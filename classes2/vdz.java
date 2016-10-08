import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.NearbyMemberActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class vdz
  implements DialogInterface.OnClickListener
{
  public vdz(NearbyMemberActivity paramNearbyMemberActivity, QQCustomDialog paramQQCustomDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.cancel();
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyMemberActivity.doOnBackPressed();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vdz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */