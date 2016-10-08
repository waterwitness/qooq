package oicq.wlogin_sdk.b;

import oicq.wlogin_sdk.tools.util;

public class ae
  extends a
{
  int h = 0;
  int i = 0;
  
  public ae()
  {
    this.g = 295;
  }
  
  public byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.h = (paramArrayOfByte1.length + 4 + 2 + paramArrayOfByte2.length);
    byte[] arrayOfByte = new byte[this.h];
    util.int16_to_buf(arrayOfByte, 0, this.i);
    util.int16_to_buf(arrayOfByte, 2, paramArrayOfByte1.length);
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 4, paramArrayOfByte1.length);
    int j = paramArrayOfByte1.length + 4;
    util.int16_to_buf(arrayOfByte, j, paramArrayOfByte2.length);
    j += 2;
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, j, paramArrayOfByte2.length);
    j = paramArrayOfByte2.length;
    a(this.g);
    b(arrayOfByte, arrayOfByte.length);
    d();
    return a();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oicq\wlogin_sdk\b\ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */