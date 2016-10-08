import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.dating.DismissAnimationAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rfk
  implements Animator.AnimatorListener
{
  public rfk(DismissAnimationAdapter paramDismissAnimationAdapter, View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_AndroidViewView.setAlpha(1.0F);
    this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams.height = -2;
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqDatingDismissAnimationAdapter.a();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rfk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */