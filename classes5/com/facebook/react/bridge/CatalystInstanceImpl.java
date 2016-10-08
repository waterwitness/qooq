package com.facebook.react.bridge;

import android.util.Log;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.queue.CatalystQueueConfiguration;
import com.facebook.react.bridge.queue.CatalystQueueConfigurationImpl;
import com.facebook.react.bridge.queue.CatalystQueueConfigurationSpec;
import com.facebook.react.bridge.queue.QueueThreadExceptionHandler;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.systrace.Systrace;
import com.facebook.systrace.TraceListener;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.tencent.bitapp.pre.PreConst;
import com.tencent.bitapp.pre.binder.MessageQueueThread;
import com.tencent.bitapp.pre.binder.client.IJava2jniClient;
import com.tencent.bitapp.pre.binder.client.Java2jniClientFactory;
import com.tencent.bitapp.pre.binder.client.ReactCallbackService;
import com.tencent.bitapp.pre.binder.server.proxy.jni.JavaScriptExecutor;
import com.tencent.bitapp.pre.binder.server.proxy.jni.ReadableNativeArray;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

@DoNotStrip
public class CatalystInstanceImpl
  implements CatalystInstance
{
  private static final int BRIDGE_SETUP_TIMEOUT_MS = 300000;
  private static final int LOAD_JS_BUNDLE_TIMEOUT_MS = 300000;
  private static final AtomicInteger sNextInstanceIdForTrace = new AtomicInteger(1);
  private final CopyOnWriteArrayList<NotThreadSafeBridgeIdleDebugListener> mBridgeIdleListeners = new CopyOnWriteArrayList();
  private final CatalystQueueConfigurationImpl mCatalystQueueConfiguration = CatalystQueueConfigurationImpl.create(paramCatalystQueueConfigurationSpec, new NativeExceptionHandler());
  private volatile boolean mDestroyed = false;
  private boolean mInitialized = false;
  private boolean mJSBundleHasLoaded;
  private final JSBundleLoader mJSBundleLoader;
  private final JavaScriptModuleRegistry mJSModuleRegistry;
  private final NativeModuleRegistry mJavaRegistry;
  private final String mJsPendingCallsTitleForTrace = "pending_js_calls_instance" + sNextInstanceIdForTrace.getAndIncrement();
  private NativeModuleCallExceptionHandler mNativeModuleCallExceptionHandler;
  private NativeModulesReactCallback mNativeModulesReactCallback;
  private final AtomicInteger mPendingJSCalls = new AtomicInteger(0);
  private final TraceListener mTraceListener;
  
  private CatalystInstanceImpl(final CatalystQueueConfigurationSpec paramCatalystQueueConfigurationSpec, final JavaScriptExecutor paramJavaScriptExecutor, NativeModuleRegistry paramNativeModuleRegistry, final JavaScriptModulesConfig paramJavaScriptModulesConfig, JSBundleLoader paramJSBundleLoader, NativeModuleCallExceptionHandler paramNativeModuleCallExceptionHandler)
  {
    this.mJavaRegistry = paramNativeModuleRegistry;
    this.mJSModuleRegistry = new JavaScriptModuleRegistry(this, paramJavaScriptModulesConfig);
    this.mJSBundleLoader = paramJSBundleLoader;
    this.mNativeModuleCallExceptionHandler = paramNativeModuleCallExceptionHandler;
    this.mTraceListener = new JSProfilerTraceListener(null);
    paramCatalystQueueConfigurationSpec = new CountDownLatch(1);
    this.mCatalystQueueConfiguration.getJSQueueThread().runOnQueue(new Runnable()
    {
      public void run()
      {
        Systrace.beginSection(0L, "initializeBridge");
        try
        {
          CatalystInstanceImpl.this.initializeBridge(paramJavaScriptExecutor, paramJavaScriptModulesConfig);
          paramCatalystQueueConfigurationSpec.countDown();
          return;
        }
        finally
        {
          Systrace.endSection(0L);
        }
      }
    });
    try
    {
      if ((!paramCatalystQueueConfigurationSpec.await(300000L, TimeUnit.MILLISECONDS)) && (FLog.isLoggable(6))) {
        FLog.e("Exception", "Timed out waiting for bridge to initialize!");
      }
      return;
    }
    catch (InterruptedException paramCatalystQueueConfigurationSpec)
    {
      throw new RuntimeException(paramCatalystQueueConfigurationSpec);
    }
  }
  
  private String buildModulesConfigJSONProperty(NativeModuleRegistry paramNativeModuleRegistry, JavaScriptModulesConfig paramJavaScriptModulesConfig)
  {
    if ((PreConst.isTestPerformance) && (FLog.isLoggable(6))) {
      FLog.e("bitapp_performance", "buildModulesConfigJSONProperty begin");
    }
    Object localObject = new JsonFactory();
    StringWriter localStringWriter = new StringWriter();
    try
    {
      localObject = ((JsonFactory)localObject).createGenerator(localStringWriter);
      ((JsonGenerator)localObject).writeStartObject();
      ((JsonGenerator)localObject).writeFieldName("remoteModuleConfig");
      paramNativeModuleRegistry.writeModuleDescriptions((JsonGenerator)localObject);
      ((JsonGenerator)localObject).writeFieldName("localModulesConfig");
      paramJavaScriptModulesConfig.writeModuleDescriptions((JsonGenerator)localObject);
      ((JsonGenerator)localObject).writeEndObject();
      ((JsonGenerator)localObject).close();
      paramNativeModuleRegistry = localStringWriter.getBuffer().toString();
      if ((PreConst.isTestPerformance) && (FLog.isLoggable(6))) {
        FLog.e("bitapp_performance", "buildModulesConfigJSONProperty end: " + paramNativeModuleRegistry);
      }
      return paramNativeModuleRegistry;
    }
    catch (IOException paramNativeModuleRegistry)
    {
      throw new RuntimeException("Unable to serialize JavaScript module declaration", paramNativeModuleRegistry);
    }
  }
  
  private void decrementPendingJSCalls()
  {
    int j = this.mPendingJSCalls.decrementAndGet();
    if (j < 0) {
      return;
    }
    if (j == 0) {}
    for (int i = 1;; i = 0)
    {
      Systrace.traceCounter(0L, this.mJsPendingCallsTitleForTrace, j);
      if ((i == 0) || (this.mBridgeIdleListeners.isEmpty())) {
        break;
      }
      Iterator localIterator = this.mBridgeIdleListeners.iterator();
      while (localIterator.hasNext()) {
        ((NotThreadSafeBridgeIdleDebugListener)localIterator.next()).onTransitionToBridgeIdle();
      }
      break;
    }
  }
  
  private void incrementPendingJSCalls()
  {
    int j = this.mPendingJSCalls.getAndIncrement();
    if (j == 0) {}
    for (int i = 1;; i = 0)
    {
      Systrace.traceCounter(0L, this.mJsPendingCallsTitleForTrace, j + 1);
      if ((i == 0) || (this.mBridgeIdleListeners.isEmpty())) {
        break;
      }
      Iterator localIterator = this.mBridgeIdleListeners.iterator();
      while (localIterator.hasNext()) {
        ((NotThreadSafeBridgeIdleDebugListener)localIterator.next()).onTransitionToBridgeBusy();
      }
    }
  }
  
  /* Error */
  private void initializeBridge(JavaScriptExecutor paramJavaScriptExecutor, JavaScriptModulesConfig paramJavaScriptModulesConfig)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 118	com/facebook/react/bridge/CatalystInstanceImpl:mCatalystQueueConfiguration	Lcom/facebook/react/bridge/queue/CatalystQueueConfigurationImpl;
    //   4: invokevirtual 148	com/facebook/react/bridge/queue/CatalystQueueConfigurationImpl:getJSQueueThread	()Lcom/tencent/bitapp/pre/binder/MessageQueueThread;
    //   7: invokeinterface 324 1 0
    //   12: lconst_0
    //   13: ldc_w 326
    //   16: invokestatic 330	com/facebook/systrace/Systrace:beginSection	(JLjava/lang/String;)V
    //   19: aload_0
    //   20: new 31	com/facebook/react/bridge/CatalystInstanceImpl$NativeModulesReactCallback
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 331	com/facebook/react/bridge/CatalystInstanceImpl$NativeModulesReactCallback:<init>	(Lcom/facebook/react/bridge/CatalystInstanceImpl;)V
    //   28: putfield 333	com/facebook/react/bridge/CatalystInstanceImpl:mNativeModulesReactCallback	Lcom/facebook/react/bridge/CatalystInstanceImpl$NativeModulesReactCallback;
    //   31: lconst_0
    //   32: invokestatic 337	com/facebook/systrace/Systrace:endSection	(J)V
    //   35: lconst_0
    //   36: ldc_w 339
    //   39: invokestatic 330	com/facebook/systrace/Systrace:beginSection	(JLjava/lang/String;)V
    //   42: invokestatic 345	com/tencent/bitapp/pre/binder/client/Java2jniClientFactory:getJava2jniClient	()Lcom/tencent/bitapp/pre/binder/client/IJava2jniClient;
    //   45: aload_0
    //   46: aload_1
    //   47: invokeinterface 351 3 0
    //   52: invokestatic 345	com/tencent/bitapp/pre/binder/client/Java2jniClientFactory:getJava2jniClient	()Lcom/tencent/bitapp/pre/binder/client/IJava2jniClient;
    //   55: ldc_w 353
    //   58: aload_0
    //   59: aload_0
    //   60: getfield 125	com/facebook/react/bridge/CatalystInstanceImpl:mJavaRegistry	Lcom/facebook/react/bridge/NativeModuleRegistry;
    //   63: aload_2
    //   64: invokespecial 355	com/facebook/react/bridge/CatalystInstanceImpl:buildModulesConfigJSONProperty	(Lcom/facebook/react/bridge/NativeModuleRegistry;Lcom/facebook/react/bridge/JavaScriptModulesConfig;)Ljava/lang/String;
    //   67: invokeinterface 358 3 0
    //   72: invokestatic 345	com/tencent/bitapp/pre/binder/client/Java2jniClientFactory:getJava2jniClient	()Lcom/tencent/bitapp/pre/binder/client/IJava2jniClient;
    //   75: astore_2
    //   76: lconst_0
    //   77: invokestatic 362	com/facebook/systrace/Systrace:isTracing	(J)Z
    //   80: ifeq +29 -> 109
    //   83: ldc_w 364
    //   86: astore_1
    //   87: aload_2
    //   88: ldc_w 366
    //   91: aload_1
    //   92: invokeinterface 358 3 0
    //   97: lconst_0
    //   98: invokestatic 337	com/facebook/systrace/Systrace:endSection	(J)V
    //   101: return
    //   102: astore_1
    //   103: lconst_0
    //   104: invokestatic 337	com/facebook/systrace/Systrace:endSection	(J)V
    //   107: aload_1
    //   108: athrow
    //   109: ldc_w 368
    //   112: astore_1
    //   113: goto -26 -> 87
    //   116: astore_1
    //   117: lconst_0
    //   118: invokestatic 337	com/facebook/systrace/Systrace:endSection	(J)V
    //   121: aload_1
    //   122: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	CatalystInstanceImpl
    //   0	123	1	paramJavaScriptExecutor	JavaScriptExecutor
    //   0	123	2	paramJavaScriptModulesConfig	JavaScriptModulesConfig
    // Exception table:
    //   from	to	target	type
    //   19	31	102	finally
    //   42	83	116	finally
    //   87	97	116	finally
  }
  
  public void addBridgeIdleDebugListener(NotThreadSafeBridgeIdleDebugListener paramNotThreadSafeBridgeIdleDebugListener)
  {
    this.mBridgeIdleListeners.add(paramNotThreadSafeBridgeIdleDebugListener);
  }
  
  void callFunction(final int paramInt1, final int paramInt2, final Object[] paramArrayOfObject, final String paramString)
  {
    if (this.mDestroyed)
    {
      if (FLog.isLoggable(5)) {
        FLog.w("React", "Calling JS function after bridge has been destroyed.");
      }
      return;
    }
    incrementPendingJSCalls();
    this.mCatalystQueueConfiguration.getJSQueueThread().runOnQueue(new Runnable()
    {
      public void run()
      {
        CatalystInstanceImpl.this.mCatalystQueueConfiguration.getJSQueueThread().assertIsOnThread();
        if (CatalystInstanceImpl.this.mDestroyed) {
          return;
        }
        Systrace.beginSection(0L, paramString);
        try
        {
          Java2jniClientFactory.getJava2jniClient().reactBridgeCallfunction(paramInt1, paramInt2, paramArrayOfObject, paramString);
          return;
        }
        finally
        {
          Systrace.endSection(0L);
        }
      }
    });
  }
  
  public void destroy()
  {
    int i = 1;
    UiThreadUtil.assertOnUiThread();
    if (this.mDestroyed)
    {
      if (FLog.isLoggable(6)) {
        FLog.e("React", "CatalystInstance destroy mDestroyed: " + this.mDestroyed);
      }
      return;
    }
    this.mDestroyed = true;
    this.mJavaRegistry.notifyCatalystInstanceDestroy();
    this.mCatalystQueueConfiguration.destroy();
    if (this.mPendingJSCalls.getAndSet(0) == 0) {}
    while ((i == 0) && (!this.mBridgeIdleListeners.isEmpty()))
    {
      Iterator localIterator = this.mBridgeIdleListeners.iterator();
      while (localIterator.hasNext()) {
        ((NotThreadSafeBridgeIdleDebugListener)localIterator.next()).onTransitionToBridgeIdle();
      }
      i = 0;
    }
    Systrace.unregisterListener(this.mTraceListener);
    Java2jniClientFactory.getJava2jniClient().reactBridgeDestory();
  }
  
  public void executeJSScript(final String paramString)
  {
    try
    {
      final CountDownLatch localCountDownLatch = new CountDownLatch(1);
      this.mCatalystQueueConfiguration.getJSQueueThread().runOnQueue(new Runnable()
      {
        public void run()
        {
          CatalystInstanceImpl.this.incrementPendingJSCalls();
          try
          {
            Java2jniClientFactory.getJava2jniClient().reactBridgeExecuteJSScript(paramString);
            localCountDownLatch.countDown();
            return;
          }
          catch (JSExecutionException localJSExecutionException)
          {
            for (;;) {}
          }
        }
      });
      if (!localCountDownLatch.await(300000L, TimeUnit.MILLISECONDS)) {
        Log.e("Exception e", "Timed out executing JS script!");
      }
      return;
    }
    catch (Exception paramString)
    {
      throw new RuntimeException(paramString);
    }
  }
  
  public CatalystQueueConfiguration getCatalystQueueConfiguration()
  {
    return this.mCatalystQueueConfiguration;
  }
  
  public JSBundleLoader getJSBundleLoader()
  {
    return this.mJSBundleLoader;
  }
  
  public <T extends JavaScriptModule> T getJSModule(Class<T> paramClass)
  {
    return ((JavaScriptModuleRegistry)Assertions.assertNotNull(this.mJSModuleRegistry)).getJavaScriptModule(paramClass);
  }
  
  public <T extends NativeModule> T getNativeModule(Class<T> paramClass)
  {
    return this.mJavaRegistry.getModule(paramClass);
  }
  
  public Collection<NativeModule> getNativeModules()
  {
    return this.mJavaRegistry.getAllModules();
  }
  
  public NativeModulesReactCallback getNativeModulesReactCallback()
  {
    return this.mNativeModulesReactCallback;
  }
  
  public void handleMemoryPressure(MemoryPressure paramMemoryPressure)
  {
    Java2jniClientFactory.getJava2jniClient().reactBridgeHandleMemoryPressure(paramMemoryPressure);
  }
  
  @VisibleForTesting
  public void initialize()
  {
    UiThreadUtil.assertOnUiThread();
    this.mInitialized = true;
    this.mJavaRegistry.notifyCatalystInstanceInitialized();
  }
  
  @DoNotStrip
  public void invokeCallback(final int paramInt, final Object[] paramArrayOfObject)
  {
    if (this.mDestroyed)
    {
      if (FLog.isLoggable(5)) {
        FLog.w("React", "Invoking JS callback after bridge has been destroyed.");
      }
      return;
    }
    incrementPendingJSCalls();
    this.mCatalystQueueConfiguration.getJSQueueThread().runOnQueue(new Runnable()
    {
      public void run()
      {
        CatalystInstanceImpl.this.mCatalystQueueConfiguration.getJSQueueThread().assertIsOnThread();
        if (CatalystInstanceImpl.this.mDestroyed) {
          return;
        }
        Systrace.beginSection(0L, "<callback>");
        try
        {
          Java2jniClientFactory.getJava2jniClient().reactBridgeInvokeCallback(paramInt, paramArrayOfObject);
          return;
        }
        finally
        {
          Systrace.endSection(0L);
        }
      }
    });
  }
  
  public boolean isDestroyed()
  {
    return this.mDestroyed;
  }
  
  public void loadBundle(final String paramString, final String[] paramArrayOfString)
  {
    try
    {
      final CountDownLatch localCountDownLatch = new CountDownLatch(1);
      this.mCatalystQueueConfiguration.getJSQueueThread().runOnQueue(new Runnable()
      {
        public void run()
        {
          CatalystInstanceImpl.this.incrementPendingJSCalls();
          Java2jniClientFactory.getJava2jniClient().reactBridgeLoadScriptFromFile(paramArrayOfString, paramString);
          localCountDownLatch.countDown();
        }
      });
      if ((!localCountDownLatch.await(300000L, TimeUnit.MILLISECONDS)) && (FLog.isLoggable(6))) {
        FLog.e("Exception", "Timed out loading JS!");
      }
      return;
    }
    catch (Exception paramString)
    {
      throw new RuntimeException(paramString);
    }
  }
  
  public void removeBridgeIdleDebugListener(NotThreadSafeBridgeIdleDebugListener paramNotThreadSafeBridgeIdleDebugListener)
  {
    this.mBridgeIdleListeners.remove(paramNotThreadSafeBridgeIdleDebugListener);
  }
  
  public void runJSBundle()
  {
    do
    {
      try
      {
        if ((PreConst.isTestPerformance) && (FLog.isLoggable(6))) {
          FLog.e("bitapp_performance", "runJSBundle begin");
        }
        final CountDownLatch localCountDownLatch = new CountDownLatch(1);
        this.mCatalystQueueConfiguration.getJSQueueThread().runOnQueue(new Runnable()
        {
          public void run()
          {
            if (CatalystInstanceImpl.this.mJSBundleHasLoaded)
            {
              if (FLog.isLoggable(6)) {
                FLog.e("Exception", "JS bundle was already loaded!");
              }
              return;
            }
            CatalystInstanceImpl.access$202(CatalystInstanceImpl.this, true);
            CatalystInstanceImpl.this.incrementPendingJSCalls();
            Systrace.beginSection(0L, "loadJSScript");
            try
            {
              CatalystInstanceImpl.this.mJSBundleLoader.loadScript();
              Systrace.registerListener(CatalystInstanceImpl.this.mTraceListener);
            }
            catch (JSExecutionException localJSExecutionException)
            {
              if (CatalystInstanceImpl.this.mNativeModuleCallExceptionHandler == null) {
                break label111;
              }
              CatalystInstanceImpl.this.mNativeModuleCallExceptionHandler.handleException(localJSExecutionException);
              for (;;)
              {
                Systrace.endSection(0L);
                break;
                if (FLog.isLoggable(3)) {
                  FLog.d("React", "runJSBundle mNativeModuleCallExceptionHandler is null");
                }
              }
            }
            finally
            {
              Systrace.endSection(0L);
            }
            localCountDownLatch.countDown();
          }
        });
        if (!localCountDownLatch.await(300000L, TimeUnit.MILLISECONDS))
        {
          if (FLog.isLoggable(6)) {
            FLog.e("Exception", "Timed out loading JS!");
          }
          return;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        throw new RuntimeException(localInterruptedException);
      }
    } while ((!PreConst.isTestPerformance) || (!FLog.isLoggable(6)));
    FLog.e("bitapp_performance", "runJSBundle end");
  }
  
  public void setNativeModuleCallExceptionHandler(NativeModuleCallExceptionHandler paramNativeModuleCallExceptionHandler)
  {
    this.mNativeModuleCallExceptionHandler = paramNativeModuleCallExceptionHandler;
  }
  
  public void startProfiler(String paramString) {}
  
  public void stopProfiler(String paramString1, String paramString2) {}
  
  public boolean supportsProfiling()
  {
    return false;
  }
  
  public static class Builder
  {
    @Nullable
    private CatalystQueueConfigurationSpec mCatalystQueueConfigurationSpec;
    @Nullable
    private JSBundleLoader mJSBundleLoader;
    @Nullable
    private JavaScriptExecutor mJSExecutor;
    @Nullable
    private JavaScriptModulesConfig mJSModulesConfig;
    @Nullable
    private NativeModuleCallExceptionHandler mNativeModuleCallExceptionHandler;
    @Nullable
    private NativeModuleRegistry mRegistry;
    
    public CatalystInstanceImpl build()
    {
      return new CatalystInstanceImpl((CatalystQueueConfigurationSpec)Assertions.assertNotNull(this.mCatalystQueueConfigurationSpec), this.mJSExecutor, (NativeModuleRegistry)Assertions.assertNotNull(this.mRegistry), (JavaScriptModulesConfig)Assertions.assertNotNull(this.mJSModulesConfig), (JSBundleLoader)Assertions.assertNotNull(this.mJSBundleLoader), this.mNativeModuleCallExceptionHandler, null);
    }
    
    public Builder setCatalystQueueConfigurationSpec(CatalystQueueConfigurationSpec paramCatalystQueueConfigurationSpec)
    {
      this.mCatalystQueueConfigurationSpec = paramCatalystQueueConfigurationSpec;
      return this;
    }
    
    public Builder setJSBundleLoader(JSBundleLoader paramJSBundleLoader)
    {
      this.mJSBundleLoader = paramJSBundleLoader;
      return this;
    }
    
    public Builder setJSExecutor(JavaScriptExecutor paramJavaScriptExecutor)
    {
      this.mJSExecutor = paramJavaScriptExecutor;
      return this;
    }
    
    public Builder setJSModulesConfig(JavaScriptModulesConfig paramJavaScriptModulesConfig)
    {
      this.mJSModulesConfig = paramJavaScriptModulesConfig;
      return this;
    }
    
    public Builder setNativeModuleCallExceptionHandler(NativeModuleCallExceptionHandler paramNativeModuleCallExceptionHandler)
    {
      this.mNativeModuleCallExceptionHandler = paramNativeModuleCallExceptionHandler;
      return this;
    }
    
    public Builder setRegistry(NativeModuleRegistry paramNativeModuleRegistry)
    {
      this.mRegistry = paramNativeModuleRegistry;
      return this;
    }
  }
  
  private class JSProfilerTraceListener
    implements TraceListener
  {
    private JSProfilerTraceListener() {}
    
    public void onTraceStarted()
    {
      ((BridgeProfiling)CatalystInstanceImpl.this.getJSModule(BridgeProfiling.class)).setEnabled(true);
    }
    
    public void onTraceStopped()
    {
      ((BridgeProfiling)CatalystInstanceImpl.this.getJSModule(BridgeProfiling.class)).setEnabled(false);
    }
  }
  
  class NativeExceptionHandler
    implements QueueThreadExceptionHandler
  {
    NativeExceptionHandler() {}
    
    public void handleException(Exception paramException)
    {
      if ((paramException != null) && (FLog.isLoggable(6))) {
        FLog.e("React", "handleException: " + paramException.getMessage());
      }
      paramException.printStackTrace();
      if (CatalystInstanceImpl.this.mNativeModuleCallExceptionHandler != null) {
        CatalystInstanceImpl.this.mNativeModuleCallExceptionHandler.handleException(paramException);
      }
      for (;;)
      {
        CatalystInstanceImpl.this.mCatalystQueueConfiguration.getUIQueueThread().runOnQueue(new Runnable()
        {
          public void run()
          {
            CatalystInstanceImpl.this.destroy();
          }
        });
        return;
        if (FLog.isLoggable(3)) {
          FLog.d("React", "handleException mNativeModuleCallExceptionHandler is null");
        }
      }
    }
  }
  
  public static class NativeModulesReactCallback
    implements ReactCallbackService
  {
    private WeakReference<CatalystInstanceImpl> mReference;
    
    public NativeModulesReactCallback(CatalystInstanceImpl paramCatalystInstanceImpl)
    {
      this.mReference = new WeakReference(paramCatalystInstanceImpl);
    }
    
    public void call(int paramInt1, int paramInt2, ReadableNativeArray paramReadableNativeArray)
    {
      CatalystInstanceImpl localCatalystInstanceImpl = (CatalystInstanceImpl)this.mReference.get();
      if (localCatalystInstanceImpl == null) {}
      do
      {
        return;
        localCatalystInstanceImpl.mCatalystQueueConfiguration.getNativeModulesQueueThread().assertIsOnThread();
      } while (localCatalystInstanceImpl.mDestroyed);
      localCatalystInstanceImpl.mJavaRegistry.call(localCatalystInstanceImpl, paramInt1, paramInt2, paramReadableNativeArray);
    }
    
    public void onBatchComplete()
    {
      CatalystInstanceImpl localCatalystInstanceImpl = (CatalystInstanceImpl)this.mReference.get();
      if (localCatalystInstanceImpl == null) {
        return;
      }
      localCatalystInstanceImpl.mCatalystQueueConfiguration.getNativeModulesQueueThread().assertIsOnThread();
      if (!localCatalystInstanceImpl.mDestroyed) {
        Systrace.beginSection(0L, "onBatchComplete");
      }
      try
      {
        localCatalystInstanceImpl.mJavaRegistry.onBatchComplete();
        Systrace.endSection(0L);
        localCatalystInstanceImpl.decrementPendingJSCalls();
        return;
      }
      finally
      {
        Systrace.endSection(0L);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\bridge\CatalystInstanceImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */