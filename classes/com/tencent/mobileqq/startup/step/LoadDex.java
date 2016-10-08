package com.tencent.mobileqq.startup.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.InjectUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadRegulator;
import mqq.os.MqqHandler;

public class LoadDex
  extends Step
{
  protected boolean a()
  {
    if ((BaseApplicationImpl.i == 4) || ("Success".equals(BaseApplicationImpl.sInjectResult))) {}
    label78:
    label83:
    do
    {
      return true;
      boolean bool1;
      if (this.L == 1)
      {
        bool1 = true;
        BaseApplicationImpl.sInjectResult = InjectUtils.b(BaseApplicationImpl.a, bool1);
        if (bool1) {
          if (BaseApplicationImpl.sInjectResult != null) {
            break label78;
          }
        }
      }
      for (boolean bool2 = true;; bool2 = false)
      {
        BaseApplicationImpl.c = bool2;
        if ((bool1) || ("Success".equals(BaseApplicationImpl.sInjectResult))) {
          break label83;
        }
        return false;
        bool1 = false;
        break;
      }
    } while (!"Success".equals(BaseApplicationImpl.sInjectResult));
    try
    {
      ThreadRegulator.a().a();
      Step.AmStepFactory.a();
      if (2 != BaseApplicationImpl.i) {
        ThreadManager.b().postDelayed(Step.AmStepFactory.b(12, this.a, null), 3000L);
      }
      if (1 == BaseApplicationImpl.i) {
        Step.AmStepFactory.b(14, this.a, null).c();
      }
      Step.QIPCConnectStep.a();
      return true;
    }
    catch (Exception localException) {}
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\startup\step\LoadDex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */