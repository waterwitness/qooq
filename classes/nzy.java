import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class nzy
  implements Animation.AnimationListener
{
  public nzy(PublicAccountChatPie paramPublicAccountChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.M = false;
    this.a.dT = 0;
    this.a.N = false;
    this.a.X = false;
    this.a.W = false;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.a(this.a.h, PublicAccountChatPie.a(this.a));
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nzy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */