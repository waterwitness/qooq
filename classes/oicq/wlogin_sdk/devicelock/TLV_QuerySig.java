package oicq.wlogin_sdk.devicelock;

public class TLV_QuerySig
  extends e
{
  public byte[] QuerySig = new byte[0];
  
  public TLV_QuerySig()
  {
    this._type = 8;
  }
  
  public void parse()
  {
    this.QuerySig = get_data();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oicq\wlogin_sdk\devicelock\TLV_QuerySig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */