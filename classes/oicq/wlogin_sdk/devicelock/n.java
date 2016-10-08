package oicq.wlogin_sdk.devicelock;

public class n
  extends e
{
  public n()
  {
    this._type = 7;
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return new byte[0];
    }
    byte[] arrayOfByte = new byte[paramArrayOfByte.length + 2];
    fill_head();
    fill_body(arrayOfByte, arrayOfByte.length);
    put_block(paramArrayOfByte, this._head_len);
    return get_buf();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oicq\wlogin_sdk\devicelock\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */