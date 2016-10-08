package com.sixgod.pluginsdk;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.app.Instrumentation;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.os.Process;
import android.text.TextUtils;
import android.view.Window;
import com.sixgod.pluginsdk.a.g;
import com.sixgod.pluginsdk.component.ContainerActivity;
import com.sixgod.pluginsdk.exception.SixGodException;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class c
{
  protected ClassLoader a;
  protected Context b;
  protected ClassLoader c;
  protected PluginLoadParams d;
  protected com.sixgod.pluginsdk.apkmanager.a e;
  protected com.sixgod.pluginsdk.a.a f;
  protected com.sixgod.pluginsdk.component.a g;
  protected ComponentName h;
  protected Map i = new HashMap();
  protected Map j = new HashMap();
  protected ArrayList k = new ArrayList();
  protected ArrayList l = new ArrayList();
  protected Map m = new HashMap();
  protected Map n = new HashMap();
  protected boolean o = false;
  protected String p = "";
  public b q;
  protected int r = 0;
  boolean s = false;
  protected Object t = new Object();
  protected BroadcastReceiver u;
  protected Handler v = new e(this, Looper.getMainLooper());
  BroadcastReceiver w = new f(this);
  
  private void c(Context paramContext, PluginLoadParams paramPluginLoadParams)
  {
    int i1 = 0;
    for (;;)
    {
      Object localObject2;
      try
      {
        this.d = paramPluginLoadParams;
        this.b = paramContext;
        int i2 = Process.myPid();
        ??? = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
        if (!((Iterator)???).hasNext()) {
          break label595;
        }
        localObject2 = (ActivityManager.RunningAppProcessInfo)((Iterator)???).next();
        if (((ActivityManager.RunningAppProcessInfo)localObject2).pid != i2) {
          continue;
        }
        ??? = ((ActivityManager.RunningAppProcessInfo)localObject2).processName;
        this.p = ((String)???);
        this.q = new b(paramContext, paramPluginLoadParams);
        if (paramPluginLoadParams.useBootClassLoader)
        {
          this.a = paramContext.getClassLoader().getParent();
          if ((paramPluginLoadParams.libList == null) || (paramPluginLoadParams.libList.size() == 0)) {
            break label318;
          }
          ??? = new StringBuilder();
          if (i1 >= paramPluginLoadParams.libList.size()) {
            break label223;
          }
          if (i1 != paramPluginLoadParams.libList.size() - 1)
          {
            ((StringBuilder)???).append((String)paramPluginLoadParams.libList.get(i1)).append(File.pathSeparator);
            break label586;
          }
        }
        else
        {
          this.a = paramContext.getClassLoader();
          continue;
        }
        ((StringBuilder)???).append((String)paramPluginLoadParams.libList.get(i1));
      }
      finally {}
      break label586;
      label223:
      label318:
      for (this.c = new DexClassLoader(((StringBuilder)???).toString(), paramContext.getDir("dex", 0).getAbsolutePath(), null, this.a); (paramPluginLoadParams.singleTaskContainers != null) && (paramPluginLoadParams.singleTaskContainers.size() > 0); this.c = this.a)
      {
        ??? = paramPluginLoadParams.singleTaskContainers.iterator();
        while (((Iterator)???).hasNext())
        {
          localObject2 = (Class)((Iterator)???).next();
          this.k.add(((Class)localObject2).getName());
        }
      }
      if ((paramPluginLoadParams.singleTopContainers != null) && (paramPluginLoadParams.singleTopContainers.size() > 0))
      {
        ??? = paramPluginLoadParams.singleTopContainers.iterator();
        while (((Iterator)???).hasNext())
        {
          localObject2 = (Class)((Iterator)???).next();
          this.l.add(((Class)localObject2).getName());
        }
      }
      this.f = new com.sixgod.pluginsdk.a.a(this.a);
      this.e = new com.sixgod.pluginsdk.apkmanager.a(paramContext, this.f, this.c);
      if (Looper.myLooper() == Looper.getMainLooper()) {
        this.e.b();
      }
      for (;;)
      {
        this.g = new com.sixgod.pluginsdk.component.a(paramContext, this.e);
        if (paramPluginLoadParams.componentMap != null) {
          this.i.putAll(paramPluginLoadParams.componentMap);
        }
        if (paramPluginLoadParams.serviceActionMap != null) {
          this.j.putAll(paramPluginLoadParams.serviceActionMap);
        }
        paramContext = new IntentFilter();
        paramContext.addAction("action_load_plugin_finish");
        paramContext.addAction("action_start_plugin_finish");
        this.b.registerReceiver(this.w, paramContext);
        return;
        synchronized (this.t)
        {
          Message.obtain(this.v, 1001).sendToTarget();
        }
        try
        {
          this.t.wait();
          continue;
          paramContext = finally;
          throw paramContext;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
      label586:
      i1 += 1;
      continue;
      label595:
      ??? = "";
    }
  }
  
  public final Activity a(ContainerActivity paramContainerActivity, Intent paramIntent, Bundle paramBundle)
  {
    com.sixgod.pluginsdk.log.a.a("ContainerActiivty createInnerActivity...");
    Object localObject1 = (Intent)paramIntent.getParcelableExtra("plugin_intent");
    if (localObject1 == null) {
      localObject1 = new Intent();
    }
    for (;;)
    {
      Object localObject2 = paramIntent.getStringExtra("packageName");
      String str = paramIntent.getStringExtra("className");
      Object localObject3 = new ComponentName((String)localObject2, str);
      if ((com.sixgod.pluginsdk.apkmanager.c)this.e.e.get(localObject2) == null) {
        return null;
      }
      paramIntent = (com.sixgod.pluginsdk.apkmanager.c)this.e.e.get(localObject2);
      if (paramIntent == null) {}
      for (paramIntent = null;; paramIntent = paramIntent.b)
      {
        ((Intent)localObject1).setExtrasClassLoader(paramIntent);
        localObject3 = this.e.a((ComponentName)localObject3);
        if (localObject3 == null) {
          break;
        }
        ((Intent)localObject1).setClassName((String)localObject2, str);
        localObject2 = (IBinder)this.f.ba.a(paramContainerActivity);
        com.sixgod.pluginsdk.log.a.a("ContainerActiivty createInnerActivity startActivity now...\n pkg = " + ((ActivityInfo)localObject3).packageName + " classname = " + ((ActivityInfo)localObject3).name);
        long l1 = System.currentTimeMillis();
        paramIntent = this.e.a((ActivityInfo)localObject3, (Intent)localObject1, paramBundle, paramIntent, (IBinder)localObject2, paramContainerActivity);
        com.sixgod.pluginsdk.log.a.a("ODPerf", "startActivityNow dtime = " + (System.currentTimeMillis() - l1));
        if (paramIntent == null) {
          break;
        }
        localObject1 = paramIntent.getParent();
        this.f.L.a(paramIntent, new Object[] { null });
        if (paramIntent == null) {
          break label315;
        }
        paramBundle = this.f.E.a(paramIntent, new Object[] { paramBundle });
        if (!(paramBundle instanceof Exception)) {
          break label315;
        }
        throw ((Exception)paramBundle);
      }
      label315:
      if (((ActivityInfo)localObject3).labelRes != 0) {
        paramIntent.setTitle(paramIntent.getResources().getString(((ActivityInfo)localObject3).labelRes));
      }
      for (;;)
      {
        this.f.L.a(paramIntent, new Object[] { localObject1 });
        paramIntent.getWindow().setContainer(paramContainerActivity.getWindow());
        return paramIntent;
        paramBundle = paramIntent.getResources().getString(((ActivityInfo)localObject3).applicationInfo.labelRes);
        if (((ActivityInfo)localObject3).applicationInfo.labelRes != 0) {
          paramIntent.setTitle(paramBundle);
        }
      }
    }
  }
  
  public final String a(int paramInt)
  {
    if (paramInt == 1) {}
    synchronized (this.k)
    {
      while (???.size() != 0)
      {
        String str = (String)???.get(0);
        ???.remove(str);
        return str;
        ??? = this.l;
      }
      return null;
    }
  }
  
  public final String a(String paramString)
  {
    return (String)this.i.get(paramString);
  }
  
  public final void a()
  {
    try
    {
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        Instrumentation localInstrumentation = (Instrumentation)this.f.aT.a(this.e.a());
        Object localObject = this.e;
        String str = this.d.pkgName;
        localObject = (com.sixgod.pluginsdk.apkmanager.c)((com.sixgod.pluginsdk.apkmanager.a)localObject).e.get(str);
        if (localObject == null) {}
        for (localObject = null;; localObject = ((com.sixgod.pluginsdk.apkmanager.c)localObject).e)
        {
          localInstrumentation.callApplicationOnCreate((Application)localObject);
          return;
        }
      }
      Message.obtain(this.v, 1000).sendToTarget();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public final void a(int paramInt, String paramString)
  {
    if (paramInt == 1) {}
    synchronized (this.k)
    {
      if (!???.contains(paramString)) {
        ???.add(paramString);
      }
      com.sixgod.pluginsdk.log.a.a("SpecialTest", "recycleSpecialActivity + list = " + ???.toString());
      return;
      ??? = this.l;
    }
  }
  
  public final boolean a(Context paramContext, PluginLoadParams paramPluginLoadParams)
  {
    try
    {
      c(paramContext, paramPluginLoadParams);
      com.sixgod.pluginsdk.log.a.a("SixGod_PluginSdk", "loadPlugin:" + paramPluginLoadParams.apkPath + "," + paramPluginLoadParams.pkgName + "," + this.p);
      if ((!TextUtils.isEmpty(paramPluginLoadParams.apkPath)) && (!TextUtils.isEmpty(paramPluginLoadParams.pkgName))) {
        break label141;
      }
      if (paramPluginLoadParams.pluginLoadCallBack != null) {
        throw new SixGodException("apkPath and pkgName must not be empty:" + paramPluginLoadParams.apkPath + "," + paramPluginLoadParams.pkgName);
      }
    }
    finally {}
    boolean bool = false;
    for (;;)
    {
      return bool;
      label141:
      Object localObject1 = this.e;
      Object localObject2 = paramPluginLoadParams.pkgName;
      localObject1 = (com.sixgod.pluginsdk.apkmanager.c)((com.sixgod.pluginsdk.apkmanager.a)localObject1).e.get(localObject2);
      if (localObject1 == null)
      {
        long l1;
        try
        {
          l1 = System.currentTimeMillis();
          localObject1 = this.e.a(paramPluginLoadParams.apkPath, paramPluginLoadParams.pluginResourceFlag, paramPluginLoadParams.useJni, paramPluginLoadParams.defaultUseActionBar, paramPluginLoadParams.versionName);
          if ((localObject1 == null) || (((com.sixgod.pluginsdk.apkmanager.c)localObject1).a.equals(paramPluginLoadParams.pkgName))) {
            break label318;
          }
          throw new SixGodException("pkg name!=params pkg = " + paramPluginLoadParams.pkgName + " parsed pkg = " + ((com.sixgod.pluginsdk.apkmanager.c)localObject1).a);
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
          com.sixgod.pluginsdk.log.a.a("SixGod_PluginSdk", "loadPlugin: crash e  = " + paramContext.getMessage());
          this.q.a(this.p, paramContext);
          this.q.a(5);
          bool = false;
        }
        continue;
        label318:
        com.sixgod.pluginsdk.log.a.a("SixGod_PluginSdk", "loadPlugin: loadedApk dTime = " + (System.currentTimeMillis() - l1));
        localObject2 = (Instrumentation)this.f.aT.a(this.e.a());
        localObject1 = this.e;
        Object localObject3 = paramPluginLoadParams.pkgName;
        localObject1 = (com.sixgod.pluginsdk.apkmanager.c)((com.sixgod.pluginsdk.apkmanager.a)localObject1).e.get(localObject3);
        if (localObject1 == null) {}
        for (localObject1 = null;; localObject1 = ((com.sixgod.pluginsdk.apkmanager.c)localObject1).e)
        {
          ((Instrumentation)localObject2).callApplicationOnCreate((Application)localObject1);
          if (this.o) {
            break label596;
          }
          localObject1 = this.e;
          paramPluginLoadParams = paramPluginLoadParams.pkgName;
          paramPluginLoadParams = ((com.sixgod.pluginsdk.apkmanager.c)((com.sixgod.pluginsdk.apkmanager.a)localObject1).e.get(paramPluginLoadParams)).h;
          if (paramPluginLoadParams == null) {
            break;
          }
          localObject1 = paramPluginLoadParams.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = ((Iterator)localObject1).next();
            localObject2 = (ActivityInfo)this.f.aC.a(localObject3);
            localObject3 = (List)this.f.aY.a(localObject3);
            this.g.a((ActivityInfo)localObject2, (List)localObject3);
          }
        }
        localObject1 = new StringBuilder("loadPlugin: registerBroadCast, ");
        if (paramPluginLoadParams == null) {}
        for (int i1 = 0;; i1 = paramPluginLoadParams.size())
        {
          com.sixgod.pluginsdk.log.a.a("SixGod_PluginSdk", i1);
          this.o = true;
          if (this.u == null)
          {
            this.u = new d(this);
            paramPluginLoadParams = new IntentFilter("com.sixgod.pluginsdk.unload_plugin.ACTION");
            paramContext.registerReceiver(this.u, paramPluginLoadParams);
          }
          label596:
          this.q.a();
          break;
        }
      }
      else
      {
        bool = true;
      }
    }
  }
  
  protected final boolean a(Bundle paramBundle, Uri paramUri)
  {
    String str = "";
    if (this.s) {
      localObject1 = this.h;
    }
    for (;;)
    {
      if (localObject1 != null) {
        str = ((ComponentName)localObject1).getClassName();
      }
      com.sixgod.pluginsdk.log.a.a("SixGod_PluginSdk", "startPluginLauncherActivity: clsName=" + str);
      if (!TextUtils.isEmpty(str)) {
        break;
      }
      this.q.a(2);
      return false;
      localObject1 = this.e;
      localObject2 = this.d.pkgName;
      localObject1 = (com.sixgod.pluginsdk.apkmanager.c)((com.sixgod.pluginsdk.apkmanager.a)localObject1).e.get(localObject2);
      if (localObject1 == null) {
        localObject1 = null;
      } else {
        localObject1 = ((com.sixgod.pluginsdk.apkmanager.c)localObject1).f;
      }
    }
    Object localObject2 = (String)this.i.get(str);
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = this.d.defaultActivityContainer;
    }
    com.sixgod.pluginsdk.log.a.a("SixGod_PluginSdk", "startPluginLauncherActivity: containerName=" + (String)localObject1);
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      this.q.a(4);
      return false;
    }
    localObject2 = new Intent();
    if (paramBundle != null) {
      ((Intent)localObject2).putExtras(paramBundle);
    }
    if (paramUri != null) {
      ((Intent)localObject2).setData(paramUri);
    }
    ((Intent)localObject2).putExtra("packageName", this.d.pkgName);
    paramBundle = new Intent();
    if (!(this.b instanceof Activity)) {
      paramBundle.setFlags(268435456);
    }
    paramBundle.setClassName(this.b, (String)localObject1);
    paramBundle.putExtra("className", str);
    paramBundle.putExtra("plugin_intent", (Parcelable)localObject2);
    paramBundle.putExtra("plugin_load_params", this.d.toJsonString());
    paramBundle.putExtra("packageName", this.d.pkgName);
    paramBundle.putExtra("plugin_id", this.d.pluginName);
    paramBundle.putExtra("is_launcher_activity", true);
    this.b.startActivity(paramBundle);
    this.q.a(str);
    return true;
  }
  
  public final String b()
  {
    return this.d.defaultActivityContainer;
  }
  
  public final String b(String paramString)
  {
    String str = (String)this.i.get(paramString);
    paramString = str;
    if (TextUtils.isEmpty(str)) {
      paramString = this.d.defaultServiceContainer;
    }
    return paramString;
  }
  
  protected final void b(int paramInt)
  {
    this.r = paramInt;
  }
  
  public final void b(int paramInt, String paramString)
  {
    if (paramInt == 1) {
      this.m.remove(paramString);
    }
    while (paramInt != 2) {
      return;
    }
    this.n.remove(paramString);
  }
  
  public final void b(Context paramContext, PluginLoadParams paramPluginLoadParams)
  {
    try
    {
      com.sixgod.pluginsdk.log.a.a("SixGod_Now", "loadPluginInSubProcess");
      c(paramContext, paramPluginLoadParams);
      if ((TextUtils.isEmpty(paramPluginLoadParams.apkPath)) || (TextUtils.isEmpty(paramPluginLoadParams.pkgName)))
      {
        if (paramPluginLoadParams.pluginLoadCallBack == null) {
          break label109;
        }
        throw new SixGodException("apkPath and pkgName must not be empty:" + paramPluginLoadParams.apkPath + "," + paramPluginLoadParams.pkgName);
      }
    }
    finally {}
    if (TextUtils.isEmpty(paramPluginLoadParams.defaultLoadApkActivity)) {
      com.sixgod.pluginsdk.log.a.a("SixGod_Now", "defaultLoadApkActivity is null ,不该走这个分支！");
    }
    for (;;)
    {
      label109:
      return;
      Intent localIntent = new Intent();
      localIntent.setComponent(new ComponentName(paramContext.getPackageName(), paramPluginLoadParams.defaultLoadApkActivity));
      localIntent.putExtra("preload", true);
      localIntent.putExtra("plugin_load_params", paramPluginLoadParams.toJsonString());
      localIntent.putExtra("packageName", paramPluginLoadParams.pkgName);
      localIntent.putExtra("plugin_id", paramPluginLoadParams.pluginName);
      localIntent.putExtra("packageName", paramPluginLoadParams.pkgName);
      if (!(paramContext instanceof Activity)) {
        localIntent.setFlags(268435456);
      }
      com.sixgod.pluginsdk.log.a.a("SixGod_PluginSdk", "loadPluginInSubProcess 启动加载Activity classname = " + paramPluginLoadParams.defaultLoadApkActivity);
      paramContext.startActivity(localIntent);
    }
  }
  
  public final com.sixgod.pluginsdk.apkmanager.a c()
  {
    try
    {
      com.sixgod.pluginsdk.apkmanager.a locala = this.e;
      return locala;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final String c(int paramInt, String paramString)
  {
    if (paramInt == 1) {
      return (String)this.m.get(paramString);
    }
    if (paramInt == 2) {
      return (String)this.n.get(paramString);
    }
    return null;
  }
  
  public final String c(String paramString)
  {
    return (String)this.i.get(paramString);
  }
  
  public final com.sixgod.pluginsdk.a.a d()
  {
    try
    {
      com.sixgod.pluginsdk.a.a locala = this.f;
      return locala;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final boolean d(String paramString)
  {
    this.e.a(paramString);
    this.g.a();
    this.b.unregisterReceiver(this.w);
    return true;
  }
  
  public final PluginLoadParams e()
  {
    try
    {
      PluginLoadParams localPluginLoadParams = this.d;
      return localPluginLoadParams;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final int f()
  {
    return this.r;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\sixgod\pluginsdk\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */