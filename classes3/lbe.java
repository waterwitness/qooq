import android.os.Bundle;
import com.tencent.mobileqq.activity.Contacts;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.observer.GameCenterObserver;

public class lbe
  extends GameCenterObserver
{
  public lbe(Contacts paramContacts)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (Contacts.a(this.a)) {
      Contacts.a(this.a);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lbe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */