import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ohe
  implements TextWatcher
{
  public ohe(ClassificationSearchActivity paramClassificationSearchActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    String str = this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    paramEditable = this.a.jdField_a_of_type_AndroidWidgetImageButton;
    if (str.equals("")) {}
    for (int i = 8;; i = 0)
    {
      paramEditable.setVisibility(i);
      if (this.a.d != ClassificationSearchActivity.c) {
        break;
      }
      this.a.jdField_a_of_type_AndroidWidgetButton.setText(this.a.getResources().getString(2131367262));
      if (AppSetting.j) {
        this.a.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.a.jdField_a_of_type_AndroidWidgetButton.getText().toString());
      }
      if ((str.equals("")) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment != null))
      {
        if (this.a.d != ClassificationSearchActivity.jdField_a_of_type_Int) {
          break label207;
        }
        ClassificationSearchActivity.a(this.a);
      }
      return;
    }
    Button localButton = this.a.jdField_a_of_type_AndroidWidgetButton;
    if (!str.equals("")) {}
    for (paramEditable = this.a.getResources().getString(2131368226);; paramEditable = this.a.getResources().getString(2131367262))
    {
      localButton.setText(paramEditable);
      break;
    }
    label207:
    this.a.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.g();
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ohe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */