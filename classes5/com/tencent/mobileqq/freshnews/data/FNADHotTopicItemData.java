package com.tencent.mobileqq.freshnews.data;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.freshnews.FreshNewsInfo;
import com.tencent.mobileqq.freshnews.ad.HotTopic;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class FNADHotTopicItemData
  extends FNBaseItemData
{
  public HotTopic a;
  public List a;
  
  public FNADHotTopicItemData(FreshNewsInfo paramFreshNewsInfo)
  {
    super(paramFreshNewsInfo);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(Context paramContext, AppInterface paramAppInterface)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.feedType != 12L) || (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.adTopicList == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby.freshNews", 2, "FNADHotTopicItemData update topic info is null");
      }
      return;
    }
    this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.adTopicList;
    int i = 0;
    for (;;)
    {
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        paramContext = (HotTopic)this.jdField_a_of_type_JavaUtilList.get(i);
        if (paramContext.b == 0L) {
          this.jdField_a_of_type_ComTencentMobileqqFreshnewsAdHotTopic = paramContext;
        }
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsAdHotTopic == null) {
          break;
        }
        this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_ComTencentMobileqqFreshnewsAdHotTopic);
        return;
      }
      i += 1;
    }
  }
  
  public String toString()
  {
    return "FNADHotTopicItemData{operationTopic=" + this.jdField_a_of_type_ComTencentMobileqqFreshnewsAdHotTopic + ", hotTopicList=" + this.jdField_a_of_type_JavaUtilList + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\freshnews\data\FNADHotTopicItemData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */