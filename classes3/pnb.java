import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.welcomeguide.QQAVFunnyFaceInvest;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class pnb
  implements Animation.AnimationListener
{
  pnb(pna parampna)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QQAVFunnyFaceInvest.a(this.a.a)) {
      return;
    }
    QQAVFunnyFaceInvest.a(this.a.a);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (QQAVFunnyFaceInvest.a(this.a.a)) {
      return;
    }
    this.a.a.b.setVisibility(0);
    this.a.a.b.postDelayed(new pnc(this), 750L);
    this.a.a.b.postDelayed(new pnd(this), 800L);
    this.a.a.b.postDelayed(new pne(this), 850L);
    this.a.a.b.postDelayed(new pnf(this), 900L);
    this.a.a.b.postDelayed(new png(this), 950L);
    this.a.a.a.postDelayed(new pnh(this), 1000L);
    this.a.a.a.postDelayed(new pni(this), 1050L);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pnb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */