import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.av.random.ui.RandomDoubleActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class glo
  implements Animation.AnimationListener
{
  public glo(RandomDoubleActivity paramRandomDoubleActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a(this.a.a, this.a.b);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\glo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */