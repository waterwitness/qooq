package com.qq.taf.jce.dynamic;

public class FloatField
  extends NumberField
{
  private float data;
  
  FloatField(float paramFloat, int paramInt)
  {
    super(paramInt);
    this.data = paramFloat;
  }
  
  public float get()
  {
    return this.data;
  }
  
  public Number getNumber()
  {
    return Float.valueOf(this.data);
  }
  
  public void set(float paramFloat)
  {
    this.data = paramFloat;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\qq\taf\jce\dynamic\FloatField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */