package com.tencent.mobileqq.util;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class EndianUtil
{
  public EndianUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(byte paramByte)
  {
    return paramByte & 0xFF;
  }
  
  public static int a(byte[] paramArrayOfByte)
  {
    int i = 0;
    int j = 0;
    while (i < 4)
    {
      j = j << 8 | a(paramArrayOfByte[i]);
      i += 1;
    }
    return j;
  }
  
  public static int a(byte[] paramArrayOfByte, int paramInt)
  {
    int j = 0;
    int i = paramInt;
    while (i < paramInt + 4)
    {
      j = j << 8 | a(paramArrayOfByte[i]);
      i += 1;
    }
    return j;
  }
  
  public static short a(byte[] paramArrayOfByte)
  {
    int i = 0;
    short s = 0;
    while (i < 2)
    {
      s = (short)((short)(s << 8) | a(paramArrayOfByte[i]));
      i += 1;
    }
    return s;
  }
  
  public static byte[] a(int paramInt)
  {
    byte[] arrayOfByte = new byte[4];
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < 4)
    {
      arrayOfByte[paramInt] = Integer.valueOf(i >>> 24).byteValue();
      i <<= 8;
      paramInt += 1;
    }
    return arrayOfByte;
  }
  
  public static byte[] a(long paramLong)
  {
    byte[] arrayOfByte = new byte[4];
    int i = 0;
    while (i < 4)
    {
      arrayOfByte[i] = Long.valueOf(paramLong >>> 24).byteValue();
      paramLong <<= 8;
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static byte[] a(short paramShort)
  {
    return new byte[] { (byte)(paramShort >>> 8), (byte)paramShort };
  }
  
  public static byte[] b(int paramInt)
  {
    int i = (byte)(paramInt & 0xFF);
    int j = (byte)((0xFF00 & paramInt) >> 8);
    int k = (byte)((0xFF0000 & paramInt) >> 16);
    return new byte[] { (byte)((0xFF000000 & paramInt) >> 24), k, j, i };
  }
  
  public static byte[] b(long paramLong)
  {
    byte[] arrayOfByte = new byte[8];
    int i = 0;
    while (i < 8)
    {
      arrayOfByte[i] = Integer.valueOf((int)(paramLong >>> 56)).byteValue();
      paramLong <<= 8;
      i += 1;
    }
    return arrayOfByte;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\util\EndianUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */