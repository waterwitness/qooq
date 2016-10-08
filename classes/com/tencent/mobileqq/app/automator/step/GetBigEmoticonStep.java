package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import qjc;

public class GetBigEmoticonStep
  extends AsyncStep
{
  public GetBigEmoticonStep()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GetBigEmoticonStep", 2, "doStep begins");
    }
    ThreadManager.a(new qjc(this), 5, null, false);
    return 7;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\automator\step\GetBigEmoticonStep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */