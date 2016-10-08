import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import com.tencent.mobileqq.freshnews.FreshNewsDetailActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class spe
  implements Runnable
{
  public spe(FreshNewsDetailActivity paramFreshNewsDetailActivity, List paramList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(250L);
    localScaleAnimation.setInterpolator(new DecelerateInterpolator());
    localScaleAnimation.setAnimationListener(new spf(this));
    ((View)this.jdField_a_of_type_JavaUtilList.get(0)).startAnimation(localScaleAnimation);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\spe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */