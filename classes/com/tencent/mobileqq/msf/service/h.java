package com.tencent.mobileqq.msf.service;

import android.content.Intent;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.IInterface;
import android.os.RemoteException;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.c.m;
import com.tencent.mobileqq.msf.core.w;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Random;

public class h
  implements IBinder.DeathRecipient
{
  private static final int A = 0;
  private static int B = 0;
  private static int C = 3;
  public static final int a = 2;
  public static final int b = 1;
  public static final int c = 0;
  public static final int d = 3;
  public static final boolean e = true;
  private static final int h = 500;
  private static final String i = "GuardManager";
  private static final String j = "gm_history";
  private static final int k = 1;
  private static final int l = 2;
  private static final int m = 3;
  private static final int n = 4;
  private static final int o = 5;
  private static long p = 720000L;
  private static long r = 0L;
  private static final int y = 2;
  private static final int z = 1;
  public boolean f;
  public volatile boolean g;
  private IBinder q;
  private int s = 1;
  private long t;
  private a u;
  private a v;
  private a w;
  private MsfCore x;
  
  public h(MsfCore paramMsfCore)
  {
    this.x = paramMsfCore;
  }
  
  private void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    int i1 = 1;
    paramInt1 = 1;
    Object localObject;
    if (paramInt3 != 0)
    {
      if (paramInt3 == 2) {
        paramInt1 = 2;
      }
      B = paramInt1;
      localObject = Calendar.getInstance(Locale.getDefault());
      ((Calendar)localObject).setTimeInMillis(paramLong - 15000L);
      paramInt1 = ((Calendar)localObject).get(7);
      paramLong = ((Calendar)localObject).get(11) * 60 * 60 * 1000 + paramLong % 3600000L;
      if (B != 2) {
        break label150;
      }
      if (!paramBoolean) {
        break label143;
      }
      localObject = "11";
    }
    for (;;)
    {
      a("GM_StartTime", paramLong, (String)localObject);
      C = paramInt2;
      a(0L, paramLong, paramInt1);
      return;
      if (B != 0) {
        break;
      }
      paramInt1 = i1;
      if (new Random().nextInt(2) == 0) {
        paramInt1 = 2;
      }
      B = paramInt1;
      break;
      label143:
      localObject = "10";
      continue;
      label150:
      if (paramBoolean) {
        localObject = "01";
      } else {
        localObject = "00";
      }
    }
  }
  
  private void a(long paramLong1, long paramLong2, int paramInt)
  {
    boolean bool3 = true;
    boolean bool2 = true;
    if (paramLong1 != 0L)
    {
      localObject = Calendar.getInstance(Locale.getDefault());
      ((Calendar)localObject).setTimeInMillis(paramLong1 - 15000L);
      paramInt = ((Calendar)localObject).get(7);
      paramLong2 = ((Calendar)localObject).get(11) * 60 * 60 * 1000 + paramLong1 % 3600000L;
    }
    if (this.w == null) {
      d();
    }
    Object localObject = this.w;
    if (paramLong1 == 0L)
    {
      bool1 = true;
      ((a)localObject).a(paramLong2, bool1);
      if ((paramInt == 1) || (paramInt == 7)) {
        break label152;
      }
      localObject = this.u;
      if (paramLong1 != 0L) {
        break label146;
      }
    }
    label146:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((a)localObject).a(paramLong2, bool1);
      e();
      return;
      bool1 = false;
      break;
    }
    label152:
    localObject = this.v;
    if (paramLong1 == 0L) {}
    for (bool1 = bool3;; bool1 = false)
    {
      ((a)localObject).a(paramLong2, bool1);
      break;
    }
  }
  
  private void a(String paramString1, long paramLong, String paramString2)
  {
    HashMap localHashMap = null;
    if (paramString2 != null)
    {
      localHashMap = new HashMap();
      localHashMap.put("Tag", paramString2);
    }
    this.x.getStatReporter().a(paramString1, true, paramLong, 0L, localHashMap, false, false);
  }
  
  /* Error */
  private void d()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 7
    //   3: iconst_0
    //   4: istore 5
    //   6: aload_0
    //   7: monitorenter
    //   8: new 164	java/io/ObjectInputStream
    //   11: dup
    //   12: invokestatic 170	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   15: ldc 31
    //   17: invokevirtual 174	com/tencent/qphone/base/util/BaseApplication:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   20: invokespecial 177	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   23: astore_2
    //   24: aload_2
    //   25: astore_1
    //   26: aload_2
    //   27: invokevirtual 181	java/io/ObjectInputStream:readByte	()B
    //   30: istore 6
    //   32: iload 6
    //   34: ifeq +79 -> 113
    //   37: bipush 24
    //   39: iload 6
    //   41: irem
    //   42: ifne +71 -> 113
    //   45: aload_2
    //   46: astore_1
    //   47: iload 6
    //   49: newarray <illegal type>
    //   51: astore_3
    //   52: aload_2
    //   53: astore_1
    //   54: iload 6
    //   56: newarray <illegal type>
    //   58: astore 4
    //   60: iload 5
    //   62: iload 6
    //   64: if_icmpge +33 -> 97
    //   67: aload_2
    //   68: astore_1
    //   69: aload 4
    //   71: iload 5
    //   73: aload_2
    //   74: invokevirtual 184	java/io/ObjectInputStream:readLong	()J
    //   77: lastore
    //   78: aload_2
    //   79: astore_1
    //   80: aload_3
    //   81: iload 5
    //   83: aload_2
    //   84: invokevirtual 184	java/io/ObjectInputStream:readLong	()J
    //   87: lastore
    //   88: iload 5
    //   90: iconst_1
    //   91: iadd
    //   92: istore 5
    //   94: goto -34 -> 60
    //   97: aload_2
    //   98: astore_1
    //   99: aload_0
    //   100: new 8	com/tencent/mobileqq/msf/service/h$a
    //   103: dup
    //   104: aload 4
    //   106: aload_3
    //   107: invokespecial 187	com/tencent/mobileqq/msf/service/h$a:<init>	([J[J)V
    //   110: putfield 132	com/tencent/mobileqq/msf/service/h:u	Lcom/tencent/mobileqq/msf/service/h$a;
    //   113: aload_2
    //   114: astore_1
    //   115: aload_2
    //   116: invokevirtual 190	java/io/ObjectInputStream:readInt	()I
    //   119: putstatic 67	com/tencent/mobileqq/msf/service/h:C	I
    //   122: aload_2
    //   123: astore_1
    //   124: aload_2
    //   125: invokevirtual 190	java/io/ObjectInputStream:readInt	()I
    //   128: putstatic 65	com/tencent/mobileqq/msf/service/h:B	I
    //   131: aload_2
    //   132: astore_1
    //   133: aload_2
    //   134: invokevirtual 184	java/io/ObjectInputStream:readLong	()J
    //   137: lstore 8
    //   139: lload 8
    //   141: ldc2_w 191
    //   144: lcmp
    //   145: ifgt +444 -> 589
    //   148: lload 8
    //   150: l2i
    //   151: istore 5
    //   153: iload 5
    //   155: ifeq +97 -> 252
    //   158: bipush 24
    //   160: iload 5
    //   162: irem
    //   163: ifne +89 -> 252
    //   166: aload_2
    //   167: astore_1
    //   168: iload 5
    //   170: newarray <illegal type>
    //   172: astore_3
    //   173: aload_2
    //   174: astore_1
    //   175: iload 5
    //   177: newarray <illegal type>
    //   179: astore 4
    //   181: aload 4
    //   183: iconst_0
    //   184: lload 8
    //   186: lastore
    //   187: aload_2
    //   188: astore_1
    //   189: aload_3
    //   190: iconst_0
    //   191: aload_2
    //   192: invokevirtual 184	java/io/ObjectInputStream:readLong	()J
    //   195: lastore
    //   196: iconst_1
    //   197: istore 6
    //   199: iload 6
    //   201: iload 5
    //   203: if_icmpge +33 -> 236
    //   206: aload_2
    //   207: astore_1
    //   208: aload 4
    //   210: iload 6
    //   212: aload_2
    //   213: invokevirtual 184	java/io/ObjectInputStream:readLong	()J
    //   216: lastore
    //   217: aload_2
    //   218: astore_1
    //   219: aload_3
    //   220: iload 6
    //   222: aload_2
    //   223: invokevirtual 184	java/io/ObjectInputStream:readLong	()J
    //   226: lastore
    //   227: iload 6
    //   229: iconst_1
    //   230: iadd
    //   231: istore 6
    //   233: goto -34 -> 199
    //   236: aload_2
    //   237: astore_1
    //   238: aload_0
    //   239: new 8	com/tencent/mobileqq/msf/service/h$a
    //   242: dup
    //   243: aload 4
    //   245: aload_3
    //   246: invokespecial 187	com/tencent/mobileqq/msf/service/h$a:<init>	([J[J)V
    //   249: putfield 136	com/tencent/mobileqq/msf/service/h:v	Lcom/tencent/mobileqq/msf/service/h$a;
    //   252: aload_2
    //   253: astore_1
    //   254: aload_2
    //   255: invokevirtual 190	java/io/ObjectInputStream:readInt	()I
    //   258: istore 6
    //   260: iload 6
    //   262: ifeq +98 -> 360
    //   265: bipush 24
    //   267: iload 6
    //   269: irem
    //   270: ifne +90 -> 360
    //   273: aload_2
    //   274: astore_1
    //   275: iload 6
    //   277: newarray <illegal type>
    //   279: astore_3
    //   280: aload_2
    //   281: astore_1
    //   282: iload 6
    //   284: newarray <illegal type>
    //   286: astore 4
    //   288: aload 4
    //   290: iconst_0
    //   291: lload 8
    //   293: lastore
    //   294: aload_2
    //   295: astore_1
    //   296: aload_3
    //   297: iconst_0
    //   298: aload_2
    //   299: invokevirtual 184	java/io/ObjectInputStream:readLong	()J
    //   302: lastore
    //   303: iload 7
    //   305: istore 5
    //   307: iload 5
    //   309: iload 6
    //   311: if_icmpge +33 -> 344
    //   314: aload_2
    //   315: astore_1
    //   316: aload 4
    //   318: iload 5
    //   320: aload_2
    //   321: invokevirtual 184	java/io/ObjectInputStream:readLong	()J
    //   324: lastore
    //   325: aload_2
    //   326: astore_1
    //   327: aload_3
    //   328: iload 5
    //   330: aload_2
    //   331: invokevirtual 184	java/io/ObjectInputStream:readLong	()J
    //   334: lastore
    //   335: iload 5
    //   337: iconst_1
    //   338: iadd
    //   339: istore 5
    //   341: goto -34 -> 307
    //   344: aload_2
    //   345: astore_1
    //   346: aload_0
    //   347: new 8	com/tencent/mobileqq/msf/service/h$a
    //   350: dup
    //   351: aload 4
    //   353: aload_3
    //   354: invokespecial 187	com/tencent/mobileqq/msf/service/h$a:<init>	([J[J)V
    //   357: putfield 125	com/tencent/mobileqq/msf/service/h:w	Lcom/tencent/mobileqq/msf/service/h$a;
    //   360: aload_2
    //   361: ifnull +7 -> 368
    //   364: aload_2
    //   365: invokevirtual 195	java/io/ObjectInputStream:close	()V
    //   368: aload_0
    //   369: getfield 125	com/tencent/mobileqq/msf/service/h:w	Lcom/tencent/mobileqq/msf/service/h$a;
    //   372: ifnonnull +51 -> 423
    //   375: aload_0
    //   376: getfield 132	com/tencent/mobileqq/msf/service/h:u	Lcom/tencent/mobileqq/msf/service/h$a;
    //   379: ifnull +203 -> 582
    //   382: aload_0
    //   383: getfield 132	com/tencent/mobileqq/msf/service/h:u	Lcom/tencent/mobileqq/msf/service/h$a;
    //   386: getfield 198	com/tencent/mobileqq/msf/service/h$a:a	[J
    //   389: invokevirtual 203	[J:clone	()Ljava/lang/Object;
    //   392: checkcast 199	[J
    //   395: astore_1
    //   396: aload_0
    //   397: getfield 132	com/tencent/mobileqq/msf/service/h:u	Lcom/tencent/mobileqq/msf/service/h$a;
    //   400: getfield 205	com/tencent/mobileqq/msf/service/h$a:b	[J
    //   403: invokevirtual 203	[J:clone	()Ljava/lang/Object;
    //   406: checkcast 199	[J
    //   409: astore_2
    //   410: aload_0
    //   411: new 8	com/tencent/mobileqq/msf/service/h$a
    //   414: dup
    //   415: aload_1
    //   416: aload_2
    //   417: invokespecial 187	com/tencent/mobileqq/msf/service/h$a:<init>	([J[J)V
    //   420: putfield 125	com/tencent/mobileqq/msf/service/h:w	Lcom/tencent/mobileqq/msf/service/h$a;
    //   423: aload_0
    //   424: getfield 132	com/tencent/mobileqq/msf/service/h:u	Lcom/tencent/mobileqq/msf/service/h$a;
    //   427: ifnonnull +16 -> 443
    //   430: aload_0
    //   431: new 8	com/tencent/mobileqq/msf/service/h$a
    //   434: dup
    //   435: aconst_null
    //   436: aconst_null
    //   437: invokespecial 187	com/tencent/mobileqq/msf/service/h$a:<init>	([J[J)V
    //   440: putfield 132	com/tencent/mobileqq/msf/service/h:u	Lcom/tencent/mobileqq/msf/service/h$a;
    //   443: aload_0
    //   444: getfield 136	com/tencent/mobileqq/msf/service/h:v	Lcom/tencent/mobileqq/msf/service/h$a;
    //   447: ifnonnull +16 -> 463
    //   450: aload_0
    //   451: new 8	com/tencent/mobileqq/msf/service/h$a
    //   454: dup
    //   455: aconst_null
    //   456: aconst_null
    //   457: invokespecial 187	com/tencent/mobileqq/msf/service/h$a:<init>	([J[J)V
    //   460: putfield 136	com/tencent/mobileqq/msf/service/h:v	Lcom/tencent/mobileqq/msf/service/h$a;
    //   463: aload_0
    //   464: monitorexit
    //   465: return
    //   466: astore_3
    //   467: aconst_null
    //   468: astore_2
    //   469: aload_2
    //   470: astore_1
    //   471: invokestatic 211	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   474: ifeq +14 -> 488
    //   477: aload_2
    //   478: astore_1
    //   479: ldc 28
    //   481: iconst_2
    //   482: ldc -43
    //   484: aload_3
    //   485: invokestatic 216	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   488: aload_2
    //   489: ifnull -121 -> 368
    //   492: aload_2
    //   493: invokevirtual 195	java/io/ObjectInputStream:close	()V
    //   496: goto -128 -> 368
    //   499: astore_1
    //   500: invokestatic 211	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   503: ifeq -135 -> 368
    //   506: ldc 28
    //   508: iconst_2
    //   509: ldc -38
    //   511: aload_1
    //   512: invokestatic 216	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   515: goto -147 -> 368
    //   518: astore_1
    //   519: aload_0
    //   520: monitorexit
    //   521: aload_1
    //   522: athrow
    //   523: astore_2
    //   524: aconst_null
    //   525: astore_1
    //   526: aload_1
    //   527: ifnull +7 -> 534
    //   530: aload_1
    //   531: invokevirtual 195	java/io/ObjectInputStream:close	()V
    //   534: aload_2
    //   535: athrow
    //   536: astore_1
    //   537: invokestatic 211	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   540: ifeq -6 -> 534
    //   543: ldc 28
    //   545: iconst_2
    //   546: ldc -38
    //   548: aload_1
    //   549: invokestatic 216	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   552: goto -18 -> 534
    //   555: astore_1
    //   556: invokestatic 211	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   559: ifeq -191 -> 368
    //   562: ldc 28
    //   564: iconst_2
    //   565: ldc -38
    //   567: aload_1
    //   568: invokestatic 216	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   571: goto -203 -> 368
    //   574: astore_2
    //   575: goto -49 -> 526
    //   578: astore_3
    //   579: goto -110 -> 469
    //   582: aconst_null
    //   583: astore_2
    //   584: aconst_null
    //   585: astore_1
    //   586: goto -176 -> 410
    //   589: iload 6
    //   591: istore 5
    //   593: goto -440 -> 153
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	596	0	this	h
    //   25	454	1	localObject1	Object
    //   499	13	1	localIOException1	java.io.IOException
    //   518	4	1	localObject2	Object
    //   525	6	1	localObject3	Object
    //   536	13	1	localIOException2	java.io.IOException
    //   555	13	1	localIOException3	java.io.IOException
    //   585	1	1	localObject4	Object
    //   23	470	2	localObject5	Object
    //   523	12	2	localObject6	Object
    //   574	1	2	localObject7	Object
    //   583	1	2	localObject8	Object
    //   51	303	3	arrayOfLong1	long[]
    //   466	19	3	localThrowable1	Throwable
    //   578	1	3	localThrowable2	Throwable
    //   58	294	4	arrayOfLong2	long[]
    //   4	588	5	i1	int
    //   30	560	6	i2	int
    //   1	303	7	i3	int
    //   137	155	8	l1	long
    // Exception table:
    //   from	to	target	type
    //   8	24	466	java/lang/Throwable
    //   492	496	499	java/io/IOException
    //   364	368	518	finally
    //   368	410	518	finally
    //   410	423	518	finally
    //   423	443	518	finally
    //   443	463	518	finally
    //   492	496	518	finally
    //   500	515	518	finally
    //   530	534	518	finally
    //   534	536	518	finally
    //   537	552	518	finally
    //   556	571	518	finally
    //   8	24	523	finally
    //   530	534	536	java/io/IOException
    //   364	368	555	java/io/IOException
    //   26	32	574	finally
    //   47	52	574	finally
    //   54	60	574	finally
    //   69	78	574	finally
    //   80	88	574	finally
    //   99	113	574	finally
    //   115	122	574	finally
    //   124	131	574	finally
    //   133	139	574	finally
    //   168	173	574	finally
    //   175	181	574	finally
    //   189	196	574	finally
    //   208	217	574	finally
    //   219	227	574	finally
    //   238	252	574	finally
    //   254	260	574	finally
    //   275	280	574	finally
    //   282	288	574	finally
    //   296	303	574	finally
    //   316	325	574	finally
    //   327	335	574	finally
    //   346	360	574	finally
    //   471	477	574	finally
    //   479	488	574	finally
    //   26	32	578	java/lang/Throwable
    //   47	52	578	java/lang/Throwable
    //   54	60	578	java/lang/Throwable
    //   69	78	578	java/lang/Throwable
    //   80	88	578	java/lang/Throwable
    //   99	113	578	java/lang/Throwable
    //   115	122	578	java/lang/Throwable
    //   124	131	578	java/lang/Throwable
    //   133	139	578	java/lang/Throwable
    //   168	173	578	java/lang/Throwable
    //   175	181	578	java/lang/Throwable
    //   189	196	578	java/lang/Throwable
    //   208	217	578	java/lang/Throwable
    //   219	227	578	java/lang/Throwable
    //   238	252	578	java/lang/Throwable
    //   254	260	578	java/lang/Throwable
    //   275	280	578	java/lang/Throwable
    //   282	288	578	java/lang/Throwable
    //   296	303	578	java/lang/Throwable
    //   316	325	578	java/lang/Throwable
    //   327	335	578	java/lang/Throwable
    //   346	360	578	java/lang/Throwable
  }
  
  /* Error */
  private void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 220	java/io/ObjectOutputStream
    //   5: dup
    //   6: invokestatic 170	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   9: ldc 31
    //   11: iconst_0
    //   12: invokevirtual 224	com/tencent/qphone/base/util/BaseApplication:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   15: invokespecial 227	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   18: astore_2
    //   19: aload_2
    //   20: astore_1
    //   21: aload_0
    //   22: getfield 132	com/tencent/mobileqq/msf/service/h:u	Lcom/tencent/mobileqq/msf/service/h$a;
    //   25: aload_2
    //   26: iconst_0
    //   27: invokevirtual 230	com/tencent/mobileqq/msf/service/h$a:a	(Ljava/io/ObjectOutputStream;Z)V
    //   30: aload_2
    //   31: astore_1
    //   32: aload_2
    //   33: getstatic 67	com/tencent/mobileqq/msf/service/h:C	I
    //   36: invokevirtual 234	java/io/ObjectOutputStream:writeInt	(I)V
    //   39: aload_2
    //   40: astore_1
    //   41: aload_2
    //   42: getstatic 65	com/tencent/mobileqq/msf/service/h:B	I
    //   45: invokevirtual 234	java/io/ObjectOutputStream:writeInt	(I)V
    //   48: aload_2
    //   49: astore_1
    //   50: aload_0
    //   51: getfield 136	com/tencent/mobileqq/msf/service/h:v	Lcom/tencent/mobileqq/msf/service/h$a;
    //   54: aload_2
    //   55: iconst_1
    //   56: invokevirtual 230	com/tencent/mobileqq/msf/service/h$a:a	(Ljava/io/ObjectOutputStream;Z)V
    //   59: aload_2
    //   60: astore_1
    //   61: aload_0
    //   62: getfield 125	com/tencent/mobileqq/msf/service/h:w	Lcom/tencent/mobileqq/msf/service/h$a;
    //   65: aload_2
    //   66: iconst_0
    //   67: invokevirtual 230	com/tencent/mobileqq/msf/service/h$a:a	(Ljava/io/ObjectOutputStream;Z)V
    //   70: aload_2
    //   71: ifnull +7 -> 78
    //   74: aload_2
    //   75: invokevirtual 235	java/io/ObjectOutputStream:close	()V
    //   78: aload_0
    //   79: monitorexit
    //   80: return
    //   81: astore_3
    //   82: aconst_null
    //   83: astore_2
    //   84: aload_2
    //   85: astore_1
    //   86: invokestatic 211	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   89: ifeq +14 -> 103
    //   92: aload_2
    //   93: astore_1
    //   94: ldc 28
    //   96: iconst_2
    //   97: ldc -38
    //   99: aload_3
    //   100: invokestatic 216	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   103: aload_2
    //   104: ifnull -26 -> 78
    //   107: aload_2
    //   108: invokevirtual 235	java/io/ObjectOutputStream:close	()V
    //   111: goto -33 -> 78
    //   114: astore_1
    //   115: invokestatic 211	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   118: ifeq -40 -> 78
    //   121: ldc 28
    //   123: iconst_2
    //   124: ldc -38
    //   126: aload_1
    //   127: invokestatic 216	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   130: goto -52 -> 78
    //   133: astore_1
    //   134: aload_0
    //   135: monitorexit
    //   136: aload_1
    //   137: athrow
    //   138: astore_2
    //   139: aconst_null
    //   140: astore_1
    //   141: aload_1
    //   142: ifnull +7 -> 149
    //   145: aload_1
    //   146: invokevirtual 235	java/io/ObjectOutputStream:close	()V
    //   149: aload_2
    //   150: athrow
    //   151: astore_1
    //   152: invokestatic 211	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   155: ifeq -6 -> 149
    //   158: ldc 28
    //   160: iconst_2
    //   161: ldc -38
    //   163: aload_1
    //   164: invokestatic 216	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   167: goto -18 -> 149
    //   170: astore_1
    //   171: invokestatic 211	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   174: ifeq -96 -> 78
    //   177: ldc 28
    //   179: iconst_2
    //   180: ldc -38
    //   182: aload_1
    //   183: invokestatic 216	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   186: goto -108 -> 78
    //   189: astore_2
    //   190: goto -49 -> 141
    //   193: astore_3
    //   194: goto -110 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	this	h
    //   20	74	1	localObjectOutputStream1	ObjectOutputStream
    //   114	13	1	localIOException1	java.io.IOException
    //   133	4	1	localObject1	Object
    //   140	6	1	localObject2	Object
    //   151	13	1	localIOException2	java.io.IOException
    //   170	13	1	localIOException3	java.io.IOException
    //   18	90	2	localObjectOutputStream2	ObjectOutputStream
    //   138	12	2	localObject3	Object
    //   189	1	2	localObject4	Object
    //   81	19	3	localThrowable1	Throwable
    //   193	1	3	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   2	19	81	java/lang/Throwable
    //   107	111	114	java/io/IOException
    //   74	78	133	finally
    //   107	111	133	finally
    //   115	130	133	finally
    //   145	149	133	finally
    //   149	151	133	finally
    //   152	167	133	finally
    //   171	186	133	finally
    //   2	19	138	finally
    //   145	149	151	java/io/IOException
    //   74	78	170	java/io/IOException
    //   21	30	189	finally
    //   32	39	189	finally
    //   41	48	189	finally
    //   50	59	189	finally
    //   61	70	189	finally
    //   86	92	189	finally
    //   94	103	189	finally
    //   21	30	193	java/lang/Throwable
    //   32	39	193	java/lang/Throwable
    //   41	48	193	java/lang/Throwable
    //   50	59	193	java/lang/Throwable
    //   61	70	193	java/lang/Throwable
  }
  
  private boolean f()
  {
    IBinder localIBinder = this.q;
    return (localIBinder != null) && (localIBinder.isBinderAlive());
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager", 2, "onEvent:" + paramInt + ", " + paramLong1 + ", " + paramLong2);
    }
    long l1 = System.currentTimeMillis();
    this.t = l1;
    this.g = true;
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                paramInt = (int)(paramLong1 >> 8);
                int i1 = (int)(0xFF & paramLong1);
                if ((0xFF & paramLong2) == 1L) {}
                for (boolean bool = true;; bool = false)
                {
                  a(l1, paramInt, i1, bool, (int)(paramLong2 >> 8));
                  return;
                }
                r = l1;
                this.s = 1;
                this.g = false;
                return;
                this.s = 2;
              } while (!com.tencent.mobileqq.msf.core.a.a.aM());
              try
              {
                this.x.sender.G.c().a();
                return;
              }
              catch (Exception localException1) {}
            } while (!QLog.isColorLevel());
            QLog.d("GuardManager", 2, "failed to call adaptorcontroller background ", localException1);
            return;
            this.s = 4;
            return;
            this.s = 3;
            p = paramLong1;
            return;
            this.s = 5;
            p = paramLong1;
            return;
            MsfService.getCore().pushManager.k();
            MsfService.getCore().pushManager.l();
          } while (!com.tencent.mobileqq.msf.core.a.a.aM());
          try
          {
            this.x.sender.G.c().b();
            return;
          }
          catch (Exception localException2) {}
        } while (!QLog.isColorLevel());
        QLog.d("GuardManager", 2, "failed to call adaptorcontroller foreground ", localException2);
        return;
        a(l1, 0L, 0);
      } while (!com.tencent.mobileqq.msf.core.a.a.aM());
      try
      {
        this.x.sender.G.c().b();
        return;
      }
      catch (Exception localException3) {}
    } while (!QLog.isColorLevel());
    QLog.d("GuardManager", 2, "failed to call adaptorcontroller foreground ", localException3);
  }
  
  public void a(IInterface paramIInterface)
  {
    IBinder localIBinder;
    if (paramIInterface != null) {
      localIBinder = paramIInterface.asBinder();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuardManager", 2, "onAppBind with " + paramIInterface);
      }
      paramIInterface = this.q;
      long l1;
      if (paramIInterface != localIBinder)
      {
        l1 = System.currentTimeMillis();
        if (paramIInterface != null)
        {
          paramIInterface.unlinkToDeath(this, 0);
          this.q = null;
          r = l1;
          this.t = l1;
        }
        if ((localIBinder == null) || (!localIBinder.isBinderAlive())) {}
      }
      try
      {
        localIBinder.linkToDeath(this, 0);
        this.q = localIBinder;
        r = l1;
        return;
        localIBinder = null;
      }
      catch (RemoteException paramIInterface)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("GuardManager", 2, "onAppBind ", paramIInterface);
      }
    }
  }
  
  public boolean a()
  {
    return (this.g) && (f());
  }
  
  public boolean a(int paramInt)
  {
    if (this.f) {}
    long l1;
    int i1;
    do
    {
      return true;
      this.f = true;
      l1 = System.currentTimeMillis();
      l2 = Math.abs(l1 - r);
      if ((this.s == 2) || (this.s == 4)) {}
      for (i1 = 1; ((paramInt == 3) && (l2 > 500L) && (!this.g) && (f())) || ((paramInt == 1) && (l2 > p) && (!f()) && (i1 == 0)) || ((paramInt == 0) && (l2 > 500L) && (!f())); i1 = 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GuardManager", 2, "prestart " + paramInt + ", " + l1 + ", " + r + ", " + p);
        }
        localObject = new Intent("com.tencent.mobileqq.broadcast.qq");
        ((Intent)localObject).putExtra("k_start_mode", paramInt);
        BaseApplication.getContext().sendBroadcast((Intent)localObject);
        r = l1;
        a("GM_LiteStart", 0L, "" + paramInt);
        return true;
      }
    } while ((paramInt != 2) || (l2 <= p) || (f()) || (i1 != 0));
    if (this.w == null) {
      d();
    }
    Object localObject = Calendar.getInstance(Locale.getDefault());
    ((Calendar)localObject).setTimeInMillis(l1);
    long l2 = ((Calendar)localObject).get(11) * 60 * 60 * 1000 + l1 % 3600000L;
    boolean bool;
    if (B == 2)
    {
      paramInt = ((Calendar)localObject).get(7);
      if ((paramInt != 1) && (paramInt != 7))
      {
        bool = this.u.a(l2);
        label366:
        if (!bool) {
          break label452;
        }
        localObject = new Intent("com.tencent.mobileqq.broadcast.qq");
        ((Intent)localObject).putExtra("k_start_mode", 2);
        BaseApplication.getContext().sendBroadcast((Intent)localObject);
        if (B != 2) {
          break label454;
        }
      }
    }
    label452:
    label454:
    for (localObject = "1";; localObject = "0")
    {
      a("GM_PreStart", l2, (String)localObject);
      r = l1;
      return true;
      bool = this.v.a(l2);
      break label366;
      bool = this.w.a(l2);
      break label366;
      break;
    }
  }
  
  public void binderDied()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager", 2, "binderDied");
    }
    IBinder localIBinder = this.q;
    if (localIBinder != null)
    {
      localIBinder.unlinkToDeath(this, 0);
      this.q = null;
      r = System.currentTimeMillis();
      this.g = false;
      long l1 = r - this.t;
      if ((l1 > 0L) && (l1 < 86400000L)) {
        a("GM_AliveTime" + this.s, l1, null);
      }
    }
  }
  
  private static class a
  {
    public long[] a;
    public long[] b;
    
    public a(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
    {
      this.a = paramArrayOfLong1;
      this.b = paramArrayOfLong2;
    }
    
    public void a(long paramLong, boolean paramBoolean)
    {
      if (this.a == null)
      {
        this.a = new long[1];
        this.a[0] = paramLong;
        this.b = new long[1];
      }
      long l1;
      int j;
      Object localObject;
      int i;
      if (paramBoolean)
      {
        l1 = 2L;
        j = Arrays.binarySearch(this.a, paramLong);
        localObject = new StringBuilder().append(paramLong).append(" is the ");
        if (j >= 0) {
          break label289;
        }
        i = -j - 1;
        label77:
        QLog.d("GuardManager", 2, i + "th of " + Arrays.toString(this.a));
        if (j >= 0) {
          break label845;
        }
        i = -j - 1;
        if (i <= 0) {
          break label929;
        }
      }
      label289:
      label845:
      label918:
      label929:
      for (long l2 = paramLong - this.a[(i - 1)];; l2 = Long.MAX_VALUE)
      {
        if (i < this.a.length) {}
        for (long l3 = this.a[i] - paramLong;; l3 = Long.MAX_VALUE)
        {
          if ((l2 <= h.b() * 2L) || (l3 <= h.b() * 2L))
          {
            if (l2 >= l3) {
              break label918;
            }
            i -= 1;
          }
          for (;;)
          {
            this.a[i] = (this.a[i] * this.b[i] + paramLong * l1);
            localObject = this.b;
            localObject[i] = (l1 + localObject[i]);
            localObject = this.a;
            localObject[i] /= this.b[i];
            for (;;)
            {
              QLog.d("GuardManager", 2, Arrays.toString(this.a));
              return;
              l1 = 1L;
              break;
              i = j;
              break label77;
              int k = this.a.length;
              localObject = new ArrayList(k * 2);
              j = 0;
              while (j < i)
              {
                ((ArrayList)localObject).add(Long.valueOf(this.a[j]));
                ((ArrayList)localObject).add(Long.valueOf(this.b[j]));
                j += 1;
              }
              ((ArrayList)localObject).add(Long.valueOf(paramLong));
              ((ArrayList)localObject).add(Long.valueOf(l1));
              while (i < k)
              {
                ((ArrayList)localObject).add(Long.valueOf(this.a[i]));
                ((ArrayList)localObject).add(Long.valueOf(this.b[i]));
                i += 1;
              }
              if (((ArrayList)localObject).size() > 56)
              {
                l1 = ((Long)((ArrayList)localObject).get(0)).longValue();
                paramLong = ((Long)((ArrayList)localObject).get(1)).longValue();
                k = ((ArrayList)localObject).size() / 2;
                i = 0;
                j = 1;
                if (j < k)
                {
                  l2 = ((Long)((ArrayList)localObject).get(j * 2)).longValue();
                  long l4 = ((Long)((ArrayList)localObject).get(j * 2 + 1)).longValue();
                  if (l2 - l1 < h.b() * 3L)
                  {
                    l3 = l4 + paramLong;
                    paramLong = (l2 * l4 + l1 * paramLong) / l3;
                    l1 = l3;
                  }
                  for (;;)
                  {
                    j += 1;
                    l2 = paramLong;
                    paramLong = l1;
                    l1 = l2;
                    break;
                    ((ArrayList)localObject).set(i * 2, Long.valueOf(l1));
                    ((ArrayList)localObject).set(i * 2 + 1, Long.valueOf(paramLong));
                    i += 1;
                    l1 = l4;
                    paramLong = l2;
                  }
                }
                ((ArrayList)localObject).set(i * 2, Long.valueOf(l1));
                ((ArrayList)localObject).set(i * 2 + 1, Long.valueOf(paramLong));
                j = i + 1;
                this.a = new long[j];
                this.b = new long[j];
                i = 0;
                while (i < j)
                {
                  this.a[i] = ((Long)((ArrayList)localObject).get(i * 2)).longValue();
                  this.b[i] = ((Long)((ArrayList)localObject).get(i * 2 + 1)).longValue();
                  i += 1;
                }
              }
              else
              {
                j = ((ArrayList)localObject).size() / 2;
                this.a = new long[j];
                this.b = new long[j];
                i = 0;
                while (i < j)
                {
                  this.a[i] = ((Long)((ArrayList)localObject).get(i * 2)).longValue();
                  this.b[i] = ((Long)((ArrayList)localObject).get(i * 2 + 1)).longValue();
                  i += 1;
                }
                continue;
                this.a[j] = (this.a[j] * this.b[j] + paramLong * l1);
                localObject = this.b;
                localObject[j] = (l1 + localObject[j]);
                localObject = this.a;
                localObject[j] /= this.b[j];
              }
            }
          }
        }
      }
    }
    
    public void a(ObjectOutputStream paramObjectOutputStream, boolean paramBoolean)
      throws Throwable
    {
      int j = 0;
      int i;
      if (this.a != null)
      {
        i = this.a.length;
        if (!paramBoolean) {
          break label68;
        }
        paramObjectOutputStream.writeLong(i);
      }
      for (;;)
      {
        if (j >= i) {
          return;
        }
        paramObjectOutputStream.writeLong(this.a[j]);
        paramObjectOutputStream.writeLong(this.b[j]);
        j += 1;
        continue;
        i = 0;
        break;
        label68:
        paramObjectOutputStream.writeByte(i);
      }
    }
    
    public boolean a(long paramLong)
    {
      if (this.a != null)
      {
        int j = Arrays.binarySearch(this.a, paramLong);
        int i = j;
        if (j < 0)
        {
          j = -j - 1;
          QLog.d("GuardManager", 2, paramLong + " is the " + j + "th of " + Arrays.toString(this.a) + ", range reaches [" + (paramLong - h.b()) + ", " + (h.b() + paramLong) + "]");
          if ((j <= 0) || (paramLong - this.a[(j - 1)] > h.b())) {
            break label197;
          }
          i = j - 1;
        }
        while (i >= 0)
        {
          int m = this.a.length;
          paramLong = this.b[i];
          i = 0;
          j = 0;
          for (;;)
          {
            if (i < m)
            {
              int k = j;
              if (this.b[i] > paramLong) {
                k = j + 1;
              }
              i += 1;
              j = k;
              continue;
              label197:
              if (j < this.a.length)
              {
                i = j;
                if (this.a[j] - paramLong <= h.b()) {
                  break;
                }
              }
              i = -1;
              break;
            }
          }
          QLog.d("GuardManager", 2, "order: " + j + ", limit: " + h.c() + ", in " + Arrays.toString(this.b));
          if (j < h.c()) {
            return true;
          }
        }
      }
      return false;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\service\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */