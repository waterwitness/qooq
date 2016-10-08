package com.tencent.bitapp.pre.binder.client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;
import com.facebook.common.logging.FLog;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.CatalystInstanceImpl.NativeModulesReactCallback;
import com.facebook.react.bridge.MemoryPressure;
import com.facebook.react.bridge.ReactContext;
import com.facebook.soloader.SoLoader;
import com.tencent.bitapp.pre.ContextUtils;
import com.tencent.bitapp.pre.binder.aidl.Java2Jni;
import com.tencent.bitapp.pre.binder.aidl.Java2Jni.Stub;
import com.tencent.bitapp.pre.binder.aidl.Jni2Java.Stub;
import com.tencent.bitapp.pre.binder.server.Java2JniService;
import com.tencent.bitapp.pre.binder.server.proxy.jni.JavaScriptExecutor;
import com.tencent.bitapp.pre.binder.server.proxy.jni.ReadableNativeArray;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

public class Java2jniClient
  implements IJava2jniClient
{
  public static final String TAG = "Java2jniClient";
  private Map<String, String> initParams = null;
  boolean isKilled = false;
  private int lastViewId = 0;
  private List<BundleSource> mBundleLoaded = null;
  WeakReference<CatalystInstance> mCIRef;
  Java2Jni mJava2Jni = null;
  Jni2Java.Stub mJni2Java = new Jni2JavaStub(null);
  ServiceConnection mServiceConnection = new Java2JniConnection(null);
  private int startViewId = -1;
  
  private void loadScriptAfterBind(String[] paramArrayOfString, @Nullable String paramString)
  {
    if (FLog.isLoggable(3)) {
      FLog.d("Java2jniClient", "Java2JniClient loadScriptAfterBind");
    }
    if (paramArrayOfString != null)
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = paramArrayOfString[i];
        if (FLog.isLoggable(3)) {
          FLog.d("Java2jniClient", "Java2JniClient loadScriptAfterBind file: " + str);
        }
        i += 1;
      }
    }
    try
    {
      this.mJava2Jni.reactBridgeLoadScriptFromFile(paramArrayOfString, paramString);
      return;
    }
    catch (RemoteException paramArrayOfString)
    {
      do
      {
        paramArrayOfString.printStackTrace();
      } while (!FLog.isLoggable(3));
      FLog.d("Java2jniClient", "Java2JniClient loadScriptAfterBind exception: " + paramArrayOfString.getMessage());
    }
  }
  
  private void setGlobalvariable(String paramString1, String paramString2)
  {
    if (FLog.isLoggable(3)) {
      FLog.d("Java2jniClient", "Java2JniClient setGlobalvariable propertyName: " + paramString1 + " | jsonEncodedArgument: " + paramString2);
    }
    if (this.mJava2Jni != null) {}
    while (!FLog.isLoggable(3)) {
      try
      {
        this.mJava2Jni.reactBridgeSetGlobalvariable(paramString1, paramString2);
        return;
      }
      catch (RemoteException paramString1)
      {
        do
        {
          paramString1.printStackTrace();
        } while (!FLog.isLoggable(3));
        FLog.d("Java2jniClient", "Java2JniClient setGlobalvariable exception: " + paramString1.getMessage());
        return;
      }
    }
    FLog.d("Java2jniClient", "Java2JniClient mJava2Jni is null");
  }
  
  private void setSoLoadPath()
  {
    if (FLog.isLoggable(3)) {
      FLog.d("Java2jniClient", "Java2JniClient setSoLoadPath");
    }
    if (this.mJava2Jni != null) {}
    while (!FLog.isLoggable(3)) {
      try
      {
        String[] arrayOfString2 = new String[SoLoader.extSoSource.size()];
        String[] arrayOfString1 = arrayOfString2;
        if (SoLoader.extSoSource.size() > 0) {
          arrayOfString1 = (String[])SoLoader.extSoSource.toArray(arrayOfString2);
        }
        if (FLog.isLoggable(3)) {
          FLog.d("Java2jniClient", "Java2JniClient setSoLoadPath SoLoader.extSoSource: " + SoLoader.extSoSource);
        }
        this.mJava2Jni.setSoLoadPath(arrayOfString1);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        do
        {
          localRemoteException.printStackTrace();
        } while (!FLog.isLoggable(3));
        FLog.d("Java2jniClient", "Java2JniClient setGlobalvariable exception: " + localRemoteException.getMessage());
        return;
      }
    }
    FLog.d("Java2jniClient", "Java2JniClient mJava2Jni is null");
  }
  
  public void addInitParams(String paramString1, String paramString2)
  {
    this.initParams.put(paramString1, paramString2);
  }
  
  public void bindService()
  {
    if (FLog.isLoggable(3)) {
      FLog.d("Java2jniClient", "bindService");
    }
    Object localObject2;
    if (this.mJava2Jni == null)
    {
      Object localObject1 = ContextUtils.INSTANCE.getApplicationContext();
      if (localObject1 != null)
      {
        ((Context)localObject1).bindService(new Intent((Context)localObject1, Java2JniService.class), this.mServiceConnection, 1);
        int i = 0;
        for (;;)
        {
          if ((i >= 100) || (this.mJava2Jni != null))
          {
            if (this.mJava2Jni == null) {
              break label315;
            }
            setSoLoadPath();
            if (this.initParams != null)
            {
              if (FLog.isLoggable(3)) {
                FLog.d("Java2jniClient", "initParams size: " + this.initParams.size());
              }
              localObject1 = this.initParams.entrySet().iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = (Map.Entry)((Iterator)localObject1).next();
                setGlobalvariable((String)((Map.Entry)localObject2).getKey(), (String)((Map.Entry)localObject2).getValue());
              }
            }
          }
          else
          {
            try
            {
              Thread.sleep(50L);
              i += 1;
            }
            catch (InterruptedException localInterruptedException)
            {
              for (;;)
              {
                localInterruptedException.printStackTrace();
              }
            }
          }
        }
        if (FLog.isLoggable(3)) {
          FLog.d("Java2jniClient", "initParams is null");
        }
      }
    }
    while ((this.mJava2Jni != null) && (this.isKilled))
    {
      this.isKilled = false;
      this.startViewId = this.lastViewId;
      setSoLoadPath();
      Iterator localIterator;
      if (this.initParams != null)
      {
        localIterator = this.initParams.entrySet().iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localObject2 = (Map.Entry)localIterator.next();
            setGlobalvariable((String)((Map.Entry)localObject2).getKey(), (String)((Map.Entry)localObject2).getValue());
            continue;
            label315:
            if (!FLog.isLoggable(3)) {
              break;
            }
            FLog.d("Java2jniClient", "mJava2Jni is null wait timeout");
            break;
            if (!FLog.isLoggable(3)) {
              break;
            }
            FLog.d("Java2jniClient", "bindService context is null");
            break;
            if (!FLog.isLoggable(3)) {
              break;
            }
            FLog.d("Java2jniClient", "bindService is exist");
            break;
          }
        }
      }
      if (this.mBundleLoaded != null)
      {
        localIterator = this.mBundleLoaded.iterator();
        while (localIterator.hasNext())
        {
          localObject2 = (BundleSource)localIterator.next();
          loadScriptAfterBind(((BundleSource)localObject2).getCachedFileLocation(), ((BundleSource)localObject2).getSourceURL());
        }
      }
      reactBridgeExecuteJSScript("require('ReactNativeTagHandles').tagCount = " + this.lastViewId + ";");
    }
  }
  
  public void exitProcess() {}
  
  public boolean isInvalidView(int paramInt)
  {
    if (FLog.isLoggable(3)) {
      FLog.d("Java2jniClient", "isValidView startViewId: " + this.startViewId + " | viewId: " + paramInt);
    }
    return (this.startViewId >= 0) && (this.startViewId > paramInt);
  }
  
  public void reactBridgeCallfunction(int paramInt1, int paramInt2, Object[] paramArrayOfObject, String paramString)
  {
    if (FLog.isLoggable(3)) {
      FLog.d("Java2jniClient", "Java2JniClient reactBridgeCallfunction tracingName : " + paramString);
    }
    bindService();
    if (this.mJava2Jni != null) {}
    while (!FLog.isLoggable(3)) {
      try
      {
        this.mJava2Jni.reactBridgeCallfunction(paramInt1, paramInt2, Arguments.toBundle(paramArrayOfObject));
        return;
      }
      catch (RemoteException paramArrayOfObject)
      {
        do
        {
          paramArrayOfObject.printStackTrace();
        } while (!FLog.isLoggable(3));
        FLog.d("Java2jniClient", "Java2JniClient reactBridgeCallfunction exception: " + paramArrayOfObject.getMessage());
        return;
      }
    }
    FLog.d("Java2jniClient", "Java2JniClient mJava2Jni is null");
  }
  
  public void reactBridgeDestory()
  {
    if (FLog.isLoggable(3)) {
      FLog.d("Java2jniClient", "Java2JniClient reactBridgeDestory: " + this.mJava2Jni);
    }
    if (this.mJava2Jni != null) {}
    for (;;)
    {
      try
      {
        this.mJava2Jni.reactBridgeDestory();
        unbindService();
        this.isKilled = false;
        this.initParams.clear();
        this.lastViewId = 0;
        this.startViewId = -1;
        this.mBundleLoaded.clear();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        localRemoteException.printStackTrace();
        if (!FLog.isLoggable(3)) {
          continue;
        }
        FLog.d("Java2jniClient", "Java2JniClient reactBridgeDestory exception: " + localRemoteException.getMessage());
        continue;
      }
      if (FLog.isLoggable(3)) {
        FLog.d("Java2jniClient", "Java2JniClient mJava2Jni is null");
      }
    }
  }
  
  public void reactBridgeExecuteJSScript(String paramString)
  {
    if (FLog.isLoggable(3)) {
      FLog.d("Java2jniClient", "Java2JniClient reactBridgeExecuteJSScript: " + paramString);
    }
    bindService();
    if (this.mJava2Jni != null) {}
    while (!FLog.isLoggable(3)) {
      try
      {
        this.mJava2Jni.reactBridgeExecuteJSScript(paramString);
        return;
      }
      catch (RemoteException paramString)
      {
        do
        {
          paramString.printStackTrace();
        } while (!FLog.isLoggable(3));
        FLog.d("Java2jniClient", "Java2JniClient reactBridgeExecuteJSScript exception: " + paramString.getMessage());
        return;
      }
    }
    FLog.d("Java2jniClient", "Java2JniClient mJava2Jni is null");
  }
  
  public void reactBridgeHandleMemoryPressure(MemoryPressure paramMemoryPressure)
  {
    if (FLog.isLoggable(3)) {
      FLog.d("Java2jniClient", "Java2JniClient reactBridgeHandleMemoryPressure");
    }
    if (this.mJava2Jni != null) {}
    while (!FLog.isLoggable(3)) {
      try
      {
        this.mJava2Jni.reactBridgeHandleMemoryPressure(paramMemoryPressure.toString());
        return;
      }
      catch (RemoteException paramMemoryPressure)
      {
        do
        {
          paramMemoryPressure.printStackTrace();
        } while (!FLog.isLoggable(3));
        FLog.d("Java2jniClient", "Java2JniClient reactBridgeHandleMemoryPressure exception: " + paramMemoryPressure.getMessage());
        return;
      }
    }
    FLog.d("Java2jniClient", "Java2JniClient mJava2Jni is null");
  }
  
  public void reactBridgeInvokeCallback(int paramInt, Object[] paramArrayOfObject)
  {
    if (FLog.isLoggable(3)) {
      FLog.d("Java2jniClient", "Java2JniClient reactBridgeInvokeCallback");
    }
    bindService();
    if (this.mJava2Jni != null) {}
    while (!FLog.isLoggable(3)) {
      try
      {
        this.mJava2Jni.reactBridgeInvokeCallback(paramInt, Arguments.toBundle(paramArrayOfObject));
        return;
      }
      catch (RemoteException paramArrayOfObject)
      {
        do
        {
          paramArrayOfObject.printStackTrace();
        } while (!FLog.isLoggable(3));
        FLog.d("Java2jniClient", "Java2JniClient reactBridgeInvokeCallback exception: " + paramArrayOfObject.getMessage());
        return;
      }
    }
    FLog.d("Java2jniClient", "Java2JniClient mJava2Jni is null");
  }
  
  public void reactBridgeLoadScriptFromAssets(AssetManager paramAssetManager, String paramString) {}
  
  public void reactBridgeLoadScriptFromFile(String[] paramArrayOfString, @Nullable String paramString)
  {
    if (FLog.isLoggable(3)) {
      FLog.d("Java2jniClient", "Java2JniClient reactBridgeLoadScriptFromFile");
    }
    bindService();
    if (this.mJava2Jni != null) {}
    while (!FLog.isLoggable(3)) {
      try
      {
        this.mBundleLoaded.add(new BundleSource(paramArrayOfString, paramString));
        this.mJava2Jni.reactBridgeLoadScriptFromFile(paramArrayOfString, paramString);
        return;
      }
      catch (RemoteException paramArrayOfString)
      {
        do
        {
          paramArrayOfString.printStackTrace();
        } while (!FLog.isLoggable(3));
        FLog.d("Java2jniClient", "Java2JniClient reactBridgeLoadScriptFromFile exception: " + paramArrayOfString.getMessage());
        return;
      }
    }
    FLog.d("Java2jniClient", "Java2JniClient mJava2Jni is null");
  }
  
  public void setJavaScriptExecutor(CatalystInstance paramCatalystInstance, JavaScriptExecutor paramJavaScriptExecutor)
  {
    if (paramCatalystInstance != null)
    {
      this.mCIRef = new WeakReference(paramCatalystInstance);
      return;
    }
    this.mCIRef = null;
  }
  
  public void setLastViewId(int paramInt)
  {
    this.lastViewId = paramInt;
  }
  
  /* Error */
  public void unbindService()
  {
    // Byte code:
    //   0: iconst_3
    //   1: invokestatic 94	com/facebook/common/logging/FLog:isLoggable	(I)Z
    //   4: ifeq +31 -> 35
    //   7: ldc 25
    //   9: new 102	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 361
    //   19: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_0
    //   23: getfield 51	com/tencent/bitapp/pre/binder/client/Java2jniClient:mJava2Jni	Lcom/tencent/bitapp/pre/binder/aidl/Java2Jni;
    //   26: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 100	com/facebook/common/logging/FLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: aload_0
    //   36: getfield 51	com/tencent/bitapp/pre/binder/client/Java2jniClient:mJava2Jni	Lcom/tencent/bitapp/pre/binder/aidl/Java2Jni;
    //   39: ifnull +35 -> 74
    //   42: getstatic 185	com/tencent/bitapp/pre/ContextUtils:INSTANCE	Lcom/tencent/bitapp/pre/ContextUtils;
    //   45: invokevirtual 189	com/tencent/bitapp/pre/ContextUtils:getApplicationContext	()Landroid/content/Context;
    //   48: astore_1
    //   49: aload_1
    //   50: ifnull +50 -> 100
    //   53: aload_0
    //   54: getfield 51	com/tencent/bitapp/pre/binder/client/Java2jniClient:mJava2Jni	Lcom/tencent/bitapp/pre/binder/aidl/Java2Jni;
    //   57: aload_0
    //   58: getfield 56	com/tencent/bitapp/pre/binder/client/Java2jniClient:mJni2Java	Lcom/tencent/bitapp/pre/binder/aidl/Jni2Java$Stub;
    //   61: invokeinterface 365 2 0
    //   66: aload_1
    //   67: aload_0
    //   68: getfield 59	com/tencent/bitapp/pre/binder/client/Java2jniClient:mServiceConnection	Landroid/content/ServiceConnection;
    //   71: invokevirtual 368	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   74: aload_0
    //   75: aconst_null
    //   76: putfield 51	com/tencent/bitapp/pre/binder/client/Java2jniClient:mJava2Jni	Lcom/tencent/bitapp/pre/binder/aidl/Java2Jni;
    //   79: return
    //   80: astore_2
    //   81: iconst_3
    //   82: invokestatic 94	com/facebook/common/logging/FLog:isLoggable	(I)Z
    //   85: ifeq -19 -> 66
    //   88: ldc 25
    //   90: ldc_w 369
    //   93: aload_2
    //   94: invokestatic 372	com/facebook/common/logging/FLog:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   97: goto -31 -> 66
    //   100: iconst_3
    //   101: invokestatic 94	com/facebook/common/logging/FLog:isLoggable	(I)Z
    //   104: ifeq -30 -> 74
    //   107: ldc 25
    //   109: ldc_w 374
    //   112: invokestatic 100	com/facebook/common/logging/FLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: goto -41 -> 74
    //   118: astore_1
    //   119: goto -45 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	this	Java2jniClient
    //   48	19	1	localContext	Context
    //   118	1	1	localException	Exception
    //   80	14	2	localRemoteException	RemoteException
    // Exception table:
    //   from	to	target	type
    //   53	66	80	android/os/RemoteException
    //   66	74	118	java/lang/Exception
  }
  
  class BundleSource
  {
    String[] cachedFileLocation = null;
    String sourceURL = "";
    
    public BundleSource(String[] paramArrayOfString, String paramString)
    {
      this.cachedFileLocation = paramArrayOfString;
      this.sourceURL = paramString;
    }
    
    public String[] getCachedFileLocation()
    {
      return this.cachedFileLocation;
    }
    
    public String getSourceURL()
    {
      return this.sourceURL;
    }
  }
  
  private class Java2JniConnection
    implements ServiceConnection
  {
    private Java2JniConnection() {}
    
    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      if (FLog.isLoggable(3)) {
        FLog.d("Java2jniClient", "Java2JniConnection onServiceConnected");
      }
      Java2jniClient.this.mJava2Jni = Java2Jni.Stub.asInterface(paramIBinder);
      new Thread(new Runnable()
      {
        public void run()
        {
          if (FLog.isLoggable(3)) {
            FLog.d("Java2jniClient", "Java2JniClient onServiceConnected -> setSoLoadPath. ");
          }
          Java2jniClient.this.setSoLoadPath();
        }
      }).run();
      try
      {
        Java2jniClient.this.mJava2Jni.registerCallback(Java2jniClient.this.mJni2Java);
      }
      catch (RemoteException paramComponentName)
      {
        try
        {
          for (;;)
          {
            Java2jniClient.this.mJava2Jni.asBinder().linkToDeath(new IBinder.DeathRecipient()
            {
              public void binderDied()
              {
                if (Java2jniClient.this.mJava2Jni != null)
                {
                  if (FLog.isLoggable(3)) {
                    FLog.d("Java2jniClient", "process exited, process exit!");
                  }
                  Java2jniClient.this.isKilled = true;
                  Java2jniClient.this.exitProcess();
                }
              }
            }, 0);
            return;
            paramComponentName = paramComponentName;
            if (FLog.isLoggable(3)) {
              FLog.d("Java2jniClient", "onServiceConnected", paramComponentName);
            }
          }
        }
        catch (Exception paramComponentName)
        {
          while (!FLog.isLoggable(3)) {}
          FLog.d("Java2jniClient", "onServiceConnected", paramComponentName);
        }
      }
    }
    
    public void onServiceDisconnected(ComponentName paramComponentName)
    {
      if (FLog.isLoggable(3)) {
        FLog.d("Java2jniClient", "Java2JniConnection onServiceDisconnected");
      }
      try
      {
        if (Java2jniClient.this.mJava2Jni != null) {
          Java2jniClient.this.mJava2Jni.unregisterCallback(Java2jniClient.this.mJni2Java);
        }
        Java2jniClient.this.mJava2Jni = null;
        return;
      }
      catch (RemoteException paramComponentName)
      {
        for (;;)
        {
          if (FLog.isLoggable(3)) {
            FLog.d("Java2jniClient", "onServiceDisconnected", paramComponentName);
          }
        }
      }
    }
  }
  
  private class Jni2JavaStub
    extends Jni2Java.Stub
  {
    private Jni2JavaStub() {}
    
    public void reactCallbackCall(int paramInt1, int paramInt2, Bundle paramBundle)
      throws RemoteException
    {
      if (FLog.isLoggable(3)) {
        FLog.d("Java2jniClient", "Jni2JavaStub reactCallbackCall moduleId: " + paramInt1 + " | methodId: " + paramInt2);
      }
      Object localObject1;
      Object localObject2;
      if (paramBundle != null)
      {
        localObject1 = paramBundle.keySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          if (FLog.isLoggable(3)) {
            FLog.d("Java2jniClient", "Jni2JavaStub reactCallbackCall parameters: " + (String)localObject2 + " = " + paramBundle.get((String)localObject2));
          }
        }
      }
      try
      {
        localObject2 = Arguments.fromBundle2Array(paramBundle);
        paramBundle = null;
        localObject1 = ReactInstanceManager.mReactInstanceManager.getCurrentReactContext();
        if (localObject1 != null) {
          paramBundle = ((ReactContext)localObject1).getCatalystInstance();
        }
        localObject1 = paramBundle;
        if (paramBundle == null)
        {
          WeakReference localWeakReference = Java2jniClient.this.mCIRef;
          localObject1 = paramBundle;
          if (localWeakReference != null) {
            localObject1 = (CatalystInstance)localWeakReference.get();
          }
        }
        if (localObject1 != null)
        {
          ((CatalystInstance)localObject1).getNativeModulesReactCallback().call(paramInt1, paramInt2, (ReadableNativeArray)localObject2);
          return;
        }
        if (FLog.isLoggable(6))
        {
          FLog.e("Java2jniClient", "reactCallbackCall CatalystInstance is null");
          return;
        }
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
      }
    }
    
    public void reactCallbackonBatchComplete()
      throws RemoteException
    {
      if (FLog.isLoggable(3)) {
        FLog.d("Java2jniClient", "Jni2JavaStub onBatchComplete mListener");
      }
      try
      {
        ReactInstanceManager.mReactInstanceManager.getCurrentReactContext().getCatalystInstance().getNativeModulesReactCallback().onBatchComplete();
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\pre\binder\client\Java2jniClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */