import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class tmh
  implements View.OnClickListener
{
  public tmh(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if ((this.a.b != null) && (!this.a.isFinishing()))
    {
      this.a.b.dismiss();
      this.a.b = null;
    }
    this.a.a(300L);
    ReportController.b(this.a.app, "CliOper", "", "", "0X8004BB0", "0X8004BB0", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tmh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */