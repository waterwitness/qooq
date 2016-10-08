package com.qq.taf.jce.dynamic;

public class LongField
  extends NumberField
{
  private long data;
  
  LongField(long paramLong, int paramInt)
  {
    super(paramInt);
    this.data = paramLong;
  }
  
  public long get()
  {
    return this.data;
  }
  
  public Number getNumber()
  {
    return Long.valueOf(this.data);
  }
  
  public void set(long paramLong)
  {
    this.data = paramLong;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\qq\taf\jce\dynamic\LongField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */