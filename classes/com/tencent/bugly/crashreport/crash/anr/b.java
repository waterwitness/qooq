package com.tencent.bugly.crashreport.crash.anr;

import android.app.ActivityManager;
import android.app.ActivityManager.ProcessErrorStateInfo;
import android.content.Context;
import android.os.FileObserver;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.v;
import com.tencent.bugly.proguard.w;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public final class b
{
  private AtomicInteger a = new AtomicInteger(0);
  private long b = -1L;
  private final Context c;
  private final com.tencent.bugly.crashreport.common.info.a d;
  private final u e;
  private final com.tencent.bugly.crashreport.common.strategy.a f;
  private final String g;
  private final com.tencent.bugly.crashreport.crash.b h;
  private FileObserver i;
  private boolean j = true;
  
  public b(Context paramContext, com.tencent.bugly.crashreport.common.strategy.a parama, com.tencent.bugly.crashreport.common.info.a parama1, u paramu, com.tencent.bugly.crashreport.crash.b paramb)
  {
    Object localObject;
    if (paramContext == null) {
      localObject = paramContext;
    }
    for (;;)
    {
      this.c = ((Context)localObject);
      this.g = paramContext.getDir("bugly", 0).getAbsolutePath();
      this.d = parama1;
      this.e = paramu;
      this.f = parama;
      this.h = paramb;
      return;
      Context localContext = paramContext.getApplicationContext();
      localObject = localContext;
      if (localContext == null) {
        localObject = paramContext;
      }
    }
  }
  
  private static ActivityManager.ProcessErrorStateInfo a(Context paramContext, long paramLong)
  {
    int k;
    if (10000L < 0L)
    {
      paramLong = 0L;
      v.c("to find!", new Object[0]);
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      paramLong /= 500L;
      k = 0;
    }
    for (;;)
    {
      v.c("waiting!", new Object[0]);
      Object localObject = paramContext.getProcessesInErrorState();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            ActivityManager.ProcessErrorStateInfo localProcessErrorStateInfo = (ActivityManager.ProcessErrorStateInfo)((Iterator)localObject).next();
            if (localProcessErrorStateInfo.condition == 2)
            {
              v.c("found!", new Object[0]);
              return localProcessErrorStateInfo;
              paramLong = 10000L;
              break;
            }
          }
        }
      }
      try
      {
        Thread.sleep(500L);
        if (k >= paramLong)
        {
          v.c("end!", new Object[0]);
          return null;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
        k += 1;
      }
    }
  }
  
  private CrashDetailBean a(a parama)
  {
    localCrashDetailBean = new CrashDetailBean();
    try
    {
      localCrashDetailBean.B = com.tencent.bugly.crashreport.common.info.b.h();
      localCrashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.f();
      localCrashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.j();
      localCrashDetailBean.E = this.d.n();
      localCrashDetailBean.F = this.d.m();
      localCrashDetailBean.G = this.d.o();
      localCrashDetailBean.w = com.tencent.bugly.proguard.a.a(this.c, c.d, c.g);
      localCrashDetailBean.x = w.a(true);
      localCrashDetailBean.b = 3;
      localCrashDetailBean.e = this.d.f();
      localCrashDetailBean.f = this.d.l;
      localCrashDetailBean.g = this.d.u();
      localCrashDetailBean.m = this.d.e();
      localCrashDetailBean.n = "ANR_EXCEPTION";
      localCrashDetailBean.o = parama.f;
      localCrashDetailBean.q = parama.g;
      localCrashDetailBean.N = new HashMap();
      localCrashDetailBean.N.put("BUGLY_CR_01", parama.e);
      int k = localCrashDetailBean.q.indexOf("\n");
      if (k > 0) {}
      for (String str = localCrashDetailBean.q.substring(0, k);; str = "GET_FAIL")
      {
        localCrashDetailBean.p = str;
        localCrashDetailBean.r = parama.c;
        localCrashDetailBean.u = com.tencent.bugly.proguard.a.c(localCrashDetailBean.q.getBytes());
        localCrashDetailBean.y = parama.b;
        localCrashDetailBean.z = this.d.d;
        localCrashDetailBean.A = "main(1)";
        localCrashDetailBean.H = this.d.w();
        localCrashDetailBean.h = this.d.t();
        localCrashDetailBean.i = this.d.E();
        localCrashDetailBean.v = parama.d;
        localCrashDetailBean.K = this.d.o;
        localCrashDetailBean.L = this.d.a;
        localCrashDetailBean.M = this.d.q;
        localCrashDetailBean.O = this.d.B();
        localCrashDetailBean.P = this.d.C();
        localCrashDetailBean.Q = this.d.x();
        localCrashDetailBean.R = this.d.A();
        return localCrashDetailBean;
      }
      return localCrashDetailBean;
    }
    catch (Throwable parama)
    {
      if (!v.a(parama)) {
        parama.printStackTrace();
      }
    }
  }
  
  private boolean a(Context paramContext, String paramString, ActivityManager.ProcessErrorStateInfo paramProcessErrorStateInfo, long paramLong, Map<String, String> paramMap)
  {
    this.f.c();
    int k;
    if (!this.f.b())
    {
      v.e("waiting for remote sync", new Object[0]);
      k = 0;
    }
    for (;;)
    {
      if (!this.f.b()) {}
      try
      {
        Thread.sleep(500L);
        int m = k + 500;
        k = m;
        if (m >= 3000)
        {
          Object localObject = new File(paramContext.getFilesDir(), "bugly/bugly_trace_" + paramLong + ".txt");
          paramContext = new a();
          paramContext.c = paramLong;
          paramContext.d = ((File)localObject).getAbsolutePath();
          paramContext.a = paramProcessErrorStateInfo.processName;
          paramContext.f = paramProcessErrorStateInfo.shortMsg;
          paramContext.e = paramProcessErrorStateInfo.longMsg;
          paramContext.b = paramMap;
          if (paramMap != null)
          {
            paramProcessErrorStateInfo = paramMap.keySet().iterator();
            while (paramProcessErrorStateInfo.hasNext())
            {
              localObject = (String)paramProcessErrorStateInfo.next();
              if (((String)localObject).startsWith("main(")) {
                paramContext.g = ((String)paramMap.get(localObject));
              }
            }
          }
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
        paramLong = paramContext.c;
        paramProcessErrorStateInfo = paramContext.d;
        paramMap = paramContext.a;
        String str1 = paramContext.f;
        String str2 = paramContext.e;
        if (paramContext.b == null) {}
        for (k = 0;; k = paramContext.b.size())
        {
          v.c("anr tm:%d\ntr:%s\nproc:%s\nsMsg:%s\n lMsg:%s\n threads:%d", new Object[] { Long.valueOf(paramLong), paramProcessErrorStateInfo, paramMap, str1, str2, Integer.valueOf(k) });
          if (this.f.b()) {
            break;
          }
          v.e("crash report sync remote fail, will not upload to Bugly , print local for helpful!", new Object[0]);
          com.tencent.bugly.crashreport.crash.b.a("ANR", com.tencent.bugly.proguard.a.d(), paramContext.a, null, paramContext.e, null);
          return false;
        }
        if (!this.f.c().j)
        {
          v.d("ANR Report is closed!", new Object[0]);
          return false;
        }
        v.a("found visiable anr , start to upload!", new Object[0]);
        paramProcessErrorStateInfo = a(paramContext);
        if (paramProcessErrorStateInfo == null)
        {
          v.e("pack anr fail!", new Object[0]);
          return false;
        }
        c.a().a(paramProcessErrorStateInfo);
        if (paramProcessErrorStateInfo.a < 0L) {
          break label569;
        }
      }
    }
    v.a("backup anr record success!", new Object[0]);
    for (;;)
    {
      if ((paramString != null) && (new File(paramString).exists()))
      {
        this.a.set(3);
        if (a(paramString, paramContext.d, paramContext.a)) {
          v.a("backup trace success", new Object[0]);
        }
      }
      com.tencent.bugly.crashreport.crash.b.a("ANR", com.tencent.bugly.proguard.a.d(), paramContext.a, null, paramContext.e, paramProcessErrorStateInfo);
      if (!this.h.a(paramProcessErrorStateInfo)) {
        this.h.a(paramProcessErrorStateInfo, 3000L, true);
      }
      this.h.b(paramProcessErrorStateInfo);
      return true;
      label569:
      v.d("backup anr record fail!", new Object[0]);
    }
  }
  
  /* Error */
  private static boolean a(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_2
    //   1: aload_0
    //   2: iconst_1
    //   3: invokestatic 512	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper:readTargetDumpInfo	(Ljava/lang/String;Ljava/lang/String;Z)Lcom/tencent/bugly/crashreport/crash/anr/TraceFileHelper$a;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +22 -> 30
    //   11: aload_3
    //   12: getfield 516	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper$a:d	Ljava/util/Map;
    //   15: ifnull +15 -> 30
    //   18: aload_3
    //   19: getfield 516	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper$a:d	Ljava/util/Map;
    //   22: invokeinterface 452 1 0
    //   27: ifgt +20 -> 47
    //   30: ldc_w 518
    //   33: iconst_1
    //   34: anewarray 4	java/lang/Object
    //   37: dup
    //   38: iconst_0
    //   39: aload_2
    //   40: aastore
    //   41: invokestatic 370	com/tencent/bugly/proguard/v:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   44: pop
    //   45: iconst_0
    //   46: ireturn
    //   47: new 58	java/io/File
    //   50: dup
    //   51: aload_1
    //   52: invokespecial 477	java/io/File:<init>	(Ljava/lang/String;)V
    //   55: astore_2
    //   56: aload_2
    //   57: invokevirtual 480	java/io/File:exists	()Z
    //   60: ifne +26 -> 86
    //   63: aload_2
    //   64: invokevirtual 521	java/io/File:getParentFile	()Ljava/io/File;
    //   67: invokevirtual 480	java/io/File:exists	()Z
    //   70: ifne +11 -> 81
    //   73: aload_2
    //   74: invokevirtual 521	java/io/File:getParentFile	()Ljava/io/File;
    //   77: invokevirtual 524	java/io/File:mkdirs	()Z
    //   80: pop
    //   81: aload_2
    //   82: invokevirtual 527	java/io/File:createNewFile	()Z
    //   85: pop
    //   86: aload_2
    //   87: invokevirtual 480	java/io/File:exists	()Z
    //   90: ifeq +10 -> 100
    //   93: aload_2
    //   94: invokevirtual 530	java/io/File:canWrite	()Z
    //   97: ifne +85 -> 182
    //   100: ldc_w 532
    //   103: iconst_1
    //   104: anewarray 4	java/lang/Object
    //   107: dup
    //   108: iconst_0
    //   109: aload_1
    //   110: aastore
    //   111: invokestatic 370	com/tencent/bugly/proguard/v:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   114: pop
    //   115: iconst_0
    //   116: ireturn
    //   117: astore_0
    //   118: aload_0
    //   119: invokestatic 357	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   122: ifne +7 -> 129
    //   125: aload_0
    //   126: invokevirtual 533	java/lang/Exception:printStackTrace	()V
    //   129: ldc_w 535
    //   132: iconst_2
    //   133: anewarray 4	java/lang/Object
    //   136: dup
    //   137: iconst_0
    //   138: new 376	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 536	java/lang/StringBuilder:<init>	()V
    //   145: aload_0
    //   146: invokevirtual 540	java/lang/Object:getClass	()Ljava/lang/Class;
    //   149: invokevirtual 545	java/lang/Class:getName	()Ljava/lang/String;
    //   152: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: ldc_w 547
    //   158: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload_0
    //   162: invokevirtual 550	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   165: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 393	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: aastore
    //   172: dup
    //   173: iconst_1
    //   174: aload_1
    //   175: aastore
    //   176: invokestatic 370	com/tencent/bugly/proguard/v:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   179: pop
    //   180: iconst_0
    //   181: ireturn
    //   182: aconst_null
    //   183: astore_0
    //   184: new 552	java/io/BufferedWriter
    //   187: dup
    //   188: new 554	java/io/FileWriter
    //   191: dup
    //   192: aload_2
    //   193: iconst_0
    //   194: invokespecial 557	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   197: invokespecial 560	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   200: astore_1
    //   201: aload_3
    //   202: getfield 516	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper$a:d	Ljava/util/Map;
    //   205: ldc_w 562
    //   208: invokeinterface 425 2 0
    //   213: checkcast 564	[Ljava/lang/String;
    //   216: astore 4
    //   218: aload 4
    //   220: ifnull +78 -> 298
    //   223: aload 4
    //   225: arraylength
    //   226: iconst_3
    //   227: if_icmplt +71 -> 298
    //   230: aload 4
    //   232: iconst_0
    //   233: aaload
    //   234: astore_0
    //   235: aload 4
    //   237: iconst_1
    //   238: aaload
    //   239: astore_2
    //   240: aload 4
    //   242: iconst_2
    //   243: aaload
    //   244: astore 4
    //   246: aload_1
    //   247: new 376	java/lang/StringBuilder
    //   250: dup
    //   251: ldc_w 566
    //   254: invokespecial 381	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   257: aload 4
    //   259: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: ldc_w 568
    //   265: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: aload_0
    //   269: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: ldc_w 256
    //   275: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: aload_2
    //   279: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: ldc_w 570
    //   285: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: invokevirtual 393	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   291: invokevirtual 573	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   294: aload_1
    //   295: invokevirtual 576	java/io/BufferedWriter:flush	()V
    //   298: aload_3
    //   299: getfield 516	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper$a:d	Ljava/util/Map;
    //   302: invokeinterface 579 1 0
    //   307: invokeinterface 415 1 0
    //   312: astore_0
    //   313: aload_0
    //   314: invokeinterface 117 1 0
    //   319: ifeq +239 -> 558
    //   322: aload_0
    //   323: invokeinterface 121 1 0
    //   328: checkcast 581	java/util/Map$Entry
    //   331: astore_2
    //   332: aload_2
    //   333: invokeinterface 584 1 0
    //   338: checkcast 258	java/lang/String
    //   341: ldc_w 562
    //   344: invokevirtual 588	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   347: ifne -34 -> 313
    //   350: aload_2
    //   351: invokeinterface 591 1 0
    //   356: ifnull -43 -> 313
    //   359: aload_2
    //   360: invokeinterface 591 1 0
    //   365: checkcast 564	[Ljava/lang/String;
    //   368: arraylength
    //   369: iconst_3
    //   370: if_icmplt -57 -> 313
    //   373: aload_2
    //   374: invokeinterface 591 1 0
    //   379: checkcast 564	[Ljava/lang/String;
    //   382: iconst_0
    //   383: aaload
    //   384: astore_3
    //   385: aload_2
    //   386: invokeinterface 591 1 0
    //   391: checkcast 564	[Ljava/lang/String;
    //   394: iconst_1
    //   395: aaload
    //   396: astore 4
    //   398: aload_2
    //   399: invokeinterface 591 1 0
    //   404: checkcast 564	[Ljava/lang/String;
    //   407: iconst_2
    //   408: aaload
    //   409: astore 5
    //   411: aload_1
    //   412: new 376	java/lang/StringBuilder
    //   415: dup
    //   416: ldc_w 593
    //   419: invokespecial 381	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   422: aload_2
    //   423: invokeinterface 584 1 0
    //   428: checkcast 258	java/lang/String
    //   431: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: ldc_w 595
    //   437: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: aload 5
    //   442: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: ldc_w 568
    //   448: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: aload_3
    //   452: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: ldc_w 256
    //   458: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: aload 4
    //   463: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: ldc_w 570
    //   469: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: invokevirtual 393	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   475: invokevirtual 573	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   478: aload_1
    //   479: invokevirtual 576	java/io/BufferedWriter:flush	()V
    //   482: goto -169 -> 313
    //   485: astore_2
    //   486: aload_1
    //   487: astore_0
    //   488: aload_2
    //   489: astore_1
    //   490: aload_1
    //   491: invokestatic 357	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   494: ifne +7 -> 501
    //   497: aload_1
    //   498: invokevirtual 596	java/io/IOException:printStackTrace	()V
    //   501: ldc_w 598
    //   504: iconst_1
    //   505: anewarray 4	java/lang/Object
    //   508: dup
    //   509: iconst_0
    //   510: new 376	java/lang/StringBuilder
    //   513: dup
    //   514: invokespecial 536	java/lang/StringBuilder:<init>	()V
    //   517: aload_1
    //   518: invokevirtual 540	java/lang/Object:getClass	()Ljava/lang/Class;
    //   521: invokevirtual 545	java/lang/Class:getName	()Ljava/lang/String;
    //   524: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: ldc_w 547
    //   530: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: aload_1
    //   534: invokevirtual 599	java/io/IOException:getMessage	()Ljava/lang/String;
    //   537: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: invokevirtual 393	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   543: aastore
    //   544: invokestatic 370	com/tencent/bugly/proguard/v:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   547: pop
    //   548: aload_0
    //   549: ifnull +7 -> 556
    //   552: aload_0
    //   553: invokevirtual 602	java/io/BufferedWriter:close	()V
    //   556: iconst_0
    //   557: ireturn
    //   558: aload_1
    //   559: invokevirtual 602	java/io/BufferedWriter:close	()V
    //   562: iconst_1
    //   563: ireturn
    //   564: astore_0
    //   565: aload_0
    //   566: invokestatic 357	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   569: ifne -7 -> 562
    //   572: aload_0
    //   573: invokevirtual 596	java/io/IOException:printStackTrace	()V
    //   576: goto -14 -> 562
    //   579: astore_0
    //   580: aload_0
    //   581: invokestatic 357	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   584: ifne -28 -> 556
    //   587: aload_0
    //   588: invokevirtual 596	java/io/IOException:printStackTrace	()V
    //   591: goto -35 -> 556
    //   594: astore_0
    //   595: aconst_null
    //   596: astore_1
    //   597: aload_1
    //   598: ifnull +7 -> 605
    //   601: aload_1
    //   602: invokevirtual 602	java/io/BufferedWriter:close	()V
    //   605: aload_0
    //   606: athrow
    //   607: astore_1
    //   608: aload_1
    //   609: invokestatic 357	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   612: ifne -7 -> 605
    //   615: aload_1
    //   616: invokevirtual 596	java/io/IOException:printStackTrace	()V
    //   619: goto -14 -> 605
    //   622: astore_0
    //   623: goto -26 -> 597
    //   626: astore_2
    //   627: aload_0
    //   628: astore_1
    //   629: aload_2
    //   630: astore_0
    //   631: goto -34 -> 597
    //   634: astore_1
    //   635: goto -145 -> 490
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	638	0	paramString1	String
    //   0	638	1	paramString2	String
    //   0	638	2	paramString3	String
    //   6	446	3	localObject1	Object
    //   216	246	4	localObject2	Object
    //   409	32	5	str	String
    // Exception table:
    //   from	to	target	type
    //   56	81	117	java/lang/Exception
    //   81	86	117	java/lang/Exception
    //   201	218	485	java/io/IOException
    //   223	230	485	java/io/IOException
    //   246	298	485	java/io/IOException
    //   298	313	485	java/io/IOException
    //   313	482	485	java/io/IOException
    //   558	562	564	java/io/IOException
    //   552	556	579	java/io/IOException
    //   184	201	594	finally
    //   601	605	607	java/io/IOException
    //   201	218	622	finally
    //   223	230	622	finally
    //   246	298	622	finally
    //   298	313	622	finally
    //   313	482	622	finally
    //   490	501	626	finally
    //   501	548	626	finally
    //   184	201	634	java/io/IOException
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        c();
        return;
      }
      finally {}
      d();
    }
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 609	com/tencent/bugly/crashreport/crash/anr/b:e	()Z
    //   6: ifeq +17 -> 23
    //   9: ldc_w 611
    //   12: iconst_0
    //   13: anewarray 4	java/lang/Object
    //   16: invokestatic 459	com/tencent/bugly/proguard/v:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   19: pop
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: new 6	com/tencent/bugly/crashreport/crash/anr/b$1
    //   27: dup
    //   28: aload_0
    //   29: ldc_w 613
    //   32: bipush 8
    //   34: invokespecial 616	com/tencent/bugly/crashreport/crash/anr/b$1:<init>	(Lcom/tencent/bugly/crashreport/crash/anr/b;Ljava/lang/String;I)V
    //   37: putfield 618	com/tencent/bugly/crashreport/crash/anr/b:i	Landroid/os/FileObserver;
    //   40: aload_0
    //   41: getfield 618	com/tencent/bugly/crashreport/crash/anr/b:i	Landroid/os/FileObserver;
    //   44: invokevirtual 623	android/os/FileObserver:startWatching	()V
    //   47: ldc_w 625
    //   50: iconst_0
    //   51: anewarray 4	java/lang/Object
    //   54: invokestatic 463	com/tencent/bugly/proguard/v:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   57: pop
    //   58: aload_0
    //   59: getfield 68	com/tencent/bugly/crashreport/crash/anr/b:e	Lcom/tencent/bugly/proguard/u;
    //   62: new 8	com/tencent/bugly/crashreport/crash/anr/b$2
    //   65: dup
    //   66: aload_0
    //   67: invokespecial 628	com/tencent/bugly/crashreport/crash/anr/b$2:<init>	(Lcom/tencent/bugly/crashreport/crash/anr/b;)V
    //   70: invokevirtual 633	com/tencent/bugly/proguard/u:b	(Ljava/lang/Runnable;)Z
    //   73: pop
    //   74: goto -54 -> 20
    //   77: astore_1
    //   78: aload_0
    //   79: aconst_null
    //   80: putfield 618	com/tencent/bugly/crashreport/crash/anr/b:i	Landroid/os/FileObserver;
    //   83: ldc_w 635
    //   86: iconst_0
    //   87: anewarray 4	java/lang/Object
    //   90: invokestatic 459	com/tencent/bugly/proguard/v:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   93: pop
    //   94: aload_1
    //   95: invokestatic 357	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   98: ifne -78 -> 20
    //   101: aload_1
    //   102: invokevirtual 358	java/lang/Throwable:printStackTrace	()V
    //   105: goto -85 -> 20
    //   108: astore_1
    //   109: aload_0
    //   110: monitorexit
    //   111: aload_1
    //   112: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	b
    //   77	25	1	localThrowable	Throwable
    //   108	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   40	74	77	java/lang/Throwable
    //   2	20	108	finally
    //   23	40	108	finally
    //   40	74	108	finally
    //   78	105	108	finally
  }
  
  private void c(boolean paramBoolean)
  {
    try
    {
      if (this.j != paramBoolean)
      {
        v.a("user change anr %b", new Object[] { Boolean.valueOf(paramBoolean) });
        this.j = paramBoolean;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  private void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 609	com/tencent/bugly/crashreport/crash/anr/b:e	()Z
    //   6: ifne +17 -> 23
    //   9: ldc_w 644
    //   12: iconst_0
    //   13: anewarray 4	java/lang/Object
    //   16: invokestatic 459	com/tencent/bugly/proguard/v:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   19: pop
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: getfield 618	com/tencent/bugly/crashreport/crash/anr/b:i	Landroid/os/FileObserver;
    //   27: invokevirtual 647	android/os/FileObserver:stopWatching	()V
    //   30: aload_0
    //   31: aconst_null
    //   32: putfield 618	com/tencent/bugly/crashreport/crash/anr/b:i	Landroid/os/FileObserver;
    //   35: ldc_w 649
    //   38: iconst_0
    //   39: anewarray 4	java/lang/Object
    //   42: invokestatic 459	com/tencent/bugly/proguard/v:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   45: pop
    //   46: goto -26 -> 20
    //   49: astore_1
    //   50: ldc_w 651
    //   53: iconst_0
    //   54: anewarray 4	java/lang/Object
    //   57: invokestatic 459	com/tencent/bugly/proguard/v:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   60: pop
    //   61: aload_1
    //   62: invokestatic 357	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   65: ifne -45 -> 20
    //   68: aload_1
    //   69: invokevirtual 358	java/lang/Throwable:printStackTrace	()V
    //   72: goto -52 -> 20
    //   75: astore_1
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_1
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	b
    //   49	20	1	localThrowable	Throwable
    //   75	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   23	46	49	java/lang/Throwable
    //   2	20	75	finally
    //   23	46	75	finally
    //   50	72	75	finally
  }
  
  /* Error */
  private boolean e()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 618	com/tencent/bugly/crashreport/crash/anr/b:i	Landroid/os/FileObserver;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +9 -> 17
    //   11: iconst_1
    //   12: istore_2
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_2
    //   16: ireturn
    //   17: iconst_0
    //   18: istore_2
    //   19: goto -6 -> 13
    //   22: astore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_1
    //   26: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	b
    //   6	2	1	localFileObserver	FileObserver
    //   22	4	1	localObject	Object
    //   12	7	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
  
  private boolean f()
  {
    try
    {
      boolean bool = this.j;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public final void a(StrategyBean paramStrategyBean)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_1
    //   5: ifnull +35 -> 40
    //   8: aload_1
    //   9: getfield 455	com/tencent/bugly/crashreport/common/strategy/StrategyBean:j	Z
    //   12: aload_0
    //   13: invokespecial 609	com/tencent/bugly/crashreport/crash/anr/b:e	()Z
    //   16: if_icmpeq +24 -> 40
    //   19: ldc_w 654
    //   22: iconst_1
    //   23: anewarray 4	java/lang/Object
    //   26: dup
    //   27: iconst_0
    //   28: aload_1
    //   29: getfield 455	com/tencent/bugly/crashreport/common/strategy/StrategyBean:j	Z
    //   32: invokestatic 642	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   35: aastore
    //   36: invokestatic 459	com/tencent/bugly/proguard/v:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   39: pop
    //   40: aload_1
    //   41: getfield 455	com/tencent/bugly/crashreport/common/strategy/StrategyBean:j	Z
    //   44: ifeq +44 -> 88
    //   47: aload_0
    //   48: invokespecial 656	com/tencent/bugly/crashreport/crash/anr/b:f	()Z
    //   51: ifeq +37 -> 88
    //   54: iload_2
    //   55: aload_0
    //   56: invokespecial 609	com/tencent/bugly/crashreport/crash/anr/b:e	()Z
    //   59: if_icmpeq +26 -> 85
    //   62: ldc_w 658
    //   65: iconst_1
    //   66: anewarray 4	java/lang/Object
    //   69: dup
    //   70: iconst_0
    //   71: iload_2
    //   72: invokestatic 642	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   75: aastore
    //   76: invokestatic 463	com/tencent/bugly/proguard/v:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   79: pop
    //   80: aload_0
    //   81: iload_2
    //   82: invokespecial 660	com/tencent/bugly/crashreport/crash/anr/b:b	(Z)V
    //   85: aload_0
    //   86: monitorexit
    //   87: return
    //   88: iconst_0
    //   89: istore_2
    //   90: goto -36 -> 54
    //   93: astore_1
    //   94: aload_0
    //   95: monitorexit
    //   96: aload_1
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	b
    //   0	98	1	paramStrategyBean	StrategyBean
    //   1	89	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   8	40	93	finally
    //   40	54	93	finally
    //   54	85	93	finally
  }
  
  /* Error */
  public final void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 40	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   6: invokevirtual 662	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   9: ifeq +17 -> 26
    //   12: ldc_w 664
    //   15: iconst_0
    //   16: anewarray 4	java/lang/Object
    //   19: invokestatic 89	com/tencent/bugly/proguard/v:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   22: pop
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: aload_0
    //   27: getfield 40	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   30: iconst_1
    //   31: invokevirtual 483	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   34: aload_0
    //   35: monitorexit
    //   36: ldc_w 666
    //   39: iconst_0
    //   40: anewarray 4	java/lang/Object
    //   43: invokestatic 89	com/tencent/bugly/proguard/v:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   46: pop
    //   47: aload_1
    //   48: iconst_0
    //   49: invokestatic 670	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper:readFirstDumpInfo	(Ljava/lang/String;Z)Lcom/tencent/bugly/crashreport/crash/anr/TraceFileHelper$a;
    //   52: astore_2
    //   53: aload_2
    //   54: ifnull +329 -> 383
    //   57: aload_2
    //   58: getfield 671	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper$a:c	J
    //   61: lstore 4
    //   63: lload 4
    //   65: lstore 6
    //   67: lload 4
    //   69: ldc2_w 41
    //   72: lcmp
    //   73: ifne +19 -> 92
    //   76: ldc_w 673
    //   79: iconst_0
    //   80: anewarray 4	java/lang/Object
    //   83: invokestatic 459	com/tencent/bugly/proguard/v:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   86: pop
    //   87: invokestatic 678	java/lang/System:currentTimeMillis	()J
    //   90: lstore 6
    //   92: lload 6
    //   94: aload_0
    //   95: getfield 44	com/tencent/bugly/crashreport/crash/anr/b:b	J
    //   98: lsub
    //   99: invokestatic 684	java/lang/Math:abs	(J)J
    //   102: ldc2_w 81
    //   105: lcmp
    //   106: ifge +37 -> 143
    //   109: ldc_w 686
    //   112: iconst_1
    //   113: anewarray 4	java/lang/Object
    //   116: dup
    //   117: iconst_0
    //   118: sipush 10000
    //   121: invokestatic 438	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   124: aastore
    //   125: invokestatic 459	com/tencent/bugly/proguard/v:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   128: pop
    //   129: aload_0
    //   130: getfield 40	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   133: iconst_0
    //   134: invokevirtual 483	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   137: return
    //   138: astore_1
    //   139: aload_0
    //   140: monitorexit
    //   141: aload_1
    //   142: athrow
    //   143: aload_0
    //   144: lload 6
    //   146: putfield 44	com/tencent/bugly/crashreport/crash/anr/b:b	J
    //   149: aload_0
    //   150: getfield 40	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   153: iconst_1
    //   154: invokevirtual 483	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   157: getstatic 688	com/tencent/bugly/crashreport/crash/c:e	I
    //   160: iconst_0
    //   161: invokestatic 691	com/tencent/bugly/proguard/a:a	(IZ)Ljava/util/Map;
    //   164: astore_2
    //   165: aload_2
    //   166: ifnull +12 -> 178
    //   169: aload_2
    //   170: invokeinterface 452 1 0
    //   175: ifgt +49 -> 224
    //   178: ldc_w 693
    //   181: iconst_0
    //   182: anewarray 4	java/lang/Object
    //   185: invokestatic 459	com/tencent/bugly/proguard/v:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   188: pop
    //   189: aload_0
    //   190: getfield 40	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   193: iconst_0
    //   194: invokevirtual 483	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   197: return
    //   198: astore_1
    //   199: aload_1
    //   200: invokestatic 357	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   203: pop
    //   204: ldc_w 695
    //   207: iconst_0
    //   208: anewarray 4	java/lang/Object
    //   211: invokestatic 370	com/tencent/bugly/proguard/v:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   214: pop
    //   215: aload_0
    //   216: getfield 40	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   219: iconst_0
    //   220: invokevirtual 483	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   223: return
    //   224: aload_0
    //   225: getfield 48	com/tencent/bugly/crashreport/crash/anr/b:c	Landroid/content/Context;
    //   228: ldc2_w 81
    //   231: invokestatic 697	com/tencent/bugly/crashreport/crash/anr/b:a	(Landroid/content/Context;J)Landroid/app/ActivityManager$ProcessErrorStateInfo;
    //   234: astore_3
    //   235: aload_3
    //   236: ifnonnull +23 -> 259
    //   239: ldc_w 699
    //   242: iconst_0
    //   243: anewarray 4	java/lang/Object
    //   246: invokestatic 89	com/tencent/bugly/proguard/v:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   249: pop
    //   250: aload_0
    //   251: getfield 40	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   254: iconst_0
    //   255: invokevirtual 483	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   258: return
    //   259: aload_3
    //   260: getfield 702	android/app/ActivityManager$ProcessErrorStateInfo:pid	I
    //   263: invokestatic 707	android/os/Process:myPid	()I
    //   266: if_icmpeq +30 -> 296
    //   269: ldc_w 709
    //   272: iconst_1
    //   273: anewarray 4	java/lang/Object
    //   276: dup
    //   277: iconst_0
    //   278: aload_3
    //   279: getfield 400	android/app/ActivityManager$ProcessErrorStateInfo:processName	Ljava/lang/String;
    //   282: aastore
    //   283: invokestatic 89	com/tencent/bugly/proguard/v:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   286: pop
    //   287: aload_0
    //   288: getfield 40	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   291: iconst_0
    //   292: invokevirtual 483	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   295: return
    //   296: ldc_w 711
    //   299: iconst_0
    //   300: anewarray 4	java/lang/Object
    //   303: invokestatic 463	com/tencent/bugly/proguard/v:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   306: pop
    //   307: aload_0
    //   308: aload_0
    //   309: getfield 48	com/tencent/bugly/crashreport/crash/anr/b:c	Landroid/content/Context;
    //   312: aload_1
    //   313: aload_3
    //   314: lload 6
    //   316: aload_2
    //   317: invokespecial 713	com/tencent/bugly/crashreport/crash/anr/b:a	(Landroid/content/Context;Ljava/lang/String;Landroid/app/ActivityManager$ProcessErrorStateInfo;JLjava/util/Map;)Z
    //   320: pop
    //   321: aload_0
    //   322: getfield 40	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   325: iconst_0
    //   326: invokevirtual 483	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   329: return
    //   330: astore_1
    //   331: aload_1
    //   332: invokestatic 357	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   335: ifne +7 -> 342
    //   338: aload_1
    //   339: invokevirtual 358	java/lang/Throwable:printStackTrace	()V
    //   342: ldc_w 715
    //   345: iconst_1
    //   346: anewarray 4	java/lang/Object
    //   349: dup
    //   350: iconst_0
    //   351: aload_1
    //   352: invokevirtual 540	java/lang/Object:getClass	()Ljava/lang/Class;
    //   355: invokevirtual 716	java/lang/Class:toString	()Ljava/lang/String;
    //   358: aastore
    //   359: invokestatic 370	com/tencent/bugly/proguard/v:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   362: pop
    //   363: aload_0
    //   364: getfield 40	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   367: iconst_0
    //   368: invokevirtual 483	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   371: return
    //   372: astore_1
    //   373: aload_0
    //   374: getfield 40	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   377: iconst_0
    //   378: invokevirtual 483	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   381: aload_1
    //   382: athrow
    //   383: ldc2_w 41
    //   386: lstore 4
    //   388: goto -325 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	391	0	this	b
    //   0	391	1	paramString	String
    //   52	265	2	localObject	Object
    //   234	80	3	localProcessErrorStateInfo	ActivityManager.ProcessErrorStateInfo
    //   61	326	4	l1	long
    //   65	250	6	l2	long
    // Exception table:
    //   from	to	target	type
    //   2	25	138	finally
    //   26	36	138	finally
    //   157	165	198	java/lang/Throwable
    //   36	53	330	java/lang/Throwable
    //   57	63	330	java/lang/Throwable
    //   76	92	330	java/lang/Throwable
    //   92	129	330	java/lang/Throwable
    //   143	157	330	java/lang/Throwable
    //   169	178	330	java/lang/Throwable
    //   178	189	330	java/lang/Throwable
    //   199	215	330	java/lang/Throwable
    //   224	235	330	java/lang/Throwable
    //   239	250	330	java/lang/Throwable
    //   259	287	330	java/lang/Throwable
    //   296	321	330	java/lang/Throwable
    //   36	53	372	finally
    //   57	63	372	finally
    //   76	92	372	finally
    //   92	129	372	finally
    //   143	157	372	finally
    //   157	165	372	finally
    //   169	178	372	finally
    //   178	189	372	finally
    //   199	215	372	finally
    //   224	235	372	finally
    //   239	250	372	finally
    //   259	287	372	finally
    //   296	321	372	finally
    //   331	342	372	finally
    //   342	363	372	finally
  }
  
  public final void a(boolean paramBoolean)
  {
    c(paramBoolean);
    if ((com.tencent.bugly.crashreport.common.strategy.a.a().c().j) && (f())) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      if (paramBoolean != e())
      {
        v.a("anr changed to %b", new Object[] { Boolean.valueOf(paramBoolean) });
        b(paramBoolean);
      }
      return;
    }
  }
  
  public final boolean a()
  {
    return this.a.get() != 0;
  }
  
  protected final void b()
  {
    long l1 = com.tencent.bugly.proguard.a.e();
    long l2 = c.f;
    Object localObject1 = new File(this.g);
    if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
    {
      localObject1 = ((File)localObject1).listFiles();
      if ((localObject1 != null) && (localObject1.length != 0)) {}
    }
    else
    {
      return;
    }
    int i1 = "bugly_trace_".length();
    int i2 = localObject1.length;
    int k = 0;
    Object localObject2;
    String str;
    int n;
    for (int m = 0;; m = n)
    {
      if (k >= i2) {
        break label192;
      }
      localObject2 = localObject1[k];
      str = ((File)localObject2).getName();
      n = m;
      if (str.startsWith("bugly_trace_")) {}
      try
      {
        n = str.indexOf(".txt");
        if (n <= 0) {
          break;
        }
        long l3 = Long.parseLong(str.substring(i1, n));
        if (l3 < l1 - l2) {
          break;
        }
        n = m;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          v.e("tomb format error delete %s", new Object[] { str });
          n = m;
          if (((File)localObject2).delete()) {
            n = m + 1;
          }
        }
      }
      k += 1;
    }
    label192:
    v.c("clean tombs %d", new Object[] { Integer.valueOf(m) });
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\bugly\crashreport\crash\anr\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */