import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class nbk
  extends ClickableSpan
{
  public nbk(ActivateFriendActivity paramActivateFriendActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.a.b();
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(Color.rgb(0, 165, 224));
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nbk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */