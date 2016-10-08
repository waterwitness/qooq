import com.tencent.mobileqq.contactsync.ContactSyncManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class rbd
  implements Runnable
{
  public rbd(ContactSyncManager paramContactSyncManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      this.a.a();
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ContactSync.Manager", 2, "onQQContactRefreshed | syncAllContacts exception", localThrowable);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\rbd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */