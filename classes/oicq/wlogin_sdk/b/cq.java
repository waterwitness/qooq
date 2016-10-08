package oicq.wlogin_sdk.b;

import oicq.wlogin_sdk.tools.util;

public class cq
  extends a
{
  int h = 0;
  
  public cq()
  {
    this.g = 8;
  }
  
  public byte[] a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.h = 8;
    byte[] arrayOfByte = new byte[this.h];
    util.int16_to_buf(arrayOfByte, 0, paramInt1);
    util.int32_to_buf(arrayOfByte, 2, paramInt2);
    util.int16_to_buf(arrayOfByte, 6, paramInt3);
    a(this.g);
    b(arrayOfByte, this.h);
    d();
    return a();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oicq\wlogin_sdk\b\cq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */