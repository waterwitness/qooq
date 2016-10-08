import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.welcomeguide.QQAVFunnyFaceInvest;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class pnl
  implements Animation.AnimationListener
{
  public pnl(QQAVFunnyFaceInvest paramQQAVFunnyFaceInvest)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QQAVFunnyFaceInvest.a(this.a)) {
      return;
    }
    QQAVFunnyFaceInvest.d(this.a);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (QQAVFunnyFaceInvest.a(this.a)) {
      return;
    }
    this.a.a.setVisibility(0);
    this.a.a.postDelayed(new pnm(this), 750L);
    this.a.a.postDelayed(new pnn(this), 800L);
    this.a.a.postDelayed(new pno(this), 850L);
    this.a.a.postDelayed(new pnp(this), 900L);
    this.a.a.postDelayed(new pnq(this), 950L);
    this.a.a.postDelayed(new pnr(this), 1000L);
    this.a.a.postDelayed(new pns(this), 1050L);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pnl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */