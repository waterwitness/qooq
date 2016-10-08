package com.fasterxml.jackson.core.sym;

public final class NameN
  extends Name
{
  final int mQuadLen;
  final int[] mQuads;
  
  NameN(String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    super(paramString, paramInt1);
    if (paramInt2 < 3) {
      throw new IllegalArgumentException("Qlen must >= 3");
    }
    this.mQuads = paramArrayOfInt;
    this.mQuadLen = paramInt2;
  }
  
  public boolean equals(int paramInt)
  {
    return false;
  }
  
  public boolean equals(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public boolean equals(int[] paramArrayOfInt, int paramInt)
  {
    if (paramInt != this.mQuadLen) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramInt) {
        return true;
      }
      if (paramArrayOfInt[i] != this.mQuads[i]) {
        break;
      }
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\fasterxml\jackson\core\sym\NameN.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */