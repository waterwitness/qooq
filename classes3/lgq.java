import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.activity.DiscussionMemberActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lgq
  implements View.OnTouchListener
{
  public lgq(DiscussionMemberActivity paramDiscussionMemberActivity, InputMethodManager paramInputMethodManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lgq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */