import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.qcall.LightalkSwitchHanlder;
import com.tencent.mobileqq.qcall.QCallDetailActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;
import java.util.ArrayList;

class tzi
  implements DialogInterface.OnClickListener
{
  tzi(tzf paramtzf, QQCustomDialog paramQQCustomDialog, ShieldMsgManger paramShieldMsgManger, ArrayList paramArrayList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 0) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    while (paramInt != 1) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqManagersShieldMsgManger.b(this.jdField_a_of_type_Tzf.jdField_a_of_type_Int, this.jdField_a_of_type_JavaUtilArrayList);
    QCallDetailActivity.a(this.jdField_a_of_type_Tzf.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity).a((byte)0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */