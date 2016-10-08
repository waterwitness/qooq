import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lsr
  implements TextWatcher
{
  public lsr(LoginActivity paramLoginActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramCharSequence.length() > 0) {
      if (this.a.b != null) {
        this.a.b.setVisibility(0);
      }
    }
    while (paramCharSequence.length() > 4)
    {
      this.a.a(paramCharSequence.toString());
      return;
      if ((this.a.b != null) && (this.a.b.isShown())) {
        this.a.b.setVisibility(8);
      }
    }
    this.a.a.setImageResource(2130838678);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lsr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */