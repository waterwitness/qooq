import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.data.QidianCorpInfo;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qidian.data.QidianInternalInfo;
import com.tencent.qidian.data.QidianProfileUiInfo;
import com.tencent.qphone.base.util.QLog;

public class wyd
  implements Runnable
{
  public wyd(QidianManager paramQidianManager, QidianExternalInfo paramQidianExternalInfo, QidianInternalInfo paramQidianInternalInfo, QidianCorpInfo paramQidianCorpInfo, QidianProfileUiInfo paramQidianProfileUiInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(QidianManager.jdField_a_of_type_JavaLangString, 2, "saveQidianExtInfoInSubThread");
    }
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentQidianQidianManager.jdField_a_of_type_ComTencentCommonAppAppInterface.a().createEntityManager();
    if (localEntityManager != null) {}
    label78:
    label113:
    label141:
    label184:
    while (!QLog.isColorLevel())
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo == null) {
          break label113;
        }
        localEntityManager.b(this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo);
        if (this.jdField_a_of_type_ComTencentQidianDataQidianInternalInfo == null) {
          break label141;
        }
        localEntityManager.b(this.jdField_a_of_type_ComTencentQidianDataQidianInternalInfo);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          return;
          if (QLog.isColorLevel()) {
            QLog.d(QidianManager.jdField_a_of_type_JavaLangString, 2, "saveQidianIntInfoInSubThread internalInfo is null");
          }
        }
      }
      finally
      {
        localEntityManager.a();
      }
      if (this.jdField_a_of_type_ComTencentQidianDataQidianCorpInfo != null)
      {
        localEntityManager.b(this.jdField_a_of_type_ComTencentQidianDataQidianCorpInfo);
        if (this.jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo == null) {
          break label184;
        }
        localEntityManager.b(this.jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(QidianManager.jdField_a_of_type_JavaLangString, 2, "saveQidianExtInfoInSubThread success");
        }
        localEntityManager.a();
        return;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(QidianManager.jdField_a_of_type_JavaLangString, 2, "saveQidianExtInfoInSubThread externalInfo is null");
        break;
        if (!QLog.isColorLevel()) {
          break label78;
        }
        QLog.d(QidianManager.jdField_a_of_type_JavaLangString, 2, "saveQidianExtInfoInSubThread corpInfo is null");
        break label78;
        if (QLog.isColorLevel()) {
          QLog.d(QidianManager.jdField_a_of_type_JavaLangString, 2, "saveQidianExtInfoInSubThread uiInfo is null");
        }
      }
    }
    QLog.d(QidianManager.jdField_a_of_type_JavaLangString, 2, "saveQidianExtInfoInSubThread em is null");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wyd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */