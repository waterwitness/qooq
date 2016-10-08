import android.content.SharedPreferences;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.contactsync.ContactSyncManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qbu
  implements Runnable
{
  public qbu(PhoneContactManagerImp paramPhoneContactManagerImp)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    PhoneContactManagerImp.a(this.a, this.a.a());
    PhoneContactManagerImp.a(this.a);
    this.a.e = this.a.a.getLong("key_contacts_switches", 0L);
    ContactSyncManager localContactSyncManager = (ContactSyncManager)PhoneContactManagerImp.a(this.a).getManager(40);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qbu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */