import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vip.IPCDownloadListener;
import com.tencent.qphone.base.util.QLog;

public class rhv
  extends IPCDownloadListener
{
  public rhv(MessengerService paramMessengerService)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(long paramLong, int paramInt, Bundle paramBundle)
  {
    if (this.a.a != null) {}
    try
    {
      Message localMessage = Message.obtain(null, 5);
      paramBundle.putInt("id", (int)paramLong);
      paramBundle.putInt("result", paramInt);
      localMessage.setData(paramBundle);
      this.a.a.send(localMessage);
      return;
    }
    catch (Exception paramBundle)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.emoji.web.MessengerService", 2, paramBundle.getMessage());
    }
  }
  
  public void a(Bundle paramBundle)
  {
    Message localMessage;
    if (this.a.a != null)
    {
      localMessage = Message.obtain(null, 5);
      localMessage.setData(paramBundle);
    }
    try
    {
      this.a.a.send(localMessage);
      return;
    }
    catch (RemoteException paramBundle)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.emoji.web.MessengerService", 2, paramBundle.getMessage());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rhv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */