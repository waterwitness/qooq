import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.biz.lebasearch.SearchActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hjn
  implements TextWatcher
{
  private hjn(SearchActivity paramSearchActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (this.a.b == true)
    {
      this.a.b = false;
      if (SearchActivity.a(this.a) <= paramEditable.length()) {
        break label70;
      }
      this.a.a.setText("");
    }
    for (;;)
    {
      paramEditable = this.a.a.getText().toString();
      this.a.b(paramEditable);
      return;
      label70:
      paramEditable = paramEditable.toString().substring(SearchActivity.a(this.a));
      this.a.a.setText(paramEditable);
      this.a.a.setSelection(paramEditable.length());
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    SearchActivity.a(this.a, paramCharSequence.length());
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hjn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */