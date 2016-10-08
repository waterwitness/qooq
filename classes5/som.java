import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.freshnews.FreshNewsDetailActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class som
  implements Runnable
{
  public som(FreshNewsDetailActivity paramFreshNewsDetailActivity, int paramInt1, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = this.jdField_a_of_type_Int + 1;
    while (i < this.b + 1)
    {
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0, 0.0F, 0, -AIOUtils.a(40.0F, this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsDetailActivity.getResources()), 1, 0.0F, 1, 0.0F);
      localTranslateAnimation.setDuration(250L);
      localTranslateAnimation.setInterpolator(new DecelerateInterpolator());
      localTranslateAnimation.setFillAfter(true);
      View localView = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsDetailActivity.b.getChildAt(i);
      if (localView != null) {
        localView.startAnimation(localTranslateAnimation);
      }
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\som.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */