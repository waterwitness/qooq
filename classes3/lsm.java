import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lsm
  implements Runnable
{
  public lsm(LoginActivity paramLoginActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.a.setVisibility(0);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    localTranslateAnimation.setInterpolator(new DecelerateInterpolator());
    localTranslateAnimation.setDuration(500L);
    localTranslateAnimation.setFillAfter(true);
    localTranslateAnimation.setAnimationListener(new lsn(this));
    this.a.a.startAnimation(localTranslateAnimation);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lsm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */