import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.qphone.base.util.QLog;

public class kgt
  implements View.OnClickListener
{
  public kgt(AccountManageActivity paramAccountManageActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Switch_Account", 2, "add account");
    }
    if (!PhoneNumLoginImpl.a().a(this.a.app, this.a)) {
      return;
    }
    AccountManageActivity.a(this.a, SubAccountControll.a(this.a.app));
    paramView = new Intent();
    paramView.setPackage(this.a.getPackageName());
    paramView.setClass(this.a, LoginActivity.class);
    paramView.putExtra("IS_ADD_ACCOUNT", true);
    paramView.putExtra("login_from_account_change", true);
    this.a.startActivityForResult(paramView, 1000);
    this.a.overridePendingTransition(2130968592, 2130968589);
    if (QQPlayerService.a())
    {
      paramView = new Intent();
      paramView.setAction("qqplayer_exit_action");
      this.a.sendBroadcast(paramView);
    }
    ReportController.b(this.a.app, "CliOper", "", "", "Setting_tab", "Clk_acc_add", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kgt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */