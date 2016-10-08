package com.tencent.mobileqq.app.automator;

import android.util.Log;
import com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.asyncdb.CacheManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class InitBeforeSyncMsg
  extends AsyncStep
{
  public InitBeforeSyncMsg()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected int a()
  {
    long l1 = System.currentTimeMillis();
    Object localObject;
    if (this.h == 14)
    {
      this.a.b.a(this.a.b.a());
      this.a.b.getManager(59);
      this.a.b.a().b();
      this.a.b.a().a();
      localObject = (EcshopReportHandler)this.a.b.a(88);
      this.a.b.a(((EcshopReportHandler)localObject).a, true);
      localObject = this.a.b.a();
      if (this.h != 15) {
        break label228;
      }
    }
    label228:
    for (int i = 2;; i = 1)
    {
      ((MessageHandler)localObject).a(i);
      if (this.h != 15)
      {
        this.a.b.a().a();
        this.a.b.a().c = false;
      }
      long l2 = System.currentTimeMillis();
      Log.i("AutoMonitor", "STEP_DOSOMETHING, cost=" + (l2 - l1));
      return 7;
      if (this.h != 15) {
        break;
      }
      this.a.b.a().e();
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\automator\InitBeforeSyncMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */