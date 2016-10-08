package com.tencent.bugly.proguard;

import java.nio.ByteBuffer;

public final class k
{
  static
  {
    byte[] arrayOfByte1 = new byte[16];
    arrayOfByte1[0] = 48;
    arrayOfByte1[1] = 49;
    arrayOfByte1[2] = 50;
    arrayOfByte1[3] = 51;
    arrayOfByte1[4] = 52;
    arrayOfByte1[5] = 53;
    arrayOfByte1[6] = 54;
    arrayOfByte1[7] = 55;
    arrayOfByte1[8] = 56;
    arrayOfByte1[9] = 57;
    arrayOfByte1[10] = 65;
    arrayOfByte1[11] = 66;
    arrayOfByte1[12] = 67;
    arrayOfByte1[13] = 68;
    arrayOfByte1[14] = 69;
    arrayOfByte1[15] = 70;
    arrayOfByte1;
    byte[] arrayOfByte2 = new byte['Ā'];
    byte[] arrayOfByte3 = new byte['Ā'];
    int i = 0;
    while (i < 256)
    {
      arrayOfByte2[i] = arrayOfByte1[(i >>> 4)];
      arrayOfByte3[i] = arrayOfByte1[(i & 0xF)];
      i += 1;
    }
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    return paramInt1 == paramInt2;
  }
  
  public static boolean a(long paramLong1, long paramLong2)
  {
    return paramLong1 == paramLong2;
  }
  
  public static boolean a(Object paramObject1, Object paramObject2)
  {
    return paramObject1.equals(paramObject2);
  }
  
  public static boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    return paramBoolean1 == paramBoolean2;
  }
  
  public static byte[] a(ByteBuffer paramByteBuffer)
  {
    byte[] arrayOfByte = new byte[paramByteBuffer.position()];
    System.arraycopy(paramByteBuffer.array(), 0, arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\bugly\proguard\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */