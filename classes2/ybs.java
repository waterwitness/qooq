import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.dingdong.data.ScheduleTipsDialog;

public class ybs
  extends BroadcastReceiver
{
  static final String jdField_a_of_type_JavaLangString = "reason";
  static final String b = "homekey";
  static final String c = "rencentkeys";
  
  public ybs(ScheduleTipsDialog paramScheduleTipsDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS"))
    {
      paramContext = paramIntent.getStringExtra("reason");
      if ((paramContext != null) && (paramContext.equals("homekey")) && (ScheduleTipsDialog.b(this.a))) {
        ScheduleTipsDialog.a(this.a, this.a);
      }
    }
    while ((!paramContext.equals("android.intent.action.SCREEN_OFF")) || (!ScheduleTipsDialog.b(this.a))) {
      return;
    }
    ScheduleTipsDialog.a(this.a, this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ybs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */