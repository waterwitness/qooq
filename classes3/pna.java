import android.view.animation.AnimationSet;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.welcomeguide.QQAVFunnyFaceInvest;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class pna
  implements Runnable
{
  public pna(QQAVFunnyFaceInvest paramQQAVFunnyFaceInvest)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QQAVFunnyFaceInvest.a(this.a) != 0) {}
    while (QQAVFunnyFaceInvest.a(this.a)) {
      return;
    }
    AnimationSet localAnimationSet = QQAVFunnyFaceInvest.a(this.a);
    localAnimationSet.setAnimationListener(new pnb(this));
    this.a.b.startAnimation(localAnimationSet);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pna.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */