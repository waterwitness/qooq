import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import com.tencent.biz.qqstory.pgc.PgcSearchActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ika
  implements View.OnTouchListener
{
  public ika(PgcSearchActivity paramPgcSearchActivity, InputMethodManager paramInputMethodManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ika.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */