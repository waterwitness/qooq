import android.content.Context;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.activity.qwallet.TransactionActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class otw
  implements TextView.OnEditorActionListener
{
  public otw(TransactionActivity paramTransactionActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 6) || ((paramKeyEvent != null) && (paramKeyEvent.getKeyCode() == 66)))
    {
      if (TransactionActivity.b(this.a).isEnabled()) {
        TransactionActivity.b(this.a).performClick();
      }
      ((InputMethodManager)TransactionActivity.a(this.a).getSystemService("input_method")).hideSoftInputFromWindow(TransactionActivity.c(this.a).getWindowToken(), 0);
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\otw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */