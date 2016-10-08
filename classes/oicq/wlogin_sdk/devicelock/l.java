package oicq.wlogin_sdk.devicelock;

public class l
  extends e
{
  public int a = 0;
  
  public l()
  {
    this._type = 5;
  }
  
  public byte[] a(long paramLong)
  {
    fill_head();
    fill_body(new byte[4], 4);
    put_int32(paramLong, this._head_len);
    return get_buf();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oicq\wlogin_sdk\devicelock\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */