import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.ClearableEditText;

public class wld
  implements TextWatcher
{
  public wld(ClearableEditText paramClearableEditText)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    paramCharSequence = this.a.getText().toString();
    if ((paramCharSequence == null) || (paramCharSequence.length() == 0))
    {
      this.a.setClearButtonVisible(false);
      return;
    }
    if (ClearableEditText.a(this.a))
    {
      this.a.setClearButtonVisible(true);
      return;
    }
    this.a.setClearButtonVisible(false);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\wld.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */