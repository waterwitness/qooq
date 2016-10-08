package com.tencent.mobileqq.app;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class QWalletAuthObserver
  implements BusinessObserver
{
  private Handler a;
  
  public QWalletAuthObserver(Handler paramHandler)
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
    int i = 1;
    if (this.a == null) {}
    while ((paramInt != 1) && (paramInt != 4)) {
      return;
    }
    Handler localHandler = this.a;
    if (paramBoolean) {}
    for (;;)
    {
      localHandler.obtainMessage(paramInt, i, 0, paramObject).sendToTarget();
      return;
      i = 0;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\QWalletAuthObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */