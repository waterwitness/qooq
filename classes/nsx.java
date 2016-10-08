import android.app.Activity;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class nsx
  extends BroadcastReceiver
{
  Activity jdField_a_of_type_AndroidAppActivity;
  boolean jdField_a_of_type_Boolean;
  
  public nsx(Activity paramActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public boolean a(Context paramContext)
  {
    return ((KeyguardManager)paramContext.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool = true;
    paramIntent = paramIntent.getAction();
    if ("android.intent.action.SCREEN_ON".equals(paramIntent)) {
      if (!a(paramContext)) {
        this.jdField_a_of_type_Boolean = bool;
      }
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidAppActivity.unregisterReceiver(this);
        this.jdField_a_of_type_AndroidAppActivity.finish();
      }
      return;
      bool = false;
      break;
      if ("android.intent.action.SCREEN_OFF".equals(paramIntent)) {
        this.jdField_a_of_type_Boolean = false;
      } else if ("android.intent.action.USER_PRESENT".equals(paramIntent)) {
        this.jdField_a_of_type_Boolean = true;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nsx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */