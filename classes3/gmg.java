import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import com.tencent.av.random.ui.RandomMultiActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class gmg
  implements Animation.AnimationListener
{
  gmg(gmf paramgmf)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.a.a.b != null) {
      this.a.a.b.setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gmg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */