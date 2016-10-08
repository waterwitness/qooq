package com.sixgod.pluginsdk.component;

import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import android.util.Log;
import com.sixgod.pluginsdk.PluginLoadParams;
import com.sixgod.pluginsdk.SixGodHelper;
import com.sixgod.pluginsdk.a.e;
import com.sixgod.pluginsdk.a.f;
import com.sixgod.pluginsdk.a.g;
import com.sixgod.pluginsdk.apkmanager.PluginResources;
import com.sixgod.pluginsdk.apkmanager.SixGodContext;
import com.sixgod.pluginsdk.common.Constants;
import com.sixgod.pluginsdk.log.SixGodReporter;
import java.util.HashMap;

public class ContainerService
  extends Service
{
  Service a;
  com.sixgod.pluginsdk.apkmanager.a b = null;
  com.sixgod.pluginsdk.a.a c = null;
  ClassLoader d;
  com.sixgod.pluginsdk.c e;
  PluginLoadParams f = null;
  
  private boolean a(Intent paramIntent)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    g localg = null;
    String str2;
    String str1;
    com.sixgod.pluginsdk.apkmanager.c localc;
    Application localApplication;
    if (this.a == null)
    {
      str2 = paramIntent.getStringExtra("packageName");
      str1 = paramIntent.getStringExtra("className");
      this.f = PluginLoadParams.parseFromJson(paramIntent.getStringExtra("plugin_load_params"));
      this.e = SixGodHelper.getPluginLoader(str2);
      if (this.e == null) {
        SixGodHelper.loadPlugin(getApplicationContext(), this.f);
      }
      this.e = SixGodHelper.getPluginLoader(str2);
      if (this.e != null)
      {
        this.c = this.e.d();
        this.b = this.e.c();
        localc = (com.sixgod.pluginsdk.apkmanager.c)this.b.e.get(str2);
        if (localc == null)
        {
          com.sixgod.pluginsdk.log.a.b("create Activity Failed! msg = appInfo null, not installed or unLaunched!");
          SixGodReporter.reportInfo("StartService", 0, 1, "", "", SixGodReporter.sDevInfo, "appInfo null");
          super.stopSelf();
          return false;
        }
      }
      else
      {
        super.stopSelf();
        return false;
      }
      paramIntent = (com.sixgod.pluginsdk.apkmanager.c)this.b.e.get(str2);
      if (paramIntent != null) {
        break label582;
      }
      paramIntent = null;
      this.d = paramIntent;
      localApplication = localc.e;
    }
    try
    {
      this.a = ((Service)this.d.loadClass(str1).newInstance());
      localObject3 = this.c.aq.a(null);
      if (localObject3 == null) {
        break label953;
      }
      localObject4 = this.c.M;
      paramIntent = (com.sixgod.pluginsdk.apkmanager.c)this.b.e.get(str2);
      if (paramIntent != null) {
        break label590;
      }
      paramIntent = null;
      label266:
      paramIntent = ((g)localObject4).a(localObject3, new Object[] { paramIntent, null, this.b.a() });
      if (!(paramIntent instanceof Boolean)) {
        break label953;
      }
      bool = ((Boolean)paramIntent).booleanValue();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject3;
        Object localObject4;
        label380:
        label582:
        label590:
        label804:
        if (this.a == null) {}
        for (paramIntent = "";; paramIntent = this.a.getClass().getName())
        {
          paramIntent = "exception happaned! msg = " + localException.getMessage() + " class = " + paramIntent;
          SixGodReporter.reportInfo("StartService", 0, 1, "", "", SixGodReporter.sDevInfo, paramIntent);
          SixGodReporter.reportException("StartServiceExp", localException);
          return false;
        }
        SixGodReporter.reportInfo("StartService", 0, 1, "", "", SixGodReporter.sDevInfo, "service null");
        continue;
        int i = 0;
        continue;
        boolean bool = false;
        if ((localObject3 != null) && (bool)) {
          paramIntent = (Intent)localObject3;
        }
      }
    }
    localObject4 = this.c.bb.a(this);
    if (this.c.S.a())
    {
      localObject1 = this.c.S;
      localObject2 = this.b.a();
      paramIntent = (com.sixgod.pluginsdk.apkmanager.c)this.b.e.get(str2);
      if (paramIntent == null)
      {
        paramIntent = localg;
        paramIntent = ((g)localObject1).a(null, new Object[] { localObject2, paramIntent, localObject4 });
        if ((paramIntent != null) && (!(paramIntent instanceof Boolean))) {
          break label947;
        }
        paramIntent = getBaseContext();
        i = 1;
        if (i != 0) {
          break label804;
        }
        this.c.N.a(paramIntent, new Object[] { this.a });
      }
    }
    for (paramIntent = new SixGodContext((Context)paramIntent, str2, this.b, getApplicationContext());; paramIntent = new SixGodContext((Context)paramIntent, str2, this.d, localc.k.a(), localc.k.b(), this.b, getApplicationContext()))
    {
      this.c.O.a(this.a, new Object[] { paramIntent, this.b.a(), str1, null, localApplication, null });
      if (this.a == null) {
        break label927;
      }
      this.a.onCreate();
      paramIntent = "service success! class = " + this.a.getClass().getName();
      SixGodReporter.reportInfo("StartService", 0, 0, "", "", SixGodReporter.sDevInfo, paramIntent);
      return true;
      paramIntent = paramIntent.b;
      break;
      paramIntent = paramIntent.d;
      break label266;
      paramIntent = paramIntent.d;
      break label380;
      if (this.c.T.a())
      {
        localg = this.c.T;
        localObject2 = this.b.a();
        paramIntent = (com.sixgod.pluginsdk.apkmanager.c)this.b.e.get(str2);
        if (paramIntent == null) {}
        for (paramIntent = (Intent)localObject1;; paramIntent = paramIntent.d)
        {
          paramIntent = localg.a(null, new Object[] { localObject2, paramIntent, Integer.valueOf(0), null });
          break;
        }
      }
      if (this.c.U.a())
      {
        localg = this.c.U;
        localObject1 = this.b.a();
        paramIntent = (com.sixgod.pluginsdk.apkmanager.c)this.b.e.get(str2);
        if (paramIntent == null) {}
        for (paramIntent = (Intent)localObject2;; paramIntent = paramIntent.d)
        {
          paramIntent = localg.a(null, new Object[] { localObject1, paramIntent, localObject4, Integer.valueOf(0), null });
          break;
        }
      }
      com.sixgod.pluginsdk.log.a.b("createSerivceContext failed ins create Service.");
      break label969;
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if (Constants.DEBUG_LOG.booleanValue()) {
      Log.d("SixGod_PluginSdk", "ContainerService onBind");
    }
    if (this.a == null) {}
    try
    {
      a(paramIntent);
      paramIntent = (Intent)paramIntent.getParcelableExtra("plugin_intent");
      if (this.a != null) {
        return this.a.onBind(paramIntent);
      }
    }
    catch (Exception paramIntent)
    {
      com.sixgod.pluginsdk.log.a.a("create service failed ! msg = " + paramIntent.getMessage());
      paramIntent.printStackTrace();
      super.stopSelf();
      return null;
    }
    return null;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (this.a != null) {
      this.a.onConfigurationChanged(paramConfiguration);
    }
  }
  
  public void onDestroy()
  {
    if (this.a != null) {
      this.a.onDestroy();
    }
  }
  
  public void onLowMemory()
  {
    if (this.a != null) {
      this.a.onLowMemory();
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    int i = 3;
    if (Constants.DEBUG_LOG.booleanValue()) {
      Log.d("SixGod_PluginSdk", "ContainerService onStartComment");
    }
    if (this.a == null) {}
    try
    {
      a(paramIntent);
      if (this.a != null)
      {
        Intent localIntent = null;
        if (paramIntent != null)
        {
          localIntent = (Intent)paramIntent.getParcelableExtra("plugin_intent");
          com.sixgod.pluginsdk.log.a.a("intent = null");
        }
        i = this.a.onStartCommand(localIntent, paramInt1, paramInt2);
      }
      return i;
    }
    catch (Exception paramIntent)
    {
      com.sixgod.pluginsdk.log.a.a("create service failed ! msg = " + paramIntent.getMessage());
      paramIntent.printStackTrace();
      super.stopSelf();
    }
    return 3;
  }
  
  public void onTrimMemory(int paramInt)
  {
    if (this.a != null) {
      this.a.onTrimMemory(paramInt);
    }
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    if (this.a != null) {
      return this.a.onUnbind(paramIntent);
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\sixgod\pluginsdk\component\ContainerService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */