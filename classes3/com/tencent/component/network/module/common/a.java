package com.tencent.component.network.module.common;

import android.text.TextUtils;
import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.utils.thread.ThreadPool;
import com.tencent.component.network.utils.thread.ThreadPool.Job;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a
{
  private static a a = null;
  private static final byte[] b = new byte[0];
  private static final byte[] c = new byte[0];
  private static final byte[] d = new byte[0];
  private static final Pattern f = Pattern.compile("((\\d{1,3}\\.){3}\\d{1,3}|(\\w{1,4}:){5}\\w{1,4})", 2);
  private final HashMap<String, ThreadPool> e = new HashMap();
  private String g = "none";
  private List<String> h = Collections.synchronizedList(new ArrayList());
  private ConcurrentHashMap<String, a> i = new ConcurrentHashMap();
  private ConcurrentHashMap<String, ConcurrentHashMap<Long, Integer>> j = new ConcurrentHashMap();
  private List<b> k = Collections.synchronizedList(new ArrayList());
  private List<Pattern> l;
  private Executor m;
  
  private a()
  {
    e();
  }
  
  /* Error */
  public static a a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 39	com/tencent/component/network/module/common/a:a	Lcom/tencent/component/network/module/common/a;
    //   6: ifnonnull +27 -> 33
    //   9: getstatic 41	com/tencent/component/network/module/common/a:b	[B
    //   12: astore_0
    //   13: aload_0
    //   14: monitorenter
    //   15: getstatic 39	com/tencent/component/network/module/common/a:a	Lcom/tencent/component/network/module/common/a;
    //   18: ifnonnull +13 -> 31
    //   21: new 2	com/tencent/component/network/module/common/a
    //   24: dup
    //   25: invokespecial 92	com/tencent/component/network/module/common/a:<init>	()V
    //   28: putstatic 39	com/tencent/component/network/module/common/a:a	Lcom/tencent/component/network/module/common/a;
    //   31: aload_0
    //   32: monitorexit
    //   33: getstatic 39	com/tencent/component/network/module/common/a:a	Lcom/tencent/component/network/module/common/a;
    //   36: astore_0
    //   37: ldc 2
    //   39: monitorexit
    //   40: aload_0
    //   41: areturn
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    //   47: astore_0
    //   48: ldc 2
    //   50: monitorexit
    //   51: aload_0
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   47	5	0	localObject2	Object
    //   42	4	1	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   15	31	42	finally
    //   31	33	42	finally
    //   3	15	47	finally
    //   33	37	47	finally
    //   43	47	47	finally
  }
  
  private String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    a locala = (a)this.i.get(paramString);
    if (locala == null) {
      return null;
    }
    long l1 = System.currentTimeMillis() - locala.a;
    if ((l1 >= 0L) && (l1 <= 3600000L) && (!TextUtils.isEmpty(locala.b))) {}
    for (int n = 1; n != 0; n = 0) {
      return locala.b;
    }
    this.i.remove(paramString);
    return null;
  }
  
  private int d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    for (;;)
    {
      synchronized (c)
      {
        if (this.j.get(paramString) == null) {
          break label120;
        }
        paramString = (ConcurrentHashMap)this.j.get(paramString);
        localObject = Long.valueOf(Thread.currentThread().getId());
        if (paramString.get(localObject) == null) {
          break label104;
        }
        Integer localInteger = (Integer)paramString.get(localObject);
        if (localInteger != null)
        {
          n = localInteger.intValue();
          return n;
        }
      }
      paramString.put(localObject, Integer.valueOf(0));
      int n = 0;
      continue;
      label104:
      paramString.put(localObject, Integer.valueOf(0));
      n = 0;
      continue;
      label120:
      Object localObject = new ConcurrentHashMap();
      ((ConcurrentHashMap)localObject).put(Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(0));
      this.j.put(paramString, localObject);
      n = 0;
    }
  }
  
  private void e()
  {
    int n = 0;
    String[] arrayOfString = new String[7];
    arrayOfString[0] = "a[0-9].qpic.cn";
    arrayOfString[1] = "m.qpic.cn";
    arrayOfString[2] = "t[0-9].qpic.cn";
    arrayOfString[3] = "qlogo[0-9].store.qq.com";
    arrayOfString[4] = "mmsns.qpic.cn";
    arrayOfString[5] = "ugc.qpic.cn";
    arrayOfString[6] = "b\\d+.photo.store.qq.com";
    this.l = new ArrayList();
    for (;;)
    {
      if (n >= arrayOfString.length) {
        return;
      }
      Pattern localPattern = Pattern.compile(arrayOfString[n], 2);
      this.l.add(localPattern);
      n += 1;
    }
  }
  
  private static boolean e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((paramString.startsWith("192.168")) || (paramString.equals("127.0.0.1")) || (paramString.equals("0.0.0.0")) || (paramString.equals("255.255.255.255"))) {
      return false;
    }
    return f.matcher(paramString).find();
  }
  
  private void f(String paramString)
  {
    int n;
    Object localObject;
    if (!TextUtils.isEmpty(paramString))
    {
      if (!this.h.contains(paramString)) {
        break label175;
      }
      n = 0;
      if (n != 0)
      {
        this.h.add(paramString);
        if (!TextUtils.isEmpty(paramString)) {
          break label181;
        }
        localObject = "resolver_threadpool_name_common";
        label50:
        ThreadPool localThreadPool2 = (ThreadPool)this.e.get(localObject);
        localThreadPool1 = localThreadPool2;
        if (localThreadPool2 == null)
        {
          n = 2;
          if ("resolver_threadpool_name_internal".equals(localObject)) {
            n = 4;
          }
          if (this.m == null) {
            break label230;
          }
        }
      }
    }
    label175:
    label181:
    label230:
    for (ThreadPool localThreadPool1 = new ThreadPool(this.m);; localThreadPool1 = new ThreadPool((String)localObject, n, n, new LinkedBlockingQueue()))
    {
      this.e.put(localObject, localThreadPool1);
      if (com.tencent.component.network.downloader.common.a.b()) {
        com.tencent.component.network.downloader.common.a.b("DnsService", "add query:" + paramString);
      }
      if ("wifi".equals(NetworkManager.getApnValue())) {
        NetworkManager.getBSSID();
      }
      try
      {
        localThreadPool1.submit(new b(paramString));
        return;
      }
      catch (Throwable paramString)
      {
        com.tencent.component.network.downloader.common.a.b("DnsService", "exception when add query to DNSService.", paramString);
      }
      n = 1;
      break;
      localObject = this.l.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext())
        {
          localObject = "resolver_threadpool_name_common";
          break;
        }
      } while (!com.tencent.component.network.downloader.common.a.a((Pattern)((Iterator)localObject).next(), paramString));
      localObject = "resolver_threadpool_name_internal";
      break label50;
    }
  }
  
  public final String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      str = null;
    }
    do
    {
      return str;
      str = paramString;
    } while (f.matcher(paramString).find());
    long l2 = System.currentTimeMillis();
    String str = c(paramString);
    long l1;
    if (TextUtils.isEmpty(str))
    {
      l1 = 0L;
      str = c(paramString);
      if ((TextUtils.isEmpty(str)) && (l1 <= 20000L) && (d(paramString) <= 0)) {}
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramString)) {}
      synchronized (c)
      {
        if (this.j.get(paramString) != null)
        {
          ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.j.get(paramString);
          Long localLong = Long.valueOf(Thread.currentThread().getId());
          if (localConcurrentHashMap.get(localLong) != null) {
            localConcurrentHashMap.remove(localLong);
          }
        }
        if (com.tencent.component.network.downloader.common.a.b()) {
          com.tencent.component.network.downloader.common.a.b("DnsService", "DNSService domain:" + paramString + " ip:" + str + " time:" + (System.currentTimeMillis() - l2) + " threadId:" + Thread.currentThread().getId());
        }
        return str;
        try
        {
          f(paramString);
          Thread.sleep(20L);
          l1 += 20L;
        }
        catch (InterruptedException localInterruptedException)
        {
          com.tencent.component.network.downloader.common.a.b("DnsService", "DNSService getDomainIP InterruptedException", localInterruptedException);
        }
      }
    }
  }
  
  public final void a(Executor paramExecutor)
  {
    if (this.m != null) {
      this.m = paramExecutor;
    }
  }
  
  public final void b()
  {
    if (NetworkManager.isMobile()) {}
    Object localObject2;
    for (String str = NetworkManager.getApnValue();; localObject2 = null) {
      for (;;)
      {
        if (com.tencent.component.network.downloader.common.a.b()) {
          com.tencent.component.network.downloader.common.a.b("DnsService", "DNSService reset. Key:" + this.g + " currKey:" + str);
        }
        if ((str == null) || (!str.equalsIgnoreCase(this.g))) {}
        synchronized (d)
        {
          Iterator localIterator = this.k.iterator();
          if (!localIterator.hasNext())
          {
            this.g = str;
            this.i.clear();
            f("m.qpic.cn");
            return;
            if (NetworkManager.isWifi()) {
              str = NetworkManager.getBSSID();
            }
          }
          else
          {
            ((b)localIterator.next()).a();
          }
        }
      }
    }
  }
  
  public final class a
  {
    public long a;
    
    public a(long paramLong)
    {
      this.a = paramLong;
    }
  }
  
  final class b
    implements ThreadPool.Job<Object>
  {
    private String a;
    private volatile boolean b = false;
    
    public b(String paramString)
    {
      this.a = paramString;
    }
    
    public final void a()
    {
      this.b = true;
    }
    
    /* Error */
    public final Object run(com.tencent.component.network.utils.thread.ThreadPool.JobContext arg1)
    {
      // Byte code:
      //   0: invokestatic 40	com/tencent/component/network/module/common/a:c	()[B
      //   3: astore_1
      //   4: aload_1
      //   5: monitorenter
      //   6: aload_0
      //   7: getfield 19	com/tencent/component/network/module/common/a$b:c	Lcom/tencent/component/network/module/common/a;
      //   10: invokestatic 43	com/tencent/component/network/module/common/a:a	(Lcom/tencent/component/network/module/common/a;)Ljava/util/List;
      //   13: aload_0
      //   14: invokeinterface 49 2 0
      //   19: pop
      //   20: aload_1
      //   21: monitorexit
      //   22: aconst_null
      //   23: astore 6
      //   25: aconst_null
      //   26: astore 7
      //   28: aconst_null
      //   29: astore 8
      //   31: aconst_null
      //   32: astore 9
      //   34: aconst_null
      //   35: astore 10
      //   37: aconst_null
      //   38: astore 11
      //   40: aconst_null
      //   41: astore_3
      //   42: aconst_null
      //   43: astore 5
      //   45: aconst_null
      //   46: astore_2
      //   47: invokestatic 55	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
      //   50: astore_1
      //   51: aload_1
      //   52: astore 4
      //   54: ldc 57
      //   56: aload_1
      //   57: invokevirtual 62	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   60: ifeq +8 -> 68
      //   63: invokestatic 65	com/tencent/component/network/NetworkManager:getBSSID	()Ljava/lang/String;
      //   66: astore 4
      //   68: invokestatic 71	java/lang/System:currentTimeMillis	()J
      //   71: lstore 15
      //   73: aload_2
      //   74: astore_1
      //   75: aload_0
      //   76: getfield 26	com/tencent/component/network/module/common/a$b:a	Ljava/lang/String;
      //   79: invokestatic 77	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   82: ifne +25 -> 107
      //   85: aload_0
      //   86: getfield 26	com/tencent/component/network/module/common/a$b:a	Ljava/lang/String;
      //   89: invokestatic 83	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
      //   92: astore 12
      //   94: aload_2
      //   95: astore_1
      //   96: aload 12
      //   98: ifnull +9 -> 107
      //   101: aload 12
      //   103: invokevirtual 86	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
      //   106: astore_1
      //   107: invokestatic 91	com/tencent/component/network/downloader/common/a:b	()Z
      //   110: ifeq +24 -> 134
      //   113: ldc 93
      //   115: new 95	java/lang/StringBuilder
      //   118: dup
      //   119: ldc 97
      //   121: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   124: aload_1
      //   125: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   128: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   131: invokestatic 110	com/tencent/component/network/downloader/common/a:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   134: aload_0
      //   135: getfield 19	com/tencent/component/network/module/common/a$b:c	Lcom/tencent/component/network/module/common/a;
      //   138: astore_2
      //   139: aload_1
      //   140: astore_2
      //   141: aload_1
      //   142: invokestatic 113	com/tencent/component/network/module/common/a:b	(Ljava/lang/String;)Z
      //   145: ifne +136 -> 281
      //   148: aload_0
      //   149: getfield 19	com/tencent/component/network/module/common/a$b:c	Lcom/tencent/component/network/module/common/a;
      //   152: astore_2
      //   153: aload_1
      //   154: astore_2
      //   155: invokestatic 116	com/tencent/component/network/module/common/a:d	()Z
      //   158: ifeq +123 -> 281
      //   161: invokestatic 71	java/lang/System:currentTimeMillis	()J
      //   164: lload 15
      //   166: lsub
      //   167: lstore 13
      //   169: aload_1
      //   170: astore_3
      //   171: aload_0
      //   172: getfield 26	com/tencent/component/network/module/common/a$b:a	Ljava/lang/String;
      //   175: astore_2
      //   176: ldc2_w 117
      //   179: lload 13
      //   181: lsub
      //   182: ldc2_w 119
      //   185: lcmp
      //   186: iflt +1705 -> 1891
      //   189: ldc2_w 117
      //   192: lload 13
      //   194: lsub
      //   195: lstore 13
      //   197: aload_1
      //   198: astore_3
      //   199: aload_2
      //   200: lload 13
      //   202: invokestatic 123	com/tencent/component/network/downloader/common/a:a	(Ljava/lang/String;J)[Ljava/net/InetAddress;
      //   205: astore 5
      //   207: aload_1
      //   208: astore_2
      //   209: aload 5
      //   211: ifnull +70 -> 281
      //   214: aload_1
      //   215: astore_2
      //   216: aload_1
      //   217: astore_3
      //   218: aload 5
      //   220: arraylength
      //   221: ifle +60 -> 281
      //   224: aload_1
      //   225: astore_3
      //   226: aload 5
      //   228: iconst_0
      //   229: aaload
      //   230: invokevirtual 86	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
      //   233: astore_1
      //   234: aload_1
      //   235: astore_2
      //   236: aload_1
      //   237: astore_3
      //   238: invokestatic 91	com/tencent/component/network/downloader/common/a:b	()Z
      //   241: ifeq +40 -> 281
      //   244: aload_1
      //   245: astore_3
      //   246: ldc 93
      //   248: new 95	java/lang/StringBuilder
      //   251: dup
      //   252: ldc 125
      //   254: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   257: aload_0
      //   258: getfield 26	com/tencent/component/network/module/common/a$b:a	Ljava/lang/String;
      //   261: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   264: ldc 127
      //   266: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   269: aload_1
      //   270: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   273: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   276: invokestatic 110	com/tencent/component/network/downloader/common/a:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   279: aload_1
      //   280: astore_2
      //   281: invokestatic 55	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
      //   284: astore_3
      //   285: aload_3
      //   286: astore_1
      //   287: ldc 57
      //   289: aload_3
      //   290: invokevirtual 62	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   293: ifeq +7 -> 300
      //   296: invokestatic 65	com/tencent/component/network/NetworkManager:getBSSID	()Ljava/lang/String;
      //   299: astore_1
      //   300: invokestatic 91	com/tencent/component/network/downloader/common/a:b	()Z
      //   303: ifeq +95 -> 398
      //   306: ldc 93
      //   308: new 95	java/lang/StringBuilder
      //   311: dup
      //   312: ldc -127
      //   314: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   317: aload_0
      //   318: getfield 26	com/tencent/component/network/module/common/a$b:a	Ljava/lang/String;
      //   321: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   324: ldc -125
      //   326: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   329: aload_2
      //   330: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   333: ldc -123
      //   335: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   338: invokestatic 71	java/lang/System:currentTimeMillis	()J
      //   341: lload 15
      //   343: lsub
      //   344: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   347: ldc -118
      //   349: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   352: aload 4
      //   354: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   357: ldc -116
      //   359: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   362: aload_1
      //   363: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   366: ldc -114
      //   368: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   371: invokestatic 148	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   374: invokevirtual 151	java/lang/Thread:getId	()J
      //   377: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   380: ldc -103
      //   382: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   385: aload_0
      //   386: getfield 24	com/tencent/component/network/module/common/a$b:b	Z
      //   389: invokevirtual 156	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   392: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   395: invokestatic 110	com/tencent/component/network/downloader/common/a:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   398: aload_0
      //   399: getfield 24	com/tencent/component/network/module/common/a$b:b	Z
      //   402: ifne +1511 -> 1913
      //   405: aload_0
      //   406: getfield 19	com/tencent/component/network/module/common/a$b:c	Lcom/tencent/component/network/module/common/a;
      //   409: aload_0
      //   410: getfield 26	com/tencent/component/network/module/common/a$b:a	Ljava/lang/String;
      //   413: aload_2
      //   414: invokestatic 159	com/tencent/component/network/module/common/a:a	(Lcom/tencent/component/network/module/common/a;Ljava/lang/String;Ljava/lang/String;)V
      //   417: invokestatic 40	com/tencent/component/network/module/common/a:c	()[B
      //   420: astore_1
      //   421: aload_1
      //   422: monitorenter
      //   423: aload_0
      //   424: getfield 19	com/tencent/component/network/module/common/a$b:c	Lcom/tencent/component/network/module/common/a;
      //   427: invokestatic 43	com/tencent/component/network/module/common/a:a	(Lcom/tencent/component/network/module/common/a;)Ljava/util/List;
      //   430: aload_0
      //   431: invokeinterface 162 2 0
      //   436: pop
      //   437: aload_1
      //   438: monitorexit
      //   439: aconst_null
      //   440: areturn
      //   441: astore_2
      //   442: aload_1
      //   443: monitorexit
      //   444: aload_2
      //   445: athrow
      //   446: astore_1
      //   447: ldc 93
      //   449: ldc -92
      //   451: aload_1
      //   452: invokestatic 167	com/tencent/component/network/downloader/common/a:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   455: invokestatic 91	com/tencent/component/network/downloader/common/a:b	()Z
      //   458: ifeq +24 -> 482
      //   461: ldc 93
      //   463: new 95	java/lang/StringBuilder
      //   466: dup
      //   467: ldc 97
      //   469: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   472: aconst_null
      //   473: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   476: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   479: invokestatic 110	com/tencent/component/network/downloader/common/a:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   482: aload_0
      //   483: getfield 19	com/tencent/component/network/module/common/a$b:c	Lcom/tencent/component/network/module/common/a;
      //   486: astore_1
      //   487: aload 6
      //   489: astore_1
      //   490: aconst_null
      //   491: invokestatic 113	com/tencent/component/network/module/common/a:b	(Ljava/lang/String;)Z
      //   494: ifne +139 -> 633
      //   497: aload_0
      //   498: getfield 19	com/tencent/component/network/module/common/a$b:c	Lcom/tencent/component/network/module/common/a;
      //   501: astore_1
      //   502: aload 6
      //   504: astore_1
      //   505: invokestatic 116	com/tencent/component/network/module/common/a:d	()Z
      //   508: ifeq +125 -> 633
      //   511: invokestatic 71	java/lang/System:currentTimeMillis	()J
      //   514: lload 15
      //   516: lsub
      //   517: lstore 13
      //   519: aload 7
      //   521: astore_2
      //   522: aload_0
      //   523: getfield 26	com/tencent/component/network/module/common/a$b:a	Ljava/lang/String;
      //   526: astore_1
      //   527: ldc2_w 117
      //   530: lload 13
      //   532: lsub
      //   533: ldc2_w 119
      //   536: lcmp
      //   537: iflt +235 -> 772
      //   540: ldc2_w 117
      //   543: lload 13
      //   545: lsub
      //   546: lstore 13
      //   548: aload 7
      //   550: astore_2
      //   551: aload_1
      //   552: lload 13
      //   554: invokestatic 123	com/tencent/component/network/downloader/common/a:a	(Ljava/lang/String;J)[Ljava/net/InetAddress;
      //   557: astore_3
      //   558: aload 6
      //   560: astore_1
      //   561: aload_3
      //   562: ifnull +71 -> 633
      //   565: aload 6
      //   567: astore_1
      //   568: aload 7
      //   570: astore_2
      //   571: aload_3
      //   572: arraylength
      //   573: ifle +60 -> 633
      //   576: aload 7
      //   578: astore_2
      //   579: aload_3
      //   580: iconst_0
      //   581: aaload
      //   582: invokevirtual 86	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
      //   585: astore_3
      //   586: aload_3
      //   587: astore_1
      //   588: aload_3
      //   589: astore_2
      //   590: invokestatic 91	com/tencent/component/network/downloader/common/a:b	()Z
      //   593: ifeq +40 -> 633
      //   596: aload_3
      //   597: astore_2
      //   598: ldc 93
      //   600: new 95	java/lang/StringBuilder
      //   603: dup
      //   604: ldc 125
      //   606: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   609: aload_0
      //   610: getfield 26	com/tencent/component/network/module/common/a$b:a	Ljava/lang/String;
      //   613: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   616: ldc 127
      //   618: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   621: aload_3
      //   622: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   625: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   628: invokestatic 110	com/tencent/component/network/downloader/common/a:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   631: aload_3
      //   632: astore_1
      //   633: invokestatic 55	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
      //   636: astore_3
      //   637: aload_3
      //   638: astore_2
      //   639: ldc 57
      //   641: aload_3
      //   642: invokevirtual 62	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   645: ifeq +7 -> 652
      //   648: invokestatic 65	com/tencent/component/network/NetworkManager:getBSSID	()Ljava/lang/String;
      //   651: astore_2
      //   652: invokestatic 91	com/tencent/component/network/downloader/common/a:b	()Z
      //   655: ifeq +95 -> 750
      //   658: ldc 93
      //   660: new 95	java/lang/StringBuilder
      //   663: dup
      //   664: ldc -127
      //   666: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   669: aload_0
      //   670: getfield 26	com/tencent/component/network/module/common/a$b:a	Ljava/lang/String;
      //   673: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   676: ldc -125
      //   678: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   681: aload_1
      //   682: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   685: ldc -123
      //   687: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   690: invokestatic 71	java/lang/System:currentTimeMillis	()J
      //   693: lload 15
      //   695: lsub
      //   696: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   699: ldc -118
      //   701: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   704: aload 4
      //   706: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   709: ldc -116
      //   711: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   714: aload_2
      //   715: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   718: ldc -114
      //   720: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   723: invokestatic 148	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   726: invokevirtual 151	java/lang/Thread:getId	()J
      //   729: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   732: ldc -103
      //   734: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   737: aload_0
      //   738: getfield 24	com/tencent/component/network/module/common/a$b:b	Z
      //   741: invokevirtual 156	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   744: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   747: invokestatic 110	com/tencent/component/network/downloader/common/a:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   750: aload_0
      //   751: getfield 24	com/tencent/component/network/module/common/a$b:b	Z
      //   754: ifne +40 -> 794
      //   757: aload_0
      //   758: getfield 19	com/tencent/component/network/module/common/a$b:c	Lcom/tencent/component/network/module/common/a;
      //   761: aload_0
      //   762: getfield 26	com/tencent/component/network/module/common/a$b:a	Ljava/lang/String;
      //   765: aload_1
      //   766: invokestatic 159	com/tencent/component/network/module/common/a:a	(Lcom/tencent/component/network/module/common/a;Ljava/lang/String;Ljava/lang/String;)V
      //   769: goto -352 -> 417
      //   772: ldc2_w 119
      //   775: lstore 13
      //   777: goto -229 -> 548
      //   780: astore_1
      //   781: ldc 93
      //   783: ldc -87
      //   785: aload_1
      //   786: invokestatic 167	com/tencent/component/network/downloader/common/a:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   789: aload_2
      //   790: astore_1
      //   791: goto -158 -> 633
      //   794: aload_0
      //   795: getfield 19	com/tencent/component/network/module/common/a$b:c	Lcom/tencent/component/network/module/common/a;
      //   798: aload_0
      //   799: getfield 26	com/tencent/component/network/module/common/a$b:a	Ljava/lang/String;
      //   802: aconst_null
      //   803: invokestatic 159	com/tencent/component/network/module/common/a:a	(Lcom/tencent/component/network/module/common/a;Ljava/lang/String;Ljava/lang/String;)V
      //   806: goto -389 -> 417
      //   809: astore_1
      //   810: ldc 93
      //   812: ldc -92
      //   814: aload_1
      //   815: invokestatic 167	com/tencent/component/network/downloader/common/a:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   818: invokestatic 91	com/tencent/component/network/downloader/common/a:b	()Z
      //   821: ifeq +24 -> 845
      //   824: ldc 93
      //   826: new 95	java/lang/StringBuilder
      //   829: dup
      //   830: ldc 97
      //   832: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   835: aconst_null
      //   836: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   839: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   842: invokestatic 110	com/tencent/component/network/downloader/common/a:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   845: aload_0
      //   846: getfield 19	com/tencent/component/network/module/common/a$b:c	Lcom/tencent/component/network/module/common/a;
      //   849: astore_1
      //   850: aload 8
      //   852: astore_1
      //   853: aconst_null
      //   854: invokestatic 113	com/tencent/component/network/module/common/a:b	(Ljava/lang/String;)Z
      //   857: ifne +139 -> 996
      //   860: aload_0
      //   861: getfield 19	com/tencent/component/network/module/common/a$b:c	Lcom/tencent/component/network/module/common/a;
      //   864: astore_1
      //   865: aload 8
      //   867: astore_1
      //   868: invokestatic 116	com/tencent/component/network/module/common/a:d	()Z
      //   871: ifeq +125 -> 996
      //   874: invokestatic 71	java/lang/System:currentTimeMillis	()J
      //   877: lload 15
      //   879: lsub
      //   880: lstore 13
      //   882: aload 9
      //   884: astore_2
      //   885: aload_0
      //   886: getfield 26	com/tencent/component/network/module/common/a$b:a	Ljava/lang/String;
      //   889: astore_1
      //   890: ldc2_w 117
      //   893: lload 13
      //   895: lsub
      //   896: ldc2_w 119
      //   899: lcmp
      //   900: iflt +235 -> 1135
      //   903: ldc2_w 117
      //   906: lload 13
      //   908: lsub
      //   909: lstore 13
      //   911: aload 9
      //   913: astore_2
      //   914: aload_1
      //   915: lload 13
      //   917: invokestatic 123	com/tencent/component/network/downloader/common/a:a	(Ljava/lang/String;J)[Ljava/net/InetAddress;
      //   920: astore_3
      //   921: aload 8
      //   923: astore_1
      //   924: aload_3
      //   925: ifnull +71 -> 996
      //   928: aload 8
      //   930: astore_1
      //   931: aload 9
      //   933: astore_2
      //   934: aload_3
      //   935: arraylength
      //   936: ifle +60 -> 996
      //   939: aload 9
      //   941: astore_2
      //   942: aload_3
      //   943: iconst_0
      //   944: aaload
      //   945: invokevirtual 86	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
      //   948: astore_3
      //   949: aload_3
      //   950: astore_1
      //   951: aload_3
      //   952: astore_2
      //   953: invokestatic 91	com/tencent/component/network/downloader/common/a:b	()Z
      //   956: ifeq +40 -> 996
      //   959: aload_3
      //   960: astore_2
      //   961: ldc 93
      //   963: new 95	java/lang/StringBuilder
      //   966: dup
      //   967: ldc 125
      //   969: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   972: aload_0
      //   973: getfield 26	com/tencent/component/network/module/common/a$b:a	Ljava/lang/String;
      //   976: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   979: ldc 127
      //   981: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   984: aload_3
      //   985: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   988: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   991: invokestatic 110	com/tencent/component/network/downloader/common/a:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   994: aload_3
      //   995: astore_1
      //   996: invokestatic 55	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
      //   999: astore_3
      //   1000: aload_3
      //   1001: astore_2
      //   1002: ldc 57
      //   1004: aload_3
      //   1005: invokevirtual 62	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   1008: ifeq +7 -> 1015
      //   1011: invokestatic 65	com/tencent/component/network/NetworkManager:getBSSID	()Ljava/lang/String;
      //   1014: astore_2
      //   1015: invokestatic 91	com/tencent/component/network/downloader/common/a:b	()Z
      //   1018: ifeq +95 -> 1113
      //   1021: ldc 93
      //   1023: new 95	java/lang/StringBuilder
      //   1026: dup
      //   1027: ldc -127
      //   1029: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1032: aload_0
      //   1033: getfield 26	com/tencent/component/network/module/common/a$b:a	Ljava/lang/String;
      //   1036: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1039: ldc -125
      //   1041: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1044: aload_1
      //   1045: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1048: ldc -123
      //   1050: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1053: invokestatic 71	java/lang/System:currentTimeMillis	()J
      //   1056: lload 15
      //   1058: lsub
      //   1059: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1062: ldc -118
      //   1064: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1067: aload 4
      //   1069: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1072: ldc -116
      //   1074: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1077: aload_2
      //   1078: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1081: ldc -114
      //   1083: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1086: invokestatic 148	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   1089: invokevirtual 151	java/lang/Thread:getId	()J
      //   1092: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1095: ldc -103
      //   1097: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1100: aload_0
      //   1101: getfield 24	com/tencent/component/network/module/common/a$b:b	Z
      //   1104: invokevirtual 156	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   1107: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1110: invokestatic 110	com/tencent/component/network/downloader/common/a:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   1113: aload_0
      //   1114: getfield 24	com/tencent/component/network/module/common/a$b:b	Z
      //   1117: ifne +40 -> 1157
      //   1120: aload_0
      //   1121: getfield 19	com/tencent/component/network/module/common/a$b:c	Lcom/tencent/component/network/module/common/a;
      //   1124: aload_0
      //   1125: getfield 26	com/tencent/component/network/module/common/a$b:a	Ljava/lang/String;
      //   1128: aload_1
      //   1129: invokestatic 159	com/tencent/component/network/module/common/a:a	(Lcom/tencent/component/network/module/common/a;Ljava/lang/String;Ljava/lang/String;)V
      //   1132: goto -715 -> 417
      //   1135: ldc2_w 119
      //   1138: lstore 13
      //   1140: goto -229 -> 911
      //   1143: astore_1
      //   1144: ldc 93
      //   1146: ldc -87
      //   1148: aload_1
      //   1149: invokestatic 167	com/tencent/component/network/downloader/common/a:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   1152: aload_2
      //   1153: astore_1
      //   1154: goto -158 -> 996
      //   1157: aload_0
      //   1158: getfield 19	com/tencent/component/network/module/common/a$b:c	Lcom/tencent/component/network/module/common/a;
      //   1161: aload_0
      //   1162: getfield 26	com/tencent/component/network/module/common/a$b:a	Ljava/lang/String;
      //   1165: aconst_null
      //   1166: invokestatic 159	com/tencent/component/network/module/common/a:a	(Lcom/tencent/component/network/module/common/a;Ljava/lang/String;Ljava/lang/String;)V
      //   1169: goto -752 -> 417
      //   1172: astore_1
      //   1173: ldc 93
      //   1175: ldc -85
      //   1177: aload_1
      //   1178: invokestatic 167	com/tencent/component/network/downloader/common/a:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   1181: invokestatic 91	com/tencent/component/network/downloader/common/a:b	()Z
      //   1184: ifeq +24 -> 1208
      //   1187: ldc 93
      //   1189: new 95	java/lang/StringBuilder
      //   1192: dup
      //   1193: ldc 97
      //   1195: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1198: aconst_null
      //   1199: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1202: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1205: invokestatic 110	com/tencent/component/network/downloader/common/a:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   1208: aload_0
      //   1209: getfield 19	com/tencent/component/network/module/common/a$b:c	Lcom/tencent/component/network/module/common/a;
      //   1212: astore_1
      //   1213: aload 10
      //   1215: astore_1
      //   1216: aconst_null
      //   1217: invokestatic 113	com/tencent/component/network/module/common/a:b	(Ljava/lang/String;)Z
      //   1220: ifne +139 -> 1359
      //   1223: aload_0
      //   1224: getfield 19	com/tencent/component/network/module/common/a$b:c	Lcom/tencent/component/network/module/common/a;
      //   1227: astore_1
      //   1228: aload 10
      //   1230: astore_1
      //   1231: invokestatic 116	com/tencent/component/network/module/common/a:d	()Z
      //   1234: ifeq +125 -> 1359
      //   1237: invokestatic 71	java/lang/System:currentTimeMillis	()J
      //   1240: lload 15
      //   1242: lsub
      //   1243: lstore 13
      //   1245: aload 11
      //   1247: astore_2
      //   1248: aload_0
      //   1249: getfield 26	com/tencent/component/network/module/common/a$b:a	Ljava/lang/String;
      //   1252: astore_1
      //   1253: ldc2_w 117
      //   1256: lload 13
      //   1258: lsub
      //   1259: ldc2_w 119
      //   1262: lcmp
      //   1263: iflt +235 -> 1498
      //   1266: ldc2_w 117
      //   1269: lload 13
      //   1271: lsub
      //   1272: lstore 13
      //   1274: aload 11
      //   1276: astore_2
      //   1277: aload_1
      //   1278: lload 13
      //   1280: invokestatic 123	com/tencent/component/network/downloader/common/a:a	(Ljava/lang/String;J)[Ljava/net/InetAddress;
      //   1283: astore_3
      //   1284: aload 10
      //   1286: astore_1
      //   1287: aload_3
      //   1288: ifnull +71 -> 1359
      //   1291: aload 10
      //   1293: astore_1
      //   1294: aload 11
      //   1296: astore_2
      //   1297: aload_3
      //   1298: arraylength
      //   1299: ifle +60 -> 1359
      //   1302: aload 11
      //   1304: astore_2
      //   1305: aload_3
      //   1306: iconst_0
      //   1307: aaload
      //   1308: invokevirtual 86	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
      //   1311: astore_3
      //   1312: aload_3
      //   1313: astore_1
      //   1314: aload_3
      //   1315: astore_2
      //   1316: invokestatic 91	com/tencent/component/network/downloader/common/a:b	()Z
      //   1319: ifeq +40 -> 1359
      //   1322: aload_3
      //   1323: astore_2
      //   1324: ldc 93
      //   1326: new 95	java/lang/StringBuilder
      //   1329: dup
      //   1330: ldc 125
      //   1332: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1335: aload_0
      //   1336: getfield 26	com/tencent/component/network/module/common/a$b:a	Ljava/lang/String;
      //   1339: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1342: ldc 127
      //   1344: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1347: aload_3
      //   1348: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1351: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1354: invokestatic 110	com/tencent/component/network/downloader/common/a:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   1357: aload_3
      //   1358: astore_1
      //   1359: invokestatic 55	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
      //   1362: astore_3
      //   1363: aload_3
      //   1364: astore_2
      //   1365: ldc 57
      //   1367: aload_3
      //   1368: invokevirtual 62	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   1371: ifeq +7 -> 1378
      //   1374: invokestatic 65	com/tencent/component/network/NetworkManager:getBSSID	()Ljava/lang/String;
      //   1377: astore_2
      //   1378: invokestatic 91	com/tencent/component/network/downloader/common/a:b	()Z
      //   1381: ifeq +95 -> 1476
      //   1384: ldc 93
      //   1386: new 95	java/lang/StringBuilder
      //   1389: dup
      //   1390: ldc -127
      //   1392: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1395: aload_0
      //   1396: getfield 26	com/tencent/component/network/module/common/a$b:a	Ljava/lang/String;
      //   1399: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1402: ldc -125
      //   1404: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1407: aload_1
      //   1408: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1411: ldc -123
      //   1413: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1416: invokestatic 71	java/lang/System:currentTimeMillis	()J
      //   1419: lload 15
      //   1421: lsub
      //   1422: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1425: ldc -118
      //   1427: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1430: aload 4
      //   1432: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1435: ldc -116
      //   1437: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1440: aload_2
      //   1441: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1444: ldc -114
      //   1446: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1449: invokestatic 148	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   1452: invokevirtual 151	java/lang/Thread:getId	()J
      //   1455: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1458: ldc -103
      //   1460: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1463: aload_0
      //   1464: getfield 24	com/tencent/component/network/module/common/a$b:b	Z
      //   1467: invokevirtual 156	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   1470: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1473: invokestatic 110	com/tencent/component/network/downloader/common/a:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   1476: aload_0
      //   1477: getfield 24	com/tencent/component/network/module/common/a$b:b	Z
      //   1480: ifne +40 -> 1520
      //   1483: aload_0
      //   1484: getfield 19	com/tencent/component/network/module/common/a$b:c	Lcom/tencent/component/network/module/common/a;
      //   1487: aload_0
      //   1488: getfield 26	com/tencent/component/network/module/common/a$b:a	Ljava/lang/String;
      //   1491: aload_1
      //   1492: invokestatic 159	com/tencent/component/network/module/common/a:a	(Lcom/tencent/component/network/module/common/a;Ljava/lang/String;Ljava/lang/String;)V
      //   1495: goto -1078 -> 417
      //   1498: ldc2_w 119
      //   1501: lstore 13
      //   1503: goto -229 -> 1274
      //   1506: astore_1
      //   1507: ldc 93
      //   1509: ldc -87
      //   1511: aload_1
      //   1512: invokestatic 167	com/tencent/component/network/downloader/common/a:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   1515: aload_2
      //   1516: astore_1
      //   1517: goto -158 -> 1359
      //   1520: aload_0
      //   1521: getfield 19	com/tencent/component/network/module/common/a$b:c	Lcom/tencent/component/network/module/common/a;
      //   1524: aload_0
      //   1525: getfield 26	com/tencent/component/network/module/common/a$b:a	Ljava/lang/String;
      //   1528: aconst_null
      //   1529: invokestatic 159	com/tencent/component/network/module/common/a:a	(Lcom/tencent/component/network/module/common/a;Ljava/lang/String;Ljava/lang/String;)V
      //   1532: goto -1115 -> 417
      //   1535: astore 6
      //   1537: invokestatic 91	com/tencent/component/network/downloader/common/a:b	()Z
      //   1540: ifeq +24 -> 1564
      //   1543: ldc 93
      //   1545: new 95	java/lang/StringBuilder
      //   1548: dup
      //   1549: ldc 97
      //   1551: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1554: aconst_null
      //   1555: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1558: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1561: invokestatic 110	com/tencent/component/network/downloader/common/a:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   1564: aload_0
      //   1565: getfield 19	com/tencent/component/network/module/common/a$b:c	Lcom/tencent/component/network/module/common/a;
      //   1568: astore_1
      //   1569: aload_3
      //   1570: astore_1
      //   1571: aconst_null
      //   1572: invokestatic 113	com/tencent/component/network/module/common/a:b	(Ljava/lang/String;)Z
      //   1575: ifne +140 -> 1715
      //   1578: aload_0
      //   1579: getfield 19	com/tencent/component/network/module/common/a$b:c	Lcom/tencent/component/network/module/common/a;
      //   1582: astore_1
      //   1583: aload_3
      //   1584: astore_1
      //   1585: invokestatic 116	com/tencent/component/network/module/common/a:d	()Z
      //   1588: ifeq +127 -> 1715
      //   1591: invokestatic 71	java/lang/System:currentTimeMillis	()J
      //   1594: lload 15
      //   1596: lsub
      //   1597: lstore 13
      //   1599: aload 5
      //   1601: astore_2
      //   1602: aload_0
      //   1603: getfield 26	com/tencent/component/network/module/common/a$b:a	Ljava/lang/String;
      //   1606: astore_1
      //   1607: ldc2_w 117
      //   1610: lload 13
      //   1612: lsub
      //   1613: ldc2_w 119
      //   1616: lcmp
      //   1617: iflt +237 -> 1854
      //   1620: ldc2_w 117
      //   1623: lload 13
      //   1625: lsub
      //   1626: lstore 13
      //   1628: aload 5
      //   1630: astore_2
      //   1631: aload_1
      //   1632: lload 13
      //   1634: invokestatic 123	com/tencent/component/network/downloader/common/a:a	(Ljava/lang/String;J)[Ljava/net/InetAddress;
      //   1637: astore 7
      //   1639: aload_3
      //   1640: astore_1
      //   1641: aload 7
      //   1643: ifnull +72 -> 1715
      //   1646: aload_3
      //   1647: astore_1
      //   1648: aload 5
      //   1650: astore_2
      //   1651: aload 7
      //   1653: arraylength
      //   1654: ifle +61 -> 1715
      //   1657: aload 5
      //   1659: astore_2
      //   1660: aload 7
      //   1662: iconst_0
      //   1663: aaload
      //   1664: invokevirtual 86	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
      //   1667: astore_3
      //   1668: aload_3
      //   1669: astore_1
      //   1670: aload_3
      //   1671: astore_2
      //   1672: invokestatic 91	com/tencent/component/network/downloader/common/a:b	()Z
      //   1675: ifeq +40 -> 1715
      //   1678: aload_3
      //   1679: astore_2
      //   1680: ldc 93
      //   1682: new 95	java/lang/StringBuilder
      //   1685: dup
      //   1686: ldc 125
      //   1688: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1691: aload_0
      //   1692: getfield 26	com/tencent/component/network/module/common/a$b:a	Ljava/lang/String;
      //   1695: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1698: ldc 127
      //   1700: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1703: aload_3
      //   1704: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1707: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1710: invokestatic 110	com/tencent/component/network/downloader/common/a:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   1713: aload_3
      //   1714: astore_1
      //   1715: invokestatic 55	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
      //   1718: astore_3
      //   1719: aload_3
      //   1720: astore_2
      //   1721: ldc 57
      //   1723: aload_3
      //   1724: invokevirtual 62	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   1727: ifeq +7 -> 1734
      //   1730: invokestatic 65	com/tencent/component/network/NetworkManager:getBSSID	()Ljava/lang/String;
      //   1733: astore_2
      //   1734: invokestatic 91	com/tencent/component/network/downloader/common/a:b	()Z
      //   1737: ifeq +95 -> 1832
      //   1740: ldc 93
      //   1742: new 95	java/lang/StringBuilder
      //   1745: dup
      //   1746: ldc -127
      //   1748: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1751: aload_0
      //   1752: getfield 26	com/tencent/component/network/module/common/a$b:a	Ljava/lang/String;
      //   1755: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1758: ldc -125
      //   1760: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1763: aload_1
      //   1764: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1767: ldc -123
      //   1769: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1772: invokestatic 71	java/lang/System:currentTimeMillis	()J
      //   1775: lload 15
      //   1777: lsub
      //   1778: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1781: ldc -118
      //   1783: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1786: aload 4
      //   1788: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1791: ldc -116
      //   1793: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1796: aload_2
      //   1797: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1800: ldc -114
      //   1802: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1805: invokestatic 148	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   1808: invokevirtual 151	java/lang/Thread:getId	()J
      //   1811: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1814: ldc -103
      //   1816: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1819: aload_0
      //   1820: getfield 24	com/tencent/component/network/module/common/a$b:b	Z
      //   1823: invokevirtual 156	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   1826: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1829: invokestatic 110	com/tencent/component/network/downloader/common/a:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   1832: aload_0
      //   1833: getfield 24	com/tencent/component/network/module/common/a$b:b	Z
      //   1836: ifne +40 -> 1876
      //   1839: aload_0
      //   1840: getfield 19	com/tencent/component/network/module/common/a$b:c	Lcom/tencent/component/network/module/common/a;
      //   1843: aload_0
      //   1844: getfield 26	com/tencent/component/network/module/common/a$b:a	Ljava/lang/String;
      //   1847: aload_1
      //   1848: invokestatic 159	com/tencent/component/network/module/common/a:a	(Lcom/tencent/component/network/module/common/a;Ljava/lang/String;Ljava/lang/String;)V
      //   1851: aload 6
      //   1853: athrow
      //   1854: ldc2_w 119
      //   1857: lstore 13
      //   1859: goto -231 -> 1628
      //   1862: astore_1
      //   1863: ldc 93
      //   1865: ldc -87
      //   1867: aload_1
      //   1868: invokestatic 167	com/tencent/component/network/downloader/common/a:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   1871: aload_2
      //   1872: astore_1
      //   1873: goto -158 -> 1715
      //   1876: aload_0
      //   1877: getfield 19	com/tencent/component/network/module/common/a$b:c	Lcom/tencent/component/network/module/common/a;
      //   1880: aload_0
      //   1881: getfield 26	com/tencent/component/network/module/common/a$b:a	Ljava/lang/String;
      //   1884: aconst_null
      //   1885: invokestatic 159	com/tencent/component/network/module/common/a:a	(Lcom/tencent/component/network/module/common/a;Ljava/lang/String;Ljava/lang/String;)V
      //   1888: goto -37 -> 1851
      //   1891: ldc2_w 119
      //   1894: lstore 13
      //   1896: goto -1699 -> 197
      //   1899: astore_1
      //   1900: ldc 93
      //   1902: ldc -87
      //   1904: aload_1
      //   1905: invokestatic 167	com/tencent/component/network/downloader/common/a:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   1908: aload_3
      //   1909: astore_2
      //   1910: goto -1629 -> 281
      //   1913: aload_0
      //   1914: getfield 19	com/tencent/component/network/module/common/a$b:c	Lcom/tencent/component/network/module/common/a;
      //   1917: aload_0
      //   1918: getfield 26	com/tencent/component/network/module/common/a$b:a	Ljava/lang/String;
      //   1921: aconst_null
      //   1922: invokestatic 159	com/tencent/component/network/module/common/a:a	(Lcom/tencent/component/network/module/common/a;Ljava/lang/String;Ljava/lang/String;)V
      //   1925: goto -1508 -> 417
      //   1928: astore_2
      //   1929: aload_1
      //   1930: monitorexit
      //   1931: aload_2
      //   1932: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1933	0	this	b
      //   46	368	2	localObject1	Object
      //   441	4	2	localObject2	Object
      //   521	1389	2	localObject3	Object
      //   1928	4	2	localObject4	Object
      //   41	1868	3	localObject5	Object
      //   52	1735	4	localObject6	Object
      //   43	1615	5	arrayOfInetAddress1	java.net.InetAddress[]
      //   23	543	6	localObject7	Object
      //   1535	317	6	localObject8	Object
      //   26	1635	7	arrayOfInetAddress2	java.net.InetAddress[]
      //   29	900	8	localObject9	Object
      //   32	908	9	localObject10	Object
      //   35	1257	10	localObject11	Object
      //   38	1265	11	localObject12	Object
      //   92	10	12	localInetAddress	java.net.InetAddress
      //   167	1728	13	l1	long
      //   71	1705	15	l2	long
      // Exception table:
      //   from	to	target	type
      //   6	22	441	finally
      //   75	94	446	java/net/UnknownHostException
      //   101	107	446	java/net/UnknownHostException
      //   522	527	780	java/lang/Throwable
      //   551	558	780	java/lang/Throwable
      //   571	576	780	java/lang/Throwable
      //   579	586	780	java/lang/Throwable
      //   590	596	780	java/lang/Throwable
      //   598	631	780	java/lang/Throwable
      //   75	94	809	java/lang/Exception
      //   101	107	809	java/lang/Exception
      //   885	890	1143	java/lang/Throwable
      //   914	921	1143	java/lang/Throwable
      //   934	939	1143	java/lang/Throwable
      //   942	949	1143	java/lang/Throwable
      //   953	959	1143	java/lang/Throwable
      //   961	994	1143	java/lang/Throwable
      //   75	94	1172	java/lang/Error
      //   101	107	1172	java/lang/Error
      //   1248	1253	1506	java/lang/Throwable
      //   1277	1284	1506	java/lang/Throwable
      //   1297	1302	1506	java/lang/Throwable
      //   1305	1312	1506	java/lang/Throwable
      //   1316	1322	1506	java/lang/Throwable
      //   1324	1357	1506	java/lang/Throwable
      //   75	94	1535	finally
      //   101	107	1535	finally
      //   447	455	1535	finally
      //   810	818	1535	finally
      //   1173	1181	1535	finally
      //   1602	1607	1862	java/lang/Throwable
      //   1631	1639	1862	java/lang/Throwable
      //   1651	1657	1862	java/lang/Throwable
      //   1660	1668	1862	java/lang/Throwable
      //   1672	1678	1862	java/lang/Throwable
      //   1680	1713	1862	java/lang/Throwable
      //   171	176	1899	java/lang/Throwable
      //   199	207	1899	java/lang/Throwable
      //   218	224	1899	java/lang/Throwable
      //   226	234	1899	java/lang/Throwable
      //   238	244	1899	java/lang/Throwable
      //   246	279	1899	java/lang/Throwable
      //   423	439	1928	finally
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\module\common\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */