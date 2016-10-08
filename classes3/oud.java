import android.content.Context;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.activity.qwallet.fragment.CommonHbFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class oud
  implements TextView.OnEditorActionListener
{
  public oud(CommonHbFragment paramCommonHbFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 6) || ((paramKeyEvent != null) && (paramKeyEvent.getKeyCode() == 66)))
    {
      if (CommonHbFragment.a(this.a).isEnabled()) {
        CommonHbFragment.a(this.a).performClick();
      }
      ((InputMethodManager)paramTextView.getContext().getSystemService("input_method")).hideSoftInputFromWindow(CommonHbFragment.a(this.a).getWindowToken(), 0);
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oud.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */