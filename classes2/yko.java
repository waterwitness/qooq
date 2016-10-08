import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.QZoneClickReport.ReportRunnable;

public class yko
  implements Runnable
{
  public yko(QZoneClickReport.ReportRunnable paramReportRunnable)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ThreadManager.d(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yko.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */