import android.content.Intent;
import com.tencent.av.ui.QavPanel.SlideAcceptListener;
import com.tencent.av.ui.VideoInviteLock;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class gzu
  implements QavPanel.SlideAcceptListener
{
  public gzu(VideoInviteLock paramVideoInviteLock)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.a.getIntent().getBooleanExtra("isDoubleVideoMeeting", false)) {
        ReportController.b(null, "CliOper", "", "", "0X80051FE", "0X80051FE", 0, 0, Integer.toString(this.a.jdField_d_of_type_Int), Integer.toString(this.a.i), Integer.toString(this.a.j), "");
      }
      for (;;)
      {
        this.a.jdField_d_of_type_Boolean = true;
        VideoInviteLock.a(this.a);
        return;
        if (this.a.b) {
          ReportController.b(null, "CliOper", "", "", "0X8004201", "0X8004201", 0, 0, Integer.toString(this.a.jdField_d_of_type_Int), Integer.toString(this.a.i), Integer.toString(this.a.j), "");
        } else {
          ReportController.b(null, "CliOper", "", "", "0X8004205", "0X8004205", 0, 0, Integer.toString(this.a.jdField_d_of_type_Int), Integer.toString(this.a.i), Integer.toString(this.a.j), "");
        }
      }
    }
    if (this.a.b)
    {
      ReportController.b(null, "CliOper", "", "", "0X800439E", "0X800439E", 0, 0, Integer.toString(this.a.jdField_d_of_type_Int), Integer.toString(this.a.i), Integer.toString(this.a.j), "");
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X80043FD", "0X80043FD", 0, 0, Integer.toString(this.a.jdField_d_of_type_Int), Integer.toString(this.a.i), Integer.toString(this.a.j), "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gzu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */