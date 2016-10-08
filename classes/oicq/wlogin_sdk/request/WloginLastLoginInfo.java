package oicq.wlogin_sdk.request;

import java.io.Serializable;

public class WloginLastLoginInfo
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public String mAccount = new String();
  public long mUin = 0L;
  
  public WloginLastLoginInfo()
  {
    this.mAccount = "";
  }
  
  public WloginLastLoginInfo(String paramString, long paramLong)
  {
    this.mAccount = paramString;
    this.mUin = paramLong;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oicq\wlogin_sdk\request\WloginLastLoginInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */