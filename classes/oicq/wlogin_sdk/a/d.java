package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public class d
  extends a
{
  public d()
  {
    this.b = 3;
  }
  
  public byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    paramArrayOfByte2 = a(paramArrayOfByte1, paramArrayOfByte2);
    this.d = (paramArrayOfByte1.length + 1 + 1 + paramArrayOfByte2.length);
    byte[] arrayOfByte = new byte[this.d];
    util.int8_to_buf(arrayOfByte, 0, paramArrayOfByte1.length);
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 1, paramArrayOfByte1.length);
    int i = paramArrayOfByte1.length + 1;
    util.int8_to_buf(arrayOfByte, i, paramArrayOfByte2.length);
    i += 1;
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, i, paramArrayOfByte2.length);
    i = paramArrayOfByte2.length;
    return a(arrayOfByte);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oicq\wlogin_sdk\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */