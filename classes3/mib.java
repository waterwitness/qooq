import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.RegisterActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class mib
  implements DialogInterface.OnClickListener
{
  public mib(RegisterActivity paramRegisterActivity, String paramString1, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    RegisterActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterActivity, "请稍候，请保证发送短信" + this.jdField_a_of_type_JavaLangString + "至" + this.b + "成功");
    RegisterActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterActivity);
    RegisterActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterActivity, 60000L);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mib.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */