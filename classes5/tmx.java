import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel;
import com.tencent.mobileqq.statistics.ReportController;

public class tmx
  implements View.OnClickListener
{
  public tmx(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.a.j = true;
    this.a.b();
    ReportController.b(this.a.a.app, "CliOper", "", "", "0X800482C", "0X800482C", 0, 0, "", "", "", "");
    if (ProfileActivity.b(this.a.a.a.g)) {
      ReportController.b(this.a.a.app, "CliOper", "", "", "0X8005242", "0X8005242", 0, 0, "", "", "", "");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tmx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */