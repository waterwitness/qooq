import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.fragment.NearbyFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class soe
  implements Animation.AnimationListener
{
  public soe(NearbyFragment paramNearbyFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (this.a.getActivity().getWindow().getDecorView().getBackground() == null) {
      this.a.getActivity().getWindow().getDecorView().setBackgroundResource(2130837958);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\soe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */