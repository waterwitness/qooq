import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.hotchat.HotChatPttStageControl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ListView;

public class suc
  implements Animator.AnimatorListener
{
  public suc(HotChatPttStageControl paramHotChatPttStageControl)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.a(false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.j = 0;
    this.a.a.setBackgroundResource(2130838119);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\suc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */