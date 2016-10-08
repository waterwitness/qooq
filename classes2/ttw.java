import android.view.animation.Transformation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.portal.HongBaoPendantHolder;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ValueAnimation.AnimationUpdateListener;

public class ttw
  implements ValueAnimation.AnimationUpdateListener
{
  public ttw(HongBaoPendantHolder paramHongBaoPendantHolder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(ValueAnimation paramValueAnimation, float paramFloat, Float paramFloat1, Transformation paramTransformation)
  {
    this.a.b = paramFloat1.floatValue();
    this.a.a = (1.1F - (paramFloat1.floatValue() - 1.0F));
    this.a.a((int)(this.a.f * paramFloat1.floatValue()));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ttw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */