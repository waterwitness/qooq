package oicq.wlogin_sdk.b;

import oicq.wlogin_sdk.tools.util;

public class bm
  extends a
{
  public bm()
  {
    this.g = 378;
  }
  
  public byte[] a(long paramLong)
  {
    byte[] arrayOfByte = new byte[4];
    util.int64_to_buf32(arrayOfByte, 0, paramLong);
    a(this.g);
    b(arrayOfByte, 4);
    d();
    return a();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oicq\wlogin_sdk\b\bm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */