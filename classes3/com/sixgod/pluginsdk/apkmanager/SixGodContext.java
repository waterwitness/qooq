package com.sixgod.pluginsdk.apkmanager;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.sixgod.pluginsdk.component.j;
import java.util.HashMap;

public class SixGodContext
  extends ContextWrapper
{
  ClassLoader a;
  Resources b;
  AssetManager c;
  String d;
  boolean e = false;
  a f;
  Context g;
  SixGodPackageManager h;
  
  public SixGodContext(Context paramContext1, String paramString, a parama, Context paramContext2)
  {
    super(paramContext1);
    this.f = parama;
    this.g = paramContext2;
    this.d = paramString;
  }
  
  public SixGodContext(Context paramContext1, String paramString, ClassLoader paramClassLoader, Resources paramResources, AssetManager paramAssetManager, a parama, Context paramContext2)
  {
    super(paramContext1);
    this.a = paramClassLoader;
    this.b = paramResources;
    this.c = paramAssetManager;
    this.d = paramString;
    this.e = true;
    this.f = parama;
    this.g = paramContext2;
  }
  
  public boolean bindService(Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt)
  {
    return super.bindService(j.a(this.g, paramIntent, this.d), paramServiceConnection, paramInt);
  }
  
  public Context getApplicationContext()
  {
    Object localObject1 = new StringBuilder("getApplicationContext = ");
    Object localObject2 = this.f;
    String str = this.d;
    Log.i("qiqili", ((c)((a)localObject2).e.get(str)).e.getApplicationContext());
    localObject1 = this.f;
    localObject2 = this.d;
    return ((c)((a)localObject1).e.get(localObject2)).e.getApplicationContext();
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
    if (com.sixgod.pluginsdk.b.c.a()) {
      return this.g.getPackageName();
    }
    if (this.e) {
      return this.d;
    }
    return super.getPackageName();
  }
  
  public PackageManager getPackageManager()
  {
    if (this.h == null) {
      this.h = new SixGodPackageManager(super.getPackageManager());
    }
    return this.h;
  }
  
  public String getPackageName()
  {
    if (com.sixgod.pluginsdk.b.c.a()) {
      return this.g.getPackageName();
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
    if ((paramString.equals("layout_inflater")) || (paramString.equals("audio"))) {
      return super.getSystemService(paramString);
    }
    Log.i("qiqili", "getSystemService name = " + paramString + "application = " + this.g.getApplicationContext());
    return this.g.getSystemService(paramString);
  }
  
  public Intent registerReceiver(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter)
  {
    return this.g.registerReceiver(paramBroadcastReceiver, paramIntentFilter);
  }
  
  public Intent registerReceiver(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter, String paramString, Handler paramHandler)
  {
    return this.g.registerReceiver(paramBroadcastReceiver, paramIntentFilter, paramString, paramHandler);
  }
  
  public void removeStickyBroadcast(Intent paramIntent)
  {
    this.g.removeStickyBroadcast(paramIntent);
  }
  
  public void sendBroadcast(Intent paramIntent)
  {
    com.sixgod.pluginsdk.log.a.a("SixgodContext,插件内发送广播 action =  " + paramIntent.getAction());
    this.g.sendBroadcast(paramIntent);
  }
  
  public void sendBroadcast(Intent paramIntent, String paramString)
  {
    this.g.sendBroadcast(paramIntent, paramString);
  }
  
  public void sendOrderedBroadcast(Intent paramIntent, String paramString)
  {
    this.g.sendOrderedBroadcast(paramIntent, paramString);
  }
  
  public void sendOrderedBroadcast(Intent paramIntent, String paramString1, BroadcastReceiver paramBroadcastReceiver, Handler paramHandler, int paramInt, String paramString2, Bundle paramBundle)
  {
    this.g.sendOrderedBroadcast(paramIntent, paramString1, paramBroadcastReceiver, paramHandler, paramInt, paramString2, paramBundle);
  }
  
  public void sendStickyBroadcast(Intent paramIntent)
  {
    this.g.sendStickyBroadcast(paramIntent);
  }
  
  public void sendStickyOrderedBroadcast(Intent paramIntent, BroadcastReceiver paramBroadcastReceiver, Handler paramHandler, int paramInt, String paramString, Bundle paramBundle)
  {
    this.g.sendStickyOrderedBroadcast(paramIntent, paramBroadcastReceiver, paramHandler, paramInt, paramString, paramBundle);
  }
  
  public void startActivity(Intent paramIntent)
  {
    super.startActivity(j.a(this.g, paramIntent));
  }
  
  public ComponentName startService(Intent paramIntent)
  {
    return super.startService(j.a(this.g, paramIntent, this.d));
  }
  
  public boolean stopService(Intent paramIntent)
  {
    return super.stopService(j.a(this.g, paramIntent, this.d));
  }
  
  public void unregisterReceiver(BroadcastReceiver paramBroadcastReceiver)
  {
    this.g.unregisterReceiver(paramBroadcastReceiver);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\sixgod\pluginsdk\apkmanager\SixGodContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */