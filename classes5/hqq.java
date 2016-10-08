import android.os.Bundle;
import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountMenuResponse;
import mqq.observer.BusinessObserver;

class hqq
  implements Runnable
{
  hqq(hqp paramhqp, mobileqq_mp.GetPublicAccountMenuResponse paramGetPublicAccountMenuResponse, int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_Hqp.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a(this.jdField_a_of_type_Hqp.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Hqp.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountMenuResponse);
    if (this.jdField_a_of_type_Hqp.jdField_a_of_type_MqqObserverBusinessObserver != null) {
      this.jdField_a_of_type_Hqp.jdField_a_of_type_MqqObserverBusinessObserver.onReceive(this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_AndroidOsBundle);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hqq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */