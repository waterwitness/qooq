import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.CustomSafeEditText;
import com.tencent.mobileqq.widget.DropdownView;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.List;

class ltk
  implements View.OnClickListener
{
  ltk(lti paramlti, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Lti.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.removeTextChangedListener(this.jdField_a_of_type_Lti.a.b);
    paramView = (SimpleAccount)this.jdField_a_of_type_Lti.a.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
    LoginActivity.a(this.jdField_a_of_type_Lti.a, paramView);
    this.jdField_a_of_type_Lti.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.addTextChangedListener(this.jdField_a_of_type_Lti.a.b);
    this.jdField_a_of_type_Lti.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.clearFocus();
    this.jdField_a_of_type_Lti.a.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.clearFocus();
    this.jdField_a_of_type_Lti.a.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setClearButtonVisible(false);
    this.jdField_a_of_type_Lti.a.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView.a().setVisibility(8);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ltk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */