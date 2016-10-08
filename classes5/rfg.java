import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.dating.DismissAnimationAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class rfg
  implements Animator.AnimatorListener
{
  public rfg(DismissAnimationAdapter paramDismissAnimationAdapter, List paramList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_ComTencentMobileqqDatingDismissAnimationAdapter.a(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */