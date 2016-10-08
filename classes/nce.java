import com.tencent.mobileqq.activity.aio.AIOReporterGetDeviceInfo;
import com.tencent.mobileqq.activity.aio.AIOTimeReporter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class nce
  implements Runnable
{
  public nce(AIOTimeReporter paramAIOTimeReporter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    AIOReporterGetDeviceInfo localAIOReporterGetDeviceInfo = AIOReporterGetDeviceInfo.a();
    AIOTimeReporter.a(this.a, localAIOReporterGetDeviceInfo.a());
    if (StartupTracker.a <= 0L)
    {
      AIOTimeReporter.a(this.a);
      return;
    }
    String str = "";
    switch (AIOTimeReporter.a(this.a))
    {
    default: 
      return;
    case 1: 
      switch (localAIOReporterGetDeviceInfo.a)
      {
      }
      for (;;)
      {
        StatisticCollector.a(BaseApplication.getContext()).a(null, str, true, StartupTracker.a, 0L, null, "");
        if (QLog.isDevelopLevel()) {
          QLog.d(this.a.a, 4, "reportAIOTime: " + str + " cost : " + StartupTracker.a);
        }
        AIOTimeReporter.a(this.a);
        return;
        if (!AIOTimeReporter.a(this.a).equalsIgnoreCase("0"))
        {
          str = AIOTimeReporter.a();
        }
        else
        {
          str = AIOTimeReporter.b();
          continue;
          if (!AIOTimeReporter.a(this.a).equalsIgnoreCase("0")) {
            str = AIOTimeReporter.c();
          } else {
            str = AIOTimeReporter.d();
          }
        }
      }
    case 2: 
      switch (localAIOReporterGetDeviceInfo.a)
      {
      }
      for (;;)
      {
        break;
        if (!AIOTimeReporter.a(this.a).equalsIgnoreCase("0"))
        {
          str = AIOTimeReporter.e();
        }
        else
        {
          str = AIOTimeReporter.f();
          continue;
          if (!AIOTimeReporter.a(this.a).equalsIgnoreCase("0")) {
            str = AIOTimeReporter.g();
          } else {
            str = AIOTimeReporter.h();
          }
        }
      }
    }
    switch (localAIOReporterGetDeviceInfo.a)
    {
    }
    for (;;)
    {
      break;
      if (!AIOTimeReporter.a(this.a).equalsIgnoreCase("0"))
      {
        str = AIOTimeReporter.i();
      }
      else
      {
        str = AIOTimeReporter.j();
        continue;
        if (!AIOTimeReporter.a(this.a).equalsIgnoreCase("0")) {
          str = AIOTimeReporter.k();
        } else {
          str = AIOTimeReporter.l();
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */