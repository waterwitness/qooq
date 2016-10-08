import android.graphics.drawable.Drawable;
import android.view.animation.Transformation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.profile.view.BreatheEffectView;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ValueAnimation.AnimationUpdateListener;

public class tvv
  implements ValueAnimation.AnimationUpdateListener
{
  public tvv(BreatheEffectView paramBreatheEffectView, Drawable paramDrawable)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(ValueAnimation paramValueAnimation, float paramFloat, Integer paramInteger, Transformation paramTransformation)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setAlpha(paramInteger.intValue());
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tvv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */