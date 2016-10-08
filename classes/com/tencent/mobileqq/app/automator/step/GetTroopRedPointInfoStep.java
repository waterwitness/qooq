package com.tencent.mobileqq.app.automator.step;

import com.tencent.biz.TroopRedpoint.TroopRedTouchHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class GetTroopRedPointInfoStep
  extends AsyncStep
{
  public GetTroopRedPointInfoStep()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected int a()
  {
    ((TroopRedTouchHandler)this.a.b.a(43)).a();
    return 7;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\automator\step\GetTroopRedPointInfoStep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */