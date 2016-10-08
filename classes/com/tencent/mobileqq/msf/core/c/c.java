package com.tencent.mobileqq.msf.core.c;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.w;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.utils.MonitorSocketStat;
import com.tencent.mobileqq.msf.sdk.utils.a;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class c
  extends BroadcastReceiver
{
  public static final String a = "MSF.C.MonitorNetFlowStore";
  static final String d = "SQQzoneSvcDev";
  public static final String e = "MONITOR_NetflowRdmReport";
  public static final String f = "MONITOR_NetflowRdmReportwithStatus";
  public static final String g = "MONITOR_NetflowRdmReport_TIME";
  public static final int h = 1;
  static SimpleDateFormat i = new SimpleDateFormat("dd HH:mm:ss");
  static final String j = "dataflow";
  private static Context l;
  private static b p;
  private static SQLiteDatabase q;
  public ConcurrentHashMap b = new ConcurrentHashMap();
  public ConcurrentHashMap c = new ConcurrentHashMap();
  private MsfCore k;
  private AlarmManager m;
  private String n = "";
  private PendingIntent o;
  
  public c(MsfCore paramMsfCore, Context paramContext)
  {
    this.k = paramMsfCore;
    l = paramContext;
  }
  
  /* Error */
  public static com.tencent.qphone.base.util.QLog.a a(long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: ldc 8
    //   2: iconst_1
    //   3: ldc 80
    //   5: invokestatic 85	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8: getstatic 87	com/tencent/mobileqq/msf/core/c/c:p	Lcom/tencent/mobileqq/msf/core/c/b;
    //   11: ifnonnull +16 -> 27
    //   14: new 89	com/tencent/mobileqq/msf/core/c/b
    //   17: dup
    //   18: getstatic 75	com/tencent/mobileqq/msf/core/c/c:l	Landroid/content/Context;
    //   21: invokespecial 92	com/tencent/mobileqq/msf/core/c/b:<init>	(Landroid/content/Context;)V
    //   24: putstatic 87	com/tencent/mobileqq/msf/core/c/c:p	Lcom/tencent/mobileqq/msf/core/c/b;
    //   27: getstatic 94	com/tencent/mobileqq/msf/core/c/c:q	Landroid/database/sqlite/SQLiteDatabase;
    //   30: ifnonnull +12 -> 42
    //   33: getstatic 87	com/tencent/mobileqq/msf/core/c/c:p	Lcom/tencent/mobileqq/msf/core/c/b;
    //   36: invokevirtual 98	com/tencent/mobileqq/msf/core/c/b:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   39: putstatic 94	com/tencent/mobileqq/msf/core/c/c:q	Landroid/database/sqlite/SQLiteDatabase;
    //   42: getstatic 94	com/tencent/mobileqq/msf/core/c/c:q	Landroid/database/sqlite/SQLiteDatabase;
    //   45: ldc 28
    //   47: bipush 7
    //   49: anewarray 100	java/lang/String
    //   52: dup
    //   53: iconst_0
    //   54: ldc 102
    //   56: aastore
    //   57: dup
    //   58: iconst_1
    //   59: ldc 104
    //   61: aastore
    //   62: dup
    //   63: iconst_2
    //   64: ldc 106
    //   66: aastore
    //   67: dup
    //   68: iconst_3
    //   69: ldc 108
    //   71: aastore
    //   72: dup
    //   73: iconst_4
    //   74: ldc 110
    //   76: aastore
    //   77: dup
    //   78: iconst_5
    //   79: ldc 112
    //   81: aastore
    //   82: dup
    //   83: bipush 6
    //   85: ldc 114
    //   87: aastore
    //   88: ldc 116
    //   90: iconst_2
    //   91: anewarray 100	java/lang/String
    //   94: dup
    //   95: iconst_0
    //   96: lload_0
    //   97: invokestatic 120	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   100: aastore
    //   101: dup
    //   102: iconst_1
    //   103: lload_2
    //   104: invokestatic 120	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   107: aastore
    //   108: aconst_null
    //   109: aconst_null
    //   110: aconst_null
    //   111: invokevirtual 126	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   114: astore 5
    //   116: aload 5
    //   118: ifnonnull +21 -> 139
    //   121: aload 5
    //   123: ifnull +10 -> 133
    //   126: aload 5
    //   128: invokeinterface 131 1 0
    //   133: aconst_null
    //   134: astore 4
    //   136: aload 4
    //   138: areturn
    //   139: aload 5
    //   141: astore 4
    //   143: new 133	java/io/File
    //   146: dup
    //   147: invokestatic 137	com/tencent/qphone/base/util/QLog:getLogPath	()Ljava/lang/String;
    //   150: invokespecial 138	java/io/File:<init>	(Ljava/lang/String;)V
    //   153: astore 6
    //   155: aload 5
    //   157: astore 4
    //   159: aload 6
    //   161: invokevirtual 142	java/io/File:exists	()Z
    //   164: istore 9
    //   166: iload 9
    //   168: istore 8
    //   170: iload 9
    //   172: ifne +14 -> 186
    //   175: aload 5
    //   177: astore 4
    //   179: aload 6
    //   181: invokevirtual 145	java/io/File:mkdirs	()Z
    //   184: istore 8
    //   186: iload 8
    //   188: ifne +17 -> 205
    //   191: aload 5
    //   193: ifnull +10 -> 203
    //   196: aload 5
    //   198: invokeinterface 131 1 0
    //   203: aconst_null
    //   204: areturn
    //   205: aload 5
    //   207: astore 4
    //   209: new 147	com/tencent/qphone/base/util/QLog$a
    //   212: dup
    //   213: aload 6
    //   215: ldc -107
    //   217: invokespecial 152	com/tencent/qphone/base/util/QLog$a:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   220: astore 6
    //   222: aload 5
    //   224: astore 4
    //   226: new 154	java/io/BufferedWriter
    //   229: dup
    //   230: new 156	java/io/OutputStreamWriter
    //   233: dup
    //   234: new 158	java/io/FileOutputStream
    //   237: dup
    //   238: aload 6
    //   240: invokespecial 161	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   243: invokespecial 164	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   246: invokespecial 167	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   249: astore 7
    //   251: aload 5
    //   253: astore 4
    //   255: aload 5
    //   257: invokeinterface 170 1 0
    //   262: pop
    //   263: aload 5
    //   265: astore 4
    //   267: aload 5
    //   269: invokeinterface 173 1 0
    //   274: ifne +210 -> 484
    //   277: aload 5
    //   279: astore 4
    //   281: aload 7
    //   283: new 175	java/lang/StringBuilder
    //   286: dup
    //   287: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   290: aload 5
    //   292: iconst_0
    //   293: invokeinterface 180 2 0
    //   298: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: ldc -70
    //   303: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: aload 5
    //   308: iconst_1
    //   309: invokeinterface 180 2 0
    //   314: invokestatic 192	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getShortUin	(Ljava/lang/String;)Ljava/lang/String;
    //   317: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: ldc -70
    //   322: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: aload 5
    //   327: iconst_2
    //   328: invokeinterface 196 2 0
    //   333: invokevirtual 199	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   336: ldc -70
    //   338: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: aload 5
    //   343: iconst_3
    //   344: invokeinterface 203 2 0
    //   349: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   352: ldc -70
    //   354: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: aload 5
    //   359: iconst_4
    //   360: invokeinterface 180 2 0
    //   365: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: ldc -70
    //   370: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: aload 5
    //   375: iconst_5
    //   376: invokeinterface 203 2 0
    //   381: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   384: ldc -70
    //   386: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: getstatic 56	com/tencent/mobileqq/msf/core/c/c:i	Ljava/text/SimpleDateFormat;
    //   392: aload 5
    //   394: bipush 6
    //   396: invokeinterface 196 2 0
    //   401: invokestatic 211	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   404: invokevirtual 215	java/text/SimpleDateFormat:format	(Ljava/lang/Object;)Ljava/lang/String;
    //   407: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: ldc -39
    //   412: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   418: invokevirtual 223	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   421: aload 5
    //   423: astore 4
    //   425: aload 5
    //   427: invokeinterface 226 1 0
    //   432: pop
    //   433: goto -170 -> 263
    //   436: astore 6
    //   438: aload 5
    //   440: astore 4
    //   442: ldc 8
    //   444: iconst_1
    //   445: new 175	java/lang/StringBuilder
    //   448: dup
    //   449: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   452: ldc -28
    //   454: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: aload 6
    //   459: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   462: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   465: aload 6
    //   467: invokestatic 234	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   470: aload 5
    //   472: ifnull +10 -> 482
    //   475: aload 5
    //   477: invokeinterface 131 1 0
    //   482: aconst_null
    //   483: areturn
    //   484: aload 5
    //   486: astore 4
    //   488: aload 7
    //   490: invokevirtual 237	java/io/BufferedWriter:flush	()V
    //   493: aload 5
    //   495: astore 4
    //   497: aload 7
    //   499: invokevirtual 238	java/io/BufferedWriter:close	()V
    //   502: aload 6
    //   504: astore 4
    //   506: aload 5
    //   508: ifnull -372 -> 136
    //   511: aload 5
    //   513: invokeinterface 131 1 0
    //   518: aload 6
    //   520: areturn
    //   521: astore 5
    //   523: aconst_null
    //   524: astore 4
    //   526: aload 4
    //   528: ifnull +10 -> 538
    //   531: aload 4
    //   533: invokeinterface 131 1 0
    //   538: aload 5
    //   540: athrow
    //   541: astore 5
    //   543: goto -17 -> 526
    //   546: astore 6
    //   548: aconst_null
    //   549: astore 5
    //   551: goto -113 -> 438
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	554	0	paramLong1	long
    //   0	554	2	paramLong2	long
    //   134	398	4	localObject1	Object
    //   114	398	5	localCursor	android.database.Cursor
    //   521	18	5	localObject2	Object
    //   541	1	5	localObject3	Object
    //   549	1	5	localObject4	Object
    //   153	86	6	localObject5	Object
    //   436	83	6	localException1	Exception
    //   546	1	6	localException2	Exception
    //   249	249	7	localBufferedWriter	java.io.BufferedWriter
    //   168	19	8	bool1	boolean
    //   164	7	9	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   143	155	436	java/lang/Exception
    //   159	166	436	java/lang/Exception
    //   179	186	436	java/lang/Exception
    //   209	222	436	java/lang/Exception
    //   226	251	436	java/lang/Exception
    //   255	263	436	java/lang/Exception
    //   267	277	436	java/lang/Exception
    //   281	421	436	java/lang/Exception
    //   425	433	436	java/lang/Exception
    //   488	493	436	java/lang/Exception
    //   497	502	436	java/lang/Exception
    //   8	27	521	finally
    //   27	42	521	finally
    //   42	116	521	finally
    //   143	155	541	finally
    //   159	166	541	finally
    //   179	186	541	finally
    //   209	222	541	finally
    //   226	251	541	finally
    //   255	263	541	finally
    //   267	277	541	finally
    //   281	421	541	finally
    //   425	433	541	finally
    //   442	470	541	finally
    //   488	493	541	finally
    //   497	502	541	finally
    //   8	27	546	java/lang/Exception
    //   27	42	546	java/lang/Exception
    //   42	116	546	java/lang/Exception
  }
  
  private void a(Context paramContext)
  {
    this.n = (MsfSdkUtils.getProcessName(paramContext) + "_" + getClass().hashCode());
    paramContext = new IntentFilter();
    paramContext.addAction(this.n);
    BaseApplication.getContext().registerReceiver(this, paramContext);
    if (QLog.isColorLevel())
    {
      a(System.currentTimeMillis() + 300000L);
      return;
    }
    a(System.currentTimeMillis() + 600000L);
  }
  
  public static void b(long paramLong)
  {
    try
    {
      if (p == null) {
        p = new b(l);
      }
      if (q == null) {
        q = p.getWritableDatabase();
      }
      int i1 = q.delete("dataflow", "curtime < ?", new String[] { String.valueOf(paramLong) });
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.MonitorNetFlowStore", 4, "delete netflow " + i1 + " record.");
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.d("MSF.C.MonitorNetFlowStore", 1, "delete expire data failed. " + localException, localException);
    }
  }
  
  /* Error */
  public java.util.HashMap a(long paramLong, boolean paramBoolean)
  {
    // Byte code:
    //   0: getstatic 75	com/tencent/mobileqq/msf/core/c/c:l	Landroid/content/Context;
    //   3: invokevirtual 308	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   6: ldc_w 310
    //   9: invokevirtual 316	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   12: astore 8
    //   14: new 318	java/util/Properties
    //   17: dup
    //   18: invokespecial 319	java/util/Properties:<init>	()V
    //   21: astore 10
    //   23: aload 10
    //   25: aload 8
    //   27: invokevirtual 323	java/util/Properties:loadFromXML	(Ljava/io/InputStream;)V
    //   30: invokestatic 329	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   33: astore 4
    //   35: aload 4
    //   37: bipush 6
    //   39: aload 4
    //   41: bipush 6
    //   43: invokevirtual 332	java/util/Calendar:get	(I)I
    //   46: iconst_1
    //   47: isub
    //   48: invokevirtual 336	java/util/Calendar:set	(II)V
    //   51: aload 4
    //   53: bipush 11
    //   55: iconst_0
    //   56: invokevirtual 336	java/util/Calendar:set	(II)V
    //   59: aload 4
    //   61: bipush 12
    //   63: iconst_0
    //   64: invokevirtual 336	java/util/Calendar:set	(II)V
    //   67: aload 4
    //   69: bipush 13
    //   71: iconst_0
    //   72: invokevirtual 336	java/util/Calendar:set	(II)V
    //   75: aload 4
    //   77: bipush 14
    //   79: iconst_0
    //   80: invokevirtual 336	java/util/Calendar:set	(II)V
    //   83: aload 4
    //   85: invokevirtual 339	java/util/Calendar:getTimeInMillis	()J
    //   88: lstore_1
    //   89: lload_1
    //   90: ldc2_w 340
    //   93: ladd
    //   94: lstore 17
    //   96: getstatic 87	com/tencent/mobileqq/msf/core/c/c:p	Lcom/tencent/mobileqq/msf/core/c/b;
    //   99: ifnonnull +16 -> 115
    //   102: new 89	com/tencent/mobileqq/msf/core/c/b
    //   105: dup
    //   106: getstatic 75	com/tencent/mobileqq/msf/core/c/c:l	Landroid/content/Context;
    //   109: invokespecial 92	com/tencent/mobileqq/msf/core/c/b:<init>	(Landroid/content/Context;)V
    //   112: putstatic 87	com/tencent/mobileqq/msf/core/c/c:p	Lcom/tencent/mobileqq/msf/core/c/b;
    //   115: getstatic 94	com/tencent/mobileqq/msf/core/c/c:q	Landroid/database/sqlite/SQLiteDatabase;
    //   118: ifnonnull +12 -> 130
    //   121: getstatic 87	com/tencent/mobileqq/msf/core/c/c:p	Lcom/tencent/mobileqq/msf/core/c/b;
    //   124: invokevirtual 98	com/tencent/mobileqq/msf/core/c/b:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   127: putstatic 94	com/tencent/mobileqq/msf/core/c/c:q	Landroid/database/sqlite/SQLiteDatabase;
    //   130: new 343	java/util/HashMap
    //   133: dup
    //   134: invokespecial 344	java/util/HashMap:<init>	()V
    //   137: astore 9
    //   139: iconst_0
    //   140: istore 13
    //   142: iload 13
    //   144: iconst_5
    //   145: if_icmpge +1361 -> 1506
    //   148: iload_3
    //   149: ifeq +101 -> 250
    //   152: getstatic 94	com/tencent/mobileqq/msf/core/c/c:q	Landroid/database/sqlite/SQLiteDatabase;
    //   155: ldc 28
    //   157: bipush 6
    //   159: anewarray 100	java/lang/String
    //   162: dup
    //   163: iconst_0
    //   164: ldc 102
    //   166: aastore
    //   167: dup
    //   168: iconst_1
    //   169: ldc 104
    //   171: aastore
    //   172: dup
    //   173: iconst_2
    //   174: ldc 106
    //   176: aastore
    //   177: dup
    //   178: iconst_3
    //   179: ldc 110
    //   181: aastore
    //   182: dup
    //   183: iconst_4
    //   184: ldc 112
    //   186: aastore
    //   187: dup
    //   188: iconst_5
    //   189: ldc_w 346
    //   192: aastore
    //   193: ldc_w 348
    //   196: iconst_3
    //   197: anewarray 100	java/lang/String
    //   200: dup
    //   201: iconst_0
    //   202: lload_1
    //   203: invokestatic 120	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   206: aastore
    //   207: dup
    //   208: iconst_1
    //   209: lload 17
    //   211: invokestatic 120	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   214: aastore
    //   215: dup
    //   216: iconst_2
    //   217: iload 13
    //   219: invokestatic 350	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   222: aastore
    //   223: aconst_null
    //   224: aconst_null
    //   225: aconst_null
    //   226: invokevirtual 126	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   229: astore 5
    //   231: aload 5
    //   233: ifnonnull +113 -> 346
    //   236: aload 5
    //   238: ifnull +10 -> 248
    //   241: aload 5
    //   243: invokeinterface 131 1 0
    //   248: aconst_null
    //   249: areturn
    //   250: getstatic 94	com/tencent/mobileqq/msf/core/c/c:q	Landroid/database/sqlite/SQLiteDatabase;
    //   253: ldc 28
    //   255: bipush 6
    //   257: anewarray 100	java/lang/String
    //   260: dup
    //   261: iconst_0
    //   262: ldc 102
    //   264: aastore
    //   265: dup
    //   266: iconst_1
    //   267: ldc 104
    //   269: aastore
    //   270: dup
    //   271: iconst_2
    //   272: ldc 106
    //   274: aastore
    //   275: dup
    //   276: iconst_3
    //   277: ldc 110
    //   279: aastore
    //   280: dup
    //   281: iconst_4
    //   282: ldc 112
    //   284: aastore
    //   285: dup
    //   286: iconst_5
    //   287: ldc_w 346
    //   290: aastore
    //   291: ldc_w 352
    //   294: iconst_5
    //   295: anewarray 100	java/lang/String
    //   298: dup
    //   299: iconst_0
    //   300: lload_1
    //   301: invokestatic 120	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   304: aastore
    //   305: dup
    //   306: iconst_1
    //   307: lload 17
    //   309: invokestatic 120	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   312: aastore
    //   313: dup
    //   314: iconst_2
    //   315: iconst_2
    //   316: invokestatic 350	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   319: aastore
    //   320: dup
    //   321: iconst_3
    //   322: iconst_3
    //   323: invokestatic 350	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   326: aastore
    //   327: dup
    //   328: iconst_4
    //   329: iload 13
    //   331: invokestatic 350	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   334: aastore
    //   335: aconst_null
    //   336: aconst_null
    //   337: aconst_null
    //   338: invokevirtual 126	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   341: astore 5
    //   343: goto -112 -> 231
    //   346: aload 5
    //   348: invokeinterface 170 1 0
    //   353: pop
    //   354: iload 13
    //   356: ifne +565 -> 921
    //   359: iconst_1
    //   360: istore 15
    //   362: aload 5
    //   364: invokeinterface 173 1 0
    //   369: ifne +1432 -> 1801
    //   372: aload 5
    //   374: iconst_0
    //   375: invokeinterface 180 2 0
    //   380: astore 6
    //   382: aload 5
    //   384: iconst_1
    //   385: invokeinterface 180 2 0
    //   390: astore 11
    //   392: aload 5
    //   394: iconst_2
    //   395: invokeinterface 196 2 0
    //   400: lstore 19
    //   402: aload 5
    //   404: iconst_3
    //   405: invokeinterface 180 2 0
    //   410: astore 4
    //   412: aload 5
    //   414: iconst_4
    //   415: invokeinterface 203 2 0
    //   420: istore 16
    //   422: iload 16
    //   424: iconst_3
    //   425: if_icmpeq +503 -> 928
    //   428: iload 16
    //   430: iconst_2
    //   431: if_icmpeq +497 -> 928
    //   434: iconst_1
    //   435: istore 14
    //   437: aload 6
    //   439: ldc_w 354
    //   442: invokevirtual 358	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   445: ifne +1400 -> 1845
    //   448: aload 4
    //   450: ldc_w 360
    //   453: invokevirtual 364	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   456: ifne +1389 -> 1845
    //   459: aload 4
    //   461: ldc_w 366
    //   464: invokevirtual 364	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   467: ifne +1378 -> 1845
    //   470: aload 4
    //   472: ldc_w 368
    //   475: invokevirtual 364	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   478: ifne +1367 -> 1845
    //   481: aload 6
    //   483: ldc_w 370
    //   486: invokevirtual 358	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   489: ifeq +461 -> 950
    //   492: aload 4
    //   494: ldc 11
    //   496: invokevirtual 373	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   499: ifeq +537 -> 1036
    //   502: aload 10
    //   504: new 175	java/lang/StringBuilder
    //   507: dup
    //   508: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   511: ldc 11
    //   513: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: iload 14
    //   518: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   521: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   524: invokevirtual 376	java/util/Properties:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   527: checkcast 100	java/lang/String
    //   530: astore 6
    //   532: aload 9
    //   534: aload 11
    //   536: invokevirtual 379	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   539: ifeq +779 -> 1318
    //   542: aload 9
    //   544: aload 11
    //   546: invokevirtual 380	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   549: checkcast 382	android/util/SparseArray
    //   552: iload 15
    //   554: invokevirtual 385	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   557: ifnonnull +29 -> 586
    //   560: new 343	java/util/HashMap
    //   563: dup
    //   564: invokespecial 344	java/util/HashMap:<init>	()V
    //   567: astore 7
    //   569: aload 9
    //   571: aload 11
    //   573: invokevirtual 380	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   576: checkcast 382	android/util/SparseArray
    //   579: iload 15
    //   581: aload 7
    //   583: invokevirtual 389	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   586: aload 6
    //   588: ifnonnull +584 -> 1172
    //   591: new 175	java/lang/StringBuilder
    //   594: dup
    //   595: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   598: astore 12
    //   600: iload 14
    //   602: iconst_1
    //   603: if_icmpne +1248 -> 1851
    //   606: ldc_w 391
    //   609: astore 7
    //   611: aload 12
    //   613: aload 7
    //   615: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: aload 4
    //   620: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: ldc_w 393
    //   626: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   629: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   632: astore 4
    //   634: aload 9
    //   636: aload 11
    //   638: invokevirtual 380	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   641: checkcast 382	android/util/SparseArray
    //   644: iload 15
    //   646: invokevirtual 385	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   649: checkcast 343	java/util/HashMap
    //   652: aload 4
    //   654: invokevirtual 379	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   657: ifeq +412 -> 1069
    //   660: aload 9
    //   662: aload 11
    //   664: invokevirtual 380	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   667: checkcast 382	android/util/SparseArray
    //   670: iload 15
    //   672: invokevirtual 385	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   675: checkcast 343	java/util/HashMap
    //   678: astore 7
    //   680: aload 7
    //   682: aload 4
    //   684: aload 7
    //   686: aload 4
    //   688: invokevirtual 380	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   691: checkcast 208	java/lang/Long
    //   694: invokevirtual 396	java/lang/Long:longValue	()J
    //   697: lload 19
    //   699: ladd
    //   700: invokestatic 211	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   703: invokevirtual 399	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   706: pop
    //   707: aload 9
    //   709: aload 11
    //   711: invokevirtual 380	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   714: checkcast 382	android/util/SparseArray
    //   717: iload 15
    //   719: aload 7
    //   721: invokevirtual 389	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   724: iload_3
    //   725: ifeq +19 -> 744
    //   728: aload 6
    //   730: ifnull +14 -> 744
    //   733: aload 6
    //   735: ldc_w 391
    //   738: invokevirtual 373	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   741: ifne +18 -> 759
    //   744: iload_3
    //   745: ifeq +105 -> 850
    //   748: aload 4
    //   750: ldc_w 391
    //   753: invokevirtual 373	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   756: ifeq +94 -> 850
    //   759: aload 9
    //   761: aload 11
    //   763: invokevirtual 380	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   766: checkcast 382	android/util/SparseArray
    //   769: iload 15
    //   771: invokevirtual 385	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   774: checkcast 343	java/util/HashMap
    //   777: astore 4
    //   779: aload 4
    //   781: ifnonnull +1067 -> 1848
    //   784: new 343	java/util/HashMap
    //   787: dup
    //   788: invokespecial 344	java/util/HashMap:<init>	()V
    //   791: astore 4
    //   793: aload 4
    //   795: ldc_w 401
    //   798: invokevirtual 379	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   801: ifeq +671 -> 1472
    //   804: aload 4
    //   806: ldc_w 401
    //   809: lload 19
    //   811: aload 4
    //   813: ldc_w 401
    //   816: invokevirtual 380	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   819: checkcast 208	java/lang/Long
    //   822: invokevirtual 396	java/lang/Long:longValue	()J
    //   825: ladd
    //   826: invokestatic 211	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   829: invokevirtual 399	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   832: pop
    //   833: aload 9
    //   835: aload 11
    //   837: invokevirtual 380	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   840: checkcast 382	android/util/SparseArray
    //   843: iload 15
    //   845: aload 4
    //   847: invokevirtual 389	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   850: aload 5
    //   852: invokeinterface 226 1 0
    //   857: pop
    //   858: goto -496 -> 362
    //   861: astore 6
    //   863: aload 5
    //   865: astore 4
    //   867: aload 6
    //   869: astore 5
    //   871: ldc 8
    //   873: iconst_1
    //   874: new 175	java/lang/StringBuilder
    //   877: dup
    //   878: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   881: ldc_w 403
    //   884: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   887: aload 5
    //   889: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   892: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   895: aload 5
    //   897: invokestatic 234	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   900: aload 4
    //   902: ifnull +10 -> 912
    //   905: aload 4
    //   907: invokeinterface 131 1 0
    //   912: iload 13
    //   914: iconst_1
    //   915: iadd
    //   916: istore 13
    //   918: goto -776 -> 142
    //   921: iload 13
    //   923: istore 15
    //   925: goto -563 -> 362
    //   928: iload 16
    //   930: iconst_2
    //   931: if_icmpeq +13 -> 944
    //   934: iload 16
    //   936: istore 14
    //   938: iload 16
    //   940: iconst_3
    //   941: if_icmpne -504 -> 437
    //   944: iconst_2
    //   945: istore 14
    //   947: goto -510 -> 437
    //   950: aload 6
    //   952: ldc_w 405
    //   955: invokevirtual 358	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   958: ifeq +11 -> 969
    //   961: ldc_w 407
    //   964: astore 4
    //   966: goto -474 -> 492
    //   969: aload 6
    //   971: ldc_w 409
    //   974: invokevirtual 413	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   977: ifeq +868 -> 1845
    //   980: aload 6
    //   982: ldc_w 409
    //   985: invokevirtual 417	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   988: istore 16
    //   990: new 175	java/lang/StringBuilder
    //   993: dup
    //   994: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   997: aload 6
    //   999: iload 16
    //   1001: iconst_1
    //   1002: iadd
    //   1003: iload 16
    //   1005: iconst_2
    //   1006: iadd
    //   1007: invokevirtual 421	java/lang/String:substring	(II)Ljava/lang/String;
    //   1010: invokevirtual 424	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   1013: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1016: aload 6
    //   1018: iload 16
    //   1020: iconst_2
    //   1021: iadd
    //   1022: invokevirtual 426	java/lang/String:substring	(I)Ljava/lang/String;
    //   1025: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1028: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1031: astore 4
    //   1033: goto -541 -> 492
    //   1036: aload 10
    //   1038: new 175	java/lang/StringBuilder
    //   1041: dup
    //   1042: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   1045: aload 4
    //   1047: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1050: iload 14
    //   1052: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1055: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1058: invokevirtual 376	java/util/Properties:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1061: checkcast 100	java/lang/String
    //   1064: astore 6
    //   1066: goto -534 -> 532
    //   1069: aload 9
    //   1071: aload 11
    //   1073: invokevirtual 380	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1076: checkcast 382	android/util/SparseArray
    //   1079: iload 15
    //   1081: invokevirtual 385	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   1084: checkcast 343	java/util/HashMap
    //   1087: astore 7
    //   1089: aload 7
    //   1091: aload 4
    //   1093: lload 19
    //   1095: invokestatic 211	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1098: invokevirtual 399	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1101: pop
    //   1102: aload 9
    //   1104: aload 11
    //   1106: invokevirtual 380	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1109: checkcast 382	android/util/SparseArray
    //   1112: iload 15
    //   1114: aload 7
    //   1116: invokevirtual 389	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   1119: goto -395 -> 724
    //   1122: astore 4
    //   1124: aload 5
    //   1126: ifnull +10 -> 1136
    //   1129: aload 5
    //   1131: invokeinterface 131 1 0
    //   1136: aload 4
    //   1138: athrow
    //   1139: astore 4
    //   1141: ldc 8
    //   1143: iconst_1
    //   1144: new 175	java/lang/StringBuilder
    //   1147: dup
    //   1148: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   1151: ldc_w 428
    //   1154: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1157: aload 4
    //   1159: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1162: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1165: aload 4
    //   1167: invokestatic 234	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1170: aconst_null
    //   1171: areturn
    //   1172: aload 9
    //   1174: aload 11
    //   1176: invokevirtual 380	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1179: checkcast 382	android/util/SparseArray
    //   1182: iload 15
    //   1184: invokevirtual 385	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   1187: checkcast 343	java/util/HashMap
    //   1190: aload 6
    //   1192: invokevirtual 379	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   1195: ifeq +70 -> 1265
    //   1198: aload 9
    //   1200: aload 11
    //   1202: invokevirtual 380	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1205: checkcast 382	android/util/SparseArray
    //   1208: iload 15
    //   1210: invokevirtual 385	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   1213: checkcast 343	java/util/HashMap
    //   1216: astore 7
    //   1218: aload 7
    //   1220: aload 6
    //   1222: aload 7
    //   1224: aload 6
    //   1226: invokevirtual 380	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1229: checkcast 208	java/lang/Long
    //   1232: invokevirtual 396	java/lang/Long:longValue	()J
    //   1235: lload 19
    //   1237: ladd
    //   1238: invokestatic 211	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1241: invokevirtual 399	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1244: pop
    //   1245: aload 9
    //   1247: aload 11
    //   1249: invokevirtual 380	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1252: checkcast 382	android/util/SparseArray
    //   1255: iload 15
    //   1257: aload 7
    //   1259: invokevirtual 389	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   1262: goto -538 -> 724
    //   1265: aload 9
    //   1267: aload 11
    //   1269: invokevirtual 380	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1272: checkcast 382	android/util/SparseArray
    //   1275: iload 15
    //   1277: invokevirtual 385	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   1280: checkcast 343	java/util/HashMap
    //   1283: astore 7
    //   1285: aload 7
    //   1287: aload 6
    //   1289: lload 19
    //   1291: invokestatic 211	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1294: invokevirtual 399	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1297: pop
    //   1298: aload 9
    //   1300: aload 11
    //   1302: invokevirtual 380	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1305: checkcast 382	android/util/SparseArray
    //   1308: iload 15
    //   1310: aload 7
    //   1312: invokevirtual 389	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   1315: goto -591 -> 724
    //   1318: aload 6
    //   1320: ifnonnull +99 -> 1419
    //   1323: new 175	java/lang/StringBuilder
    //   1326: dup
    //   1327: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   1330: astore 12
    //   1332: iload 14
    //   1334: iconst_1
    //   1335: if_icmpne +524 -> 1859
    //   1338: ldc_w 391
    //   1341: astore 7
    //   1343: aload 12
    //   1345: aload 7
    //   1347: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1350: aload 4
    //   1352: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1355: ldc_w 393
    //   1358: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1361: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1364: astore 4
    //   1366: new 343	java/util/HashMap
    //   1369: dup
    //   1370: invokespecial 344	java/util/HashMap:<init>	()V
    //   1373: astore 7
    //   1375: aload 7
    //   1377: aload 4
    //   1379: lload 19
    //   1381: invokestatic 211	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1384: invokevirtual 399	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1387: pop
    //   1388: new 382	android/util/SparseArray
    //   1391: dup
    //   1392: invokespecial 429	android/util/SparseArray:<init>	()V
    //   1395: astore 12
    //   1397: aload 12
    //   1399: iload 15
    //   1401: aload 7
    //   1403: invokevirtual 389	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   1406: aload 9
    //   1408: aload 11
    //   1410: aload 12
    //   1412: invokevirtual 399	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1415: pop
    //   1416: goto -692 -> 724
    //   1419: new 343	java/util/HashMap
    //   1422: dup
    //   1423: invokespecial 344	java/util/HashMap:<init>	()V
    //   1426: astore 7
    //   1428: aload 7
    //   1430: aload 6
    //   1432: lload 19
    //   1434: invokestatic 211	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1437: invokevirtual 399	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1440: pop
    //   1441: new 382	android/util/SparseArray
    //   1444: dup
    //   1445: invokespecial 429	android/util/SparseArray:<init>	()V
    //   1448: astore 12
    //   1450: aload 12
    //   1452: iload 15
    //   1454: aload 7
    //   1456: invokevirtual 389	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   1459: aload 9
    //   1461: aload 11
    //   1463: aload 12
    //   1465: invokevirtual 399	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1468: pop
    //   1469: goto -745 -> 724
    //   1472: aload 4
    //   1474: ldc_w 401
    //   1477: lload 19
    //   1479: invokestatic 211	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1482: invokevirtual 399	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1485: pop
    //   1486: aload 9
    //   1488: aload 11
    //   1490: invokevirtual 380	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1493: checkcast 382	android/util/SparseArray
    //   1496: iload 15
    //   1498: aload 4
    //   1500: invokevirtual 389	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   1503: goto -653 -> 850
    //   1506: invokestatic 273	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1509: ifeq +284 -> 1793
    //   1512: aload 9
    //   1514: invokevirtual 433	java/util/HashMap:keySet	()Ljava/util/Set;
    //   1517: invokeinterface 439 1 0
    //   1522: astore 4
    //   1524: aload 4
    //   1526: invokeinterface 444 1 0
    //   1531: ifeq +262 -> 1793
    //   1534: aload 4
    //   1536: invokeinterface 448 1 0
    //   1541: checkcast 100	java/lang/String
    //   1544: astore 5
    //   1546: iconst_1
    //   1547: istore 13
    //   1549: iload 13
    //   1551: iconst_5
    //   1552: if_icmpge -28 -> 1524
    //   1555: aload 9
    //   1557: aload 5
    //   1559: invokevirtual 380	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1562: checkcast 382	android/util/SparseArray
    //   1565: iload 13
    //   1567: invokevirtual 385	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   1570: checkcast 343	java/util/HashMap
    //   1573: astore 6
    //   1575: aload 6
    //   1577: ifnonnull +6 -> 1583
    //   1580: goto +287 -> 1867
    //   1583: aload 6
    //   1585: invokevirtual 433	java/util/HashMap:keySet	()Ljava/util/Set;
    //   1588: invokeinterface 439 1 0
    //   1593: astore 6
    //   1595: aload 6
    //   1597: invokeinterface 444 1 0
    //   1602: ifeq +265 -> 1867
    //   1605: aload 6
    //   1607: invokeinterface 448 1 0
    //   1612: checkcast 100	java/lang/String
    //   1615: astore 7
    //   1617: iload_3
    //   1618: ifeq +89 -> 1707
    //   1621: ldc 8
    //   1623: iconst_2
    //   1624: new 175	java/lang/StringBuilder
    //   1627: dup
    //   1628: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   1631: ldc_w 450
    //   1634: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1637: aload 5
    //   1639: invokestatic 192	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getShortUin	(Ljava/lang/String;)Ljava/lang/String;
    //   1642: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1645: ldc_w 452
    //   1648: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1651: aload 7
    //   1653: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1656: ldc_w 454
    //   1659: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1662: aload 9
    //   1664: aload 5
    //   1666: invokevirtual 380	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1669: checkcast 382	android/util/SparseArray
    //   1672: iload 13
    //   1674: invokevirtual 385	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   1677: checkcast 343	java/util/HashMap
    //   1680: aload 7
    //   1682: invokevirtual 380	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1685: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1688: ldc -70
    //   1690: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1693: iload 13
    //   1695: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1698: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1701: invokestatic 85	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1704: goto -109 -> 1595
    //   1707: ldc 8
    //   1709: iconst_2
    //   1710: new 175	java/lang/StringBuilder
    //   1713: dup
    //   1714: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   1717: ldc_w 456
    //   1720: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1723: aload 5
    //   1725: invokestatic 192	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getShortUin	(Ljava/lang/String;)Ljava/lang/String;
    //   1728: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1731: ldc_w 452
    //   1734: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1737: aload 7
    //   1739: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1742: ldc_w 454
    //   1745: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1748: aload 9
    //   1750: aload 5
    //   1752: invokevirtual 380	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1755: checkcast 382	android/util/SparseArray
    //   1758: iload 13
    //   1760: invokevirtual 385	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   1763: checkcast 343	java/util/HashMap
    //   1766: aload 7
    //   1768: invokevirtual 380	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1771: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1774: ldc -70
    //   1776: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1779: iload 13
    //   1781: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1784: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1787: invokestatic 85	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1790: goto -195 -> 1595
    //   1793: aload 8
    //   1795: invokevirtual 459	java/io/InputStream:close	()V
    //   1798: aload 9
    //   1800: areturn
    //   1801: aload 5
    //   1803: ifnull -891 -> 912
    //   1806: aload 5
    //   1808: invokeinterface 131 1 0
    //   1813: goto -901 -> 912
    //   1816: astore 4
    //   1818: aconst_null
    //   1819: astore 5
    //   1821: goto -697 -> 1124
    //   1824: astore 6
    //   1826: aload 4
    //   1828: astore 5
    //   1830: aload 6
    //   1832: astore 4
    //   1834: goto -710 -> 1124
    //   1837: astore 5
    //   1839: aconst_null
    //   1840: astore 4
    //   1842: goto -971 -> 871
    //   1845: goto -1353 -> 492
    //   1848: goto -1055 -> 793
    //   1851: ldc_w 461
    //   1854: astore 7
    //   1856: goto -1245 -> 611
    //   1859: ldc_w 461
    //   1862: astore 7
    //   1864: goto -521 -> 1343
    //   1867: iload 13
    //   1869: iconst_1
    //   1870: iadd
    //   1871: istore 13
    //   1873: goto -324 -> 1549
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1876	0	this	c
    //   0	1876	1	paramLong	long
    //   0	1876	3	paramBoolean	boolean
    //   33	1059	4	localObject1	Object
    //   1122	15	4	localObject2	Object
    //   1139	212	4	localException1	Exception
    //   1364	171	4	localObject3	Object
    //   1816	11	4	localObject4	Object
    //   1832	9	4	localObject5	Object
    //   229	1600	5	localObject6	Object
    //   1837	1	5	localException2	Exception
    //   380	354	6	str1	String
    //   861	156	6	localException3	Exception
    //   1064	542	6	localObject7	Object
    //   1824	7	6	localObject8	Object
    //   567	1296	7	localObject9	Object
    //   12	1782	8	localInputStream	java.io.InputStream
    //   137	1662	9	localHashMap	java.util.HashMap
    //   21	1016	10	localProperties	java.util.Properties
    //   390	1099	11	str2	String
    //   598	866	12	localObject10	Object
    //   140	1732	13	i1	int
    //   435	901	14	i2	int
    //   360	1137	15	i3	int
    //   420	602	16	i4	int
    //   94	214	17	l1	long
    //   400	1078	19	l2	long
    // Exception table:
    //   from	to	target	type
    //   346	354	861	java/lang/Exception
    //   362	422	861	java/lang/Exception
    //   437	492	861	java/lang/Exception
    //   492	532	861	java/lang/Exception
    //   532	586	861	java/lang/Exception
    //   591	600	861	java/lang/Exception
    //   611	724	861	java/lang/Exception
    //   733	744	861	java/lang/Exception
    //   748	759	861	java/lang/Exception
    //   759	779	861	java/lang/Exception
    //   784	793	861	java/lang/Exception
    //   793	850	861	java/lang/Exception
    //   850	858	861	java/lang/Exception
    //   950	961	861	java/lang/Exception
    //   969	1033	861	java/lang/Exception
    //   1036	1066	861	java/lang/Exception
    //   1069	1119	861	java/lang/Exception
    //   1172	1262	861	java/lang/Exception
    //   1265	1315	861	java/lang/Exception
    //   1323	1332	861	java/lang/Exception
    //   1343	1416	861	java/lang/Exception
    //   1419	1469	861	java/lang/Exception
    //   1472	1503	861	java/lang/Exception
    //   346	354	1122	finally
    //   362	422	1122	finally
    //   437	492	1122	finally
    //   492	532	1122	finally
    //   532	586	1122	finally
    //   591	600	1122	finally
    //   611	724	1122	finally
    //   733	744	1122	finally
    //   748	759	1122	finally
    //   759	779	1122	finally
    //   784	793	1122	finally
    //   793	850	1122	finally
    //   850	858	1122	finally
    //   950	961	1122	finally
    //   969	1033	1122	finally
    //   1036	1066	1122	finally
    //   1069	1119	1122	finally
    //   1172	1262	1122	finally
    //   1265	1315	1122	finally
    //   1323	1332	1122	finally
    //   1343	1416	1122	finally
    //   1419	1469	1122	finally
    //   1472	1503	1122	finally
    //   0	89	1139	java/lang/Exception
    //   96	115	1139	java/lang/Exception
    //   115	130	1139	java/lang/Exception
    //   130	139	1139	java/lang/Exception
    //   241	248	1139	java/lang/Exception
    //   905	912	1139	java/lang/Exception
    //   1129	1136	1139	java/lang/Exception
    //   1136	1139	1139	java/lang/Exception
    //   1506	1524	1139	java/lang/Exception
    //   1524	1546	1139	java/lang/Exception
    //   1555	1575	1139	java/lang/Exception
    //   1583	1595	1139	java/lang/Exception
    //   1595	1617	1139	java/lang/Exception
    //   1621	1704	1139	java/lang/Exception
    //   1707	1790	1139	java/lang/Exception
    //   1793	1798	1139	java/lang/Exception
    //   1806	1813	1139	java/lang/Exception
    //   152	231	1816	finally
    //   250	343	1816	finally
    //   871	900	1824	finally
    //   152	231	1837	java/lang/Exception
    //   250	343	1837	java/lang/Exception
  }
  
  public void a()
  {
    int i2 = 0;
    try
    {
      if (p == null) {
        p = new b(l);
      }
      if (q == null) {
        q = p.getWritableDatabase();
      }
      long l1 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.MonitorNetFlowStore", 2, "write data : " + this.b.size() + " | read data : " + this.c.size() + ", starting to store.");
      }
      Iterator localIterator = this.b.keySet().iterator();
      int i1 = 0;
      String str;
      a locala;
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        locala = (a)this.b.get(str);
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.MonitorNetFlowStore", 2, "mType|" + locala.h + "|" + locala.b + "|" + locala.d + "|write|" + locala.f + "|" + locala.g + "|" + locala.i + "|" + locala.a);
        }
        q.execSQL("insert into dataflow(processName, uin, ip, refer, port, flag, buffersize, networktype, mType, curtime, status) values(?,?,?,?,?,?,?,?,?,?,?)", new Object[] { locala.a, this.k.sender.e(), locala.b, locala.c, Integer.valueOf(locala.d), Integer.valueOf(locala.e), Long.valueOf(locala.f), Integer.valueOf(locala.g), locala.h, Long.valueOf(l1), Byte.valueOf(locala.i) });
        i1 = (int)(i1 + ((a)this.b.get(str)).f);
        this.b.remove(str);
      }
      localIterator = this.c.keySet().iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        locala = (a)this.c.get(str);
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.MonitorNetFlowStore", 2, "mType|" + locala.h + "|" + locala.b + "|" + locala.d + "|read|" + locala.f + "|" + locala.g + "|" + locala.i + "|" + locala.a);
        }
        q.execSQL("insert into dataflow(processName, uin, ip, refer, port, flag, buffersize, networktype, mType, curtime, status) values(?,?,?,?,?,?,?,?,?,?,?)", new Object[] { locala.a, this.k.sender.e(), locala.b, locala.c, Integer.valueOf(locala.d), Integer.valueOf(locala.e), Long.valueOf(locala.f), Integer.valueOf(locala.g), locala.h, Long.valueOf(l1), Byte.valueOf(locala.i) });
        long l2 = i2;
        i2 = (int)(((a)this.c.get(str)).f + l2);
        this.c.remove(str);
      }
      QLog.d("MSF.C.MonitorNetFlowStore", 1, "write data lenth : " + i1 + " | read data lenth : " + i2 + ", has been stored.");
      i.a(System.currentTimeMillis(), 1);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("MSF.C.MonitorNetFlowStore", 1, "data store failed.", localException);
    }
  }
  
  public void a(long paramLong)
  {
    Intent localIntent = new Intent(this.n);
    localIntent.setAction(this.n);
    this.o = PendingIntent.getBroadcast(BaseApplication.getContext(), 0, localIntent, 0);
    this.m = ((AlarmManager)BaseApplication.getContext().getSystemService("alarm"));
    if (QLog.isColorLevel()) {
      this.m.setRepeating(0, paramLong, 300000L, this.o);
    }
    for (;;)
    {
      QLog.d("MSF.C.MonitorNetFlowStore", 1, "register " + this.n.hashCode() + " alarm alive send at " + i.format(Long.valueOf(paramLong)));
      return;
      this.m.setRepeating(0, paramLong, 600000L, this.o);
    }
  }
  
  public void a(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.MonitorNetFlowStore", 2, "receive broadcast : " + paramIntent.getAction() + ", start to store socket flow at " + i.format(Long.valueOf(System.currentTimeMillis())));
    }
    try
    {
      if (p == null) {
        p = new b(paramContext);
      }
      if (q == null) {
        q = p.getWritableDatabase();
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        QLog.d("MSF.C.MonitorNetFlowStore", 1, "create DBHelper failed.", paramContext);
      }
      new d(this).start();
    }
    if ((this.b.isEmpty()) && (this.c.isEmpty())) {
      return;
    }
  }
  
  public void a(a parama)
  {
    try
    {
      switch (parama.e)
      {
      case 0: 
        locala = (a)this.b.get(parama.h + parama.g + parama.i);
        if (locala != null)
        {
          this.b.put(parama.h + parama.g + parama.i, locala.a(parama.f));
          return;
        }
        break;
      }
    }
    catch (Exception parama)
    {
      QLog.d("MSF.C.MonitorNetFlowStore", 1, "MonitorDataFlow cache failed.", parama);
      return;
    }
    this.b.put(parama.h + parama.g + parama.i, parama);
    return;
    a locala = (a)this.c.get(parama.h + parama.g + parama.i);
    if (locala != null)
    {
      this.c.put(parama.h + parama.g + parama.i, locala.a(parama.f));
      return;
    }
    this.c.put(parama.h + parama.g + parama.i, parama);
    return;
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    for (;;)
    {
      try
      {
        paramToServiceMsg = paramToServiceMsg.extraData;
        a locala = new a(paramToServiceMsg.getString("ip"), paramToServiceMsg.getString("refer"), paramToServiceMsg.getInt("port"), paramToServiceMsg.getInt("flag"), paramToServiceMsg.getLong("buffersize"), paramToServiceMsg.getInt("networktype"));
        locala.a = paramToServiceMsg.getString("processName");
        locala.i = paramToServiceMsg.getByte("status");
        if (paramToServiceMsg.getString("mType").startsWith("LongConn")) {
          locala.i = MonitorSocketStat.STATUS;
        }
        int i1 = paramToServiceMsg.getString("mType").indexOf(".");
        if (i1 != -1)
        {
          if (paramToServiceMsg.getString("mType").indexOf(".", i1 + 1) != -1)
          {
            locala.h = paramToServiceMsg.getString("mType");
            a(locala);
            return;
          }
          locala.h = paramToServiceMsg.getString("mType").substring(0, i1);
          continue;
        }
        locala.h = paramToServiceMsg.getString("mType");
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.d("MSF.C.MonitorNetFlowStore", 1, "ToServiceMsg analysis error.", paramToServiceMsg);
        return;
      }
    }
  }
  
  /* Error */
  public java.util.HashMap b(long paramLong, boolean paramBoolean)
  {
    // Byte code:
    //   0: getstatic 75	com/tencent/mobileqq/msf/core/c/c:l	Landroid/content/Context;
    //   3: invokevirtual 308	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   6: ldc_w 310
    //   9: invokevirtual 316	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   12: astore 8
    //   14: new 318	java/util/Properties
    //   17: dup
    //   18: invokespecial 319	java/util/Properties:<init>	()V
    //   21: astore 9
    //   23: aload 9
    //   25: aload 8
    //   27: invokevirtual 323	java/util/Properties:loadFromXML	(Ljava/io/InputStream;)V
    //   30: invokestatic 329	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   33: astore 4
    //   35: aload 4
    //   37: bipush 6
    //   39: aload 4
    //   41: bipush 6
    //   43: invokevirtual 332	java/util/Calendar:get	(I)I
    //   46: iconst_1
    //   47: isub
    //   48: invokevirtual 336	java/util/Calendar:set	(II)V
    //   51: aload 4
    //   53: bipush 11
    //   55: iconst_0
    //   56: invokevirtual 336	java/util/Calendar:set	(II)V
    //   59: aload 4
    //   61: bipush 12
    //   63: iconst_0
    //   64: invokevirtual 336	java/util/Calendar:set	(II)V
    //   67: aload 4
    //   69: bipush 13
    //   71: iconst_0
    //   72: invokevirtual 336	java/util/Calendar:set	(II)V
    //   75: aload 4
    //   77: bipush 14
    //   79: iconst_0
    //   80: invokevirtual 336	java/util/Calendar:set	(II)V
    //   83: aload 4
    //   85: invokevirtual 339	java/util/Calendar:getTimeInMillis	()J
    //   88: lstore_1
    //   89: lload_1
    //   90: ldc2_w 340
    //   93: ladd
    //   94: lstore 15
    //   96: getstatic 87	com/tencent/mobileqq/msf/core/c/c:p	Lcom/tencent/mobileqq/msf/core/c/b;
    //   99: ifnonnull +16 -> 115
    //   102: new 89	com/tencent/mobileqq/msf/core/c/b
    //   105: dup
    //   106: getstatic 75	com/tencent/mobileqq/msf/core/c/c:l	Landroid/content/Context;
    //   109: invokespecial 92	com/tencent/mobileqq/msf/core/c/b:<init>	(Landroid/content/Context;)V
    //   112: putstatic 87	com/tencent/mobileqq/msf/core/c/c:p	Lcom/tencent/mobileqq/msf/core/c/b;
    //   115: getstatic 94	com/tencent/mobileqq/msf/core/c/c:q	Landroid/database/sqlite/SQLiteDatabase;
    //   118: ifnonnull +12 -> 130
    //   121: getstatic 87	com/tencent/mobileqq/msf/core/c/c:p	Lcom/tencent/mobileqq/msf/core/c/b;
    //   124: invokevirtual 98	com/tencent/mobileqq/msf/core/c/b:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   127: putstatic 94	com/tencent/mobileqq/msf/core/c/c:q	Landroid/database/sqlite/SQLiteDatabase;
    //   130: iload_3
    //   131: ifeq +92 -> 223
    //   134: getstatic 94	com/tencent/mobileqq/msf/core/c/c:q	Landroid/database/sqlite/SQLiteDatabase;
    //   137: ldc 28
    //   139: bipush 6
    //   141: anewarray 100	java/lang/String
    //   144: dup
    //   145: iconst_0
    //   146: ldc 102
    //   148: aastore
    //   149: dup
    //   150: iconst_1
    //   151: ldc 104
    //   153: aastore
    //   154: dup
    //   155: iconst_2
    //   156: ldc 106
    //   158: aastore
    //   159: dup
    //   160: iconst_3
    //   161: ldc 110
    //   163: aastore
    //   164: dup
    //   165: iconst_4
    //   166: ldc 112
    //   168: aastore
    //   169: dup
    //   170: iconst_5
    //   171: ldc_w 346
    //   174: aastore
    //   175: ldc 116
    //   177: iconst_2
    //   178: anewarray 100	java/lang/String
    //   181: dup
    //   182: iconst_0
    //   183: lload_1
    //   184: invokestatic 120	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   187: aastore
    //   188: dup
    //   189: iconst_1
    //   190: lload 15
    //   192: invokestatic 120	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   195: aastore
    //   196: aconst_null
    //   197: aconst_null
    //   198: aconst_null
    //   199: invokevirtual 126	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   202: astore 5
    //   204: aload 5
    //   206: ifnonnull +105 -> 311
    //   209: aload 5
    //   211: ifnull +10 -> 221
    //   214: aload 5
    //   216: invokeinterface 131 1 0
    //   221: aconst_null
    //   222: areturn
    //   223: getstatic 94	com/tencent/mobileqq/msf/core/c/c:q	Landroid/database/sqlite/SQLiteDatabase;
    //   226: ldc 28
    //   228: bipush 6
    //   230: anewarray 100	java/lang/String
    //   233: dup
    //   234: iconst_0
    //   235: ldc 102
    //   237: aastore
    //   238: dup
    //   239: iconst_1
    //   240: ldc 104
    //   242: aastore
    //   243: dup
    //   244: iconst_2
    //   245: ldc 106
    //   247: aastore
    //   248: dup
    //   249: iconst_3
    //   250: ldc 110
    //   252: aastore
    //   253: dup
    //   254: iconst_4
    //   255: ldc 112
    //   257: aastore
    //   258: dup
    //   259: iconst_5
    //   260: ldc_w 346
    //   263: aastore
    //   264: ldc_w 651
    //   267: iconst_4
    //   268: anewarray 100	java/lang/String
    //   271: dup
    //   272: iconst_0
    //   273: lload_1
    //   274: invokestatic 120	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   277: aastore
    //   278: dup
    //   279: iconst_1
    //   280: lload 15
    //   282: invokestatic 120	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   285: aastore
    //   286: dup
    //   287: iconst_2
    //   288: iconst_2
    //   289: invokestatic 350	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   292: aastore
    //   293: dup
    //   294: iconst_3
    //   295: iconst_3
    //   296: invokestatic 350	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   299: aastore
    //   300: aconst_null
    //   301: aconst_null
    //   302: aconst_null
    //   303: invokevirtual 126	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   306: astore 5
    //   308: goto -104 -> 204
    //   311: new 343	java/util/HashMap
    //   314: dup
    //   315: invokespecial 344	java/util/HashMap:<init>	()V
    //   318: astore 10
    //   320: aload 5
    //   322: invokeinterface 170 1 0
    //   327: pop
    //   328: aload 5
    //   330: invokeinterface 173 1 0
    //   335: ifne +886 -> 1221
    //   338: aload 5
    //   340: iconst_0
    //   341: invokeinterface 180 2 0
    //   346: astore 7
    //   348: aload 5
    //   350: iconst_1
    //   351: invokeinterface 180 2 0
    //   356: astore 11
    //   358: aload 5
    //   360: iconst_2
    //   361: invokeinterface 196 2 0
    //   366: lstore_1
    //   367: aload 5
    //   369: iconst_3
    //   370: invokeinterface 180 2 0
    //   375: astore 6
    //   377: aload 5
    //   379: iconst_4
    //   380: invokeinterface 203 2 0
    //   385: istore 13
    //   387: aload 5
    //   389: iconst_5
    //   390: invokeinterface 203 2 0
    //   395: pop
    //   396: iload 13
    //   398: iconst_3
    //   399: if_icmpeq +407 -> 806
    //   402: iload 13
    //   404: iconst_2
    //   405: if_icmpeq +401 -> 806
    //   408: iconst_1
    //   409: istore 13
    //   411: aload 6
    //   413: astore 4
    //   415: aload 7
    //   417: ldc_w 354
    //   420: invokevirtual 358	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   423: ifne +63 -> 486
    //   426: aload 6
    //   428: astore 4
    //   430: aload 6
    //   432: ldc_w 360
    //   435: invokevirtual 364	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   438: ifne +48 -> 486
    //   441: aload 6
    //   443: astore 4
    //   445: aload 6
    //   447: ldc_w 366
    //   450: invokevirtual 364	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   453: ifne +33 -> 486
    //   456: aload 6
    //   458: astore 4
    //   460: aload 6
    //   462: ldc_w 368
    //   465: invokevirtual 364	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   468: ifne +18 -> 486
    //   471: aload 7
    //   473: ldc_w 370
    //   476: invokevirtual 358	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   479: ifeq +345 -> 824
    //   482: aload 6
    //   484: astore 4
    //   486: aload 4
    //   488: ldc 11
    //   490: invokevirtual 373	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   493: ifeq +421 -> 914
    //   496: aload 9
    //   498: new 175	java/lang/StringBuilder
    //   501: dup
    //   502: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   505: ldc 11
    //   507: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: iload 13
    //   512: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   515: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   518: invokevirtual 376	java/util/Properties:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   521: checkcast 100	java/lang/String
    //   524: astore 6
    //   526: aload 10
    //   528: aload 11
    //   530: invokevirtual 379	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   533: ifeq +523 -> 1056
    //   536: aload 6
    //   538: ifnonnull +432 -> 970
    //   541: new 175	java/lang/StringBuilder
    //   544: dup
    //   545: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   548: astore 12
    //   550: iload 13
    //   552: iconst_1
    //   553: if_icmpne +942 -> 1495
    //   556: ldc_w 391
    //   559: astore 7
    //   561: aload 12
    //   563: aload 7
    //   565: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: aload 4
    //   570: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: ldc_w 393
    //   576: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   579: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   582: astore 4
    //   584: aload 10
    //   586: aload 11
    //   588: invokevirtual 380	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   591: checkcast 343	java/util/HashMap
    //   594: aload 4
    //   596: invokevirtual 379	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   599: ifeq +348 -> 947
    //   602: aload 10
    //   604: aload 11
    //   606: invokevirtual 380	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   609: checkcast 343	java/util/HashMap
    //   612: aload 4
    //   614: aload 10
    //   616: aload 11
    //   618: invokevirtual 380	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   621: checkcast 343	java/util/HashMap
    //   624: aload 4
    //   626: invokevirtual 380	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   629: checkcast 208	java/lang/Long
    //   632: invokevirtual 396	java/lang/Long:longValue	()J
    //   635: lload_1
    //   636: ladd
    //   637: invokestatic 211	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   640: invokevirtual 399	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   643: pop
    //   644: iload_3
    //   645: ifeq +19 -> 664
    //   648: aload 6
    //   650: ifnull +14 -> 664
    //   653: aload 6
    //   655: ldc_w 391
    //   658: invokevirtual 373	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   661: ifne +18 -> 679
    //   664: iload_3
    //   665: ifeq +77 -> 742
    //   668: aload 4
    //   670: ldc_w 391
    //   673: invokevirtual 373	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   676: ifeq +66 -> 742
    //   679: aload 10
    //   681: aload 11
    //   683: invokevirtual 380	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   686: checkcast 343	java/util/HashMap
    //   689: ldc_w 401
    //   692: invokevirtual 379	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   695: ifeq +502 -> 1197
    //   698: aload 10
    //   700: aload 11
    //   702: invokevirtual 380	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   705: checkcast 343	java/util/HashMap
    //   708: ldc_w 401
    //   711: aload 10
    //   713: aload 11
    //   715: invokevirtual 380	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   718: checkcast 343	java/util/HashMap
    //   721: ldc_w 401
    //   724: invokevirtual 380	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   727: checkcast 208	java/lang/Long
    //   730: invokevirtual 396	java/lang/Long:longValue	()J
    //   733: lload_1
    //   734: ladd
    //   735: invokestatic 211	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   738: invokevirtual 399	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   741: pop
    //   742: aload 5
    //   744: invokeinterface 226 1 0
    //   749: pop
    //   750: goto -422 -> 328
    //   753: astore 6
    //   755: aload 5
    //   757: astore 4
    //   759: aload 6
    //   761: astore 5
    //   763: ldc 8
    //   765: iconst_1
    //   766: new 175	java/lang/StringBuilder
    //   769: dup
    //   770: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   773: ldc_w 428
    //   776: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   779: aload 5
    //   781: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   784: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   787: aload 5
    //   789: invokestatic 234	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   792: aload 4
    //   794: ifnull +10 -> 804
    //   797: aload 4
    //   799: invokeinterface 131 1 0
    //   804: aconst_null
    //   805: areturn
    //   806: iload 13
    //   808: iconst_2
    //   809: if_icmpeq +9 -> 818
    //   812: iload 13
    //   814: iconst_3
    //   815: if_icmpne +677 -> 1492
    //   818: iconst_2
    //   819: istore 13
    //   821: goto -410 -> 411
    //   824: aload 7
    //   826: ldc_w 405
    //   829: invokevirtual 358	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   832: ifeq +11 -> 843
    //   835: ldc_w 407
    //   838: astore 4
    //   840: goto -354 -> 486
    //   843: aload 6
    //   845: astore 4
    //   847: aload 7
    //   849: ldc_w 409
    //   852: invokevirtual 413	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   855: ifeq -369 -> 486
    //   858: aload 7
    //   860: ldc_w 409
    //   863: invokevirtual 417	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   866: istore 14
    //   868: new 175	java/lang/StringBuilder
    //   871: dup
    //   872: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   875: aload 7
    //   877: iload 14
    //   879: iconst_1
    //   880: iadd
    //   881: iload 14
    //   883: iconst_2
    //   884: iadd
    //   885: invokevirtual 421	java/lang/String:substring	(II)Ljava/lang/String;
    //   888: invokevirtual 424	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   891: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   894: aload 7
    //   896: iload 14
    //   898: iconst_2
    //   899: iadd
    //   900: invokevirtual 426	java/lang/String:substring	(I)Ljava/lang/String;
    //   903: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   906: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   909: astore 4
    //   911: goto -425 -> 486
    //   914: aload 9
    //   916: new 175	java/lang/StringBuilder
    //   919: dup
    //   920: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   923: aload 4
    //   925: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   928: iload 13
    //   930: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   933: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   936: invokevirtual 376	java/util/Properties:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   939: checkcast 100	java/lang/String
    //   942: astore 6
    //   944: goto -418 -> 526
    //   947: aload 10
    //   949: aload 11
    //   951: invokevirtual 380	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   954: checkcast 343	java/util/HashMap
    //   957: aload 4
    //   959: lload_1
    //   960: invokestatic 211	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   963: invokevirtual 399	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   966: pop
    //   967: goto -323 -> 644
    //   970: aload 10
    //   972: aload 11
    //   974: invokevirtual 380	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   977: checkcast 343	java/util/HashMap
    //   980: aload 6
    //   982: invokevirtual 379	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   985: ifeq +48 -> 1033
    //   988: aload 10
    //   990: aload 11
    //   992: invokevirtual 380	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   995: checkcast 343	java/util/HashMap
    //   998: aload 6
    //   1000: aload 10
    //   1002: aload 11
    //   1004: invokevirtual 380	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1007: checkcast 343	java/util/HashMap
    //   1010: aload 6
    //   1012: invokevirtual 380	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1015: checkcast 208	java/lang/Long
    //   1018: invokevirtual 396	java/lang/Long:longValue	()J
    //   1021: lload_1
    //   1022: ladd
    //   1023: invokestatic 211	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1026: invokevirtual 399	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1029: pop
    //   1030: goto -386 -> 644
    //   1033: aload 10
    //   1035: aload 11
    //   1037: invokevirtual 380	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1040: checkcast 343	java/util/HashMap
    //   1043: aload 6
    //   1045: lload_1
    //   1046: invokestatic 211	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1049: invokevirtual 399	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1052: pop
    //   1053: goto -409 -> 644
    //   1056: aload 6
    //   1058: ifnonnull +105 -> 1163
    //   1061: new 175	java/lang/StringBuilder
    //   1064: dup
    //   1065: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   1068: astore 12
    //   1070: iload 13
    //   1072: iconst_1
    //   1073: if_icmpne +82 -> 1155
    //   1076: ldc_w 391
    //   1079: astore 7
    //   1081: aload 12
    //   1083: aload 7
    //   1085: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1088: aload 4
    //   1090: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1093: ldc_w 393
    //   1096: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1099: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1102: astore 4
    //   1104: new 343	java/util/HashMap
    //   1107: dup
    //   1108: invokespecial 344	java/util/HashMap:<init>	()V
    //   1111: astore 7
    //   1113: aload 7
    //   1115: aload 4
    //   1117: lload_1
    //   1118: invokestatic 211	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1121: invokevirtual 399	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1124: pop
    //   1125: aload 10
    //   1127: aload 11
    //   1129: aload 7
    //   1131: invokevirtual 399	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1134: pop
    //   1135: goto -491 -> 644
    //   1138: astore 4
    //   1140: aload 5
    //   1142: ifnull +10 -> 1152
    //   1145: aload 5
    //   1147: invokeinterface 131 1 0
    //   1152: aload 4
    //   1154: athrow
    //   1155: ldc_w 461
    //   1158: astore 7
    //   1160: goto -79 -> 1081
    //   1163: new 343	java/util/HashMap
    //   1166: dup
    //   1167: invokespecial 344	java/util/HashMap:<init>	()V
    //   1170: astore 7
    //   1172: aload 7
    //   1174: aload 6
    //   1176: lload_1
    //   1177: invokestatic 211	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1180: invokevirtual 399	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1183: pop
    //   1184: aload 10
    //   1186: aload 11
    //   1188: aload 7
    //   1190: invokevirtual 399	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1193: pop
    //   1194: goto -550 -> 644
    //   1197: aload 10
    //   1199: aload 11
    //   1201: invokevirtual 380	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1204: checkcast 343	java/util/HashMap
    //   1207: ldc_w 401
    //   1210: lload_1
    //   1211: invokestatic 211	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1214: invokevirtual 399	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1217: pop
    //   1218: goto -476 -> 742
    //   1221: invokestatic 273	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1224: ifeq +219 -> 1443
    //   1227: aload 10
    //   1229: invokevirtual 433	java/util/HashMap:keySet	()Ljava/util/Set;
    //   1232: invokeinterface 439 1 0
    //   1237: astore 4
    //   1239: aload 4
    //   1241: invokeinterface 444 1 0
    //   1246: ifeq +197 -> 1443
    //   1249: aload 4
    //   1251: invokeinterface 448 1 0
    //   1256: checkcast 100	java/lang/String
    //   1259: astore 6
    //   1261: aload 10
    //   1263: aload 6
    //   1265: invokevirtual 380	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1268: checkcast 343	java/util/HashMap
    //   1271: invokevirtual 433	java/util/HashMap:keySet	()Ljava/util/Set;
    //   1274: invokeinterface 439 1 0
    //   1279: astore 7
    //   1281: aload 7
    //   1283: invokeinterface 444 1 0
    //   1288: ifeq -49 -> 1239
    //   1291: aload 7
    //   1293: invokeinterface 448 1 0
    //   1298: checkcast 100	java/lang/String
    //   1301: astore 9
    //   1303: iload_3
    //   1304: ifeq +71 -> 1375
    //   1307: ldc 8
    //   1309: iconst_2
    //   1310: new 175	java/lang/StringBuilder
    //   1313: dup
    //   1314: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   1317: ldc_w 653
    //   1320: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1323: aload 6
    //   1325: invokestatic 192	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getShortUin	(Ljava/lang/String;)Ljava/lang/String;
    //   1328: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1331: ldc_w 452
    //   1334: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1337: aload 9
    //   1339: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1342: ldc_w 454
    //   1345: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1348: aload 10
    //   1350: aload 6
    //   1352: invokevirtual 380	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1355: checkcast 343	java/util/HashMap
    //   1358: aload 9
    //   1360: invokevirtual 380	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1363: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1366: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1369: invokestatic 85	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1372: goto -91 -> 1281
    //   1375: ldc 8
    //   1377: iconst_2
    //   1378: new 175	java/lang/StringBuilder
    //   1381: dup
    //   1382: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   1385: ldc_w 456
    //   1388: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1391: aload 6
    //   1393: invokestatic 192	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getShortUin	(Ljava/lang/String;)Ljava/lang/String;
    //   1396: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1399: ldc_w 452
    //   1402: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1405: aload 9
    //   1407: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1410: ldc_w 454
    //   1413: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1416: aload 10
    //   1418: aload 6
    //   1420: invokevirtual 380	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1423: checkcast 343	java/util/HashMap
    //   1426: aload 9
    //   1428: invokevirtual 380	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1431: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1434: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1437: invokestatic 85	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1440: goto -159 -> 1281
    //   1443: aload 8
    //   1445: invokevirtual 459	java/io/InputStream:close	()V
    //   1448: aload 5
    //   1450: ifnull +10 -> 1460
    //   1453: aload 5
    //   1455: invokeinterface 131 1 0
    //   1460: aload 10
    //   1462: areturn
    //   1463: astore 4
    //   1465: aconst_null
    //   1466: astore 5
    //   1468: goto -328 -> 1140
    //   1471: astore 6
    //   1473: aload 4
    //   1475: astore 5
    //   1477: aload 6
    //   1479: astore 4
    //   1481: goto -341 -> 1140
    //   1484: astore 5
    //   1486: aconst_null
    //   1487: astore 4
    //   1489: goto -726 -> 763
    //   1492: goto -1081 -> 411
    //   1495: ldc_w 461
    //   1498: astore 7
    //   1500: goto -939 -> 561
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1503	0	this	c
    //   0	1503	1	paramLong	long
    //   0	1503	3	paramBoolean	boolean
    //   33	1083	4	localObject1	Object
    //   1138	15	4	localObject2	Object
    //   1237	13	4	localIterator	Iterator
    //   1463	11	4	localObject3	Object
    //   1479	9	4	localObject4	Object
    //   202	1274	5	localObject5	Object
    //   1484	1	5	localException1	Exception
    //   375	279	6	str1	String
    //   753	91	6	localException2	Exception
    //   942	477	6	str2	String
    //   1471	7	6	localObject6	Object
    //   346	1153	7	localObject7	Object
    //   12	1432	8	localInputStream	java.io.InputStream
    //   21	1406	9	localObject8	Object
    //   318	1143	10	localHashMap	java.util.HashMap
    //   356	844	11	str3	String
    //   548	534	12	localStringBuilder	StringBuilder
    //   385	689	13	i1	int
    //   866	34	14	i2	int
    //   94	187	15	l1	long
    // Exception table:
    //   from	to	target	type
    //   311	328	753	java/lang/Exception
    //   328	396	753	java/lang/Exception
    //   415	426	753	java/lang/Exception
    //   430	441	753	java/lang/Exception
    //   445	456	753	java/lang/Exception
    //   460	482	753	java/lang/Exception
    //   486	526	753	java/lang/Exception
    //   526	536	753	java/lang/Exception
    //   541	550	753	java/lang/Exception
    //   561	644	753	java/lang/Exception
    //   653	664	753	java/lang/Exception
    //   668	679	753	java/lang/Exception
    //   679	742	753	java/lang/Exception
    //   742	750	753	java/lang/Exception
    //   824	835	753	java/lang/Exception
    //   847	911	753	java/lang/Exception
    //   914	944	753	java/lang/Exception
    //   947	967	753	java/lang/Exception
    //   970	1030	753	java/lang/Exception
    //   1033	1053	753	java/lang/Exception
    //   1061	1070	753	java/lang/Exception
    //   1081	1135	753	java/lang/Exception
    //   1163	1194	753	java/lang/Exception
    //   1197	1218	753	java/lang/Exception
    //   1221	1239	753	java/lang/Exception
    //   1239	1281	753	java/lang/Exception
    //   1281	1303	753	java/lang/Exception
    //   1307	1372	753	java/lang/Exception
    //   1375	1440	753	java/lang/Exception
    //   1443	1448	753	java/lang/Exception
    //   311	328	1138	finally
    //   328	396	1138	finally
    //   415	426	1138	finally
    //   430	441	1138	finally
    //   445	456	1138	finally
    //   460	482	1138	finally
    //   486	526	1138	finally
    //   526	536	1138	finally
    //   541	550	1138	finally
    //   561	644	1138	finally
    //   653	664	1138	finally
    //   668	679	1138	finally
    //   679	742	1138	finally
    //   742	750	1138	finally
    //   824	835	1138	finally
    //   847	911	1138	finally
    //   914	944	1138	finally
    //   947	967	1138	finally
    //   970	1030	1138	finally
    //   1033	1053	1138	finally
    //   1061	1070	1138	finally
    //   1081	1135	1138	finally
    //   1163	1194	1138	finally
    //   1197	1218	1138	finally
    //   1221	1239	1138	finally
    //   1239	1281	1138	finally
    //   1281	1303	1138	finally
    //   1307	1372	1138	finally
    //   1375	1440	1138	finally
    //   1443	1448	1138	finally
    //   0	89	1463	finally
    //   96	115	1463	finally
    //   115	130	1463	finally
    //   134	204	1463	finally
    //   223	308	1463	finally
    //   763	792	1471	finally
    //   0	89	1484	java/lang/Exception
    //   96	115	1484	java/lang/Exception
    //   115	130	1484	java/lang/Exception
    //   134	204	1484	java/lang/Exception
    //   223	308	1484	java/lang/Exception
  }
  
  public void onReceive(Context paramContext, Intent paramIntent) {}
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\core\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */