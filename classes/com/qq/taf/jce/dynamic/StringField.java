package com.qq.taf.jce.dynamic;

public class StringField
  extends JceField
{
  private String data;
  
  StringField(String paramString, int paramInt)
  {
    super(paramInt);
    this.data = paramString;
  }
  
  public String get()
  {
    return this.data;
  }
  
  public void set(String paramString)
  {
    this.data = paramString;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\qq\taf\jce\dynamic\StringField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */