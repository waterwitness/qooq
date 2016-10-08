import android.content.SharedPreferences;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.app.MobileQQ;

public class htz
  implements Runnable
{
  public htz(EcShopAssistantManager paramEcShopAssistantManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ((EcshopReportHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(88)).a();
    SharedPreferences localSharedPreferences = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("ecshop_sp" + EcShopAssistantManager.a(this.a), 0);
    EcShopAssistantManager.jdField_a_of_type_Boolean = localSharedPreferences.getBoolean("folder_can_del", false);
    EcShopAssistantManager.S = String.valueOf(localSharedPreferences.getLong("ad_puin", 0L));
    EcShopAssistantManager.c();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\htz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */