import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.recent.AnonymousEntranceView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ovi
  implements Animation.AnimationListener
{
  public ovi(AnonymousEntranceView paramAnonymousEntranceView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (AnonymousEntranceView.a(this.a) != null) {
      AnonymousEntranceView.a(this.a).setVisibility(4);
    }
    if (AnonymousEntranceView.b(this.a) != null)
    {
      AnonymousEntranceView.b(this.a).clearAnimation();
      AnonymousEntranceView.b(this.a).startAnimation(AnonymousEntranceView.a(this.a));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (AnonymousEntranceView.a(this.a) != null) {
      AnonymousEntranceView.a(this.a).setVisibility(0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ovi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */