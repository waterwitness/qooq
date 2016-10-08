import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.data.BmqqAccountType;

public class wyb
  implements Runnable
{
  public wyb(QidianManager paramQidianManager, BmqqAccountType paramBmqqAccountType)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentQidianQidianManager.a.a().createEntityManager();
    if (localEntityManager != null) {}
    try
    {
      localEntityManager.b(this.jdField_a_of_type_ComTencentQidianDataBmqqAccountType);
      return;
    }
    finally
    {
      localEntityManager.a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wyb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */