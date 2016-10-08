import android.graphics.PointF;
import android.view.animation.Transformation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.view.ProfileTagView;
import com.tencent.mobileqq.profile.view.VipTagView;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ValueAnimation.AnimationUpdateListener;
import com.tencent.mobileqq.widget.RatioLayout;

public class txf
  implements ValueAnimation.AnimationUpdateListener
{
  public txf(ProfileTagView paramProfileTagView, VipTagView paramVipTagView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(ValueAnimation paramValueAnimation, float paramFloat, PointF paramPointF, Transformation paramTransformation)
  {
    ProfileTagView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView).a(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipTagView, paramPointF.x, paramPointF.y);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\txf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */