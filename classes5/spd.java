import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.freshnews.FreshNewsDetailActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class spd
  implements Animation.AnimationListener
{
  public spd(FreshNewsDetailActivity paramFreshNewsDetailActivity, TextView paramTextView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    ((FrameLayout)this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsDetailActivity.getWindow().getDecorView()).removeView(this.jdField_a_of_type_AndroidWidgetTextView);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\spd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */