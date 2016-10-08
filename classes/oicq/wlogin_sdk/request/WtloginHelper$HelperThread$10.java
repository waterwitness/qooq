package oicq.wlogin_sdk.request;

class WtloginHelper$HelperThread$10
  implements Runnable
{
  WtloginHelper$HelperThread$10(WtloginHelper.HelperThread paramHelperThread, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    WtloginHelper.HelperThread.access$500(this.this$1);
    if (this.val$cancel != 0) {
      return;
    }
    WtloginHelper.access$100(this.this$1.mHelper).OnRequestTransport(this.this$1.mUserAccount, this.this$1.mDwAppid, this.this$1.mRole, this.this$1.mReqContext, this.val$ret);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oicq\wlogin_sdk\request\WtloginHelper$HelperThread$10.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */