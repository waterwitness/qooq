package com.sixgod.pluginsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;

final class d
  extends BroadcastReceiver
{
  d(c paramc) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((!paramIntent.hasExtra("plugin_pkg_name")) || (!paramIntent.hasExtra("is_kill_process"))) {}
    String str;
    do
    {
      boolean bool;
      do
      {
        return;
        str = paramIntent.getStringExtra("plugin_pkg_name");
        bool = paramIntent.getBooleanExtra("is_kill_process", false);
      } while ((str == null) || (!str.equals(this.a.d.pkgName)));
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


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\sixgod\pluginsdk\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */