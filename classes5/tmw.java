import android.content.res.Resources;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel;
import com.tencent.widget.immersive.ImmersiveTitleBar2;

public class tmw
  implements Animation.AnimationListener
{
  public tmw(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == NearbyProfileDisplayPanel.b(this.a))
    {
      NearbyProfileDisplayPanel.a(this.a).setVisibility(8);
      NearbyProfileDisplayPanel.a(this.a).setVisibility(4);
      NearbyProfileDisplayPanel.a(this.a).clearAnimation();
      NearbyProfileDisplayPanel.a(this.a).clearAnimation();
      NearbyProfileDisplayPanel.a(this.a).setBackgroundResource(2130842742);
      NearbyProfileDisplayPanel.a(this.a).setTextColor(this.a.a.getResources().getColor(2131428239));
      NearbyProfileDisplayPanel.b(this.a).setTextColor(this.a.a.getResources().getColor(2131428239));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (paramAnimation == NearbyProfileDisplayPanel.a(this.a))
    {
      NearbyProfileDisplayPanel.a(this.a).setVisibility(0);
      NearbyProfileDisplayPanel.a(this.a).setVisibility(0);
      NearbyProfileDisplayPanel.a(this.a).setBackgroundResource(2130843454);
      NearbyProfileDisplayPanel.a(this.a).setTextColor(this.a.a.getResources().getColor(2131428258));
      NearbyProfileDisplayPanel.b(this.a).setTextColor(this.a.a.getResources().getColor(2131428258));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tmw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */