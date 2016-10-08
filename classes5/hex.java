import android.view.View;
import android.view.animation.Transformation;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.PoiMapActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ValueAnimation.AnimationUpdateListener;
import com.tencent.mobileqq.widget.QQMapView;

public class hex
  implements ValueAnimation.AnimationUpdateListener
{
  public hex(PoiMapActivity paramPoiMapActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(ValueAnimation paramValueAnimation, float paramFloat, Integer paramInteger, Transformation paramTransformation)
  {
    paramValueAnimation = PoiMapActivity.g(this.a).getLayoutParams();
    paramValueAnimation.height = paramInteger.intValue();
    PoiMapActivity.h(this.a).setLayoutParams(paramValueAnimation);
    paramValueAnimation = (RelativeLayout.LayoutParams)this.a.b.getLayoutParams();
    paramValueAnimation.bottomMargin = (this.a.r - paramInteger.intValue());
    this.a.b.setLayoutParams(paramValueAnimation);
    int i = (paramInteger.intValue() - PoiMapActivity.c(this.a) - this.a.v) / 2;
    if (i >= (this.a.r - PoiMapActivity.d(this.a)) / 2 + this.a.w) {
      PoiMapActivity.a(this.a, i, false);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */