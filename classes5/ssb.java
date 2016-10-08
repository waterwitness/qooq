import com.tencent.mobileqq.freshnews.FreshNewsFeedAdapter;
import com.tencent.mobileqq.freshnews.FreshNewsInfo;
import com.tencent.mobileqq.freshnews.FreshNewsManager.CUnpublishedFeedsListener;
import com.tencent.mobileqq.freshnews.topic.NearbyTopicFeedActivity;
import com.tencent.mobileqq.freshnews.topic.TopicInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.XListView;
import java.util.List;

public class ssb
  extends FreshNewsManager.CUnpublishedFeedsListener
{
  public ssb(NearbyTopicFeedActivity paramNearbyTopicFeedActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(FreshNewsInfo paramFreshNewsInfo)
  {
    if ((paramFreshNewsInfo != null) && (paramFreshNewsInfo.topicInfo != null) && (paramFreshNewsInfo.topicInfo.a == this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsTopicTopicInfo.a))
    {
      paramFreshNewsInfo = this.a.a(paramFreshNewsInfo);
      this.a.jdField_a_of_type_JavaUtilList.add(0, paramFreshNewsInfo);
      this.a.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
      if (this.a.d) {
        break label98;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.a = paramFreshNewsInfo;
      }
    }
    label98:
    while (this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter == null) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.a = paramFreshNewsInfo;
    this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.d();
  }
  
  public void a(List paramList) {}
  
  public void a(boolean paramBoolean, FreshNewsInfo paramFreshNewsInfo)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.e();
    }
    if (!this.a.d) {}
    do
    {
      return;
      if (!paramBoolean)
      {
        this.a.a(1, "删除失败");
        return;
      }
    } while ((this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter == null) || (paramFreshNewsInfo == null));
    this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.a(paramFreshNewsInfo.feedId);
  }
  
  public void b(FreshNewsInfo paramFreshNewsInfo)
  {
    if (this.a.jdField_a_of_type_JavaUtilList.contains(paramFreshNewsInfo)) {
      NearbyTopicFeedActivity.a(this.a);
    }
  }
  
  public void c(FreshNewsInfo paramFreshNewsInfo)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.a(paramFreshNewsInfo);
    NearbyTopicFeedActivity.a(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ssb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */