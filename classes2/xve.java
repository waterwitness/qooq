import android.text.Spanned;
import android.text.method.NumberKeyListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.TCWNumberPicker;

public class xve
  extends NumberKeyListener
{
  private xve(TCWNumberPicker paramTCWNumberPicker)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    CharSequence localCharSequence2 = super.filter(paramCharSequence, paramInt1, paramInt2, paramSpanned, paramInt3, paramInt4);
    CharSequence localCharSequence1 = localCharSequence2;
    if (localCharSequence2 == null) {
      localCharSequence1 = paramCharSequence.subSequence(paramInt1, paramInt2);
    }
    paramCharSequence = String.valueOf(paramSpanned.subSequence(0, paramInt3)) + localCharSequence1 + paramSpanned.subSequence(paramInt4, paramSpanned.length());
    if ("".equals(paramCharSequence)) {
      localCharSequence1 = paramCharSequence;
    }
    while (TCWNumberPicker.a(this.a, paramCharSequence) <= TCWNumberPicker.b(this.a)) {
      return localCharSequence1;
    }
    return "";
  }
  
  protected char[] getAcceptedChars()
  {
    return TCWNumberPicker.a();
  }
  
  public int getInputType()
  {
    return 2;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xve.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */