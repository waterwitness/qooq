import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DraftTextInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.managers.DraftTextManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;

public class tbv
  implements Runnable
{
  public tbv(DraftTextManager paramDraftTextManager, QQAppInterface paramQQAppInterface, DraftTextInfo paramDraftTextInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    localEntityTransaction = localEntityManager.a();
    try
    {
      localEntityTransaction.a();
      localEntityManager.b(this.jdField_a_of_type_ComTencentMobileqqDataDraftTextInfo);
      localEntityTransaction.c();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        localEntityTransaction.b();
      }
    }
    finally
    {
      localEntityTransaction.b();
    }
    localEntityManager.a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tbv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */