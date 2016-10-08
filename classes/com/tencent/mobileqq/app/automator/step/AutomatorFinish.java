package com.tencent.mobileqq.app.automator.step;

import android.util.Log;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadOptimizer;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.HashMap;

public class AutomatorFinish
  extends AsyncStep
{
  public AutomatorFinish()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected int a()
  {
    long l = System.currentTimeMillis() - this.a.a;
    this.a.a = 0L;
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_threadOpId", String.valueOf(ThreadOptimizer.a().a()));
    StatisticCollector.a(this.a.b.a()).a(null, "actQQInit", true, l, this.a.e, localHashMap, null);
    Log.i("AutoMonitor", "QQInitialize, cost=" + l + ", totalFailCount=" + this.a.e);
    return 7;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\automator\step\AutomatorFinish.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */