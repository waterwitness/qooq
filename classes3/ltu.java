import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.LoginInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class ltu
  implements CompoundButton.OnCheckedChangeListener
{
  public ltu(LoginInfoActivity paramLoginInfoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int j = 1;
    int i = 1;
    if (paramCompoundButton == LoginInfoActivity.a(this.a).a())
    {
      paramCompoundButton = this.a.app;
      if (paramBoolean)
      {
        ReportController.b(paramCompoundButton, "CliOper", "", "", "Setting_tab", "Mobile_pc_online", 0, i, "", "", "", "");
        SettingCloneUtil.writeValue(this.a, this.a.app.a(), "login_accounts", "qqsetting_bothonline_key", paramBoolean);
        this.a.app.m();
      }
    }
    while (paramCompoundButton != LoginInfoActivity.b(this.a).a()) {
      for (;;)
      {
        return;
        i = 0;
      }
    }
    paramCompoundButton = this.a.app;
    if (paramBoolean) {}
    for (i = j;; i = 0)
    {
      ReportController.b(paramCompoundButton, "CliOper", "", "", "Setting_tab", "Security_check", 0, i, "", "", "", "");
      SettingCloneUtil.writeValue(this.a, null, "security_scan_key", "qqsetting_security_scan_key", paramBoolean);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ltu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */