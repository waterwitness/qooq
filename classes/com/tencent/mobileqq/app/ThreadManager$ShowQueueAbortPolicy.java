package com.tencent.mobileqq.app;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadManager$ShowQueueAbortPolicy
  implements RejectedExecutionHandler
{
  public ThreadManager$ShowQueueAbortPolicy()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void rejectedExecution(Runnable paramRunnable, ThreadPoolExecutor paramThreadPoolExecutor)
  {
    QLog.e("TM.global", 1, "rejectedExecution:" + paramRunnable.toString() + " " + paramThreadPoolExecutor.toString());
    StatisticCollector.a(BaseApplicationImpl.a()).a("", "ap_reject_exception_report", false, 0L, 0L, null, "", false);
    paramRunnable = paramThreadPoolExecutor.getQueue();
    if ((paramRunnable != null) && (!paramRunnable.isEmpty())) {}
    try
    {
      paramRunnable = paramRunnable.iterator();
      while (paramRunnable.hasNext())
      {
        paramThreadPoolExecutor = (Runnable)paramRunnable.next();
        try
        {
          Field localField = paramThreadPoolExecutor.getClass().getDeclaredField("this$0");
          localField.setAccessible(true);
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("TM.global", 2, "Queue details." + localField.get(paramThreadPoolExecutor).getClass());
        }
        catch (NoSuchFieldException localNoSuchFieldException) {}
        if (QLog.isColorLevel()) {
          QLog.d("TM.global", 2, "Queue details." + paramThreadPoolExecutor.getClass());
        }
      }
      return;
    }
    catch (IllegalArgumentException paramRunnable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TM.global", 2, paramRunnable.getMessage());
      }
      return;
    }
    catch (IllegalAccessException paramRunnable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("TM.global", 2, paramRunnable.getMessage());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\ThreadManager$ShowQueueAbortPolicy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */