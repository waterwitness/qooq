import com.tencent.mobileqq.activity.Contacts;
import com.tencent.mobileqq.adapter.BuddyListAdapter;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lbn
  extends FriendListObserver
{
  public lbn(Contacts paramContacts)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void b()
  {
    if (this.a.a != null)
    {
      this.a.a.c();
      this.a.a.a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lbn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */