package com.tencent.mobileqq.startup.step;

import com.tencent.mobileqq.app.ThreadManager;

public class PreInitValues
  extends Step
{
  protected boolean a()
  {
    ThreadManager.a(new NewRuntime(), null, false);
    ThreadManager.a(new InitDPC(), null, false);
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\startup\step\PreInitValues.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */