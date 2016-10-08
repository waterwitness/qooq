import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.GaInviteLockActivity;
import com.tencent.av.ui.QavInOutAnimation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class gil
  extends BroadcastReceiver
{
  static final String jdField_a_of_type_JavaLangString = "reason";
  static final String b = "homekey";
  static final String c = "rencentkeys";
  
  public gil(GaInviteLockActivity paramGaInviteLockActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS"))
    {
      paramContext = paramIntent.getStringExtra("reason");
      if ((paramContext != null) && (paramContext.equals("homekey")))
      {
        ReportController.b(null, "CliOper", "", "", "0X8004210", "0X8004210", 0, 0, "", "", "", "");
        this.a.i();
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (!paramContext.equals("tencent.notify.cancel.videorequest")) {
            break;
          }
          paramContext = paramIntent.getStringExtra("selfUin");
          paramIntent = paramIntent.getStringExtra("sendUin");
          if (QLog.isColorLevel()) {
            QLog.d(GaInviteLockActivity.c, 2, "recv cancel audio request");
          }
        } while ((this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() != null) && ((!this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().equals(paramContext)) || (!paramIntent.equals(Long.valueOf(this.a.b)))));
        if (this.a.jdField_a_of_type_ComTencentAvUiQavInOutAnimation != null)
        {
          this.a.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.a(new gim(this));
          return;
        }
        GaInviteLockActivity.b(this.a);
        return;
      } while (!paramContext.equals("android.intent.action.SCREEN_OFF"));
      ReportController.b(null, "CliOper", "", "", "0X800420C", "0X800420C", 0, 0, "", "", "", "");
    } while (!QLog.isColorLevel());
    QLog.d(GaInviteLockActivity.c, 2, "ACTION_SCREEN_OFF");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */