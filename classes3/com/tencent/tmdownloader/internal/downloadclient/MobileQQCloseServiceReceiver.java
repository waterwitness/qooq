package com.tencent.tmdownloader.internal.downloadclient;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.text.format.Time;
import com.tencent.tmassistantbase.a.h;
import com.tencent.tmassistantbase.a.m;
import java.util.ArrayList;
import java.util.List;

public class MobileQQCloseServiceReceiver
  extends BroadcastReceiver
{
  protected static MobileQQCloseServiceReceiver b = null;
  public boolean a = false;
  public HandlerThread c = new HandlerThread("checkIsAllFinishThread");
  public Handler d = null;
  
  public static MobileQQCloseServiceReceiver a()
  {
    try
    {
      if (b == null) {
        b = new MobileQQCloseServiceReceiver();
      }
      MobileQQCloseServiceReceiver localMobileQQCloseServiceReceiver = b;
      return localMobileQQCloseServiceReceiver;
    }
    finally {}
  }
  
  private String a(ArrayList<String> paramArrayList, String paramString, boolean paramBoolean)
  {
    Time localTime = new Time();
    localTime.setToNow();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(localTime.year).append(localTime.month + 1).append(localTime.monthDay);
    localStringBuilder.append(localTime.hour);
    if (paramBoolean)
    {
      localStringBuilder.append(localTime.minute - 1);
      if (paramArrayList != null) {
        break label150;
      }
    }
    label150:
    for (paramArrayList = "null";; paramArrayList = paramArrayList.toString())
    {
      localStringBuilder.append(paramArrayList);
      paramArrayList = h.a(localStringBuilder.toString());
      return h.a(paramArrayList + localStringBuilder.toString());
      localStringBuilder.append(localTime.minute);
      break;
    }
  }
  
  public void a(Context paramContext)
  {
    if (paramContext != null)
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.process.exit");
      localIntentFilter.addAction("com.tencent.process.tmdownloader.exit");
      paramContext.registerReceiver(this, localIntentFilter);
      this.a = true;
    }
  }
  
  public void b(Context paramContext)
  {
    if ((paramContext == null) || (b == null)) {}
    while (!this.a) {
      return;
    }
    paramContext.unregisterReceiver(this);
    this.a = false;
  }
  
  public String c(Context paramContext)
  {
    Object localObject = new ComponentName(paramContext, "com.tencent.tmdownloader.TMAssistantDownloadService");
    try
    {
      localObject = paramContext.getPackageManager().getServiceInfo((ComponentName)localObject, 0);
      paramContext = "com.tencent.tmassistantsdk.Service";
      if (localObject != null) {
        paramContext = ((ServiceInfo)localObject).processName;
      }
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return "";
  }
  
  public int d(Context paramContext)
  {
    int i = 0;
    String str = c(paramContext);
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    int k;
    for (int j = 0; i < paramContext.size(); j = k)
    {
      Object localObject = (ActivityManager.RunningAppProcessInfo)paramContext.get(i);
      int m = ((ActivityManager.RunningAppProcessInfo)localObject).pid;
      localObject = ((ActivityManager.RunningAppProcessInfo)localObject).processName;
      k = j;
      if (str.equals(localObject))
      {
        m.c("MobileQQCloseServiceReceiver", "MobileQQCloseServiceReceiver killProcessByName;process name: " + (String)localObject + " pid: " + m);
        m.c("MobileQQCloseServiceReceiver", "MobileQQCloseServiceReceiver killProcessByName;killProcess pid-->" + m);
        Process.killProcess(m);
        k = j + 1;
      }
      i += 1;
    }
    return j;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int k = 0;
    m.c("MobileQQCloseServiceReceiver", "receive broadcast close all service");
    String str;
    if ((paramContext != null) && (paramIntent != null))
    {
      str = paramIntent.getAction();
      if ((str != null) && ((str.equals("com.tencent.process.exit")) || (str.equals("com.tencent.process.tmdownloader.exit"))) && (paramIntent.getExtras() != null)) {}
    }
    else
    {
      return;
      break label105;
    }
    label56:
    ArrayList localArrayList = paramIntent.getExtras().getStringArrayList("procNameList");
    paramIntent = paramIntent.getExtras().getString("verify");
    int i;
    if ((paramIntent == null) || (paramIntent.length() == 0)) {
      i = 0;
    }
    for (;;)
    {
      int m;
      if ((localArrayList == null) || (localArrayList.size() == 0))
      {
        m = 1;
        label105:
        if ((i == 0) || (m == 0)) {
          break label56;
        }
        if (!this.c.isAlive())
        {
          this.c.start();
          this.d = new Handler(this.c.getLooper());
        }
        if (this.d == null) {
          break label56;
        }
        this.d.post(new a(this, paramContext));
        return;
        if ((!paramIntent.equals(a(localArrayList, str, false))) && (!paramIntent.equals(a(localArrayList, str, true)))) {
          break label258;
        }
        i = 1;
        continue;
      }
      paramIntent = c(paramContext);
      int j = 0;
      for (;;)
      {
        m = j;
        if (k >= localArrayList.size()) {
          break;
        }
        if (paramIntent.equals(localArrayList.get(k))) {
          j = 1;
        }
        k += 1;
      }
      label258:
      i = 0;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmdownloader\internal\downloadclient\MobileQQCloseServiceReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */