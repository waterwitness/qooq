package com.tencent.mobileqq.shortvideo.util;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class FastYUVToRGBA
{
  public static final int a = 1;
  public static final int b = 2;
  
  public FastYUVToRGBA()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      paramInt1 = yuvToRgba(paramArrayOfByte1, paramArrayOfByte2, paramInt1, paramInt2, paramInt3);
      return paramInt1;
    }
    catch (UnsatisfiedLinkError paramArrayOfByte1) {}
    return -1;
  }
  
  private static native int yuvToRgba(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\util\FastYUVToRGBA.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */