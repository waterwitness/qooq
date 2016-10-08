import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qqconnect.wtlogin.Login;

public class xhe
  implements TextWatcher
{
  public xhe(Login paramLogin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 < 2)
    {
      this.a.jdField_b_of_type_Boolean = false;
      if (paramCharSequence.length() == 0) {
        this.a.jdField_b_of_type_AndroidViewView.setVisibility(4);
      }
    }
    else
    {
      return;
    }
    this.a.jdField_b_of_type_AndroidViewView.setVisibility(0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xhe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */