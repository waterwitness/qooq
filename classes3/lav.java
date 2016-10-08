import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.TroopPrivateSettingActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

public class lav
  implements View.OnClickListener
{
  public lav(ChatSettingForTroop paramChatSettingForTroop)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131297083: 
      ChatSettingForTroop.a(this.a);
      this.a.finish();
      return;
    }
    if ((this.a.ap == 1) || ((this.a.a != null) && (this.a.a.isMember)))
    {
      paramView = new Intent(paramView.getContext(), TroopPrivateSettingActivity.class);
      paramView.putExtra("troop_uin", this.a.a.troopUin);
      this.a.startActivityForResult(paramView, 15);
      ReportController.b(this.a.app, "P_CliOper", "Grp_set", "", "Grp_data", "Clk_persetup", 0, 0, this.a.a.troopUin, "0", "", "");
      return;
    }
    ChatSettingForTroop.b(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lav.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */