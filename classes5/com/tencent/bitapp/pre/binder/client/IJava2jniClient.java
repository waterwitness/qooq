package com.tencent.bitapp.pre.binder.client;

import android.content.res.AssetManager;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.MemoryPressure;
import com.tencent.bitapp.pre.binder.server.proxy.jni.JavaScriptExecutor;
import javax.annotation.Nullable;

public abstract interface IJava2jniClient
{
  public abstract void addInitParams(String paramString1, String paramString2);
  
  public abstract boolean isInvalidView(int paramInt);
  
  public abstract void reactBridgeCallfunction(int paramInt1, int paramInt2, Object[] paramArrayOfObject, String paramString);
  
  public abstract void reactBridgeDestory();
  
  public abstract void reactBridgeExecuteJSScript(String paramString);
  
  public abstract void reactBridgeHandleMemoryPressure(MemoryPressure paramMemoryPressure);
  
  public abstract void reactBridgeInvokeCallback(int paramInt, Object[] paramArrayOfObject);
  
  public abstract void reactBridgeLoadScriptFromAssets(AssetManager paramAssetManager, String paramString);
  
  public abstract void reactBridgeLoadScriptFromFile(String[] paramArrayOfString, @Nullable String paramString);
  
  public abstract void setJavaScriptExecutor(CatalystInstance paramCatalystInstance, JavaScriptExecutor paramJavaScriptExecutor);
  
  public abstract void setLastViewId(int paramInt);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\pre\binder\client\IJava2jniClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */