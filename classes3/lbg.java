import android.os.Bundle;
import com.tencent.mobileqq.activity.Contacts;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.observer.GameCenterObserver;

public class lbg
  extends GameCenterObserver
{
  public lbg(Contacts paramContacts)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (Contacts.b(this.a)) {
      Contacts.b(this.a);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lbg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */