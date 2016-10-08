import android.text.Spannable;
import android.text.Spannable.Factory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.text.QQText;

public final class uze
  extends Spannable.Factory
{
  public uze()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Spannable newSpannable(CharSequence paramCharSequence)
  {
    if ((!QQText.b) && ((paramCharSequence instanceof QQText))) {
      try
      {
        QQText localQQText = (QQText)((QQText)paramCharSequence).clone();
        return localQQText;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException) {}
    }
    return super.newSpannable(paramCharSequence);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */