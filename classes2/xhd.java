import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qqconnect.wtlogin.Login;

public class xhd
  implements TextWatcher
{
  public xhd(Login paramLogin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramCharSequence.length() == 0) {
      this.a.a.setVisibility(4);
    }
    for (;;)
    {
      this.a.jdField_b_of_type_Boolean = false;
      this.a.jdField_b_of_type_AndroidWidgetEditText.setText("");
      return;
      if (paramInt3 < 2) {
        this.a.a.setVisibility(0);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xhd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */