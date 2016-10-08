import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.activity.TroopTransferActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class myg
  implements View.OnTouchListener
{
  public myg(TroopTransferActivity paramTroopTransferActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramMotionEvent = (InputMethodManager)this.a.getSystemService("input_method");
    if (paramMotionEvent != null) {
      paramMotionEvent.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\myg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */