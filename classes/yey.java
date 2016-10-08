import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qlink.IQlinkService.Stub;
import cooperation.qlink.QlinkServiceProxy;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class yey
  implements ServiceConnection
{
  public yey(QlinkServiceProxy paramQlinkServiceProxy)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    QLog.d("QlinkServiceProxy", 1, "onServiceConnected service:" + paramComponentName);
    QlinkServiceProxy.a(this.a, IQlinkService.Stub.a(paramIBinder));
    QlinkServiceProxy.a(this.a, false);
    QlinkServiceProxy.a(this.a);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    QLog.d("QlinkServiceProxy", 1, "onServiceDisconnected " + paramComponentName);
    try
    {
      QlinkServiceProxy.a(this.a).getApplication().unbindService(QlinkServiceProxy.a(this.a));
      QlinkServiceProxy.a(this.a, null);
      QlinkServiceProxy.a(this.a, false);
      return;
    }
    catch (Exception paramComponentName)
    {
      for (;;)
      {
        paramComponentName.printStackTrace();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\yey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */