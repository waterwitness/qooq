package com.tencent.mobileqq.redtouch;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class RedTouchReciver
  extends ResultReceiver
{
  QQAppInterface a;
  
  public RedTouchReciver(QQAppInterface paramQQAppInterface, Handler paramHandler)
  {
    super(paramHandler);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramQQAppInterface;
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    BaseReq localBaseReq = BaseReq.a(paramBundle);
    if (localBaseReq != null) {
      localBaseReq.a(this.a, paramBundle);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\redtouch\RedTouchReciver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */