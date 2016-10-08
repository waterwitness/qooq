import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.structmsg.StructMsgVideoController;

public class uvu
  extends Handler
{
  public uvu(StructMsgVideoController paramStructMsgVideoController)
  {
    super(Looper.getMainLooper());
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      this.a.d = true;
      StructMsgVideoController.a(this.a);
      return;
    }
    StructMsgVideoController.b(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uvu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */