import VACDReport.ReportHeader;
import VACDReport.ReportItem;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public final class ovb
  extends SQLiteOpenHelper
{
  private static final int jdField_a_of_type_Int = 6;
  private static final long jdField_a_of_type_Long = 30000L;
  private static final String jdField_a_of_type_JavaLangString = "VACDReport";
  private static final int jdField_b_of_type_Int = 1;
  private static final String jdField_b_of_type_JavaLangString = "VACDReport.db";
  private static final int jdField_c_of_type_Int = 0;
  private static final String jdField_c_of_type_JavaLangString = "ReportItem";
  private static final String d = "createTime";
  private static final String e = "seqno";
  private static final String f = "content";
  private static final String g = "type";
  private static final String h = "skey";
  private static final String i = "sendTime";
  private static final String j = "ReportRecord";
  
  public ovb(Context paramContext)
  {
    super(paramContext, "VACDReport.db", null, 6);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private ReportHeader a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = new String(Base64Util.decode(paramString.getBytes(), 0));
    try
    {
      paramString = new JSONObject(paramString);
      ReportHeader localReportHeader = new ReportHeader();
      localReportHeader.platform = paramString.optString("platform");
      localReportHeader.version = paramString.optString("version");
      localReportHeader.seqno = paramString.optLong("seqno");
      localReportHeader.sAction = paramString.optString("sAction");
      localReportHeader.sModule = paramString.optString("sModule");
      localReportHeader.uin = paramString.optLong("uin");
      localReportHeader.iNetType = paramString.optInt("iNetType");
      localReportHeader.result = paramString.optInt("result");
      localReportHeader.createTime = paramString.optLong("createTime");
      localReportHeader.serverTime = paramString.optLong("serverTime");
      return localReportHeader;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  private ReportItem a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = new String(Base64Util.decode(paramString.getBytes(), 0));
    try
    {
      paramString = new JSONObject(paramString);
      ReportItem localReportItem = new ReportItem();
      localReportItem.step = paramString.optString("step");
      localReportItem.createTime = paramString.optLong("createTime");
      localReportItem.params = paramString.optString("params");
      localReportItem.result = paramString.optInt("result");
      localReportItem.failReason = paramString.optString("failReason");
      return localReportItem;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  private String a(ReportHeader paramReportHeader)
  {
    if (paramReportHeader == null) {}
    do
    {
      return null;
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("platform", paramReportHeader.platform);
        localJSONObject.put("version", paramReportHeader.version);
        localJSONObject.put("uin", paramReportHeader.uin);
        localJSONObject.put("seqno", paramReportHeader.seqno);
        localJSONObject.put("sModule", paramReportHeader.sModule);
        localJSONObject.put("sAction", paramReportHeader.sAction);
        localJSONObject.put("iNetType", paramReportHeader.iNetType);
        localJSONObject.put("result", paramReportHeader.result);
        localJSONObject.put("createTime", paramReportHeader.createTime);
        localJSONObject.put("serverTime", paramReportHeader.serverTime);
        paramReportHeader = new String(Base64Util.encode(localJSONObject.toString().getBytes(), 0));
        return paramReportHeader;
      }
      catch (Exception paramReportHeader) {}
    } while (!QLog.isColorLevel());
    QLog.e("VACDReport", 2, "convertHeaderToString exception:  " + paramReportHeader.toString());
    return null;
  }
  
  private String a(ReportItem paramReportItem)
  {
    if (paramReportItem == null) {
      return null;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("step", paramReportItem.step);
      localJSONObject.put("createTime", paramReportItem.createTime);
      localJSONObject.put("params", paramReportItem.params);
      localJSONObject.put("result", paramReportItem.result);
      localJSONObject.put("failReason", paramReportItem.failReason);
      paramReportItem = new String(Base64Util.encode(localJSONObject.toString().getBytes(), 0));
      return paramReportItem;
    }
    catch (Exception paramReportItem) {}
    return null;
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" CREATE TABLE IF NOT EXISTS ").append("ReportRecord");
    localStringBuilder.append(" (");
    localStringBuilder.append("seqno").append(" INTEGER(16) NOT NULL, ");
    localStringBuilder.append("sendTime").append(" INTEGER(16) DEFAULT 0, PRIMARY KEY(");
    localStringBuilder.append("seqno").append("))");
    paramSQLiteDatabase.execSQL(localStringBuilder.toString());
  }
  
  /* Error */
  private void a(java.util.HashSet paramHashSet)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 217	android/os/SystemClock:uptimeMillis	()J
    //   5: lstore 5
    //   7: invokestatic 220	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   10: ifeq +29 -> 39
    //   13: ldc 13
    //   15: iconst_4
    //   16: new 181	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   23: ldc -34
    //   25: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: lload 5
    //   30: invokevirtual 225	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   33: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokestatic 193	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   39: aconst_null
    //   40: astore_2
    //   41: aload_0
    //   42: invokevirtual 229	ovb:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   45: astore_3
    //   46: aload_3
    //   47: astore_2
    //   48: aload_2
    //   49: invokevirtual 232	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   52: new 234	android/content/ContentValues
    //   55: dup
    //   56: invokespecial 235	android/content/ContentValues:<init>	()V
    //   59: astore_3
    //   60: aload_1
    //   61: invokevirtual 241	java/util/HashSet:iterator	()Ljava/util/Iterator;
    //   64: astore_1
    //   65: aload_1
    //   66: invokeinterface 246 1 0
    //   71: ifeq +71 -> 142
    //   74: aload_1
    //   75: invokeinterface 250 1 0
    //   80: checkcast 252	java/lang/Long
    //   83: astore 4
    //   85: aload_3
    //   86: invokevirtual 255	android/content/ContentValues:clear	()V
    //   89: aload_3
    //   90: ldc 39
    //   92: lload 5
    //   94: invokestatic 259	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   97: invokevirtual 262	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   100: aload_2
    //   101: ldc 42
    //   103: aload_3
    //   104: ldc_w 264
    //   107: iconst_1
    //   108: anewarray 65	java/lang/String
    //   111: dup
    //   112: iconst_0
    //   113: aload 4
    //   115: invokestatic 267	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   118: aastore
    //   119: invokevirtual 271	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   122: pop
    //   123: goto -58 -> 65
    //   126: astore_1
    //   127: aload_2
    //   128: ifnull +11 -> 139
    //   131: aload_2
    //   132: invokevirtual 274	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   135: aload_2
    //   136: invokevirtual 277	android/database/sqlite/SQLiteDatabase:close	()V
    //   139: aload_0
    //   140: monitorexit
    //   141: return
    //   142: aload_2
    //   143: invokevirtual 280	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   146: aload_2
    //   147: ifnull -8 -> 139
    //   150: aload_2
    //   151: invokevirtual 274	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   154: aload_2
    //   155: invokevirtual 277	android/database/sqlite/SQLiteDatabase:close	()V
    //   158: goto -19 -> 139
    //   161: astore_1
    //   162: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   165: ifeq -26 -> 139
    //   168: ldc 13
    //   170: iconst_2
    //   171: new 181	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   178: ldc_w 282
    //   181: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload_1
    //   185: invokevirtual 189	java/lang/Exception:toString	()Ljava/lang/String;
    //   188: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokestatic 193	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   197: goto -58 -> 139
    //   200: astore_1
    //   201: aload_0
    //   202: monitorexit
    //   203: aload_1
    //   204: athrow
    //   205: astore_1
    //   206: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   209: ifeq -70 -> 139
    //   212: ldc 13
    //   214: iconst_2
    //   215: new 181	java/lang/StringBuilder
    //   218: dup
    //   219: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   222: ldc_w 282
    //   225: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: aload_1
    //   229: invokevirtual 189	java/lang/Exception:toString	()Ljava/lang/String;
    //   232: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: invokestatic 193	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   241: goto -102 -> 139
    //   244: astore_1
    //   245: aconst_null
    //   246: astore_2
    //   247: aload_2
    //   248: ifnull +11 -> 259
    //   251: aload_2
    //   252: invokevirtual 274	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   255: aload_2
    //   256: invokevirtual 277	android/database/sqlite/SQLiteDatabase:close	()V
    //   259: aload_1
    //   260: athrow
    //   261: astore_2
    //   262: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   265: ifeq -6 -> 259
    //   268: ldc 13
    //   270: iconst_2
    //   271: new 181	java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   278: ldc_w 282
    //   281: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: aload_2
    //   285: invokevirtual 189	java/lang/Exception:toString	()Ljava/lang/String;
    //   288: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   294: invokestatic 193	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   297: goto -38 -> 259
    //   300: astore_1
    //   301: goto -54 -> 247
    //   304: astore_1
    //   305: goto -178 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	308	0	this	ovb
    //   0	308	1	paramHashSet	java.util.HashSet
    //   40	216	2	localObject1	Object
    //   261	24	2	localException	Exception
    //   45	59	3	localObject2	Object
    //   83	31	4	localLong	Long
    //   5	88	5	l	long
    // Exception table:
    //   from	to	target	type
    //   48	65	126	java/lang/Exception
    //   65	123	126	java/lang/Exception
    //   142	146	126	java/lang/Exception
    //   150	158	161	java/lang/Exception
    //   2	39	200	finally
    //   131	139	200	finally
    //   150	158	200	finally
    //   162	197	200	finally
    //   206	241	200	finally
    //   251	259	200	finally
    //   259	261	200	finally
    //   262	297	200	finally
    //   131	139	205	java/lang/Exception
    //   41	46	244	finally
    //   251	259	261	java/lang/Exception
    //   48	65	300	finally
    //   65	123	300	finally
    //   142	146	300	finally
    //   41	46	304	java/lang/Exception
  }
  
  private void b(SQLiteDatabase paramSQLiteDatabase)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" CREATE TABLE IF NOT EXISTS ").append("ReportItem");
    localStringBuilder.append(" (");
    localStringBuilder.append("seqno").append(" INTEGER(16) NOT NULL, ");
    localStringBuilder.append("createTime").append(" INTEGER(16) NOT NULL, ");
    localStringBuilder.append("skey").append(" VARCHAR(16), ");
    localStringBuilder.append("type").append(" INTEGER DEFAULT 0, ");
    localStringBuilder.append("content").append(" VARCHAR(255))");
    paramSQLiteDatabase.execSQL(localStringBuilder.toString());
  }
  
  /* Error */
  public java.util.Map a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 294	java/lang/System:currentTimeMillis	()J
    //   5: lstore 21
    //   7: new 296	java/util/HashMap
    //   10: dup
    //   11: bipush 10
    //   13: invokespecial 299	java/util/HashMap:<init>	(I)V
    //   16: astore 6
    //   18: new 237	java/util/HashSet
    //   21: dup
    //   22: bipush 10
    //   24: invokespecial 300	java/util/HashSet:<init>	(I)V
    //   27: astore 7
    //   29: aconst_null
    //   30: astore_3
    //   31: aconst_null
    //   32: astore_2
    //   33: aconst_null
    //   34: astore_1
    //   35: aload_0
    //   36: invokevirtual 303	ovb:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   39: astore 4
    //   41: aload 4
    //   43: astore_1
    //   44: aload_2
    //   45: astore_3
    //   46: aload_1
    //   47: ldc_w 305
    //   50: iconst_1
    //   51: anewarray 65	java/lang/String
    //   54: dup
    //   55: iconst_0
    //   56: invokestatic 217	android/os/SystemClock:uptimeMillis	()J
    //   59: ldc2_w 9
    //   62: lsub
    //   63: invokestatic 308	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   66: aastore
    //   67: invokevirtual 312	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   70: astore_2
    //   71: aload_2
    //   72: ifnull +390 -> 462
    //   75: aload_2
    //   76: astore_3
    //   77: aload_2
    //   78: invokeinterface 318 1 0
    //   83: ifle +379 -> 462
    //   86: aload_2
    //   87: astore_3
    //   88: aload_2
    //   89: ldc 27
    //   91: invokeinterface 321 2 0
    //   96: istore 10
    //   98: aload_2
    //   99: astore_3
    //   100: aload_2
    //   101: ldc 30
    //   103: invokeinterface 321 2 0
    //   108: istore 11
    //   110: aload_2
    //   111: astore_3
    //   112: aload_2
    //   113: ldc 33
    //   115: invokeinterface 321 2 0
    //   120: istore 12
    //   122: aload_2
    //   123: astore_3
    //   124: aload_2
    //   125: ldc 36
    //   127: invokeinterface 321 2 0
    //   132: istore 13
    //   134: lconst_0
    //   135: lstore 15
    //   137: aload_2
    //   138: astore_3
    //   139: new 323	java/util/ArrayList
    //   142: dup
    //   143: iconst_1
    //   144: invokespecial 324	java/util/ArrayList:<init>	(I)V
    //   147: astore 8
    //   149: aload_2
    //   150: astore_3
    //   151: aload_2
    //   152: invokeinterface 327 1 0
    //   157: pop
    //   158: aload_2
    //   159: astore_3
    //   160: aload_2
    //   161: invokeinterface 330 1 0
    //   166: ifne +276 -> 442
    //   169: aload_2
    //   170: astore_3
    //   171: aload_2
    //   172: iload 10
    //   174: invokeinterface 334 2 0
    //   179: lstore 19
    //   181: lload 15
    //   183: lstore 17
    //   185: lload 15
    //   187: lload 19
    //   189: lcmp
    //   190: ifeq +240 -> 430
    //   193: aload_2
    //   194: astore_3
    //   195: aload 6
    //   197: lload 15
    //   199: invokestatic 259	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   202: invokeinterface 340 2 0
    //   207: ifeq +1367 -> 1574
    //   210: aload_2
    //   211: astore_3
    //   212: aload 6
    //   214: lload 15
    //   216: invokestatic 259	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   219: invokeinterface 344 2 0
    //   224: checkcast 346	VACDReport/ReportInfo
    //   227: astore 4
    //   229: aload_2
    //   230: astore_3
    //   231: aload 4
    //   233: getfield 350	VACDReport/ReportInfo:body	LVACDReport/ReportBody;
    //   236: aload 4
    //   238: getfield 354	VACDReport/ReportInfo:header	LVACDReport/ReportHeader;
    //   241: getfield 357	VACDReport/ReportHeader:sKey	Ljava/lang/String;
    //   244: putfield 360	VACDReport/ReportBody:sKey	Ljava/lang/String;
    //   247: aload_2
    //   248: astore_3
    //   249: aload 4
    //   251: getfield 350	VACDReport/ReportInfo:body	LVACDReport/ReportBody;
    //   254: aload 4
    //   256: getfield 354	VACDReport/ReportInfo:header	LVACDReport/ReportHeader;
    //   259: getfield 136	VACDReport/ReportHeader:serverTime	J
    //   262: putfield 363	VACDReport/ReportBody:startTime	J
    //   265: aload_2
    //   266: astore_3
    //   267: aload 4
    //   269: getfield 350	VACDReport/ReportInfo:body	LVACDReport/ReportBody;
    //   272: getfield 367	VACDReport/ReportBody:reportItems	Ljava/util/ArrayList;
    //   275: aload 4
    //   277: getfield 350	VACDReport/ReportInfo:body	LVACDReport/ReportBody;
    //   280: getfield 367	VACDReport/ReportBody:reportItems	Ljava/util/ArrayList;
    //   283: invokevirtual 370	java/util/ArrayList:size	()I
    //   286: iconst_1
    //   287: isub
    //   288: invokevirtual 373	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   291: checkcast 139	VACDReport/ReportItem
    //   294: astore 5
    //   296: aload_2
    //   297: astore_3
    //   298: aload 4
    //   300: getfield 350	VACDReport/ReportInfo:body	LVACDReport/ReportBody;
    //   303: aload 5
    //   305: getfield 145	VACDReport/ReportItem:createTime	J
    //   308: aload 4
    //   310: getfield 354	VACDReport/ReportInfo:header	LVACDReport/ReportHeader;
    //   313: getfield 132	VACDReport/ReportHeader:createTime	J
    //   316: lsub
    //   317: putfield 376	VACDReport/ReportBody:totalTime	J
    //   320: aload_2
    //   321: astore_3
    //   322: aload 5
    //   324: getfield 150	VACDReport/ReportItem:result	I
    //   327: ldc_w 377
    //   330: if_icmpne +28 -> 358
    //   333: aload_2
    //   334: astore_3
    //   335: aload 4
    //   337: getfield 350	VACDReport/ReportInfo:body	LVACDReport/ReportBody;
    //   340: astore 9
    //   342: aload_2
    //   343: astore_3
    //   344: aload 9
    //   346: aload 9
    //   348: getfield 376	VACDReport/ReportBody:totalTime	J
    //   351: ldc2_w 378
    //   354: lsub
    //   355: putfield 376	VACDReport/ReportBody:totalTime	J
    //   358: aload_2
    //   359: astore_3
    //   360: aload 4
    //   362: getfield 354	VACDReport/ReportInfo:header	LVACDReport/ReportHeader;
    //   365: aload 5
    //   367: getfield 150	VACDReport/ReportItem:result	I
    //   370: putfield 130	VACDReport/ReportHeader:result	I
    //   373: aload_2
    //   374: astore_3
    //   375: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   378: ifeq +1196 -> 1574
    //   381: aload_2
    //   382: astore_3
    //   383: ldc 13
    //   385: iconst_2
    //   386: new 181	java/lang/StringBuilder
    //   389: dup
    //   390: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   393: ldc_w 381
    //   396: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: lload 15
    //   401: invokevirtual 225	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   404: ldc_w 383
    //   407: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: aload 4
    //   412: getfield 350	VACDReport/ReportInfo:body	LVACDReport/ReportBody;
    //   415: invokevirtual 384	VACDReport/ReportBody:toString	()Ljava/lang/String;
    //   418: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   424: invokestatic 386	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   427: goto +1147 -> 1574
    //   430: aload_2
    //   431: astore_3
    //   432: aload 7
    //   434: invokevirtual 387	java/util/HashSet:size	()I
    //   437: bipush 10
    //   439: if_icmple +113 -> 552
    //   442: aload_2
    //   443: astore_3
    //   444: aload 8
    //   446: invokeinterface 391 1 0
    //   451: ifne +11 -> 462
    //   454: aload_2
    //   455: astore_3
    //   456: aload_0
    //   457: aload 8
    //   459: invokevirtual 394	ovb:a	(Ljava/util/List;)V
    //   462: aload_1
    //   463: ifnull +7 -> 470
    //   466: aload_1
    //   467: invokevirtual 277	android/database/sqlite/SQLiteDatabase:close	()V
    //   470: aload_2
    //   471: ifnull +9 -> 480
    //   474: aload_2
    //   475: invokeinterface 395 1 0
    //   480: invokestatic 220	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   483: ifeq +50 -> 533
    //   486: ldc 13
    //   488: iconst_4
    //   489: new 181	java/lang/StringBuilder
    //   492: dup
    //   493: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   496: ldc_w 397
    //   499: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: invokestatic 294	java/lang/System:currentTimeMillis	()J
    //   505: lload 21
    //   507: lsub
    //   508: invokevirtual 225	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   511: ldc_w 399
    //   514: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: aload 6
    //   519: invokeinterface 400 1 0
    //   524: invokevirtual 403	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   527: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   530: invokestatic 386	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   533: aload 7
    //   535: invokevirtual 404	java/util/HashSet:isEmpty	()Z
    //   538: ifne +9 -> 547
    //   541: aload_0
    //   542: aload 7
    //   544: invokespecial 406	ovb:a	(Ljava/util/HashSet;)V
    //   547: aload_0
    //   548: monitorexit
    //   549: aload 6
    //   551: areturn
    //   552: aload_2
    //   553: astore_3
    //   554: aload_2
    //   555: iload 12
    //   557: invokeinterface 410 2 0
    //   562: istore 14
    //   564: aload_2
    //   565: astore_3
    //   566: aload_2
    //   567: iload 11
    //   569: invokeinterface 414 2 0
    //   574: astore 9
    //   576: aload_2
    //   577: astore_3
    //   578: aload 6
    //   580: lload 19
    //   582: invokestatic 259	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   585: invokeinterface 344 2 0
    //   590: checkcast 346	VACDReport/ReportInfo
    //   593: astore 5
    //   595: iconst_1
    //   596: iload 14
    //   598: if_icmpne +547 -> 1145
    //   601: aload_2
    //   602: astore_3
    //   603: aload_0
    //   604: aload 9
    //   606: invokespecial 416	ovb:a	(Ljava/lang/String;)LVACDReport/ReportHeader;
    //   609: astore 9
    //   611: aload 9
    //   613: ifnonnull +157 -> 770
    //   616: aload_2
    //   617: astore_3
    //   618: invokestatic 220	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   621: ifeq +32 -> 653
    //   624: aload_2
    //   625: astore_3
    //   626: ldc 13
    //   628: iconst_4
    //   629: new 181	java/lang/StringBuilder
    //   632: dup
    //   633: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   636: ldc_w 418
    //   639: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   642: lload 19
    //   644: invokevirtual 225	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   647: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   650: invokestatic 193	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   653: aload_2
    //   654: astore_3
    //   655: aload_2
    //   656: invokeinterface 421 1 0
    //   661: pop
    //   662: lload 17
    //   664: lstore 15
    //   666: goto -508 -> 158
    //   669: astore_3
    //   670: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   673: ifeq +32 -> 705
    //   676: ldc 13
    //   678: iconst_2
    //   679: new 181	java/lang/StringBuilder
    //   682: dup
    //   683: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   686: ldc_w 423
    //   689: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: aload_3
    //   693: invokevirtual 189	java/lang/Exception:toString	()Ljava/lang/String;
    //   696: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   699: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   702: invokestatic 193	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   705: aload_1
    //   706: ifnull +7 -> 713
    //   709: aload_1
    //   710: invokevirtual 277	android/database/sqlite/SQLiteDatabase:close	()V
    //   713: aload_2
    //   714: ifnull -234 -> 480
    //   717: aload_2
    //   718: invokeinterface 395 1 0
    //   723: goto -243 -> 480
    //   726: astore_1
    //   727: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   730: ifeq -250 -> 480
    //   733: ldc 13
    //   735: iconst_2
    //   736: new 181	java/lang/StringBuilder
    //   739: dup
    //   740: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   743: ldc_w 425
    //   746: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   749: aload_1
    //   750: invokevirtual 189	java/lang/Exception:toString	()Ljava/lang/String;
    //   753: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   756: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   759: invokestatic 193	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   762: goto -282 -> 480
    //   765: astore_1
    //   766: aload_0
    //   767: monitorexit
    //   768: aload_1
    //   769: athrow
    //   770: aload 5
    //   772: astore 4
    //   774: aload 5
    //   776: ifnonnull +44 -> 820
    //   779: aload_2
    //   780: astore_3
    //   781: new 346	VACDReport/ReportInfo
    //   784: dup
    //   785: invokespecial 426	VACDReport/ReportInfo:<init>	()V
    //   788: astore 4
    //   790: aload_2
    //   791: astore_3
    //   792: aload 6
    //   794: lload 19
    //   796: invokestatic 259	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   799: aload 4
    //   801: invokeinterface 429 3 0
    //   806: pop
    //   807: aload_2
    //   808: astore_3
    //   809: aload 7
    //   811: lload 19
    //   813: invokestatic 259	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   816: invokevirtual 432	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   819: pop
    //   820: aload_2
    //   821: astore_3
    //   822: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   825: ifeq +35 -> 860
    //   828: aload_2
    //   829: astore_3
    //   830: ldc 13
    //   832: iconst_2
    //   833: new 181	java/lang/StringBuilder
    //   836: dup
    //   837: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   840: ldc_w 434
    //   843: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   846: aload 9
    //   848: invokevirtual 435	VACDReport/ReportHeader:toString	()Ljava/lang/String;
    //   851: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   854: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   857: invokestatic 386	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   860: aload_2
    //   861: astore_3
    //   862: aload 4
    //   864: aload 9
    //   866: putfield 354	VACDReport/ReportInfo:header	LVACDReport/ReportHeader;
    //   869: aload_2
    //   870: astore_3
    //   871: aload 4
    //   873: getfield 354	VACDReport/ReportInfo:header	LVACDReport/ReportHeader;
    //   876: aload_2
    //   877: iload 13
    //   879: invokeinterface 414 2 0
    //   884: putfield 357	VACDReport/ReportHeader:sKey	Ljava/lang/String;
    //   887: aload_2
    //   888: astore_3
    //   889: aload_2
    //   890: invokeinterface 438 1 0
    //   895: ifeq -242 -> 653
    //   898: aload_2
    //   899: astore_3
    //   900: aload 6
    //   902: lload 17
    //   904: invokestatic 259	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   907: invokeinterface 344 2 0
    //   912: checkcast 346	VACDReport/ReportInfo
    //   915: astore 4
    //   917: aload_2
    //   918: astore_3
    //   919: aload 4
    //   921: getfield 350	VACDReport/ReportInfo:body	LVACDReport/ReportBody;
    //   924: aload 4
    //   926: getfield 354	VACDReport/ReportInfo:header	LVACDReport/ReportHeader;
    //   929: getfield 357	VACDReport/ReportHeader:sKey	Ljava/lang/String;
    //   932: putfield 360	VACDReport/ReportBody:sKey	Ljava/lang/String;
    //   935: aload_2
    //   936: astore_3
    //   937: aload 4
    //   939: getfield 350	VACDReport/ReportInfo:body	LVACDReport/ReportBody;
    //   942: aload 4
    //   944: getfield 354	VACDReport/ReportInfo:header	LVACDReport/ReportHeader;
    //   947: getfield 136	VACDReport/ReportHeader:serverTime	J
    //   950: putfield 363	VACDReport/ReportBody:startTime	J
    //   953: aload_2
    //   954: astore_3
    //   955: aload 4
    //   957: getfield 350	VACDReport/ReportInfo:body	LVACDReport/ReportBody;
    //   960: getfield 367	VACDReport/ReportBody:reportItems	Ljava/util/ArrayList;
    //   963: aload 4
    //   965: getfield 350	VACDReport/ReportInfo:body	LVACDReport/ReportBody;
    //   968: getfield 367	VACDReport/ReportBody:reportItems	Ljava/util/ArrayList;
    //   971: invokevirtual 370	java/util/ArrayList:size	()I
    //   974: iconst_1
    //   975: isub
    //   976: invokevirtual 373	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   979: checkcast 139	VACDReport/ReportItem
    //   982: astore 5
    //   984: aload_2
    //   985: astore_3
    //   986: aload 4
    //   988: getfield 350	VACDReport/ReportInfo:body	LVACDReport/ReportBody;
    //   991: aload 5
    //   993: getfield 145	VACDReport/ReportItem:createTime	J
    //   996: aload 4
    //   998: getfield 354	VACDReport/ReportInfo:header	LVACDReport/ReportHeader;
    //   1001: getfield 132	VACDReport/ReportHeader:createTime	J
    //   1004: lsub
    //   1005: putfield 376	VACDReport/ReportBody:totalTime	J
    //   1008: aload_2
    //   1009: astore_3
    //   1010: aload 5
    //   1012: getfield 150	VACDReport/ReportItem:result	I
    //   1015: ldc_w 377
    //   1018: if_icmpne +28 -> 1046
    //   1021: aload_2
    //   1022: astore_3
    //   1023: aload 4
    //   1025: getfield 350	VACDReport/ReportInfo:body	LVACDReport/ReportBody;
    //   1028: astore 9
    //   1030: aload_2
    //   1031: astore_3
    //   1032: aload 9
    //   1034: aload 9
    //   1036: getfield 376	VACDReport/ReportBody:totalTime	J
    //   1039: ldc2_w 378
    //   1042: lsub
    //   1043: putfield 376	VACDReport/ReportBody:totalTime	J
    //   1046: aload_2
    //   1047: astore_3
    //   1048: aload 4
    //   1050: getfield 354	VACDReport/ReportInfo:header	LVACDReport/ReportHeader;
    //   1053: aload 5
    //   1055: getfield 150	VACDReport/ReportItem:result	I
    //   1058: putfield 130	VACDReport/ReportHeader:result	I
    //   1061: aload_2
    //   1062: astore_3
    //   1063: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1066: ifeq -413 -> 653
    //   1069: aload_2
    //   1070: astore_3
    //   1071: ldc 13
    //   1073: iconst_2
    //   1074: new 181	java/lang/StringBuilder
    //   1077: dup
    //   1078: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   1081: ldc_w 381
    //   1084: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1087: lload 17
    //   1089: invokevirtual 225	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1092: ldc_w 383
    //   1095: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1098: aload 4
    //   1100: getfield 350	VACDReport/ReportInfo:body	LVACDReport/ReportBody;
    //   1103: invokevirtual 384	VACDReport/ReportBody:toString	()Ljava/lang/String;
    //   1106: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1109: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1112: invokestatic 386	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1115: goto -462 -> 653
    //   1118: astore 4
    //   1120: aload_1
    //   1121: astore_2
    //   1122: aload 4
    //   1124: astore_1
    //   1125: aload_2
    //   1126: ifnull +7 -> 1133
    //   1129: aload_2
    //   1130: invokevirtual 277	android/database/sqlite/SQLiteDatabase:close	()V
    //   1133: aload_3
    //   1134: ifnull +9 -> 1143
    //   1137: aload_3
    //   1138: invokeinterface 395 1 0
    //   1143: aload_1
    //   1144: athrow
    //   1145: iload 14
    //   1147: ifne -260 -> 887
    //   1150: aload 5
    //   1152: ifnonnull +75 -> 1227
    //   1155: aload_2
    //   1156: astore_3
    //   1157: invokestatic 220	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1160: ifeq +32 -> 1192
    //   1163: aload_2
    //   1164: astore_3
    //   1165: ldc 13
    //   1167: iconst_4
    //   1168: new 181	java/lang/StringBuilder
    //   1171: dup
    //   1172: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   1175: ldc_w 440
    //   1178: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1181: lload 19
    //   1183: invokevirtual 225	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1186: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1189: invokestatic 193	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1192: aload_2
    //   1193: astore_3
    //   1194: aload 8
    //   1196: lload 19
    //   1198: invokestatic 259	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1201: invokeinterface 443 2 0
    //   1206: ifne -553 -> 653
    //   1209: aload_2
    //   1210: astore_3
    //   1211: aload 8
    //   1213: lload 19
    //   1215: invokestatic 259	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1218: invokeinterface 444 2 0
    //   1223: pop
    //   1224: goto -571 -> 653
    //   1227: aload_2
    //   1228: astore_3
    //   1229: aload 5
    //   1231: getfield 350	VACDReport/ReportInfo:body	LVACDReport/ReportBody;
    //   1234: ifnonnull +36 -> 1270
    //   1237: aload_2
    //   1238: astore_3
    //   1239: aload 5
    //   1241: new 359	VACDReport/ReportBody
    //   1244: dup
    //   1245: invokespecial 445	VACDReport/ReportBody:<init>	()V
    //   1248: putfield 350	VACDReport/ReportInfo:body	LVACDReport/ReportBody;
    //   1251: aload_2
    //   1252: astore_3
    //   1253: aload 5
    //   1255: getfield 350	VACDReport/ReportInfo:body	LVACDReport/ReportBody;
    //   1258: new 323	java/util/ArrayList
    //   1261: dup
    //   1262: bipush 32
    //   1264: invokespecial 324	java/util/ArrayList:<init>	(I)V
    //   1267: putfield 367	VACDReport/ReportBody:reportItems	Ljava/util/ArrayList;
    //   1270: aload_2
    //   1271: astore_3
    //   1272: aload_0
    //   1273: aload 9
    //   1275: invokespecial 447	ovb:a	(Ljava/lang/String;)LVACDReport/ReportItem;
    //   1278: astore 4
    //   1280: aload 4
    //   1282: ifnonnull +43 -> 1325
    //   1285: aload_2
    //   1286: astore_3
    //   1287: invokestatic 220	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1290: ifeq -637 -> 653
    //   1293: aload_2
    //   1294: astore_3
    //   1295: ldc 13
    //   1297: iconst_4
    //   1298: new 181	java/lang/StringBuilder
    //   1301: dup
    //   1302: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   1305: ldc_w 449
    //   1308: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1311: aload 9
    //   1313: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1316: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1319: invokestatic 193	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1322: goto -669 -> 653
    //   1325: aload_2
    //   1326: astore_3
    //   1327: aload 5
    //   1329: getfield 350	VACDReport/ReportInfo:body	LVACDReport/ReportBody;
    //   1332: getfield 367	VACDReport/ReportBody:reportItems	Ljava/util/ArrayList;
    //   1335: invokevirtual 370	java/util/ArrayList:size	()I
    //   1338: istore 14
    //   1340: iload 14
    //   1342: ifle +113 -> 1455
    //   1345: aload_2
    //   1346: astore_3
    //   1347: aload 5
    //   1349: getfield 350	VACDReport/ReportInfo:body	LVACDReport/ReportBody;
    //   1352: getfield 367	VACDReport/ReportBody:reportItems	Ljava/util/ArrayList;
    //   1355: iload 14
    //   1357: iconst_1
    //   1358: isub
    //   1359: invokevirtual 373	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1362: checkcast 139	VACDReport/ReportItem
    //   1365: astore 9
    //   1367: aload_2
    //   1368: astore_3
    //   1369: aload 4
    //   1371: aload 4
    //   1373: getfield 145	VACDReport/ReportItem:createTime	J
    //   1376: aload 9
    //   1378: getfield 145	VACDReport/ReportItem:createTime	J
    //   1381: lsub
    //   1382: putfield 452	VACDReport/ReportItem:costTime	J
    //   1385: aload_2
    //   1386: astore_3
    //   1387: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1390: ifeq +46 -> 1436
    //   1393: aload_2
    //   1394: astore_3
    //   1395: ldc 13
    //   1397: iconst_2
    //   1398: new 181	java/lang/StringBuilder
    //   1401: dup
    //   1402: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   1405: ldc_w 381
    //   1408: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1411: lload 19
    //   1413: invokevirtual 225	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1416: ldc_w 454
    //   1419: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1422: aload 4
    //   1424: invokevirtual 455	VACDReport/ReportItem:toString	()Ljava/lang/String;
    //   1427: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1430: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1433: invokestatic 386	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1436: aload_2
    //   1437: astore_3
    //   1438: aload 5
    //   1440: getfield 350	VACDReport/ReportInfo:body	LVACDReport/ReportBody;
    //   1443: getfield 367	VACDReport/ReportBody:reportItems	Ljava/util/ArrayList;
    //   1446: aload 4
    //   1448: invokevirtual 456	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1451: pop
    //   1452: goto -565 -> 887
    //   1455: aload_2
    //   1456: astore_3
    //   1457: aload 4
    //   1459: lconst_0
    //   1460: putfield 452	VACDReport/ReportItem:costTime	J
    //   1463: goto -78 -> 1385
    //   1466: astore_1
    //   1467: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1470: ifeq -990 -> 480
    //   1473: ldc 13
    //   1475: iconst_2
    //   1476: new 181	java/lang/StringBuilder
    //   1479: dup
    //   1480: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   1483: ldc_w 425
    //   1486: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1489: aload_1
    //   1490: invokevirtual 189	java/lang/Exception:toString	()Ljava/lang/String;
    //   1493: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1496: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1499: invokestatic 193	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1502: goto -1022 -> 480
    //   1505: astore_2
    //   1506: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1509: ifeq -366 -> 1143
    //   1512: ldc 13
    //   1514: iconst_2
    //   1515: new 181	java/lang/StringBuilder
    //   1518: dup
    //   1519: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   1522: ldc_w 425
    //   1525: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1528: aload_2
    //   1529: invokevirtual 189	java/lang/Exception:toString	()Ljava/lang/String;
    //   1532: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1535: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1538: invokestatic 193	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1541: goto -398 -> 1143
    //   1544: astore_1
    //   1545: aconst_null
    //   1546: astore_2
    //   1547: goto -422 -> 1125
    //   1550: astore 4
    //   1552: aload_2
    //   1553: astore_3
    //   1554: aload_1
    //   1555: astore_2
    //   1556: aload 4
    //   1558: astore_1
    //   1559: goto -434 -> 1125
    //   1562: astore_3
    //   1563: aconst_null
    //   1564: astore_2
    //   1565: goto -895 -> 670
    //   1568: astore_3
    //   1569: aconst_null
    //   1570: astore_2
    //   1571: goto -901 -> 670
    //   1574: lload 19
    //   1576: lstore 17
    //   1578: goto -1148 -> 430
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1581	0	this	ovb
    //   34	676	1	localObject1	Object
    //   726	24	1	localException1	Exception
    //   765	356	1	localObject2	Object
    //   1124	20	1	localObject3	Object
    //   1466	24	1	localException2	Exception
    //   1544	11	1	localObject4	Object
    //   1558	1	1	localObject5	Object
    //   32	1424	2	localObject6	Object
    //   1505	24	2	localException3	Exception
    //   1546	25	2	localObject7	Object
    //   30	625	3	localObject8	Object
    //   669	24	3	localException4	Exception
    //   780	774	3	localObject9	Object
    //   1562	1	3	localException5	Exception
    //   1568	1	3	localException6	Exception
    //   39	1060	4	localObject10	Object
    //   1118	5	4	localObject11	Object
    //   1278	180	4	localReportItem	ReportItem
    //   1550	7	4	localObject12	Object
    //   294	1145	5	localObject13	Object
    //   16	885	6	localHashMap	java.util.HashMap
    //   27	783	7	localHashSet	java.util.HashSet
    //   147	1065	8	localArrayList	java.util.ArrayList
    //   340	1037	9	localObject14	Object
    //   96	77	10	k	int
    //   108	460	11	m	int
    //   120	436	12	n	int
    //   132	746	13	i1	int
    //   562	797	14	i2	int
    //   135	530	15	l1	long
    //   183	1394	17	l2	long
    //   179	1396	19	l3	long
    //   5	501	21	l4	long
    // Exception table:
    //   from	to	target	type
    //   77	86	669	java/lang/Exception
    //   88	98	669	java/lang/Exception
    //   100	110	669	java/lang/Exception
    //   112	122	669	java/lang/Exception
    //   124	134	669	java/lang/Exception
    //   139	149	669	java/lang/Exception
    //   151	158	669	java/lang/Exception
    //   160	169	669	java/lang/Exception
    //   171	181	669	java/lang/Exception
    //   195	210	669	java/lang/Exception
    //   212	229	669	java/lang/Exception
    //   231	247	669	java/lang/Exception
    //   249	265	669	java/lang/Exception
    //   267	296	669	java/lang/Exception
    //   298	320	669	java/lang/Exception
    //   322	333	669	java/lang/Exception
    //   335	342	669	java/lang/Exception
    //   344	358	669	java/lang/Exception
    //   360	373	669	java/lang/Exception
    //   375	381	669	java/lang/Exception
    //   383	427	669	java/lang/Exception
    //   432	442	669	java/lang/Exception
    //   444	454	669	java/lang/Exception
    //   456	462	669	java/lang/Exception
    //   554	564	669	java/lang/Exception
    //   566	576	669	java/lang/Exception
    //   578	595	669	java/lang/Exception
    //   603	611	669	java/lang/Exception
    //   618	624	669	java/lang/Exception
    //   626	653	669	java/lang/Exception
    //   655	662	669	java/lang/Exception
    //   781	790	669	java/lang/Exception
    //   792	807	669	java/lang/Exception
    //   809	820	669	java/lang/Exception
    //   822	828	669	java/lang/Exception
    //   830	860	669	java/lang/Exception
    //   862	869	669	java/lang/Exception
    //   871	887	669	java/lang/Exception
    //   889	898	669	java/lang/Exception
    //   900	917	669	java/lang/Exception
    //   919	935	669	java/lang/Exception
    //   937	953	669	java/lang/Exception
    //   955	984	669	java/lang/Exception
    //   986	1008	669	java/lang/Exception
    //   1010	1021	669	java/lang/Exception
    //   1023	1030	669	java/lang/Exception
    //   1032	1046	669	java/lang/Exception
    //   1048	1061	669	java/lang/Exception
    //   1063	1069	669	java/lang/Exception
    //   1071	1115	669	java/lang/Exception
    //   1157	1163	669	java/lang/Exception
    //   1165	1192	669	java/lang/Exception
    //   1194	1209	669	java/lang/Exception
    //   1211	1224	669	java/lang/Exception
    //   1229	1237	669	java/lang/Exception
    //   1239	1251	669	java/lang/Exception
    //   1253	1270	669	java/lang/Exception
    //   1272	1280	669	java/lang/Exception
    //   1287	1293	669	java/lang/Exception
    //   1295	1322	669	java/lang/Exception
    //   1327	1340	669	java/lang/Exception
    //   1347	1367	669	java/lang/Exception
    //   1369	1385	669	java/lang/Exception
    //   1387	1393	669	java/lang/Exception
    //   1395	1436	669	java/lang/Exception
    //   1438	1452	669	java/lang/Exception
    //   1457	1463	669	java/lang/Exception
    //   709	713	726	java/lang/Exception
    //   717	723	726	java/lang/Exception
    //   2	29	765	finally
    //   466	470	765	finally
    //   474	480	765	finally
    //   480	533	765	finally
    //   533	547	765	finally
    //   709	713	765	finally
    //   717	723	765	finally
    //   727	762	765	finally
    //   1129	1133	765	finally
    //   1137	1143	765	finally
    //   1143	1145	765	finally
    //   1467	1502	765	finally
    //   1506	1541	765	finally
    //   46	71	1118	finally
    //   77	86	1118	finally
    //   88	98	1118	finally
    //   100	110	1118	finally
    //   112	122	1118	finally
    //   124	134	1118	finally
    //   139	149	1118	finally
    //   151	158	1118	finally
    //   160	169	1118	finally
    //   171	181	1118	finally
    //   195	210	1118	finally
    //   212	229	1118	finally
    //   231	247	1118	finally
    //   249	265	1118	finally
    //   267	296	1118	finally
    //   298	320	1118	finally
    //   322	333	1118	finally
    //   335	342	1118	finally
    //   344	358	1118	finally
    //   360	373	1118	finally
    //   375	381	1118	finally
    //   383	427	1118	finally
    //   432	442	1118	finally
    //   444	454	1118	finally
    //   456	462	1118	finally
    //   554	564	1118	finally
    //   566	576	1118	finally
    //   578	595	1118	finally
    //   603	611	1118	finally
    //   618	624	1118	finally
    //   626	653	1118	finally
    //   655	662	1118	finally
    //   781	790	1118	finally
    //   792	807	1118	finally
    //   809	820	1118	finally
    //   822	828	1118	finally
    //   830	860	1118	finally
    //   862	869	1118	finally
    //   871	887	1118	finally
    //   889	898	1118	finally
    //   900	917	1118	finally
    //   919	935	1118	finally
    //   937	953	1118	finally
    //   955	984	1118	finally
    //   986	1008	1118	finally
    //   1010	1021	1118	finally
    //   1023	1030	1118	finally
    //   1032	1046	1118	finally
    //   1048	1061	1118	finally
    //   1063	1069	1118	finally
    //   1071	1115	1118	finally
    //   1157	1163	1118	finally
    //   1165	1192	1118	finally
    //   1194	1209	1118	finally
    //   1211	1224	1118	finally
    //   1229	1237	1118	finally
    //   1239	1251	1118	finally
    //   1253	1270	1118	finally
    //   1272	1280	1118	finally
    //   1287	1293	1118	finally
    //   1295	1322	1118	finally
    //   1327	1340	1118	finally
    //   1347	1367	1118	finally
    //   1369	1385	1118	finally
    //   1387	1393	1118	finally
    //   1395	1436	1118	finally
    //   1438	1452	1118	finally
    //   1457	1463	1118	finally
    //   466	470	1466	java/lang/Exception
    //   474	480	1466	java/lang/Exception
    //   1129	1133	1505	java/lang/Exception
    //   1137	1143	1505	java/lang/Exception
    //   35	41	1544	finally
    //   670	705	1550	finally
    //   35	41	1562	java/lang/Exception
    //   46	71	1568	java/lang/Exception
  }
  
  public void a(long paramLong)
  {
    Object localObject4 = null;
    Object localObject1 = null;
    if (paramLong <= 0L) {}
    for (;;)
    {
      return;
      try
      {
        SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
        localObject1 = localSQLiteDatabase;
        localObject4 = localSQLiteDatabase;
        ContentValues localContentValues = new ContentValues();
        localObject1 = localSQLiteDatabase;
        localObject4 = localSQLiteDatabase;
        localContentValues.put("seqno", Long.valueOf(paramLong));
        localObject1 = localSQLiteDatabase;
        localObject4 = localSQLiteDatabase;
        localSQLiteDatabase.insertOrThrow("ReportRecord", null, localContentValues);
        if (localSQLiteDatabase == null) {
          continue;
        }
        try
        {
          localSQLiteDatabase.close();
        }
        finally {}
      }
      catch (Exception localException)
      {
        localObject4 = localObject2;
        if (QLog.isColorLevel())
        {
          localObject4 = localObject2;
          QLog.e("VACDReport", 2, "saveReportRecord exception:  " + localException.toString());
        }
        if (localObject2 == null) {
          continue;
        }
        ((SQLiteDatabase)localObject2).close();
      }
      finally
      {
        if (localObject4 != null) {
          ((SQLiteDatabase)localObject4).close();
        }
      }
    }
  }
  
  public void a(long paramLong, ReportItem paramReportItem)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramReportItem == null) {}
    for (;;)
    {
      return;
      try
      {
        SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        ContentValues localContentValues = new ContentValues();
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("seqno", Long.valueOf(paramLong));
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("content", a(paramReportItem));
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("createTime", Long.valueOf(paramReportItem.createTime));
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("type", Integer.valueOf(0));
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localSQLiteDatabase.insertOrThrow("ReportItem", null, localContentValues);
        if (localSQLiteDatabase == null) {
          continue;
        }
        try
        {
          localSQLiteDatabase.close();
        }
        finally {}
      }
      catch (Exception paramReportItem)
      {
        localObject2 = localObject1;
        if (QLog.isColorLevel())
        {
          localObject2 = localObject1;
          QLog.e("VACDReport", 2, "saveReportItem exception:  " + paramReportItem.toString());
        }
        if (localObject1 == null) {
          continue;
        }
        ((SQLiteDatabase)localObject1).close();
      }
      finally
      {
        if (localObject2 != null) {
          ((SQLiteDatabase)localObject2).close();
        }
      }
    }
  }
  
  /* Error */
  public void a(long paramLong, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_3
    //   3: invokestatic 63	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: istore 8
    //   8: iload 8
    //   10: ifeq +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aconst_null
    //   17: astore 5
    //   19: aconst_null
    //   20: astore 4
    //   22: aload_0
    //   23: invokevirtual 229	ovb:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   26: astore 6
    //   28: aload 6
    //   30: astore 4
    //   32: aload 6
    //   34: astore 5
    //   36: new 234	android/content/ContentValues
    //   39: dup
    //   40: invokespecial 235	android/content/ContentValues:<init>	()V
    //   43: astore 7
    //   45: aload 6
    //   47: astore 4
    //   49: aload 6
    //   51: astore 5
    //   53: aload 7
    //   55: ldc 36
    //   57: aload_3
    //   58: invokevirtual 469	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: aload 6
    //   63: astore 4
    //   65: aload 6
    //   67: astore 5
    //   69: aload 6
    //   71: ldc 21
    //   73: aload 7
    //   75: ldc_w 482
    //   78: iconst_2
    //   79: anewarray 65	java/lang/String
    //   82: dup
    //   83: iconst_0
    //   84: lload_1
    //   85: invokestatic 308	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   88: aastore
    //   89: dup
    //   90: iconst_1
    //   91: iconst_1
    //   92: invokestatic 484	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   95: aastore
    //   96: invokevirtual 271	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   99: pop
    //   100: aload 6
    //   102: ifnull -89 -> 13
    //   105: aload 6
    //   107: invokevirtual 277	android/database/sqlite/SQLiteDatabase:close	()V
    //   110: goto -97 -> 13
    //   113: astore_3
    //   114: aload_0
    //   115: monitorexit
    //   116: aload_3
    //   117: athrow
    //   118: astore_3
    //   119: aload 4
    //   121: astore 5
    //   123: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   126: ifeq +36 -> 162
    //   129: aload 4
    //   131: astore 5
    //   133: ldc 13
    //   135: iconst_2
    //   136: new 181	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   143: ldc_w 486
    //   146: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload_3
    //   150: invokevirtual 189	java/lang/Exception:toString	()Ljava/lang/String;
    //   153: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 193	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   162: aload 4
    //   164: ifnull -151 -> 13
    //   167: aload 4
    //   169: invokevirtual 277	android/database/sqlite/SQLiteDatabase:close	()V
    //   172: goto -159 -> 13
    //   175: astore_3
    //   176: aload 5
    //   178: ifnull +8 -> 186
    //   181: aload 5
    //   183: invokevirtual 277	android/database/sqlite/SQLiteDatabase:close	()V
    //   186: aload_3
    //   187: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	this	ovb
    //   0	188	1	paramLong	long
    //   0	188	3	paramString	String
    //   20	148	4	localObject1	Object
    //   17	165	5	localObject2	Object
    //   26	80	6	localSQLiteDatabase	SQLiteDatabase
    //   43	31	7	localContentValues	ContentValues
    //   6	3	8	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	8	113	finally
    //   105	110	113	finally
    //   167	172	113	finally
    //   181	186	113	finally
    //   186	188	113	finally
    //   22	28	118	java/lang/Exception
    //   36	45	118	java/lang/Exception
    //   53	61	118	java/lang/Exception
    //   69	100	118	java/lang/Exception
    //   22	28	175	finally
    //   36	45	175	finally
    //   53	61	175	finally
    //   69	100	175	finally
    //   123	129	175	finally
    //   133	162	175	finally
  }
  
  /* Error */
  public void a(long paramLong, java.util.List paramList)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_3
    //   9: ifnull +16 -> 25
    //   12: aload_3
    //   13: invokeinterface 391 1 0
    //   18: istore 9
    //   20: iload 9
    //   22: ifeq +6 -> 28
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    //   28: aload_0
    //   29: invokevirtual 229	ovb:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   32: astore 6
    //   34: aload 6
    //   36: astore 4
    //   38: aload 6
    //   40: astore 5
    //   42: aload 6
    //   44: invokevirtual 232	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   47: aload 6
    //   49: astore 4
    //   51: aload 6
    //   53: astore 5
    //   55: new 234	android/content/ContentValues
    //   58: dup
    //   59: invokespecial 235	android/content/ContentValues:<init>	()V
    //   62: astore 7
    //   64: aload 6
    //   66: astore 4
    //   68: aload 6
    //   70: astore 5
    //   72: aload_3
    //   73: invokeinterface 488 1 0
    //   78: astore_3
    //   79: aload 6
    //   81: astore 4
    //   83: aload 6
    //   85: astore 5
    //   87: aload_3
    //   88: invokeinterface 246 1 0
    //   93: ifeq +250 -> 343
    //   96: aload 6
    //   98: astore 4
    //   100: aload 6
    //   102: astore 5
    //   104: aload_3
    //   105: invokeinterface 250 1 0
    //   110: checkcast 139	VACDReport/ReportItem
    //   113: astore 8
    //   115: aload 8
    //   117: ifnull -38 -> 79
    //   120: aload 6
    //   122: astore 4
    //   124: aload 6
    //   126: astore 5
    //   128: aload 7
    //   130: invokevirtual 255	android/content/ContentValues:clear	()V
    //   133: aload 6
    //   135: astore 4
    //   137: aload 6
    //   139: astore 5
    //   141: aload 7
    //   143: ldc 27
    //   145: lload_1
    //   146: invokestatic 259	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   149: invokevirtual 262	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   152: aload 6
    //   154: astore 4
    //   156: aload 6
    //   158: astore 5
    //   160: aload 7
    //   162: ldc 30
    //   164: aload_0
    //   165: aload 8
    //   167: invokespecial 466	ovb:a	(LVACDReport/ReportItem;)Ljava/lang/String;
    //   170: invokevirtual 469	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   173: aload 6
    //   175: astore 4
    //   177: aload 6
    //   179: astore 5
    //   181: aload 7
    //   183: ldc 24
    //   185: aload 8
    //   187: getfield 145	VACDReport/ReportItem:createTime	J
    //   190: invokestatic 259	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   193: invokevirtual 262	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   196: aload 6
    //   198: astore 4
    //   200: aload 6
    //   202: astore 5
    //   204: aload 7
    //   206: ldc 33
    //   208: iconst_0
    //   209: invokestatic 474	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   212: invokevirtual 477	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   215: aload 6
    //   217: astore 4
    //   219: aload 6
    //   221: astore 5
    //   223: aload 6
    //   225: ldc 21
    //   227: aconst_null
    //   228: aload 7
    //   230: invokevirtual 461	android/database/sqlite/SQLiteDatabase:insertOrThrow	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   233: pop2
    //   234: goto -155 -> 79
    //   237: astore_3
    //   238: aload 4
    //   240: astore 5
    //   242: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   245: ifeq +36 -> 281
    //   248: aload 4
    //   250: astore 5
    //   252: ldc 13
    //   254: iconst_4
    //   255: new 181	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   262: ldc_w 490
    //   265: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: aload_3
    //   269: invokevirtual 189	java/lang/Exception:toString	()Ljava/lang/String;
    //   272: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: invokestatic 193	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   281: aload 4
    //   283: ifnull -258 -> 25
    //   286: aload 4
    //   288: invokevirtual 274	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   291: aload 4
    //   293: invokevirtual 277	android/database/sqlite/SQLiteDatabase:close	()V
    //   296: goto -271 -> 25
    //   299: astore_3
    //   300: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   303: ifeq -278 -> 25
    //   306: ldc 13
    //   308: iconst_4
    //   309: new 181	java/lang/StringBuilder
    //   312: dup
    //   313: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   316: ldc_w 492
    //   319: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: aload_3
    //   323: invokevirtual 189	java/lang/Exception:toString	()Ljava/lang/String;
    //   326: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: invokestatic 193	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   335: goto -310 -> 25
    //   338: astore_3
    //   339: aload_0
    //   340: monitorexit
    //   341: aload_3
    //   342: athrow
    //   343: aload 6
    //   345: astore 4
    //   347: aload 6
    //   349: astore 5
    //   351: aload 6
    //   353: invokevirtual 280	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   356: aload 6
    //   358: ifnull -333 -> 25
    //   361: aload 6
    //   363: invokevirtual 274	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   366: aload 6
    //   368: invokevirtual 277	android/database/sqlite/SQLiteDatabase:close	()V
    //   371: goto -346 -> 25
    //   374: astore_3
    //   375: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   378: ifeq -353 -> 25
    //   381: ldc 13
    //   383: iconst_4
    //   384: new 181	java/lang/StringBuilder
    //   387: dup
    //   388: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   391: ldc_w 492
    //   394: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: aload_3
    //   398: invokevirtual 189	java/lang/Exception:toString	()Ljava/lang/String;
    //   401: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   407: invokestatic 193	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   410: goto -385 -> 25
    //   413: astore_3
    //   414: aload 5
    //   416: ifnull +13 -> 429
    //   419: aload 5
    //   421: invokevirtual 274	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   424: aload 5
    //   426: invokevirtual 277	android/database/sqlite/SQLiteDatabase:close	()V
    //   429: aload_3
    //   430: athrow
    //   431: astore 4
    //   433: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   436: ifeq -7 -> 429
    //   439: ldc 13
    //   441: iconst_4
    //   442: new 181	java/lang/StringBuilder
    //   445: dup
    //   446: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   449: ldc_w 492
    //   452: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: aload 4
    //   457: invokevirtual 189	java/lang/Exception:toString	()Ljava/lang/String;
    //   460: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   466: invokestatic 193	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   469: goto -40 -> 429
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	472	0	this	ovb
    //   0	472	1	paramLong	long
    //   0	472	3	paramList	java.util.List
    //   4	342	4	localObject1	Object
    //   431	25	4	localException	Exception
    //   1	424	5	localObject2	Object
    //   32	335	6	localSQLiteDatabase	SQLiteDatabase
    //   62	167	7	localContentValues	ContentValues
    //   113	73	8	localReportItem	ReportItem
    //   18	3	9	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   28	34	237	java/lang/Exception
    //   42	47	237	java/lang/Exception
    //   55	64	237	java/lang/Exception
    //   72	79	237	java/lang/Exception
    //   87	96	237	java/lang/Exception
    //   104	115	237	java/lang/Exception
    //   128	133	237	java/lang/Exception
    //   141	152	237	java/lang/Exception
    //   160	173	237	java/lang/Exception
    //   181	196	237	java/lang/Exception
    //   204	215	237	java/lang/Exception
    //   223	234	237	java/lang/Exception
    //   351	356	237	java/lang/Exception
    //   286	296	299	java/lang/Exception
    //   12	20	338	finally
    //   286	296	338	finally
    //   300	335	338	finally
    //   361	371	338	finally
    //   375	410	338	finally
    //   419	429	338	finally
    //   429	431	338	finally
    //   433	469	338	finally
    //   361	371	374	java/lang/Exception
    //   28	34	413	finally
    //   42	47	413	finally
    //   55	64	413	finally
    //   72	79	413	finally
    //   87	96	413	finally
    //   104	115	413	finally
    //   128	133	413	finally
    //   141	152	413	finally
    //   160	173	413	finally
    //   181	196	413	finally
    //   204	215	413	finally
    //   223	234	413	finally
    //   242	248	413	finally
    //   252	281	413	finally
    //   351	356	413	finally
    //   419	429	431	java/lang/Exception
  }
  
  public void a(String paramString, ReportHeader paramReportHeader)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramReportHeader == null) {}
    for (;;)
    {
      return;
      try
      {
        SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        ContentValues localContentValues = new ContentValues();
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("seqno", Long.valueOf(paramReportHeader.seqno));
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("content", a(paramReportHeader));
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("type", Integer.valueOf(1));
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        if (!TextUtils.isEmpty(paramString))
        {
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          localContentValues.put("skey", paramString);
        }
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localContentValues.put("createTime", Integer.valueOf(0));
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        localSQLiteDatabase.insertOrThrow("ReportItem", null, localContentValues);
        if (localSQLiteDatabase == null) {
          continue;
        }
        try
        {
          localSQLiteDatabase.close();
        }
        finally {}
      }
      catch (Exception paramString)
      {
        localObject2 = localObject1;
        if (QLog.isColorLevel())
        {
          localObject2 = localObject1;
          QLog.e("VACDReport", 2, "saveReportHeader exception:  " + paramString.toString());
        }
        if (localObject1 == null) {
          continue;
        }
        ((SQLiteDatabase)localObject1).close();
      }
      finally
      {
        if (localObject2 != null) {
          ((SQLiteDatabase)localObject2).close();
        }
      }
    }
  }
  
  /* Error */
  public void a(java.util.List paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +16 -> 19
    //   6: aload_1
    //   7: invokeinterface 391 1 0
    //   12: istore 11
    //   14: iload 11
    //   16: ifeq +6 -> 22
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aconst_null
    //   23: astore_3
    //   24: aconst_null
    //   25: astore_2
    //   26: aload_0
    //   27: invokevirtual 229	ovb:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   30: astore 4
    //   32: aload 4
    //   34: astore_2
    //   35: aload 4
    //   37: astore_3
    //   38: aload 4
    //   40: invokevirtual 232	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   43: aload 4
    //   45: astore_2
    //   46: aload 4
    //   48: astore_3
    //   49: aload_1
    //   50: invokeinterface 498 1 0
    //   55: istore 8
    //   57: aload 4
    //   59: astore_2
    //   60: aload 4
    //   62: astore_3
    //   63: new 181	java/lang/StringBuilder
    //   66: dup
    //   67: iload 8
    //   69: bipush 14
    //   71: imul
    //   72: invokespecial 499	java/lang/StringBuilder:<init>	(I)V
    //   75: astore 5
    //   77: iconst_0
    //   78: istore 7
    //   80: iload 7
    //   82: iload 8
    //   84: if_icmpge +137 -> 221
    //   87: aload 4
    //   89: astore_2
    //   90: aload 4
    //   92: astore_3
    //   93: aload_1
    //   94: iload 7
    //   96: invokeinterface 500 2 0
    //   101: checkcast 252	java/lang/Long
    //   104: invokevirtual 503	java/lang/Long:longValue	()J
    //   107: lstore 9
    //   109: aload 4
    //   111: astore_2
    //   112: aload 4
    //   114: astore_3
    //   115: aload 5
    //   117: lload 9
    //   119: invokevirtual 225	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: iload 7
    //   125: iload 8
    //   127: iconst_1
    //   128: isub
    //   129: if_icmpge +18 -> 147
    //   132: aload 4
    //   134: astore_2
    //   135: aload 4
    //   137: astore_3
    //   138: aload 5
    //   140: ldc_w 505
    //   143: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: aload 4
    //   149: astore_2
    //   150: aload 4
    //   152: astore_3
    //   153: iconst_1
    //   154: anewarray 65	java/lang/String
    //   157: astore 6
    //   159: aload 4
    //   161: astore_2
    //   162: aload 4
    //   164: astore_3
    //   165: aload 6
    //   167: iconst_0
    //   168: lload 9
    //   170: invokestatic 308	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   173: aastore
    //   174: aload 4
    //   176: astore_2
    //   177: aload 4
    //   179: astore_3
    //   180: aload 4
    //   182: ldc 21
    //   184: ldc_w 507
    //   187: aload 6
    //   189: invokevirtual 511	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   192: pop
    //   193: aload 4
    //   195: astore_2
    //   196: aload 4
    //   198: astore_3
    //   199: aload 4
    //   201: ldc 42
    //   203: ldc_w 507
    //   206: aload 6
    //   208: invokevirtual 511	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   211: pop
    //   212: iload 7
    //   214: iconst_1
    //   215: iadd
    //   216: istore 7
    //   218: goto -138 -> 80
    //   221: aload 4
    //   223: astore_2
    //   224: aload 4
    //   226: astore_3
    //   227: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   230: ifeq +39 -> 269
    //   233: aload 4
    //   235: astore_2
    //   236: aload 4
    //   238: astore_3
    //   239: ldc 13
    //   241: iconst_2
    //   242: new 181	java/lang/StringBuilder
    //   245: dup
    //   246: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   249: ldc_w 513
    //   252: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: aload 5
    //   257: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: invokestatic 386	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   269: aload 4
    //   271: astore_2
    //   272: aload 4
    //   274: astore_3
    //   275: aload 4
    //   277: invokevirtual 280	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   280: aload 4
    //   282: ifnull -263 -> 19
    //   285: aload 4
    //   287: invokevirtual 274	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   290: aload 4
    //   292: invokevirtual 277	android/database/sqlite/SQLiteDatabase:close	()V
    //   295: goto -276 -> 19
    //   298: astore_1
    //   299: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   302: ifeq -283 -> 19
    //   305: ldc 13
    //   307: iconst_2
    //   308: new 181	java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   315: ldc_w 515
    //   318: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: aload_1
    //   322: invokevirtual 189	java/lang/Exception:toString	()Ljava/lang/String;
    //   325: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   331: invokestatic 193	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   334: goto -315 -> 19
    //   337: astore_1
    //   338: aload_0
    //   339: monitorexit
    //   340: aload_1
    //   341: athrow
    //   342: astore_1
    //   343: aload_2
    //   344: astore_3
    //   345: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   348: ifeq +34 -> 382
    //   351: aload_2
    //   352: astore_3
    //   353: ldc 13
    //   355: iconst_2
    //   356: new 181	java/lang/StringBuilder
    //   359: dup
    //   360: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   363: ldc_w 517
    //   366: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: aload_1
    //   370: invokevirtual 189	java/lang/Exception:toString	()Ljava/lang/String;
    //   373: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   379: invokestatic 193	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   382: aload_2
    //   383: ifnull -364 -> 19
    //   386: aload_2
    //   387: invokevirtual 274	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   390: aload_2
    //   391: invokevirtual 277	android/database/sqlite/SQLiteDatabase:close	()V
    //   394: goto -375 -> 19
    //   397: astore_1
    //   398: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   401: ifeq -382 -> 19
    //   404: ldc 13
    //   406: iconst_2
    //   407: new 181	java/lang/StringBuilder
    //   410: dup
    //   411: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   414: ldc_w 515
    //   417: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: aload_1
    //   421: invokevirtual 189	java/lang/Exception:toString	()Ljava/lang/String;
    //   424: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   430: invokestatic 193	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   433: goto -414 -> 19
    //   436: astore_1
    //   437: aload_3
    //   438: ifnull +11 -> 449
    //   441: aload_3
    //   442: invokevirtual 274	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   445: aload_3
    //   446: invokevirtual 277	android/database/sqlite/SQLiteDatabase:close	()V
    //   449: aload_1
    //   450: athrow
    //   451: astore_2
    //   452: invokestatic 179	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   455: ifeq -6 -> 449
    //   458: ldc 13
    //   460: iconst_2
    //   461: new 181	java/lang/StringBuilder
    //   464: dup
    //   465: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   468: ldc_w 515
    //   471: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: aload_2
    //   475: invokevirtual 189	java/lang/Exception:toString	()Ljava/lang/String;
    //   478: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   484: invokestatic 193	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   487: goto -38 -> 449
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	490	0	this	ovb
    //   0	490	1	paramList	java.util.List
    //   25	366	2	localObject1	Object
    //   451	24	2	localException	Exception
    //   23	423	3	localObject2	Object
    //   30	261	4	localSQLiteDatabase	SQLiteDatabase
    //   75	181	5	localStringBuilder	StringBuilder
    //   157	50	6	arrayOfString	String[]
    //   78	139	7	k	int
    //   55	74	8	m	int
    //   107	62	9	l	long
    //   12	3	11	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   285	295	298	java/lang/Exception
    //   6	14	337	finally
    //   285	295	337	finally
    //   299	334	337	finally
    //   386	394	337	finally
    //   398	433	337	finally
    //   441	449	337	finally
    //   449	451	337	finally
    //   452	487	337	finally
    //   26	32	342	java/lang/Exception
    //   38	43	342	java/lang/Exception
    //   49	57	342	java/lang/Exception
    //   63	77	342	java/lang/Exception
    //   93	109	342	java/lang/Exception
    //   115	123	342	java/lang/Exception
    //   138	147	342	java/lang/Exception
    //   153	159	342	java/lang/Exception
    //   165	174	342	java/lang/Exception
    //   180	193	342	java/lang/Exception
    //   199	212	342	java/lang/Exception
    //   227	233	342	java/lang/Exception
    //   239	269	342	java/lang/Exception
    //   275	280	342	java/lang/Exception
    //   386	394	397	java/lang/Exception
    //   26	32	436	finally
    //   38	43	436	finally
    //   49	57	436	finally
    //   63	77	436	finally
    //   93	109	436	finally
    //   115	123	436	finally
    //   138	147	436	finally
    //   153	159	436	finally
    //   165	174	436	finally
    //   180	193	436	finally
    //   199	212	436	finally
    //   227	233	436	finally
    //   239	269	436	finally
    //   275	280	436	finally
    //   345	351	436	finally
    //   353	382	436	finally
    //   441	449	451	java/lang/Exception
  }
  
  protected void finalize()
  {
    close();
    super.finalize();
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    b(paramSQLiteDatabase);
    a(paramSQLiteDatabase);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2)
    {
      switch (paramInt1)
      {
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        try
        {
          paramSQLiteDatabase.execSQL("ALTER TABLE VACDReport ADD sendTime INTEGER(16) DEFAULT 0");
        }
        catch (Exception localException1) {}
        continue;
        try
        {
          paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS VACDReport");
          try
          {
            b(paramSQLiteDatabase);
          }
          catch (Exception localException2) {}
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("VACDReport", 2, "createReportItemTable exception:" + localException2.toString());
        }
        catch (Exception localException3)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("VACDReport", 2, "VACDReport table is not exists");
            }
          }
        }
        try
        {
          paramSQLiteDatabase.execSQL("ALTER TABLE ReportItem ADD COLUMN status INTEGER DEFAULT 1");
        }
        catch (Exception localException4) {}
        if (QLog.isColorLevel())
        {
          QLog.e("VACDReport", 2, " TABLE ReportItem add column status is exception=" + localException4.toString());
          continue;
          try
          {
            paramSQLiteDatabase.execSQL("ALTER TABLE ReportItem ADD COLUMN send_time INTEGER(16) DEFAULT 9");
          }
          catch (Exception localException5) {}
          if (QLog.isColorLevel())
          {
            QLog.e("VACDReport", 2, " TABLE ReportItem add column send_time is exception=" + localException5.toString());
            continue;
            try
            {
              a(paramSQLiteDatabase);
            }
            catch (Exception localException6) {}
            if (QLog.isColorLevel()) {
              QLog.e("VACDReport", 2, "createReportRecordTable exception=" + localException6.toString());
            }
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ovb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */