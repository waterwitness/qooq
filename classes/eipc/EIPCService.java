package eipc;

import android.content.Intent;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppService;

public abstract class EIPCService
  extends AppService
{
  protected EIPCServer mServer;
  
  public IBinder onBind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EIPCConst", 2, getClass().getSimpleName() + ".onBind. " + this);
    }
    return this.mServer.a(paramIntent);
  }
  
  public void onCreate()
  {
    if (QLog.isColorLevel()) {
      QLog.i("EIPCConst", 2, getClass().getSimpleName() + ".onCreate");
    }
    super.onCreate();
    this.mServer = onCreateSingleServer();
  }
  
  public abstract EIPCServer onCreateSingleServer();
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("EIPCConst", 2, getClass().getSimpleName() + ".onDestroy." + this);
    }
    this.mServer = null;
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EIPCConst", 2, getClass().getSimpleName() + ".onUnbind." + this);
    }
    return this.mServer.b(paramIntent);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\eipc\EIPCService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */