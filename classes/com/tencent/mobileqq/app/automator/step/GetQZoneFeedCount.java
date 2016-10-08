package com.tencent.mobileqq.app.automator.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.QZoneManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;

public class GetQZoneFeedCount
  extends AsyncStep
{
  private static final String c = GetQZoneFeedCount.class.getSimpleName();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected int a()
  {
    QZoneManager localQZoneManager;
    if ((this.a != null) && (this.a.b != null))
    {
      if (BaseApplicationImpl.c) {
        QZoneHelper.a(this.a.b, c);
      }
      localQZoneManager = (QZoneManager)this.a.b.getManager(9);
      if (localQZoneManager != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(c, 2, "GetQZoneFeedCount isFirstGetUnread:" + localQZoneManager.a() + ",isBackground_Pause:" + this.a.b.isBackground_Pause);
        }
        if (!localQZoneManager.a()) {
          break label140;
        }
        localQZoneManager.a(this.a.b.getAccount(), null);
      }
    }
    for (;;)
    {
      return 7;
      label140:
      if (this.a.b.isBackground_Pause) {
        localQZoneManager.c(6);
      } else {
        localQZoneManager.b(5);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\automator\step\GetQZoneFeedCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */