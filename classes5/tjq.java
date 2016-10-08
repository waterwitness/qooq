import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity;

public class tjq
  implements Animation.AnimationListener
{
  public tjq(ChooseInterestTagActivity paramChooseInterestTagActivity, View paramView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    ChooseInterestTagActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyInterestTagChooseInterestTagActivity).postDelayed(new tjr(this), 100L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tjq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */