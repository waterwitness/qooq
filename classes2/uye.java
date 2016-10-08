import android.os.Handler;
import android.widget.EditText;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.t9search.T9KeyBoard;

public class uye
  implements Runnable
{
  public uye(T9KeyBoard paramT9KeyBoard)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.jdField_a_of_type_AndroidWidgetEditText != null) {
      this.a.a(false, this.a.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart() - 1);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 50L);
      return;
      this.a.a(false);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uye.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */