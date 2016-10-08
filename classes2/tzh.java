import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.qcall.LightalkShieldHandler;
import com.tencent.mobileqq.qcall.LightalkSwitchHanlder;
import com.tencent.mobileqq.qcall.QCallDetailActivity;
import com.tencent.mobileqq.qcall.UinUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;

class tzh
  implements DialogInterface.OnClickListener
{
  tzh(tzf paramtzf, QQCustomDialog paramQQCustomDialog)
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
    QCallDetailActivity.a(this.jdField_a_of_type_Tzf.a).b(10, UinUtils.a(QCallDetailActivity.a(this.jdField_a_of_type_Tzf.a)));
    QCallDetailActivity.a(this.jdField_a_of_type_Tzf.a).a((byte)0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */