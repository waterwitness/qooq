import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.av.ui.MultiVideoCtrlLayerUI4Discussion;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gvr
  extends ClickableSpan
{
  public gvr(MultiVideoCtrlLayerUI4Discussion paramMultiVideoCtrlLayerUI4Discussion)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.a.I();
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(paramTextPaint.linkColor);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gvr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */