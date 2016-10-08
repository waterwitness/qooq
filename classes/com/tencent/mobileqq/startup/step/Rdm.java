package com.tencent.mobileqq.startup.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.feedback.eup.CrashReport;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.log.ReportLog;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneCrashHandler;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;
import uub;
import uuc;

public class Rdm
  extends Step
{
  private static final ScheduledThreadPoolExecutor jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(3, new uub());
  private static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  
  protected boolean a()
  {
    String str2 = BaseApplicationImpl.processName;
    QLog.d("Rdm", 1, "doStep...process=" + str2 + ", sRdmState=" + jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
    if ((jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(0, 1)) && (!str2.endsWith(":MSF"))) {}
    for (;;)
    {
      try
      {
        Object localObject = BaseApplicationImpl.a.getAllAccounts();
        if (localObject == null) {
          break label214;
        }
        localObject = (SimpleAccount)((List)localObject).get(0);
        if (localObject != null)
        {
          localObject = ((SimpleAccount)localObject).getUin();
          if ((str2.equals("com.tencent.mobileqq")) || (str2.endsWith(":web")))
          {
            Thread.setDefaultUncaughtExceptionHandler(new ReportLog());
            CrashReport.setThreadPoolService(jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor);
            StatisticCollector.a(BaseApplicationImpl.a).c((String)localObject);
            if (!str2.endsWith(":openSdk")) {
              StatisticCollector.a(BaseApplicationImpl.a).a((String)localObject);
            }
            localObject = new uuc(this, str2);
            ThreadManager.b().postDelayed((Runnable)localObject, 10000L);
            return true;
          }
          if (!str2.endsWith(":qzone")) {
            continue;
          }
          Thread.setDefaultUncaughtExceptionHandler(new QZoneCrashHandler());
          continue;
        }
        str1 = "10000";
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return true;
      }
      continue;
      return true;
      label214:
      String str1 = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\startup\step\Rdm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */