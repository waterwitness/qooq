import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.AppRuntime.Status;

public class khq
  implements View.OnClickListener
{
  public khq(AccountManageActivity paramAccountManageActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    AppRuntime.Status localStatus = AppRuntime.Status.online;
    int i = paramView.getId();
    if (i == 2131296838)
    {
      ReportController.b(this.a.app, "CliOper", "", "", "0X800403A", "0X800403A", 0, 0, "", "", "", "");
      paramView = AppRuntime.Status.online;
    }
    for (;;)
    {
      this.a.a(paramView);
      if (((paramView == AppRuntime.Status.online) || (paramView == AppRuntime.Status.invisiable) || (paramView == AppRuntime.Status.away)) && (paramView != this.a.app.getOnlineStatus()))
      {
        if (!NetworkUtil.e(this.a.getApplication())) {
          break;
        }
        this.a.app.a(this.a.a(paramView), true);
      }
      return;
      if (i == 2131296289)
      {
        ReportController.b(this.a.app, "CliOper", "", "", "0X800403B", "0X800403B", 0, 0, "", "", "", "");
        paramView = AppRuntime.Status.invisiable;
      }
      else
      {
        paramView = localStatus;
        if (i == 2131296839) {
          paramView = AppRuntime.Status.away;
        }
      }
    }
    Toast.makeText(BaseApplication.getContext(), 2131367525, 0).show();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\khq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */