import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.QzoneOnlineTimeCollectRptService;
import mqq.os.MqqHandler;

public class yoz
  implements Runnable
{
  public yoz(QzoneOnlineTimeCollectRptService paramQzoneOnlineTimeCollectRptService)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ThreadManager.b().removeCallbacks(QzoneOnlineTimeCollectRptService.a(this.a));
    if (QLog.isColorLevel()) {
      QLog.d(QzoneOnlineTimeCollectRptService.a(), 2, "mOnlineTimeCheckTraceRunnable run");
    }
    this.a.d();
    ThreadManager.b().postDelayed(this, QzoneOnlineTimeCollectRptService.a(this.a));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yoz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */