import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.PoiMapActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hew
  implements Animation.AnimationListener
{
  public hew(PoiMapActivity paramPoiMapActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = (RelativeLayout.LayoutParams)this.a.d.getLayoutParams();
    paramAnimation.bottomMargin = (-this.a.p);
    this.a.d.setLayoutParams(paramAnimation);
    this.a.d.clearAnimation();
    this.a.a.setImageResource(2130839299);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */