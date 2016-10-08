package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mqp.app.sec.d;

public class SecDetectInit
  extends AsyncStep
{
  public SecDetectInit()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected int a()
  {
    try
    {
      d.e(1, d.x(), null);
      return 7;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\automator\step\SecDetectInit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */