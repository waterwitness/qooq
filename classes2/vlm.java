import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.data.TroopAioMsgNavigateBar;

public class vlm
  extends Handler
{
  public vlm(TroopAioMsgNavigateBar paramTroopAioMsgNavigateBar, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    this.a.g();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vlm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */