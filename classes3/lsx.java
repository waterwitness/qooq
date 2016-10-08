import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.LoginPhoneNumActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class lsx
  implements ActionSheet.OnButtonClickListener
{
  public lsx(LoginActivity paramLoginActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    if (LoginActivity.a(this.a)) {
      return;
    }
    if (paramInt == 0)
    {
      paramView = new Intent(this.a, QQBrowserActivity.class);
      paramView.putExtra("uin", this.a.app.a());
      paramView.putExtra("reqType", 3);
      paramView.putExtra("url", "https://aq.qq.com/cn2/findpsw/mobile_web_find_input_account?source_id=2756");
      this.a.startActivity(paramView);
    }
    for (;;)
    {
      LoginActivity.b(this.a, true);
      LoginActivity.a(this.a).dismiss();
      return;
      if (paramInt == 1)
      {
        ReportController.b(this.a.app, "CliOper", "", "", "Mobile_signup", "Clk_ems_login", 0, 0, "", "", "", "");
        boolean bool = this.a.getIntent().getBooleanExtra("login_from_account_change", false);
        paramView = new Intent(this.a, LoginPhoneNumActivity.class);
        paramView.putExtra("login_from_account_change", bool);
        this.a.startActivity(paramView);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lsx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */