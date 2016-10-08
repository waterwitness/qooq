package com.tencent.mobileqq.pluginsdk;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

final class f
  implements ServiceConnection
{
  private void a()
  {
    if (PluginManagerHelper.a() != null)
    {
      PluginManagerHelper.a().clear();
      PluginManagerHelper.a(null);
    }
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (QLog.isColorLevel()) {
      QLog.i("plugin_tag", 2, "onServiceConnected");
    }
    if (PluginManagerHelper.a() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("plugin_tag", 2, "return WeakReference<OnPluginInterfaceReadyListener> is null");
      }
      a();
      return;
    }
    paramComponentName = (PluginManagerHelper.OnPluginManagerLoadedListener)PluginManagerHelper.a().get();
    if (paramComponentName == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("plugin_tag", 2, "return OnPluginManagerLoadedListener is null");
      }
      a();
      return;
    }
    if ((paramIBinder != null) && (paramIBinder.isBinderAlive()) && (paramIBinder.pingBinder()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("plugin_tag", 2, "binder alive");
      }
      PluginManagerHelper.a(new PluginManagerClient(RemotePluginManager.Stub.asInterface(paramIBinder)));
      paramComponentName.onPluginManagerLoaded(PluginManagerHelper.b());
    }
    for (;;)
    {
      a();
      return;
      if (QLog.isColorLevel()) {
        QLog.i("plugin_tag", 2, "binder not alive");
      }
      paramComponentName.onPluginManagerLoaded(null);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (QLog.isColorLevel()) {
      QLog.i("plugin_tag", 2, "onServiceDisconnected");
    }
    if (PluginManagerHelper.b() != null)
    {
      PluginManagerHelper.b().destory();
      PluginManagerHelper.a(null);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\pluginsdk\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */