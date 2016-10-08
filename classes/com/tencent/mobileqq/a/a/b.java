package com.tencent.mobileqq.a.a;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.c.m;
import com.tencent.mobileqq.msf.core.n;
import com.tencent.mobileqq.msf.service.MsfService;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class b
{
  private static final long a = 180000L;
  private static final int b = 20;
  private static final int c = 30000;
  private static String d = "";
  private static int e;
  private static int f;
  private static long g;
  private static long h;
  private static long i;
  private static boolean j;
  private static HashMap k = new HashMap();
  private static double l = 0.0D;
  private static long m;
  private static long n;
  private static long o;
  private static long p;
  private static long q;
  private static double r = 0.0D;
  private static String s = "";
  private static long t;
  private static int u;
  private static String v = "";
  private static long w;
  private static int x;
  private static double y;
  private static HashMap z = new HashMap();
  
  public static void a()
  {
    try
    {
      c();
      b();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2)
  {
    b();
    d = paramString;
    e = paramInt1;
    f = paramInt2;
    g = SystemClock.elapsedRealtime();
  }
  
  public static void a(String paramString, int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    try
    {
      l = l / (m + 1L) * m + paramLong / (m + 1L);
      m += 1L;
      if (!"SSO.LoginMerge".equals(paramString))
      {
        n += 1L;
        if (paramInt3 > 0) {
          o += paramInt3;
        }
        if ((TextUtils.isEmpty(s)) || (t < paramLong))
        {
          s = paramString;
          t = paramLong;
          u = paramInt1;
        }
        if ((g <= 0L) || (i - g <= 180000L)) {
          break label360;
        }
        if (!j)
        {
          j = true;
          paramString = new HashMap();
          Iterator localIterator = k.entrySet().iterator();
          while (localIterator.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)localIterator.next();
            if (((Integer)localEntry.getValue()).intValue() > 20) {
              paramString.put(localEntry.getKey(), "" + localEntry.getValue());
            }
          }
        }
        return;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    do
    {
      if (paramInt2 <= 0) {
        break;
      }
      n += paramInt2;
      break;
    } while (paramString.size() <= 0);
    paramString.put("account", MsfService.getCore().getAccountCenter().i());
    paramString.put("ip", d);
    paramString.put("port", "" + e);
    paramString.put("nettype", "" + f);
    MsfService.getCore().getStatReporter().a("ReqQualityStatExceptTemp", true, 0L, 0L, paramString, false, false);
    return;
    label360:
    i = SystemClock.elapsedRealtime();
    if (k.containsKey(paramString))
    {
      k.put(paramString, Integer.valueOf(((Integer)k.get(paramString)).intValue() + 1));
      return;
    }
    k.put(paramString, Integer.valueOf(1));
  }
  
  public static void a(String paramString, int paramInt, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    try
    {
      h = SystemClock.elapsedRealtime();
      r = r / (q + 1L) * q + paramLong1 / (q + 1L);
      q += 1L;
      if ((TextUtils.isEmpty(v)) || (w < paramLong1))
      {
        v = paramString;
        w = paramLong1;
        x = paramInt;
      }
      if (!paramBoolean)
      {
        y = y / (p + 1L) * p + paramLong2 / (p + 1L);
        p += 1L;
        if ((!TextUtils.isEmpty(v)) && (w < paramLong1))
        {
          v = paramString;
          w = paramLong1;
          x = paramInt;
        }
        if (paramLong2 <= 30000L)
        {
          paramInt = (int)(paramLong2 / 1000L);
          if (z.containsKey(Integer.valueOf(paramInt)))
          {
            z.put(Integer.valueOf(paramInt), Integer.valueOf(((Integer)z.get(Integer.valueOf(paramInt))).intValue() + 1));
            return;
          }
          z.put(Integer.valueOf(paramInt), Integer.valueOf(1));
          return;
        }
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private static void b()
  {
    d = "";
    e = 0;
    f = 0;
    g = 0L;
    i = 0L;
    j = false;
    h = 0L;
    l = 0.0D;
    r = 0.0D;
    n = 0L;
    o = 0L;
    m = 0L;
    p = 0L;
    q = 0L;
    s = "";
    t = 0L;
    u = 0;
    v = "";
    w = 0L;
    x = 0;
    k.clear();
    y = 0.0D;
    z.clear();
  }
  
  private static void c()
  {
    if (TextUtils.isEmpty(d)) {}
    while (m == 0L) {
      return;
    }
    long l1 = SystemClock.elapsedRealtime();
    HashMap localHashMap = new HashMap();
    localHashMap.put("account", MsfService.getCore().getAccountCenter().i());
    localHashMap.put("ip", d);
    localHashMap.put("port", "" + e);
    localHashMap.put("nettype", "" + f);
    localHashMap.put("imsi", n.e());
    localHashMap.put("reqtotalcount", "" + n);
    localHashMap.put("reqnoresp", "" + o);
    localHashMap.put("reqcount", "" + m);
    localHashMap.put("avareqsize", "" + l);
    localHashMap.put("respcount", "" + p);
    localHashMap.put("resptotalcount", "" + q);
    localHashMap.put("avarespsize", "" + r);
    localHashMap.put("maxreqcmd", s);
    localHashMap.put("maxreqsize", "" + t);
    localHashMap.put("maxreqseq", "" + u);
    localHashMap.put("maxrespcmd", v);
    localHashMap.put("maxrespsize", "" + w);
    localHashMap.put("maxrespseq", "" + x);
    localHashMap.put("avacost", "" + y);
    localHashMap.put("conntime", "" + g);
    localHashMap.put("disconntime", "" + l1);
    localHashMap.put("lastresptime", "" + h);
    localHashMap.put("lastreqtime", "" + i);
    if (z.size() > 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = z.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localStringBuilder.append(localEntry.getKey()).append(":").append(localEntry.getValue()).append("|");
      }
      localHashMap.put("costmap", localStringBuilder.toString());
    }
    MsfService.getCore().getStatReporter().a("ReqQualityStatTemp", true, y, (int)l, localHashMap, false, false);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\a\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */