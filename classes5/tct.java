import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.maproam.widget.RoamSearchDialog;

public class tct
  implements TextWatcher
{
  public tct(RoamSearchDialog paramRoamSearchDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (this.a.a.getText().toString().trim().length() == 0)
    {
      this.a.findViewById(2131300880).setVisibility(8);
      return;
    }
    this.a.findViewById(2131300880).setVisibility(0);
    this.a.a();
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */