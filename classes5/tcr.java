import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.maproam.widget.RoamSearchDialog;

public class tcr
  implements View.OnTouchListener
{
  public tcr(RoamSearchDialog paramRoamSearchDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    ((InputMethodManager)this.a.a.getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tcr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */