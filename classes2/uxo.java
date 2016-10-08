import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;

public class uxo
  implements Runnable
{
  public uxo(SubAccountManager paramSubAccountManager, String paramString1, String paramString2, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int j = 1;
    int k = 0;
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
          if ((this.b != null) || (localSubAccountInfo.A2 == null))
          {
            i = k;
            if (this.b != null)
            {
              i = k;
              if (this.b.equals(localSubAccountInfo.A2)) {}
            }
          }
          else
          {
            if (this.jdField_a_of_type_Boolean)
            {
              localSubAccountInfo.lasttime = (System.currentTimeMillis() / 1000L);
              if (QLog.isColorLevel()) {
                QLog.d("SUB_ACCOUNT", 2, "updateA2() change lasttime=" + localSubAccountInfo.lasttime);
              }
            }
            localSubAccountInfo.A2 = this.b;
            if (this.b != null) {
              break label319;
            }
            localSubAccountInfo.hintIsNew = false;
            if (!QLog.isColorLevel()) {
              break label319;
            }
            QLog.d("SUB_ACCOUNT", 2, "updateA2() set hintIsNew=false");
            break label319;
          }
          if (this.b == null)
          {
            localSubAccountInfo.cookie = null;
            if (localSubAccountInfo.status == 0)
            {
              localSubAccountInfo.status = 3;
              i = j;
              if (QLog.isColorLevel())
              {
                QLog.d("SUB_ACCOUNT", 2, "updateA2() change status=" + localSubAccountInfo.status);
                i = j;
              }
              if (i == 0) {
                break label314;
              }
              this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountManager.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
              if (localSubAccountInfo != null) {
                this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountManager.a(localSubAccountInfo);
              }
            }
          }
          else
          {
            localSubAccountInfo.serverErrorMsg = null;
            localSubAccountInfo.serverErrorType = 0;
          }
          continue;
        }
        Object localObject2 = null;
      }
      finally
      {
        this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountManager.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      label314:
      continue;
      label319:
      int i = 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uxo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */