import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.XPanelContainer;

public class odr
  implements Animation.AnimationListener
{
  public odr(TroopChatPie paramTroopChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    TroopChatPie.a(this.a).setBackgroundResource(2130839791);
    TroopChatPie.b(this.a).setBackgroundResource(2130839791);
    this.a.j.setVisibility(8);
    this.a.k.setVisibility(8);
    this.a.h.setVisibility(0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.j.setVisibility(0);
    this.a.k.setVisibility(0);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\odr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */