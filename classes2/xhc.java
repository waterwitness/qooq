import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qqconnect.wtlogin.Login;

public class xhc
  implements View.OnTouchListener
{
  public xhc(Login paramLogin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView == this.a.jdField_b_of_type_AndroidWidgetEditText) {
      if ((paramMotionEvent.getAction() == 0) && (this.a.jdField_b_of_type_AndroidWidgetEditText.getText().length() > 0)) {
        this.a.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
    }
    while ((paramView != this.a.jdField_a_of_type_AndroidWidgetEditText) || (paramMotionEvent.getAction() != 0) || (this.a.jdField_a_of_type_AndroidWidgetEditText.getText().length() <= 0)) {
      return false;
    }
    this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xhc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */