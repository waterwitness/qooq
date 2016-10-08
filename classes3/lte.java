import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class lte
  implements DialogInterface.OnClickListener
{
  public lte(LoginActivity paramLoginActivity, String paramString1, String paramString2, String paramString3)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity.app, "dc00898", "", "", "0X8006796", "0X8006796", 0, 0, "", "", "", "");
    ThreadManager.a(new ltf(this), null, false);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lte.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */