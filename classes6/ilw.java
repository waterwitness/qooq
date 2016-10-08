import android.animation.ObjectAnimator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.biz.qqstory.pgc.view.BaseCoverView;
import com.tencent.biz.qqstory.view.widget.StrokeTextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ilw
  implements Animation.AnimationListener
{
  public ilw(BaseCoverView paramBaseCoverView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = new AlphaAnimation(0.7F, 1.0F);
    paramAnimation.setDuration(600L);
    paramAnimation.setRepeatCount(-1);
    paramAnimation.setRepeatMode(2);
    this.a.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStrokeTextView.startAnimation(paramAnimation);
    this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    if (this.a.jdField_a_of_type_AndroidAnimationObjectAnimator != null)
    {
      if (this.a.jdField_a_of_type_AndroidAnimationObjectAnimator.isRunning()) {
        this.a.jdField_a_of_type_AndroidAnimationObjectAnimator.cancel();
      }
      this.a.jdField_a_of_type_AndroidAnimationObjectAnimator.setTarget(null);
    }
    this.a.jdField_a_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this.a.jdField_a_of_type_AndroidWidgetImageView, "alpha", new float[] { 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F });
    this.a.jdField_a_of_type_AndroidAnimationObjectAnimator.setDuration(1200L);
    this.a.jdField_a_of_type_AndroidAnimationObjectAnimator.setRepeatCount(-1);
    BaseCoverView.a(this.a, this.a.jdField_a_of_type_AndroidAnimationObjectAnimator, 100L);
    if (this.a.jdField_b_of_type_AndroidAnimationObjectAnimator != null)
    {
      if (this.a.jdField_b_of_type_AndroidAnimationObjectAnimator.isRunning()) {
        this.a.jdField_b_of_type_AndroidAnimationObjectAnimator.cancel();
      }
      this.a.jdField_b_of_type_AndroidAnimationObjectAnimator.setTarget(null);
    }
    this.a.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    this.a.jdField_b_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this.a.jdField_b_of_type_AndroidWidgetImageView, "alpha", new float[] { 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F });
    this.a.jdField_b_of_type_AndroidAnimationObjectAnimator.setDuration(1200L);
    this.a.jdField_b_of_type_AndroidAnimationObjectAnimator.setRepeatCount(-1);
    BaseCoverView.a(this.a, this.a.jdField_b_of_type_AndroidAnimationObjectAnimator, 240L);
    if (this.a.jdField_c_of_type_AndroidAnimationObjectAnimator != null)
    {
      if (this.a.jdField_c_of_type_AndroidAnimationObjectAnimator.isRunning()) {
        this.a.jdField_c_of_type_AndroidAnimationObjectAnimator.cancel();
      }
      this.a.jdField_c_of_type_AndroidAnimationObjectAnimator.setTarget(null);
    }
    this.a.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    this.a.jdField_c_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this.a.jdField_c_of_type_AndroidWidgetImageView, "alpha", new float[] { 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F });
    this.a.jdField_c_of_type_AndroidAnimationObjectAnimator.setDuration(1200L);
    this.a.jdField_c_of_type_AndroidAnimationObjectAnimator.setRepeatCount(-1);
    BaseCoverView.a(this.a, this.a.jdField_c_of_type_AndroidAnimationObjectAnimator, 360L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ilw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */