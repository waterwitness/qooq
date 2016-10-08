import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.pubaccount.subscript.SubscriptRecommendController;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ien
  implements Animation.AnimationListener
{
  public ien(SubscriptRecommendController paramSubscriptRecommendController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a(SubscriptRecommendController.a(this.a));
    this.a.c();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ien.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */