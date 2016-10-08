package oicq.wlogin_sdk.request;

class WtloginHelper$HelperThread$9
  implements Runnable
{
  WtloginHelper$HelperThread$9(WtloginHelper.HelperThread paramHelperThread, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    WtloginHelper.HelperThread.access$500(this.this$1);
    if (this.val$cancel != 0) {
      return;
    }
    if (this.this$1.mReqContext.is_register_req())
    {
      WtloginHelper.access$1400(this.this$1.mHelper, this.this$1.mUserAccount, this.this$1.mDwAppid, this.this$1.mRole, this.this$1.mReqContext, this.this$1.mUserSigInfo, this.val$ret);
      return;
    }
    if (this.this$1.mReqContext.is_code2d_func_req())
    {
      WtloginHelper.access$1500(this.this$1.mHelper, this.this$1.mUserAccount, this.this$1.mDwAppid, this.this$1.mRole, this.this$1.mReqContext, this.this$1.mUserSigInfo, this.val$ret);
      return;
    }
    if (this.this$1.mReqContext.is_devlock_req())
    {
      WtloginHelper.access$1600(this.this$1.mHelper, this.this$1.mUserAccount, this.this$1.mDwAppid, this.this$1.mRole, this.this$1.mReqContext, this.this$1.mUserSigInfo, this.val$ret);
      return;
    }
    WtloginHelper.access$100(this.this$1.mHelper).OnRequestTransport(this.this$1.mUserAccount, this.this$1.mDwAppid, this.this$1.mRole, this.this$1.mReqContext, this.this$1.mUserSigInfo, this.val$ret);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oicq\wlogin_sdk\request\WtloginHelper$HelperThread$9.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */