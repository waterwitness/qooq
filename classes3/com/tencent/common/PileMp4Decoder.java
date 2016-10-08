package com.tencent.common;

public class PileMp4Decoder
{
  private int mHandler;
  
  static
  {
    System.loadLibrary("getframe");
  }
  
  public PileMp4Decoder(String paramString)
  {
    this.mHandler = initDecoder(paramString);
  }
  
  public static native int getFrameFromPileMp4(int paramInt, byte[] paramArrayOfByte);
  
  public static native int initDecoder(String paramString);
  
  public static native int releaseDecoder(int paramInt);
  
  public int getFrame(byte[] paramArrayOfByte)
  {
    return getFrameFromPileMp4(this.mHandler, paramArrayOfByte);
  }
  
  public void release()
  {
    releaseDecoder(this.mHandler);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\common\PileMp4Decoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */