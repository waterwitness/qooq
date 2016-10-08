import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.share.QZoneShareActivity;

public class ypj
  implements TextWatcher
{
  public ypj(QZoneShareActivity paramQZoneShareActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (((paramInt2 == 1) || (paramInt2 == 2)) && (paramInt3 == 0)) {
      try
      {
        QZoneShareActivity.b(this.a, QZoneShareActivity.a(this.a, paramCharSequence, paramInt1 + paramInt2));
        if (QZoneShareActivity.b(this.a) == -1)
        {
          QZoneShareActivity.b(this.a);
          return;
        }
        QZoneShareActivity.c(this.a, paramInt1);
        QZoneShareActivity.a(this.a, paramCharSequence.toString().substring(QZoneShareActivity.b(this.a), QZoneShareActivity.c(this.a) + paramInt2));
        return;
      }
      catch (Exception paramCharSequence)
      {
        QZoneShareActivity.b(this.a);
      }
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.a.removeTextChangedListener(this);
    if (paramCharSequence == null)
    {
      this.a.a.addTextChangedListener(this);
      QZoneShareActivity.b(this.a);
      return;
    }
    if (QZoneShareActivity.a(this.a, QZoneShareActivity.a(this.a), false)) {
      this.a.a.getEditableText().delete(QZoneShareActivity.b(this.a), QZoneShareActivity.c(this.a));
    }
    QZoneShareActivity.b(this.a);
    this.a.i();
    this.a.a.addTextChangedListener(this);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ypj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */