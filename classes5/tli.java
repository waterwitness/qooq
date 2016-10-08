import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;

public class tli
  implements Animation.AnimationListener
{
  public tli(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    ((ViewGroup)NearbyPeopleProfileActivity.b(this.a)).removeView(NearbyPeopleProfileActivity.a(this.a));
    NearbyPeopleProfileActivity.a(this.a).a();
    NearbyPeopleProfileActivity.a(this.a, null);
    NearbyPeopleProfileActivity.a(this.a, null);
    if (NearbyPeopleProfileActivity.a(this.a) == null)
    {
      NearbyPeopleProfileActivity.a(this.a, new NearbyProfileDisplayPanel(this.a, NearbyPeopleProfileActivity.b(this.a)));
      NearbyPeopleProfileActivity.a(this.a).l();
    }
    NearbyPeopleProfileActivity.a(this.a).b(NearbyPeopleProfileActivity.a(this.a));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tli.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */