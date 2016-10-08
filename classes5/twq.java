import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.widget.ImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;

public class twq
  implements Animator.AnimatorListener
{
  public twq(ProfileHeaderView paramProfileHeaderView, ImageView paramImageView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleX(1.0F);
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleY(1.0F);
    this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(0.0F);
    if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a.setStartDelay(300L);
      this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a.start();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(0.0F);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\twq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */