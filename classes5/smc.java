import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.forward.ForwardSendHongBaoOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class smc
  implements DialogInterface.OnClickListener
{
  public smc(ForwardSendHongBaoOption paramForwardSendHongBaoOption, QQCustomDialog paramQQCustomDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardSendHongBaoOption.a.setResult(-1);
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardSendHongBaoOption.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\smc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */