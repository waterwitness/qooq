import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class kjg
  implements View.OnTouchListener
{
  public kjg(AddFriendVerifyActivity paramAddFriendVerifyActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    ((InputMethodManager)this.a.getSystemService("input_method")).hideSoftInputFromWindow(this.a.leftView.getWindowToken(), 2);
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kjg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */