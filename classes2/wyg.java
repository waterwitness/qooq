import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.data.QidianPAForWpa;
import com.tencent.qphone.base.util.QLog;

public class wyg
  implements Runnable
{
  public wyg(QidianManager paramQidianManager, QidianPAForWpa paramQidianPAForWpa)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(QidianManager.jdField_a_of_type_JavaLangString, 2, "updateQidianPAForWpa");
    }
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentQidianQidianManager.jdField_a_of_type_ComTencentCommonAppAppInterface.a().createEntityManager();
    if (localEntityManager != null) {
      try
      {
        if (this.jdField_a_of_type_ComTencentQidianDataQidianPAForWpa != null) {
          localEntityManager.b(this.jdField_a_of_type_ComTencentQidianDataQidianPAForWpa);
        }
        do
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d(QidianManager.jdField_a_of_type_JavaLangString, 2, "updateQidianPAForWpa success");
            }
            return;
            if (QLog.isColorLevel()) {
              QLog.d(QidianManager.jdField_a_of_type_JavaLangString, 2, "updateQidianPAForWpa uiInfo is null");
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
    QLog.d(QidianManager.jdField_a_of_type_JavaLangString, 2, "updateQidianPAForWpa em is null");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wyg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */