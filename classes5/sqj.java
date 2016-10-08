import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.freshnews.FreshNewsInfo;
import com.tencent.mobileqq.freshnews.FreshNewsManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;

public class sqj
  implements Runnable
{
  public sqj(FreshNewsManager paramFreshNewsManager, FreshNewsInfo paramFreshNewsInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo);
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.jdField_a_of_type_AndroidOsHandler.obtainMessage(4, this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo).sendToTarget();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sqj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */