package oicq.wlogin_sdk.b;

public class be
  extends a
{
  int h = 0;
  
  public be()
  {
    this.g = 366;
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    int i = 64;
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      arrayOfByte = new byte[0];
    }
    if (arrayOfByte.length < 64) {
      i = arrayOfByte.length;
    }
    this.h = i;
    paramArrayOfByte = new byte[this.h];
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte, 0, this.h);
    a(this.g);
    b(paramArrayOfByte, this.h);
    d();
    return a();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oicq\wlogin_sdk\b\be.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */