import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class lxz
  extends BroadcastReceiver
{
  public lxz(NotifyPushSettingActivity paramNotifyPushSettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("com.tencent.mobileqq.activity.NotifyPushSettingActivity.PCActive"))
    {
      paramContext = paramIntent.getStringExtra("uin");
      NotifyPushSettingActivity.a(this.a, paramContext);
    }
    boolean bool;
    do
    {
      do
      {
        return;
      } while (!paramContext.equals("com.tencent.mobileqq.activity.NotifyPushSettingActivity.ConfigPCActive"));
      paramContext = paramIntent.getStringExtra("uin");
      bool = paramIntent.getBooleanExtra("configPCActive", false);
    } while (!this.a.app.getAccount().equals(paramContext));
    if (true == bool)
    {
      NotifyPushSettingActivity.g(this.a).setVisibility(0);
      return;
    }
    NotifyPushSettingActivity.g(this.a).setVisibility(8);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lxz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */