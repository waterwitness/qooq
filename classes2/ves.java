import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.NearbyTroopsActivity;
import com.tencent.mobileqq.troop.activity.TroopCreateEnterActivity;

public class ves
  implements View.OnClickListener
{
  public ves(NearbyTroopsActivity paramNearbyTroopsActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      this.a.b();
      return;
      this.a.onBackPressed();
      return;
      if (this.a.c())
      {
        this.a.b();
        return;
      }
      this.a.a();
      return;
      TroopCreateEnterActivity.a(this.a, 2, 51);
      ReportController.b(this.a.app, "P_CliOper", "Grp_nearby", "", "right", "create", 0, 0, "", "", "", "");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ves.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */