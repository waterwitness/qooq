package com.tencent.open.business.cgireport;

import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.OpenConfig;
import java.util.ArrayList;
import java.util.Random;
import wul;

public class ReportManager
{
  protected static ReportManager a;
  public static final String a;
  public static final String b = "POST";
  public int a;
  protected long a;
  public ReportDataModal a;
  public volatile ArrayList a;
  protected Random a;
  public boolean a;
  protected volatile ArrayList b = new ArrayList();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = ReportManager.class.getName();
  }
  
  public ReportManager()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 3;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentOpenBusinessCgireportReportDataModal = new ReportDataModal();
    this.jdField_a_of_type_JavaUtilRandom = new Random();
  }
  
  public static ReportManager a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentOpenBusinessCgireportReportManager == null) {
        jdField_a_of_type_ComTencentOpenBusinessCgireportReportManager = new ReportManager();
      }
      ReportManager localReportManager = jdField_a_of_type_ComTencentOpenBusinessCgireportReportManager;
      return localReportManager;
    }
    finally {}
  }
  
  protected int a(int paramInt)
  {
    if (paramInt == 0)
    {
      i = OpenConfig.a(CommonDataAdapter.a().a(), null).a("Common_CGIReportFrequencySuccess");
      LogUtility.c("OpenConfig_agent", "config 4:Common_CGIReportFrequencySuccess     config_value:" + i);
      paramInt = i;
      if (i == 0) {
        paramInt = 10;
      }
      LogUtility.c("OpenConfig_agent", "config 4:Common_CGIReportFrequencySuccess     result_value:" + paramInt);
      return paramInt;
    }
    int i = OpenConfig.a(CommonDataAdapter.a().a(), null).a("Common_CGIReportFrequencyFailed");
    LogUtility.c("OpenConfig_agent", "config 4:Common_CGIReportFrequencyFailed     config_value:" + i);
    paramInt = i;
    if (i == 0) {
      paramInt = 100;
    }
    LogUtility.c("OpenConfig_agent", "config 4:Common_CGIReportFrequencyFailed     result_value:" + paramInt);
    return paramInt;
  }
  
  /* Error */
  protected Bundle a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 117
    //   4: ldc 119
    //   6: invokestatic 121	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: aload_0
    //   10: aload_0
    //   11: getfield 53	com/tencent/open/business/cgireport/ReportManager:jdField_a_of_type_ComTencentOpenBusinessCgireportReportDataModal	Lcom/tencent/open/business/cgireport/ReportDataModal;
    //   14: aload_1
    //   15: invokevirtual 124	com/tencent/open/business/cgireport/ReportDataModal:a	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   18: putfield 46	com/tencent/open/business/cgireport/ReportManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   21: aload_0
    //   22: getfield 53	com/tencent/open/business/cgireport/ReportManager:jdField_a_of_type_ComTencentOpenBusinessCgireportReportDataModal	Lcom/tencent/open/business/cgireport/ReportDataModal;
    //   25: aload_1
    //   26: invokevirtual 127	com/tencent/open/business/cgireport/ReportDataModal:b	(Ljava/lang/String;)Z
    //   29: pop
    //   30: aload_0
    //   31: getfield 46	com/tencent/open/business/cgireport/ReportManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   34: invokevirtual 131	java/util/ArrayList:size	()I
    //   37: ifgt +16 -> 53
    //   40: ldc 117
    //   42: ldc -123
    //   44: invokestatic 121	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: aconst_null
    //   48: astore_1
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_1
    //   52: areturn
    //   53: aload_0
    //   54: aload_0
    //   55: getfield 53	com/tencent/open/business/cgireport/ReportManager:jdField_a_of_type_ComTencentOpenBusinessCgireportReportDataModal	Lcom/tencent/open/business/cgireport/ReportDataModal;
    //   58: aload_1
    //   59: invokevirtual 135	com/tencent/open/business/cgireport/ReportDataModal:b	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   62: putfield 48	com/tencent/open/business/cgireport/ReportManager:b	Ljava/util/ArrayList;
    //   65: aload_0
    //   66: getfield 53	com/tencent/open/business/cgireport/ReportManager:jdField_a_of_type_ComTencentOpenBusinessCgireportReportDataModal	Lcom/tencent/open/business/cgireport/ReportDataModal;
    //   69: aload_1
    //   70: invokevirtual 137	com/tencent/open/business/cgireport/ReportDataModal:a	(Ljava/lang/String;)Z
    //   73: pop
    //   74: new 139	android/os/Bundle
    //   77: dup
    //   78: invokespecial 140	android/os/Bundle:<init>	()V
    //   81: astore_2
    //   82: aload_2
    //   83: ldc -114
    //   85: aload_1
    //   86: invokevirtual 145	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: aload_2
    //   90: ldc -109
    //   92: getstatic 152	com/tencent/open/business/cgireport/ReportComm:g	Ljava/lang/String;
    //   95: invokevirtual 145	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: aload_2
    //   99: ldc -102
    //   101: getstatic 159	android/os/Build:DEVICE	Ljava/lang/String;
    //   104: invokevirtual 145	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: aload_2
    //   108: ldc -95
    //   110: getstatic 164	com/tencent/open/business/cgireport/ReportComm:l	Ljava/lang/String;
    //   113: invokevirtual 145	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   116: aload_2
    //   117: ldc -90
    //   119: ldc -88
    //   121: invokevirtual 145	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   124: iconst_0
    //   125: istore_3
    //   126: iload_3
    //   127: aload_0
    //   128: getfield 46	com/tencent/open/business/cgireport/ReportManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   131: invokevirtual 131	java/util/ArrayList:size	()I
    //   134: if_icmpge +406 -> 540
    //   137: aload_2
    //   138: new 85	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   145: iload_3
    //   146: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   149: ldc -86
    //   151: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: aload_0
    //   158: getfield 46	com/tencent/open/business/cgireport/ReportManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   161: iload_3
    //   162: invokevirtual 174	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   165: checkcast 176	com/tencent/open/business/cgireport/reportItem
    //   168: getfield 177	com/tencent/open/business/cgireport/reportItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   171: invokevirtual 145	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   174: aload_2
    //   175: new 85	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   182: iload_3
    //   183: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   186: ldc -77
    //   188: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: aload_0
    //   195: getfield 46	com/tencent/open/business/cgireport/ReportManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   198: iload_3
    //   199: invokevirtual 174	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   202: checkcast 176	com/tencent/open/business/cgireport/reportItem
    //   205: getfield 181	com/tencent/open/business/cgireport/reportItem:b	Ljava/lang/String;
    //   208: invokevirtual 145	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   211: aload_2
    //   212: new 85	java/lang/StringBuilder
    //   215: dup
    //   216: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   219: iload_3
    //   220: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   223: ldc -73
    //   225: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: aload_0
    //   232: getfield 46	com/tencent/open/business/cgireport/ReportManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   235: iload_3
    //   236: invokevirtual 174	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   239: checkcast 176	com/tencent/open/business/cgireport/reportItem
    //   242: getfield 185	com/tencent/open/business/cgireport/reportItem:c	Ljava/lang/String;
    //   245: invokevirtual 145	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   248: aload_2
    //   249: new 85	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   256: iload_3
    //   257: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   260: ldc -69
    //   262: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: aload_0
    //   269: getfield 46	com/tencent/open/business/cgireport/ReportManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   272: iload_3
    //   273: invokevirtual 174	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   276: checkcast 176	com/tencent/open/business/cgireport/reportItem
    //   279: getfield 190	com/tencent/open/business/cgireport/reportItem:d	Ljava/lang/String;
    //   282: invokevirtual 145	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   285: aload_2
    //   286: new 85	java/lang/StringBuilder
    //   289: dup
    //   290: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   293: iload_3
    //   294: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   297: ldc -64
    //   299: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   305: aload_0
    //   306: getfield 46	com/tencent/open/business/cgireport/ReportManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   309: iload_3
    //   310: invokevirtual 174	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   313: checkcast 176	com/tencent/open/business/cgireport/reportItem
    //   316: getfield 195	com/tencent/open/business/cgireport/reportItem:e	Ljava/lang/String;
    //   319: invokevirtual 145	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   322: aload_2
    //   323: new 85	java/lang/StringBuilder
    //   326: dup
    //   327: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   330: iload_3
    //   331: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   334: ldc -59
    //   336: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: aload_0
    //   343: getfield 46	com/tencent/open/business/cgireport/ReportManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   346: iload_3
    //   347: invokevirtual 174	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   350: checkcast 176	com/tencent/open/business/cgireport/reportItem
    //   353: getfield 200	com/tencent/open/business/cgireport/reportItem:f	Ljava/lang/String;
    //   356: invokevirtual 145	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   359: aload_2
    //   360: new 85	java/lang/StringBuilder
    //   363: dup
    //   364: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   367: iload_3
    //   368: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   371: ldc -54
    //   373: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   379: aload_0
    //   380: getfield 46	com/tencent/open/business/cgireport/ReportManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   383: iload_3
    //   384: invokevirtual 174	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   387: checkcast 176	com/tencent/open/business/cgireport/reportItem
    //   390: getfield 203	com/tencent/open/business/cgireport/reportItem:g	Ljava/lang/String;
    //   393: invokevirtual 145	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   396: aload_2
    //   397: new 85	java/lang/StringBuilder
    //   400: dup
    //   401: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   404: iload_3
    //   405: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   408: ldc -51
    //   410: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   416: aload_0
    //   417: getfield 46	com/tencent/open/business/cgireport/ReportManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   420: iload_3
    //   421: invokevirtual 174	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   424: checkcast 176	com/tencent/open/business/cgireport/reportItem
    //   427: getfield 208	com/tencent/open/business/cgireport/reportItem:j	Ljava/lang/String;
    //   430: invokevirtual 145	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   433: aload_2
    //   434: new 85	java/lang/StringBuilder
    //   437: dup
    //   438: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   441: iload_3
    //   442: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   445: ldc -46
    //   447: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   453: aload_0
    //   454: getfield 46	com/tencent/open/business/cgireport/ReportManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   457: iload_3
    //   458: invokevirtual 174	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   461: checkcast 176	com/tencent/open/business/cgireport/reportItem
    //   464: getfield 213	com/tencent/open/business/cgireport/reportItem:h	Ljava/lang/String;
    //   467: invokevirtual 145	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   470: new 85	java/lang/StringBuilder
    //   473: dup
    //   474: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   477: invokestatic 217	com/tencent/open/business/base/MobileInfoUtil:h	()Ljava/lang/String;
    //   480: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: ldc -37
    //   485: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: aload_0
    //   489: getfield 46	com/tencent/open/business/cgireport/ReportManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   492: iload_3
    //   493: invokevirtual 174	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   496: checkcast 176	com/tencent/open/business/cgireport/reportItem
    //   499: getfield 222	com/tencent/open/business/cgireport/reportItem:i	Ljava/lang/String;
    //   502: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   508: astore_1
    //   509: aload_2
    //   510: new 85	java/lang/StringBuilder
    //   513: dup
    //   514: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   517: iload_3
    //   518: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   521: ldc -32
    //   523: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   529: aload_1
    //   530: invokevirtual 145	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   533: iload_3
    //   534: iconst_1
    //   535: iadd
    //   536: istore_3
    //   537: goto -411 -> 126
    //   540: aload_0
    //   541: getfield 46	com/tencent/open/business/cgireport/ReportManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   544: invokevirtual 131	java/util/ArrayList:size	()I
    //   547: istore_3
    //   548: iload_3
    //   549: aload_0
    //   550: getfield 48	com/tencent/open/business/cgireport/ReportManager:b	Ljava/util/ArrayList;
    //   553: invokevirtual 131	java/util/ArrayList:size	()I
    //   556: aload_0
    //   557: getfield 46	com/tencent/open/business/cgireport/ReportManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   560: invokevirtual 131	java/util/ArrayList:size	()I
    //   563: iadd
    //   564: if_icmpge +442 -> 1006
    //   567: iload_3
    //   568: aload_0
    //   569: getfield 46	com/tencent/open/business/cgireport/ReportManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   572: invokevirtual 131	java/util/ArrayList:size	()I
    //   575: isub
    //   576: istore 4
    //   578: aload_2
    //   579: new 85	java/lang/StringBuilder
    //   582: dup
    //   583: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   586: iload_3
    //   587: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   590: ldc -86
    //   592: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   598: aload_0
    //   599: getfield 48	com/tencent/open/business/cgireport/ReportManager:b	Ljava/util/ArrayList;
    //   602: iload 4
    //   604: invokevirtual 174	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   607: checkcast 176	com/tencent/open/business/cgireport/reportItem
    //   610: getfield 177	com/tencent/open/business/cgireport/reportItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   613: invokevirtual 145	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   616: aload_2
    //   617: new 85	java/lang/StringBuilder
    //   620: dup
    //   621: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   624: iload_3
    //   625: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   628: ldc -77
    //   630: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   633: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   636: aload_0
    //   637: getfield 48	com/tencent/open/business/cgireport/ReportManager:b	Ljava/util/ArrayList;
    //   640: iload 4
    //   642: invokevirtual 174	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   645: checkcast 176	com/tencent/open/business/cgireport/reportItem
    //   648: getfield 181	com/tencent/open/business/cgireport/reportItem:b	Ljava/lang/String;
    //   651: invokevirtual 145	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   654: aload_2
    //   655: new 85	java/lang/StringBuilder
    //   658: dup
    //   659: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   662: iload_3
    //   663: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   666: ldc -73
    //   668: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   671: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   674: aload_0
    //   675: getfield 48	com/tencent/open/business/cgireport/ReportManager:b	Ljava/util/ArrayList;
    //   678: iload 4
    //   680: invokevirtual 174	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   683: checkcast 176	com/tencent/open/business/cgireport/reportItem
    //   686: getfield 185	com/tencent/open/business/cgireport/reportItem:c	Ljava/lang/String;
    //   689: invokevirtual 145	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   692: aload_2
    //   693: new 85	java/lang/StringBuilder
    //   696: dup
    //   697: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   700: iload_3
    //   701: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   704: ldc -69
    //   706: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   712: aload_0
    //   713: getfield 48	com/tencent/open/business/cgireport/ReportManager:b	Ljava/util/ArrayList;
    //   716: iload 4
    //   718: invokevirtual 174	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   721: checkcast 176	com/tencent/open/business/cgireport/reportItem
    //   724: getfield 190	com/tencent/open/business/cgireport/reportItem:d	Ljava/lang/String;
    //   727: invokevirtual 145	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   730: aload_2
    //   731: new 85	java/lang/StringBuilder
    //   734: dup
    //   735: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   738: iload_3
    //   739: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   742: ldc -64
    //   744: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   747: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   750: aload_0
    //   751: getfield 48	com/tencent/open/business/cgireport/ReportManager:b	Ljava/util/ArrayList;
    //   754: iload 4
    //   756: invokevirtual 174	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   759: checkcast 176	com/tencent/open/business/cgireport/reportItem
    //   762: getfield 195	com/tencent/open/business/cgireport/reportItem:e	Ljava/lang/String;
    //   765: invokevirtual 145	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   768: aload_2
    //   769: new 85	java/lang/StringBuilder
    //   772: dup
    //   773: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   776: iload_3
    //   777: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   780: ldc -59
    //   782: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   785: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   788: aload_0
    //   789: getfield 48	com/tencent/open/business/cgireport/ReportManager:b	Ljava/util/ArrayList;
    //   792: iload 4
    //   794: invokevirtual 174	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   797: checkcast 176	com/tencent/open/business/cgireport/reportItem
    //   800: getfield 200	com/tencent/open/business/cgireport/reportItem:f	Ljava/lang/String;
    //   803: invokevirtual 145	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   806: aload_2
    //   807: new 85	java/lang/StringBuilder
    //   810: dup
    //   811: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   814: iload_3
    //   815: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   818: ldc -54
    //   820: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   823: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   826: aload_0
    //   827: getfield 48	com/tencent/open/business/cgireport/ReportManager:b	Ljava/util/ArrayList;
    //   830: iload 4
    //   832: invokevirtual 174	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   835: checkcast 176	com/tencent/open/business/cgireport/reportItem
    //   838: getfield 203	com/tencent/open/business/cgireport/reportItem:g	Ljava/lang/String;
    //   841: invokevirtual 145	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   844: aload_2
    //   845: new 85	java/lang/StringBuilder
    //   848: dup
    //   849: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   852: iload_3
    //   853: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   856: ldc -51
    //   858: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   861: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   864: aload_0
    //   865: getfield 48	com/tencent/open/business/cgireport/ReportManager:b	Ljava/util/ArrayList;
    //   868: iload 4
    //   870: invokevirtual 174	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   873: checkcast 176	com/tencent/open/business/cgireport/reportItem
    //   876: getfield 208	com/tencent/open/business/cgireport/reportItem:j	Ljava/lang/String;
    //   879: invokevirtual 145	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   882: aload_2
    //   883: new 85	java/lang/StringBuilder
    //   886: dup
    //   887: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   890: iload_3
    //   891: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   894: ldc -46
    //   896: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   899: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   902: aload_0
    //   903: getfield 48	com/tencent/open/business/cgireport/ReportManager:b	Ljava/util/ArrayList;
    //   906: iload 4
    //   908: invokevirtual 174	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   911: checkcast 176	com/tencent/open/business/cgireport/reportItem
    //   914: getfield 213	com/tencent/open/business/cgireport/reportItem:h	Ljava/lang/String;
    //   917: invokevirtual 145	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   920: new 85	java/lang/StringBuilder
    //   923: dup
    //   924: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   927: invokestatic 217	com/tencent/open/business/base/MobileInfoUtil:h	()Ljava/lang/String;
    //   930: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   933: ldc -37
    //   935: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   938: aload_0
    //   939: getfield 46	com/tencent/open/business/cgireport/ReportManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   942: iload 4
    //   944: invokevirtual 174	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   947: checkcast 176	com/tencent/open/business/cgireport/reportItem
    //   950: getfield 222	com/tencent/open/business/cgireport/reportItem:i	Ljava/lang/String;
    //   953: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   956: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   959: astore_1
    //   960: aload_2
    //   961: new 85	java/lang/StringBuilder
    //   964: dup
    //   965: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   968: iload_3
    //   969: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   972: ldc -32
    //   974: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   977: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   980: aload_1
    //   981: invokevirtual 145	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   984: iload_3
    //   985: iconst_1
    //   986: iadd
    //   987: istore_3
    //   988: goto -440 -> 548
    //   991: astore_1
    //   992: getstatic 31	com/tencent/open/business/cgireport/ReportManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   995: ldc -30
    //   997: aload_1
    //   998: invokestatic 229	com/tencent/open/base/LogUtility:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1001: aconst_null
    //   1002: astore_1
    //   1003: goto -954 -> 49
    //   1006: ldc 117
    //   1008: ldc -25
    //   1010: invokestatic 121	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   1013: aload_2
    //   1014: astore_1
    //   1015: goto -966 -> 49
    //   1018: astore_1
    //   1019: aload_0
    //   1020: monitorexit
    //   1021: aload_1
    //   1022: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1023	0	this	ReportManager
    //   0	1023	1	paramString	String
    //   81	933	2	localBundle	Bundle
    //   125	863	3	i	int
    //   576	367	4	j	int
    // Exception table:
    //   from	to	target	type
    //   82	124	991	java/lang/Exception
    //   126	533	991	java/lang/Exception
    //   540	548	991	java/lang/Exception
    //   548	984	991	java/lang/Exception
    //   2	47	1018	finally
    //   53	82	1018	finally
    //   82	124	1018	finally
    //   126	533	1018	finally
    //   540	548	1018	finally
    //   548	984	1018	finally
    //   992	1001	1018	finally
    //   1006	1013	1018	finally
  }
  
  protected String a()
  {
    return AppNetConnInfo.getCurrentAPN();
  }
  
  protected void a(String paramString)
  {
    LogUtility.b("cgi_report_debug", "ReportManager doUpload start");
    paramString = a(paramString);
    if (paramString == null) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    a("http://wspeed.qq.com/w.cgi", "POST", paramString);
  }
  
  public void a(String paramString1, long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4, String paramString2, String paramString3)
  {
    if (a(paramInt) == true)
    {
      b(paramString1, paramLong1, paramLong2, paramLong3, paramInt, paramLong4, paramString2, paramString3);
      if (this.jdField_a_of_type_Boolean != true) {
        break label37;
      }
    }
    label37:
    do
    {
      return;
      if (a() == true)
      {
        a(paramString2);
        return;
      }
    } while (a(paramString2) != true);
    a(paramString2);
  }
  
  protected void a(String paramString1, String paramString2, Bundle paramBundle)
  {
    ThreadManager.d(new wul(this, paramString1, paramBundle));
  }
  
  protected boolean a()
  {
    long l2 = OpenConfig.a(CommonDataAdapter.a().a(), null).a("Common_CGIReportTimeinterval");
    LogUtility.c("OpenConfig_agent", "config 5:Common_CGIReportTimeinterval     config_value:" + l2);
    long l1 = l2;
    if (l2 == 0L) {
      l1 = 1200L;
    }
    LogUtility.c("OpenConfig_agent", "config 5:Common_CGIReportTimeinterval     result_value:" + l1);
    l2 = System.currentTimeMillis() / 1000L;
    if ((this.jdField_a_of_type_Long == 0L) || (l1 + this.jdField_a_of_type_Long <= l2))
    {
      this.jdField_a_of_type_Long = l2;
      LogUtility.b("cgi_report_debug", "ReportManager availableForTime = ture");
      return true;
    }
    LogUtility.b("cgi_report_debug", "ReportManager availableForTime = false");
    return false;
  }
  
  protected boolean a(int paramInt)
  {
    paramInt = a(paramInt);
    if (this.jdField_a_of_type_JavaUtilRandom.nextInt(100) < paramInt)
    {
      LogUtility.b("cgi_report_debug", "ReportManager availableForFrequency = ture");
      return true;
    }
    LogUtility.b("cgi_report_debug", "ReportManager availableForFrequency = false");
    return false;
  }
  
  protected boolean a(String paramString)
  {
    int j = OpenConfig.a(CommonDataAdapter.a().a(), null).a("Common_CGIReportMaxcount");
    LogUtility.c("OpenConfig_agent", "config 6:Common_CGIReportMaxcount     config_value:" + j);
    int i = j;
    if (j == 0) {
      i = 20;
    }
    LogUtility.c("OpenConfig_agent", "config 6:Common_CGIReportMaxcount     result_value:" + i);
    if (this.jdField_a_of_type_ComTencentOpenBusinessCgireportReportDataModal.a(paramString) >= i)
    {
      LogUtility.b("cgi_report_debug", "ReportManager availableForCount = ture");
      return true;
    }
    LogUtility.b("cgi_report_debug", "ReportManager availableForCount = false");
    return false;
  }
  
  protected void b(String paramString1, long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4, String paramString2, String paramString3)
  {
    paramLong1 = SystemClock.elapsedRealtime() - paramLong1;
    LogUtility.b("cgi_report_debug", "ReportManager updateDB url=" + paramString1 + ",resultCode=" + paramInt + ",timeCost=" + paramLong1 + ",reqSize=" + paramLong2 + ",rspSize=" + paramLong3);
    int i = 100 / a(paramInt);
    if (i <= 0) {
      i = 1;
    }
    for (;;)
    {
      String str = a();
      this.jdField_a_of_type_ComTencentOpenBusinessCgireportReportDataModal.a(str, i + "", paramString1, paramInt + "", paramLong1 + "", paramLong2 + "", paramLong3 + "", paramLong4 + "", paramString3, paramString2);
      return;
      if (i > 100) {
        i = 100;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\business\cgireport\ReportManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */