package com.fasterxml.jackson.core.sym;

public final class Name1
  extends Name
{
  static final Name1 sEmptyName = new Name1("", 0, 0);
  final int mQuad;
  
  Name1(String paramString, int paramInt1, int paramInt2)
  {
    super(paramString, paramInt1);
    this.mQuad = paramInt2;
  }
  
  static Name1 getEmptyName()
  {
    return sEmptyName;
  }
  
  public boolean equals(int paramInt)
  {
    return paramInt == this.mQuad;
  }
  
  public boolean equals(int paramInt1, int paramInt2)
  {
    return (paramInt1 == this.mQuad) && (paramInt2 == 0);
  }
  
  public boolean equals(int[] paramArrayOfInt, int paramInt)
  {
    return (paramInt == 1) && (paramArrayOfInt[0] == this.mQuad);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\fasterxml\jackson\core\sym\Name1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */