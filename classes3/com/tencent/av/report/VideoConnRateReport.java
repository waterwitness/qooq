package com.tencent.av.report;

import android.os.Environment;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import gmt;
import gmu;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

public class VideoConnRateReport
{
  public static final int a = 0;
  static volatile VideoConnRateReport jdField_a_of_type_ComTencentAvReportVideoConnRateReport;
  public static final String a = "VideoConnRateReport";
  public static final int b = 1;
  public static final String b = "eNone";
  public static final int c = 100;
  public static final String c = "eMSFRecvInviteMsg";
  public static final int d = 3;
  public static final String d = "eMSFTransferInviteMsg";
  public static final String e = "eVideoServletCreate";
  public static final String f = "eVideoAddMsg";
  public static final String g = "eVideoMSFReceiverProcess";
  public static final String h = "eVideoRecvInviteMsg";
  public static final String i = "eVideoSendACK";
  public static final String j = "eMSFSendVideoACK";
  public static final String k = "actAVMsfConnRateReport";
  static final String l = "param_detail";
  static final String m = "param_peeruin";
  static final String n = "param_fromuin";
  private static String o = "";
  long jdField_a_of_type_Long = 0L;
  public Object a;
  ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public boolean a;
  ConcurrentHashMap b;
  public boolean b;
  final int e = 10240;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private VideoConnRateReport()
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public static VideoConnRateReport a()
  {
    if (jdField_a_of_type_ComTencentAvReportVideoConnRateReport == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentAvReportVideoConnRateReport == null)
      {
        jdField_a_of_type_ComTencentAvReportVideoConnRateReport = new VideoConnRateReport();
        o = Environment.getExternalStorageDirectory().getPath() + "/tencent/audio/";
      }
      return jdField_a_of_type_ComTencentAvReportVideoConnRateReport;
    }
    finally {}
  }
  
  private String a(String paramString)
  {
    long l1 = 0L;
    VideoSerializeData localVideoSerializeData = (VideoSerializeData)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString + "_" + "eMSFRecvInviteMsg");
    String str;
    if (localVideoSerializeData != null) {
      if (localVideoSerializeData.errCode == 0)
      {
        str = "" + "|STEP1_1_0_0";
        l1 = localVideoSerializeData.time;
        label76:
        localVideoSerializeData = (VideoSerializeData)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString + "_" + "eMSFTransferInviteMsg");
        if (localVideoSerializeData == null) {
          break label693;
        }
        if (localVideoSerializeData.errCode != 0) {
          break label648;
        }
        str = str + "|STEP2_1_0_" + (localVideoSerializeData.time - l1);
        label152:
        l1 = localVideoSerializeData.time;
        label158:
        localVideoSerializeData = (VideoSerializeData)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString + "_" + "eVideoAddMsg");
        if (localVideoSerializeData == null) {
          break label761;
        }
        if (localVideoSerializeData.errCode != 0) {
          break label716;
        }
        str = str + "|STEP3_1_0_" + (localVideoSerializeData.time - l1);
        label234:
        l1 = localVideoSerializeData.time;
        label240:
        localVideoSerializeData = (VideoSerializeData)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString + "_" + "eVideoMSFReceiverProcess");
        if (localVideoSerializeData == null) {
          break label829;
        }
        if (localVideoSerializeData.errCode != 0) {
          break label784;
        }
        str = str + "|STEP4_1_0_" + (localVideoSerializeData.time - l1);
        label316:
        l1 = localVideoSerializeData.time;
        label322:
        localVideoSerializeData = (VideoSerializeData)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString + "_" + "eVideoRecvInviteMsg");
        if (localVideoSerializeData == null) {
          break label897;
        }
        if (localVideoSerializeData.errCode != 0) {
          break label852;
        }
        str = str + "|STEP5_1_0_" + (localVideoSerializeData.time - l1);
        label398:
        l1 = localVideoSerializeData.time;
        label404:
        localVideoSerializeData = (VideoSerializeData)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString + "_" + "eVideoSendACK");
        if (localVideoSerializeData == null) {
          break label965;
        }
        if (localVideoSerializeData.errCode != 0) {
          break label920;
        }
        str = str + "|STEP6_1_0_" + (localVideoSerializeData.time - l1);
        label480:
        l1 = localVideoSerializeData.time;
        label486:
        localVideoSerializeData = (VideoSerializeData)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString + "_" + "eMSFSendVideoACK");
        if (localVideoSerializeData == null) {
          break label1033;
        }
        if (localVideoSerializeData.errCode != 0) {
          break label988;
        }
        paramString = str + "|STEP7_1_0_" + (localVideoSerializeData.time - l1);
        label562:
        l1 = localVideoSerializeData.time;
      }
    }
    for (;;)
    {
      return paramString + "|";
      str = "" + "|STEP1_2_" + localVideoSerializeData.errCode + "_0";
      break;
      str = "" + "|STEP1_0_0_0";
      break label76;
      label648:
      str = str + "|STEP2_2_" + localVideoSerializeData.errCode + "_" + (localVideoSerializeData.time - l1);
      break label152;
      label693:
      str = str + "|STEP2_1_0_0";
      break label158;
      label716:
      str = str + "|STEP3_2_" + localVideoSerializeData.errCode + "_" + (localVideoSerializeData.time - l1);
      break label234;
      label761:
      str = str + "|STEP3_0_0_0";
      break label240;
      label784:
      str = str + "|STEP4_2_" + localVideoSerializeData.errCode + "_" + (localVideoSerializeData.time - l1);
      break label316;
      label829:
      str = str + "|STEP4_0_0_0";
      break label322;
      label852:
      str = str + "|STEP5_2_" + localVideoSerializeData.errCode + "_" + (localVideoSerializeData.time - l1);
      break label398;
      label897:
      str = str + "|STEP5_0_0_0";
      break label404;
      label920:
      str = str + "|STEP6_2_" + localVideoSerializeData.errCode + "_" + (localVideoSerializeData.time - l1);
      break label480;
      label965:
      str = str + "|STEP6_0_0_0";
      break label486;
      label988:
      paramString = str + "|STEP7_2_" + localVideoSerializeData.errCode + "_" + (localVideoSerializeData.time - l1);
      break label562;
      label1033:
      paramString = str + "|STEP7_0_0_0";
    }
  }
  
  private void a(String paramString)
  {
    a(paramString, "eMSFRecvInviteMsg");
    a(paramString, "eMSFTransferInviteMsg");
    a(paramString, "eVideoAddMsg");
    a(paramString, "eVideoMSFReceiverProcess");
    a(paramString, "eVideoRecvInviteMsg");
    a(paramString, "eVideoSendACK");
    a(paramString, "eMSFSendVideoACK");
  }
  
  private void a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      do
      {
        return;
        paramString1 = (String)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1 + "_" + paramString2);
      } while (paramString1 == null);
      paramString1 = new File(o + paramString1);
    } while ((paramString1 == null) || (!paramString1.exists()));
    paramString1.delete();
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: new 101	java/io/File
    //   3: dup
    //   4: getstatic 69	com/tencent/av/report/VideoConnRateReport:o	Ljava/lang/String;
    //   7: invokespecial 198	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: invokevirtual 217	java/io/File:listFiles	()[Ljava/io/File;
    //   13: astore_1
    //   14: aload_1
    //   15: ifnull +8 -> 23
    //   18: aload_1
    //   19: arraylength
    //   20: ifgt +4 -> 24
    //   23: return
    //   24: iconst_0
    //   25: istore 6
    //   27: iload 6
    //   29: aload_1
    //   30: arraylength
    //   31: if_icmpge +78 -> 109
    //   34: aload_1
    //   35: iload 6
    //   37: aaload
    //   38: astore_2
    //   39: aload_2
    //   40: ifnull +22 -> 62
    //   43: aload_2
    //   44: invokevirtual 220	java/io/File:isFile	()Z
    //   47: ifeq +10 -> 57
    //   50: aload_2
    //   51: invokevirtual 202	java/io/File:exists	()Z
    //   54: ifne +17 -> 71
    //   57: aload_2
    //   58: invokevirtual 205	java/io/File:delete	()Z
    //   61: pop
    //   62: iload 6
    //   64: iconst_1
    //   65: iadd
    //   66: istore 6
    //   68: goto -41 -> 27
    //   71: aload_2
    //   72: invokevirtual 223	java/io/File:getName	()Ljava/lang/String;
    //   75: astore_3
    //   76: aload_3
    //   77: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   80: ifne -18 -> 62
    //   83: aload_3
    //   84: ldc -31
    //   86: invokevirtual 228	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   89: ifeq -27 -> 62
    //   92: aload_0
    //   93: aload_3
    //   94: iconst_1
    //   95: invokevirtual 231	com/tencent/av/report/VideoConnRateReport:a	(Ljava/lang/String;Z)Z
    //   98: ifne -36 -> 62
    //   101: aload_2
    //   102: invokevirtual 205	java/io/File:delete	()Z
    //   105: pop
    //   106: goto -44 -> 62
    //   109: new 233	java/util/ArrayList
    //   112: dup
    //   113: invokespecial 234	java/util/ArrayList:<init>	()V
    //   116: astore_2
    //   117: aload_0
    //   118: getfield 84	com/tencent/av/report/VideoConnRateReport:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   121: invokevirtual 238	java/util/concurrent/ConcurrentHashMap:entrySet	()Ljava/util/Set;
    //   124: invokeinterface 244 1 0
    //   129: astore_1
    //   130: aload_1
    //   131: invokeinterface 249 1 0
    //   136: ifeq +82 -> 218
    //   139: aload_1
    //   140: invokeinterface 253 1 0
    //   145: checkcast 255	java/util/Map$Entry
    //   148: invokeinterface 258 1 0
    //   153: checkcast 196	java/lang/String
    //   156: astore_3
    //   157: aload_3
    //   158: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   161: ifne -31 -> 130
    //   164: aload_3
    //   165: iconst_0
    //   166: aload_3
    //   167: ldc 117
    //   169: invokevirtual 262	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   172: invokevirtual 266	java/lang/String:substring	(II)Ljava/lang/String;
    //   175: astore_3
    //   176: aload_3
    //   177: ifnull -47 -> 130
    //   180: aload_2
    //   181: aload_3
    //   182: invokevirtual 269	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   185: ifne -55 -> 130
    //   188: aload_3
    //   189: aload_0
    //   190: getfield 77	com/tencent/av/report/VideoConnRateReport:jdField_a_of_type_Long	J
    //   193: invokestatic 273	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   196: invokevirtual 276	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   199: ifne -69 -> 130
    //   202: aload_2
    //   203: aload_3
    //   204: invokevirtual 279	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   207: pop
    //   208: goto -78 -> 130
    //   211: astore_3
    //   212: iconst_0
    //   213: ifeq -83 -> 130
    //   216: aload_3
    //   217: athrow
    //   218: iconst_0
    //   219: istore 6
    //   221: iload 6
    //   223: aload_2
    //   224: invokevirtual 283	java/util/ArrayList:size	()I
    //   227: if_icmpge -204 -> 23
    //   230: aload_2
    //   231: iload 6
    //   233: invokevirtual 286	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   236: checkcast 196	java/lang/String
    //   239: astore_3
    //   240: aload_3
    //   241: ifnull +72 -> 313
    //   244: aload_0
    //   245: aload_3
    //   246: invokespecial 288	com/tencent/av/report/VideoConnRateReport:a	(Ljava/lang/String;)Ljava/lang/String;
    //   249: astore_1
    //   250: aload_0
    //   251: getfield 84	com/tencent/av/report/VideoConnRateReport:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   254: new 92	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   261: aload_3
    //   262: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: ldc 117
    //   267: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: ldc 19
    //   272: invokestatic 291	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   275: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: invokevirtual 121	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   284: checkcast 123	com/tencent/av/report/VideoSerializeData
    //   287: astore 5
    //   289: ldc 67
    //   291: aload_1
    //   292: invokevirtual 276	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   295: ifne +13 -> 308
    //   298: aload_1
    //   299: ldc_w 293
    //   302: invokevirtual 228	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   305: ifne +17 -> 322
    //   308: aload_0
    //   309: aload_3
    //   310: invokespecial 295	com/tencent/av/report/VideoConnRateReport:a	(Ljava/lang/String;)V
    //   313: iload 6
    //   315: iconst_1
    //   316: iadd
    //   317: istore 6
    //   319: goto -98 -> 221
    //   322: new 297	java/util/HashMap
    //   325: dup
    //   326: invokespecial 298	java/util/HashMap:<init>	()V
    //   329: astore 4
    //   331: aload 4
    //   333: ldc 47
    //   335: aload_1
    //   336: invokevirtual 302	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   339: pop
    //   340: ldc_w 304
    //   343: astore_1
    //   344: aload 5
    //   346: ifnull +44 -> 390
    //   349: aload 4
    //   351: ldc 50
    //   353: aload 5
    //   355: getfield 307	com/tencent/av/report/VideoSerializeData:toUin	J
    //   358: invokestatic 273	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   361: invokevirtual 302	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   364: pop
    //   365: aload 4
    //   367: ldc 53
    //   369: aload 5
    //   371: getfield 310	com/tencent/av/report/VideoSerializeData:fromUin	J
    //   374: invokestatic 273	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   377: invokevirtual 302	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   380: pop
    //   381: aload 5
    //   383: getfield 310	com/tencent/av/report/VideoSerializeData:fromUin	J
    //   386: invokestatic 273	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   389: astore_1
    //   390: invokestatic 316	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   393: invokestatic 321	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   396: aload_1
    //   397: ldc 44
    //   399: iconst_1
    //   400: lconst_0
    //   401: lconst_0
    //   402: aload 4
    //   404: ldc 67
    //   406: iconst_1
    //   407: invokevirtual 324	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   410: aload_0
    //   411: aload_3
    //   412: invokespecial 295	com/tencent/av/report/VideoConnRateReport:a	(Ljava/lang/String;)V
    //   415: goto -102 -> 313
    //   418: astore_3
    //   419: goto -289 -> 130
    //   422: astore_3
    //   423: goto -293 -> 130
    //   426: astore_3
    //   427: goto -297 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	430	0	this	VideoConnRateReport
    //   13	384	1	localObject1	Object
    //   38	193	2	localArrayList	java.util.ArrayList
    //   75	129	3	str1	String
    //   211	6	3	localObject2	Object
    //   239	173	3	str2	String
    //   418	1	3	localException	Exception
    //   422	1	3	localNullPointerException	NullPointerException
    //   426	1	3	localIndexOutOfBoundsException	IndexOutOfBoundsException
    //   329	74	4	localHashMap	java.util.HashMap
    //   287	95	5	localVideoSerializeData	VideoSerializeData
    //   25	293	6	i1	int
    // Exception table:
    //   from	to	target	type
    //   164	176	211	finally
    //   164	176	418	java/lang/Exception
    //   164	176	422	java/lang/NullPointerException
    //   164	176	426	java/lang/IndexOutOfBoundsException
  }
  
  /* Error */
  private void d()
  {
    // Byte code:
    //   0: new 101	java/io/File
    //   3: dup
    //   4: getstatic 69	com/tencent/av/report/VideoConnRateReport:o	Ljava/lang/String;
    //   7: invokespecial 198	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: invokevirtual 217	java/io/File:listFiles	()[Ljava/io/File;
    //   13: astore 6
    //   15: aload 6
    //   17: ifnonnull +4 -> 21
    //   20: return
    //   21: iconst_0
    //   22: istore 8
    //   24: iload 8
    //   26: aload 6
    //   28: arraylength
    //   29: if_icmpge -9 -> 20
    //   32: aload 6
    //   34: iload 8
    //   36: aaload
    //   37: astore 7
    //   39: aload 7
    //   41: ifnull +25 -> 66
    //   44: aload 7
    //   46: invokevirtual 220	java/io/File:isFile	()Z
    //   49: ifeq +11 -> 60
    //   52: aload 7
    //   54: invokevirtual 202	java/io/File:exists	()Z
    //   57: ifne +18 -> 75
    //   60: aload 7
    //   62: invokevirtual 205	java/io/File:delete	()Z
    //   65: pop
    //   66: iload 8
    //   68: iconst_1
    //   69: iadd
    //   70: istore 8
    //   72: goto -48 -> 24
    //   75: aload 7
    //   77: invokevirtual 223	java/io/File:getName	()Ljava/lang/String;
    //   80: astore 5
    //   82: aload 5
    //   84: ifnull -18 -> 66
    //   87: aload 5
    //   89: ldc_w 330
    //   92: invokevirtual 228	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   95: ifeq -29 -> 66
    //   98: aload 7
    //   100: invokevirtual 334	java/io/File:length	()J
    //   103: lstore 11
    //   105: lload 11
    //   107: lconst_0
    //   108: lcmp
    //   109: ifle +12 -> 121
    //   112: lload 11
    //   114: ldc2_w 335
    //   117: lcmp
    //   118: ifle +12 -> 130
    //   121: aload 7
    //   123: invokevirtual 205	java/io/File:delete	()Z
    //   126: pop
    //   127: goto -61 -> 66
    //   130: aload 5
    //   132: ifnull -66 -> 66
    //   135: lload 11
    //   137: l2i
    //   138: newarray <illegal type>
    //   140: astore 4
    //   142: aload 4
    //   144: ifnonnull +12 -> 156
    //   147: aload 7
    //   149: invokevirtual 205	java/io/File:delete	()Z
    //   152: pop
    //   153: goto -87 -> 66
    //   156: iconst_1
    //   157: istore 10
    //   159: aconst_null
    //   160: astore_3
    //   161: aconst_null
    //   162: astore_2
    //   163: new 338	java/io/FileInputStream
    //   166: dup
    //   167: aload 7
    //   169: invokespecial 341	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   172: astore_1
    //   173: aload_1
    //   174: aload 4
    //   176: invokevirtual 345	java/io/FileInputStream:read	([B)I
    //   179: pop
    //   180: iload 10
    //   182: istore 9
    //   184: aload_1
    //   185: ifnull +11 -> 196
    //   188: aload_1
    //   189: invokevirtual 348	java/io/FileInputStream:close	()V
    //   192: iload 10
    //   194: istore 9
    //   196: iload 9
    //   198: ifeq +9 -> 207
    //   201: aload 4
    //   203: arraylength
    //   204: ifgt +102 -> 306
    //   207: aload 7
    //   209: invokevirtual 205	java/io/File:delete	()Z
    //   212: pop
    //   213: goto -147 -> 66
    //   216: astore_1
    //   217: iconst_0
    //   218: istore 9
    //   220: goto -24 -> 196
    //   223: astore_1
    //   224: aconst_null
    //   225: astore_1
    //   226: aload_1
    //   227: ifnull +7 -> 234
    //   230: aload_1
    //   231: invokevirtual 348	java/io/FileInputStream:close	()V
    //   234: aload 7
    //   236: invokevirtual 205	java/io/File:delete	()Z
    //   239: pop
    //   240: goto -174 -> 66
    //   243: astore_1
    //   244: aload_2
    //   245: astore_1
    //   246: aload_1
    //   247: ifnull +7 -> 254
    //   250: aload_1
    //   251: invokevirtual 348	java/io/FileInputStream:close	()V
    //   254: aload 7
    //   256: invokevirtual 205	java/io/File:delete	()Z
    //   259: pop
    //   260: goto -194 -> 66
    //   263: astore_1
    //   264: aload_3
    //   265: astore_2
    //   266: aload_2
    //   267: ifnull +7 -> 274
    //   270: aload_2
    //   271: invokevirtual 348	java/io/FileInputStream:close	()V
    //   274: iconst_1
    //   275: istore 9
    //   277: iload 9
    //   279: ifeq +9 -> 288
    //   282: aload 4
    //   284: arraylength
    //   285: ifgt +19 -> 304
    //   288: aload 7
    //   290: invokevirtual 205	java/io/File:delete	()Z
    //   293: pop
    //   294: goto -228 -> 66
    //   297: astore_2
    //   298: iconst_0
    //   299: istore 9
    //   301: goto -24 -> 277
    //   304: aload_1
    //   305: athrow
    //   306: aload 4
    //   308: ldc_w 350
    //   311: new 352	SharpSvrPack/SharpVideoMsg
    //   314: dup
    //   315: invokespecial 353	SharpSvrPack/SharpVideoMsg:<init>	()V
    //   318: invokestatic 359	mqq/app/Packet:decodePacket	([BLjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   321: checkcast 352	SharpSvrPack/SharpVideoMsg
    //   324: astore_2
    //   325: iconst_1
    //   326: istore 9
    //   328: iload 9
    //   330: ifeq +35 -> 365
    //   333: aload_2
    //   334: ifnull +31 -> 365
    //   337: aload_2
    //   338: getfield 362	SharpSvrPack/SharpVideoMsg:msg_type	J
    //   341: ldc2_w 363
    //   344: lcmp
    //   345: ifne +20 -> 365
    //   348: aload_2
    //   349: getfield 368	SharpSvrPack/SharpVideoMsg:to_uin	Ljava/util/ArrayList;
    //   352: ifnull +13 -> 365
    //   355: aload_2
    //   356: getfield 368	SharpSvrPack/SharpVideoMsg:to_uin	Ljava/util/ArrayList;
    //   359: invokevirtual 283	java/util/ArrayList:size	()I
    //   362: ifgt +21 -> 383
    //   365: aload 7
    //   367: invokevirtual 205	java/io/File:delete	()Z
    //   370: pop
    //   371: goto -305 -> 66
    //   374: astore_1
    //   375: iconst_0
    //   376: istore 9
    //   378: aconst_null
    //   379: astore_2
    //   380: goto -52 -> 328
    //   383: aload 5
    //   385: iconst_0
    //   386: aload 5
    //   388: ldc 117
    //   390: invokevirtual 262	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   393: invokevirtual 266	java/lang/String:substring	(II)Ljava/lang/String;
    //   396: astore_1
    //   397: aload 5
    //   399: aload 5
    //   401: ldc 117
    //   403: invokevirtual 262	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   406: iconst_1
    //   407: iadd
    //   408: aload 5
    //   410: ldc 117
    //   412: invokevirtual 371	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   415: invokevirtual 266	java/lang/String:substring	(II)Ljava/lang/String;
    //   418: astore 4
    //   420: aload 5
    //   422: aload 5
    //   424: ldc 117
    //   426: invokevirtual 371	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   429: iconst_1
    //   430: iadd
    //   431: aload 5
    //   433: ldc_w 373
    //   436: invokevirtual 262	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   439: invokevirtual 266	java/lang/String:substring	(II)Ljava/lang/String;
    //   442: astore_3
    //   443: aload_1
    //   444: ifnull +12 -> 456
    //   447: aload 4
    //   449: ifnull +7 -> 456
    //   452: aload_3
    //   453: ifnonnull +60 -> 513
    //   456: aload 7
    //   458: invokevirtual 205	java/io/File:delete	()Z
    //   461: pop
    //   462: goto -396 -> 66
    //   465: astore_1
    //   466: aload 7
    //   468: invokevirtual 205	java/io/File:delete	()Z
    //   471: pop
    //   472: goto -406 -> 66
    //   475: astore_1
    //   476: aload 7
    //   478: invokevirtual 205	java/io/File:delete	()Z
    //   481: pop
    //   482: goto -416 -> 66
    //   485: astore_1
    //   486: aconst_null
    //   487: astore_3
    //   488: aconst_null
    //   489: astore_2
    //   490: aload_3
    //   491: ifnull +11 -> 502
    //   494: aload_2
    //   495: ifnull +7 -> 502
    //   498: iconst_0
    //   499: ifne +12 -> 511
    //   502: aload 7
    //   504: invokevirtual 205	java/io/File:delete	()Z
    //   507: pop
    //   508: goto -442 -> 66
    //   511: aload_1
    //   512: athrow
    //   513: ldc 19
    //   515: aload_1
    //   516: invokevirtual 276	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   519: ifeq +70 -> 589
    //   522: ldc 19
    //   524: astore_1
    //   525: aload 4
    //   527: invokestatic 378	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   530: invokevirtual 381	java/lang/Long:longValue	()J
    //   533: lstore 11
    //   535: aload_3
    //   536: invokestatic 386	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   539: invokevirtual 389	java/lang/Integer:intValue	()I
    //   542: istore 9
    //   544: aload_0
    //   545: aload_1
    //   546: aload_2
    //   547: getfield 362	SharpSvrPack/SharpVideoMsg:msg_type	J
    //   550: aload_2
    //   551: getfield 392	SharpSvrPack/SharpVideoMsg:msg_seq	J
    //   554: lload 11
    //   556: aload_2
    //   557: getfield 368	SharpSvrPack/SharpVideoMsg:to_uin	Ljava/util/ArrayList;
    //   560: iconst_0
    //   561: invokevirtual 286	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   564: checkcast 375	java/lang/Long
    //   567: invokevirtual 381	java/lang/Long:longValue	()J
    //   570: aload_2
    //   571: getfield 395	SharpSvrPack/SharpVideoMsg:from_uin	J
    //   574: iload 9
    //   576: invokevirtual 398	com/tencent/av/report/VideoConnRateReport:a	(Ljava/lang/String;JJJJJI)Z
    //   579: pop
    //   580: aload 7
    //   582: invokevirtual 205	java/io/File:delete	()Z
    //   585: pop
    //   586: goto -520 -> 66
    //   589: ldc 23
    //   591: aload_1
    //   592: invokevirtual 276	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   595: ifeq +9 -> 604
    //   598: ldc 23
    //   600: astore_1
    //   601: goto -76 -> 525
    //   604: ldc 29
    //   606: aload_1
    //   607: invokevirtual 276	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   610: ifeq +9 -> 619
    //   613: ldc 29
    //   615: astore_1
    //   616: goto -91 -> 525
    //   619: ldc 32
    //   621: aload_1
    //   622: invokevirtual 276	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   625: ifeq +9 -> 634
    //   628: ldc 32
    //   630: astore_1
    //   631: goto -106 -> 525
    //   634: ldc 41
    //   636: aload_1
    //   637: invokevirtual 276	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   640: ifeq +9 -> 649
    //   643: ldc 41
    //   645: astore_1
    //   646: goto -121 -> 525
    //   649: aload 7
    //   651: invokevirtual 205	java/io/File:delete	()Z
    //   654: pop
    //   655: goto -589 -> 66
    //   658: astore_1
    //   659: aload 7
    //   661: invokevirtual 205	java/io/File:delete	()Z
    //   664: pop
    //   665: goto -599 -> 66
    //   668: astore_1
    //   669: aload_1
    //   670: athrow
    //   671: astore_1
    //   672: goto -438 -> 234
    //   675: astore_1
    //   676: goto -422 -> 254
    //   679: astore 4
    //   681: aload_1
    //   682: astore_3
    //   683: aconst_null
    //   684: astore_2
    //   685: aload 4
    //   687: astore_1
    //   688: goto -198 -> 490
    //   691: astore 5
    //   693: aload_1
    //   694: astore_3
    //   695: aload 4
    //   697: astore_2
    //   698: aload 5
    //   700: astore_1
    //   701: goto -211 -> 490
    //   704: astore_1
    //   705: goto -229 -> 476
    //   708: astore_1
    //   709: goto -233 -> 476
    //   712: astore_1
    //   713: goto -247 -> 466
    //   716: astore_1
    //   717: goto -251 -> 466
    //   720: astore_3
    //   721: aload_1
    //   722: astore_2
    //   723: aload_3
    //   724: astore_1
    //   725: goto -459 -> 266
    //   728: astore_2
    //   729: goto -483 -> 246
    //   732: astore_2
    //   733: goto -507 -> 226
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	736	0	this	VideoConnRateReport
    //   172	17	1	localFileInputStream	java.io.FileInputStream
    //   216	1	1	localIOException1	java.io.IOException
    //   223	1	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   225	6	1	localObject1	Object
    //   243	1	1	localIOException2	java.io.IOException
    //   245	6	1	localObject2	Object
    //   263	42	1	localObject3	Object
    //   374	1	1	localException1	Exception
    //   396	48	1	str1	String
    //   465	1	1	localIndexOutOfBoundsException1	IndexOutOfBoundsException
    //   475	1	1	localNullPointerException1	NullPointerException
    //   485	31	1	localObject4	Object
    //   524	122	1	str2	String
    //   658	1	1	localException2	Exception
    //   668	2	1	localObject5	Object
    //   671	1	1	localIOException3	java.io.IOException
    //   675	7	1	localIOException4	java.io.IOException
    //   687	14	1	localObject6	Object
    //   704	1	1	localNullPointerException2	NullPointerException
    //   708	1	1	localNullPointerException3	NullPointerException
    //   712	1	1	localIndexOutOfBoundsException2	IndexOutOfBoundsException
    //   716	6	1	localIndexOutOfBoundsException3	IndexOutOfBoundsException
    //   724	1	1	localObject7	Object
    //   162	109	2	localObject8	Object
    //   297	1	2	localIOException5	java.io.IOException
    //   324	399	2	localObject9	Object
    //   728	1	2	localIOException6	java.io.IOException
    //   732	1	2	localFileNotFoundException2	java.io.FileNotFoundException
    //   160	535	3	localObject10	Object
    //   720	4	3	localObject11	Object
    //   140	386	4	localObject12	Object
    //   679	17	4	localObject13	Object
    //   80	352	5	str3	String
    //   691	8	5	localObject14	Object
    //   13	20	6	arrayOfFile	File[]
    //   37	623	7	localFile	File
    //   22	49	8	i1	int
    //   182	393	9	i2	int
    //   157	36	10	i3	int
    //   103	452	11	l1	long
    // Exception table:
    //   from	to	target	type
    //   188	192	216	java/io/IOException
    //   163	173	223	java/io/FileNotFoundException
    //   163	173	243	java/io/IOException
    //   163	173	263	finally
    //   270	274	297	java/io/IOException
    //   306	325	374	java/lang/Exception
    //   383	397	465	java/lang/IndexOutOfBoundsException
    //   383	397	475	java/lang/NullPointerException
    //   383	397	485	finally
    //   525	544	658	java/lang/Exception
    //   525	544	668	finally
    //   230	234	671	java/io/IOException
    //   250	254	675	java/io/IOException
    //   397	420	679	finally
    //   420	443	691	finally
    //   397	420	704	java/lang/NullPointerException
    //   420	443	708	java/lang/NullPointerException
    //   397	420	712	java/lang/IndexOutOfBoundsException
    //   420	443	716	java/lang/IndexOutOfBoundsException
    //   173	180	720	finally
    //   173	180	728	java/io/IOException
    //   173	180	732	java/io/FileNotFoundException
  }
  
  public void a()
  {
    new Thread(new gmt(this)).start();
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    File localFile;
    do
    {
      do
      {
        return;
      } while (((!paramString.equals("eVideoRecvInviteMsg")) && (!paramString.equals("eVideoSendACK"))) || (!Environment.getExternalStorageState().equals("mounted")));
      localFile = new File(o);
    } while ((localFile == null) || ((!localFile.exists()) && (!localFile.mkdirs())));
    a(paramString, paramLong1, paramLong2, SystemClock.elapsedRealtime(), paramLong3, paramLong4, paramInt);
  }
  
  /* Error */
  boolean a(String paramString, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +9 -> 13
    //   7: iconst_0
    //   8: istore 17
    //   10: iload 17
    //   12: ireturn
    //   13: aconst_null
    //   14: astore 15
    //   16: aconst_null
    //   17: astore 14
    //   19: aload_1
    //   20: ldc 19
    //   22: invokevirtual 276	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   25: ifne +57 -> 82
    //   28: aload_1
    //   29: ldc 23
    //   31: invokevirtual 276	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   34: ifne +48 -> 82
    //   37: aload_1
    //   38: ldc 29
    //   40: invokevirtual 276	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   43: ifne +39 -> 82
    //   46: aload_1
    //   47: ldc 32
    //   49: invokevirtual 276	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   52: ifne +30 -> 82
    //   55: aload_1
    //   56: ldc 35
    //   58: invokevirtual 276	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   61: ifne +21 -> 82
    //   64: aload_1
    //   65: ldc 38
    //   67: invokevirtual 276	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   70: ifne +12 -> 82
    //   73: aload_1
    //   74: ldc 41
    //   76: invokevirtual 276	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   79: ifeq +465 -> 544
    //   82: new 92	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   89: aload_1
    //   90: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: ldc 117
    //   95: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokestatic 425	android/os/SystemClock:elapsedRealtime	()J
    //   101: invokestatic 273	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   104: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: iload 12
    //   109: invokevirtual 153	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   112: ldc -31
    //   114: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: astore 13
    //   122: ldc 67
    //   124: aload 13
    //   126: invokevirtual 276	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   129: ifeq +5 -> 134
    //   132: iconst_0
    //   133: ireturn
    //   134: new 123	com/tencent/av/report/VideoSerializeData
    //   137: dup
    //   138: aload_1
    //   139: lload_2
    //   140: lload 4
    //   142: lload 6
    //   144: lload 8
    //   146: lload 10
    //   148: iload 12
    //   150: invokespecial 428	com/tencent/av/report/VideoSerializeData:<init>	(Ljava/lang/String;JJJJJI)V
    //   153: astore 16
    //   155: aload 16
    //   157: ifnonnull +5 -> 162
    //   160: iconst_0
    //   161: ireturn
    //   162: new 430	java/io/ObjectOutputStream
    //   165: dup
    //   166: new 432	java/io/FileOutputStream
    //   169: dup
    //   170: new 92	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   177: getstatic 69	com/tencent/av/report/VideoConnRateReport:o	Ljava/lang/String;
    //   180: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: aload 13
    //   185: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: invokespecial 433	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   194: invokespecial 436	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   197: astore_1
    //   198: aload_1
    //   199: ifnull +13 -> 212
    //   202: aload_1
    //   203: aload 16
    //   205: invokevirtual 440	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   208: aload_1
    //   209: invokevirtual 443	java/io/ObjectOutputStream:flush	()V
    //   212: aload_1
    //   213: ifnull +7 -> 220
    //   216: aload_1
    //   217: invokevirtual 444	java/io/ObjectOutputStream:close	()V
    //   220: iconst_1
    //   221: istore 18
    //   223: iload 18
    //   225: istore 17
    //   227: iload 18
    //   229: ifne -219 -> 10
    //   232: new 101	java/io/File
    //   235: dup
    //   236: new 92	java/lang/StringBuilder
    //   239: dup
    //   240: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   243: getstatic 69	com/tencent/av/report/VideoConnRateReport:o	Ljava/lang/String;
    //   246: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: aload 13
    //   251: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: invokespecial 198	java/io/File:<init>	(Ljava/lang/String;)V
    //   260: astore_1
    //   261: iload 18
    //   263: istore 17
    //   265: aload_1
    //   266: ifnull -256 -> 10
    //   269: iload 18
    //   271: istore 17
    //   273: aload_1
    //   274: invokevirtual 202	java/io/File:exists	()Z
    //   277: ifeq -267 -> 10
    //   280: aload_1
    //   281: invokevirtual 205	java/io/File:delete	()Z
    //   284: pop
    //   285: iload 18
    //   287: ireturn
    //   288: astore_1
    //   289: iconst_0
    //   290: istore 18
    //   292: goto -69 -> 223
    //   295: astore_1
    //   296: aconst_null
    //   297: astore_1
    //   298: aload_1
    //   299: ifnull +7 -> 306
    //   302: aload_1
    //   303: invokevirtual 444	java/io/ObjectOutputStream:close	()V
    //   306: iconst_0
    //   307: istore 18
    //   309: new 101	java/io/File
    //   312: dup
    //   313: new 92	java/lang/StringBuilder
    //   316: dup
    //   317: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   320: getstatic 69	com/tencent/av/report/VideoConnRateReport:o	Ljava/lang/String;
    //   323: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: aload 13
    //   328: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: invokespecial 198	java/io/File:<init>	(Ljava/lang/String;)V
    //   337: astore_1
    //   338: iload 18
    //   340: istore 17
    //   342: aload_1
    //   343: ifnull -333 -> 10
    //   346: iload 18
    //   348: istore 17
    //   350: aload_1
    //   351: invokevirtual 202	java/io/File:exists	()Z
    //   354: ifeq -344 -> 10
    //   357: aload_1
    //   358: invokevirtual 205	java/io/File:delete	()Z
    //   361: pop
    //   362: iconst_0
    //   363: ireturn
    //   364: astore_1
    //   365: goto -59 -> 306
    //   368: astore_1
    //   369: aload 14
    //   371: astore_1
    //   372: aload_1
    //   373: ifnull +7 -> 380
    //   376: aload_1
    //   377: invokevirtual 444	java/io/ObjectOutputStream:close	()V
    //   380: iconst_0
    //   381: istore 18
    //   383: new 101	java/io/File
    //   386: dup
    //   387: new 92	java/lang/StringBuilder
    //   390: dup
    //   391: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   394: getstatic 69	com/tencent/av/report/VideoConnRateReport:o	Ljava/lang/String;
    //   397: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: aload 13
    //   402: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   408: invokespecial 198	java/io/File:<init>	(Ljava/lang/String;)V
    //   411: astore_1
    //   412: iload 18
    //   414: istore 17
    //   416: aload_1
    //   417: ifnull -407 -> 10
    //   420: iload 18
    //   422: istore 17
    //   424: aload_1
    //   425: invokevirtual 202	java/io/File:exists	()Z
    //   428: ifeq -418 -> 10
    //   431: aload_1
    //   432: invokevirtual 205	java/io/File:delete	()Z
    //   435: pop
    //   436: iconst_0
    //   437: ireturn
    //   438: astore_1
    //   439: goto -59 -> 380
    //   442: astore_1
    //   443: aload 15
    //   445: astore_1
    //   446: aload_1
    //   447: ifnull +7 -> 454
    //   450: aload_1
    //   451: invokevirtual 444	java/io/ObjectOutputStream:close	()V
    //   454: iconst_1
    //   455: istore 18
    //   457: iload 18
    //   459: istore 17
    //   461: iload 18
    //   463: ifne -453 -> 10
    //   466: new 101	java/io/File
    //   469: dup
    //   470: new 92	java/lang/StringBuilder
    //   473: dup
    //   474: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   477: getstatic 69	com/tencent/av/report/VideoConnRateReport:o	Ljava/lang/String;
    //   480: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: aload 13
    //   485: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   491: invokespecial 198	java/io/File:<init>	(Ljava/lang/String;)V
    //   494: astore_1
    //   495: iload 18
    //   497: istore 17
    //   499: aload_1
    //   500: ifnull -490 -> 10
    //   503: iload 18
    //   505: istore 17
    //   507: aload_1
    //   508: invokevirtual 202	java/io/File:exists	()Z
    //   511: ifeq -501 -> 10
    //   514: aload_1
    //   515: invokevirtual 205	java/io/File:delete	()Z
    //   518: pop
    //   519: iload 18
    //   521: ireturn
    //   522: astore_1
    //   523: iconst_0
    //   524: istore 18
    //   526: goto -69 -> 457
    //   529: astore 14
    //   531: goto -85 -> 446
    //   534: astore 14
    //   536: goto -164 -> 372
    //   539: astore 14
    //   541: goto -243 -> 298
    //   544: ldc 67
    //   546: astore 13
    //   548: goto -426 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	551	0	this	VideoConnRateReport
    //   0	551	1	paramString	String
    //   0	551	2	paramLong1	long
    //   0	551	4	paramLong2	long
    //   0	551	6	paramLong3	long
    //   0	551	8	paramLong4	long
    //   0	551	10	paramLong5	long
    //   0	551	12	paramInt	int
    //   120	427	13	str	String
    //   17	353	14	localObject1	Object
    //   529	1	14	localObject2	Object
    //   534	1	14	localIOException	java.io.IOException
    //   539	1	14	localFileNotFoundException	java.io.FileNotFoundException
    //   14	430	15	localObject3	Object
    //   153	51	16	localVideoSerializeData	VideoSerializeData
    //   8	498	17	bool1	boolean
    //   221	304	18	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   216	220	288	java/lang/Exception
    //   162	198	295	java/io/FileNotFoundException
    //   302	306	364	java/lang/Exception
    //   162	198	368	java/io/IOException
    //   376	380	438	java/lang/Exception
    //   162	198	442	finally
    //   450	454	522	java/lang/Exception
    //   202	212	529	finally
    //   202	212	534	java/io/IOException
    //   202	212	539	java/io/FileNotFoundException
  }
  
  /* Error */
  boolean a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: iconst_1
    //   10: istore 5
    //   12: new 450	java/io/ObjectInputStream
    //   15: dup
    //   16: new 338	java/io/FileInputStream
    //   19: dup
    //   20: new 92	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   27: getstatic 69	com/tencent/av/report/VideoConnRateReport:o	Ljava/lang/String;
    //   30: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_1
    //   34: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokespecial 451	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   43: invokespecial 454	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   46: astore_3
    //   47: aload_3
    //   48: ifnull +293 -> 341
    //   51: aload_3
    //   52: invokevirtual 457	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   55: checkcast 123	com/tencent/av/report/VideoSerializeData
    //   58: astore 4
    //   60: aload_3
    //   61: ifnull +7 -> 68
    //   64: aload_3
    //   65: invokevirtual 458	java/io/ObjectInputStream:close	()V
    //   68: aload 4
    //   70: ifnonnull +7 -> 77
    //   73: iconst_0
    //   74: istore_2
    //   75: iload_2
    //   76: ireturn
    //   77: aload 4
    //   79: getfield 461	com/tencent/av/report/VideoSerializeData:msgType	J
    //   82: ldc2_w 363
    //   85: lcmp
    //   86: ifeq +33 -> 119
    //   89: new 101	java/io/File
    //   92: dup
    //   93: aload_1
    //   94: invokespecial 198	java/io/File:<init>	(Ljava/lang/String;)V
    //   97: astore_1
    //   98: aload_1
    //   99: ifnull +15 -> 114
    //   102: aload_1
    //   103: invokevirtual 202	java/io/File:exists	()Z
    //   106: ifeq +8 -> 114
    //   109: aload_1
    //   110: invokevirtual 205	java/io/File:delete	()Z
    //   113: pop
    //   114: iconst_1
    //   115: istore_2
    //   116: goto -41 -> 75
    //   119: iload_2
    //   120: ifeq +59 -> 179
    //   123: new 92	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   130: aload 4
    //   132: getfield 464	com/tencent/av/report/VideoSerializeData:msgSeq	J
    //   135: invokestatic 273	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   138: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: ldc 117
    //   143: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: aload 4
    //   148: getfield 467	com/tencent/av/report/VideoSerializeData:type	Ljava/lang/String;
    //   151: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: astore_3
    //   158: aload_0
    //   159: getfield 84	com/tencent/av/report/VideoConnRateReport:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   162: aload_3
    //   163: aload 4
    //   165: invokevirtual 468	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   168: pop
    //   169: aload_0
    //   170: getfield 86	com/tencent/av/report/VideoConnRateReport:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   173: aload_3
    //   174: aload_1
    //   175: invokevirtual 468	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   178: pop
    //   179: iconst_1
    //   180: istore_2
    //   181: goto -106 -> 75
    //   184: astore_1
    //   185: aconst_null
    //   186: astore_3
    //   187: aload_3
    //   188: ifnull +7 -> 195
    //   191: aload_3
    //   192: invokevirtual 458	java/io/ObjectInputStream:close	()V
    //   195: iconst_0
    //   196: ifeq -189 -> 7
    //   199: new 211	java/lang/NullPointerException
    //   202: dup
    //   203: invokespecial 469	java/lang/NullPointerException:<init>	()V
    //   206: athrow
    //   207: astore_1
    //   208: aconst_null
    //   209: astore_3
    //   210: aload_3
    //   211: ifnull +7 -> 218
    //   214: aload_3
    //   215: invokevirtual 458	java/io/ObjectInputStream:close	()V
    //   218: iconst_0
    //   219: ifeq -212 -> 7
    //   222: new 211	java/lang/NullPointerException
    //   225: dup
    //   226: invokespecial 469	java/lang/NullPointerException:<init>	()V
    //   229: athrow
    //   230: astore_1
    //   231: aconst_null
    //   232: astore_3
    //   233: aload_3
    //   234: ifnull +7 -> 241
    //   237: aload_3
    //   238: invokevirtual 458	java/io/ObjectInputStream:close	()V
    //   241: iconst_0
    //   242: ifeq -235 -> 7
    //   245: new 211	java/lang/NullPointerException
    //   248: dup
    //   249: invokespecial 469	java/lang/NullPointerException:<init>	()V
    //   252: athrow
    //   253: astore_1
    //   254: aconst_null
    //   255: astore_3
    //   256: aload_3
    //   257: ifnull +7 -> 264
    //   260: aload_3
    //   261: invokevirtual 458	java/io/ObjectInputStream:close	()V
    //   264: iconst_0
    //   265: ifeq -258 -> 7
    //   268: new 211	java/lang/NullPointerException
    //   271: dup
    //   272: invokespecial 469	java/lang/NullPointerException:<init>	()V
    //   275: athrow
    //   276: astore_1
    //   277: aconst_null
    //   278: astore_3
    //   279: aload_3
    //   280: ifnull +7 -> 287
    //   283: aload_3
    //   284: invokevirtual 458	java/io/ObjectInputStream:close	()V
    //   287: iconst_0
    //   288: ifne +7 -> 295
    //   291: iconst_0
    //   292: istore_2
    //   293: iload_2
    //   294: ireturn
    //   295: new 211	java/lang/NullPointerException
    //   298: dup
    //   299: invokespecial 469	java/lang/NullPointerException:<init>	()V
    //   302: athrow
    //   303: astore_1
    //   304: iconst_0
    //   305: ireturn
    //   306: astore_1
    //   307: iconst_0
    //   308: ireturn
    //   309: astore_1
    //   310: iconst_0
    //   311: ireturn
    //   312: astore_1
    //   313: iconst_0
    //   314: ireturn
    //   315: astore_1
    //   316: iconst_0
    //   317: ireturn
    //   318: astore_1
    //   319: iconst_0
    //   320: ireturn
    //   321: astore_1
    //   322: goto -43 -> 279
    //   325: astore_1
    //   326: goto -70 -> 256
    //   329: astore_1
    //   330: goto -97 -> 233
    //   333: astore_1
    //   334: goto -124 -> 210
    //   337: astore_1
    //   338: goto -151 -> 187
    //   341: aconst_null
    //   342: astore 4
    //   344: goto -284 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	347	0	this	VideoConnRateReport
    //   0	347	1	paramString	String
    //   0	347	2	paramBoolean	boolean
    //   46	238	3	localObject	Object
    //   58	285	4	localVideoSerializeData	VideoSerializeData
    //   10	1	5	i1	int
    // Exception table:
    //   from	to	target	type
    //   12	47	184	java/io/FileNotFoundException
    //   12	47	207	java/io/OptionalDataException
    //   12	47	230	java/lang/ClassNotFoundException
    //   12	47	253	java/io/IOException
    //   12	47	276	finally
    //   64	68	303	java/lang/Exception
    //   191	195	306	java/lang/Exception
    //   214	218	309	java/lang/Exception
    //   237	241	312	java/lang/Exception
    //   260	264	315	java/lang/Exception
    //   283	287	318	java/lang/Exception
    //   51	60	321	finally
    //   51	60	325	java/io/IOException
    //   51	60	329	java/lang/ClassNotFoundException
    //   51	60	333	java/io/OptionalDataException
    //   51	60	337	java/io/FileNotFoundException
  }
  
  public void b()
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      new Thread(new gmu(this)).start();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\report\VideoConnRateReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */