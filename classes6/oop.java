import android.os.Bundle;
import com.tencent.mobileqq.activity.phone.ContactListView;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class oop
  extends FriendListObserver
{
  public oop(ContactListView paramContactListView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(String paramString) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if ((paramBoolean1) && (paramBoolean2) && (!paramBoolean3)) {
      this.a.j();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\oop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */