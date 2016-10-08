import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class lyc
  implements CompoundButton.OnCheckedChangeListener
{
  public lyc(NotifyPushSettingActivity paramNotifyPushSettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i = 1;
    if (AppSetting.j) {
      NotifyPushSettingActivity.c(this.a).setContentDescription("通知时指示灯闪烁");
    }
    SettingCloneUtil.writeValue(this.a, this.a.a, this.a.getString(2131368466), "qqsetting_notify_blncontrol_key", paramBoolean);
    QQAppInterface localQQAppInterface;
    if (paramBoolean)
    {
      NotifyPushSettingActivity.a(this.a.getActivity(), this.a.app.a(), "LED_light", 1);
      localQQAppInterface = this.a.app;
      if (!paramBoolean) {
        break label144;
      }
      label86:
      if (!paramBoolean) {
        break label150;
      }
    }
    label144:
    label150:
    for (paramCompoundButton = "1";; paramCompoundButton = "0")
    {
      ReportController.b(localQQAppInterface, "CliOper", "", "", "Setting_tab", "Led_blinking", 0, i, paramCompoundButton, "", "", "");
      return;
      NotifyPushSettingActivity.a(this.a.getActivity(), this.a.app.a(), "LED_light", 0);
      break;
      i = 0;
      break label86;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lyc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */