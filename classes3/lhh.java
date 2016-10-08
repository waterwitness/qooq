import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.activity.EditInfoActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;

public class lhh
  implements TextWatcher
{
  public lhh(EditInfoActivity paramEditInfoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramCharSequence == null) || (paramCharSequence.length() == 0))
    {
      this.a.v = ("" + this.a.m);
      this.a.a.post(new lhi(this));
      return;
    }
    for (;;)
    {
      try
      {
        if (this.a.p != 0) {
          break label230;
        }
        paramInt1 = paramCharSequence.toString().getBytes("utf-8").length;
        this.a.v = ("" + (this.a.m - paramInt1));
        if (this.a.v.length() > 4) {
          this.a.v = (this.a.v.substring(0, 2) + "…");
        }
        this.a.a.post(new lhj(this, paramInt1));
        return;
      }
      catch (UnsupportedEncodingException paramCharSequence) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("IphoneTitleBarActivity", 2, "UnsupportedEncodingException" + paramCharSequence.getMessage());
      return;
      label230:
      paramInt1 = paramCharSequence.toString().length();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lhh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */