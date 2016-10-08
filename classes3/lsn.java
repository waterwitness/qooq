import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout;

class lsn
  implements Animation.AnimationListener
{
  lsn(lsm paramlsm)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.jdField_a_of_type_AndroidViewView.clearAnimation();
    this.a.a.jdField_a_of_type_AndroidViewView.setAnimation(null);
    this.a.a.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout.invalidate();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lsn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */