import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.AntiphingToast;
import java.util.TimerTask;

public class wkq
  extends TimerTask
{
  public wkq(AntiphingToast paramAntiphingToast)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Message localMessage = new Message();
    localMessage.what = 1;
    this.a.a.sendMessage(localMessage);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wkq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */