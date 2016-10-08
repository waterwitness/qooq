import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;

public class twp
  implements ValueAnimator.AnimatorUpdateListener
{
  public twp(ProfileHeaderView paramProfileHeaderView, ImageView paramImageView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = ((Integer)paramValueAnimator.getAnimatedValue()).intValue() * 1.0F / 700.0F;
    float f2 = 0.6F * f1 + 1.0F;
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleY(f2);
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleX(f2);
    this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(1.0F - f1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\twp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */