import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.UpgradeActivity;
import com.tencent.mobileqq.app.upgrade.UpgradeConstants;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class mzx
  implements DialogInterface.OnClickListener
{
  public mzx(UpgradeActivity paramUpgradeActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.b(this.a.app, "CliOper", "", "", "0X800417E", "0X800417E", 0, 0, "", "", "", "");
    UpgradeActivity.a(this.a, false);
    ReportController.b(this.a.app, "CliOper", "", "", "0X8004DA1", "0X8004DA1", 0, 0, UpgradeConstants.b(), String.valueOf(2), UpgradeController.a(), "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mzx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */