import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qqconnect.wtlogin.Login;

public class xha
  implements TextView.OnEditorActionListener
{
  public xha(Login paramLogin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 6)
    {
      this.a.b();
      return true;
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xha.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */