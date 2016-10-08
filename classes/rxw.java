import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.TimerTask;

class rxw
  extends TimerTask
{
  rxw(rxv paramrxv)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (rxv.a(this.a) == null) {
      return;
    }
    Message localMessage = new Message();
    localMessage.what = 1;
    this.a.a.a.sendMessage(localMessage);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\rxw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */