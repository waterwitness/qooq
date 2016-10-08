import android.content.Intent;
import com.tencent.biz.pubaccount.PublicAccountManageActivity;
import com.tencent.biz.pubaccount.PublicAccountManagePopBar;
import com.tencent.mobileqq.activity.PublicAccountSearchActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.PopupMenuDialog.OnClickActionListener;

public class hqe
  implements PopupMenuDialog.OnClickActionListener
{
  public hqe(PublicAccountManagePopBar paramPublicAccountManagePopBar)
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
      PublicAccountSearchActivity.a(PublicAccountManagePopBar.a(this.a));
      ReportController.b(PublicAccountManagePopBar.a(this.a).app, "P_CliOper", "Pb_account_lifeservice", "", "0X800573A", "0X800573A", 0, 1, 0, "", "", "", "");
      paramMenuItem = (RedTouchManager)PublicAccountManagePopBar.a(this.a).app.getManager(35);
      BusinessInfoCheckUpdate.AppInfo localAppInfo = paramMenuItem.a("101000.101001");
      if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() == 1)) {
        ReportController.b(PublicAccountManagePopBar.a(this.a).app, "P_CliOper", "Pb_account_lifeservice", "", "0X80060E3", "0X80060E3", 0, 0, "", "", "", "");
      }
      paramMenuItem.b("101000.101001");
      return;
    }
    paramMenuItem = new Intent(PublicAccountManagePopBar.a(this.a), PublicAccountManageActivity.class);
    PublicAccountManagePopBar.a(this.a).startActivity(paramMenuItem);
    int i;
    if ((PublicAccountManagePopBar.a(this.a) != null) && (PublicAccountManagePopBar.a(this.a).a()))
    {
      i = 1;
      label207:
      paramMenuItem = PublicAccountManagePopBar.a(this.a).app;
      if (i == 0) {
        break label274;
      }
    }
    label274:
    for (int j = 1;; j = 0)
    {
      ReportController.b(paramMenuItem, "dc00899", "Pb_account_lifeservice", "", "0X800679B", "0X800679B", j, 0, "", "", "", "");
      if (i == 0) {
        break;
      }
      ThreadManager.c(new hqf(this, NetConnInfoCenter.getServerTimeMillis()));
      return;
      i = 0;
      break label207;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hqe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */