import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.emosm.Client;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class rgs
  extends Handler
{
  public rgs(Client paramClient, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      super.handleMessage(paramMessage);
    }
    do
    {
      do
      {
        return;
        this.a.onRespFromServer(paramMessage.getData());
      } while (!QLog.isColorLevel());
      QLog.i("Q.emoji.web.Client", 2, "resp from server MSG_CLIENT_RESP");
      return;
      this.a.onPushMsgFromServer(paramMessage.getData());
    } while (!QLog.isColorLevel());
    QLog.i("Q.emoji.web.Client", 2, "resp from server MSG_SERVER_DOWNLOAD_STATE");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rgs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */