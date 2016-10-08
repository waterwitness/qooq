package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler;
import com.tencent.bugly.proguard.n;
import com.tencent.bugly.proguard.s;
import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class c
{
  public static int a = 0;
  public static boolean b = false;
  public static boolean c = true;
  public static int d = 20000;
  public static int e = 20000;
  public static long f = 604800000L;
  public static String g = null;
  public static boolean h = false;
  public static String i = null;
  public static int j = 5000;
  public static boolean k = true;
  private static c n;
  public final b l;
  private final Context m;
  private final d o;
  private final NativeCrashHandler p;
  private com.tencent.bugly.crashreport.common.strategy.a q;
  private u r;
  private final com.tencent.bugly.crashreport.crash.anr.b s;
  
  private c(int paramInt, Context paramContext, u paramu, boolean paramBoolean, com.tencent.bugly.proguard.a parama, e parame, String paramString)
  {
    a = paramInt;
    Object localObject1;
    if (paramContext == null) {
      localObject1 = paramContext;
    }
    for (;;)
    {
      this.m = ((Context)localObject1);
      this.q = com.tencent.bugly.crashreport.common.strategy.a.a();
      paramContext = s.a();
      Object localObject2 = n.a();
      com.tencent.bugly.crashreport.common.info.a locala = com.tencent.bugly.crashreport.common.info.a.a((Context)localObject1);
      this.r = paramu;
      this.l = new b(paramInt, (Context)localObject1, paramContext, (n)localObject2, this.q, parama, parame);
      this.o = new d((Context)localObject1, this.l, this.q, locala);
      this.p = NativeCrashHandler.getInstance((Context)localObject1, locala, this.l, this.q, paramu, paramBoolean, paramString);
      this.s = new com.tencent.bugly.crashreport.crash.anr.b((Context)localObject1, this.q, locala, paramu, this.l);
      return;
      localObject2 = paramContext.getApplicationContext();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = paramContext;
      }
    }
  }
  
  public static c a()
  {
    return n;
  }
  
  public static void a(int paramInt, Context paramContext, boolean paramBoolean, com.tencent.bugly.proguard.a parama, e parame, String paramString)
  {
    try
    {
      if (n == null) {
        n = new c(1003, paramContext, u.a(), false, null, parame, null);
      }
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public final void a(long paramLong)
  {
    u.a().a(new Thread()
    {
      public final void run()
      {
        if (!com.tencent.bugly.proguard.a.a(c.b(c.this), "local_crash_lock", 10000L)) {
          return;
        }
        List localList = c.this.l.a();
        if ((localList != null) && (localList.size() > 0))
        {
          int j = localList.size();
          if (j > 100L)
          {
            ArrayList localArrayList = new ArrayList();
            Collections.sort(localList);
            int i = 0;
            for (;;)
            {
              localObject = localArrayList;
              if (i >= 100L) {
                break;
              }
              localArrayList.add(localList.get(j - 1 - i));
              i += 1;
            }
          }
          Object localObject = localList;
          c.this.l.a((List)localObject, 0L, false, false);
        }
        com.tencent.bugly.proguard.a.b(c.b(c.this), "local_crash_lock");
      }
    }, paramLong);
  }
  
  public final void a(StrategyBean paramStrategyBean)
  {
    this.o.a(paramStrategyBean);
    this.p.onStrategyChanged(paramStrategyBean);
    this.s.a(paramStrategyBean);
  }
  
  public final void a(CrashDetailBean paramCrashDetailBean)
  {
    this.l.c(paramCrashDetailBean);
  }
  
  public final void a(e parame)
  {
    try
    {
      if (this.l != null) {
        this.l.a = parame;
      }
      return;
    }
    finally
    {
      parame = finally;
      throw parame;
    }
  }
  
  public final void a(final Thread paramThread, final Throwable paramThrowable, boolean paramBoolean, final String paramString, final byte[] paramArrayOfByte)
  {
    this.r.b(new Runnable()
    {
      public final void run()
      {
        try
        {
          v.c("post a throwable %b", new Object[] { Boolean.valueOf(this.a) });
          c.a(c.this).a(paramThread, paramThrowable, false, paramString, paramArrayOfByte);
          return;
        }
        catch (Throwable localThrowable)
        {
          if (v.b(localThrowable) != true) {
            localThrowable.printStackTrace();
          }
          v.e("java catch error: %s", new Object[] { paramThrowable.toString() });
        }
      }
    });
  }
  
  public final void b()
  {
    this.o.b();
  }
  
  public final void c()
  {
    this.o.a();
  }
  
  public final void d()
  {
    this.p.setUserOpened(false);
  }
  
  public final void e()
  {
    this.p.setUserOpened(true);
  }
  
  public final void f()
  {
    this.s.a(true);
  }
  
  public final void g()
  {
    this.s.a(false);
  }
  
  public final boolean h()
  {
    return this.s.a();
  }
  
  public final byte[] i()
  {
    List localList = this.l.a();
    return this.l.a(localList, true);
  }
  
  public final int j()
  {
    List localList = this.l.a();
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public final NativeExceptionHandler k()
  {
    return this.p.getNativeExceptionHandler();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\bugly\crashreport\crash\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */