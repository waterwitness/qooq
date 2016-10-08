import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.qqstory.pgc.view.DiscoverItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ima
  extends AnimatorListenerAdapter
{
  public ima(DiscoverItem paramDiscoverItem)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (paramAnimator != null)
    {
      paramAnimator.cancel();
      paramAnimator.setTarget(null);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ima.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */