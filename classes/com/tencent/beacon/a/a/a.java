package com.tencent.beacon.a.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public final class a
{
  private long a = -1L;
  private int b = -1;
  private int c = -1;
  private long d = -1L;
  private byte[] e = null;
  private long f = 0L;
  
  public a() {}
  
  public a(int paramInt1, int paramInt2, long paramLong, byte[] paramArrayOfByte)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramLong;
    this.e = paramArrayOfByte;
    if (paramArrayOfByte != null) {
      this.f = paramArrayOfByte.length;
    }
  }
  
  public static int a(Context paramContext, int[] paramArrayOfInt)
  {
    int j = -1;
    int i = 0;
    for (;;)
    {
      synchronized (e.a)
      {
        com.tencent.beacon.d.a.b(" AnalyticsDAO.delete() start", new Object[0]);
        if (paramContext == null)
        {
          com.tencent.beacon.d.a.a(" delete() context is null arg", new Object[0]);
          return -1;
        }
        if (-1L > Long.MAX_VALUE) {
          return 0;
        }
        if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0)) {
          break label265;
        }
        String str = "";
        if (i < paramArrayOfInt.length)
        {
          str = str + " or _type = " + paramArrayOfInt[i];
          i += 1;
          continue;
        }
        paramArrayOfInt = str.substring(4);
        paramArrayOfInt = "_time >= -1 and _time <= 9223372036854775807" + " and ( " + paramArrayOfInt + " )";
        com.tencent.beacon.d.a.b(" delete where: " + paramArrayOfInt, new Object[0]);
      }
      try
      {
        i = e.a(paramContext).getWritableDatabase().delete("t_event", paramArrayOfInt, null);
        com.tencent.beacon.d.a.b(" deleted num: " + i, new Object[0]);
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          com.tencent.beacon.d.a.b(paramContext.getMessage(), new Object[0]);
          com.tencent.beacon.d.a.b(" AnalyticsDAO.delete() end", new Object[0]);
          i = j;
        }
      }
      finally
      {
        com.tencent.beacon.d.a.b(" AnalyticsDAO.delete() end", new Object[0]);
      }
      return i;
      paramContext = finally;
      throw paramContext;
      label265:
      paramArrayOfInt = "_time >= -1 and _time <= 9223372036854775807";
    }
  }
  
  public static int a(Context paramContext, Long[] paramArrayOfLong)
  {
    int k = 0;
    int j = 0;
    synchronized (e.a)
    {
      com.tencent.beacon.d.a.b(" AnalyticsDAO.deleteList() start!", new Object[0]);
      if (paramContext == null)
      {
        com.tencent.beacon.d.a.d(" deleteList() have null args!", new Object[0]);
        return -1;
      }
      if ((paramArrayOfLong == null) || (paramArrayOfLong.length <= 0)) {
        return 0;
      }
    }
    int i = k;
    for (;;)
    {
      try
      {
        paramContext = e.a(paramContext).getWritableDatabase();
        i = k;
        StringBuffer localStringBuffer = new StringBuffer();
        k = 0;
        i = j;
        if (k < paramArrayOfLong.length)
        {
          i = j;
          long l = paramArrayOfLong[k].longValue();
          i = j;
          localStringBuffer.append(" or  _id = " + l);
          i = j;
          if (k <= 0) {
            break label389;
          }
          i = j;
          if (k % 25 != 0) {
            break label389;
          }
          i = j;
          com.tencent.beacon.d.a.b(" current " + k, new Object[0]);
          i = j;
          j += paramContext.delete("t_event", localStringBuffer.substring(4), null);
          i = j;
          localStringBuffer.setLength(0);
          i = j;
          com.tencent.beacon.d.a.b(" current deleteNum: " + j, new Object[0]);
          i = j;
          break label389;
        }
        i = j;
        if (localStringBuffer.length() > 0)
        {
          i = j;
          k = paramContext.delete("t_event", localStringBuffer.substring(4), null);
          i = k + j;
          j = i;
        }
        i = j;
      }
      catch (Throwable paramContext)
      {
        paramContext = paramContext;
        j = i;
        com.tencent.beacon.d.a.d(paramContext.getMessage(), new Object[0]);
        com.tencent.beacon.d.a.b(" AnalyticsDAO.deleteList() end!", new Object[0]);
        i = j;
        continue;
      }
      finally
      {
        com.tencent.beacon.d.a.b(" AnalyticsDAO.deleteList() end!", new Object[0]);
      }
      continue;
      label389:
      k += 1;
      j = i;
    }
  }
  
  private static ContentValues a(a parama)
  {
    ContentValues localContentValues = new ContentValues();
    if (parama.a > 0L) {
      localContentValues.put("_id", Long.valueOf(parama.a));
    }
    localContentValues.put("_prority", Integer.valueOf(parama.c));
    localContentValues.put("_time", Long.valueOf(parama.d));
    localContentValues.put("_type", Integer.valueOf(parama.b));
    localContentValues.put("_datas", parama.e);
    localContentValues.put("_length", Long.valueOf(parama.f));
    return localContentValues;
  }
  
  /* Error */
  public static List a(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_3
    //   4: aconst_null
    //   5: astore_2
    //   6: getstatic 41	com/tencent/beacon/a/a/e:a	Ljava/lang/Object;
    //   9: astore 4
    //   11: aload 4
    //   13: monitorenter
    //   14: ldc -64
    //   16: iconst_0
    //   17: anewarray 4	java/lang/Object
    //   20: invokestatic 48	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   23: aload_0
    //   24: ifnonnull +17 -> 41
    //   27: ldc -62
    //   29: iconst_0
    //   30: anewarray 4	java/lang/Object
    //   33: invokestatic 118	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   36: aload 4
    //   38: monitorexit
    //   39: aconst_null
    //   40: areturn
    //   41: aload_0
    //   42: invokestatic 92	com/tencent/beacon/a/a/e:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/a/e;
    //   45: invokevirtual 96	com/tencent/beacon/a/a/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   48: ldc -60
    //   50: aconst_null
    //   51: aconst_null
    //   52: aconst_null
    //   53: aconst_null
    //   54: aconst_null
    //   55: ldc -58
    //   57: ldc -56
    //   59: invokevirtual 204	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   62: astore_0
    //   63: aload_2
    //   64: astore_1
    //   65: aload_3
    //   66: astore_2
    //   67: aload_0
    //   68: invokeinterface 210 1 0
    //   73: ifeq +127 -> 200
    //   76: aload_3
    //   77: astore_2
    //   78: new 212	java/util/ArrayList
    //   81: dup
    //   82: invokespecial 213	java/util/ArrayList:<init>	()V
    //   85: astore_1
    //   86: aload_1
    //   87: aload_0
    //   88: aload_0
    //   89: ldc -98
    //   91: invokeinterface 217 2 0
    //   96: invokeinterface 221 2 0
    //   101: invokestatic 173	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   104: invokeinterface 227 2 0
    //   109: pop
    //   110: aload_1
    //   111: aload_0
    //   112: aload_0
    //   113: ldc -27
    //   115: invokeinterface 217 2 0
    //   120: invokeinterface 232 2 0
    //   125: invokeinterface 227 2 0
    //   130: pop
    //   131: aload_1
    //   132: aload_0
    //   133: aload_0
    //   134: ldc -78
    //   136: invokeinterface 217 2 0
    //   141: invokeinterface 236 2 0
    //   146: invokestatic 162	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   149: invokeinterface 227 2 0
    //   154: pop
    //   155: aload_1
    //   156: aload_0
    //   157: aload_0
    //   158: ldc -74
    //   160: invokeinterface 217 2 0
    //   165: invokeinterface 240 2 0
    //   170: invokeinterface 227 2 0
    //   175: pop
    //   176: aload_1
    //   177: aload_0
    //   178: aload_0
    //   179: ldc -14
    //   181: invokeinterface 217 2 0
    //   186: invokeinterface 221 2 0
    //   191: invokestatic 173	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   194: invokeinterface 227 2 0
    //   199: pop
    //   200: aload_1
    //   201: ifnull +14 -> 215
    //   204: aload_1
    //   205: astore_2
    //   206: ldc -12
    //   208: iconst_0
    //   209: anewarray 4	java/lang/Object
    //   212: invokestatic 52	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   215: aload_0
    //   216: ifnull +18 -> 234
    //   219: aload_0
    //   220: invokeinterface 247 1 0
    //   225: ifne +9 -> 234
    //   228: aload_0
    //   229: invokeinterface 250 1 0
    //   234: ldc -4
    //   236: iconst_0
    //   237: anewarray 4	java/lang/Object
    //   240: invokestatic 48	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   243: aload 4
    //   245: monitorexit
    //   246: aload_1
    //   247: areturn
    //   248: astore_0
    //   249: aload 4
    //   251: monitorexit
    //   252: aload_0
    //   253: athrow
    //   254: astore_0
    //   255: aconst_null
    //   256: astore_2
    //   257: aload_1
    //   258: astore_0
    //   259: aload_2
    //   260: astore_1
    //   261: aload_1
    //   262: ifnull +18 -> 280
    //   265: aload_1
    //   266: invokeinterface 247 1 0
    //   271: ifne +9 -> 280
    //   274: aload_1
    //   275: invokeinterface 250 1 0
    //   280: ldc -4
    //   282: iconst_0
    //   283: anewarray 4	java/lang/Object
    //   286: invokestatic 48	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   289: aload_0
    //   290: astore_1
    //   291: goto -48 -> 243
    //   294: aload_0
    //   295: ifnull +18 -> 313
    //   298: aload_0
    //   299: invokeinterface 247 1 0
    //   304: ifne +9 -> 313
    //   307: aload_0
    //   308: invokeinterface 250 1 0
    //   313: ldc -4
    //   315: iconst_0
    //   316: anewarray 4	java/lang/Object
    //   319: invokestatic 48	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   322: aload_1
    //   323: athrow
    //   324: astore_1
    //   325: goto -31 -> 294
    //   328: astore_1
    //   329: aload_0
    //   330: astore_1
    //   331: aload_2
    //   332: astore_0
    //   333: goto -72 -> 261
    //   336: astore_2
    //   337: aload_1
    //   338: astore_2
    //   339: aload_0
    //   340: astore_1
    //   341: aload_2
    //   342: astore_0
    //   343: goto -82 -> 261
    //   346: astore_1
    //   347: aconst_null
    //   348: astore_0
    //   349: goto -55 -> 294
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	352	0	paramContext	Context
    //   1	322	1	localObject1	Object
    //   324	1	1	localObject2	Object
    //   328	1	1	localException1	Exception
    //   330	11	1	localContext1	Context
    //   346	1	1	localObject3	Object
    //   5	327	2	localObject4	Object
    //   336	1	2	localException2	Exception
    //   338	4	2	localContext2	Context
    //   3	74	3	localObject5	Object
    //   9	241	4	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   14	23	248	finally
    //   27	39	248	finally
    //   219	234	248	finally
    //   234	243	248	finally
    //   243	246	248	finally
    //   265	280	248	finally
    //   280	289	248	finally
    //   298	313	248	finally
    //   313	324	248	finally
    //   41	63	254	java/lang/Exception
    //   67	76	324	finally
    //   78	86	324	finally
    //   86	200	324	finally
    //   206	215	324	finally
    //   67	76	328	java/lang/Exception
    //   78	86	328	java/lang/Exception
    //   206	215	328	java/lang/Exception
    //   86	200	336	java/lang/Exception
    //   41	63	346	finally
  }
  
  public static List<a> a(Context paramContext, int[] paramArrayOfInt, int paramInt)
  {
    synchronized (e.a)
    {
      paramContext = a(paramContext, paramArrayOfInt, 1, 2, paramInt, -1L);
      return paramContext;
    }
  }
  
  public static List<a> a(Context paramContext, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    synchronized (e.a)
    {
      paramContext = b(paramContext, paramArrayOfInt, paramInt1, paramInt2, paramInt3, paramLong);
      return paramContext;
    }
  }
  
  private static List<a> a(Cursor paramCursor)
  {
    ArrayList localArrayList;
    synchronized (e.a)
    {
      com.tencent.beacon.d.a.b(" in AnalyticsDAO.paserCursor() start", new Object[0]);
      if (paramCursor == null) {
        return null;
      }
      localArrayList = new ArrayList();
      int i = paramCursor.getColumnIndex("_id");
      int j = paramCursor.getColumnIndex("_prority");
      int k = paramCursor.getColumnIndex("_time");
      int m = paramCursor.getColumnIndex("_type");
      int n = paramCursor.getColumnIndex("_datas");
      int i1 = paramCursor.getColumnIndex("_length");
      if (paramCursor.moveToNext())
      {
        a locala = new a();
        locala.a = paramCursor.getLong(i);
        locala.e = paramCursor.getBlob(n);
        locala.c = paramCursor.getInt(j);
        locala.d = paramCursor.getLong(k);
        locala.b = paramCursor.getInt(m);
        locala.f = paramCursor.getLong(i1);
        localArrayList.add(locala);
      }
    }
    com.tencent.beacon.d.a.b(" in AnalyticsDAO.paserCursor() end", new Object[0]);
    return localArrayList;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    bool2 = false;
    bool1 = false;
    synchronized (e.a)
    {
      com.tencent.beacon.d.a.b(" AnalyticsDAO.deleteReqData() start", new Object[0]);
      if (paramContext == null)
      {
        com.tencent.beacon.d.a.a(" delete() context is null arg", new Object[0]);
        return false;
      }
      if ((paramString == null) || (paramString.trim().equals(""))) {
        return false;
      }
    }
    paramString = "_rid = '" + paramString + "' ";
    com.tencent.beacon.d.a.b(" delete where: " + paramString, new Object[0]);
    try
    {
      int i = e.a(paramContext).getWritableDatabase().delete("t_req_data", paramString, null);
      com.tencent.beacon.d.a.b(" deleted num: " + i, new Object[0]);
      if (i == 1) {
        bool1 = true;
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        com.tencent.beacon.d.a.b(paramContext.getMessage(), new Object[0]);
        com.tencent.beacon.d.a.b(" AnalyticsDAO.deleteReqData() end", new Object[0]);
        bool1 = bool2;
      }
    }
    finally
    {
      com.tencent.beacon.d.a.b(" AnalyticsDAO.deleteReqData() end", new Object[0]);
    }
    return bool1;
  }
  
  /* Error */
  public static boolean a(Context paramContext, List<a> paramList)
  {
    // Byte code:
    //   0: getstatic 41	com/tencent/beacon/a/a/e:a	Ljava/lang/Object;
    //   3: astore_3
    //   4: aload_3
    //   5: monitorenter
    //   6: ldc_w 286
    //   9: iconst_0
    //   10: anewarray 4	java/lang/Object
    //   13: invokestatic 48	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   16: aload_0
    //   17: ifnull +7 -> 24
    //   20: aload_1
    //   21: ifnonnull +17 -> 38
    //   24: ldc_w 288
    //   27: iconst_0
    //   28: anewarray 4	java/lang/Object
    //   31: invokestatic 118	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   34: aload_3
    //   35: monitorexit
    //   36: iconst_0
    //   37: ireturn
    //   38: aload_1
    //   39: invokeinterface 291 1 0
    //   44: ifgt +17 -> 61
    //   47: ldc_w 293
    //   50: iconst_0
    //   51: anewarray 4	java/lang/Object
    //   54: invokestatic 48	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   57: aload_3
    //   58: monitorexit
    //   59: iconst_1
    //   60: ireturn
    //   61: aconst_null
    //   62: astore_2
    //   63: aload_0
    //   64: invokestatic 92	com/tencent/beacon/a/a/e:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/a/e;
    //   67: invokevirtual 96	com/tencent/beacon/a/a/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   70: astore_0
    //   71: aload_0
    //   72: invokevirtual 296	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   75: iconst_0
    //   76: istore 4
    //   78: iload 4
    //   80: aload_1
    //   81: invokeinterface 291 1 0
    //   86: if_icmpge +61 -> 147
    //   89: aload_1
    //   90: iload 4
    //   92: invokeinterface 300 2 0
    //   97: checkcast 2	com/tencent/beacon/a/a/a
    //   100: astore_2
    //   101: aload_0
    //   102: ldc 98
    //   104: ldc -98
    //   106: aload_2
    //   107: invokestatic 302	com/tencent/beacon/a/a/a:a	(Lcom/tencent/beacon/a/a/a;)Landroid/content/ContentValues;
    //   110: invokevirtual 306	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   113: lstore 5
    //   115: lload 5
    //   117: lconst_0
    //   118: lcmp
    //   119: ifge +13 -> 132
    //   122: ldc_w 308
    //   125: iconst_0
    //   126: anewarray 4	java/lang/Object
    //   129: invokestatic 118	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   132: aload_2
    //   133: lload 5
    //   135: putfield 21	com/tencent/beacon/a/a/a:a	J
    //   138: iload 4
    //   140: iconst_1
    //   141: iadd
    //   142: istore 4
    //   144: goto -66 -> 78
    //   147: aload_0
    //   148: invokevirtual 311	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   151: aload_0
    //   152: invokevirtual 314	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   155: ldc_w 316
    //   158: iconst_0
    //   159: anewarray 4	java/lang/Object
    //   162: invokestatic 48	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   165: iconst_1
    //   166: istore 7
    //   168: aload_3
    //   169: monitorexit
    //   170: iload 7
    //   172: ireturn
    //   173: astore_0
    //   174: aload_3
    //   175: monitorexit
    //   176: aload_0
    //   177: athrow
    //   178: astore_0
    //   179: aload_2
    //   180: astore_0
    //   181: ldc_w 318
    //   184: iconst_0
    //   185: anewarray 4	java/lang/Object
    //   188: invokestatic 48	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   191: aload_0
    //   192: invokevirtual 314	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   195: ldc_w 316
    //   198: iconst_0
    //   199: anewarray 4	java/lang/Object
    //   202: invokestatic 48	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   205: iconst_0
    //   206: istore 7
    //   208: goto -40 -> 168
    //   211: aload_0
    //   212: invokevirtual 314	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   215: ldc_w 316
    //   218: iconst_0
    //   219: anewarray 4	java/lang/Object
    //   222: invokestatic 48	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   225: aload_1
    //   226: athrow
    //   227: astore_1
    //   228: goto -17 -> 211
    //   231: astore_1
    //   232: goto -21 -> 211
    //   235: astore_1
    //   236: goto -55 -> 181
    //   239: astore_1
    //   240: aconst_null
    //   241: astore_0
    //   242: goto -31 -> 211
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	paramContext	Context
    //   0	245	1	paramList	List<a>
    //   62	118	2	locala	a
    //   3	172	3	localObject	Object
    //   76	67	4	i	int
    //   113	21	5	l	long
    //   166	41	7	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   6	16	173	finally
    //   24	36	173	finally
    //   38	59	173	finally
    //   151	165	173	finally
    //   168	170	173	finally
    //   191	205	173	finally
    //   211	227	173	finally
    //   63	71	178	java/lang/Throwable
    //   71	75	227	finally
    //   78	115	227	finally
    //   122	132	227	finally
    //   132	138	227	finally
    //   147	151	227	finally
    //   181	191	231	finally
    //   71	75	235	java/lang/Throwable
    //   78	115	235	java/lang/Throwable
    //   122	132	235	java/lang/Throwable
    //   132	138	235	java/lang/Throwable
    //   147	151	235	java/lang/Throwable
    //   63	71	239	finally
  }
  
  public static boolean a(Context paramContext, byte[] paramArrayOfByte, String paramString, int paramInt)
  {
    bool2 = false;
    for (bool1 = false;; bool1 = true) {
      synchronized (e.a)
      {
        com.tencent.beacon.d.a.b(" AnalyticsDAO.insertReqData() start", new Object[0]);
        if ((paramContext == null) || (paramArrayOfByte == null) || (paramString == null))
        {
          com.tencent.beacon.d.a.d(" AnalyticsDAO.insertReqData() have null args", new Object[0]);
          return false;
        }
        try
        {
          paramContext = e.a(paramContext).getWritableDatabase();
          ContentValues localContentValues = new ContentValues();
          localContentValues.put("_rid", paramString);
          localContentValues.put("_time", Long.valueOf(new Date().getTime()));
          localContentValues.put("_cnt", Integer.valueOf(paramInt));
          localContentValues.put("_datas", paramArrayOfByte);
          if (paramContext.insert("t_req_data", null, localContentValues) >= 0L) {
            continue;
          }
          com.tencent.beacon.d.a.d(" AnalyticsDAO.insertReqData() failure! return", new Object[0]);
        }
        catch (Throwable paramContext)
        {
          for (;;)
          {
            com.tencent.beacon.d.a.b("AnalyticsDAO.insertReqData() failure!", new Object[0]);
            com.tencent.beacon.d.a.b(" AnalyticsDAO.insertReqData() end", new Object[0]);
            bool1 = bool2;
          }
        }
        finally
        {
          com.tencent.beacon.d.a.b(" AnalyticsDAO.insertReqData() end", new Object[0]);
        }
        return bool1;
      }
    }
  }
  
  /* Error */
  public static int b(Context paramContext, int[] paramArrayOfInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: getstatic 41	com/tencent/beacon/a/a/e:a	Ljava/lang/Object;
    //   6: astore 4
    //   8: aload 4
    //   10: monitorenter
    //   11: ldc_w 341
    //   14: iconst_0
    //   15: anewarray 4	java/lang/Object
    //   18: invokestatic 48	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   21: aload_0
    //   22: ifnonnull +18 -> 40
    //   25: ldc_w 343
    //   28: iconst_0
    //   29: anewarray 4	java/lang/Object
    //   32: invokestatic 52	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   35: aload 4
    //   37: monitorexit
    //   38: iconst_m1
    //   39: ireturn
    //   40: ldc2_w 18
    //   43: ldc2_w 53
    //   46: lcmp
    //   47: ifle +8 -> 55
    //   50: aload 4
    //   52: monitorexit
    //   53: iconst_0
    //   54: ireturn
    //   55: ldc 80
    //   57: astore_3
    //   58: aload_3
    //   59: astore_2
    //   60: aload_1
    //   61: ifnull +92 -> 153
    //   64: aload_3
    //   65: astore_2
    //   66: aload_1
    //   67: arraylength
    //   68: ifle +85 -> 153
    //   71: ldc 56
    //   73: astore_2
    //   74: iload 5
    //   76: aload_1
    //   77: arraylength
    //   78: if_icmpge +39 -> 117
    //   81: new 58	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   88: aload_2
    //   89: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: ldc 65
    //   94: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload_1
    //   98: iload 5
    //   100: iaload
    //   101: invokevirtual 68	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   104: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: astore_2
    //   108: iload 5
    //   110: iconst_1
    //   111: iadd
    //   112: istore 5
    //   114: goto -40 -> 74
    //   117: aload_2
    //   118: iconst_4
    //   119: invokevirtual 78	java/lang/String:substring	(I)Ljava/lang/String;
    //   122: astore_1
    //   123: new 58	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   130: ldc 80
    //   132: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: ldc 82
    //   137: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload_1
    //   141: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: ldc 84
    //   146: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: astore_2
    //   153: new 58	java/lang/StringBuilder
    //   156: dup
    //   157: ldc_w 345
    //   160: invokespecial 89	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   163: aload_2
    //   164: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: iconst_0
    //   171: anewarray 4	java/lang/Object
    //   174: invokestatic 48	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   177: aload_0
    //   178: invokestatic 92	com/tencent/beacon/a/a/e:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/a/e;
    //   181: invokevirtual 96	com/tencent/beacon/a/a/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   184: ldc 98
    //   186: iconst_1
    //   187: anewarray 74	java/lang/String
    //   190: dup
    //   191: iconst_0
    //   192: ldc_w 347
    //   195: aastore
    //   196: aload_2
    //   197: aconst_null
    //   198: aconst_null
    //   199: aconst_null
    //   200: aconst_null
    //   201: invokevirtual 350	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   204: astore_1
    //   205: aload_1
    //   206: astore_0
    //   207: aload_1
    //   208: invokeinterface 210 1 0
    //   213: pop
    //   214: aload_1
    //   215: astore_0
    //   216: aload_1
    //   217: aload_1
    //   218: ldc_w 352
    //   221: invokeinterface 217 2 0
    //   226: invokeinterface 221 2 0
    //   231: istore 5
    //   233: aload_1
    //   234: astore_0
    //   235: new 58	java/lang/StringBuilder
    //   238: dup
    //   239: ldc_w 354
    //   242: invokespecial 89	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   245: iload 5
    //   247: invokevirtual 68	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   250: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: iconst_0
    //   254: anewarray 4	java/lang/Object
    //   257: invokestatic 48	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   260: aload_1
    //   261: ifnull +18 -> 279
    //   264: aload_1
    //   265: invokeinterface 247 1 0
    //   270: ifne +9 -> 279
    //   273: aload_1
    //   274: invokeinterface 250 1 0
    //   279: ldc_w 356
    //   282: iconst_0
    //   283: anewarray 4	java/lang/Object
    //   286: invokestatic 48	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   289: aload 4
    //   291: monitorexit
    //   292: iload 5
    //   294: ireturn
    //   295: astore_0
    //   296: aload 4
    //   298: monitorexit
    //   299: aload_0
    //   300: athrow
    //   301: astore_2
    //   302: aconst_null
    //   303: astore_1
    //   304: aload_1
    //   305: astore_0
    //   306: aload_2
    //   307: invokevirtual 111	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   310: iconst_0
    //   311: anewarray 4	java/lang/Object
    //   314: invokestatic 48	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   317: aload_1
    //   318: ifnull +18 -> 336
    //   321: aload_1
    //   322: invokeinterface 247 1 0
    //   327: ifne +9 -> 336
    //   330: aload_1
    //   331: invokeinterface 250 1 0
    //   336: ldc_w 356
    //   339: iconst_0
    //   340: anewarray 4	java/lang/Object
    //   343: invokestatic 48	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   346: iconst_m1
    //   347: istore 5
    //   349: goto -60 -> 289
    //   352: aload_0
    //   353: ifnull +18 -> 371
    //   356: aload_0
    //   357: invokeinterface 247 1 0
    //   362: ifne +9 -> 371
    //   365: aload_0
    //   366: invokeinterface 250 1 0
    //   371: ldc_w 356
    //   374: iconst_0
    //   375: anewarray 4	java/lang/Object
    //   378: invokestatic 48	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   381: aload_1
    //   382: athrow
    //   383: astore_1
    //   384: goto -32 -> 352
    //   387: astore_2
    //   388: goto -84 -> 304
    //   391: astore_1
    //   392: aconst_null
    //   393: astore_0
    //   394: goto -42 -> 352
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	397	0	paramContext	Context
    //   0	397	1	paramArrayOfInt	int[]
    //   59	138	2	str1	String
    //   301	6	2	localThrowable1	Throwable
    //   387	1	2	localThrowable2	Throwable
    //   57	8	3	str2	String
    //   6	291	4	localObject	Object
    //   1	347	5	i	int
    // Exception table:
    //   from	to	target	type
    //   11	21	295	finally
    //   25	38	295	finally
    //   66	71	295	finally
    //   74	108	295	finally
    //   117	153	295	finally
    //   153	177	295	finally
    //   264	279	295	finally
    //   279	289	295	finally
    //   289	292	295	finally
    //   321	336	295	finally
    //   336	346	295	finally
    //   356	371	295	finally
    //   371	383	295	finally
    //   177	205	301	java/lang/Throwable
    //   207	214	383	finally
    //   216	233	383	finally
    //   235	260	383	finally
    //   306	317	383	finally
    //   207	214	387	java/lang/Throwable
    //   216	233	387	java/lang/Throwable
    //   235	260	387	java/lang/Throwable
    //   177	205	391	finally
  }
  
  /* Error */
  private static List<a> b(Context paramContext, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    // Byte code:
    //   0: getstatic 41	com/tencent/beacon/a/a/e:a	Ljava/lang/Object;
    //   3: astore 9
    //   5: aload 9
    //   7: monitorenter
    //   8: ldc_w 358
    //   11: iconst_0
    //   12: anewarray 4	java/lang/Object
    //   15: invokestatic 48	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   18: aload_0
    //   19: ifnull +92 -> 111
    //   22: lload 5
    //   24: lconst_0
    //   25: lcmp
    //   26: ifle +12 -> 38
    //   29: ldc2_w 18
    //   32: lload 5
    //   34: lcmp
    //   35: ifgt +76 -> 111
    //   38: ldc 56
    //   40: astore 8
    //   42: aload 8
    //   44: astore 7
    //   46: aload_1
    //   47: ifnull +105 -> 152
    //   50: aload 8
    //   52: astore 7
    //   54: aload_1
    //   55: arraylength
    //   56: ifle +96 -> 152
    //   59: ldc 56
    //   61: astore 7
    //   63: iconst_0
    //   64: istore 10
    //   66: iload 10
    //   68: aload_1
    //   69: arraylength
    //   70: if_icmpge +56 -> 126
    //   73: new 58	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   80: aload 7
    //   82: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: ldc 65
    //   87: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload_1
    //   91: iload 10
    //   93: iaload
    //   94: invokevirtual 68	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   97: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: astore 7
    //   102: iload 10
    //   104: iconst_1
    //   105: iadd
    //   106: istore 10
    //   108: goto -42 -> 66
    //   111: ldc_w 360
    //   114: iconst_0
    //   115: anewarray 4	java/lang/Object
    //   118: invokestatic 118	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   121: aload 9
    //   123: monitorexit
    //   124: aconst_null
    //   125: areturn
    //   126: new 58	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   133: ldc 56
    //   135: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload 7
    //   140: iconst_4
    //   141: invokevirtual 78	java/lang/String:substring	(I)Ljava/lang/String;
    //   144: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: astore 7
    //   152: aload 7
    //   154: invokevirtual 361	java/lang/String:length	()I
    //   157: ifle +351 -> 508
    //   160: new 58	java/lang/StringBuilder
    //   163: dup
    //   164: ldc_w 363
    //   167: invokespecial 89	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   170: aload 7
    //   172: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: ldc_w 365
    //   178: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: astore 7
    //   186: aload 7
    //   188: astore_1
    //   189: ldc2_w 18
    //   192: lconst_0
    //   193: lcmp
    //   194: iflt +45 -> 239
    //   197: new 58	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   204: aload 7
    //   206: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: astore 8
    //   211: aload 7
    //   213: invokevirtual 361	java/lang/String:length	()I
    //   216: ifle +563 -> 779
    //   219: ldc_w 367
    //   222: astore_1
    //   223: aload 8
    //   225: aload_1
    //   226: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: ldc_w 369
    //   232: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: astore_1
    //   239: aload_1
    //   240: astore 7
    //   242: lload 5
    //   244: lconst_0
    //   245: lcmp
    //   246: iflt +479 -> 725
    //   249: new 58	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   256: aload_1
    //   257: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: astore 7
    //   262: aload_1
    //   263: invokevirtual 361	java/lang/String:length	()I
    //   266: ifle +519 -> 785
    //   269: ldc_w 367
    //   272: astore_1
    //   273: aload 7
    //   275: aload_1
    //   276: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: ldc_w 371
    //   282: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: lload 5
    //   287: invokevirtual 132	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   290: ldc_w 373
    //   293: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   299: astore 7
    //   301: goto +424 -> 725
    //   304: aload_1
    //   305: astore 8
    //   307: aload_1
    //   308: ldc_w 375
    //   311: invokevirtual 379	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   314: ifeq +16 -> 330
    //   317: aload_1
    //   318: iconst_0
    //   319: aload_1
    //   320: invokevirtual 361	java/lang/String:length	()I
    //   323: iconst_3
    //   324: isub
    //   325: invokevirtual 382	java/lang/String:substring	(II)Ljava/lang/String;
    //   328: astore 8
    //   330: ldc_w 384
    //   333: iconst_1
    //   334: anewarray 4	java/lang/Object
    //   337: dup
    //   338: iconst_0
    //   339: aload 7
    //   341: aastore
    //   342: invokestatic 48	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   345: aload_0
    //   346: invokestatic 92	com/tencent/beacon/a/a/e:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/a/e;
    //   349: invokevirtual 96	com/tencent/beacon/a/a/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   352: astore_1
    //   353: iload 4
    //   355: iflt +257 -> 612
    //   358: iload 4
    //   360: invokestatic 386	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   363: astore_0
    //   364: aload_1
    //   365: ldc 98
    //   367: aconst_null
    //   368: aload 7
    //   370: aconst_null
    //   371: aconst_null
    //   372: aconst_null
    //   373: aload 8
    //   375: aload_0
    //   376: invokevirtual 204	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   379: astore_1
    //   380: aload_1
    //   381: astore 7
    //   383: new 58	java/lang/StringBuilder
    //   386: dup
    //   387: ldc_w 388
    //   390: invokespecial 89	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   393: aload_1
    //   394: invokeinterface 391 1 0
    //   399: invokevirtual 68	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   402: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: iconst_0
    //   406: anewarray 4	java/lang/Object
    //   409: invokestatic 52	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   412: aload_1
    //   413: astore 7
    //   415: aload_1
    //   416: invokeinterface 391 1 0
    //   421: ifle +299 -> 720
    //   424: aload_1
    //   425: astore 7
    //   427: aload_1
    //   428: invokestatic 393	com/tencent/beacon/a/a/a:a	(Landroid/database/Cursor;)Ljava/util/List;
    //   431: astore_0
    //   432: aload_0
    //   433: ifnull +35 -> 468
    //   436: aload_1
    //   437: astore 7
    //   439: new 58	java/lang/StringBuilder
    //   442: dup
    //   443: ldc_w 395
    //   446: invokespecial 89	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   449: aload_0
    //   450: invokeinterface 291 1 0
    //   455: invokevirtual 68	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   458: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   461: iconst_0
    //   462: anewarray 4	java/lang/Object
    //   465: invokestatic 52	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   468: aload_1
    //   469: ifnull +18 -> 487
    //   472: aload_1
    //   473: invokeinterface 247 1 0
    //   478: ifne +9 -> 487
    //   481: aload_1
    //   482: invokeinterface 250 1 0
    //   487: ldc_w 397
    //   490: iconst_0
    //   491: anewarray 4	java/lang/Object
    //   494: invokestatic 48	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   497: aload 9
    //   499: monitorexit
    //   500: aload_0
    //   501: areturn
    //   502: astore_0
    //   503: aload 9
    //   505: monitorexit
    //   506: aload_0
    //   507: athrow
    //   508: ldc 56
    //   510: astore 7
    //   512: goto -326 -> 186
    //   515: new 58	java/lang/StringBuilder
    //   518: dup
    //   519: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   522: ldc 56
    //   524: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: ldc_w 399
    //   530: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   536: astore_1
    //   537: goto +215 -> 752
    //   540: new 58	java/lang/StringBuilder
    //   543: dup
    //   544: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   547: ldc 56
    //   549: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: ldc_w 401
    //   555: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   561: astore_1
    //   562: goto +190 -> 752
    //   565: new 58	java/lang/StringBuilder
    //   568: dup
    //   569: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   572: aload_1
    //   573: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: ldc_w 403
    //   579: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   585: astore_1
    //   586: goto -282 -> 304
    //   589: new 58	java/lang/StringBuilder
    //   592: dup
    //   593: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   596: aload_1
    //   597: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: ldc -58
    //   602: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   608: astore_1
    //   609: goto -305 -> 304
    //   612: aconst_null
    //   613: astore_0
    //   614: goto -250 -> 364
    //   617: astore 8
    //   619: aconst_null
    //   620: astore_0
    //   621: aconst_null
    //   622: astore_1
    //   623: aload_1
    //   624: astore 7
    //   626: aload 8
    //   628: invokevirtual 111	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   631: iconst_0
    //   632: anewarray 4	java/lang/Object
    //   635: invokestatic 48	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   638: aload_1
    //   639: ifnull +18 -> 657
    //   642: aload_1
    //   643: invokeinterface 247 1 0
    //   648: ifne +9 -> 657
    //   651: aload_1
    //   652: invokeinterface 250 1 0
    //   657: ldc_w 397
    //   660: iconst_0
    //   661: anewarray 4	java/lang/Object
    //   664: invokestatic 48	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   667: goto -170 -> 497
    //   670: aload 7
    //   672: ifnull +20 -> 692
    //   675: aload 7
    //   677: invokeinterface 247 1 0
    //   682: ifne +10 -> 692
    //   685: aload 7
    //   687: invokeinterface 250 1 0
    //   692: ldc_w 397
    //   695: iconst_0
    //   696: anewarray 4	java/lang/Object
    //   699: invokestatic 48	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   702: aload_0
    //   703: athrow
    //   704: astore_0
    //   705: goto -35 -> 670
    //   708: astore 8
    //   710: aconst_null
    //   711: astore_0
    //   712: goto -89 -> 623
    //   715: astore 8
    //   717: goto -94 -> 623
    //   720: aconst_null
    //   721: astore_0
    //   722: goto -290 -> 432
    //   725: ldc 56
    //   727: astore_1
    //   728: iload_2
    //   729: tableswitch	default:+23->752, 1:+-214->515, 2:+-189->540
    //   752: iload_3
    //   753: tableswitch	default:+23->776, 1:+-188->565, 2:+-164->589
    //   776: goto -472 -> 304
    //   779: ldc 56
    //   781: astore_1
    //   782: goto -559 -> 223
    //   785: ldc 56
    //   787: astore_1
    //   788: goto -515 -> 273
    //   791: astore_0
    //   792: aconst_null
    //   793: astore 7
    //   795: goto -125 -> 670
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	798	0	paramContext	Context
    //   0	798	1	paramArrayOfInt	int[]
    //   0	798	2	paramInt1	int
    //   0	798	3	paramInt2	int
    //   0	798	4	paramInt3	int
    //   0	798	5	paramLong	long
    //   44	750	7	localObject1	Object
    //   40	334	8	localObject2	Object
    //   617	10	8	localThrowable1	Throwable
    //   708	1	8	localThrowable2	Throwable
    //   715	1	8	localThrowable3	Throwable
    //   3	501	9	localObject3	Object
    //   64	43	10	i	int
    // Exception table:
    //   from	to	target	type
    //   8	18	502	finally
    //   54	59	502	finally
    //   66	102	502	finally
    //   111	124	502	finally
    //   126	152	502	finally
    //   152	186	502	finally
    //   197	219	502	finally
    //   223	239	502	finally
    //   249	269	502	finally
    //   273	301	502	finally
    //   307	330	502	finally
    //   330	345	502	finally
    //   472	487	502	finally
    //   487	497	502	finally
    //   497	500	502	finally
    //   515	537	502	finally
    //   540	562	502	finally
    //   565	586	502	finally
    //   589	609	502	finally
    //   642	657	502	finally
    //   657	667	502	finally
    //   675	692	502	finally
    //   692	704	502	finally
    //   345	353	617	java/lang/Throwable
    //   358	364	617	java/lang/Throwable
    //   364	380	617	java/lang/Throwable
    //   383	412	704	finally
    //   415	424	704	finally
    //   427	432	704	finally
    //   439	468	704	finally
    //   626	638	704	finally
    //   383	412	708	java/lang/Throwable
    //   415	424	708	java/lang/Throwable
    //   427	432	708	java/lang/Throwable
    //   439	468	715	java/lang/Throwable
    //   345	353	791	finally
    //   358	364	791	finally
    //   364	380	791	finally
  }
  
  public static boolean b(Context paramContext, List<a> paramList)
  {
    synchronized (e.a)
    {
      com.tencent.beacon.d.a.b(" insertOrUpdate alyticsBeans start!", new Object[0]);
      if ((paramContext == null) || (paramList == null) || (paramList.size() <= 0))
      {
        com.tencent.beacon.d.a.d(" context == null || list == null|| list.size() <= 0 ? pls check!", new Object[0]);
        return false;
      }
      boolean bool3 = true;
      bool1 = true;
      bool2 = bool3;
      try
      {
        paramContext = e.a(paramContext).getWritableDatabase();
        bool2 = bool3;
        paramList = paramList.iterator();
      }
      catch (Throwable paramContext)
      {
        a locala;
        ContentValues localContentValues;
        long l;
        com.tencent.beacon.d.a.a(paramContext);
        com.tencent.beacon.d.a.b(" insertOrUpdate alyticsBeans end", new Object[0]);
        for (;;)
        {
          return bool2;
          paramContext = finally;
          throw paramContext;
          bool1 = false;
          break;
          com.tencent.beacon.d.a.b(" insertOrUpdate alyticsBeans end", new Object[0]);
          bool2 = bool1;
        }
      }
      finally
      {
        com.tencent.beacon.d.a.b(" insertOrUpdate alyticsBeans end", new Object[0]);
      }
      bool2 = bool1;
      if (paramList.hasNext())
      {
        bool2 = bool1;
        locala = (a)paramList.next();
        bool2 = bool1;
        localContentValues = a(locala);
        if (localContentValues != null)
        {
          bool2 = bool1;
          l = paramContext.replace("t_event", "_id", localContentValues);
          if (l > 0L)
          {
            bool2 = bool1;
            com.tencent.beacon.d.a.b(" result id:" + l, new Object[0]);
            bool2 = bool1;
            locala.a = l;
          }
        }
      }
    }
  }
  
  public final long a()
  {
    return this.a;
  }
  
  public final a a(long paramLong)
  {
    this.a = paramLong;
    return this;
  }
  
  public final byte[] b()
  {
    return this.e;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\beacon\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */