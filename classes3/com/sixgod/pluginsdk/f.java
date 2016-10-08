package com.sixgod.pluginsdk;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.sixgod.pluginsdk.log.a;
import java.util.HashMap;

final class f
  extends BroadcastReceiver
{
  f(c paramc) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("action_start_plugin_finish")) {
      if (!paramIntent.getStringExtra("processName").equals(com.sixgod.pluginsdk.b.b.a(this.a.b))) {}
    }
    for (;;)
    {
      return;
      this.a.q.b(paramIntent.getStringExtra("className"));
      return;
      if (paramIntent.getAction().equals("action_load_plugin_finish"))
      {
        paramContext = paramIntent.getStringExtra("packageName");
        paramIntent.getStringExtra("plugin_id");
        String str = paramIntent.getStringExtra("processName");
        int i = paramIntent.getIntExtra("code", 0);
        paramIntent.getStringExtra("descmsg");
        try
        {
          if (paramContext.equals(this.a.d.pkgName))
          {
            boolean bool = str.equals(com.sixgod.pluginsdk.b.b.a(this.a.b));
            if (!bool)
            {
              a.a("SixGod_PluginSdk", "loadPlugin:  收到跨进程广播，通知加载插件结果");
              if (i == 0)
              {
                this.a.b(2);
                SixGodHelper.a.put(this.a.d.pkgName, this.a);
                paramContext = paramIntent.getStringExtra("launcherpkg");
                paramIntent = paramIntent.getStringExtra("launcherclass");
                this.a.h = new ComponentName(paramContext, paramIntent);
                this.a.s = true;
                this.a.q.a();
                return;
              }
              this.a.b(0);
              this.a.q.a(i);
              return;
            }
          }
        }
        catch (Exception paramContext) {}
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\sixgod\pluginsdk\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */