import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.view.BreatheEffectView;
import com.tencent.mobileqq.profile.view.BreatheEffectView.BreatheListener;

public class tvy
  implements Animation.AnimationListener
{
  public tvy(BreatheEffectView paramBreatheEffectView, BreatheEffectView.BreatheListener paramBreatheListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileViewBreatheEffectView$BreatheListener.a();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tvy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */