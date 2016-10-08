package com.tencent.mobileqq.startup.step;

import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;

public class LoadAIOBg
  extends Step
{
  protected boolean a()
  {
    try
    {
      com.tencent.mobileqq.app.BaseActivity.sAIOBgCache = BaseApplicationImpl.a.getResources().getDrawable(2130838119);
      return true;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\startup\step\LoadAIOBg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */