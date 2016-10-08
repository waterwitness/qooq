import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.freshnews.FreshNewsFeedAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class spp
  implements ValueAnimator.AnimatorUpdateListener
{
  public spp(FreshNewsFeedAdapter paramFreshNewsFeedAdapter, ViewGroup.LayoutParams paramLayoutParams, View paramView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams.height = i;
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\spp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */