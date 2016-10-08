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
import cooperation.qqwifi.QQWiFiPluginInstallActivity;

public class owf
  implements View.OnClickListener
{
  public owf(BannerManager paramBannerManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    ((NotificationManager)BannerManager.a(this.a).getSystemService("notification")).cancel(QQWiFiHelper.a);
    paramView = new Intent(BannerManager.a(this.a), QQWiFiPluginInstallActivity.class);
    paramView.setAction("com.tencent.mobileqq.action.QQWiFi");
    paramView.putExtra("from-bluebar", true);
    BannerManager.a(this.a).startActivity(paramView);
    this.a.a(17, 0);
    this.a.a(-1, null);
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent.banner", 2, "banner click send qqwifi broadcast");
    }
    paramView = new Intent("com.tencent.mobileqq.qqwifi.scanStateChange");
    paramView.putExtra("intervalTime", QQWiFiHelper.b + 2L);
    BannerManager.a(this.a).sendBroadcast(paramView);
    ReportController.b(BannerManager.a(this.a).app, "CliOper", "", "", "QQWIFI", "clk_buleNotify", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\owf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */