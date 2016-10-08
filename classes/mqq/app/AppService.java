package mqq.app;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import java.util.ArrayList;
import mqq.util.WeakReference;

public class AppService
  extends Service
{
  protected static final int CONFIG_NEED_RUNTIME = 0;
  protected static final int CONFIG_NO_NEED_RUNTIME = 1;
  protected AppRuntime app;
  
  public String getModuleId()
  {
    return null;
  }
  
  public void onAccountChanged() {}
  
  public void onAccoutChangeFailed() {}
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  protected int onConfigRuntime()
  {
    return 0;
  }
  
  public void onCreate()
  {
    super.onCreate();
    MobileQQ.sMobileQQ.onActivityCreate(this, null);
    if (onConfigRuntime() == 0) {
      this.app = MobileQQ.getMobileQQ().waitAppRuntime(null).getAppRuntime(getModuleId());
    }
    MobileQQ.sMobileQQ.appServices.add(new WeakReference(this));
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason) {}
  
  public void setAppRuntime(AppRuntime paramAppRuntime)
  {
    this.app = paramAppRuntime.getAppRuntime(getModuleId());
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\mqq\app\AppService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */