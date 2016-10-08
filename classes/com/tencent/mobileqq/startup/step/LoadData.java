package com.tencent.mobileqq.startup.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.startup.director.StartupDirector;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;

public class LoadData
  extends Step
{
  protected boolean a()
  {
    AppActivity localAppActivity = this.a.a;
    long l = System.currentTimeMillis();
    if (localAppActivity != null)
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.a.waitAppRuntime(null);
      if (this.L == 17) {}
      for (boolean bool = true; (localAppActivity.preloadData(localAppRuntime, bool)) && (System.currentTimeMillis() - l < 550L); bool = false) {
        return true;
      }
      return false;
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\startup\step\LoadData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */