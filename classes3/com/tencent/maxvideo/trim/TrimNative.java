package com.tencent.maxvideo.trim;

import android.graphics.Bitmap;

public class TrimNative
{
  public static native int detect(String paramString);
  
  public static native int getFrame(long paramLong1, long paramLong2, Bitmap paramBitmap);
  
  public static native String getRealProperties(String paramString, int paramInt);
  
  public static native int getThumbnail(long paramLong1, long paramLong2, Bitmap paramBitmap);
  
  public static native int initGetFrame(String paramString, int paramInt1, int paramInt2);
  
  public static native boolean isGetFrameReady();
  
  public static native boolean isGetThumbnailReady();
  
  public static native int prepare(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
  
  public static native void release();
  
  public static native int trim(String[] paramArrayOfString);
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\maxvideo\trim\TrimNative.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */