import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.av.utils.RingAnimator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hbp
  implements Animation.AnimationListener
{
  public hbp(RingAnimator paramRingAnimator)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.a.b != null) {
      this.a.b.setVisibility(4);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\hbp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */