package oicq.wlogin_sdk.b;

import oicq.wlogin_sdk.tools.util;

public class bn
  extends a
{
  public bn()
  {
    this.g = 379;
  }
  
  public Boolean e()
  {
    if (this.e < 4) {
      return Boolean.valueOf(false);
    }
    return Boolean.valueOf(true);
  }
  
  public int f()
  {
    if (this.e < 4) {
      return 0;
    }
    return util.buf_to_int16(this.f, this.d);
  }
  
  public int g()
  {
    if (this.e < 4) {
      return 0;
    }
    return util.buf_to_int16(this.f, this.d + 2);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oicq\wlogin_sdk\b\bn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */