import android.app.Activity;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.activity.qwallet.fragment.QzoneHbFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ouq
  implements Runnable
{
  public ouq(QzoneHbFragment paramQzoneHbFragment, Activity paramActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ((InputMethodManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("input_method")).toggleSoftInput(0, 2);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ouq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */