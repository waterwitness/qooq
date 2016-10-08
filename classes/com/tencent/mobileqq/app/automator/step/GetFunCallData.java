package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vipav.VipFunCallManager;
import com.tencent.mobileqq.vipav.VipSetFunCallHandler;
import com.tencent.qphone.base.util.QLog;

public class GetFunCallData
  extends AsyncStep
{
  public GetFunCallData()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected int a()
  {
    long l = VipFunCallManager.a(this.a.b, 1, null).getLong("update_time", 0L);
    if ((System.currentTimeMillis() - l > 14400000L) || (System.currentTimeMillis() < l)) {
      ((VipSetFunCallHandler)this.a.b.a(46)).a(1, new Bundle());
    }
    for (;;)
    {
      return 7;
      if (QLog.isColorLevel()) {
        QLog.d("GetFunCallData", 2, "doStep system time" + System.currentTimeMillis() + ",last update time:" + l);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\automator\step\GetFunCallData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */