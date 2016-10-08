import android.text.TextPaint;
import android.text.style.CharacterStyle;
import com.tencent.mobileqq.activity.AuthDevActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class kky
  extends CharacterStyle
{
  public kky(AuthDevActivity paramAuthDevActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-5855578);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kky.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */