import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class llv
  implements Animator.AnimatorListener
{
  public llv(FriendProfileCardActivity paramFriendProfileCardActivity, TextView paramTextView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\llv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */