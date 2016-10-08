package com.tencent.bitapp.pre.binder.server.proxy.jni;

import com.facebook.common.logging.FLog;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.soloader.SoLoader;

@DoNotStrip
public class WritableNativeArray
  extends ReadableNativeArray
  implements WritableArray
{
  static
  {
    SoLoader.loadLibrary("reactnativejni");
  }
  
  public WritableNativeArray()
  {
    super(initHybrid());
  }
  
  private static native HybridData initHybrid();
  
  private native void pushNativeArray(WritableNativeArray paramWritableNativeArray);
  
  private native void pushNativeMap(WritableNativeMap paramWritableNativeMap);
  
  public void pushArray(WritableArray paramWritableArray)
  {
    if ((paramWritableArray != null) && ((paramWritableArray instanceof WritableNativeArray))) {
      pushNativeArray((WritableNativeArray)paramWritableArray);
    }
    while ((paramWritableArray == null) || ((paramWritableArray instanceof WritableNativeArray)) || (!FLog.isLoggable(6))) {
      return;
    }
    FLog.e("Exception", "Illegal type provided");
  }
  
  public native void pushBoolean(boolean paramBoolean);
  
  public native void pushDouble(double paramDouble);
  
  public native void pushInt(int paramInt);
  
  public void pushMap(WritableMap paramWritableMap)
  {
    if ((paramWritableMap != null) && ((paramWritableMap instanceof WritableNativeMap))) {
      pushNativeMap((WritableNativeMap)paramWritableMap);
    }
    while ((paramWritableMap == null) || ((paramWritableMap instanceof WritableNativeMap)) || (!FLog.isLoggable(6))) {
      return;
    }
    FLog.e("Exception", "Illegal type provided");
  }
  
  public native void pushNull();
  
  public native void pushString(String paramString);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\pre\binder\server\proxy\jni\WritableNativeArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */