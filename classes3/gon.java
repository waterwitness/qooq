import android.content.res.Resources;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.smallscreen.SmallScreenMultiVideoControlUI;
import com.tencent.av.utils.TipsManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class gon
  implements Runnable
{
  public gon(SmallScreenMultiVideoControlUI paramSmallScreenMultiVideoControlUI)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      this.a.jdField_a_of_type_ComTencentAvVideoController.f();
      if (this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)
      {
        TipsManager.c(103);
        TipsManager.c(106);
        this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(103);
        this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(106);
        str = this.a.jdField_a_of_type_AndroidContentResResources.getString(2131363868);
        TipsManager.a(107, str);
        this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(107, str, false);
      }
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().a(this.a.jdField_a_of_type_Long, true, true);
      this.a.a(true, false, true);
      if (this.a.d == 2) {
        ReportController.b(null, "CliOper", "", "", "0X8004425", "0X8004425", 0, 0, "", "", "", "");
      }
    }
    while (!QLog.isColorLevel())
    {
      String str;
      return;
    }
    QLog.e("SmallScreenMultiVideoControlUI", 2, "RequestVideoTimeOutRunnable, mVideoController = null!!!");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */