import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.hotchat.anim.HeartBeatAnimator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class svc
  extends AnimatorListenerAdapter
{
  public svc(HeartBeatAnimator paramHeartBeatAnimator)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.b();
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.b();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\svc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */