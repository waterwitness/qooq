import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.contactsync.ContactSyncManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rbf
  extends Handler
{
  public rbf(ContactSyncManager paramContactSyncManager, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      ContactSyncManager.a(this.a);
      return;
    }
    ContactSyncManager.b(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\rbf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */