import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadExcutor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import mqq.os.MqqHandler;

class qhj
  implements RejectedExecutionHandler
{
  private long a;
  
  public qhj()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = -1L;
  }
  
  public void rejectedExecution(Runnable paramRunnable, ThreadPoolExecutor paramThreadPoolExecutor)
  {
    if (QLog.isColorLevel()) {
      QLog.e("TM.global", 2, "rejectedExecution:" + paramRunnable.toString() + " " + paramThreadPoolExecutor.toString());
    }
    if (this.a == -1L) {
      this.a = SystemClock.uptimeMillis();
    }
    ThreadExcutor.e += 1;
    if ((SystemClock.uptimeMillis() - this.a < 1000L) && (ThreadExcutor.e > 10))
    {
      QLog.e("TM.global", 1, "rejectedExecution may undermine fluency:");
      ThreadExcutor.e = 0;
      this.a = -1L;
      StatisticCollector.a(BaseApplicationImpl.a()).a("", "sp_reject_exception_report", false, 0L, 0L, null, "", false);
    }
    for (;;)
    {
      qhi.a().post(paramRunnable);
      return;
      if (SystemClock.uptimeMillis() - this.a > 1000L)
      {
        ThreadExcutor.e = 0;
        this.a = -1L;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qhj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */