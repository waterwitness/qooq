package com.tencent.bugly.crashreport.biz;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.s;
import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.v;
import java.util.List;

public final class b
{
  public static a a;
  private static boolean b;
  private static int c = 10;
  private static long d = 300000L;
  private static long e = 30000L;
  private static long f = 0L;
  private static int g;
  private static long h;
  private static long i;
  private static long j = 0L;
  private static Application.ActivityLifecycleCallbacks k = null;
  private static Class<?> l = null;
  
  public static void a(Context paramContext, final BuglyStrategy paramBuglyStrategy)
  {
    if (b) {
      return;
    }
    e = com.tencent.bugly.crashreport.common.strategy.a.a().c().p;
    c = com.tencent.bugly.crashreport.common.strategy.a.a().c().v;
    a = new a(paramContext);
    b = true;
    if (paramBuglyStrategy != null) {
      l = paramBuglyStrategy.getUserInfoActivity();
    }
    for (long l1 = paramBuglyStrategy.getAppReportDelay();; l1 = 0L)
    {
      if (l1 <= 0L)
      {
        c(paramContext, paramBuglyStrategy);
        return;
      }
      u.a().a(new Runnable()
      {
        public final void run()
        {
          b.b(this.a, paramBuglyStrategy);
        }
      }, l1);
      return;
    }
  }
  
  public static void a(StrategyBean paramStrategyBean)
  {
    if (paramStrategyBean == null) {}
    do
    {
      return;
      if (paramStrategyBean.p > 0L) {
        e = paramStrategyBean.p;
      }
      if (paramStrategyBean.v > 0) {
        c = paramStrategyBean.v;
      }
    } while (paramStrategyBean.w <= 0L);
    d = paramStrategyBean.w;
  }
  
  private static void c(Context paramContext, BuglyStrategy paramBuglyStrategy)
  {
    boolean bool2;
    boolean bool1;
    if (paramBuglyStrategy != null)
    {
      bool2 = paramBuglyStrategy.recordUserInfoOnceADay();
      bool1 = paramBuglyStrategy.isEnableUserInfo();
    }
    for (;;)
    {
      int m;
      Object localObject2;
      if (bool2)
      {
        paramBuglyStrategy = com.tencent.bugly.crashreport.common.info.a.a(paramContext);
        localObject1 = paramBuglyStrategy.d;
        localObject1 = a.a((String)localObject1);
        if (localObject1 != null)
        {
          m = 0;
          if (m < ((List)localObject1).size())
          {
            localObject2 = (UserInfoBean)((List)localObject1).get(m);
            if ((((UserInfoBean)localObject2).n.equals(paramBuglyStrategy.l)) && (((UserInfoBean)localObject2).b == 1))
            {
              long l1 = com.tencent.bugly.proguard.a.e();
              if (l1 <= 0L) {
                break label146;
              }
              if (((UserInfoBean)localObject2).e >= l1) {
                if (((UserInfoBean)localObject2).f <= 0L) {
                  a.b();
                }
              }
            }
          }
        }
        label146:
        for (m = 0;; m = 1)
        {
          if (m != 0) {
            break label152;
          }
          return;
          m += 1;
          break;
        }
        label152:
        bool1 = false;
      }
      Object localObject1 = com.tencent.bugly.crashreport.common.info.a.a();
      if (localObject1 != null)
      {
        int n = 0;
        localObject2 = Thread.currentThread().getStackTrace();
        int i1 = localObject2.length;
        paramBuglyStrategy = null;
        m = 0;
        while (m < i1)
        {
          Object localObject3 = localObject2[m];
          if (((StackTraceElement)localObject3).getMethodName().equals("onCreate")) {
            paramBuglyStrategy = ((StackTraceElement)localObject3).getClassName();
          }
          if (((StackTraceElement)localObject3).getClassName().equals("android.app.Activity")) {
            n = 1;
          }
          m += 1;
        }
        if (paramBuglyStrategy == null) {
          break label393;
        }
        if (n == 0) {
          break label387;
        }
        ((com.tencent.bugly.crashreport.common.info.a)localObject1).q = true;
      }
      for (;;)
      {
        ((com.tencent.bugly.crashreport.common.info.a)localObject1).r = paramBuglyStrategy;
        if (bool1)
        {
          paramBuglyStrategy = null;
          if (Build.VERSION.SDK_INT >= 14)
          {
            if ((paramContext.getApplicationContext() instanceof Application)) {
              paramBuglyStrategy = (Application)paramContext.getApplicationContext();
            }
            if (paramBuglyStrategy == null) {}
          }
        }
        try
        {
          if (k == null) {
            k = new Application.ActivityLifecycleCallbacks()
            {
              public final void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle) {}
              
              public final void onActivityDestroyed(Activity paramAnonymousActivity) {}
              
              public final void onActivityPaused(Activity paramAnonymousActivity)
              {
                Object localObject = "unknown";
                if (paramAnonymousActivity != null) {
                  localObject = paramAnonymousActivity.getClass().getName();
                }
                if ((b.a() != null) && (!b.a().getName().equals(localObject))) {}
                do
                {
                  return;
                  v.c(">>> %s onPaused <<<", new Object[] { localObject });
                  localObject = com.tencent.bugly.crashreport.common.info.a.a();
                } while (localObject == null);
                ((com.tencent.bugly.crashreport.common.info.a)localObject).q = false;
                ((com.tencent.bugly.crashreport.common.info.a)localObject).t = System.currentTimeMillis();
                ((com.tencent.bugly.crashreport.common.info.a)localObject).u = (((com.tencent.bugly.crashreport.common.info.a)localObject).t - ((com.tencent.bugly.crashreport.common.info.a)localObject).s);
                b.b(((com.tencent.bugly.crashreport.common.info.a)localObject).t);
                if (((com.tencent.bugly.crashreport.common.info.a)localObject).u < 0L) {
                  ((com.tencent.bugly.crashreport.common.info.a)localObject).u = 0L;
                }
                if (paramAnonymousActivity != null)
                {
                  ((com.tencent.bugly.crashreport.common.info.a)localObject).r = "background";
                  return;
                }
                ((com.tencent.bugly.crashreport.common.info.a)localObject).r = "unknown";
              }
              
              public final void onActivityResumed(Activity paramAnonymousActivity)
              {
                String str = "unknown";
                if (paramAnonymousActivity != null) {
                  str = paramAnonymousActivity.getClass().getName();
                }
                if ((b.a() != null) && (!b.a().getName().equals(str))) {}
                label185:
                do
                {
                  for (;;)
                  {
                    return;
                    v.c(">>> %s onResumed <<<", new Object[] { str });
                    paramAnonymousActivity = com.tencent.bugly.crashreport.common.info.a.a();
                    if (paramAnonymousActivity != null)
                    {
                      paramAnonymousActivity.q = true;
                      paramAnonymousActivity.r = str;
                      paramAnonymousActivity.s = System.currentTimeMillis();
                      paramAnonymousActivity.v = (paramAnonymousActivity.s - b.b());
                      long l2 = paramAnonymousActivity.s - b.c();
                      if (b.d() > 0L) {}
                      for (l1 = b.d(); l2 > l1; l1 = b.e())
                      {
                        paramAnonymousActivity.b();
                        b.f();
                        v.a("[session] launch app one times (app in background %d seconds and over %d seconds)", new Object[] { Long.valueOf(l2 / 1000L), Long.valueOf(b.e() / 1000L) });
                        if (b.g() % b.h() != 0) {
                          break label185;
                        }
                        b.a.a(4, true, 0L);
                        return;
                      }
                    }
                  }
                  b.a.a(4, false, 0L);
                  l1 = System.currentTimeMillis();
                } while (l1 - b.i() <= b.j());
                b.a(l1);
                v.a("add a timer to upload hot start user info", new Object[0]);
                paramAnonymousActivity = b.a;
                long l1 = b.j();
                u.a().a(new a.a(paramAnonymousActivity, null, true), l1);
              }
              
              public final void onActivitySaveInstanceState(Activity paramAnonymousActivity, Bundle paramAnonymousBundle) {}
              
              public final void onActivityStarted(Activity paramAnonymousActivity) {}
              
              public final void onActivityStopped(Activity paramAnonymousActivity) {}
            };
          }
          paramBuglyStrategy.registerActivityLifecycleCallbacks(k);
        }
        catch (Exception paramContext)
        {
          for (;;) {}
        }
        i = System.currentTimeMillis();
        a.a(1, true, 0L);
        s.a().a(1001, System.currentTimeMillis());
        v.a("[session] launch app, new start", new Object[0]);
        a.a();
        paramContext = a;
        u.a().a(new a.c(paramContext, 21600000L), 21600000L);
        return;
        label387:
        paramBuglyStrategy = "background";
        continue;
        label393:
        paramBuglyStrategy = "unknown";
      }
      bool1 = true;
      bool2 = false;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\bugly\crashreport\biz\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */