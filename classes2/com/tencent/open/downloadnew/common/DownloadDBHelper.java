package com.tencent.open.downloadnew.common;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;

public class DownloadDBHelper
  extends SQLiteOpenHelper
{
  public static final int a = 14;
  protected static volatile DownloadDBHelper a;
  protected static final String a;
  protected static final byte[] a;
  public static final String[] a;
  public static final int b = 0;
  public static final String b = "app_plugin_download.db";
  public static final int c = 1;
  protected static final String c = "download_info";
  public static final int d = 2;
  protected static final String d = "appid";
  public static final int e = 3;
  protected static final String e = "download_url";
  public static final int f = 4;
  protected static final String f = "package";
  public static final int g = 5;
  protected static final String g = "push_title";
  public static final int h = 6;
  protected static final String h = "sendtime_col";
  public static final int i = 7;
  protected static final String i = "uin_col";
  public static final int j = 8;
  protected static final String j = "triggertime_col";
  public static final int k = 9;
  protected static final String k = "via_col";
  public static final int l = 10;
  protected static final String l = "patch_url";
  public static final int m = 11;
  protected static final String m = "update_type";
  public static final int n = 12;
  protected static final String n = "myappid_col";
  public static final int o = 13;
  protected static final String o = "apkid_col";
  public static final int p = 14;
  protected static final String p = "version_col";
  public static final int q = 15;
  protected static final String q = "downloadtype_col";
  public static final int r = 16;
  protected static final String r = "filepath_col";
  public static final int s = 17;
  protected static final String s = "source_col";
  public static final int t = 18;
  protected static final String t = "last_download_size";
  public static final int u = 19;
  protected static final String u = "is_apk";
  public static final int v = 20;
  protected static final String v = "myapp_download_from";
  public static final int w = 21;
  protected static final String w = "icon_url";
  public static final int x = 22;
  protected static final String x = "is_show_notification";
  protected static final String y = "apk_writecode_state";
  protected static final String z = "extra_info";
  protected long a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = DownloadDBHelper.class.getName();
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "appid", "download_url", "package", "push_title", "sendtime_col", "uin_col", "triggertime_col", "via_col", "patch_url", "update_type", "myappid_col", "apkid_col", "version_col", "downloadtype_col", "filepath_col", "source_col", "last_download_size", "is_apk", "myapp_download_from", "icon_url", "is_show_notification", "apk_writecode_state", "extra_info" };
    jdField_a_of_type_ArrayOfByte = new byte[1];
  }
  
  protected DownloadDBHelper(Context paramContext)
  {
    super(paramContext, "app_plugin_download.db", null, 14);
  }
  
  public static DownloadDBHelper a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentOpenDownloadnewCommonDownloadDBHelper == null) {
        jdField_a_of_type_ComTencentOpenDownloadnewCommonDownloadDBHelper = new DownloadDBHelper(CommonDataAdapter.a().a());
      }
      if (jdField_a_of_type_ComTencentOpenDownloadnewCommonDownloadDBHelper.jdField_a_of_type_Long == 0L)
      {
        jdField_a_of_type_ComTencentOpenDownloadnewCommonDownloadDBHelper.jdField_a_of_type_Long = CommonDataAdapter.a().a();
        if (jdField_a_of_type_ComTencentOpenDownloadnewCommonDownloadDBHelper.jdField_a_of_type_Long == 0L) {
          jdField_a_of_type_ComTencentOpenDownloadnewCommonDownloadDBHelper.jdField_a_of_type_Long = CommonDataAdapter.a().b();
        }
      }
      DownloadDBHelper localDownloadDBHelper = jdField_a_of_type_ComTencentOpenDownloadnewCommonDownloadDBHelper;
      return localDownloadDBHelper;
    }
    finally {}
  }
  
  protected DownloadInfo a(Cursor paramCursor)
  {
    String str1 = paramCursor.getString(0);
    String str2 = paramCursor.getString(1);
    String str3 = paramCursor.getString(2);
    String str4 = paramCursor.getString(3);
    String str5 = paramCursor.getString(4);
    long l1 = paramCursor.getLong(6);
    String str6 = paramCursor.getString(7);
    String str7 = paramCursor.getString(8);
    int i2 = paramCursor.getInt(9);
    String str8 = paramCursor.getString(10);
    String str9 = paramCursor.getString(11);
    int i3 = paramCursor.getInt(12);
    int i4 = paramCursor.getInt(13);
    String str10 = paramCursor.getString(14);
    int i5 = paramCursor.getInt(15);
    long l2 = paramCursor.getLong(16);
    boolean bool;
    int i6;
    String str11;
    int i7;
    if (paramCursor.getInt(17) == 1)
    {
      bool = true;
      i6 = paramCursor.getInt(18);
      str11 = paramCursor.getString(19);
      i7 = paramCursor.getInt(20);
      if (paramCursor.getInt(21) != 1) {
        break label275;
      }
    }
    label275:
    for (int i1 = 0;; i1 = paramCursor.getInt(21))
    {
      return new DownloadInfo(str1, str2, str3, str4, str5, l1, str6, str7, i2, str8, str9, i3, i4, str10, i5, l2, bool, i6, str11, i7, i1, paramCursor.getString(22));
      bool = false;
      break;
    }
  }
  
  public DownloadInfo a(String paramString)
  {
    return a("package = ?", new String[] { paramString });
  }
  
  /* Error */
  protected DownloadInfo a(String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 6
    //   9: getstatic 131	com/tencent/open/downloadnew/common/DownloadDBHelper:jdField_a_of_type_ArrayOfByte	[B
    //   12: astore 7
    //   14: aload 7
    //   16: monitorenter
    //   17: aload_0
    //   18: invokevirtual 189	com/tencent/open/downloadnew/common/DownloadDBHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   21: astore_3
    //   22: aload_3
    //   23: ldc 19
    //   25: getstatic 129	com/tencent/open/downloadnew/common/DownloadDBHelper:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   28: aload_1
    //   29: aload_2
    //   30: aconst_null
    //   31: aconst_null
    //   32: aconst_null
    //   33: invokevirtual 195	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   36: astore_2
    //   37: aload 6
    //   39: astore_1
    //   40: aload_2
    //   41: invokeinterface 199 1 0
    //   46: ifle +16 -> 62
    //   49: aload_2
    //   50: invokeinterface 203 1 0
    //   55: pop
    //   56: aload_0
    //   57: aload_2
    //   58: invokevirtual 205	com/tencent/open/downloadnew/common/DownloadDBHelper:a	(Landroid/database/Cursor;)Lcom/tencent/open/downloadnew/DownloadInfo;
    //   61: astore_1
    //   62: aload_2
    //   63: ifnull +9 -> 72
    //   66: aload_2
    //   67: invokeinterface 208 1 0
    //   72: aload_1
    //   73: astore_2
    //   74: aload_3
    //   75: ifnull +9 -> 84
    //   78: aload_3
    //   79: invokevirtual 209	android/database/sqlite/SQLiteDatabase:close	()V
    //   82: aload_1
    //   83: astore_2
    //   84: aload 7
    //   86: monitorexit
    //   87: aload_2
    //   88: areturn
    //   89: astore_3
    //   90: aconst_null
    //   91: astore_2
    //   92: aconst_null
    //   93: astore_1
    //   94: getstatic 125	com/tencent/open/downloadnew/common/DownloadDBHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   97: ldc -45
    //   99: aload_3
    //   100: invokestatic 216	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   103: aload_2
    //   104: ifnull +9 -> 113
    //   107: aload_2
    //   108: invokeinterface 208 1 0
    //   113: aload 4
    //   115: astore_2
    //   116: aload_1
    //   117: ifnull -33 -> 84
    //   120: aload_1
    //   121: invokevirtual 209	android/database/sqlite/SQLiteDatabase:close	()V
    //   124: aload 4
    //   126: astore_2
    //   127: goto -43 -> 84
    //   130: astore_1
    //   131: aload 7
    //   133: monitorexit
    //   134: aload_1
    //   135: athrow
    //   136: astore_2
    //   137: aconst_null
    //   138: astore_1
    //   139: aload 5
    //   141: astore_3
    //   142: aload_3
    //   143: ifnull +9 -> 152
    //   146: aload_3
    //   147: invokeinterface 208 1 0
    //   152: aload_1
    //   153: ifnull +7 -> 160
    //   156: aload_1
    //   157: invokevirtual 209	android/database/sqlite/SQLiteDatabase:close	()V
    //   160: aload_2
    //   161: athrow
    //   162: astore_2
    //   163: aload_3
    //   164: astore_1
    //   165: aload 5
    //   167: astore_3
    //   168: goto -26 -> 142
    //   171: astore 5
    //   173: aload_2
    //   174: astore 4
    //   176: aload_3
    //   177: astore_1
    //   178: aload 5
    //   180: astore_2
    //   181: aload 4
    //   183: astore_3
    //   184: goto -42 -> 142
    //   187: astore 4
    //   189: aload_2
    //   190: astore_3
    //   191: aload 4
    //   193: astore_2
    //   194: goto -52 -> 142
    //   197: astore_2
    //   198: aload_3
    //   199: astore_1
    //   200: aload_2
    //   201: astore_3
    //   202: aconst_null
    //   203: astore_2
    //   204: goto -110 -> 94
    //   207: astore 5
    //   209: aload_3
    //   210: astore_1
    //   211: aload 5
    //   213: astore_3
    //   214: goto -120 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	this	DownloadDBHelper
    //   0	217	1	paramString	String
    //   0	217	2	paramArrayOfString	String[]
    //   21	58	3	localSQLiteDatabase	SQLiteDatabase
    //   89	11	3	localException1	Exception
    //   141	73	3	localObject1	Object
    //   1	181	4	arrayOfString	String[]
    //   187	5	4	localObject2	Object
    //   4	162	5	localObject3	Object
    //   171	8	5	localObject4	Object
    //   207	5	5	localException2	Exception
    //   7	31	6	localObject5	Object
    //   12	120	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   17	22	89	java/lang/Exception
    //   66	72	130	finally
    //   78	82	130	finally
    //   84	87	130	finally
    //   107	113	130	finally
    //   120	124	130	finally
    //   131	134	130	finally
    //   146	152	130	finally
    //   156	160	130	finally
    //   160	162	130	finally
    //   17	22	136	finally
    //   22	37	162	finally
    //   40	62	171	finally
    //   94	103	187	finally
    //   22	37	197	java/lang/Exception
    //   40	62	207	java/lang/Exception
  }
  
  protected String a()
  {
    if (this.jdField_a_of_type_Long == 0L)
    {
      this.jdField_a_of_type_Long = CommonDataAdapter.a().a();
      if (this.jdField_a_of_type_Long == 0L) {
        LogUtility.e(jdField_a_of_type_JavaLangString, "getUin() is empty!");
      }
    }
    return String.valueOf(this.jdField_a_of_type_Long);
  }
  
  /* Error */
  public java.util.Map a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: getstatic 125	com/tencent/open/downloadnew/common/DownloadDBHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   7: ldc -28
    //   9: invokestatic 230	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: new 232	java/util/concurrent/ConcurrentHashMap
    //   15: dup
    //   16: invokespecial 234	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   19: astore 6
    //   21: getstatic 131	com/tencent/open/downloadnew/common/DownloadDBHelper:jdField_a_of_type_ArrayOfByte	[B
    //   24: astore 5
    //   26: aload 5
    //   28: monitorenter
    //   29: aload_0
    //   30: invokevirtual 189	com/tencent/open/downloadnew/common/DownloadDBHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   33: astore_1
    //   34: aload_1
    //   35: ldc 19
    //   37: getstatic 129	com/tencent/open/downloadnew/common/DownloadDBHelper:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   40: aconst_null
    //   41: aconst_null
    //   42: aconst_null
    //   43: aconst_null
    //   44: aconst_null
    //   45: invokevirtual 195	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   48: astore_3
    //   49: aload_3
    //   50: invokeinterface 199 1 0
    //   55: ifle +103 -> 158
    //   58: aload_3
    //   59: invokeinterface 203 1 0
    //   64: pop
    //   65: aload_3
    //   66: iconst_0
    //   67: invokeinterface 164 2 0
    //   72: astore_2
    //   73: getstatic 125	com/tencent/open/downloadnew/common/DownloadDBHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   76: new 236	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   83: ldc -17
    //   85: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: aload_2
    //   89: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 230	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: aload_0
    //   99: aload_3
    //   100: invokevirtual 205	com/tencent/open/downloadnew/common/DownloadDBHelper:a	(Landroid/database/Cursor;)Lcom/tencent/open/downloadnew/DownloadInfo;
    //   103: astore 4
    //   105: getstatic 125	com/tencent/open/downloadnew/common/DownloadDBHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   108: new 236	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   115: ldc -8
    //   117: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload 4
    //   122: invokevirtual 249	com/tencent/open/downloadnew/DownloadInfo:toString	()Ljava/lang/String;
    //   125: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokestatic 230	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   134: aload 6
    //   136: aload_2
    //   137: aload 4
    //   139: invokeinterface 255 3 0
    //   144: pop
    //   145: aload_3
    //   146: invokeinterface 258 1 0
    //   151: istore 7
    //   153: iload 7
    //   155: ifne -90 -> 65
    //   158: aload_3
    //   159: ifnull +9 -> 168
    //   162: aload_3
    //   163: invokeinterface 208 1 0
    //   168: aload_1
    //   169: ifnull +7 -> 176
    //   172: aload_1
    //   173: invokevirtual 209	android/database/sqlite/SQLiteDatabase:close	()V
    //   176: aload 5
    //   178: monitorexit
    //   179: aload 6
    //   181: areturn
    //   182: astore_3
    //   183: aconst_null
    //   184: astore 4
    //   186: aload_2
    //   187: astore_1
    //   188: aload 4
    //   190: astore_2
    //   191: getstatic 125	com/tencent/open/downloadnew/common/DownloadDBHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   194: ldc_w 260
    //   197: aload_3
    //   198: invokestatic 216	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   201: aload_2
    //   202: ifnull +9 -> 211
    //   205: aload_2
    //   206: invokeinterface 208 1 0
    //   211: aload_1
    //   212: ifnull -36 -> 176
    //   215: aload_1
    //   216: invokevirtual 209	android/database/sqlite/SQLiteDatabase:close	()V
    //   219: goto -43 -> 176
    //   222: astore_1
    //   223: aload 5
    //   225: monitorexit
    //   226: aload_1
    //   227: athrow
    //   228: astore_2
    //   229: aconst_null
    //   230: astore 4
    //   232: aload_3
    //   233: astore_1
    //   234: aload 4
    //   236: astore_3
    //   237: aload_3
    //   238: ifnull +9 -> 247
    //   241: aload_3
    //   242: invokeinterface 208 1 0
    //   247: aload_1
    //   248: ifnull +7 -> 255
    //   251: aload_1
    //   252: invokevirtual 209	android/database/sqlite/SQLiteDatabase:close	()V
    //   255: aload_2
    //   256: athrow
    //   257: astore_2
    //   258: aconst_null
    //   259: astore_3
    //   260: goto -23 -> 237
    //   263: astore_2
    //   264: goto -27 -> 237
    //   267: astore 4
    //   269: aload_2
    //   270: astore_3
    //   271: aload 4
    //   273: astore_2
    //   274: goto -37 -> 237
    //   277: astore_3
    //   278: aconst_null
    //   279: astore_2
    //   280: goto -89 -> 191
    //   283: astore_2
    //   284: aload_3
    //   285: astore 4
    //   287: aload_2
    //   288: astore_3
    //   289: aload 4
    //   291: astore_2
    //   292: goto -101 -> 191
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	295	0	this	DownloadDBHelper
    //   33	183	1	localObject1	Object
    //   222	5	1	localObject2	Object
    //   233	19	1	localException1	Exception
    //   3	203	2	localObject3	Object
    //   228	28	2	localObject4	Object
    //   257	1	2	localObject5	Object
    //   263	7	2	localObject6	Object
    //   273	7	2	localObject7	Object
    //   283	5	2	localException2	Exception
    //   291	1	2	localObject8	Object
    //   1	162	3	localCursor	Cursor
    //   182	51	3	localException3	Exception
    //   236	35	3	localObject9	Object
    //   277	8	3	localException4	Exception
    //   288	1	3	localObject10	Object
    //   103	132	4	localDownloadInfo	DownloadInfo
    //   267	5	4	localObject11	Object
    //   285	5	4	localException5	Exception
    //   24	200	5	arrayOfByte	byte[]
    //   19	161	6	localConcurrentHashMap	java.util.concurrent.ConcurrentHashMap
    //   151	3	7	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   29	34	182	java/lang/Exception
    //   162	168	222	finally
    //   172	176	222	finally
    //   176	179	222	finally
    //   205	211	222	finally
    //   215	219	222	finally
    //   223	226	222	finally
    //   241	247	222	finally
    //   251	255	222	finally
    //   255	257	222	finally
    //   29	34	228	finally
    //   34	49	257	finally
    //   49	65	263	finally
    //   65	153	263	finally
    //   191	201	267	finally
    //   34	49	277	java/lang/Exception
    //   49	65	283	java/lang/Exception
    //   65	153	283	java/lang/Exception
  }
  
  protected void a(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (paramInt1 != paramInt2)
    {
      paramSQLiteDatabase.beginTransaction();
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS download_info;");
      paramSQLiteDatabase.setTransactionSuccessful();
      paramSQLiteDatabase.endTransaction();
      onCreate(paramSQLiteDatabase);
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    int i1 = 0;
    int i2 = 1;
    byte[] arrayOfByte = jdField_a_of_type_ArrayOfByte;
    for (;;)
    {
      try
      {
        localSQLiteDatabase = getWritableDatabase();
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localSQLiteDatabase.beginTransaction();
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        ContentValues localContentValues = new ContentValues();
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("appid", paramDownloadInfo.jdField_b_of_type_JavaLangString);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("download_url", paramDownloadInfo.jdField_c_of_type_JavaLangString);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("package", paramDownloadInfo.d);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("push_title", paramDownloadInfo.e);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("sendtime_col", paramDownloadInfo.jdField_f_of_type_JavaLangString);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("uin_col", a());
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("triggertime_col", Long.valueOf(paramDownloadInfo.jdField_a_of_type_Long));
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("via_col", paramDownloadInfo.jdField_g_of_type_JavaLangString);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("patch_url", paramDownloadInfo.jdField_h_of_type_JavaLangString);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("update_type", Integer.valueOf(paramDownloadInfo.jdField_f_of_type_Int));
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("myappid_col", paramDownloadInfo.i);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("apkid_col", paramDownloadInfo.jdField_j_of_type_JavaLangString);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("version_col", Integer.valueOf(paramDownloadInfo.jdField_g_of_type_Int));
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("downloadtype_col", Integer.valueOf(paramDownloadInfo.jdField_h_of_type_Int));
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("filepath_col", paramDownloadInfo.k);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("source_col", Integer.valueOf(paramDownloadInfo.jdField_j_of_type_Int));
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("last_download_size", Long.valueOf(paramDownloadInfo.jdField_b_of_type_Long));
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        if (paramDownloadInfo.jdField_c_of_type_Boolean) {
          i1 = 1;
        }
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("is_apk", Integer.valueOf(i1));
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("myapp_download_from", Integer.valueOf(paramDownloadInfo.n));
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("icon_url", paramDownloadInfo.l);
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("is_show_notification", Integer.valueOf(paramDownloadInfo.o));
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        if (paramDownloadInfo.p == 0)
        {
          i1 = i2;
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          localContentValues.put("apk_writecode_state", Integer.valueOf(i1));
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          localContentValues.put("extra_info", paramDownloadInfo.m);
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          i1 = localSQLiteDatabase.update("download_info", localContentValues, "appid = ?", new String[] { paramDownloadInfo.jdField_b_of_type_JavaLangString });
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          LogUtility.a(jdField_a_of_type_JavaLangString, "addDownloadInfo>>>update affected rowNum=" + i1);
          if (i1 == 0)
          {
            localObject1 = localSQLiteDatabase;
            localObject2 = localSQLiteDatabase;
            long l1 = localSQLiteDatabase.insert("download_info", null, localContentValues);
            localObject1 = localSQLiteDatabase;
            localObject2 = localSQLiteDatabase;
            LogUtility.a(jdField_a_of_type_JavaLangString, "addDownloadInfo>>>insert rowID = " + l1);
          }
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          localSQLiteDatabase.setTransactionSuccessful();
        }
      }
      catch (Exception paramDownloadInfo)
      {
        SQLiteDatabase localSQLiteDatabase;
        localObject2 = localObject1;
        LogUtility.c(jdField_a_of_type_JavaLangString, "addDownloadExceptionInfo>>>", paramDownloadInfo);
        if (localObject1 == null) {
          continue;
        }
        try
        {
          ((SQLiteDatabase)localObject1).endTransaction();
          ((SQLiteDatabase)localObject1).close();
        }
        catch (Exception paramDownloadInfo)
        {
          LogUtility.c(jdField_a_of_type_JavaLangString, "addDownloadExceptionInfo>>>", paramDownloadInfo);
        }
        continue;
      }
      finally
      {
        if (localObject2 == null) {
          break label740;
        }
      }
      try
      {
        localSQLiteDatabase.endTransaction();
        localSQLiteDatabase.close();
        return;
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        i1 = paramDownloadInfo.p;
      }
      catch (Exception paramDownloadInfo)
      {
        LogUtility.c(jdField_a_of_type_JavaLangString, "addDownloadExceptionInfo>>>", paramDownloadInfo);
      }
      finally {}
    }
    try
    {
      ((SQLiteDatabase)localObject2).endTransaction();
      ((SQLiteDatabase)localObject2).close();
      label740:
      throw paramDownloadInfo;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        LogUtility.c(jdField_a_of_type_JavaLangString, "addDownloadExceptionInfo>>>", localException);
      }
    }
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: getstatic 131	com/tencent/open/downloadnew/common/DownloadDBHelper:jdField_a_of_type_ArrayOfByte	[B
    //   3: astore 5
    //   5: aload 5
    //   7: monitorenter
    //   8: aconst_null
    //   9: astore_3
    //   10: aconst_null
    //   11: astore_2
    //   12: aload_0
    //   13: invokevirtual 284	com/tencent/open/downloadnew/common/DownloadDBHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   16: astore 4
    //   18: aload 4
    //   20: astore_2
    //   21: aload 4
    //   23: astore_3
    //   24: getstatic 125	com/tencent/open/downloadnew/common/DownloadDBHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   27: new 236	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 237	java/lang/StringBuilder:<init>	()V
    //   34: ldc_w 376
    //   37: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: iconst_1
    //   41: anewarray 127	java/lang/String
    //   44: dup
    //   45: iconst_0
    //   46: aload_1
    //   47: aastore
    //   48: invokestatic 381	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   51: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 230	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   60: aload 4
    //   62: astore_2
    //   63: aload 4
    //   65: astore_3
    //   66: aload 4
    //   68: ldc 19
    //   70: ldc_w 352
    //   73: iconst_1
    //   74: anewarray 127	java/lang/String
    //   77: dup
    //   78: iconst_0
    //   79: aload_1
    //   80: aastore
    //   81: invokevirtual 385	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   84: pop
    //   85: aload 4
    //   87: ifnull +8 -> 95
    //   90: aload 4
    //   92: invokevirtual 209	android/database/sqlite/SQLiteDatabase:close	()V
    //   95: aload 5
    //   97: monitorexit
    //   98: return
    //   99: astore_1
    //   100: aload_2
    //   101: astore_3
    //   102: getstatic 125	com/tencent/open/downloadnew/common/DownloadDBHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   105: ldc_w 387
    //   108: aload_1
    //   109: invokestatic 216	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   112: aload_2
    //   113: ifnull -18 -> 95
    //   116: aload_2
    //   117: invokevirtual 209	android/database/sqlite/SQLiteDatabase:close	()V
    //   120: goto -25 -> 95
    //   123: astore_1
    //   124: aload 5
    //   126: monitorexit
    //   127: aload_1
    //   128: athrow
    //   129: astore_1
    //   130: aload_3
    //   131: ifnull +7 -> 138
    //   134: aload_3
    //   135: invokevirtual 209	android/database/sqlite/SQLiteDatabase:close	()V
    //   138: aload_1
    //   139: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	this	DownloadDBHelper
    //   0	140	1	paramString	String
    //   11	106	2	localObject1	Object
    //   9	126	3	localObject2	Object
    //   16	75	4	localSQLiteDatabase	SQLiteDatabase
    //   3	122	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   12	18	99	java/lang/Exception
    //   24	60	99	java/lang/Exception
    //   66	85	99	java/lang/Exception
    //   90	95	123	finally
    //   95	98	123	finally
    //   116	120	123	finally
    //   124	127	123	finally
    //   134	138	123	finally
    //   138	140	123	finally
    //   12	18	129	finally
    //   24	60	129	finally
    //   66	85	129	finally
    //   102	112	129	finally
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE download_info (appid TEXT PRIMARY KEY,download_url TEXT,package TEXT,push_title TEXT,sendtime_col TEXT,uin_col TEXT,triggertime_col INTEGER,via_col TEXT,patch_url TEXT,update_type INTEGER,myappid_col TEXT,apkid_col TEXT,version_col INTEGER,downloadtype_col INTEGER,filepath_col TEXT,source_col INTEGER,last_download_size INTEGER,is_apk INTEGER,myapp_download_from INTEGER,icon_url TEXT,is_show_notification INTEGER,apk_writecode_state INTEGER,extra_info TEXT); ");
  }
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    LogUtility.c(jdField_a_of_type_JavaLangString, "onDowngrade oldVersion=" + paramInt1 + " newVersion=" + paramInt2);
    a(paramSQLiteDatabase, paramInt1, paramInt2);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    LogUtility.c(jdField_a_of_type_JavaLangString, "onUpgrade oldVersion=" + paramInt1 + " newVersion=" + paramInt2);
    a(paramSQLiteDatabase, paramInt1, paramInt2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\downloadnew\common\DownloadDBHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */