import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin;
import com.tencent.av.ui.AVActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class gpn
  extends BroadcastReceiver
{
  static final String jdField_a_of_type_JavaLangString = "reason";
  static final String b = "homekey";
  static final String c = "rencentkeys";
  
  gpn(AVActivity paramAVActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS"))
    {
      paramContext = paramIntent.getStringExtra("reason");
      if ((paramContext != null) && (this.a.a != null) && (paramContext.equals("homekey")))
      {
        if (this.a.a.a().jdField_f_of_type_Int == 4)
        {
          if (this.a.j != 3000) {
            break label217;
          }
          if (!this.a.a.a().jdField_f_of_type_Boolean) {
            break label190;
          }
          ReportController.b(null, "CliOper", "", "", "0X80041BB", "0X80041BB", 0, 0, "", "", "", "");
        }
        if (this.a.g)
        {
          if (!this.a.a.a().jdField_f_of_type_Boolean) {
            break label404;
          }
          ReportController.b(null, "CliOper", "", "", "0X8005216", "0X8005216", 0, 0, "", "", "", "");
        }
      }
    }
    for (;;)
    {
      if (AVActivity.a(this.a) != null) {
        AVActivity.a(this.a).b(this.a.isResume());
      }
      return;
      label190:
      ReportController.b(null, "CliOper", "", "", "0X80041BE", "0X80041BE", 0, 0, "", "", "", "");
      break;
      label217:
      if (this.a.j != 1) {
        break;
      }
      if (this.a.a.a().jdField_f_of_type_Boolean)
      {
        if (this.a.a.a().D == 10)
        {
          ReportController.b(null, "CliOper", "", "", "0X800593E", "0X800593E", 0, 0, "", "", "", "");
          break;
        }
        ReportController.b(null, "CliOper", "", "", "0X80046E8", "0X80046E8", 0, 0, "", "", "", "");
        break;
      }
      if (!this.a.a.a().g) {
        break;
      }
      if (this.a.a.a().D == 10)
      {
        ReportController.b(null, "CliOper", "", "", "0X8005941", "0X8005941", 0, 0, "", "", "", "");
        break;
      }
      ReportController.b(null, "CliOper", "", "", "0X80046EB", "0X80046EB", 0, 0, "", "", "", "");
      break;
      label404:
      ReportController.b(null, "CliOper", "", "", "0X8005219", "0X8005219", 0, 0, "", "", "", "");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gpn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */