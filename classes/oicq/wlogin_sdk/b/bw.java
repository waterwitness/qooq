package oicq.wlogin_sdk.b;

import oicq.wlogin_sdk.tools.util;

public class bw
  extends a
{
  private int h;
  
  public bw()
  {
    this.g = 390;
  }
  
  public Boolean e()
  {
    if (this.e < 2) {
      return Boolean.valueOf(false);
    }
    this.h = util.buf_to_int8(this.f, this.d + 1);
    return Boolean.valueOf(true);
  }
  
  public boolean f()
  {
    return this.h == 1;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oicq\wlogin_sdk\b\bw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */