import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.freshnews.FreshNewsFeedAdapter;
import com.tencent.mobileqq.freshnews.FreshNewsFeedAdapter.OnPublishTopicListener;
import com.tencent.mobileqq.freshnews.FreshNewsInfo;
import com.tencent.mobileqq.freshnews.data.FNTopicItemData;
import com.tencent.mobileqq.freshnews.topic.NearbyTopicFeedActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class spu
  implements View.OnClickListener
{
  public spu(FreshNewsFeedAdapter paramFreshNewsFeedAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    int j = -1;
    int i = j;
    if (paramView.getTag(-1) != null)
    {
      localObject = paramView.getTag(-1);
      i = j;
      if ((localObject instanceof Integer)) {
        i = ((Integer)localObject).intValue();
      }
    }
    Object localObject = (FNTopicItemData)this.a.a(i);
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby.freshNews", 2, "topicItemOnClickLis, itemData is null|pos =" + i);
      }
    }
    label161:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            switch (paramView.getId())
            {
            default: 
              return;
            case 2131296515: 
              paramView = ((FNTopicItemData)localObject).a;
              if (paramView != null) {
                break label161;
              }
            }
          } while (!QLog.isColorLevel());
          QLog.d("Q.nearby.freshNews", 2, "topicItem click content|feedinfo is null, feedId:" + ((FNTopicItemData)localObject).e);
          return;
          NearbyTopicFeedActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramView.topicInfo);
          this.a.jdField_a_of_type_ComTencentCommonAppAppInterface.a("CliOper", "0X8005A1B");
          return;
          paramView = ((FNTopicItemData)localObject).a;
          if (paramView != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("Q.nearby.freshNews", 2, "topicItem click btn_publish|feedinfo is null, feedId:" + ((FNTopicItemData)localObject).e);
        return;
        if (paramView.topicInfo != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.nearby.freshNews", 2, "topicItem click btn_publish|feedinfo.topicInfo is null, feedId:" + ((FNTopicItemData)localObject).e);
      return;
    } while (this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter$OnPublishTopicListener == null);
    this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter$OnPublishTopicListener.a(paramView.topicInfo);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\spu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */