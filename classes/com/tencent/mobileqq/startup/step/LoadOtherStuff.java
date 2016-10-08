package com.tencent.mobileqq.startup.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;

public class LoadOtherStuff
  extends Step
{
  protected boolean a()
  {
    StatisticCollector.a(BaseApplicationImpl.getContext());
    BaseApplicationImpl.a().getSharedPreferences("UserGuide", 0);
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\startup\step\LoadOtherStuff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */