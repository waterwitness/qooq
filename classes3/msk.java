import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.activity.TroopMemberCardActivity.ViewHolder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.StatusHistoryActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopMemberCharmUtils;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;

public class msk
  implements View.OnClickListener
{
  public msk(TroopMemberCardActivity paramTroopMemberCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView == null) || (!(paramView instanceof TroopMemberCardActivity.ViewHolder))) {}
    do
    {
      return;
      paramView = (TroopMemberCardActivity.ViewHolder)paramView;
      if (paramView.a == 0)
      {
        this.a.c(this.a.v);
        this.a.g("Clk_account");
        return;
      }
      if (paramView.a == 1)
      {
        this.a.b(this.a.t, this.a.v);
        this.a.d("Clk_recentsaid", "P_CliOper");
        return;
      }
      if (paramView.a == 2)
      {
        this.a.a(this.a.t, this.a.v);
        this.a.g("Clk_set");
        return;
      }
      if (paramView.a == 4)
      {
        if (this.a.K != 5)
        {
          ReportController.b(this.a.app, "P_CliOper", "Grp_work", "", "person_data", "phone_mem", 0, 0, this.a.t, "", "", "");
          this.a.n();
          return;
        }
        this.a.e(this.a.p);
        return;
      }
      if (paramView.a == 5)
      {
        this.a.f(this.a.q);
        return;
      }
      if (paramView.a == 8)
      {
        QZoneHelper.a(this.a.a, QZoneHelper.UserInfo.a(), this.a.v, 0, 0, 0);
        this.a.g("Clk_Qzone");
        return;
      }
      if ((paramView.a == 7) || (paramView.a == 6))
      {
        this.a.g("Clk_nameNew");
        TroopMemberCardActivity.a(this.a);
        return;
      }
      if (paramView.a == 9)
      {
        StatusHistoryActivity.a(this.a, this.a.v, this.a.d(), 3, "");
        this.a.g("Clk_signature");
        return;
      }
    } while (paramView.a != 10);
    paramView = TroopMemberCharmUtils.a(this.a.v, this.a.t);
    Intent localIntent = new Intent(this.a.a, QQBrowserActivity.class);
    localIntent.putExtra("url", paramView);
    localIntent.putExtra("uin", this.a.app.f());
    localIntent.putExtra("portraitOnly", true);
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("isShowAd", false);
    this.a.startActivity(localIntent);
    ReportController.b(this.a.app, "dc00899", "Grp_flower", "", "charm", "Clk_grpname", 0, 0, String.valueOf(this.a.J), "", "", "");
    ReportController.b(this.a.app, "dc00899", "Grp_flower", "", "charm", "Clk_charm", 0, 0, String.valueOf(this.a.J), "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\msk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */