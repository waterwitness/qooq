import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import com.tencent.mobileqq.activity.qwallet.fragment.QzoneHbFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class oum
  implements TextWatcher
{
  public oum(QzoneHbFragment paramQzoneHbFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    QzoneHbFragment.a(this.a).setEnabled(QzoneHbFragment.a(this.a));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */