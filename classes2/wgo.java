import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vipgift.VipGiftManager;
import com.tencent.qphone.base.util.QLog;

public class wgo
  implements AsyncBack
{
  public wgo(VipGiftManager paramVipGiftManager, long paramLong1, String paramString1, long paramLong2, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipGiftManager", 2, "checkUpAndNotifyByBid progress:" + paramInt);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipGiftManager", 2, "checkUpAndNotifyByBid loaded,code:" + paramInt + ",cost:" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
    if (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("280")) {
      this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftManager.a("http://imgcache.qq.com/club/client/gift/resource/0/index.html?_wv=524289&_bid=280");
    }
    if ((paramInt == 0) || (8 == paramInt) || (5 == paramInt)) {
      if (this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftManager.a(2L, this.jdField_b_of_type_Long)) {
        this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftManager.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Long);
      }
    }
    while ((!this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftManager.a(5L, this.jdField_b_of_type_Long)) || (this.jdField_b_of_type_JavaLangString == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqVipgiftVipGiftManager.a(this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Long);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wgo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */