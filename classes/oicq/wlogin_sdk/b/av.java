package oicq.wlogin_sdk.b;

import oicq.wlogin_sdk.tools.util;

public class av
  extends a
{
  public av()
  {
    this.g = 340;
  }
  
  public byte[] b(int paramInt)
  {
    byte[] arrayOfByte = new byte[4];
    util.int32_to_buf(arrayOfByte, 0, paramInt);
    a(this.g);
    b(arrayOfByte, arrayOfByte.length);
    d();
    return a();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oicq\wlogin_sdk\b\av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */