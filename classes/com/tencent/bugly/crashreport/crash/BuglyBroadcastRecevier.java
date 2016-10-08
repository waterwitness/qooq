package com.tencent.bugly.crashreport.crash;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.bugly.proguard.s;
import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.v;

public class BuglyBroadcastRecevier
  extends BroadcastReceiver
{
  public static String ACTION_PROCESS_CRASHED = "com.tencent.feedback.A02";
  public static String ACTION_PROCESS_LAUNCHED = "com.tencent.feedback.A01";
  public static final long UPLOADLIMITED = 60000L;
  private static BuglyBroadcastRecevier d = null;
  private IntentFilter a = new IntentFilter();
  private Context b;
  private String c;
  
  private boolean a(Context paramContext, Intent paramIntent)
  {
    boolean bool2 = true;
    if ((paramContext != null) && (paramIntent != null)) {}
    for (;;)
    {
      boolean bool1;
      try
      {
        bool1 = paramIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE");
        if (!bool1)
        {
          bool1 = false;
          return bool1;
        }
        paramIntent = com.tencent.bugly.crashreport.common.info.b.e(this.b);
        v.c("is Connect BC " + paramIntent, new Object[0]);
        v.a("network %s changed to %s", new Object[] { this.c, paramIntent });
        if (paramIntent == null)
        {
          this.c = null;
          bool1 = bool2;
          continue;
        }
        str = this.c;
      }
      finally {}
      String str;
      this.c = paramIntent;
      long l = System.currentTimeMillis();
      com.tencent.bugly.crashreport.common.strategy.a locala = com.tencent.bugly.crashreport.common.strategy.a.a();
      s locals = s.a();
      paramContext = com.tencent.bugly.crashreport.common.info.a.a(paramContext);
      if ((locala == null) || (locals == null) || (paramContext == null))
      {
        v.d("not inited BC not work", new Object[0]);
        bool1 = bool2;
      }
      else
      {
        bool1 = bool2;
        if (!paramIntent.equals(str))
        {
          if (l - locals.a(c.a) > 60000L)
          {
            v.a("try to upload crash on network changed.", new Object[0]);
            c.a().a(0L);
          }
          bool1 = bool2;
          if (l - locals.a(1001) > 60000L)
          {
            v.a("try to upload userinfo on network changed.", new Object[0]);
            u.a().b(new Runnable()
            {
              public final void run()
              {
                com.tencent.bugly.crashreport.biz.b.a.b();
              }
            });
            bool1 = bool2;
          }
        }
      }
    }
  }
  
  public static BuglyBroadcastRecevier getInstance()
  {
    try
    {
      if (d == null) {
        d = new BuglyBroadcastRecevier();
      }
      BuglyBroadcastRecevier localBuglyBroadcastRecevier = d;
      return localBuglyBroadcastRecevier;
    }
    finally {}
  }
  
  public void addFilter(String paramString)
  {
    try
    {
      if (!this.a.hasAction(paramString)) {
        this.a.addAction(paramString);
      }
      v.c("add action %s", new Object[] { paramString });
      return;
    }
    finally {}
  }
  
  protected void finalize()
    throws Throwable
  {
    super.finalize();
    if (this.b != null) {
      this.b.unregisterReceiver(this);
    }
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    try
    {
      a(paramContext, paramIntent);
      return;
    }
    catch (Throwable paramContext)
    {
      while (v.a(paramContext)) {}
      paramContext.printStackTrace();
    }
  }
  
  public void regist(Context paramContext, b paramb)
  {
    try
    {
      v.a("regis BC", new Object[0]);
      this.b = paramContext;
      paramContext.registerReceiver(this, this.a);
      return;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
    finally {}
  }
  
  public void unregist(Context paramContext)
  {
    try
    {
      v.a("unregis BC", new Object[0]);
      paramContext.unregisterReceiver(this);
      this.b = paramContext;
      return;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        if (!v.a(paramContext)) {
          paramContext.printStackTrace();
        }
      }
    }
    finally {}
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\bugly\crashreport\crash\BuglyBroadcastRecevier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */