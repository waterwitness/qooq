import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qqfav.widget.LocationDetailActivity;

public class ygv
  implements Animation.AnimationListener
{
  public ygv(LocationDetailActivity paramLocationDetailActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.g.clearAnimation();
    this.a.g.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ygv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */