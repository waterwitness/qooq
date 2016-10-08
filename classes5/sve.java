import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.hotchat.ui.GlowView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class sve
  implements Animator.AnimatorListener
{
  public sve(GlowView paramGlowView, long paramLong, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotchatUiGlowView.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqHotchatUiGlowView.jdField_a_of_type_AndroidWidgetRelativeLayout.setScaleX(1.0F);
    this.jdField_a_of_type_ComTencentMobileqqHotchatUiGlowView.jdField_a_of_type_AndroidWidgetRelativeLayout.setScaleY(1.0F);
    this.jdField_a_of_type_ComTencentMobileqqHotchatUiGlowView.jdField_b_of_type_AndroidWidgetImageView.setScaleX(1.0F);
    this.jdField_a_of_type_ComTencentMobileqqHotchatUiGlowView.jdField_b_of_type_AndroidWidgetImageView.setScaleY(1.0F);
    this.jdField_a_of_type_ComTencentMobileqqHotchatUiGlowView.jdField_a_of_type_AndroidAnimationValueAnimator = null;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHotchatUiGlowView.jdField_b_of_type_Boolean) {
      GlowView.a(this.jdField_a_of_type_ComTencentMobileqqHotchatUiGlowView, this.jdField_a_of_type_Long, this.jdField_a_of_type_Int);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqHotchatUiGlowView.jdField_a_of_type_AndroidAnimationValueAnimator = null;
      return;
      GlowView.a(this.jdField_a_of_type_ComTencentMobileqqHotchatUiGlowView);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sve.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */