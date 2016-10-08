import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class lya
  implements CompoundButton.OnCheckedChangeListener
{
  public lya(NotifyPushSettingActivity paramNotifyPushSettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (NotifyPushSettingActivity.a())
    {
      NotifyPushSettingActivity.a(this.a).setChecked(false);
      NotifyPushSettingActivity.a(this.a).setVisibility(8);
      SettingCloneUtil.writeValue(this.a, this.a.a, this.a.getString(2131368465), "qqsetting_notify_showcontent_key", paramBoolean);
      if (!paramBoolean) {
        break label127;
      }
    }
    label127:
    for (int i = 1;; i = 0)
    {
      ReportController.b(this.a.app, "CliOper", "", "", "Setting_tab", "Clk_hide_text", 0, i, String.valueOf(i), "", "", "");
      return;
      if (paramBoolean)
      {
        NotifyPushSettingActivity.a(this.a).setVisibility(0);
        break;
      }
      NotifyPushSettingActivity.a(this.a).setVisibility(8);
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lya.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */