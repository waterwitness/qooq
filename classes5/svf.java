import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.hotchat.ui.GlowView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class svf
  implements ValueAnimator.AnimatorUpdateListener
{
  public svf(GlowView paramGlowView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (f != this.a.jdField_a_of_type_Float)
    {
      this.a.jdField_a_of_type_Float = f;
      long l = System.currentTimeMillis();
      if ((float)(l - this.a.jdField_a_of_type_Long) >= 0.05F) {
        this.a.invalidate();
      }
      this.a.jdField_a_of_type_Long = l;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\svf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */