import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class tmo
  implements DialogInterface.OnClickListener
{
  public tmo(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramInt = 0;
    while (paramInt < NearbyProfileDisplayPanel.b(this.a).getChildCount())
    {
      paramDialogInterface = NearbyProfileDisplayPanel.b(this.a).getChildAt(paramInt);
      DataTag localDataTag = (DataTag)paramDialogInterface.getTag();
      if ((localDataTag != null) && (localDataTag.ah == 8) && (!paramDialogInterface.isEnabled()))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.dating", 2, "profile add friend return");
        }
        return;
      }
      paramInt += 1;
    }
    this.a.g();
    if ((NearbyProfileDisplayPanel.a(this.a) != null) && (NearbyProfileDisplayPanel.a(this.a).isShowing())) {
      NearbyProfileDisplayPanel.a(this.a).dismiss();
    }
    ReportController.b(this.a.a.app, "CliOper", "", "", "0X8004829", "0X8004829", 1, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tmo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */