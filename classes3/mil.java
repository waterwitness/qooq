import android.app.Dialog;
import android.widget.TextView;
import com.tencent.mobileqq.activity.RegisterBaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class mil
  implements Runnable
{
  public mil(RegisterBaseActivity paramRegisterBaseActivity, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterBaseActivity.a = new Dialog(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterBaseActivity, 2131558973);
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterBaseActivity.a.setContentView(2130903052);
    ((TextView)this.jdField_a_of_type_ComTencentMobileqqActivityRegisterBaseActivity.a.findViewById(2131296852)).setText(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterBaseActivity.getString(this.jdField_a_of_type_Int));
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterBaseActivity.a.show();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */