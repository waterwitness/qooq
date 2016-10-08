import SecurityAccountServer.RespondQueryQQBindingStat;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.contactsync.ContactSyncManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.qphone.base.util.QLog;

public class rbc
  extends ContactBindObserver
{
  public rbc(ContactSyncManager paramContactSyncManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    PhoneContactManager localPhoneContactManager = (PhoneContactManager)this.a.a.getManager(10);
    int i = localPhoneContactManager.d();
    String str1 = this.a.a.a();
    String str2 = this.a.a();
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "onQueryBindState | state = " + i + " | syncUin = " + ContactSyncManager.b(str2) + " | currentUin = " + ContactSyncManager.b(str1));
    }
    if (localPhoneContactManager.b()) {
      if (TextUtils.isEmpty(str2)) {
        ContactSyncManager.a(this.a).removeCallbacksAndMessages(null);
      }
    }
    do
    {
      do
      {
        ContactSyncManager.a(this.a).sendEmptyMessage(1);
        do
        {
          return;
        } while (str1.equals(str2));
        ContactSyncManager.a(this.a).removeCallbacksAndMessages(null);
        ContactSyncManager.a(this.a).sendEmptyMessage(2);
        ContactSyncManager.a(this.a).sendEmptyMessage(1);
        return;
      } while ((i != 2) && (i != 1) && ((i != 3) || (localPhoneContactManager.a() == null) || (localPhoneContactManager.a().lastUsedFlag != 3L)) && ((i != 4) || (localPhoneContactManager.a() == null) || (!localPhoneContactManager.a().isStopFindMatch)));
      if ((i == 2) || (i == 1)) {
        ContactSyncManager.a(this.a);
      }
    } while ((TextUtils.isEmpty(str2)) || (!str2.equals(this.a.a.a())));
    ContactSyncManager.a(this.a).removeCallbacksAndMessages(null);
    ContactSyncManager.a(this.a).sendEmptyMessage(2);
  }
  
  protected void c(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "onQueryContactList | isSuccess = " + paramBoolean + " | updateFlag = " + paramInt);
    }
    this.a.b();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\rbc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */