import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqhotspot.hotspotnode.PublicAccountHandler;

public final class yhh
  implements Runnable
{
  public yhh(QQAppInterface paramQQAppInterface, AccountDetail paramAccountDetail)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(PublicAccountHandler.a, 2, "saveCache");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) && (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.getId() != -1L)) {
      if (!((EntityManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail)) {
        ((EntityManager)localObject).a(AccountDetail.class);
      }
    }
    for (;;)
    {
      ((EntityManager)localObject).a();
      if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) && (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType == 1))
      {
        localObject = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
        if (localObject != null) {
          ((PublicAccountDataManager)localObject).a(PublicAccountInfo.createPublicAccount(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail, 0L));
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(PublicAccountHandler.a, 2, "saveCache exit");
      }
      return;
      ((EntityManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yhh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */