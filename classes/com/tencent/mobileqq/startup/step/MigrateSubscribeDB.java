package com.tencent.mobileqq.startup.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.subscript.SubscriptUtil;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import utx;
import uty;
import utz;

public class MigrateSubscribeDB
  extends Step
{
  private static final int M = 17;
  private static final String jdField_a_of_type_JavaLangString = "MigrateSubscribeDB";
  public static boolean a = false;
  private static final int jdField_b_of_type_Int = 40000;
  private static final int jdField_c_of_type_Int = 80;
  int jdField_a_of_type_Int = -1;
  long jdField_a_of_type_Long = 0L;
  BaseApplicationImpl jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
  Object jdField_a_of_type_JavaLangObject = new Object();
  private List jdField_a_of_type_JavaUtilList;
  private List jdField_b_of_type_JavaUtilList;
  volatile boolean jdField_b_of_type_Boolean = true;
  private List jdField_c_of_type_JavaUtilList;
  
  private int a()
  {
    return (short)Math.abs(new Random().nextInt()) & 0xFFFF;
  }
  
  private long a()
  {
    return MessageUtils.a(0x4000000000000 | Math.abs(new Random().nextInt()));
  }
  
  private String a(Object paramObject)
  {
    if (paramObject == null) {
      paramObject = null;
    }
    String str;
    do
    {
      return (String)paramObject;
      str = paramObject.toString();
      paramObject = str;
    } while (str.length() <= 0);
    return SecurityUtile.a(str);
  }
  
  private List a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MigrateSubscribeDB", 2, "getSubscribeRecentDataList fail readInJoySubDBName is null");
      }
      paramString = null;
      return paramString;
    }
    uty localuty = new uty(this, BaseApplication.getContext(), paramString, 17);
    paramString = localuty.getReadableDatabase().rawQuery("select * from RecentSubscribeData order by mLastMsgTime DESC", null);
    if (paramString != null) {}
    for (;;)
    {
      try
      {
        if (!paramString.moveToFirst()) {
          continue;
        }
        int i = paramString.getColumnIndex("mDraft");
        int j = paramString.getColumnIndex("mDraftTime");
        int k = paramString.getColumnIndex("mLastMsg");
        int m = paramString.getColumnIndex("mLastMsgID");
        int n = paramString.getColumnIndex("mLastMsgTime");
        int i1 = paramString.getColumnIndex("mLastReorderTime");
        int i2 = paramString.getColumnIndex("mSubscribeHeadUrl");
        int i3 = paramString.getColumnIndex("mSubscribeID");
        int i4 = paramString.getColumnIndex("mSubscribeName");
        int i5 = paramString.getColumnIndex("mUnreadCount");
        utz localutz = new utz(this, null);
        localutz.d = a(paramString.getString(i));
        localutz.e = a(paramString.getString(j));
        localutz.jdField_c_of_type_JavaLangString = a(paramString.getString(k));
        localutz.jdField_b_of_type_Long = paramString.getLong(m);
        localutz.jdField_a_of_type_Long = paramString.getLong(n);
        localutz.jdField_c_of_type_Long = paramString.getLong(i1);
        localutz.f = a(paramString.getString(i2));
        localutz.jdField_a_of_type_JavaLangString = a(paramString.getString(i3));
        localutz.jdField_b_of_type_JavaLangString = a(paramString.getString(i4));
        localutz.jdField_a_of_type_Int = paramString.getInt(i5);
        if (QLog.isColorLevel()) {
          QLog.d("MigrateSubscribeDB", 2, "read Subscribe RecentDataResults:(mDraft,mDraftTime,mLastMsg,mLastMsgID,mLastMsgTime,mLastReorderTime,mSubscribeHeadUrl,mSubscribeID,mSubscribeName,mUnreadCount)=(" + localutz.d + "," + localutz.e + "," + localutz.jdField_c_of_type_JavaLangString + "," + localutz.jdField_b_of_type_Long + "," + localutz.jdField_a_of_type_Long + "," + localutz.jdField_c_of_type_Long + localutz.f + "," + localutz.jdField_a_of_type_JavaLangString + "," + localutz.jdField_b_of_type_JavaLangString + "," + localutz.jdField_a_of_type_Int + ")");
        }
        localArrayList.add(localutz);
        boolean bool = paramString.moveToNext();
        if (bool) {
          continue;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("MigrateSubscribeDB", 2, "read Subscribe Recent Datas Exception", localException);
        paramString.close();
        continue;
      }
      finally
      {
        paramString.close();
      }
      paramString = localArrayList;
      if (localuty == null) {
        break;
      }
      localuty.close();
      return localArrayList;
      if (QLog.isColorLevel())
      {
        QLog.d("MigrateSubscribeDB", 2, "getSubscribeRecentDataList select from RecentSubscribeData no data");
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("MigrateSubscribeDB", 2, "getSubscribeRecentDataList fail curSubReadInJoy is null");
        }
      }
    }
  }
  
  /* Error */
  private List a(String paramString1, String paramString2, List paramList, String paramString3)
  {
    // Byte code:
    //   0: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +56 -> 59
    //   6: ldc 11
    //   8: iconst_2
    //   9: new 184	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   16: ldc -26
    //   18: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_1
    //   22: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: ldc -24
    //   27: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_2
    //   31: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: ldc -22
    //   36: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_3
    //   40: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   43: ldc -17
    //   45: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload 4
    //   50: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: invokestatic 244	java/lang/System:nanoTime	()J
    //   62: lstore 17
    //   64: new 79	java/util/ArrayList
    //   67: dup
    //   68: invokespecial 80	java/util/ArrayList:<init>	()V
    //   71: astore 5
    //   73: aload_2
    //   74: ifnull +7 -> 81
    //   77: aload_3
    //   78: ifnonnull +19 -> 97
    //   81: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   84: ifeq +11 -> 95
    //   87: ldc 11
    //   89: iconst_2
    //   90: ldc -10
    //   92: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   95: aconst_null
    //   96: areturn
    //   97: aload_3
    //   98: invokeinterface 249 1 0
    //   103: istore 10
    //   105: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   108: ifeq +29 -> 137
    //   111: ldc 11
    //   113: iconst_2
    //   114: new 184	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   121: ldc -5
    //   123: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: iload 10
    //   128: invokevirtual 199	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   131: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   137: iconst_0
    //   138: istore 9
    //   140: iload 9
    //   142: iload 10
    //   144: if_icmpge +958 -> 1102
    //   147: aload_3
    //   148: iload 9
    //   150: invokeinterface 255 2 0
    //   155: checkcast 146	utz
    //   158: getfield 176	utz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   161: aload_2
    //   162: invokevirtual 258	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   165: ifeq +681 -> 846
    //   168: aload_3
    //   169: iload 9
    //   171: invokeinterface 255 2 0
    //   176: checkcast 146	utz
    //   179: astore_3
    //   180: aload_3
    //   181: ifnull +915 -> 1096
    //   184: aload_3
    //   185: getfield 182	utz:jdField_a_of_type_Int	I
    //   188: istore 9
    //   190: ldc_w 260
    //   193: astore_3
    //   194: iload 9
    //   196: ifle +7 -> 203
    //   199: ldc_w 262
    //   202: astore_3
    //   203: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   206: ifeq +29 -> 235
    //   209: ldc 11
    //   211: iconst_2
    //   212: new 184	java/lang/StringBuilder
    //   215: dup
    //   216: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   219: ldc_w 264
    //   222: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: aload_3
    //   226: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   235: new 94	uty
    //   238: dup
    //   239: aload_0
    //   240: invokestatic 100	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   243: aload_1
    //   244: bipush 80
    //   246: invokespecial 103	uty:<init>	(Lcom/tencent/mobileqq/startup/step/MigrateSubscribeDB;Landroid/content/Context;Ljava/lang/String;I)V
    //   249: astore_1
    //   250: aload_1
    //   251: invokevirtual 107	uty:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   254: iconst_0
    //   255: ldc_w 266
    //   258: aconst_null
    //   259: ldc_w 268
    //   262: iconst_1
    //   263: anewarray 66	java/lang/String
    //   266: dup
    //   267: iconst_0
    //   268: aload_2
    //   269: aastore
    //   270: aconst_null
    //   271: aconst_null
    //   272: ldc_w 270
    //   275: aload_3
    //   276: invokevirtual 274	android/database/sqlite/SQLiteDatabase:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   279: astore_2
    //   280: aload_2
    //   281: ifnull +750 -> 1031
    //   284: aload_2
    //   285: invokeinterface 120 1 0
    //   290: ifeq +714 -> 1004
    //   293: aload_2
    //   294: ldc_w 276
    //   297: invokeinterface 126 2 0
    //   302: istore 11
    //   304: aload_2
    //   305: ldc_w 278
    //   308: invokeinterface 126 2 0
    //   313: istore 12
    //   315: aload_2
    //   316: ldc_w 280
    //   319: invokeinterface 126 2 0
    //   324: istore 13
    //   326: aload_2
    //   327: ldc_w 282
    //   330: invokeinterface 126 2 0
    //   335: istore 14
    //   337: aload_2
    //   338: ldc_w 284
    //   341: invokeinterface 126 2 0
    //   346: istore 15
    //   348: aload_2
    //   349: ldc_w 286
    //   352: invokeinterface 126 2 0
    //   357: istore 16
    //   359: aload_2
    //   360: iload 11
    //   362: invokeinterface 166 2 0
    //   367: lstore 19
    //   369: aload_2
    //   370: iload 12
    //   372: invokeinterface 153 2 0
    //   377: astore 7
    //   379: aload_2
    //   380: iload 13
    //   382: invokeinterface 153 2 0
    //   387: astore_3
    //   388: aload_2
    //   389: iload 14
    //   391: invokeinterface 153 2 0
    //   396: astore 6
    //   398: aload_2
    //   399: iload 15
    //   401: invokeinterface 166 2 0
    //   406: lstore 21
    //   408: aload_2
    //   409: iload 16
    //   411: invokeinterface 166 2 0
    //   416: lstore 23
    //   418: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   421: ifeq +84 -> 505
    //   424: ldc 11
    //   426: iconst_2
    //   427: new 184	java/lang/StringBuilder
    //   430: dup
    //   431: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   434: ldc_w 288
    //   437: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: lload 19
    //   442: invokevirtual 196	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   445: ldc -63
    //   447: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: aload 7
    //   452: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: ldc -63
    //   457: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: aload_3
    //   461: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: ldc -63
    //   466: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: aload 6
    //   471: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: ldc -63
    //   476: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: lload 21
    //   481: invokevirtual 196	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   484: ldc -63
    //   486: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: lload 23
    //   491: invokevirtual 196	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   494: ldc -55
    //   496: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   502: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   505: aload 7
    //   507: invokestatic 291	com/tencent/biz/pubaccount/subscript/SubscriptUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   510: astore_3
    //   511: aload_3
    //   512: invokestatic 297	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   515: ifne +439 -> 954
    //   518: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   521: ifeq +40 -> 561
    //   524: ldc 11
    //   526: iconst_2
    //   527: new 184	java/lang/StringBuilder
    //   530: dup
    //   531: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   534: ldc_w 299
    //   537: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: aload 7
    //   542: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   545: ldc_w 301
    //   548: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: aload_3
    //   552: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   558: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   561: aload 6
    //   563: invokestatic 306	com/tencent/biz/pubaccount/util/PAMessageUtil:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/PAMessage;
    //   566: astore 8
    //   568: aload 8
    //   570: ifnull +366 -> 936
    //   573: sipush 62530
    //   576: invokestatic 311	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   579: checkcast 313	com/tencent/mobileqq/data/MessageForPubAccount
    //   582: astore 7
    //   584: aload 7
    //   586: sipush 62530
    //   589: putfield 316	com/tencent/mobileqq/data/MessageForPubAccount:msgtype	I
    //   592: aload 7
    //   594: sipush 1008
    //   597: putfield 319	com/tencent/mobileqq/data/MessageForPubAccount:istroop	I
    //   600: aload 7
    //   602: aload 6
    //   604: putfield 322	com/tencent/mobileqq/data/MessageForPubAccount:msg	Ljava/lang/String;
    //   607: aload 7
    //   609: aload 8
    //   611: putfield 326	com/tencent/mobileqq/data/MessageForPubAccount:mPAMessage	Lcom/tencent/mobileqq/data/PAMessage;
    //   614: aload 7
    //   616: aload 8
    //   618: invokestatic 329	com/tencent/biz/pubaccount/util/PAMessageUtil:a	(Lcom/tencent/mobileqq/data/PAMessage;)[B
    //   621: putfield 333	com/tencent/mobileqq/data/MessageForPubAccount:msgData	[B
    //   624: aload 7
    //   626: aload_3
    //   627: putfield 336	com/tencent/mobileqq/data/MessageForPubAccount:frienduin	Ljava/lang/String;
    //   630: aload 7
    //   632: aload_3
    //   633: putfield 339	com/tencent/mobileqq/data/MessageForPubAccount:senderuin	Ljava/lang/String;
    //   636: aload 7
    //   638: aload 4
    //   640: putfield 342	com/tencent/mobileqq/data/MessageForPubAccount:selfuin	Ljava/lang/String;
    //   643: aload 7
    //   645: lload 21
    //   647: putfield 345	com/tencent/mobileqq/data/MessageForPubAccount:time	J
    //   650: aload 7
    //   652: lload 21
    //   654: putfield 348	com/tencent/mobileqq/data/MessageForPubAccount:msgseq	J
    //   657: aload 7
    //   659: aload_0
    //   660: invokespecial 350	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	()I
    //   663: i2l
    //   664: putfield 353	com/tencent/mobileqq/data/MessageForPubAccount:shmsgseq	J
    //   667: aload 7
    //   669: aload_0
    //   670: invokespecial 355	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	()J
    //   673: putfield 358	com/tencent/mobileqq/data/MessageForPubAccount:msgUid	J
    //   676: iload 9
    //   678: ifle +252 -> 930
    //   681: iconst_0
    //   682: istore 25
    //   684: aload 7
    //   686: iload 25
    //   688: putfield 361	com/tencent/mobileqq/data/MessageForPubAccount:isread	Z
    //   691: aload 5
    //   693: aload 7
    //   695: invokeinterface 208 2 0
    //   700: pop
    //   701: iload 9
    //   703: iconst_1
    //   704: isub
    //   705: istore 9
    //   707: goto +400 -> 1107
    //   710: aload_2
    //   711: invokeinterface 211 1 0
    //   716: istore 25
    //   718: iload 10
    //   720: istore 9
    //   722: iload 25
    //   724: ifne -365 -> 359
    //   727: aload_2
    //   728: invokeinterface 214 1 0
    //   733: aload_1
    //   734: ifnull +7 -> 741
    //   737: aload_1
    //   738: invokevirtual 215	uty:close	()V
    //   741: aload 5
    //   743: ifnull +303 -> 1046
    //   746: aload 5
    //   748: invokeinterface 249 1 0
    //   753: ifle +293 -> 1046
    //   756: iconst_0
    //   757: istore 9
    //   759: iload 9
    //   761: aload 5
    //   763: invokeinterface 249 1 0
    //   768: iconst_1
    //   769: isub
    //   770: if_icmpge +276 -> 1046
    //   773: aload 5
    //   775: invokeinterface 249 1 0
    //   780: iconst_1
    //   781: isub
    //   782: istore 10
    //   784: iload 10
    //   786: iload 9
    //   788: if_icmple +234 -> 1022
    //   791: aload 5
    //   793: iload 10
    //   795: invokeinterface 255 2 0
    //   800: checkcast 363	com/tencent/mobileqq/data/MessageRecord
    //   803: getfield 364	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   806: aload 5
    //   808: iload 9
    //   810: invokeinterface 255 2 0
    //   815: checkcast 363	com/tencent/mobileqq/data/MessageRecord
    //   818: getfield 364	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   821: invokevirtual 258	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   824: ifeq +13 -> 837
    //   827: aload 5
    //   829: iload 10
    //   831: invokeinterface 367 2 0
    //   836: pop
    //   837: iload 10
    //   839: iconst_1
    //   840: isub
    //   841: istore 10
    //   843: goto -59 -> 784
    //   846: iload 9
    //   848: iconst_1
    //   849: iadd
    //   850: istore 9
    //   852: goto -712 -> 140
    //   855: astore 6
    //   857: aload 6
    //   859: invokevirtual 220	java/lang/Exception:printStackTrace	()V
    //   862: goto -248 -> 614
    //   865: astore_3
    //   866: aload_3
    //   867: invokevirtual 220	java/lang/Exception:printStackTrace	()V
    //   870: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   873: ifeq +13 -> 886
    //   876: ldc 11
    //   878: iconst_2
    //   879: ldc_w 369
    //   882: aload_3
    //   883: invokestatic 225	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   886: aload_2
    //   887: invokeinterface 214 1 0
    //   892: aload_1
    //   893: ifnull -152 -> 741
    //   896: aload_1
    //   897: invokevirtual 215	uty:close	()V
    //   900: goto -159 -> 741
    //   903: astore 6
    //   905: aload 6
    //   907: invokevirtual 220	java/lang/Exception:printStackTrace	()V
    //   910: goto -286 -> 624
    //   913: astore_3
    //   914: aload_2
    //   915: invokeinterface 214 1 0
    //   920: aload_1
    //   921: ifnull +7 -> 928
    //   924: aload_1
    //   925: invokevirtual 215	uty:close	()V
    //   928: aload_3
    //   929: athrow
    //   930: iconst_1
    //   931: istore 25
    //   933: goto -249 -> 684
    //   936: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   939: ifeq +175 -> 1114
    //   942: ldc 11
    //   944: iconst_2
    //   945: ldc_w 371
    //   948: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   951: goto +163 -> 1114
    //   954: iload 9
    //   956: istore 10
    //   958: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   961: ifeq -251 -> 710
    //   964: ldc 11
    //   966: iconst_2
    //   967: new 184	java/lang/StringBuilder
    //   970: dup
    //   971: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   974: ldc_w 373
    //   977: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   980: aload 7
    //   982: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   985: ldc_w 375
    //   988: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   991: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   994: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   997: iload 9
    //   999: istore 10
    //   1001: goto -291 -> 710
    //   1004: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1007: ifeq -280 -> 727
    //   1010: ldc 11
    //   1012: iconst_2
    //   1013: ldc_w 377
    //   1016: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1019: goto -292 -> 727
    //   1022: iload 9
    //   1024: iconst_1
    //   1025: iadd
    //   1026: istore 9
    //   1028: goto -269 -> 759
    //   1031: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1034: ifeq +12 -> 1046
    //   1037: ldc 11
    //   1039: iconst_2
    //   1040: ldc_w 379
    //   1043: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1046: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1049: ifeq +44 -> 1093
    //   1052: ldc 11
    //   1054: iconst_2
    //   1055: new 184	java/lang/StringBuilder
    //   1058: dup
    //   1059: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   1062: ldc_w 381
    //   1065: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1068: invokestatic 244	java/lang/System:nanoTime	()J
    //   1071: lload 17
    //   1073: lsub
    //   1074: ldc2_w 382
    //   1077: ldiv
    //   1078: invokevirtual 196	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1081: ldc_w 385
    //   1084: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1087: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1090: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1093: aload 5
    //   1095: areturn
    //   1096: iconst_0
    //   1097: istore 9
    //   1099: goto -909 -> 190
    //   1102: aconst_null
    //   1103: astore_3
    //   1104: goto -924 -> 180
    //   1107: iload 9
    //   1109: istore 10
    //   1111: goto -401 -> 710
    //   1114: goto -7 -> 1107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1117	0	this	MigrateSubscribeDB
    //   0	1117	1	paramString1	String
    //   0	1117	2	paramString2	String
    //   0	1117	3	paramList	List
    //   0	1117	4	paramString3	String
    //   71	1023	5	localArrayList	ArrayList
    //   396	207	6	str	String
    //   855	3	6	localException1	Exception
    //   903	3	6	localException2	Exception
    //   377	604	7	localObject	Object
    //   566	51	8	localPAMessage	com.tencent.mobileqq.data.PAMessage
    //   138	970	9	i	int
    //   103	1007	10	j	int
    //   302	59	11	k	int
    //   313	58	12	m	int
    //   324	57	13	n	int
    //   335	55	14	i1	int
    //   346	54	15	i2	int
    //   357	53	16	i3	int
    //   62	1010	17	l1	long
    //   367	74	19	l2	long
    //   406	247	21	l3	long
    //   416	74	23	l4	long
    //   682	250	25	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   607	614	855	java/lang/Exception
    //   284	359	865	java/lang/Exception
    //   359	505	865	java/lang/Exception
    //   505	561	865	java/lang/Exception
    //   561	568	865	java/lang/Exception
    //   573	607	865	java/lang/Exception
    //   624	676	865	java/lang/Exception
    //   684	701	865	java/lang/Exception
    //   710	718	865	java/lang/Exception
    //   857	862	865	java/lang/Exception
    //   905	910	865	java/lang/Exception
    //   936	951	865	java/lang/Exception
    //   958	997	865	java/lang/Exception
    //   1004	1019	865	java/lang/Exception
    //   614	624	903	java/lang/Exception
    //   284	359	913	finally
    //   359	505	913	finally
    //   505	561	913	finally
    //   561	568	913	finally
    //   573	607	913	finally
    //   607	614	913	finally
    //   614	624	913	finally
    //   624	676	913	finally
    //   684	701	913	finally
    //   710	718	913	finally
    //   857	862	913	finally
    //   866	886	913	finally
    //   905	910	913	finally
    //   936	951	913	finally
    //   958	997	913	finally
    //   1004	1019	913	finally
  }
  
  private List a(List paramList, String[] paramArrayOfString)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramList.size())
    {
      String str = ((utz)paramList.get(i)).jdField_a_of_type_JavaLangString;
      int j = 0;
      for (;;)
      {
        if (j < paramArrayOfString.length)
        {
          if (paramArrayOfString[j].equals(str)) {
            localArrayList.add(str);
          }
        }
        else
        {
          i += 1;
          break;
        }
        j += 1;
      }
    }
    return localArrayList;
  }
  
  private void a()
  {
    Object localObject3;
    HashMap localHashMap;
    Object localObject2;
    int j;
    int i;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
      localObject1 = BaseApplicationImpl.a().getAllAccounts();
      if (localObject1 != null)
      {
        try
        {
          localObject3 = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.a().getAccount();
          localHashMap = new HashMap(this.jdField_a_of_type_JavaUtilList.size());
          localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            File localFile = (File)((Iterator)localObject2).next();
            if (localFile != null)
            {
              localHashMap.put(localFile.getName().replace(".db", ""), localFile);
              continue;
              return;
            }
          }
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MigrateSubscribeDB", 2, "sorMainDbFiles error", localException);
          }
        }
        localObject2 = new ArrayList(this.jdField_a_of_type_JavaUtilList.size());
        if (QLog.isColorLevel()) {
          QLog.d("MigrateSubscribeDB", 2, "sorMainDbFiles currentUin: " + (String)localObject3);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          localObject3 = (File)localHashMap.remove(localObject3);
          if (localObject3 != null) {
            ((List)localObject2).add(localObject3);
          }
        }
        j = localException.size();
        i = 0;
      }
    }
    for (;;)
    {
      if (i < j)
      {
        localObject3 = (SimpleAccount)localException.get(i);
        if ((localObject3 != null) && (((SimpleAccount)localObject3).getUin() != null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MigrateSubscribeDB", 2, "sorMainDbFiles uin: " + ((SimpleAccount)localObject3).getUin());
          }
          localObject3 = (File)localHashMap.remove(((SimpleAccount)localObject3).getUin());
          if (localObject3 != null) {
            ((List)localObject2).add(localObject3);
          }
        }
      }
      else
      {
        Iterator localIterator = localHashMap.values().iterator();
        while (localIterator.hasNext()) {
          ((List)localObject2).add((File)localIterator.next());
        }
        this.jdField_a_of_type_JavaUtilList = ((List)localObject2);
        return;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MigrateSubscribeDB", 2, "sorMainDbFiles no account login");
        return;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MigrateSubscribeDB", 2, "sorMainDbFiles mUinMainDBFiles is empty");
        return;
      }
      i += 1;
    }
  }
  
  private void a(String paramString)
  {
    long l = System.nanoTime();
    int j = BaseApplicationImpl.a().getSharedPreferences("readinjoy_" + paramString + "_" + 1, 0).getInt("updated_msg_count", 0);
    if (j == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MigrateSubscribeDB", 2, "updateFolderUnReadCount readInJoyUnreadCount == 0");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MigrateSubscribeDB", 2, "updateFolderUnReadCount readinjoy new unread count: " + j);
    }
    paramString = BaseApplicationImpl.a().getSharedPreferences(paramString, 0);
    Object localObject2 = paramString.getString("troopbar_assist_new_unread_list", "");
    if (ReadInJoyHelper.b()) {
      QLog.i("MigrateSubscribeDB", 2, "updateFolderUnReadCount, get troopbar new unread list ( newMsgStr ): " + (String)localObject2);
    }
    Object localObject1 = new ConcurrentHashMap();
    for (;;)
    {
      Object localObject3;
      Object localObject4;
      String str;
      try
      {
        localObject2 = new JSONArray((String)localObject2);
        if (!QLog.isColorLevel()) {
          break label623;
        }
        QLog.d("MigrateSubscribeDB", 2, "updateFolderUnReadCount jsonArray length: " + ((JSONArray)localObject2).length());
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        if (!QLog.isColorLevel()) {
          break label372;
        }
        QLog.e("MigrateSubscribeDB", 2, "updateFolderUnReadCount:" + paramString.toString(), paramString);
      }
      if (i < ((JSONArray)localObject2).length())
      {
        localObject3 = ((JSONArray)localObject2).getJSONObject(i);
        localObject4 = ((JSONObject)localObject3).keys();
        if (((Iterator)localObject4).hasNext())
        {
          str = (String)((Iterator)localObject4).next();
          if (QLog.isColorLevel()) {
            QLog.d("MigrateSubscribeDB", 2, "updateFolderUnReadCount newMsgMap put key: " + str + " | value: " + ((JSONObject)localObject3).getInt(str));
          }
          ((ConcurrentHashMap)localObject1).put(str, Integer.valueOf(((JSONObject)localObject3).getInt(str)));
          continue;
        }
      }
      for (;;)
      {
        label372:
        if (!QLog.isColorLevel()) {
          break label621;
        }
        QLog.d("MigrateSubscribeDB", 2, "updateFolderUnReadCount total cost = " + (System.nanoTime() - l) / 1000000L + " ms ");
        return;
        i += 1;
        break;
        ((ConcurrentHashMap)localObject1).put(AppConstants.aR, Integer.valueOf(j));
        localObject2 = ((ConcurrentHashMap)localObject1).keySet().iterator();
        localObject3 = new JSONArray();
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = new JSONObject();
          str = (String)((Iterator)localObject2).next();
          try
          {
            ((JSONObject)localObject4).put(str, ((ConcurrentHashMap)localObject1).get(str));
            ((JSONArray)localObject3).put(localObject4);
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
          }
        }
        localObject1 = ((JSONArray)localObject3).toString();
        if (QLog.isColorLevel()) {
          QLog.d("MigrateSubscribeDB", 2, "updateFolderUnReadCount save newMsgStr into sp:" + (String)localObject1);
        }
        paramString = paramString.edit();
        paramString.putString("troopbar_assist_new_unread_list", (String)localObject1);
        paramString.commit();
        if (ReadInJoyHelper.b()) {
          QLog.i("MigrateSubscribeDB", 2, "updateFolderUnReadCount, put troopbar new list ( newMsgStr ): " + (String)localObject1);
        }
      }
      label621:
      break;
      label623:
      int i = 0;
    }
  }
  
  private void a(String paramString1, String paramString2, String[] paramArrayOfString, List paramList, EntityManager paramEntityManager)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MigrateSubscribeDB", 2, "MigrateAllToMessageRecord  fileName is : " + paramString1 + "uinStr : " + paramString2);
    }
    if (paramArrayOfString != null)
    {
      int j = paramArrayOfString.length;
      if (QLog.isColorLevel()) {
        QLog.d("MigrateSubscribeDB", 2, "Migrate subscribe subscribeMsgIDs size: " + j);
      }
      int i = 0;
      while (i < j)
      {
        List localList = a(paramString1, paramArrayOfString[i], paramList, paramString2);
        a(paramArrayOfString[i], paramList, localList);
        c(localList, paramEntityManager);
        i += 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MigrateSubscribeDB", 2, "Migrate subscribe subscribeMsgIDs is null");
    }
  }
  
  private void a(String paramString, List paramList1, List paramList2)
  {
    if ((paramString == null) || (paramList1 == null) || (paramList2 == null) || (paramList2.size() <= 0)) {
      if (QLog.isColorLevel()) {
        QLog.d("MigrateSubscribeDB", 2, "updateSubscribeRecentDataList subscribleID is null or subscribeRecentDataList is null or subscribeMsgList is null");
      }
    }
    for (;;)
    {
      return;
      long l = ((MessageRecord)paramList2.get(paramList2.size() - 1)).time;
      int j = paramList1.size();
      if (QLog.isColorLevel()) {
        QLog.d("MigrateSubscribeDB", 2, "updateSubscribeRecentDataList subscribeRecentDataList size: " + j);
      }
      int i = 0;
      while (i < j)
      {
        if (((utz)paramList1.get(i)).jdField_a_of_type_JavaLangString.equals(paramString))
        {
          paramString = (utz)paramList1.get(i);
          paramString.jdField_c_of_type_Long = l;
          paramList1.set(i, paramString);
          return;
        }
        i += 1;
      }
    }
  }
  
  private void a(List paramList, EntityManager paramEntityManager)
  {
    long l = System.nanoTime();
    if (paramList == null) {
      if (QLog.isColorLevel()) {
        QLog.d("MigrateSubscribeDB", 2, "migrateToTroopBar fail subscribeRecentDataList is null");
      }
    }
    do
    {
      return;
      int j = paramList.size();
      if (QLog.isColorLevel()) {
        QLog.d("MigrateSubscribeDB", 2, "migrateToTroopBar subscribeRecentDataList list size: " + j);
      }
      int i = 0;
      if (i < j)
      {
        utz localutz = (utz)paramList.get(i);
        if (QLog.isColorLevel()) {
          QLog.d("MigrateSubscribeDB", 2, "migrateToTroopBar subscribeRecentData: " + localutz);
        }
        String str = SubscriptUtil.a(localutz.jdField_a_of_type_JavaLangString);
        if (!TextUtils.isEmpty(str))
        {
          TroopBarData localTroopBarData = new TroopBarData();
          localTroopBarData.mUin = str;
          localTroopBarData.mLastMsgTime = localutz.jdField_c_of_type_Long;
          localTroopBarData.mLastDraftTime = 0L;
          if (QLog.isColorLevel()) {
            QLog.d("MigrateSubscribeDB", 2, "migrateToTroopBar subscribeid[" + localutz.jdField_a_of_type_JavaLangString + "] create new TroopBarData: " + localTroopBarData);
          }
          paramEntityManager.b(localTroopBarData);
        }
        for (;;)
        {
          i += 1;
          break;
          if (QLog.isColorLevel()) {
            QLog.d("MigrateSubscribeDB", 2, "migrateToTroopBar we can't subscribeid[" + localutz.jdField_a_of_type_JavaLangString + "]'s uin");
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("MigrateSubscribeDB", 2, "migrateToTroopBar total cost = " + (System.nanoTime() - l) / 1000000L + " ms ");
  }
  
  /* Error */
  private boolean a(File paramFile)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +24 -> 25
    //   4: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +12 -> 19
    //   10: ldc 11
    //   12: iconst_2
    //   13: ldc_w 647
    //   16: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: iconst_0
    //   20: istore 17
    //   22: iload 17
    //   24: ireturn
    //   25: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   28: ifeq +32 -> 60
    //   31: ldc 11
    //   33: iconst_2
    //   34: new 184	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   41: ldc_w 649
    //   44: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: aload_1
    //   48: invokevirtual 652	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   51: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   60: invokestatic 244	java/lang/System:nanoTime	()J
    //   63: lstore 15
    //   65: aload_1
    //   66: invokevirtual 432	java/io/File:getName	()Ljava/lang/String;
    //   69: astore 6
    //   71: aconst_null
    //   72: astore_2
    //   73: aconst_null
    //   74: astore 11
    //   76: aconst_null
    //   77: astore 5
    //   79: aconst_null
    //   80: astore 4
    //   82: aconst_null
    //   83: astore 10
    //   85: aconst_null
    //   86: astore 7
    //   88: aconst_null
    //   89: astore_3
    //   90: aconst_null
    //   91: astore 9
    //   93: aload_0
    //   94: getfield 654	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   97: invokeinterface 390 1 0
    //   102: ifne +15 -> 117
    //   105: aload_0
    //   106: getfield 656	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:c	Ljava/util/List;
    //   109: invokeinterface 390 1 0
    //   114: ifeq +57 -> 171
    //   117: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   120: ifeq +12 -> 132
    //   123: ldc 11
    //   125: iconst_2
    //   126: ldc_w 658
    //   129: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   132: iconst_0
    //   133: istore 17
    //   135: iconst_0
    //   136: ifeq +11 -> 147
    //   139: new 660	java/lang/NullPointerException
    //   142: dup
    //   143: invokespecial 661	java/lang/NullPointerException:<init>	()V
    //   146: athrow
    //   147: iconst_0
    //   148: ifeq +11 -> 159
    //   151: new 660	java/lang/NullPointerException
    //   154: dup
    //   155: invokespecial 661	java/lang/NullPointerException:<init>	()V
    //   158: athrow
    //   159: iconst_0
    //   160: ifeq -138 -> 22
    //   163: new 660	java/lang/NullPointerException
    //   166: dup
    //   167: invokespecial 661	java/lang/NullPointerException:<init>	()V
    //   170: athrow
    //   171: aload 6
    //   173: ldc_w 434
    //   176: ldc_w 436
    //   179: invokevirtual 440	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   182: invokestatic 667	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   185: invokestatic 670	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   188: astore 12
    //   190: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   193: ifeq +30 -> 223
    //   196: ldc 11
    //   198: iconst_2
    //   199: new 184	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   206: ldc_w 672
    //   209: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: aload 12
    //   214: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   223: aload_0
    //   224: getfield 654	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   227: invokeinterface 390 1 0
    //   232: ifne +456 -> 688
    //   235: aload_0
    //   236: getfield 654	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   239: invokeinterface 418 1 0
    //   244: astore_2
    //   245: aload_2
    //   246: invokeinterface 423 1 0
    //   251: ifeq +1181 -> 1432
    //   254: aload_2
    //   255: invokeinterface 427 1 0
    //   260: checkcast 429	java/io/File
    //   263: invokevirtual 432	java/io/File:getName	()Ljava/lang/String;
    //   266: astore 6
    //   268: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   271: ifeq +30 -> 301
    //   274: ldc 11
    //   276: iconst_2
    //   277: new 184	java/lang/StringBuilder
    //   280: dup
    //   281: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   284: ldc_w 674
    //   287: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: aload 6
    //   292: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   301: aload 6
    //   303: aload 12
    //   305: invokevirtual 677	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   308: ifeq +234 -> 542
    //   311: aload 6
    //   313: astore_2
    //   314: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   317: ifeq +1117 -> 1434
    //   320: ldc 11
    //   322: iconst_2
    //   323: new 184	java/lang/StringBuilder
    //   326: dup
    //   327: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   330: ldc_w 679
    //   333: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: aload 6
    //   338: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   347: aload 6
    //   349: astore_2
    //   350: goto +1084 -> 1434
    //   353: aload_0
    //   354: getfield 656	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:c	Ljava/util/List;
    //   357: invokeinterface 390 1 0
    //   362: ifne +436 -> 798
    //   365: aload_0
    //   366: getfield 656	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:c	Ljava/util/List;
    //   369: invokeinterface 418 1 0
    //   374: astore_2
    //   375: aload_2
    //   376: invokeinterface 423 1 0
    //   381: ifeq +1046 -> 1427
    //   384: aload_2
    //   385: invokeinterface 427 1 0
    //   390: checkcast 429	java/io/File
    //   393: invokevirtual 432	java/io/File:getName	()Ljava/lang/String;
    //   396: astore 8
    //   398: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   401: ifeq +30 -> 431
    //   404: ldc 11
    //   406: iconst_2
    //   407: new 184	java/lang/StringBuilder
    //   410: dup
    //   411: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   414: ldc_w 681
    //   417: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: aload 8
    //   422: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   428: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   431: aload 8
    //   433: aload 12
    //   435: invokevirtual 677	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   438: ifeq +313 -> 751
    //   441: aload 8
    //   443: astore_2
    //   444: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   447: ifeq +993 -> 1440
    //   450: ldc 11
    //   452: iconst_2
    //   453: new 184	java/lang/StringBuilder
    //   456: dup
    //   457: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   460: ldc_w 683
    //   463: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: aload 8
    //   468: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   474: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   477: aload 8
    //   479: astore_2
    //   480: goto +960 -> 1440
    //   483: aload 8
    //   485: ifnonnull +339 -> 824
    //   488: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   491: ifeq +12 -> 503
    //   494: ldc 11
    //   496: iconst_2
    //   497: ldc_w 685
    //   500: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   503: iconst_1
    //   504: istore 17
    //   506: iconst_0
    //   507: ifeq +11 -> 518
    //   510: new 660	java/lang/NullPointerException
    //   513: dup
    //   514: invokespecial 661	java/lang/NullPointerException:<init>	()V
    //   517: athrow
    //   518: iconst_0
    //   519: ifeq +11 -> 530
    //   522: new 660	java/lang/NullPointerException
    //   525: dup
    //   526: invokespecial 661	java/lang/NullPointerException:<init>	()V
    //   529: athrow
    //   530: iconst_0
    //   531: ifeq -509 -> 22
    //   534: new 660	java/lang/NullPointerException
    //   537: dup
    //   538: invokespecial 661	java/lang/NullPointerException:<init>	()V
    //   541: athrow
    //   542: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   545: ifeq -300 -> 245
    //   548: ldc 11
    //   550: iconst_2
    //   551: new 184	java/lang/StringBuilder
    //   554: dup
    //   555: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   558: ldc_w 687
    //   561: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: aload 6
    //   566: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: ldc_w 689
    //   572: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: aload 12
    //   577: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   580: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   583: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   586: goto -341 -> 245
    //   589: astore 5
    //   591: aconst_null
    //   592: astore_2
    //   593: aconst_null
    //   594: astore_1
    //   595: aload 5
    //   597: invokevirtual 220	java/lang/Exception:printStackTrace	()V
    //   600: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   603: ifeq +12 -> 615
    //   606: ldc 11
    //   608: iconst_2
    //   609: ldc_w 691
    //   612: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   615: aload_2
    //   616: ifnull +7 -> 623
    //   619: aload_2
    //   620: invokevirtual 695	com/tencent/mobileqq/app/SQLiteDatabase:d	()V
    //   623: aload_3
    //   624: ifnull +7 -> 631
    //   627: aload_3
    //   628: invokevirtual 697	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   631: aload_1
    //   632: ifnull +7 -> 639
    //   635: aload_1
    //   636: invokevirtual 700	com/tencent/mobileqq/persistence/EntityManagerFactory:close	()V
    //   639: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   642: ifeq +44 -> 686
    //   645: ldc 11
    //   647: iconst_2
    //   648: new 184	java/lang/StringBuilder
    //   651: dup
    //   652: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   655: ldc_w 702
    //   658: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   661: invokestatic 244	java/lang/System:nanoTime	()J
    //   664: lload 15
    //   666: lsub
    //   667: ldc2_w 382
    //   670: ldiv
    //   671: invokevirtual 196	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   674: ldc_w 704
    //   677: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   680: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   683: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   686: iconst_1
    //   687: ireturn
    //   688: aload_2
    //   689: astore 6
    //   691: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   694: ifeq -341 -> 353
    //   697: ldc 11
    //   699: iconst_2
    //   700: ldc_w 706
    //   703: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   706: aload_2
    //   707: astore 6
    //   709: goto -356 -> 353
    //   712: astore_1
    //   713: aload 5
    //   715: astore_2
    //   716: aload 4
    //   718: astore_3
    //   719: aload 9
    //   721: astore 4
    //   723: aload 4
    //   725: ifnull +8 -> 733
    //   728: aload 4
    //   730: invokevirtual 695	com/tencent/mobileqq/app/SQLiteDatabase:d	()V
    //   733: aload_3
    //   734: ifnull +7 -> 741
    //   737: aload_3
    //   738: invokevirtual 697	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   741: aload_2
    //   742: ifnull +7 -> 749
    //   745: aload_2
    //   746: invokevirtual 700	com/tencent/mobileqq/persistence/EntityManagerFactory:close	()V
    //   749: aload_1
    //   750: athrow
    //   751: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   754: ifeq -379 -> 375
    //   757: ldc 11
    //   759: iconst_2
    //   760: new 184	java/lang/StringBuilder
    //   763: dup
    //   764: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   767: ldc_w 708
    //   770: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   773: aload 8
    //   775: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   778: ldc_w 689
    //   781: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   784: aload 12
    //   786: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   789: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   792: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   795: goto -420 -> 375
    //   798: aload 11
    //   800: astore 8
    //   802: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   805: ifeq -322 -> 483
    //   808: ldc 11
    //   810: iconst_2
    //   811: ldc_w 710
    //   814: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   817: aload 11
    //   819: astore 8
    //   821: goto -338 -> 483
    //   824: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   827: ifeq +41 -> 868
    //   830: ldc 11
    //   832: iconst_2
    //   833: new 184	java/lang/StringBuilder
    //   836: dup
    //   837: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   840: ldc_w 712
    //   843: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   846: aload 6
    //   848: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   851: ldc_w 714
    //   854: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   857: aload 8
    //   859: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   862: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   865: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   868: new 716	com/tencent/mobileqq/data/QQEntityManagerFactory
    //   871: dup
    //   872: aload 12
    //   874: invokespecial 717	com/tencent/mobileqq/data/QQEntityManagerFactory:<init>	(Ljava/lang/String;)V
    //   877: astore_2
    //   878: aload 10
    //   880: astore 5
    //   882: aload 7
    //   884: astore 4
    //   886: aload_2
    //   887: invokevirtual 721	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   890: astore_3
    //   891: aload_3
    //   892: astore 5
    //   894: aload_3
    //   895: astore 4
    //   897: aload_3
    //   898: invokevirtual 724	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   901: astore 10
    //   903: aload_3
    //   904: astore 5
    //   906: aload_3
    //   907: astore 4
    //   909: aload_2
    //   910: aload 12
    //   912: invokevirtual 728	com/tencent/mobileqq/persistence/EntityManagerFactory:build	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/SQLiteOpenHelper;
    //   915: invokevirtual 733	com/tencent/mobileqq/app/SQLiteOpenHelper:a	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   918: astore 7
    //   920: aload_0
    //   921: getfield 29	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:jdField_b_of_type_Boolean	Z
    //   924: ifne +67 -> 991
    //   927: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   930: ifeq +30 -> 960
    //   933: ldc 11
    //   935: iconst_2
    //   936: new 184	java/lang/StringBuilder
    //   939: dup
    //   940: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   943: ldc_w 735
    //   946: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   949: aload 12
    //   951: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   954: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   957: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   960: iconst_0
    //   961: istore 17
    //   963: aload 7
    //   965: ifnull +8 -> 973
    //   968: aload 7
    //   970: invokevirtual 695	com/tencent/mobileqq/app/SQLiteDatabase:d	()V
    //   973: aload_3
    //   974: ifnull +7 -> 981
    //   977: aload_3
    //   978: invokevirtual 697	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   981: aload_2
    //   982: ifnull -960 -> 22
    //   985: aload_2
    //   986: invokevirtual 700	com/tencent/mobileqq/persistence/EntityManagerFactory:close	()V
    //   989: iconst_0
    //   990: ireturn
    //   991: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   994: ifeq +62 -> 1056
    //   997: ldc 11
    //   999: iconst_2
    //   1000: new 184	java/lang/StringBuilder
    //   1003: dup
    //   1004: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   1007: ldc_w 737
    //   1010: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1013: aload 12
    //   1015: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1018: ldc_w 739
    //   1021: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1024: aload_1
    //   1025: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1028: ldc_w 741
    //   1031: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1034: aload 6
    //   1036: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1039: ldc_w 743
    //   1042: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1045: aload 8
    //   1047: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1050: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1053: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1056: aload 10
    //   1058: invokevirtual 746	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   1061: aload_0
    //   1062: aload 8
    //   1064: invokespecial 748	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/lang/String;)Ljava/util/List;
    //   1067: astore_1
    //   1068: aload_0
    //   1069: aload_1
    //   1070: aload_3
    //   1071: invokespecial 750	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:b	(Ljava/util/List;Lcom/tencent/mobileqq/persistence/EntityManager;)V
    //   1074: aload_0
    //   1075: aload 12
    //   1077: invokespecial 752	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/lang/String;)V
    //   1080: aload 6
    //   1082: ifnull +64 -> 1146
    //   1085: aload_0
    //   1086: aload 6
    //   1088: aload 12
    //   1090: aload_0
    //   1091: aload 6
    //   1093: invokespecial 755	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/lang/String;)[Ljava/lang/String;
    //   1096: aload_1
    //   1097: aload_3
    //   1098: invokespecial 757	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/util/List;Lcom/tencent/mobileqq/persistence/EntityManager;)V
    //   1101: aload_0
    //   1102: aload_1
    //   1103: aload_3
    //   1104: invokespecial 759	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/util/List;Lcom/tencent/mobileqq/persistence/EntityManager;)V
    //   1107: aload 10
    //   1109: invokevirtual 761	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   1112: aload 10
    //   1114: invokevirtual 763	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   1117: aload 7
    //   1119: ifnull +8 -> 1127
    //   1122: aload 7
    //   1124: invokevirtual 695	com/tencent/mobileqq/app/SQLiteDatabase:d	()V
    //   1127: aload_3
    //   1128: ifnull +7 -> 1135
    //   1131: aload_3
    //   1132: invokevirtual 697	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   1135: aload_2
    //   1136: ifnull -497 -> 639
    //   1139: aload_2
    //   1140: invokevirtual 700	com/tencent/mobileqq/persistence/EntityManagerFactory:close	()V
    //   1143: goto -504 -> 639
    //   1146: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1149: ifeq +12 -> 1161
    //   1152: ldc 11
    //   1154: iconst_2
    //   1155: ldc_w 765
    //   1158: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1161: aload_0
    //   1162: getfield 654	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   1165: invokeinterface 390 1 0
    //   1170: ifne -69 -> 1101
    //   1173: aload_0
    //   1174: getfield 654	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   1177: invokeinterface 418 1 0
    //   1182: astore 4
    //   1184: aload 4
    //   1186: invokeinterface 423 1 0
    //   1191: ifeq -90 -> 1101
    //   1194: aload 4
    //   1196: invokeinterface 427 1 0
    //   1201: checkcast 429	java/io/File
    //   1204: invokevirtual 432	java/io/File:getName	()Ljava/lang/String;
    //   1207: astore 5
    //   1209: aload_0
    //   1210: aload 5
    //   1212: invokespecial 755	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/lang/String;)[Ljava/lang/String;
    //   1215: astore 6
    //   1217: aload 6
    //   1219: ifnull -35 -> 1184
    //   1222: aload_0
    //   1223: aload_1
    //   1224: aload 6
    //   1226: invokespecial 767	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/util/List;[Ljava/lang/String;)Ljava/util/List;
    //   1229: invokeinterface 249 1 0
    //   1234: istore 14
    //   1236: iload 14
    //   1238: ifeq -54 -> 1184
    //   1241: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1244: ifeq +41 -> 1285
    //   1247: ldc 11
    //   1249: iconst_2
    //   1250: new 184	java/lang/StringBuilder
    //   1253: dup
    //   1254: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   1257: ldc_w 769
    //   1260: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1263: aload 12
    //   1265: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1268: ldc_w 771
    //   1271: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1274: aload 5
    //   1276: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1279: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1282: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1285: iload 14
    //   1287: anewarray 66	java/lang/String
    //   1290: astore 6
    //   1292: iconst_0
    //   1293: istore 13
    //   1295: iload 13
    //   1297: iload 14
    //   1299: if_icmpge +31 -> 1330
    //   1302: aload 6
    //   1304: iload 13
    //   1306: aload_1
    //   1307: iload 13
    //   1309: invokeinterface 255 2 0
    //   1314: checkcast 146	utz
    //   1317: getfield 176	utz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1320: aastore
    //   1321: iload 13
    //   1323: iconst_1
    //   1324: iadd
    //   1325: istore 13
    //   1327: goto -32 -> 1295
    //   1330: aload_0
    //   1331: aload 5
    //   1333: aload 12
    //   1335: aload 6
    //   1337: aload_1
    //   1338: aload_3
    //   1339: invokespecial 757	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/util/List;Lcom/tencent/mobileqq/persistence/EntityManager;)V
    //   1342: goto -158 -> 1184
    //   1345: astore_1
    //   1346: aload_1
    //   1347: invokevirtual 220	java/lang/Exception:printStackTrace	()V
    //   1350: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1353: ifeq +12 -> 1365
    //   1356: ldc 11
    //   1358: iconst_2
    //   1359: ldc_w 773
    //   1362: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1365: aload 10
    //   1367: invokevirtual 763	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   1370: goto -253 -> 1117
    //   1373: astore_1
    //   1374: aload 10
    //   1376: invokevirtual 763	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   1379: aload_1
    //   1380: athrow
    //   1381: astore_1
    //   1382: aload 7
    //   1384: astore 4
    //   1386: goto -663 -> 723
    //   1389: astore_1
    //   1390: aload 9
    //   1392: astore 4
    //   1394: aload 5
    //   1396: astore_3
    //   1397: goto -674 -> 723
    //   1400: astore 5
    //   1402: aload_2
    //   1403: astore 4
    //   1405: aload_1
    //   1406: astore_2
    //   1407: aload 5
    //   1409: astore_1
    //   1410: goto -687 -> 723
    //   1413: astore 5
    //   1415: aconst_null
    //   1416: astore_3
    //   1417: aload_2
    //   1418: astore_1
    //   1419: aload_3
    //   1420: astore_2
    //   1421: aload 4
    //   1423: astore_3
    //   1424: goto -829 -> 595
    //   1427: aconst_null
    //   1428: astore_2
    //   1429: goto +11 -> 1440
    //   1432: aconst_null
    //   1433: astore_2
    //   1434: aload_2
    //   1435: astore 6
    //   1437: goto -1084 -> 353
    //   1440: aload_2
    //   1441: astore 8
    //   1443: goto -960 -> 483
    //   1446: astore 5
    //   1448: aload_2
    //   1449: astore_1
    //   1450: aload 7
    //   1452: astore_2
    //   1453: goto -858 -> 595
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1456	0	this	MigrateSubscribeDB
    //   0	1456	1	paramFile	File
    //   72	1381	2	localObject1	Object
    //   89	1335	3	localObject2	Object
    //   80	1342	4	localObject3	Object
    //   77	1	5	localObject4	Object
    //   589	125	5	localException1	Exception
    //   880	515	5	localObject5	Object
    //   1400	8	5	localObject6	Object
    //   1413	1	5	localException2	Exception
    //   1446	1	5	localException3	Exception
    //   69	1367	6	localObject7	Object
    //   86	1365	7	localSQLiteDatabase	com.tencent.mobileqq.app.SQLiteDatabase
    //   396	1046	8	localObject8	Object
    //   91	1300	9	localObject9	Object
    //   83	1292	10	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   74	744	11	localObject10	Object
    //   188	1146	12	str	String
    //   1293	33	13	i	int
    //   1234	66	14	j	int
    //   63	602	15	l	long
    //   20	942	17	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   93	117	589	java/lang/Exception
    //   117	132	589	java/lang/Exception
    //   171	223	589	java/lang/Exception
    //   223	245	589	java/lang/Exception
    //   245	301	589	java/lang/Exception
    //   301	311	589	java/lang/Exception
    //   314	347	589	java/lang/Exception
    //   353	375	589	java/lang/Exception
    //   375	431	589	java/lang/Exception
    //   431	441	589	java/lang/Exception
    //   444	477	589	java/lang/Exception
    //   488	503	589	java/lang/Exception
    //   542	586	589	java/lang/Exception
    //   691	706	589	java/lang/Exception
    //   751	795	589	java/lang/Exception
    //   802	817	589	java/lang/Exception
    //   824	868	589	java/lang/Exception
    //   868	878	589	java/lang/Exception
    //   93	117	712	finally
    //   117	132	712	finally
    //   171	223	712	finally
    //   223	245	712	finally
    //   245	301	712	finally
    //   301	311	712	finally
    //   314	347	712	finally
    //   353	375	712	finally
    //   375	431	712	finally
    //   431	441	712	finally
    //   444	477	712	finally
    //   488	503	712	finally
    //   542	586	712	finally
    //   691	706	712	finally
    //   751	795	712	finally
    //   802	817	712	finally
    //   824	868	712	finally
    //   868	878	712	finally
    //   1061	1080	1345	java/lang/Exception
    //   1085	1101	1345	java/lang/Exception
    //   1101	1112	1345	java/lang/Exception
    //   1146	1161	1345	java/lang/Exception
    //   1161	1184	1345	java/lang/Exception
    //   1184	1217	1345	java/lang/Exception
    //   1222	1236	1345	java/lang/Exception
    //   1241	1285	1345	java/lang/Exception
    //   1285	1292	1345	java/lang/Exception
    //   1302	1321	1345	java/lang/Exception
    //   1330	1342	1345	java/lang/Exception
    //   1061	1080	1373	finally
    //   1085	1101	1373	finally
    //   1101	1112	1373	finally
    //   1146	1161	1373	finally
    //   1161	1184	1373	finally
    //   1184	1217	1373	finally
    //   1222	1236	1373	finally
    //   1241	1285	1373	finally
    //   1285	1292	1373	finally
    //   1302	1321	1373	finally
    //   1330	1342	1373	finally
    //   1346	1365	1373	finally
    //   920	960	1381	finally
    //   991	1056	1381	finally
    //   1056	1061	1381	finally
    //   1112	1117	1381	finally
    //   1365	1370	1381	finally
    //   1374	1381	1381	finally
    //   886	891	1389	finally
    //   897	903	1389	finally
    //   909	920	1389	finally
    //   595	615	1400	finally
    //   886	891	1413	java/lang/Exception
    //   897	903	1413	java/lang/Exception
    //   909	920	1413	java/lang/Exception
    //   920	960	1446	java/lang/Exception
    //   991	1056	1446	java/lang/Exception
    //   1056	1061	1446	java/lang/Exception
    //   1112	1117	1446	java/lang/Exception
    //   1365	1370	1446	java/lang/Exception
    //   1374	1381	1446	java/lang/Exception
  }
  
  /* Error */
  private String[] a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore_3
    //   8: aload_1
    //   9: ifnonnull +24 -> 33
    //   12: aload_3
    //   13: astore_2
    //   14: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   17: ifeq +14 -> 31
    //   20: ldc 11
    //   22: iconst_2
    //   23: ldc_w 775
    //   26: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   29: aload_3
    //   30: astore_2
    //   31: aload_2
    //   32: areturn
    //   33: invokestatic 100	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   36: astore_2
    //   37: new 94	uty
    //   40: dup
    //   41: aload_0
    //   42: aload_2
    //   43: aload_1
    //   44: bipush 80
    //   46: invokespecial 103	uty:<init>	(Lcom/tencent/mobileqq/startup/step/MigrateSubscribeDB;Landroid/content/Context;Ljava/lang/String;I)V
    //   49: astore 4
    //   51: aload 4
    //   53: invokevirtual 107	uty:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   56: astore_3
    //   57: aload_3
    //   58: ldc_w 777
    //   61: aconst_null
    //   62: invokevirtual 115	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   65: astore_2
    //   66: aload_2
    //   67: ifnull +335 -> 402
    //   70: aload_2
    //   71: astore 6
    //   73: aload_3
    //   74: astore 7
    //   76: aload 4
    //   78: astore 8
    //   80: aload_2
    //   81: invokeinterface 120 1 0
    //   86: ifeq +183 -> 269
    //   89: aload_2
    //   90: astore 6
    //   92: aload_3
    //   93: astore 7
    //   95: aload 4
    //   97: astore 8
    //   99: aload_2
    //   100: invokeinterface 780 1 0
    //   105: anewarray 66	java/lang/String
    //   108: astore_1
    //   109: iconst_0
    //   110: istore 10
    //   112: aload_2
    //   113: astore 6
    //   115: aload_3
    //   116: astore 7
    //   118: aload 4
    //   120: astore 8
    //   122: aload_1
    //   123: iload 10
    //   125: aload_2
    //   126: iconst_0
    //   127: invokeinterface 153 2 0
    //   132: aastore
    //   133: aload_2
    //   134: astore 6
    //   136: aload_3
    //   137: astore 7
    //   139: aload 4
    //   141: astore 8
    //   143: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   146: ifeq +59 -> 205
    //   149: aload_2
    //   150: astore 6
    //   152: aload_3
    //   153: astore 7
    //   155: aload 4
    //   157: astore 8
    //   159: ldc 11
    //   161: iconst_2
    //   162: new 184	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 185	java/lang/StringBuilder:<init>	()V
    //   169: ldc_w 782
    //   172: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: iload 10
    //   177: invokevirtual 199	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   180: ldc_w 784
    //   183: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: aload_1
    //   187: iload 10
    //   189: aaload
    //   190: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: ldc_w 786
    //   196: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   205: iload 10
    //   207: iconst_1
    //   208: iadd
    //   209: istore 10
    //   211: aload_2
    //   212: astore 6
    //   214: aload_3
    //   215: astore 7
    //   217: aload 4
    //   219: astore 8
    //   221: aload_2
    //   222: invokeinterface 211 1 0
    //   227: istore 11
    //   229: iload 11
    //   231: ifne -119 -> 112
    //   234: aload_2
    //   235: ifnull +9 -> 244
    //   238: aload_2
    //   239: invokeinterface 214 1 0
    //   244: aload_3
    //   245: ifnull +7 -> 252
    //   248: aload_3
    //   249: invokevirtual 787	android/database/sqlite/SQLiteDatabase:close	()V
    //   252: aload_1
    //   253: astore_2
    //   254: aload 4
    //   256: ifnull -225 -> 31
    //   259: aload 4
    //   261: invokevirtual 215	uty:close	()V
    //   264: aload_1
    //   265: areturn
    //   266: astore_2
    //   267: aload_1
    //   268: areturn
    //   269: aload 9
    //   271: astore_1
    //   272: aload_2
    //   273: astore 6
    //   275: aload_3
    //   276: astore 7
    //   278: aload 4
    //   280: astore 8
    //   282: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   285: ifeq -51 -> 234
    //   288: aload_2
    //   289: astore 6
    //   291: aload_3
    //   292: astore 7
    //   294: aload 4
    //   296: astore 8
    //   298: ldc 11
    //   300: iconst_2
    //   301: ldc_w 789
    //   304: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   307: aload 9
    //   309: astore_1
    //   310: goto -76 -> 234
    //   313: astore_1
    //   314: aload_2
    //   315: astore 6
    //   317: aload_3
    //   318: astore 7
    //   320: aload 4
    //   322: astore 8
    //   324: aload_1
    //   325: invokevirtual 220	java/lang/Exception:printStackTrace	()V
    //   328: aload_2
    //   329: astore 6
    //   331: aload_3
    //   332: astore 7
    //   334: aload 4
    //   336: astore 8
    //   338: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   341: ifeq +23 -> 364
    //   344: aload_2
    //   345: astore 6
    //   347: aload_3
    //   348: astore 7
    //   350: aload 4
    //   352: astore 8
    //   354: ldc 11
    //   356: iconst_2
    //   357: ldc_w 791
    //   360: aload_1
    //   361: invokestatic 225	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   364: aload_2
    //   365: ifnull +9 -> 374
    //   368: aload_2
    //   369: invokeinterface 214 1 0
    //   374: aload_3
    //   375: ifnull +7 -> 382
    //   378: aload_3
    //   379: invokevirtual 787	android/database/sqlite/SQLiteDatabase:close	()V
    //   382: aload 5
    //   384: astore_2
    //   385: aload 4
    //   387: ifnull -356 -> 31
    //   390: aload 4
    //   392: invokevirtual 215	uty:close	()V
    //   395: aload 5
    //   397: areturn
    //   398: astore_1
    //   399: aload 5
    //   401: areturn
    //   402: aload 9
    //   404: astore_1
    //   405: aload_2
    //   406: astore 6
    //   408: aload_3
    //   409: astore 7
    //   411: aload 4
    //   413: astore 8
    //   415: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   418: ifeq -184 -> 234
    //   421: aload_2
    //   422: astore 6
    //   424: aload_3
    //   425: astore 7
    //   427: aload 4
    //   429: astore 8
    //   431: ldc 11
    //   433: iconst_2
    //   434: ldc_w 793
    //   437: invokestatic 92	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   440: aload 9
    //   442: astore_1
    //   443: goto -209 -> 234
    //   446: astore_1
    //   447: aload 8
    //   449: astore 4
    //   451: aload 7
    //   453: astore_3
    //   454: aload 6
    //   456: astore_2
    //   457: aload_2
    //   458: ifnull +9 -> 467
    //   461: aload_2
    //   462: invokeinterface 214 1 0
    //   467: aload_3
    //   468: ifnull +7 -> 475
    //   471: aload_3
    //   472: invokevirtual 787	android/database/sqlite/SQLiteDatabase:close	()V
    //   475: aload 4
    //   477: ifnull +8 -> 485
    //   480: aload 4
    //   482: invokevirtual 215	uty:close	()V
    //   485: aload_1
    //   486: athrow
    //   487: astore_2
    //   488: goto -244 -> 244
    //   491: astore_2
    //   492: goto -240 -> 252
    //   495: astore_1
    //   496: goto -122 -> 374
    //   499: astore_1
    //   500: goto -118 -> 382
    //   503: astore_2
    //   504: goto -37 -> 467
    //   507: astore_2
    //   508: goto -33 -> 475
    //   511: astore_2
    //   512: goto -27 -> 485
    //   515: astore_1
    //   516: aconst_null
    //   517: astore_2
    //   518: aconst_null
    //   519: astore_3
    //   520: aconst_null
    //   521: astore 4
    //   523: goto -66 -> 457
    //   526: astore_1
    //   527: aconst_null
    //   528: astore_2
    //   529: aconst_null
    //   530: astore_3
    //   531: goto -74 -> 457
    //   534: astore_1
    //   535: aconst_null
    //   536: astore_2
    //   537: goto -80 -> 457
    //   540: astore_1
    //   541: aconst_null
    //   542: astore_2
    //   543: aconst_null
    //   544: astore_3
    //   545: aconst_null
    //   546: astore 4
    //   548: goto -234 -> 314
    //   551: astore_1
    //   552: aconst_null
    //   553: astore_2
    //   554: aconst_null
    //   555: astore_3
    //   556: goto -242 -> 314
    //   559: astore_1
    //   560: aconst_null
    //   561: astore_2
    //   562: goto -248 -> 314
    //   565: astore 6
    //   567: aload_1
    //   568: astore 5
    //   570: aload 6
    //   572: astore_1
    //   573: goto -259 -> 314
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	576	0	this	MigrateSubscribeDB
    //   0	576	1	paramString	String
    //   13	241	2	localObject1	Object
    //   266	103	2	localException1	Exception
    //   384	78	2	localObject2	Object
    //   487	1	2	localException2	Exception
    //   491	1	2	localException3	Exception
    //   503	1	2	localException4	Exception
    //   507	1	2	localException5	Exception
    //   511	1	2	localException6	Exception
    //   517	45	2	localObject3	Object
    //   7	549	3	localObject4	Object
    //   49	498	4	localObject5	Object
    //   4	565	5	localObject6	Object
    //   71	384	6	localObject7	Object
    //   565	6	6	localException7	Exception
    //   74	378	7	localObject8	Object
    //   78	370	8	localObject9	Object
    //   1	440	9	localObject10	Object
    //   110	100	10	i	int
    //   227	3	11	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   259	264	266	java/lang/Exception
    //   80	89	313	java/lang/Exception
    //   99	109	313	java/lang/Exception
    //   282	288	313	java/lang/Exception
    //   298	307	313	java/lang/Exception
    //   415	421	313	java/lang/Exception
    //   431	440	313	java/lang/Exception
    //   390	395	398	java/lang/Exception
    //   80	89	446	finally
    //   99	109	446	finally
    //   122	133	446	finally
    //   143	149	446	finally
    //   159	205	446	finally
    //   221	229	446	finally
    //   282	288	446	finally
    //   298	307	446	finally
    //   324	328	446	finally
    //   338	344	446	finally
    //   354	364	446	finally
    //   415	421	446	finally
    //   431	440	446	finally
    //   238	244	487	java/lang/Exception
    //   248	252	491	java/lang/Exception
    //   368	374	495	java/lang/Exception
    //   378	382	499	java/lang/Exception
    //   461	467	503	java/lang/Exception
    //   471	475	507	java/lang/Exception
    //   480	485	511	java/lang/Exception
    //   37	51	515	finally
    //   51	57	526	finally
    //   57	66	534	finally
    //   37	51	540	java/lang/Exception
    //   51	57	551	java/lang/Exception
    //   57	66	559	java/lang/Exception
    //   122	133	565	java/lang/Exception
    //   143	149	565	java/lang/Exception
    //   159	205	565	java/lang/Exception
    //   221	229	565	java/lang/Exception
  }
  
  private void b()
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("MigrateSubscribeDB", 2, "begin getMigrateDBFiles.");
    }
    long l = System.nanoTime();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.c = new ArrayList();
    Pattern localPattern1 = Pattern.compile("^\\d+\\.db$");
    Pattern localPattern2 = Pattern.compile("^readinjoy_main_\\d+$");
    Pattern localPattern3 = Pattern.compile("^readinjoy_\\d+\\.db$");
    String str1 = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getFilesDir().getPath();
    str1 = str1.substring(0, str1.lastIndexOf("/")) + "/databases";
    Object localObject1 = new File(str1);
    if (QLog.isColorLevel()) {
      QLog.d("MigrateSubscribeDB", 2, "getMigrateDBFiles we will list files in folder: " + str1);
    }
    localObject1 = ((File)localObject1).listFiles();
    if (localObject1 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MigrateSubscribeDB", 2, "getMigrateDBFiles dbFiles length: " + localObject1.length);
      }
      j = localObject1.length;
      while (i < j)
      {
        localObject2 = localObject1[i];
        str2 = ((File)localObject2).getName();
        if (QLog.isColorLevel()) {
          QLog.d("MigrateSubscribeDB", 2, "getMigrateDBFiles find file[" + str2 + "] in folder[" + str1 + "]");
        }
        if (localPattern1.matcher(str2).find())
        {
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
          if (QLog.isColorLevel()) {
            QLog.d("MigrateSubscribeDB", 2, "getMigrateDBFiles mUinMainDBFiles " + localObject2);
          }
        }
        if (localPattern2.matcher(str2).find())
        {
          this.jdField_b_of_type_JavaUtilList.add(localObject2);
          if (QLog.isColorLevel()) {
            QLog.d("MigrateSubscribeDB", 2, "getMigrateDBFiles mReadInJoyMainDBFiles " + localObject2);
          }
        }
        if (localPattern3.matcher(str2).find())
        {
          this.c.add(localObject2);
          if (QLog.isColorLevel()) {
            QLog.d("MigrateSubscribeDB", 2, "getMigrateDBFiles mReadInJoySubDBFiles " + localObject2);
          }
        }
        i += 1;
      }
      Collections.sort(this.jdField_a_of_type_JavaUtilList, new utx(this));
      if (QLog.isColorLevel()) {
        QLog.d("MigrateSubscribeDB", 2, "doStep get Migrate db files cost = " + (System.nanoTime() - l) / 1000000L + "ms");
      }
    }
    while (!QLog.isColorLevel())
    {
      int j;
      Object localObject2;
      String str2;
      return;
    }
    QLog.d("MigrateSubscribeDB", 2, "getMigrateDBFiles dbFiles is null");
  }
  
  private void b(List paramList, EntityManager paramEntityManager)
  {
    long l = System.nanoTime();
    if (paramList == null) {
      if (QLog.isColorLevel()) {
        QLog.d("MigrateSubscribeDB", 2, "migrateToCoversationInfo fail subscribeRecentDataList is null");
      }
    }
    label269:
    label339:
    label359:
    do
    {
      return;
      int i = paramList.size();
      if (QLog.isColorLevel()) {
        QLog.d("MigrateSubscribeDB", 2, "migrateToCoversationInfo subscribeRecentDataList list size: " + i);
      }
      i = 0;
      if (i < paramList.size())
      {
        utz localutz = (utz)paramList.get(i);
        if (QLog.isColorLevel()) {
          QLog.d("MigrateSubscribeDB", 2, "migrateToCoversationInfo subscribeRecentData: " + localutz);
        }
        String str = SubscriptUtil.a(localutz.jdField_a_of_type_JavaLangString);
        ConversationInfo localConversationInfo;
        int j;
        if (!TextUtils.isEmpty(str))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MigrateSubscribeDB", 2, "migrateToCoversationInfo find subscribeID[" + localutz.jdField_a_of_type_JavaLangString + "]'s uin: " + str);
          }
          localConversationInfo = new ConversationInfo();
          List localList = paramEntityManager.a(ConversationInfo.class, false, "uin=? and type=?", new String[] { str, String.valueOf(1008) }, null, null, null, null);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder().append("migrateToCoversationInfo dataList size: ");
            if (localList != null)
            {
              j = localList.size();
              QLog.d("MigrateSubscribeDB", 2, j);
            }
          }
          else
          {
            if ((localList == null) || (localList.size() <= 0)) {
              break label359;
            }
            localConversationInfo = (ConversationInfo)localList.get(0);
            localConversationInfo.uin = str;
            localConversationInfo.unreadCount += localutz.jdField_a_of_type_Int;
            localConversationInfo.type = 1008;
            paramEntityManager.b(localConversationInfo);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          j = 0;
          break label269;
          localConversationInfo.uin = str;
          localConversationInfo.unreadCount = localutz.jdField_a_of_type_Int;
          localConversationInfo.type = 1008;
          break label339;
          if (QLog.isColorLevel()) {
            QLog.d("MigrateSubscribeDB", 2, "migrateToCoversationInfo we can't subscribeid[" + localutz.jdField_a_of_type_JavaLangString + "]'s uin");
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("MigrateSubscribeDB", 2, "migrateToCoversationInfo total cost = " + (System.nanoTime() - l) / 1000000L + " ms ");
  }
  
  public static boolean b()
  {
    boolean bool2 = false;
    boolean bool1;
    if (!jdField_a_of_type_Boolean)
    {
      String str = BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getSharedPreferences("contact_bind_info_global", 0).getString("last_phone_version_popped", "");
      if (QLog.isColorLevel()) {
        QLog.d("MigrateSubscribeDB", 2, "isNeedUpdate oldVersion: " + str + " : curVersion: " + "6.5.5");
      }
      if (!TextUtils.isEmpty(str)) {
        if (str.startsWith("5.7")) {
          bool1 = true;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MigrateSubscribeDB", 2, "isNeedUpdate isNeed: " + bool1);
      }
      return bool1;
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("MigrateSubscribeDB", 2, "isNeedUpdate oldVersion isn't start with 5.7");
        bool1 = bool2;
        continue;
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("MigrateSubscribeDB", 2, "isNeedUpdate oldVersion is empty");
          bool1 = bool2;
          continue;
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            QLog.d("MigrateSubscribeDB", 2, "isNeedUpdate no need run again");
            bool1 = bool2;
          }
        }
      }
    }
  }
  
  private void c(List paramList, EntityManager paramEntityManager)
  {
    long l = System.nanoTime();
    if (paramList == null) {}
    do
    {
      return;
      int i = 0;
      while (i < paramList.size())
      {
        paramEntityManager.b((MessageRecord)paramList.get(i));
        i += 1;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MigrateSubscribeDB", 2, "migrateToMsgRecord total cost = " + (System.nanoTime() - l) / 1000000L + " ms ");
  }
  
  protected boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MigrateSubscribeDB", 2, "begin do Step for MigrateSubscribeDB." + BaseApplicationImpl.i);
    }
    if (!b())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MigrateSubscribeDB", 2, "No need do update action");
      }
      return super.a();
    }
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl = BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
    if (this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MigrateSubscribeDB", 2, "doStep fail app is null");
      }
      return super.a();
    }
    jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 40000;
    long l = System.nanoTime();
    b();
    Iterator localIterator;
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      a();
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    }
    for (;;)
    {
      File localFile;
      if (localIterator.hasNext())
      {
        localFile = (File)localIterator.next();
        if (this.jdField_b_of_type_Boolean) {
          break label249;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MigrateSubscribeDB", 2, "doStep foreach mUinMainDBFiles，but timeout！");
        }
      }
      label249:
      while (!a(localFile))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MigrateSubscribeDB", 2, "doStep Migrate subscribe db total cost = " + (System.nanoTime() - l) / 1000000L + " ms " + " and Migrate " + this.jdField_a_of_type_Long + " times ");
        }
        return super.a();
      }
      this.jdField_a_of_type_Long += 1L;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\startup\step\MigrateSubscribeDB.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */