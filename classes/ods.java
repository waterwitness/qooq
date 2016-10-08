import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.XPanelContainer;

public class ods
  implements Animation.AnimationListener
{
  public ods(TroopChatPie paramTroopChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.j.setVisibility(8);
    this.a.k.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    TroopChatPie.b(this.a).setBackgroundDrawable(this.a.a.a.a);
    TroopChatPie.c(this.a).setBackgroundResource(2130843150);
    TroopChatPie.a(this.a).setBackgroundResource(2130843012);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ods.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */