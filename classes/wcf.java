import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.QQCustomDialogWtihInput;
import java.lang.ref.SoftReference;
import java.util.TimerTask;

public class wcf
  extends TimerTask
{
  public wcf(QQCustomDialogWtihInput paramQQCustomDialogWtihInput)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Context localContext = (Context)QQCustomDialogWtihInput.a(this.a).get();
    if (localContext != null) {
      ((InputMethodManager)localContext.getSystemService("input_method")).toggleSoftInput(0, 2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\wcf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */