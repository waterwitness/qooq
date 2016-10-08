package com.tencent.securitysdk.utils;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ZipShort
  implements Cloneable
{
  private int a;
  
  public ZipShort(int paramInt)
  {
    this.a = paramInt;
  }
  
  public ZipShort(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, 0);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ZipShort(byte[] paramArrayOfByte, int paramInt)
  {
    this.a = (paramArrayOfByte[(paramInt + 1)] << 8 & 0xFF00);
    this.a += (paramArrayOfByte[paramInt] & 0xFF);
  }
  
  public int a()
  {
    return this.a;
  }
  
  public byte[] a()
  {
    return new byte[] { (byte)(this.a & 0xFF), (byte)((this.a & 0xFF00) >> 8) };
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof ZipShort))) {}
    while (this.a != ((ZipShort)paramObject).a()) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    return this.a;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\securitysdk\utils\ZipShort.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */