import android.text.Editable;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.CustomSafeEditText;

public class lsy
  implements View.OnFocusChangeListener
{
  public lsy(LoginActivity paramLoginActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramView == this.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView) {
      if (true == paramBoolean)
      {
        if (this.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.isPopupShowing()) {
          this.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.dismissDropDown();
        }
        if ((this.a.b != null) && (this.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().length() > 0)) {
          this.a.b.setVisibility(0);
        }
        this.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setSelection(this.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().length());
      }
    }
    while ((paramView != this.a.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText) || (true != paramBoolean))
    {
      do
      {
        return;
      } while ((this.a.b == null) || (!this.a.b.isShown()));
      this.a.b.setVisibility(8);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setSelection(this.a.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.getText().length());
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lsy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */