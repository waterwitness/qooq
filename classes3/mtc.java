import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import cooperation.troop.TroopMemberCardProxyActivity;
import cooperation.troop.TroopProxyActivity;

public class mtc
  implements View.OnClickListener
{
  public mtc(TroopMemberCardActivity paramTroopMemberCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.a.d("Clk_set", "P_CliOper");
    if (this.a.K == 5)
    {
      ReportController.b(this.a.app, "CliOper", "", "", "0X8005B32", "0X8005B32", 0, 0, "", "", "", "");
      this.a.m();
      return;
    }
    paramView = new Intent();
    paramView.putExtra("troopUin", this.a.t);
    paramView.putExtra("memberUin", this.a.v);
    paramView.putExtra("fromFlag", this.a.K);
    paramView.putExtra("troopMemberCard", this.a.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard);
    paramView.putExtra("troopCode", this.a.u);
    paramView.putExtra("troopName", this.a.s);
    paramView.putExtra("hwCard", this.a.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(this.a.t, this.a.v));
    Dialog localDialog = TroopProxyActivity.a(this.a);
    TroopMemberCardProxyActivity.a(this.a.app, "troop_member_card_plugin.apk", "群名片", TroopMemberCardProxyActivity.class, this.a, paramView, localDialog, "com.tencent.mobileqq.memcard.plugin.TroopMemberCardMoreInfoActivity", this.a.app.a(), 8);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mtc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */