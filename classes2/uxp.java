import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;

public class uxp
  implements Runnable
{
  public uxp(SubAccountManager paramSubAccountManager, String paramString, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountManager.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    for (;;)
    {
      try
      {
        Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountManager.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (localIterator.hasNext())
        {
          SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
          if (!this.jdField_a_of_type_JavaLangString.equals(localSubAccountInfo.subuin)) {
            continue;
          }
          localSubAccountInfo.lasttime = this.jdField_a_of_type_Long;
          this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountManager.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
          if (localSubAccountInfo != null) {
            this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountManager.a(localSubAccountInfo);
          }
          return;
        }
      }
      finally
      {
        this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountManager.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      Object localObject2 = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uxp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */