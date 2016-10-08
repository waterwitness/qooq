package com.tencent.qphone.base.util;

public class Cryptor
{
  b impl = new b();
  
  public byte[] decrypt(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    return this.impl.a(paramArrayOfByte1, paramInt1, paramInt2, paramArrayOfByte2);
  }
  
  public byte[] decrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return this.impl.a(paramArrayOfByte1, paramArrayOfByte2);
  }
  
  public void enableResultRandom(boolean paramBoolean)
  {
    this.impl.a(paramBoolean);
  }
  
  public byte[] encrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return this.impl.b(paramArrayOfByte1, paramArrayOfByte2);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\qphone\base\util\Cryptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */