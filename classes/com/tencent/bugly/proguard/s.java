package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import android.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

public final class s
{
  private static s b = null;
  public r a;
  private final n c;
  private final Context d;
  private Map<Integer, Long> e = new HashMap();
  private LinkedBlockingQueue<Runnable> f = new LinkedBlockingQueue();
  private final Object g = new Object();
  private String h = null;
  private byte[] i = null;
  private long j = 0L;
  private byte[] k = null;
  private long l = 0L;
  private String m = null;
  private long n = 0L;
  private final Object o = new Object();
  private boolean p = false;
  private final Object q = new Object();
  private boolean r = true;
  
  private s(Context paramContext)
  {
    this.d = paramContext;
    this.c = n.a();
    try
    {
      Class.forName("android.util.Base64");
      if (this.r)
      {
        paramContext = new StringBuilder();
        paramContext.append("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDP9x32s5pPtZBXzJBz2GWM/sbTvVO2+RvW0PH01IdaBxc/").append("fB6fbHZocC9T3nl1+J5eAFjIRVuV8vHDky7Qo82Mnh0PVvcZIEQvMMVKU8dsMQopxgsOs2gkSHJwgWdinKNS8CmWobo6pFwPUW11lMv714jAUZRq2GBOqiO2vQI6iwIDAQAB");
        this.h = paramContext.toString();
      }
      return;
    }
    catch (ClassNotFoundException paramContext)
    {
      for (;;)
      {
        v.a("[UploadManager] can not find Base64 class, will not use stronger security way to upload", new Object[0]);
        this.r = false;
      }
    }
  }
  
  public static s a()
  {
    try
    {
      s locals = b;
      return locals;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static s a(Context paramContext)
  {
    try
    {
      if (b == null) {
        b = new s(paramContext);
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
  
  private void a(Runnable paramRunnable, long paramLong)
  {
    if (paramRunnable == null)
    {
      v.d("[UploadManager] upload task should not be null", new Object[0]);
      return;
    }
    v.c("[UploadManager] execute synchronized upload task (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
    Thread localThread = new Thread(paramRunnable);
    localThread.setName("BuglySyncUploadThread");
    localThread.start();
    try
    {
      localThread.join(paramLong);
      return;
    }
    catch (Throwable localThrowable)
    {
      v.e("[UploadManager] failed to execute upload synchronized task with message: %s. Add it to queue", new Object[] { localThrowable.getMessage() });
      a(paramRunnable);
    }
  }
  
  private void a(Runnable paramRunnable, boolean paramBoolean, long paramLong)
  {
    if (paramRunnable == null) {
      v.d("[UploadManager] upload task should not be null", new Object[0]);
    }
    u localu = u.a();
    if (localu == null) {
      v.d("[UploadManager] async task handler has not been initialized", new Object[0]);
    }
    v.c("[UploadManager] add upload task (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
    if (this.m != null)
    {
      if (d())
      {
        v.c("[UploadManager] sucessfully got session ID, try to execute upload task now (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
        if (paramBoolean) {
          a(paramRunnable, paramLong);
        }
        for (;;)
        {
          b(0);
          return;
          if (localu == null) {
            a(paramRunnable);
          } else {
            localu.c(paramRunnable);
          }
        }
      }
      v.a("[UploadManager] session ID is expired, drop it (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
      b(false);
    }
    for (;;)
    {
      synchronized (this.q)
      {
        if (this.p) {
          break label287;
        }
        this.p = true;
        v.c("[UploadManager] try to request session ID now (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
        if (paramBoolean)
        {
          a(new a(this.d, paramRunnable, paramLong), 0L);
          return;
        }
      }
      a(paramRunnable);
      localu.c(new a(this.d));
      continue;
      label287:
      a(paramRunnable);
    }
  }
  
  private boolean a(Runnable paramRunnable)
  {
    if (paramRunnable == null)
    {
      v.d("[UploadManager] upload task should not be null", new Object[0]);
      return false;
    }
    try
    {
      v.c("[UploadManager] add upload task to queue (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
      synchronized (this.g)
      {
        this.f.put(paramRunnable);
        return true;
      }
      return false;
    }
    catch (Throwable paramRunnable)
    {
      v.e("[UploadManager] failed to add upload task to queue: %s", new Object[] { paramRunnable.getMessage() });
    }
  }
  
  private boolean b(int paramInt)
  {
    if (paramInt < 0)
    {
      v.a("[UploadManager] number of task to execute should >= 0", new Object[0]);
      return false;
    }
    for (;;)
    {
      synchronized (this.g)
      {
        if (this.f.isEmpty()) {
          return true;
        }
        v.c("[UploadManager] execute upload tasks of queue which has %d tasks (pid=%d | tid=%d)", new Object[] { Integer.valueOf(this.f.size()), Integer.valueOf(Process.myPid()), Long.valueOf(Thread.currentThread().getId()) });
        int i1;
        if (paramInt != 0)
        {
          i1 = paramInt;
          if (paramInt <= this.f.size()) {}
        }
        else
        {
          i1 = this.f.size();
        }
        u localu = u.a();
        if (localu == null)
        {
          v.d("[UploadManager] async task handler has not been initialized", new Object[0]);
          return false;
        }
        paramInt = 0;
        if (paramInt < i1) {
          try
          {
            Runnable localRunnable = (Runnable)this.f.poll();
            if (localRunnable != null) {
              localu.c(localRunnable);
            } else {
              v.d("[UploadManager] upload task poll from queue is null", new Object[0]);
            }
          }
          catch (Throwable localThrowable)
          {
            v.e("[UploadManager] failed to execute upload task with message: %s", new Object[] { localThrowable.getMessage() });
            return false;
          }
        }
        return true;
      }
      paramInt += 1;
    }
  }
  
  private static boolean e()
  {
    v.c("[UploadManager] drop security info of database (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
    try
    {
      n localn = n.a();
      if (localn == null)
      {
        v.d("[UploadManager] failed to get Database", new Object[0]);
        return false;
      }
      boolean bool = localn.a(555, "security_info", null, true);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      v.a(localThrowable);
    }
    return false;
  }
  
  private boolean f()
  {
    v.c("[UploadManager] record security info to database (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
    for (;;)
    {
      StringBuilder localStringBuilder;
      try
      {
        n localn = n.a();
        if (localn == null)
        {
          v.d("[UploadManager] failed to get Database", new Object[0]);
          return false;
        }
        localStringBuilder = new StringBuilder();
        if (this.k != null)
        {
          localStringBuilder.append(Base64.encodeToString(this.k, 0));
          localStringBuilder.append("#");
          if (this.n != 0L)
          {
            localStringBuilder.append(Long.toString(this.l));
            localStringBuilder.append("#");
            if (this.m == null) {
              break label218;
            }
            localStringBuilder.append(this.m);
            localStringBuilder.append("#");
            if (this.n == 0L) {
              break label229;
            }
            localStringBuilder.append(Long.toString(this.n));
            localn.a(555, "security_info", localStringBuilder.toString().getBytes(), null, true);
            return true;
          }
        }
        else
        {
          v.c("[UploadManager] AES key is null, will not record", new Object[0]);
          return false;
        }
        localStringBuilder.append("null");
        continue;
        localStringBuilder.append("null");
      }
      catch (Throwable localThrowable)
      {
        v.a(localThrowable);
        e();
        return false;
      }
      label218:
      continue;
      label229:
      localStringBuilder.append("null");
    }
  }
  
  private boolean g()
  {
    v.c("[UploadManager] load security info from dataBase (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
    label365:
    for (;;)
    {
      try
      {
        Object localObject = n.a();
        if (localObject == null)
        {
          v.d("[UploadManager] failed to get Database", new Object[0]);
          return false;
        }
        localObject = ((n)localObject).a(555, null, true);
        if ((localObject == null) || (!((Map)localObject).containsKey("security_info"))) {
          break;
        }
        String str = new String((byte[])((Map)localObject).get("security_info"));
        localObject = str.split("#");
        int i2;
        if (localObject.length == 4)
        {
          if (localObject[0].isEmpty()) {
            break label365;
          }
          boolean bool = localObject[0].equals("null");
          if (bool) {
            break label365;
          }
          try
          {
            this.k = Base64.decode(localObject[0], 0);
            i1 = 0;
          }
          catch (Throwable localThrowable3)
          {
            v.a(localThrowable3);
            i1 = 1;
            continue;
          }
          i2 = i1;
          if (i1 == 0)
          {
            i2 = i1;
            if (!localObject[1].isEmpty())
            {
              bool = localObject[1].equals("null");
              i2 = i1;
              if (bool) {}
            }
          }
          try
          {
            this.l = Long.parseLong(localObject[1]);
            i2 = i1;
          }
          catch (Throwable localThrowable4)
          {
            v.a(localThrowable4);
            i2 = 1;
            continue;
          }
          if ((i2 == 0) && (!localObject[2].isEmpty()) && (!localObject[2].equals("null"))) {
            this.m = localObject[2];
          }
          i1 = i2;
          if (i2 == 0)
          {
            i1 = i2;
            if (!localObject[3].isEmpty())
            {
              bool = localObject[3].equals("null");
              i1 = i2;
              if (bool) {}
            }
          }
          try
          {
            this.n = Long.parseLong(localObject[3]);
            i1 = i2;
          }
          catch (Throwable localThrowable1)
          {
            v.a(localThrowable1);
            i1 = 1;
            continue;
          }
          if (i1 == 0) {
            break;
          }
          e();
          break;
        }
        v.a("securityInfo = %s, strings.length = %d", new Object[] { localThrowable4, Integer.valueOf(localThrowable1.length) });
        int i1 = 1;
        continue;
        i1 = 0;
      }
      catch (Throwable localThrowable2)
      {
        v.a(localThrowable2);
        return false;
      }
    }
    return true;
  }
  
  /* Error */
  public final long a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: iflt +40 -> 43
    //   6: aload_0
    //   7: getfield 53	com/tencent/bugly/proguard/s:e	Ljava/util/Map;
    //   10: iload_1
    //   11: invokestatic 150	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   14: invokeinterface 320 2 0
    //   19: checkcast 247	java/lang/Long
    //   22: astore_2
    //   23: aload_2
    //   24: ifnonnull +11 -> 35
    //   27: ldc2_w 344
    //   30: lstore_3
    //   31: aload_0
    //   32: monitorexit
    //   33: lload_3
    //   34: lreturn
    //   35: aload_2
    //   36: invokevirtual 348	java/lang/Long:longValue	()J
    //   39: lstore_3
    //   40: goto -9 -> 31
    //   43: ldc_w 350
    //   46: iconst_1
    //   47: anewarray 4	java/lang/Object
    //   50: dup
    //   51: iconst_0
    //   52: iload_1
    //   53: invokestatic 150	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   56: aastore
    //   57: invokestatic 180	com/tencent/bugly/proguard/v:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   60: pop
    //   61: ldc2_w 344
    //   64: lstore_3
    //   65: goto -34 -> 31
    //   68: astore_2
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_2
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	s
    //   0	73	1	paramInt	int
    //   22	14	2	localLong	Long
    //   68	4	2	localObject	Object
    //   30	35	3	l1	long
    // Exception table:
    //   from	to	target	type
    //   6	23	68	finally
    //   35	40	68	finally
    //   43	61	68	finally
  }
  
  public final long a(boolean paramBoolean)
  {
    long l3 = 0L;
    long l4 = a.e();
    int i1;
    List localList;
    if (paramBoolean)
    {
      i1 = 5;
      localList = this.c.a(i1);
      if ((localList != null) && (localList.size() > 0)) {
        l2 = l3;
      }
    }
    else
    {
      try
      {
        localObject = (p)localList.get(0);
        l1 = l3;
        l2 = l3;
        if (((p)localObject).e >= l4)
        {
          l2 = l3;
          l1 = a.d(((p)localObject).g);
          l2 = l1;
          localList.remove(localObject);
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Object localObject;
          v.e("error local type %d", new Object[] { Integer.valueOf(i1) });
          long l1 = l2;
        }
      }
      l2 = l1;
      if (localList.size() > 0)
      {
        localObject = this.c;
        n.a(localList);
      }
    }
    for (long l2 = l1;; l2 = 0L)
    {
      v.c("consume getted %d", new Object[] { Long.valueOf(l2) });
      return l2;
      i1 = 3;
      break;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, byte[] paramArrayOfByte, String paramString, r paramr)
  {
    try
    {
      if (this.r)
      {
        a(new t(this.d, paramInt1, paramInt2, paramArrayOfByte, null, paramr, true), false, 0L);
        return;
      }
      paramArrayOfByte = new t(this.d, paramInt1, paramInt2, paramArrayOfByte, null, paramr, false);
      u.a().b(paramArrayOfByte);
      return;
    }
    catch (Throwable paramArrayOfByte)
    {
      if (!v.a(paramArrayOfByte)) {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  public final void a(int paramInt, long paramLong)
  {
    if (paramInt >= 0) {}
    for (;;)
    {
      try
      {
        this.e.put(Integer.valueOf(paramInt), Long.valueOf(paramLong));
        v.c("up %d %d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) });
        return;
      }
      finally {}
      v.e("unknown up %d", new Object[] { Integer.valueOf(paramInt) });
    }
  }
  
  public final void a(int paramInt, aj paramaj, String paramString, r paramr, boolean paramBoolean)
  {
    a(paramInt, paramaj, null, paramr, false, 0L, paramBoolean);
  }
  
  public final void a(int paramInt, aj paramaj, String paramString, r paramr, boolean paramBoolean1, long paramLong, boolean paramBoolean2)
  {
    try
    {
      if (this.r)
      {
        a(new t(this.d, paramInt, paramaj, paramString, paramr, true, paramBoolean2), paramBoolean1, paramLong);
        return;
      }
      paramaj = new t(this.d, paramInt, paramaj, paramString, paramr, false, paramBoolean2);
      if (paramBoolean1)
      {
        a(paramaj, paramLong);
        return;
      }
    }
    catch (Throwable paramaj)
    {
      if (!v.a(paramaj))
      {
        paramaj.printStackTrace();
        return;
        u.a().b(paramaj);
      }
    }
  }
  
  public final void a(int paramInt, ak arg2)
  {
    if (!this.r) {
      return;
    }
    if (paramInt == 2)
    {
      v.c("[UploadManager] Session ID is invalid, will clear security context (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
      b(true);
    }
    for (;;)
    {
      synchronized (this.q)
      {
        if (this.p)
        {
          this.p = false;
          a.b(this.d, "security_info");
        }
        return;
      }
      if (!this.p) {
        break;
      }
      if (??? != null)
      {
        v.c("[UploadManager] record security context (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
        try
        {
          localMap = ???.h;
          if ((localMap == null) || (!localMap.containsKey("S1")) || (!localMap.containsKey("S2"))) {
            break label414;
          }
          this.j = (???.e - System.currentTimeMillis());
          v.c("[UploadManager] time lag of server is: %d", new Object[] { Long.valueOf(this.j) });
          this.m = ((String)localMap.get("S1"));
          v.c("[UploadManager] session ID from server is: %s", new Object[] { this.m });
          paramInt = this.m.length();
          if (paramInt <= 0) {
            break label403;
          }
        }
        catch (Throwable ???)
        {
          for (;;)
          {
            Map localMap;
            label323:
            boolean bool;
            v.a(???);
            paramInt = 1;
            continue;
            v.c("[UploadManager] failed to record database", new Object[0]);
            paramInt = 1;
            continue;
            v.c("[UploadManager] session ID from server is invalid, try next time", new Object[0]);
            paramInt = 1;
          }
        }
        try
        {
          this.n = Long.parseLong((String)localMap.get("S2"));
          v.c("[UploadManager] session expired time from server is: %d(%s)", new Object[] { Long.valueOf(this.n), new Date(this.n).toString() });
          if (this.n < 1000L)
          {
            v.d("[UploadManager] session expired time from server is less than 1 second, will set to default value", new Object[0]);
            this.n = 259200000L;
          }
          b(0);
          bool = f();
          if (bool)
          {
            paramInt = 0;
            if (paramInt == 0) {
              continue;
            }
            b(false);
          }
        }
        catch (NumberFormatException ???)
        {
          v.d("[UploadManager] session expired time is invalid, will set to default value", new Object[0]);
          this.n = 259200000L;
          break label323;
        }
      }
      label403:
      label414:
      v.c("[UploadManager] fail to init security context and clear local info (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
      b(false);
    }
  }
  
  /* Error */
  protected final void a(long paramLong, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_3
    //   3: ifeq +97 -> 100
    //   6: iconst_5
    //   7: istore 6
    //   9: new 366	com/tencent/bugly/proguard/p
    //   12: dup
    //   13: invokespecial 465	com/tencent/bugly/proguard/p:<init>	()V
    //   16: astore 4
    //   18: aload 4
    //   20: iload 6
    //   22: putfield 468	com/tencent/bugly/proguard/p:b	I
    //   25: aload 4
    //   27: invokestatic 355	com/tencent/bugly/proguard/a:e	()J
    //   30: putfield 368	com/tencent/bugly/proguard/p:e	J
    //   33: aload 4
    //   35: ldc_w 470
    //   38: putfield 472	com/tencent/bugly/proguard/p:c	Ljava/lang/String;
    //   41: aload 4
    //   43: ldc_w 470
    //   46: putfield 474	com/tencent/bugly/proguard/p:d	Ljava/lang/String;
    //   49: aload 4
    //   51: lload_1
    //   52: invokestatic 477	com/tencent/bugly/proguard/a:a	(J)[B
    //   55: putfield 370	com/tencent/bugly/proguard/p:g	[B
    //   58: aload_0
    //   59: getfield 91	com/tencent/bugly/proguard/s:c	Lcom/tencent/bugly/proguard/n;
    //   62: astore 5
    //   64: iload 6
    //   66: invokestatic 480	com/tencent/bugly/proguard/n:b	(I)V
    //   69: aload_0
    //   70: getfield 91	com/tencent/bugly/proguard/s:c	Lcom/tencent/bugly/proguard/n;
    //   73: aload 4
    //   75: invokevirtual 483	com/tencent/bugly/proguard/n:a	(Lcom/tencent/bugly/proguard/p;)Z
    //   78: pop
    //   79: ldc_w 485
    //   82: iconst_1
    //   83: anewarray 4	java/lang/Object
    //   86: dup
    //   87: iconst_0
    //   88: lload_1
    //   89: invokestatic 250	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   92: aastore
    //   93: invokestatic 155	com/tencent/bugly/proguard/v:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   96: pop
    //   97: aload_0
    //   98: monitorexit
    //   99: return
    //   100: iconst_3
    //   101: istore 6
    //   103: goto -94 -> 9
    //   106: astore 4
    //   108: aload_0
    //   109: monitorexit
    //   110: aload 4
    //   112: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	s
    //   0	113	1	paramLong	long
    //   0	113	3	paramBoolean	boolean
    //   16	58	4	localp	p
    //   106	5	4	localObject	Object
    //   62	1	5	localn	n
    //   7	95	6	i1	int
    // Exception table:
    //   from	to	target	type
    //   9	97	106	finally
  }
  
  public final boolean a(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      return false;
    }
    v.c("[UploadManager] integrate security to HTTP headers (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
    if (this.m != null)
    {
      paramMap.put("secureSessionId", this.m);
      return true;
    }
    if ((this.k == null) || (this.k.length << 3 != 128))
    {
      v.d("[UploadManager] AES key is invalid", new Object[0]);
      return false;
    }
    if (this.i == null)
    {
      this.i = Base64.decode(this.h, 0);
      if (this.i == null)
      {
        v.d("[UploadManager] failed to decode RSA public key", new Object[0]);
        return false;
      }
    }
    Object localObject = a.b(1, this.k, this.i);
    if (localObject == null)
    {
      v.d("[UploadManager] failed to encrypt AES key", new Object[0]);
      return false;
    }
    localObject = Base64.encodeToString((byte[])localObject, 0);
    if (localObject == null)
    {
      v.d("[UploadManager] failed to encode AES key", new Object[0]);
      return false;
    }
    paramMap.put("raKey", localObject);
    return true;
  }
  
  public final byte[] a(byte[] paramArrayOfByte)
  {
    if ((this.k == null) || (this.k.length << 3 != 128))
    {
      v.d("[UploadManager] AES key is invalid (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
      return null;
    }
    return a.a(1, paramArrayOfByte, this.k);
  }
  
  public final void b()
  {
    List localList = this.c.a(3);
    if ((localList == null) || (localList.size() == 0)) {
      return;
    }
    n localn = this.c;
    n.a(localList);
    v.c("net consume clear", new Object[0]);
  }
  
  protected final void b(boolean paramBoolean)
  {
    synchronized (this.o)
    {
      v.c("[UploadManager] clear security context (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
      this.k = null;
      this.m = null;
      this.n = 0L;
      if (paramBoolean) {
        e();
      }
      return;
    }
  }
  
  public final byte[] b(byte[] paramArrayOfByte)
  {
    if ((this.k == null) || (this.k.length << 3 != 128))
    {
      v.d("[UploadManager] AES key is invalid (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
      return null;
    }
    return a.a(2, paramArrayOfByte, this.k);
  }
  
  public final void c()
  {
    List localList = this.c.a(5);
    if ((localList == null) || (localList.size() == 0)) {
      return;
    }
    n localn = this.c;
    n.a(localList);
    v.c("block net consume clear", new Object[0]);
  }
  
  protected final boolean d()
  {
    if ((this.m == null) || (this.n == 0L)) {
      return false;
    }
    long l1 = System.currentTimeMillis() + this.j;
    if (this.n < l1)
    {
      v.c("[UploadManager] session ID expired time from server is: %d(%s), but now is: %d(%s)", new Object[] { Long.valueOf(this.n), new Date(this.n).toString(), Long.valueOf(l1), new Date(l1).toString() });
      return false;
    }
    return true;
  }
  
  final class a
    implements Runnable
  {
    private final Context a;
    private final Runnable b;
    private final long c;
    
    public a(Context paramContext)
    {
      this(paramContext, null, 0L);
    }
    
    public a(Context paramContext, Runnable paramRunnable, long paramLong)
    {
      this.a = paramContext;
      this.b = paramRunnable;
      this.c = paramLong;
    }
    
    public final void run()
    {
      if (!a.a(this.a, "security_info", 30000L))
      {
        ??? = u.a();
        if (??? == null) {
          v.e("[UploadManager] async task handler has not been initialized", new Object[0]);
        }
      }
      do
      {
        return;
        v.c("[UploadManager] sleep %d try to lock security file again", new Object[] { Integer.valueOf(5000) });
        try
        {
          Thread.sleep(5000L);
          ((u)???).c(new a(s.this, s.a(s.this)));
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            localInterruptedException.printStackTrace();
          }
        }
        if (!s.b(s.this))
        {
          v.d("[UploadManager] failed to load security info from database", new Object[0]);
          s.this.b(false);
        }
        if (s.c(s.this) != null)
        {
          if (s.this.d())
          {
            v.c("[UploadManager] sucessfully got session ID, try to execute upload tasks now (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
            if (this.b != null) {
              s.a(s.this, this.b, this.c);
            }
            s.a(s.this, 0);
            a.b(this.a, "security_info");
            synchronized (s.d(s.this))
            {
              s.a(s.this, false);
              return;
            }
          }
          v.a("[UploadManager] session ID is expired, drop it", new Object[0]);
          s.this.b(true);
        }
        ??? = a.a(128);
        if ((??? == null) || (???.length << 3 != 128)) {
          break;
        }
        s.a(s.this, (byte[])???);
        v.c("[UploadManager] execute one upload task for requesting session ID (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
        if (this.b != null)
        {
          s.a(s.this, this.b, this.c);
          return;
        }
      } while (s.a(s.this, 1));
      v.d("[UploadManager] failed to execute one upload task (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
      for (;;)
      {
        s.this.b(false);
        a.b(this.a, "security_info");
        synchronized (s.d(s.this))
        {
          s.a(s.this, false);
          return;
        }
        v.d("[UploadManager] failed to create AES key (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\bugly\proguard\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */