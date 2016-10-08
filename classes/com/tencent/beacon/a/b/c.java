package com.tencent.beacon.a.b;

import android.content.Context;
import com.tencent.beacon.a.f;
import com.tencent.beacon.d.a;
import com.tencent.beacon.upload.h;

public final class c
  implements Runnable
{
  private static long b = 0L;
  Context a = null;
  
  public c(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private static long a()
  {
    try
    {
      long l = b;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void a(long paramLong)
  {
    try
    {
      b = paramLong;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private static boolean a(Context paramContext, String paramString)
  {
    try
    {
      int i = Integer.parseInt(com.tencent.beacon.a.b.b(paramContext, "querytimes", "0"));
      if (!f.n().equals(paramString)) {
        i = 0;
      }
      if (i <= d.a().h())
      {
        com.tencent.beacon.a.b.d(paramContext, String.valueOf(i + 1));
        return false;
      }
      bool = true;
      a.c(" set init times failed! ", new Object[0]);
    }
    catch (Exception paramContext)
    {
      try
      {
        a.e(" sdk init max times", new Object[0]);
        return true;
      }
      catch (Exception paramContext)
      {
        boolean bool;
        for (;;) {}
      }
      paramContext = paramContext;
      bool = false;
    }
    return bool;
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 23	com/tencent/beacon/a/b/c:a	Landroid/content/Context;
    //   4: invokestatic 94	com/tencent/beacon/a/f:o	(Landroid/content/Context;)Lcom/tencent/beacon/a/b/g;
    //   7: astore_1
    //   8: aload_1
    //   9: ifnull +54 -> 63
    //   12: aload_1
    //   13: invokevirtual 98	com/tencent/beacon/a/b/g:b	()I
    //   16: bipush 101
    //   18: if_icmpne +45 -> 63
    //   21: aload_1
    //   22: invokevirtual 101	com/tencent/beacon/a/b/g:c	()[B
    //   25: ifnull +38 -> 63
    //   28: aload_0
    //   29: getfield 23	com/tencent/beacon/a/b/c:a	Landroid/content/Context;
    //   32: invokestatic 106	com/tencent/beacon/a/b/b:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/b/b;
    //   35: invokevirtual 110	com/tencent/beacon/a/b/b:f	()Lcom/tencent/beacon/upload/g;
    //   38: astore_2
    //   39: aload_2
    //   40: ifnull +23 -> 63
    //   43: aload_2
    //   44: bipush 101
    //   46: aload_1
    //   47: invokevirtual 101	com/tencent/beacon/a/b/g:c	()[B
    //   50: iconst_0
    //   51: invokevirtual 115	com/tencent/beacon/upload/g:a	(I[BZ)V
    //   54: ldc 117
    //   56: iconst_0
    //   57: anewarray 4	java/lang/Object
    //   60: invokestatic 80	com/tencent/beacon/d/a:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   63: aload_0
    //   64: getfield 23	com/tencent/beacon/a/b/c:a	Landroid/content/Context;
    //   67: invokestatic 106	com/tencent/beacon/a/b/b:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/b/b;
    //   70: astore_2
    //   71: aload_2
    //   72: invokevirtual 120	com/tencent/beacon/a/b/b:j	()I
    //   75: ifne +185 -> 260
    //   78: ldc 122
    //   80: iconst_0
    //   81: anewarray 4	java/lang/Object
    //   84: invokestatic 80	com/tencent/beacon/d/a:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   87: aload_2
    //   88: iconst_1
    //   89: invokevirtual 125	com/tencent/beacon/a/b/b:a	(I)V
    //   92: aload_0
    //   93: getfield 23	com/tencent/beacon/a/b/c:a	Landroid/content/Context;
    //   96: invokestatic 128	com/tencent/beacon/a/b:d	(Landroid/content/Context;)Z
    //   99: istore 12
    //   101: ldc -126
    //   103: iconst_1
    //   104: anewarray 4	java/lang/Object
    //   107: dup
    //   108: iconst_0
    //   109: iload 12
    //   111: invokestatic 135	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   114: aastore
    //   115: invokestatic 80	com/tencent/beacon/d/a:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   118: iload 12
    //   120: ifeq +106 -> 226
    //   123: ldc -119
    //   125: iconst_1
    //   126: anewarray 4	java/lang/Object
    //   129: dup
    //   130: iconst_0
    //   131: aload_0
    //   132: getfield 23	com/tencent/beacon/a/b/c:a	Landroid/content/Context;
    //   135: aconst_null
    //   136: invokestatic 142	com/tencent/beacon/a/a/a:a	(Landroid/content/Context;[I)I
    //   139: invokestatic 145	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   142: aastore
    //   143: invokestatic 80	com/tencent/beacon/d/a:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   146: aload_2
    //   147: monitorenter
    //   148: ldc -109
    //   150: iconst_0
    //   151: anewarray 4	java/lang/Object
    //   154: invokestatic 80	com/tencent/beacon/d/a:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   157: aload_2
    //   158: invokevirtual 151	com/tencent/beacon/a/b/b:i	()[Lcom/tencent/beacon/a/b/a;
    //   161: astore_1
    //   162: aload_2
    //   163: invokevirtual 153	com/tencent/beacon/a/b/b:h	()V
    //   166: aload_2
    //   167: monitorexit
    //   168: aload_1
    //   169: ifnull +91 -> 260
    //   172: ldc -101
    //   174: iconst_0
    //   175: anewarray 4	java/lang/Object
    //   178: invokestatic 80	com/tencent/beacon/d/a:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   181: aload_1
    //   182: arraylength
    //   183: istore 7
    //   185: iconst_0
    //   186: istore 6
    //   188: iload 6
    //   190: iload 7
    //   192: if_icmpge +68 -> 260
    //   195: aload_1
    //   196: iload 6
    //   198: aaload
    //   199: invokeinterface 159 1 0
    //   204: iload 6
    //   206: iconst_1
    //   207: iadd
    //   208: istore 6
    //   210: goto -22 -> 188
    //   213: astore_1
    //   214: aload_1
    //   215: invokestatic 162	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   218: goto -155 -> 63
    //   221: astore_1
    //   222: aload_2
    //   223: monitorexit
    //   224: aload_1
    //   225: athrow
    //   226: invokestatic 164	com/tencent/beacon/a/b/c:a	()J
    //   229: lstore 8
    //   231: lload 8
    //   233: lconst_0
    //   234: lcmp
    //   235: ifle +25 -> 260
    //   238: ldc -90
    //   240: iconst_1
    //   241: anewarray 4	java/lang/Object
    //   244: dup
    //   245: iconst_0
    //   246: lload 8
    //   248: invokestatic 171	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   251: aastore
    //   252: invokestatic 80	com/tencent/beacon/d/a:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   255: lload 8
    //   257: invokestatic 176	java/lang/Thread:sleep	(J)V
    //   260: aload_2
    //   261: monitorenter
    //   262: ldc -78
    //   264: iconst_0
    //   265: anewarray 4	java/lang/Object
    //   268: invokestatic 80	com/tencent/beacon/d/a:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   271: aload_2
    //   272: invokevirtual 151	com/tencent/beacon/a/b/b:i	()[Lcom/tencent/beacon/a/b/a;
    //   275: astore_1
    //   276: aload_2
    //   277: iconst_2
    //   278: invokevirtual 125	com/tencent/beacon/a/b/b:a	(I)V
    //   281: aload_2
    //   282: monitorexit
    //   283: aload_1
    //   284: ifnull +57 -> 341
    //   287: ldc -76
    //   289: iconst_0
    //   290: anewarray 4	java/lang/Object
    //   293: invokestatic 80	com/tencent/beacon/d/a:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   296: aload_1
    //   297: arraylength
    //   298: istore 7
    //   300: iconst_0
    //   301: istore 6
    //   303: iload 6
    //   305: iload 7
    //   307: if_icmpge +34 -> 341
    //   310: aload_1
    //   311: iload 6
    //   313: aaload
    //   314: invokeinterface 182 1 0
    //   319: iload 6
    //   321: iconst_1
    //   322: iadd
    //   323: istore 6
    //   325: goto -22 -> 303
    //   328: astore_1
    //   329: aload_1
    //   330: invokestatic 162	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   333: goto -73 -> 260
    //   336: astore_1
    //   337: aload_2
    //   338: monitorexit
    //   339: aload_1
    //   340: athrow
    //   341: invokestatic 60	com/tencent/beacon/a/b/d:a	()Lcom/tencent/beacon/a/b/d;
    //   344: invokevirtual 185	com/tencent/beacon/a/b/d:i	()Z
    //   347: ifne +201 -> 548
    //   350: invokestatic 188	com/tencent/beacon/a/b/b:c	()Lcom/tencent/beacon/upload/h;
    //   353: astore_1
    //   354: iconst_0
    //   355: istore 6
    //   357: aload_1
    //   358: ifnonnull +36 -> 394
    //   361: iload 6
    //   363: iconst_1
    //   364: iadd
    //   365: istore 6
    //   367: iload 6
    //   369: iconst_5
    //   370: if_icmpge +24 -> 394
    //   373: ldc2_w 189
    //   376: invokestatic 176	java/lang/Thread:sleep	(J)V
    //   379: invokestatic 188	com/tencent/beacon/a/b/b:c	()Lcom/tencent/beacon/upload/h;
    //   382: astore_1
    //   383: goto -26 -> 357
    //   386: astore_1
    //   387: aload_1
    //   388: invokestatic 162	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   391: goto -12 -> 379
    //   394: aload_1
    //   395: ifnull +407 -> 802
    //   398: aload_0
    //   399: getfield 23	com/tencent/beacon/a/b/c:a	Landroid/content/Context;
    //   402: ldc -64
    //   404: ldc -62
    //   406: invokestatic 37	com/tencent/beacon/a/b:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   409: astore_3
    //   410: invokestatic 49	com/tencent/beacon/a/f:n	()Ljava/lang/String;
    //   413: aload_3
    //   414: invokevirtual 55	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   417: ifne +13 -> 430
    //   420: aload_0
    //   421: getfield 23	com/tencent/beacon/a/b/c:a	Landroid/content/Context;
    //   424: invokestatic 49	com/tencent/beacon/a/f:n	()Ljava/lang/String;
    //   427: invokestatic 196	com/tencent/beacon/a/b:e	(Landroid/content/Context;Ljava/lang/String;)V
    //   430: aload_0
    //   431: getfield 23	com/tencent/beacon/a/b/c:a	Landroid/content/Context;
    //   434: aload_3
    //   435: invokestatic 198	com/tencent/beacon/a/b/c:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   438: istore 12
    //   440: aload_0
    //   441: getfield 23	com/tencent/beacon/a/b/c:a	Landroid/content/Context;
    //   444: astore 4
    //   446: invokestatic 203	com/tencent/beacon/event/o:d	()Lcom/tencent/beacon/event/o;
    //   449: getfield 206	com/tencent/beacon/event/o:a	Lcom/tencent/beacon/event/g;
    //   452: astore 5
    //   454: aload 5
    //   456: invokevirtual 211	com/tencent/beacon/event/g:x	()Z
    //   459: ifeq +197 -> 656
    //   462: invokestatic 216	java/lang/System:currentTimeMillis	()J
    //   465: lstore 8
    //   467: lload 8
    //   469: ldc2_w 217
    //   472: ldiv
    //   473: ldc2_w 219
    //   476: ladd
    //   477: ldc2_w 221
    //   480: lrem
    //   481: lstore 10
    //   483: lload 10
    //   485: lconst_0
    //   486: lcmp
    //   487: iflt +129 -> 616
    //   490: lload 10
    //   492: ldc2_w 223
    //   495: lcmp
    //   496: ifgt +120 -> 616
    //   499: lload 8
    //   501: aload 4
    //   503: ldc -30
    //   505: invokestatic 229	com/tencent/beacon/a/b:b	(Landroid/content/Context;Ljava/lang/String;)J
    //   508: lsub
    //   509: ldc2_w 230
    //   512: lcmp
    //   513: ifgt +103 -> 616
    //   516: iconst_1
    //   517: istore 6
    //   519: iload 12
    //   521: ifne +8 -> 529
    //   524: iload 6
    //   526: ifeq +136 -> 662
    //   529: ldc -23
    //   531: iconst_0
    //   532: anewarray 4	java/lang/Object
    //   535: invokestatic 85	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   538: aload_0
    //   539: getfield 23	com/tencent/beacon/a/b/c:a	Landroid/content/Context;
    //   542: invokestatic 106	com/tencent/beacon/a/b/b:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/b/b;
    //   545: invokevirtual 235	com/tencent/beacon/a/b/b:b	()V
    //   548: ldc -19
    //   550: iconst_0
    //   551: anewarray 4	java/lang/Object
    //   554: invokestatic 239	com/tencent/beacon/d/a:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   557: aload_2
    //   558: monitorenter
    //   559: aload_2
    //   560: invokevirtual 151	com/tencent/beacon/a/b/b:i	()[Lcom/tencent/beacon/a/b/a;
    //   563: astore_1
    //   564: aload_2
    //   565: iconst_3
    //   566: invokevirtual 125	com/tencent/beacon/a/b/b:a	(I)V
    //   569: aload_2
    //   570: monitorexit
    //   571: aload_1
    //   572: ifnull +248 -> 820
    //   575: ldc -15
    //   577: iconst_0
    //   578: anewarray 4	java/lang/Object
    //   581: invokestatic 80	com/tencent/beacon/d/a:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   584: aload_1
    //   585: arraylength
    //   586: istore 7
    //   588: iconst_0
    //   589: istore 6
    //   591: iload 6
    //   593: iload 7
    //   595: if_icmpge +225 -> 820
    //   598: aload_1
    //   599: iload 6
    //   601: aaload
    //   602: invokeinterface 242 1 0
    //   607: iload 6
    //   609: iconst_1
    //   610: iadd
    //   611: istore 6
    //   613: goto -22 -> 591
    //   616: invokestatic 49	com/tencent/beacon/a/f:n	()Ljava/lang/String;
    //   619: aload_3
    //   620: invokevirtual 55	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   623: ifeq +24 -> 647
    //   626: aload 4
    //   628: ldc -12
    //   630: invokestatic 247	com/tencent/beacon/a/b:a	(Landroid/content/Context;Ljava/lang/String;)I
    //   633: aload 5
    //   635: invokevirtual 250	com/tencent/beacon/event/g:w	()I
    //   638: if_icmplt +18 -> 656
    //   641: iconst_1
    //   642: istore 6
    //   644: goto -125 -> 519
    //   647: aload 4
    //   649: ldc -12
    //   651: iconst_0
    //   652: invokestatic 253	com/tencent/beacon/a/b:a	(Landroid/content/Context;Ljava/lang/String;I)Z
    //   655: pop
    //   656: iconst_0
    //   657: istore 6
    //   659: goto -140 -> 519
    //   662: aload_1
    //   663: new 255	com/tencent/beacon/upload/c
    //   666: dup
    //   667: aload_0
    //   668: getfield 23	com/tencent/beacon/a/b/c:a	Landroid/content/Context;
    //   671: invokespecial 257	com/tencent/beacon/upload/c:<init>	(Landroid/content/Context;)V
    //   674: invokeinterface 262 2 0
    //   679: invokestatic 60	com/tencent/beacon/a/b/d:a	()Lcom/tencent/beacon/a/b/d;
    //   682: invokevirtual 264	com/tencent/beacon/a/b/d:f	()Z
    //   685: ifeq +111 -> 796
    //   688: iconst_1
    //   689: istore 6
    //   691: new 266	com/tencent/beacon/d/b
    //   694: dup
    //   695: aload_0
    //   696: getfield 23	com/tencent/beacon/a/b/c:a	Landroid/content/Context;
    //   699: invokespecial 267	com/tencent/beacon/d/b:<init>	(Landroid/content/Context;)V
    //   702: astore_3
    //   703: iload 6
    //   705: istore 7
    //   707: iload 6
    //   709: ifeq +17 -> 726
    //   712: iload 6
    //   714: istore 7
    //   716: aload_3
    //   717: invokevirtual 269	com/tencent/beacon/d/b:b	()Z
    //   720: ifeq +6 -> 726
    //   723: iconst_0
    //   724: istore 7
    //   726: ldc -62
    //   728: aload_0
    //   729: getfield 23	com/tencent/beacon/a/b/c:a	Landroid/content/Context;
    //   732: invokestatic 274	com/tencent/beacon/a/j:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/j;
    //   735: invokevirtual 276	com/tencent/beacon/a/j:b	()Ljava/lang/String;
    //   738: invokevirtual 55	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   741: ifeq +6 -> 747
    //   744: iconst_1
    //   745: istore 7
    //   747: iload 7
    //   749: ifeq -201 -> 548
    //   752: invokestatic 60	com/tencent/beacon/a/b/d:a	()Lcom/tencent/beacon/a/b/d;
    //   755: invokevirtual 278	com/tencent/beacon/a/b/d:j	()Z
    //   758: ifne -210 -> 548
    //   761: new 8	com/tencent/beacon/a/b/c$1
    //   764: dup
    //   765: aload_0
    //   766: aload_1
    //   767: aload_3
    //   768: invokespecial 281	com/tencent/beacon/a/b/c$1:<init>	(Lcom/tencent/beacon/a/b/c;Lcom/tencent/beacon/upload/h;Lcom/tencent/beacon/d/b;)V
    //   771: astore_1
    //   772: invokestatic 286	com/tencent/beacon/a/c:a	()Lcom/tencent/beacon/a/c;
    //   775: aload_1
    //   776: invokevirtual 289	com/tencent/beacon/a/c:a	(Ljava/lang/Runnable;)V
    //   779: goto -231 -> 548
    //   782: astore_1
    //   783: ldc_w 291
    //   786: iconst_0
    //   787: anewarray 4	java/lang/Object
    //   790: invokestatic 85	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   793: goto -245 -> 548
    //   796: iconst_0
    //   797: istore 6
    //   799: goto -108 -> 691
    //   802: ldc_w 293
    //   805: iconst_0
    //   806: anewarray 4	java/lang/Object
    //   809: invokestatic 239	com/tencent/beacon/d/a:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   812: goto -264 -> 548
    //   815: astore_1
    //   816: aload_2
    //   817: monitorexit
    //   818: aload_1
    //   819: athrow
    //   820: aload_0
    //   821: getfield 23	com/tencent/beacon/a/b/c:a	Landroid/content/Context;
    //   824: invokestatic 106	com/tencent/beacon/a/b/b:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/b/b;
    //   827: invokevirtual 295	com/tencent/beacon/a/b/b:e	()Lcom/tencent/beacon/a/b/d;
    //   830: astore_1
    //   831: aload_1
    //   832: ifnonnull +14 -> 846
    //   835: ldc_w 297
    //   838: iconst_0
    //   839: anewarray 4	java/lang/Object
    //   842: invokestatic 299	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   845: return
    //   846: aload_1
    //   847: invokevirtual 301	com/tencent/beacon/a/b/d:c	()I
    //   850: ldc_w 302
    //   853: imul
    //   854: i2l
    //   855: lstore 8
    //   857: lload 8
    //   859: lconst_0
    //   860: lcmp
    //   861: ifle +42 -> 903
    //   864: invokestatic 286	com/tencent/beacon/a/c:a	()Lcom/tencent/beacon/a/c;
    //   867: aload_0
    //   868: lload 8
    //   870: invokevirtual 305	com/tencent/beacon/a/c:a	(Ljava/lang/Runnable;J)V
    //   873: ldc_w 307
    //   876: iconst_1
    //   877: anewarray 4	java/lang/Object
    //   880: dup
    //   881: iconst_0
    //   882: lload 8
    //   884: invokestatic 171	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   887: aastore
    //   888: invokestatic 239	com/tencent/beacon/d/a:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   891: aload_0
    //   892: getfield 23	com/tencent/beacon/a/b/c:a	Landroid/content/Context;
    //   895: invokestatic 106	com/tencent/beacon/a/b/b:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/b/b;
    //   898: iconst_4
    //   899: invokevirtual 125	com/tencent/beacon/a/b/b:a	(I)V
    //   902: return
    //   903: ldc_w 309
    //   906: iconst_0
    //   907: anewarray 4	java/lang/Object
    //   910: invokestatic 239	com/tencent/beacon/d/a:h	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   913: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	914	0	this	c
    //   7	189	1	localObject1	Object
    //   213	2	1	localThrowable	Throwable
    //   221	4	1	localObject2	Object
    //   275	36	1	arrayOfa	a[]
    //   328	2	1	localInterruptedException1	InterruptedException
    //   336	4	1	localObject3	Object
    //   353	30	1	localh	h
    //   386	9	1	localInterruptedException2	InterruptedException
    //   563	213	1	localObject4	Object
    //   782	1	1	localException	Exception
    //   815	4	1	localObject5	Object
    //   830	17	1	locald	d
    //   38	779	2	localObject6	Object
    //   409	359	3	localObject7	Object
    //   444	204	4	localContext	Context
    //   452	182	5	localg	com.tencent.beacon.event.g
    //   186	612	6	i	int
    //   183	565	7	j	int
    //   229	654	8	l1	long
    //   481	10	10	l2	long
    //   99	421	12	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   28	39	213	java/lang/Throwable
    //   43	63	213	java/lang/Throwable
    //   148	168	221	finally
    //   255	260	328	java/lang/InterruptedException
    //   262	283	336	finally
    //   373	379	386	java/lang/InterruptedException
    //   679	688	782	java/lang/Exception
    //   691	703	782	java/lang/Exception
    //   716	723	782	java/lang/Exception
    //   726	744	782	java/lang/Exception
    //   752	779	782	java/lang/Exception
    //   559	571	815	finally
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\beacon\a\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */