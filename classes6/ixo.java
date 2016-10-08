import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.qqstory.takevideo.doodle.ui.animation.AnimatorFactory.AnimatorListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ixo
  implements ValueAnimator.AnimatorUpdateListener
{
  public ixo(AnimatorFactory.AnimatorListener paramAnimatorListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (this.a != null) {
      this.a.a(paramValueAnimator);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ixo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */