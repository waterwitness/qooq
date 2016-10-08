package com.tencent.mobileqq.vip;

import android.content.Context;
import android.net.ConnectivityManager;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.handler.EarlyHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.WebpSoLoader;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqsharpP.QQSharpPUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

public class DownloaderFactory
  implements Manager
{
  public static final int a = 2048;
  static ConnectivityManager jdField_a_of_type_AndroidNetConnectivityManager;
  public static final String a;
  public static ConcurrentHashMap a;
  public static volatile boolean a = false;
  private static final int[] jdField_a_of_type_ArrayOfInt = WebpSoLoader.a();
  public static final int b = 600;
  public static ConcurrentHashMap b;
  public static final int c = 5;
  public static final int d = 3;
  public static final int e = 1;
  public static final int f = 2;
  protected AppRuntime a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = DownloaderFactory.class.getSimpleName();
    jdField_a_of_type_Boolean = true;
  }
  
  public DownloaderFactory(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    b = new ConcurrentHashMap();
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    if (jdField_a_of_type_AndroidNetConnectivityManager == null) {
      jdField_a_of_type_AndroidNetConnectivityManager = (ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity");
    }
  }
  
  /* Error */
  public static int a(DownloadTask paramDownloadTask, String paramString, Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: getstatic 41	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   9: iconst_2
    //   10: ldc 97
    //   12: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: bipush -2
    //   17: istore 19
    //   19: aload_0
    //   20: invokevirtual 105	com/tencent/mobileqq/vip/DownloadTask:a	()Lcom/tencent/mobileqq/vip/DownloadListener;
    //   23: ifnonnull +14 -> 37
    //   26: aload_0
    //   27: new 107	wfx
    //   30: dup
    //   31: invokespecial 108	wfx:<init>	()V
    //   34: invokevirtual 111	com/tencent/mobileqq/vip/DownloadTask:a	(Lcom/tencent/mobileqq/vip/DownloadListener;)V
    //   37: aload_1
    //   38: ifnull +26 -> 64
    //   41: aload_0
    //   42: getfield 114	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_ComTencentMobileqqVipDownloadTask$ReportInfo	Lcom/tencent/mobileqq/vip/DownloadTask$ReportInfo;
    //   45: getfield 119	com/tencent/mobileqq/vip/DownloadTask$ReportInfo:a	J
    //   48: lconst_0
    //   49: lcmp
    //   50: ifge +14 -> 64
    //   53: aload_0
    //   54: getfield 114	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_ComTencentMobileqqVipDownloadTask$ReportInfo	Lcom/tencent/mobileqq/vip/DownloadTask$ReportInfo;
    //   57: aload_1
    //   58: invokestatic 125	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   61: putfield 119	com/tencent/mobileqq/vip/DownloadTask$ReportInfo:a	J
    //   64: aload_0
    //   65: ifnull +217 -> 282
    //   68: iconst_m1
    //   69: istore 19
    //   71: aload_0
    //   72: invokevirtual 127	com/tencent/mobileqq/vip/DownloadTask:c	()Z
    //   75: ifne +51 -> 126
    //   78: aload_0
    //   79: bipush -109
    //   81: putfield 130	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   84: aload_0
    //   85: invokevirtual 132	com/tencent/mobileqq/vip/DownloadTask:f	()V
    //   88: iload 19
    //   90: istore 20
    //   92: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   95: ifeq +5783 -> 5878
    //   98: getstatic 41	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   101: iconst_2
    //   102: new 134	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   109: ldc -119
    //   111: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: aload_0
    //   115: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   118: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   124: iconst_m1
    //   125: ireturn
    //   126: new 149	org/apache/http/params/BasicHttpParams
    //   129: dup
    //   130: invokespecial 150	org/apache/http/params/BasicHttpParams:<init>	()V
    //   133: astore 12
    //   135: aload 12
    //   137: ldc -104
    //   139: sipush 10000
    //   142: invokestatic 158	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   145: invokeinterface 164 3 0
    //   150: pop
    //   151: aload 12
    //   153: ldc -90
    //   155: ldc -89
    //   157: invokestatic 158	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   160: invokeinterface 164 3 0
    //   165: pop
    //   166: aload_0
    //   167: getfield 170	com/tencent/mobileqq/vip/DownloadTask:l	Z
    //   170: ifeq +152 -> 322
    //   173: ldc -84
    //   175: astore_3
    //   176: aload 12
    //   178: ldc -82
    //   180: aload_3
    //   181: invokeinterface 164 3 0
    //   186: pop
    //   187: aload_0
    //   188: getfield 177	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   191: ifnull +15 -> 206
    //   194: aload_0
    //   195: getfield 177	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   198: invokeinterface 183 1 0
    //   203: ifgt +125 -> 328
    //   206: aload_0
    //   207: bipush -107
    //   209: putfield 130	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   212: aload_0
    //   213: invokevirtual 132	com/tencent/mobileqq/vip/DownloadTask:f	()V
    //   216: iload 19
    //   218: istore 20
    //   220: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   223: ifeq +5655 -> 5878
    //   226: getstatic 41	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   229: iconst_2
    //   230: new 134	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   237: ldc -71
    //   239: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: aload_0
    //   243: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   246: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   249: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   252: iconst_m1
    //   253: ireturn
    //   254: astore_0
    //   255: iconst_m1
    //   256: istore 19
    //   258: new 187	java/util/HashMap
    //   261: dup
    //   262: invokespecial 188	java/util/HashMap:<init>	()V
    //   265: pop
    //   266: aload_0
    //   267: instanceof 85
    //   270: ifeq +5058 -> 5328
    //   273: getstatic 41	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   276: iconst_1
    //   277: ldc -66
    //   279: invokestatic 192	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   282: iload 19
    //   284: istore 20
    //   286: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   289: ifeq +5589 -> 5878
    //   292: getstatic 41	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   295: iconst_2
    //   296: new 134	java/lang/StringBuilder
    //   299: dup
    //   300: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   303: ldc -62
    //   305: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: iload 19
    //   310: invokevirtual 197	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   313: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   319: iload 19
    //   321: ireturn
    //   322: ldc -57
    //   324: astore_3
    //   325: goto -149 -> 176
    //   328: aload_0
    //   329: getfield 177	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   332: invokeinterface 183 1 0
    //   337: istore 23
    //   339: iconst_0
    //   340: istore 25
    //   342: aconst_null
    //   343: astore 4
    //   345: aconst_null
    //   346: astore_3
    //   347: aconst_null
    //   348: astore 5
    //   350: sipush 2048
    //   353: istore 20
    //   355: iconst_0
    //   356: istore 39
    //   358: iload 25
    //   360: aload_0
    //   361: getfield 177	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   364: invokeinterface 183 1 0
    //   369: if_icmpge +4789 -> 5158
    //   372: invokestatic 205	java/lang/System:currentTimeMillis	()J
    //   375: lstore 37
    //   377: new 4	java/lang/Object
    //   380: dup
    //   381: invokespecial 55	java/lang/Object:<init>	()V
    //   384: astore 13
    //   386: aload_0
    //   387: getfield 177	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   390: iload 25
    //   392: invokeinterface 209 2 0
    //   397: checkcast 211	java/lang/String
    //   400: astore 6
    //   402: aload_0
    //   403: aload 6
    //   405: putfield 213	com/tencent/mobileqq/vip/DownloadTask:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   408: aload_0
    //   409: getfield 216	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   412: aload 6
    //   414: invokeinterface 221 2 0
    //   419: checkcast 223	java/io/File
    //   422: astore 10
    //   424: aload 10
    //   426: ifnull +4699 -> 5125
    //   429: aload 10
    //   431: invokevirtual 227	java/io/File:getParentFile	()Ljava/io/File;
    //   434: astore 14
    //   436: new 223	java/io/File
    //   439: dup
    //   440: aload 14
    //   442: new 134	java/lang/StringBuilder
    //   445: dup
    //   446: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   449: aload 10
    //   451: invokevirtual 230	java/io/File:getName	()Ljava/lang/String;
    //   454: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: ldc -24
    //   459: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   465: invokespecial 235	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   468: astore 15
    //   470: aload_0
    //   471: getfield 237	com/tencent/mobileqq/vip/DownloadTask:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   474: invokestatic 243	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   477: ifne +5333 -> 5810
    //   480: aload_0
    //   481: getfield 237	com/tencent/mobileqq/vip/DownloadTask:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   484: aload 6
    //   486: invokestatic 249	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:insertMtype	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   489: astore 7
    //   491: new 251	com/tencent/mobileqq/emoticon/DownloadInfo
    //   494: dup
    //   495: aload 7
    //   497: aconst_null
    //   498: iconst_0
    //   499: invokespecial 254	com/tencent/mobileqq/emoticon/DownloadInfo:<init>	(Ljava/lang/String;Ljava/io/File;I)V
    //   502: astore 11
    //   504: iconst_0
    //   505: istore 39
    //   507: iconst_m1
    //   508: istore 26
    //   510: iconst_m1
    //   511: istore 21
    //   513: aload 5
    //   515: astore 6
    //   517: aload_3
    //   518: astore 5
    //   520: iload 20
    //   522: istore 19
    //   524: lconst_0
    //   525: lstore 29
    //   527: lconst_0
    //   528: lstore 31
    //   530: iload 21
    //   532: istore 20
    //   534: aload 4
    //   536: astore_3
    //   537: aload 6
    //   539: astore 4
    //   541: iconst_0
    //   542: istore 41
    //   544: aload 11
    //   546: invokevirtual 256	com/tencent/mobileqq/emoticon/DownloadInfo:a	()V
    //   549: aload 14
    //   551: ifnull +769 -> 1320
    //   554: aload 14
    //   556: invokevirtual 259	java/io/File:exists	()Z
    //   559: ifne +761 -> 1320
    //   562: aload 14
    //   564: invokevirtual 262	java/io/File:mkdirs	()Z
    //   567: istore 40
    //   569: iload 40
    //   571: ifne +749 -> 1320
    //   574: aload_0
    //   575: bipush -103
    //   577: putfield 130	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   580: new 134	java/lang/StringBuilder
    //   583: dup
    //   584: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   587: ldc_w 264
    //   590: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: aload 14
    //   595: invokevirtual 267	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   598: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: ldc_w 269
    //   604: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: invokestatic 273	com/tencent/mobileqq/util/Utils:b	()Z
    //   610: invokevirtual 276	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   613: ldc_w 278
    //   616: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: invokestatic 280	com/tencent/mobileqq/util/Utils:b	()J
    //   622: invokevirtual 283	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   625: ldc_w 285
    //   628: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: aload 7
    //   633: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   636: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   639: astore 6
    //   641: getstatic 41	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   644: iconst_1
    //   645: aload 6
    //   647: invokestatic 192	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   650: new 87	java/lang/Exception
    //   653: dup
    //   654: aload 6
    //   656: invokespecial 288	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   659: athrow
    //   660: astore 8
    //   662: iconst_1
    //   663: istore 20
    //   665: aload 4
    //   667: astore 6
    //   669: bipush -103
    //   671: istore 22
    //   673: iload 19
    //   675: istore 21
    //   677: iconst_0
    //   678: istore 40
    //   680: iload 22
    //   682: istore 19
    //   684: aload_3
    //   685: astore 4
    //   687: aload 6
    //   689: astore_3
    //   690: aload 8
    //   692: astore 6
    //   694: iconst_0
    //   695: istore 22
    //   697: aload 6
    //   699: instanceof 290
    //   702: ifne +5179 -> 5881
    //   705: aload 6
    //   707: instanceof 292
    //   710: ifne +5171 -> 5881
    //   713: aload 6
    //   715: instanceof 294
    //   718: ifeq +6 -> 724
    //   721: goto +5160 -> 5881
    //   724: aload 6
    //   726: instanceof 85
    //   729: ifeq +4159 -> 4888
    //   732: aload_0
    //   733: bipush -111
    //   735: putfield 130	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   738: aload_0
    //   739: aload 6
    //   741: invokevirtual 297	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   744: putfield 299	com/tencent/mobileqq/vip/DownloadTask:b	Ljava/lang/String;
    //   747: iload 40
    //   749: ifne +18 -> 767
    //   752: iload 22
    //   754: ifeq +13 -> 767
    //   757: iload 39
    //   759: ifeq +4204 -> 4963
    //   762: aload_0
    //   763: iconst_1
    //   764: putfield 301	com/tencent/mobileqq/vip/DownloadTask:jdField_f_of_type_Boolean	Z
    //   767: getstatic 41	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   770: iconst_1
    //   771: new 134	java/lang/StringBuilder
    //   774: dup
    //   775: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   778: ldc_w 303
    //   781: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   784: aload 7
    //   786: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   789: ldc_w 305
    //   792: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   795: aload 6
    //   797: invokevirtual 297	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   800: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   803: ldc_w 307
    //   806: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   809: aload_0
    //   810: getfield 130	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   813: invokevirtual 197	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   816: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   819: invokestatic 192	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   822: iload 19
    //   824: ifeq +70 -> 894
    //   827: aload_0
    //   828: invokevirtual 308	com/tencent/mobileqq/vip/DownloadTask:b	()Z
    //   831: ifne +63 -> 894
    //   834: aload_0
    //   835: getfield 310	com/tencent/mobileqq/vip/DownloadTask:jdField_e_of_type_Boolean	Z
    //   838: ifeq +56 -> 894
    //   841: aload 11
    //   843: getfield 311	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_Boolean	Z
    //   846: ifeq +4125 -> 4971
    //   849: invokestatic 316	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:a	()Lcom/tencent/mobileqq/transfile/FMTSrvAddrProvider;
    //   852: astore 6
    //   854: aload 6
    //   856: ifnull +18 -> 874
    //   859: aload 6
    //   861: aload 11
    //   863: getfield 318	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_d_of_type_Int	I
    //   866: aload 11
    //   868: getfield 319	com/tencent/mobileqq/emoticon/DownloadInfo:b	Ljava/lang/String;
    //   871: invokevirtual 322	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:a	(ILjava/lang/String;)V
    //   874: aload 11
    //   876: getfield 319	com/tencent/mobileqq/emoticon/DownloadInfo:b	Ljava/lang/String;
    //   879: aload 10
    //   881: invokevirtual 230	java/io/File:getName	()Ljava/lang/String;
    //   884: iconst_m1
    //   885: aload_2
    //   886: invokestatic 325	com/tencent/mobileqq/vip/DownloaderFactory:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/content/Context;)V
    //   889: aload_0
    //   890: iconst_0
    //   891: putfield 327	com/tencent/mobileqq/vip/DownloadTask:jdField_d_of_type_Boolean	Z
    //   894: iload 26
    //   896: iconst_1
    //   897: iadd
    //   898: istore 22
    //   900: aload 5
    //   902: ifnull +10 -> 912
    //   905: aload 5
    //   907: invokeinterface 332 1 0
    //   912: aload 4
    //   914: ifnull +8 -> 922
    //   917: aload 4
    //   919: invokevirtual 337	java/io/InputStream:close	()V
    //   922: aload_3
    //   923: ifnull +7 -> 930
    //   926: aload_3
    //   927: invokevirtual 340	java/io/BufferedOutputStream:close	()V
    //   930: iload 40
    //   932: istore 41
    //   934: iload 21
    //   936: istore 24
    //   938: aload_3
    //   939: astore 6
    //   941: aload 5
    //   943: astore_3
    //   944: iload 20
    //   946: istore 21
    //   948: iload 22
    //   950: istore 20
    //   952: iload 21
    //   954: istore 22
    //   956: iload 39
    //   958: istore 40
    //   960: iload 19
    //   962: istore 21
    //   964: aload 6
    //   966: astore 5
    //   968: iload 24
    //   970: istore 19
    //   972: iload 41
    //   974: istore 39
    //   976: iload 21
    //   978: ifeq +4909 -> 5887
    //   981: iload 22
    //   983: ifne +4904 -> 5887
    //   986: iload 20
    //   988: aload_0
    //   989: getfield 343	com/tencent/mobileqq/vip/DownloadTask:A	I
    //   992: if_icmpge +4895 -> 5887
    //   995: aload_0
    //   996: invokevirtual 308	com/tencent/mobileqq/vip/DownloadTask:b	()Z
    //   999: ifeq +4841 -> 5840
    //   1002: goto +4885 -> 5887
    //   1005: aload_0
    //   1006: invokevirtual 345	com/tencent/mobileqq/vip/DownloadTask:e	()V
    //   1009: new 187	java/util/HashMap
    //   1012: dup
    //   1013: invokespecial 188	java/util/HashMap:<init>	()V
    //   1016: astore 8
    //   1018: aload 8
    //   1020: ldc_w 347
    //   1023: aload 6
    //   1025: invokevirtual 351	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1028: pop
    //   1029: aload 8
    //   1031: ldc_w 353
    //   1034: aload_0
    //   1035: getfield 130	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   1038: invokestatic 356	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1041: invokevirtual 351	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1044: pop
    //   1045: aload 8
    //   1047: ldc_w 358
    //   1050: iload 22
    //   1052: invokestatic 356	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1055: invokevirtual 351	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1058: pop
    //   1059: aload 8
    //   1061: ldc_w 360
    //   1064: lload 29
    //   1066: invokestatic 363	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1069: invokevirtual 351	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1072: pop
    //   1073: aload 8
    //   1075: ldc_w 365
    //   1078: aload_0
    //   1079: getfield 177	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1082: invokeinterface 183 1 0
    //   1087: invokestatic 356	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1090: invokevirtual 351	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1093: pop
    //   1094: aload 8
    //   1096: ldc_w 367
    //   1099: aload_0
    //   1100: getfield 369	com/tencent/mobileqq/vip/DownloadTask:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   1103: invokevirtual 351	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1106: pop
    //   1107: aload 8
    //   1109: ldc_w 371
    //   1112: iload 39
    //   1114: invokestatic 376	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   1117: invokevirtual 351	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1120: pop
    //   1121: ldc_w 378
    //   1124: astore 7
    //   1126: aload_0
    //   1127: getfield 299	com/tencent/mobileqq/vip/DownloadTask:b	Ljava/lang/String;
    //   1130: invokestatic 243	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1133: ifne +4785 -> 5918
    //   1136: aload 8
    //   1138: ldc_w 380
    //   1141: aload_0
    //   1142: getfield 299	com/tencent/mobileqq/vip/DownloadTask:b	Ljava/lang/String;
    //   1145: invokevirtual 351	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1148: pop
    //   1149: aload_0
    //   1150: getfield 299	com/tencent/mobileqq/vip/DownloadTask:b	Ljava/lang/String;
    //   1153: astore 7
    //   1155: goto +4763 -> 5918
    //   1158: invokestatic 205	java/lang/System:currentTimeMillis	()J
    //   1161: lstore 31
    //   1163: aload_2
    //   1164: ifnull +128 -> 1292
    //   1167: aload_1
    //   1168: invokestatic 243	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1171: istore 41
    //   1173: iload 41
    //   1175: ifne +117 -> 1292
    //   1178: ldc_w 382
    //   1181: aload 6
    //   1183: new 134	java/lang/StringBuilder
    //   1186: dup
    //   1187: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   1190: aload_0
    //   1191: getfield 130	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   1194: invokevirtual 197	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1197: ldc_w 378
    //   1200: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1203: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1206: new 134	java/lang/StringBuilder
    //   1209: dup
    //   1210: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   1213: lload 29
    //   1215: invokevirtual 283	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1218: ldc_w 378
    //   1221: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1224: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1227: aload_0
    //   1228: getfield 369	com/tencent/mobileqq/vip/DownloadTask:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   1231: new 134	java/lang/StringBuilder
    //   1234: dup
    //   1235: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   1238: iload 39
    //   1240: invokevirtual 276	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1243: ldc_w 378
    //   1246: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1249: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1252: aload 7
    //   1254: ldc_w 378
    //   1257: ldc_w 378
    //   1260: ldc_w 378
    //   1263: invokestatic 387	com/tencent/mobileqq/vas/VasReportUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1266: aload_2
    //   1267: invokestatic 392	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1270: aload_1
    //   1271: ldc_w 394
    //   1274: iload 40
    //   1276: lload 31
    //   1278: lload 37
    //   1280: lsub
    //   1281: lload 33
    //   1283: aload 8
    //   1285: ldc_w 378
    //   1288: iconst_0
    //   1289: invokevirtual 397	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   1292: iload 19
    //   1294: ifne +3856 -> 5150
    //   1297: iload 23
    //   1299: iconst_1
    //   1300: isub
    //   1301: istore 20
    //   1303: iload 25
    //   1305: iconst_1
    //   1306: iadd
    //   1307: istore 25
    //   1309: iload 20
    //   1311: istore 23
    //   1313: iload 21
    //   1315: istore 20
    //   1317: goto -959 -> 358
    //   1320: getstatic 66	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_AndroidNetConnectivityManager	Landroid/net/ConnectivityManager;
    //   1323: ifnonnull +17 -> 1340
    //   1326: invokestatic 72	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1329: ldc 74
    //   1331: invokevirtual 78	com/tencent/qphone/base/util/BaseApplication:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   1334: checkcast 80	android/net/ConnectivityManager
    //   1337: putstatic 66	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_AndroidNetConnectivityManager	Landroid/net/ConnectivityManager;
    //   1340: invokestatic 403	com/tencent/mobileqq/msf/sdk/AppNetConnInfo:getRecentNetworkInfo	()Landroid/net/NetworkInfo;
    //   1343: astore 16
    //   1345: aload 16
    //   1347: ifnonnull +84 -> 1431
    //   1350: aload_0
    //   1351: bipush -104
    //   1353: putfield 130	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   1356: new 134	java/lang/StringBuilder
    //   1359: dup
    //   1360: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   1363: ldc_w 405
    //   1366: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1369: aload 7
    //   1371: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1374: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1377: astore 6
    //   1379: getstatic 41	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1382: iconst_1
    //   1383: aload 6
    //   1385: invokestatic 192	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1388: new 87	java/lang/Exception
    //   1391: dup
    //   1392: aload 6
    //   1394: invokespecial 288	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   1397: athrow
    //   1398: astore 6
    //   1400: aload_3
    //   1401: astore 8
    //   1403: iconst_0
    //   1404: istore 20
    //   1406: aload 4
    //   1408: astore_3
    //   1409: bipush -104
    //   1411: istore 22
    //   1413: iconst_0
    //   1414: istore 40
    //   1416: iload 19
    //   1418: istore 21
    //   1420: aload 8
    //   1422: astore 4
    //   1424: iload 22
    //   1426: istore 19
    //   1428: goto -734 -> 694
    //   1431: new 407	org/apache/http/client/methods/HttpGet
    //   1434: dup
    //   1435: aload 7
    //   1437: invokespecial 408	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   1440: astore 9
    //   1442: aload_0
    //   1443: invokevirtual 411	com/tencent/mobileqq/vip/DownloadTask:a	()Ljava/util/Map;
    //   1446: astore 6
    //   1448: aload 6
    //   1450: ifnull +110 -> 1560
    //   1453: aload 6
    //   1455: invokeinterface 415 1 0
    //   1460: invokeinterface 421 1 0
    //   1465: astore 8
    //   1467: aload 8
    //   1469: invokeinterface 426 1 0
    //   1474: ifeq +86 -> 1560
    //   1477: aload 8
    //   1479: invokeinterface 430 1 0
    //   1484: checkcast 211	java/lang/String
    //   1487: astore 17
    //   1489: aload 6
    //   1491: aload 17
    //   1493: invokeinterface 221 2 0
    //   1498: checkcast 211	java/lang/String
    //   1501: astore 18
    //   1503: aload 9
    //   1505: aload 17
    //   1507: aload 18
    //   1509: invokevirtual 434	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   1512: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1515: ifeq -48 -> 1467
    //   1518: getstatic 41	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1521: iconst_2
    //   1522: new 134	java/lang/StringBuilder
    //   1525: dup
    //   1526: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   1529: ldc_w 436
    //   1532: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1535: aload 17
    //   1537: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1540: ldc_w 438
    //   1543: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1546: aload 18
    //   1548: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1551: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1554: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1557: goto -90 -> 1467
    //   1560: aload_0
    //   1561: getfield 441	com/tencent/mobileqq/vip/DownloadTask:jdField_i_of_type_Boolean	Z
    //   1564: ifeq +42 -> 1606
    //   1567: getstatic 444	com/tencent/qqsharpP/QQSharpPUtil:jdField_a_of_type_Boolean	Z
    //   1570: ifeq +36 -> 1606
    //   1573: invokestatic 446	com/tencent/qqsharpP/QQSharpPUtil:a	()Z
    //   1576: ifeq +30 -> 1606
    //   1579: aload 9
    //   1581: ldc_w 448
    //   1584: ldc_w 450
    //   1587: invokevirtual 434	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   1590: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1593: ifeq +13 -> 1606
    //   1596: getstatic 41	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1599: iconst_2
    //   1600: ldc_w 452
    //   1603: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1606: aload_0
    //   1607: getfield 455	com/tencent/mobileqq/vip/DownloadTask:j	Z
    //   1610: ifeq +155 -> 1765
    //   1613: invokestatic 460	com/tencent/mobileqq/app/DeviceProfileManager:b	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   1616: getstatic 466	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:AcceptType	Lcom/tencent/mobileqq/app/DeviceProfileManager$DpcNames;
    //   1619: invokevirtual 469	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:name	()Ljava/lang/String;
    //   1622: invokevirtual 472	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1625: astore 6
    //   1627: aload 6
    //   1629: invokestatic 243	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1632: ifne +1316 -> 2948
    //   1635: aload 6
    //   1637: invokestatic 476	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1640: iconst_1
    //   1641: iand
    //   1642: iconst_1
    //   1643: if_icmpne +1305 -> 2948
    //   1646: aload 9
    //   1648: ldc_w 448
    //   1651: ldc_w 478
    //   1654: invokevirtual 434	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   1657: ldc_w 480
    //   1660: iconst_3
    //   1661: anewarray 4	java/lang/Object
    //   1664: dup
    //   1665: iconst_0
    //   1666: getstatic 50	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_ArrayOfInt	[I
    //   1669: iconst_0
    //   1670: iaload
    //   1671: invokestatic 158	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1674: aastore
    //   1675: dup
    //   1676: iconst_1
    //   1677: getstatic 50	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_ArrayOfInt	[I
    //   1680: iconst_1
    //   1681: iaload
    //   1682: invokestatic 158	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1685: aastore
    //   1686: dup
    //   1687: iconst_2
    //   1688: getstatic 50	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_ArrayOfInt	[I
    //   1691: iconst_2
    //   1692: iaload
    //   1693: invokestatic 158	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1696: aastore
    //   1697: invokestatic 484	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1700: astore 6
    //   1702: aload 9
    //   1704: ldc_w 486
    //   1707: new 134	java/lang/StringBuilder
    //   1710: dup
    //   1711: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   1714: ldc_w 488
    //   1717: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1720: aload 6
    //   1722: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1725: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1728: invokevirtual 434	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   1731: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1734: ifeq +31 -> 1765
    //   1737: getstatic 41	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1740: iconst_2
    //   1741: new 134	java/lang/StringBuilder
    //   1744: dup
    //   1745: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   1748: ldc_w 490
    //   1751: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1754: aload 7
    //   1756: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1759: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1762: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1765: aload 15
    //   1767: ifnull +87 -> 1854
    //   1770: aload 15
    //   1772: invokevirtual 259	java/io/File:exists	()Z
    //   1775: ifeq +79 -> 1854
    //   1778: aload 15
    //   1780: invokevirtual 493	java/io/File:length	()J
    //   1783: lstore 33
    //   1785: aload 9
    //   1787: ldc_w 495
    //   1790: new 134	java/lang/StringBuilder
    //   1793: dup
    //   1794: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   1797: ldc_w 497
    //   1800: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1803: lload 33
    //   1805: invokevirtual 283	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1808: ldc_w 499
    //   1811: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1814: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1817: invokevirtual 434	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   1820: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1823: ifeq +31 -> 1854
    //   1826: getstatic 41	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1829: iconst_2
    //   1830: new 134	java/lang/StringBuilder
    //   1833: dup
    //   1834: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   1837: ldc_w 501
    //   1840: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1843: lload 33
    //   1845: invokevirtual 283	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1848: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1851: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1854: aload_0
    //   1855: getfield 504	com/tencent/mobileqq/vip/DownloadTask:k	Z
    //   1858: ifne +1214 -> 3072
    //   1861: aload_0
    //   1862: getfield 507	com/tencent/mobileqq/vip/DownloadTask:h	Z
    //   1865: ifeq +1207 -> 3072
    //   1868: aload 10
    //   1870: ifnull +1202 -> 3072
    //   1873: aload 10
    //   1875: invokevirtual 259	java/io/File:exists	()Z
    //   1878: ifeq +1194 -> 3072
    //   1881: aload 10
    //   1883: invokevirtual 510	java/io/File:lastModified	()J
    //   1886: lstore 33
    //   1888: lload 33
    //   1890: lconst_0
    //   1891: lcmp
    //   1892: ifle +108 -> 2000
    //   1895: new 512	java/text/SimpleDateFormat
    //   1898: dup
    //   1899: ldc_w 514
    //   1902: getstatic 520	java/util/Locale:US	Ljava/util/Locale;
    //   1905: invokespecial 523	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   1908: astore 6
    //   1910: aload 6
    //   1912: ldc_w 525
    //   1915: invokestatic 531	java/util/TimeZone:getTimeZone	(Ljava/lang/String;)Ljava/util/TimeZone;
    //   1918: invokevirtual 535	java/text/SimpleDateFormat:setTimeZone	(Ljava/util/TimeZone;)V
    //   1921: aload 6
    //   1923: new 537	java/util/Date
    //   1926: dup
    //   1927: lload 33
    //   1929: invokespecial 540	java/util/Date:<init>	(J)V
    //   1932: invokevirtual 543	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   1935: astore 6
    //   1937: aload 6
    //   1939: invokestatic 243	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1942: ifne +58 -> 2000
    //   1945: aload 9
    //   1947: ldc_w 545
    //   1950: aload 6
    //   1952: invokevirtual 434	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   1955: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1958: ifeq +42 -> 2000
    //   1961: getstatic 41	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1964: iconst_2
    //   1965: new 134	java/lang/StringBuilder
    //   1968: dup
    //   1969: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   1972: ldc_w 547
    //   1975: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1978: aload 6
    //   1980: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1983: ldc_w 549
    //   1986: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1989: lload 33
    //   1991: invokevirtual 283	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1994: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1997: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2000: getstatic 43	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_Boolean	Z
    //   2003: ifeq +60 -> 2063
    //   2006: aload_0
    //   2007: getfield 310	com/tencent/mobileqq/vip/DownloadTask:jdField_e_of_type_Boolean	Z
    //   2010: ifeq +53 -> 2063
    //   2013: aload_0
    //   2014: getfield 327	com/tencent/mobileqq/vip/DownloadTask:jdField_d_of_type_Boolean	Z
    //   2017: ifeq +46 -> 2063
    //   2020: aload 11
    //   2022: invokestatic 554	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Lcom/tencent/mobileqq/emoticon/DownloadInfo;)V
    //   2025: aload 11
    //   2027: getfield 311	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_Boolean	Z
    //   2030: ifeq +33 -> 2063
    //   2033: aload 9
    //   2035: new 556	java/net/URI
    //   2038: dup
    //   2039: aload 11
    //   2041: getfield 319	com/tencent/mobileqq/emoticon/DownloadInfo:b	Ljava/lang/String;
    //   2044: invokespecial 557	java/net/URI:<init>	(Ljava/lang/String;)V
    //   2047: invokevirtual 561	org/apache/http/client/methods/HttpGet:setURI	(Ljava/net/URI;)V
    //   2050: aload 9
    //   2052: ldc_w 563
    //   2055: aload 11
    //   2057: getfield 565	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   2060: invokevirtual 434	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   2063: aload 16
    //   2065: invokevirtual 570	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   2068: invokestatic 574	com/tencent/mobileqq/utils/httputils/PkgTools:f	(Ljava/lang/String;)Ljava/lang/String;
    //   2071: astore 17
    //   2073: aload 17
    //   2075: aload_0
    //   2076: getfield 575	com/tencent/mobileqq/vip/DownloadTask:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   2079: invokevirtual 579	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2082: ifne +14 -> 2096
    //   2085: aload_0
    //   2086: iconst_0
    //   2087: putfield 301	com/tencent/mobileqq/vip/DownloadTask:jdField_f_of_type_Boolean	Z
    //   2090: aload_0
    //   2091: aload 17
    //   2093: putfield 575	com/tencent/mobileqq/vip/DownloadTask:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   2096: aconst_null
    //   2097: astore 8
    //   2099: aconst_null
    //   2100: astore 6
    //   2102: iconst_0
    //   2103: istore 22
    //   2105: iconst_0
    //   2106: istore 21
    //   2108: aload 16
    //   2110: invokestatic 584	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   2113: ifeq +1025 -> 3138
    //   2116: iload 22
    //   2118: istore 21
    //   2120: aload 8
    //   2122: astore 6
    //   2124: aload_0
    //   2125: getfield 301	com/tencent/mobileqq/vip/DownloadTask:jdField_f_of_type_Boolean	Z
    //   2128: ifne +3709 -> 5837
    //   2131: invokestatic 589	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   2134: astore 8
    //   2136: invokestatic 592	android/net/Proxy:getDefaultPort	()I
    //   2139: istore 22
    //   2141: iload 22
    //   2143: istore 21
    //   2145: aload 8
    //   2147: astore 6
    //   2149: aload 8
    //   2151: ifnull +3686 -> 5837
    //   2154: iload 22
    //   2156: istore 21
    //   2158: aload 8
    //   2160: astore 6
    //   2162: iload 22
    //   2164: ifle +3673 -> 5837
    //   2167: aload 12
    //   2169: ldc_w 594
    //   2172: new 596	org/apache/http/HttpHost
    //   2175: dup
    //   2176: aload 8
    //   2178: iload 22
    //   2180: invokespecial 599	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   2183: invokeinterface 164 3 0
    //   2188: pop
    //   2189: iconst_1
    //   2190: istore 39
    //   2192: aload 8
    //   2194: astore 6
    //   2196: iload 22
    //   2198: istore 21
    //   2200: iload 41
    //   2202: istore 40
    //   2204: aload_0
    //   2205: getfield 602	com/tencent/mobileqq/vip/DownloadTask:n	Z
    //   2208: ifne +26 -> 2234
    //   2211: iload 41
    //   2213: istore 40
    //   2215: invokestatic 72	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2218: invokestatic 605	com/tencent/mobileqq/utils/NetworkUtil:i	(Landroid/content/Context;)Z
    //   2221: ifeq +13 -> 2234
    //   2224: iload 41
    //   2226: istore 40
    //   2228: aload 12
    //   2230: iconst_0
    //   2231: invokestatic 611	org/apache/http/client/params/HttpClientParams:setRedirecting	(Lorg/apache/http/params/HttpParams;Z)V
    //   2234: iload 41
    //   2236: istore 40
    //   2238: aload 12
    //   2240: ldc_w 613
    //   2243: iload 19
    //   2245: invokeinterface 617 3 0
    //   2250: pop
    //   2251: iload 41
    //   2253: istore 40
    //   2255: aload 9
    //   2257: aload 12
    //   2259: invokevirtual 621	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   2262: iload 41
    //   2264: istore 40
    //   2266: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2269: ifeq +148 -> 2417
    //   2272: iload 41
    //   2274: istore 40
    //   2276: new 623	java/lang/StringBuffer
    //   2279: dup
    //   2280: invokespecial 624	java/lang/StringBuffer:<init>	()V
    //   2283: astore 8
    //   2285: iload 41
    //   2287: istore 40
    //   2289: aload 8
    //   2291: ldc_w 626
    //   2294: invokevirtual 629	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2297: getstatic 43	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_Boolean	Z
    //   2300: invokevirtual 632	java/lang/StringBuffer:append	(Z)Ljava/lang/StringBuffer;
    //   2303: ldc_w 634
    //   2306: invokevirtual 629	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2309: aload_0
    //   2310: getfield 310	com/tencent/mobileqq/vip/DownloadTask:jdField_e_of_type_Boolean	Z
    //   2313: invokevirtual 632	java/lang/StringBuffer:append	(Z)Ljava/lang/StringBuffer;
    //   2316: ldc_w 636
    //   2319: invokevirtual 629	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2322: aload_0
    //   2323: getfield 327	com/tencent/mobileqq/vip/DownloadTask:jdField_d_of_type_Boolean	Z
    //   2326: invokevirtual 632	java/lang/StringBuffer:append	(Z)Ljava/lang/StringBuffer;
    //   2329: ldc_w 638
    //   2332: invokevirtual 629	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2335: aload_0
    //   2336: getfield 301	com/tencent/mobileqq/vip/DownloadTask:jdField_f_of_type_Boolean	Z
    //   2339: invokevirtual 632	java/lang/StringBuffer:append	(Z)Ljava/lang/StringBuffer;
    //   2342: ldc_w 640
    //   2345: invokevirtual 629	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2348: iload 39
    //   2350: invokevirtual 632	java/lang/StringBuffer:append	(Z)Ljava/lang/StringBuffer;
    //   2353: ldc_w 642
    //   2356: invokevirtual 629	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2359: aload 17
    //   2361: invokevirtual 629	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2364: ldc_w 644
    //   2367: invokevirtual 629	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2370: aload 6
    //   2372: invokevirtual 629	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2375: ldc_w 646
    //   2378: invokevirtual 629	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2381: iload 21
    //   2383: invokevirtual 649	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   2386: ldc_w 651
    //   2389: invokevirtual 629	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2392: aload 9
    //   2394: invokevirtual 655	org/apache/http/client/methods/HttpGet:getURI	()Ljava/net/URI;
    //   2397: invokevirtual 658	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   2400: pop
    //   2401: iload 41
    //   2403: istore 40
    //   2405: getstatic 41	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2408: iconst_2
    //   2409: aload 8
    //   2411: invokevirtual 659	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   2414: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2417: iload 39
    //   2419: ifeq +148 -> 2567
    //   2422: iload 41
    //   2424: istore 40
    //   2426: new 623	java/lang/StringBuffer
    //   2429: dup
    //   2430: invokespecial 624	java/lang/StringBuffer:<init>	()V
    //   2433: astore 8
    //   2435: iload 41
    //   2437: istore 40
    //   2439: aload 8
    //   2441: ldc_w 626
    //   2444: invokevirtual 629	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2447: getstatic 43	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_Boolean	Z
    //   2450: invokevirtual 632	java/lang/StringBuffer:append	(Z)Ljava/lang/StringBuffer;
    //   2453: ldc_w 634
    //   2456: invokevirtual 629	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2459: aload_0
    //   2460: getfield 310	com/tencent/mobileqq/vip/DownloadTask:jdField_e_of_type_Boolean	Z
    //   2463: invokevirtual 632	java/lang/StringBuffer:append	(Z)Ljava/lang/StringBuffer;
    //   2466: ldc_w 636
    //   2469: invokevirtual 629	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2472: aload_0
    //   2473: getfield 327	com/tencent/mobileqq/vip/DownloadTask:jdField_d_of_type_Boolean	Z
    //   2476: invokevirtual 632	java/lang/StringBuffer:append	(Z)Ljava/lang/StringBuffer;
    //   2479: ldc_w 638
    //   2482: invokevirtual 629	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2485: aload_0
    //   2486: getfield 301	com/tencent/mobileqq/vip/DownloadTask:jdField_f_of_type_Boolean	Z
    //   2489: invokevirtual 632	java/lang/StringBuffer:append	(Z)Ljava/lang/StringBuffer;
    //   2492: ldc_w 640
    //   2495: invokevirtual 629	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2498: iload 39
    //   2500: invokevirtual 632	java/lang/StringBuffer:append	(Z)Ljava/lang/StringBuffer;
    //   2503: ldc_w 642
    //   2506: invokevirtual 629	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2509: aload 17
    //   2511: invokevirtual 629	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2514: ldc_w 644
    //   2517: invokevirtual 629	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2520: aload 6
    //   2522: invokevirtual 629	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2525: ldc_w 646
    //   2528: invokevirtual 629	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2531: iload 21
    //   2533: invokevirtual 649	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   2536: ldc_w 651
    //   2539: invokevirtual 629	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2542: aload 9
    //   2544: invokevirtual 655	org/apache/http/client/methods/HttpGet:getURI	()Ljava/net/URI;
    //   2547: invokevirtual 658	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   2550: pop
    //   2551: iload 41
    //   2553: istore 40
    //   2555: getstatic 41	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2558: iconst_1
    //   2559: aload 8
    //   2561: invokevirtual 659	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   2564: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2567: iload 41
    //   2569: istore 40
    //   2571: aload_0
    //   2572: getfield 170	com/tencent/mobileqq/vip/DownloadTask:l	Z
    //   2575: ifeq +574 -> 3149
    //   2578: ldc -84
    //   2580: astore 6
    //   2582: iload 41
    //   2584: istore 40
    //   2586: aload 9
    //   2588: ldc -82
    //   2590: aload 6
    //   2592: invokevirtual 662	org/apache/http/client/methods/HttpGet:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   2595: iload 41
    //   2597: istore 40
    //   2599: getstatic 665	com/tencent/mobileqq/utils/HttpDownloadUtil:a	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   2602: aload 9
    //   2604: invokevirtual 671	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   2607: astore 9
    //   2609: iconst_1
    //   2610: istore 41
    //   2612: iload 41
    //   2614: istore 40
    //   2616: aload 9
    //   2618: invokeinterface 677 1 0
    //   2623: invokeinterface 682 1 0
    //   2628: istore 21
    //   2630: iload 41
    //   2632: istore 40
    //   2634: aload_0
    //   2635: iload 21
    //   2637: putfield 685	com/tencent/mobileqq/vip/DownloadTask:D	I
    //   2640: iload 41
    //   2642: istore 40
    //   2644: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2647: ifeq +35 -> 2682
    //   2650: iload 41
    //   2652: istore 40
    //   2654: getstatic 41	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2657: iconst_2
    //   2658: new 134	java/lang/StringBuilder
    //   2661: dup
    //   2662: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   2665: ldc_w 687
    //   2668: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2671: iload 21
    //   2673: invokevirtual 197	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2676: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2679: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2682: iload 41
    //   2684: istore 40
    //   2686: aload 11
    //   2688: iload 21
    //   2690: putfield 689	com/tencent/mobileqq/emoticon/DownloadInfo:c	I
    //   2693: sipush 200
    //   2696: iload 21
    //   2698: if_icmpeq +11 -> 2709
    //   2701: sipush 206
    //   2704: iload 21
    //   2706: if_icmpne +1698 -> 4404
    //   2709: iload 41
    //   2711: istore 40
    //   2713: aload 9
    //   2715: invokeinterface 693 1 0
    //   2720: astore 6
    //   2722: aload 6
    //   2724: invokeinterface 696 1 0
    //   2729: lstore 35
    //   2731: lload 35
    //   2733: lstore 33
    //   2735: aload 9
    //   2737: ldc_w 698
    //   2740: invokeinterface 702 2 0
    //   2745: astore 5
    //   2747: lload 35
    //   2749: lstore 33
    //   2751: aload 9
    //   2753: ldc_w 704
    //   2756: invokeinterface 702 2 0
    //   2761: astore 8
    //   2763: aload 5
    //   2765: ifnull +391 -> 3156
    //   2768: lload 35
    //   2770: lstore 33
    //   2772: aload 5
    //   2774: invokeinterface 709 1 0
    //   2779: ldc_w 711
    //   2782: invokevirtual 715	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   2785: iconst_1
    //   2786: aaload
    //   2787: invokestatic 476	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   2790: i2l
    //   2791: lstore 31
    //   2793: lload 31
    //   2795: lconst_1
    //   2796: lcmp
    //   2797: iflt +34 -> 2831
    //   2800: lload 31
    //   2802: lstore 33
    //   2804: aload_0
    //   2805: getfield 717	com/tencent/mobileqq/vip/DownloadTask:jdField_e_of_type_Long	J
    //   2808: lconst_0
    //   2809: lcmp
    //   2810: ifle +375 -> 3185
    //   2813: lload 31
    //   2815: lstore 33
    //   2817: aload_0
    //   2818: getfield 717	com/tencent/mobileqq/vip/DownloadTask:jdField_e_of_type_Long	J
    //   2821: lstore 35
    //   2823: lload 31
    //   2825: lload 35
    //   2827: lcmp
    //   2828: ifle +357 -> 3185
    //   2831: aload_0
    //   2832: bipush -105
    //   2834: putfield 130	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   2837: new 134	java/lang/StringBuilder
    //   2840: dup
    //   2841: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   2844: ldc_w 719
    //   2847: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2850: lload 31
    //   2852: invokevirtual 283	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2855: ldc_w 721
    //   2858: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2861: aload_0
    //   2862: getfield 717	com/tencent/mobileqq/vip/DownloadTask:jdField_e_of_type_Long	J
    //   2865: invokevirtual 283	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2868: ldc_w 723
    //   2871: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2874: aload 7
    //   2876: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2879: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2882: astore 5
    //   2884: getstatic 41	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2887: iconst_1
    //   2888: aload 5
    //   2890: invokestatic 192	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2893: new 87	java/lang/Exception
    //   2896: dup
    //   2897: aload 5
    //   2899: invokespecial 288	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   2902: athrow
    //   2903: astore 9
    //   2905: bipush -105
    //   2907: istore 22
    //   2909: iconst_1
    //   2910: istore 40
    //   2912: aload_3
    //   2913: astore 5
    //   2915: aload 4
    //   2917: astore_3
    //   2918: aload 6
    //   2920: astore 8
    //   2922: iconst_1
    //   2923: istore 20
    //   2925: aload 9
    //   2927: astore 6
    //   2929: iload 19
    //   2931: istore 21
    //   2933: aload 5
    //   2935: astore 4
    //   2937: aload 8
    //   2939: astore 5
    //   2941: iload 22
    //   2943: istore 19
    //   2945: goto -2251 -> 694
    //   2948: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2951: ifeq -1186 -> 1765
    //   2954: getstatic 41	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2957: iconst_2
    //   2958: ldc_w 725
    //   2961: invokestatic 728	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2964: goto -1199 -> 1765
    //   2967: astore_1
    //   2968: iload 20
    //   2970: ifeq +70 -> 3040
    //   2973: aload_0
    //   2974: invokevirtual 308	com/tencent/mobileqq/vip/DownloadTask:b	()Z
    //   2977: ifne +63 -> 3040
    //   2980: aload_0
    //   2981: getfield 310	com/tencent/mobileqq/vip/DownloadTask:jdField_e_of_type_Boolean	Z
    //   2984: ifeq +56 -> 3040
    //   2987: aload 11
    //   2989: getfield 311	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_Boolean	Z
    //   2992: ifeq +2080 -> 5072
    //   2995: invokestatic 316	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:a	()Lcom/tencent/mobileqq/transfile/FMTSrvAddrProvider;
    //   2998: astore 6
    //   3000: aload 6
    //   3002: ifnull +18 -> 3020
    //   3005: aload 6
    //   3007: aload 11
    //   3009: getfield 318	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_d_of_type_Int	I
    //   3012: aload 11
    //   3014: getfield 319	com/tencent/mobileqq/emoticon/DownloadInfo:b	Ljava/lang/String;
    //   3017: invokevirtual 322	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:a	(ILjava/lang/String;)V
    //   3020: aload 11
    //   3022: getfield 319	com/tencent/mobileqq/emoticon/DownloadInfo:b	Ljava/lang/String;
    //   3025: aload 10
    //   3027: invokevirtual 230	java/io/File:getName	()Ljava/lang/String;
    //   3030: iconst_m1
    //   3031: aload_2
    //   3032: invokestatic 325	com/tencent/mobileqq/vip/DownloaderFactory:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/content/Context;)V
    //   3035: aload_0
    //   3036: iconst_0
    //   3037: putfield 327	com/tencent/mobileqq/vip/DownloadTask:jdField_d_of_type_Boolean	Z
    //   3040: aload 5
    //   3042: ifnull +10 -> 3052
    //   3045: aload 5
    //   3047: invokeinterface 332 1 0
    //   3052: aload_3
    //   3053: ifnull +7 -> 3060
    //   3056: aload_3
    //   3057: invokevirtual 337	java/io/InputStream:close	()V
    //   3060: aload 4
    //   3062: ifnull +8 -> 3070
    //   3065: aload 4
    //   3067: invokevirtual 340	java/io/BufferedOutputStream:close	()V
    //   3070: aload_1
    //   3071: athrow
    //   3072: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3075: ifeq -1075 -> 2000
    //   3078: getstatic 41	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3081: iconst_2
    //   3082: new 134	java/lang/StringBuilder
    //   3085: dup
    //   3086: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   3089: ldc_w 730
    //   3092: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3095: aload_0
    //   3096: getfield 504	com/tencent/mobileqq/vip/DownloadTask:k	Z
    //   3099: invokevirtual 276	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3102: ldc_w 732
    //   3105: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3108: aload_0
    //   3109: getfield 507	com/tencent/mobileqq/vip/DownloadTask:h	Z
    //   3112: invokevirtual 276	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3115: ldc_w 734
    //   3118: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3121: aload 10
    //   3123: invokevirtual 259	java/io/File:exists	()Z
    //   3126: invokevirtual 276	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3129: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3132: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3135: goto -1135 -> 2000
    //   3138: sipush 4096
    //   3141: istore 19
    //   3143: iconst_0
    //   3144: istore 39
    //   3146: goto -946 -> 2200
    //   3149: ldc -57
    //   3151: astore 6
    //   3153: goto -571 -> 2582
    //   3156: lload 35
    //   3158: lstore 31
    //   3160: aload 8
    //   3162: ifnull -369 -> 2793
    //   3165: lload 35
    //   3167: lstore 33
    //   3169: aload 8
    //   3171: invokeinterface 709 1 0
    //   3176: invokestatic 476	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   3179: i2l
    //   3180: lstore 31
    //   3182: goto -389 -> 2793
    //   3185: lload 31
    //   3187: lstore 33
    //   3189: aload 15
    //   3191: invokevirtual 493	java/io/File:length	()J
    //   3194: lstore 35
    //   3196: lload 35
    //   3198: lload 31
    //   3200: lcmp
    //   3201: iflt +2633 -> 5834
    //   3204: lload 31
    //   3206: lstore 33
    //   3208: aload 15
    //   3210: invokevirtual 737	java/io/File:delete	()Z
    //   3213: pop
    //   3214: lconst_0
    //   3215: lstore 35
    //   3217: lload 35
    //   3219: lconst_0
    //   3220: lcmp
    //   3221: ifeq +2741 -> 5962
    //   3224: iconst_1
    //   3225: istore 40
    //   3227: lload 31
    //   3229: lstore 33
    //   3231: new 339	java/io/BufferedOutputStream
    //   3234: dup
    //   3235: new 739	java/io/FileOutputStream
    //   3238: dup
    //   3239: aload 15
    //   3241: iload 40
    //   3243: invokespecial 742	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   3246: invokespecial 745	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   3249: astore 5
    //   3251: aload 6
    //   3253: invokeinterface 749 1 0
    //   3258: astore 4
    //   3260: aload 9
    //   3262: ldc_w 751
    //   3265: invokeinterface 702 2 0
    //   3270: ifnull +2602 -> 5872
    //   3273: ldc -84
    //   3275: aload 9
    //   3277: ldc_w 751
    //   3280: invokeinterface 702 2 0
    //   3285: invokeinterface 709 1 0
    //   3290: invokevirtual 579	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3293: ifeq +2579 -> 5872
    //   3296: new 753	java/util/zip/GZIPInputStream
    //   3299: dup
    //   3300: aload 4
    //   3302: invokespecial 756	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   3305: astore_3
    //   3306: invokestatic 762	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   3309: iload 19
    //   3311: invokevirtual 766	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   3314: astore 16
    //   3316: iconst_0
    //   3317: istore 21
    //   3319: lload 29
    //   3321: lstore 33
    //   3323: aload_0
    //   3324: invokevirtual 308	com/tencent/mobileqq/vip/DownloadTask:b	()Z
    //   3327: ifne +197 -> 3524
    //   3330: lload 29
    //   3332: lstore 33
    //   3334: aload_3
    //   3335: aload 16
    //   3337: invokevirtual 770	java/io/InputStream:read	([B)I
    //   3340: istore 22
    //   3342: iload 22
    //   3344: iconst_m1
    //   3345: if_icmpeq +179 -> 3524
    //   3348: lload 29
    //   3350: lstore 33
    //   3352: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3355: ifeq +89 -> 3444
    //   3358: lconst_0
    //   3359: lload 35
    //   3361: lcmp
    //   3362: ifne +82 -> 3444
    //   3365: aconst_null
    //   3366: astore 8
    //   3368: iload 22
    //   3370: iconst_4
    //   3371: if_icmple +2597 -> 5968
    //   3374: iconst_m1
    //   3375: aload 16
    //   3377: iconst_0
    //   3378: baload
    //   3379: if_icmpne +2589 -> 5968
    //   3382: bipush -40
    //   3384: aload 16
    //   3386: iconst_1
    //   3387: baload
    //   3388: if_icmpne +2580 -> 5968
    //   3391: ldc_w 772
    //   3394: astore 4
    //   3396: aload 4
    //   3398: ifnull +46 -> 3444
    //   3401: lload 29
    //   3403: lstore 33
    //   3405: getstatic 41	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3408: iconst_2
    //   3409: new 134	java/lang/StringBuilder
    //   3412: dup
    //   3413: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   3416: ldc_w 774
    //   3419: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3422: aload 4
    //   3424: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3427: ldc_w 776
    //   3430: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3433: aload 7
    //   3435: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3438: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3441: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3444: lload 29
    //   3446: lstore 33
    //   3448: aload 5
    //   3450: aload 16
    //   3452: iconst_0
    //   3453: iload 22
    //   3455: invokevirtual 780	java/io/BufferedOutputStream:write	([BII)V
    //   3458: lload 35
    //   3460: iload 22
    //   3462: i2l
    //   3463: ladd
    //   3464: lstore 35
    //   3466: lload 29
    //   3468: iload 22
    //   3470: i2l
    //   3471: ladd
    //   3472: lstore 29
    //   3474: iload 21
    //   3476: iload 22
    //   3478: iadd
    //   3479: istore 21
    //   3481: lload 29
    //   3483: lstore 33
    //   3485: iload 21
    //   3487: i2l
    //   3488: aload_0
    //   3489: getfield 782	com/tencent/mobileqq/vip/DownloadTask:jdField_f_of_type_Long	J
    //   3492: lcmp
    //   3493: iflt +2376 -> 5869
    //   3496: lload 29
    //   3498: lstore 33
    //   3500: aload_0
    //   3501: lload 31
    //   3503: lload 35
    //   3505: iload 25
    //   3507: invokevirtual 785	com/tencent/mobileqq/vip/DownloadTask:a	(JJI)V
    //   3510: lload 29
    //   3512: lstore 33
    //   3514: aload_0
    //   3515: invokevirtual 787	com/tencent/mobileqq/vip/DownloadTask:b	()V
    //   3518: iconst_0
    //   3519: istore 21
    //   3521: goto -202 -> 3319
    //   3524: lload 29
    //   3526: lstore 33
    //   3528: aload 5
    //   3530: invokevirtual 790	java/io/BufferedOutputStream:flush	()V
    //   3533: lload 29
    //   3535: lstore 33
    //   3537: invokestatic 762	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   3540: aload 16
    //   3542: invokevirtual 794	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   3545: lload 29
    //   3547: lstore 33
    //   3549: aload 15
    //   3551: invokevirtual 493	java/io/File:length	()J
    //   3554: lload 31
    //   3556: lcmp
    //   3557: ifeq +62 -> 3619
    //   3560: lload 29
    //   3562: lstore 33
    //   3564: aload 9
    //   3566: ldc_w 751
    //   3569: invokeinterface 702 2 0
    //   3574: ifnull +747 -> 4321
    //   3577: lload 29
    //   3579: lstore 33
    //   3581: ldc -84
    //   3583: aload 9
    //   3585: ldc_w 751
    //   3588: invokeinterface 702 2 0
    //   3593: invokeinterface 709 1 0
    //   3598: invokevirtual 579	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3601: ifeq +720 -> 4321
    //   3604: lload 29
    //   3606: lstore 33
    //   3608: aload 15
    //   3610: invokevirtual 493	java/io/File:length	()J
    //   3613: lload 31
    //   3615: lcmp
    //   3616: iflt +705 -> 4321
    //   3619: iconst_0
    //   3620: istore 27
    //   3622: iconst_0
    //   3623: istore 28
    //   3625: iconst_0
    //   3626: istore 24
    //   3628: lload 29
    //   3630: lstore 33
    //   3632: aload_0
    //   3633: iconst_0
    //   3634: putfield 130	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   3637: iload 27
    //   3639: istore 21
    //   3641: iload 28
    //   3643: istore 22
    //   3645: aload 10
    //   3647: invokevirtual 259	java/io/File:exists	()Z
    //   3650: ifeq +17 -> 3667
    //   3653: iload 27
    //   3655: istore 21
    //   3657: iload 28
    //   3659: istore 22
    //   3661: aload 10
    //   3663: invokevirtual 737	java/io/File:delete	()Z
    //   3666: pop
    //   3667: iload 27
    //   3669: istore 21
    //   3671: iload 28
    //   3673: istore 22
    //   3675: aload 15
    //   3677: aload 10
    //   3679: invokevirtual 798	java/io/File:renameTo	(Ljava/io/File;)Z
    //   3682: pop
    //   3683: iload 24
    //   3685: istore 20
    //   3687: iload 27
    //   3689: istore 21
    //   3691: iload 28
    //   3693: istore 22
    //   3695: aload_0
    //   3696: getfield 507	com/tencent/mobileqq/vip/DownloadTask:h	Z
    //   3699: ifeq +266 -> 3965
    //   3702: iload 24
    //   3704: istore 20
    //   3706: iload 27
    //   3708: istore 21
    //   3710: iload 28
    //   3712: istore 22
    //   3714: aload 9
    //   3716: ldc_w 800
    //   3719: invokeinterface 804 2 0
    //   3724: ifeq +241 -> 3965
    //   3727: iload 27
    //   3729: istore 21
    //   3731: iload 28
    //   3733: istore 22
    //   3735: aload 9
    //   3737: ldc_w 800
    //   3740: invokeinterface 702 2 0
    //   3745: invokeinterface 709 1 0
    //   3750: astore 4
    //   3752: iload 27
    //   3754: istore 21
    //   3756: iload 28
    //   3758: istore 22
    //   3760: aload 4
    //   3762: invokestatic 243	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3765: istore 40
    //   3767: iload 24
    //   3769: istore 20
    //   3771: iload 40
    //   3773: ifne +192 -> 3965
    //   3776: iload 27
    //   3778: istore 21
    //   3780: iload 28
    //   3782: istore 22
    //   3784: new 512	java/text/SimpleDateFormat
    //   3787: dup
    //   3788: ldc_w 806
    //   3791: getstatic 520	java/util/Locale:US	Ljava/util/Locale;
    //   3794: invokespecial 523	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   3797: astore 8
    //   3799: iload 27
    //   3801: istore 21
    //   3803: iload 28
    //   3805: istore 22
    //   3807: aload 8
    //   3809: ldc_w 525
    //   3812: invokestatic 531	java/util/TimeZone:getTimeZone	(Ljava/lang/String;)Ljava/util/TimeZone;
    //   3815: invokevirtual 535	java/text/SimpleDateFormat:setTimeZone	(Ljava/util/TimeZone;)V
    //   3818: iload 27
    //   3820: istore 21
    //   3822: iload 28
    //   3824: istore 22
    //   3826: aload 8
    //   3828: aload 4
    //   3830: invokevirtual 810	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   3833: invokevirtual 813	java/util/Date:getTime	()J
    //   3836: lstore 33
    //   3838: iload 27
    //   3840: istore 21
    //   3842: iload 28
    //   3844: istore 22
    //   3846: aload 10
    //   3848: lload 33
    //   3850: invokevirtual 817	java/io/File:setLastModified	(J)Z
    //   3853: pop
    //   3854: iload 27
    //   3856: istore 21
    //   3858: iload 28
    //   3860: istore 22
    //   3862: aload_0
    //   3863: lload 33
    //   3865: putfield 819	com/tencent/mobileqq/vip/DownloadTask:jdField_i_of_type_Long	J
    //   3868: iload 24
    //   3870: istore 20
    //   3872: iload 27
    //   3874: istore 21
    //   3876: iload 28
    //   3878: istore 22
    //   3880: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3883: ifeq +82 -> 3965
    //   3886: iload 27
    //   3888: istore 21
    //   3890: iload 28
    //   3892: istore 22
    //   3894: getstatic 41	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3897: iconst_2
    //   3898: new 134	java/lang/StringBuilder
    //   3901: dup
    //   3902: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   3905: ldc_w 821
    //   3908: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3911: aload 4
    //   3913: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3916: ldc_w 823
    //   3919: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3922: lload 33
    //   3924: invokevirtual 283	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3927: ldc_w 825
    //   3930: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3933: aload 10
    //   3935: invokevirtual 230	java/io/File:getName	()Ljava/lang/String;
    //   3938: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3941: ldc_w 549
    //   3944: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3947: aload 10
    //   3949: invokevirtual 510	java/io/File:lastModified	()J
    //   3952: invokevirtual 283	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3955: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3958: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3961: iload 24
    //   3963: istore 20
    //   3965: iconst_0
    //   3966: istore 21
    //   3968: aload 5
    //   3970: astore 4
    //   3972: aload 6
    //   3974: astore 5
    //   3976: iload 20
    //   3978: istore 22
    //   3980: iload 21
    //   3982: istore 20
    //   3984: iload 20
    //   3986: istore 21
    //   3988: getstatic 62	com/tencent/mobileqq/vip/DownloaderFactory:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   3991: ifnonnull +17 -> 4008
    //   3994: iload 20
    //   3996: istore 21
    //   3998: new 59	java/util/concurrent/ConcurrentHashMap
    //   4001: dup
    //   4002: invokespecial 60	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   4005: putstatic 62	com/tencent/mobileqq/vip/DownloaderFactory:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   4008: iload 22
    //   4010: ifeq +768 -> 4778
    //   4013: iload 20
    //   4015: istore 21
    //   4017: aload_0
    //   4018: invokevirtual 308	com/tencent/mobileqq/vip/DownloadTask:b	()Z
    //   4021: ifne +757 -> 4778
    //   4024: iload 20
    //   4026: istore 21
    //   4028: iload 26
    //   4030: aload_0
    //   4031: getfield 343	com/tencent/mobileqq/vip/DownloadTask:A	I
    //   4034: if_icmpge +616 -> 4650
    //   4037: iload 20
    //   4039: istore 21
    //   4041: aload 13
    //   4043: monitorenter
    //   4044: sipush 2000
    //   4047: i2l
    //   4048: lstore 33
    //   4050: aload 13
    //   4052: lload 33
    //   4054: invokevirtual 828	java/lang/Object:wait	(J)V
    //   4057: aload 13
    //   4059: monitorexit
    //   4060: iload 22
    //   4062: ifeq +70 -> 4132
    //   4065: aload_0
    //   4066: invokevirtual 308	com/tencent/mobileqq/vip/DownloadTask:b	()Z
    //   4069: ifne +63 -> 4132
    //   4072: aload_0
    //   4073: getfield 310	com/tencent/mobileqq/vip/DownloadTask:jdField_e_of_type_Boolean	Z
    //   4076: ifeq +56 -> 4132
    //   4079: aload 11
    //   4081: getfield 311	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_Boolean	Z
    //   4084: ifeq +712 -> 4796
    //   4087: invokestatic 316	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:a	()Lcom/tencent/mobileqq/transfile/FMTSrvAddrProvider;
    //   4090: astore 6
    //   4092: aload 6
    //   4094: ifnull +18 -> 4112
    //   4097: aload 6
    //   4099: aload 11
    //   4101: getfield 318	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_d_of_type_Int	I
    //   4104: aload 11
    //   4106: getfield 319	com/tencent/mobileqq/emoticon/DownloadInfo:b	Ljava/lang/String;
    //   4109: invokevirtual 322	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:a	(ILjava/lang/String;)V
    //   4112: aload 11
    //   4114: getfield 319	com/tencent/mobileqq/emoticon/DownloadInfo:b	Ljava/lang/String;
    //   4117: aload 10
    //   4119: invokevirtual 230	java/io/File:getName	()Ljava/lang/String;
    //   4122: iconst_m1
    //   4123: aload_2
    //   4124: invokestatic 325	com/tencent/mobileqq/vip/DownloaderFactory:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/content/Context;)V
    //   4127: aload_0
    //   4128: iconst_0
    //   4129: putfield 327	com/tencent/mobileqq/vip/DownloadTask:jdField_d_of_type_Boolean	Z
    //   4132: iload 26
    //   4134: iconst_1
    //   4135: iadd
    //   4136: istore 21
    //   4138: aload 5
    //   4140: ifnull +10 -> 4150
    //   4143: aload 5
    //   4145: invokeinterface 332 1 0
    //   4150: aload_3
    //   4151: ifnull +7 -> 4158
    //   4154: aload_3
    //   4155: invokevirtual 337	java/io/InputStream:close	()V
    //   4158: aload 4
    //   4160: ifnull +8 -> 4168
    //   4163: aload 4
    //   4165: invokevirtual 340	java/io/BufferedOutputStream:close	()V
    //   4168: aload_3
    //   4169: astore 6
    //   4171: aload 5
    //   4173: astore_3
    //   4174: iload 20
    //   4176: istore 24
    //   4178: iload 39
    //   4180: istore 40
    //   4182: iconst_1
    //   4183: istore 39
    //   4185: iload 21
    //   4187: istore 20
    //   4189: aload 4
    //   4191: astore 5
    //   4193: iload 22
    //   4195: istore 21
    //   4197: iload 24
    //   4199: istore 22
    //   4201: aload 6
    //   4203: astore 4
    //   4205: goto -3229 -> 976
    //   4208: astore 8
    //   4210: iload 27
    //   4212: istore 21
    //   4214: iload 28
    //   4216: istore 22
    //   4218: aload 8
    //   4220: invokevirtual 831	java/lang/Exception:printStackTrace	()V
    //   4223: iload 27
    //   4225: istore 21
    //   4227: iload 28
    //   4229: istore 22
    //   4231: getstatic 41	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4234: iconst_1
    //   4235: new 134	java/lang/StringBuilder
    //   4238: dup
    //   4239: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   4242: ldc_w 821
    //   4245: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4248: aload 4
    //   4250: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4253: ldc_w 833
    //   4256: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4259: aload 8
    //   4261: invokevirtual 834	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   4264: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4267: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4270: invokestatic 192	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   4273: iload 24
    //   4275: istore 20
    //   4277: goto -312 -> 3965
    //   4280: astore 9
    //   4282: iconst_0
    //   4283: istore 20
    //   4285: aload_3
    //   4286: astore 4
    //   4288: aload 6
    //   4290: astore 8
    //   4292: aload 5
    //   4294: astore_3
    //   4295: iload 21
    //   4297: istore 22
    //   4299: aload 9
    //   4301: astore 6
    //   4303: iconst_1
    //   4304: istore 40
    //   4306: iload 19
    //   4308: istore 21
    //   4310: aload 8
    //   4312: astore 5
    //   4314: iload 22
    //   4316: istore 19
    //   4318: goto -3624 -> 694
    //   4321: lload 29
    //   4323: lstore 33
    //   4325: aload_0
    //   4326: invokevirtual 308	com/tencent/mobileqq/vip/DownloadTask:b	()Z
    //   4329: ifeq +24 -> 4353
    //   4332: bipush -106
    //   4334: istore 21
    //   4336: lload 29
    //   4338: lstore 33
    //   4340: aload_0
    //   4341: bipush -106
    //   4343: putfield 130	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   4346: iload 21
    //   4348: istore 20
    //   4350: goto -385 -> 3965
    //   4353: bipush -105
    //   4355: istore 24
    //   4357: lload 29
    //   4359: lstore 33
    //   4361: aload_0
    //   4362: bipush -105
    //   4364: putfield 130	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   4367: iload 24
    //   4369: istore 21
    //   4371: iload 24
    //   4373: istore 22
    //   4375: aload 15
    //   4377: invokevirtual 737	java/io/File:delete	()Z
    //   4380: pop
    //   4381: iload 24
    //   4383: istore 20
    //   4385: goto -420 -> 3965
    //   4388: astore_1
    //   4389: iload 22
    //   4391: istore 20
    //   4393: aload 5
    //   4395: astore 4
    //   4397: aload 6
    //   4399: astore 5
    //   4401: goto -1433 -> 2968
    //   4404: sipush 404
    //   4407: iload 21
    //   4409: if_icmpne +19 -> 4428
    //   4412: aload_0
    //   4413: iload 21
    //   4415: putfield 130	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   4418: iconst_1
    //   4419: istore 20
    //   4421: iload 21
    //   4423: istore 22
    //   4425: goto -441 -> 3984
    //   4428: sipush 302
    //   4431: iload 21
    //   4433: if_icmpeq +11 -> 4444
    //   4436: sipush 301
    //   4439: iload 21
    //   4441: if_icmpne +68 -> 4509
    //   4444: iload 41
    //   4446: istore 40
    //   4448: aload_0
    //   4449: getfield 602	com/tencent/mobileqq/vip/DownloadTask:n	Z
    //   4452: istore 42
    //   4454: iload 42
    //   4456: ifne +53 -> 4509
    //   4459: aload_0
    //   4460: iload 21
    //   4462: putfield 130	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   4465: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4468: ifeq +1356 -> 5824
    //   4471: getstatic 41	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4474: iconst_2
    //   4475: new 134	java/lang/StringBuilder
    //   4478: dup
    //   4479: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   4482: ldc_w 836
    //   4485: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4488: iload 21
    //   4490: invokevirtual 197	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4493: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4496: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4499: iconst_1
    //   4500: istore 20
    //   4502: iload 21
    //   4504: istore 22
    //   4506: goto -522 -> 3984
    //   4509: sipush 304
    //   4512: iload 21
    //   4514: if_icmpne +21 -> 4535
    //   4517: iload 41
    //   4519: istore 40
    //   4521: aload_0
    //   4522: iconst_0
    //   4523: putfield 130	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   4526: iconst_0
    //   4527: istore 20
    //   4529: iconst_0
    //   4530: istore 22
    //   4532: goto -548 -> 3984
    //   4535: sipush 416
    //   4538: iload 21
    //   4540: if_icmpne +45 -> 4585
    //   4543: iload 41
    //   4545: istore 40
    //   4547: aload 15
    //   4549: invokevirtual 259	java/io/File:exists	()Z
    //   4552: ifeq +13 -> 4565
    //   4555: iload 41
    //   4557: istore 40
    //   4559: aload 15
    //   4561: invokevirtual 737	java/io/File:delete	()Z
    //   4564: pop
    //   4565: iload 41
    //   4567: istore 40
    //   4569: aload_0
    //   4570: iload 21
    //   4572: putfield 130	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   4575: iconst_0
    //   4576: istore 20
    //   4578: iload 21
    //   4580: istore 22
    //   4582: goto -598 -> 3984
    //   4585: iload 41
    //   4587: istore 40
    //   4589: aload_0
    //   4590: iload 21
    //   4592: putfield 130	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   4595: iconst_0
    //   4596: istore 20
    //   4598: iload 21
    //   4600: istore 22
    //   4602: goto -618 -> 3984
    //   4605: astore 6
    //   4607: getstatic 41	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4610: iconst_1
    //   4611: new 134	java/lang/StringBuilder
    //   4614: dup
    //   4615: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   4618: ldc_w 838
    //   4621: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4624: aload 7
    //   4626: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4629: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4632: invokestatic 192	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   4635: goto -578 -> 4057
    //   4638: astore 6
    //   4640: aload 13
    //   4642: monitorexit
    //   4643: iload 20
    //   4645: istore 21
    //   4647: aload 6
    //   4649: athrow
    //   4650: iload 20
    //   4652: istore 21
    //   4654: invokestatic 205	java/lang/System:currentTimeMillis	()J
    //   4657: ldc2_w 839
    //   4660: ldiv
    //   4661: l2i
    //   4662: istore 24
    //   4664: iload 20
    //   4666: istore 21
    //   4668: aload_0
    //   4669: getfield 842	com/tencent/mobileqq/vip/DownloadTask:jdField_c_of_type_Boolean	Z
    //   4672: ifeq +23 -> 4695
    //   4675: iload 20
    //   4677: istore 21
    //   4679: getstatic 62	com/tencent/mobileqq/vip/DownloaderFactory:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   4682: aload_0
    //   4683: getfield 843	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4686: iload 24
    //   4688: invokestatic 158	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4691: invokevirtual 844	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   4694: pop
    //   4695: iconst_1
    //   4696: istore 20
    //   4698: iload 20
    //   4700: istore 21
    //   4702: new 134	java/lang/StringBuilder
    //   4705: dup
    //   4706: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   4709: ldc_w 846
    //   4712: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4715: aload 7
    //   4717: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4720: ldc_w 848
    //   4723: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4726: aload_0
    //   4727: getfield 310	com/tencent/mobileqq/vip/DownloadTask:jdField_e_of_type_Boolean	Z
    //   4730: invokevirtual 276	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4733: ldc_w 850
    //   4736: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4739: aload_0
    //   4740: getfield 327	com/tencent/mobileqq/vip/DownloadTask:jdField_d_of_type_Boolean	Z
    //   4743: invokevirtual 276	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4746: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4749: astore 6
    //   4751: iload 20
    //   4753: istore 21
    //   4755: getstatic 41	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4758: iconst_1
    //   4759: aload 6
    //   4761: invokestatic 192	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   4764: iload 20
    //   4766: istore 21
    //   4768: new 87	java/lang/Exception
    //   4771: dup
    //   4772: aload 6
    //   4774: invokespecial 288	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   4777: athrow
    //   4778: iload 20
    //   4780: istore 21
    //   4782: getstatic 62	com/tencent/mobileqq/vip/DownloaderFactory:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   4785: aload_0
    //   4786: getfield 843	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4789: invokevirtual 853	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4792: pop
    //   4793: goto -733 -> 4060
    //   4796: aload_0
    //   4797: iconst_1
    //   4798: putfield 327	com/tencent/mobileqq/vip/DownloadTask:jdField_d_of_type_Boolean	Z
    //   4801: goto -669 -> 4132
    //   4804: astore 6
    //   4806: getstatic 41	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4809: iconst_1
    //   4810: new 134	java/lang/StringBuilder
    //   4813: dup
    //   4814: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   4817: ldc_w 855
    //   4820: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4823: aload 6
    //   4825: invokevirtual 856	java/io/IOException:getMessage	()Ljava/lang/String;
    //   4828: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4831: ldc_w 858
    //   4834: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4837: aload 7
    //   4839: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4842: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4845: invokestatic 192	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   4848: aload_3
    //   4849: astore 6
    //   4851: aload 5
    //   4853: astore_3
    //   4854: iload 20
    //   4856: istore 24
    //   4858: iload 39
    //   4860: istore 40
    //   4862: iconst_1
    //   4863: istore 39
    //   4865: iload 21
    //   4867: istore 20
    //   4869: aload 4
    //   4871: astore 5
    //   4873: iload 22
    //   4875: istore 21
    //   4877: iload 24
    //   4879: istore 22
    //   4881: aload 6
    //   4883: astore 4
    //   4885: goto -3909 -> 976
    //   4888: aload 6
    //   4890: instanceof 860
    //   4893: ifeq +12 -> 4905
    //   4896: aload_0
    //   4897: bipush -112
    //   4899: putfield 130	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   4902: goto -4164 -> 738
    //   4905: aload 6
    //   4907: instanceof 290
    //   4910: ifne +11 -> 4921
    //   4913: aload 6
    //   4915: instanceof 292
    //   4918: ifeq +12 -> 4930
    //   4921: aload_0
    //   4922: bipush -113
    //   4924: putfield 130	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   4927: goto -4189 -> 738
    //   4930: aload 6
    //   4932: instanceof 294
    //   4935: ifeq +12 -> 4947
    //   4938: aload_0
    //   4939: bipush -114
    //   4941: putfield 130	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   4944: goto -4206 -> 738
    //   4947: aload_0
    //   4948: getfield 130	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   4951: ifne -4213 -> 738
    //   4954: aload_0
    //   4955: bipush -115
    //   4957: putfield 130	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   4960: goto -4222 -> 738
    //   4963: aload_0
    //   4964: iconst_0
    //   4965: putfield 301	com/tencent/mobileqq/vip/DownloadTask:jdField_f_of_type_Boolean	Z
    //   4968: goto -4201 -> 767
    //   4971: aload_0
    //   4972: iconst_1
    //   4973: putfield 327	com/tencent/mobileqq/vip/DownloadTask:jdField_d_of_type_Boolean	Z
    //   4976: goto -4082 -> 894
    //   4979: astore 6
    //   4981: getstatic 41	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4984: iconst_1
    //   4985: new 134	java/lang/StringBuilder
    //   4988: dup
    //   4989: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   4992: ldc_w 855
    //   4995: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4998: aload 6
    //   5000: invokevirtual 856	java/io/IOException:getMessage	()Ljava/lang/String;
    //   5003: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5006: ldc_w 858
    //   5009: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5012: aload 7
    //   5014: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5017: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5020: invokestatic 192	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5023: iload 39
    //   5025: istore 41
    //   5027: iload 40
    //   5029: istore 39
    //   5031: aload 5
    //   5033: astore 6
    //   5035: iload 20
    //   5037: istore 24
    //   5039: iload 19
    //   5041: istore 26
    //   5043: iload 22
    //   5045: istore 20
    //   5047: iload 21
    //   5049: istore 19
    //   5051: aload_3
    //   5052: astore 5
    //   5054: aload 6
    //   5056: astore_3
    //   5057: iload 26
    //   5059: istore 21
    //   5061: iload 41
    //   5063: istore 40
    //   5065: iload 24
    //   5067: istore 22
    //   5069: goto -4093 -> 976
    //   5072: aload_0
    //   5073: iconst_1
    //   5074: putfield 327	com/tencent/mobileqq/vip/DownloadTask:jdField_d_of_type_Boolean	Z
    //   5077: goto -2037 -> 3040
    //   5080: astore_0
    //   5081: getstatic 41	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   5084: iconst_1
    //   5085: new 134	java/lang/StringBuilder
    //   5088: dup
    //   5089: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   5092: ldc_w 855
    //   5095: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5098: aload_0
    //   5099: invokevirtual 856	java/io/IOException:getMessage	()Ljava/lang/String;
    //   5102: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5105: ldc_w 858
    //   5108: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5111: aload 7
    //   5113: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5116: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5119: invokestatic 192	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5122: goto -2052 -> 3070
    //   5125: aload_0
    //   5126: bipush -110
    //   5128: putfield 130	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   5131: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5134: ifeq +1155 -> 6289
    //   5137: getstatic 41	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   5140: iconst_2
    //   5141: ldc_w 862
    //   5144: invokestatic 728	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   5147: goto +1142 -> 6289
    //   5150: aload_0
    //   5151: getfield 865	com/tencent/mobileqq/vip/DownloadTask:m	Z
    //   5154: iconst_1
    //   5155: if_icmpne +662 -> 5817
    //   5158: iload 19
    //   5160: istore 20
    //   5162: iload 23
    //   5164: ifle +81 -> 5245
    //   5167: iload 19
    //   5169: istore 20
    //   5171: aload_0
    //   5172: getfield 177	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   5175: invokeinterface 183 1 0
    //   5180: iconst_1
    //   5181: if_icmple +64 -> 5245
    //   5184: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5187: ifeq +49 -> 5236
    //   5190: getstatic 41	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   5193: iconst_2
    //   5194: new 134	java/lang/StringBuilder
    //   5197: dup
    //   5198: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   5201: ldc_w 867
    //   5204: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5207: iload 23
    //   5209: invokevirtual 197	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5212: ldc_w 869
    //   5215: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5218: aload_0
    //   5219: getfield 177	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   5222: invokeinterface 183 1 0
    //   5227: invokevirtual 197	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5230: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5233: invokestatic 728	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   5236: aload_0
    //   5237: bipush -108
    //   5239: putfield 130	com/tencent/mobileqq/vip/DownloadTask:z	I
    //   5242: iconst_m1
    //   5243: istore 20
    //   5245: aload_0
    //   5246: invokevirtual 308	com/tencent/mobileqq/vip/DownloadTask:b	()Z
    //   5249: ifeq +37 -> 5286
    //   5252: aload_0
    //   5253: getfield 872	com/tencent/mobileqq/vip/DownloadTask:g	Z
    //   5256: ifne +30 -> 5286
    //   5259: iload 20
    //   5261: istore 19
    //   5263: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5266: ifeq -4984 -> 282
    //   5269: getstatic 41	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   5272: iconst_2
    //   5273: ldc_w 874
    //   5276: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5279: iload 20
    //   5281: istore 19
    //   5283: goto -5001 -> 282
    //   5286: aload_0
    //   5287: invokevirtual 308	com/tencent/mobileqq/vip/DownloadTask:b	()Z
    //   5290: ifeq +1024 -> 6314
    //   5293: aload_0
    //   5294: iconst_2
    //   5295: invokevirtual 877	com/tencent/mobileqq/vip/DownloadTask:a	(I)V
    //   5298: aload_0
    //   5299: invokevirtual 879	com/tencent/mobileqq/vip/DownloadTask:c	()V
    //   5302: aload_0
    //   5303: invokevirtual 132	com/tencent/mobileqq/vip/DownloadTask:f	()V
    //   5306: iload 20
    //   5308: istore 19
    //   5310: goto -5028 -> 282
    //   5313: aload_0
    //   5314: iload 19
    //   5316: invokevirtual 877	com/tencent/mobileqq/vip/DownloadTask:a	(I)V
    //   5319: goto -17 -> 5302
    //   5322: iconst_m1
    //   5323: istore 19
    //   5325: goto -12 -> 5313
    //   5328: aload_0
    //   5329: instanceof 860
    //   5332: ifeq -5059 -> 273
    //   5335: goto -5062 -> 273
    //   5338: astore 6
    //   5340: goto -4048 -> 1292
    //   5343: astore_1
    //   5344: aload 4
    //   5346: astore_3
    //   5347: aload 5
    //   5349: astore 4
    //   5351: aload 6
    //   5353: astore 5
    //   5355: goto -2387 -> 2968
    //   5358: astore_1
    //   5359: aload 5
    //   5361: astore 4
    //   5363: aload 6
    //   5365: astore 5
    //   5367: goto -2399 -> 2968
    //   5370: astore_1
    //   5371: bipush -103
    //   5373: istore 20
    //   5375: goto -2407 -> 2968
    //   5378: astore_1
    //   5379: bipush -104
    //   5381: istore 20
    //   5383: goto -2415 -> 2968
    //   5386: astore_1
    //   5387: aload 6
    //   5389: astore 5
    //   5391: goto -2423 -> 2968
    //   5394: astore_1
    //   5395: aload 6
    //   5397: astore 5
    //   5399: bipush -105
    //   5401: istore 20
    //   5403: goto -2435 -> 2968
    //   5406: astore_1
    //   5407: aload 5
    //   5409: astore 4
    //   5411: aload 6
    //   5413: astore 5
    //   5415: goto -2447 -> 2968
    //   5418: astore_1
    //   5419: iload 21
    //   5421: istore 20
    //   5423: goto -2455 -> 2968
    //   5426: astore 9
    //   5428: iconst_1
    //   5429: istore 40
    //   5431: aload 6
    //   5433: astore 8
    //   5435: aload 5
    //   5437: astore_3
    //   5438: iload 20
    //   5440: istore 22
    //   5442: iconst_0
    //   5443: istore 20
    //   5445: aload 9
    //   5447: astore 6
    //   5449: iload 19
    //   5451: istore 21
    //   5453: aload 8
    //   5455: astore 5
    //   5457: iload 22
    //   5459: istore 19
    //   5461: goto -4767 -> 694
    //   5464: astore 9
    //   5466: iconst_1
    //   5467: istore 40
    //   5469: iload 20
    //   5471: istore 22
    //   5473: aload_3
    //   5474: astore 4
    //   5476: aload 6
    //   5478: astore 8
    //   5480: iconst_0
    //   5481: istore 20
    //   5483: aload 9
    //   5485: astore 6
    //   5487: iload 19
    //   5489: istore 21
    //   5491: aload 5
    //   5493: astore_3
    //   5494: aload 8
    //   5496: astore 5
    //   5498: iload 22
    //   5500: istore 19
    //   5502: goto -4808 -> 694
    //   5505: astore 6
    //   5507: aload_3
    //   5508: astore 8
    //   5510: iconst_0
    //   5511: istore 40
    //   5513: aload 4
    //   5515: astore_3
    //   5516: iload 20
    //   5518: istore 22
    //   5520: iconst_1
    //   5521: istore 20
    //   5523: iload 19
    //   5525: istore 21
    //   5527: aload 8
    //   5529: astore 4
    //   5531: iload 22
    //   5533: istore 19
    //   5535: goto -4841 -> 694
    //   5538: astore 6
    //   5540: iconst_0
    //   5541: istore 21
    //   5543: aload_3
    //   5544: astore 8
    //   5546: aload 4
    //   5548: astore_3
    //   5549: iload 20
    //   5551: istore 22
    //   5553: iload 21
    //   5555: istore 20
    //   5557: iload 19
    //   5559: istore 21
    //   5561: aload 8
    //   5563: astore 4
    //   5565: iload 22
    //   5567: istore 19
    //   5569: goto -4875 -> 694
    //   5572: astore 9
    //   5574: iload 20
    //   5576: istore 22
    //   5578: iconst_1
    //   5579: istore 40
    //   5581: aload 6
    //   5583: astore 5
    //   5585: aload_3
    //   5586: astore 8
    //   5588: iconst_0
    //   5589: istore 20
    //   5591: aload 9
    //   5593: astore 6
    //   5595: iload 19
    //   5597: istore 21
    //   5599: aload 4
    //   5601: astore_3
    //   5602: aload 8
    //   5604: astore 4
    //   5606: iload 22
    //   5608: istore 19
    //   5610: goto -4916 -> 694
    //   5613: astore 9
    //   5615: iconst_1
    //   5616: istore 40
    //   5618: iload 20
    //   5620: istore 22
    //   5622: aload 6
    //   5624: astore 5
    //   5626: lload 33
    //   5628: lstore 31
    //   5630: aload_3
    //   5631: astore 8
    //   5633: iconst_0
    //   5634: istore 20
    //   5636: aload 9
    //   5638: astore 6
    //   5640: iload 19
    //   5642: istore 21
    //   5644: aload 4
    //   5646: astore_3
    //   5647: aload 8
    //   5649: astore 4
    //   5651: iload 22
    //   5653: istore 19
    //   5655: goto -4961 -> 694
    //   5658: astore 9
    //   5660: iconst_1
    //   5661: istore 40
    //   5663: iload 20
    //   5665: istore 22
    //   5667: aload_3
    //   5668: astore 5
    //   5670: aload 6
    //   5672: astore 8
    //   5674: iconst_1
    //   5675: istore 20
    //   5677: aload 9
    //   5679: astore 6
    //   5681: iload 19
    //   5683: istore 21
    //   5685: aload 4
    //   5687: astore_3
    //   5688: aload 5
    //   5690: astore 4
    //   5692: aload 8
    //   5694: astore 5
    //   5696: iload 22
    //   5698: istore 19
    //   5700: goto -5006 -> 694
    //   5703: astore 9
    //   5705: iconst_1
    //   5706: istore 40
    //   5708: aload 6
    //   5710: astore 8
    //   5712: iload 20
    //   5714: istore 22
    //   5716: aload_3
    //   5717: astore 4
    //   5719: iconst_0
    //   5720: istore 20
    //   5722: aload 9
    //   5724: astore 6
    //   5726: iload 19
    //   5728: istore 21
    //   5730: aload 5
    //   5732: astore_3
    //   5733: aload 8
    //   5735: astore 5
    //   5737: iload 22
    //   5739: istore 19
    //   5741: goto -5047 -> 694
    //   5744: astore 6
    //   5746: aload_3
    //   5747: astore 8
    //   5749: iconst_1
    //   5750: istore 40
    //   5752: aload 4
    //   5754: astore_3
    //   5755: iload 20
    //   5757: istore 22
    //   5759: iconst_1
    //   5760: istore 20
    //   5762: iload 19
    //   5764: istore 21
    //   5766: aload 8
    //   5768: astore 4
    //   5770: iload 22
    //   5772: istore 19
    //   5774: goto -5080 -> 694
    //   5777: astore 6
    //   5779: aload_3
    //   5780: astore 8
    //   5782: iconst_1
    //   5783: istore 40
    //   5785: aload 4
    //   5787: astore_3
    //   5788: iload 21
    //   5790: istore 22
    //   5792: iconst_1
    //   5793: istore 20
    //   5795: iload 19
    //   5797: istore 21
    //   5799: aload 8
    //   5801: astore 4
    //   5803: iload 22
    //   5805: istore 19
    //   5807: goto -5113 -> 694
    //   5810: aload 6
    //   5812: astore 7
    //   5814: goto -5323 -> 491
    //   5817: iload 23
    //   5819: istore 20
    //   5821: goto -4518 -> 1303
    //   5824: iconst_1
    //   5825: istore 20
    //   5827: iload 21
    //   5829: istore 22
    //   5831: goto -1847 -> 3984
    //   5834: goto -2617 -> 3217
    //   5837: goto -3637 -> 2200
    //   5840: iload 20
    //   5842: istore 26
    //   5844: aload 4
    //   5846: astore 6
    //   5848: iload 21
    //   5850: istore 20
    //   5852: iload 40
    //   5854: istore 39
    //   5856: aload 5
    //   5858: astore 4
    //   5860: aload_3
    //   5861: astore 5
    //   5863: aload 6
    //   5865: astore_3
    //   5866: goto -5325 -> 541
    //   5869: goto -2550 -> 3319
    //   5872: aload 4
    //   5874: astore_3
    //   5875: goto -2569 -> 3306
    //   5878: iload 20
    //   5880: ireturn
    //   5881: iconst_1
    //   5882: istore 22
    //   5884: goto -5160 -> 724
    //   5887: lload 29
    //   5889: lstore 33
    //   5891: aload 7
    //   5893: astore 6
    //   5895: lload 31
    //   5897: lstore 29
    //   5899: iload 19
    //   5901: istore 24
    //   5903: iload 20
    //   5905: istore 22
    //   5907: iload 21
    //   5909: istore 19
    //   5911: iload 24
    //   5913: istore 21
    //   5915: goto -4910 -> 1005
    //   5918: iload 19
    //   5920: ifne +388 -> 6308
    //   5923: iconst_1
    //   5924: istore 40
    //   5926: goto -4768 -> 1158
    //   5929: astore 6
    //   5931: aload_3
    //   5932: astore 8
    //   5934: iconst_0
    //   5935: istore 40
    //   5937: aload 4
    //   5939: astore_3
    //   5940: iload 20
    //   5942: istore 22
    //   5944: iconst_0
    //   5945: istore 20
    //   5947: iload 19
    //   5949: istore 21
    //   5951: aload 8
    //   5953: astore 4
    //   5955: iload 22
    //   5957: istore 19
    //   5959: goto -5265 -> 694
    //   5962: iconst_0
    //   5963: istore 40
    //   5965: goto -2738 -> 3227
    //   5968: iload 22
    //   5970: bipush 8
    //   5972: if_icmple +85 -> 6057
    //   5975: bipush -119
    //   5977: aload 16
    //   5979: iconst_0
    //   5980: baload
    //   5981: if_icmpne +76 -> 6057
    //   5984: bipush 80
    //   5986: aload 16
    //   5988: iconst_1
    //   5989: baload
    //   5990: if_icmpne +67 -> 6057
    //   5993: bipush 78
    //   5995: aload 16
    //   5997: iconst_2
    //   5998: baload
    //   5999: if_icmpne +58 -> 6057
    //   6002: bipush 71
    //   6004: aload 16
    //   6006: iconst_3
    //   6007: baload
    //   6008: if_icmpne +49 -> 6057
    //   6011: bipush 13
    //   6013: aload 16
    //   6015: iconst_4
    //   6016: baload
    //   6017: if_icmpne +40 -> 6057
    //   6020: bipush 10
    //   6022: aload 16
    //   6024: iconst_5
    //   6025: baload
    //   6026: if_icmpne +31 -> 6057
    //   6029: bipush 26
    //   6031: aload 16
    //   6033: bipush 6
    //   6035: baload
    //   6036: if_icmpne +21 -> 6057
    //   6039: bipush 10
    //   6041: aload 16
    //   6043: bipush 7
    //   6045: baload
    //   6046: if_icmpne +11 -> 6057
    //   6049: ldc_w 881
    //   6052: astore 4
    //   6054: goto -2658 -> 3396
    //   6057: aload 8
    //   6059: astore 4
    //   6061: iload 22
    //   6063: bipush 12
    //   6065: if_icmple -2669 -> 3396
    //   6068: aload 8
    //   6070: astore 4
    //   6072: bipush 82
    //   6074: aload 16
    //   6076: iconst_0
    //   6077: baload
    //   6078: if_icmpne -2682 -> 3396
    //   6081: aload 8
    //   6083: astore 4
    //   6085: bipush 73
    //   6087: aload 16
    //   6089: iconst_1
    //   6090: baload
    //   6091: if_icmpne -2695 -> 3396
    //   6094: aload 8
    //   6096: astore 4
    //   6098: bipush 70
    //   6100: aload 16
    //   6102: iconst_2
    //   6103: baload
    //   6104: if_icmpne -2708 -> 3396
    //   6107: aload 8
    //   6109: astore 4
    //   6111: bipush 70
    //   6113: aload 16
    //   6115: iconst_3
    //   6116: baload
    //   6117: if_icmpne -2721 -> 3396
    //   6120: aload 8
    //   6122: astore 4
    //   6124: bipush 87
    //   6126: aload 16
    //   6128: bipush 8
    //   6130: baload
    //   6131: if_icmpne -2735 -> 3396
    //   6134: aload 8
    //   6136: astore 4
    //   6138: bipush 69
    //   6140: aload 16
    //   6142: bipush 9
    //   6144: baload
    //   6145: if_icmpne -2749 -> 3396
    //   6148: aload 8
    //   6150: astore 4
    //   6152: bipush 66
    //   6154: aload 16
    //   6156: bipush 10
    //   6158: baload
    //   6159: if_icmpne -2763 -> 3396
    //   6162: aload 8
    //   6164: astore 4
    //   6166: bipush 80
    //   6168: aload 16
    //   6170: bipush 11
    //   6172: baload
    //   6173: if_icmpne -2777 -> 3396
    //   6176: ldc_w 883
    //   6179: astore 4
    //   6181: goto -2785 -> 3396
    //   6184: astore 9
    //   6186: iconst_0
    //   6187: istore 21
    //   6189: aload_3
    //   6190: astore 4
    //   6192: aload 6
    //   6194: astore 8
    //   6196: aload 5
    //   6198: astore_3
    //   6199: iload 20
    //   6201: istore 22
    //   6203: lload 33
    //   6205: lstore 29
    //   6207: iconst_1
    //   6208: istore 40
    //   6210: aload 9
    //   6212: astore 6
    //   6214: iload 21
    //   6216: istore 20
    //   6218: iload 19
    //   6220: istore 21
    //   6222: aload 8
    //   6224: astore 5
    //   6226: iload 22
    //   6228: istore 19
    //   6230: goto -5536 -> 694
    //   6233: astore 6
    //   6235: iload 21
    //   6237: istore 20
    //   6239: iconst_1
    //   6240: istore 40
    //   6242: aload_3
    //   6243: astore 8
    //   6245: iload 19
    //   6247: istore 21
    //   6249: aload 4
    //   6251: astore_3
    //   6252: aload 8
    //   6254: astore 4
    //   6256: iload 22
    //   6258: istore 19
    //   6260: goto -5566 -> 694
    //   6263: astore_1
    //   6264: iload 22
    //   6266: istore 20
    //   6268: goto -3300 -> 2968
    //   6271: astore_1
    //   6272: aload 4
    //   6274: astore 6
    //   6276: aload_3
    //   6277: astore 4
    //   6279: aload 6
    //   6281: astore_3
    //   6282: iload 19
    //   6284: istore 20
    //   6286: goto -3318 -> 2968
    //   6289: lconst_0
    //   6290: lstore 33
    //   6292: iconst_m1
    //   6293: istore 19
    //   6295: lconst_0
    //   6296: lstore 29
    //   6298: iconst_m1
    //   6299: istore 22
    //   6301: iload 20
    //   6303: istore 21
    //   6305: goto -5300 -> 1005
    //   6308: iconst_0
    //   6309: istore 40
    //   6311: goto -5153 -> 1158
    //   6314: iload 20
    //   6316: ifne -994 -> 5322
    //   6319: iconst_3
    //   6320: istore 19
    //   6322: goto -1009 -> 5313
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	6325	0	paramDownloadTask	DownloadTask
    //   0	6325	1	paramString	String
    //   0	6325	2	paramContext	Context
    //   175	6107	3	localObject1	Object
    //   343	5935	4	localObject2	Object
    //   348	5877	5	localObject3	Object
    //   400	993	6	localObject4	Object
    //   1398	1	6	localThrowable1	Throwable
    //   1446	2952	6	localObject5	Object
    //   4605	1	6	localInterruptedException	InterruptedException
    //   4638	10	6	localObject6	Object
    //   4749	24	6	str1	String
    //   4804	20	6	localIOException1	java.io.IOException
    //   4849	82	6	localObject7	Object
    //   4979	20	6	localIOException2	java.io.IOException
    //   5033	22	6	localObject8	Object
    //   5338	94	6	localThrowable2	Throwable
    //   5447	39	6	localObject9	Object
    //   5505	1	6	localThrowable3	Throwable
    //   5538	44	6	localThrowable4	Throwable
    //   5593	132	6	localObject10	Object
    //   5744	1	6	localThrowable5	Throwable
    //   5777	34	6	localThrowable6	Throwable
    //   5846	48	6	localObject11	Object
    //   5929	264	6	localThrowable7	Throwable
    //   6212	1	6	localObject12	Object
    //   6233	1	6	localThrowable8	Throwable
    //   6274	6	6	localObject13	Object
    //   489	5403	7	localObject14	Object
    //   660	31	8	localThrowable9	Throwable
    //   1016	2811	8	localObject15	Object
    //   4208	52	8	localException	Exception
    //   4290	1963	8	localObject16	Object
    //   1440	1312	9	localObject17	Object
    //   2903	833	9	localThrowable10	Throwable
    //   4280	20	9	localThrowable11	Throwable
    //   5426	20	9	localThrowable12	Throwable
    //   5464	20	9	localThrowable13	Throwable
    //   5572	20	9	localThrowable14	Throwable
    //   5613	24	9	localThrowable15	Throwable
    //   5658	20	9	localThrowable16	Throwable
    //   5703	20	9	localThrowable17	Throwable
    //   6184	27	9	localThrowable18	Throwable
    //   422	3696	10	localFile1	java.io.File
    //   502	3611	11	localDownloadInfo	com.tencent.mobileqq.emoticon.DownloadInfo
    //   133	2125	12	localBasicHttpParams	org.apache.http.params.BasicHttpParams
    //   384	4257	13	localObject18	Object
    //   434	160	14	localFile2	java.io.File
    //   468	4092	15	localFile3	java.io.File
    //   1343	4826	16	localObject19	Object
    //   1487	1023	17	str2	String
    //   1501	46	18	str3	String
    //   17	6304	19	i	int
    //   90	6225	20	j	int
    //   511	5793	21	k	int
    //   671	5629	22	m	int
    //   337	5481	23	n	int
    //   936	4976	24	i1	int
    //   340	3166	25	i2	int
    //   508	5335	26	i3	int
    //   3620	604	27	i4	int
    //   3623	605	28	i5	int
    //   525	5772	29	l1	long
    //   528	5368	31	l2	long
    //   1281	1	33	localObject20	Object
    //   1783	4508	33	l3	long
    //   2729	775	35	l4	long
    //   375	904	37	l5	long
    //   356	5499	39	bool1	boolean
    //   567	5743	40	bool2	boolean
    //   542	4520	41	bool3	boolean
    //   4452	3	42	bool4	boolean
    // Exception table:
    //   from	to	target	type
    //   71	88	254	java/lang/Throwable
    //   92	124	254	java/lang/Throwable
    //   126	173	254	java/lang/Throwable
    //   176	206	254	java/lang/Throwable
    //   206	216	254	java/lang/Throwable
    //   220	252	254	java/lang/Throwable
    //   328	339	254	java/lang/Throwable
    //   358	424	254	java/lang/Throwable
    //   429	491	254	java/lang/Throwable
    //   491	504	254	java/lang/Throwable
    //   827	854	254	java/lang/Throwable
    //   859	874	254	java/lang/Throwable
    //   874	894	254	java/lang/Throwable
    //   905	912	254	java/lang/Throwable
    //   917	922	254	java/lang/Throwable
    //   926	930	254	java/lang/Throwable
    //   986	1002	254	java/lang/Throwable
    //   1005	1121	254	java/lang/Throwable
    //   1126	1155	254	java/lang/Throwable
    //   1158	1163	254	java/lang/Throwable
    //   1167	1173	254	java/lang/Throwable
    //   2973	3000	254	java/lang/Throwable
    //   3005	3020	254	java/lang/Throwable
    //   3020	3040	254	java/lang/Throwable
    //   3045	3052	254	java/lang/Throwable
    //   3056	3060	254	java/lang/Throwable
    //   3065	3070	254	java/lang/Throwable
    //   3070	3072	254	java/lang/Throwable
    //   4065	4092	254	java/lang/Throwable
    //   4097	4112	254	java/lang/Throwable
    //   4112	4132	254	java/lang/Throwable
    //   4143	4150	254	java/lang/Throwable
    //   4154	4158	254	java/lang/Throwable
    //   4163	4168	254	java/lang/Throwable
    //   4796	4801	254	java/lang/Throwable
    //   4806	4848	254	java/lang/Throwable
    //   4971	4976	254	java/lang/Throwable
    //   4981	5023	254	java/lang/Throwable
    //   5072	5077	254	java/lang/Throwable
    //   5081	5122	254	java/lang/Throwable
    //   5125	5147	254	java/lang/Throwable
    //   5150	5158	254	java/lang/Throwable
    //   5171	5236	254	java/lang/Throwable
    //   5236	5242	254	java/lang/Throwable
    //   5245	5259	254	java/lang/Throwable
    //   5263	5279	254	java/lang/Throwable
    //   5286	5302	254	java/lang/Throwable
    //   5302	5306	254	java/lang/Throwable
    //   5313	5319	254	java/lang/Throwable
    //   580	660	660	java/lang/Throwable
    //   1356	1398	1398	java/lang/Throwable
    //   2837	2903	2903	java/lang/Throwable
    //   544	549	2967	finally
    //   554	569	2967	finally
    //   574	580	2967	finally
    //   1320	1340	2967	finally
    //   1340	1345	2967	finally
    //   1350	1356	2967	finally
    //   1431	1448	2967	finally
    //   1453	1467	2967	finally
    //   1467	1557	2967	finally
    //   1560	1606	2967	finally
    //   1606	1765	2967	finally
    //   1770	1854	2967	finally
    //   1854	1868	2967	finally
    //   1873	1888	2967	finally
    //   1895	2000	2967	finally
    //   2000	2063	2967	finally
    //   2063	2096	2967	finally
    //   2108	2116	2967	finally
    //   2124	2141	2967	finally
    //   2167	2189	2967	finally
    //   2204	2211	2967	finally
    //   2215	2224	2967	finally
    //   2228	2234	2967	finally
    //   2238	2251	2967	finally
    //   2255	2262	2967	finally
    //   2266	2272	2967	finally
    //   2276	2285	2967	finally
    //   2289	2401	2967	finally
    //   2405	2417	2967	finally
    //   2426	2435	2967	finally
    //   2439	2551	2967	finally
    //   2555	2567	2967	finally
    //   2571	2578	2967	finally
    //   2586	2595	2967	finally
    //   2599	2609	2967	finally
    //   2616	2630	2967	finally
    //   2634	2640	2967	finally
    //   2644	2650	2967	finally
    //   2654	2682	2967	finally
    //   2686	2693	2967	finally
    //   2713	2722	2967	finally
    //   2948	2964	2967	finally
    //   3072	3135	2967	finally
    //   4412	4418	2967	finally
    //   4448	4454	2967	finally
    //   4459	4465	2967	finally
    //   4521	4526	2967	finally
    //   4547	4555	2967	finally
    //   4559	4565	2967	finally
    //   4569	4575	2967	finally
    //   4589	4595	2967	finally
    //   3784	3799	4208	java/lang/Exception
    //   3807	3818	4208	java/lang/Exception
    //   3826	3838	4208	java/lang/Exception
    //   3846	3854	4208	java/lang/Exception
    //   3862	3868	4208	java/lang/Exception
    //   3880	3886	4208	java/lang/Exception
    //   3894	3961	4208	java/lang/Exception
    //   3645	3653	4280	java/lang/Throwable
    //   3661	3667	4280	java/lang/Throwable
    //   3675	3683	4280	java/lang/Throwable
    //   3695	3702	4280	java/lang/Throwable
    //   3714	3727	4280	java/lang/Throwable
    //   3735	3752	4280	java/lang/Throwable
    //   3760	3767	4280	java/lang/Throwable
    //   3784	3799	4280	java/lang/Throwable
    //   3807	3818	4280	java/lang/Throwable
    //   3826	3838	4280	java/lang/Throwable
    //   3846	3854	4280	java/lang/Throwable
    //   3862	3868	4280	java/lang/Throwable
    //   3880	3886	4280	java/lang/Throwable
    //   3894	3961	4280	java/lang/Throwable
    //   4218	4223	4280	java/lang/Throwable
    //   4231	4273	4280	java/lang/Throwable
    //   4375	4381	4280	java/lang/Throwable
    //   3645	3653	4388	finally
    //   3661	3667	4388	finally
    //   3675	3683	4388	finally
    //   3695	3702	4388	finally
    //   3714	3727	4388	finally
    //   3735	3752	4388	finally
    //   3760	3767	4388	finally
    //   3784	3799	4388	finally
    //   3807	3818	4388	finally
    //   3826	3838	4388	finally
    //   3846	3854	4388	finally
    //   3862	3868	4388	finally
    //   3880	3886	4388	finally
    //   3894	3961	4388	finally
    //   4218	4223	4388	finally
    //   4231	4273	4388	finally
    //   4375	4381	4388	finally
    //   4050	4057	4605	java/lang/InterruptedException
    //   4050	4057	4638	finally
    //   4057	4060	4638	finally
    //   4607	4635	4638	finally
    //   4640	4643	4638	finally
    //   4143	4150	4804	java/io/IOException
    //   4154	4158	4804	java/io/IOException
    //   4163	4168	4804	java/io/IOException
    //   905	912	4979	java/io/IOException
    //   917	922	4979	java/io/IOException
    //   926	930	4979	java/io/IOException
    //   3045	3052	5080	java/io/IOException
    //   3056	3060	5080	java/io/IOException
    //   3065	3070	5080	java/io/IOException
    //   1178	1292	5338	java/lang/Throwable
    //   3260	3306	5343	finally
    //   3306	3316	5358	finally
    //   3323	3330	5358	finally
    //   3334	3342	5358	finally
    //   3352	3358	5358	finally
    //   3405	3444	5358	finally
    //   3448	3458	5358	finally
    //   3485	3496	5358	finally
    //   3500	3510	5358	finally
    //   3514	3518	5358	finally
    //   3528	3533	5358	finally
    //   3537	3545	5358	finally
    //   3549	3560	5358	finally
    //   3564	3577	5358	finally
    //   3581	3604	5358	finally
    //   3608	3619	5358	finally
    //   3632	3637	5358	finally
    //   4325	4332	5358	finally
    //   4340	4346	5358	finally
    //   4361	4367	5358	finally
    //   580	660	5370	finally
    //   1356	1398	5378	finally
    //   2722	2731	5386	finally
    //   2735	2747	5386	finally
    //   2751	2763	5386	finally
    //   2772	2793	5386	finally
    //   2804	2813	5386	finally
    //   2817	2823	5386	finally
    //   2831	2837	5386	finally
    //   3169	3182	5386	finally
    //   3189	3196	5386	finally
    //   3208	3214	5386	finally
    //   3231	3251	5386	finally
    //   2837	2903	5394	finally
    //   3251	3260	5406	finally
    //   4465	4499	5418	finally
    //   3260	3306	5426	java/lang/Throwable
    //   3306	3316	5464	java/lang/Throwable
    //   574	580	5505	java/lang/Throwable
    //   2204	2211	5538	java/lang/Throwable
    //   2215	2224	5538	java/lang/Throwable
    //   2228	2234	5538	java/lang/Throwable
    //   2238	2251	5538	java/lang/Throwable
    //   2255	2262	5538	java/lang/Throwable
    //   2266	2272	5538	java/lang/Throwable
    //   2276	2285	5538	java/lang/Throwable
    //   2289	2401	5538	java/lang/Throwable
    //   2405	2417	5538	java/lang/Throwable
    //   2426	2435	5538	java/lang/Throwable
    //   2439	2551	5538	java/lang/Throwable
    //   2555	2567	5538	java/lang/Throwable
    //   2571	2578	5538	java/lang/Throwable
    //   2586	2595	5538	java/lang/Throwable
    //   2599	2609	5538	java/lang/Throwable
    //   2616	2630	5538	java/lang/Throwable
    //   2634	2640	5538	java/lang/Throwable
    //   2644	2650	5538	java/lang/Throwable
    //   2654	2682	5538	java/lang/Throwable
    //   2686	2693	5538	java/lang/Throwable
    //   2713	2722	5538	java/lang/Throwable
    //   4448	4454	5538	java/lang/Throwable
    //   4521	4526	5538	java/lang/Throwable
    //   4547	4555	5538	java/lang/Throwable
    //   4559	4565	5538	java/lang/Throwable
    //   4569	4575	5538	java/lang/Throwable
    //   4589	4595	5538	java/lang/Throwable
    //   2722	2731	5572	java/lang/Throwable
    //   2735	2747	5613	java/lang/Throwable
    //   2751	2763	5613	java/lang/Throwable
    //   2772	2793	5613	java/lang/Throwable
    //   2804	2813	5613	java/lang/Throwable
    //   2817	2823	5613	java/lang/Throwable
    //   3169	3182	5613	java/lang/Throwable
    //   3189	3196	5613	java/lang/Throwable
    //   3208	3214	5613	java/lang/Throwable
    //   3231	3251	5613	java/lang/Throwable
    //   2831	2837	5658	java/lang/Throwable
    //   3251	3260	5703	java/lang/Throwable
    //   4412	4418	5744	java/lang/Throwable
    //   4459	4465	5744	java/lang/Throwable
    //   4465	4499	5777	java/lang/Throwable
    //   544	549	5929	java/lang/Throwable
    //   554	569	5929	java/lang/Throwable
    //   1320	1340	5929	java/lang/Throwable
    //   1340	1345	5929	java/lang/Throwable
    //   1350	1356	5929	java/lang/Throwable
    //   1431	1448	5929	java/lang/Throwable
    //   1453	1467	5929	java/lang/Throwable
    //   1467	1557	5929	java/lang/Throwable
    //   1560	1606	5929	java/lang/Throwable
    //   1606	1765	5929	java/lang/Throwable
    //   1770	1854	5929	java/lang/Throwable
    //   1854	1868	5929	java/lang/Throwable
    //   1873	1888	5929	java/lang/Throwable
    //   1895	2000	5929	java/lang/Throwable
    //   2000	2063	5929	java/lang/Throwable
    //   2063	2096	5929	java/lang/Throwable
    //   2108	2116	5929	java/lang/Throwable
    //   2124	2141	5929	java/lang/Throwable
    //   2167	2189	5929	java/lang/Throwable
    //   2948	2964	5929	java/lang/Throwable
    //   3072	3135	5929	java/lang/Throwable
    //   3323	3330	6184	java/lang/Throwable
    //   3334	3342	6184	java/lang/Throwable
    //   3352	3358	6184	java/lang/Throwable
    //   3405	3444	6184	java/lang/Throwable
    //   3448	3458	6184	java/lang/Throwable
    //   3485	3496	6184	java/lang/Throwable
    //   3500	3510	6184	java/lang/Throwable
    //   3514	3518	6184	java/lang/Throwable
    //   3528	3533	6184	java/lang/Throwable
    //   3537	3545	6184	java/lang/Throwable
    //   3549	3560	6184	java/lang/Throwable
    //   3564	3577	6184	java/lang/Throwable
    //   3581	3604	6184	java/lang/Throwable
    //   3608	3619	6184	java/lang/Throwable
    //   3632	3637	6184	java/lang/Throwable
    //   4325	4332	6184	java/lang/Throwable
    //   4340	4346	6184	java/lang/Throwable
    //   4361	4367	6184	java/lang/Throwable
    //   3988	3994	6233	java/lang/Throwable
    //   3998	4008	6233	java/lang/Throwable
    //   4017	4024	6233	java/lang/Throwable
    //   4028	4037	6233	java/lang/Throwable
    //   4041	4044	6233	java/lang/Throwable
    //   4647	4650	6233	java/lang/Throwable
    //   4654	4664	6233	java/lang/Throwable
    //   4668	4675	6233	java/lang/Throwable
    //   4679	4695	6233	java/lang/Throwable
    //   4702	4751	6233	java/lang/Throwable
    //   4755	4764	6233	java/lang/Throwable
    //   4768	4778	6233	java/lang/Throwable
    //   4782	4793	6233	java/lang/Throwable
    //   3988	3994	6263	finally
    //   3998	4008	6263	finally
    //   4017	4024	6263	finally
    //   4028	4037	6263	finally
    //   4041	4044	6263	finally
    //   4647	4650	6263	finally
    //   4654	4664	6263	finally
    //   4668	4675	6263	finally
    //   4679	4695	6263	finally
    //   4702	4751	6263	finally
    //   4755	4764	6263	finally
    //   4768	4778	6263	finally
    //   4782	4793	6263	finally
    //   697	713	6271	finally
    //   713	721	6271	finally
    //   724	738	6271	finally
    //   738	747	6271	finally
    //   762	767	6271	finally
    //   767	822	6271	finally
    //   4888	4902	6271	finally
    //   4905	4921	6271	finally
    //   4921	4927	6271	finally
    //   4930	4944	6271	finally
    //   4947	4960	6271	finally
    //   4963	4968	6271	finally
  }
  
  public static int a(DownloadTask paramDownloadTask, AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime != null)
    {
      if ((paramDownloadTask.jdField_i_of_type_Boolean) && (!QQSharpPUtil.b(paramAppRuntime.getApplication())) && ((paramAppRuntime instanceof QQAppInterface)))
      {
        EarlyHandler localEarlyHandler = ((EarlyDownloadManager)((QQAppInterface)paramAppRuntime).getManager(76)).a("qq.android.qav.so");
        if (localEarlyHandler == null) {
          break label69;
        }
        localEarlyHandler.a(false);
      }
      for (;;)
      {
        return a(paramDownloadTask, paramAppRuntime.getAccount(), paramAppRuntime.getApplication());
        label69:
        QLog.e("AIOAudioPanel", 1, "voiceChang checkVcSo null == earlyHandler:");
      }
    }
    return a(paramDownloadTask, null, null);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    paramContext = Integer.toString(NetworkUtil.a(paramContext));
    if (paramString2 != null) {}
    for (;;)
    {
      ReportController.b(null, "P_CliOper", "VipDownload", "0", "VipDownload", "ip", 0, paramInt, "", paramContext, paramString2, paramString1);
      return;
      paramString2 = "unknow";
    }
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      int i = NetworkUtil.a(paramContext);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "isQualityNetwork type=" + i);
      }
      if ((i != 3) && (i != 4))
      {
        bool1 = bool2;
        if (i != 1) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean a(DownloadTask paramDownloadTask)
  {
    if (paramDownloadTask == null) {
      return false;
    }
    if ((paramDownloadTask.jdField_a_of_type_JavaUtilList == null) || (paramDownloadTask.jdField_a_of_type_JavaUtilMap == null) || (paramDownloadTask.jdField_a_of_type_JavaUtilList.size() < 1) || (paramDownloadTask.jdField_a_of_type_JavaUtilMap.size() < 1) || (TextUtils.isEmpty(paramDownloadTask.jdField_a_of_type_JavaLangString))) {
      return false;
    }
    paramDownloadTask = paramDownloadTask.jdField_a_of_type_JavaUtilList.iterator();
    while (paramDownloadTask.hasNext())
    {
      String str = (String)paramDownloadTask.next();
      if ((TextUtils.isEmpty(str)) || (!URLUtil.isNetworkUrl(str))) {
        return false;
      }
    }
    return true;
  }
  
  /* Error */
  public static boolean a(java.io.File paramFile1, java.io.File paramFile2, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: iconst_0
    //   4: istore 17
    //   6: iconst_0
    //   7: istore 18
    //   9: iload 18
    //   11: istore 16
    //   13: aload_0
    //   14: ifnull +18 -> 32
    //   17: aload_0
    //   18: invokevirtual 259	java/io/File:exists	()Z
    //   21: istore 16
    //   23: iload 16
    //   25: ifne +13 -> 38
    //   28: iload 18
    //   30: istore 16
    //   32: ldc 2
    //   34: monitorexit
    //   35: iload 16
    //   37: ireturn
    //   38: invokestatic 205	java/lang/System:currentTimeMillis	()J
    //   41: lstore 14
    //   43: aload_1
    //   44: invokevirtual 259	java/io/File:exists	()Z
    //   47: ifeq +365 -> 412
    //   50: aload_1
    //   51: invokevirtual 952	java/io/File:listFiles	()[Ljava/io/File;
    //   54: astore_3
    //   55: iconst_0
    //   56: istore 7
    //   58: iload 7
    //   60: aload_3
    //   61: arraylength
    //   62: if_icmpge +355 -> 417
    //   65: aload_3
    //   66: iload 7
    //   68: aaload
    //   69: astore 4
    //   71: aload 4
    //   73: invokevirtual 955	java/io/File:isDirectory	()Z
    //   76: ifeq +57 -> 133
    //   79: aload 4
    //   81: invokevirtual 952	java/io/File:listFiles	()[Ljava/io/File;
    //   84: astore 5
    //   86: aload 5
    //   88: ifnull +521 -> 609
    //   91: aload 5
    //   93: arraylength
    //   94: istore 9
    //   96: iconst_0
    //   97: istore 8
    //   99: iload 8
    //   101: iload 9
    //   103: if_icmpge +21 -> 124
    //   106: aload 5
    //   108: iload 8
    //   110: aaload
    //   111: invokevirtual 737	java/io/File:delete	()Z
    //   114: pop
    //   115: iload 8
    //   117: iconst_1
    //   118: iadd
    //   119: istore 8
    //   121: goto -22 -> 99
    //   124: aload 4
    //   126: invokevirtual 737	java/io/File:delete	()Z
    //   129: pop
    //   130: goto +479 -> 609
    //   133: aload_3
    //   134: iload 7
    //   136: aaload
    //   137: invokevirtual 737	java/io/File:delete	()Z
    //   140: pop
    //   141: goto +468 -> 609
    //   144: astore_3
    //   145: getstatic 41	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   148: iconst_2
    //   149: new 134	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   156: ldc_w 957
    //   159: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_1
    //   163: invokevirtual 267	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   166: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload_3
    //   170: invokevirtual 834	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   173: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   182: iload 17
    //   184: istore_2
    //   185: invokestatic 963	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   188: invokestatic 966	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   191: if_acmpeq +155 -> 346
    //   194: aload_0
    //   195: invokevirtual 493	java/io/File:length	()J
    //   198: lstore 12
    //   200: aload_0
    //   201: invokevirtual 267	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   204: invokestatic 969	com/tencent/open/base/MD5Utils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   207: astore 5
    //   209: aconst_null
    //   210: astore 4
    //   212: lload 12
    //   214: ldc2_w 970
    //   217: lcmp
    //   218: ifle +276 -> 494
    //   221: ldc2_w 970
    //   224: lstore 10
    //   226: lload 10
    //   228: l2i
    //   229: newarray <illegal type>
    //   231: astore 6
    //   233: new 973	java/io/FileInputStream
    //   236: dup
    //   237: aload_0
    //   238: invokespecial 976	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   241: astore_0
    //   242: new 978	java/io/InputStreamReader
    //   245: dup
    //   246: aload_0
    //   247: ldc_w 980
    //   250: invokespecial 983	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   253: astore_3
    //   254: aload_3
    //   255: aload 6
    //   257: invokevirtual 986	java/io/InputStreamReader:read	([C)I
    //   260: pop
    //   261: aload_0
    //   262: ifnull +7 -> 269
    //   265: aload_0
    //   266: invokevirtual 337	java/io/InputStream:close	()V
    //   269: aload_3
    //   270: ifnull +7 -> 277
    //   273: aload_3
    //   274: invokevirtual 987	java/io/InputStreamReader:close	()V
    //   277: getstatic 41	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   280: iconst_2
    //   281: new 134	java/lang/StringBuilder
    //   284: dup
    //   285: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   288: ldc_w 957
    //   291: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: aload_1
    //   295: invokevirtual 267	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   298: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: ldc_w 989
    //   304: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: lload 12
    //   309: invokevirtual 283	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   312: ldc_w 991
    //   315: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: aload 5
    //   320: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: ldc_w 993
    //   326: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: aload 6
    //   331: invokestatic 996	java/lang/String:valueOf	([C)Ljava/lang/String;
    //   334: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   343: iload 17
    //   345: istore_2
    //   346: iload_2
    //   347: istore 16
    //   349: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   352: ifeq -320 -> 32
    //   355: getstatic 41	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   358: iconst_2
    //   359: new 134	java/lang/StringBuilder
    //   362: dup
    //   363: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   366: ldc_w 998
    //   369: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: invokestatic 205	java/lang/System:currentTimeMillis	()J
    //   375: lload 14
    //   377: lsub
    //   378: invokevirtual 283	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   381: ldc_w 1000
    //   384: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: aload_1
    //   388: invokevirtual 267	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   391: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   397: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   400: iload_2
    //   401: istore 16
    //   403: goto -371 -> 32
    //   406: astore_0
    //   407: ldc 2
    //   409: monitorexit
    //   410: aload_0
    //   411: athrow
    //   412: aload_1
    //   413: invokevirtual 262	java/io/File:mkdirs	()Z
    //   416: pop
    //   417: aload_0
    //   418: new 134	java/lang/StringBuilder
    //   421: dup
    //   422: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   425: aload_1
    //   426: invokevirtual 267	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   429: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: getstatic 1004	java/io/File:separatorChar	C
    //   435: invokevirtual 1007	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   438: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   441: invokestatic 1011	com/tencent/biz/common/util/ZipUtils:a	(Ljava/io/File;Ljava/lang/String;)V
    //   444: iload_2
    //   445: ifeq +8 -> 453
    //   448: aload_0
    //   449: invokevirtual 737	java/io/File:delete	()Z
    //   452: pop
    //   453: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   456: ifeq +33 -> 489
    //   459: getstatic 41	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   462: iconst_2
    //   463: new 134	java/lang/StringBuilder
    //   466: dup
    //   467: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   470: ldc_w 1013
    //   473: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: aload_1
    //   477: invokevirtual 267	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   480: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   486: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   489: iconst_1
    //   490: istore_2
    //   491: goto -145 -> 346
    //   494: lload 12
    //   496: lstore 10
    //   498: goto -272 -> 226
    //   501: astore_0
    //   502: aconst_null
    //   503: astore_3
    //   504: aconst_null
    //   505: astore_0
    //   506: aload_3
    //   507: ifnull +7 -> 514
    //   510: aload_3
    //   511: invokevirtual 337	java/io/InputStream:close	()V
    //   514: aload_0
    //   515: ifnull -238 -> 277
    //   518: aload_0
    //   519: invokevirtual 987	java/io/InputStreamReader:close	()V
    //   522: goto -245 -> 277
    //   525: astore_0
    //   526: goto -249 -> 277
    //   529: astore_1
    //   530: aconst_null
    //   531: astore_0
    //   532: aload 4
    //   534: astore_3
    //   535: aload_0
    //   536: ifnull +7 -> 543
    //   539: aload_0
    //   540: invokevirtual 337	java/io/InputStream:close	()V
    //   543: aload_3
    //   544: ifnull +7 -> 551
    //   547: aload_3
    //   548: invokevirtual 987	java/io/InputStreamReader:close	()V
    //   551: aload_1
    //   552: athrow
    //   553: astore_0
    //   554: goto -285 -> 269
    //   557: astore_0
    //   558: goto -281 -> 277
    //   561: astore_3
    //   562: goto -48 -> 514
    //   565: astore_0
    //   566: goto -23 -> 543
    //   569: astore_0
    //   570: goto -19 -> 551
    //   573: astore_1
    //   574: aload 4
    //   576: astore_3
    //   577: goto -42 -> 535
    //   580: astore_1
    //   581: goto -46 -> 535
    //   584: astore_3
    //   585: aconst_null
    //   586: astore 4
    //   588: aload_0
    //   589: astore_3
    //   590: aload 4
    //   592: astore_0
    //   593: goto -87 -> 506
    //   596: astore 4
    //   598: aload_0
    //   599: astore 4
    //   601: aload_3
    //   602: astore_0
    //   603: aload 4
    //   605: astore_3
    //   606: goto -100 -> 506
    //   609: iload 7
    //   611: iconst_1
    //   612: iadd
    //   613: istore 7
    //   615: goto -557 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	618	0	paramFile1	java.io.File
    //   0	618	1	paramFile2	java.io.File
    //   0	618	2	paramBoolean	boolean
    //   54	80	3	arrayOfFile	java.io.File[]
    //   144	26	3	localException1	Exception
    //   253	295	3	localObject1	Object
    //   561	1	3	localException2	Exception
    //   576	1	3	localObject2	Object
    //   584	1	3	localException3	Exception
    //   589	17	3	localObject3	Object
    //   69	522	4	localFile1	java.io.File
    //   596	1	4	localException4	Exception
    //   599	5	4	localFile2	java.io.File
    //   84	235	5	localObject4	Object
    //   231	99	6	arrayOfChar	char[]
    //   56	558	7	i	int
    //   97	23	8	j	int
    //   94	10	9	k	int
    //   224	273	10	l1	long
    //   198	297	12	l2	long
    //   41	335	14	l3	long
    //   11	391	16	bool1	boolean
    //   4	340	17	bool2	boolean
    //   7	22	18	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   43	55	144	java/lang/Exception
    //   58	65	144	java/lang/Exception
    //   71	86	144	java/lang/Exception
    //   91	96	144	java/lang/Exception
    //   106	115	144	java/lang/Exception
    //   124	130	144	java/lang/Exception
    //   133	141	144	java/lang/Exception
    //   412	417	144	java/lang/Exception
    //   417	444	144	java/lang/Exception
    //   448	453	144	java/lang/Exception
    //   453	489	144	java/lang/Exception
    //   17	23	406	finally
    //   38	43	406	finally
    //   43	55	406	finally
    //   58	65	406	finally
    //   71	86	406	finally
    //   91	96	406	finally
    //   106	115	406	finally
    //   124	130	406	finally
    //   133	141	406	finally
    //   145	182	406	finally
    //   185	209	406	finally
    //   226	233	406	finally
    //   265	269	406	finally
    //   273	277	406	finally
    //   277	343	406	finally
    //   349	400	406	finally
    //   412	417	406	finally
    //   417	444	406	finally
    //   448	453	406	finally
    //   453	489	406	finally
    //   510	514	406	finally
    //   518	522	406	finally
    //   539	543	406	finally
    //   547	551	406	finally
    //   551	553	406	finally
    //   233	242	501	java/lang/Exception
    //   518	522	525	java/lang/Exception
    //   233	242	529	finally
    //   265	269	553	java/lang/Exception
    //   273	277	557	java/lang/Exception
    //   510	514	561	java/lang/Exception
    //   539	543	565	java/lang/Exception
    //   547	551	569	java/lang/Exception
    //   242	254	573	finally
    //   254	261	580	finally
    //   242	254	584	java/lang/Exception
    //   254	261	596	java/lang/Exception
  }
  
  public static boolean a(String paramString)
  {
    int i;
    if (b.containsKey(paramString)) {
      i = ((Integer)b.get(paramString)).intValue();
    }
    while (i > 0) {
      if ((int)(System.currentTimeMillis() / 1000L) < i + 600)
      {
        return true;
        i = 0;
      }
      else
      {
        b.remove(paramString);
        return false;
      }
    }
    return false;
  }
  
  /* Error */
  public DownloaderInterface a(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: getstatic 64	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   5: ifnull +174 -> 179
    //   8: getstatic 64	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   11: astore_3
    //   12: aload_3
    //   13: monitorenter
    //   14: iload_1
    //   15: tableswitch	default:+21->36, 1:+25->40, 2:+97->112
    //   36: aload_3
    //   37: monitorexit
    //   38: aload_2
    //   39: areturn
    //   40: getstatic 64	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   43: iload_1
    //   44: invokestatic 158	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   47: invokevirtual 1016	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   50: ifeq +20 -> 70
    //   53: getstatic 64	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   56: iload_1
    //   57: invokestatic 158	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   60: invokevirtual 1017	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   63: checkcast 1023	com/tencent/mobileqq/vip/DownloaderInterface
    //   66: astore_2
    //   67: goto -31 -> 36
    //   70: new 1025	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig
    //   73: dup
    //   74: iconst_0
    //   75: invokespecial 1027	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig:<init>	(Z)V
    //   78: astore_2
    //   79: new 1029	wfy
    //   82: dup
    //   83: aload_0
    //   84: getfield 57	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   87: aload_2
    //   88: invokespecial 1032	wfy:<init>	(Lmqq/app/AppRuntime;Lcom/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig;)V
    //   91: astore_2
    //   92: getstatic 64	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   95: iload_1
    //   96: invokestatic 158	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   99: aload_2
    //   100: invokevirtual 844	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   103: pop
    //   104: goto -68 -> 36
    //   107: astore_2
    //   108: aload_3
    //   109: monitorexit
    //   110: aload_2
    //   111: athrow
    //   112: getstatic 64	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   115: iload_1
    //   116: invokestatic 158	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   119: invokevirtual 1016	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   122: ifeq +20 -> 142
    //   125: getstatic 64	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   128: iload_1
    //   129: invokestatic 158	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   132: invokevirtual 1017	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   135: checkcast 1023	com/tencent/mobileqq/vip/DownloaderInterface
    //   138: astore_2
    //   139: goto -103 -> 36
    //   142: new 1025	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig
    //   145: dup
    //   146: iconst_0
    //   147: invokespecial 1027	com/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig:<init>	(Z)V
    //   150: astore_2
    //   151: new 1029	wfy
    //   154: dup
    //   155: aload_0
    //   156: getfield 57	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   159: aload_2
    //   160: invokespecial 1032	wfy:<init>	(Lmqq/app/AppRuntime;Lcom/tencent/mobileqq/vip/DownloaderFactory$DownloadConfig;)V
    //   163: astore_2
    //   164: getstatic 64	com/tencent/mobileqq/vip/DownloaderFactory:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   167: iload_1
    //   168: invokestatic 158	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   171: aload_2
    //   172: invokevirtual 844	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   175: pop
    //   176: goto -140 -> 36
    //   179: aconst_null
    //   180: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	this	DownloaderFactory
    //   0	181	1	paramInt	int
    //   1	99	2	localObject1	Object
    //   107	4	2	localObject2	Object
    //   138	34	2	localObject3	Object
    //   11	98	3	localConcurrentHashMap	ConcurrentHashMap
    // Exception table:
    //   from	to	target	type
    //   36	38	107	finally
    //   40	67	107	finally
    //   70	104	107	finally
    //   108	110	107	finally
    //   112	139	107	finally
    //   142	176	107	finally
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onDestroy...");
    }
    synchronized (b)
    {
      b.clear();
      synchronized (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        Iterator localIterator = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
        if (localIterator.hasNext()) {
          ((DownloaderInterface)((Map.Entry)localIterator.next()).getValue()).a();
        }
      }
    }
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_MqqAppAppRuntime = null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vip\DownloaderFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */