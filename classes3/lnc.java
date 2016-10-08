import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.FriendProfileImageActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lnc
  implements Animation.AnimationListener
{
  public lnc(FriendProfileImageActivity paramFriendProfileImageActivity, TextView paramTextView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.clearAnimation();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageActivity.f) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lnc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */