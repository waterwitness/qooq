import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantActivity;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcShopListAdapter;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class htr
  implements Runnable
{
  public htr(EcShopAssistantActivity paramEcShopAssistantActivity, List paramList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() == -1) && (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantActivity.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopListAdapter != null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantActivity.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopListAdapter.a(this.jdField_a_of_type_JavaUtilList);
      if (this.jdField_a_of_type_JavaUtilList.size() != 0) {
        break label141;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantActivity.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopListAdapter.a(true);
      RecentUserProxy localRecentUserProxy = this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantActivity.app.a().a();
      if (localRecentUserProxy != null)
      {
        RecentUser localRecentUser = localRecentUserProxy.b(AppConstants.aK, 7120);
        if (localRecentUser != null)
        {
          localRecentUserProxy.b(localRecentUser);
          this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantActivity.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantManager.a(true);
          ReportController.b(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantActivity.app, "dc00899", "Shop_lifeservice", "", "Shop_folder", "Del_shopHelperauto", 0, 0, "", "", "", "");
        }
      }
    }
    label141:
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantActivity.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopListAdapter.a(false);
    } while ((!QLog.isColorLevel()) || (this.jdField_a_of_type_JavaUtilList.get(0) == null));
    QLog.i("EcShop", 2, "refresh result first to show:" + ((RecentBaseData)this.jdField_a_of_type_JavaUtilList.get(0)).b);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\htr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */