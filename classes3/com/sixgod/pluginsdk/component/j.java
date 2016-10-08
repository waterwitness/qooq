package com.sixgod.pluginsdk.component;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.text.TextUtils;
import com.sixgod.pluginsdk.PluginLoadParams;
import com.sixgod.pluginsdk.SixGodHelper;
import com.sixgod.pluginsdk.apkmanager.a;
import com.sixgod.pluginsdk.exception.SixGodException;
import java.util.HashMap;

public final class j
{
  public static Intent a(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      localObject2 = null;
    }
    Object localObject4;
    String str1;
    String str2;
    Object localObject3;
    a locala;
    do
    {
      do
      {
        do
        {
          return (Intent)localObject2;
          localObject4 = paramIntent.getComponent();
          localObject2 = paramIntent;
        } while (localObject4 == null);
        str1 = ((ComponentName)localObject4).getPackageName();
        str2 = ((ComponentName)localObject4).getClassName();
        localObject3 = SixGodHelper.getPluginLoader(str1);
        localObject2 = paramIntent;
      } while (localObject3 == null);
      locala = ((com.sixgod.pluginsdk.c)localObject3).c();
      localObject2 = paramIntent;
    } while (locala.e.get(str1) == null);
    Intent localIntent = new Intent();
    Object localObject2 = ((com.sixgod.pluginsdk.c)localObject3).a(str2);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject4 = ((com.sixgod.pluginsdk.c)localObject3).c().a((ComponentName)localObject4);
      if (localObject4 == null) {
        throw new SixGodException("IntentHelper ActivityInfo not Found, have you declared this activity in your plugin AndroidManifest.xml?");
      }
      if ((localObject4 == null) || (((ActivityInfo)localObject4).launchMode != 2)) {
        break label306;
      }
      localObject1 = ((com.sixgod.pluginsdk.c)localObject3).c(1, str2);
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = ((com.sixgod.pluginsdk.c)localObject3).a(1);
      }
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        localIntent.putExtra("is_special_activity", true);
        localIntent.putExtra("special_type", 1);
        localObject1 = localObject2;
      }
    }
    if (localObject1 == null) {
      localObject1 = ((com.sixgod.pluginsdk.c)localObject3).b();
    }
    for (;;)
    {
      localObject2 = paramIntent;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break;
      }
      localObject3 = ((com.sixgod.pluginsdk.c)localObject3).e();
      localObject2 = (com.sixgod.pluginsdk.apkmanager.c)locala.e.get(str1);
      if (localObject2 == null) {}
      for (localObject2 = null;; localObject2 = ((com.sixgod.pluginsdk.apkmanager.c)localObject2).b)
      {
        localIntent.setExtrasClassLoader((ClassLoader)localObject2);
        localIntent.setClassName(paramContext, (String)localObject1);
        localIntent.putExtra("plugin_load_params", ((PluginLoadParams)localObject3).toJsonString());
        localIntent.putExtra("packageName", str1);
        localIntent.putExtra("className", str2);
        localIntent.setFlags(paramIntent.getFlags());
        localIntent.addFlags(268435456);
        localIntent.putExtra("plugin_intent", paramIntent);
        return localIntent;
        label306:
        localObject1 = localObject2;
        if (localObject4 == null) {
          break;
        }
        localObject1 = localObject2;
        if (((ActivityInfo)localObject4).launchMode != 1) {
          break;
        }
        localObject1 = ((com.sixgod.pluginsdk.c)localObject3).c(2, str2);
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = ((com.sixgod.pluginsdk.c)localObject3).a(2);
        }
        localObject1 = localObject2;
        if (localObject2 == null) {
          break;
        }
        localIntent.putExtra("is_special_activity", true);
        localIntent.putExtra("special_type", 2);
        localObject1 = localObject2;
        break;
      }
    }
  }
  
  public static Intent a(Context paramContext, Intent paramIntent, String paramString)
  {
    Object localObject3 = SixGodHelper.getPluginLoader(paramString);
    if (localObject3 == null) {}
    for (;;)
    {
      return paramIntent;
      Object localObject2 = ((com.sixgod.pluginsdk.c)localObject3).c();
      if (((a)localObject2).e.get(paramString) != null)
      {
        Object localObject1 = paramIntent.getComponent();
        String str = paramIntent.getAction();
        if (localObject1 != null)
        {
          localObject1 = ((ComponentName)localObject1).getClassName();
          str = ((com.sixgod.pluginsdk.c)localObject3).b((String)localObject1);
        }
        while ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
        {
          localObject3 = ((com.sixgod.pluginsdk.c)localObject3).e();
          Intent localIntent = new Intent();
          localObject2 = (com.sixgod.pluginsdk.apkmanager.c)((a)localObject2).e.get(paramString);
          if (localObject2 == null) {}
          for (localObject2 = null;; localObject2 = ((com.sixgod.pluginsdk.apkmanager.c)localObject2).b)
          {
            localIntent.setExtrasClassLoader((ClassLoader)localObject2);
            localIntent.setClassName(paramContext, str);
            localIntent.putExtra("packageName", paramString);
            localIntent.putExtra("className", (String)localObject1);
            localIntent.putExtra("plugin_intent", paramIntent);
            localIntent.putExtra("plugin_load_params", ((PluginLoadParams)localObject3).toJsonString());
            return localIntent;
            if (TextUtils.isEmpty(str)) {
              break label209;
            }
            localObject1 = ((com.sixgod.pluginsdk.c)localObject3).c(str);
            str = ((com.sixgod.pluginsdk.c)localObject3).b((String)localObject1);
            break;
          }
          label209:
          str = "";
          localObject1 = "";
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\sixgod\pluginsdk\component\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */