import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.NearbyTroopsActivity;
import com.tencent.mobileqq.troop.activity.TroopCreateEnterActivity;
import com.tencent.mobileqq.troop.browser.TroopQQBrowserHelper;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.PopupMenuDialog.OnClickActionListener;

public class ver
  implements PopupMenuDialog.OnClickActionListener
{
  public ver(NearbyTroopsActivity paramNearbyTroopsActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(PopupMenuDialog.MenuItem paramMenuItem)
  {
    switch (paramMenuItem.a)
    {
    default: 
      return;
    case 0: 
      TroopCreateEnterActivity.a(this.a, 2, 51);
      ReportController.b(this.a.app, "P_CliOper", "Grp_nearby", "", "right", "create", 0, 0, "", "", "", "");
      return;
    }
    TroopQQBrowserHelper.b(this.a, this.a.g);
    ReportController.b(this.a.app, "P_CliOper", "Grp_nearby", "", "ac", "create", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */