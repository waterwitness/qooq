import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qqconnect.wtlogin.Login;

public class xhb
  implements View.OnFocusChangeListener
{
  public xhb(Login paramLogin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramView == this.a.jdField_b_of_type_AndroidWidgetEditText)
    {
      if (true == paramBoolean) {
        this.a.jdField_b_of_type_AndroidWidgetEditText.selectAll();
      }
      if (!paramBoolean) {
        this.a.jdField_b_of_type_AndroidViewView.setVisibility(4);
      }
    }
    while ((paramView != this.a.jdField_a_of_type_AndroidWidgetEditText) || (paramBoolean)) {
      return;
    }
    this.a.jdField_a_of_type_AndroidViewView.setVisibility(4);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xhb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */