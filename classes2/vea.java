import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.NearbyMemberActivity;

public class vea
  implements View.OnClickListener
{
  public vea(NearbyMemberActivity paramNearbyMemberActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.a.b();
    ReportController.b(this.a.app, "P_CliOper", "Grp_AIO", "", "nearby_mber", "Clk_all", 0, 0, this.a.a.a, "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vea.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */