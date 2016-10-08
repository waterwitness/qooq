package com.tencent.tmassistantsdk.internal.openSDK;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.tmassistantbase.a.m;
import java.util.ArrayList;

public class DownloadStateChangedReceiver
  extends BroadcastReceiver
{
  protected static final String a = DownloadStateChangedReceiver.class.getSimpleName();
  protected static DownloadStateChangedReceiver b = null;
  protected HandlerThread c = new HandlerThread("downloadStateChangedThread");
  protected Handler d = null;
  protected boolean e = false;
  ArrayList<b> f = new ArrayList();
  
  public DownloadStateChangedReceiver()
  {
    this.c.start();
    this.d = new Handler(this.c.getLooper());
  }
  
  public static DownloadStateChangedReceiver a()
  {
    try
    {
      if (b == null) {
        b = new DownloadStateChangedReceiver();
      }
      DownloadStateChangedReceiver localDownloadStateChangedReceiver = b;
      return localDownloadStateChangedReceiver;
    }
    finally {}
  }
  
  public void a(Context paramContext)
  {
    m.c(a, "context = " + paramContext);
    IntentFilter localIntentFilter;
    if (!this.e)
    {
      m.c("DownloadStateChangedReceiver", "registeReceiver   context" + paramContext + "  receiver:" + this);
      localIntentFilter = new IntentFilter("com.tencent.assistantOpenSDK.downloadStateChange.action");
    }
    try
    {
      paramContext = paramContext.registerReceiver(this, localIntentFilter);
      m.c("DownloadStateChangedReceiver", "" + paramContext);
      this.e = true;
      return;
    }
    catch (Throwable paramContext)
    {
      m.c("DownloadStateChangedReceiver", "registeReceiver exception!!!");
      this.e = false;
      paramContext.printStackTrace();
    }
  }
  
  public void a(b paramb)
  {
    m.c(a, "listener = " + paramb);
    if ((paramb != null) && (!this.f.contains(paramb))) {
      this.f.add(paramb);
    }
  }
  
  public void b(Context paramContext)
  {
    if ((paramContext == null) || (b == null)) {
      m.c(a, "unRegisteReceiver fail! context = " + paramContext + ",mInstance = " + b);
    }
    while (!this.e) {
      return;
    }
    m.c("DownloadStateChangedReceiver", "realy unRegisteReceiver  context:" + paramContext + "  receiver:" + this);
    try
    {
      paramContext.unregisterReceiver(this);
      this.e = false;
      return;
    }
    catch (Throwable paramContext)
    {
      m.a("DownloadStateChangedReceiver", "unRegisteReceiver exception!!!", paramContext);
      this.e = false;
      paramContext.printStackTrace();
    }
  }
  
  public void b(b paramb)
  {
    m.c(a, "listener = " + paramb);
    if (paramb != null) {
      this.f.remove(paramb);
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    m.c(a, "context = " + paramContext + ",intent = " + paramIntent);
    if (this.d != null) {
      this.d.post(new a(this, paramIntent));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmassistantsdk\internal\openSDK\DownloadStateChangedReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */