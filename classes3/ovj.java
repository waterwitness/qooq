import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.recent.AnonymousEntranceView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ovj
  implements Animation.AnimationListener
{
  public ovj(AnonymousEntranceView paramAnonymousEntranceView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (AnonymousEntranceView.b(this.a) != null) {
      AnonymousEntranceView.b(this.a).setVisibility(4);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (AnonymousEntranceView.b(this.a) != null) {
      AnonymousEntranceView.b(this.a).setVisibility(0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ovj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */