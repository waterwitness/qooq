import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qvw
  implements TextWatcher
{
  int jdField_a_of_type_Int;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  
  public qvw(BusinessCardEditActivity paramBusinessCardEditActivity, int paramInt, EditText paramEditText)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidWidgetEditText = paramEditText;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if (paramEditable.getBytes().length > this.jdField_a_of_type_Int)
    {
      while (paramEditable.getBytes().length > this.jdField_a_of_type_Int) {
        paramEditable = paramEditable.substring(0, paramEditable.length() - 1);
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setText(paramEditable);
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(paramEditable.length());
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\qvw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */