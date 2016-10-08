package com.tencent.bitapp.pre.binder.server.proxy.jni;

import com.facebook.common.logging.FLog;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.soloader.SoLoader;

@DoNotStrip
public class WritableNativeMap
  extends ReadableNativeMap
  implements WritableMap
{
  static
  {
    SoLoader.loadLibrary("reactnativejni");
  }
  
  private native void mergeNativeMap(ReadableNativeMap paramReadableNativeMap);
  
  private native void putNativeArray(String paramString, WritableNativeArray paramWritableNativeArray);
  
  private native void putNativeMap(String paramString, WritableNativeMap paramWritableNativeMap);
  
  public void merge(ReadableMap paramReadableMap)
  {
    if (!(paramReadableMap instanceof ReadableNativeMap))
    {
      if (FLog.isLoggable(6)) {
        FLog.e("Exception", "Illegal type provided");
      }
      return;
    }
    mergeNativeMap((ReadableNativeMap)paramReadableMap);
  }
  
  public void putArray(String paramString, WritableArray paramWritableArray)
  {
    if ((paramWritableArray != null) && ((paramWritableArray instanceof WritableNativeArray))) {
      putNativeArray(paramString, (WritableNativeArray)paramWritableArray);
    }
    while ((paramWritableArray == null) || ((paramWritableArray instanceof WritableNativeArray)) || (!FLog.isLoggable(6))) {
      return;
    }
    FLog.e("Exception", "Illegal type provided");
  }
  
  public native void putBoolean(String paramString, boolean paramBoolean);
  
  public native void putDouble(String paramString, double paramDouble);
  
  public native void putInt(String paramString, int paramInt);
  
  public void putMap(String paramString, WritableMap paramWritableMap)
  {
    if ((paramWritableMap != null) && ((paramWritableMap instanceof WritableNativeMap))) {
      putNativeMap(paramString, (WritableNativeMap)paramWritableMap);
    }
    while ((paramWritableMap == null) || ((paramWritableMap instanceof WritableNativeMap)) || (!FLog.isLoggable(6))) {
      return;
    }
    FLog.e("Exception", "Illegal type provided");
  }
  
  public native void putNull(String paramString);
  
  public native void putString(String paramString1, String paramString2);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\pre\binder\server\proxy\jni\WritableNativeMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */