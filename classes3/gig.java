import android.os.Handler;
import android.os.Message;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.gaudio.GaInviteActivity;
import com.tencent.av.utils.QAVNotification;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class gig
  extends Handler
{
  public gig(GaInviteActivity paramGaInviteActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      this.a.jdField_a_of_type_Boolean = true;
      if (this.a.c) {
        if (this.a.e) {
          ReportController.b(null, "CliOper", "", "", "0X8005647", "0X8005647", 0, 0, "", "", "", "");
        }
      }
      for (;;)
      {
        if (this.a.jdField_a_of_type_ComTencentAvUtilsQAVNotification != null) {
          this.a.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.b);
        }
        this.a.a(8);
        return;
        ReportController.b(null, "CliOper", "", "", "Multi_call", "Lock_popup_timeout", 0, 0, "", "", "", "");
        continue;
        if (this.a.e) {
          ReportController.b(null, "CliOper", "", "", "0X8005572", "0X8005572", 0, 0, "", "", "", "");
        } else {
          ReportController.b(null, "CliOper", "", "", "Multi_call", "Multi_call_timeout", 0, 0, "", "", "", "");
        }
      }
    }
    this.a.f();
    super.sendEmptyMessageDelayed(1, 2000L);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */