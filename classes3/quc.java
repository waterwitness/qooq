import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import com.tencent.mobileqq.bubble.BubbleNewAIOAnim;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class quc
  extends AnimatorListenerAdapter
{
  public quc(BubbleNewAIOAnim paramBubbleNewAIOAnim, ObjectAnimator paramObjectAnimator)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\quc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */