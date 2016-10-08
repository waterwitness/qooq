import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.LoginInfoActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ltv
  extends ClickableSpan
{
  private ltv(LoginInfoActivity paramLoginInfoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView) {}
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(paramTextPaint.linkColor);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ltv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */