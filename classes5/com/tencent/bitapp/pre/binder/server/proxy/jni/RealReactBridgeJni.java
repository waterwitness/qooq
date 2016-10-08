package com.tencent.bitapp.pre.binder.server.proxy.jni;

import android.content.res.AssetManager;
import com.facebook.jni.Countable;
import com.facebook.soloader.SoLoader;
import com.tencent.bitapp.pre.binder.MessageQueueThread;
import com.tencent.bitapp.pre.binder.ReactCallback;
import javax.annotation.Nullable;

public class RealReactBridgeJni
  extends Countable
{
  public static final String REACT_NATIVE_LIB = "reactnativejni";
  
  static
  {
    SoLoader.loadLibrary("reactnativejni");
  }
  
  public native void callFunction(int paramInt1, int paramInt2, NativeArray paramNativeArray);
  
  public native void executeJSScript(String paramString);
  
  public native void handleMemoryPressureCritical();
  
  public native void handleMemoryPressureModerate();
  
  public native void initialize(JavaScriptExecutor paramJavaScriptExecutor, ReactCallback paramReactCallback, MessageQueueThread paramMessageQueueThread);
  
  public native void invokeCallback(int paramInt, NativeArray paramNativeArray);
  
  public native void loadScriptFromAssets(AssetManager paramAssetManager, String paramString);
  
  public native void loadScriptFromFile(NativeArray paramNativeArray, @Nullable String paramString);
  
  public native void setGlobalVariable(String paramString1, String paramString2);
  
  public native void startProfiler(String paramString);
  
  public native void stopProfiler(String paramString1, String paramString2);
  
  public native boolean supportsProfiling();
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\pre\binder\server\proxy\jni\RealReactBridgeJni.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */