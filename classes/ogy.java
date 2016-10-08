import android.os.MessageQueue.IdleHandler;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ogy
  implements MessageQueue.IdleHandler
{
  public ogy(ClassificationSearchActivity paramClassificationSearchActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean queueIdle()
  {
    this.a.a.requestFocus();
    ((InputMethodManager)this.a.getSystemService("input_method")).showSoftInput(this.a.a, 0);
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ogy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */