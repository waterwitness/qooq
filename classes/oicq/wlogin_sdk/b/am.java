package oicq.wlogin_sdk.b;

public class am
  extends a
{
  public int h = 0;
  
  public am()
  {
    this.g = 323;
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    this.h = paramArrayOfByte.length;
    byte[] arrayOfByte = new byte[this.h];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    a(this.g);
    b(arrayOfByte, this.h);
    d();
    return a();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oicq\wlogin_sdk\b\am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */