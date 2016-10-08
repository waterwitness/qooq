package com.tencent.maxvideo.activity;

public class CoverNative
{
  public static native void closeFile(long paramLong);
  
  public static native boolean getFrameYuv(long paramLong, String paramString, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3);
  
  public static native int getVfFrameCount(long paramLong);
  
  public static native long openFile(String paramString);
  
  public static native int[] testTran();
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\maxvideo\activity\CoverNative.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */