import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopAssisSettingActivity;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import mqq.os.MqqHandler;

public class ovr
  implements View.OnClickListener
{
  public ovr(BannerManager paramBannerManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = new Intent(BannerManager.a(this.a), TroopAssisSettingActivity.class);
    BannerManager.a(this.a).startActivityForResult(paramView, 9001);
    BannerManager.a(this.a).sendEmptyMessageDelayed(1, 1000L);
    ReportController.b(BannerManager.a(this.a).app, "P_CliOper", "Grp_msg", "", "Msglist", "Clk_setmsg", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ovr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */