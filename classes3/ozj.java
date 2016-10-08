import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ozj
  implements ValueAnimator.AnimatorUpdateListener
{
  public ozj(FlowCameraActivity2 paramFlowCameraActivity2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Integer)paramValueAnimator.getAnimatedValue();
    this.a.c.setBackgroundColor(paramValueAnimator.intValue());
    this.a.b.setBackgroundColor(paramValueAnimator.intValue());
    this.a.a.setBackgroundColor(paramValueAnimator.intValue());
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ozj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */