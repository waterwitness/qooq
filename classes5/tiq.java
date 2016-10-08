import com.tencent.mobileqq.app.NearbyHandler;
import com.tencent.mobileqq.config.NearbyDataManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.SpecialNearbyListActivity;
import com.tencent.mobileqq.nearby.SpecialNearbyListActivity.SpecialData;

public class tiq
  implements Runnable
{
  public tiq(SpecialNearbyListActivity paramSpecialNearbyListActivity, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbySpecialNearbyListActivity.c) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbySpecialNearbyListActivity.c = true;
    byte b = this.jdField_a_of_type_ComTencentMobileqqNearbySpecialNearbyListActivity.jdField_a_of_type_ComTencentMobileqqNearbySpecialNearbyListActivity$SpecialData.jdField_a_of_type_Byte;
    long l = this.jdField_a_of_type_ComTencentMobileqqNearbySpecialNearbyListActivity.jdField_a_of_type_ComTencentMobileqqNearbySpecialNearbyListActivity$SpecialData.jdField_a_of_type_Long;
    String str1 = NearbyDataManager.a(this.jdField_a_of_type_ComTencentMobileqqNearbySpecialNearbyListActivity, this.jdField_a_of_type_ComTencentMobileqqNearbySpecialNearbyListActivity.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqNearbySpecialNearbyListActivity.jdField_b_of_type_Int);
    String str2 = this.jdField_a_of_type_ComTencentMobileqqNearbySpecialNearbyListActivity.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getAccount();
    NearbyHandler localNearbyHandler = (NearbyHandler)this.jdField_a_of_type_ComTencentMobileqqNearbySpecialNearbyListActivity.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(3);
    this.jdField_a_of_type_ComTencentMobileqqNearbySpecialNearbyListActivity.jdField_a_of_type_Long = localNearbyHandler.a(0, this.jdField_a_of_type_Boolean, null, null, 0, (byte)0, b, 480, (byte)0, (byte)0, 0, 0, 0, 0, null, null, str1, 63L, (byte)0, false, str2, 3, l);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tiq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */