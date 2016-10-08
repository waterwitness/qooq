package com.tencent.bitapp.pre.binder.server;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.RemoteException;
import com.facebook.common.logging.FLog;
import com.facebook.common.soloader.SoLoaderShim;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.MemoryPressure;
import com.facebook.react.modules.fresco.FrescoModule.FrescoHandler;
import com.facebook.soloader.SoLoader;
import com.tencent.bitapp.pre.ContextUtils;
import com.tencent.bitapp.pre.binder.ReactBridge;
import com.tencent.bitapp.pre.binder.server.proxy.jni.JavaScriptExecutor;
import com.tencent.bitapp.pre.binder.server.proxy.jni.NativeArray;
import com.tencent.bitapp.pre.binder.server.proxy.jni.ReadableNativeArray;
import java.util.List;

public class Java2JniImpl
{
  static final String TAG = Java2JniImpl.class.getSimpleName();
  public static Java2JniImpl instance = null;
  protected Context mApplicationContext;
  public ReactBridge mBridge = null;
  protected final JavaScriptExecutor mJSExecutor;
  protected final ReactCallbackCall mReactCallBackCall;
  
  public Java2JniImpl(JavaScriptExecutor paramJavaScriptExecutor, ReactCallbackCall paramReactCallbackCall)
    throws IllegalArgumentException
  {
    if (paramReactCallbackCall == null) {
      throw new IllegalArgumentException("ReactCallbackCall is null");
    }
    this.mJSExecutor = paramJavaScriptExecutor;
    this.mReactCallBackCall = paramReactCallbackCall;
    instance = this;
  }
  
  public ReactBridge getReactBridge()
  {
    if (this.mBridge == null) {
      this.mBridge = new ReactBridge(this.mJSExecutor);
    }
    return this.mBridge;
  }
  
  public void initializeSoLoaderIfNecessary()
  {
    Context localContext = this.mApplicationContext;
    if (localContext == null)
    {
      localContext = ContextUtils.INSTANCE.getApplicationContext();
      if (localContext == null) {
        break label36;
      }
      SoLoader.init(localContext, false);
    }
    label36:
    while (!FLog.isLoggable(6))
    {
      return;
      ContextUtils.INSTANCE.setApplicationContext(localContext);
      break;
    }
    FLog.e(TAG, "initializeSoLoaderIfNecessary context is null");
  }
  
  public void loadScriptFromAssets(AssetManager paramAssetManager, String paramString)
  {
    if (FLog.isLoggable(3)) {
      FLog.d(TAG, "loadScriptFromAssets params, sourceURL: " + paramString);
    }
    getReactBridge().loadScriptFromAssets(paramAssetManager, paramString);
  }
  
  public void onDestroy()
  {
    instance = null;
  }
  
  public void reactBridgeCallfunctionReal(int paramInt1, int paramInt2, NativeArray paramNativeArray)
    throws RemoteException
  {
    if (FLog.isLoggable(3)) {
      FLog.d(TAG, "reactBridgeCallfunctionReal params, moduleId: " + paramInt1 + " | methodId: " + paramInt2 + " | parameters: " + paramNativeArray);
    }
    getReactBridge().callFunction(paramInt1, paramInt2, paramNativeArray);
  }
  
  public void reactBridgeDestoryReal()
    throws RemoteException
  {
    if (FLog.isLoggable(3)) {
      FLog.d(TAG, "reactBridgeDestory");
    }
    if (this.mBridge != null)
    {
      this.mBridge.destory();
      this.mBridge = null;
    }
  }
  
  public void reactBridgeExecuteJSScriptReal(String paramString)
    throws RemoteException
  {
    if (FLog.isLoggable(3)) {
      FLog.d(TAG, "reactBridgeExecuteJSScript params, script: " + paramString);
    }
    getReactBridge().executeJSScript(paramString);
  }
  
  public void reactBridgeHandleMemoryPressureReal(String paramString)
    throws RemoteException
  {
    if (FLog.isLoggable(3)) {
      FLog.d(TAG, "reactBridgeHandleMemoryPressureReal params, memoryPressure: " + paramString);
    }
    paramString = MemoryPressure.valueOf(paramString);
    getReactBridge().handleMemoryPressure(paramString);
  }
  
  public void reactBridgeInvokeCallbackReal(int paramInt, NativeArray paramNativeArray)
    throws RemoteException
  {
    if (FLog.isLoggable(3)) {
      FLog.d(TAG, "reactBridgeInvokeCallback params, callbackID: " + paramInt + " | arguments: " + paramNativeArray);
    }
    getReactBridge().invokeCallback(paramInt, paramNativeArray);
  }
  
  public void reactBridgeLoadScriptFromFileReal(String[] paramArrayOfString, String paramString)
    throws RemoteException
  {
    if (FLog.isLoggable(3)) {
      FLog.d(TAG, "reactBridgeLoadScriptFromFile params, sourceURL: " + paramString + " | cachedFileLocation: " + paramArrayOfString);
    }
    getReactBridge().loadScriptFromFile(Arguments.fromJavaArgs(paramArrayOfString), paramString);
  }
  
  public void reactBridgeSetGlobalvariableReal(String paramString1, String paramString2)
    throws RemoteException
  {
    if (FLog.isLoggable(3)) {
      FLog.d(TAG, "setGlobalVariable params, propertyName: " + paramString1 + " | jsonEncodedArgument: " + paramString2);
    }
    getReactBridge().setGlobalVariable(paramString1, paramString2);
  }
  
  public void reactCallbackCall(int paramInt1, int paramInt2, ReadableNativeArray paramReadableNativeArray)
  {
    this.mReactCallBackCall.reactCallbackCall(paramInt1, paramInt2, paramReadableNativeArray);
  }
  
  public void reactCallbackonBatchComplete()
  {
    this.mReactCallBackCall.reactCallbackonBatchComplete();
  }
  
  public void setApplicationContext(Context paramContext)
  {
    this.mApplicationContext = paramContext;
  }
  
  public void setSoLoadPathReal(String[] paramArrayOfString)
    throws RemoteException
  {
    if (paramArrayOfString != null)
    {
      int i = 0;
      int j = paramArrayOfString.length;
      while (i < j)
      {
        SoLoader.extSoSource.add(paramArrayOfString[i]);
        i += 1;
      }
    }
    SoLoaderShim.setHandler(new FrescoModule.FrescoHandler());
    initializeSoLoaderIfNecessary();
  }
  
  public static abstract interface ReactCallbackCall
  {
    public abstract void reactCallbackCall(int paramInt1, int paramInt2, ReadableNativeArray paramReadableNativeArray);
    
    public abstract void reactCallbackonBatchComplete();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\pre\binder\server\Java2JniImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */