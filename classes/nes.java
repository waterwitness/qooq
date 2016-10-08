import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.activity.aio.anim.ComboAnimation3;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class nes
  extends AnimatorListenerAdapter
{
  public nes(ComboAnimation3 paramComboAnimation3)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.d();
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.d();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */