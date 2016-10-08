package oicq.wlogin_sdk.b;

import oicq.wlogin_sdk.tools.util;

public class au
  extends a
{
  public au()
  {
    this.g = 339;
  }
  
  public byte[] b(int paramInt)
  {
    byte[] arrayOfByte = new byte[2];
    util.int16_to_buf(arrayOfByte, 0, paramInt);
    a(this.g);
    b(arrayOfByte, arrayOfByte.length);
    d();
    return a();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oicq\wlogin_sdk\b\au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */