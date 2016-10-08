package com.tencent.open.business.cgireport;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import java.util.ArrayList;
import java.util.Iterator;

public class ReportDataModal
{
  protected static final String a;
  protected SQLiteDatabase a;
  protected ReportDataModal.DataBaseHelper a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = ReportDataModal.class.getName();
  }
  
  public ReportDataModal()
  {
    this.jdField_a_of_type_ComTencentOpenBusinessCgireportReportDataModal$DataBaseHelper = new ReportDataModal.DataBaseHelper(this, CommonDataAdapter.a().a(), "agent_cgi_report.db", null, 4);
  }
  
  public int a(String paramString)
  {
    try
    {
      int i = 0 + a("newdata_report", paramString);
      LogUtility.b(jdField_a_of_type_JavaLangString, "new_table>>count=" + i);
      i += a("olddata_report", paramString);
      LogUtility.b(jdField_a_of_type_JavaLangString, "all_table>>>count=" + i);
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
    //   1: astore 4
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_2
    //   6: invokestatic 84	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifeq +64 -> 73
    //   12: aconst_null
    //   13: astore_3
    //   14: aload_2
    //   15: invokestatic 84	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   18: istore 6
    //   20: iload 6
    //   22: ifeq +57 -> 79
    //   25: aload 4
    //   27: astore_2
    //   28: aload_0
    //   29: aload_0
    //   30: getfield 45	com/tencent/open/business/cgireport/ReportDataModal:jdField_a_of_type_ComTencentOpenBusinessCgireportReportDataModal$DataBaseHelper	Lcom/tencent/open/business/cgireport/ReportDataModal$DataBaseHelper;
    //   33: invokevirtual 88	com/tencent/open/business/cgireport/ReportDataModal$DataBaseHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   36: putfield 90	com/tencent/open/business/cgireport/ReportDataModal:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   39: aload_0
    //   40: getfield 90	com/tencent/open/business/cgireport/ReportDataModal:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   43: aload_1
    //   44: aconst_null
    //   45: aload_3
    //   46: aload_2
    //   47: aconst_null
    //   48: aconst_null
    //   49: aconst_null
    //   50: invokevirtual 96	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   53: astore_1
    //   54: aload_1
    //   55: invokeinterface 102 1 0
    //   60: istore 5
    //   62: aload_1
    //   63: invokeinterface 105 1 0
    //   68: aload_0
    //   69: monitorexit
    //   70: iload 5
    //   72: ireturn
    //   73: ldc 107
    //   75: astore_3
    //   76: goto -62 -> 14
    //   79: iconst_1
    //   80: anewarray 109	java/lang/String
    //   83: astore 4
    //   85: aload 4
    //   87: iconst_0
    //   88: aload_2
    //   89: aastore
    //   90: aload 4
    //   92: astore_2
    //   93: goto -65 -> 28
    //   96: astore_1
    //   97: aload_0
    //   98: monitorexit
    //   99: aload_1
    //   100: athrow
    //   101: astore_1
    //   102: getstatic 24	com/tencent/open/business/cgireport/ReportDataModal:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   105: ldc 111
    //   107: aload_1
    //   108: invokestatic 114	com/tencent/open/base/LogUtility:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   111: iconst_0
    //   112: istore 5
    //   114: goto -46 -> 68
    //   117: astore_1
    //   118: getstatic 24	com/tencent/open/business/cgireport/ReportDataModal:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   121: aload_1
    //   122: invokevirtual 117	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   125: aload_1
    //   126: invokestatic 120	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   129: iconst_0
    //   130: istore 5
    //   132: goto -64 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	this	ReportDataModal
    //   0	135	1	paramString1	String
    //   0	135	2	paramString2	String
    //   13	63	3	str	String
    //   1	90	4	arrayOfString	String[]
    //   60	71	5	i	int
    //   18	3	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   5	12	96	finally
    //   14	20	96	finally
    //   28	39	96	finally
    //   39	68	96	finally
    //   79	85	96	finally
    //   102	111	96	finally
    //   118	129	96	finally
    //   28	39	101	java/lang/Exception
    //   39	68	117	java/lang/Exception
  }
  
  public int a(ArrayList paramArrayList)
  {
    int i;
    try
    {
      LogUtility.b("cgi_report_debug", "ReportDataModal backupOldItems count = " + paramArrayList.size());
      paramArrayList = new ArrayList(paramArrayList).iterator();
      i = 0;
      for (;;)
      {
        if (paramArrayList.hasNext())
        {
          reportItem localreportItem = (reportItem)paramArrayList.next();
          ContentValues localContentValues = new ContentValues();
          localContentValues.put("apn", localreportItem.jdField_a_of_type_JavaLangString);
          localContentValues.put("frequency", localreportItem.b);
          localContentValues.put("commandid", localreportItem.c);
          localContentValues.put("resultcode", localreportItem.d);
          localContentValues.put("tmcost", localreportItem.e);
          localContentValues.put("reqsize", localreportItem.f);
          localContentValues.put("rspsize", localreportItem.g);
          localContentValues.put("touin", localreportItem.h);
          localContentValues.put("deviceinfo", localreportItem.i);
          localContentValues.put("detail", localreportItem.j);
          localContentValues.put("appid", localreportItem.k);
          try
          {
            this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = this.jdField_a_of_type_ComTencentOpenBusinessCgireportReportDataModal$DataBaseHelper.getWritableDatabase();
            this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.insertOrThrow("olddata_report", null, localContentValues);
            this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.close();
            i += 1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              LogUtility.c(jdField_a_of_type_JavaLangString, "update>>>", localException);
            }
          }
        }
      }
      LogUtility.b("cgi_report_debug", "ReportDataModal backupOldItems succ_count = " + i);
    }
    finally {}
    return i;
  }
  
  public ArrayList a(String paramString)
  {
    try
    {
      paramString = a("newdata_report", paramString);
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
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 123
    //   4: ldc -32
    //   6: invokestatic 72	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: new 127	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 225	java/util/ArrayList:<init>	()V
    //   16: astore 5
    //   18: aload_0
    //   19: aload_0
    //   20: getfield 45	com/tencent/open/business/cgireport/ReportDataModal:jdField_a_of_type_ComTencentOpenBusinessCgireportReportDataModal$DataBaseHelper	Lcom/tencent/open/business/cgireport/ReportDataModal$DataBaseHelper;
    //   23: invokevirtual 88	com/tencent/open/business/cgireport/ReportDataModal$DataBaseHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   26: putfield 90	com/tencent/open/business/cgireport/ReportDataModal:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   29: aconst_null
    //   30: astore 4
    //   32: aload_0
    //   33: getfield 90	com/tencent/open/business/cgireport/ReportDataModal:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   36: new 53	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   43: ldc -29
    //   45: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_1
    //   49: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: ldc -27
    //   54: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: ldc -53
    //   59: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: ldc -25
    //   64: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_2
    //   68: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: iconst_0
    //   75: anewarray 109	java/lang/String
    //   78: invokevirtual 235	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   81: astore_3
    //   82: aload_3
    //   83: ifnull +335 -> 418
    //   86: aload_3
    //   87: invokeinterface 238 1 0
    //   92: pop
    //   93: aload_3
    //   94: invokeinterface 241 1 0
    //   99: ifne +319 -> 418
    //   102: aload_3
    //   103: aload_3
    //   104: ldc -102
    //   106: invokeinterface 244 2 0
    //   111: invokeinterface 248 2 0
    //   116: astore 4
    //   118: aload_3
    //   119: aload_3
    //   120: ldc -96
    //   122: invokeinterface 244 2 0
    //   127: invokeinterface 248 2 0
    //   132: astore 6
    //   134: aload_3
    //   135: aload_3
    //   136: ldc -92
    //   138: invokeinterface 244 2 0
    //   143: invokeinterface 248 2 0
    //   148: astore 7
    //   150: aload_3
    //   151: aload_3
    //   152: ldc -88
    //   154: invokeinterface 244 2 0
    //   159: invokeinterface 248 2 0
    //   164: astore 8
    //   166: aload_3
    //   167: aload_3
    //   168: ldc -83
    //   170: invokeinterface 244 2 0
    //   175: invokeinterface 248 2 0
    //   180: astore 9
    //   182: aload_3
    //   183: aload_3
    //   184: ldc -78
    //   186: invokeinterface 244 2 0
    //   191: invokeinterface 248 2 0
    //   196: astore 10
    //   198: aload_3
    //   199: aload_3
    //   200: ldc -73
    //   202: invokeinterface 244 2 0
    //   207: invokeinterface 248 2 0
    //   212: astore 11
    //   214: aload_3
    //   215: aload_3
    //   216: ldc -58
    //   218: invokeinterface 244 2 0
    //   223: invokeinterface 248 2 0
    //   228: astore 12
    //   230: aload 5
    //   232: new 149	com/tencent/open/business/cgireport/reportItem
    //   235: dup
    //   236: aload 4
    //   238: aload 6
    //   240: aload 7
    //   242: aload 8
    //   244: aload 9
    //   246: aload 10
    //   248: aload 11
    //   250: aload_3
    //   251: aload_3
    //   252: ldc -68
    //   254: invokeinterface 244 2 0
    //   259: invokeinterface 248 2 0
    //   264: aload_3
    //   265: aload_3
    //   266: ldc -63
    //   268: invokeinterface 244 2 0
    //   273: invokeinterface 248 2 0
    //   278: aload 12
    //   280: aload_2
    //   281: invokespecial 251	com/tencent/open/business/cgireport/reportItem:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   284: invokevirtual 255	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   287: pop
    //   288: aload_3
    //   289: invokeinterface 258 1 0
    //   294: pop
    //   295: goto -202 -> 93
    //   298: astore 4
    //   300: aload_3
    //   301: astore_2
    //   302: aload 4
    //   304: astore_3
    //   305: getstatic 24	com/tencent/open/business/cgireport/ReportDataModal:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   308: new 53	java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   315: ldc_w 260
    //   318: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: aload_1
    //   322: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: ldc_w 262
    //   328: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: aload_3
    //   335: invokestatic 114	com/tencent/open/base/LogUtility:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   338: aload_2
    //   339: ifnull +9 -> 348
    //   342: aload_2
    //   343: invokeinterface 105 1 0
    //   348: aload_0
    //   349: getfield 90	com/tencent/open/business/cgireport/ReportDataModal:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   352: invokevirtual 214	android/database/sqlite/SQLiteDatabase:close	()V
    //   355: ldc 123
    //   357: new 53	java/lang/StringBuilder
    //   360: dup
    //   361: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   364: ldc_w 260
    //   367: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: aload_1
    //   371: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: ldc_w 262
    //   377: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: ldc_w 264
    //   383: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: aload 5
    //   388: invokevirtual 130	java/util/ArrayList:size	()I
    //   391: invokevirtual 63	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   394: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   397: invokestatic 72	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   400: aload_0
    //   401: monitorexit
    //   402: aload 5
    //   404: areturn
    //   405: astore_1
    //   406: getstatic 24	com/tencent/open/business/cgireport/ReportDataModal:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   409: ldc 111
    //   411: aload_1
    //   412: invokestatic 114	com/tencent/open/base/LogUtility:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   415: goto -15 -> 400
    //   418: aload_3
    //   419: ifnull -71 -> 348
    //   422: aload_3
    //   423: invokeinterface 105 1 0
    //   428: goto -80 -> 348
    //   431: astore_1
    //   432: aload_0
    //   433: monitorexit
    //   434: aload_1
    //   435: athrow
    //   436: astore_1
    //   437: aconst_null
    //   438: astore_3
    //   439: aload_3
    //   440: ifnull +9 -> 449
    //   443: aload_3
    //   444: invokeinterface 105 1 0
    //   449: aload_1
    //   450: athrow
    //   451: astore_1
    //   452: goto -13 -> 439
    //   455: astore_1
    //   456: aload_2
    //   457: astore_3
    //   458: goto -19 -> 439
    //   461: astore_3
    //   462: aload 4
    //   464: astore_2
    //   465: goto -160 -> 305
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	468	0	this	ReportDataModal
    //   0	468	1	paramString1	String
    //   0	468	2	paramString2	String
    //   81	377	3	localObject	Object
    //   461	1	3	localException1	Exception
    //   30	207	4	str1	String
    //   298	165	4	localException2	Exception
    //   16	387	5	localArrayList	ArrayList
    //   132	107	6	str2	String
    //   148	93	7	str3	String
    //   164	79	8	str4	String
    //   180	65	9	str5	String
    //   196	51	10	str6	String
    //   212	37	11	str7	String
    //   228	51	12	str8	String
    // Exception table:
    //   from	to	target	type
    //   86	93	298	java/lang/Exception
    //   93	295	298	java/lang/Exception
    //   18	29	405	java/lang/Exception
    //   2	18	431	finally
    //   18	29	431	finally
    //   342	348	431	finally
    //   348	400	431	finally
    //   406	415	431	finally
    //   422	428	431	finally
    //   443	449	431	finally
    //   449	451	431	finally
    //   32	82	436	finally
    //   86	93	451	finally
    //   93	295	451	finally
    //   305	338	455	finally
    //   32	82	461	java/lang/Exception
  }
  
  public boolean a(String paramString)
  {
    boolean bool = false;
    try
    {
      LogUtility.b("cgi_report_debug", "ReportDataModal deleteOldItems start");
      try
      {
        this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = this.jdField_a_of_type_ComTencentOpenBusinessCgireportReportDataModal$DataBaseHelper.getWritableDatabase();
        paramString = "delete from olddata_report where appid=" + paramString + ";";
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          label75:
          LogUtility.a(jdField_a_of_type_JavaLangString, "deleteOldItems>>>", paramString);
        }
      }
    }
    finally {}
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.execSQL(paramString);
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.close();
      LogUtility.b("cgi_report_debug", "ReportDataModal deleteOldItems success");
      bool = true;
    }
    catch (Exception paramString)
    {
      LogUtility.a(jdField_a_of_type_JavaLangString, "deleteOldItems>>>", paramString);
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.close();
      break label75;
    }
    return bool;
  }
  
  /* Error */
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_3
    //   3: astore 11
    //   5: aload_3
    //   6: ldc_w 282
    //   9: invokevirtual 285	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   12: ifeq +14 -> 26
    //   15: aload_3
    //   16: ldc_w 287
    //   19: invokevirtual 291	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   22: iconst_0
    //   23: aaload
    //   24: astore 11
    //   26: ldc 123
    //   28: new 53	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   35: ldc_w 293
    //   38: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: aload_1
    //   42: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: ldc_w 295
    //   48: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: aload_2
    //   52: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: ldc_w 297
    //   58: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: aload 11
    //   63: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: ldc_w 299
    //   69: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: aload 4
    //   74: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: ldc_w 301
    //   80: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: aload 5
    //   85: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: ldc_w 303
    //   91: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload 6
    //   96: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: ldc_w 305
    //   102: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload 7
    //   107: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokestatic 72	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   116: new 151	android/content/ContentValues
    //   119: dup
    //   120: invokespecial 152	android/content/ContentValues:<init>	()V
    //   123: astore_3
    //   124: aload_3
    //   125: ldc -102
    //   127: new 53	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   134: aload_1
    //   135: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: ldc_w 307
    //   141: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokevirtual 158	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   150: aload_3
    //   151: ldc -96
    //   153: new 53	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   160: aload_2
    //   161: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: ldc_w 307
    //   167: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokevirtual 158	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   176: aload_3
    //   177: ldc -92
    //   179: new 53	java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   186: aload 11
    //   188: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: ldc_w 307
    //   194: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: invokevirtual 158	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   203: aload_3
    //   204: ldc -88
    //   206: new 53	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   213: aload 4
    //   215: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: ldc_w 307
    //   221: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: invokevirtual 158	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   230: aload_3
    //   231: ldc -83
    //   233: new 53	java/lang/StringBuilder
    //   236: dup
    //   237: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   240: aload 5
    //   242: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: ldc_w 307
    //   248: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokevirtual 158	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   257: aload_3
    //   258: ldc -78
    //   260: new 53	java/lang/StringBuilder
    //   263: dup
    //   264: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   267: aload 6
    //   269: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: ldc_w 307
    //   275: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: invokevirtual 158	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   284: aload_3
    //   285: ldc -73
    //   287: new 53	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   294: aload 7
    //   296: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: ldc_w 307
    //   302: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   308: invokevirtual 158	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   311: aload_3
    //   312: ldc -68
    //   314: new 53	java/lang/StringBuilder
    //   317: dup
    //   318: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   321: aload 8
    //   323: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: ldc_w 307
    //   329: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: invokevirtual 158	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   338: aload_3
    //   339: ldc -53
    //   341: new 53	java/lang/StringBuilder
    //   344: dup
    //   345: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   348: aload 10
    //   350: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: ldc_w 307
    //   356: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   362: invokevirtual 158	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   365: new 53	java/lang/StringBuilder
    //   368: dup
    //   369: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   372: astore_2
    //   373: aload_2
    //   374: ldc_w 309
    //   377: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: aload_1
    //   381: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: bipush 38
    //   386: invokevirtual 312	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   389: pop
    //   390: aload_2
    //   391: ldc_w 314
    //   394: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: astore_1
    //   398: invokestatic 319	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   401: ldc_w 321
    //   404: invokevirtual 324	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   407: ifeq +172 -> 579
    //   410: iconst_1
    //   411: istore 12
    //   413: aload_1
    //   414: iload 12
    //   416: invokevirtual 63	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   419: bipush 38
    //   421: invokevirtual 312	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   424: pop
    //   425: aload_2
    //   426: ldc_w 326
    //   429: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: invokestatic 35	com/tencent/open/adapter/CommonDataAdapter:a	()Lcom/tencent/open/adapter/CommonDataAdapter;
    //   435: invokevirtual 38	com/tencent/open/adapter/CommonDataAdapter:a	()Landroid/content/Context;
    //   438: invokestatic 331	com/tencent/open/base/APNUtil:e	(Landroid/content/Context;)Ljava/lang/String;
    //   441: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: pop
    //   445: aload_3
    //   446: ldc -63
    //   448: aload_2
    //   449: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   452: invokevirtual 158	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   455: new 53	java/lang/StringBuilder
    //   458: dup
    //   459: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   462: ldc_w 333
    //   465: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: invokestatic 35	com/tencent/open/adapter/CommonDataAdapter:a	()Lcom/tencent/open/adapter/CommonDataAdapter;
    //   471: invokevirtual 336	com/tencent/open/adapter/CommonDataAdapter:a	()J
    //   474: invokevirtual 339	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   477: ldc_w 307
    //   480: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   486: astore_2
    //   487: aload_2
    //   488: astore_1
    //   489: aload 9
    //   491: ifnull +35 -> 526
    //   494: new 53	java/lang/StringBuilder
    //   497: dup
    //   498: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   501: aload_2
    //   502: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: ldc_w 341
    //   508: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: aload 9
    //   513: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: ldc_w 307
    //   519: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   525: astore_1
    //   526: aload_3
    //   527: ldc -58
    //   529: aload_1
    //   530: invokevirtual 158	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   533: aload_0
    //   534: aload_0
    //   535: getfield 45	com/tencent/open/business/cgireport/ReportDataModal:jdField_a_of_type_ComTencentOpenBusinessCgireportReportDataModal$DataBaseHelper	Lcom/tencent/open/business/cgireport/ReportDataModal$DataBaseHelper;
    //   538: invokevirtual 209	com/tencent/open/business/cgireport/ReportDataModal$DataBaseHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   541: putfield 90	com/tencent/open/business/cgireport/ReportDataModal:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   544: aload_0
    //   545: getfield 90	com/tencent/open/business/cgireport/ReportDataModal:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   548: ldc 48
    //   550: aconst_null
    //   551: aload_3
    //   552: invokevirtual 213	android/database/sqlite/SQLiteDatabase:insertOrThrow	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   555: pop2
    //   556: aload_0
    //   557: getfield 90	com/tencent/open/business/cgireport/ReportDataModal:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   560: invokevirtual 214	android/database/sqlite/SQLiteDatabase:close	()V
    //   563: ldc 123
    //   565: ldc_w 343
    //   568: invokestatic 72	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   571: iconst_1
    //   572: istore 13
    //   574: aload_0
    //   575: monitorexit
    //   576: iload 13
    //   578: ireturn
    //   579: iconst_0
    //   580: istore 12
    //   582: goto -169 -> 413
    //   585: astore_1
    //   586: ldc 123
    //   588: ldc_w 345
    //   591: invokestatic 347	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   594: iconst_0
    //   595: istore 13
    //   597: goto -23 -> 574
    //   600: astore_1
    //   601: aload_0
    //   602: monitorexit
    //   603: aload_1
    //   604: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	605	0	this	ReportDataModal
    //   0	605	1	paramString1	String
    //   0	605	2	paramString2	String
    //   0	605	3	paramString3	String
    //   0	605	4	paramString4	String
    //   0	605	5	paramString5	String
    //   0	605	6	paramString6	String
    //   0	605	7	paramString7	String
    //   0	605	8	paramString8	String
    //   0	605	9	paramString9	String
    //   0	605	10	paramString10	String
    //   3	184	11	str	String
    //   411	170	12	i	int
    //   572	24	13	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   533	571	585	java/lang/Exception
    //   5	26	600	finally
    //   26	410	600	finally
    //   413	487	600	finally
    //   494	526	600	finally
    //   526	533	600	finally
    //   533	571	600	finally
    //   586	594	600	finally
  }
  
  public ArrayList b(String paramString)
  {
    try
    {
      paramString = a("olddata_report", paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public boolean b(String paramString)
  {
    boolean bool = false;
    try
    {
      LogUtility.b("cgi_report_debug", "ReportDataModal deleteNewItems start");
      try
      {
        this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = this.jdField_a_of_type_ComTencentOpenBusinessCgireportReportDataModal$DataBaseHelper.getWritableDatabase();
        paramString = "delete from newdata_report where appid=" + paramString + ";";
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          label75:
          LogUtility.a(jdField_a_of_type_JavaLangString, "deleteNewItems>>>", paramString);
        }
      }
    }
    finally {}
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.execSQL(paramString);
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.close();
      LogUtility.b("cgi_report_debug", "ReportDataModal deleteNewItems success");
      bool = true;
    }
    catch (Exception paramString)
    {
      LogUtility.a(jdField_a_of_type_JavaLangString, "deleteNewItems>>>", paramString);
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.close();
      break label75;
    }
    return bool;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\business\cgireport\ReportDataModal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */