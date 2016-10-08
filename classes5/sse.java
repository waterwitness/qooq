import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.freshnews.FreshNewsHandler;
import com.tencent.mobileqq.freshnews.topic.NearbyTopicFeedActivity;
import com.tencent.mobileqq.freshnews.topic.TopicInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;

public class sse
  implements OverScrollViewListener
{
  public sse(NearbyTopicFeedActivity paramNearbyTopicFeedActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(0L);
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0L);
    if (!NetworkUtil.e(this.a))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(1);
      this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new ssf(this), 300L);
      return true;
    }
    if (this.a.b)
    {
      this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new ssg(this), 300L);
      return true;
    }
    ((FreshNewsHandler)this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(1)).a(this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsTopicTopicInfo.a, 30, null, true);
    this.a.b = true;
    return true;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(0L);
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */