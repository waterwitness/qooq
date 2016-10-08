package com.tencent.bitapp.pre.binder;

import android.content.res.AssetManager;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.MemoryPressure;
import com.tencent.bitapp.pre.binder.server.proxy.jni.JavaScriptExecutor;
import com.tencent.bitapp.pre.binder.server.proxy.jni.NativeArray;
import com.tencent.bitapp.pre.binder.server.proxy.jni.RealJSCJavaScriptExecutorJni;
import com.tencent.bitapp.pre.binder.server.proxy.jni.RealMessageQueueThread;
import com.tencent.bitapp.pre.binder.server.proxy.jni.RealReactBridgeJni;
import com.tencent.bitapp.pre.binder.server.proxy.jni.RealReactCallback;
import javax.annotation.Nullable;

@DoNotStrip
public class ReactBridge
{
  private ReactCallback mCallback;
  private JavaScriptExecutor mJSExecutor;
  private MessageQueueThread mNativeModulesQueueThread;
  private RealReactBridgeJni mRealReactBridgeJni = new RealReactBridgeJni();
  
  public ReactBridge(JavaScriptExecutor paramJavaScriptExecutor)
  {
    Object localObject = paramJavaScriptExecutor;
    if (paramJavaScriptExecutor == null)
    {
      localObject = new RealJSCJavaScriptExecutorJni();
      ((RealJSCJavaScriptExecutorJni)localObject).initialize();
    }
    this.mJSExecutor = ((JavaScriptExecutor)localObject);
    this.mCallback = new RealReactCallback();
    this.mNativeModulesQueueThread = new RealMessageQueueThread();
    this.mRealReactBridgeJni.initialize(this.mJSExecutor, this.mCallback, this.mNativeModulesQueueThread);
  }
  
  private void handleMemoryPressureCritical()
  {
    this.mRealReactBridgeJni.handleMemoryPressureCritical();
  }
  
  private void handleMemoryPressureModerate()
  {
    this.mRealReactBridgeJni.handleMemoryPressureModerate();
  }
  
  public void callFunction(int paramInt1, int paramInt2, NativeArray paramNativeArray)
  {
    this.mRealReactBridgeJni.callFunction(paramInt1, paramInt2, paramNativeArray);
  }
  
  public void destory()
  {
    this.mJSExecutor.close();
    this.mJSExecutor.dispose();
    this.mCallback = null;
    this.mJSExecutor = null;
    this.mNativeModulesQueueThread = null;
    this.mRealReactBridgeJni = null;
  }
  
  public void executeJSScript(String paramString)
  {
    this.mRealReactBridgeJni.executeJSScript(paramString);
  }
  
  public void handleMemoryPressure(MemoryPressure paramMemoryPressure)
  {
    switch (paramMemoryPressure)
    {
    default: 
      throw new IllegalArgumentException("Unknown level: " + paramMemoryPressure);
    case ???: 
      handleMemoryPressureModerate();
      return;
    }
    handleMemoryPressureCritical();
  }
  
  public void invokeCallback(int paramInt, NativeArray paramNativeArray)
  {
    this.mRealReactBridgeJni.invokeCallback(paramInt, paramNativeArray);
  }
  
  public void loadScriptFromAssets(AssetManager paramAssetManager, String paramString)
  {
    this.mRealReactBridgeJni.loadScriptFromAssets(paramAssetManager, paramString);
  }
  
  public void loadScriptFromFile(NativeArray paramNativeArray, @Nullable String paramString)
  {
    this.mRealReactBridgeJni.loadScriptFromFile(paramNativeArray, paramString);
  }
  
  public void setGlobalVariable(String paramString1, String paramString2)
  {
    this.mRealReactBridgeJni.setGlobalVariable(paramString1, paramString2);
  }
  
  public void startProfiler(String paramString)
  {
    this.mRealReactBridgeJni.startProfiler(paramString);
  }
  
  public void stopProfiler(String paramString1, String paramString2)
  {
    this.mRealReactBridgeJni.stopProfiler(paramString1, paramString2);
  }
  
  public boolean supportsProfiling()
  {
    return this.mRealReactBridgeJni.supportsProfiling();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\pre\binder\ReactBridge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */