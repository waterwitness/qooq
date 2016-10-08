import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.mobileqq.widget.Rotate3dAnimation;

public class twk
  implements Animation.AnimationListener
{
  public twk(ProfileHeaderView paramProfileHeaderView, View paramView1, View paramView2, Rotate3dAnimation paramRotate3dAnimation)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    this.b.setVisibility(0);
    this.b.startAnimation(this.jdField_a_of_type_ComTencentMobileqqWidgetRotate3dAnimation);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\twk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */