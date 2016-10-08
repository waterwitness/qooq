import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.freshnews.FreshNewsFeedAdapter;
import com.tencent.mobileqq.freshnews.data.FNBaseItemData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Iterator;
import java.util.List;

public class sps
  implements Animator.AnimatorListener
{
  public sps(FreshNewsFeedAdapter paramFreshNewsFeedAdapter, String paramString, ViewGroup.LayoutParams paramLayoutParams, View paramView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.a != null) && (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.a.size() > 0))
    {
      paramAnimator = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.a.iterator();
      while (paramAnimator.hasNext())
      {
        FNBaseItemData localFNBaseItemData = (FNBaseItemData)paramAnimator.next();
        if (this.jdField_a_of_type_JavaLangString.equals(localFNBaseItemData.e)) {
          this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.a.remove(localFNBaseItemData);
        }
      }
    }
    this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams.height = -2;
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.notifyDataSetChanged();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */