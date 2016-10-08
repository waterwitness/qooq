import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.video.interact.ParaMoveImageView;

public class ypz
  implements ValueAnimator.AnimatorUpdateListener
{
  public ypz(ParaMoveImageView paramParaMoveImageView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    try
    {
      float f3 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
      float f1 = this.a.a(f3);
      float f2 = this.a.b(f3);
      f3 = ParaMoveImageView.a(this.a, f3);
      ParaMoveImageView.a(this.a, Math.round(f3) * 2);
      paramValueAnimator = this.a.getLayoutParams();
      int i = ParaMoveImageView.a(this.a);
      paramValueAnimator.width = i;
      paramValueAnimator.height = i;
      this.a.setLayoutParams(paramValueAnimator);
      this.a.setX(f1);
      this.a.setY(f2);
      this.a.invalidate();
      return;
    }
    catch (Exception paramValueAnimator)
    {
      paramValueAnimator.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ypz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */