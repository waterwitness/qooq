import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.phone.DialogBaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager;
import com.tencent.mobileqq.statistics.ReportController;

public class opj
  implements DialogInterface.OnClickListener
{
  public opj(DialogBaseActivity paramDialogBaseActivity, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (this.jdField_a_of_type_Boolean)
    {
      LoginWelcomeManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneDialogBaseActivity.app).a(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneDialogBaseActivity, 0);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneDialogBaseActivity.app, "dc00898", "", "", "0X8006AA6", "0X8006AA6", 0, 0, "", "", "", "");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhoneDialogBaseActivity.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\opj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */