package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import com.tencent.bugly.crashreport.common.info.b;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class t
  implements Runnable
{
  private int a = 1;
  private int b = 30000;
  private final Context c;
  private final int d;
  private final byte[] e;
  private final com.tencent.bugly.crashreport.common.info.a f;
  private final com.tencent.bugly.crashreport.common.strategy.a g;
  private final q h;
  private final s i;
  private final int j;
  private final r k;
  private final r l;
  private String m = "";
  private int n = 0;
  private long o = 0L;
  private long p = 0L;
  private boolean q = true;
  private boolean r = false;
  
  public t(Context paramContext, int paramInt1, int paramInt2, byte[] paramArrayOfByte, String paramString, r paramr, boolean paramBoolean)
  {
    this(paramContext, paramInt1, paramInt2, paramArrayOfByte, paramString, paramr, paramBoolean, 1, 30000, false);
  }
  
  private t(Context paramContext, int paramInt1, int paramInt2, byte[] paramArrayOfByte, String paramString, r paramr, boolean paramBoolean1, int paramInt3, int paramInt4, boolean paramBoolean2)
  {
    this.c = paramContext;
    this.f = com.tencent.bugly.crashreport.common.info.a.a(paramContext);
    this.e = paramArrayOfByte;
    this.g = com.tencent.bugly.crashreport.common.strategy.a.a();
    this.h = q.a(paramContext);
    this.i = s.a();
    this.j = paramInt1;
    this.m = paramString;
    this.k = paramr;
    this.l = this.i.a;
    this.q = paramBoolean1;
    paramInt1 = paramInt2;
    if (paramBoolean1) {
      switch (paramInt2)
      {
      default: 
        paramInt1 = paramInt2;
      }
    }
    for (;;)
    {
      this.d = paramInt1;
      this.a = 1;
      this.b = 30000;
      this.r = paramBoolean2;
      return;
      paramInt1 = 830;
      continue;
      paramInt1 = 840;
    }
  }
  
  private t(Context paramContext, int paramInt1, int paramInt2, byte[] paramArrayOfByte, String paramString, r paramr, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramContext, paramInt1, paramInt2, paramArrayOfByte, paramString, paramr, paramBoolean1, 1, 30000, paramBoolean2);
  }
  
  public t(Context paramContext, int paramInt, aj paramaj, String paramString, r paramr, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramContext, paramInt, paramaj.g, a.a(paramaj), paramString, paramr, paramBoolean1, paramBoolean2);
  }
  
  private void a(ak paramak, boolean paramBoolean, int paramInt1, String paramString, int paramInt2)
  {
    String str;
    switch (this.d)
    {
    default: 
      str = String.valueOf(this.d);
      if (paramBoolean) {
        v.a("[upload] success: %s", new Object[] { str });
      }
      break;
    }
    for (;;)
    {
      if (this.o + this.p > 0L)
      {
        long l1 = this.i.a(this.r);
        long l2 = this.o;
        long l3 = this.p;
        this.i.a(l1 + l2 + l3, this.r);
      }
      if (this.k != null) {
        this.k.a(this.d, paramak, this.o, this.p, paramBoolean, paramString);
      }
      if (this.l != null) {
        this.l.a(this.d, paramak, this.o, this.p, paramBoolean, paramString);
      }
      return;
      str = "crash";
      break;
      str = "userinfo";
      break;
      v.e("[upload] fail! %s %d %s", new Object[] { str, Integer.valueOf(paramInt1), paramString });
      if (this.q) {
        this.i.a(paramInt2, null);
      }
    }
  }
  
  private static boolean a(ak paramak, com.tencent.bugly.crashreport.common.info.a parama, com.tencent.bugly.crashreport.common.strategy.a parama1)
  {
    if (paramak == null)
    {
      v.d("resp == null!", new Object[0]);
      return false;
    }
    if (paramak.a != 0)
    {
      v.e("resp result error %d", new Object[] { Byte.valueOf(paramak.a) });
      return false;
    }
    for (;;)
    {
      try
      {
        String str = paramak.d;
        if ((str == null) || (str.trim().length() <= 0)) {
          continue;
        }
        i1 = 0;
        if ((i1 == 0) && (com.tencent.bugly.crashreport.common.info.a.a().g() != paramak.d))
        {
          n.a().a(com.tencent.bugly.crashreport.common.strategy.a.a, "key_ip", paramak.d.getBytes("UTF-8"), null, true);
          parama.d(paramak.d);
        }
        str = paramak.g;
        if ((str == null) || (str.trim().length() <= 0)) {
          continue;
        }
        i1 = 0;
        if ((i1 == 0) && (com.tencent.bugly.crashreport.common.info.a.a().h() != paramak.g))
        {
          n.a().a(com.tencent.bugly.crashreport.common.strategy.a.a, "key_imei", paramak.g.getBytes("UTF-8"), null, true);
          parama.e(paramak.g);
        }
      }
      catch (Throwable localThrowable)
      {
        int i1;
        boolean bool1;
        boolean bool2;
        boolean bool3;
        continue;
      }
      parama.k = paramak.e;
      if (paramak.b != 510) {
        continue;
      }
      if (paramak.c != null) {
        continue;
      }
      v.e("remote data is miss! %d", new Object[] { Integer.valueOf(paramak.b) });
      return false;
      i1 = 1;
      continue;
      i1 = 1;
    }
    parama = (am)a.a(paramak.c, am.class);
    if (parama == null)
    {
      v.e("remote data is error! %d", new Object[] { Integer.valueOf(paramak.b) });
      return false;
    }
    bool1 = parama.a;
    bool2 = parama.c;
    bool3 = parama.b;
    if (parama.g == null) {}
    for (i1 = -1;; i1 = parama.g.size())
    {
      v.c("en:%b qu:%b uin:%b vm:%d", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Integer.valueOf(i1) });
      parama1.a(parama);
      return true;
    }
  }
  
  public final void a(long paramLong)
  {
    this.n += 1;
    this.o += paramLong;
  }
  
  public final void b(long paramLong)
  {
    this.p += paramLong;
  }
  
  public final void run()
  {
    Object localObject2;
    try
    {
      localObject2 = this.e;
      this.n = 0;
      this.o = 0L;
      this.p = 0L;
      this.i.a(this.j, System.currentTimeMillis());
      if (this.k != null) {
        this.k.a(this.d);
      }
      if (this.l != null) {
        this.l.a(this.d);
      }
      if (b.e(this.c) == null)
      {
        a(null, false, 0, "network is not availiable!", 0);
        return;
      }
      if ((localObject2 != null) && (localObject2.length != 0)) {
        break label130;
      }
      a(null, false, 0, "[upload] fail, request package is empty!", 0);
      return;
    }
    catch (Throwable localThrowable1)
    {
      if (v.a(localThrowable1)) {
        break label1673;
      }
    }
    localThrowable1.printStackTrace();
    return;
    label130:
    long l1 = this.i.a(this.r);
    if (localObject2.length + l1 >= 2097152L)
    {
      v.e("up too much wait to next time ! %d %d ", new Object[] { Long.valueOf(l1), Long.valueOf(2097152L) });
      a(null, false, 0, "[upload] fail, over net consume: " + 2048L + "K", 0);
      return;
    }
    v.c("do upload task %d", new Object[] { Integer.valueOf(this.d) });
    if ((this.c == null) || (localObject2 == null) || (this.f == null) || (this.g == null) || (this.h == null))
    {
      a(null, false, 0, "[upload] fail, illegal access error!", 0);
      return;
    }
    StrategyBean localStrategyBean = this.g.c();
    if (localStrategyBean == null)
    {
      a(null, false, 0, "[upload] fail, illegal local strategy!", 0);
      return;
    }
    int i2 = 0;
    HashMap localHashMap = new HashMap();
    localHashMap.put("prodId", this.f.d());
    localHashMap.put("bundleId", this.f.c);
    localHashMap.put("appVer", this.f.l);
    Object localObject1 = localObject2;
    int i1;
    label624:
    int i4;
    label790:
    label801:
    int i3;
    Object localObject3;
    if (this.q)
    {
      localHashMap.put("cmd", Integer.toString(this.d));
      localHashMap.put("platformId", Byte.toString((byte)1));
      this.f.getClass();
      localHashMap.put("sdkVer", "2.2.1");
      localHashMap.put("strategylastUpdateTime", Long.toString(localStrategyBean.o));
      if (!this.i.a(localHashMap))
      {
        a(null, false, 0, "[upload] fail, failed to add security info to HTTP headers", 0);
        return;
      }
      localObject1 = a.a((byte[])localObject2, 2);
      if (localObject1 == null)
      {
        a(null, false, 0, "[upload] fail, failed to zip request body", 0);
        return;
      }
      localObject2 = this.i.a((byte[])localObject1);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        a(null, false, 0, "[upload] fail, failed to encrypt request body", 0);
        return;
        Object localObject4;
        for (;;)
        {
          if (i1 >= this.a) {
            break label1661;
          }
          i2 = i1 + 1;
          if (i1 != 0)
          {
            v.d("failed to upload last time, wait and try(%d) again", new Object[] { Integer.valueOf(i2) });
            i1 = this.b;
            l1 = i1;
          }
          try
          {
            Thread.sleep(l1);
            v.c("send %d", new Object[] { Integer.valueOf(localObject1.length) });
            localObject2 = this.m;
            if ((localObject2 == null) || (((String)localObject2).trim().length() <= 0)) {
              break label1683;
            }
            i1 = 0;
            if (i1 != 0)
            {
              if (!this.q) {
                break label790;
              }
              if (this.d == 830) {
                this.m = localStrategyBean.r;
              }
            }
            else
            {
              v.c("do upload to %s with cmd %d (pid=%d | tid=%d)", new Object[] { this.m, Integer.valueOf(this.d), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
              localObject2 = this.h.a(this.m, (byte[])localObject1, this, localHashMap);
              if (localObject2 != null) {
                break label801;
              }
              v.e("try upload fail! %d %s", new Object[] { Integer.valueOf(this.d), "upload fail, no response!" });
              Log.d(v.b, "Failed to upload for no response.");
              i4 = 1;
              i1 = i2;
              i2 = i4;
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;)
            {
              localInterruptedException.printStackTrace();
              continue;
              this.m = localStrategyBean.q;
              continue;
              this.m = localStrategyBean.s;
            }
            localObject4 = this.h.a;
            i4 = i3;
            if (this.q)
            {
              if ((localObject4 == null) || (((Map)localObject4).size() == 0) || (!((Map)localObject4).containsKey("status")))
              {
                v.c("no headers from server, just try again (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
                v.e("try upload fail! %d %s", new Object[] { Integer.valueOf(this.d), "upload fail, no status header" });
                if (localObject4 != null)
                {
                  Iterator localIterator = ((Map)localObject4).entrySet().iterator();
                  while (localIterator.hasNext())
                  {
                    localObject4 = (Map.Entry)localIterator.next();
                    Log.d(v.b, String.format("[key]: %s, [value]: %s", new Object[] { ((Map.Entry)localObject4).getKey(), ((Map.Entry)localObject4).getValue() }));
                  }
                }
                Log.d(v.b, "Failed to upload for no status header.");
                i4 = 1;
                i1 = i2;
                i2 = i4;
              }
              else
              {
                try
                {
                  i1 = Integer.parseInt((String)((Map)localObject4).get("status"));
                  i3 = i1;
                  v.c("status from server is %d (pid=%d | tid=%d)", new Object[] { Integer.valueOf(i1), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
                  i4 = i1;
                  if (i1 == 0) {
                    break label1321;
                  }
                  if (i1 != 2) {
                    break label1265;
                  }
                  if (this.o + this.p > 0L)
                  {
                    l1 = this.i.a(this.r);
                    long l2 = this.o;
                    long l3 = this.p;
                    this.i.a(l1 + l2 + l3, this.r);
                  }
                  this.i.a(i1, null);
                  v.a("Session ID is invalid, will try again immediately (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
                  this.i.a(this.j, this.d, this.e, null, this.l);
                  return;
                }
                catch (Throwable localThrowable2)
                {
                  localObject3 = "upload fail, format of status header is invalid: " + Integer.toString(i3);
                  v.e("try upload fail! %d %s", new Object[] { Integer.valueOf(this.d), localObject3 });
                  i4 = 1;
                  i1 = i2;
                  i2 = i4;
                }
                continue;
                label1265:
                a(null, false, 1, "upload fail, status: " + Integer.toString(i1), i1);
                Log.d(v.b, "Failed to upload for status: " + i1);
              }
            }
            else
            {
              label1321:
              v.c("recv %d", new Object[] { Integer.valueOf(localObject3.length) });
              if (!this.q) {
                break label1689;
              }
            }
          }
        }
        if (localObject3.length == 0)
        {
          localObject1 = ((Map)localObject4).entrySet().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (Map.Entry)((Iterator)localObject1).next();
            v.c("[HTTP headers from server] key = %s, value = %s", new Object[] { ((Map.Entry)localObject3).getKey(), ((Map.Entry)localObject3).getValue() });
          }
          a(null, false, 1, "upload fail, response data from server is empty", 0);
          Log.d(v.b, "Failed to upload for length of data received is 0.");
          return;
        }
        localObject1 = this.i.b((byte[])localObject3);
        if (localObject1 == null)
        {
          a(null, false, 1, "upload fail, failed to decrypt response from server", 0);
          Log.d(v.b, "Failed to decrypt data.");
          return;
        }
        localObject3 = a.b((byte[])localObject1, 2);
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          a(null, false, 1, "upload fail, failed to unzip(gzip) response from server", 0);
          Log.d(v.b, "Failed to unzip data received.");
          return;
        }
      }
    }
    for (;;)
    {
      localObject1 = a.a((byte[])localObject1, this.q);
      if (localObject1 == null)
      {
        a(null, false, 1, "upload fail, resp null!", 0);
        Log.d(v.b, "Failed to decode data received.");
        return;
      }
      if (this.q) {
        this.i.a(i4, (ak)localObject1);
      }
      i2 = ((ak)localObject1).b;
      if (((ak)localObject1).c == null) {}
      for (i1 = 0;; i1 = ((ak)localObject1).c.length)
      {
        v.c("response %d %d", new Object[] { Integer.valueOf(i2), Integer.valueOf(i1) });
        if (a((ak)localObject1, this.f, this.g)) {
          break;
        }
        a((ak)localObject1, false, 2, ((ak)localObject1).f, 0);
        return;
      }
      v.c("Successfully uploaded.", new Object[0]);
      a((ak)localObject1, true, 2, null, 0);
      return;
      label1661:
      a(null, false, i2, "try OT Fail!", 0);
      label1673:
      return;
      i3 = -1;
      i1 = 0;
      break;
      label1683:
      i1 = 1;
      break label624;
      label1689:
      localObject1 = localObject3;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\bugly\proguard\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */