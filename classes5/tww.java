import android.graphics.PointF;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.view.ProfileTagView;
import com.tencent.mobileqq.profile.view.VipTagView;
import com.tencent.mobileqq.widget.RatioLayout.LayoutParams;
import java.util.List;

public class tww
  implements Animation.AnimationListener
{
  public tww(ProfileTagView paramProfileTagView, View paramView, PointF paramPointF)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    ProfileTagView.b(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView);
    paramAnimation = (RatioLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    if (paramAnimation != null)
    {
      if (this.jdField_a_of_type_AndroidViewView.getAnimation() != null) {
        this.jdField_a_of_type_AndroidViewView.clearAnimation();
      }
      if ((paramAnimation.a != this.jdField_a_of_type_AndroidGraphicsPointF.x) || (paramAnimation.b != this.jdField_a_of_type_AndroidGraphicsPointF.y))
      {
        paramAnimation.a = this.jdField_a_of_type_AndroidGraphicsPointF.x;
        paramAnimation.b = this.jdField_a_of_type_AndroidGraphicsPointF.y;
        this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramAnimation);
        if ((this.jdField_a_of_type_AndroidViewView instanceof VipTagView)) {
          ((VipTagView)this.jdField_a_of_type_AndroidViewView).setShakingState(true);
        }
      }
      ProfileTagView.b(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView, false);
      if (ProfileTagView.c(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView) == 0) {
        if (!ProfileTagView.d(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView))
        {
          paramAnimation = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.a.a.getLabelList();
          if (paramAnimation != null)
          {
            if ((ProfileTagView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView)[(ProfileTagView.a().length - 1)] == null) || (paramAnimation.size() != 0)) {
              break label238;
            }
            ProfileTagView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView).setVisibility(0);
          }
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.b)
      {
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.h(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.a);
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.b = false;
      }
      return;
      label238:
      ProfileTagView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView).setVisibility(4);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tww.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */