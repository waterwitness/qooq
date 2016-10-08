import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class ooc
  implements DialogInterface.OnClickListener
{
  public ooc(BindNumberActivity paramBindNumberActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    BindNumberActivity.a(this.a);
    paramDialogInterface.dismiss();
    paramDialogInterface = this.a.getIntent();
    if (paramDialogInterface.getBooleanExtra("kFPhoneChange", false)) {
      ReportController.b(this.a.app, "CliOper", "", "", "0X8005DE9", "0X8005DE9", 1, 0, "", "", "", "");
    }
    if (paramDialogInterface.getBooleanExtra("kUnityOther", false)) {
      ReportController.b(this.a.app, "CliOper", "", "", "0X8005DE9", "0X8005DE9", 2, 0, "", "", "", "");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ooc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */