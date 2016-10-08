import com.tencent.biz.pubaccount.readinjoy.model.SubscriptionInfoModule;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hzi
  implements Runnable
{
  public hzi(SubscriptionInfoModule paramSubscriptionInfoModule)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ((PublicAccountDataManager)this.a.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(55)).a();
    TroopBarAssistantManager localTroopBarAssistantManager = TroopBarAssistantManager.a();
    localTroopBarAssistantManager.d((QQAppInterface)this.a.jdField_a_of_type_ComTencentCommonAppAppInterface);
    if (localTroopBarAssistantManager.a((QQAppInterface)this.a.jdField_a_of_type_ComTencentCommonAppAppInterface)) {
      localTroopBarAssistantManager.a(this.a.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, (QQAppInterface)this.a.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */