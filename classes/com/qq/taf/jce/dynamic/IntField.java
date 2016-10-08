package com.qq.taf.jce.dynamic;

public class IntField
  extends NumberField
{
  private int data;
  
  IntField(int paramInt1, int paramInt2)
  {
    super(paramInt2);
    this.data = paramInt1;
  }
  
  public int get()
  {
    return this.data;
  }
  
  public Number getNumber()
  {
    return Integer.valueOf(this.data);
  }
  
  public void set(int paramInt)
  {
    this.data = paramInt;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\qq\taf\jce\dynamic\IntField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */