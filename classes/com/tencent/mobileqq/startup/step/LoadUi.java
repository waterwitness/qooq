package com.tencent.mobileqq.startup.step;

import com.tencent.mobileqq.startup.director.StartupDirector;
import mqq.app.AppActivity;

public class LoadUi
  extends Step
{
  protected boolean a()
  {
    AppActivity localAppActivity = this.a.a;
    if (localAppActivity != null) {
      localAppActivity.preloadUi();
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\startup\step\LoadUi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */