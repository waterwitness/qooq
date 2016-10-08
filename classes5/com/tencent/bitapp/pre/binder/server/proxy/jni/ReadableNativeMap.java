package com.tencent.bitapp.pre.binder.server.proxy.jni;

import com.facebook.jni.Countable;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.soloader.SoLoader;

@DoNotStrip
public class ReadableNativeMap
  extends NativeMap
  implements ReadableMap
{
  static
  {
    SoLoader.loadLibrary("reactnativejni");
  }
  
  public native ReadableNativeArray getArray(String paramString);
  
  public native boolean getBoolean(String paramString);
  
  public native double getDouble(String paramString);
  
  public native int getInt(String paramString);
  
  public native ReadableNativeMap getMap(String paramString);
  
  public native String getString(String paramString);
  
  public native ReadableType getType(String paramString);
  
  public native boolean hasKey(String paramString);
  
  public native boolean isNull(String paramString);
  
  public ReadableMapKeySetIterator keySetIterator()
  {
    return new ReadableNativeMapKeySetIterator(this);
  }
  
  @DoNotStrip
  private static class ReadableNativeMapKeySetIterator
    extends Countable
    implements ReadableMapKeySetIterator
  {
    private final ReadableNativeMap mReadableNativeMap;
    
    public ReadableNativeMapKeySetIterator(ReadableNativeMap paramReadableNativeMap)
    {
      this.mReadableNativeMap = paramReadableNativeMap;
      initialize(this.mReadableNativeMap);
    }
    
    private native void initialize(ReadableNativeMap paramReadableNativeMap);
    
    public native boolean hasNextKey();
    
    public native String nextKey();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\pre\binder\server\proxy\jni\ReadableNativeMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */