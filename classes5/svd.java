import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.hotchat.ui.GlowView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class svd
  implements ValueAnimator.AnimatorUpdateListener
{
  public svd(GlowView paramGlowView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.a.setScaleX(f);
    this.a.a.setScaleY(f);
    f = f / 1.25F * 1.2741935F;
    this.a.b.setScaleX(f);
    this.a.b.setScaleY(f);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\svd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */