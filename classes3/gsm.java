import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.ui.DoubleVideoMeetingCtrlUI;
import com.tencent.av.ui.QavInOutAnimation.QavOutAnimationListener;
import com.tencent.av.utils.TraeHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class gsm
  implements QavInOutAnimation.QavOutAnimationListener
{
  public gsm(DoubleVideoMeetingCtrlUI paramDoubleVideoMeetingCtrlUI)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    this.a.p = true;
    this.a.ak();
  }
  
  public void b()
  {
    TraeHelper.a().a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().K) {
      DoubleVideoMeetingCtrlUI.a(this.a);
    }
    this.a.jdField_a_of_type_Boolean = true;
    this.a.jdField_a_of_type_ComTencentAvVideoController.a(this.a.jdField_a_of_type_Long, true, 0);
    DoubleVideoMeetingCtrlUI.b(this.a);
    this.a.g(true);
    ReportController.b(null, "CliOper", "", "", "0X8005206", "0X8005206", 0, 0, "", "", "", "");
    this.a.p = false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gsm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */