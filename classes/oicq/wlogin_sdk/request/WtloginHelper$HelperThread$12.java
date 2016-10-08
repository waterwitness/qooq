package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.tools.ErrMsg;

class WtloginHelper$HelperThread$12
  implements Runnable
{
  WtloginHelper$HelperThread$12(WtloginHelper.HelperThread paramHelperThread, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    WtloginHelper.HelperThread.access$500(this.this$1);
    if (this.val$cancel != 0) {
      return;
    }
    ErrMsg localErrMsg = t.b(this.this$1.mUserSigInfo._seqence)._last_err_msg;
    WtloginHelper.access$100(this.this$1.mHelper).OnVerifySMSVerifyLoginCode(this.this$1.mUserAccount, this.this$1.mMsgCode, this.this$1.mUserSigInfo, this.val$ret, localErrMsg);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oicq\wlogin_sdk\request\WtloginHelper$HelperThread$12.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */