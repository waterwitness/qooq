package com.sixgod.pluginsdk.apkmanager;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.sixgod.pluginsdk.b.c;
import com.sixgod.pluginsdk.component.j;

public class SixGodAppContext
  extends Application
{
  ClassLoader a;
  Resources b;
  AssetManager c;
  String d;
  boolean e = false;
  protected Context f;
  SixGodPackageManager g;
  
  public SixGodAppContext(Context paramContext1, String paramString, Context paramContext2)
  {
    attachBaseContext(paramContext1);
    this.f = paramContext2;
    this.d = paramString;
  }
  
  public SixGodAppContext(Context paramContext1, String paramString, ClassLoader paramClassLoader, Resources paramResources, AssetManager paramAssetManager, Context paramContext2)
  {
    attachBaseContext(paramContext1);
    this.a = paramClassLoader;
    this.b = paramResources;
    this.c = paramAssetManager;
    this.d = paramString;
    this.e = true;
    this.f = paramContext2;
  }
  
  public boolean bindService(Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt)
  {
    return super.bindService(j.a(this.f, paramIntent, this.d), paramServiceConnection, paramInt);
  }
  
  public Context getApplicationContext()
  {
    return this;
  }
  
  public AssetManager getAssets()
  {
    if (this.e) {
      return this.c;
    }
    return super.getAssets();
  }
  
  public ClassLoader getClassLoader()
  {
    if (this.e) {
      return this.a;
    }
    return super.getClassLoader();
  }
  
  public String getOpPackageName()
  {
    if (c.a()) {
      return this.f.getPackageName();
    }
    if (this.e) {
      return this.d;
    }
    return super.getPackageName();
  }
  
  public PackageManager getPackageManager()
  {
    if (this.g == null) {
      this.g = new SixGodPackageManager(super.getPackageManager());
    }
    return this.g;
  }
  
  public String getPackageName()
  {
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
    int i = 0;
    while (i < arrayOfStackTraceElement.length)
    {
      if (arrayOfStackTraceElement[i] != null)
      {
        String str = arrayOfStackTraceElement[i].getClassName();
        if ((str.equals("android.app.PendingIntent")) || (str.startsWith("android.widget.Toast")) || (str.startsWith("com.tencent.mm.sdk.openapi"))) {
          return this.f.getPackageName();
        }
        if ((str.equals("oicq.wlogin_sdk.tools.util")) && (this.d.equals("com.tencent.intervideo.xplatform"))) {
          return "com.tencent.huayang";
        }
      }
      i += 1;
    }
    if (this.e) {
      return this.d;
    }
    return super.getPackageName();
  }
  
  public Resources getResources()
  {
    if (this.e) {
      return this.b;
    }
    return super.getResources();
  }
  
  public Object getSystemService(String paramString)
  {
    if (paramString.equals("location")) {
      return (LocationManager)this.f.getSystemService(paramString);
    }
    if (paramString.equals("layout_inflater")) {
      return super.getSystemService(paramString);
    }
    return this.f.getSystemService(paramString);
  }
  
  public Intent registerReceiver(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter)
  {
    return this.f.registerReceiver(paramBroadcastReceiver, paramIntentFilter);
  }
  
  public Intent registerReceiver(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter, String paramString, Handler paramHandler)
  {
    return this.f.registerReceiver(paramBroadcastReceiver, paramIntentFilter, paramString, paramHandler);
  }
  
  public void removeStickyBroadcast(Intent paramIntent)
  {
    this.f.removeStickyBroadcast(paramIntent);
  }
  
  public void sendBroadcast(Intent paramIntent)
  {
    if ((paramIntent != null) && (!TextUtils.isEmpty(paramIntent.getPackage()))) {
      paramIntent.setPackage(this.f.getPackageName());
    }
    this.f.sendBroadcast(paramIntent);
  }
  
  public void sendBroadcast(Intent paramIntent, String paramString)
  {
    if ((paramIntent != null) && (!TextUtils.isEmpty(paramIntent.getPackage()))) {
      paramIntent.setPackage(this.f.getPackageName());
    }
    this.f.sendBroadcast(paramIntent, paramString);
  }
  
  public void sendOrderedBroadcast(Intent paramIntent, String paramString)
  {
    if ((paramIntent != null) && (!TextUtils.isEmpty(paramIntent.getPackage()))) {
      paramIntent.setPackage(this.f.getPackageName());
    }
    this.f.sendOrderedBroadcast(paramIntent, paramString);
  }
  
  public void sendOrderedBroadcast(Intent paramIntent, String paramString1, BroadcastReceiver paramBroadcastReceiver, Handler paramHandler, int paramInt, String paramString2, Bundle paramBundle)
  {
    if ((paramIntent != null) && (!TextUtils.isEmpty(paramIntent.getPackage()))) {
      paramIntent.setPackage(this.f.getPackageName());
    }
    this.f.sendOrderedBroadcast(paramIntent, paramString1, paramBroadcastReceiver, paramHandler, paramInt, paramString2, paramBundle);
  }
  
  public void sendStickyBroadcast(Intent paramIntent)
  {
    if ((paramIntent != null) && (!TextUtils.isEmpty(paramIntent.getPackage()))) {
      paramIntent.setPackage(this.f.getPackageName());
    }
    this.f.sendStickyBroadcast(paramIntent);
  }
  
  public void sendStickyOrderedBroadcast(Intent paramIntent, BroadcastReceiver paramBroadcastReceiver, Handler paramHandler, int paramInt, String paramString, Bundle paramBundle)
  {
    if ((paramIntent != null) && (!TextUtils.isEmpty(paramIntent.getPackage()))) {
      paramIntent.setPackage(this.f.getPackageName());
    }
    this.f.sendStickyOrderedBroadcast(paramIntent, paramBroadcastReceiver, paramHandler, paramInt, paramString, paramBundle);
  }
  
  public void startActivity(Intent paramIntent)
  {
    super.startActivity(j.a(this.f, paramIntent));
  }
  
  public ComponentName startService(Intent paramIntent)
  {
    try
    {
      ComponentName localComponentName = super.startService(j.a(this.f, paramIntent, this.d));
      return localComponentName;
    }
    catch (Exception localException) {}
    return paramIntent.getComponent();
  }
  
  public boolean stopService(Intent paramIntent)
  {
    return super.stopService(j.a(this.f, paramIntent, this.d));
  }
  
  public void unregisterReceiver(BroadcastReceiver paramBroadcastReceiver)
  {
    this.f.unregisterReceiver(paramBroadcastReceiver);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\sixgod\pluginsdk\apkmanager\SixGodAppContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */