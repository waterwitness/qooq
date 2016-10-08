import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel;
import com.tencent.mobileqq.statistics.ReportController;

public class tmp
  implements DialogInterface.OnClickListener
{
  public tmp(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((NearbyProfileDisplayPanel.a(this.a) != null) && (NearbyProfileDisplayPanel.a(this.a).isShowing())) {
      NearbyProfileDisplayPanel.a(this.a).dismiss();
    }
    ReportController.b(this.a.a.app, "CliOper", "", "", "0X8004829", "0X8004829", 2, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tmp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */