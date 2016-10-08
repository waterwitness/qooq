import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class lyb
  implements CompoundButton.OnCheckedChangeListener
{
  public lyb(NotifyPushSettingActivity paramNotifyPushSettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (AppSetting.j) {
      NotifyPushSettingActivity.b(this.a).setContentDescription("夜间防骚扰模式");
    }
    SettingCloneUtil.writeValue(this.a, null, "no_disturb_mode", "qqsetting_nodisturb_mode_key", paramBoolean);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      ReportController.b(this.a.app, "CliOper", "", "", "Setting_tab", "Clk_night_mode", 0, i, String.valueOf(i), "", "", "");
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lyb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */