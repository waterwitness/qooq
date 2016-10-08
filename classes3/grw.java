import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class grw
  implements Runnable
{
  grw(gru paramgru)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      if (!this.a.a.a.a().w)
      {
        this.a.a.a.a().x = true;
        this.a.a.g(true);
        if (QLog.isColorLevel()) {
          QLog.e("DoubleVideoCtrlUI", 2, "[childLock] action lock");
        }
        ReportController.b(null, "CliOper", "", "", "0X80061F7", "0X80061F7", 0, 0, "", "", "", "");
        return;
      }
      this.a.a.a.a().x = false;
      this.a.a.z();
      if (QLog.isColorLevel()) {
        QLog.e("DoubleVideoCtrlUI", 2, "[childLock] action unlock");
      }
      ReportController.b(null, "CliOper", "", "", "0X80061F9", "0X80061F9", 0, 0, "", "", "", "");
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\grw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */