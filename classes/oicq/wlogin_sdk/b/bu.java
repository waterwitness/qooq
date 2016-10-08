package oicq.wlogin_sdk.b;

import oicq.wlogin_sdk.tools.MD5;
import oicq.wlogin_sdk.tools.util;

public class bu
  extends a
{
  byte[] h = new byte[0];
  
  public bu()
  {
    this.g = 388;
  }
  
  public byte[] a(long paramLong, String paramString)
  {
    paramString = MD5.toMD5Byte(paramString);
    int i = paramString.length;
    byte[] arrayOfByte = new byte[i + 8];
    System.arraycopy(paramString, 0, arrayOfByte, 0, i);
    i = 0 + i;
    util.int64_to_buf(arrayOfByte, i, paramLong);
    paramString = MD5.toMD5Byte(arrayOfByte);
    a(this.g);
    b(paramString, paramString.length);
    d();
    return a();
  }
  
  public Boolean e()
  {
    if (this.e < 16) {
      return Boolean.valueOf(false);
    }
    this.h = new byte[16];
    System.arraycopy(this.f, this.d, this.h, 0, 16);
    return Boolean.valueOf(true);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oicq\wlogin_sdk\b\bu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */