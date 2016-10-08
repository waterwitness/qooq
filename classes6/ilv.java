import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;
import com.tencent.biz.qqstory.pgc.view.BaseCoverView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ilv
  implements Animation.AnimationListener
{
  public ilv(BaseCoverView paramBaseCoverView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.startAnimation(this.a.b);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ilv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */