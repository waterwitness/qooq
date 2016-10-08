import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class msn
  implements DialogInterface.OnClickListener
{
  msn(msm parammsm, QQCustomDialog paramQQCustomDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (NetworkUtil.e(this.jdField_a_of_type_Msm.a.getApplicationContext()))
    {
      this.jdField_a_of_type_Msm.a.a.i(this.jdField_a_of_type_Msm.a.t);
      this.jdField_a_of_type_Msm.a.a(0, 2131369494, 0);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.cancel();
      }
      return;
      this.jdField_a_of_type_Msm.a.a(this.jdField_a_of_type_Msm.a.getString(2131368805));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\msn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */