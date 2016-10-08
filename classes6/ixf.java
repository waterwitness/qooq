import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer;
import com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer.LayerListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class ixf
  implements ValueAnimator.AnimatorUpdateListener
{
  ixf(ixe paramixe)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (ixe.a(this.a) == null) {
      return;
    }
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    ixe.a(this.a).c = (ixe.a(this.a) + ixe.b(this.a) * f);
    ixe.a(this.a).d = (ixe.c(this.a) + ixe.d(this.a) * f);
    ixe.a(this.a).a = (ixe.e(this.a) + ixe.f(this.a) * f);
    ixe.a(this.a).b = (ixe.g(this.a) + ixe.h(this.a) * f);
    if (f == 1.0F) {
      ixe.a(this.a, null);
    }
    if (this.a.b.a != null) {
      this.a.b.a.a(f);
    }
    this.a.b.e();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ixf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */