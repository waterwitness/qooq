package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import qjp;

public class GetTbsSwitchInfo
  extends AsyncStep
{
  public GetTbsSwitchInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected int a()
  {
    ThreadManager.a(new qjp(this), 8, null, false);
    return 7;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\automator\step\GetTbsSwitchInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */