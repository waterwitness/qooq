package com.sixgod.pluginsdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.sixgod.pluginsdk.component.ContainerActivity;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class SixGodHelper
{
  public static final String ACTION_UNLOAD_PLUGIN = "com.sixgod.pluginsdk.unload_plugin.ACTION";
  public static final String EXTRA_IS_KILL_PROCESS = "is_kill_process";
  public static final String EXTRA_PKG_NAME = "plugin_pkg_name";
  public static final String PKG_NAME_ALL = "com.sixgod.pluginsdk.unload_all_plugin";
  protected static HashMap a = new HashMap();
  
  public static void bindPluginService() {}
  
  public static void clearAllPluginLoaderInfo(Context paramContext)
  {
    try
    {
      if (a.size() > 0)
      {
        paramContext = a.keySet().iterator();
        while (paramContext.hasNext())
        {
          String str = (String)paramContext.next();
          ((c)a.get(str)).d(str);
        }
        a.clear();
      }
    }
    finally {}
  }
  
  public static void clearPluginLoaderInfo(Context paramContext, String paramString)
  {
    try
    {
      if (a.containsKey(paramString))
      {
        ((c)a.get(paramString)).d(paramString);
        a.remove(paramString);
      }
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static Activity createPluginActivity(ContainerActivity paramContainerActivity, String paramString1, String paramString2, Intent paramIntent, Bundle paramBundle)
  {
    c localc = getPluginLoader(paramString1);
    if (localc == null)
    {
      com.sixgod.pluginsdk.log.a.a("create pluginActivity failed, loader null!");
      return null;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("packageName", paramString1);
    localIntent.putExtra("className", paramString2);
    localIntent.putExtra("plugin_intent", paramIntent);
    return localc.a(paramContainerActivity, localIntent, paramBundle);
  }
  
  public static c getPluginLoader(String paramString)
  {
    if (a.containsKey(paramString)) {
      return (c)a.get(paramString);
    }
    try
    {
      paramString = (c)a.get(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static boolean isPluginLoaded(String paramString)
  {
    if (a.containsKey(paramString))
    {
      paramString = (c)a.get(paramString);
      if (TextUtils.isEmpty(paramString.e().processName)) {
        return paramString.f() == 2;
      }
      return (paramString.f() == 2) && (com.sixgod.pluginsdk.b.b.a(paramString.b, paramString.e().processName));
    }
    return false;
  }
  
  public static boolean loadPlugin(Context paramContext, PluginLoadParams paramPluginLoadParams)
  {
    if (!TextUtils.isEmpty(paramPluginLoadParams.processName)) {}
    for (;;)
    {
      try
      {
        if ((a.containsKey(paramPluginLoadParams.pkgName)) && (com.sixgod.pluginsdk.b.b.a(paramContext, paramPluginLoadParams.processName))) {
          return true;
        }
        if (TextUtils.isEmpty(paramPluginLoadParams.defaultLoadApkActivity)) {
          break;
        }
        loadPluginInSubProcess(paramContext, paramPluginLoadParams);
        return true;
      }
      finally {}
      try
      {
        if (a.containsKey(paramPluginLoadParams.pkgName)) {
          return true;
        }
      }
      finally
      {
        paramContext = finally;
        throw paramContext;
      }
    }
    c localc = new c();
    for (;;)
    {
      try
      {
        a.put(paramPluginLoadParams.pkgName, localc);
        localc.b(1);
        boolean bool = localc.a(paramContext, paramPluginLoadParams);
        if (bool)
        {
          i = 2;
          try
          {
            localc.b(i);
            return bool;
          }
          finally
          {
            paramContext = finally;
            throw paramContext;
          }
        }
        int i = 0;
      }
      finally {}
    }
  }
  
  public static void loadPluginInSubProcess(Context paramContext, PluginLoadParams paramPluginLoadParams)
  {
    try
    {
      c localc = new c();
      a.put(paramPluginLoadParams.pkgName, localc);
      localc.b(1);
      localc.b(paramContext, paramPluginLoadParams);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static boolean moveSoFile(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    String str2 = com.sixgod.pluginsdk.common.a.b(paramContext, paramString2, paramString3);
    String str1 = "tmp";
    if (!TextUtils.isEmpty(paramString3)) {
      str1 = "tmp" + "_" + paramString3;
    }
    paramContext = com.sixgod.pluginsdk.common.a.a(paramContext, paramString2) + str1 + File.separator;
    paramString2 = new File(paramContext);
    if (!paramString2.exists()) {
      paramString2.mkdirs();
    }
    paramString2 = new File(paramContext);
    if (paramString2.exists())
    {
      com.sixgod.pluginsdk.b.a.a(paramContext);
      paramString2.mkdirs();
      paramString2 = new File(str2);
      if (!paramString2.exists()) {
        break label300;
      }
      com.sixgod.pluginsdk.b.a.a(str2);
      paramString2.mkdirs();
    }
    for (;;)
    {
      com.sixgod.pluginsdk.b.a.a(paramString1, paramContext, "lib", "so");
      paramString1 = new File(paramContext + File.separator + "lib" + File.separator + Build.CPU_ABI);
      paramContext = new File(paramContext + File.separator + "lib" + File.separator + "armeabi");
      boolean bool = false;
      if (paramContext.exists()) {
        bool = com.sixgod.pluginsdk.b.a.a(paramContext.getAbsolutePath(), str2, true);
      }
      if (paramString1.exists()) {
        bool = com.sixgod.pluginsdk.b.a.a(paramString1.getAbsolutePath(), str2, true);
      }
      return bool;
      paramString2.mkdirs();
      break;
      label300:
      paramString2.mkdirs();
    }
  }
  
  public static boolean startPluginActivity(Context paramContext, String paramString, PluginLoadParams paramPluginLoadParams, Bundle paramBundle, Uri paramUri)
  {
    if (a.containsKey(paramPluginLoadParams.pkgName))
    {
      c localc = (c)a.get(paramPluginLoadParams.pkgName);
      if (paramPluginLoadParams.componentMap.containsKey(paramString)) {}
      for (String str = (String)paramPluginLoadParams.componentMap.get(paramString);; str = paramPluginLoadParams.defaultActivityContainer)
      {
        com.sixgod.pluginsdk.log.a.a("SixGod_PluginSdk", "startPluginActivity: containerName=" + str);
        if (!TextUtils.isEmpty(str)) {
          break;
        }
        return false;
      }
      Intent localIntent = new Intent();
      if (paramBundle != null) {
        localIntent.putExtras(paramBundle);
      }
      if (paramUri != null) {
        localIntent.setData(paramUri);
      }
      localIntent.putExtra("packageName", paramPluginLoadParams.pkgName);
      paramBundle = new Intent();
      if (!(paramContext instanceof Activity)) {
        paramBundle.setFlags(268435456);
      }
      paramBundle.setClassName(paramContext, str);
      paramBundle.putExtra("className", paramString);
      paramBundle.putExtra("plugin_intent", localIntent);
      paramBundle.putExtra("plugin_load_params", paramPluginLoadParams.toJsonString());
      paramBundle.putExtra("packageName", paramPluginLoadParams.pkgName);
      paramBundle.putExtra("plugin_id", paramPluginLoadParams.pluginName);
      paramBundle.putExtra("is_launcher_activity", true);
      paramContext.startActivity(paramBundle);
      localc.q.b(paramString);
      return true;
    }
    return false;
  }
  
  /* Error */
  public static boolean startPluginLauncherActivity(String paramString, Bundle paramBundle, Uri paramUri)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 28	com/sixgod/pluginsdk/SixGodHelper:a	Ljava/util/HashMap;
    //   6: aload_0
    //   7: invokevirtual 78	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   10: ifeq +24 -> 34
    //   13: getstatic 28	com/sixgod/pluginsdk/SixGodHelper:a	Ljava/util/HashMap;
    //   16: aload_0
    //   17: invokevirtual 63	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   20: checkcast 65	com/sixgod/pluginsdk/c
    //   23: aload_1
    //   24: aload_2
    //   25: invokevirtual 301	com/sixgod/pluginsdk/c:a	(Landroid/os/Bundle;Landroid/net/Uri;)Z
    //   28: istore_3
    //   29: ldc 2
    //   31: monitorexit
    //   32: iload_3
    //   33: ireturn
    //   34: iconst_0
    //   35: istore_3
    //   36: goto -7 -> 29
    //   39: astore_0
    //   40: ldc 2
    //   42: monitorexit
    //   43: aload_0
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	paramString	String
    //   0	45	1	paramBundle	Bundle
    //   0	45	2	paramUri	Uri
    //   28	8	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	29	39	finally
  }
  
  public static void startPluginService() {}
  
  public static void stopPluginService() {}
  
  public static boolean unLoadAllPlugin(Context paramContext, boolean paramBoolean)
  {
    try
    {
      clearAllPluginLoaderInfo(paramContext);
      Intent localIntent = new Intent("com.sixgod.pluginsdk.unload_plugin.ACTION");
      localIntent.putExtra("plugin_pkg_name", "com.sixgod.pluginsdk.unload_all_plugin");
      localIntent.putExtra("is_kill_process", paramBoolean);
      paramContext.sendBroadcast(localIntent);
      return true;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static boolean unLoadPlugin(Context paramContext, String paramString)
  {
    try
    {
      boolean bool = unLoadPlugin(paramContext, paramString, false);
      return bool;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static boolean unLoadPlugin(Context paramContext, String paramString, boolean paramBoolean)
  {
    try
    {
      clearPluginLoaderInfo(paramContext, paramString);
      Intent localIntent = new Intent("com.sixgod.pluginsdk.unload_plugin.ACTION");
      localIntent.putExtra("plugin_pkg_name", paramString);
      localIntent.putExtra("is_kill_process", paramBoolean);
      paramContext.sendBroadcast(localIntent);
      return true;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\sixgod\pluginsdk\SixGodHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */