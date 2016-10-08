package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.qphone.base.util.QLog;

public class getLocalRedtouchStep
  extends AsyncStep
{
  public getLocalRedtouchStep()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected int a()
  {
    if (QLog.isColorLevel()) {
      QLog.i(LocalRedTouchManager.a, 2, "reconnect pullRedTouchs");
    }
    ((LocalRedTouchManager)this.a.b.getManager(159)).c();
    return 7;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\automator\step\getLocalRedtouchStep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */