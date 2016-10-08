package com.tencent.open.business.viareport;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import java.util.ArrayList;

public class ReportDbHelper
{
  protected static ReportDbHelper a;
  protected static final String a = "BusinessReport";
  
  protected ReportDbHelper()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private long a(SQLiteDatabase paramSQLiteDatabase, String paramString, BatchReportInfo paramBatchReportInfo)
  {
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("actiontype", paramBatchReportInfo.c);
      localContentValues.put("appid", paramBatchReportInfo.a);
      localContentValues.put("qua", paramBatchReportInfo.e);
      localContentValues.put("uin", paramBatchReportInfo.d);
      localContentValues.put("via", paramBatchReportInfo.b);
      localContentValues.put("network", paramBatchReportInfo.a());
      localContentValues.put("timestamp", paramBatchReportInfo.g);
      localContentValues.put("expand1", paramBatchReportInfo.h);
      localContentValues.put("expand2", paramBatchReportInfo.i);
      localContentValues.put("expand3", paramBatchReportInfo.j);
      localContentValues.put("expand4", paramBatchReportInfo.k);
      localContentValues.put("expand5", paramBatchReportInfo.l);
      long l1 = -1L;
      try
      {
        long l2 = paramSQLiteDatabase.insertOrThrow(paramString, "_id", localContentValues);
        l1 = l2;
      }
      catch (SQLException paramSQLiteDatabase)
      {
        for (;;)
        {
          paramSQLiteDatabase.printStackTrace();
          LogUtility.e("BusinessReport", paramSQLiteDatabase.getLocalizedMessage());
        }
      }
      return l1;
    }
    finally {}
  }
  
  public static ReportDbHelper a()
  {
    try
    {
      if (a == null) {
        a = new ReportDbHelper();
      }
      ReportDbHelper localReportDbHelper = a;
      return localReportDbHelper;
    }
    finally {}
  }
  
  public int a(String paramString)
  {
    try
    {
      int i = 0 + b("table_new_data", paramString);
      LogUtility.b("Jie", "new_table>>count=" + i);
      i += b("table_old_data", paramString);
      LogUtility.b("Jie", "all_table>>>count=" + i);
      return i;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public int a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: invokevirtual 149	com/tencent/open/business/viareport/ReportDbHelper:a	()Landroid/database/sqlite/SQLiteDatabase;
    //   9: astore 4
    //   11: aload 4
    //   13: astore_3
    //   14: aload_2
    //   15: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   18: ifeq +42 -> 60
    //   21: aload 5
    //   23: astore_2
    //   24: aload 4
    //   26: astore_3
    //   27: aload 4
    //   29: aload_1
    //   30: aload_2
    //   31: aconst_null
    //   32: invokevirtual 159	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   35: istore 6
    //   37: iload 6
    //   39: istore 7
    //   41: aload 4
    //   43: ifnull +12 -> 55
    //   46: aload 4
    //   48: invokevirtual 162	android/database/sqlite/SQLiteDatabase:close	()V
    //   51: iload 6
    //   53: istore 7
    //   55: aload_0
    //   56: monitorexit
    //   57: iload 7
    //   59: ireturn
    //   60: aload 4
    //   62: astore_3
    //   63: new 125	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   70: ldc -92
    //   72: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload_2
    //   76: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: astore_2
    //   83: goto -59 -> 24
    //   86: astore_1
    //   87: aconst_null
    //   88: astore 4
    //   90: aload 4
    //   92: astore_3
    //   93: aload_1
    //   94: invokevirtual 165	java/lang/Exception:printStackTrace	()V
    //   97: aload 4
    //   99: astore_3
    //   100: ldc 9
    //   102: aload_1
    //   103: invokevirtual 166	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   106: invokestatic 111	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   109: aload 4
    //   111: ifnull +34 -> 145
    //   114: aload 4
    //   116: invokevirtual 162	android/database/sqlite/SQLiteDatabase:close	()V
    //   119: goto +26 -> 145
    //   122: aload_3
    //   123: ifnull +7 -> 130
    //   126: aload_3
    //   127: invokevirtual 162	android/database/sqlite/SQLiteDatabase:close	()V
    //   130: aload_1
    //   131: athrow
    //   132: astore_1
    //   133: aload_0
    //   134: monitorexit
    //   135: aload_1
    //   136: athrow
    //   137: astore_1
    //   138: goto -16 -> 122
    //   141: astore_1
    //   142: goto -52 -> 90
    //   145: iconst_m1
    //   146: istore 7
    //   148: goto -93 -> 55
    //   151: astore_1
    //   152: aconst_null
    //   153: astore_3
    //   154: goto -32 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	this	ReportDbHelper
    //   0	157	1	paramString1	String
    //   0	157	2	paramString2	String
    //   13	141	3	localSQLiteDatabase1	SQLiteDatabase
    //   9	106	4	localSQLiteDatabase2	SQLiteDatabase
    //   1	21	5	localObject	Object
    //   35	17	6	i	int
    //   39	108	7	j	int
    // Exception table:
    //   from	to	target	type
    //   5	11	86	java/lang/Exception
    //   46	51	132	finally
    //   114	119	132	finally
    //   126	130	132	finally
    //   130	132	132	finally
    //   14	21	137	finally
    //   27	37	137	finally
    //   63	83	137	finally
    //   93	97	137	finally
    //   100	109	137	finally
    //   14	21	141	java/lang/Exception
    //   27	37	141	java/lang/Exception
    //   63	83	141	java/lang/Exception
    //   5	11	151	finally
  }
  
  /* Error */
  public int a(String paramString, ArrayList paramArrayList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore 5
    //   5: iconst_0
    //   6: istore 4
    //   8: invokestatic 171	com/tencent/mobileqq/app/SQLiteDatabase:g	()V
    //   11: aload_0
    //   12: invokevirtual 149	com/tencent/open/business/viareport/ReportDbHelper:a	()Landroid/database/sqlite/SQLiteDatabase;
    //   15: astore_3
    //   16: aload_3
    //   17: invokevirtual 174	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   20: aload_2
    //   21: invokevirtual 180	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   24: astore_2
    //   25: iload 4
    //   27: istore 5
    //   29: aload_2
    //   30: invokeinterface 186 1 0
    //   35: ifeq +32 -> 67
    //   38: iload 4
    //   40: istore 5
    //   42: aload_0
    //   43: aload_3
    //   44: aload_1
    //   45: aload_2
    //   46: invokeinterface 190 1 0
    //   51: checkcast 30	com/tencent/open/business/viareport/BatchReportInfo
    //   54: invokespecial 192	com/tencent/open/business/viareport/ReportDbHelper:a	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Lcom/tencent/open/business/viareport/BatchReportInfo;)J
    //   57: pop2
    //   58: iload 4
    //   60: iconst_1
    //   61: iadd
    //   62: istore 4
    //   64: goto -39 -> 25
    //   67: iload 4
    //   69: istore 5
    //   71: aload_3
    //   72: invokevirtual 195	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   75: aload_3
    //   76: invokevirtual 198	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   79: aload_3
    //   80: invokevirtual 162	android/database/sqlite/SQLiteDatabase:close	()V
    //   83: invokestatic 200	com/tencent/mobileqq/app/SQLiteDatabase:h	()V
    //   86: aload_0
    //   87: monitorexit
    //   88: iload 4
    //   90: ireturn
    //   91: astore_1
    //   92: iload 5
    //   94: istore 4
    //   96: ldc 9
    //   98: ldc -54
    //   100: aload_1
    //   101: invokestatic 205	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   104: aload_3
    //   105: invokevirtual 198	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   108: aload_3
    //   109: invokevirtual 162	android/database/sqlite/SQLiteDatabase:close	()V
    //   112: invokestatic 200	com/tencent/mobileqq/app/SQLiteDatabase:h	()V
    //   115: goto -29 -> 86
    //   118: astore_1
    //   119: aload_0
    //   120: monitorexit
    //   121: aload_1
    //   122: athrow
    //   123: astore_1
    //   124: aload_3
    //   125: invokevirtual 198	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   128: aload_3
    //   129: invokevirtual 162	android/database/sqlite/SQLiteDatabase:close	()V
    //   132: invokestatic 200	com/tencent/mobileqq/app/SQLiteDatabase:h	()V
    //   135: aload_1
    //   136: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	this	ReportDbHelper
    //   0	137	1	paramString	String
    //   0	137	2	paramArrayList	ArrayList
    //   15	114	3	localSQLiteDatabase	SQLiteDatabase
    //   6	89	4	i	int
    //   3	90	5	j	int
    // Exception table:
    //   from	to	target	type
    //   20	25	91	java/lang/Exception
    //   29	38	91	java/lang/Exception
    //   42	58	91	java/lang/Exception
    //   71	75	91	java/lang/Exception
    //   8	20	118	finally
    //   75	86	118	finally
    //   104	115	118	finally
    //   124	137	118	finally
    //   20	25	123	finally
    //   29	38	123	finally
    //   42	58	123	finally
    //   71	75	123	finally
    //   96	104	123	finally
  }
  
  public int a(ArrayList paramArrayList)
  {
    try
    {
      int i = a("table_old_data", paramArrayList);
      return i;
    }
    finally
    {
      paramArrayList = finally;
      throw paramArrayList;
    }
  }
  
  public long a(String paramString, BatchReportInfo paramBatchReportInfo)
  {
    long l = -1L;
    try
    {
      SQLiteDatabase localSQLiteDatabase = a();
      if (localSQLiteDatabase != null)
      {
        l = a(localSQLiteDatabase, paramString, paramBatchReportInfo);
        localSQLiteDatabase.close();
      }
      return l;
    }
    finally {}
  }
  
  protected SQLiteDatabase a()
  {
    return ReportSqliteHelper.a(CommonDataAdapter.a().a()).getWritableDatabase();
  }
  
  public ArrayList a(String paramString)
  {
    try
    {
      paramString = a("table_new_data", paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public ArrayList a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 7
    //   5: aconst_null
    //   6: astore 8
    //   8: aconst_null
    //   9: astore 9
    //   11: aload_0
    //   12: monitorenter
    //   13: new 176	java/util/ArrayList
    //   16: dup
    //   17: invokespecial 230	java/util/ArrayList:<init>	()V
    //   20: astore 10
    //   22: aload_2
    //   23: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   26: ifeq +426 -> 452
    //   29: aconst_null
    //   30: astore 5
    //   32: aload_2
    //   33: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   36: istore 11
    //   38: iload 11
    //   40: ifeq +420 -> 460
    //   43: aconst_null
    //   44: astore 6
    //   46: aload_0
    //   47: invokevirtual 149	com/tencent/open/business/viareport/ReportDbHelper:a	()Landroid/database/sqlite/SQLiteDatabase;
    //   50: astore 4
    //   52: aload 9
    //   54: astore_3
    //   55: aload 8
    //   57: astore_2
    //   58: aload 4
    //   60: aload_1
    //   61: aconst_null
    //   62: aload 5
    //   64: aload 6
    //   66: aconst_null
    //   67: aconst_null
    //   68: aconst_null
    //   69: invokevirtual 234	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   72: astore_1
    //   73: aload_1
    //   74: astore_3
    //   75: aload_1
    //   76: astore_2
    //   77: aload_1
    //   78: invokeinterface 239 1 0
    //   83: pop
    //   84: aload_1
    //   85: astore_3
    //   86: aload_1
    //   87: astore_2
    //   88: aload_1
    //   89: invokeinterface 242 1 0
    //   94: ifne +385 -> 479
    //   97: aload_1
    //   98: astore_3
    //   99: aload_1
    //   100: astore_2
    //   101: new 30	com/tencent/open/business/viareport/BatchReportInfo
    //   104: dup
    //   105: invokespecial 243	com/tencent/open/business/viareport/BatchReportInfo:<init>	()V
    //   108: astore 5
    //   110: aload_1
    //   111: astore_3
    //   112: aload_1
    //   113: astore_2
    //   114: aload 5
    //   116: aload_1
    //   117: aload_1
    //   118: ldc 28
    //   120: invokeinterface 246 2 0
    //   125: invokeinterface 250 2 0
    //   130: putfield 33	com/tencent/open/business/viareport/BatchReportInfo:c	Ljava/lang/String;
    //   133: aload_1
    //   134: astore_3
    //   135: aload_1
    //   136: astore_2
    //   137: aload 5
    //   139: aload_1
    //   140: aload_1
    //   141: ldc 39
    //   143: invokeinterface 246 2 0
    //   148: invokeinterface 250 2 0
    //   153: putfield 41	com/tencent/open/business/viareport/BatchReportInfo:a	Ljava/lang/String;
    //   156: aload_1
    //   157: astore_3
    //   158: aload_1
    //   159: astore_2
    //   160: aload 5
    //   162: aload_1
    //   163: aload_1
    //   164: ldc 43
    //   166: invokeinterface 246 2 0
    //   171: invokeinterface 250 2 0
    //   176: putfield 46	com/tencent/open/business/viareport/BatchReportInfo:e	Ljava/lang/String;
    //   179: aload_1
    //   180: astore_3
    //   181: aload_1
    //   182: astore_2
    //   183: aload 5
    //   185: aload_1
    //   186: aload_1
    //   187: ldc 48
    //   189: invokeinterface 246 2 0
    //   194: invokeinterface 250 2 0
    //   199: putfield 51	com/tencent/open/business/viareport/BatchReportInfo:d	Ljava/lang/String;
    //   202: aload_1
    //   203: astore_3
    //   204: aload_1
    //   205: astore_2
    //   206: aload 5
    //   208: aload_1
    //   209: aload_1
    //   210: ldc 53
    //   212: invokeinterface 246 2 0
    //   217: invokeinterface 250 2 0
    //   222: putfield 56	com/tencent/open/business/viareport/BatchReportInfo:b	Ljava/lang/String;
    //   225: aload_1
    //   226: astore_3
    //   227: aload_1
    //   228: astore_2
    //   229: aload 5
    //   231: aload_1
    //   232: aload_1
    //   233: ldc 58
    //   235: invokeinterface 246 2 0
    //   240: invokeinterface 250 2 0
    //   245: putfield 253	com/tencent/open/business/viareport/BatchReportInfo:f	Ljava/lang/String;
    //   248: aload_1
    //   249: astore_3
    //   250: aload_1
    //   251: astore_2
    //   252: aload 5
    //   254: aload_1
    //   255: aload_1
    //   256: ldc 63
    //   258: invokeinterface 246 2 0
    //   263: invokeinterface 250 2 0
    //   268: putfield 66	com/tencent/open/business/viareport/BatchReportInfo:g	Ljava/lang/String;
    //   271: aload_1
    //   272: astore_3
    //   273: aload_1
    //   274: astore_2
    //   275: aload 5
    //   277: aload_1
    //   278: aload_1
    //   279: ldc 68
    //   281: invokeinterface 246 2 0
    //   286: invokeinterface 250 2 0
    //   291: putfield 71	com/tencent/open/business/viareport/BatchReportInfo:h	Ljava/lang/String;
    //   294: aload_1
    //   295: astore_3
    //   296: aload_1
    //   297: astore_2
    //   298: aload 5
    //   300: aload_1
    //   301: aload_1
    //   302: ldc 73
    //   304: invokeinterface 246 2 0
    //   309: invokeinterface 250 2 0
    //   314: putfield 76	com/tencent/open/business/viareport/BatchReportInfo:i	Ljava/lang/String;
    //   317: aload_1
    //   318: astore_3
    //   319: aload_1
    //   320: astore_2
    //   321: aload 5
    //   323: aload_1
    //   324: aload_1
    //   325: ldc 78
    //   327: invokeinterface 246 2 0
    //   332: invokeinterface 250 2 0
    //   337: putfield 81	com/tencent/open/business/viareport/BatchReportInfo:j	Ljava/lang/String;
    //   340: aload_1
    //   341: astore_3
    //   342: aload_1
    //   343: astore_2
    //   344: aload 5
    //   346: aload_1
    //   347: aload_1
    //   348: ldc 83
    //   350: invokeinterface 246 2 0
    //   355: invokeinterface 250 2 0
    //   360: putfield 86	com/tencent/open/business/viareport/BatchReportInfo:k	Ljava/lang/String;
    //   363: aload_1
    //   364: astore_3
    //   365: aload_1
    //   366: astore_2
    //   367: aload 5
    //   369: aload_1
    //   370: aload_1
    //   371: ldc 88
    //   373: invokeinterface 246 2 0
    //   378: invokeinterface 250 2 0
    //   383: putfield 91	com/tencent/open/business/viareport/BatchReportInfo:l	Ljava/lang/String;
    //   386: aload_1
    //   387: astore_3
    //   388: aload_1
    //   389: astore_2
    //   390: aload 10
    //   392: aload 5
    //   394: invokevirtual 257	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   397: pop
    //   398: aload_1
    //   399: astore_3
    //   400: aload_1
    //   401: astore_2
    //   402: aload_1
    //   403: invokeinterface 260 1 0
    //   408: pop
    //   409: goto -325 -> 84
    //   412: astore_1
    //   413: aload 4
    //   415: astore_2
    //   416: aload_1
    //   417: invokevirtual 165	java/lang/Exception:printStackTrace	()V
    //   420: ldc 9
    //   422: aload_1
    //   423: invokevirtual 166	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   426: invokestatic 111	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   429: aload_3
    //   430: ifnull +9 -> 439
    //   433: aload_3
    //   434: invokeinterface 261 1 0
    //   439: aload_2
    //   440: ifnull +7 -> 447
    //   443: aload_2
    //   444: invokevirtual 162	android/database/sqlite/SQLiteDatabase:close	()V
    //   447: aload_0
    //   448: monitorexit
    //   449: aload 10
    //   451: areturn
    //   452: ldc_w 263
    //   455: astore 5
    //   457: goto -425 -> 32
    //   460: iconst_1
    //   461: anewarray 265	java/lang/String
    //   464: astore 6
    //   466: aload 6
    //   468: iconst_0
    //   469: aload_2
    //   470: aastore
    //   471: goto -425 -> 46
    //   474: astore_1
    //   475: aload_0
    //   476: monitorexit
    //   477: aload_1
    //   478: athrow
    //   479: aload_1
    //   480: ifnull +9 -> 489
    //   483: aload_1
    //   484: invokeinterface 261 1 0
    //   489: aload 4
    //   491: ifnull -44 -> 447
    //   494: aload 4
    //   496: invokevirtual 162	android/database/sqlite/SQLiteDatabase:close	()V
    //   499: goto -52 -> 447
    //   502: aload_2
    //   503: ifnull +9 -> 512
    //   506: aload_2
    //   507: invokeinterface 261 1 0
    //   512: aload 4
    //   514: ifnull +8 -> 522
    //   517: aload 4
    //   519: invokevirtual 162	android/database/sqlite/SQLiteDatabase:close	()V
    //   522: aload_1
    //   523: athrow
    //   524: astore_1
    //   525: goto -23 -> 502
    //   528: astore_1
    //   529: aload_2
    //   530: astore 4
    //   532: aload_3
    //   533: astore_2
    //   534: goto -32 -> 502
    //   537: astore_1
    //   538: aconst_null
    //   539: astore_2
    //   540: goto -124 -> 416
    //   543: astore_1
    //   544: aconst_null
    //   545: astore 4
    //   547: aload 7
    //   549: astore_2
    //   550: goto -48 -> 502
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	553	0	this	ReportDbHelper
    //   0	553	1	paramString1	String
    //   0	553	2	paramString2	String
    //   1	532	3	localObject1	Object
    //   50	496	4	localObject2	Object
    //   30	426	5	localObject3	Object
    //   44	423	6	arrayOfString	String[]
    //   3	545	7	localObject4	Object
    //   6	50	8	localObject5	Object
    //   9	44	9	localObject6	Object
    //   20	430	10	localArrayList	ArrayList
    //   36	3	11	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   58	73	412	java/lang/Exception
    //   77	84	412	java/lang/Exception
    //   88	97	412	java/lang/Exception
    //   101	110	412	java/lang/Exception
    //   114	133	412	java/lang/Exception
    //   137	156	412	java/lang/Exception
    //   160	179	412	java/lang/Exception
    //   183	202	412	java/lang/Exception
    //   206	225	412	java/lang/Exception
    //   229	248	412	java/lang/Exception
    //   252	271	412	java/lang/Exception
    //   275	294	412	java/lang/Exception
    //   298	317	412	java/lang/Exception
    //   321	340	412	java/lang/Exception
    //   344	363	412	java/lang/Exception
    //   367	386	412	java/lang/Exception
    //   390	398	412	java/lang/Exception
    //   402	409	412	java/lang/Exception
    //   13	29	474	finally
    //   32	38	474	finally
    //   433	439	474	finally
    //   443	447	474	finally
    //   460	466	474	finally
    //   483	489	474	finally
    //   494	499	474	finally
    //   506	512	474	finally
    //   517	522	474	finally
    //   522	524	474	finally
    //   58	73	524	finally
    //   77	84	524	finally
    //   88	97	524	finally
    //   101	110	524	finally
    //   114	133	524	finally
    //   137	156	524	finally
    //   160	179	524	finally
    //   183	202	524	finally
    //   206	225	524	finally
    //   229	248	524	finally
    //   252	271	524	finally
    //   275	294	524	finally
    //   298	317	524	finally
    //   321	340	524	finally
    //   344	363	524	finally
    //   367	386	524	finally
    //   390	398	524	finally
    //   402	409	524	finally
    //   416	429	528	finally
    //   46	52	537	java/lang/Exception
    //   46	52	543	finally
  }
  
  /* Error */
  public int b(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 9
    //   5: aconst_null
    //   6: astore 8
    //   8: aconst_null
    //   9: astore 7
    //   11: aload_0
    //   12: monitorenter
    //   13: aload_2
    //   14: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   17: ifeq +84 -> 101
    //   20: aconst_null
    //   21: astore 4
    //   23: aload_2
    //   24: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   27: istore 11
    //   29: iload 11
    //   31: ifeq +78 -> 109
    //   34: aconst_null
    //   35: astore 6
    //   37: aload_0
    //   38: invokevirtual 149	com/tencent/open/business/viareport/ReportDbHelper:a	()Landroid/database/sqlite/SQLiteDatabase;
    //   41: astore 5
    //   43: aload 9
    //   45: astore_2
    //   46: aload 8
    //   48: astore_3
    //   49: aload 5
    //   51: aload_1
    //   52: aconst_null
    //   53: aload 4
    //   55: aload 6
    //   57: aconst_null
    //   58: aconst_null
    //   59: aconst_null
    //   60: invokevirtual 234	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   63: astore_1
    //   64: aload_1
    //   65: astore_2
    //   66: aload_1
    //   67: astore_3
    //   68: aload_1
    //   69: invokeinterface 269 1 0
    //   74: istore 10
    //   76: aload_1
    //   77: ifnull +9 -> 86
    //   80: aload_1
    //   81: invokeinterface 261 1 0
    //   86: aload 5
    //   88: ifnull +8 -> 96
    //   91: aload 5
    //   93: invokevirtual 162	android/database/sqlite/SQLiteDatabase:close	()V
    //   96: aload_0
    //   97: monitorexit
    //   98: iload 10
    //   100: ireturn
    //   101: ldc_w 263
    //   104: astore 4
    //   106: goto -83 -> 23
    //   109: iconst_1
    //   110: anewarray 265	java/lang/String
    //   113: astore 6
    //   115: aload 6
    //   117: iconst_0
    //   118: aload_2
    //   119: aastore
    //   120: goto -83 -> 37
    //   123: astore_1
    //   124: aload_0
    //   125: monitorexit
    //   126: aload_1
    //   127: athrow
    //   128: astore_1
    //   129: aconst_null
    //   130: astore_2
    //   131: aload 7
    //   133: astore_3
    //   134: aload_1
    //   135: invokevirtual 165	java/lang/Exception:printStackTrace	()V
    //   138: ldc 9
    //   140: aload_1
    //   141: invokevirtual 166	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   144: invokestatic 111	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   147: aload_3
    //   148: ifnull +9 -> 157
    //   151: aload_3
    //   152: invokeinterface 261 1 0
    //   157: aload_2
    //   158: ifnull +56 -> 214
    //   161: aload_2
    //   162: invokevirtual 162	android/database/sqlite/SQLiteDatabase:close	()V
    //   165: goto +49 -> 214
    //   168: aload_2
    //   169: ifnull +9 -> 178
    //   172: aload_2
    //   173: invokeinterface 261 1 0
    //   178: aload 4
    //   180: ifnull +8 -> 188
    //   183: aload 4
    //   185: invokevirtual 162	android/database/sqlite/SQLiteDatabase:close	()V
    //   188: aload_1
    //   189: athrow
    //   190: astore_1
    //   191: aload 5
    //   193: astore 4
    //   195: goto -27 -> 168
    //   198: astore_1
    //   199: aload_2
    //   200: astore 4
    //   202: aload_3
    //   203: astore_2
    //   204: goto -36 -> 168
    //   207: astore_1
    //   208: aload 5
    //   210: astore_2
    //   211: goto -77 -> 134
    //   214: iconst_0
    //   215: istore 10
    //   217: goto -121 -> 96
    //   220: astore_1
    //   221: aconst_null
    //   222: astore 4
    //   224: aload_3
    //   225: astore_2
    //   226: goto -58 -> 168
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	this	ReportDbHelper
    //   0	229	1	paramString1	String
    //   0	229	2	paramString2	String
    //   1	224	3	localObject1	Object
    //   21	202	4	localObject2	Object
    //   41	168	5	localSQLiteDatabase	SQLiteDatabase
    //   35	81	6	arrayOfString	String[]
    //   9	123	7	localObject3	Object
    //   6	41	8	localObject4	Object
    //   3	41	9	localObject5	Object
    //   74	142	10	i	int
    //   27	3	11	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   13	20	123	finally
    //   23	29	123	finally
    //   80	86	123	finally
    //   91	96	123	finally
    //   109	115	123	finally
    //   151	157	123	finally
    //   161	165	123	finally
    //   172	178	123	finally
    //   183	188	123	finally
    //   188	190	123	finally
    //   37	43	128	java/lang/Exception
    //   49	64	190	finally
    //   68	76	190	finally
    //   134	147	198	finally
    //   49	64	207	java/lang/Exception
    //   68	76	207	java/lang/Exception
    //   37	43	220	finally
  }
  
  public ArrayList b(String paramString)
  {
    try
    {
      paramString = a("table_old_data", paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\business\viareport\ReportDbHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */