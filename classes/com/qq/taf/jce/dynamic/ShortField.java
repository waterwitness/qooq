package com.qq.taf.jce.dynamic;

public final class ShortField
  extends NumberField
{
  private short data;
  
  ShortField(short paramShort, int paramInt)
  {
    super(paramInt);
    this.data = paramShort;
  }
  
  public short get()
  {
    return this.data;
  }
  
  public Number getNumber()
  {
    return Short.valueOf(this.data);
  }
  
  public void set(short paramShort)
  {
    this.data = paramShort;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\qq\taf\jce\dynamic\ShortField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */