import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.tencent.mobileqq.emosm.Client;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class rgr
  implements ServiceConnection
{
  public rgr(Client paramClient)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    try
    {
      this.a.mIsBound = true;
      this.a.mService = new Messenger(paramIBinder);
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.web.Client", 2, "ServiceConnection Attached.");
      }
      WebIPCOperator.a().a();
      paramComponentName = Message.obtain(null, 1);
      paramComponentName.replyTo = this.a.mMessenger;
      this.a.mService.send(paramComponentName);
      return;
    }
    catch (Exception paramComponentName)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.emoji.web.Client", 2, paramComponentName.getMessage());
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    this.a.mService = null;
    this.a.onDisconnectWithService();
    if (QLog.isColorLevel()) {
      QLog.i("Q.emoji.web.Client", 2, "Disconnected.");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */