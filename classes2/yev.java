import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qlink.QlinkReliableReport;
import java.util.TimerTask;

public class yev
  extends TimerTask
{
  public yev(QlinkReliableReport paramQlinkReliableReport)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QLog.d("QlinkReliableReport", 2, "doStopReportTimer :  on timer");
    QlinkReliableReport.a(this.a, null);
    QlinkReliableReport.g();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yev.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */