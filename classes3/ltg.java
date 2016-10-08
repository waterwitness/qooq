import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class ltg
  implements DialogInterface.OnClickListener
{
  public ltg(LoginActivity paramLoginActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.a(this.a.app, "dc00898", "", "", "0X8006797", "0X8006797", 0, 0, "", "", "", "");
    try
    {
      paramDialogInterface.dismiss();
      return;
    }
    catch (Exception paramDialogInterface) {}
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ltg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */