import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.TroopDisbandActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQCustomDialog;

class mqg
  implements DialogInterface.OnClickListener
{
  mqg(mqe parammqe, QQCustomDialog paramQQCustomDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.b(this.jdField_a_of_type_Mqe.a.app, "P_CliOper", "Grp_manage", "", "del_grp", "Clk_know", 0, 0, this.jdField_a_of_type_Mqe.a.b, "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.cancel();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mqg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */