import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troopreward.TroopRewardDetailActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class vvy
  implements DialogInterface.OnClickListener
{
  public vvy(TroopRewardDetailActivity paramTroopRewardDetailActivity, QQCustomDialog paramQQCustomDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.cancel();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vvy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */