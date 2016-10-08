package com.tencent.open.pcpush;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;

public class PCPushDBHelper
  extends SQLiteOpenHelper
{
  protected static final int a = 2;
  public static final Uri a = Uri.parse("content://open.pcpush/pcpush_package_info");
  protected static final String a = "PCPushDBHelper";
  public static final Uri b = Uri.parse("content://open.pcpush/pcpush_package_info/");
  public static final String b = "open.pcpush";
  public static final Uri c = Uri.parse("content://open.pcpush/pcpush_package_info//#");
  protected static final String c = "pcdb";
  protected static final String d = "content://";
  protected static final String e = "/pcpush_package_info";
  protected static final String f = "/pcpush_package_info/";
  public static final String g = "vnd.android.cursor.dir/vnd.tencent.pcpush";
  public static final String h = "vnd.android.cursor.item/vnd.tencent.pcpush";
  public static final String i = "pcpush_package_info";
  public static final String j = "_id";
  public static final String k = "key";
  public static final String l = "appid";
  public static final String m = "via";
  public static final String n = "pkgname";
  public static final String o = "versioncode";
  public static final String p = "appname";
  public static final String q = "appurl";
  public static final String r = "iconurl";
  public static final String s = "appsize";
  public static final String t = "filetype";
  public static final String u = "source";
  public static final String v = "srciconurl";
  public static final String w = "timestamp";
  public static final String x = "downloadtype";
  public static final String y = "installstate";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public PCPushDBHelper()
  {
    super(CommonDataAdapter.a().a(), "pcdb", null, 2);
  }
  
  protected void a(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (paramInt1 != paramInt2)
    {
      paramSQLiteDatabase.beginTransaction();
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS pcpush_package_info;");
      paramSQLiteDatabase.setTransactionSuccessful();
      paramSQLiteDatabase.endTransaction();
      onCreate(paramSQLiteDatabase);
    }
  }
  
  public void a(PCPushProxy.PkgEntry paramPkgEntry)
  {
    LogUtility.b("PCPushDBHelper", "addPkgEntry>>>insert entry = " + paramPkgEntry.toString());
    Object localObject2 = null;
    Object localObject1 = null;
    try
    {
      SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localSQLiteDatabase.beginTransaction();
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      ContentValues localContentValues = new ContentValues();
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("key", paramPkgEntry.jdField_a_of_type_JavaLangString);
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("appid", paramPkgEntry.jdField_b_of_type_JavaLangString);
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("appname", paramPkgEntry.e);
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("appsize", paramPkgEntry.h);
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("appurl", paramPkgEntry.f);
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("downloadtype", Integer.valueOf(paramPkgEntry.jdField_d_of_type_Int));
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("filetype", Integer.valueOf(paramPkgEntry.jdField_b_of_type_Int));
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("iconurl", paramPkgEntry.g);
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("pkgname", paramPkgEntry.jdField_d_of_type_JavaLangString);
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("source", paramPkgEntry.i);
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("srciconurl", paramPkgEntry.j);
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("versioncode", Integer.valueOf(paramPkgEntry.jdField_a_of_type_Int));
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("via", paramPkgEntry.jdField_c_of_type_JavaLangString);
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("key", paramPkgEntry.jdField_a_of_type_JavaLangString);
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("installstate", Integer.valueOf(paramPkgEntry.jdField_c_of_type_Int));
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localContentValues.put("timestamp", Long.valueOf(System.currentTimeMillis()));
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      int i1 = localSQLiteDatabase.update("pcpush_package_info", localContentValues, "key = ?", new String[] { paramPkgEntry.jdField_a_of_type_JavaLangString });
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      LogUtility.a("PCPushDBHelper", "addPkgEntry>>>update affected rowNum=" + i1);
      if (i1 == 0)
      {
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        long l1 = localSQLiteDatabase.insert("pcpush_package_info", "pkgname", localContentValues);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        LogUtility.a("PCPushDBHelper", "addPkgEntry>>>insert rowID = " + l1);
      }
      localObject1 = localSQLiteDatabase;
      localObject2 = localSQLiteDatabase;
      localSQLiteDatabase.setTransactionSuccessful();
      if (localSQLiteDatabase != null)
      {
        localSQLiteDatabase.endTransaction();
        localSQLiteDatabase.close();
      }
      return;
    }
    catch (Exception paramPkgEntry)
    {
      localObject2 = localObject1;
      LogUtility.c("PCPushDBHelper", "addPkgEntry error", paramPkgEntry);
      return;
    }
    finally
    {
      if (localObject2 != null)
      {
        ((SQLiteDatabase)localObject2).endTransaction();
        ((SQLiteDatabase)localObject2).close();
      }
    }
  }
  
  public void a(String paramString)
  {
    LogUtility.a("PCPushDBHelper", "--> delete key = " + paramString);
    try
    {
      SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
      localSQLiteDatabase.delete("pcpush_package_info", "key = ?", new String[] { paramString });
      localSQLiteDatabase.close();
      return;
    }
    catch (Exception paramString)
    {
      LogUtility.c("PCPushDBHelper", "deletePkgEntry error", paramString);
    }
  }
  
  /* Error */
  public void a(java.util.concurrent.ConcurrentHashMap paramConcurrentHashMap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 6
    //   5: aconst_null
    //   6: astore 5
    //   8: aconst_null
    //   9: astore_3
    //   10: aload_0
    //   11: invokevirtual 276	com/tencent/open/pcpush/PCPushDBHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   14: astore 4
    //   16: aload 6
    //   18: astore_2
    //   19: aload 5
    //   21: astore_3
    //   22: aload 4
    //   24: ldc 35
    //   26: aconst_null
    //   27: aconst_null
    //   28: aconst_null
    //   29: aconst_null
    //   30: aconst_null
    //   31: aconst_null
    //   32: invokevirtual 280	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   35: astore 5
    //   37: aload 5
    //   39: ifnull +464 -> 503
    //   42: aload 5
    //   44: astore_2
    //   45: aload 5
    //   47: astore_3
    //   48: aload 5
    //   50: invokeinterface 286 1 0
    //   55: ifle +448 -> 503
    //   58: aload 5
    //   60: astore_2
    //   61: aload 5
    //   63: astore_3
    //   64: aload 5
    //   66: invokeinterface 290 1 0
    //   71: pop
    //   72: aload 5
    //   74: astore_2
    //   75: aload 5
    //   77: astore_3
    //   78: new 178	com/tencent/open/pcpush/PCPushProxy$PkgEntry
    //   81: dup
    //   82: invokespecial 291	com/tencent/open/pcpush/PCPushProxy$PkgEntry:<init>	()V
    //   85: astore 6
    //   87: aload 5
    //   89: astore_2
    //   90: aload 5
    //   92: astore_3
    //   93: aload 6
    //   95: aload 5
    //   97: aload 5
    //   99: ldc 44
    //   101: invokeinterface 295 2 0
    //   106: invokeinterface 299 2 0
    //   111: putfield 185	com/tencent/open/pcpush/PCPushProxy$PkgEntry:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   114: aload 5
    //   116: astore_2
    //   117: aload 5
    //   119: astore_3
    //   120: aload 6
    //   122: aload 5
    //   124: aload 5
    //   126: ldc 56
    //   128: invokeinterface 295 2 0
    //   133: invokeinterface 299 2 0
    //   138: putfield 187	com/tencent/open/pcpush/PCPushProxy$PkgEntry:e	Ljava/lang/String;
    //   141: aload 5
    //   143: astore_2
    //   144: aload 5
    //   146: astore_3
    //   147: aload 6
    //   149: aload 5
    //   151: aload 5
    //   153: ldc 65
    //   155: invokeinterface 295 2 0
    //   160: invokeinterface 299 2 0
    //   165: putfield 189	com/tencent/open/pcpush/PCPushProxy$PkgEntry:h	Ljava/lang/String;
    //   168: aload 5
    //   170: astore_2
    //   171: aload 5
    //   173: astore_3
    //   174: aload 6
    //   176: aload 5
    //   178: aload 5
    //   180: ldc 59
    //   182: invokeinterface 295 2 0
    //   187: invokeinterface 299 2 0
    //   192: putfield 191	com/tencent/open/pcpush/PCPushProxy$PkgEntry:f	Ljava/lang/String;
    //   195: aload 5
    //   197: astore_2
    //   198: aload 5
    //   200: astore_3
    //   201: aload 6
    //   203: aload 5
    //   205: aload 5
    //   207: ldc 68
    //   209: invokeinterface 295 2 0
    //   214: invokeinterface 303 2 0
    //   219: putfield 204	com/tencent/open/pcpush/PCPushProxy$PkgEntry:jdField_b_of_type_Int	I
    //   222: aload 5
    //   224: astore_2
    //   225: aload 5
    //   227: astore_3
    //   228: aload 6
    //   230: aload 5
    //   232: aload 5
    //   234: ldc 62
    //   236: invokeinterface 295 2 0
    //   241: invokeinterface 299 2 0
    //   246: putfield 206	com/tencent/open/pcpush/PCPushProxy$PkgEntry:g	Ljava/lang/String;
    //   249: aload 5
    //   251: astore_2
    //   252: aload 5
    //   254: astore_3
    //   255: aload 6
    //   257: aload 5
    //   259: aload 5
    //   261: ldc 50
    //   263: invokeinterface 295 2 0
    //   268: invokeinterface 299 2 0
    //   273: putfield 208	com/tencent/open/pcpush/PCPushProxy$PkgEntry:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   276: aload 5
    //   278: astore_2
    //   279: aload 5
    //   281: astore_3
    //   282: aload 6
    //   284: aload 5
    //   286: aload 5
    //   288: ldc 71
    //   290: invokeinterface 295 2 0
    //   295: invokeinterface 299 2 0
    //   300: putfield 210	com/tencent/open/pcpush/PCPushProxy$PkgEntry:i	Ljava/lang/String;
    //   303: aload 5
    //   305: astore_2
    //   306: aload 5
    //   308: astore_3
    //   309: aload 6
    //   311: aload 5
    //   313: aload 5
    //   315: ldc 74
    //   317: invokeinterface 295 2 0
    //   322: invokeinterface 299 2 0
    //   327: putfield 212	com/tencent/open/pcpush/PCPushProxy$PkgEntry:j	Ljava/lang/String;
    //   330: aload 5
    //   332: astore_2
    //   333: aload 5
    //   335: astore_3
    //   336: aload 6
    //   338: aload 5
    //   340: aload 5
    //   342: ldc 53
    //   344: invokeinterface 295 2 0
    //   349: invokeinterface 303 2 0
    //   354: putfield 214	com/tencent/open/pcpush/PCPushProxy$PkgEntry:jdField_a_of_type_Int	I
    //   357: aload 5
    //   359: astore_2
    //   360: aload 5
    //   362: astore_3
    //   363: aload 6
    //   365: aload 5
    //   367: aload 5
    //   369: ldc 47
    //   371: invokeinterface 295 2 0
    //   376: invokeinterface 299 2 0
    //   381: putfield 216	com/tencent/open/pcpush/PCPushProxy$PkgEntry:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   384: aload 5
    //   386: astore_2
    //   387: aload 5
    //   389: astore_3
    //   390: aload 6
    //   392: aload 5
    //   394: aload 5
    //   396: ldc 80
    //   398: invokeinterface 295 2 0
    //   403: invokeinterface 303 2 0
    //   408: putfield 193	com/tencent/open/pcpush/PCPushProxy$PkgEntry:jdField_d_of_type_Int	I
    //   411: aload 5
    //   413: astore_2
    //   414: aload 5
    //   416: astore_3
    //   417: aload 6
    //   419: aload 5
    //   421: aload 5
    //   423: ldc 41
    //   425: invokeinterface 295 2 0
    //   430: invokeinterface 299 2 0
    //   435: putfield 180	com/tencent/open/pcpush/PCPushProxy$PkgEntry:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   438: aload 5
    //   440: astore_2
    //   441: aload 5
    //   443: astore_3
    //   444: aload 6
    //   446: aload 5
    //   448: aload 5
    //   450: ldc 83
    //   452: invokeinterface 295 2 0
    //   457: invokeinterface 303 2 0
    //   462: putfield 218	com/tencent/open/pcpush/PCPushProxy$PkgEntry:jdField_c_of_type_Int	I
    //   465: aload 5
    //   467: astore_2
    //   468: aload 5
    //   470: astore_3
    //   471: aload_1
    //   472: aload 6
    //   474: getfield 180	com/tencent/open/pcpush/PCPushProxy$PkgEntry:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   477: aload 6
    //   479: invokevirtual 308	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   482: pop
    //   483: aload 5
    //   485: astore_2
    //   486: aload 5
    //   488: astore_3
    //   489: aload 5
    //   491: invokeinterface 311 1 0
    //   496: istore 7
    //   498: iload 7
    //   500: ifne -428 -> 72
    //   503: aload 5
    //   505: ifnull +10 -> 515
    //   508: aload 5
    //   510: invokeinterface 312 1 0
    //   515: aload 4
    //   517: ifnull +8 -> 525
    //   520: aload 4
    //   522: invokevirtual 259	android/database/sqlite/SQLiteDatabase:close	()V
    //   525: return
    //   526: astore_2
    //   527: aconst_null
    //   528: astore_1
    //   529: ldc 11
    //   531: ldc_w 314
    //   534: aload_2
    //   535: invokestatic 264	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   538: aload_3
    //   539: ifnull +9 -> 548
    //   542: aload_3
    //   543: invokeinterface 312 1 0
    //   548: aload_1
    //   549: ifnull -24 -> 525
    //   552: aload_1
    //   553: invokevirtual 259	android/database/sqlite/SQLiteDatabase:close	()V
    //   556: return
    //   557: astore 4
    //   559: aconst_null
    //   560: astore_1
    //   561: aload_2
    //   562: ifnull +9 -> 571
    //   565: aload_2
    //   566: invokeinterface 312 1 0
    //   571: aload_1
    //   572: ifnull +7 -> 579
    //   575: aload_1
    //   576: invokevirtual 259	android/database/sqlite/SQLiteDatabase:close	()V
    //   579: aload 4
    //   581: athrow
    //   582: astore_3
    //   583: aload 4
    //   585: astore_1
    //   586: aload_3
    //   587: astore 4
    //   589: goto -28 -> 561
    //   592: astore 4
    //   594: aload_3
    //   595: astore_2
    //   596: goto -35 -> 561
    //   599: astore_2
    //   600: aload 4
    //   602: astore_1
    //   603: goto -74 -> 529
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	606	0	this	PCPushDBHelper
    //   0	606	1	paramConcurrentHashMap	java.util.concurrent.ConcurrentHashMap
    //   1	485	2	localObject1	Object
    //   526	40	2	localException1	Exception
    //   595	1	2	localObject2	Object
    //   599	1	2	localException2	Exception
    //   9	534	3	localCursor1	android.database.Cursor
    //   582	13	3	localObject3	Object
    //   14	507	4	localSQLiteDatabase	SQLiteDatabase
    //   557	27	4	localObject4	Object
    //   587	1	4	localObject5	Object
    //   592	9	4	localObject6	Object
    //   6	503	5	localCursor2	android.database.Cursor
    //   3	475	6	localPkgEntry	PCPushProxy.PkgEntry
    //   496	3	7	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   10	16	526	java/lang/Exception
    //   10	16	557	finally
    //   22	37	582	finally
    //   48	58	582	finally
    //   64	72	582	finally
    //   78	87	582	finally
    //   93	114	582	finally
    //   120	141	582	finally
    //   147	168	582	finally
    //   174	195	582	finally
    //   201	222	582	finally
    //   228	249	582	finally
    //   255	276	582	finally
    //   282	303	582	finally
    //   309	330	582	finally
    //   336	357	582	finally
    //   363	384	582	finally
    //   390	411	582	finally
    //   417	438	582	finally
    //   444	465	582	finally
    //   471	483	582	finally
    //   489	498	582	finally
    //   529	538	592	finally
    //   22	37	599	java/lang/Exception
    //   48	58	599	java/lang/Exception
    //   64	72	599	java/lang/Exception
    //   78	87	599	java/lang/Exception
    //   93	114	599	java/lang/Exception
    //   120	141	599	java/lang/Exception
    //   147	168	599	java/lang/Exception
    //   174	195	599	java/lang/Exception
    //   201	222	599	java/lang/Exception
    //   228	249	599	java/lang/Exception
    //   255	276	599	java/lang/Exception
    //   282	303	599	java/lang/Exception
    //   309	330	599	java/lang/Exception
    //   336	357	599	java/lang/Exception
    //   363	384	599	java/lang/Exception
    //   390	411	599	java/lang/Exception
    //   417	438	599	java/lang/Exception
    //   444	465	599	java/lang/Exception
    //   471	483	599	java/lang/Exception
    //   489	498	599	java/lang/Exception
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    LogUtility.a("PCPushDBHelper", "--> start--DatabaseHelper onCreate<<<<");
    paramSQLiteDatabase.execSQL("CREATE TABLE pcpush_package_info (key TEXT PRIMARY KEY,appid TEXT,via TEXT,pkgname TEXT,versioncode INTEGER,appname TEXT,appurl TEXT,iconurl TEXT,appsize TEXT,filetype TEXT,source TEXT,srciconurl TEXT,timestamp INTEGER,installstate INTEGER,downloadtype INTEGER);");
    LogUtility.a("PCPushDBHelper", "--> end--DatabaseHelper onCreate<<<<");
  }
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    LogUtility.c("PCPushDBHelper", "onDowngrade oldVersion=" + paramInt1 + " newVersion=" + paramInt2);
    a(paramSQLiteDatabase, paramInt1, paramInt2);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    LogUtility.c("PCPushDBHelper", "onUpgrade oldVersion=" + paramInt1 + " newVersion=" + paramInt2);
    a(paramSQLiteDatabase, paramInt1, paramInt2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\pcpush\PCPushDBHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */