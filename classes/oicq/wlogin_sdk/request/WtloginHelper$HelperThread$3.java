package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.b.g;
import oicq.wlogin_sdk.tools.ErrMsg;

class WtloginHelper$HelperThread$3
  implements Runnable
{
  WtloginHelper$HelperThread$3(WtloginHelper.HelperThread paramHelperThread, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    WtloginHelper.HelperThread.access$500(this.this$1);
    if (this.val$cancel != 0) {
      return;
    }
    async_context localasync_context = t.b(this.this$1.mUserSigInfo._seqence);
    ErrMsg localErrMsg = localasync_context._last_err_msg;
    this.this$1.mPictureData = localasync_context._t105.f();
    WtloginHelper.access$100(this.this$1.mHelper).OnRefreshPictureData(this.this$1.mUserAccount, this.this$1.mUserSigInfo, this.this$1.mPictureData, this.val$ret, localErrMsg);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oicq\wlogin_sdk\request\WtloginHelper$HelperThread$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */