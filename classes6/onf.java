import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class onf
  implements ValueAnimator.AnimatorUpdateListener
{
  public onf(AvatarPendantActivity paramAvatarPendantActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.a.setAlpha(f);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\onf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */