import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.hotchat.ui.HotChatPttStageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class svm
  implements Animator.AnimatorListener
{
  public svm(HotChatPttStageView paramHotChatPttStageView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.a = true;
    this.a.b = false;
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.b = true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\svm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */