import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.report.QzoneOnlineTimeCollectRptService;
import mqq.os.MqqHandler;

public class yoy
  implements Runnable
{
  public yoy(QzoneOnlineTimeCollectRptService paramQzoneOnlineTimeCollectRptService)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QLog.d(QzoneOnlineTimeCollectRptService.a(), 1, "closeTrace isForeground:" + QzoneOnlineTimeCollectRptService.a(this.a));
    if (QzoneOnlineTimeCollectRptService.a(this.a))
    {
      ThreadManager.b().removeCallbacks(QzoneOnlineTimeCollectRptService.a(this.a));
      this.a.c();
      QzoneOnlineTimeCollectRptService.b(this.a);
      LocalMultiProcConfig.b("key_sp_qzone_isforeground", false);
      QzoneOnlineTimeCollectRptService.a(this.a, false);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yoy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */