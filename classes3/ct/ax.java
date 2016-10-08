package ct;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class ax
{
  public static int a = -1;
  public static int b = -1;
  private static int c = 20000;
  private static ThreadPoolExecutor d;
  
  public static aw a(String paramString, int paramInt)
  {
    if (paramString != null) {
      try
      {
        if ("".equals(paramString)) {
          return null;
        }
        paramString = b(paramString, paramInt);
        return paramString;
      }
      catch (Exception paramString) {}
    }
    return null;
  }
  
  public static aw a(ArrayList paramArrayList, int paramInt)
  {
    if (paramArrayList != null) {
      try
      {
        if (paramArrayList.size() <= 0) {
          return null;
        }
        paramArrayList = a(paramArrayList, "", paramInt);
        return paramArrayList;
      }
      catch (Exception paramArrayList) {}
    }
    return null;
  }
  
  public static aw a(ArrayList paramArrayList, String paramString, int paramInt)
  {
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    c localc = new c((byte)0);
    localaw = new aw();
    try
    {
      if (d == null) {
        d = new ThreadPoolExecutor(3, 5, 3000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(5), new a("HalleyAccess"));
      }
      paramArrayList = a(paramArrayList, paramString).iterator();
      while (paramArrayList.hasNext())
      {
        paramString = new b(localCountDownLatch, localc, (aw)paramArrayList.next());
        d.execute(paramString);
      }
      int i;
      return localaw;
    }
    catch (RejectedExecutionException paramArrayList)
    {
      localaw.d = "ThreadPool is full";
      return localaw;
      if (paramInt >= 0)
      {
        i = paramInt;
        if (paramInt <= c) {}
      }
      else
      {
        i = c;
      }
      if (!localCountDownLatch.await(i, TimeUnit.MILLISECONDS))
      {
        localaw.d = "latch wait too long";
        return localaw;
      }
      paramArrayList = localc.b;
      return paramArrayList;
    }
    catch (InterruptedException paramArrayList)
    {
      localaw.d = "countDownLatch InterruptedException";
      return localaw;
    }
    catch (Throwable paramArrayList)
    {
      localaw.d = "Parallel connect failed";
    }
  }
  
  private static List a(ArrayList paramArrayList, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      s locals = (s)paramArrayList.next();
      aw localaw = new aw();
      localaw.g = locals;
      localArrayList.add(localaw);
    }
    if (!TextUtils.isEmpty(paramString))
    {
      paramArrayList = new aw();
      paramArrayList.b = paramString;
      localArrayList.add(paramArrayList);
    }
    return localArrayList;
  }
  
  public static void a()
  {
    if (d != null)
    {
      d.shutdownNow();
      d = null;
    }
  }
  
  private static aw b(String paramString, int paramInt)
  {
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    c localc = new c((byte)0);
    aw localaw = new aw();
    localaw.b = paramString;
    paramString = new b(localCountDownLatch, localc, localaw);
    o.a().a(paramString);
    long l = paramInt;
    try
    {
      if (!localCountDownLatch.await(l, TimeUnit.MILLISECONDS))
      {
        localaw.d = "latch wait too long";
        return localaw;
      }
      paramString = localc.b;
      return paramString;
    }
    catch (InterruptedException paramString)
    {
      paramString.printStackTrace();
    }
    return localaw;
  }
  
  static final class a
    implements ThreadFactory
  {
    private static final AtomicInteger a = new AtomicInteger(1);
    private final ThreadGroup b;
    private final AtomicInteger c = new AtomicInteger(1);
    private final String d;
    
    a(String paramString)
    {
      Object localObject = System.getSecurityManager();
      if (localObject != null) {}
      for (localObject = ((SecurityManager)localObject).getThreadGroup();; localObject = Thread.currentThread().getThreadGroup())
      {
        this.b = ((ThreadGroup)localObject);
        this.d = (paramString + "-" + a.getAndIncrement() + "-thread-");
        return;
      }
    }
    
    public final Thread newThread(Runnable paramRunnable)
    {
      paramRunnable = new Thread(this.b, paramRunnable, this.d + this.c.getAndIncrement(), 0L);
      if (paramRunnable.isDaemon()) {
        paramRunnable.setDaemon(false);
      }
      if (paramRunnable.getPriority() != 5) {
        paramRunnable.setPriority(5);
      }
      return paramRunnable;
    }
  }
  
  static final class b
    implements Runnable
  {
    private CountDownLatch a = null;
    private ax.c b = null;
    private aw c = null;
    
    public b(CountDownLatch paramCountDownLatch, ax.c paramc, aw paramaw)
    {
      this.a = paramCountDownLatch;
      this.b = paramc;
      this.c = paramaw;
    }
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_1
      //   2: aload_0
      //   3: getfield 25	ct/ax$b:c	Lct/aw;
      //   6: astore_3
      //   7: new 35	java/lang/StringBuilder
      //   10: dup
      //   11: ldc 37
      //   13: invokespecial 40	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   16: invokestatic 46	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   19: invokevirtual 50	java/lang/Thread:getName	()Ljava/lang/String;
      //   22: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   25: ldc 56
      //   27: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   30: invokestatic 46	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   33: invokevirtual 60	java/lang/Thread:isDaemon	()Z
      //   36: invokevirtual 63	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   39: pop
      //   40: invokestatic 67	ct/bc:c	()V
      //   43: invokestatic 73	java/lang/System:currentTimeMillis	()J
      //   46: lstore 4
      //   48: aload_3
      //   49: getfield 78	ct/aw:b	Ljava/lang/String;
      //   52: invokestatic 84	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   55: istore 8
      //   57: iload 8
      //   59: ifne +256 -> 315
      //   62: aload_3
      //   63: getfield 78	ct/aw:b	Ljava/lang/String;
      //   66: invokestatic 90	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
      //   69: astore_2
      //   70: aload_2
      //   71: astore_1
      //   72: aload_3
      //   73: invokestatic 73	java/lang/System:currentTimeMillis	()J
      //   76: lload 4
      //   78: lsub
      //   79: l2i
      //   80: putfield 94	ct/aw:e	I
      //   83: new 96	java/net/InetSocketAddress
      //   86: dup
      //   87: aload_1
      //   88: invokevirtual 99	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
      //   91: sipush 14000
      //   94: invokespecial 102	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
      //   97: astore_1
      //   98: new 104	java/net/Socket
      //   101: dup
      //   102: invokespecial 105	java/net/Socket:<init>	()V
      //   105: astore_2
      //   106: lconst_0
      //   107: lstore 4
      //   109: invokestatic 73	java/lang/System:currentTimeMillis	()J
      //   112: lstore 6
      //   114: lload 6
      //   116: lstore 4
      //   118: aload_3
      //   119: invokestatic 110	ct/b:a	()Lct/b;
      //   122: getfield 113	ct/b:b	Lct/d;
      //   125: getfield 117	ct/d:a	I
      //   128: putfield 118	ct/aw:a	I
      //   131: lload 6
      //   133: lstore 4
      //   135: aload_2
      //   136: aload_1
      //   137: aload_3
      //   138: getfield 118	ct/aw:a	I
      //   141: invokevirtual 122	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
      //   144: lload 6
      //   146: lstore 4
      //   148: aload_2
      //   149: invokevirtual 125	java/net/Socket:isConnected	()Z
      //   152: ifeq +38 -> 190
      //   155: lload 6
      //   157: lstore 4
      //   159: aload_2
      //   160: invokevirtual 128	java/net/Socket:isClosed	()Z
      //   163: ifne +27 -> 190
      //   166: lload 6
      //   168: lstore 4
      //   170: aload_3
      //   171: aload_2
      //   172: putfield 131	ct/aw:c	Ljava/net/Socket;
      //   175: lload 6
      //   177: lstore 4
      //   179: aload_3
      //   180: invokestatic 73	java/lang/System:currentTimeMillis	()J
      //   183: lload 6
      //   185: lsub
      //   186: l2i
      //   187: putfield 134	ct/aw:f	I
      //   190: invokestatic 73	java/lang/System:currentTimeMillis	()J
      //   193: pop2
      //   194: aload_0
      //   195: getfield 25	ct/ax$b:c	Lct/aw;
      //   198: getfield 94	ct/aw:e	I
      //   201: putstatic 135	ct/ax:a	I
      //   204: aload_0
      //   205: getfield 25	ct/ax$b:c	Lct/aw;
      //   208: getfield 134	ct/aw:f	I
      //   211: putstatic 137	ct/ax:b	I
      //   214: aload_0
      //   215: getfield 23	ct/ax$b:b	Lct/ax$c;
      //   218: astore_1
      //   219: aload_0
      //   220: getfield 25	ct/ax$b:c	Lct/aw;
      //   223: astore_2
      //   224: aload_2
      //   225: ifnull +33 -> 258
      //   228: aload_1
      //   229: getfield 142	ct/ax$c:a	Ljava/util/concurrent/locks/Lock;
      //   232: invokeinterface 147 1 0
      //   237: aload_1
      //   238: getfield 149	ct/ax$c:b	Lct/aw;
      //   241: ifnonnull +144 -> 385
      //   244: aload_1
      //   245: aload_2
      //   246: putfield 149	ct/ax$c:b	Lct/aw;
      //   249: aload_1
      //   250: getfield 142	ct/ax$c:a	Ljava/util/concurrent/locks/Lock;
      //   253: invokeinterface 152 1 0
      //   258: aload_0
      //   259: getfield 21	ct/ax$b:a	Ljava/util/concurrent/CountDownLatch;
      //   262: invokevirtual 157	java/util/concurrent/CountDownLatch:countDown	()V
      //   265: return
      //   266: astore_2
      //   267: aload_2
      //   268: invokevirtual 161	java/lang/Object:getClass	()Ljava/lang/Class;
      //   271: invokevirtual 166	java/lang/Class:getSimpleName	()Ljava/lang/String;
      //   274: pop
      //   275: aload_3
      //   276: new 35	java/lang/StringBuilder
      //   279: dup
      //   280: ldc -88
      //   282: invokespecial 40	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   285: aload_3
      //   286: getfield 78	ct/aw:b	Ljava/lang/String;
      //   289: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   292: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   295: putfield 174	ct/aw:d	Ljava/lang/String;
      //   298: goto -226 -> 72
      //   301: astore_1
      //   302: aload_3
      //   303: aload_1
      //   304: invokestatic 179	ct/be:a	(Ljava/lang/Exception;)Ljava/lang/String;
      //   307: putfield 174	ct/aw:d	Ljava/lang/String;
      //   310: goto -116 -> 194
      //   313: astore_1
      //   314: return
      //   315: new 96	java/net/InetSocketAddress
      //   318: dup
      //   319: aload_3
      //   320: getfield 183	ct/aw:g	Lct/s;
      //   323: getfield 187	ct/s:a	Ljava/lang/String;
      //   326: aload_3
      //   327: getfield 183	ct/aw:g	Lct/s;
      //   330: getfield 188	ct/s:b	I
      //   333: invokespecial 102	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
      //   336: astore_1
      //   337: aload_3
      //   338: iconst_0
      //   339: putfield 94	ct/aw:e	I
      //   342: goto -244 -> 98
      //   345: astore_1
      //   346: aload_1
      //   347: invokevirtual 191	java/lang/Exception:printStackTrace	()V
      //   350: aload_1
      //   351: invokevirtual 161	java/lang/Object:getClass	()Ljava/lang/Class;
      //   354: invokevirtual 166	java/lang/Class:getSimpleName	()Ljava/lang/String;
      //   357: pop
      //   358: aload_3
      //   359: aload_1
      //   360: invokestatic 179	ct/be:a	(Ljava/lang/Exception;)Ljava/lang/String;
      //   363: putfield 174	ct/aw:d	Ljava/lang/String;
      //   366: aload_3
      //   367: invokestatic 73	java/lang/System:currentTimeMillis	()J
      //   370: lload 4
      //   372: lsub
      //   373: l2i
      //   374: putfield 134	ct/aw:f	I
      //   377: aload_3
      //   378: aconst_null
      //   379: putfield 131	ct/aw:c	Ljava/net/Socket;
      //   382: goto -192 -> 190
      //   385: aload_2
      //   386: getfield 131	ct/aw:c	Ljava/net/Socket;
      //   389: invokevirtual 194	java/net/Socket:close	()V
      //   392: goto -143 -> 249
      //   395: astore_2
      //   396: aload_2
      //   397: invokevirtual 195	java/io/IOException:printStackTrace	()V
      //   400: goto -151 -> 249
      //   403: astore_2
      //   404: aload_1
      //   405: getfield 142	ct/ax$c:a	Ljava/util/concurrent/locks/Lock;
      //   408: invokeinterface 152 1 0
      //   413: aload_2
      //   414: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	415	0	this	b
      //   1	249	1	localObject1	Object
      //   301	3	1	localException1	Exception
      //   313	1	1	localThrowable	Throwable
      //   336	1	1	localInetSocketAddress	java.net.InetSocketAddress
      //   345	60	1	localException2	Exception
      //   69	177	2	localObject2	Object
      //   266	120	2	localException3	Exception
      //   395	2	2	localIOException	java.io.IOException
      //   403	11	2	localObject3	Object
      //   6	372	3	localaw	aw
      //   46	325	4	l1	long
      //   112	72	6	l2	long
      //   55	3	8	bool	boolean
      // Exception table:
      //   from	to	target	type
      //   62	70	266	java/lang/Exception
      //   7	57	301	java/lang/Exception
      //   72	98	301	java/lang/Exception
      //   98	106	301	java/lang/Exception
      //   190	194	301	java/lang/Exception
      //   267	298	301	java/lang/Exception
      //   315	342	301	java/lang/Exception
      //   346	382	301	java/lang/Exception
      //   2	7	313	java/lang/Throwable
      //   7	57	313	java/lang/Throwable
      //   62	70	313	java/lang/Throwable
      //   72	98	313	java/lang/Throwable
      //   98	106	313	java/lang/Throwable
      //   109	114	313	java/lang/Throwable
      //   118	131	313	java/lang/Throwable
      //   135	144	313	java/lang/Throwable
      //   148	155	313	java/lang/Throwable
      //   159	166	313	java/lang/Throwable
      //   170	175	313	java/lang/Throwable
      //   179	190	313	java/lang/Throwable
      //   190	194	313	java/lang/Throwable
      //   194	224	313	java/lang/Throwable
      //   228	237	313	java/lang/Throwable
      //   249	258	313	java/lang/Throwable
      //   258	265	313	java/lang/Throwable
      //   267	298	313	java/lang/Throwable
      //   302	310	313	java/lang/Throwable
      //   315	342	313	java/lang/Throwable
      //   346	382	313	java/lang/Throwable
      //   404	415	313	java/lang/Throwable
      //   109	114	345	java/lang/Exception
      //   118	131	345	java/lang/Exception
      //   135	144	345	java/lang/Exception
      //   148	155	345	java/lang/Exception
      //   159	166	345	java/lang/Exception
      //   170	175	345	java/lang/Exception
      //   179	190	345	java/lang/Exception
      //   385	392	395	java/io/IOException
      //   237	249	403	finally
      //   385	392	403	finally
      //   396	400	403	finally
    }
  }
  
  static final class c
  {
    Lock a = new ReentrantLock();
    aw b = null;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */