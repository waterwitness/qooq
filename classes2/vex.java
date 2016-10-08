import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.NearbyTroopsBaseView.INearbyTroopContext;
import com.tencent.mobileqq.troop.activity.NearbyTroopsView;

public class vex
  implements View.OnClickListener
{
  public vex(NearbyTroopsView paramNearbyTroopsView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = new Intent(paramView.getContext(), QQBrowserActivity.class);
    paramView.putExtra("url", this.a.d);
    paramView.putExtra("hide_operation_bar", true);
    paramView.putExtra("hide_more_button", true);
    this.a.b(paramView);
    ReportController.b(this.a.a.a(), "P_CliOper", "Grp_nearby", "", "hot", "Clk", 0, 0, "", "", "", "");
    this.a.k = false;
    this.a.l();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */