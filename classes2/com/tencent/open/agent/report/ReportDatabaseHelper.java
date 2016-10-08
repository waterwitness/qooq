package com.tencent.open.agent.report;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.adapter.CommonDataAdapter;

public class ReportDatabaseHelper
  extends SQLiteOpenHelper
{
  protected static final int a = 2;
  protected static ReportDatabaseHelper a;
  protected static final String a = "agent_report.db";
  protected static final String[] a;
  protected static final int b = 20;
  protected static final String b = "via_cgi_report";
  protected static final String c = "key";
  protected static final String d = "type";
  protected static final String e = "blob";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "key" };
  }
  
  public ReportDatabaseHelper(Context paramContext)
  {
    super(paramContext, "agent_report.db", null, 2);
  }
  
  public static ReportDatabaseHelper a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentOpenAgentReportReportDatabaseHelper == null) {
        jdField_a_of_type_ComTencentOpenAgentReportReportDatabaseHelper = new ReportDatabaseHelper(CommonDataAdapter.a().a());
      }
      ReportDatabaseHelper localReportDatabaseHelper = jdField_a_of_type_ComTencentOpenAgentReportReportDatabaseHelper;
      return localReportDatabaseHelper;
    }
    finally {}
  }
  
  /* Error */
  public int a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 63	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: istore 5
    //   8: iload 5
    //   10: ifeq +11 -> 21
    //   13: iconst_0
    //   14: istore 4
    //   16: aload_0
    //   17: monitorexit
    //   18: iload 4
    //   20: ireturn
    //   21: aload_0
    //   22: invokevirtual 67	com/tencent/open/agent/report/ReportDatabaseHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   25: astore_3
    //   26: aload_3
    //   27: ifnonnull +9 -> 36
    //   30: iconst_0
    //   31: istore 4
    //   33: goto -17 -> 16
    //   36: aload_3
    //   37: ldc 16
    //   39: getstatic 37	com/tencent/open/agent/report/ReportDatabaseHelper:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   42: ldc 69
    //   44: iconst_1
    //   45: anewarray 35	java/lang/String
    //   48: dup
    //   49: iconst_0
    //   50: aload_1
    //   51: aastore
    //   52: aconst_null
    //   53: aconst_null
    //   54: aconst_null
    //   55: invokevirtual 75	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   58: astore_2
    //   59: aload_2
    //   60: ifnull +61 -> 121
    //   63: aload_2
    //   64: invokeinterface 81 1 0
    //   69: istore 4
    //   71: aload_2
    //   72: ifnull +9 -> 81
    //   75: aload_2
    //   76: invokeinterface 84 1 0
    //   81: aload_3
    //   82: ifnull +45 -> 127
    //   85: aload_3
    //   86: invokevirtual 85	android/database/sqlite/SQLiteDatabase:close	()V
    //   89: goto +38 -> 127
    //   92: aload_2
    //   93: ifnull +9 -> 102
    //   96: aload_2
    //   97: invokeinterface 84 1 0
    //   102: aload_3
    //   103: ifnull +7 -> 110
    //   106: aload_3
    //   107: invokevirtual 85	android/database/sqlite/SQLiteDatabase:close	()V
    //   110: aload_1
    //   111: athrow
    //   112: astore_1
    //   113: aload_0
    //   114: monitorexit
    //   115: aload_1
    //   116: athrow
    //   117: astore_1
    //   118: goto -26 -> 92
    //   121: iconst_0
    //   122: istore 4
    //   124: goto -53 -> 71
    //   127: goto -111 -> 16
    //   130: astore_1
    //   131: aconst_null
    //   132: astore_2
    //   133: goto -41 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	ReportDatabaseHelper
    //   0	136	1	paramString	String
    //   58	75	2	localCursor	android.database.Cursor
    //   25	82	3	localSQLiteDatabase	SQLiteDatabase
    //   14	109	4	i	int
    //   6	3	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	8	112	finally
    //   21	26	112	finally
    //   75	81	112	finally
    //   85	89	112	finally
    //   96	102	112	finally
    //   106	110	112	finally
    //   110	112	112	finally
    //   63	71	117	finally
    //   36	59	130	finally
  }
  
  /* Error */
  public java.util.List a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 92	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 94	java/util/ArrayList:<init>	()V
    //   9: astore 5
    //   11: aload_1
    //   12: invokestatic 63	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15: istore 7
    //   17: iload 7
    //   19: ifeq +8 -> 27
    //   22: aload_0
    //   23: monitorexit
    //   24: aload 5
    //   26: areturn
    //   27: aload_0
    //   28: invokevirtual 67	com/tencent/open/agent/report/ReportDatabaseHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   31: astore 4
    //   33: aload 4
    //   35: ifnonnull +6 -> 41
    //   38: goto -16 -> 22
    //   41: aload 4
    //   43: ldc 16
    //   45: aconst_null
    //   46: ldc 69
    //   48: iconst_1
    //   49: anewarray 35	java/lang/String
    //   52: dup
    //   53: iconst_0
    //   54: aload_1
    //   55: aastore
    //   56: aconst_null
    //   57: aconst_null
    //   58: aconst_null
    //   59: invokevirtual 75	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   62: astore_3
    //   63: aload_3
    //   64: ifnull +101 -> 165
    //   67: aload_3
    //   68: invokeinterface 81 1 0
    //   73: ifle +92 -> 165
    //   76: aload_3
    //   77: invokeinterface 98 1 0
    //   82: pop
    //   83: new 100	java/io/ByteArrayInputStream
    //   86: dup
    //   87: aload_3
    //   88: aload_3
    //   89: ldc 25
    //   91: invokeinterface 103 2 0
    //   96: invokeinterface 107 2 0
    //   101: invokespecial 110	java/io/ByteArrayInputStream:<init>	([B)V
    //   104: astore 6
    //   106: new 112	java/io/ObjectInputStream
    //   109: dup
    //   110: aload 6
    //   112: invokespecial 115	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   115: astore_1
    //   116: aload_1
    //   117: invokevirtual 119	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   120: checkcast 121	java/io/Serializable
    //   123: astore_2
    //   124: aload_1
    //   125: ifnull +7 -> 132
    //   128: aload_1
    //   129: invokevirtual 122	java/io/ObjectInputStream:close	()V
    //   132: aload 6
    //   134: invokevirtual 123	java/io/ByteArrayInputStream:close	()V
    //   137: aload_2
    //   138: astore_1
    //   139: aload_1
    //   140: ifnull +12 -> 152
    //   143: aload 5
    //   145: aload_1
    //   146: invokeinterface 129 2 0
    //   151: pop
    //   152: aload_3
    //   153: invokeinterface 132 1 0
    //   158: istore 7
    //   160: iload 7
    //   162: ifne -79 -> 83
    //   165: aload_3
    //   166: ifnull +9 -> 175
    //   169: aload_3
    //   170: invokeinterface 84 1 0
    //   175: aload 4
    //   177: ifnull +8 -> 185
    //   180: aload 4
    //   182: invokevirtual 85	android/database/sqlite/SQLiteDatabase:close	()V
    //   185: iconst_0
    //   186: ifeq +11 -> 197
    //   189: new 134	java/lang/NullPointerException
    //   192: dup
    //   193: invokespecial 135	java/lang/NullPointerException:<init>	()V
    //   196: athrow
    //   197: goto -175 -> 22
    //   200: astore_1
    //   201: aconst_null
    //   202: astore_1
    //   203: aload_1
    //   204: ifnull +7 -> 211
    //   207: aload_1
    //   208: invokevirtual 122	java/io/ObjectInputStream:close	()V
    //   211: aload 6
    //   213: invokevirtual 123	java/io/ByteArrayInputStream:close	()V
    //   216: aconst_null
    //   217: astore_1
    //   218: goto -79 -> 139
    //   221: astore_1
    //   222: aconst_null
    //   223: astore_1
    //   224: goto -85 -> 139
    //   227: astore_2
    //   228: aconst_null
    //   229: astore_1
    //   230: aload_1
    //   231: ifnull +7 -> 238
    //   234: aload_1
    //   235: invokevirtual 122	java/io/ObjectInputStream:close	()V
    //   238: aload 6
    //   240: invokevirtual 123	java/io/ByteArrayInputStream:close	()V
    //   243: aload_2
    //   244: athrow
    //   245: astore_1
    //   246: aload_3
    //   247: astore_2
    //   248: aload_2
    //   249: ifnull +9 -> 258
    //   252: aload_2
    //   253: invokeinterface 84 1 0
    //   258: aload 4
    //   260: ifnull +8 -> 268
    //   263: aload 4
    //   265: invokevirtual 85	android/database/sqlite/SQLiteDatabase:close	()V
    //   268: iconst_0
    //   269: ifeq +11 -> 280
    //   272: new 134	java/lang/NullPointerException
    //   275: dup
    //   276: invokespecial 135	java/lang/NullPointerException:<init>	()V
    //   279: athrow
    //   280: aload_1
    //   281: athrow
    //   282: astore_1
    //   283: aload_0
    //   284: monitorexit
    //   285: aload_1
    //   286: athrow
    //   287: astore_1
    //   288: aload_1
    //   289: invokevirtual 138	java/io/IOException:printStackTrace	()V
    //   292: goto -95 -> 197
    //   295: astore_2
    //   296: aload_2
    //   297: invokevirtual 138	java/io/IOException:printStackTrace	()V
    //   300: goto -20 -> 280
    //   303: astore_1
    //   304: goto -172 -> 132
    //   307: astore_1
    //   308: aload_2
    //   309: astore_1
    //   310: goto -171 -> 139
    //   313: astore_1
    //   314: goto -103 -> 211
    //   317: astore_1
    //   318: goto -80 -> 238
    //   321: astore_1
    //   322: goto -79 -> 243
    //   325: astore_1
    //   326: aconst_null
    //   327: astore_2
    //   328: goto -80 -> 248
    //   331: astore_2
    //   332: goto -102 -> 230
    //   335: astore_2
    //   336: goto -133 -> 203
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	339	0	this	ReportDatabaseHelper
    //   0	339	1	paramString	String
    //   123	15	2	localSerializable	java.io.Serializable
    //   227	17	2	localObject1	Object
    //   247	6	2	localCursor1	android.database.Cursor
    //   295	14	2	localIOException	java.io.IOException
    //   327	1	2	localObject2	Object
    //   331	1	2	localObject3	Object
    //   335	1	2	localException	Exception
    //   62	185	3	localCursor2	android.database.Cursor
    //   31	233	4	localSQLiteDatabase	SQLiteDatabase
    //   9	135	5	localArrayList	java.util.ArrayList
    //   104	135	6	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   15	146	7	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   106	116	200	java/lang/Exception
    //   211	216	221	java/io/IOException
    //   106	116	227	finally
    //   67	83	245	finally
    //   83	106	245	finally
    //   128	132	245	finally
    //   132	137	245	finally
    //   143	152	245	finally
    //   152	160	245	finally
    //   207	211	245	finally
    //   211	216	245	finally
    //   234	238	245	finally
    //   238	243	245	finally
    //   243	245	245	finally
    //   2	17	282	finally
    //   27	33	282	finally
    //   169	175	282	finally
    //   180	185	282	finally
    //   189	197	282	finally
    //   252	258	282	finally
    //   263	268	282	finally
    //   272	280	282	finally
    //   280	282	282	finally
    //   288	292	282	finally
    //   296	300	282	finally
    //   189	197	287	java/io/IOException
    //   272	280	295	java/io/IOException
    //   128	132	303	java/io/IOException
    //   132	137	307	java/io/IOException
    //   207	211	313	java/io/IOException
    //   234	238	317	java/io/IOException
    //   238	243	321	java/io/IOException
    //   41	63	325	finally
    //   116	124	331	finally
    //   116	124	335	java/lang/Exception
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 63	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: invokevirtual 142	com/tencent/open/agent/report/ReportDatabaseHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   18: astore_2
    //   19: aload_2
    //   20: ifnull -9 -> 11
    //   23: aload_2
    //   24: ldc 16
    //   26: ldc 69
    //   28: iconst_1
    //   29: anewarray 35	java/lang/String
    //   32: dup
    //   33: iconst_0
    //   34: aload_1
    //   35: aastore
    //   36: invokevirtual 146	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   39: pop
    //   40: aload_2
    //   41: invokevirtual 85	android/database/sqlite/SQLiteDatabase:close	()V
    //   44: goto -33 -> 11
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	ReportDatabaseHelper
    //   0	52	1	paramString	String
    //   18	23	2	localSQLiteDatabase	SQLiteDatabase
    //   6	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	47	finally
    //   14	19	47	finally
    //   23	44	47	finally
  }
  
  /* Error */
  public void a(String paramString, java.util.List paramList)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_2
    //   6: invokeinterface 150 1 0
    //   11: istore 9
    //   13: aload_1
    //   14: invokestatic 63	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   17: istore 11
    //   19: iload 11
    //   21: ifne +8 -> 29
    //   24: iload 9
    //   26: ifne +6 -> 32
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: iload 9
    //   34: bipush 20
    //   36: if_icmpgt +147 -> 183
    //   39: aload_0
    //   40: aload_1
    //   41: invokevirtual 152	com/tencent/open/agent/report/ReportDatabaseHelper:a	(Ljava/lang/String;)V
    //   44: aload_0
    //   45: invokevirtual 142	com/tencent/open/agent/report/ReportDatabaseHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   48: astore 5
    //   50: aload 5
    //   52: ifnull -23 -> 29
    //   55: aload 5
    //   57: invokevirtual 155	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   60: new 157	android/content/ContentValues
    //   63: dup
    //   64: invokespecial 158	android/content/ContentValues:<init>	()V
    //   67: astore 7
    //   69: iconst_0
    //   70: istore 10
    //   72: iload 10
    //   74: iload 9
    //   76: if_icmpge +174 -> 250
    //   79: aload_2
    //   80: iload 10
    //   82: invokeinterface 162 2 0
    //   87: checkcast 121	java/io/Serializable
    //   90: astore 8
    //   92: aload 8
    //   94: ifnull +75 -> 169
    //   97: aload 7
    //   99: ldc 22
    //   101: aload_1
    //   102: invokevirtual 166	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: new 168	java/io/ByteArrayOutputStream
    //   108: dup
    //   109: sipush 512
    //   112: invokespecial 171	java/io/ByteArrayOutputStream:<init>	(I)V
    //   115: astore 6
    //   117: new 173	java/io/ObjectOutputStream
    //   120: dup
    //   121: aload 6
    //   123: invokespecial 176	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   126: astore_3
    //   127: aload_3
    //   128: aload 8
    //   130: invokevirtual 180	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   133: aload_3
    //   134: ifnull +7 -> 141
    //   137: aload_3
    //   138: invokevirtual 181	java/io/ObjectOutputStream:close	()V
    //   141: aload 6
    //   143: invokevirtual 182	java/io/ByteArrayOutputStream:close	()V
    //   146: aload 7
    //   148: ldc 25
    //   150: aload 6
    //   152: invokevirtual 186	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   155: invokevirtual 189	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   158: aload 5
    //   160: ldc 16
    //   162: aconst_null
    //   163: aload 7
    //   165: invokevirtual 193	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   168: pop2
    //   169: aload 7
    //   171: invokevirtual 196	android/content/ContentValues:clear	()V
    //   174: iload 10
    //   176: iconst_1
    //   177: iadd
    //   178: istore 10
    //   180: goto -108 -> 72
    //   183: bipush 20
    //   185: istore 9
    //   187: goto -148 -> 39
    //   190: astore_3
    //   191: aconst_null
    //   192: astore_3
    //   193: aload_3
    //   194: ifnull +7 -> 201
    //   197: aload_3
    //   198: invokevirtual 181	java/io/ObjectOutputStream:close	()V
    //   201: aload 6
    //   203: invokevirtual 182	java/io/ByteArrayOutputStream:close	()V
    //   206: goto -60 -> 146
    //   209: astore_3
    //   210: goto -64 -> 146
    //   213: astore_1
    //   214: aload 4
    //   216: astore_2
    //   217: aload_2
    //   218: ifnull +7 -> 225
    //   221: aload_2
    //   222: invokevirtual 181	java/io/ObjectOutputStream:close	()V
    //   225: aload 6
    //   227: invokevirtual 182	java/io/ByteArrayOutputStream:close	()V
    //   230: aload_1
    //   231: athrow
    //   232: astore_1
    //   233: aload 5
    //   235: invokevirtual 199	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   238: aload 5
    //   240: invokevirtual 85	android/database/sqlite/SQLiteDatabase:close	()V
    //   243: aload_1
    //   244: athrow
    //   245: astore_1
    //   246: aload_0
    //   247: monitorexit
    //   248: aload_1
    //   249: athrow
    //   250: aload 5
    //   252: invokevirtual 202	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   255: aload 5
    //   257: invokevirtual 199	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   260: aload 5
    //   262: invokevirtual 85	android/database/sqlite/SQLiteDatabase:close	()V
    //   265: goto -236 -> 29
    //   268: astore_3
    //   269: goto -128 -> 141
    //   272: astore_3
    //   273: goto -127 -> 146
    //   276: astore_3
    //   277: goto -76 -> 201
    //   280: astore_2
    //   281: goto -56 -> 225
    //   284: astore_2
    //   285: goto -55 -> 230
    //   288: astore_1
    //   289: aload_3
    //   290: astore_2
    //   291: goto -74 -> 217
    //   294: astore 8
    //   296: goto -103 -> 193
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	299	0	this	ReportDatabaseHelper
    //   0	299	1	paramString	String
    //   0	299	2	paramList	java.util.List
    //   126	12	3	localObjectOutputStream	java.io.ObjectOutputStream
    //   190	1	3	localIOException1	java.io.IOException
    //   192	6	3	localObject1	Object
    //   209	1	3	localIOException2	java.io.IOException
    //   268	1	3	localIOException3	java.io.IOException
    //   272	1	3	localIOException4	java.io.IOException
    //   276	14	3	localIOException5	java.io.IOException
    //   1	214	4	localObject2	Object
    //   48	213	5	localSQLiteDatabase	SQLiteDatabase
    //   115	111	6	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   67	103	7	localContentValues	android.content.ContentValues
    //   90	39	8	localSerializable	java.io.Serializable
    //   294	1	8	localIOException6	java.io.IOException
    //   11	175	9	i	int
    //   70	109	10	j	int
    //   17	3	11	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   117	127	190	java/io/IOException
    //   201	206	209	java/io/IOException
    //   117	127	213	finally
    //   60	69	232	finally
    //   79	92	232	finally
    //   97	117	232	finally
    //   137	141	232	finally
    //   141	146	232	finally
    //   146	169	232	finally
    //   169	174	232	finally
    //   197	201	232	finally
    //   201	206	232	finally
    //   221	225	232	finally
    //   225	230	232	finally
    //   230	232	232	finally
    //   250	255	232	finally
    //   5	19	245	finally
    //   39	50	245	finally
    //   55	60	245	finally
    //   233	245	245	finally
    //   255	265	245	finally
    //   137	141	268	java/io/IOException
    //   141	146	272	java/io/IOException
    //   197	201	276	java/io/IOException
    //   221	225	280	java/io/IOException
    //   225	230	284	java/io/IOException
    //   127	133	288	finally
    //   127	133	294	java/io/IOException
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS via_cgi_report( _id INTEGER PRIMARY KEY,key TEXT,type TEXT,blob BLOB);");
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS via_cgi_report");
    onCreate(paramSQLiteDatabase);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\agent\report\ReportDatabaseHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */