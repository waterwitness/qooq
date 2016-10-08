import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class oif
  implements TextWatcher
{
  public oif(SearchContactsActivity paramSearchContactsActivity, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsActivity.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    SearchContactsActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsActivity, str);
    paramEditable = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsActivity.jdField_a_of_type_AndroidWidgetImageButton;
    int i;
    Button localButton;
    if (str.equals(""))
    {
      i = 8;
      paramEditable.setVisibility(i);
      localButton = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsActivity.jdField_a_of_type_AndroidWidgetButton;
      if (str.equals("")) {
        break label143;
      }
    }
    label143:
    for (paramEditable = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsActivity.getResources().getString(2131368226);; paramEditable = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsActivity.getResources().getString(2131367262))
    {
      localButton.setText(paramEditable);
      if (AppSetting.j) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsActivity.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsActivity.jdField_a_of_type_AndroidWidgetButton.getText().toString());
      }
      if (this.jdField_a_of_type_Boolean) {
        ((SearchContactsFragment)this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsActivity.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment).c(str);
      }
      return;
      i = 0;
      break;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oif.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */