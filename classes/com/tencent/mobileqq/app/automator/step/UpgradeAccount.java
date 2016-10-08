package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class UpgradeAccount
  extends AsyncStep
{
  public UpgradeAccount(Automator paramAutomator, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramAutomator;
    this.h = paramInt;
  }
  
  protected int a()
  {
    return super.a();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\automator\step\UpgradeAccount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */