import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;

public final class uxk
  implements DialogInterface.OnClickListener
{
  public uxk(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    SubAccountAssistantForward.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    SubAccountAssistantForward.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    SubAccountAssistantForward.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    SubAccountAssistantForward.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    paramDialogInterface = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, SplashActivity.class);
    paramDialogInterface.putExtra("tab_index", MainFragment.a);
    paramDialogInterface.setFlags(67108864);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramDialogInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uxk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */