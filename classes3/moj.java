import android.text.Editable;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.ClearableEditText;

public class moj
  implements View.OnFocusChangeListener
{
  public moj(SubLoginActivity paramSubLoginActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (true == paramBoolean) {
      SubLoginActivity.a(this.a).setSelection(SubLoginActivity.a(this.a).getText().length());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\moj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */