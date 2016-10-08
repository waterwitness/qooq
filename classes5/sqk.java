import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.freshnews.FreshNewsInfo;
import com.tencent.mobileqq.freshnews.FreshNewsManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.List;

public class sqk
  implements Runnable
{
  public sqk(FreshNewsManager paramFreshNewsManager, FreshNewsInfo paramFreshNewsInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    synchronized (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.jdField_a_of_type_JavaUtilList)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.jdField_a_of_type_JavaUtilList.contains(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo)) {
        this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo);
      }
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo);
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.jdField_a_of_type_AndroidOsHandler.obtainMessage(6, new Object[] { Boolean.valueOf(bool), this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo }).sendToTarget();
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sqk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */