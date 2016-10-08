import android.accounts.Account;
import android.accounts.AccountManager;
import com.tencent.mobileqq.contactsync.ContactSyncManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.locks.Lock;

public class rbg
  implements Runnable
{
  public rbg(ContactSyncManager paramContactSyncManager, Account[] paramArrayOfAccount)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ContactSyncManager.a(this.jdField_a_of_type_ComTencentMobileqqContactsyncContactSyncManager).lock();
    int i = 1;
    try
    {
      while (i < this.jdField_a_of_type_ArrayOfAndroidAccountsAccount.length)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.Manager", 2, "initSyncAccount | delAccount = " + this.jdField_a_of_type_ArrayOfAndroidAccountsAccount[i]);
        }
        ContactSyncManager.a(this.jdField_a_of_type_ComTencentMobileqqContactsyncContactSyncManager).removeAccount(this.jdField_a_of_type_ArrayOfAndroidAccountsAccount[i], null, null);
        i += 1;
      }
      return;
    }
    catch (Throwable localThrowable) {}finally
    {
      ContactSyncManager.a(this.jdField_a_of_type_ComTencentMobileqqContactsyncContactSyncManager).unlock();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\rbg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */