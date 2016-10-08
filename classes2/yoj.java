import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.plugin.QZonePluginMangerHelper;
import cooperation.qzone.plugin.QZonePluginMangerHelper.OnQzonePluginClientReadyListner;
import cooperation.qzone.plugin.QZoneRemotePluginManager.Stub;
import java.lang.ref.WeakReference;

public final class yoj
  implements ServiceConnection
{
  public yoj()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (QLog.isColorLevel()) {
      QLog.i("patch", 2, "onServiceConnected");
    }
    if (QZonePluginMangerHelper.a() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("patch", 2, "return WeakReference<OnPluginInterfaceReadyListener> is null");
      }
      QZonePluginMangerHelper.a();
      return;
    }
    paramComponentName = (QZonePluginMangerHelper.OnQzonePluginClientReadyListner)QZonePluginMangerHelper.a().get();
    if (paramComponentName == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("patch", 2, "return OnPluginManagerLoadedListener is null");
      }
      QZonePluginMangerHelper.a();
      return;
    }
    if ((paramIBinder != null) && (paramIBinder.isBinderAlive()) && (paramIBinder.pingBinder()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("patch", 2, "binder alive");
      }
      QZonePluginMangerHelper.a = new ynx(QZoneRemotePluginManager.Stub.a(paramIBinder));
      paramComponentName.a(QZonePluginMangerHelper.a);
    }
    for (;;)
    {
      QZonePluginMangerHelper.a();
      return;
      if (QLog.isColorLevel()) {
        QLog.i("patch", 2, "binder not alive");
      }
      paramComponentName.a(null);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (QLog.isColorLevel()) {
      QLog.i("plugin_tag", 2, "onServiceDisconnected");
    }
    if (QZonePluginMangerHelper.a != null)
    {
      QZonePluginMangerHelper.a.b();
      QZonePluginMangerHelper.a = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yoj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */