package com.tencent.mobileqq.startup.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.StepFactory;

public class StartServiceLiteCmp
  extends Step
{
  protected boolean a()
  {
    Object localObject = BaseApplicationImpl.a.a();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      if (((QQAppInterface)localObject).e()) {
        ((QQAppInterface)localObject).a.a(StepFactory.a(((QQAppInterface)localObject).a, "{{4,3,5,6},41,42,[76,62,25,10,26,27,28,29,30,32,34,35,37,38,39,40,44,45,47,52,66,90,67,68,69,70,{88,48},50,51,58,60,74,78,64,77,71,84,85,75,79,81,83],54}"));
      }
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\startup\step\StartServiceLiteCmp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */