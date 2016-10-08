package com.tencent.mobileqq.app;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class QWalletOpenObserver
  implements BusinessObserver
{
  private Handler a;
  
  public QWalletOpenObserver(Handler paramHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramHandler;
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (this.a == null) {}
    while ((paramInt != 3) && (paramInt != 4)) {
      return;
    }
    Handler localHandler = this.a;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localHandler.obtainMessage(paramInt, i, 0, paramObject).sendToTarget();
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\QWalletOpenObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */