import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.biz.lebasearch.SearchActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hji
  implements View.OnTouchListener
{
  public hji(SearchActivity paramSearchActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.a.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    this.a.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
    this.a.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
    paramView = this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    this.a.a(paramView);
    this.a.jdField_a_of_type_AndroidWidgetEditText.setSelection(paramView.length());
    this.a.b = false;
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hji.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */