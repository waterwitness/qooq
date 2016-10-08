import android.app.NotificationManager;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqwifi.QQWiFiHelper;

public class owg
  implements View.OnClickListener
{
  public owg(BannerManager paramBannerManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.a.a(17, 0);
    this.a.a(-1, null);
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent.banner", 2, "banner close send qqwifi broadcast");
    }
    paramView = new Intent("com.tencent.mobileqq.qqwifi.scanStateChange");
    paramView.putExtra("intervalTime", QQWiFiHelper.b + 1L);
    BannerManager.a(this.a).sendBroadcast(paramView);
    ((NotificationManager)BannerManager.a(this.a).getSystemService("notification")).cancel(QQWiFiHelper.a);
    ReportController.b(BannerManager.a(this.a).app, "CliOper", "", "", "QQWIFI", "clk_buleClose", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\owg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */