import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.TroopPrivateSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.qphone.base.util.BaseApplication;

public class mwf
  implements DialogInterface.OnClickListener
{
  public mwf(TroopPrivateSettingActivity paramTroopPrivateSettingActivity, QQCustomDialog paramQQCustomDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopPrivateSettingActivity.a == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopPrivateSettingActivity.a = new QQProgressNotifier(this.jdField_a_of_type_ComTencentMobileqqActivityTroopPrivateSettingActivity);
    }
    paramDialogInterface = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqActivityTroopPrivateSettingActivity.app.a(20);
    if ((NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqActivityTroopPrivateSettingActivity.app.a().getApplicationContext())) && (paramDialogInterface != null))
    {
      paramDialogInterface.i(this.jdField_a_of_type_ComTencentMobileqqActivityTroopPrivateSettingActivity.b);
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopPrivateSettingActivity.a.a(0, 2131369494, 0);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.cancel();
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopPrivateSettingActivity.app, "CliOper", "", "", "Grp", "Dismiss_grp_OK", 0, 0, "", "", "", "");
      return;
      if (paramDialogInterface != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopPrivateSettingActivity.a.a(2, 2131368805, 1500);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopPrivateSettingActivity.a.a(2, 2131369498, 1500);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mwf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */