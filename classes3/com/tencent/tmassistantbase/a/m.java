package com.tencent.tmassistantbase.a;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class m
{
  protected static ArrayList<WeakReference<g>> A;
  private static ArrayList<String> B;
  private static long C;
  private static Field D;
  private static Boolean E = Boolean.valueOf(true);
  private static ThreadLocal<char[]> F = new n();
  protected static boolean a = false;
  protected static String b = "";
  protected static int c = 2;
  protected static int d = 4;
  protected static boolean e = true;
  protected static boolean f = false;
  protected static boolean g = false;
  protected static Context h;
  protected static boolean i;
  static LinkedBlockingQueue<String> j;
  protected static BufferedWriter k;
  static long l;
  static final ReentrantLock m;
  protected static int n;
  protected static String o;
  protected static String p;
  protected static long q;
  protected static SimpleDateFormat r;
  protected static AtomicBoolean s;
  protected static AtomicBoolean t;
  protected static final int[] u;
  protected static AtomicInteger v;
  protected static Handler w;
  protected static Runnable x = new o();
  static Thread y = new q();
  protected static ReferenceQueue<g> z;
  
  static
  {
    B = new ArrayList();
    i = false;
    C = 0L;
    l = 0L;
    m = new ReentrantLock();
    o = "";
    p = "";
    q = 0L;
    r = new SimpleDateFormat("yy-MM-dd HH:mm");
    s = new AtomicBoolean(false);
    t = new AtomicBoolean(false);
    u = new int[] { 1, 2, 4, 8, 16, 29 };
    v = new AtomicInteger(0);
    w = new Handler(Looper.getMainLooper());
  }
  
  public static void a(int paramInt)
  {
    c = paramInt;
  }
  
  private static void a(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    if ((paramInt < c()) && (paramInt < b())) {
      return;
    }
    if ((!e()) || (paramInt >= b()))
    {
      if ((paramInt == 2) && (a()))
      {
        if (paramThrowable != null) {
          break label267;
        }
        Log.v(paramString1, paramString2);
      }
      label49:
      if ((paramInt == 3) && (a()))
      {
        if (paramThrowable != null) {
          break label277;
        }
        Log.d(paramString1, paramString2);
      }
      label70:
      if (paramInt == 4)
      {
        if (paramThrowable != null) {
          break label287;
        }
        Log.i(paramString1, paramString2);
      }
      label85:
      if (paramInt == 5)
      {
        if (paramThrowable != null) {
          break label297;
        }
        Log.w(paramString1, paramString2);
      }
      label100:
      if (paramInt == 6)
      {
        if (paramThrowable != null) {
          break label307;
        }
        Log.e(paramString1, paramString2);
      }
    }
    for (;;)
    {
      if (paramInt >= c()) {
        c(paramInt, paramString1, paramString2, paramThrowable);
      }
      if ((paramInt < c()) || (A == null)) {
        break;
      }
      if (B == null) {
        B = new ArrayList();
      }
      if ((B.size() < 20) && (System.currentTimeMillis() - C <= 3000L)) {
        break label317;
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(B);
      B.clear();
      C = System.currentTimeMillis();
      Iterator localIterator = A.iterator();
      while (localIterator.hasNext())
      {
        g localg = (g)((WeakReference)localIterator.next()).get();
        if (localg != null) {
          localg.a(localArrayList);
        }
      }
      label267:
      Log.v(paramString1, paramString2, paramThrowable);
      break label49;
      label277:
      Log.d(paramString1, paramString2, paramThrowable);
      break label70;
      label287:
      Log.i(paramString1, paramString2, paramThrowable);
      break label85;
      label297:
      Log.w(paramString1, paramString2, paramThrowable);
      break label100;
      label307:
      Log.e(paramString1, paramString2, paramThrowable);
    }
    label317:
    B.add(b(paramInt, paramString1, paramString2, paramThrowable));
  }
  
  public static void a(Context paramContext)
  {
    try
    {
      if (!i)
      {
        h = paramContext;
        x.run();
        i = true;
      }
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("/")) && (paramString.endsWith("/"))) {
      b = paramString;
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    a(2, paramString1, paramString2, null);
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(4, paramString1, paramString2, paramThrowable);
  }
  
  public static void a(boolean paramBoolean)
  {
    e = paramBoolean;
  }
  
  public static boolean a()
  {
    return false;
  }
  
  public static boolean a(g paramg)
  {
    boolean bool;
    if (paramg == null) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      Object localObject;
      try
      {
        Log.d("TMLog", "registerLogListener : " + paramg);
        if (A == null) {
          A = new ArrayList();
        }
        if (z == null) {
          z = new ReferenceQueue();
        }
        localObject = z.poll();
        while (localObject != null) {
          A.remove(localObject);
        }
        localObject = A.iterator();
      }
      finally {}
      for (;;)
      {
        if (((Iterator)localObject).hasNext()) {
          if ((g)((WeakReference)((Iterator)localObject).next()).get() == paramg)
          {
            bool = true;
            break;
          }
        }
      }
      paramg = new WeakReference(paramg, z);
      A.add(paramg);
      bool = true;
    }
  }
  
  public static int b()
  {
    return c;
  }
  
  private static String b(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LL'" + c(paramInt) + "&");
    localStringBuilder.append("LTS'" + System.currentTimeMillis() + "&");
    localStringBuilder.append("LT'" + paramString1 + "&");
    localStringBuilder.append("LM'" + paramString2);
    if (paramThrowable != null) {
      localStringBuilder.append("&LW'" + Log.getStackTraceString(paramThrowable));
    }
    return localStringBuilder.toString();
  }
  
  public static void b(int paramInt)
  {
    d = paramInt;
  }
  
  public static void b(String paramString1, String paramString2)
  {
    a(3, paramString1, paramString2, null);
  }
  
  public static void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(5, paramString1, paramString2, paramThrowable);
  }
  
  public static void b(boolean paramBoolean)
  {
    g = paramBoolean;
  }
  
  public static boolean b(g paramg)
  {
    boolean bool;
    if (paramg == null)
    {
      bool = false;
      return bool;
    }
    for (;;)
    {
      try
      {
        Iterator localIterator = A.iterator();
        if (localIterator.hasNext())
        {
          WeakReference localWeakReference = (WeakReference)localIterator.next();
          if ((g)localWeakReference.get() != paramg) {
            break label85;
          }
          A.remove(localWeakReference);
          i1 = 1;
          if (i1 == 0) {
            continue;
          }
          bool = true;
          break;
        }
        bool = false;
        break;
      }
      finally {}
      label85:
      int i1 = 0;
    }
  }
  
  public static int c()
  {
    return d;
  }
  
  private static String c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "D";
    case 2: 
      return "V";
    case 3: 
      return "D";
    case 4: 
      return "I";
    case 5: 
      return "W";
    }
    return "E";
  }
  
  private static void c(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (!g()) {}
    do
    {
      return;
      long l1 = Thread.currentThread().getId();
      StringBuilder localStringBuilder = l();
      if (f()) {
        localStringBuilder.append(i()).append("|");
      }
      localStringBuilder.append(c(paramInt)).append("|pid=").append(n).append("|tid=").append(String.valueOf(l1)).append("|").append(paramString1).append("|").append(paramString2).append("\n");
      paramString1 = localStringBuilder;
      if (paramThrowable != null) {
        paramString1 = localStringBuilder.append("\n").append(Log.getStackTraceString(paramThrowable)).append("\n");
      }
    } while (c(paramString1.toString()));
    Log.d("TMLog", "addLogToCache failed!");
  }
  
  public static void c(String paramString1, String paramString2)
  {
    a(4, paramString1, paramString2, null);
  }
  
  public static void c(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(6, paramString1, paramString2, paramThrowable);
  }
  
  public static void c(boolean paramBoolean)
  {
    a = paramBoolean;
  }
  
  private static boolean c(String paramString)
  {
    try
    {
      j.add(paramString);
      return true;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  private static void d(String paramString)
  {
    if (!g()) {
      return;
    }
    long l1;
    if (k == null)
    {
      Log.d("TMLog", "can not write log.");
      l1 = System.currentTimeMillis();
      if (l == 0L) {
        l = l1;
      }
    }
    for (;;)
    {
      s.compareAndSet(true, false);
      return;
      if (l1 - l > 60000L)
      {
        try
        {
          m();
          l = l1;
        }
        catch (IOException paramString)
        {
          for (;;)
          {
            paramString.printStackTrace();
          }
        }
        if (m.tryLock()) {}
        try
        {
          k.write(paramString);
          if (!d()) {
            k.flush();
          }
          m.unlock();
        }
        finally
        {
          m.unlock();
        }
        Log.d("TMLog", "addLogToCache failed!");
      }
    }
  }
  
  public static void d(String paramString1, String paramString2)
  {
    a(5, paramString1, paramString2, null);
  }
  
  public static boolean d()
  {
    return e;
  }
  
  public static void e(String paramString1, String paramString2)
  {
    a(6, paramString1, paramString2, null);
  }
  
  public static boolean e()
  {
    return f;
  }
  
  public static boolean f()
  {
    return g;
  }
  
  public static boolean g()
  {
    return a;
  }
  
  public static String h()
  {
    if (TextUtils.isEmpty(b)) {
      b = Environment.getExternalStorageDirectory().getPath() + "/tencent/TMAssistantSDK/Logs/";
    }
    return b;
  }
  
  public static String i()
  {
    long l1 = System.currentTimeMillis();
    if (l1 - q > 60000L)
    {
      q = l1;
      p = r.format(Long.valueOf(q));
    }
    return p;
  }
  
  private static StringBuilder l()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      if (E.booleanValue())
      {
        D = StringBuilder.class.getSuperclass().getDeclaredField("value");
        D.setAccessible(true);
        E = Boolean.valueOf(false);
      }
      if (D != null) {
        D.set(localStringBuilder, F.get());
      }
      return localStringBuilder;
    }
    catch (Exception localException) {}
    return localStringBuilder;
  }
  
  /* Error */
  private static void m()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 286
    //   6: ldc_w 483
    //   9: invokestatic 185	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   12: pop
    //   13: new 434	java/io/File
    //   16: dup
    //   17: invokestatic 485	com/tencent/tmassistantbase/a/m:h	()Ljava/lang/String;
    //   20: invokespecial 486	java/io/File:<init>	(Ljava/lang/String;)V
    //   23: astore_0
    //   24: aload_0
    //   25: invokevirtual 489	java/io/File:exists	()Z
    //   28: ifne +8 -> 36
    //   31: aload_0
    //   32: invokevirtual 492	java/io/File:mkdirs	()Z
    //   35: pop
    //   36: new 434	java/io/File
    //   39: dup
    //   40: new 288	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 289	java/lang/StringBuilder:<init>	()V
    //   47: invokestatic 485	com/tencent/tmassistantbase/a/m:h	()Ljava/lang/String;
    //   50: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: getstatic 99	com/tencent/tmassistantbase/a/m:o	Ljava/lang/String;
    //   56: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: ldc_w 494
    //   62: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 302	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokespecial 486	java/io/File:<init>	(Ljava/lang/String;)V
    //   71: astore_0
    //   72: aload_0
    //   73: invokevirtual 489	java/io/File:exists	()Z
    //   76: ifne +145 -> 221
    //   79: aload_0
    //   80: invokevirtual 497	java/io/File:createNewFile	()Z
    //   83: istore_2
    //   84: invokestatic 499	com/tencent/tmassistantbase/a/m:n	()V
    //   87: getstatic 397	com/tencent/tmassistantbase/a/m:k	Ljava/io/BufferedWriter;
    //   90: ifnull +102 -> 192
    //   93: invokestatic 350	com/tencent/tmassistantbase/a/m:g	()Z
    //   96: ifeq +96 -> 192
    //   99: getstatic 397	com/tencent/tmassistantbase/a/m:k	Ljava/io/BufferedWriter;
    //   102: new 288	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 289	java/lang/StringBuilder:<init>	()V
    //   109: invokestatic 366	com/tencent/tmassistantbase/a/m:i	()Ljava/lang/String;
    //   112: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: ldc_w 368
    //   118: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: getstatic 99	com/tencent/tmassistantbase/a/m:o	Ljava/lang/String;
    //   124: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: ldc_w 368
    //   130: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: getstatic 504	android/os/Build:MODEL	Ljava/lang/String;
    //   136: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: ldc_w 506
    //   142: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: getstatic 511	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   148: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: ldc_w 513
    //   154: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: aload_0
    //   158: invokevirtual 516	java/io/File:getName	()Ljava/lang/String;
    //   161: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: ldc_w 506
    //   167: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: iload_2
    //   171: invokevirtual 519	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   174: ldc_w 382
    //   177: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: invokevirtual 302	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokevirtual 418	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   186: getstatic 397	com/tencent/tmassistantbase/a/m:k	Ljava/io/BufferedWriter;
    //   189: invokevirtual 423	java/io/BufferedWriter:flush	()V
    //   192: new 415	java/io/BufferedWriter
    //   195: dup
    //   196: new 521	java/io/FileWriter
    //   199: dup
    //   200: aload_0
    //   201: iconst_1
    //   202: invokespecial 524	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   205: sipush 8192
    //   208: invokespecial 527	java/io/BufferedWriter:<init>	(Ljava/io/Writer;I)V
    //   211: putstatic 397	com/tencent/tmassistantbase/a/m:k	Ljava/io/BufferedWriter;
    //   214: invokestatic 499	com/tencent/tmassistantbase/a/m:n	()V
    //   217: ldc 2
    //   219: monitorexit
    //   220: return
    //   221: aload_0
    //   222: invokevirtual 530	java/io/File:length	()J
    //   225: ldc2_w 531
    //   228: lcmp
    //   229: iflt +49 -> 278
    //   232: aload_0
    //   233: invokevirtual 535	java/io/File:delete	()Z
    //   236: pop
    //   237: aload_0
    //   238: invokevirtual 497	java/io/File:createNewFile	()Z
    //   241: pop
    //   242: ldc_w 286
    //   245: new 288	java/lang/StringBuilder
    //   248: dup
    //   249: invokespecial 289	java/lang/StringBuilder:<init>	()V
    //   252: ldc_w 537
    //   255: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: aload_0
    //   259: invokevirtual 516	java/io/File:getName	()Ljava/lang/String;
    //   262: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: ldc_w 539
    //   268: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: invokevirtual 302	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   274: invokestatic 185	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   277: pop
    //   278: invokestatic 499	com/tencent/tmassistantbase/a/m:n	()V
    //   281: getstatic 397	com/tencent/tmassistantbase/a/m:k	Ljava/io/BufferedWriter;
    //   284: ifnull -92 -> 192
    //   287: invokestatic 350	com/tencent/tmassistantbase/a/m:g	()Z
    //   290: ifeq -98 -> 192
    //   293: getstatic 397	com/tencent/tmassistantbase/a/m:k	Ljava/io/BufferedWriter;
    //   296: new 288	java/lang/StringBuilder
    //   299: dup
    //   300: invokespecial 289	java/lang/StringBuilder:<init>	()V
    //   303: invokestatic 366	com/tencent/tmassistantbase/a/m:i	()Ljava/lang/String;
    //   306: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: ldc_w 368
    //   312: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: getstatic 99	com/tencent/tmassistantbase/a/m:o	Ljava/lang/String;
    //   318: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: ldc_w 368
    //   324: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: getstatic 504	android/os/Build:MODEL	Ljava/lang/String;
    //   330: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: ldc_w 506
    //   336: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: getstatic 511	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   342: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: ldc_w 541
    //   348: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: aload_0
    //   352: invokevirtual 516	java/io/File:getName	()Ljava/lang/String;
    //   355: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: ldc_w 543
    //   361: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: invokevirtual 302	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   367: invokevirtual 418	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   370: getstatic 397	com/tencent/tmassistantbase/a/m:k	Ljava/io/BufferedWriter;
    //   373: invokevirtual 423	java/io/BufferedWriter:flush	()V
    //   376: goto -184 -> 192
    //   379: astore_1
    //   380: aload_1
    //   381: invokevirtual 544	java/lang/Throwable:printStackTrace	()V
    //   384: goto -192 -> 192
    //   387: astore_0
    //   388: ldc 2
    //   390: monitorexit
    //   391: aload_0
    //   392: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   23	329	0	localFile	File
    //   387	5	0	localObject	Object
    //   379	2	1	localThrowable	Throwable
    //   83	88	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   72	192	379	java/lang/Throwable
    //   221	278	379	java/lang/Throwable
    //   278	376	379	java/lang/Throwable
    //   3	36	387	finally
    //   36	72	387	finally
    //   72	192	387	finally
    //   192	217	387	finally
    //   221	278	387	finally
    //   278	376	387	finally
    //   380	384	387	finally
  }
  
  private static void n()
  {
    if ((k != null) && (g()))
    {
      k.write("SDK_VERSION = 1.0|BUILD_NO = {BuildNo}|RELEASE_DATE: {ReleaseDate}\r\n");
      k.flush();
    }
  }
  
  /* Error */
  private static void o()
  {
    // Byte code:
    //   0: ldc_w 550
    //   3: invokestatic 553	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   6: invokevirtual 556	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9: ifeq +463 -> 472
    //   12: new 558	java/util/Properties
    //   15: dup
    //   16: invokespecial 559	java/util/Properties:<init>	()V
    //   19: astore_0
    //   20: new 434	java/io/File
    //   23: dup
    //   24: new 288	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 289	java/lang/StringBuilder:<init>	()V
    //   31: invokestatic 432	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   34: invokevirtual 437	java/io/File:getPath	()Ljava/lang/String;
    //   37: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: ldc_w 561
    //   43: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 302	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokespecial 486	java/io/File:<init>	(Ljava/lang/String;)V
    //   52: astore_1
    //   53: aload_1
    //   54: invokevirtual 489	java/io/File:exists	()Z
    //   57: ifne +4 -> 61
    //   60: return
    //   61: aload_0
    //   62: new 563	java/io/FileInputStream
    //   65: dup
    //   66: aload_1
    //   67: invokespecial 566	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   70: invokevirtual 570	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   73: aload_0
    //   74: ldc_w 572
    //   77: ldc 67
    //   79: invokevirtual 576	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   82: astore_1
    //   83: aload_1
    //   84: invokevirtual 579	java/lang/String:trim	()Ljava/lang/String;
    //   87: ldc_w 581
    //   90: invokevirtual 556	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   93: ifeq +340 -> 433
    //   96: iconst_1
    //   97: invokestatic 583	com/tencent/tmassistantbase/a/m:c	(Z)V
    //   100: aload_0
    //   101: ldc_w 585
    //   104: ldc 67
    //   106: invokevirtual 576	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   109: astore_2
    //   110: aload_2
    //   111: invokestatic 268	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   114: istore 6
    //   116: iload 6
    //   118: ifne +13 -> 131
    //   121: aload_2
    //   122: invokestatic 590	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   125: invokevirtual 593	java/lang/Integer:intValue	()I
    //   128: invokestatic 595	com/tencent/tmassistantbase/a/m:b	(I)V
    //   131: aload_0
    //   132: ldc_w 597
    //   135: ldc 67
    //   137: invokevirtual 576	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   140: astore_3
    //   141: aload_3
    //   142: invokestatic 268	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   145: istore 6
    //   147: iload 6
    //   149: ifne +13 -> 162
    //   152: aload_3
    //   153: invokestatic 590	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   156: invokevirtual 593	java/lang/Integer:intValue	()I
    //   159: invokestatic 599	com/tencent/tmassistantbase/a/m:a	(I)V
    //   162: aload_0
    //   163: ldc_w 601
    //   166: ldc 67
    //   168: invokevirtual 576	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   171: astore 4
    //   173: aload 4
    //   175: invokestatic 603	com/tencent/tmassistantbase/a/m:a	(Ljava/lang/String;)V
    //   178: aload_0
    //   179: ldc_w 605
    //   182: ldc 67
    //   184: invokevirtual 576	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   187: astore 5
    //   189: aload 5
    //   191: invokevirtual 579	java/lang/String:trim	()Ljava/lang/String;
    //   194: ldc_w 607
    //   197: invokevirtual 556	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   200: ifeq +258 -> 458
    //   203: iconst_0
    //   204: invokestatic 609	com/tencent/tmassistantbase/a/m:a	(Z)V
    //   207: aload_0
    //   208: ldc_w 611
    //   211: ldc 67
    //   213: invokevirtual 576	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   216: invokevirtual 579	java/lang/String:trim	()Ljava/lang/String;
    //   219: ldc_w 581
    //   222: invokevirtual 556	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   225: ifeq +240 -> 465
    //   228: iconst_1
    //   229: invokestatic 613	com/tencent/tmassistantbase/a/m:b	(Z)V
    //   232: ldc_w 286
    //   235: new 288	java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial 289	java/lang/StringBuilder:<init>	()V
    //   242: ldc_w 615
    //   245: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: aload_1
    //   249: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: ldc_w 617
    //   255: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: aload_2
    //   259: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: ldc_w 619
    //   265: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: aload_3
    //   269: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: ldc_w 621
    //   275: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: aload 4
    //   280: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: ldc_w 623
    //   286: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: aload 5
    //   291: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: ldc_w 625
    //   297: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: invokestatic 176	com/tencent/tmassistantbase/a/m:e	()Z
    //   303: invokevirtual 519	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   306: ldc_w 627
    //   309: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: invokestatic 364	com/tencent/tmassistantbase/a/m:f	()Z
    //   315: invokevirtual 519	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   318: invokevirtual 302	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: invokestatic 185	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   324: pop
    //   325: ldc_w 286
    //   328: new 288	java/lang/StringBuilder
    //   331: dup
    //   332: invokespecial 289	java/lang/StringBuilder:<init>	()V
    //   335: ldc_w 629
    //   338: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: invokestatic 350	com/tencent/tmassistantbase/a/m:g	()Z
    //   344: invokevirtual 519	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   347: ldc_w 617
    //   350: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: invokestatic 171	com/tencent/tmassistantbase/a/m:c	()I
    //   356: invokevirtual 375	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   359: ldc_w 619
    //   362: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: invokestatic 173	com/tencent/tmassistantbase/a/m:b	()I
    //   368: invokevirtual 375	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   371: ldc_w 621
    //   374: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: invokestatic 485	com/tencent/tmassistantbase/a/m:h	()Ljava/lang/String;
    //   380: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: ldc_w 623
    //   386: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: invokestatic 420	com/tencent/tmassistantbase/a/m:d	()Z
    //   392: invokevirtual 519	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   395: ldc_w 625
    //   398: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: invokestatic 176	com/tencent/tmassistantbase/a/m:e	()Z
    //   404: invokevirtual 519	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   407: ldc_w 627
    //   410: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: invokestatic 364	com/tencent/tmassistantbase/a/m:f	()Z
    //   416: invokevirtual 519	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   419: invokevirtual 302	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: invokestatic 185	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   425: pop
    //   426: return
    //   427: astore_0
    //   428: aload_0
    //   429: invokevirtual 410	java/io/IOException:printStackTrace	()V
    //   432: return
    //   433: iconst_0
    //   434: invokestatic 583	com/tencent/tmassistantbase/a/m:c	(Z)V
    //   437: goto -337 -> 100
    //   440: astore_3
    //   441: aload_3
    //   442: invokevirtual 630	java/lang/NumberFormatException:printStackTrace	()V
    //   445: goto -314 -> 131
    //   448: astore 4
    //   450: aload 4
    //   452: invokevirtual 630	java/lang/NumberFormatException:printStackTrace	()V
    //   455: goto -293 -> 162
    //   458: iconst_1
    //   459: invokestatic 609	com/tencent/tmassistantbase/a/m:a	(Z)V
    //   462: goto -255 -> 207
    //   465: iconst_0
    //   466: invokestatic 613	com/tencent/tmassistantbase/a/m:b	(Z)V
    //   469: goto -237 -> 232
    //   472: iconst_0
    //   473: invokestatic 583	com/tencent/tmassistantbase/a/m:c	(Z)V
    //   476: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   19	189	0	localProperties	java.util.Properties
    //   427	2	0	localIOException	IOException
    //   52	197	1	localObject	Object
    //   109	150	2	str1	String
    //   140	129	3	str2	String
    //   440	2	3	localNumberFormatException1	NumberFormatException
    //   171	108	4	str3	String
    //   448	3	4	localNumberFormatException2	NumberFormatException
    //   187	103	5	str4	String
    //   114	34	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   20	60	427	java/io/IOException
    //   61	100	427	java/io/IOException
    //   100	116	427	java/io/IOException
    //   121	131	427	java/io/IOException
    //   131	147	427	java/io/IOException
    //   152	162	427	java/io/IOException
    //   162	207	427	java/io/IOException
    //   207	232	427	java/io/IOException
    //   232	426	427	java/io/IOException
    //   433	437	427	java/io/IOException
    //   441	445	427	java/io/IOException
    //   450	455	427	java/io/IOException
    //   458	462	427	java/io/IOException
    //   465	469	427	java/io/IOException
    //   121	131	440	java/lang/NumberFormatException
    //   152	162	448	java/lang/NumberFormatException
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmassistantbase\a\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */