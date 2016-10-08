package oicq.wlogin_sdk.b;

import oicq.wlogin_sdk.tools.util;

public class bl
  extends a
{
  public int h = 0;
  
  public bl()
  {
    this.g = 377;
  }
  
  public Boolean e()
  {
    if (this.e < 2) {
      return Boolean.valueOf(false);
    }
    int i = util.buf_to_int16(this.f, this.d);
    if (this.e < i + 2) {
      return Boolean.valueOf(false);
    }
    this.h = i;
    return Boolean.valueOf(true);
  }
  
  public byte[] f()
  {
    byte[] arrayOfByte = new byte[this.h];
    System.arraycopy(this.f, this.d + 2, arrayOfByte, 0, this.h);
    return arrayOfByte;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oicq\wlogin_sdk\b\bl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */