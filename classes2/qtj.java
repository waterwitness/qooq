import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.avatar.dynamicavatar.SelectCoverActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qtj
  extends AnimatorListenerAdapter
{
  public qtj(SelectCoverActivity paramSelectCoverActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.a = null;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.a = null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qtj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */