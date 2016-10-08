import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class msr
  implements DialogInterface.OnClickListener
{
  public msr(TroopMemberCardActivity paramTroopMemberCardActivity, QQCustomDialog paramQQCustomDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.a.a((byte)0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.t, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.v);
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.b(2131367376);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.app, "P_CliOper", "Grp_manage", "", "mber_card", "un_admin", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.t, "", "", "");
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.cancel();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\msr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */