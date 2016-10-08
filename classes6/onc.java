import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class onc
  implements ValueAnimator.AnimatorUpdateListener
{
  public onc(AvatarPendantActivity paramAvatarPendantActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.a.a.setTranslationY(i);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\onc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */