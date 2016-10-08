import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.apollo.store.ApolloGuestsStateActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;

public class prt
  implements Animation.AnimationListener
{
  private SoftReference a;
  
  public prt(ApolloGuestsStateActivity paramApolloGuestsStateActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new SoftReference(paramApolloGuestsStateActivity);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGuestsStateActivity", 2, "close animation end");
    }
    paramAnimation = (ApolloGuestsStateActivity)this.a.get();
    if (paramAnimation == null) {
      return;
    }
    paramAnimation.finish();
    paramAnimation.overridePendingTransition(2130968620, 2130968621);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    paramAnimation = (ApolloGuestsStateActivity)this.a.get();
    if (paramAnimation != null) {
      paramAnimation.f = true;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\prt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */