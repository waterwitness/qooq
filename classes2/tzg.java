import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.qcall.LightalkSwitchHanlder;
import com.tencent.mobileqq.qcall.QCallDetailActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;

class tzg
  implements DialogInterface.OnClickListener
{
  tzg(tzf paramtzf, QQCustomDialog paramQQCustomDialog, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    boolean bool = true;
    if (paramInt == 0) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    while (paramInt != 1) {
      return;
    }
    paramDialogInterface = QCallDetailActivity.a(this.jdField_a_of_type_Tzf.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity);
    long l = this.jdField_a_of_type_Long;
    if (!this.jdField_a_of_type_Tzf.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      paramDialogInterface.a(l, bool);
      QCallDetailActivity.a(this.jdField_a_of_type_Tzf.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity).a((byte)0);
      return;
      bool = false;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */