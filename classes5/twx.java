import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.View;
import android.view.animation.Transformation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.view.ProfileTagView;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ValueAnimation.AnimationUpdateListener;
import com.tencent.mobileqq.widget.RatioLayout;

public class twx
  implements ValueAnimation.AnimationUpdateListener
{
  public twx(ProfileTagView paramProfileTagView, View paramView, PointF paramPointF)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(ValueAnimation paramValueAnimation, float paramFloat, Float paramFloat1, Transformation paramTransformation)
  {
    paramTransformation.getMatrix().setScale(paramFloat1.floatValue(), paramFloat1.floatValue(), this.jdField_a_of_type_AndroidViewView.getWidth() * 0.5F, this.jdField_a_of_type_AndroidViewView.getHeight() * 0.5F);
    paramFloat = this.jdField_a_of_type_AndroidGraphicsPointF.x;
    float f1 = ProfileTagView.b(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView).x;
    float f2 = ProfileTagView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView).getWidth();
    float f3 = this.jdField_a_of_type_AndroidGraphicsPointF.y;
    float f4 = ProfileTagView.b(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView).y;
    float f5 = ProfileTagView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView).getHeight();
    paramTransformation.getMatrix().postTranslate((paramFloat - f1) * f2 * paramFloat1.floatValue(), (f3 - f4) * f5 * paramFloat1.floatValue());
    paramTransformation.getMatrix().postRotate(paramFloat1.floatValue() * 120.0F - 120.0F, this.jdField_a_of_type_AndroidViewView.getWidth() * 0.5F, this.jdField_a_of_type_AndroidViewView.getHeight() * 0.5F);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\twx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */