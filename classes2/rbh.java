import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import com.tencent.mobileqq.contactsync.ContactSyncManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class rbh
  implements AccountManagerCallback
{
  public rbh(ContactSyncManager paramContactSyncManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run(AccountManagerFuture paramAccountManagerFuture)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "removeSyncAccount | is done = " + paramAccountManagerFuture.isDone());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\rbh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */