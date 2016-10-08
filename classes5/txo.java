import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.view.VipProfileSimpleView;

public class txo
  implements Animation.AnimationListener
{
  public txo(VipProfileSimpleView paramVipProfileSimpleView, ProfileCardInfo paramProfileCardInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileViewVipProfileSimpleView.b = true;
    this.jdField_a_of_type_ComTencentMobileqqProfileViewVipProfileSimpleView.h(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\txo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */