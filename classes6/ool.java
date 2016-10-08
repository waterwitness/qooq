import android.content.Intent;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.phone.BindVerifyActivity;
import com.tencent.mobileqq.activity.phone.MyBusinessActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;

public class ool
  extends ContactBindObserver
{
  public ool(BindVerifyActivity paramBindVerifyActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void b(boolean paramBoolean, int paramInt)
  {
    this.a.b();
    if (!paramBoolean)
    {
      this.a.b(2131368649);
      return;
    }
    if ((paramInt == 0) || (paramInt == 106))
    {
      if (1 == this.a.b) {
        MyBusinessActivity.f(true);
      }
      if (this.a.getIntent().getBooleanExtra("k_is_block", false)) {
        ReportController.b(this.a.app, "CliOper", "", "", "0X80053D5", "0X80053D5", 0, 0, "", "", "", "");
      }
      if (this.a.getIntent().getBooleanExtra("key_is_from_qqhotspot", false))
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("bind_mobile", BindVerifyActivity.a(this.a).getText().toString().trim());
        this.a.setResult(-1, (Intent)localObject);
        this.a.finish();
        return;
      }
      if (this.a.c == 10)
      {
        LoginWelcomeManager.a(this.a.app).a(this.a, 2);
        return;
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("bind_mobile", BindVerifyActivity.a(this.a).getText().toString().trim());
      this.a.app.a(new oom(this));
      QQToast.a(BaseApplicationImpl.a, "特征码匹配中。", 0).a();
      this.a.setResult(-1, (Intent)localObject);
      this.a.finish();
      return;
    }
    if (paramInt == 213)
    {
      this.a.a("验证码错误，请重新输入。");
      return;
    }
    Object localObject = "请稍后重试。";
    if (paramInt == 107) {
      localObject = "此手机号已与其他帐号绑定，请返回重试。";
    }
    this.a.a("请求失败", (String)localObject);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */