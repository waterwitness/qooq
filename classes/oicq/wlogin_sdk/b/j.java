package oicq.wlogin_sdk.b;

public class j
  extends a
{
  int h = 0;
  
  public j()
  {
    this.g = 264;
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      arrayOfByte = new byte[0];
    }
    this.h = arrayOfByte.length;
    paramArrayOfByte = new byte[this.h];
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte, 0, arrayOfByte.length);
    a(this.g);
    b(paramArrayOfByte, this.h);
    d();
    return a();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oicq\wlogin_sdk\b\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */