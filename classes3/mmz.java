import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.SubAccountMessageActivity;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;

public class mmz
  implements DialogInterface.OnClickListener
{
  public mmz(SubAccountMessageActivity paramSubAccountMessageActivity, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity.app.a().c(SubAccountMessageActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity).subuin, 7000);
    paramDialogInterface = (SubAccountManager)this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity.app.getManager(60);
    if (paramDialogInterface != null) {
      paramDialogInterface.b(SubAccountMessageActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity).subuin);
    }
    paramDialogInterface = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity, SubLoginActivity.class);
    paramDialogInterface.putExtra("is_need_bind", false);
    paramDialogInterface.putExtra("subuin", this.jdField_a_of_type_JavaLangString);
    paramDialogInterface.putExtra("fromWhere", this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity.startActivity(paramDialogInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity.b();
    this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mmz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */