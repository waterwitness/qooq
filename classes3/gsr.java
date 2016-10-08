import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.ui.DoubleVideoMeetingCtrlUI;
import com.tencent.av.utils.TipsManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class gsr
  implements Runnable
{
  public gsr(DoubleVideoMeetingCtrlUI paramDoubleVideoMeetingCtrlUI)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoubleVideoMeetingCtrlUI", 2, "RequestVideoTimeoutRunnale-->VideoControl is null");
      }
      return;
    }
    this.a.jdField_a_of_type_ComTencentAvVideoController.f();
    this.a.h(true);
    if (this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager != null)
    {
      TipsManager.c(103);
      TipsManager.c(106);
      this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(106);
      this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.a(106);
    }
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().a(this.a.b, true, true);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gsr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */