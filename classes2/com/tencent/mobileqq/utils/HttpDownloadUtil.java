package com.tencent.mobileqq.utils;

import android.net.NetworkInfo;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticon.DownloadInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.transfile.FMTSrvAddrProvider;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.http.HttpVersion;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpProtocolParams;

public class HttpDownloadUtil
{
  public static final int A = 31;
  public static final int B = 32;
  public static final int C = 33;
  public static final int a = 2;
  static long jdField_a_of_type_Long = 0L;
  static HttpDownloadUtil.IdleConnectionMonitorThread jdField_a_of_type_ComTencentMobileqqUtilsHttpDownloadUtil$IdleConnectionMonitorThread;
  public static final String a = "HttpDownloadUtil";
  public static final DefaultHttpClient a;
  private static boolean jdField_a_of_type_Boolean = false;
  public static final int b = 2;
  private static String jdField_b_of_type_JavaLangString;
  private static boolean jdField_b_of_type_Boolean = false;
  public static final int c = 0;
  public static final int d = 1;
  public static final int e = 2;
  public static final int f = 3;
  public static final int g = 4;
  public static final int h = 5;
  public static final int i = 6;
  @Deprecated
  public static final int j = 7;
  public static final int k = 8;
  public static final int l = 9;
  public static final int m = 10;
  public static final int n = 11;
  public static final int o = 12;
  public static final int p = 13;
  public static final int q = 14;
  public static final int r = 15;
  public static final int s = 16;
  public static final int t = 17;
  public static final int u = 18;
  public static final int v = 19;
  public static final int w = 17;
  public static final int x = 18;
  public static final int y = 19;
  public static final int z = 30;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Long = System.currentTimeMillis();
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpProtocolParams.setVersion(localBasicHttpParams, HttpVersion.HTTP_1_1);
    HttpProtocolParams.setContentCharset(localBasicHttpParams, "ISO-8859-1");
    HttpProtocolParams.setUseExpectContinue(localBasicHttpParams, true);
    Object localObject = new SchemeRegistry();
    ((SchemeRegistry)localObject).register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    localObject = new ThreadSafeClientConnManager(localBasicHttpParams, (SchemeRegistry)localObject);
    jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient = new DefaultHttpClient((ClientConnectionManager)localObject, localBasicHttpParams);
    jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient.setHttpRequestRetryHandler(new DefaultHttpRequestRetryHandler());
    jdField_a_of_type_ComTencentMobileqqUtilsHttpDownloadUtil$IdleConnectionMonitorThread = new HttpDownloadUtil.IdleConnectionMonitorThread((ClientConnectionManager)localObject);
    ThreadManager.a(jdField_a_of_type_ComTencentMobileqqUtilsHttpDownloadUtil$IdleConnectionMonitorThread, 1, null, false);
  }
  
  /* Error */
  private static int a(AppInterface paramAppInterface, DownloadInfo paramDownloadInfo, NetworkInfo paramNetworkInfo, HttpDownloadUtil.HttpDownloadListener paramHttpDownloadListener)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +23 -> 24
    //   4: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +11 -> 18
    //   10: ldc 20
    //   12: iconst_2
    //   13: ldc -74
    //   15: invokestatic 185	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   18: iconst_5
    //   19: istore 21
    //   21: iload 21
    //   23: ireturn
    //   24: new 187	java/net/URL
    //   27: dup
    //   28: aload_1
    //   29: getfield 191	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   32: invokespecial 194	java/net/URL:<init>	(Ljava/lang/String;)V
    //   35: astore 14
    //   37: invokestatic 81	java/lang/System:currentTimeMillis	()J
    //   40: lstore 27
    //   42: new 4	java/lang/Object
    //   45: dup
    //   46: invokespecial 163	java/lang/Object:<init>	()V
    //   49: astore 15
    //   51: aload_1
    //   52: getfield 197	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   55: invokevirtual 203	java/io/File:getParentFile	()Ljava/io/File;
    //   58: astore 4
    //   60: aload 4
    //   62: ifnull +139 -> 201
    //   65: aload 4
    //   67: invokevirtual 206	java/io/File:exists	()Z
    //   70: ifne +131 -> 201
    //   73: aload 4
    //   75: invokevirtual 209	java/io/File:mkdirs	()Z
    //   78: ifne +123 -> 201
    //   81: aload_3
    //   82: ifnull +15 -> 97
    //   85: aload_3
    //   86: aload 14
    //   88: invokevirtual 213	java/net/URL:toString	()Ljava/lang/String;
    //   91: iconst_4
    //   92: invokeinterface 218 3 0
    //   97: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   100: ifeq +31 -> 131
    //   103: ldc 20
    //   105: iconst_2
    //   106: new 220	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   113: ldc -33
    //   115: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_1
    //   119: getfield 191	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   122: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 185	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   131: iconst_4
    //   132: ireturn
    //   133: astore_0
    //   134: aload_0
    //   135: invokevirtual 231	java/net/MalformedURLException:printStackTrace	()V
    //   138: aload_1
    //   139: aload_0
    //   140: invokestatic 237	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   143: putfield 239	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   146: iconst_5
    //   147: ireturn
    //   148: astore_0
    //   149: aload_3
    //   150: ifnull +15 -> 165
    //   153: aload_3
    //   154: aload 14
    //   156: invokevirtual 213	java/net/URL:toString	()Ljava/lang/String;
    //   159: iconst_4
    //   160: invokeinterface 218 3 0
    //   165: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   168: ifeq +31 -> 199
    //   171: ldc 20
    //   173: iconst_2
    //   174: new 220	java/lang/StringBuilder
    //   177: dup
    //   178: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   181: ldc -33
    //   183: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: aload_1
    //   187: getfield 191	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   190: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: invokestatic 185	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   199: iconst_4
    //   200: ireturn
    //   201: aconst_null
    //   202: astore 6
    //   204: aload_1
    //   205: getfield 191	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   208: astore 4
    //   210: new 241	org/apache/http/client/methods/HttpGet
    //   213: dup
    //   214: aload 4
    //   216: invokespecial 242	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   219: astore 13
    //   221: new 85	org/apache/http/params/BasicHttpParams
    //   224: dup
    //   225: invokespecial 88	org/apache/http/params/BasicHttpParams:<init>	()V
    //   228: astore 16
    //   230: aload 16
    //   232: ldc -12
    //   234: ldc -11
    //   236: invokestatic 250	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   239: invokeinterface 256 3 0
    //   244: pop
    //   245: aload 16
    //   247: ldc_w 258
    //   250: ldc -11
    //   252: invokestatic 250	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   255: invokeinterface 256 3 0
    //   260: pop
    //   261: invokestatic 263	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   264: astore 4
    //   266: invokestatic 267	android/net/Proxy:getDefaultPort	()I
    //   269: istore 20
    //   271: iconst_0
    //   272: istore 19
    //   274: aload_2
    //   275: ifnull +96 -> 371
    //   278: aload_2
    //   279: invokevirtual 272	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   282: astore 5
    //   284: aload_2
    //   285: invokestatic 277	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   288: ifeq +51 -> 339
    //   291: aload 5
    //   293: ifnull +14 -> 307
    //   296: aload 5
    //   298: ldc_w 279
    //   301: invokevirtual 283	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   304: ifeq +35 -> 339
    //   307: aload 4
    //   309: ifnull +30 -> 339
    //   312: iload 20
    //   314: ifle +25 -> 339
    //   317: aload 16
    //   319: ldc_w 285
    //   322: new 287	org/apache/http/HttpHost
    //   325: dup
    //   326: aload 4
    //   328: iload 20
    //   330: invokespecial 289	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   333: invokeinterface 256 3 0
    //   338: pop
    //   339: aload_2
    //   340: invokestatic 277	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   343: ifeq +574 -> 917
    //   346: sipush 2048
    //   349: istore 19
    //   351: aload 16
    //   353: ldc_w 291
    //   356: iload 19
    //   358: invokeinterface 295 3 0
    //   363: pop
    //   364: aload 13
    //   366: aload 16
    //   368: invokevirtual 299	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   371: new 199	java/io/File
    //   374: dup
    //   375: aload_1
    //   376: invokevirtual 301	com/tencent/mobileqq/emoticon/DownloadInfo:a	()Ljava/lang/String;
    //   379: invokespecial 302	java/io/File:<init>	(Ljava/lang/String;)V
    //   382: astore 17
    //   384: aload 17
    //   386: invokevirtual 206	java/io/File:exists	()Z
    //   389: ifeq +9 -> 398
    //   392: aload 17
    //   394: invokevirtual 305	java/io/File:delete	()Z
    //   397: pop
    //   398: aconst_null
    //   399: astore 4
    //   401: iconst_m1
    //   402: istore 24
    //   404: iconst_5
    //   405: istore 25
    //   407: iload 24
    //   409: ifne +38 -> 447
    //   412: aload 16
    //   414: ldc_w 285
    //   417: new 287	org/apache/http/HttpHost
    //   420: dup
    //   421: aload 14
    //   423: invokevirtual 308	java/net/URL:getHost	()Ljava/lang/String;
    //   426: aload 14
    //   428: invokevirtual 311	java/net/URL:getPort	()I
    //   431: invokespecial 289	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   434: invokeinterface 256 3 0
    //   439: pop
    //   440: aload 13
    //   442: aload 16
    //   444: invokevirtual 299	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   447: aload 6
    //   449: astore 11
    //   451: aload 4
    //   453: astore 7
    //   455: iload 19
    //   457: istore 21
    //   459: aload 6
    //   461: astore 10
    //   463: aload 4
    //   465: astore 8
    //   467: iload 19
    //   469: istore 23
    //   471: aload 6
    //   473: astore 12
    //   475: aload 4
    //   477: astore 9
    //   479: iload 25
    //   481: istore 22
    //   483: getstatic 142	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   486: new 287	org/apache/http/HttpHost
    //   489: dup
    //   490: aload 14
    //   492: invokevirtual 308	java/net/URL:getHost	()Ljava/lang/String;
    //   495: invokespecial 312	org/apache/http/HttpHost:<init>	(Ljava/lang/String;)V
    //   498: aload 13
    //   500: invokevirtual 316	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpResponse;
    //   503: astore 5
    //   505: aload 6
    //   507: astore 11
    //   509: aload 4
    //   511: astore 7
    //   513: iload 19
    //   515: istore 21
    //   517: aload 6
    //   519: astore 10
    //   521: aload 4
    //   523: astore 8
    //   525: iload 19
    //   527: istore 23
    //   529: aload 6
    //   531: astore 12
    //   533: aload 4
    //   535: astore 9
    //   537: iload 25
    //   539: istore 22
    //   541: aload 5
    //   543: invokeinterface 322 1 0
    //   548: astore 18
    //   550: aload 6
    //   552: astore 11
    //   554: aload 4
    //   556: astore 7
    //   558: iload 19
    //   560: istore 21
    //   562: aload 6
    //   564: astore 10
    //   566: aload 4
    //   568: astore 8
    //   570: iload 19
    //   572: istore 23
    //   574: aload 6
    //   576: astore 12
    //   578: aload 4
    //   580: astore 9
    //   582: iload 25
    //   584: istore 22
    //   586: aload 5
    //   588: invokeinterface 326 1 0
    //   593: pop
    //   594: aload 6
    //   596: astore 11
    //   598: aload 4
    //   600: astore 7
    //   602: iload 19
    //   604: istore 21
    //   606: aload 6
    //   608: astore 10
    //   610: aload 4
    //   612: astore 8
    //   614: iload 19
    //   616: istore 23
    //   618: aload 6
    //   620: astore 12
    //   622: aload 4
    //   624: astore 9
    //   626: iload 25
    //   628: istore 22
    //   630: aload 18
    //   632: invokeinterface 331 1 0
    //   637: istore 20
    //   639: aload_3
    //   640: ifnull +52 -> 692
    //   643: aload 6
    //   645: astore 11
    //   647: aload 4
    //   649: astore 7
    //   651: iload 19
    //   653: istore 21
    //   655: aload 6
    //   657: astore 10
    //   659: aload 4
    //   661: astore 8
    //   663: iload 19
    //   665: istore 23
    //   667: aload 6
    //   669: astore 12
    //   671: aload 4
    //   673: astore 9
    //   675: iload 25
    //   677: istore 22
    //   679: aload_3
    //   680: aload 14
    //   682: invokevirtual 213	java/net/URL:toString	()Ljava/lang/String;
    //   685: iload 20
    //   687: invokeinterface 333 3 0
    //   692: aload 6
    //   694: astore 11
    //   696: aload 4
    //   698: astore 7
    //   700: iload 19
    //   702: istore 21
    //   704: aload 6
    //   706: astore 10
    //   708: aload 4
    //   710: astore 8
    //   712: iload 19
    //   714: istore 23
    //   716: aload 6
    //   718: astore 12
    //   720: aload 4
    //   722: astore 9
    //   724: iload 25
    //   726: istore 22
    //   728: aload 5
    //   730: invokeinterface 337 1 0
    //   735: astore 4
    //   737: sipush 200
    //   740: iload 20
    //   742: if_icmpne +1434 -> 2176
    //   745: aload 6
    //   747: astore 11
    //   749: aload 4
    //   751: astore 7
    //   753: iload 19
    //   755: istore 21
    //   757: aload 6
    //   759: astore 10
    //   761: aload 4
    //   763: astore 8
    //   765: iload 19
    //   767: istore 23
    //   769: aload 6
    //   771: astore 12
    //   773: aload 4
    //   775: astore 9
    //   777: iload 25
    //   779: istore 22
    //   781: aload 4
    //   783: invokeinterface 342 1 0
    //   788: lstore 29
    //   790: aconst_null
    //   791: astore 7
    //   793: iconst_0
    //   794: istore 20
    //   796: new 344	java/io/FileOutputStream
    //   799: dup
    //   800: aload 17
    //   802: invokespecial 347	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   805: astore 5
    //   807: aload 4
    //   809: invokeinterface 351 1 0
    //   814: astore 6
    //   816: aload 6
    //   818: astore 7
    //   820: iload 19
    //   822: ifne +1889 -> 2711
    //   825: sipush 2048
    //   828: istore 19
    //   830: iload 19
    //   832: newarray <illegal type>
    //   834: astore 6
    //   836: iload 20
    //   838: i2l
    //   839: lload 29
    //   841: lcmp
    //   842: ifge +83 -> 925
    //   845: aload 7
    //   847: aload 6
    //   849: invokevirtual 357	java/io/InputStream:read	([B)I
    //   852: istore 21
    //   854: aload 5
    //   856: aload 6
    //   858: iconst_0
    //   859: iload 21
    //   861: invokevirtual 363	java/io/OutputStream:write	([BII)V
    //   864: iload 20
    //   866: iload 21
    //   868: iadd
    //   869: istore 20
    //   871: aload_3
    //   872: ifnull +1836 -> 2708
    //   875: aload_3
    //   876: aload 14
    //   878: invokevirtual 213	java/net/URL:toString	()Ljava/lang/String;
    //   881: lload 29
    //   883: iload 20
    //   885: i2l
    //   886: invokeinterface 366 6 0
    //   891: goto -55 -> 836
    //   894: astore 5
    //   896: new 241	org/apache/http/client/methods/HttpGet
    //   899: dup
    //   900: aload 4
    //   902: invokestatic 369	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   905: invokespecial 242	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   908: astore 13
    //   910: goto -689 -> 221
    //   913: astore_0
    //   914: bipush 13
    //   916: ireturn
    //   917: sipush 4096
    //   920: istore 19
    //   922: goto -571 -> 351
    //   925: iload 20
    //   927: i2l
    //   928: lload 29
    //   930: lcmp
    //   931: ifne +656 -> 1587
    //   934: iconst_0
    //   935: istore 25
    //   937: iconst_0
    //   938: istore 26
    //   940: iconst_0
    //   941: istore 23
    //   943: iload 23
    //   945: istore 20
    //   947: iload 25
    //   949: istore 21
    //   951: iload 26
    //   953: istore 22
    //   955: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   958: ifeq +44 -> 1002
    //   961: iload 25
    //   963: istore 21
    //   965: iload 26
    //   967: istore 22
    //   969: ldc 20
    //   971: iconst_2
    //   972: new 220	java/lang/StringBuilder
    //   975: dup
    //   976: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   979: ldc_w 371
    //   982: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   985: aload_1
    //   986: getfield 191	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   989: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   992: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   995: invokestatic 185	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   998: iload 23
    //   1000: istore 20
    //   1002: iload 20
    //   1004: istore 21
    //   1006: iload 20
    //   1008: istore 22
    //   1010: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1013: ifeq +53 -> 1066
    //   1016: iload 20
    //   1018: istore 21
    //   1020: iload 20
    //   1022: istore 22
    //   1024: ldc_w 373
    //   1027: iconst_2
    //   1028: new 220	java/lang/StringBuilder
    //   1031: dup
    //   1032: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   1035: ldc_w 375
    //   1038: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1041: invokestatic 81	java/lang/System:currentTimeMillis	()J
    //   1044: invokevirtual 378	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1047: ldc_w 380
    //   1050: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1053: aload_1
    //   1054: getfield 191	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1057: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1060: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1063: invokestatic 185	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1066: aload_1
    //   1067: ifnull +108 -> 1175
    //   1070: iload 20
    //   1072: istore 21
    //   1074: iload 20
    //   1076: istore 22
    //   1078: aload_1
    //   1079: getfield 382	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_Int	I
    //   1082: tableswitch	default:+1632->2714, 10001:+665->1747
    //   1100: iload 20
    //   1102: istore 21
    //   1104: iload 20
    //   1106: istore 22
    //   1108: aload_2
    //   1109: invokestatic 277	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   1112: ifeq +1001 -> 2113
    //   1115: iload 20
    //   1117: istore 21
    //   1119: iload 20
    //   1121: istore 22
    //   1123: iconst_3
    //   1124: anewarray 233	java/lang/String
    //   1127: astore 6
    //   1129: aload 6
    //   1131: iconst_0
    //   1132: ldc_w 384
    //   1135: aastore
    //   1136: aload 6
    //   1138: iconst_1
    //   1139: ldc_w 386
    //   1142: aastore
    //   1143: aload 6
    //   1145: iconst_2
    //   1146: ldc_w 388
    //   1149: aastore
    //   1150: aload 6
    //   1152: ifnull +23 -> 1175
    //   1155: iload 20
    //   1157: istore 21
    //   1159: iload 20
    //   1161: istore 22
    //   1163: aload_0
    //   1164: aload_0
    //   1165: invokevirtual 391	com/tencent/common/app/AppInterface:a	()Ljava/lang/String;
    //   1168: aload 6
    //   1170: lload 29
    //   1172: invokevirtual 394	com/tencent/common/app/AppInterface:a	(Ljava/lang/String;[Ljava/lang/String;J)V
    //   1175: iload 20
    //   1177: istore 21
    //   1179: iload 20
    //   1181: istore 22
    //   1183: aload 17
    //   1185: invokestatic 81	java/lang/System:currentTimeMillis	()J
    //   1188: invokevirtual 398	java/io/File:setLastModified	(J)Z
    //   1191: pop
    //   1192: iload 20
    //   1194: istore 21
    //   1196: iload 20
    //   1198: istore 22
    //   1200: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1203: ifeq +66 -> 1269
    //   1206: iload 20
    //   1208: istore 21
    //   1210: iload 20
    //   1212: istore 22
    //   1214: ldc 20
    //   1216: iconst_2
    //   1217: new 220	java/lang/StringBuilder
    //   1220: dup
    //   1221: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   1224: ldc_w 400
    //   1227: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1230: invokestatic 81	java/lang/System:currentTimeMillis	()J
    //   1233: lload 27
    //   1235: lsub
    //   1236: invokevirtual 378	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1239: ldc_w 402
    //   1242: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1245: lload 29
    //   1247: invokevirtual 378	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1250: ldc_w 404
    //   1253: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1256: aload_1
    //   1257: getfield 191	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1260: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1263: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1266: invokestatic 406	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1269: aload 7
    //   1271: ifnull +1434 -> 2705
    //   1274: iload 20
    //   1276: istore 22
    //   1278: iload 19
    //   1280: istore 21
    //   1282: aload 5
    //   1284: astore 8
    //   1286: iload 19
    //   1288: istore 23
    //   1290: aload 5
    //   1292: astore 9
    //   1294: aload 5
    //   1296: astore 10
    //   1298: aload 7
    //   1300: invokevirtual 409	java/io/InputStream:close	()V
    //   1303: iload 20
    //   1305: ifne +92 -> 1397
    //   1308: aload 5
    //   1310: astore 11
    //   1312: aload 4
    //   1314: astore 7
    //   1316: iload 19
    //   1318: istore 21
    //   1320: aload 5
    //   1322: astore 10
    //   1324: aload 4
    //   1326: astore 8
    //   1328: iload 19
    //   1330: istore 23
    //   1332: aload 5
    //   1334: astore 12
    //   1336: aload 4
    //   1338: astore 9
    //   1340: iload 20
    //   1342: istore 22
    //   1344: aload_1
    //   1345: getfield 197	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   1348: ifnull +49 -> 1397
    //   1351: aload 5
    //   1353: astore 11
    //   1355: aload 4
    //   1357: astore 7
    //   1359: iload 19
    //   1361: istore 21
    //   1363: aload 5
    //   1365: astore 10
    //   1367: aload 4
    //   1369: astore 8
    //   1371: iload 19
    //   1373: istore 23
    //   1375: aload 5
    //   1377: astore 12
    //   1379: aload 4
    //   1381: astore 9
    //   1383: iload 20
    //   1385: istore 22
    //   1387: aload 17
    //   1389: aload_1
    //   1390: getfield 197	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   1393: invokevirtual 413	java/io/File:renameTo	(Ljava/io/File;)Z
    //   1396: pop
    //   1397: aload_3
    //   1398: ifnull +52 -> 1450
    //   1401: aload 5
    //   1403: astore 11
    //   1405: aload 4
    //   1407: astore 7
    //   1409: iload 19
    //   1411: istore 21
    //   1413: aload 5
    //   1415: astore 10
    //   1417: aload 4
    //   1419: astore 8
    //   1421: iload 19
    //   1423: istore 23
    //   1425: aload 5
    //   1427: astore 12
    //   1429: aload 4
    //   1431: astore 9
    //   1433: iload 20
    //   1435: istore 22
    //   1437: aload_3
    //   1438: aload 14
    //   1440: invokevirtual 213	java/net/URL:toString	()Ljava/lang/String;
    //   1443: iload 20
    //   1445: invokeinterface 218 3 0
    //   1450: aload 4
    //   1452: ifnull +10 -> 1462
    //   1455: aload 4
    //   1457: invokeinterface 416 1 0
    //   1462: aload 5
    //   1464: ifnull +1227 -> 2691
    //   1467: aload 5
    //   1469: invokevirtual 417	java/io/OutputStream:close	()V
    //   1472: aload 5
    //   1474: astore 7
    //   1476: aload 4
    //   1478: astore 6
    //   1480: iload 24
    //   1482: iconst_1
    //   1483: iadd
    //   1484: istore 24
    //   1486: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1489: ifeq +43 -> 1532
    //   1492: ldc 20
    //   1494: iconst_2
    //   1495: new 220	java/lang/StringBuilder
    //   1498: dup
    //   1499: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   1502: ldc_w 419
    //   1505: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1508: iload 20
    //   1510: invokevirtual 422	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1513: ldc_w 424
    //   1516: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1519: aload_1
    //   1520: getfield 191	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1523: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1526: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1529: invokestatic 185	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1532: iload 24
    //   1534: iconst_2
    //   1535: if_icmpge +22 -> 1557
    //   1538: iload 20
    //   1540: ifeq +17 -> 1557
    //   1543: aload 15
    //   1545: monitorenter
    //   1546: aload 15
    //   1548: ldc2_w 425
    //   1551: invokevirtual 430	java/lang/Object:wait	(J)V
    //   1554: aload 15
    //   1556: monitorexit
    //   1557: iload 20
    //   1559: istore 21
    //   1561: iload 20
    //   1563: ifeq -1542 -> 21
    //   1566: iload 20
    //   1568: istore 21
    //   1570: iload 24
    //   1572: iconst_2
    //   1573: if_icmpge -1552 -> 21
    //   1576: aload 6
    //   1578: astore 4
    //   1580: aload 7
    //   1582: astore 6
    //   1584: goto -1180 -> 404
    //   1587: bipush 8
    //   1589: istore 23
    //   1591: iload 23
    //   1593: istore 21
    //   1595: iload 23
    //   1597: istore 22
    //   1599: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1602: ifeq +62 -> 1664
    //   1605: iload 23
    //   1607: istore 21
    //   1609: iload 23
    //   1611: istore 22
    //   1613: ldc 20
    //   1615: iconst_2
    //   1616: new 220	java/lang/StringBuilder
    //   1619: dup
    //   1620: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   1623: ldc_w 432
    //   1626: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1629: iload 20
    //   1631: invokevirtual 422	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1634: ldc_w 434
    //   1637: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1640: lload 29
    //   1642: invokevirtual 378	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1645: ldc_w 436
    //   1648: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1651: aload_1
    //   1652: getfield 191	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1655: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1658: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1661: invokestatic 185	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1664: iload 23
    //   1666: istore 20
    //   1668: iload 23
    //   1670: istore 21
    //   1672: iload 23
    //   1674: istore 22
    //   1676: aload 17
    //   1678: invokevirtual 206	java/io/File:exists	()Z
    //   1681: ifeq -679 -> 1002
    //   1684: iload 23
    //   1686: istore 21
    //   1688: iload 23
    //   1690: istore 22
    //   1692: aload 17
    //   1694: invokevirtual 305	java/io/File:delete	()Z
    //   1697: pop
    //   1698: iload 23
    //   1700: istore 20
    //   1702: goto -700 -> 1002
    //   1705: astore 6
    //   1707: iload 21
    //   1709: istore 20
    //   1711: aload 6
    //   1713: instanceof 438
    //   1716: ifne +15 -> 1731
    //   1719: aload 6
    //   1721: instanceof 440
    //   1724: istore 31
    //   1726: iload 31
    //   1728: ifeq +423 -> 2151
    //   1731: iconst_3
    //   1732: istore 20
    //   1734: aload 7
    //   1736: ifnull +966 -> 2702
    //   1739: aload 7
    //   1741: invokevirtual 409	java/io/InputStream:close	()V
    //   1744: goto -441 -> 1303
    //   1747: iload 20
    //   1749: istore 21
    //   1751: iload 20
    //   1753: istore 22
    //   1755: aload_2
    //   1756: invokestatic 277	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   1759: ifeq +316 -> 2075
    //   1762: iload 20
    //   1764: istore 21
    //   1766: iload 20
    //   1768: istore 22
    //   1770: iconst_3
    //   1771: anewarray 233	java/lang/String
    //   1774: astore 6
    //   1776: aload 6
    //   1778: iconst_0
    //   1779: ldc_w 442
    //   1782: aastore
    //   1783: aload 6
    //   1785: iconst_1
    //   1786: ldc_w 386
    //   1789: aastore
    //   1790: aload 6
    //   1792: iconst_2
    //   1793: ldc_w 388
    //   1796: aastore
    //   1797: goto -647 -> 1150
    //   1800: astore 6
    //   1802: iload 22
    //   1804: istore 20
    //   1806: aload 7
    //   1808: ifnull +32 -> 1840
    //   1811: iload 20
    //   1813: istore 22
    //   1815: iload 19
    //   1817: istore 21
    //   1819: aload 5
    //   1821: astore 8
    //   1823: iload 19
    //   1825: istore 23
    //   1827: aload 5
    //   1829: astore 9
    //   1831: aload 5
    //   1833: astore 10
    //   1835: aload 7
    //   1837: invokevirtual 409	java/io/InputStream:close	()V
    //   1840: iload 20
    //   1842: istore 22
    //   1844: iload 19
    //   1846: istore 21
    //   1848: aload 5
    //   1850: astore 8
    //   1852: iload 19
    //   1854: istore 23
    //   1856: aload 5
    //   1858: astore 9
    //   1860: aload 5
    //   1862: astore 10
    //   1864: aload 6
    //   1866: athrow
    //   1867: astore 6
    //   1869: aload 8
    //   1871: astore 5
    //   1873: iload 22
    //   1875: istore 20
    //   1877: aload 4
    //   1879: astore 8
    //   1881: aload 5
    //   1883: astore 7
    //   1885: aload 6
    //   1887: invokevirtual 443	java/io/IOException:printStackTrace	()V
    //   1890: aload 4
    //   1892: astore 8
    //   1894: aload 5
    //   1896: astore 7
    //   1898: aload 6
    //   1900: instanceof 445
    //   1903: ifeq +340 -> 2243
    //   1906: bipush 10
    //   1908: istore 22
    //   1910: aload 4
    //   1912: astore 8
    //   1914: aload 5
    //   1916: astore 7
    //   1918: ldc 20
    //   1920: iconst_2
    //   1921: new 220	java/lang/StringBuilder
    //   1924: dup
    //   1925: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   1928: ldc_w 447
    //   1931: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1934: iload 22
    //   1936: invokevirtual 422	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1939: ldc_w 449
    //   1942: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1945: aload_1
    //   1946: getfield 191	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1949: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1952: ldc_w 451
    //   1955: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1958: aload 6
    //   1960: invokevirtual 454	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1963: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1966: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1969: invokestatic 456	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1972: aload_3
    //   1973: ifnull +24 -> 1997
    //   1976: aload 4
    //   1978: astore 8
    //   1980: aload 5
    //   1982: astore 7
    //   1984: aload_3
    //   1985: aload 14
    //   1987: invokevirtual 213	java/net/URL:toString	()Ljava/lang/String;
    //   1990: iload 22
    //   1992: invokeinterface 218 3 0
    //   1997: aload 4
    //   1999: ifnull +10 -> 2009
    //   2002: aload 4
    //   2004: invokeinterface 416 1 0
    //   2009: aload 4
    //   2011: astore 6
    //   2013: iload 21
    //   2015: istore 19
    //   2017: aload 5
    //   2019: astore 7
    //   2021: iload 22
    //   2023: istore 20
    //   2025: aload 5
    //   2027: ifnull -547 -> 1480
    //   2030: aload 5
    //   2032: invokevirtual 417	java/io/OutputStream:close	()V
    //   2035: aload 4
    //   2037: astore 6
    //   2039: iload 21
    //   2041: istore 19
    //   2043: aload 5
    //   2045: astore 7
    //   2047: iload 22
    //   2049: istore 20
    //   2051: goto -571 -> 1480
    //   2054: astore 6
    //   2056: aload 4
    //   2058: astore 6
    //   2060: iload 21
    //   2062: istore 19
    //   2064: aload 5
    //   2066: astore 7
    //   2068: iload 22
    //   2070: istore 20
    //   2072: goto -592 -> 1480
    //   2075: iload 20
    //   2077: istore 21
    //   2079: iload 20
    //   2081: istore 22
    //   2083: iconst_3
    //   2084: anewarray 233	java/lang/String
    //   2087: astore 6
    //   2089: aload 6
    //   2091: iconst_0
    //   2092: ldc_w 458
    //   2095: aastore
    //   2096: aload 6
    //   2098: iconst_1
    //   2099: ldc_w 460
    //   2102: aastore
    //   2103: aload 6
    //   2105: iconst_2
    //   2106: ldc_w 388
    //   2109: aastore
    //   2110: goto -960 -> 1150
    //   2113: iload 20
    //   2115: istore 21
    //   2117: iload 20
    //   2119: istore 22
    //   2121: iconst_3
    //   2122: anewarray 233	java/lang/String
    //   2125: astore 6
    //   2127: aload 6
    //   2129: iconst_0
    //   2130: ldc_w 462
    //   2133: aastore
    //   2134: aload 6
    //   2136: iconst_1
    //   2137: ldc_w 460
    //   2140: aastore
    //   2141: aload 6
    //   2143: iconst_2
    //   2144: ldc_w 388
    //   2147: aastore
    //   2148: goto -998 -> 1150
    //   2151: aload 6
    //   2153: instanceof 464
    //   2156: istore 31
    //   2158: iload 31
    //   2160: ifeq +10 -> 2170
    //   2163: bipush 11
    //   2165: istore 20
    //   2167: goto -433 -> 1734
    //   2170: iconst_4
    //   2171: istore 20
    //   2173: goto -439 -> 1734
    //   2176: aload_3
    //   2177: ifnull +36 -> 2213
    //   2180: aload 6
    //   2182: astore 11
    //   2184: aload 4
    //   2186: astore 7
    //   2188: iload 19
    //   2190: istore 21
    //   2192: aload 6
    //   2194: astore 10
    //   2196: aload 4
    //   2198: astore 8
    //   2200: aload_3
    //   2201: aload 14
    //   2203: invokevirtual 213	java/net/URL:toString	()Ljava/lang/String;
    //   2206: iload 20
    //   2208: invokeinterface 218 3 0
    //   2213: aload 6
    //   2215: astore 5
    //   2217: goto -767 -> 1450
    //   2220: astore 6
    //   2222: aload 6
    //   2224: invokevirtual 443	java/io/IOException:printStackTrace	()V
    //   2227: goto -765 -> 1462
    //   2230: astore 6
    //   2232: aload 4
    //   2234: astore 6
    //   2236: aload 5
    //   2238: astore 7
    //   2240: goto -760 -> 1480
    //   2243: aload 4
    //   2245: astore 8
    //   2247: aload 5
    //   2249: astore 7
    //   2251: aload 6
    //   2253: instanceof 438
    //   2256: ifne +461 -> 2717
    //   2259: aload 4
    //   2261: astore 8
    //   2263: aload 5
    //   2265: astore 7
    //   2267: aload 6
    //   2269: instanceof 440
    //   2272: ifeq +6 -> 2278
    //   2275: goto +442 -> 2717
    //   2278: aload 4
    //   2280: astore 8
    //   2282: aload 5
    //   2284: astore 7
    //   2286: aload 6
    //   2288: instanceof 464
    //   2291: ifeq +24 -> 2315
    //   2294: aload 4
    //   2296: astore 8
    //   2298: aload 5
    //   2300: astore 7
    //   2302: aload_1
    //   2303: bipush 11
    //   2305: putfield 466	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   2308: iload 20
    //   2310: istore 22
    //   2312: goto -402 -> 1910
    //   2315: iconst_4
    //   2316: istore 22
    //   2318: goto -408 -> 1910
    //   2321: astore 6
    //   2323: aload 6
    //   2325: invokevirtual 443	java/io/IOException:printStackTrace	()V
    //   2328: goto -319 -> 2009
    //   2331: astore 6
    //   2333: iload 23
    //   2335: istore 21
    //   2337: aload 9
    //   2339: astore 5
    //   2341: aload 4
    //   2343: astore 8
    //   2345: aload 5
    //   2347: astore 7
    //   2349: aload 6
    //   2351: invokevirtual 467	java/lang/Exception:printStackTrace	()V
    //   2354: iconst_5
    //   2355: istore 22
    //   2357: aload_3
    //   2358: ifnull +23 -> 2381
    //   2361: aload 4
    //   2363: astore 8
    //   2365: aload 5
    //   2367: astore 7
    //   2369: aload_3
    //   2370: aload 14
    //   2372: invokevirtual 213	java/net/URL:toString	()Ljava/lang/String;
    //   2375: iconst_5
    //   2376: invokeinterface 218 3 0
    //   2381: aload 4
    //   2383: ifnull +10 -> 2393
    //   2386: aload 4
    //   2388: invokeinterface 416 1 0
    //   2393: aload 4
    //   2395: astore 6
    //   2397: iload 21
    //   2399: istore 19
    //   2401: aload 5
    //   2403: astore 7
    //   2405: iload 22
    //   2407: istore 20
    //   2409: aload 5
    //   2411: ifnull -931 -> 1480
    //   2414: aload 5
    //   2416: invokevirtual 417	java/io/OutputStream:close	()V
    //   2419: aload 4
    //   2421: astore 6
    //   2423: iload 21
    //   2425: istore 19
    //   2427: aload 5
    //   2429: astore 7
    //   2431: iload 22
    //   2433: istore 20
    //   2435: goto -955 -> 1480
    //   2438: astore 6
    //   2440: aload 4
    //   2442: astore 6
    //   2444: iload 21
    //   2446: istore 19
    //   2448: aload 5
    //   2450: astore 7
    //   2452: iload 22
    //   2454: istore 20
    //   2456: goto -976 -> 1480
    //   2459: astore 6
    //   2461: aload 6
    //   2463: invokevirtual 443	java/io/IOException:printStackTrace	()V
    //   2466: goto -73 -> 2393
    //   2469: astore_0
    //   2470: aload 10
    //   2472: astore_1
    //   2473: aload 4
    //   2475: ifnull +10 -> 2485
    //   2478: aload 4
    //   2480: invokeinterface 416 1 0
    //   2485: aload_1
    //   2486: ifnull +7 -> 2493
    //   2489: aload_1
    //   2490: invokevirtual 417	java/io/OutputStream:close	()V
    //   2493: aload_0
    //   2494: athrow
    //   2495: astore_2
    //   2496: aload_2
    //   2497: invokevirtual 443	java/io/IOException:printStackTrace	()V
    //   2500: goto -15 -> 2485
    //   2503: astore_0
    //   2504: aload 15
    //   2506: monitorexit
    //   2507: aload_0
    //   2508: athrow
    //   2509: astore_1
    //   2510: goto -17 -> 2493
    //   2513: astore 4
    //   2515: goto -961 -> 1554
    //   2518: astore_0
    //   2519: aload 5
    //   2521: astore_1
    //   2522: goto -49 -> 2473
    //   2525: astore_0
    //   2526: aload 11
    //   2528: astore_1
    //   2529: aload 7
    //   2531: astore 4
    //   2533: goto -60 -> 2473
    //   2536: astore_0
    //   2537: aload 8
    //   2539: astore 4
    //   2541: aload 7
    //   2543: astore_1
    //   2544: goto -71 -> 2473
    //   2547: astore 6
    //   2549: iload 19
    //   2551: istore 21
    //   2553: goto -212 -> 2341
    //   2556: astore 6
    //   2558: aload 10
    //   2560: astore 5
    //   2562: aload 8
    //   2564: astore 4
    //   2566: goto -225 -> 2341
    //   2569: astore 6
    //   2571: iload 19
    //   2573: istore 21
    //   2575: goto -698 -> 1877
    //   2578: astore 6
    //   2580: iload 23
    //   2582: istore 21
    //   2584: aload 12
    //   2586: astore 5
    //   2588: aload 9
    //   2590: astore 4
    //   2592: iload 22
    //   2594: istore 20
    //   2596: goto -719 -> 1877
    //   2599: astore 7
    //   2601: aload 6
    //   2603: astore 5
    //   2605: aload 7
    //   2607: astore 6
    //   2609: iload 19
    //   2611: istore 21
    //   2613: goto -736 -> 1877
    //   2616: astore 6
    //   2618: iconst_5
    //   2619: istore 20
    //   2621: goto -815 -> 1806
    //   2624: astore 6
    //   2626: goto -820 -> 1806
    //   2629: astore 8
    //   2631: aconst_null
    //   2632: astore 7
    //   2634: aload 6
    //   2636: astore 5
    //   2638: iconst_5
    //   2639: istore 20
    //   2641: aload 8
    //   2643: astore 6
    //   2645: goto -839 -> 1806
    //   2648: astore 6
    //   2650: aconst_null
    //   2651: astore 7
    //   2653: iconst_5
    //   2654: istore 20
    //   2656: goto -850 -> 1806
    //   2659: astore 6
    //   2661: iconst_5
    //   2662: istore 20
    //   2664: goto -953 -> 1711
    //   2667: astore 8
    //   2669: aload 6
    //   2671: astore 5
    //   2673: iconst_5
    //   2674: istore 20
    //   2676: aload 8
    //   2678: astore 6
    //   2680: goto -969 -> 1711
    //   2683: astore 6
    //   2685: iconst_5
    //   2686: istore 20
    //   2688: goto -977 -> 1711
    //   2691: aload 4
    //   2693: astore 6
    //   2695: aload 5
    //   2697: astore 7
    //   2699: goto -1219 -> 1480
    //   2702: goto -1399 -> 1303
    //   2705: goto -1402 -> 1303
    //   2708: goto -1872 -> 836
    //   2711: goto -1881 -> 830
    //   2714: goto -1614 -> 1100
    //   2717: iconst_2
    //   2718: istore 22
    //   2720: goto -810 -> 1910
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2723	0	paramAppInterface	AppInterface
    //   0	2723	1	paramDownloadInfo	DownloadInfo
    //   0	2723	2	paramNetworkInfo	NetworkInfo
    //   0	2723	3	paramHttpDownloadListener	HttpDownloadUtil.HttpDownloadListener
    //   58	2421	4	localObject1	Object
    //   2513	1	4	localInterruptedException	InterruptedException
    //   2531	161	4	localObject2	Object
    //   282	573	5	localObject3	Object
    //   894	967	5	localIllegalArgumentException	IllegalArgumentException
    //   1871	825	5	localObject4	Object
    //   202	1381	6	localObject5	Object
    //   1705	15	6	localIOException1	java.io.IOException
    //   1774	17	6	arrayOfString	String[]
    //   1800	65	6	localObject6	Object
    //   1867	92	6	localIOException2	java.io.IOException
    //   2011	27	6	localObject7	Object
    //   2054	1	6	localIOException3	java.io.IOException
    //   2058	156	6	localObject8	Object
    //   2220	3	6	localIOException4	java.io.IOException
    //   2230	1	6	localIOException5	java.io.IOException
    //   2234	53	6	localObject9	Object
    //   2321	3	6	localIOException6	java.io.IOException
    //   2331	19	6	localException1	Exception
    //   2395	27	6	localObject10	Object
    //   2438	1	6	localIOException7	java.io.IOException
    //   2442	1	6	localObject11	Object
    //   2459	3	6	localIOException8	java.io.IOException
    //   2547	1	6	localException2	Exception
    //   2556	1	6	localException3	Exception
    //   2569	1	6	localIOException9	java.io.IOException
    //   2578	24	6	localIOException10	java.io.IOException
    //   2607	1	6	localObject12	Object
    //   2616	1	6	localObject13	Object
    //   2624	11	6	localObject14	Object
    //   2643	1	6	localObject15	Object
    //   2648	1	6	localObject16	Object
    //   2659	11	6	localIOException11	java.io.IOException
    //   2678	1	6	localObject17	Object
    //   2683	1	6	localIOException12	java.io.IOException
    //   2693	1	6	localObject18	Object
    //   453	2089	7	localObject19	Object
    //   2599	7	7	localIOException13	java.io.IOException
    //   2632	66	7	localObject20	Object
    //   465	2098	8	localObject21	Object
    //   2629	13	8	localObject22	Object
    //   2667	10	8	localIOException14	java.io.IOException
    //   477	2112	9	localObject23	Object
    //   461	2098	10	localObject24	Object
    //   449	2078	11	localObject25	Object
    //   473	2112	12	localObject26	Object
    //   219	690	13	localHttpGet	org.apache.http.client.methods.HttpGet
    //   35	2336	14	localURL	URL
    //   49	2456	15	localObject27	Object
    //   228	215	16	localBasicHttpParams	BasicHttpParams
    //   382	1311	17	localFile	File
    //   548	83	18	localStatusLine	org.apache.http.StatusLine
    //   272	2338	19	i1	int
    //   269	2418	20	i2	int
    //   19	2593	21	i3	int
    //   481	2238	22	i4	int
    //   469	2112	23	i5	int
    //   402	1172	24	i6	int
    //   405	557	25	i7	int
    //   938	28	26	i8	int
    //   40	1194	27	l1	long
    //   788	853	29	l2	long
    //   1724	435	31	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   24	37	133	java/net/MalformedURLException
    //   51	60	148	java/lang/Exception
    //   65	81	148	java/lang/Exception
    //   85	97	148	java/lang/Exception
    //   97	131	148	java/lang/Exception
    //   210	221	894	java/lang/IllegalArgumentException
    //   896	910	913	java/lang/IllegalArgumentException
    //   955	961	1705	java/io/IOException
    //   969	998	1705	java/io/IOException
    //   1010	1016	1705	java/io/IOException
    //   1024	1066	1705	java/io/IOException
    //   1078	1100	1705	java/io/IOException
    //   1108	1115	1705	java/io/IOException
    //   1123	1129	1705	java/io/IOException
    //   1163	1175	1705	java/io/IOException
    //   1183	1192	1705	java/io/IOException
    //   1200	1206	1705	java/io/IOException
    //   1214	1269	1705	java/io/IOException
    //   1599	1605	1705	java/io/IOException
    //   1613	1664	1705	java/io/IOException
    //   1676	1684	1705	java/io/IOException
    //   1692	1698	1705	java/io/IOException
    //   1755	1762	1705	java/io/IOException
    //   1770	1776	1705	java/io/IOException
    //   2083	2089	1705	java/io/IOException
    //   2121	2127	1705	java/io/IOException
    //   955	961	1800	finally
    //   969	998	1800	finally
    //   1010	1016	1800	finally
    //   1024	1066	1800	finally
    //   1078	1100	1800	finally
    //   1108	1115	1800	finally
    //   1123	1129	1800	finally
    //   1163	1175	1800	finally
    //   1183	1192	1800	finally
    //   1200	1206	1800	finally
    //   1214	1269	1800	finally
    //   1599	1605	1800	finally
    //   1613	1664	1800	finally
    //   1676	1684	1800	finally
    //   1692	1698	1800	finally
    //   1755	1762	1800	finally
    //   1770	1776	1800	finally
    //   2083	2089	1800	finally
    //   2121	2127	1800	finally
    //   1298	1303	1867	java/io/IOException
    //   1835	1840	1867	java/io/IOException
    //   1864	1867	1867	java/io/IOException
    //   2030	2035	2054	java/io/IOException
    //   1455	1462	2220	java/io/IOException
    //   1467	1472	2230	java/io/IOException
    //   2002	2009	2321	java/io/IOException
    //   1298	1303	2331	java/lang/Exception
    //   1835	1840	2331	java/lang/Exception
    //   1864	1867	2331	java/lang/Exception
    //   2414	2419	2438	java/io/IOException
    //   2386	2393	2459	java/io/IOException
    //   1298	1303	2469	finally
    //   1835	1840	2469	finally
    //   1864	1867	2469	finally
    //   2478	2485	2495	java/io/IOException
    //   1546	1554	2503	finally
    //   1554	1557	2503	finally
    //   2504	2507	2503	finally
    //   2489	2493	2509	java/io/IOException
    //   1546	1554	2513	java/lang/InterruptedException
    //   1739	1744	2518	finally
    //   483	505	2525	finally
    //   541	550	2525	finally
    //   586	594	2525	finally
    //   630	639	2525	finally
    //   679	692	2525	finally
    //   728	737	2525	finally
    //   781	790	2525	finally
    //   1344	1351	2525	finally
    //   1387	1397	2525	finally
    //   1437	1450	2525	finally
    //   2200	2213	2525	finally
    //   1885	1890	2536	finally
    //   1898	1906	2536	finally
    //   1918	1972	2536	finally
    //   1984	1997	2536	finally
    //   2251	2259	2536	finally
    //   2267	2275	2536	finally
    //   2286	2294	2536	finally
    //   2302	2308	2536	finally
    //   2349	2354	2536	finally
    //   2369	2381	2536	finally
    //   1739	1744	2547	java/lang/Exception
    //   483	505	2556	java/lang/Exception
    //   541	550	2556	java/lang/Exception
    //   586	594	2556	java/lang/Exception
    //   630	639	2556	java/lang/Exception
    //   679	692	2556	java/lang/Exception
    //   728	737	2556	java/lang/Exception
    //   781	790	2556	java/lang/Exception
    //   1344	1351	2556	java/lang/Exception
    //   1387	1397	2556	java/lang/Exception
    //   1437	1450	2556	java/lang/Exception
    //   2200	2213	2556	java/lang/Exception
    //   1739	1744	2569	java/io/IOException
    //   483	505	2578	java/io/IOException
    //   541	550	2578	java/io/IOException
    //   586	594	2578	java/io/IOException
    //   630	639	2578	java/io/IOException
    //   679	692	2578	java/io/IOException
    //   728	737	2578	java/io/IOException
    //   781	790	2578	java/io/IOException
    //   1344	1351	2578	java/io/IOException
    //   1387	1397	2578	java/io/IOException
    //   1437	1450	2578	java/io/IOException
    //   2200	2213	2599	java/io/IOException
    //   830	836	2616	finally
    //   845	864	2616	finally
    //   875	891	2616	finally
    //   1711	1726	2624	finally
    //   2151	2158	2624	finally
    //   796	807	2629	finally
    //   807	816	2648	finally
    //   830	836	2659	java/io/IOException
    //   845	864	2659	java/io/IOException
    //   875	891	2659	java/io/IOException
    //   796	807	2667	java/io/IOException
    //   807	816	2683	java/io/IOException
  }
  
  public static int a(AppInterface paramAppInterface, DownloadInfo paramDownloadInfo, HttpDownloadUtil.HttpDownloadListener paramHttpDownloadListener)
  {
    NetworkInfo localNetworkInfo = AppNetConnInfo.getRecentNetworkInfo();
    if (localNetworkInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("HttpDownloadUtil", 2, "Download failed-----------activeNetworkInfo is null");
      }
      return 9;
    }
    return a(paramAppInterface, paramDownloadInfo, localNetworkInfo, paramHttpDownloadListener);
  }
  
  public static int a(AppInterface paramAppInterface, String paramString, File paramFile)
  {
    return a(paramAppInterface, paramString, paramFile, 2);
  }
  
  public static int a(AppInterface paramAppInterface, String paramString, File paramFile, int paramInt)
  {
    NetworkInfo localNetworkInfo = AppNetConnInfo.getRecentNetworkInfo();
    if (localNetworkInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("HttpDownloadUtil", 2, "Download failed-----------activeNetworkInfo is null");
      }
      return 1;
    }
    try
    {
      paramString = new URL(paramString);
      return a(paramAppInterface, paramString, paramFile, localNetworkInfo, paramInt);
    }
    catch (MalformedURLException paramAppInterface)
    {
      paramAppInterface.printStackTrace();
    }
    return 5;
  }
  
  public static int a(AppInterface paramAppInterface, URL paramURL, File paramFile, NetworkInfo paramNetworkInfo)
  {
    return a(paramAppInterface, paramURL, paramFile, paramNetworkInfo, 2);
  }
  
  /* Error */
  private static int a(AppInterface paramAppInterface, URL paramURL, File paramFile, NetworkInfo paramNetworkInfo, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 81	java/lang/System:currentTimeMillis	()J
    //   3: lstore 26
    //   5: new 4	java/lang/Object
    //   8: dup
    //   9: invokespecial 163	java/lang/Object:<init>	()V
    //   12: astore 15
    //   14: iload 4
    //   16: istore 18
    //   18: iload 4
    //   20: ifge +6 -> 26
    //   23: iconst_2
    //   24: istore 18
    //   26: aload_2
    //   27: invokevirtual 203	java/io/File:getParentFile	()Ljava/io/File;
    //   30: astore_0
    //   31: aload_0
    //   32: ifnull +15 -> 47
    //   35: aload_0
    //   36: invokevirtual 206	java/io/File:exists	()Z
    //   39: ifne +8 -> 47
    //   42: aload_0
    //   43: invokevirtual 209	java/io/File:mkdirs	()Z
    //   46: pop
    //   47: aconst_null
    //   48: astore_0
    //   49: aload_1
    //   50: invokevirtual 213	java/net/URL:toString	()Ljava/lang/String;
    //   53: astore 5
    //   55: new 241	org/apache/http/client/methods/HttpGet
    //   58: dup
    //   59: aload 5
    //   61: invokespecial 242	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   64: astore 13
    //   66: new 85	org/apache/http/params/BasicHttpParams
    //   69: dup
    //   70: invokespecial 88	org/apache/http/params/BasicHttpParams:<init>	()V
    //   73: astore 16
    //   75: sipush 20000
    //   78: istore 17
    //   80: ldc -11
    //   82: istore 4
    //   84: aload_3
    //   85: ifnull +104 -> 189
    //   88: invokestatic 263	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   91: astore 5
    //   93: invokestatic 267	android/net/Proxy:getDefaultPort	()I
    //   96: istore 4
    //   98: aload_3
    //   99: invokevirtual 272	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   102: astore 6
    //   104: aload_3
    //   105: invokestatic 277	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   108: ifeq +51 -> 159
    //   111: aload 6
    //   113: ifnull +14 -> 127
    //   116: aload 6
    //   118: ldc_w 279
    //   121: invokevirtual 283	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   124: ifeq +35 -> 159
    //   127: aload 5
    //   129: ifnull +30 -> 159
    //   132: iload 4
    //   134: ifle +25 -> 159
    //   137: aload 16
    //   139: ldc_w 285
    //   142: new 287	org/apache/http/HttpHost
    //   145: dup
    //   146: aload 5
    //   148: iload 4
    //   150: invokespecial 289	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   153: invokeinterface 256 3 0
    //   158: pop
    //   159: aload_3
    //   160: invokestatic 277	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   163: ifeq +897 -> 1060
    //   166: sipush 20000
    //   169: istore 17
    //   171: ldc -11
    //   173: istore 4
    //   175: aload 16
    //   177: ldc_w 291
    //   180: sipush 2048
    //   183: invokeinterface 295 3 0
    //   188: pop
    //   189: aload 16
    //   191: ldc -12
    //   193: iload 17
    //   195: invokestatic 250	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   198: invokeinterface 256 3 0
    //   203: pop
    //   204: aload 16
    //   206: ldc_w 258
    //   209: iload 4
    //   211: invokestatic 250	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   214: invokeinterface 256 3 0
    //   219: pop
    //   220: aload 13
    //   222: aload 16
    //   224: invokevirtual 299	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   227: aload_2
    //   228: ifnull +15 -> 243
    //   231: aload_2
    //   232: invokevirtual 206	java/io/File:exists	()Z
    //   235: ifeq +8 -> 243
    //   238: aload_2
    //   239: invokevirtual 305	java/io/File:delete	()Z
    //   242: pop
    //   243: aconst_null
    //   244: astore 5
    //   246: iconst_m1
    //   247: istore 19
    //   249: aload_0
    //   250: astore_3
    //   251: aload 5
    //   253: astore_0
    //   254: iload 19
    //   256: ifne +36 -> 292
    //   259: aload 16
    //   261: ldc_w 285
    //   264: new 287	org/apache/http/HttpHost
    //   267: dup
    //   268: aload_1
    //   269: invokevirtual 308	java/net/URL:getHost	()Ljava/lang/String;
    //   272: aload_1
    //   273: invokevirtual 311	java/net/URL:getPort	()I
    //   276: invokespecial 289	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   279: invokeinterface 256 3 0
    //   284: pop
    //   285: aload 13
    //   287: aload 16
    //   289: invokevirtual 299	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   292: iconst_5
    //   293: istore 4
    //   295: aload_0
    //   296: astore 6
    //   298: aload_3
    //   299: astore 11
    //   301: aload_0
    //   302: astore 9
    //   304: aload_3
    //   305: astore 7
    //   307: aload_0
    //   308: astore 10
    //   310: aload_3
    //   311: astore 8
    //   313: aload_0
    //   314: astore 12
    //   316: aload_3
    //   317: astore 5
    //   319: getstatic 142	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   322: new 287	org/apache/http/HttpHost
    //   325: dup
    //   326: aload_1
    //   327: invokevirtual 308	java/net/URL:getHost	()Ljava/lang/String;
    //   330: invokespecial 312	org/apache/http/HttpHost:<init>	(Ljava/lang/String;)V
    //   333: aload 13
    //   335: invokevirtual 316	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpResponse;
    //   338: astore 14
    //   340: aload_0
    //   341: astore 6
    //   343: aload_3
    //   344: astore 11
    //   346: aload_0
    //   347: astore 9
    //   349: aload_3
    //   350: astore 7
    //   352: aload_0
    //   353: astore 10
    //   355: aload_3
    //   356: astore 8
    //   358: aload_0
    //   359: astore 12
    //   361: aload_3
    //   362: astore 5
    //   364: aload 14
    //   366: invokeinterface 322 1 0
    //   371: invokeinterface 331 1 0
    //   376: istore 17
    //   378: aload_0
    //   379: astore 6
    //   381: aload_3
    //   382: astore 11
    //   384: aload_0
    //   385: astore 9
    //   387: aload_3
    //   388: astore 7
    //   390: aload_0
    //   391: astore 10
    //   393: aload_3
    //   394: astore 8
    //   396: aload_0
    //   397: astore 12
    //   399: aload_3
    //   400: astore 5
    //   402: aload 14
    //   404: invokeinterface 337 1 0
    //   409: astore_0
    //   410: sipush 200
    //   413: iload 17
    //   415: if_icmpne +822 -> 1237
    //   418: aload_0
    //   419: astore 6
    //   421: aload_3
    //   422: astore 11
    //   424: aload_0
    //   425: astore 9
    //   427: aload_3
    //   428: astore 7
    //   430: aload_0
    //   431: astore 10
    //   433: aload_3
    //   434: astore 8
    //   436: aload_0
    //   437: astore 12
    //   439: aload_3
    //   440: astore 5
    //   442: aload_0
    //   443: invokeinterface 342 1 0
    //   448: lstore 28
    //   450: lconst_0
    //   451: lstore 20
    //   453: aload_0
    //   454: astore 6
    //   456: aload_3
    //   457: astore 11
    //   459: aload_0
    //   460: astore 9
    //   462: aload_3
    //   463: astore 7
    //   465: aload_0
    //   466: astore 10
    //   468: aload_3
    //   469: astore 8
    //   471: new 492	java/io/BufferedOutputStream
    //   474: dup
    //   475: new 344	java/io/FileOutputStream
    //   478: dup
    //   479: aload_2
    //   480: invokespecial 347	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   483: invokespecial 495	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   486: astore 5
    //   488: lload 20
    //   490: lstore 22
    //   492: lload 20
    //   494: lstore 24
    //   496: aload 5
    //   498: astore 7
    //   500: aload 5
    //   502: astore 8
    //   504: aload 5
    //   506: astore 6
    //   508: aload_0
    //   509: aload 5
    //   511: invokeinterface 498 2 0
    //   516: lload 20
    //   518: lstore 22
    //   520: lload 20
    //   522: lstore 24
    //   524: aload 5
    //   526: astore 7
    //   528: aload 5
    //   530: astore 8
    //   532: aload 5
    //   534: astore 6
    //   536: aload 5
    //   538: invokevirtual 501	java/io/OutputStream:flush	()V
    //   541: lload 20
    //   543: lstore 22
    //   545: lload 20
    //   547: lstore 24
    //   549: aload 5
    //   551: astore 7
    //   553: aload 5
    //   555: astore 8
    //   557: aload 5
    //   559: astore 6
    //   561: aload_2
    //   562: invokevirtual 504	java/io/File:length	()J
    //   565: lstore 20
    //   567: lload 20
    //   569: lstore 22
    //   571: lload 20
    //   573: lstore 24
    //   575: aload 5
    //   577: astore 7
    //   579: aload 5
    //   581: astore 8
    //   583: aload 5
    //   585: astore 6
    //   587: aload_2
    //   588: invokestatic 81	java/lang/System:currentTimeMillis	()J
    //   591: invokevirtual 398	java/io/File:setLastModified	(J)Z
    //   594: pop
    //   595: lload 20
    //   597: lstore 22
    //   599: lload 20
    //   601: lstore 24
    //   603: aload 5
    //   605: astore 7
    //   607: aload 5
    //   609: astore 8
    //   611: aload 5
    //   613: astore 6
    //   615: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   618: ifeq +75 -> 693
    //   621: lload 20
    //   623: lstore 22
    //   625: lload 20
    //   627: lstore 24
    //   629: aload 5
    //   631: astore 7
    //   633: aload 5
    //   635: astore 8
    //   637: aload 5
    //   639: astore 6
    //   641: ldc 20
    //   643: iconst_2
    //   644: new 220	java/lang/StringBuilder
    //   647: dup
    //   648: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   651: ldc_w 400
    //   654: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   657: invokestatic 81	java/lang/System:currentTimeMillis	()J
    //   660: lload 26
    //   662: lsub
    //   663: invokevirtual 378	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   666: ldc_w 506
    //   669: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   672: lload 20
    //   674: invokevirtual 378	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   677: ldc_w 404
    //   680: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   683: aload_1
    //   684: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   687: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   690: invokestatic 406	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   693: aload 5
    //   695: astore_3
    //   696: iconst_0
    //   697: istore 4
    //   699: iload 4
    //   701: istore 17
    //   703: lload 28
    //   705: lconst_0
    //   706: lcmp
    //   707: ifle +75 -> 782
    //   710: iload 4
    //   712: istore 17
    //   714: lload 20
    //   716: lload 28
    //   718: lcmp
    //   719: ifge +63 -> 782
    //   722: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   725: ifeq +53 -> 778
    //   728: ldc 20
    //   730: iconst_2
    //   731: new 220	java/lang/StringBuilder
    //   734: dup
    //   735: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   738: ldc_w 511
    //   741: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   744: lload 28
    //   746: invokevirtual 378	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   749: ldc_w 513
    //   752: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   755: aload_2
    //   756: invokevirtual 504	java/io/File:length	()J
    //   759: invokevirtual 378	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   762: ldc_w 424
    //   765: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   768: aload_1
    //   769: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   772: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   775: invokestatic 456	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   778: bipush 8
    //   780: istore 17
    //   782: aload_0
    //   783: ifnull +9 -> 792
    //   786: aload_0
    //   787: invokeinterface 416 1 0
    //   792: aload_3
    //   793: ifnull +7 -> 800
    //   796: aload_3
    //   797: invokevirtual 417	java/io/OutputStream:close	()V
    //   800: iload 17
    //   802: ifeq +1413 -> 2215
    //   805: aload_2
    //   806: ifnull +68 -> 874
    //   809: aload_2
    //   810: invokevirtual 203	java/io/File:getParentFile	()Ljava/io/File;
    //   813: astore 5
    //   815: aload 5
    //   817: ifnull +17 -> 834
    //   820: aload 5
    //   822: invokevirtual 206	java/io/File:exists	()Z
    //   825: ifne +9 -> 834
    //   828: aload 5
    //   830: invokevirtual 209	java/io/File:mkdirs	()Z
    //   833: pop
    //   834: aload_2
    //   835: invokevirtual 206	java/io/File:exists	()Z
    //   838: ifeq +36 -> 874
    //   841: aload_2
    //   842: invokevirtual 305	java/io/File:delete	()Z
    //   845: istore 30
    //   847: ldc 20
    //   849: iconst_1
    //   850: new 220	java/lang/StringBuilder
    //   853: dup
    //   854: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   857: ldc_w 515
    //   860: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   863: iload 30
    //   865: invokevirtual 518	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   868: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   871: invokestatic 185	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   874: iload 19
    //   876: iconst_1
    //   877: iadd
    //   878: istore 19
    //   880: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   883: ifeq +40 -> 923
    //   886: ldc 20
    //   888: iconst_2
    //   889: new 220	java/lang/StringBuilder
    //   892: dup
    //   893: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   896: ldc_w 419
    //   899: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   902: iload 17
    //   904: invokevirtual 422	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   907: ldc_w 424
    //   910: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   913: aload_1
    //   914: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   917: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   920: invokestatic 185	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   923: iload 17
    //   925: ifeq +51 -> 976
    //   928: ldc 20
    //   930: iconst_1
    //   931: new 220	java/lang/StringBuilder
    //   934: dup
    //   935: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   938: ldc_w 419
    //   941: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   944: iload 17
    //   946: invokevirtual 422	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   949: ldc_w 424
    //   952: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   955: aload_1
    //   956: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   959: ldc_w 520
    //   962: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   965: iload 19
    //   967: invokevirtual 422	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   970: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   973: invokestatic 185	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   976: iload 17
    //   978: ifeq +23 -> 1001
    //   981: iload 19
    //   983: iconst_2
    //   984: if_icmpge +17 -> 1001
    //   987: aload 15
    //   989: monitorenter
    //   990: aload 15
    //   992: ldc2_w 521
    //   995: invokevirtual 430	java/lang/Object:wait	(J)V
    //   998: aload 15
    //   1000: monitorexit
    //   1001: iload 17
    //   1003: ifeq +10 -> 1013
    //   1006: iload 19
    //   1008: iload 18
    //   1010: if_icmplt +1202 -> 2212
    //   1013: iload 17
    //   1015: ireturn
    //   1016: astore_0
    //   1017: ldc 20
    //   1019: iconst_1
    //   1020: ldc_w 524
    //   1023: invokestatic 185	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1026: iconst_4
    //   1027: ireturn
    //   1028: astore 6
    //   1030: new 241	org/apache/http/client/methods/HttpGet
    //   1033: dup
    //   1034: aload 5
    //   1036: invokestatic 369	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1039: invokespecial 242	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   1042: astore 13
    //   1044: goto -978 -> 66
    //   1047: astore_0
    //   1048: ldc 20
    //   1050: iconst_1
    //   1051: ldc_w 526
    //   1054: invokestatic 185	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1057: bipush 13
    //   1059: ireturn
    //   1060: sipush 10000
    //   1063: istore 17
    //   1065: sipush 30000
    //   1068: istore 4
    //   1070: aload 16
    //   1072: ldc_w 291
    //   1075: sipush 4096
    //   1078: invokeinterface 295 3 0
    //   1083: pop
    //   1084: goto -895 -> 189
    //   1087: astore_3
    //   1088: lload 22
    //   1090: lstore 20
    //   1092: aload 5
    //   1094: astore_3
    //   1095: aload_3
    //   1096: astore 7
    //   1098: aload_3
    //   1099: astore 8
    //   1101: aload_3
    //   1102: astore 6
    //   1104: ldc 20
    //   1106: iconst_1
    //   1107: new 220	java/lang/StringBuilder
    //   1110: dup
    //   1111: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   1114: ldc_w 528
    //   1117: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1120: aload_2
    //   1121: invokevirtual 206	java/io/File:exists	()Z
    //   1124: invokevirtual 518	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1127: ldc_w 530
    //   1130: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1133: aload_2
    //   1134: invokevirtual 203	java/io/File:getParentFile	()Ljava/io/File;
    //   1137: invokevirtual 206	java/io/File:exists	()Z
    //   1140: invokevirtual 518	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1143: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1146: invokestatic 185	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1149: iconst_5
    //   1150: istore 4
    //   1152: goto -453 -> 699
    //   1155: astore 14
    //   1157: aload 5
    //   1159: astore_3
    //   1160: lload 24
    //   1162: lstore 20
    //   1164: aload_0
    //   1165: astore 6
    //   1167: aload_3
    //   1168: astore 11
    //   1170: aload_0
    //   1171: astore 9
    //   1173: aload_3
    //   1174: astore 7
    //   1176: aload_0
    //   1177: astore 10
    //   1179: aload_3
    //   1180: astore 8
    //   1182: aload_0
    //   1183: astore 12
    //   1185: aload_3
    //   1186: astore 5
    //   1188: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1191: ifeq +40 -> 1231
    //   1194: aload_0
    //   1195: astore 6
    //   1197: aload_3
    //   1198: astore 11
    //   1200: aload_0
    //   1201: astore 9
    //   1203: aload_3
    //   1204: astore 7
    //   1206: aload_0
    //   1207: astore 10
    //   1209: aload_3
    //   1210: astore 8
    //   1212: aload_0
    //   1213: astore 12
    //   1215: aload_3
    //   1216: astore 5
    //   1218: ldc 20
    //   1220: iconst_2
    //   1221: aload 14
    //   1223: invokevirtual 454	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1226: aload 14
    //   1228: invokestatic 533	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1231: iconst_4
    //   1232: istore 4
    //   1234: goto -535 -> 699
    //   1237: goto -455 -> 782
    //   1240: astore 5
    //   1242: aload 5
    //   1244: invokevirtual 443	java/io/IOException:printStackTrace	()V
    //   1247: goto -455 -> 792
    //   1250: astore 5
    //   1252: goto -378 -> 874
    //   1255: astore 6
    //   1257: iconst_5
    //   1258: istore 4
    //   1260: aload_0
    //   1261: astore 5
    //   1263: aload 6
    //   1265: astore_0
    //   1266: aload_3
    //   1267: astore 6
    //   1269: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1272: ifeq +30 -> 1302
    //   1275: ldc 20
    //   1277: iconst_2
    //   1278: new 220	java/lang/StringBuilder
    //   1281: dup
    //   1282: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   1285: ldc_w 535
    //   1288: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1291: aload_1
    //   1292: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1295: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1298: aload_0
    //   1299: invokestatic 533	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1302: aload_0
    //   1303: instanceof 445
    //   1306: istore 30
    //   1308: iload 30
    //   1310: ifeq +156 -> 1466
    //   1313: bipush 10
    //   1315: istore 4
    //   1317: aload 5
    //   1319: ifnull +10 -> 1329
    //   1322: aload 5
    //   1324: invokeinterface 416 1 0
    //   1329: aload 6
    //   1331: ifnull +8 -> 1339
    //   1334: aload 6
    //   1336: invokevirtual 417	java/io/OutputStream:close	()V
    //   1339: aload 5
    //   1341: astore_0
    //   1342: aload 6
    //   1344: astore_3
    //   1345: iload 4
    //   1347: istore 17
    //   1349: iload 4
    //   1351: ifeq -477 -> 874
    //   1354: aload 5
    //   1356: astore_0
    //   1357: aload 6
    //   1359: astore_3
    //   1360: iload 4
    //   1362: istore 17
    //   1364: aload_2
    //   1365: ifnull -491 -> 874
    //   1368: aload_2
    //   1369: invokevirtual 203	java/io/File:getParentFile	()Ljava/io/File;
    //   1372: astore_0
    //   1373: aload_0
    //   1374: ifnull +15 -> 1389
    //   1377: aload_0
    //   1378: invokevirtual 206	java/io/File:exists	()Z
    //   1381: ifne +8 -> 1389
    //   1384: aload_0
    //   1385: invokevirtual 209	java/io/File:mkdirs	()Z
    //   1388: pop
    //   1389: aload 5
    //   1391: astore_0
    //   1392: aload 6
    //   1394: astore_3
    //   1395: iload 4
    //   1397: istore 17
    //   1399: aload_2
    //   1400: invokevirtual 206	java/io/File:exists	()Z
    //   1403: ifeq -529 -> 874
    //   1406: aload_2
    //   1407: invokevirtual 305	java/io/File:delete	()Z
    //   1410: istore 30
    //   1412: ldc 20
    //   1414: iconst_1
    //   1415: new 220	java/lang/StringBuilder
    //   1418: dup
    //   1419: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   1422: ldc_w 515
    //   1425: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1428: iload 30
    //   1430: invokevirtual 518	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1433: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1436: invokestatic 185	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1439: aload 5
    //   1441: astore_0
    //   1442: aload 6
    //   1444: astore_3
    //   1445: iload 4
    //   1447: istore 17
    //   1449: goto -575 -> 874
    //   1452: astore_0
    //   1453: aload 5
    //   1455: astore_0
    //   1456: aload 6
    //   1458: astore_3
    //   1459: iload 4
    //   1461: istore 17
    //   1463: goto -589 -> 874
    //   1466: aload_0
    //   1467: instanceof 438
    //   1470: ifne +748 -> 2218
    //   1473: aload_0
    //   1474: instanceof 440
    //   1477: ifeq +6 -> 1483
    //   1480: goto +738 -> 2218
    //   1483: aload_0
    //   1484: instanceof 464
    //   1487: istore 30
    //   1489: iload 30
    //   1491: ifeq +10 -> 1501
    //   1494: bipush 11
    //   1496: istore 4
    //   1498: goto -181 -> 1317
    //   1501: iconst_4
    //   1502: istore 4
    //   1504: goto -187 -> 1317
    //   1507: astore_0
    //   1508: aload_0
    //   1509: invokevirtual 443	java/io/IOException:printStackTrace	()V
    //   1512: goto -183 -> 1329
    //   1515: astore_3
    //   1516: aload 7
    //   1518: astore 6
    //   1520: iload 4
    //   1522: istore 17
    //   1524: aload_3
    //   1525: astore 7
    //   1527: aload_0
    //   1528: astore 5
    //   1530: aload 5
    //   1532: astore_0
    //   1533: aload 6
    //   1535: astore_3
    //   1536: iload 17
    //   1538: istore 4
    //   1540: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1543: ifeq +41 -> 1584
    //   1546: aload 5
    //   1548: astore_0
    //   1549: aload 6
    //   1551: astore_3
    //   1552: iload 17
    //   1554: istore 4
    //   1556: ldc 20
    //   1558: iconst_2
    //   1559: new 220	java/lang/StringBuilder
    //   1562: dup
    //   1563: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   1566: ldc_w 537
    //   1569: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1572: aload_1
    //   1573: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1576: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1579: aload 7
    //   1581: invokestatic 533	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1584: iconst_5
    //   1585: istore 4
    //   1587: aload 5
    //   1589: ifnull +10 -> 1599
    //   1592: aload 5
    //   1594: invokeinterface 416 1 0
    //   1599: aload 6
    //   1601: ifnull +8 -> 1609
    //   1604: aload 6
    //   1606: invokevirtual 417	java/io/OutputStream:close	()V
    //   1609: aload 5
    //   1611: astore_0
    //   1612: aload 6
    //   1614: astore_3
    //   1615: iload 4
    //   1617: istore 17
    //   1619: aload_2
    //   1620: ifnull -746 -> 874
    //   1623: aload_2
    //   1624: invokevirtual 203	java/io/File:getParentFile	()Ljava/io/File;
    //   1627: astore_0
    //   1628: aload_0
    //   1629: ifnull +15 -> 1644
    //   1632: aload_0
    //   1633: invokevirtual 206	java/io/File:exists	()Z
    //   1636: ifne +8 -> 1644
    //   1639: aload_0
    //   1640: invokevirtual 209	java/io/File:mkdirs	()Z
    //   1643: pop
    //   1644: aload 5
    //   1646: astore_0
    //   1647: aload 6
    //   1649: astore_3
    //   1650: iload 4
    //   1652: istore 17
    //   1654: aload_2
    //   1655: invokevirtual 206	java/io/File:exists	()Z
    //   1658: ifeq -784 -> 874
    //   1661: aload_2
    //   1662: invokevirtual 305	java/io/File:delete	()Z
    //   1665: istore 30
    //   1667: ldc 20
    //   1669: iconst_1
    //   1670: new 220	java/lang/StringBuilder
    //   1673: dup
    //   1674: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   1677: ldc_w 515
    //   1680: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1683: iload 30
    //   1685: invokevirtual 518	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1688: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1691: invokestatic 185	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1694: aload 5
    //   1696: astore_0
    //   1697: aload 6
    //   1699: astore_3
    //   1700: iload 4
    //   1702: istore 17
    //   1704: goto -830 -> 874
    //   1707: astore_0
    //   1708: aload 5
    //   1710: astore_0
    //   1711: aload 6
    //   1713: astore_3
    //   1714: iload 4
    //   1716: istore 17
    //   1718: goto -844 -> 874
    //   1721: astore_0
    //   1722: aload_0
    //   1723: invokevirtual 443	java/io/IOException:printStackTrace	()V
    //   1726: goto -127 -> 1599
    //   1729: astore 7
    //   1731: aload 8
    //   1733: astore 6
    //   1735: iload 4
    //   1737: istore 17
    //   1739: aload_0
    //   1740: astore 5
    //   1742: aload 5
    //   1744: astore_0
    //   1745: aload 6
    //   1747: astore_3
    //   1748: iload 17
    //   1750: istore 4
    //   1752: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1755: ifeq +41 -> 1796
    //   1758: aload 5
    //   1760: astore_0
    //   1761: aload 6
    //   1763: astore_3
    //   1764: iload 17
    //   1766: istore 4
    //   1768: ldc 20
    //   1770: iconst_2
    //   1771: new 220	java/lang/StringBuilder
    //   1774: dup
    //   1775: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   1778: ldc_w 537
    //   1781: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1784: aload_1
    //   1785: invokevirtual 509	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1788: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1791: aload 7
    //   1793: invokestatic 533	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1796: iconst_5
    //   1797: istore 4
    //   1799: aload 5
    //   1801: ifnull +10 -> 1811
    //   1804: aload 5
    //   1806: invokeinterface 416 1 0
    //   1811: aload 6
    //   1813: ifnull +8 -> 1821
    //   1816: aload 6
    //   1818: invokevirtual 417	java/io/OutputStream:close	()V
    //   1821: aload 5
    //   1823: astore_0
    //   1824: aload 6
    //   1826: astore_3
    //   1827: iload 4
    //   1829: istore 17
    //   1831: aload_2
    //   1832: ifnull -958 -> 874
    //   1835: aload_2
    //   1836: invokevirtual 203	java/io/File:getParentFile	()Ljava/io/File;
    //   1839: astore_0
    //   1840: aload_0
    //   1841: ifnull +15 -> 1856
    //   1844: aload_0
    //   1845: invokevirtual 206	java/io/File:exists	()Z
    //   1848: ifne +8 -> 1856
    //   1851: aload_0
    //   1852: invokevirtual 209	java/io/File:mkdirs	()Z
    //   1855: pop
    //   1856: aload 5
    //   1858: astore_0
    //   1859: aload 6
    //   1861: astore_3
    //   1862: iload 4
    //   1864: istore 17
    //   1866: aload_2
    //   1867: invokevirtual 206	java/io/File:exists	()Z
    //   1870: ifeq -996 -> 874
    //   1873: aload_2
    //   1874: invokevirtual 305	java/io/File:delete	()Z
    //   1877: istore 30
    //   1879: ldc 20
    //   1881: iconst_1
    //   1882: new 220	java/lang/StringBuilder
    //   1885: dup
    //   1886: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   1889: ldc_w 515
    //   1892: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1895: iload 30
    //   1897: invokevirtual 518	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1900: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1903: invokestatic 185	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1906: aload 5
    //   1908: astore_0
    //   1909: aload 6
    //   1911: astore_3
    //   1912: iload 4
    //   1914: istore 17
    //   1916: goto -1042 -> 874
    //   1919: astore_0
    //   1920: aload 5
    //   1922: astore_0
    //   1923: aload 6
    //   1925: astore_3
    //   1926: iload 4
    //   1928: istore 17
    //   1930: goto -1056 -> 874
    //   1933: astore_0
    //   1934: aload_0
    //   1935: invokevirtual 443	java/io/IOException:printStackTrace	()V
    //   1938: goto -127 -> 1811
    //   1941: astore_1
    //   1942: aload 6
    //   1944: astore_3
    //   1945: aload_0
    //   1946: ifnull +9 -> 1955
    //   1949: aload_0
    //   1950: invokeinterface 416 1 0
    //   1955: aload_3
    //   1956: ifnull +7 -> 1963
    //   1959: aload_3
    //   1960: invokevirtual 417	java/io/OutputStream:close	()V
    //   1963: iload 4
    //   1965: ifeq +68 -> 2033
    //   1968: aload_2
    //   1969: ifnull +64 -> 2033
    //   1972: aload_2
    //   1973: invokevirtual 203	java/io/File:getParentFile	()Ljava/io/File;
    //   1976: astore_0
    //   1977: aload_0
    //   1978: ifnull +15 -> 1993
    //   1981: aload_0
    //   1982: invokevirtual 206	java/io/File:exists	()Z
    //   1985: ifne +8 -> 1993
    //   1988: aload_0
    //   1989: invokevirtual 209	java/io/File:mkdirs	()Z
    //   1992: pop
    //   1993: aload_2
    //   1994: invokevirtual 206	java/io/File:exists	()Z
    //   1997: ifeq +36 -> 2033
    //   2000: aload_2
    //   2001: invokevirtual 305	java/io/File:delete	()Z
    //   2004: istore 30
    //   2006: ldc 20
    //   2008: iconst_1
    //   2009: new 220	java/lang/StringBuilder
    //   2012: dup
    //   2013: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   2016: ldc_w 515
    //   2019: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2022: iload 30
    //   2024: invokevirtual 518	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2027: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2030: invokestatic 185	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2033: aload_1
    //   2034: athrow
    //   2035: astore_0
    //   2036: aload_0
    //   2037: invokevirtual 443	java/io/IOException:printStackTrace	()V
    //   2040: goto -85 -> 1955
    //   2043: astore_0
    //   2044: aload 15
    //   2046: monitorexit
    //   2047: aload_0
    //   2048: athrow
    //   2049: astore 5
    //   2051: goto -1251 -> 800
    //   2054: astore_0
    //   2055: goto -716 -> 1339
    //   2058: astore_0
    //   2059: goto -450 -> 1609
    //   2062: astore_0
    //   2063: goto -242 -> 1821
    //   2066: astore_0
    //   2067: goto -104 -> 1963
    //   2070: astore 5
    //   2072: goto -1074 -> 998
    //   2075: astore_0
    //   2076: goto -43 -> 2033
    //   2079: astore_1
    //   2080: aload 11
    //   2082: astore_3
    //   2083: aload 6
    //   2085: astore_0
    //   2086: goto -141 -> 1945
    //   2089: astore_1
    //   2090: goto -145 -> 1945
    //   2093: astore_1
    //   2094: aload 5
    //   2096: astore_0
    //   2097: aload 6
    //   2099: astore_3
    //   2100: goto -155 -> 1945
    //   2103: astore_1
    //   2104: goto -159 -> 1945
    //   2107: astore_0
    //   2108: aload 9
    //   2110: astore 5
    //   2112: aload 7
    //   2114: astore 6
    //   2116: aload_0
    //   2117: astore 7
    //   2119: iload 4
    //   2121: istore 17
    //   2123: goto -381 -> 1742
    //   2126: astore 7
    //   2128: aload_0
    //   2129: astore 5
    //   2131: aload_3
    //   2132: astore 6
    //   2134: iload 4
    //   2136: istore 17
    //   2138: goto -396 -> 1742
    //   2141: astore 7
    //   2143: aload 10
    //   2145: astore 5
    //   2147: aload 8
    //   2149: astore 6
    //   2151: iload 4
    //   2153: istore 17
    //   2155: goto -625 -> 1530
    //   2158: astore 7
    //   2160: aload_0
    //   2161: astore 5
    //   2163: aload_3
    //   2164: astore 6
    //   2166: iload 4
    //   2168: istore 17
    //   2170: goto -640 -> 1530
    //   2173: astore_0
    //   2174: iconst_5
    //   2175: istore 4
    //   2177: aload 5
    //   2179: astore 6
    //   2181: aload 12
    //   2183: astore 5
    //   2185: goto -916 -> 1269
    //   2188: astore 7
    //   2190: aload_0
    //   2191: astore 5
    //   2193: aload_3
    //   2194: astore 6
    //   2196: aload 7
    //   2198: astore_0
    //   2199: goto -930 -> 1269
    //   2202: astore 14
    //   2204: goto -1040 -> 1164
    //   2207: astore 5
    //   2209: goto -1114 -> 1095
    //   2212: goto -1958 -> 254
    //   2215: goto -1341 -> 874
    //   2218: iconst_2
    //   2219: istore 4
    //   2221: goto -904 -> 1317
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2224	0	paramAppInterface	AppInterface
    //   0	2224	1	paramURL	URL
    //   0	2224	2	paramFile	File
    //   0	2224	3	paramNetworkInfo	NetworkInfo
    //   0	2224	4	paramInt	int
    //   53	1164	5	localObject1	Object
    //   1240	3	5	localIOException1	java.io.IOException
    //   1250	1	5	localException1	Exception
    //   1261	660	5	localAppInterface1	AppInterface
    //   2049	1	5	localIOException2	java.io.IOException
    //   2070	25	5	localInterruptedException	InterruptedException
    //   2110	82	5	localObject2	Object
    //   2207	1	5	localFileNotFoundException	java.io.FileNotFoundException
    //   102	538	6	localObject3	Object
    //   1028	1	6	localIllegalArgumentException	IllegalArgumentException
    //   1102	94	6	localObject4	Object
    //   1255	9	6	localIOException3	java.io.IOException
    //   1267	928	6	localObject5	Object
    //   305	1275	7	localObject6	Object
    //   1729	384	7	localThrowable1	Throwable
    //   2117	1	7	localAppInterface2	AppInterface
    //   2126	1	7	localThrowable2	Throwable
    //   2141	1	7	localException2	Exception
    //   2158	1	7	localException3	Exception
    //   2188	9	7	localIOException4	java.io.IOException
    //   311	1837	8	localObject7	Object
    //   302	1807	9	localAppInterface3	AppInterface
    //   308	1836	10	localAppInterface4	AppInterface
    //   299	1782	11	localNetworkInfo	NetworkInfo
    //   314	1868	12	localAppInterface5	AppInterface
    //   64	979	13	localHttpGet	org.apache.http.client.methods.HttpGet
    //   338	65	14	localHttpResponse	org.apache.http.HttpResponse
    //   1155	72	14	localIOException5	java.io.IOException
    //   2202	1	14	localIOException6	java.io.IOException
    //   12	2033	15	localObject8	Object
    //   73	998	16	localBasicHttpParams	BasicHttpParams
    //   78	2091	17	i1	int
    //   16	995	18	i2	int
    //   247	764	19	i3	int
    //   451	712	20	l1	long
    //   490	599	22	l2	long
    //   494	667	24	l3	long
    //   3	658	26	l4	long
    //   448	297	28	l5	long
    //   845	1178	30	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   26	31	1016	java/lang/Exception
    //   35	47	1016	java/lang/Exception
    //   55	66	1028	java/lang/IllegalArgumentException
    //   1030	1044	1047	java/lang/IllegalArgumentException
    //   508	516	1087	java/io/FileNotFoundException
    //   536	541	1087	java/io/FileNotFoundException
    //   561	567	1087	java/io/FileNotFoundException
    //   587	595	1087	java/io/FileNotFoundException
    //   615	621	1087	java/io/FileNotFoundException
    //   641	693	1087	java/io/FileNotFoundException
    //   508	516	1155	java/io/IOException
    //   536	541	1155	java/io/IOException
    //   561	567	1155	java/io/IOException
    //   587	595	1155	java/io/IOException
    //   615	621	1155	java/io/IOException
    //   641	693	1155	java/io/IOException
    //   786	792	1240	java/io/IOException
    //   809	815	1250	java/lang/Exception
    //   820	834	1250	java/lang/Exception
    //   834	874	1250	java/lang/Exception
    //   1104	1149	1255	java/io/IOException
    //   1368	1373	1452	java/lang/Exception
    //   1377	1389	1452	java/lang/Exception
    //   1399	1439	1452	java/lang/Exception
    //   1322	1329	1507	java/io/IOException
    //   508	516	1515	java/lang/Exception
    //   536	541	1515	java/lang/Exception
    //   561	567	1515	java/lang/Exception
    //   587	595	1515	java/lang/Exception
    //   615	621	1515	java/lang/Exception
    //   641	693	1515	java/lang/Exception
    //   1104	1149	1515	java/lang/Exception
    //   1623	1628	1707	java/lang/Exception
    //   1632	1644	1707	java/lang/Exception
    //   1654	1694	1707	java/lang/Exception
    //   1592	1599	1721	java/io/IOException
    //   508	516	1729	java/lang/Throwable
    //   536	541	1729	java/lang/Throwable
    //   561	567	1729	java/lang/Throwable
    //   587	595	1729	java/lang/Throwable
    //   615	621	1729	java/lang/Throwable
    //   641	693	1729	java/lang/Throwable
    //   1104	1149	1729	java/lang/Throwable
    //   1835	1840	1919	java/lang/Exception
    //   1844	1856	1919	java/lang/Exception
    //   1866	1906	1919	java/lang/Exception
    //   1804	1811	1933	java/io/IOException
    //   508	516	1941	finally
    //   536	541	1941	finally
    //   561	567	1941	finally
    //   587	595	1941	finally
    //   615	621	1941	finally
    //   641	693	1941	finally
    //   1104	1149	1941	finally
    //   1949	1955	2035	java/io/IOException
    //   990	998	2043	finally
    //   998	1001	2043	finally
    //   2044	2047	2043	finally
    //   796	800	2049	java/io/IOException
    //   1334	1339	2054	java/io/IOException
    //   1604	1609	2058	java/io/IOException
    //   1816	1821	2062	java/io/IOException
    //   1959	1963	2066	java/io/IOException
    //   990	998	2070	java/lang/InterruptedException
    //   1972	1977	2075	java/lang/Exception
    //   1981	1993	2075	java/lang/Exception
    //   1993	2033	2075	java/lang/Exception
    //   319	340	2079	finally
    //   364	378	2079	finally
    //   402	410	2079	finally
    //   442	450	2079	finally
    //   471	488	2079	finally
    //   1188	1194	2079	finally
    //   1218	1231	2079	finally
    //   722	778	2089	finally
    //   1269	1302	2093	finally
    //   1302	1308	2093	finally
    //   1466	1480	2093	finally
    //   1483	1489	2093	finally
    //   1540	1546	2103	finally
    //   1556	1584	2103	finally
    //   1752	1758	2103	finally
    //   1768	1796	2103	finally
    //   319	340	2107	java/lang/Throwable
    //   364	378	2107	java/lang/Throwable
    //   402	410	2107	java/lang/Throwable
    //   442	450	2107	java/lang/Throwable
    //   471	488	2107	java/lang/Throwable
    //   1188	1194	2107	java/lang/Throwable
    //   1218	1231	2107	java/lang/Throwable
    //   722	778	2126	java/lang/Throwable
    //   319	340	2141	java/lang/Exception
    //   364	378	2141	java/lang/Exception
    //   402	410	2141	java/lang/Exception
    //   442	450	2141	java/lang/Exception
    //   471	488	2141	java/lang/Exception
    //   1188	1194	2141	java/lang/Exception
    //   1218	1231	2141	java/lang/Exception
    //   722	778	2158	java/lang/Exception
    //   319	340	2173	java/io/IOException
    //   364	378	2173	java/io/IOException
    //   402	410	2173	java/io/IOException
    //   442	450	2173	java/io/IOException
    //   1188	1194	2173	java/io/IOException
    //   1218	1231	2173	java/io/IOException
    //   722	778	2188	java/io/IOException
    //   471	488	2202	java/io/IOException
    //   471	488	2207	java/io/FileNotFoundException
  }
  
  public static DownloadInfo a(String paramString, HttpDownloadUtil.DownloadInfoListener paramDownloadInfoListener)
  {
    return a(paramString, paramDownloadInfoListener, null, 2, true);
  }
  
  /* Error */
  public static DownloadInfo a(String paramString, HttpDownloadUtil.DownloadInfoListener paramDownloadInfoListener, java.util.List paramList, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 189	com/tencent/mobileqq/emoticon/DownloadInfo
    //   3: dup
    //   4: aload_0
    //   5: aconst_null
    //   6: iconst_0
    //   7: invokespecial 544	com/tencent/mobileqq/emoticon/DownloadInfo:<init>	(Ljava/lang/String;Ljava/io/File;I)V
    //   10: astore 11
    //   12: new 187	java/net/URL
    //   15: dup
    //   16: aload 11
    //   18: getfield 191	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   21: invokespecial 194	java/net/URL:<init>	(Ljava/lang/String;)V
    //   24: pop
    //   25: aload 11
    //   27: getfield 191	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   30: astore 9
    //   32: new 241	org/apache/http/client/methods/HttpGet
    //   35: dup
    //   36: aload 9
    //   38: invokespecial 242	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   41: pop
    //   42: new 4	java/lang/Object
    //   45: dup
    //   46: invokespecial 163	java/lang/Object:<init>	()V
    //   49: astore 12
    //   51: iconst_0
    //   52: istore 14
    //   54: ldc2_w 425
    //   57: lstore 17
    //   59: aconst_null
    //   60: astore 5
    //   62: invokestatic 474	com/tencent/mobileqq/msf/sdk/AppNetConnInfo:getRecentNetworkInfo	()Landroid/net/NetworkInfo;
    //   65: astore 13
    //   67: aload 13
    //   69: ifnonnull +196 -> 265
    //   72: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   75: ifeq +12 -> 87
    //   78: ldc 20
    //   80: iconst_2
    //   81: ldc_w 546
    //   84: invokestatic 456	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   87: aload 11
    //   89: iconst_1
    //   90: putfield 466	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   93: iload 14
    //   95: iconst_1
    //   96: iadd
    //   97: istore 14
    //   99: iload 14
    //   101: iload_3
    //   102: if_icmplt +133 -> 235
    //   105: aload_1
    //   106: ifnull +12 -> 118
    //   109: aload_1
    //   110: aload 11
    //   112: invokeinterface 551 2 0
    //   117: pop
    //   118: aload 11
    //   120: areturn
    //   121: astore_0
    //   122: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   125: ifeq +13 -> 138
    //   128: ldc 20
    //   130: iconst_2
    //   131: aload_0
    //   132: invokevirtual 552	java/net/MalformedURLException:toString	()Ljava/lang/String;
    //   135: invokestatic 456	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   138: aload 11
    //   140: aload_0
    //   141: invokestatic 237	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   144: putfield 239	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   147: aload 11
    //   149: bipush 13
    //   151: putfield 466	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   154: aload_1
    //   155: ifnull +12 -> 167
    //   158: aload_1
    //   159: aload 11
    //   161: invokeinterface 551 2 0
    //   166: pop
    //   167: aload 11
    //   169: areturn
    //   170: astore 5
    //   172: new 241	org/apache/http/client/methods/HttpGet
    //   175: dup
    //   176: aload 9
    //   178: invokestatic 369	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   181: invokespecial 242	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   184: pop
    //   185: aload 9
    //   187: invokestatic 369	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   190: astore 9
    //   192: goto -150 -> 42
    //   195: astore_0
    //   196: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   199: ifeq +13 -> 212
    //   202: ldc 20
    //   204: iconst_2
    //   205: aload_0
    //   206: invokevirtual 553	java/lang/IllegalArgumentException:toString	()Ljava/lang/String;
    //   209: invokestatic 456	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   212: aload 11
    //   214: bipush 13
    //   216: putfield 466	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   219: aload_1
    //   220: ifnull +12 -> 232
    //   223: aload_1
    //   224: aload 11
    //   226: invokeinterface 551 2 0
    //   231: pop
    //   232: aload 11
    //   234: areturn
    //   235: aload 12
    //   237: monitorenter
    //   238: aload 12
    //   240: lload 17
    //   242: invokevirtual 430	java/lang/Object:wait	(J)V
    //   245: lload 17
    //   247: ldc2_w 554
    //   250: lmul
    //   251: lstore 17
    //   253: aload 12
    //   255: monitorexit
    //   256: goto +1701 -> 1957
    //   259: astore_0
    //   260: aload 12
    //   262: monitorexit
    //   263: aload_0
    //   264: athrow
    //   265: aconst_null
    //   266: astore 10
    //   268: iconst_m1
    //   269: istore 15
    //   271: aload 13
    //   273: ifnull +41 -> 314
    //   276: aload 5
    //   278: astore 6
    //   280: aload 5
    //   282: astore 7
    //   284: aload 5
    //   286: astore 8
    //   288: aload 13
    //   290: invokevirtual 272	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   293: astore 10
    //   295: aload 5
    //   297: astore 6
    //   299: aload 5
    //   301: astore 7
    //   303: aload 5
    //   305: astore 8
    //   307: aload 13
    //   309: invokevirtual 558	android/net/NetworkInfo:getType	()I
    //   312: istore 15
    //   314: aload 5
    //   316: astore 6
    //   318: aload 5
    //   320: astore 7
    //   322: aload 5
    //   324: astore 8
    //   326: invokestatic 263	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   329: astore 13
    //   331: aload 5
    //   333: astore 6
    //   335: aload 5
    //   337: astore 7
    //   339: aload 5
    //   341: astore 8
    //   343: invokestatic 267	android/net/Proxy:getDefaultPort	()I
    //   346: istore 16
    //   348: aload 5
    //   350: astore 6
    //   352: aload 5
    //   354: astore 7
    //   356: aload 5
    //   358: astore 8
    //   360: aload 10
    //   362: invokestatic 562	com/tencent/mobileqq/utils/httputils/PkgTools:f	(Ljava/lang/String;)Ljava/lang/String;
    //   365: astore 10
    //   367: aload 5
    //   369: astore 6
    //   371: aload 5
    //   373: astore 7
    //   375: aload 5
    //   377: astore 8
    //   379: aload 10
    //   381: getstatic 563	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   384: invokevirtual 567	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   387: ifne +65 -> 452
    //   390: aload 5
    //   392: astore 6
    //   394: aload 5
    //   396: astore 7
    //   398: aload 5
    //   400: astore 8
    //   402: aload 10
    //   404: putstatic 563	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   407: iload 15
    //   409: iconst_1
    //   410: if_icmpeq +26 -> 436
    //   413: aload 5
    //   415: astore 6
    //   417: aload 5
    //   419: astore 7
    //   421: aload 5
    //   423: astore 8
    //   425: aload 10
    //   427: getstatic 569	com/tencent/mobileqq/utils/httputils/PkgTools:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   430: invokevirtual 567	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   433: ifeq +546 -> 979
    //   436: aload 5
    //   438: astore 6
    //   440: aload 5
    //   442: astore 7
    //   444: aload 5
    //   446: astore 8
    //   448: iconst_0
    //   449: putstatic 571	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_a_of_type_Boolean	Z
    //   452: iload 15
    //   454: iconst_1
    //   455: if_icmpne +65 -> 520
    //   458: aload 5
    //   460: astore 6
    //   462: aload 5
    //   464: astore 7
    //   466: aload 5
    //   468: astore 8
    //   470: ldc_w 573
    //   473: aload 13
    //   475: invokevirtual 567	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   478: ifne +26 -> 504
    //   481: aload 5
    //   483: astore 6
    //   485: aload 5
    //   487: astore 7
    //   489: aload 5
    //   491: astore 8
    //   493: ldc_w 575
    //   496: aload 13
    //   498: invokevirtual 567	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   501: ifeq +19 -> 520
    //   504: aload 5
    //   506: astore 6
    //   508: aload 5
    //   510: astore 7
    //   512: aload 5
    //   514: astore 8
    //   516: iconst_1
    //   517: putstatic 571	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_a_of_type_Boolean	Z
    //   520: aload 5
    //   522: astore 6
    //   524: aload 5
    //   526: astore 7
    //   528: aload 5
    //   530: astore 8
    //   532: getstatic 571	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_a_of_type_Boolean	Z
    //   535: ifne +680 -> 1215
    //   538: aload 13
    //   540: ifnull +675 -> 1215
    //   543: iload 16
    //   545: ifle +670 -> 1215
    //   548: aload 5
    //   550: astore 6
    //   552: aload 5
    //   554: astore 7
    //   556: aload 5
    //   558: astore 8
    //   560: aload 10
    //   562: getstatic 569	com/tencent/mobileqq/utils/httputils/PkgTools:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   565: invokevirtual 567	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   568: ifne +49 -> 617
    //   571: aload 5
    //   573: astore 6
    //   575: aload 5
    //   577: astore 7
    //   579: aload 5
    //   581: astore 8
    //   583: aload 10
    //   585: getstatic 577	com/tencent/mobileqq/utils/httputils/PkgTools:f	Ljava/lang/String;
    //   588: invokevirtual 567	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   591: ifne +26 -> 617
    //   594: aload 5
    //   596: astore 6
    //   598: aload 5
    //   600: astore 7
    //   602: aload 5
    //   604: astore 8
    //   606: aload 10
    //   608: getstatic 579	com/tencent/mobileqq/utils/httputils/PkgTools:h	Ljava/lang/String;
    //   611: invokevirtual 567	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   614: ifeq +526 -> 1140
    //   617: aload 5
    //   619: astore 6
    //   621: aload 5
    //   623: astore 7
    //   625: aload 5
    //   627: astore 8
    //   629: aload 9
    //   631: aload 13
    //   633: iload 16
    //   635: invokestatic 582	com/tencent/mobileqq/utils/httputils/PkgTools:b	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
    //   638: astore 5
    //   640: aload 5
    //   642: astore 6
    //   644: aload 5
    //   646: astore 7
    //   648: aload 5
    //   650: astore 8
    //   652: aload 11
    //   654: aload 5
    //   656: putfield 585	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_a_of_type_JavaNetHttpURLConnection	Ljava/net/HttpURLConnection;
    //   659: aload_2
    //   660: ifnull +590 -> 1250
    //   663: aload 5
    //   665: astore 6
    //   667: aload 5
    //   669: astore 7
    //   671: aload 5
    //   673: astore 8
    //   675: aload_2
    //   676: invokeinterface 590 1 0
    //   681: ifne +569 -> 1250
    //   684: aload 5
    //   686: astore 6
    //   688: aload 5
    //   690: astore 7
    //   692: aload 5
    //   694: astore 8
    //   696: aload_2
    //   697: invokeinterface 594 1 0
    //   702: astore 10
    //   704: aload 5
    //   706: astore 6
    //   708: aload 5
    //   710: astore 7
    //   712: aload 5
    //   714: astore 8
    //   716: aload 10
    //   718: invokeinterface 599 1 0
    //   723: ifeq +527 -> 1250
    //   726: aload 5
    //   728: astore 6
    //   730: aload 5
    //   732: astore 7
    //   734: aload 5
    //   736: astore 8
    //   738: aload 10
    //   740: invokeinterface 603 1 0
    //   745: checkcast 605	org/apache/http/Header
    //   748: astore 13
    //   750: aload 5
    //   752: astore 6
    //   754: aload 5
    //   756: astore 7
    //   758: aload 5
    //   760: astore 8
    //   762: aload 5
    //   764: aload 13
    //   766: invokeinterface 608 1 0
    //   771: aload 13
    //   773: invokeinterface 611 1 0
    //   778: invokevirtual 617	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   781: goto -77 -> 704
    //   784: astore 5
    //   786: aload 6
    //   788: astore 8
    //   790: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   793: ifeq +12 -> 805
    //   796: aload 6
    //   798: astore 8
    //   800: aload 5
    //   802: invokevirtual 443	java/io/IOException:printStackTrace	()V
    //   805: iconst_5
    //   806: istore 15
    //   808: aload 6
    //   810: astore 8
    //   812: aload 5
    //   814: instanceof 445
    //   817: ifeq +1009 -> 1826
    //   820: bipush 10
    //   822: istore 15
    //   824: iload_3
    //   825: istore 14
    //   827: aload 6
    //   829: astore 8
    //   831: aload 11
    //   833: iload 15
    //   835: putfield 466	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   838: aload 6
    //   840: astore 8
    //   842: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   845: ifeq +76 -> 921
    //   848: aload 6
    //   850: astore 8
    //   852: ldc 20
    //   854: iconst_2
    //   855: new 220	java/lang/StringBuilder
    //   858: dup
    //   859: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   862: ldc_w 619
    //   865: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   868: iload 15
    //   870: invokevirtual 422	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   873: ldc_w 621
    //   876: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   879: aload 11
    //   881: getfield 623	com/tencent/mobileqq/emoticon/DownloadInfo:c	I
    //   884: invokevirtual 422	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   887: ldc_w 449
    //   890: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   893: aload 11
    //   895: getfield 191	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   898: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   901: ldc_w 625
    //   904: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   907: aload 5
    //   909: invokevirtual 626	java/io/IOException:toString	()Ljava/lang/String;
    //   912: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   915: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   918: invokestatic 456	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   921: iload 14
    //   923: istore 15
    //   925: aload 6
    //   927: astore 8
    //   929: aload 6
    //   931: ifnull +1015 -> 1946
    //   934: aload 6
    //   936: invokevirtual 629	java/net/HttpURLConnection:disconnect	()V
    //   939: aload 6
    //   941: astore 5
    //   943: iload 14
    //   945: iconst_1
    //   946: iadd
    //   947: istore 14
    //   949: iload 14
    //   951: iload_3
    //   952: if_icmpge +965 -> 1917
    //   955: aload 12
    //   957: monitorenter
    //   958: aload 12
    //   960: lload 17
    //   962: invokevirtual 430	java/lang/Object:wait	(J)V
    //   965: lload 17
    //   967: ldc2_w 554
    //   970: lmul
    //   971: lstore 17
    //   973: aload 12
    //   975: monitorexit
    //   976: goto +981 -> 1957
    //   979: aload 5
    //   981: astore 6
    //   983: aload 5
    //   985: astore 7
    //   987: aload 5
    //   989: astore 8
    //   991: iconst_1
    //   992: putstatic 571	com/tencent/mobileqq/utils/HttpDownloadUtil:jdField_a_of_type_Boolean	Z
    //   995: goto -543 -> 452
    //   998: astore 5
    //   1000: aload 7
    //   1002: astore 8
    //   1004: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1007: ifeq +12 -> 1019
    //   1010: aload 7
    //   1012: astore 8
    //   1014: aload 5
    //   1016: invokevirtual 467	java/lang/Exception:printStackTrace	()V
    //   1019: aload 7
    //   1021: astore 8
    //   1023: aload 11
    //   1025: iconst_5
    //   1026: putfield 466	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   1029: aload 7
    //   1031: astore 8
    //   1033: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1036: ifeq +79 -> 1115
    //   1039: aload 7
    //   1041: astore 8
    //   1043: ldc 20
    //   1045: iconst_2
    //   1046: new 220	java/lang/StringBuilder
    //   1049: dup
    //   1050: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   1053: ldc_w 619
    //   1056: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1059: aload 11
    //   1061: getfield 466	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   1064: invokevirtual 422	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1067: ldc_w 631
    //   1070: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1073: aload 11
    //   1075: getfield 623	com/tencent/mobileqq/emoticon/DownloadInfo:c	I
    //   1078: invokevirtual 422	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1081: ldc_w 449
    //   1084: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1087: aload 11
    //   1089: getfield 191	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1092: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1095: ldc_w 451
    //   1098: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1101: aload 5
    //   1103: invokevirtual 632	java/lang/Exception:toString	()Ljava/lang/String;
    //   1106: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1109: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1112: invokestatic 456	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1115: iload 14
    //   1117: istore 15
    //   1119: aload 7
    //   1121: astore 8
    //   1123: aload 7
    //   1125: ifnull +821 -> 1946
    //   1128: aload 7
    //   1130: invokevirtual 629	java/net/HttpURLConnection:disconnect	()V
    //   1133: aload 7
    //   1135: astore 5
    //   1137: goto -194 -> 943
    //   1140: aload 5
    //   1142: astore 6
    //   1144: aload 5
    //   1146: astore 7
    //   1148: aload 5
    //   1150: astore 8
    //   1152: aload 10
    //   1154: getstatic 633	com/tencent/mobileqq/utils/httputils/PkgTools:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1157: invokevirtual 567	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1160: ifeq +29 -> 1189
    //   1163: aload 5
    //   1165: astore 6
    //   1167: aload 5
    //   1169: astore 7
    //   1171: aload 5
    //   1173: astore 8
    //   1175: aload 9
    //   1177: aload 13
    //   1179: iload 16
    //   1181: invokestatic 635	com/tencent/mobileqq/utils/httputils/PkgTools:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
    //   1184: astore 5
    //   1186: goto -546 -> 640
    //   1189: aload 5
    //   1191: astore 6
    //   1193: aload 5
    //   1195: astore 7
    //   1197: aload 5
    //   1199: astore 8
    //   1201: aload 9
    //   1203: aload 13
    //   1205: iload 16
    //   1207: invokestatic 635	com/tencent/mobileqq/utils/httputils/PkgTools:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
    //   1210: astore 5
    //   1212: goto -572 -> 640
    //   1215: aload 5
    //   1217: astore 6
    //   1219: aload 5
    //   1221: astore 7
    //   1223: aload 5
    //   1225: astore 8
    //   1227: new 187	java/net/URL
    //   1230: dup
    //   1231: aload 9
    //   1233: invokespecial 194	java/net/URL:<init>	(Ljava/lang/String;)V
    //   1236: getstatic 641	java/net/Proxy:NO_PROXY	Ljava/net/Proxy;
    //   1239: invokevirtual 645	java/net/URL:openConnection	(Ljava/net/Proxy;)Ljava/net/URLConnection;
    //   1242: checkcast 613	java/net/HttpURLConnection
    //   1245: astore 5
    //   1247: goto -607 -> 640
    //   1250: aload 5
    //   1252: astore 6
    //   1254: aload 5
    //   1256: astore 7
    //   1258: aload 5
    //   1260: astore 8
    //   1262: aload 5
    //   1264: ldc_w 647
    //   1267: ldc_w 649
    //   1270: invokevirtual 652	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1273: aload 5
    //   1275: astore 6
    //   1277: aload 5
    //   1279: astore 7
    //   1281: aload 5
    //   1283: astore 8
    //   1285: invokestatic 657	com/tencent/mobileqq/transfile/NetworkCenter:a	()Lcom/tencent/mobileqq/transfile/NetworkCenter;
    //   1288: invokevirtual 659	com/tencent/mobileqq/transfile/NetworkCenter:a	()I
    //   1291: istore 15
    //   1293: aload 5
    //   1295: astore 6
    //   1297: aload 5
    //   1299: astore 7
    //   1301: aload 5
    //   1303: astore 8
    //   1305: aload 5
    //   1307: iload 15
    //   1309: invokestatic 664	com/tencent/mobileqq/utils/HttpDownloadUtil$TimeoutParam:b	(I)I
    //   1312: invokevirtual 668	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   1315: aload 5
    //   1317: astore 6
    //   1319: aload 5
    //   1321: astore 7
    //   1323: aload 5
    //   1325: astore 8
    //   1327: aload 5
    //   1329: iload 15
    //   1331: invokestatic 670	com/tencent/mobileqq/utils/HttpDownloadUtil$TimeoutParam:a	(I)I
    //   1334: invokevirtual 673	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   1337: aload 5
    //   1339: astore 6
    //   1341: aload 5
    //   1343: astore 7
    //   1345: aload 5
    //   1347: astore 8
    //   1349: aload 5
    //   1351: iconst_1
    //   1352: invokevirtual 677	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   1355: aload 5
    //   1357: astore 6
    //   1359: aload 5
    //   1361: astore 7
    //   1363: aload 5
    //   1365: astore 8
    //   1367: aload 5
    //   1369: invokevirtual 680	java/net/HttpURLConnection:connect	()V
    //   1372: aload 5
    //   1374: astore 6
    //   1376: aload 5
    //   1378: astore 7
    //   1380: aload 5
    //   1382: astore 8
    //   1384: aload 11
    //   1386: aload 5
    //   1388: invokevirtual 683	java/net/HttpURLConnection:getResponseCode	()I
    //   1391: putfield 623	com/tencent/mobileqq/emoticon/DownloadInfo:c	I
    //   1394: aload 5
    //   1396: astore 6
    //   1398: aload 5
    //   1400: astore 7
    //   1402: aload 5
    //   1404: astore 8
    //   1406: aload 11
    //   1408: aload 5
    //   1410: invokevirtual 685	java/net/HttpURLConnection:getContentLength	()I
    //   1413: putfield 687	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_e_of_type_Int	I
    //   1416: aload 5
    //   1418: astore 6
    //   1420: aload 5
    //   1422: astore 7
    //   1424: aload 5
    //   1426: astore 8
    //   1428: aload 11
    //   1430: aload 5
    //   1432: invokevirtual 690	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   1435: putfield 692	com/tencent/mobileqq/emoticon/DownloadInfo:i	Ljava/lang/String;
    //   1438: aload 5
    //   1440: astore 6
    //   1442: aload 5
    //   1444: astore 7
    //   1446: aload 5
    //   1448: astore 8
    //   1450: aload 11
    //   1452: aload 5
    //   1454: invokevirtual 695	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   1457: putfield 697	com/tencent/mobileqq/emoticon/DownloadInfo:j	Ljava/lang/String;
    //   1460: aload 5
    //   1462: astore 6
    //   1464: aload 5
    //   1466: astore 7
    //   1468: aload 5
    //   1470: astore 8
    //   1472: invokestatic 180	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1475: ifeq +83 -> 1558
    //   1478: aload 5
    //   1480: astore 6
    //   1482: aload 5
    //   1484: astore 7
    //   1486: aload 5
    //   1488: astore 8
    //   1490: ldc 20
    //   1492: iconst_2
    //   1493: new 220	java/lang/StringBuilder
    //   1496: dup
    //   1497: invokespecial 221	java/lang/StringBuilder:<init>	()V
    //   1500: ldc_w 699
    //   1503: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1506: aload_0
    //   1507: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1510: ldc_w 701
    //   1513: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1516: aload 11
    //   1518: getfield 623	com/tencent/mobileqq/emoticon/DownloadInfo:c	I
    //   1521: invokevirtual 422	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1524: ldc_w 703
    //   1527: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1530: aload 11
    //   1532: getfield 687	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_e_of_type_Int	I
    //   1535: invokevirtual 422	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1538: ldc_w 705
    //   1541: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1544: aload 11
    //   1546: getfield 692	com/tencent/mobileqq/emoticon/DownloadInfo:i	Ljava/lang/String;
    //   1549: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1552: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1555: invokestatic 406	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1558: iload 4
    //   1560: ifeq +59 -> 1619
    //   1563: aload 5
    //   1565: astore 6
    //   1567: aload 5
    //   1569: astore 7
    //   1571: aload 5
    //   1573: astore 8
    //   1575: aload 11
    //   1577: iconst_0
    //   1578: putfield 466	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   1581: aload_1
    //   1582: ifnull +24 -> 1606
    //   1585: aload 5
    //   1587: astore 6
    //   1589: aload 5
    //   1591: astore 7
    //   1593: aload 5
    //   1595: astore 8
    //   1597: aload_1
    //   1598: aload 11
    //   1600: invokeinterface 551 2 0
    //   1605: pop
    //   1606: aload 5
    //   1608: ifnull +8 -> 1616
    //   1611: aload 5
    //   1613: invokevirtual 629	java/net/HttpURLConnection:disconnect	()V
    //   1616: aload 11
    //   1618: areturn
    //   1619: aload 5
    //   1621: astore 6
    //   1623: aload 5
    //   1625: astore 7
    //   1627: aload 5
    //   1629: astore 8
    //   1631: aload 11
    //   1633: getfield 623	com/tencent/mobileqq/emoticon/DownloadInfo:c	I
    //   1636: sipush 200
    //   1639: if_icmpne +149 -> 1788
    //   1642: aload_1
    //   1643: ifnull +114 -> 1757
    //   1646: aload 5
    //   1648: astore 6
    //   1650: aload 5
    //   1652: astore 7
    //   1654: aload 5
    //   1656: astore 8
    //   1658: aload 11
    //   1660: iconst_0
    //   1661: putfield 466	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   1664: aload 5
    //   1666: astore 6
    //   1668: aload 5
    //   1670: astore 7
    //   1672: aload 5
    //   1674: astore 8
    //   1676: aload_1
    //   1677: aload 11
    //   1679: invokeinterface 551 2 0
    //   1684: ifeq +34 -> 1718
    //   1687: aload 5
    //   1689: astore 6
    //   1691: aload 5
    //   1693: astore 7
    //   1695: aload 5
    //   1697: astore 8
    //   1699: aload 11
    //   1701: iconst_0
    //   1702: putfield 466	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   1705: aload 5
    //   1707: ifnull +8 -> 1715
    //   1710: aload 5
    //   1712: invokevirtual 629	java/net/HttpURLConnection:disconnect	()V
    //   1715: aload 11
    //   1717: areturn
    //   1718: aload 5
    //   1720: astore 6
    //   1722: aload 5
    //   1724: astore 7
    //   1726: aload 5
    //   1728: astore 8
    //   1730: aload 11
    //   1732: iconst_4
    //   1733: putfield 466	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   1736: iload 14
    //   1738: istore 15
    //   1740: aload 5
    //   1742: astore 8
    //   1744: aload 5
    //   1746: ifnull +200 -> 1946
    //   1749: aload 5
    //   1751: invokevirtual 629	java/net/HttpURLConnection:disconnect	()V
    //   1754: goto -811 -> 943
    //   1757: aload 5
    //   1759: astore 6
    //   1761: aload 5
    //   1763: astore 7
    //   1765: aload 5
    //   1767: astore 8
    //   1769: aload 11
    //   1771: iconst_0
    //   1772: putfield 466	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   1775: aload 5
    //   1777: ifnull +8 -> 1785
    //   1780: aload 5
    //   1782: invokevirtual 629	java/net/HttpURLConnection:disconnect	()V
    //   1785: aload 11
    //   1787: areturn
    //   1788: aload 5
    //   1790: astore 6
    //   1792: aload 5
    //   1794: astore 7
    //   1796: aload 5
    //   1798: astore 8
    //   1800: aload 11
    //   1802: aload 11
    //   1804: getfield 623	com/tencent/mobileqq/emoticon/DownloadInfo:c	I
    //   1807: putfield 466	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   1810: goto -74 -> 1736
    //   1813: astore_0
    //   1814: aload 8
    //   1816: ifnull +8 -> 1824
    //   1819: aload 8
    //   1821: invokevirtual 629	java/net/HttpURLConnection:disconnect	()V
    //   1824: aload_0
    //   1825: athrow
    //   1826: aload 6
    //   1828: astore 8
    //   1830: aload 5
    //   1832: instanceof 438
    //   1835: ifne +131 -> 1966
    //   1838: aload 6
    //   1840: astore 8
    //   1842: aload 5
    //   1844: instanceof 440
    //   1847: ifeq +6 -> 1853
    //   1850: goto +116 -> 1966
    //   1853: aload 6
    //   1855: astore 8
    //   1857: aload 5
    //   1859: instanceof 464
    //   1862: ifeq +17 -> 1879
    //   1865: aload 6
    //   1867: astore 8
    //   1869: aload 11
    //   1871: bipush 11
    //   1873: putfield 466	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   1876: goto -1049 -> 827
    //   1879: aload 6
    //   1881: astore 8
    //   1883: aload 5
    //   1885: instanceof 166
    //   1888: istore 19
    //   1890: iload 19
    //   1892: ifeq +13 -> 1905
    //   1895: bipush 13
    //   1897: istore 15
    //   1899: iload_3
    //   1900: istore 14
    //   1902: goto -1075 -> 827
    //   1905: iconst_4
    //   1906: istore 15
    //   1908: goto -1081 -> 827
    //   1911: astore_0
    //   1912: aload 12
    //   1914: monitorexit
    //   1915: aload_0
    //   1916: athrow
    //   1917: aload_1
    //   1918: ifnull +12 -> 1930
    //   1921: aload_1
    //   1922: aload 11
    //   1924: invokeinterface 551 2 0
    //   1929: pop
    //   1930: goto +27 -> 1957
    //   1933: astore 6
    //   1935: goto -1682 -> 253
    //   1938: astore 6
    //   1940: goto -967 -> 973
    //   1943: goto -1881 -> 62
    //   1946: iload 15
    //   1948: istore 14
    //   1950: aload 8
    //   1952: astore 5
    //   1954: goto -1011 -> 943
    //   1957: iload 14
    //   1959: iload_3
    //   1960: if_icmplt -17 -> 1943
    //   1963: aload 11
    //   1965: areturn
    //   1966: iconst_2
    //   1967: istore 15
    //   1969: goto -1142 -> 827
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1972	0	paramString	String
    //   0	1972	1	paramDownloadInfoListener	HttpDownloadUtil.DownloadInfoListener
    //   0	1972	2	paramList	java.util.List
    //   0	1972	3	paramInt	int
    //   0	1972	4	paramBoolean	boolean
    //   60	1	5	localObject1	Object
    //   170	456	5	localIllegalArgumentException	IllegalArgumentException
    //   638	125	5	localHttpURLConnection	java.net.HttpURLConnection
    //   784	124	5	localIOException	java.io.IOException
    //   941	47	5	localObject2	Object
    //   998	104	5	localException	Exception
    //   1135	818	5	localObject3	Object
    //   278	1602	6	localObject4	Object
    //   1933	1	6	localInterruptedException1	InterruptedException
    //   1938	1	6	localInterruptedException2	InterruptedException
    //   282	1513	7	localObject5	Object
    //   286	1665	8	localObject6	Object
    //   30	1202	9	str	String
    //   266	887	10	localObject7	Object
    //   10	1954	11	localDownloadInfo	DownloadInfo
    //   49	1864	12	localObject8	Object
    //   65	1139	13	localObject9	Object
    //   52	1909	14	i1	int
    //   269	1699	15	i2	int
    //   346	860	16	i3	int
    //   57	915	17	l1	long
    //   1888	3	19	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   12	25	121	java/net/MalformedURLException
    //   32	42	170	java/lang/IllegalArgumentException
    //   172	192	195	java/lang/IllegalArgumentException
    //   238	245	259	finally
    //   253	256	259	finally
    //   260	263	259	finally
    //   288	295	784	java/io/IOException
    //   307	314	784	java/io/IOException
    //   326	331	784	java/io/IOException
    //   343	348	784	java/io/IOException
    //   360	367	784	java/io/IOException
    //   379	390	784	java/io/IOException
    //   402	407	784	java/io/IOException
    //   425	436	784	java/io/IOException
    //   448	452	784	java/io/IOException
    //   470	481	784	java/io/IOException
    //   493	504	784	java/io/IOException
    //   516	520	784	java/io/IOException
    //   532	538	784	java/io/IOException
    //   560	571	784	java/io/IOException
    //   583	594	784	java/io/IOException
    //   606	617	784	java/io/IOException
    //   629	640	784	java/io/IOException
    //   652	659	784	java/io/IOException
    //   675	684	784	java/io/IOException
    //   696	704	784	java/io/IOException
    //   716	726	784	java/io/IOException
    //   738	750	784	java/io/IOException
    //   762	781	784	java/io/IOException
    //   991	995	784	java/io/IOException
    //   1152	1163	784	java/io/IOException
    //   1175	1186	784	java/io/IOException
    //   1201	1212	784	java/io/IOException
    //   1227	1247	784	java/io/IOException
    //   1262	1273	784	java/io/IOException
    //   1285	1293	784	java/io/IOException
    //   1305	1315	784	java/io/IOException
    //   1327	1337	784	java/io/IOException
    //   1349	1355	784	java/io/IOException
    //   1367	1372	784	java/io/IOException
    //   1384	1394	784	java/io/IOException
    //   1406	1416	784	java/io/IOException
    //   1428	1438	784	java/io/IOException
    //   1450	1460	784	java/io/IOException
    //   1472	1478	784	java/io/IOException
    //   1490	1558	784	java/io/IOException
    //   1575	1581	784	java/io/IOException
    //   1597	1606	784	java/io/IOException
    //   1631	1642	784	java/io/IOException
    //   1658	1664	784	java/io/IOException
    //   1676	1687	784	java/io/IOException
    //   1699	1705	784	java/io/IOException
    //   1730	1736	784	java/io/IOException
    //   1769	1775	784	java/io/IOException
    //   1800	1810	784	java/io/IOException
    //   288	295	998	java/lang/Exception
    //   307	314	998	java/lang/Exception
    //   326	331	998	java/lang/Exception
    //   343	348	998	java/lang/Exception
    //   360	367	998	java/lang/Exception
    //   379	390	998	java/lang/Exception
    //   402	407	998	java/lang/Exception
    //   425	436	998	java/lang/Exception
    //   448	452	998	java/lang/Exception
    //   470	481	998	java/lang/Exception
    //   493	504	998	java/lang/Exception
    //   516	520	998	java/lang/Exception
    //   532	538	998	java/lang/Exception
    //   560	571	998	java/lang/Exception
    //   583	594	998	java/lang/Exception
    //   606	617	998	java/lang/Exception
    //   629	640	998	java/lang/Exception
    //   652	659	998	java/lang/Exception
    //   675	684	998	java/lang/Exception
    //   696	704	998	java/lang/Exception
    //   716	726	998	java/lang/Exception
    //   738	750	998	java/lang/Exception
    //   762	781	998	java/lang/Exception
    //   991	995	998	java/lang/Exception
    //   1152	1163	998	java/lang/Exception
    //   1175	1186	998	java/lang/Exception
    //   1201	1212	998	java/lang/Exception
    //   1227	1247	998	java/lang/Exception
    //   1262	1273	998	java/lang/Exception
    //   1285	1293	998	java/lang/Exception
    //   1305	1315	998	java/lang/Exception
    //   1327	1337	998	java/lang/Exception
    //   1349	1355	998	java/lang/Exception
    //   1367	1372	998	java/lang/Exception
    //   1384	1394	998	java/lang/Exception
    //   1406	1416	998	java/lang/Exception
    //   1428	1438	998	java/lang/Exception
    //   1450	1460	998	java/lang/Exception
    //   1472	1478	998	java/lang/Exception
    //   1490	1558	998	java/lang/Exception
    //   1575	1581	998	java/lang/Exception
    //   1597	1606	998	java/lang/Exception
    //   1631	1642	998	java/lang/Exception
    //   1658	1664	998	java/lang/Exception
    //   1676	1687	998	java/lang/Exception
    //   1699	1705	998	java/lang/Exception
    //   1730	1736	998	java/lang/Exception
    //   1769	1775	998	java/lang/Exception
    //   1800	1810	998	java/lang/Exception
    //   288	295	1813	finally
    //   307	314	1813	finally
    //   326	331	1813	finally
    //   343	348	1813	finally
    //   360	367	1813	finally
    //   379	390	1813	finally
    //   402	407	1813	finally
    //   425	436	1813	finally
    //   448	452	1813	finally
    //   470	481	1813	finally
    //   493	504	1813	finally
    //   516	520	1813	finally
    //   532	538	1813	finally
    //   560	571	1813	finally
    //   583	594	1813	finally
    //   606	617	1813	finally
    //   629	640	1813	finally
    //   652	659	1813	finally
    //   675	684	1813	finally
    //   696	704	1813	finally
    //   716	726	1813	finally
    //   738	750	1813	finally
    //   762	781	1813	finally
    //   790	796	1813	finally
    //   800	805	1813	finally
    //   812	820	1813	finally
    //   831	838	1813	finally
    //   842	848	1813	finally
    //   852	921	1813	finally
    //   991	995	1813	finally
    //   1004	1010	1813	finally
    //   1014	1019	1813	finally
    //   1023	1029	1813	finally
    //   1033	1039	1813	finally
    //   1043	1115	1813	finally
    //   1152	1163	1813	finally
    //   1175	1186	1813	finally
    //   1201	1212	1813	finally
    //   1227	1247	1813	finally
    //   1262	1273	1813	finally
    //   1285	1293	1813	finally
    //   1305	1315	1813	finally
    //   1327	1337	1813	finally
    //   1349	1355	1813	finally
    //   1367	1372	1813	finally
    //   1384	1394	1813	finally
    //   1406	1416	1813	finally
    //   1428	1438	1813	finally
    //   1450	1460	1813	finally
    //   1472	1478	1813	finally
    //   1490	1558	1813	finally
    //   1575	1581	1813	finally
    //   1597	1606	1813	finally
    //   1631	1642	1813	finally
    //   1658	1664	1813	finally
    //   1676	1687	1813	finally
    //   1699	1705	1813	finally
    //   1730	1736	1813	finally
    //   1769	1775	1813	finally
    //   1800	1810	1813	finally
    //   1830	1838	1813	finally
    //   1842	1850	1813	finally
    //   1857	1865	1813	finally
    //   1869	1876	1813	finally
    //   1883	1890	1813	finally
    //   958	965	1911	finally
    //   973	976	1911	finally
    //   1912	1915	1911	finally
    //   238	245	1933	java/lang/InterruptedException
    //   958	965	1938	java/lang/InterruptedException
  }
  
  public static String a(String paramString)
  {
    return paramString.replaceAll("\\{", "%7B").replaceAll("\\}", "%7D").replaceAll("\\|", "%7C");
  }
  
  public static void a(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo == null) || (paramDownloadInfo.jdField_a_of_type_JavaLangString == null) || (paramDownloadInfo.jdField_a_of_type_JavaLangString.length() == 0)) {}
    label257:
    label312:
    do
    {
      do
      {
        int i1;
        int i2;
        String str1;
        do
        {
          return;
          i1 = "http://".length();
          i2 = paramDownloadInfo.jdField_a_of_type_JavaLangString.indexOf("/", i1);
          str1 = paramDownloadInfo.jdField_a_of_type_JavaLangString.substring(i1, i2);
        } while ((i2 <= i1) && (TextUtils.isEmpty(str1)));
        if ("imgcache.qq.com".equalsIgnoreCase(str1)) {
          i1 = 12;
        }
        for (;;)
        {
          String str2 = FMTSrvAddrProvider.a().b(i1);
          if ((str2 == null) || (str2.length() <= 0)) {
            break label312;
          }
          str2 = paramDownloadInfo.jdField_a_of_type_JavaLangString.replaceFirst("http://[^/\\s]*/", str2);
          paramDownloadInfo.jdField_d_of_type_JavaLangString = str1;
          paramDownloadInfo.jdField_b_of_type_JavaLangString = str2;
          paramDownloadInfo.jdField_a_of_type_Boolean = true;
          paramDownloadInfo.jdField_d_of_type_Int = i1;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.emoji.EmoDown", 2, "replaceDomainWithIp " + paramDownloadInfo.jdField_a_of_type_Boolean + " url[" + paramDownloadInfo.jdField_a_of_type_JavaLangString + "] resetIP[" + str2 + "] host[" + paramDownloadInfo.jdField_d_of_type_JavaLangString + "]");
          return;
          if ("imgcache.gtimg.cn".equalsIgnoreCase(str1))
          {
            i1 = 13;
          }
          else if ("i.gtimg.cn".equalsIgnoreCase(str1))
          {
            i1 = 14;
          }
          else
          {
            if (!"cmshow.gtimg.cn".equalsIgnoreCase(str1)) {
              break label257;
            }
            i1 = 17;
          }
        }
        paramDownloadInfo.jdField_d_of_type_JavaLangString = null;
        paramDownloadInfo.jdField_b_of_type_JavaLangString = paramDownloadInfo.jdField_a_of_type_JavaLangString;
        paramDownloadInfo.jdField_a_of_type_Boolean = false;
      } while (!QLog.isColorLevel());
      QLog.d("Q.emoji.EmoDown", 2, "unknow domain url=" + paramDownloadInfo.jdField_a_of_type_Boolean);
      return;
      paramDownloadInfo.jdField_d_of_type_JavaLangString = null;
      paramDownloadInfo.jdField_b_of_type_JavaLangString = paramDownloadInfo.jdField_a_of_type_JavaLangString;
      paramDownloadInfo.jdField_a_of_type_Boolean = false;
    } while (!QLog.isColorLevel());
    QLog.d("Q.emoji.EmoDown", 2, "replaceDomainWithIp false.url[" + paramDownloadInfo.jdField_b_of_type_JavaLangString + "]");
  }
  
  public static boolean a(AppInterface paramAppInterface, String paramString, File paramFile)
  {
    return a(paramAppInterface, paramString, paramFile) == 0;
  }
  
  public static boolean a(AppInterface paramAppInterface, URL paramURL, File paramFile)
  {
    return a(paramAppInterface, paramURL, paramFile, AppNetConnInfo.getRecentNetworkInfo(), 2) == 0;
  }
  
  private static boolean a(DownloadInfo paramDownloadInfo, int paramInt1, int paramInt2)
  {
    if (paramDownloadInfo == null) {
      if (paramInt1 > paramInt2) {}
    }
    while ((paramDownloadInfo.jdField_b_of_type_Int != 0) && (paramInt1 <= paramInt2) && (paramDownloadInfo.jdField_b_of_type_Int != 16) && (paramDownloadInfo.jdField_b_of_type_Int != 6) && (NetworkUtil.e(BaseApplication.getContext())))
    {
      return true;
      return false;
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\utils\HttpDownloadUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */