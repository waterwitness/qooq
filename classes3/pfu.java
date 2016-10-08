import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.selectmember.PhoneContactSelectActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.qcall.PstnManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQCustomDialog;

class pfu
  implements DialogInterface.OnClickListener
{
  pfu(pft parampft, PstnManager paramPstnManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramInt = 1;
    boolean bool = ((QQCustomDialog)paramDialogInterface).getCheckBoxState();
    if (bool) {
      this.jdField_a_of_type_ComTencentMobileqqQcallPstnManager.b(true);
    }
    if (!PhoneContactSelectActivity.a(this.jdField_a_of_type_Pft.a)) {
      this.jdField_a_of_type_Pft.a.h();
    }
    paramDialogInterface.dismiss();
    paramDialogInterface = this.jdField_a_of_type_Pft.a.app;
    if (bool) {}
    for (;;)
    {
      ReportController.b(paramDialogInterface, "CliOper", "", "", "0X8006404", "0X8006404", paramInt, 0, "", "", "", "");
      return;
      paramInt = 2;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pfu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */