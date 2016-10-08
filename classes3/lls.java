import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lls
  implements Animator.AnimatorListener
{
  public lls(FriendProfileCardActivity paramFriendProfileCardActivity, TextView paramTextView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    int i = 0;
    if ((this.jdField_a_of_type_AndroidWidgetTextView.getTag() instanceof Integer)) {
      i = ((Integer)this.jdField_a_of_type_AndroidWidgetTextView.getTag()).intValue();
    }
    i += 1;
    this.jdField_a_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(i));
    if (i < 3)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.postDelayed(new llt(this), 1500L);
      return;
    }
    FriendProfileCardActivity.i(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lls.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */