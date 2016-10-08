import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AboutActivity;
import com.tencent.mobileqq.activity.UpgradeDetailActivity;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class kgj
  implements View.OnClickListener
{
  public kgj(AboutActivity paramAboutActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if ((AboutActivity.a(this.a) != null) && (AboutActivity.a(this.a).a != null))
    {
      ReportController.b(this.a.app, "CliOper", "", "", "0X8004DB2", "0X8004DB2", 0, 0, "", "", UpgradeController.a(), "");
      UpgradeDetailActivity.a(this.a, UpgradeController.a().a(), false, false, true);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kgj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */