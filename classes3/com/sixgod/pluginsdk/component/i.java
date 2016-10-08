package com.sixgod.pluginsdk.component;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.sixgod.pluginsdk.PluginLoadParams;
import com.sixgod.pluginsdk.SixGodHelper;

final class i
  extends BroadcastReceiver
{
  i(ContainerActivity paramContainerActivity) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((!paramIntent.hasExtra("plugin_pkg_name")) || (!paramIntent.hasExtra("is_kill_process"))) {}
    String str;
    do
    {
      return;
      str = paramIntent.getStringExtra("plugin_pkg_name");
      boolean bool = paramIntent.getBooleanExtra("is_kill_process", false);
      if ((str != null) && ((str.equals(this.a.d.pkgName)) || (str.equals("com.sixgod.pluginsdk.unload_all_plugin")))) {
        this.a.finish();
      }
      if (bool)
      {
        Process.killProcess(Process.myPid());
        return;
      }
      if (str.equals(this.a.d.pkgName))
      {
        SixGodHelper.clearPluginLoaderInfo(paramContext, str);
        return;
      }
    } while (!str.equals("com.sixgod.pluginsdk.unload_all_plugin"));
    SixGodHelper.clearAllPluginLoaderInfo(paramContext);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\sixgod\pluginsdk\component\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */