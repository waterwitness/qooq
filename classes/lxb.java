import android.app.ProgressDialog;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.log.ReportLog;
import com.tencent.mobileqq.utils.DialogUtil;
import mqq.manager.ServerConfigManager.ConfigType;

public class lxb
  implements View.OnClickListener
{
  public lxb(NotificationActivity paramNotificationActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = DialogUtil.a(this.a, this.a.getResources().getDrawable(2130842887), 2131369250);
    paramView.setOnDismissListener(new lxc(this));
    ReportLog.a(this.a.app.getAccount());
    String str = this.a.app.a(ServerConfigManager.ConfigType.app, "log_upload");
    if ((!TextUtils.isEmpty(str)) && (str.equals("1")))
    {
      ReportLog.a(this.a.app.a(), this.a.app.a(), paramView);
      return;
    }
    ReportLog.a(this.a.app.a(), this.a.app.a(), paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\lxb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */