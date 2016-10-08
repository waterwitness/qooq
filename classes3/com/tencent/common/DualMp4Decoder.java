package com.tencent.common;

public class DualMp4Decoder
{
  private long mHandler;
  
  static
  {
    System.loadLibrary("ijkffmpeg");
    System.loadLibrary("getframe");
  }
  
  public DualMp4Decoder(String paramString1, String paramString2)
  {
    this.mHandler = initDecoder(paramString1, paramString2);
  }
  
  public static native int getFrameAtTime(long paramLong, byte[] paramArrayOfByte, int paramInt);
  
  public static native int getFrameFromDualMp4(long paramLong, byte[] paramArrayOfByte);
  
  public static native long initDecoder(String paramString1, String paramString2);
  
  public static native int releaseDecoder(long paramLong);
  
  public int getFrame(byte[] paramArrayOfByte)
  {
    return getFrameFromDualMp4(this.mHandler, paramArrayOfByte);
  }
  
  public int getFrameAtTime(byte[] paramArrayOfByte, int paramInt)
  {
    return getFrameAtTime(this.mHandler, paramArrayOfByte, paramInt);
  }
  
  public void release()
  {
    releaseDecoder(this.mHandler);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\common\DualMp4Decoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */