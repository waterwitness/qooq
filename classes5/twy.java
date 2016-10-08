import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.view.ProfileTagView;

public class twy
  implements Animation.AnimationListener
{
  public twy(ProfileTagView paramProfileTagView, View paramView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    ProfileTagView.b(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView);
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    ProfileTagView.b(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView, false);
    if (ProfileTagView.c(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView) == 0) {
      ProfileTagView.d(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\twy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */