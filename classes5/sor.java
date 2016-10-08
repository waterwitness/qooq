import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import com.tencent.mobileqq.freshnews.FreshNewsDetailActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class sor
  implements Animator.AnimatorListener
{
  public sor(FreshNewsDetailActivity paramFreshNewsDetailActivity, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsDetailActivity.e = true;
    paramAnimator = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsDetailActivity.c.getLayoutParams();
    paramAnimator.height = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsDetailActivity.c.setLayoutParams(paramAnimator);
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsDetailActivity.c.requestLayout();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */