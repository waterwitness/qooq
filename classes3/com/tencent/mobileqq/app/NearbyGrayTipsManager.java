package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.message.MsgProxy;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import mqq.manager.Manager;
import qbk;

public class NearbyGrayTipsManager
  implements Manager
{
  public static final int a = 1;
  public static final String a = ".conf";
  public static final int b = 2;
  public static final String b = "nearby_max_count_in_one_day";
  public static final int c = 3;
  public static final String c = "nearby_mark_day_time";
  public static final int d = 4;
  private long jdField_a_of_type_Long;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private List jdField_a_of_type_JavaUtilList;
  private Random jdField_a_of_type_JavaUtilRandom;
  private boolean jdField_a_of_type_Boolean;
  private List jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean;
  private int e;
  private int f;
  private int g;
  private int h;
  
  public NearbyGrayTipsManager(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilList = new ArrayList(2);
    this.jdField_b_of_type_JavaUtilList = new ArrayList(2);
    this.jdField_a_of_type_JavaUtilRandom = new Random();
    this.jdField_a_of_type_JavaUtilRandom.setSeed(System.currentTimeMillis());
  }
  
  /* Error */
  public static NearbyGrayTipsManager.GrayTipsConfig a(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokevirtual 85	java/io/File:exists	()Z
    //   8: ifne +7 -> 15
    //   11: aconst_null
    //   12: astore_1
    //   13: aload_1
    //   14: areturn
    //   15: new 87	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   22: astore 6
    //   24: new 90	java/io/FileReader
    //   27: dup
    //   28: aload_0
    //   29: invokespecial 93	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   32: astore_0
    //   33: new 95	java/io/BufferedReader
    //   36: dup
    //   37: aload_0
    //   38: invokespecial 98	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   41: astore_3
    //   42: aload_0
    //   43: astore_2
    //   44: aload_3
    //   45: astore_1
    //   46: aload_3
    //   47: invokevirtual 102	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   50: astore 4
    //   52: aload 4
    //   54: ifnull +380 -> 434
    //   57: aload_0
    //   58: astore_2
    //   59: aload_3
    //   60: astore_1
    //   61: aload 6
    //   63: aload 4
    //   65: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: goto -27 -> 42
    //   72: astore 4
    //   74: aload_0
    //   75: astore_2
    //   76: aload_3
    //   77: astore_1
    //   78: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   81: ifeq +15 -> 96
    //   84: aload_0
    //   85: astore_2
    //   86: aload_3
    //   87: astore_1
    //   88: ldc 113
    //   90: iconst_2
    //   91: ldc 115
    //   93: invokestatic 118	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   96: aload_0
    //   97: astore_2
    //   98: aload_3
    //   99: astore_1
    //   100: aload 4
    //   102: invokevirtual 121	java/io/FileNotFoundException:printStackTrace	()V
    //   105: aload_3
    //   106: ifnull +7 -> 113
    //   109: aload_3
    //   110: invokevirtual 124	java/io/BufferedReader:close	()V
    //   113: aload_0
    //   114: ifnull +7 -> 121
    //   117: aload_0
    //   118: invokevirtual 125	java/io/FileReader:close	()V
    //   121: aload 6
    //   123: invokevirtual 129	java/lang/StringBuilder:length	()I
    //   126: ifle +1403 -> 1529
    //   129: new 131	org/json/JSONObject
    //   132: dup
    //   133: aload 6
    //   135: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokespecial 137	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   141: astore_2
    //   142: new 139	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig
    //   145: dup
    //   146: invokespecial 140	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig:<init>	()V
    //   149: astore_0
    //   150: aload_2
    //   151: ldc -114
    //   153: invokevirtual 146	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   156: ifne +17 -> 173
    //   159: aload_0
    //   160: aload_2
    //   161: ldc -114
    //   163: invokevirtual 150	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   166: ldc2_w 151
    //   169: lmul
    //   170: putfield 155	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig:createTime	J
    //   173: aload_2
    //   174: ldc -99
    //   176: invokevirtual 146	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   179: ifne +13 -> 192
    //   182: aload_0
    //   183: aload_2
    //   184: ldc -99
    //   186: invokevirtual 160	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   189: putfield 163	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig:grayTipsEnable	Z
    //   192: aload_2
    //   193: ldc -91
    //   195: invokevirtual 146	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   198: ifne +13 -> 211
    //   201: aload_0
    //   202: aload_2
    //   203: ldc -91
    //   205: invokevirtual 169	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   208: putfield 172	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig:global_MaxTipsCountPerDay	I
    //   211: aload_2
    //   212: ldc -82
    //   214: invokevirtual 146	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   217: ifne +48 -> 265
    //   220: aload_2
    //   221: ldc -82
    //   223: invokevirtual 178	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   226: astore_1
    //   227: aload_1
    //   228: ldc -76
    //   230: invokevirtual 146	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   233: ifne +13 -> 246
    //   236: aload_0
    //   237: aload_1
    //   238: ldc -76
    //   240: invokevirtual 169	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   243: putfield 183	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig:maxTipsCount	I
    //   246: aload_1
    //   247: ldc -71
    //   249: invokevirtual 146	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   252: ifne +13 -> 265
    //   255: aload_0
    //   256: aload_1
    //   257: ldc -71
    //   259: invokevirtual 169	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   262: putfield 188	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig:messageCount	I
    //   265: aload_0
    //   266: astore_1
    //   267: aload_2
    //   268: ldc -66
    //   270: invokevirtual 146	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   273: ifne -260 -> 13
    //   276: aload_2
    //   277: ldc -66
    //   279: invokevirtual 178	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   282: astore_2
    //   283: aload_2
    //   284: ldc -64
    //   286: invokevirtual 146	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   289: ifne +13 -> 302
    //   292: aload_0
    //   293: aload_2
    //   294: ldc -64
    //   296: invokevirtual 169	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   299: putfield 195	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig:id	I
    //   302: aload_2
    //   303: ldc -59
    //   305: invokevirtual 146	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   308: ifne +13 -> 321
    //   311: aload_0
    //   312: aload_2
    //   313: ldc -59
    //   315: invokevirtual 169	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   318: putfield 200	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig:priority	I
    //   321: aload_2
    //   322: ldc -82
    //   324: invokevirtual 146	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   327: ifne +48 -> 375
    //   330: aload_2
    //   331: ldc -82
    //   333: invokevirtual 178	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   336: astore_1
    //   337: aload_1
    //   338: ldc -54
    //   340: invokevirtual 146	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   343: ifne +13 -> 356
    //   346: aload_0
    //   347: aload_1
    //   348: ldc -54
    //   350: invokevirtual 169	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   353: putfield 205	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig:singleTask_MaxTipsCountPerDay	I
    //   356: aload_1
    //   357: ldc -49
    //   359: invokevirtual 146	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   362: ifne +13 -> 375
    //   365: aload_0
    //   366: aload_1
    //   367: ldc -49
    //   369: invokevirtual 169	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   372: putfield 210	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig:singleTask_maxTipsCount	I
    //   375: aload_2
    //   376: ldc -44
    //   378: invokevirtual 146	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   381: ifne +226 -> 607
    //   384: aload_2
    //   385: ldc -44
    //   387: invokevirtual 216	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   390: astore_1
    //   391: new 44	java/util/ArrayList
    //   394: dup
    //   395: invokespecial 45	java/util/ArrayList:<init>	()V
    //   398: astore_3
    //   399: iconst_0
    //   400: istore 7
    //   402: iload 7
    //   404: aload_1
    //   405: invokevirtual 219	org/json/JSONArray:length	()I
    //   408: if_icmpge +194 -> 602
    //   411: aload_3
    //   412: aload_1
    //   413: iload 7
    //   415: invokevirtual 222	org/json/JSONArray:getInt	(I)I
    //   418: invokestatic 228	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   421: invokevirtual 232	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   424: pop
    //   425: iload 7
    //   427: iconst_1
    //   428: iadd
    //   429: istore 7
    //   431: goto -29 -> 402
    //   434: aload_3
    //   435: ifnull +7 -> 442
    //   438: aload_3
    //   439: invokevirtual 124	java/io/BufferedReader:close	()V
    //   442: aload_0
    //   443: ifnull -322 -> 121
    //   446: aload_0
    //   447: invokevirtual 125	java/io/FileReader:close	()V
    //   450: goto -329 -> 121
    //   453: astore_0
    //   454: aload_0
    //   455: invokevirtual 233	java/io/IOException:printStackTrace	()V
    //   458: goto -337 -> 121
    //   461: astore_1
    //   462: aload_1
    //   463: invokevirtual 233	java/io/IOException:printStackTrace	()V
    //   466: goto -24 -> 442
    //   469: astore_1
    //   470: aload_1
    //   471: invokevirtual 233	java/io/IOException:printStackTrace	()V
    //   474: goto -361 -> 113
    //   477: astore_0
    //   478: aload_0
    //   479: invokevirtual 233	java/io/IOException:printStackTrace	()V
    //   482: goto -361 -> 121
    //   485: astore 5
    //   487: aconst_null
    //   488: astore 4
    //   490: aconst_null
    //   491: astore_0
    //   492: aload 4
    //   494: astore_2
    //   495: aload_0
    //   496: astore_1
    //   497: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   500: ifeq +16 -> 516
    //   503: aload 4
    //   505: astore_2
    //   506: aload_0
    //   507: astore_1
    //   508: ldc 113
    //   510: iconst_2
    //   511: ldc -21
    //   513: invokestatic 118	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   516: aload 4
    //   518: astore_2
    //   519: aload_0
    //   520: astore_1
    //   521: aload 5
    //   523: invokevirtual 233	java/io/IOException:printStackTrace	()V
    //   526: aload_0
    //   527: ifnull +7 -> 534
    //   530: aload_0
    //   531: invokevirtual 124	java/io/BufferedReader:close	()V
    //   534: aload 4
    //   536: ifnull -415 -> 121
    //   539: aload 4
    //   541: invokevirtual 125	java/io/FileReader:close	()V
    //   544: goto -423 -> 121
    //   547: astore_0
    //   548: aload_0
    //   549: invokevirtual 233	java/io/IOException:printStackTrace	()V
    //   552: goto -431 -> 121
    //   555: astore_0
    //   556: aload_0
    //   557: invokevirtual 233	java/io/IOException:printStackTrace	()V
    //   560: goto -26 -> 534
    //   563: astore_3
    //   564: aconst_null
    //   565: astore_0
    //   566: aconst_null
    //   567: astore_1
    //   568: aload_1
    //   569: ifnull +7 -> 576
    //   572: aload_1
    //   573: invokevirtual 124	java/io/BufferedReader:close	()V
    //   576: aload_0
    //   577: ifnull +7 -> 584
    //   580: aload_0
    //   581: invokevirtual 125	java/io/FileReader:close	()V
    //   584: aload_3
    //   585: athrow
    //   586: astore_1
    //   587: aload_1
    //   588: invokevirtual 233	java/io/IOException:printStackTrace	()V
    //   591: goto -15 -> 576
    //   594: astore_0
    //   595: aload_0
    //   596: invokevirtual 233	java/io/IOException:printStackTrace	()V
    //   599: goto -15 -> 584
    //   602: aload_0
    //   603: aload_3
    //   604: putfield 238	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig:aioTypes	Ljava/util/ArrayList;
    //   607: aload_2
    //   608: ldc -16
    //   610: invokevirtual 146	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   613: ifne +58 -> 671
    //   616: aload_2
    //   617: ldc -16
    //   619: invokevirtual 216	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   622: astore_1
    //   623: new 44	java/util/ArrayList
    //   626: dup
    //   627: invokespecial 45	java/util/ArrayList:<init>	()V
    //   630: astore_3
    //   631: iconst_0
    //   632: istore 7
    //   634: iload 7
    //   636: aload_1
    //   637: invokevirtual 219	org/json/JSONArray:length	()I
    //   640: if_icmpge +26 -> 666
    //   643: aload_3
    //   644: aload_1
    //   645: iload 7
    //   647: invokevirtual 222	org/json/JSONArray:getInt	(I)I
    //   650: invokestatic 228	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   653: invokevirtual 232	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   656: pop
    //   657: iload 7
    //   659: iconst_1
    //   660: iadd
    //   661: istore 7
    //   663: goto -29 -> 634
    //   666: aload_0
    //   667: aload_3
    //   668: putfield 243	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig:sexTypes	Ljava/util/ArrayList;
    //   671: aload_2
    //   672: ldc -11
    //   674: invokevirtual 146	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   677: ifne +13 -> 690
    //   680: aload_0
    //   681: aload_2
    //   682: ldc -11
    //   684: invokevirtual 160	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   687: putfield 248	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig:timeRangeControl	Z
    //   690: aload_2
    //   691: ldc -6
    //   693: invokevirtual 146	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   696: ifne +108 -> 804
    //   699: aload_2
    //   700: ldc -6
    //   702: invokevirtual 216	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   705: astore_1
    //   706: new 44	java/util/ArrayList
    //   709: dup
    //   710: invokespecial 45	java/util/ArrayList:<init>	()V
    //   713: astore_3
    //   714: iconst_0
    //   715: istore 7
    //   717: iload 7
    //   719: aload_1
    //   720: invokevirtual 219	org/json/JSONArray:length	()I
    //   723: if_icmpge +76 -> 799
    //   726: aload_1
    //   727: iload 7
    //   729: invokevirtual 253	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   732: astore 4
    //   734: aload 4
    //   736: ldc -1
    //   738: invokevirtual 146	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   741: ifne +790 -> 1531
    //   744: aload 4
    //   746: ldc_w 257
    //   749: invokevirtual 146	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   752: ifne +779 -> 1531
    //   755: new 259	com/tencent/mobileqq/app/NearbyGrayTipsManager$TimeRangeInOneDay
    //   758: dup
    //   759: invokespecial 260	com/tencent/mobileqq/app/NearbyGrayTipsManager$TimeRangeInOneDay:<init>	()V
    //   762: astore 5
    //   764: aload 5
    //   766: aload 4
    //   768: ldc -1
    //   770: invokevirtual 169	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   773: putfield 263	com/tencent/mobileqq/app/NearbyGrayTipsManager$TimeRangeInOneDay:beginTime	I
    //   776: aload 5
    //   778: aload 4
    //   780: ldc_w 257
    //   783: invokevirtual 169	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   786: putfield 266	com/tencent/mobileqq/app/NearbyGrayTipsManager$TimeRangeInOneDay:endTime	I
    //   789: aload_3
    //   790: aload 5
    //   792: invokevirtual 232	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   795: pop
    //   796: goto +735 -> 1531
    //   799: aload_0
    //   800: aload_3
    //   801: putfield 269	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig:timeRange	Ljava/util/ArrayList;
    //   804: aload_2
    //   805: ldc_w 271
    //   808: invokevirtual 146	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   811: ifne +14 -> 825
    //   814: aload_0
    //   815: aload_2
    //   816: ldc_w 271
    //   819: invokevirtual 160	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   822: putfield 274	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig:showKeyboard	Z
    //   825: aload_2
    //   826: ldc_w 276
    //   829: invokevirtual 146	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   832: ifne +14 -> 846
    //   835: aload_0
    //   836: aload_2
    //   837: ldc_w 276
    //   840: invokevirtual 280	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   843: putfield 283	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig:url	Ljava/lang/String;
    //   846: aload_2
    //   847: ldc_w 285
    //   850: invokevirtual 146	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   853: ifne +111 -> 964
    //   856: aload_2
    //   857: ldc_w 285
    //   860: invokevirtual 216	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   863: astore_1
    //   864: new 44	java/util/ArrayList
    //   867: dup
    //   868: invokespecial 45	java/util/ArrayList:<init>	()V
    //   871: astore_3
    //   872: iconst_0
    //   873: istore 7
    //   875: iload 7
    //   877: aload_1
    //   878: invokevirtual 219	org/json/JSONArray:length	()I
    //   881: if_icmpge +78 -> 959
    //   884: aload_1
    //   885: iload 7
    //   887: invokevirtual 253	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   890: astore 4
    //   892: aload 4
    //   894: ldc_w 287
    //   897: invokevirtual 146	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   900: ifne +640 -> 1540
    //   903: new 289	com/tencent/mobileqq/app/NearbyGrayTipsManager$Wording
    //   906: dup
    //   907: invokespecial 290	com/tencent/mobileqq/app/NearbyGrayTipsManager$Wording:<init>	()V
    //   910: astore 5
    //   912: aload 5
    //   914: aload 4
    //   916: ldc_w 287
    //   919: invokevirtual 280	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   922: putfield 293	com/tencent/mobileqq/app/NearbyGrayTipsManager$Wording:text	Ljava/lang/String;
    //   925: aload 4
    //   927: ldc_w 295
    //   930: invokevirtual 146	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   933: ifne +16 -> 949
    //   936: aload 5
    //   938: aload 4
    //   940: ldc_w 295
    //   943: invokevirtual 280	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   946: putfield 298	com/tencent/mobileqq/app/NearbyGrayTipsManager$Wording:highlightText	Ljava/lang/String;
    //   949: aload_3
    //   950: aload 5
    //   952: invokevirtual 232	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   955: pop
    //   956: goto +584 -> 1540
    //   959: aload_0
    //   960: aload_3
    //   961: putfield 301	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig:grayTipWordings	Ljava/util/ArrayList;
    //   964: aload_2
    //   965: ldc_w 303
    //   968: invokevirtual 146	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   971: ifne +14 -> 985
    //   974: aload_0
    //   975: aload_2
    //   976: ldc_w 303
    //   979: invokevirtual 169	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   982: putfield 306	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig:sceneId	I
    //   985: aload_2
    //   986: ldc_w 308
    //   989: invokevirtual 146	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   992: ifne +56 -> 1048
    //   995: aload_2
    //   996: ldc_w 308
    //   999: invokevirtual 216	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1002: astore_1
    //   1003: new 44	java/util/ArrayList
    //   1006: dup
    //   1007: invokespecial 45	java/util/ArrayList:<init>	()V
    //   1010: astore_3
    //   1011: iconst_0
    //   1012: istore 7
    //   1014: iload 7
    //   1016: aload_1
    //   1017: invokevirtual 219	org/json/JSONArray:length	()I
    //   1020: if_icmpge +23 -> 1043
    //   1023: aload_3
    //   1024: aload_1
    //   1025: iload 7
    //   1027: invokevirtual 311	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   1030: invokevirtual 232	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1033: pop
    //   1034: iload 7
    //   1036: iconst_1
    //   1037: iadd
    //   1038: istore 7
    //   1040: goto -26 -> 1014
    //   1043: aload_0
    //   1044: aload_3
    //   1045: putfield 314	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig:randomWordings	Ljava/util/ArrayList;
    //   1048: aload_2
    //   1049: ldc_w 316
    //   1052: invokevirtual 146	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   1055: ifne +45 -> 1100
    //   1058: aload_2
    //   1059: ldc_w 316
    //   1062: invokevirtual 178	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1065: astore_1
    //   1066: new 318	com/tencent/mobileqq/app/NearbyGrayTipsManager$SceneOne
    //   1069: dup
    //   1070: invokespecial 319	com/tencent/mobileqq/app/NearbyGrayTipsManager$SceneOne:<init>	()V
    //   1073: astore_3
    //   1074: aload_1
    //   1075: ldc_w 321
    //   1078: invokevirtual 146	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   1081: ifne +14 -> 1095
    //   1084: aload_3
    //   1085: aload_1
    //   1086: ldc_w 321
    //   1089: invokevirtual 160	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   1092: putfield 324	com/tencent/mobileqq/app/NearbyGrayTipsManager$SceneOne:sayHiTrigger	Z
    //   1095: aload_0
    //   1096: aload_3
    //   1097: putfield 328	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig:sceneOne	Lcom/tencent/mobileqq/app/NearbyGrayTipsManager$SceneOne;
    //   1100: aload_2
    //   1101: ldc_w 330
    //   1104: invokevirtual 146	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   1107: ifne +87 -> 1194
    //   1110: aload_2
    //   1111: ldc_w 330
    //   1114: invokevirtual 178	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1117: astore_1
    //   1118: new 332	com/tencent/mobileqq/app/NearbyGrayTipsManager$SceneTwo
    //   1121: dup
    //   1122: invokespecial 333	com/tencent/mobileqq/app/NearbyGrayTipsManager$SceneTwo:<init>	()V
    //   1125: astore_3
    //   1126: aload_1
    //   1127: ldc_w 335
    //   1130: invokevirtual 146	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   1133: ifne +56 -> 1189
    //   1136: aload_3
    //   1137: aload_1
    //   1138: ldc_w 335
    //   1141: invokevirtual 160	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   1144: putfield 338	com/tencent/mobileqq/app/NearbyGrayTipsManager$SceneTwo:sayHiFrequencyControl	Z
    //   1147: aload_1
    //   1148: ldc_w 340
    //   1151: invokevirtual 146	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   1154: ifne +14 -> 1168
    //   1157: aload_3
    //   1158: aload_1
    //   1159: ldc_w 340
    //   1162: invokevirtual 169	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1165: putfield 342	com/tencent/mobileqq/app/NearbyGrayTipsManager$SceneTwo:timeRange	I
    //   1168: aload_1
    //   1169: ldc_w 344
    //   1172: invokevirtual 146	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   1175: ifne +14 -> 1189
    //   1178: aload_3
    //   1179: aload_1
    //   1180: ldc_w 344
    //   1183: invokevirtual 169	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1186: putfield 347	com/tencent/mobileqq/app/NearbyGrayTipsManager$SceneTwo:sayHiPeopleCount	I
    //   1189: aload_0
    //   1190: aload_3
    //   1191: putfield 351	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig:sceneTwo	Lcom/tencent/mobileqq/app/NearbyGrayTipsManager$SceneTwo;
    //   1194: aload_2
    //   1195: ldc_w 353
    //   1198: invokevirtual 146	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   1201: ifne +183 -> 1384
    //   1204: aload_2
    //   1205: ldc_w 353
    //   1208: invokevirtual 178	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1211: astore_3
    //   1212: aload_3
    //   1213: ldc_w 355
    //   1216: invokevirtual 146	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   1219: ifne +165 -> 1384
    //   1222: new 357	com/tencent/mobileqq/app/NearbyGrayTipsManager$SceneThree
    //   1225: dup
    //   1226: invokespecial 358	com/tencent/mobileqq/app/NearbyGrayTipsManager$SceneThree:<init>	()V
    //   1229: astore_1
    //   1230: aload_1
    //   1231: aload_3
    //   1232: ldc_w 355
    //   1235: invokevirtual 160	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   1238: putfield 361	com/tencent/mobileqq/app/NearbyGrayTipsManager$SceneThree:keywordTrigger	Z
    //   1241: aload_3
    //   1242: ldc_w 363
    //   1245: invokevirtual 146	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   1248: ifne +65 -> 1313
    //   1251: aload_3
    //   1252: ldc_w 363
    //   1255: invokevirtual 216	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1258: astore 4
    //   1260: new 44	java/util/ArrayList
    //   1263: dup
    //   1264: invokespecial 45	java/util/ArrayList:<init>	()V
    //   1267: astore 5
    //   1269: iconst_0
    //   1270: istore 7
    //   1272: iload 7
    //   1274: aload 4
    //   1276: invokevirtual 219	org/json/JSONArray:length	()I
    //   1279: if_icmpge +28 -> 1307
    //   1282: aload 5
    //   1284: aload 4
    //   1286: iload 7
    //   1288: invokevirtual 222	org/json/JSONArray:getInt	(I)I
    //   1291: invokestatic 228	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1294: invokevirtual 232	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1297: pop
    //   1298: iload 7
    //   1300: iconst_1
    //   1301: iadd
    //   1302: istore 7
    //   1304: goto -32 -> 1272
    //   1307: aload_1
    //   1308: aload 5
    //   1310: putfield 366	com/tencent/mobileqq/app/NearbyGrayTipsManager$SceneThree:whichSide	Ljava/util/ArrayList;
    //   1313: aload_3
    //   1314: ldc_w 368
    //   1317: invokevirtual 146	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   1320: ifne +59 -> 1379
    //   1323: aload_3
    //   1324: ldc_w 368
    //   1327: invokevirtual 216	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1330: astore_3
    //   1331: new 44	java/util/ArrayList
    //   1334: dup
    //   1335: invokespecial 45	java/util/ArrayList:<init>	()V
    //   1338: astore 4
    //   1340: iconst_0
    //   1341: istore 7
    //   1343: iload 7
    //   1345: aload_3
    //   1346: invokevirtual 219	org/json/JSONArray:length	()I
    //   1349: if_icmpge +24 -> 1373
    //   1352: aload 4
    //   1354: aload_3
    //   1355: iload 7
    //   1357: invokevirtual 311	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   1360: invokevirtual 232	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1363: pop
    //   1364: iload 7
    //   1366: iconst_1
    //   1367: iadd
    //   1368: istore 7
    //   1370: goto -27 -> 1343
    //   1373: aload_1
    //   1374: aload 4
    //   1376: putfield 371	com/tencent/mobileqq/app/NearbyGrayTipsManager$SceneThree:keywords	Ljava/util/ArrayList;
    //   1379: aload_0
    //   1380: aload_1
    //   1381: putfield 375	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig:sceneThree	Lcom/tencent/mobileqq/app/NearbyGrayTipsManager$SceneThree;
    //   1384: aload_0
    //   1385: astore_1
    //   1386: aload_2
    //   1387: ldc_w 377
    //   1390: invokevirtual 146	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   1393: ifne -1380 -> 13
    //   1396: aload_2
    //   1397: ldc_w 377
    //   1400: invokevirtual 178	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1403: astore_1
    //   1404: new 379	com/tencent/mobileqq/app/NearbyGrayTipsManager$SceneFour
    //   1407: dup
    //   1408: invokespecial 380	com/tencent/mobileqq/app/NearbyGrayTipsManager$SceneFour:<init>	()V
    //   1411: astore_2
    //   1412: aload_2
    //   1413: aload_1
    //   1414: ldc_w 382
    //   1417: invokevirtual 160	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   1420: putfield 385	com/tencent/mobileqq/app/NearbyGrayTipsManager$SceneFour:enterAIOTrigger	Z
    //   1423: aload_0
    //   1424: aload_2
    //   1425: putfield 389	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig:sceneFour	Lcom/tencent/mobileqq/app/NearbyGrayTipsManager$SceneFour;
    //   1428: aload_0
    //   1429: areturn
    //   1430: astore_1
    //   1431: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1434: ifeq +33 -> 1467
    //   1437: ldc 113
    //   1439: iconst_2
    //   1440: new 87	java/lang/StringBuilder
    //   1443: dup
    //   1444: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   1447: ldc_w 391
    //   1450: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1453: aload 6
    //   1455: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1458: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1461: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1464: invokestatic 118	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1467: aload_1
    //   1468: invokevirtual 392	org/json/JSONException:printStackTrace	()V
    //   1471: aload_0
    //   1472: areturn
    //   1473: astore_1
    //   1474: aconst_null
    //   1475: astore_0
    //   1476: goto -45 -> 1431
    //   1479: astore_3
    //   1480: aconst_null
    //   1481: astore_1
    //   1482: goto -914 -> 568
    //   1485: astore_3
    //   1486: aload_2
    //   1487: astore_0
    //   1488: goto -920 -> 568
    //   1491: astore 5
    //   1493: aconst_null
    //   1494: astore_1
    //   1495: aload_0
    //   1496: astore 4
    //   1498: aload_1
    //   1499: astore_0
    //   1500: goto -1008 -> 492
    //   1503: astore 5
    //   1505: aload_0
    //   1506: astore 4
    //   1508: aload_3
    //   1509: astore_0
    //   1510: goto -1018 -> 492
    //   1513: astore 4
    //   1515: aconst_null
    //   1516: astore_0
    //   1517: aconst_null
    //   1518: astore_3
    //   1519: goto -1445 -> 74
    //   1522: astore 4
    //   1524: aconst_null
    //   1525: astore_3
    //   1526: goto -1452 -> 74
    //   1529: aconst_null
    //   1530: areturn
    //   1531: iload 7
    //   1533: iconst_1
    //   1534: iadd
    //   1535: istore 7
    //   1537: goto -820 -> 717
    //   1540: iload 7
    //   1542: iconst_1
    //   1543: iadd
    //   1544: istore 7
    //   1546: goto -671 -> 875
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1549	0	paramFile	File
    //   12	401	1	localObject1	Object
    //   461	2	1	localIOException1	java.io.IOException
    //   469	2	1	localIOException2	java.io.IOException
    //   496	77	1	localFile	File
    //   586	2	1	localIOException3	java.io.IOException
    //   622	792	1	localObject2	Object
    //   1430	38	1	localJSONException1	org.json.JSONException
    //   1473	1	1	localJSONException2	org.json.JSONException
    //   1481	18	1	localObject3	Object
    //   43	1444	2	localObject4	Object
    //   41	398	3	localObject5	Object
    //   563	41	3	localArrayList	ArrayList
    //   630	725	3	localObject6	Object
    //   1479	1	3	localObject7	Object
    //   1485	24	3	localObject8	Object
    //   1518	8	3	localObject9	Object
    //   50	14	4	str	String
    //   72	29	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   488	1019	4	localObject10	Object
    //   1513	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   1522	1	4	localFileNotFoundException3	java.io.FileNotFoundException
    //   485	37	5	localIOException4	java.io.IOException
    //   762	547	5	localObject11	Object
    //   1491	1	5	localIOException5	java.io.IOException
    //   1503	1	5	localIOException6	java.io.IOException
    //   22	1432	6	localStringBuilder	StringBuilder
    //   400	1145	7	i	int
    // Exception table:
    //   from	to	target	type
    //   46	52	72	java/io/FileNotFoundException
    //   61	69	72	java/io/FileNotFoundException
    //   446	450	453	java/io/IOException
    //   438	442	461	java/io/IOException
    //   109	113	469	java/io/IOException
    //   117	121	477	java/io/IOException
    //   24	33	485	java/io/IOException
    //   539	544	547	java/io/IOException
    //   530	534	555	java/io/IOException
    //   24	33	563	finally
    //   572	576	586	java/io/IOException
    //   580	584	594	java/io/IOException
    //   150	173	1430	org/json/JSONException
    //   173	192	1430	org/json/JSONException
    //   192	211	1430	org/json/JSONException
    //   211	246	1430	org/json/JSONException
    //   246	265	1430	org/json/JSONException
    //   267	302	1430	org/json/JSONException
    //   302	321	1430	org/json/JSONException
    //   321	356	1430	org/json/JSONException
    //   356	375	1430	org/json/JSONException
    //   375	399	1430	org/json/JSONException
    //   402	425	1430	org/json/JSONException
    //   602	607	1430	org/json/JSONException
    //   607	631	1430	org/json/JSONException
    //   634	657	1430	org/json/JSONException
    //   666	671	1430	org/json/JSONException
    //   671	690	1430	org/json/JSONException
    //   690	714	1430	org/json/JSONException
    //   717	796	1430	org/json/JSONException
    //   799	804	1430	org/json/JSONException
    //   804	825	1430	org/json/JSONException
    //   825	846	1430	org/json/JSONException
    //   846	872	1430	org/json/JSONException
    //   875	949	1430	org/json/JSONException
    //   949	956	1430	org/json/JSONException
    //   959	964	1430	org/json/JSONException
    //   964	985	1430	org/json/JSONException
    //   985	1011	1430	org/json/JSONException
    //   1014	1034	1430	org/json/JSONException
    //   1043	1048	1430	org/json/JSONException
    //   1048	1095	1430	org/json/JSONException
    //   1095	1100	1430	org/json/JSONException
    //   1100	1168	1430	org/json/JSONException
    //   1168	1189	1430	org/json/JSONException
    //   1189	1194	1430	org/json/JSONException
    //   1194	1269	1430	org/json/JSONException
    //   1272	1298	1430	org/json/JSONException
    //   1307	1313	1430	org/json/JSONException
    //   1313	1340	1430	org/json/JSONException
    //   1343	1364	1430	org/json/JSONException
    //   1373	1379	1430	org/json/JSONException
    //   1379	1384	1430	org/json/JSONException
    //   1386	1428	1430	org/json/JSONException
    //   129	150	1473	org/json/JSONException
    //   33	42	1479	finally
    //   46	52	1485	finally
    //   61	69	1485	finally
    //   78	84	1485	finally
    //   88	96	1485	finally
    //   100	105	1485	finally
    //   497	503	1485	finally
    //   508	516	1485	finally
    //   521	526	1485	finally
    //   33	42	1491	java/io/IOException
    //   46	52	1503	java/io/IOException
    //   61	69	1503	java/io/IOException
    //   24	33	1513	java/io/FileNotFoundException
    //   33	42	1522	java/io/FileNotFoundException
  }
  
  private NearbyGrayTipsManager.GreetWording a(int paramInt)
  {
    int i;
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      int j = this.jdField_a_of_type_JavaUtilList.size();
      i = 0;
      NearbyGrayTipsManager.GreetWording localGreetWording = null;
      if (i < j)
      {
        localGreetWording = (NearbyGrayTipsManager.GreetWording)this.jdField_a_of_type_JavaUtilList.get(i);
        if (localGreetWording != null) {
          if (localGreetWording.id != paramInt) {
            break label78;
          }
        }
      }
      else
      {
        return localGreetWording;
      }
    }
    for (;;)
    {
      i += 1;
      break;
      label78:
      Object localObject2 = null;
    }
  }
  
  /* Error */
  public static Object a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: new 410	java/io/FileInputStream
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 411	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   11: astore_0
    //   12: new 413	java/io/BufferedInputStream
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 416	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   20: astore_1
    //   21: new 418	java/io/ObjectInputStream
    //   24: dup
    //   25: aload_1
    //   26: invokespecial 419	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   29: astore 5
    //   31: aload 5
    //   33: astore 4
    //   35: aload_1
    //   36: astore_3
    //   37: aload_0
    //   38: astore_2
    //   39: aload 5
    //   41: invokevirtual 423	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   44: astore 6
    //   46: aload 6
    //   48: astore_2
    //   49: aload 5
    //   51: ifnull +8 -> 59
    //   54: aload 5
    //   56: invokevirtual 424	java/io/ObjectInputStream:close	()V
    //   59: aload_1
    //   60: ifnull +7 -> 67
    //   63: aload_1
    //   64: invokevirtual 425	java/io/BufferedInputStream:close	()V
    //   67: aload_2
    //   68: astore_1
    //   69: aload_0
    //   70: ifnull +9 -> 79
    //   73: aload_0
    //   74: invokevirtual 426	java/io/FileInputStream:close	()V
    //   77: aload_2
    //   78: astore_1
    //   79: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   82: ifeq +39 -> 121
    //   85: new 87	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   92: ldc_w 428
    //   95: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: astore_2
    //   99: aload_1
    //   100: ifnonnull +283 -> 383
    //   103: ldc_w 430
    //   106: astore_0
    //   107: ldc 113
    //   109: iconst_2
    //   110: aload_2
    //   111: aload_0
    //   112: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 433	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   121: aload_1
    //   122: areturn
    //   123: astore_0
    //   124: aload_0
    //   125: invokevirtual 233	java/io/IOException:printStackTrace	()V
    //   128: aload_2
    //   129: astore_1
    //   130: goto -51 -> 79
    //   133: astore 6
    //   135: aconst_null
    //   136: astore 5
    //   138: aconst_null
    //   139: astore_1
    //   140: aconst_null
    //   141: astore_0
    //   142: aload 5
    //   144: astore 4
    //   146: aload_1
    //   147: astore_3
    //   148: aload_0
    //   149: astore_2
    //   150: aload 6
    //   152: invokevirtual 121	java/io/FileNotFoundException:printStackTrace	()V
    //   155: aload 5
    //   157: ifnull +8 -> 165
    //   160: aload 5
    //   162: invokevirtual 424	java/io/ObjectInputStream:close	()V
    //   165: aload_1
    //   166: ifnull +7 -> 173
    //   169: aload_1
    //   170: invokevirtual 425	java/io/BufferedInputStream:close	()V
    //   173: aload 7
    //   175: astore_1
    //   176: aload_0
    //   177: ifnull -98 -> 79
    //   180: aload_0
    //   181: invokevirtual 426	java/io/FileInputStream:close	()V
    //   184: aload 7
    //   186: astore_1
    //   187: goto -108 -> 79
    //   190: astore_0
    //   191: aload_0
    //   192: invokevirtual 233	java/io/IOException:printStackTrace	()V
    //   195: aload 7
    //   197: astore_1
    //   198: goto -119 -> 79
    //   201: astore 6
    //   203: aconst_null
    //   204: astore 5
    //   206: aconst_null
    //   207: astore_1
    //   208: aconst_null
    //   209: astore_0
    //   210: aload 5
    //   212: astore 4
    //   214: aload_1
    //   215: astore_3
    //   216: aload_0
    //   217: astore_2
    //   218: aload 6
    //   220: invokevirtual 233	java/io/IOException:printStackTrace	()V
    //   223: aload 5
    //   225: ifnull +8 -> 233
    //   228: aload 5
    //   230: invokevirtual 424	java/io/ObjectInputStream:close	()V
    //   233: aload_1
    //   234: ifnull +7 -> 241
    //   237: aload_1
    //   238: invokevirtual 425	java/io/BufferedInputStream:close	()V
    //   241: aload 7
    //   243: astore_1
    //   244: aload_0
    //   245: ifnull -166 -> 79
    //   248: aload_0
    //   249: invokevirtual 426	java/io/FileInputStream:close	()V
    //   252: aload 7
    //   254: astore_1
    //   255: goto -176 -> 79
    //   258: astore_0
    //   259: aload_0
    //   260: invokevirtual 233	java/io/IOException:printStackTrace	()V
    //   263: aload 7
    //   265: astore_1
    //   266: goto -187 -> 79
    //   269: astore 6
    //   271: aconst_null
    //   272: astore 5
    //   274: aconst_null
    //   275: astore_1
    //   276: aconst_null
    //   277: astore_0
    //   278: aload 5
    //   280: astore 4
    //   282: aload_1
    //   283: astore_3
    //   284: aload_0
    //   285: astore_2
    //   286: aload 6
    //   288: invokevirtual 434	java/lang/Exception:printStackTrace	()V
    //   291: aload 5
    //   293: ifnull +8 -> 301
    //   296: aload 5
    //   298: invokevirtual 424	java/io/ObjectInputStream:close	()V
    //   301: aload_1
    //   302: ifnull +7 -> 309
    //   305: aload_1
    //   306: invokevirtual 425	java/io/BufferedInputStream:close	()V
    //   309: aload 7
    //   311: astore_1
    //   312: aload_0
    //   313: ifnull -234 -> 79
    //   316: aload_0
    //   317: invokevirtual 426	java/io/FileInputStream:close	()V
    //   320: aload 7
    //   322: astore_1
    //   323: goto -244 -> 79
    //   326: astore_0
    //   327: aload_0
    //   328: invokevirtual 233	java/io/IOException:printStackTrace	()V
    //   331: aload 7
    //   333: astore_1
    //   334: goto -255 -> 79
    //   337: astore 5
    //   339: aconst_null
    //   340: astore 4
    //   342: aconst_null
    //   343: astore_1
    //   344: aconst_null
    //   345: astore_0
    //   346: aload 4
    //   348: ifnull +8 -> 356
    //   351: aload 4
    //   353: invokevirtual 424	java/io/ObjectInputStream:close	()V
    //   356: aload_1
    //   357: ifnull +7 -> 364
    //   360: aload_1
    //   361: invokevirtual 425	java/io/BufferedInputStream:close	()V
    //   364: aload_0
    //   365: ifnull +7 -> 372
    //   368: aload_0
    //   369: invokevirtual 426	java/io/FileInputStream:close	()V
    //   372: aload 5
    //   374: athrow
    //   375: astore_0
    //   376: aload_0
    //   377: invokevirtual 233	java/io/IOException:printStackTrace	()V
    //   380: goto -8 -> 372
    //   383: aload_1
    //   384: invokevirtual 435	java/lang/Object:toString	()Ljava/lang/String;
    //   387: astore_0
    //   388: goto -281 -> 107
    //   391: astore 5
    //   393: aconst_null
    //   394: astore 4
    //   396: aconst_null
    //   397: astore_1
    //   398: goto -52 -> 346
    //   401: astore 5
    //   403: aconst_null
    //   404: astore 4
    //   406: goto -60 -> 346
    //   409: astore 5
    //   411: aload_3
    //   412: astore_1
    //   413: aload_2
    //   414: astore_0
    //   415: goto -69 -> 346
    //   418: astore 6
    //   420: aconst_null
    //   421: astore 5
    //   423: aconst_null
    //   424: astore_1
    //   425: goto -147 -> 278
    //   428: astore 6
    //   430: aconst_null
    //   431: astore 5
    //   433: goto -155 -> 278
    //   436: astore 6
    //   438: goto -160 -> 278
    //   441: astore 6
    //   443: aconst_null
    //   444: astore 5
    //   446: aconst_null
    //   447: astore_1
    //   448: goto -238 -> 210
    //   451: astore 6
    //   453: aconst_null
    //   454: astore 5
    //   456: goto -246 -> 210
    //   459: astore 6
    //   461: goto -251 -> 210
    //   464: astore 6
    //   466: aconst_null
    //   467: astore 5
    //   469: aconst_null
    //   470: astore_1
    //   471: goto -329 -> 142
    //   474: astore 6
    //   476: aconst_null
    //   477: astore 5
    //   479: goto -337 -> 142
    //   482: astore 6
    //   484: goto -342 -> 142
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	487	0	paramString	String
    //   20	451	1	localObject1	Object
    //   38	376	2	localObject2	Object
    //   36	376	3	localObject3	Object
    //   33	372	4	localObjectInputStream1	java.io.ObjectInputStream
    //   29	268	5	localObjectInputStream2	java.io.ObjectInputStream
    //   337	36	5	localObject4	Object
    //   391	1	5	localObject5	Object
    //   401	1	5	localObject6	Object
    //   409	1	5	localObject7	Object
    //   421	57	5	localObject8	Object
    //   44	3	6	localObject9	Object
    //   133	18	6	localFileNotFoundException1	java.io.FileNotFoundException
    //   201	18	6	localIOException1	java.io.IOException
    //   269	18	6	localException1	Exception
    //   418	1	6	localException2	Exception
    //   428	1	6	localException3	Exception
    //   436	1	6	localException4	Exception
    //   441	1	6	localIOException2	java.io.IOException
    //   451	1	6	localIOException3	java.io.IOException
    //   459	1	6	localIOException4	java.io.IOException
    //   464	1	6	localFileNotFoundException2	java.io.FileNotFoundException
    //   474	1	6	localFileNotFoundException3	java.io.FileNotFoundException
    //   482	1	6	localFileNotFoundException4	java.io.FileNotFoundException
    //   1	331	7	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   54	59	123	java/io/IOException
    //   63	67	123	java/io/IOException
    //   73	77	123	java/io/IOException
    //   3	12	133	java/io/FileNotFoundException
    //   160	165	190	java/io/IOException
    //   169	173	190	java/io/IOException
    //   180	184	190	java/io/IOException
    //   3	12	201	java/io/IOException
    //   228	233	258	java/io/IOException
    //   237	241	258	java/io/IOException
    //   248	252	258	java/io/IOException
    //   3	12	269	java/lang/Exception
    //   296	301	326	java/io/IOException
    //   305	309	326	java/io/IOException
    //   316	320	326	java/io/IOException
    //   3	12	337	finally
    //   351	356	375	java/io/IOException
    //   360	364	375	java/io/IOException
    //   368	372	375	java/io/IOException
    //   12	21	391	finally
    //   21	31	401	finally
    //   39	46	409	finally
    //   150	155	409	finally
    //   218	223	409	finally
    //   286	291	409	finally
    //   12	21	418	java/lang/Exception
    //   21	31	428	java/lang/Exception
    //   39	46	436	java/lang/Exception
    //   12	21	441	java/io/IOException
    //   21	31	451	java/io/IOException
    //   39	46	459	java/io/IOException
    //   12	21	464	java/io/FileNotFoundException
    //   21	31	474	java/io/FileNotFoundException
    //   39	46	482	java/io/FileNotFoundException
  }
  
  public static String a()
  {
    File localFile = new File(BaseApplicationImpl.getContext().getFilesDir().getAbsolutePath() + "/nearby_gray_tips_configs");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile.getAbsolutePath() + "/";
  }
  
  /* Error */
  public static void a(Object paramObject, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 5
    //   9: aconst_null
    //   10: astore_3
    //   11: aconst_null
    //   12: astore 7
    //   14: aload_0
    //   15: ifnonnull +19 -> 34
    //   18: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   21: ifeq +12 -> 33
    //   24: ldc 113
    //   26: iconst_2
    //   27: ldc_w 461
    //   30: invokestatic 433	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: return
    //   34: iconst_0
    //   35: istore 11
    //   37: new 463	java/io/FileOutputStream
    //   40: dup
    //   41: aload_1
    //   42: invokespecial 464	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   45: astore_1
    //   46: new 466	java/io/BufferedOutputStream
    //   49: dup
    //   50: aload_1
    //   51: invokespecial 469	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   54: astore_2
    //   55: aload_2
    //   56: astore 4
    //   58: aload_3
    //   59: astore 5
    //   61: aload_1
    //   62: astore_3
    //   63: new 471	java/io/ObjectOutputStream
    //   66: dup
    //   67: aload_2
    //   68: invokespecial 472	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   71: astore 6
    //   73: aload 6
    //   75: aload_0
    //   76: invokevirtual 476	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   79: aload_2
    //   80: invokevirtual 479	java/io/BufferedOutputStream:flush	()V
    //   83: iconst_1
    //   84: istore 11
    //   86: aload_2
    //   87: ifnull +7 -> 94
    //   90: aload_2
    //   91: invokevirtual 480	java/io/BufferedOutputStream:close	()V
    //   94: aload 6
    //   96: ifnull +8 -> 104
    //   99: aload 6
    //   101: invokevirtual 481	java/io/ObjectOutputStream:close	()V
    //   104: iload 11
    //   106: istore 10
    //   108: aload_1
    //   109: ifnull +11 -> 120
    //   112: aload_1
    //   113: invokevirtual 482	java/io/FileOutputStream:close	()V
    //   116: iload 11
    //   118: istore 10
    //   120: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   123: ifeq -90 -> 33
    //   126: ldc 113
    //   128: iconst_2
    //   129: new 87	java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   136: ldc_w 484
    //   139: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: iload 10
    //   144: invokevirtual 487	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   147: ldc_w 489
    //   150: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_0
    //   154: invokevirtual 435	java/lang/Object:toString	()Ljava/lang/String;
    //   157: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 433	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   166: return
    //   167: astore_2
    //   168: aload_2
    //   169: invokevirtual 233	java/io/IOException:printStackTrace	()V
    //   172: goto -78 -> 94
    //   175: astore_2
    //   176: aload_2
    //   177: invokevirtual 233	java/io/IOException:printStackTrace	()V
    //   180: goto -76 -> 104
    //   183: astore_1
    //   184: aload_1
    //   185: invokevirtual 233	java/io/IOException:printStackTrace	()V
    //   188: iload 11
    //   190: istore 10
    //   192: goto -72 -> 120
    //   195: astore_3
    //   196: aconst_null
    //   197: astore_2
    //   198: aconst_null
    //   199: astore_1
    //   200: aload 7
    //   202: astore 5
    //   204: aload_3
    //   205: invokevirtual 121	java/io/FileNotFoundException:printStackTrace	()V
    //   208: aload_2
    //   209: ifnull +7 -> 216
    //   212: aload_2
    //   213: invokevirtual 480	java/io/BufferedOutputStream:close	()V
    //   216: aload 5
    //   218: ifnull +8 -> 226
    //   221: aload 5
    //   223: invokevirtual 481	java/io/ObjectOutputStream:close	()V
    //   226: iload 11
    //   228: istore 10
    //   230: aload_1
    //   231: ifnull -111 -> 120
    //   234: aload_1
    //   235: invokevirtual 482	java/io/FileOutputStream:close	()V
    //   238: iload 11
    //   240: istore 10
    //   242: goto -122 -> 120
    //   245: astore_1
    //   246: aload_1
    //   247: invokevirtual 233	java/io/IOException:printStackTrace	()V
    //   250: iload 11
    //   252: istore 10
    //   254: goto -134 -> 120
    //   257: astore_2
    //   258: aload_2
    //   259: invokevirtual 233	java/io/IOException:printStackTrace	()V
    //   262: goto -46 -> 216
    //   265: astore_2
    //   266: aload_2
    //   267: invokevirtual 233	java/io/IOException:printStackTrace	()V
    //   270: goto -44 -> 226
    //   273: astore 6
    //   275: aconst_null
    //   276: astore_2
    //   277: aconst_null
    //   278: astore_1
    //   279: aload 8
    //   281: astore 7
    //   283: aload_2
    //   284: astore 4
    //   286: aload 7
    //   288: astore 5
    //   290: aload_1
    //   291: astore_3
    //   292: aload 6
    //   294: invokevirtual 233	java/io/IOException:printStackTrace	()V
    //   297: aload_2
    //   298: ifnull +7 -> 305
    //   301: aload_2
    //   302: invokevirtual 480	java/io/BufferedOutputStream:close	()V
    //   305: aload 7
    //   307: ifnull +8 -> 315
    //   310: aload 7
    //   312: invokevirtual 481	java/io/ObjectOutputStream:close	()V
    //   315: iload 11
    //   317: istore 10
    //   319: aload_1
    //   320: ifnull -200 -> 120
    //   323: aload_1
    //   324: invokevirtual 482	java/io/FileOutputStream:close	()V
    //   327: iload 11
    //   329: istore 10
    //   331: goto -211 -> 120
    //   334: astore_1
    //   335: aload_1
    //   336: invokevirtual 233	java/io/IOException:printStackTrace	()V
    //   339: iload 11
    //   341: istore 10
    //   343: goto -223 -> 120
    //   346: astore_2
    //   347: aload_2
    //   348: invokevirtual 233	java/io/IOException:printStackTrace	()V
    //   351: goto -46 -> 305
    //   354: astore_2
    //   355: aload_2
    //   356: invokevirtual 233	java/io/IOException:printStackTrace	()V
    //   359: goto -44 -> 315
    //   362: astore 6
    //   364: aconst_null
    //   365: astore_2
    //   366: aconst_null
    //   367: astore_1
    //   368: aload 9
    //   370: astore 7
    //   372: aload_2
    //   373: astore 4
    //   375: aload 7
    //   377: astore 5
    //   379: aload_1
    //   380: astore_3
    //   381: aload 6
    //   383: invokevirtual 434	java/lang/Exception:printStackTrace	()V
    //   386: aload_2
    //   387: ifnull +7 -> 394
    //   390: aload_2
    //   391: invokevirtual 480	java/io/BufferedOutputStream:close	()V
    //   394: aload 7
    //   396: ifnull +8 -> 404
    //   399: aload 7
    //   401: invokevirtual 481	java/io/ObjectOutputStream:close	()V
    //   404: iload 11
    //   406: istore 10
    //   408: aload_1
    //   409: ifnull -289 -> 120
    //   412: aload_1
    //   413: invokevirtual 482	java/io/FileOutputStream:close	()V
    //   416: iload 11
    //   418: istore 10
    //   420: goto -300 -> 120
    //   423: astore_1
    //   424: aload_1
    //   425: invokevirtual 233	java/io/IOException:printStackTrace	()V
    //   428: iload 11
    //   430: istore 10
    //   432: goto -312 -> 120
    //   435: astore_2
    //   436: aload_2
    //   437: invokevirtual 233	java/io/IOException:printStackTrace	()V
    //   440: goto -46 -> 394
    //   443: astore_2
    //   444: aload_2
    //   445: invokevirtual 233	java/io/IOException:printStackTrace	()V
    //   448: goto -44 -> 404
    //   451: astore_0
    //   452: aconst_null
    //   453: astore_2
    //   454: aconst_null
    //   455: astore_1
    //   456: aload_2
    //   457: ifnull +7 -> 464
    //   460: aload_2
    //   461: invokevirtual 480	java/io/BufferedOutputStream:close	()V
    //   464: aload 5
    //   466: ifnull +8 -> 474
    //   469: aload 5
    //   471: invokevirtual 481	java/io/ObjectOutputStream:close	()V
    //   474: aload_1
    //   475: ifnull +7 -> 482
    //   478: aload_1
    //   479: invokevirtual 482	java/io/FileOutputStream:close	()V
    //   482: aload_0
    //   483: athrow
    //   484: astore_2
    //   485: aload_2
    //   486: invokevirtual 233	java/io/IOException:printStackTrace	()V
    //   489: goto -25 -> 464
    //   492: astore_2
    //   493: aload_2
    //   494: invokevirtual 233	java/io/IOException:printStackTrace	()V
    //   497: goto -23 -> 474
    //   500: astore_1
    //   501: aload_1
    //   502: invokevirtual 233	java/io/IOException:printStackTrace	()V
    //   505: goto -23 -> 482
    //   508: astore_0
    //   509: aconst_null
    //   510: astore_2
    //   511: goto -55 -> 456
    //   514: astore_0
    //   515: aload 4
    //   517: astore_2
    //   518: aload_3
    //   519: astore_1
    //   520: goto -64 -> 456
    //   523: astore_0
    //   524: aload 6
    //   526: astore 5
    //   528: goto -72 -> 456
    //   531: astore_0
    //   532: goto -76 -> 456
    //   535: astore 6
    //   537: aconst_null
    //   538: astore_2
    //   539: aload 9
    //   541: astore 7
    //   543: goto -171 -> 372
    //   546: astore 6
    //   548: aload 9
    //   550: astore 7
    //   552: goto -180 -> 372
    //   555: astore_3
    //   556: aload 6
    //   558: astore 7
    //   560: aload_3
    //   561: astore 6
    //   563: goto -191 -> 372
    //   566: astore 6
    //   568: aconst_null
    //   569: astore_2
    //   570: aload 8
    //   572: astore 7
    //   574: goto -291 -> 283
    //   577: astore 6
    //   579: aload 8
    //   581: astore 7
    //   583: goto -300 -> 283
    //   586: astore_3
    //   587: aload 6
    //   589: astore 7
    //   591: aload_3
    //   592: astore 6
    //   594: goto -311 -> 283
    //   597: astore_3
    //   598: aconst_null
    //   599: astore_2
    //   600: aload 7
    //   602: astore 5
    //   604: goto -400 -> 204
    //   607: astore_3
    //   608: aload 7
    //   610: astore 5
    //   612: goto -408 -> 204
    //   615: astore_3
    //   616: aload 6
    //   618: astore 5
    //   620: goto -416 -> 204
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	623	0	paramObject	Object
    //   0	623	1	paramString	String
    //   54	37	2	localBufferedOutputStream	java.io.BufferedOutputStream
    //   167	2	2	localIOException1	java.io.IOException
    //   175	2	2	localIOException2	java.io.IOException
    //   197	16	2	localObject1	Object
    //   257	2	2	localIOException3	java.io.IOException
    //   265	2	2	localIOException4	java.io.IOException
    //   276	26	2	localObject2	Object
    //   346	2	2	localIOException5	java.io.IOException
    //   354	2	2	localIOException6	java.io.IOException
    //   365	26	2	localObject3	Object
    //   435	2	2	localIOException7	java.io.IOException
    //   443	2	2	localIOException8	java.io.IOException
    //   453	8	2	localObject4	Object
    //   484	2	2	localIOException9	java.io.IOException
    //   492	2	2	localIOException10	java.io.IOException
    //   510	90	2	localObject5	Object
    //   10	53	3	str1	String
    //   195	10	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   291	228	3	str2	String
    //   555	6	3	localException1	Exception
    //   586	6	3	localIOException11	java.io.IOException
    //   597	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   607	1	3	localFileNotFoundException3	java.io.FileNotFoundException
    //   615	1	3	localFileNotFoundException4	java.io.FileNotFoundException
    //   56	460	4	localObject6	Object
    //   7	612	5	localObject7	Object
    //   71	29	6	localObjectOutputStream	java.io.ObjectOutputStream
    //   273	20	6	localIOException12	java.io.IOException
    //   362	163	6	localException2	Exception
    //   535	1	6	localException3	Exception
    //   546	11	6	localException4	Exception
    //   561	1	6	localException5	Exception
    //   566	1	6	localIOException13	java.io.IOException
    //   577	11	6	localIOException14	java.io.IOException
    //   592	25	6	localIOException15	java.io.IOException
    //   12	597	7	localObject8	Object
    //   1	579	8	localObject9	Object
    //   4	545	9	localObject10	Object
    //   106	325	10	bool1	boolean
    //   35	394	11	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   90	94	167	java/io/IOException
    //   99	104	175	java/io/IOException
    //   112	116	183	java/io/IOException
    //   37	46	195	java/io/FileNotFoundException
    //   234	238	245	java/io/IOException
    //   212	216	257	java/io/IOException
    //   221	226	265	java/io/IOException
    //   37	46	273	java/io/IOException
    //   323	327	334	java/io/IOException
    //   301	305	346	java/io/IOException
    //   310	315	354	java/io/IOException
    //   37	46	362	java/lang/Exception
    //   412	416	423	java/io/IOException
    //   390	394	435	java/io/IOException
    //   399	404	443	java/io/IOException
    //   37	46	451	finally
    //   460	464	484	java/io/IOException
    //   469	474	492	java/io/IOException
    //   478	482	500	java/io/IOException
    //   46	55	508	finally
    //   63	73	514	finally
    //   292	297	514	finally
    //   381	386	514	finally
    //   73	83	523	finally
    //   204	208	531	finally
    //   46	55	535	java/lang/Exception
    //   63	73	546	java/lang/Exception
    //   73	83	555	java/lang/Exception
    //   46	55	566	java/io/IOException
    //   63	73	577	java/io/IOException
    //   73	83	586	java/io/IOException
    //   46	55	597	java/io/FileNotFoundException
    //   63	73	607	java/io/FileNotFoundException
    //   73	83	615	java/io/FileNotFoundException
  }
  
  public static boolean a(long paramLong1, long paramLong2)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(paramLong1);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(paramLong2);
    if (localCalendar1.get(6) != localCalendar2.get(6)) {}
    while (localCalendar1.get(1) != localCalendar2.get(1)) {
      return false;
    }
    return true;
  }
  
  /* Error */
  public static boolean a(NearbyGrayTipsManager.GrayTipsConfig paramGrayTipsConfig)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 8
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 4
    //   9: aconst_null
    //   10: astore 6
    //   12: aconst_null
    //   13: astore_3
    //   14: aload_0
    //   15: ifnonnull +6 -> 21
    //   18: iload 8
    //   20: ireturn
    //   21: new 463	java/io/FileOutputStream
    //   24: dup
    //   25: new 87	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   32: invokestatic 504	com/tencent/mobileqq/app/NearbyGrayTipsManager:a	()Ljava/lang/String;
    //   35: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_0
    //   39: getfield 195	com/tencent/mobileqq/app/NearbyGrayTipsManager$GrayTipsConfig:id	I
    //   42: invokevirtual 507	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   45: ldc 12
    //   47: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokespecial 464	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   56: astore_1
    //   57: new 466	java/io/BufferedOutputStream
    //   60: dup
    //   61: aload_1
    //   62: invokespecial 469	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   65: astore_2
    //   66: aload_2
    //   67: astore 5
    //   69: aload_1
    //   70: astore 4
    //   72: new 471	java/io/ObjectOutputStream
    //   75: dup
    //   76: aload_2
    //   77: invokespecial 472	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   80: astore_3
    //   81: aload_3
    //   82: aload_0
    //   83: invokevirtual 476	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   86: aload_2
    //   87: invokevirtual 479	java/io/BufferedOutputStream:flush	()V
    //   90: iconst_1
    //   91: istore 8
    //   93: aload_3
    //   94: ifnull +7 -> 101
    //   97: aload_3
    //   98: invokevirtual 481	java/io/ObjectOutputStream:close	()V
    //   101: aload_2
    //   102: ifnull +7 -> 109
    //   105: aload_2
    //   106: invokevirtual 480	java/io/BufferedOutputStream:close	()V
    //   109: aload_1
    //   110: ifnull -92 -> 18
    //   113: aload_1
    //   114: invokevirtual 482	java/io/FileOutputStream:close	()V
    //   117: iconst_1
    //   118: ireturn
    //   119: astore_0
    //   120: aload_0
    //   121: invokevirtual 233	java/io/IOException:printStackTrace	()V
    //   124: iconst_1
    //   125: ireturn
    //   126: astore_2
    //   127: aconst_null
    //   128: astore_0
    //   129: aconst_null
    //   130: astore_1
    //   131: aload_2
    //   132: invokevirtual 121	java/io/FileNotFoundException:printStackTrace	()V
    //   135: aload_0
    //   136: ifnull +7 -> 143
    //   139: aload_0
    //   140: invokevirtual 481	java/io/ObjectOutputStream:close	()V
    //   143: aload_3
    //   144: ifnull +7 -> 151
    //   147: aload_3
    //   148: invokevirtual 480	java/io/BufferedOutputStream:close	()V
    //   151: aload_1
    //   152: ifnull -134 -> 18
    //   155: aload_1
    //   156: invokevirtual 482	java/io/FileOutputStream:close	()V
    //   159: iconst_0
    //   160: ireturn
    //   161: astore_0
    //   162: aload_0
    //   163: invokevirtual 233	java/io/IOException:printStackTrace	()V
    //   166: iconst_0
    //   167: ireturn
    //   168: astore_0
    //   169: aconst_null
    //   170: astore_2
    //   171: aconst_null
    //   172: astore_1
    //   173: aload 7
    //   175: astore_3
    //   176: aload_3
    //   177: astore 6
    //   179: aload_2
    //   180: astore 5
    //   182: aload_1
    //   183: astore 4
    //   185: aload_0
    //   186: invokevirtual 233	java/io/IOException:printStackTrace	()V
    //   189: aload_3
    //   190: ifnull +7 -> 197
    //   193: aload_3
    //   194: invokevirtual 481	java/io/ObjectOutputStream:close	()V
    //   197: aload_2
    //   198: ifnull +7 -> 205
    //   201: aload_2
    //   202: invokevirtual 480	java/io/BufferedOutputStream:close	()V
    //   205: aload_1
    //   206: ifnull -188 -> 18
    //   209: aload_1
    //   210: invokevirtual 482	java/io/FileOutputStream:close	()V
    //   213: iconst_0
    //   214: ireturn
    //   215: astore_0
    //   216: aload_0
    //   217: invokevirtual 233	java/io/IOException:printStackTrace	()V
    //   220: iconst_0
    //   221: ireturn
    //   222: astore_0
    //   223: aconst_null
    //   224: astore_2
    //   225: aconst_null
    //   226: astore_1
    //   227: aload 4
    //   229: astore_3
    //   230: aload_3
    //   231: ifnull +7 -> 238
    //   234: aload_3
    //   235: invokevirtual 481	java/io/ObjectOutputStream:close	()V
    //   238: aload_2
    //   239: ifnull +7 -> 246
    //   242: aload_2
    //   243: invokevirtual 480	java/io/BufferedOutputStream:close	()V
    //   246: aload_1
    //   247: ifnull +7 -> 254
    //   250: aload_1
    //   251: invokevirtual 482	java/io/FileOutputStream:close	()V
    //   254: aload_0
    //   255: athrow
    //   256: astore_1
    //   257: aload_1
    //   258: invokevirtual 233	java/io/IOException:printStackTrace	()V
    //   261: goto -7 -> 254
    //   264: astore_0
    //   265: aconst_null
    //   266: astore_2
    //   267: aload 4
    //   269: astore_3
    //   270: goto -40 -> 230
    //   273: astore_0
    //   274: aload 6
    //   276: astore_3
    //   277: aload 5
    //   279: astore_2
    //   280: aload 4
    //   282: astore_1
    //   283: goto -53 -> 230
    //   286: astore_0
    //   287: goto -57 -> 230
    //   290: astore 4
    //   292: aload_3
    //   293: astore_2
    //   294: aload_0
    //   295: astore_3
    //   296: aload 4
    //   298: astore_0
    //   299: goto -69 -> 230
    //   302: astore_0
    //   303: aconst_null
    //   304: astore_2
    //   305: aload 7
    //   307: astore_3
    //   308: goto -132 -> 176
    //   311: astore_0
    //   312: aload 7
    //   314: astore_3
    //   315: goto -139 -> 176
    //   318: astore_0
    //   319: goto -143 -> 176
    //   322: astore_2
    //   323: aconst_null
    //   324: astore_0
    //   325: goto -194 -> 131
    //   328: astore 4
    //   330: aconst_null
    //   331: astore_0
    //   332: aload_2
    //   333: astore_3
    //   334: aload 4
    //   336: astore_2
    //   337: goto -206 -> 131
    //   340: astore_0
    //   341: aload_2
    //   342: astore 4
    //   344: aload_0
    //   345: astore_2
    //   346: aload_3
    //   347: astore_0
    //   348: aload 4
    //   350: astore_3
    //   351: goto -220 -> 131
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	354	0	paramGrayTipsConfig	NearbyGrayTipsManager.GrayTipsConfig
    //   56	195	1	localFileOutputStream	java.io.FileOutputStream
    //   256	2	1	localIOException	java.io.IOException
    //   282	1	1	localObject1	Object
    //   65	41	2	localBufferedOutputStream	java.io.BufferedOutputStream
    //   126	6	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   170	135	2	localObject2	Object
    //   322	11	2	localFileNotFoundException2	java.io.FileNotFoundException
    //   336	10	2	localObject3	Object
    //   13	338	3	localObject4	Object
    //   7	274	4	localObject5	Object
    //   290	7	4	localObject6	Object
    //   328	7	4	localFileNotFoundException3	java.io.FileNotFoundException
    //   342	7	4	localObject7	Object
    //   67	211	5	localObject8	Object
    //   10	265	6	localObject9	Object
    //   4	309	7	localObject10	Object
    //   1	91	8	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   97	101	119	java/io/IOException
    //   105	109	119	java/io/IOException
    //   113	117	119	java/io/IOException
    //   21	57	126	java/io/FileNotFoundException
    //   139	143	161	java/io/IOException
    //   147	151	161	java/io/IOException
    //   155	159	161	java/io/IOException
    //   21	57	168	java/io/IOException
    //   193	197	215	java/io/IOException
    //   201	205	215	java/io/IOException
    //   209	213	215	java/io/IOException
    //   21	57	222	finally
    //   234	238	256	java/io/IOException
    //   242	246	256	java/io/IOException
    //   250	254	256	java/io/IOException
    //   57	66	264	finally
    //   72	81	273	finally
    //   185	189	273	finally
    //   81	90	286	finally
    //   131	135	290	finally
    //   57	66	302	java/io/IOException
    //   72	81	311	java/io/IOException
    //   81	90	318	java/io/IOException
    //   57	66	322	java/io/FileNotFoundException
    //   72	81	328	java/io/FileNotFoundException
    //   81	90	340	java/io/FileNotFoundException
  }
  
  private void c()
  {
    Object localObject1;
    Object localObject3;
    int j;
    int i;
    try
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("nearby_aio_operation_gray_tips", 4, "loadLocalData");
      }
      a(true);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
      this.h = ((SharedPreferences)localObject1).getInt("nearby_max_count_in_one_day", 0);
      this.jdField_a_of_type_Long = ((SharedPreferences)localObject1).getLong("nearby_mark_day_time", 0L);
      if (QLog.isDevelopLevel()) {
        QLog.i("nearby_aio_operation_gray_tips", 4, "loadLocalData, [" + this.h + "," + this.jdField_a_of_type_Long + "]");
      }
      localObject1 = a();
      localObject3 = new File((String)localObject1);
      if (!((File)localObject3).isDirectory()) {
        break label224;
      }
      localObject3 = ((File)localObject3).listFiles();
      if ((localObject3 == null) || (localObject3.length <= 0)) {
        break label220;
      }
      j = localObject3.length;
      i = 0;
    }
    finally {}
    Object localObject4 = ((File)localObject4).getName();
    if ((!TextUtils.isEmpty((CharSequence)localObject4)) && (((String)localObject4).endsWith(".conf")))
    {
      localObject4 = a((String)localObject1 + (String)localObject4);
      if ((localObject4 instanceof NearbyGrayTipsManager.GrayTipsConfig)) {
        a((NearbyGrayTipsManager.GrayTipsConfig)localObject4);
      }
    }
    label220:
    label224:
    label250:
    for (;;)
    {
      a();
      return;
      for (;;)
      {
        if (i >= j) {
          break label250;
        }
        localObject4 = localObject3[i];
        if (localObject4 != null) {
          break;
        }
        i += 1;
      }
    }
  }
  
  public NearbyGrayTipsManager.GrayTipStatisticData a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    ??? = null;
    label221:
    for (;;)
    {
      int i;
      synchronized (this.jdField_b_of_type_JavaUtilList)
      {
        int j = this.jdField_b_of_type_JavaUtilList.size();
        i = 0;
        ??? = ???;
        if (i < j)
        {
          ??? = (NearbyGrayTipsManager.GrayTipStatisticData)this.jdField_b_of_type_JavaUtilList.get(i);
          if ((??? == null) || (((NearbyGrayTipsManager.GrayTipStatisticData)???).mId != paramInt)) {}
        }
        else
        {
          if ((??? != null) || (!paramBoolean1)) {
            break label221;
          }
          ??? = a(NearbyGrayTipsManager.GrayTipStatisticData.getPath(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramInt));
          if (!(??? instanceof NearbyGrayTipsManager.GrayTipStatisticData)) {
            break label221;
          }
          ??? = (NearbyGrayTipsManager.GrayTipStatisticData)???;
          synchronized (this.jdField_b_of_type_JavaUtilList)
          {
            this.jdField_b_of_type_JavaUtilList.add(???);
            ??? = ???;
            if (??? == null)
            {
              ??? = ???;
              if (paramBoolean2) {
                ??? = new NearbyGrayTipsManager.GrayTipStatisticData(paramInt);
              }
            }
          }
        }
      }
      synchronized (this.jdField_b_of_type_JavaUtilList)
      {
        this.jdField_b_of_type_JavaUtilList.add(???);
        return (NearbyGrayTipsManager.GrayTipStatisticData)???;
        i += 1;
        continue;
        localObject2 = finally;
        throw ((Throwable)localObject2);
        localObject3 = finally;
        throw ((Throwable)localObject3);
      }
    }
  }
  
  public NearbyGrayTipsManager.GrayTipsConfig a(int paramInt1, int paramInt2, long paramLong)
  {
    if (!this.jdField_a_of_type_Boolean) {
      c();
    }
    Object localObject2;
    if (!this.jdField_b_of_type_Boolean)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("nearby_aio_operation_gray_tips", 4, "getValidConfigForEnterAIO, not enable");
      }
      localObject2 = null;
      return (NearbyGrayTipsManager.GrayTipsConfig)localObject2;
    }
    NearbyGrayTipsManager.GrayTipsConfig localGrayTipsConfig1 = null;
    label294:
    label303:
    label310:
    label317:
    for (;;)
    {
      NearbyGrayTipsManager.GrayTipsConfig localGrayTipsConfig3;
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
        {
          Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          localGrayTipsConfig1 = null;
          if (!localIterator.hasNext()) {
            break label317;
          }
          localGrayTipsConfig3 = (NearbyGrayTipsManager.GrayTipsConfig)localIterator.next();
          if ((localGrayTipsConfig3 == null) || (localGrayTipsConfig3.sceneId != 4) || (localGrayTipsConfig3.sceneFour == null) || (!localGrayTipsConfig3.sceneFour.enterAIOTrigger)) {
            continue;
          }
          if (!localGrayTipsConfig3.isValid(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt1, paramInt2, paramLong)) {
            break label310;
          }
          if (!QLog.isDevelopLevel()) {
            break label294;
          }
          QLog.i("nearby_aio_operation_gray_tips", 4, "getValidConfigForEnterAIO, valid id = " + localGrayTipsConfig3.id);
          break label294;
          localObject2 = localGrayTipsConfig3;
          if (localGrayTipsConfig1.priority < localGrayTipsConfig3.priority) {
            break label303;
          }
          if (localGrayTipsConfig1.priority != localGrayTipsConfig3.priority) {
            break label310;
          }
          localObject2 = localGrayTipsConfig3;
          if (localGrayTipsConfig1.createTime < localGrayTipsConfig3.createTime) {
            break label303;
          }
          break label310;
        }
        localObject2 = localGrayTipsConfig1;
        if (localGrayTipsConfig1 == null) {
          break;
        }
        localObject2 = a(localGrayTipsConfig1.id, true, true);
        if ((localObject2 != null) && (((NearbyGrayTipsManager.GrayTipStatisticData)localObject2).isLimit(localGrayTipsConfig1, paramLong))) {
          return null;
        }
      }
      a(localGrayTipsConfig2, false);
      return localGrayTipsConfig2;
      if (localGrayTipsConfig2 == null)
      {
        Object localObject1;
        for (localObject2 = localGrayTipsConfig3;; localObject2 = localObject1)
        {
          localObject1 = localObject2;
          break;
        }
      }
    }
  }
  
  public NearbyGrayTipsManager.GrayTipsConfig a(int paramInt1, int paramInt2, String paramString, int paramInt3, long paramLong)
  {
    if (!this.jdField_a_of_type_Boolean) {
      c();
    }
    if (!this.jdField_b_of_type_Boolean) {
      return null;
    }
    Object localObject1 = null;
    label379:
    label382:
    label389:
    label396:
    for (;;)
    {
      Object localObject2;
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        Object localObject3;
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
        {
          Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          localObject1 = null;
          if (!localIterator.hasNext()) {
            break label396;
          }
          localObject3 = (NearbyGrayTipsManager.GrayTipsConfig)localIterator.next();
          if ((localObject3 == null) || (((NearbyGrayTipsManager.GrayTipsConfig)localObject3).sceneId != 3) || (((NearbyGrayTipsManager.GrayTipsConfig)localObject3).sceneThree == null) || (!((NearbyGrayTipsManager.GrayTipsConfig)localObject3).sceneThree.keywordTrigger) || (((NearbyGrayTipsManager.GrayTipsConfig)localObject3).sceneThree.keywords == null) || (((NearbyGrayTipsManager.GrayTipsConfig)localObject3).sceneThree.keywords.size() == 0) || (((NearbyGrayTipsManager.GrayTipsConfig)localObject3).sceneThree.whichSide == null) || (!((NearbyGrayTipsManager.GrayTipsConfig)localObject3).sceneThree.whichSide.contains(Integer.valueOf(paramInt3)))) {
            continue;
          }
          if (!((NearbyGrayTipsManager.GrayTipsConfig)localObject3).isValid(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt1, paramInt2, paramLong)) {
            break label389;
          }
          if (localObject1 == null)
          {
            localObject2 = localObject3;
            break label382;
          }
          localObject2 = localObject3;
          if (((NearbyGrayTipsManager.GrayTipsConfig)localObject1).priority < ((NearbyGrayTipsManager.GrayTipsConfig)localObject3).priority) {
            break label382;
          }
          if (((NearbyGrayTipsManager.GrayTipsConfig)localObject1).priority != ((NearbyGrayTipsManager.GrayTipsConfig)localObject3).priority) {
            break label389;
          }
          localObject2 = localObject3;
          if (((NearbyGrayTipsManager.GrayTipsConfig)localObject1).createTime < ((NearbyGrayTipsManager.GrayTipsConfig)localObject3).createTime) {
            break label382;
          }
          break label389;
        }
        localObject2 = localObject1;
        if (localObject1 != null)
        {
          localObject3 = a(((NearbyGrayTipsManager.GrayTipsConfig)localObject1).id, true, true);
          localObject2 = localObject1;
          if (localObject3 != null)
          {
            localObject2 = localObject1;
            if (((NearbyGrayTipsManager.GrayTipStatisticData)localObject3).isLimit((NearbyGrayTipsManager.GrayTipsConfig)localObject1, paramLong)) {
              localObject2 = null;
            }
          }
        }
        if (localObject2 == null) {
          break label379;
        }
        if (TextUtils.isEmpty(paramString)) {
          return null;
        }
      }
      paramInt1 = 0;
      for (;;)
      {
        if ((paramInt1 >= ((NearbyGrayTipsManager.GrayTipsConfig)localObject2).sceneThree.keywords.size()) || (paramString.indexOf((String)((NearbyGrayTipsManager.GrayTipsConfig)localObject2).sceneThree.keywords.get(paramInt1)) >= 0))
        {
          if (paramInt1 != ((NearbyGrayTipsManager.GrayTipsConfig)localObject2).sceneThree.keywords.size()) {
            break;
          }
          return null;
        }
        paramInt1 += 1;
      }
      return (NearbyGrayTipsManager.GrayTipsConfig)localObject2;
      for (;;)
      {
        localObject1 = localObject2;
        break;
        localObject2 = localObject1;
      }
    }
  }
  
  public String a(int paramInt, boolean paramBoolean)
  {
    NearbyGrayTipsManager.GreetWording localGreetWording = a(paramInt);
    if ((localGreetWording == null) && (paramBoolean))
    {
      Object localObject = a(NearbyGrayTipsManager.GreetWording.getPath(paramInt));
      if ((localObject instanceof NearbyGrayTipsManager.GreetWording)) {
        localGreetWording = (NearbyGrayTipsManager.GreetWording)localObject;
      }
    }
    for (;;)
    {
      if (localGreetWording == null) {
        return "";
      }
      return localGreetWording.getWording(this.jdField_a_of_type_JavaUtilRandom);
    }
  }
  
  public ArrayList a()
  {
    if (!this.jdField_a_of_type_Boolean) {
      c();
    }
    return (ArrayList)this.jdField_a_of_type_JavaUtilArrayList.clone();
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
      for (;;)
      {
        synchronized (this.jdField_a_of_type_JavaUtilArrayList)
        {
          if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
          {
            Object localObject1 = (NearbyGrayTipsManager.GrayTipsConfig)this.jdField_a_of_type_JavaUtilArrayList.get(0);
            Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
            if (localIterator.hasNext())
            {
              NearbyGrayTipsManager.GrayTipsConfig localGrayTipsConfig = (NearbyGrayTipsManager.GrayTipsConfig)localIterator.next();
              if (localGrayTipsConfig.createTime > ((NearbyGrayTipsManager.GrayTipsConfig)localObject1).createTime) {
                localObject1 = localGrayTipsConfig;
              }
            }
            else
            {
              this.jdField_b_of_type_Boolean = ((NearbyGrayTipsManager.GrayTipsConfig)localObject1).grayTipsEnable;
              this.e = ((NearbyGrayTipsManager.GrayTipsConfig)localObject1).global_MaxTipsCountPerDay;
              this.f = ((NearbyGrayTipsManager.GrayTipsConfig)localObject1).maxTipsCount;
              this.g = ((NearbyGrayTipsManager.GrayTipsConfig)localObject1).messageCount;
            }
          }
          else
          {
            return;
          }
        }
      }
    }
  }
  
  public void a(int paramInt, long paramLong)
  {
    if (!this.jdField_a_of_type_Boolean) {
      c();
    }
    NearbyGrayTipsManager.GrayTipStatisticData localGrayTipStatisticData = a(paramInt, true, true);
    if (localGrayTipStatisticData != null)
    {
      localGrayTipStatisticData.increase(paramLong);
      a(localGrayTipStatisticData, NearbyGrayTipsManager.GrayTipStatisticData.getPath(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramInt));
    }
    if (a(paramLong, this.jdField_a_of_type_Long)) {
      this.h += 1;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putInt("nearby_max_count_in_one_day", this.h).putLong("nearby_mark_day_time", this.jdField_a_of_type_Long).commit();
      return;
      this.h = 1;
      this.jdField_a_of_type_Long = paramLong;
    }
  }
  
  public void a(NearbyGrayTipsManager.GrayTipsConfig paramGrayTipsConfig)
  {
    ArrayList localArrayList;
    int i;
    if (paramGrayTipsConfig != null)
    {
      localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      i = 0;
    }
    for (;;)
    {
      try
      {
        Object localObject;
        if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          localObject = (NearbyGrayTipsManager.GrayTipsConfig)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          if (((NearbyGrayTipsManager.GrayTipsConfig)localObject).id != paramGrayTipsConfig.id) {
            break label202;
          }
          if (paramGrayTipsConfig.createTime > ((NearbyGrayTipsManager.GrayTipsConfig)localObject).createTime) {
            this.jdField_a_of_type_JavaUtilArrayList.set(i, paramGrayTipsConfig);
          }
        }
        if (i == this.jdField_a_of_type_JavaUtilArrayList.size()) {
          this.jdField_a_of_type_JavaUtilArrayList.add(paramGrayTipsConfig);
        }
        if (QLog.isDevelopLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("updateOrAddAConfig").append(",").append("[").append(i).append(",").append("config_id =").append(paramGrayTipsConfig.id).append(",").append("config_scene_id =").append(paramGrayTipsConfig.sceneId).append(",").append("]");
          QLog.i("nearby_aio_operation_gray_tips", 4, ((StringBuilder)localObject).toString());
        }
        return;
      }
      finally {}
      return;
      label202:
      i += 1;
    }
  }
  
  public void a(NearbyGrayTipsManager.GrayTipsConfig paramGrayTipsConfig, boolean paramBoolean)
  {
    Object localObject1;
    if ((paramGrayTipsConfig != null) && (paramGrayTipsConfig.sceneId == 4))
    {
      localObject2 = a(paramGrayTipsConfig.id);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new NearbyGrayTipsManager.GreetWording(paramGrayTipsConfig.id);
        localObject2 = this.jdField_a_of_type_JavaUtilList;
        if (!paramBoolean) {
          break label83;
        }
      }
    }
    for (;;)
    {
      label83:
      try
      {
        this.jdField_a_of_type_JavaUtilList.add(0, localObject1);
        ((NearbyGrayTipsManager.GreetWording)localObject1).saveWording(paramGrayTipsConfig.createTime, paramGrayTipsConfig.randomWordings, paramBoolean);
        return;
      }
      finally {}
      this.jdField_a_of_type_JavaUtilList.add(localObject1);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    if (!this.jdField_a_of_type_Boolean) {
      c();
    }
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean a(long paramLong)
  {
    if (!this.jdField_a_of_type_Boolean) {
      c();
    }
    if (this.e == 0) {}
    do
    {
      return false;
      if (!a(paramLong, this.jdField_a_of_type_Long)) {
        break;
      }
    } while (this.h < this.e);
    return true;
    this.h = 0;
    this.jdField_a_of_type_Long = 0L;
    return false;
  }
  
  public boolean a(List paramList)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    int k;
    if (paramList != null)
    {
      bool1 = bool2;
      if (this.f > 0)
      {
        bool1 = bool2;
        if (this.g > 0)
        {
          i = paramList.size() - 1;
          j = 0;
          if (i < 0) {
            break label165;
          }
          if (!MessageUtils.a(((ChatMessage)paramList.get(i)).msgtype))
          {
            k = j + 1;
            j = k;
            if (k != this.g) {}
          }
        }
      }
    }
    label98:
    label162:
    label165:
    for (int j = i;; j = 0)
    {
      k = paramList.size() - 1;
      i = 0;
      if (k >= j)
      {
        if (63509 != ((ChatMessage)paramList.get(k)).msgtype) {
          break label162;
        }
        i += 1;
      }
      for (;;)
      {
        k -= 1;
        break label98;
        i -= 1;
        break;
        bool1 = bool2;
        if (i >= this.f) {
          bool1 = true;
        }
        return bool1;
      }
    }
  }
  
  public NearbyGrayTipsManager.GrayTipsConfig b(int paramInt1, int paramInt2, long paramLong)
  {
    if (!this.jdField_a_of_type_Boolean) {
      c();
    }
    if (!this.jdField_b_of_type_Boolean) {
      return null;
    }
    label253:
    label260:
    label267:
    for (;;)
    {
      Object localObject3;
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
        {
          Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          NearbyGrayTipsManager.GrayTipsConfig localGrayTipsConfig = null;
          if (!localIterator.hasNext()) {
            break label267;
          }
          Object localObject4 = (NearbyGrayTipsManager.GrayTipsConfig)localIterator.next();
          if ((localObject4 == null) || (((NearbyGrayTipsManager.GrayTipsConfig)localObject4).sceneId != 1) || (((NearbyGrayTipsManager.GrayTipsConfig)localObject4).sceneOne == null) || (!((NearbyGrayTipsManager.GrayTipsConfig)localObject4).sceneOne.sayHiTrigger)) {
            continue;
          }
          if (!((NearbyGrayTipsManager.GrayTipsConfig)localObject4).isValid(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt1, paramInt2, paramLong)) {
            break label260;
          }
          if (localGrayTipsConfig == null)
          {
            localObject3 = localObject4;
            break label253;
          }
          localObject3 = localObject4;
          if (localGrayTipsConfig.priority < ((NearbyGrayTipsManager.GrayTipsConfig)localObject4).priority) {
            break label253;
          }
          if (localGrayTipsConfig.priority != ((NearbyGrayTipsManager.GrayTipsConfig)localObject4).priority) {
            break label260;
          }
          localObject3 = localObject4;
          if (localGrayTipsConfig.createTime < ((NearbyGrayTipsManager.GrayTipsConfig)localObject4).createTime) {
            break label253;
          }
          break label260;
          localObject3 = localGrayTipsConfig;
          if (localGrayTipsConfig != null)
          {
            localObject4 = a(localGrayTipsConfig.id, true, true);
            localObject3 = localGrayTipsConfig;
            if (localObject4 != null)
            {
              localObject3 = localGrayTipsConfig;
              if (((NearbyGrayTipsManager.GrayTipStatisticData)localObject4).isLimit(localGrayTipsConfig, paramLong)) {
                localObject3 = null;
              }
            }
          }
          return (NearbyGrayTipsManager.GrayTipsConfig)localObject3;
        }
      }
      Object localObject2 = null;
      continue;
      for (;;)
      {
        localObject2 = localObject3;
        break;
        localObject3 = localObject2;
      }
    }
  }
  
  public void b()
  {
    ??? = new File(a());
    if ((??? != null) && (((File)???).exists()) && (((File)???).isDirectory()))
    {
      ??? = ((File)???).listFiles();
      if ((??? != null) && (???.length > 0))
      {
        int j = ???.length;
        int i = 0;
        while (i < j)
        {
          ???[i].delete();
          i += 1;
        }
      }
    }
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {}
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_b_of_type_Boolean = false;
      return;
    }
  }
  
  public NearbyGrayTipsManager.GrayTipsConfig c(int paramInt1, int paramInt2, long paramLong)
  {
    if (!this.jdField_a_of_type_Boolean) {
      c();
    }
    if (!this.jdField_b_of_type_Boolean) {
      return null;
    }
    Object localObject1 = null;
    label412:
    label630:
    label638:
    label645:
    label652:
    for (;;)
    {
      Object localObject4;
      Object localObject3;
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
        {
          Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          localObject1 = null;
          if (!localIterator.hasNext()) {
            break label652;
          }
          localObject4 = (NearbyGrayTipsManager.GrayTipsConfig)localIterator.next();
          if ((localObject4 == null) || (((NearbyGrayTipsManager.GrayTipsConfig)localObject4).sceneId != 2) || (((NearbyGrayTipsManager.GrayTipsConfig)localObject4).sceneTwo == null) || (!((NearbyGrayTipsManager.GrayTipsConfig)localObject4).sceneTwo.sayHiFrequencyControl) || (((NearbyGrayTipsManager.GrayTipsConfig)localObject4).sceneTwo.timeRange == 0) || (((NearbyGrayTipsManager.GrayTipsConfig)localObject4).sceneTwo.sayHiPeopleCount == 0)) {
            continue;
          }
          if (!((NearbyGrayTipsManager.GrayTipsConfig)localObject4).isValid(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt1, paramInt2, paramLong)) {
            break label645;
          }
          if (localObject1 == null)
          {
            localObject3 = localObject4;
            break label638;
          }
          localObject3 = localObject4;
          if (((NearbyGrayTipsManager.GrayTipsConfig)localObject1).priority < ((NearbyGrayTipsManager.GrayTipsConfig)localObject4).priority) {
            break label638;
          }
          if (((NearbyGrayTipsManager.GrayTipsConfig)localObject1).priority != ((NearbyGrayTipsManager.GrayTipsConfig)localObject4).priority) {
            break label645;
          }
          localObject3 = localObject4;
          if (((NearbyGrayTipsManager.GrayTipsConfig)localObject1).createTime < ((NearbyGrayTipsManager.GrayTipsConfig)localObject4).createTime) {
            break label638;
          }
          break label645;
        }
        localObject3 = localObject1;
        if (localObject1 != null)
        {
          localObject4 = a(((NearbyGrayTipsManager.GrayTipsConfig)localObject1).id, true, true);
          localObject3 = localObject1;
          if (localObject4 != null)
          {
            localObject3 = localObject1;
            if (((NearbyGrayTipsManager.GrayTipStatisticData)localObject4).isLimit((NearbyGrayTipsManager.GrayTipsConfig)localObject1, paramLong)) {
              localObject3 = null;
            }
          }
        }
        if ((localObject3 == null) || (((NearbyGrayTipsManager.GrayTipsConfig)localObject3).aioTypes == null) || (((NearbyGrayTipsManager.GrayTipsConfig)localObject3).aioTypes.size() <= 0)) {
          break label630;
        }
        localObject1 = new ArrayList();
        localObject4 = ((NearbyGrayTipsManager.GrayTipsConfig)localObject3).aioTypes.iterator();
        if (!((Iterator)localObject4).hasNext()) {
          break label412;
        }
        ??? = (Integer)((Iterator)localObject4).next();
        if (((Integer)???).intValue() == 1) {
          ((List)localObject1).addAll(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1001).a(AppConstants.ar, 1001));
        }
      }
      if (((Integer)???).intValue() == 2)
      {
        localList.addAll(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1010).a(AppConstants.aH, 1010));
        continue;
        paramLong = (paramLong - ((NearbyGrayTipsManager.GrayTipsConfig)localObject3).sceneTwo.timeRange * 60 * 1000) / 1000L;
        paramInt1 = localList.size() - 1;
        if (paramInt1 >= 0)
        {
          localObject4 = (MessageRecord)localList.get(paramInt1);
          if (localObject4 != null) {
            if (((MessageRecord)localObject4).time < paramLong) {
              localList.remove(paramInt1);
            }
          }
          for (;;)
          {
            paramInt1 -= 1;
            break;
            localList.remove(paramInt1);
          }
        }
        Collections.sort(localList, new qbk(this));
        localObject4 = (QQMessageFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(19);
        paramInt1 = 0;
        Object localObject2 = localList.iterator();
        if (((Iterator)localObject2).hasNext())
        {
          ??? = (MessageRecord)((Iterator)localObject2).next();
          ??? = ((QQMessageFacade)localObject4).a(((MessageRecord)???).senderuin, ((MessageRecord)???).istroop);
          if ((??? != null) && (!((QQMessageFacade.Message)???).hasReply))
          {
            paramInt2 = paramInt1 + 1;
            paramInt1 = paramInt2;
            if (paramInt2 < ((NearbyGrayTipsManager.GrayTipsConfig)localObject3).sceneTwo.sayHiPeopleCount) {}
          }
        }
        for (;;)
        {
          if (paramInt2 < ((NearbyGrayTipsManager.GrayTipsConfig)localObject3).sceneTwo.sayHiPeopleCount)
          {
            return null;
            break;
          }
          return (NearbyGrayTipsManager.GrayTipsConfig)localObject3;
          paramInt2 = paramInt1;
        }
        for (;;)
        {
          localObject2 = localObject3;
          break;
          localObject3 = localObject2;
        }
      }
    }
  }
  
  public void onDestroy() {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\NearbyGrayTipsManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */