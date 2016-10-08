import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.freshnews.FreshNewsDragGridView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class spo
  extends AnimatorListenerAdapter
{
  public spo(FreshNewsDragGridView paramFreshNewsDragGridView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    FreshNewsDragGridView.b(this.a, true);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    FreshNewsDragGridView.b(this.a, true);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    FreshNewsDragGridView.b(this.a, false);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\spo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */