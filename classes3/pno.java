import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.welcomeguide.QQAVFunnyFaceInvest;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class pno
  implements Runnable
{
  pno(pnl parampnl)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QQAVFunnyFaceInvest.a(this.a.a)) {
      return;
    }
    this.a.a.a.setImageResource(2130839125);
    this.a.a.b.setPressed(true);
    ScaleAnimation localScaleAnimation1 = new ScaleAnimation(1.0F, 0.9F, 1.0F, 0.9F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation1.setDuration(200L);
    localScaleAnimation1.setFillEnabled(true);
    localScaleAnimation1.setFillAfter(true);
    localScaleAnimation1.setFillBefore(true);
    ScaleAnimation localScaleAnimation2 = new ScaleAnimation(0.9F, 1.0F, 0.9F, 1.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation2.setDuration(200L);
    localScaleAnimation2.setFillEnabled(true);
    localScaleAnimation2.setFillAfter(true);
    localScaleAnimation2.setFillBefore(true);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localScaleAnimation1);
    localAnimationSet.addAnimation(localScaleAnimation2);
    this.a.a.b.startAnimation(localAnimationSet);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pno.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */