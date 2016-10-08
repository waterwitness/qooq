import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.freshnews.FreshNewsFeedAdapter;
import com.tencent.mobileqq.freshnews.FreshNewsInfo;
import com.tencent.mobileqq.freshnews.FreshNewsObserver;
import com.tencent.mobileqq.freshnews.data.FNDefaultItemData;
import com.tencent.mobileqq.freshnews.topic.NearbyTopicFeedActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import java.util.List;

public class ssh
  extends FreshNewsObserver
{
  public ssh(NearbyTopicFeedActivity paramNearbyTopicFeedActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2)
  {
    int j = 0;
    if ((!paramBoolean1) || (TextUtils.isEmpty(paramString)) || (this.a.jdField_a_of_type_JavaUtilList.isEmpty())) {}
    do
    {
      do
      {
        return;
        int k = this.a.jdField_a_of_type_JavaUtilList.size();
        int i = 0;
        while (i < k)
        {
          FreshNewsInfo localFreshNewsInfo = (FreshNewsInfo)this.a.jdField_a_of_type_JavaUtilList.get(i);
          if ((localFreshNewsInfo == null) || (!paramString.equals(localFreshNewsInfo.feedId)))
          {
            i += 1;
          }
          else
          {
            localFreshNewsInfo.praiseCount = paramInt;
            paramInt = j;
            if (paramBoolean2) {
              paramInt = 1;
            }
            localFreshNewsInfo.praiseFlag = paramInt;
          }
        }
      } while (this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter == null);
      paramString = this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.a(paramString);
    } while ((paramString == null) || (!(paramString instanceof FNDefaultItemData)));
    paramString = (FNDefaultItemData)paramString;
    paramString.f = paramBoolean2;
    this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.a(paramString);
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.e();
    }
    if (!paramBoolean)
    {
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramString1 = "删除失败";
      }
      this.a.a(1, paramString1);
    }
    while (this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter == null) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.a(paramString1);
  }
  
  public void a(boolean paramBoolean, String paramString1, List paramList, int paramInt1, int paramInt2, String paramString2)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.e();
    }
    if (!this.a.d) {}
    do
    {
      do
      {
        return;
        if (!paramBoolean)
        {
          this.a.a(1, "评论失败");
          return;
        }
      } while (this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter == null);
      paramString1 = this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.a(paramString1);
    } while ((paramString1 == null) || (!(paramString1 instanceof FNDefaultItemData)));
    paramString1 = (FNDefaultItemData)paramString1;
    paramString1.h = paramInt1;
    this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.a(paramString1);
  }
  
  public void a(boolean paramBoolean1, List paramList, int paramInt, byte[] paramArrayOfByte, String paramString, boolean paramBoolean2)
  {
    int i = 0;
    this.a.b = false;
    if (paramBoolean1)
    {
      this.a.c = paramInt;
      this.a.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        if (paramBoolean2)
        {
          this.a.jdField_a_of_type_JavaUtilList.clear();
          this.a.d();
        }
        this.a.jdField_a_of_type_JavaUtilList.addAll(paramList);
      }
      NearbyTopicFeedActivity.a(this.a);
      if (paramBoolean2)
      {
        paramList = this.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
        if (!paramBoolean1) {
          break label201;
        }
      }
    }
    label201:
    for (paramInt = i;; paramInt = 1)
    {
      paramList.a(paramInt);
      this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new ssi(this), 500L);
      return;
      if (!paramBoolean2)
      {
        paramList = paramString;
        if (TextUtils.isEmpty(paramString)) {
          paramList = "加载失败...";
        }
        this.a.a(1, paramList);
      }
      paramList = this.a;
      if (this.a.c != 1) {}
      for (boolean bool = true;; bool = false)
      {
        paramList.a(false, bool);
        break;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ssh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */