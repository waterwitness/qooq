import android.content.Intent;
import com.tencent.mobileqq.activity.TroopAssisSettingActivity;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.PopupMenuDialog.OnClickActionListener;

public class mpg
  implements PopupMenuDialog.OnClickActionListener
{
  public mpg(TroopAssistantActivity paramTroopAssistantActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(PopupMenuDialog.MenuItem paramMenuItem)
  {
    boolean bool = false;
    switch (paramMenuItem.a)
    {
    default: 
      return;
    case 0: 
      paramMenuItem = this.a;
      if (!this.a.d) {
        bool = true;
      }
      paramMenuItem.d = bool;
      TroopAssistantManager.a().b(this.a.app, this.a.d);
      return;
    }
    paramMenuItem = new Intent(this.a, TroopAssisSettingActivity.class);
    paramMenuItem.setFlags(67108864);
    this.a.startActivity(paramMenuItem);
    ReportController.b(this.a.app, "P_CliOper", "Grp_msg", "", "help_list", "Clk_set", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mpg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */