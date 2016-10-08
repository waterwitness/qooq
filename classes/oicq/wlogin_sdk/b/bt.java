package oicq.wlogin_sdk.b;

import oicq.wlogin_sdk.tools.util;

public class bt
  extends a
{
  long h = 0L;
  
  public bt()
  {
    this.g = 387;
  }
  
  public Boolean e()
  {
    if (this.e < 8) {
      return Boolean.valueOf(false);
    }
    this.h = util.buf_to_int64(this.f, this.d);
    return Boolean.valueOf(true);
  }
  
  public long f()
  {
    return this.h;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oicq\wlogin_sdk\b\bt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */