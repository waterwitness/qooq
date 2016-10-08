import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.data.TroopAioNewMessageBar;

public class vls
  extends Handler
{
  public vls(TroopAioNewMessageBar paramTroopAioNewMessageBar)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == TroopAioNewMessageBar.j) && (TroopAioNewMessageBar.e == this.a.k)) {
      TroopAioNewMessageBar.a(this.a);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vls.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */