package com.facebook.react;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.JSBundleLoader;
import com.facebook.react.bridge.JavaJSExecutor;
import com.facebook.react.bridge.JavaScriptModulesConfig.Builder;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.NativeModuleRegistry.Builder;
import com.facebook.react.bridge.NotThreadSafeBridgeIdleDebugListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.devsupport.DevSupportManager;
import com.facebook.react.devsupport.ReactInstanceDevCommandsHandler;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.facebook.react.uimanager.AppRegistry;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.UIImplementation;
import com.facebook.react.uimanager.UIImplementationProvider;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.soloader.SoLoader;
import com.facebook.systrace.Systrace;
import com.tencent.bitapp.pre.PreConst;
import com.tencent.bitapp.pre.binder.server.proxy.jni.JavaScriptExecutor;
import com.tencent.bitapp.pre.binder.server.proxy.jni.WritableNativeMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.annotation.Nullable;

public class ReactInstanceManagerImpl
  extends ReactInstanceManager
{
  private final Context mApplicationContext;
  private final HashMap<Integer, ReactRootView> mAttachedRootViews = new HashMap();
  private final DefaultHardwareBackBtnHandler mBackBtnHandler = new DefaultHardwareBackBtnHandler()
  {
    public void invokeDefaultOnBackPressed()
    {
      ReactInstanceManagerImpl.this.invokeDefaultOnBackPressed();
    }
  };
  @Nullable
  private final NotThreadSafeBridgeIdleDebugListener mBridgeIdleDebugListener;
  @Nullable
  private volatile ReactContext mCurrentReactContext;
  @Nullable
  private DefaultHardwareBackBtnHandler mDefaultBackButtonImpl;
  private final ReactInstanceDevCommandsHandler mDevInterface = new ReactInstanceDevCommandsHandler()
  {
    public void onJSBundleLoadedFromServer()
    {
      ReactInstanceManagerImpl.this.onJSBundleLoadedFromServer();
    }
    
    public void onReloadWithJSDebugger(JavaJSExecutor paramAnonymousJavaJSExecutor)
    {
      ReactInstanceManagerImpl.this.onReloadWithJSDebugger(paramAnonymousJavaJSExecutor);
    }
    
    public void toggleElementInspector()
    {
      ReactInstanceManagerImpl.this.toggleElementInspector();
    }
  };
  private final DevSupportManager mDevSupportManager;
  private volatile boolean mHasStartedCreatingInitialContext = false;
  private boolean mIsContextInitAsyncTaskRunning;
  public boolean mIsScrollIdle = true;
  private LifecycleState mLifecycleState;
  private final MemoryPressureRouter mMemoryPressureRouter;
  private boolean mNeedAttachView = true;
  private final List<ReactPackage> mPackages;
  @Nullable
  private ReactContextInitParams mPendingReactContextInitParams;
  private final Collection<ReactInstanceManager.ReactInstanceEventListener> mReactInstanceEventListeners = new ConcurrentLinkedQueue();
  private String mSourceUrl;
  private final UIImplementationProvider mUIImplementationProvider;
  private final boolean mUseDeveloperSupport;
  
  protected ReactInstanceManagerImpl(Context paramContext, @Nullable String paramString1, @Nullable String paramString2, List<ReactPackage> paramList, boolean paramBoolean, @Nullable NotThreadSafeBridgeIdleDebugListener paramNotThreadSafeBridgeIdleDebugListener, LifecycleState paramLifecycleState, UIImplementationProvider paramUIImplementationProvider)
  {
    initializeSoLoaderIfNecessary(paramContext);
    SoLoader.loadLibrary("memchunk");
    this.mApplicationContext = paramContext;
    this.mPackages = paramList;
    this.mUseDeveloperSupport = paramBoolean;
    if (this.mUseDeveloperSupport) {}
    for (this.mDevSupportManager = DevSupportManager.createDevSupportManager(paramContext, this.mDevInterface, paramBoolean);; this.mDevSupportManager = null)
    {
      this.mBridgeIdleDebugListener = paramNotThreadSafeBridgeIdleDebugListener;
      this.mLifecycleState = paramLifecycleState;
      this.mUIImplementationProvider = paramUIImplementationProvider;
      this.mMemoryPressureRouter = new MemoryPressureRouter(paramContext);
      return;
    }
  }
  
  private void attachMeasuredRootViewToInstance(ReactRootView paramReactRootView, CatalystInstance paramCatalystInstance)
  {
    UiThreadUtil.assertOnUiThread();
    paramReactRootView.removeAllViews();
    paramReactRootView.setId(-1);
    int i = ((UIManagerModule)paramCatalystInstance.getNativeModule(UIManagerModule.class)).addMeasuredRootView(paramReactRootView);
    Bundle localBundle = paramReactRootView.getLaunchOptions();
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (localBundle != null) {}
    try
    {
      localObject1 = Arguments.fromBundle2Map(localBundle);
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = Arguments.createMap();
      }
      paramReactRootView = paramReactRootView.getJSModuleName();
      localObject1 = new WritableNativeMap();
      ((WritableNativeMap)localObject1).putDouble("rootTag", i);
      ((WritableNativeMap)localObject1).putMap("initialProps", (WritableMap)localObject3);
      if ((PreConst.isTestPerformance) && (FLog.isLoggable(6))) {
        FLog.e("bitapp_performance", "Begin runApplication");
      }
      ((AppRegistry)paramCatalystInstance.getJSModule(AppRegistry.class)).runApplication(paramReactRootView, (WritableMap)localObject1);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        Object localObject2 = localObject3;
      }
    }
  }
  
  /* Error */
  private ReactApplicationContext createReactContext(JavaScriptExecutor paramJavaScriptExecutor, JSBundleLoader paramJSBundleLoader)
  {
    // Byte code:
    //   0: iconst_4
    //   1: invokestatic 238	com/facebook/common/logging/FLog:isLoggable	(I)Z
    //   4: ifeq +12 -> 16
    //   7: ldc_w 260
    //   10: ldc_w 262
    //   13: invokestatic 265	com/facebook/common/logging/FLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: aload_0
    //   17: aload_2
    //   18: invokevirtual 270	com/facebook/react/bridge/JSBundleLoader:getSourceUrl	()Ljava/lang/String;
    //   21: putfield 272	com/facebook/react/ReactInstanceManagerImpl:mSourceUrl	Ljava/lang/String;
    //   24: new 274	com/facebook/react/bridge/NativeModuleRegistry$Builder
    //   27: dup
    //   28: invokespecial 275	com/facebook/react/bridge/NativeModuleRegistry$Builder:<init>	()V
    //   31: astore 5
    //   33: new 277	com/facebook/react/bridge/JavaScriptModulesConfig$Builder
    //   36: dup
    //   37: invokespecial 278	com/facebook/react/bridge/JavaScriptModulesConfig$Builder:<init>	()V
    //   40: astore 4
    //   42: new 280	com/facebook/react/bridge/ReactApplicationContext
    //   45: dup
    //   46: aload_0
    //   47: getfield 96	com/facebook/react/ReactInstanceManagerImpl:mApplicationContext	Landroid/content/Context;
    //   50: invokespecial 281	com/facebook/react/bridge/ReactApplicationContext:<init>	(Landroid/content/Context;)V
    //   53: astore_3
    //   54: aload_0
    //   55: getfield 100	com/facebook/react/ReactInstanceManagerImpl:mUseDeveloperSupport	Z
    //   58: ifeq +18 -> 76
    //   61: aload_0
    //   62: getfield 108	com/facebook/react/ReactInstanceManagerImpl:mDevSupportManager	Lcom/facebook/react/devsupport/DevSupportManager;
    //   65: ifnull +11 -> 76
    //   68: aload_3
    //   69: aload_0
    //   70: getfield 108	com/facebook/react/ReactInstanceManagerImpl:mDevSupportManager	Lcom/facebook/react/devsupport/DevSupportManager;
    //   73: invokevirtual 285	com/facebook/react/bridge/ReactApplicationContext:setNativeModuleCallExceptionHandler	(Lcom/facebook/react/bridge/NativeModuleCallExceptionHandler;)V
    //   76: lconst_0
    //   77: ldc_w 287
    //   80: invokestatic 293	com/facebook/systrace/Systrace:beginSection	(JLjava/lang/String;)V
    //   83: aload_0
    //   84: new 295	com/facebook/react/CoreModulesPackage
    //   87: dup
    //   88: aload_0
    //   89: aload_0
    //   90: getfield 82	com/facebook/react/ReactInstanceManagerImpl:mBackBtnHandler	Lcom/facebook/react/modules/core/DefaultHardwareBackBtnHandler;
    //   93: aload_0
    //   94: getfield 114	com/facebook/react/ReactInstanceManagerImpl:mUIImplementationProvider	Lcom/facebook/react/uimanager/UIImplementationProvider;
    //   97: invokespecial 298	com/facebook/react/CoreModulesPackage:<init>	(Lcom/facebook/react/ReactInstanceManager;Lcom/facebook/react/modules/core/DefaultHardwareBackBtnHandler;Lcom/facebook/react/uimanager/UIImplementationProvider;)V
    //   100: aload_3
    //   101: aload 5
    //   103: aload 4
    //   105: invokespecial 302	com/facebook/react/ReactInstanceManagerImpl:processPackage	(Lcom/facebook/react/ReactPackage;Lcom/facebook/react/bridge/ReactApplicationContext;Lcom/facebook/react/bridge/NativeModuleRegistry$Builder;Lcom/facebook/react/bridge/JavaScriptModulesConfig$Builder;)V
    //   108: lconst_0
    //   109: invokestatic 306	com/facebook/systrace/Systrace:endSection	(J)V
    //   112: aload_0
    //   113: getfield 98	com/facebook/react/ReactInstanceManagerImpl:mPackages	Ljava/util/List;
    //   116: invokeinterface 312 1 0
    //   121: astore 6
    //   123: aload 6
    //   125: invokeinterface 318 1 0
    //   130: ifeq +54 -> 184
    //   133: aload 6
    //   135: invokeinterface 322 1 0
    //   140: checkcast 324	com/facebook/react/ReactPackage
    //   143: astore 7
    //   145: lconst_0
    //   146: ldc_w 326
    //   149: invokestatic 293	com/facebook/systrace/Systrace:beginSection	(JLjava/lang/String;)V
    //   152: aload_0
    //   153: aload 7
    //   155: aload_3
    //   156: aload 5
    //   158: aload 4
    //   160: invokespecial 302	com/facebook/react/ReactInstanceManagerImpl:processPackage	(Lcom/facebook/react/ReactPackage;Lcom/facebook/react/bridge/ReactApplicationContext;Lcom/facebook/react/bridge/NativeModuleRegistry$Builder;Lcom/facebook/react/bridge/JavaScriptModulesConfig$Builder;)V
    //   163: lconst_0
    //   164: invokestatic 306	com/facebook/systrace/Systrace:endSection	(J)V
    //   167: goto -44 -> 123
    //   170: astore_1
    //   171: lconst_0
    //   172: invokestatic 306	com/facebook/systrace/Systrace:endSection	(J)V
    //   175: aload_1
    //   176: athrow
    //   177: astore_1
    //   178: lconst_0
    //   179: invokestatic 306	com/facebook/systrace/Systrace:endSection	(J)V
    //   182: aload_1
    //   183: athrow
    //   184: lconst_0
    //   185: ldc_w 328
    //   188: invokestatic 293	com/facebook/systrace/Systrace:beginSection	(JLjava/lang/String;)V
    //   191: aload 5
    //   193: invokevirtual 332	com/facebook/react/bridge/NativeModuleRegistry$Builder:build	()Lcom/facebook/react/bridge/NativeModuleRegistry;
    //   196: astore 5
    //   198: lconst_0
    //   199: invokestatic 306	com/facebook/systrace/Systrace:endSection	(J)V
    //   202: lconst_0
    //   203: ldc_w 334
    //   206: invokestatic 293	com/facebook/systrace/Systrace:beginSection	(JLjava/lang/String;)V
    //   209: aload 4
    //   211: invokevirtual 337	com/facebook/react/bridge/JavaScriptModulesConfig$Builder:build	()Lcom/facebook/react/bridge/JavaScriptModulesConfig;
    //   214: astore 4
    //   216: lconst_0
    //   217: invokestatic 306	com/facebook/systrace/Systrace:endSection	(J)V
    //   220: new 339	com/facebook/react/bridge/CatalystInstanceImpl$Builder
    //   223: dup
    //   224: invokespecial 340	com/facebook/react/bridge/CatalystInstanceImpl$Builder:<init>	()V
    //   227: invokestatic 346	com/facebook/react/bridge/queue/CatalystQueueConfigurationSpec:createDefault	()Lcom/facebook/react/bridge/queue/CatalystQueueConfigurationSpec;
    //   230: invokevirtual 350	com/facebook/react/bridge/CatalystInstanceImpl$Builder:setCatalystQueueConfigurationSpec	(Lcom/facebook/react/bridge/queue/CatalystQueueConfigurationSpec;)Lcom/facebook/react/bridge/CatalystInstanceImpl$Builder;
    //   233: aload_1
    //   234: invokevirtual 354	com/facebook/react/bridge/CatalystInstanceImpl$Builder:setJSExecutor	(Lcom/tencent/bitapp/pre/binder/server/proxy/jni/JavaScriptExecutor;)Lcom/facebook/react/bridge/CatalystInstanceImpl$Builder;
    //   237: aload 5
    //   239: invokevirtual 358	com/facebook/react/bridge/CatalystInstanceImpl$Builder:setRegistry	(Lcom/facebook/react/bridge/NativeModuleRegistry;)Lcom/facebook/react/bridge/CatalystInstanceImpl$Builder;
    //   242: aload 4
    //   244: invokevirtual 362	com/facebook/react/bridge/CatalystInstanceImpl$Builder:setJSModulesConfig	(Lcom/facebook/react/bridge/JavaScriptModulesConfig;)Lcom/facebook/react/bridge/CatalystInstanceImpl$Builder;
    //   247: aload_2
    //   248: invokevirtual 366	com/facebook/react/bridge/CatalystInstanceImpl$Builder:setJSBundleLoader	(Lcom/facebook/react/bridge/JSBundleLoader;)Lcom/facebook/react/bridge/CatalystInstanceImpl$Builder;
    //   251: aload_0
    //   252: getfield 108	com/facebook/react/ReactInstanceManagerImpl:mDevSupportManager	Lcom/facebook/react/devsupport/DevSupportManager;
    //   255: invokevirtual 369	com/facebook/react/bridge/CatalystInstanceImpl$Builder:setNativeModuleCallExceptionHandler	(Lcom/facebook/react/bridge/NativeModuleCallExceptionHandler;)Lcom/facebook/react/bridge/CatalystInstanceImpl$Builder;
    //   258: astore_1
    //   259: lconst_0
    //   260: ldc_w 371
    //   263: invokestatic 293	com/facebook/systrace/Systrace:beginSection	(JLjava/lang/String;)V
    //   266: aload_1
    //   267: invokevirtual 374	com/facebook/react/bridge/CatalystInstanceImpl$Builder:build	()Lcom/facebook/react/bridge/CatalystInstanceImpl;
    //   270: astore_1
    //   271: lconst_0
    //   272: invokestatic 306	com/facebook/systrace/Systrace:endSection	(J)V
    //   275: aload_0
    //   276: getfield 110	com/facebook/react/ReactInstanceManagerImpl:mBridgeIdleDebugListener	Lcom/facebook/react/bridge/NotThreadSafeBridgeIdleDebugListener;
    //   279: ifnull +13 -> 292
    //   282: aload_1
    //   283: aload_0
    //   284: getfield 110	com/facebook/react/ReactInstanceManagerImpl:mBridgeIdleDebugListener	Lcom/facebook/react/bridge/NotThreadSafeBridgeIdleDebugListener;
    //   287: invokeinterface 378 2 0
    //   292: aload_3
    //   293: aload_1
    //   294: invokevirtual 382	com/facebook/react/bridge/ReactApplicationContext:initializeWithInstance	(Lcom/facebook/react/bridge/CatalystInstance;)V
    //   297: lconst_0
    //   298: ldc_w 384
    //   301: invokestatic 293	com/facebook/systrace/Systrace:beginSection	(JLjava/lang/String;)V
    //   304: aload_1
    //   305: invokeinterface 386 1 0
    //   310: lconst_0
    //   311: invokestatic 306	com/facebook/systrace/Systrace:endSection	(J)V
    //   314: aload_3
    //   315: areturn
    //   316: astore_1
    //   317: lconst_0
    //   318: invokestatic 306	com/facebook/systrace/Systrace:endSection	(J)V
    //   321: aload_1
    //   322: athrow
    //   323: astore_1
    //   324: lconst_0
    //   325: invokestatic 306	com/facebook/systrace/Systrace:endSection	(J)V
    //   328: aload_1
    //   329: athrow
    //   330: astore_1
    //   331: lconst_0
    //   332: invokestatic 306	com/facebook/systrace/Systrace:endSection	(J)V
    //   335: aload_1
    //   336: athrow
    //   337: astore_1
    //   338: lconst_0
    //   339: invokestatic 306	com/facebook/systrace/Systrace:endSection	(J)V
    //   342: aload_1
    //   343: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	344	0	this	ReactInstanceManagerImpl
    //   0	344	1	paramJavaScriptExecutor	JavaScriptExecutor
    //   0	344	2	paramJSBundleLoader	JSBundleLoader
    //   53	262	3	localReactApplicationContext	ReactApplicationContext
    //   40	203	4	localObject1	Object
    //   31	207	5	localObject2	Object
    //   121	13	6	localIterator	Iterator
    //   143	11	7	localReactPackage	ReactPackage
    // Exception table:
    //   from	to	target	type
    //   83	108	170	finally
    //   152	163	177	finally
    //   191	198	316	finally
    //   209	216	323	finally
    //   266	271	330	finally
    //   304	310	337	finally
  }
  
  private void detachViewFromInstance(ReactRootView paramReactRootView, CatalystInstance paramCatalystInstance)
  {
    UiThreadUtil.assertOnUiThread();
    ((AppRegistry)paramCatalystInstance.getJSModule(AppRegistry.class)).unmountApplicationComponentAtRootTag(paramReactRootView.getId());
  }
  
  private void invokeDefaultOnBackPressed()
  {
    
    if (this.mDefaultBackButtonImpl != null) {
      this.mDefaultBackButtonImpl.invokeDefaultOnBackPressed();
    }
  }
  
  private void moveReactContextToCurrentLifecycleState(ReactApplicationContext paramReactApplicationContext)
  {
    if (this.mLifecycleState == LifecycleState.RESUMED) {
      paramReactApplicationContext.onResume();
    }
  }
  
  private void onJSBundleLoadedFromServer()
  {
    if ((this.mUseDeveloperSupport) && (this.mDevSupportManager != null)) {
      recreateReactContextInBackground(this.mDevSupportManager.getJavaScriptExecutor(), JSBundleLoader.createCachedBundleFromNetworkLoader(this.mDevSupportManager.getSourceUrl(), this.mDevSupportManager.getDownloadedJSBundleFile()));
    }
  }
  
  private void onReloadWithJSDebugger(JavaJSExecutor paramJavaJSExecutor)
  {
    if ((this.mUseDeveloperSupport) && (this.mDevSupportManager != null)) {
      recreateReactContextInBackground(this.mDevSupportManager.getJavaScriptExecutor(paramJavaJSExecutor), JSBundleLoader.createRemoteDebuggerBundleLoader(this.mDevSupportManager.getJSBundleURLForRemoteDebugging()));
    }
  }
  
  private void processPackage(ReactPackage paramReactPackage, ReactApplicationContext paramReactApplicationContext, NativeModuleRegistry.Builder paramBuilder, JavaScriptModulesConfig.Builder paramBuilder1)
  {
    paramReactApplicationContext = paramReactPackage.createNativeModules(paramReactApplicationContext).iterator();
    while (paramReactApplicationContext.hasNext()) {
      paramBuilder.add((NativeModule)paramReactApplicationContext.next());
    }
    paramReactPackage = paramReactPackage.createJSModules().iterator();
    while (paramReactPackage.hasNext()) {
      paramBuilder1.add((Class)paramReactPackage.next());
    }
  }
  
  private void recreateReactContextInBackgroundInner()
  {
    
    if ((this.mUseDeveloperSupport) && (this.mDevSupportManager != null)) {
      this.mDevSupportManager.recreateReactContextInBackgroundInner();
    }
  }
  
  private void toggleElementInspector()
  {
    if (this.mCurrentReactContext != null) {
      ((DeviceEventManagerModule.RCTDeviceEventEmitter)this.mCurrentReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("toggleElementInspector", null);
    }
  }
  
  public void addReactInstanceEventListener(ReactInstanceManager.ReactInstanceEventListener paramReactInstanceEventListener)
  {
    this.mReactInstanceEventListeners.add(paramReactInstanceEventListener);
  }
  
  public void attachMeasuredRootView(ReactRootView paramReactRootView)
  {
    
    if (this.mNeedAttachView) {
      if (!this.mAttachedRootViews.containsKey(Integer.valueOf(paramReactRootView.hashCode()))) {}
    }
    while ((this.mIsContextInitAsyncTaskRunning) || (this.mCurrentReactContext == null))
    {
      return;
      this.mAttachedRootViews.put(Integer.valueOf(paramReactRootView.hashCode()), paramReactRootView);
    }
    attachMeasuredRootViewToInstance(paramReactRootView, this.mCurrentReactContext.getCatalystInstance());
  }
  
  public List<ViewManager> createAllViewManagers(ReactApplicationContext paramReactApplicationContext)
  {
    Systrace.beginSection(0L, "createAllViewManagers");
    ArrayList localArrayList;
    try
    {
      localArrayList = new ArrayList();
      Iterator localIterator = this.mPackages.iterator();
      while (localIterator.hasNext()) {
        localArrayList.addAll(((ReactPackage)localIterator.next()).createViewManagers(paramReactApplicationContext));
      }
    }
    finally
    {
      Systrace.endSection(0L);
    }
    return localArrayList;
  }
  
  public ReactApplicationContext createContext(JavaScriptExecutor paramJavaScriptExecutor, JSBundleLoader paramJSBundleLoader)
  {
    return createReactContext(paramJavaScriptExecutor, paramJSBundleLoader);
  }
  
  public void createReactContextInBackground()
  {
    if (!this.mHasStartedCreatingInitialContext)
    {
      this.mHasStartedCreatingInitialContext = true;
      recreateReactContextInBackgroundInner();
    }
    while (!FLog.isLoggable(6)) {
      return;
    }
    FLog.e("Exception", "createReactContextInBackground should only be called when creating the react application for the first time. When reloading JS, e.g. from a new file, explicitlyuse recreateReactContextInBackground");
  }
  
  public void detachRootView(ReactRootView paramReactRootView)
  {
    
    if ((this.mAttachedRootViews.remove(Integer.valueOf(paramReactRootView.hashCode())) != null) && (this.mCurrentReactContext != null) && (this.mCurrentReactContext.hasActiveCatalystInstance())) {
      detachViewFromInstance(paramReactRootView, this.mCurrentReactContext.getCatalystInstance());
    }
    if ((this.mAttachedRootViews.isEmpty()) && (this.mCurrentReactContext != null))
    {
      Object localObject = this.mCurrentReactContext.getCatalystInstance();
      if (localObject != null)
      {
        localObject = ((UIManagerModule)((CatalystInstance)localObject).getNativeModule(UIManagerModule.class)).mUIImplementation.mNativeViewHierarchyManager;
        paramReactRootView = ((NativeViewHierarchyManager)localObject).getViewManager(paramReactRootView.getId());
        if (paramReactRootView != null) {
          paramReactRootView.clearViewToMgr();
        }
        ((NativeViewHierarchyManager)localObject).clearMaps();
      }
    }
  }
  
  @Nullable
  @VisibleForTesting
  public ReactContext getCurrentReactContext()
  {
    return this.mCurrentReactContext;
  }
  
  public DevSupportManager getDevSupportManager()
  {
    return this.mDevSupportManager;
  }
  
  public String getSourceUrl()
  {
    return (String)Assertions.assertNotNull(this.mSourceUrl);
  }
  
  public boolean hasStartedCreatingInitialContext()
  {
    return this.mHasStartedCreatingInitialContext;
  }
  
  public boolean isDestroy()
  {
    return (this.mCurrentReactContext != null) && (this.mCurrentReactContext.hasActiveCatalystInstance());
  }
  
  public boolean isScrollIdle()
  {
    return this.mIsScrollIdle;
  }
  
  public boolean isUseDeveloperSupport()
  {
    return (this.mUseDeveloperSupport) && (this.mDevSupportManager != null);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.mCurrentReactContext != null) {
      this.mCurrentReactContext.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onBackPressed()
  {
    UiThreadUtil.assertOnUiThread();
    ReactContext localReactContext = this.mCurrentReactContext;
    if (this.mCurrentReactContext == null)
    {
      if (FLog.isLoggable(5)) {
        FLog.w("React", "Instance detached from instance manager");
      }
      invokeDefaultOnBackPressed();
      return;
    }
    ((DeviceEventManagerModule)((ReactContext)Assertions.assertNotNull(localReactContext)).getNativeModule(DeviceEventManagerModule.class)).emitHardwareBackPressed();
  }
  
  public void onDestroy()
  {
    UiThreadUtil.assertOnUiThread();
    this.mMemoryPressureRouter.destroy(this.mApplicationContext);
    if ((this.mUseDeveloperSupport) && (this.mDevSupportManager != null))
    {
      this.mDevSupportManager.setDevSupportEnabled(false);
      if (this.mCurrentReactContext != null)
      {
        this.mCurrentReactContext.onDestroy();
        this.mCurrentReactContext = null;
        this.mHasStartedCreatingInitialContext = false;
      }
    }
  }
  
  public void onPause()
  {
    UiThreadUtil.assertOnUiThread();
    this.mLifecycleState = LifecycleState.BEFORE_RESUME;
    this.mDefaultBackButtonImpl = null;
    if ((this.mUseDeveloperSupport) && (this.mDevSupportManager != null)) {
      this.mDevSupportManager.setDevSupportEnabled(false);
    }
    if (this.mCurrentReactContext != null) {
      this.mCurrentReactContext.onPause();
    }
  }
  
  public void onResume(DefaultHardwareBackBtnHandler paramDefaultHardwareBackBtnHandler)
  {
    UiThreadUtil.assertOnUiThread();
    this.mLifecycleState = LifecycleState.RESUMED;
    this.mDefaultBackButtonImpl = paramDefaultHardwareBackBtnHandler;
    if ((this.mUseDeveloperSupport) && (this.mDevSupportManager != null)) {
      this.mDevSupportManager.setDevSupportEnabled(true);
    }
    if (this.mCurrentReactContext != null) {
      this.mCurrentReactContext.onResume();
    }
  }
  
  public void recreateReactContextInBackground()
  {
    if (!this.mHasStartedCreatingInitialContext)
    {
      if (FLog.isLoggable(6)) {
        FLog.e("Exception", "recreateReactContextInBackground should only be called after the initial createReactContextInBackground call.");
      }
      return;
    }
    recreateReactContextInBackgroundInner();
  }
  
  public void recreateReactContextInBackground(JavaScriptExecutor paramJavaScriptExecutor, JSBundleLoader paramJSBundleLoader)
  {
    UiThreadUtil.assertOnUiThread();
    paramJavaScriptExecutor = new ReactContextInitParams(paramJavaScriptExecutor, paramJSBundleLoader);
    if (!this.mIsContextInitAsyncTaskRunning)
    {
      new ReactContextInitAsyncTask(null).execute(new ReactContextInitParams[] { paramJavaScriptExecutor });
      this.mIsContextInitAsyncTaskRunning = true;
      return;
    }
    this.mPendingReactContextInitParams = paramJavaScriptExecutor;
  }
  
  public void setNeedAttachView(boolean paramBoolean)
  {
    this.mNeedAttachView = paramBoolean;
  }
  
  public void setupReactContext(ReactApplicationContext paramReactApplicationContext)
  {
    UiThreadUtil.assertOnUiThread();
    this.mCurrentReactContext = ((ReactContext)Assertions.assertNotNull(paramReactApplicationContext));
    Object localObject = (CatalystInstance)Assertions.assertNotNull(paramReactApplicationContext.getCatalystInstance());
    ((CatalystInstance)localObject).initialize();
    if ((this.mUseDeveloperSupport) && (this.mDevSupportManager != null)) {
      this.mDevSupportManager.onNewReactContextCreated(paramReactApplicationContext);
    }
    this.mMemoryPressureRouter.onNewReactContextCreated(paramReactApplicationContext);
    moveReactContextToCurrentLifecycleState(paramReactApplicationContext);
    Iterator localIterator = this.mAttachedRootViews.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      attachMeasuredRootViewToInstance((ReactRootView)this.mAttachedRootViews.get(localInteger), (CatalystInstance)localObject);
    }
    localObject = this.mReactInstanceEventListeners.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((ReactInstanceManager.ReactInstanceEventListener)((Iterator)localObject).next()).onReactContextInitialized(paramReactApplicationContext);
    }
  }
  
  public void showDevOptionsDialog()
  {
    if ((this.mUseDeveloperSupport) && (this.mDevSupportManager != null))
    {
      UiThreadUtil.assertOnUiThread();
      this.mDevSupportManager.showDevOptionsDialog();
    }
  }
  
  protected void tearDownReactContext(ReactContext paramReactContext)
  {
    if (paramReactContext == null) {
      if (FLog.isLoggable(6)) {
        FLog.e("React", "tearDownReactContext but reactcontext is null");
      }
    }
    do
    {
      return;
      UiThreadUtil.assertOnUiThread();
      if (this.mLifecycleState == LifecycleState.RESUMED) {
        paramReactContext.onPause();
      }
      Iterator localIterator = this.mAttachedRootViews.keySet().iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        detachViewFromInstance((ReactRootView)this.mAttachedRootViews.get(localInteger), paramReactContext.getCatalystInstance());
      }
      paramReactContext.onDestroy();
      this.mMemoryPressureRouter.onReactInstanceDestroyed();
      if ((this.mUseDeveloperSupport) && (this.mDevSupportManager != null))
      {
        this.mDevSupportManager.onReactInstanceDestroyed(paramReactContext);
        return;
      }
      this.mAttachedRootViews.clear();
    } while (this.mCurrentReactContext == null);
    this.mCurrentReactContext.onDestroy();
    this.mCurrentReactContext = null;
    this.mHasStartedCreatingInitialContext = false;
  }
  
  private final class ReactContextInitAsyncTask
    extends AsyncTask<ReactInstanceManagerImpl.ReactContextInitParams, Void, ReactApplicationContext>
  {
    private ReactContextInitAsyncTask() {}
    
    protected ReactApplicationContext doInBackground(ReactInstanceManagerImpl.ReactContextInitParams... paramVarArgs)
    {
      if ((paramVarArgs != null) && (paramVarArgs.length > 0) && (paramVarArgs[0] != null)) {}
      for (boolean bool = true;; bool = false)
      {
        Assertions.assertCondition(bool);
        return ReactInstanceManagerImpl.this.createReactContext(paramVarArgs[0].getJsExecutor(), paramVarArgs[0].getJsBundleLoader());
      }
    }
    
    protected void onPostExecute(ReactApplicationContext paramReactApplicationContext)
    {
      try
      {
        ReactInstanceManagerImpl.this.setupReactContext(paramReactApplicationContext);
        ReactInstanceManagerImpl.access$602(ReactInstanceManagerImpl.this, false);
        if (ReactInstanceManagerImpl.this.mPendingReactContextInitParams != null) {
          ReactInstanceManagerImpl.this.recreateReactContextInBackground(ReactInstanceManagerImpl.this.mPendingReactContextInitParams.getJsExecutor(), ReactInstanceManagerImpl.this.mPendingReactContextInitParams.getJsBundleLoader());
        }
        return;
      }
      finally
      {
        ReactInstanceManagerImpl.access$602(ReactInstanceManagerImpl.this, false);
      }
    }
    
    protected void onPreExecute()
    {
      if (ReactInstanceManagerImpl.this.mCurrentReactContext != null)
      {
        ReactInstanceManagerImpl.this.tearDownReactContext(ReactInstanceManagerImpl.this.mCurrentReactContext);
        ReactInstanceManagerImpl.access$402(ReactInstanceManagerImpl.this, null);
      }
    }
  }
  
  private class ReactContextInitParams
  {
    private final JSBundleLoader mJsBundleLoader;
    private final JavaScriptExecutor mJsExecutor;
    
    public ReactContextInitParams(JavaScriptExecutor paramJavaScriptExecutor, JSBundleLoader paramJSBundleLoader)
    {
      this.mJsExecutor = paramJavaScriptExecutor;
      this.mJsBundleLoader = ((JSBundleLoader)Assertions.assertNotNull(paramJSBundleLoader));
    }
    
    public JSBundleLoader getJsBundleLoader()
    {
      return this.mJsBundleLoader;
    }
    
    public JavaScriptExecutor getJsExecutor()
    {
      return this.mJsExecutor;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\ReactInstanceManagerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */