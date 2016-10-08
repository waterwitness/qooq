import android.app.Dialog;
import android.widget.TextView;
import com.tencent.mobileqq.activity.VerifyPhoneNumActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class nal
  implements Runnable
{
  public nal(VerifyPhoneNumActivity paramVerifyPhoneNumActivity, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityVerifyPhoneNumActivity.a = new Dialog(this.jdField_a_of_type_ComTencentMobileqqActivityVerifyPhoneNumActivity, 2131558973);
    this.jdField_a_of_type_ComTencentMobileqqActivityVerifyPhoneNumActivity.a.setContentView(2130903052);
    ((TextView)this.jdField_a_of_type_ComTencentMobileqqActivityVerifyPhoneNumActivity.a.findViewById(2131296852)).setText(this.jdField_a_of_type_ComTencentMobileqqActivityVerifyPhoneNumActivity.getString(this.jdField_a_of_type_Int));
    this.jdField_a_of_type_ComTencentMobileqqActivityVerifyPhoneNumActivity.a.show();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\nal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */