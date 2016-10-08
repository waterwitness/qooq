import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.freshnews.FreshNewsFeedAdapter;
import com.tencent.mobileqq.freshnews.data.FNBaseItemData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class spq
  implements Animation.AnimationListener
{
  public spq(FreshNewsFeedAdapter paramFreshNewsFeedAdapter, FNBaseItemData paramFNBaseItemData)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.a(this.jdField_a_of_type_ComTencentMobileqqFreshnewsDataFNBaseItemData);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\spq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */