import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gsy
  implements Animation.AnimationListener
{
  public gsy(EffectSettingUi paramEffectSettingUi)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.a.b != null) {
      this.a.b.setVisibility(0);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gsy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */