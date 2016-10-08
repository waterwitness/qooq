import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.view.helper.ShakeEffectGenerator;

public class txu
  implements Animation.AnimationListener
{
  public txu(ShakeEffectGenerator paramShakeEffectGenerator)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (!ShakeEffectGenerator.a(this.a)) {
      for (;;)
      {
        int j = (int)(ShakeEffectGenerator.a(this.a) * (Math.random() * 2.0D - 1.0D));
        int i = (int)Math.sqrt(ShakeEffectGenerator.a(this.a) * ShakeEffectGenerator.a(this.a) - j * j);
        if (Math.random() > 0.5D) {}
        while ((ShakeEffectGenerator.b(this.a) + j) * (ShakeEffectGenerator.b(this.a) + j) + (ShakeEffectGenerator.c(this.a) + i) * (ShakeEffectGenerator.c(this.a) + i) <= ShakeEffectGenerator.d(this.a) * ShakeEffectGenerator.d(this.a))
        {
          ShakeEffectGenerator.a(this.a, new TranslateAnimation(ShakeEffectGenerator.b(this.a), ShakeEffectGenerator.b(this.a) + j, ShakeEffectGenerator.c(this.a), ShakeEffectGenerator.c(this.a) + i));
          ShakeEffectGenerator.a(this.a, j);
          ShakeEffectGenerator.b(this.a, i);
          ShakeEffectGenerator.a(this.a).setAnimationListener(ShakeEffectGenerator.a(this.a));
          ShakeEffectGenerator.a(this.a).setDuration(ShakeEffectGenerator.a(this.a) * (int)(50.0D + Math.random() * 30.0D));
          ShakeEffectGenerator.a(this.a).startAnimation(ShakeEffectGenerator.a(this.a));
          return;
          i = -i;
        }
      }
    }
    ShakeEffectGenerator.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\txu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */