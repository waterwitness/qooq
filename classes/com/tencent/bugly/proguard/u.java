package com.tencent.bugly.proguard;

import android.util.Log;
import com.tencent.bugly.b;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class u
{
  private static u a;
  private ScheduledExecutorService b = null;
  private ThreadPoolExecutor c = null;
  private ThreadPoolExecutor d = null;
  
  protected u()
  {
    ThreadFactory local1 = new ThreadFactory()
    {
      public final Thread newThread(Runnable paramAnonymousRunnable)
      {
        paramAnonymousRunnable = new Thread(paramAnonymousRunnable);
        paramAnonymousRunnable.setName("BUGLY_THREAD");
        return paramAnonymousRunnable;
      }
    };
    this.b = Executors.newScheduledThreadPool(3, local1);
    this.c = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue(100), local1);
    this.d = new ThreadPoolExecutor(2, Integer.MAX_VALUE, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), local1);
    if ((this.b == null) || (this.b.isShutdown())) {
      v.d("ScheduledExecutorService is not valiable!", new Object[0]);
    }
    if ((this.c == null) || (this.c.isShutdown())) {
      v.d("QueueExecutorService is not valiable!", new Object[0]);
    }
    if ((this.d == null) || (this.d.isShutdown())) {
      v.d("ploadExecutorService is not valiable!", new Object[0]);
    }
  }
  
  public static u a()
  {
    try
    {
      if (a == null) {
        a = new u();
      }
      u localu = a;
      return localu;
    }
    finally {}
  }
  
  /* Error */
  private boolean b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 19	com/tencent/bugly/proguard/u:b	Ljava/util/concurrent/ScheduledExecutorService;
    //   6: ifnull +57 -> 63
    //   9: aload_0
    //   10: getfield 19	com/tencent/bugly/proguard/u:b	Ljava/util/concurrent/ScheduledExecutorService;
    //   13: invokeinterface 58 1 0
    //   18: ifne +45 -> 63
    //   21: aload_0
    //   22: getfield 21	com/tencent/bugly/proguard/u:c	Ljava/util/concurrent/ThreadPoolExecutor;
    //   25: ifnull +38 -> 63
    //   28: aload_0
    //   29: getfield 21	com/tencent/bugly/proguard/u:c	Ljava/util/concurrent/ThreadPoolExecutor;
    //   32: invokevirtual 66	java/util/concurrent/ThreadPoolExecutor:isShutdown	()Z
    //   35: ifne +28 -> 63
    //   38: aload_0
    //   39: getfield 23	com/tencent/bugly/proguard/u:d	Ljava/util/concurrent/ThreadPoolExecutor;
    //   42: ifnull +21 -> 63
    //   45: aload_0
    //   46: getfield 23	com/tencent/bugly/proguard/u:d	Ljava/util/concurrent/ThreadPoolExecutor;
    //   49: invokevirtual 66	java/util/concurrent/ThreadPoolExecutor:isShutdown	()Z
    //   52: istore_2
    //   53: iload_2
    //   54: ifne +9 -> 63
    //   57: iconst_1
    //   58: istore_2
    //   59: aload_0
    //   60: monitorexit
    //   61: iload_2
    //   62: ireturn
    //   63: iconst_0
    //   64: istore_2
    //   65: goto -6 -> 59
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	u
    //   68	4	1	localObject	Object
    //   52	13	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	53	68	finally
  }
  
  public final void a(ScheduledExecutorService paramScheduledExecutorService)
  {
    try
    {
      this.b = paramScheduledExecutorService;
      return;
    }
    finally
    {
      paramScheduledExecutorService = finally;
      throw paramScheduledExecutorService;
    }
  }
  
  public final boolean a(Runnable paramRunnable)
  {
    boolean bool2 = false;
    for (;;)
    {
      boolean bool1;
      try
      {
        if (!b())
        {
          bool1 = bool2;
          if (b.b)
          {
            Log.w(v.b, "queue handler was closed , should not post task!");
            bool1 = bool2;
          }
          return bool1;
        }
        if (paramRunnable == null)
        {
          bool1 = bool2;
          if (!b.b) {
            continue;
          }
          Log.w(v.b, "queue task is null");
          bool1 = bool2;
          continue;
        }
        try
        {
          this.c.submit(paramRunnable);
          bool1 = true;
        }
        catch (Throwable paramRunnable)
        {
          bool1 = bool2;
        }
      }
      finally {}
      if (b.b)
      {
        paramRunnable.printStackTrace();
        bool1 = bool2;
      }
    }
  }
  
  public final boolean a(Runnable paramRunnable, long paramLong)
  {
    boolean bool2 = false;
    for (;;)
    {
      boolean bool1;
      try
      {
        if (!b())
        {
          v.d("async handler was closed , should not post task!", new Object[0]);
          bool1 = bool2;
          return bool1;
        }
        if (paramRunnable == null)
        {
          v.d("async task == null", new Object[0]);
          bool1 = bool2;
          continue;
        }
        if (paramLong <= 0L) {}
      }
      finally {}
      for (;;)
      {
        v.c("delay %d task %s", new Object[] { Long.valueOf(paramLong), paramRunnable.getClass().getName() });
        try
        {
          this.b.schedule(paramRunnable, paramLong, TimeUnit.MILLISECONDS);
          bool1 = true;
        }
        catch (Throwable paramRunnable)
        {
          bool1 = bool2;
        }
        paramLong = 0L;
      }
      if (b.b)
      {
        paramRunnable.printStackTrace();
        bool1 = bool2;
      }
    }
  }
  
  public final boolean b(Runnable paramRunnable)
  {
    boolean bool2 = false;
    for (;;)
    {
      boolean bool1;
      try
      {
        if (!b())
        {
          v.d("async handler was closed , should not post task!", new Object[0]);
          bool1 = bool2;
          return bool1;
        }
        if (paramRunnable == null)
        {
          v.d("async task == null", new Object[0]);
          bool1 = bool2;
          continue;
        }
      }
      finally {}
      tmp57_54[0] = paramRunnable.getClass().getName();
      v.c("normal task %s", tmp57_54);
      try
      {
        this.b.execute(paramRunnable);
        bool1 = true;
      }
      catch (Throwable paramRunnable)
      {
        bool1 = bool2;
      }
      if (b.b)
      {
        paramRunnable.printStackTrace();
        bool1 = bool2;
      }
    }
  }
  
  public final boolean c(Runnable paramRunnable)
  {
    boolean bool2 = false;
    for (;;)
    {
      boolean bool1;
      try
      {
        if (!b())
        {
          bool1 = bool2;
          if (b.b)
          {
            Log.w(v.b, "queue handler was closed , should not post task!");
            bool1 = bool2;
          }
          return bool1;
        }
        if (paramRunnable == null)
        {
          bool1 = bool2;
          if (!b.b) {
            continue;
          }
          Log.w(v.b, "queue task is null");
          bool1 = bool2;
          continue;
        }
        try
        {
          this.d.submit(paramRunnable);
          bool1 = true;
        }
        catch (Throwable paramRunnable)
        {
          bool1 = bool2;
        }
      }
      finally {}
      if (b.b)
      {
        paramRunnable.printStackTrace();
        bool1 = bool2;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\bugly\proguard\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */