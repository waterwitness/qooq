package ct;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArraySet;

public final class e
  implements a, n, Runnable
{
  private Set a = null;
  private BlockingQueue b = null;
  private q c;
  
  public e()
  {
    bc.a();
    this.a = new CopyOnWriteArraySet();
    this.a.add("dispatcher.3g.qq.com");
    this.b = new ArrayBlockingQueue(10);
    this.c = r.a();
    try
    {
      if (c()) {
        a(true);
      }
      for (;;)
      {
        Object localObject1 = j.a();
        ((j)localObject1).a = this;
        Object localObject2 = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        p.a().registerReceiver(((j)localObject1).b, (IntentFilter)localObject2);
        bc.b();
        bc.b();
        localObject2 = new IntentFilter("action.scheduler.access.trigger.timer");
        p.a().registerReceiver(((j)localObject1).c, (IntentFilter)localObject2);
        localObject1 = (AlarmManager)p.a().getSystemService("alarm");
        if (localObject1 != null)
        {
          long l = System.currentTimeMillis();
          localObject2 = new Intent("action.scheduler.access.trigger.timer");
          ((AlarmManager)localObject1).setRepeating(3, l + 1200000L, 1200000L, PendingIntent.getBroadcast(p.a(), 0, (Intent)localObject2, 0));
          bc.a();
        }
        return;
        a(false);
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  private void a(boolean paramBoolean)
  {
    try
    {
      new StringBuilder("before add, queue size:").append(this.b.size());
      bc.a();
      this.b.add(new i(paramBoolean));
      bc.a();
      new StringBuilder("after add, queue size:").append(this.b.size());
      bc.a();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        bc.d();
      }
    }
  }
  
  private static boolean c()
  {
    boolean bool2 = false;
    try
    {
      SharedPreferences localSharedPreferences = p.a().getSharedPreferences("Access_Preferences", 0);
      boolean bool1 = bool2;
      if (localSharedPreferences != null)
      {
        long l = localSharedPreferences.getLong("lastScheduleTime", 0L);
        bool1 = bool2;
        if (System.currentTimeMillis() - l > 86400000L)
        {
          localSharedPreferences.edit().putLong("lastScheduleTime", System.currentTimeMillis()).commit();
          bc.a();
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public final an a()
  {
    return b.a().b.f;
  }
  
  public final t.a a(String paramString)
  {
    if (this.a.contains(paramString))
    {
      t.a locala = u.a().a(paramString);
      if (locala != null)
      {
        paramString = locala;
        if (!locala.b()) {
          return paramString;
        }
        bc.c();
        a(true);
      }
    }
    paramString = null;
    return paramString;
  }
  
  public final void a(List paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      try
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          String str = (String)paramList.next();
          this.a.add(str);
        }
        return;
      }
      catch (Exception paramList) {}
    }
  }
  
  public final void b()
  {
    bc.b();
    a(false);
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: invokestatic 90	ct/bc:b	()V
    //   3: invokestatic 207	ct/u:a	()Lct/u;
    //   6: pop
    //   7: invokestatic 30	ct/bc:a	()V
    //   10: aload_0
    //   11: getfield 26	ct/e:b	Ljava/util/concurrent/BlockingQueue;
    //   14: invokeinterface 237 1 0
    //   19: checkcast 143	ct/i
    //   22: astore_1
    //   23: invokestatic 30	ct/bc:a	()V
    //   26: aload_1
    //   27: getfield 240	ct/i:a	Z
    //   30: istore 6
    //   32: invokestatic 90	ct/bc:b	()V
    //   35: invokestatic 245	ct/bb:a	()Ljava/lang/String;
    //   38: astore_1
    //   39: aload_1
    //   40: invokestatic 251	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   43: ifne +12 -> 55
    //   46: aload_1
    //   47: ldc -3
    //   49: invokevirtual 256	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   52: ifeq +9 -> 61
    //   55: invokestatic 215	ct/bc:c	()V
    //   58: goto -51 -> 7
    //   61: getstatic 259	ct/h:a	Z
    //   64: ifne +15 -> 79
    //   67: invokestatic 90	ct/bc:b	()V
    //   70: goto -63 -> 7
    //   73: astore_1
    //   74: aload_1
    //   75: invokevirtual 151	java/lang/Throwable:printStackTrace	()V
    //   78: return
    //   79: iload 6
    //   81: ifne +44 -> 125
    //   84: invokestatic 207	ct/u:a	()Lct/u;
    //   87: aload_0
    //   88: getfield 24	ct/e:a	Ljava/util/Set;
    //   91: invokevirtual 262	ct/u:a	(Ljava/util/Set;)Z
    //   94: istore 6
    //   96: invokestatic 56	ct/e:c	()Z
    //   99: istore 7
    //   101: iload 6
    //   103: ifne +382 -> 485
    //   106: iload 7
    //   108: ifeq +383 -> 491
    //   111: goto +374 -> 485
    //   114: iload 5
    //   116: ifne +9 -> 125
    //   119: invokestatic 90	ct/bc:b	()V
    //   122: goto -115 -> 7
    //   125: new 264	ct/f
    //   128: dup
    //   129: invokespecial 265	ct/f:<init>	()V
    //   132: astore_1
    //   133: aload_1
    //   134: invokestatic 267	ct/p:b	()Ljava/lang/String;
    //   137: putfield 270	ct/f:b	Ljava/lang/String;
    //   140: aload_1
    //   141: invokestatic 272	ct/p:c	()Ljava/lang/String;
    //   144: putfield 274	ct/f:c	Ljava/lang/String;
    //   147: aload_1
    //   148: invokestatic 276	ct/p:d	()I
    //   151: putfield 279	ct/f:d	I
    //   154: aload_1
    //   155: invokestatic 281	ct/p:f	()Ljava/lang/String;
    //   158: putfield 283	ct/f:a	Ljava/lang/String;
    //   161: aload_1
    //   162: invokestatic 286	ct/p:e	()Ljava/lang/String;
    //   165: putfield 288	ct/f:e	Ljava/lang/String;
    //   168: aload_0
    //   169: getfield 24	ct/e:a	Ljava/util/Set;
    //   172: astore_2
    //   173: aload_1
    //   174: new 290	java/util/ArrayList
    //   177: dup
    //   178: invokespecial 291	java/util/ArrayList:<init>	()V
    //   181: putfield 295	ct/f:h	Ljava/util/ArrayList;
    //   184: aload_1
    //   185: getfield 295	ct/f:h	Ljava/util/ArrayList;
    //   188: aload_2
    //   189: invokevirtual 299	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   192: pop
    //   193: aload_1
    //   194: invokestatic 245	ct/bb:a	()Ljava/lang/String;
    //   197: putfield 302	ct/f:g	Ljava/lang/String;
    //   200: aload_1
    //   201: invokestatic 304	ct/bb:c	()I
    //   204: putfield 307	ct/f:i	I
    //   207: aload_1
    //   208: invokestatic 308	ct/bb:d	()I
    //   211: putfield 311	ct/f:j	I
    //   214: aload_1
    //   215: invokevirtual 314	ct/f:a	()Lct/g;
    //   218: astore_2
    //   219: aload_2
    //   220: ifnull +201 -> 421
    //   223: invokestatic 207	ct/u:a	()Lct/u;
    //   226: aload_2
    //   227: getfield 319	ct/g:a	Lct/t;
    //   230: invokevirtual 322	ct/u:a	(Lct/t;)V
    //   233: invokestatic 189	ct/b:a	()Lct/b;
    //   236: astore_3
    //   237: aload_2
    //   238: getfield 323	ct/g:b	Lct/d;
    //   241: astore 4
    //   243: aload 4
    //   245: ifnull +151 -> 396
    //   248: new 128	java/lang/StringBuilder
    //   251: dup
    //   252: ldc_w 325
    //   255: invokespecial 131	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   258: aload 4
    //   260: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: invokestatic 90	ct/bc:b	()V
    //   267: aload 4
    //   269: getfield 330	ct/d:a	I
    //   272: sipush 2000
    //   275: if_icmplt +14 -> 289
    //   278: aload 4
    //   280: getfield 330	ct/d:a	I
    //   283: ldc_w 331
    //   286: if_icmple +39 -> 325
    //   289: new 128	java/lang/StringBuilder
    //   292: dup
    //   293: ldc_w 333
    //   296: invokespecial 131	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   299: aload 4
    //   301: getfield 330	ct/d:a	I
    //   304: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   307: ldc_w 335
    //   310: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: pop
    //   314: invokestatic 215	ct/bc:c	()V
    //   317: aload 4
    //   319: sipush 20000
    //   322: putfield 330	ct/d:a	I
    //   325: aload 4
    //   327: getfield 340	ct/d:b	I
    //   330: sipush 2000
    //   333: if_icmplt +14 -> 347
    //   336: aload 4
    //   338: getfield 340	ct/d:b	I
    //   341: ldc_w 331
    //   344: if_icmple +39 -> 383
    //   347: new 128	java/lang/StringBuilder
    //   350: dup
    //   351: ldc_w 342
    //   354: invokespecial 131	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   357: aload 4
    //   359: getfield 340	ct/d:b	I
    //   362: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   365: ldc_w 335
    //   368: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: pop
    //   372: invokestatic 215	ct/bc:c	()V
    //   375: aload 4
    //   377: sipush 20000
    //   380: putfield 340	ct/d:b	I
    //   383: aload_3
    //   384: aload 4
    //   386: putfield 192	ct/b:b	Lct/d;
    //   389: aload_3
    //   390: getfield 192	ct/b:b	Lct/d;
    //   393: invokevirtual 343	ct/d:b	()V
    //   396: invokestatic 189	ct/b:a	()Lct/b;
    //   399: astore_3
    //   400: aload_2
    //   401: getfield 346	ct/g:c	Lct/c;
    //   404: astore_2
    //   405: aload_2
    //   406: ifnull +15 -> 421
    //   409: aload_3
    //   410: aload_2
    //   411: putfield 348	ct/b:a	Lct/c;
    //   414: aload_3
    //   415: getfield 348	ct/b:a	Lct/c;
    //   418: invokevirtual 351	ct/c:b	()V
    //   421: new 128	java/lang/StringBuilder
    //   424: dup
    //   425: ldc_w 353
    //   428: invokespecial 131	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   431: aload_1
    //   432: getfield 302	ct/f:g	Ljava/lang/String;
    //   435: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: ldc_w 355
    //   441: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: aload_1
    //   445: getfield 358	ct/f:k	I
    //   448: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   451: ldc_w 360
    //   454: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: aload_1
    //   458: getfield 363	ct/f:l	Ljava/lang/String;
    //   461: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: pop
    //   465: invokestatic 90	ct/bc:b	()V
    //   468: aload_0
    //   469: getfield 53	ct/e:c	Lct/q;
    //   472: aload_1
    //   473: invokeinterface 368 2 0
    //   478: goto -471 -> 7
    //   481: astore_1
    //   482: goto -475 -> 7
    //   485: iconst_1
    //   486: istore 5
    //   488: goto -374 -> 114
    //   491: iconst_0
    //   492: istore 5
    //   494: goto -380 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	497	0	this	e
    //   22	25	1	localObject1	Object
    //   73	2	1	localThrowable	Throwable
    //   132	341	1	localf	f
    //   481	1	1	localException	Exception
    //   172	239	2	localObject2	Object
    //   236	179	3	localb	b
    //   241	144	4	locald	d
    //   114	379	5	i	int
    //   30	72	6	bool1	boolean
    //   99	8	7	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   3	7	73	java/lang/Throwable
    //   7	32	73	java/lang/Throwable
    //   32	55	73	java/lang/Throwable
    //   55	58	73	java/lang/Throwable
    //   61	70	73	java/lang/Throwable
    //   84	101	73	java/lang/Throwable
    //   119	122	73	java/lang/Throwable
    //   125	219	73	java/lang/Throwable
    //   223	243	73	java/lang/Throwable
    //   248	289	73	java/lang/Throwable
    //   289	325	73	java/lang/Throwable
    //   325	347	73	java/lang/Throwable
    //   347	383	73	java/lang/Throwable
    //   383	396	73	java/lang/Throwable
    //   396	405	73	java/lang/Throwable
    //   409	421	73	java/lang/Throwable
    //   421	478	73	java/lang/Throwable
    //   32	55	481	java/lang/Exception
    //   55	58	481	java/lang/Exception
    //   61	70	481	java/lang/Exception
    //   84	101	481	java/lang/Exception
    //   119	122	481	java/lang/Exception
    //   125	219	481	java/lang/Exception
    //   223	243	481	java/lang/Exception
    //   248	289	481	java/lang/Exception
    //   289	325	481	java/lang/Exception
    //   325	347	481	java/lang/Exception
    //   347	383	481	java/lang/Exception
    //   383	396	481	java/lang/Exception
    //   396	405	481	java/lang/Exception
    //   409	421	481	java/lang/Exception
    //   421	478	481	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */