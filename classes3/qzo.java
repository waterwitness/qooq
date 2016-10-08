import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.conditionsearch.LocationSelectActivity;
import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSimpleItem;

public class qzo
  implements DialogInterface.OnDismissListener
{
  public qzo(LocationSelectActivity paramLocationSelectActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    LocationSelectActivity.a(this.a).setRightTextColor(2);
    if (AppSetting.j)
    {
      LocationSelectActivity.b(this.a).setContentDescription("国家 " + LocationSelectActivity.a(this.a).a + "，连按两次来更改");
      LocationSelectActivity.a(this.a).setContentDescription("省市 " + LocationSelectActivity.a(this.a).b().getText() + "，连按两次来更改");
    }
    paramDialogInterface = LocationSelectActivity.a(this.a);
    if (LocationSelectActivity.a(this.a) == 0)
    {
      ReportController.b(this.a.app, "CliOper", "", "", "0X8004248", "0X8004248", 0, 0, paramDialogInterface[0], paramDialogInterface[1], paramDialogInterface[2], "");
      return;
    }
    ReportController.b(this.a.app, "CliOper", "", "", "0X800424A", "0X800424A", 0, 0, paramDialogInterface[0], paramDialogInterface[1], paramDialogInterface[2], "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qzo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */