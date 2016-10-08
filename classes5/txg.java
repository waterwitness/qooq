import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.view.ProfileTagView;
import com.tencent.mobileqq.profile.view.VipTagView;

public class txg
  implements Animation.AnimationListener
{
  public txg(ProfileTagView paramProfileTagView, boolean paramBoolean, VipTagView paramVipTagView)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.a.a.a != 0) && (this.jdField_a_of_type_ComTencentMobileqqProfileViewVipTagView.getTag(2131296458) != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileViewVipTagView.getTag(2131296458).equals(Boolean.valueOf(true))))
    {
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipTagView.setTag(2131296458, Boolean.valueOf(false));
      ProfileTagView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView, this.jdField_a_of_type_ComTencentMobileqqProfileViewVipTagView, ((Long)this.jdField_a_of_type_ComTencentMobileqqProfileViewVipTagView.getTag(2131296459)).longValue());
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqProfileViewVipTagView.setShakingState(true);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\txg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */