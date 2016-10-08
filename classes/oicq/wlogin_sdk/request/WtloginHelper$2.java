package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.tools.RSACrypt;

class WtloginHelper$2
  extends Thread
{
  WtloginHelper$2(WtloginHelper paramWtloginHelper, String paramString)
  {
    super(paramString);
  }
  
  public void run()
  {
    new RSACrypt(WtloginHelper.access$000(this.this$0)).GenRSAKey();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oicq\wlogin_sdk\request\WtloginHelper$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */