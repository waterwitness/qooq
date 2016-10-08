package com.tencent.mobileqq.app.automator;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class LinearGroup
  extends StepGroup
{
  public LinearGroup()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected int a()
  {
    while (this.g != 8)
    {
      AsyncStep localAsyncStep = a();
      if (localAsyncStep == null) {
        break;
      }
      localAsyncStep.run();
    }
    return 7;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\automator\LinearGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */