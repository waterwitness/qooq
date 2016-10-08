import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ozi
  implements ValueAnimator.AnimatorUpdateListener
{
  public ozi(FlowCameraActivity2 paramFlowCameraActivity2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Integer)paramValueAnimator.getAnimatedValue();
    if (FlowCameraActivity2.a(this.a))
    {
      localLayoutParams = this.a.a.getLayoutParams();
      localLayoutParams.height = paramValueAnimator.intValue();
      this.a.a.setLayoutParams(localLayoutParams);
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = this.a.b.getLayoutParams();
    localLayoutParams.height = paramValueAnimator.intValue();
    this.a.b.setLayoutParams(localLayoutParams);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ozi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */