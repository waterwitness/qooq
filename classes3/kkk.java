import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class kkk
  implements CompoundButton.OnCheckedChangeListener
{
  public kkk(AssistantSettingActivity paramAssistantSettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (AppSetting.j) {
      this.a.a.setContentDescription("摇动手机截屏");
    }
    paramCompoundButton = this.a.app;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      ReportController.b(paramCompoundButton, "CliOper", "", "", "Shake_screenshot", "Shake_screenshot_switch", 0, i, "", "", "", "");
      SettingCloneUtil.writeValue(this.a, null, this.a.getString(2131367835), "qqsetting_screenshot_key", paramBoolean);
      if (!paramBoolean) {
        break;
      }
      this.a.turnOnShake();
      return;
    }
    this.a.turnOffShake();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kkk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */