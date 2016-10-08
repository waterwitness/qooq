import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.hotchat.ui.GlowView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class svh
  implements ValueAnimator.AnimatorUpdateListener
{
  public svh(GlowView paramGlowView, float paramFloat1, float paramFloat2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f2 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    float f1 = (this.jdField_a_of_type_Float - 1.0F) * f2 + 1.0F;
    f2 = f2 * (this.b - 1.0F) + 1.0F;
    this.jdField_a_of_type_ComTencentMobileqqHotchatUiGlowView.a.setScaleX(f1);
    this.jdField_a_of_type_ComTencentMobileqqHotchatUiGlowView.a.setScaleY(f1);
    this.jdField_a_of_type_ComTencentMobileqqHotchatUiGlowView.b.setScaleX(f2);
    this.jdField_a_of_type_ComTencentMobileqqHotchatUiGlowView.b.setScaleY(f2);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\svh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */