import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.richstatus.RichStatusEditText;

public class uhp
  implements Runnable
{
  public uhp(EditActivity paramEditActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    EditActivity.a(this.a).requestFocus();
    ((InputMethodManager)this.a.getSystemService("input_method")).showSoftInput(EditActivity.a(this.a), 2);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uhp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */