package com.tencent.bugly;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.bugly.proguard.l;
import com.tencent.bugly.proguard.n;
import com.tencent.bugly.proguard.s;
import com.tencent.bugly.proguard.v;
import com.tencent.bugly.proguard.w;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class b
{
  public static boolean a;
  public static boolean b;
  private static List<a> c = new ArrayList();
  private static n d;
  private static boolean e;
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean, BuglyStrategy paramBuglyStrategy)
  {
    int i = 1;
    for (;;)
    {
      try
      {
        if (e)
        {
          v.d("[init] initial Multi-times, ignore this.", new Object[0]);
          return;
        }
        if (paramContext == null)
        {
          Log.w(v.b, "[init] context of init() is null, check it.");
          continue;
        }
        if (paramString != null) {
          break;
        }
      }
      finally {}
      Log.e(v.b, "init arg 'crashReportAppID' should not be null!");
    }
    e = true;
    if (paramBoolean)
    {
      b = true;
      v.c = true;
      v.d("Bugly debug模式开启，请在发布时把isDebug关闭。 -- Running in debug model for 'isDebug' is enabled. Please disable it when you release.", new Object[0]);
      v.e("--------------------------------------------------------------------------------------------", new Object[0]);
      v.d("Bugly debug模式将有以下行为特性 -- The following list shows the behaviour of debug model: ", new Object[0]);
      v.d("[1] 输出详细的Bugly SDK的Log -- More detailed log of Bugly SDK will be output to logcat;", new Object[0]);
      v.d("[2] 每一条Crash都会被立即上报 -- Every crash caught by Bugly will be uploaded immediately.", new Object[0]);
      v.d("[3] 自定义日志将会在Logcat中输出 -- Custom log will be output to logcat.", new Object[0]);
      v.e("--------------------------------------------------------------------------------------------", new Object[0]);
      v.b("[init] bugly in debug mode.", new Object[0]);
    }
    for (;;)
    {
      label163:
      w.a(paramContext);
      com.tencent.bugly.crashreport.common.info.a locala = com.tencent.bugly.crashreport.common.info.a.a(paramContext);
      d = n.a(paramContext, c);
      s.a(paramContext);
      com.tencent.bugly.crashreport.common.strategy.a.a(paramContext, c);
      l.a(paramContext);
      Object localObject = locala.p;
      locala.getClass();
      if ((localObject != null) && (((List)localObject).contains("bugly")))
      {
        label231:
        if (i != 0) {
          break label701;
        }
        localObject = new StringBuilder();
        locala.getClass();
        v.a(" crash report start init!", new Object[0]);
        v.b("[init] bugly start init...", new Object[0]);
        locala.a(paramString);
        v.a("[param] setted APPID:%s", new Object[] { paramString });
        if (paramBuglyStrategy != null)
        {
          paramString = paramBuglyStrategy.getAppVersion();
          if (!TextUtils.isEmpty(paramString))
          {
            if (paramString.length() <= 100) {
              break label774;
            }
            localObject = paramString.substring(0, 100);
            v.d("appVersion %s length is over limit %d substring to %s", new Object[] { paramString, Integer.valueOf(100), localObject });
            paramString = (String)localObject;
            label363:
            locala.l = paramString;
            v.a("setted APPVERSION:%s", new Object[] { paramBuglyStrategy.getAppVersion() });
          }
        }
      }
      try
      {
        if (!paramBuglyStrategy.isReplaceOldChannel()) {
          break label703;
        }
        paramString = paramBuglyStrategy.getAppChannel();
        if (TextUtils.isEmpty(paramString)) {
          break label477;
        }
        if (paramString.length() <= 100) {
          break label771;
        }
        localObject = paramString.substring(0, 100);
        v.d("appChannel %s length is over limit %d substring to %s", new Object[] { paramString, Integer.valueOf(100), localObject });
        paramString = (String)localObject;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          if (b)
          {
            paramString.printStackTrace();
            continue;
            continue;
          }
        }
      }
      d.a(556, "app_channel", paramString.getBytes(), null, false);
      locala.m = paramString;
      label477:
      v.a("setted APPCHANNEL:%s", new Object[] { locala.m });
      paramString = paramBuglyStrategy.getAppPackageName();
      if (!TextUtils.isEmpty(paramString))
      {
        if (paramString.length() > 100)
        {
          localObject = paramString.substring(0, 100);
          v.d("appPackageName %s length is over limit %d substring to %s", new Object[] { paramString, Integer.valueOf(100), localObject });
          paramString = (String)localObject;
          locala.c = paramString;
          v.a("setted PACKAGENAME:%s", new Object[] { paramBuglyStrategy.getAppPackageName() });
        }
      }
      else
      {
        paramString = paramBuglyStrategy.getDeviceID();
        if (paramString != null)
        {
          if (paramString.length() > 100)
          {
            localObject = paramString.substring(0, 100);
            v.d("deviceId %s length is over limit %d substring to %s", new Object[] { paramString, Integer.valueOf(100), localObject });
            paramString = (String)localObject;
            locala.c(paramString);
            v.a("setted deviceId :%s", new Object[] { paramString });
          }
        }
        else
        {
          w.a = paramBuglyStrategy.isBuglyLogUpload();
          com.tencent.bugly.crashreport.biz.b.a(paramContext, paramBuglyStrategy);
          v.b("[init] bugly init finished.", new Object[0]);
          break;
        }
      }
      label701:
      label703:
      label771:
      label774:
      do
      {
        localObject = paramContext.getApplicationContext();
        if (localObject == null) {
          break label163;
        }
        paramContext = (Context)localObject;
        break label163;
        i = 0;
        break label231;
        break;
        paramString = d.a(556, null, true);
        if (paramString == null) {
          break label477;
        }
        paramString = (byte[])paramString.get("app_channel");
        if (paramString == null) {
          break label477;
        }
        locala.m = new String(paramString);
        break label477;
        break label363;
      } while (paramContext != null);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\bugly\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */