import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ond
  implements Animator.AnimatorListener
{
  public ond(AvatarPendantActivity paramAvatarPendantActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    int i = 0;
    if ((this.a.a.getTag() instanceof Integer)) {
      i = ((Integer)this.a.a.getTag()).intValue();
    }
    i += 1;
    this.a.a.setTag(Integer.valueOf(i));
    if (i < 3)
    {
      this.a.a.postDelayed(new one(this), 1500L);
      return;
    }
    AvatarPendantActivity.b(this.a, true);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ond.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */