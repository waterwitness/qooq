import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.report.QzoneOnlineTimeCollectRptService;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class yox
  implements Runnable
{
  public yox(QzoneOnlineTimeCollectRptService paramQzoneOnlineTimeCollectRptService)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QLog.d(QzoneOnlineTimeCollectRptService.a(), 1, "beginTrace isForeground:" + QzoneOnlineTimeCollectRptService.a(this.a));
    if (!QzoneOnlineTimeCollectRptService.a(this.a)) {}
    try
    {
      this.a.a = Long.parseLong(BaseApplicationImpl.a().a().getAccount());
      QzoneOnlineTimeCollectRptService.a(this.a, QzoneConfig.a().a("ReportSetting", "OnlineLocalSaveFrequency", 10000));
      this.a.b();
      QzoneOnlineTimeCollectRptService.a(this.a);
      QzoneOnlineTimeCollectRptService.a(this.a, true);
      LocalMultiProcConfig.b("key_sp_qzone_isforeground", true);
      if (QzoneOnlineTimeCollectRptService.a(this.a) != 0) {
        ThreadManager.b().post(QzoneOnlineTimeCollectRptService.a(this.a));
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e(QzoneOnlineTimeCollectRptService.a(), 2, "beginTrace:" + localException.toString());
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */