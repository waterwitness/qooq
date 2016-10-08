import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.model.SubscriptionInfoModule;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hzm
  implements Runnable
{
  public hzm(SubscriptionInfoModule paramSubscriptionInfoModule, String paramString, Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    TroopBarAssistantManager.a().a(this.jdField_a_of_type_JavaLangString, (QQAppInterface)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule.a, this.jdField_a_of_type_AndroidContentContext, SubscriptionInfoModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule));
    int i = PublicAccountUtil.a((QQAppInterface)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule.a, this.jdField_a_of_type_JavaLangString);
    RecentUtil.b((QQAppInterface)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule.a, this.jdField_a_of_type_JavaLangString, i);
    ((QQAppInterface)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSubscriptionInfoModule.a).a().c(this.jdField_a_of_type_JavaLangString, 1008);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */