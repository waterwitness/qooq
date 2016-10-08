import android.text.Editable;
import android.text.Editable.Factory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.text.QQTextBuilder;

public final class vib
  extends Editable.Factory
{
  public vib()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof QQTextBuilder)) {
      return (Editable)paramCharSequence;
    }
    return new QQTextBuilder(paramCharSequence, 3, 20);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vib.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */