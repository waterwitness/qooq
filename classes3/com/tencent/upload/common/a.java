package com.tencent.upload.common;

import com.tencent.upload.a.b;

public final class a
{
  private int a = 0;
  private String b = "";
  
  public a(int paramInt, String paramString)
  {
    this.a = paramInt;
    this.b = paramString;
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null)) {
      return null;
    }
    try
    {
      byte[] arrayOfByte = new byte[paramArrayOfByte1.length];
      System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, paramArrayOfByte1.length);
      paramArrayOfByte1 = new e().a(arrayOfByte, paramArrayOfByte2);
      return paramArrayOfByte1;
    }
    catch (Exception paramArrayOfByte1)
    {
      b.d("Base.Convert", "TEA加密失败");
    }
    return null;
  }
  
  public final int a()
  {
    return this.a;
  }
  
  public final String b()
  {
    return this.b;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\common\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */