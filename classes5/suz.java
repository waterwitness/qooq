import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.hotchat.anim.HeartAnimator;
import com.tencent.mobileqq.hotchat.anim.HeartAnimator.HeartAnimatorListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.concurrent.atomic.AtomicInteger;

public class suz
  implements Animation.AnimationListener
{
  public suz(HeartAnimator paramHeartAnimator, ViewGroup paramViewGroup, View paramView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator.jdField_a_of_type_AndroidOsHandler.post(new sva(this));
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet();
    if (HeartAnimator.a(this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator) != null) {
      HeartAnimator.a(this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator).b(paramAnimation);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
    if (HeartAnimator.a(this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator) != null) {
      HeartAnimator.a(this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator).a(paramAnimation);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\suz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */