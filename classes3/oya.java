import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.mobileqq.activity.recent.RecentT9SearchActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.t9search.T9KeyBoard;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;

public class oya
  implements TextWatcher
{
  public oya(RecentT9SearchActivity paramRecentT9SearchActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      if (VersionUtils.e())
      {
        paramCharSequence = (android.content.ClipboardManager)this.a.getSystemService("clipboard");
        if ((paramCharSequence.hasText()) && (paramCharSequence.getText() != null))
        {
          this.a.e = paramCharSequence.getText().toString();
          if (QLog.isColorLevel()) {
            QLog.d("RecentT9SearchActivity", 2, "isHoneycomb|before text:" + this.a.e);
          }
        }
      }
      else
      {
        paramCharSequence = (android.text.ClipboardManager)this.a.getSystemService("clipboard");
        if ((paramCharSequence.hasText()) && (paramCharSequence.getText() != null))
        {
          this.a.e = paramCharSequence.getText().toString();
          if (QLog.isColorLevel())
          {
            QLog.d("RecentT9SearchActivity", 2, "not isHoneycomb|before text:" + this.a.e);
            return;
          }
        }
      }
    }
    catch (NullPointerException paramCharSequence)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecentT9SearchActivity", 2, "beforeTextChanged NullPointerException. e:" + paramCharSequence.toString());
      }
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentT9SearchActivity", 2, new Object[] { "onTextChanged|s:%s, ks:%s", paramCharSequence, RecentT9SearchActivity.a(this.a).a() });
    }
    paramCharSequence = paramCharSequence.toString();
    if ((!paramCharSequence.equals(RecentT9SearchActivity.a(this.a).a())) && (!TextUtils.isEmpty(RecentT9SearchActivity.a(this.a).a())) && (!TextUtils.isEmpty(this.a.e)))
    {
      if (TextUtils.isEmpty(RecentT9SearchActivity.a(this.a, this.a.e))) {
        QQToast.a(this.a, 2131372461, 0).a();
      }
      paramCharSequence = RecentT9SearchActivity.a(this.a, paramCharSequence);
      RecentT9SearchActivity.a(this.a).setString(paramCharSequence);
      RecentT9SearchActivity.a(this.a).setSelection(paramCharSequence.length());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oya.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */