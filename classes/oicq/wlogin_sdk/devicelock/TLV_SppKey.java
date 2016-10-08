package oicq.wlogin_sdk.devicelock;

public class TLV_SppKey
  extends e
{
  public byte[] SppKey = new byte[0];
  
  public TLV_SppKey()
  {
    this._type = 11;
  }
  
  public void parse()
  {
    this.SppKey = get_data();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oicq\wlogin_sdk\devicelock\TLV_SppKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */