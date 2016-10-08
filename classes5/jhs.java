import com.tencent.biz.webviewplugin.OfflineWebResManager;
import com.tencent.mobileqq.data.OfflineWebRes;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.concurrent.ConcurrentLinkedQueue;

public class jhs
  implements Runnable
{
  public jhs(OfflineWebResManager paramOfflineWebResManager, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      Thread.sleep(this.jdField_a_of_type_Int * 1000);
      if (!OfflineWebResManager.jdField_a_of_type_Boolean)
      {
        OfflineWebResManager.b();
        if (!OfflineWebResManager.b)
        {
          this.jdField_a_of_type_ComTencentBizWebviewpluginOfflineWebResManager.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(OfflineWebRes.class.getSimpleName());
          return;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
      OfflineWebResManager.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentBizWebviewpluginOfflineWebResManager.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.d(OfflineWebRes.class.getSimpleName());
      Object localObject;
      if (!OfflineWebResManager.jdField_a_of_type_Boolean)
      {
        localObject = new OfflineWebRes();
        ((OfflineWebRes)localObject).fileName = "test";
        ((OfflineWebRes)localObject).hashName = "test";
        ((OfflineWebRes)localObject).md5 = "test_md5";
        this.jdField_a_of_type_ComTencentBizWebviewpluginOfflineWebResManager.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a((Entity)localObject);
      }
      while (!OfflineWebResManager.a().isEmpty())
      {
        localObject = (String)OfflineWebResManager.a().poll();
        OfflineWebResManager.a(this.jdField_a_of_type_ComTencentBizWebviewpluginOfflineWebResManager, (String)localObject);
      }
      this.jdField_a_of_type_ComTencentBizWebviewpluginOfflineWebResManager.a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jhs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */