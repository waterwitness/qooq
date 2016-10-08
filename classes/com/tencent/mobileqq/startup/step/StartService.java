package com.tencent.mobileqq.startup.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.StepFactory;

public class StartService
  extends Step
{
  public static boolean a;
  
  protected boolean a()
  {
    Object localObject = null;
    if (a) {}
    do
    {
      return true;
      a = true;
      if (BaseApplicationImpl.i != 4)
      {
        BaseApplicationImpl.a.startService();
        localObject = BaseApplicationImpl.a.waitAppRuntime(null);
      }
    } while (BaseApplicationImpl.i != 1);
    QQAppInterface localQQAppInterface = (QQAppInterface)localObject;
    localQQAppInterface.onGuardEvent(6, 0L, 0L);
    if (localQQAppInterface.e())
    {
      Automator localAutomator1 = localQQAppInterface.a;
      Automator localAutomator2 = localQQAppInterface.a;
      if (this.L == 19) {}
      for (localObject = "{[11,12,14],17,20,21,22}";; localObject = "{82,{4,3,5,6},[11,12,14],17,20,21,56,57,22,41,42,[76,62,25,10,26,27,28,29,30,32,34,35,37,38,39,40,44,45,47,52,66,90,67,68,69,70,{88,48},50,51,58,60,74,78,64,77,71,84,85,75,79,81,83],54,92}")
      {
        localAutomator1.a(StepFactory.a(localAutomator2, (String)localObject));
        localQQAppInterface.start(false);
        return true;
      }
    }
    BaseApplicationImpl.c = 0L;
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\startup\step\StartService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */