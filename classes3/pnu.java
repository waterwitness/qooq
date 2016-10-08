import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.welcomeguide.QQAVFunnyFaceInvest;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class pnu
  implements Animation.AnimationListener
{
  public pnu(QQAVFunnyFaceInvest paramQQAVFunnyFaceInvest)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QQAVFunnyFaceInvest.a(this.a)) {
      return;
    }
    QQAVFunnyFaceInvest.e(this.a);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (QQAVFunnyFaceInvest.a(this.a)) {
      return;
    }
    this.a.e.setVisibility(0);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pnu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */