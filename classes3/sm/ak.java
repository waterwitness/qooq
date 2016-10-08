package sm;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.securemodule.service.IControlService;
import com.tencent.securemodule.ui.TransparentActivity;

public class ak
  implements ServiceConnection
{
  public ak(TransparentActivity paramTransparentActivity) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    TransparentActivity.a(this.a, (IControlService)paramIBinder);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    TransparentActivity.a(this.a, null);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\sm\ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */