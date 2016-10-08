import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.businessCard.views.BusinessCardViewScroller;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qxg
  implements ValueAnimator.AnimatorUpdateListener
{
  public qxg(BusinessCardViewScroller paramBusinessCardViewScroller)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.a(((Float)paramValueAnimator.getAnimatedValue()).floatValue());
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\qxg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */