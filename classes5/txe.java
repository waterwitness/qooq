import android.content.res.Resources;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.view.ProfileTagView;
import com.tencent.mobileqq.profile.view.VipTagView;

public class txe
  implements Animation.AnimationListener
{
  public txe(ProfileTagView paramProfileTagView, VipTagView paramVipTagView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    ProfileTagView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView, this.jdField_a_of_type_ComTencentMobileqqProfileViewVipTagView, true);
  }
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.a.a.a != 0) {
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipTagView.setTagColor(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.getResources().getColor(2131427557), this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.getResources().getColor(2131427556));
    }
  }
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\txe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */