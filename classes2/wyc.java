import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.BmqqUserSimpleInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;

public class wyc
  implements Runnable
{
  public wyc(QidianManager paramQidianManager, BmqqUserSimpleInfo paramBmqqUserSimpleInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(QidianManager.jdField_a_of_type_JavaLangString, 2, "updateBmqqExtInfo");
    }
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentQidianQidianManager.jdField_a_of_type_ComTencentCommonAppAppInterface.a().createEntityManager();
    if (localEntityManager != null) {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo != null) {
          localEntityManager.b(this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo);
        }
        do
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d(QidianManager.jdField_a_of_type_JavaLangString, 2, "updateBmqqExtInfo success");
            }
            return;
            if (QLog.isColorLevel()) {
              QLog.d(QidianManager.jdField_a_of_type_JavaLangString, 2, "updateBmqqExtInfo uiInfo is null");
            }
          }
        } while (!QLog.isColorLevel());
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      finally
      {
        localEntityManager.a();
      }
    }
    QLog.d(QidianManager.jdField_a_of_type_JavaLangString, 2, "updateBmqqExtInfo em is null");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wyc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */