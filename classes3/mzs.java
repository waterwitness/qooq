import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.UpgradeActivity;
import com.tencent.mobileqq.app.upgrade.UpgradeConstants;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class mzs
  implements DialogInterface.OnClickListener
{
  public mzs(UpgradeActivity paramUpgradeActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.b(this.a.app, "CliOper", "", "", "0X8004DA2", "0X8004DA2", 0, 0, UpgradeConstants.b(), String.valueOf(0), UpgradeController.a(), "0");
    this.a.a();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mzs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */