import android.view.animation.Transformation;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.maproam.activity.VipMapRoamActivity;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ValueAnimation.AnimationUpdateListener;

public class tcg
  implements ValueAnimation.AnimationUpdateListener
{
  public tcg(VipMapRoamActivity paramVipMapRoamActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(ValueAnimation paramValueAnimation, float paramFloat, Integer paramInteger, Transformation paramTransformation)
  {
    paramValueAnimation = this.a.a.getLayoutParams();
    if (paramValueAnimation != null)
    {
      paramValueAnimation.height = paramInteger.intValue();
      this.a.a.setLayoutParams(paramValueAnimation);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tcg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */