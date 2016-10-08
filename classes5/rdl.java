import android.app.Dialog;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.dating.DatingDestinationActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rdl
  implements Animation.AnimationListener
{
  public rdl(DatingDestinationActivity paramDatingDestinationActivity, TranslateAnimation paramTranslateAnimation1, Dialog paramDialog, TranslateAnimation paramTranslateAnimation2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    if (paramAnimation == this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation)
    {
      this.jdField_a_of_type_AndroidAppDialog.show();
      localLayoutParams.height = (this.jdField_a_of_type_ComTencentMobileqqDatingDatingDestinationActivity.b.getHeight() + DatingDestinationActivity.a);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqDatingDatingDestinationActivity.b.setLayoutParams(localLayoutParams);
      return;
      if (paramAnimation == this.b) {
        localLayoutParams.height = (this.jdField_a_of_type_ComTencentMobileqqDatingDatingDestinationActivity.b.getHeight() - DatingDestinationActivity.a);
      }
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rdl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */