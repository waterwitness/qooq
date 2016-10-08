package com.tencent.bitapp.pre.binder.server.proxy.jni;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableType;
import com.facebook.soloader.SoLoader;

@DoNotStrip
public class ReadableNativeArray
  extends NativeArray
  implements ReadableArray
{
  static
  {
    SoLoader.loadLibrary("reactnativejni");
  }
  
  protected ReadableNativeArray(HybridData paramHybridData)
  {
    super(paramHybridData);
  }
  
  public native ReadableNativeArray getArray(int paramInt);
  
  public native boolean getBoolean(int paramInt);
  
  public native double getDouble(int paramInt);
  
  public native int getInt(int paramInt);
  
  public native ReadableNativeMap getMap(int paramInt);
  
  public native String getString(int paramInt);
  
  public native ReadableType getType(int paramInt);
  
  public native boolean isNull(int paramInt);
  
  public native int size();
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\pre\binder\server\proxy\jni\ReadableNativeArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */