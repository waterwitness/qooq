package com.sixgod.pluginsdk.component;

import android.content.ComponentName;
import android.content.Intent;
import com.sixgod.pluginsdk.PluginCallback;
import com.sixgod.pluginsdk.PluginLoadParams;
import com.sixgod.pluginsdk.SixGodHelper;
import com.sixgod.pluginsdk.apkmanager.a;
import com.sixgod.pluginsdk.b.b;
import java.util.HashMap;

final class c
  implements PluginCallback
{
  c(ContainerActivity paramContainerActivity) {}
  
  public final void crashHappened(String paramString1, String paramString2, String paramString3, Throwable paramThrowable) {}
  
  public final void loadPluginFailed(String paramString1, String paramString2, int paramInt)
  {
    if (this.a.i)
    {
      paramString1 = new Intent("action_load_plugin_finish");
      paramString1.putExtra("packageName", this.a.d.pkgName);
      paramString1.putExtra("plugin_id", this.a.d.pluginName);
      paramString1.putExtra("processName", b.a(this.a));
      paramString1.putExtra("code", paramInt);
      this.a.sendBroadcast(paramString1);
    }
  }
  
  public final void loadPluginSucc(String paramString1, String paramString2)
  {
    Object localObject = null;
    Intent localIntent;
    if (this.a.i)
    {
      localIntent = new Intent("action_load_plugin_finish");
      localIntent.putExtra("packageName", this.a.d.pkgName);
      localIntent.putExtra("plugin_id", this.a.d.pluginName);
      localIntent.putExtra("processName", b.a(this.a));
      localIntent.putExtra("code", 0);
      paramString2 = (com.sixgod.pluginsdk.apkmanager.c)SixGodHelper.getPluginLoader(paramString1).c().e.get(paramString1);
      if (paramString2 != null) {
        break label180;
      }
      paramString2 = null;
      localIntent.putExtra("launcherpkg", paramString2.getPackageName());
      paramString1 = (com.sixgod.pluginsdk.apkmanager.c)SixGodHelper.getPluginLoader(paramString1).c().e.get(paramString1);
      if (paramString1 != null) {
        break label188;
      }
    }
    label180:
    label188:
    for (paramString1 = (String)localObject;; paramString1 = paramString1.f)
    {
      localIntent.putExtra("launcherclass", paramString1.getClassName());
      this.a.sendBroadcast(localIntent);
      this.a.runOnUiThread(new d(this));
      return;
      paramString2 = paramString2.f;
      break;
    }
  }
  
  public final void startActivitySucc(String paramString1, String paramString2, String paramString3) {}
  
  public final void startMainActivityFailed(String paramString1, String paramString2, String paramString3, int paramInt) {}
  
  public final void startMainActivitySucc(String paramString1, String paramString2, String paramString3) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\sixgod\pluginsdk\component\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */