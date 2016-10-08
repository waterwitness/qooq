package com.qq.taf.jce.dynamic;

public final class ByteField
  extends NumberField
{
  private byte data;
  
  ByteField(byte paramByte, int paramInt)
  {
    super(paramInt);
    this.data = paramByte;
  }
  
  public byte get()
  {
    return this.data;
  }
  
  public Number getNumber()
  {
    return Byte.valueOf(this.data);
  }
  
  public void set(byte paramByte)
  {
    this.data = paramByte;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\qq\taf\jce\dynamic\ByteField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */