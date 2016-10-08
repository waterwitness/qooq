package com.tencent.mobileqq.log;

import android.content.Context;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import org.json.JSONObject;
import sze;

public class VipWebViewReportLog
{
  public static int a = 0;
  private static Context jdField_a_of_type_AndroidContentContext;
  public static final String a;
  static Thread jdField_a_of_type_JavaLangThread;
  public static Set a;
  public static AtomicInteger a;
  private static AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  public static NewIntent a;
  public static boolean a = false;
  public static final int b = 0;
  public static final String b;
  public static boolean b = false;
  public static final int c = 1;
  public static final String c = "config.json";
  public static final int d = 2;
  public static final String d = "url_list";
  private static int e = 0;
  public static final String e = "js_report";
  private static int f = 0;
  public static final String f = "url_check";
  private static int g;
  public static String g;
  public static String h;
  public static String i;
  public static String j;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = VipWebViewReportLog.class.getSimpleName();
    jdField_a_of_type_JavaUtilSet = new HashSet();
    e = 1;
    f = 2;
    jdField_b_of_type_JavaLangString = AppConstants.bj + "WebViewCheck" + File.separator;
    h = "null";
    i = "null";
    j = "null";
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  }
  
  public static void a()
  {
    if ((jdField_a_of_type_JavaLangThread == null) || (!jdField_a_of_type_JavaLangThread.isAlive()))
    {
      jdField_a_of_type_JavaLangThread = ThreadManager.a(new sze(), "WebviewLoadConfig", 8);
      if (QLog.isColorLevel()) {
        QLog.d("WebCoreDump", 1, "ready to load config at:" + System.currentTimeMillis());
      }
      jdField_a_of_type_JavaLangThread.start();
    }
  }
  
  public static void a(Context paramContext, AppRuntime paramAppRuntime)
  {
    if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(0, 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebCoreDump", 2, "VipWebViewReportLog init by context=" + paramContext + ", AppInterface=" + paramAppRuntime);
      }
      jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
      jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
      jdField_g_of_type_Int = e;
      a();
    }
  }
  
  private static void a(TelephonyManager paramTelephonyManager)
  {
    if (paramTelephonyManager == null) {}
    NetworkInfo localNetworkInfo;
    do
    {
      return;
      h = "null";
      i = "null";
      j = "null";
      localNetworkInfo = AppNetConnInfo.getRecentNetworkInfo();
    } while ((localNetworkInfo == null) || (!localNetworkInfo.isAvailable()));
    switch (localNetworkInfo.getType())
    {
    case 7: 
    case 8: 
    default: 
      i = "unknown";
      j = "unknown";
      return;
    case 9: 
      i = "cable";
      return;
    case 1: 
    case 6: 
      i = "WIFI";
      return;
    }
    h = paramTelephonyManager.getNetworkOperatorName();
    switch (paramTelephonyManager.getNetworkType())
    {
    default: 
      i = "2G";
      j = "unknown";
      return;
    case 13: 
      i = "4G";
      j = "LTE";
      return;
    case 3: 
      i = "3G";
      j = "UMTS";
      return;
    case 5: 
      i = "3G";
      j = "EVDO_0";
      return;
    case 6: 
      i = "3G";
      j = "EVDO_A";
      return;
    case 8: 
      i = "3G";
      j = "SDPA";
      return;
    case 9: 
      i = "3G";
      j = "HSUPA";
      return;
    case 10: 
      i = "3G";
      j = "HSPA";
      return;
    case 12: 
      i = "3G";
      j = "EVDO_B";
      return;
    case 14: 
      i = "3G";
      j = "EHRPD";
      return;
    case 15: 
      i = "3G";
      j = "HSPAP";
      return;
    case 1: 
      i = "2G";
      j = "GPRS";
      return;
    case 2: 
      i = "2G";
      j = "EDGE";
      return;
    case 4: 
      i = "2G";
      j = "CDMA";
      return;
    case 7: 
      i = "2G";
      j = "1xRTT";
      return;
    case 11: 
      i = "2G";
      j = "IDEN";
      return;
    }
    i = "2G";
    j = "unknown";
  }
  
  /* Error */
  public static void a(com.tencent.smtt.export.external.interfaces.ConsoleMessage paramConsoleMessage)
  {
    // Byte code:
    //   0: getstatic 108	com/tencent/mobileqq/log/VipWebViewReportLog:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   3: ifnonnull +4 -> 7
    //   6: return
    //   7: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10: ifne +30 -> 40
    //   13: getstatic 105	com/tencent/mobileqq/log/VipWebViewReportLog:jdField_g_of_type_Int	I
    //   16: getstatic 60	com/tencent/mobileqq/log/VipWebViewReportLog:f	I
    //   19: if_icmpne +9 -> 28
    //   22: getstatic 242	com/tencent/mobileqq/log/VipWebViewReportLog:jdField_a_of_type_Boolean	Z
    //   25: ifeq +654 -> 679
    //   28: aload_0
    //   29: invokeinterface 248 1 0
    //   34: getstatic 254	com/tencent/smtt/export/external/interfaces/ConsoleMessage$MessageLevel:ERROR	Lcom/tencent/smtt/export/external/interfaces/ConsoleMessage$MessageLevel;
    //   37: if_acmpne +642 -> 679
    //   40: new 62	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   47: ldc_w 256
    //   50: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: ldc_w 258
    //   56: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: astore_1
    //   63: new 62	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   70: aload_1
    //   71: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: ldc_w 260
    //   77: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: astore_1
    //   84: new 62	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   91: aload_1
    //   92: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: ldc_w 262
    //   98: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: astore_1
    //   105: new 62	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   112: aload_1
    //   113: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: ldc_w 264
    //   119: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: getstatic 269	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   125: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: astore_1
    //   132: getstatic 108	com/tencent/mobileqq/log/VipWebViewReportLog:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   135: invokevirtual 274	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   138: astore_2
    //   139: new 62	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   146: aload_1
    //   147: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: ldc_w 276
    //   153: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: aload_2
    //   157: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: astore_1
    //   164: aload_0
    //   165: invokeinterface 279 1 0
    //   170: ifnull +381 -> 551
    //   173: new 62	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   180: aload_1
    //   181: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: ldc_w 281
    //   187: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: aload_0
    //   191: invokeinterface 279 1 0
    //   196: invokestatic 287	java/net/URLEncoder:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   199: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: astore_1
    //   206: new 62	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   213: aload_1
    //   214: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: ldc_w 289
    //   220: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: aload_0
    //   224: invokeinterface 292 1 0
    //   229: invokestatic 298	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   232: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: astore_1
    //   239: aload_0
    //   240: invokeinterface 301 1 0
    //   245: ifnull +330 -> 575
    //   248: new 62	java/lang/StringBuilder
    //   251: dup
    //   252: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   255: aload_1
    //   256: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: ldc_w 303
    //   262: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: aload_0
    //   266: invokeinterface 301 1 0
    //   271: invokestatic 287	java/net/URLEncoder:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   274: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: astore_1
    //   281: new 62	java/lang/StringBuilder
    //   284: dup
    //   285: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   288: aload_1
    //   289: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: ldc_w 305
    //   295: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: invokestatic 141	java/lang/System:currentTimeMillis	()J
    //   301: invokevirtual 144	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   304: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   307: astore_1
    //   308: getstatic 307	com/tencent/mobileqq/log/VipWebViewReportLog:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   311: ifnull +288 -> 599
    //   314: new 62	java/lang/StringBuilder
    //   317: dup
    //   318: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   321: aload_1
    //   322: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: ldc_w 309
    //   328: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: getstatic 307	com/tencent/mobileqq/log/VipWebViewReportLog:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   334: invokestatic 287	java/net/URLEncoder:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   337: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: astore_1
    //   344: aload_0
    //   345: invokeinterface 248 1 0
    //   350: ifnull +273 -> 623
    //   353: new 62	java/lang/StringBuilder
    //   356: dup
    //   357: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   360: aload_1
    //   361: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: ldc_w 311
    //   367: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: aload_0
    //   371: invokeinterface 248 1 0
    //   376: invokevirtual 312	com/tencent/smtt/export/external/interfaces/ConsoleMessage$MessageLevel:toString	()Ljava/lang/String;
    //   379: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   385: astore_0
    //   386: new 62	java/lang/StringBuilder
    //   389: dup
    //   390: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   393: aload_0
    //   394: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: ldc_w 314
    //   400: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: getstatic 319	android/os/Build:MODEL	Ljava/lang/String;
    //   406: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   412: astore_0
    //   413: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   416: ifeq +231 -> 647
    //   419: new 62	java/lang/StringBuilder
    //   422: dup
    //   423: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   426: aload_0
    //   427: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: ldc_w 321
    //   433: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   439: astore_0
    //   440: getstatic 170	com/tencent/mobileqq/log/VipWebViewReportLog:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   443: ldc_w 323
    //   446: invokevirtual 327	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   449: checkcast 195	android/telephony/TelephonyManager
    //   452: invokestatic 329	com/tencent/mobileqq/log/VipWebViewReportLog:a	(Landroid/telephony/TelephonyManager;)V
    //   455: new 62	java/lang/StringBuilder
    //   458: dup
    //   459: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   462: aload_0
    //   463: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: ldc_w 331
    //   469: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: getstatic 88	com/tencent/mobileqq/log/VipWebViewReportLog:h	Ljava/lang/String;
    //   475: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   481: astore_0
    //   482: new 62	java/lang/StringBuilder
    //   485: dup
    //   486: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   489: aload_0
    //   490: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: ldc_w 333
    //   496: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: getstatic 90	com/tencent/mobileqq/log/VipWebViewReportLog:i	Ljava/lang/String;
    //   502: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   508: astore_0
    //   509: new 62	java/lang/StringBuilder
    //   512: dup
    //   513: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   516: aload_0
    //   517: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: ldc_w 335
    //   523: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: getstatic 92	com/tencent/mobileqq/log/VipWebViewReportLog:j	Ljava/lang/String;
    //   529: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   535: astore_0
    //   536: getstatic 49	com/tencent/mobileqq/log/VipWebViewReportLog:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   539: iconst_1
    //   540: aload_0
    //   541: invokestatic 147	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   544: return
    //   545: astore_0
    //   546: aload_0
    //   547: invokevirtual 338	java/lang/Exception:printStackTrace	()V
    //   550: return
    //   551: new 62	java/lang/StringBuilder
    //   554: dup
    //   555: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   558: aload_1
    //   559: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: ldc_w 340
    //   565: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   571: astore_1
    //   572: goto -366 -> 206
    //   575: new 62	java/lang/StringBuilder
    //   578: dup
    //   579: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   582: aload_1
    //   583: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: ldc_w 342
    //   589: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   595: astore_1
    //   596: goto -315 -> 281
    //   599: new 62	java/lang/StringBuilder
    //   602: dup
    //   603: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   606: aload_1
    //   607: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   610: ldc_w 344
    //   613: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   616: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   619: astore_1
    //   620: goto -276 -> 344
    //   623: new 62	java/lang/StringBuilder
    //   626: dup
    //   627: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   630: aload_1
    //   631: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   634: ldc_w 346
    //   637: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   640: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   643: astore_0
    //   644: goto -258 -> 386
    //   647: new 62	java/lang/StringBuilder
    //   650: dup
    //   651: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   654: aload_0
    //   655: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   658: ldc_w 348
    //   661: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   664: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   667: astore_0
    //   668: goto -228 -> 440
    //   671: astore_1
    //   672: aload_1
    //   673: invokevirtual 338	java/lang/Exception:printStackTrace	()V
    //   676: goto -221 -> 455
    //   679: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	680	0	paramConsoleMessage	com.tencent.smtt.export.external.interfaces.ConsoleMessage
    //   62	569	1	str1	String
    //   671	2	1	localException	Exception
    //   138	19	2	str2	String
    // Exception table:
    //   from	to	target	type
    //   0	6	545	java/lang/Exception
    //   7	28	545	java/lang/Exception
    //   28	40	545	java/lang/Exception
    //   40	206	545	java/lang/Exception
    //   206	281	545	java/lang/Exception
    //   281	344	545	java/lang/Exception
    //   344	386	545	java/lang/Exception
    //   386	440	545	java/lang/Exception
    //   455	544	545	java/lang/Exception
    //   551	572	545	java/lang/Exception
    //   575	596	545	java/lang/Exception
    //   599	620	545	java/lang/Exception
    //   623	644	545	java/lang/Exception
    //   647	668	545	java/lang/Exception
    //   672	676	545	java/lang/Exception
    //   440	455	671	java/lang/Exception
  }
  
  public static void a(JSONObject paramJSONObject, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder(4096);
    if ("null".equals(i)) {}
    try
    {
      a((TelephonyManager)jdField_a_of_type_AndroidContentContext.getSystemService("phone"));
      localStringBuilder.append("==> SUMMARY INFO <==\nNET_TYPE:").append(i).append("\n").append("ERROR_CODE:").append(paramInt).append("\n");
      if (paramJSONObject != null)
      {
        long l2 = paramJSONObject.optLong("dns_start");
        long l8 = paramJSONObject.optLong("dns_end");
        l3 = paramJSONObject.optLong("connect_start");
        long l9 = paramJSONObject.optLong("connect_end");
        l4 = paramJSONObject.optLong("ssl_handshake_start");
        long l10 = paramJSONObject.optLong("ssl_handshake_end");
        l5 = paramJSONObject.optLong("send_start");
        long l11 = paramJSONObject.optLong("send_end");
        l6 = paramJSONObject.optLong("recv_start");
        l7 = paramJSONObject.optLong("recv_end");
        if (0L != l2)
        {
          l1 = l2;
          localStringBuilder.append("DNS cost=").append(l8 - l2).append("\n");
          localStringBuilder.append("Create connect cost=").append(l9 - l3).append("\n");
          localStringBuilder.append("SSL handshake cost=").append(l10 - l4).append("\n");
          localStringBuilder.append("Send cost=").append(l11 - l5).append("\n");
          localStringBuilder.append("Receive cost=").append(l7 - l6).append("\n");
          localStringBuilder.append("Total Duration=").append(l7 - l1).append("\n");
          localStringBuilder.append("Original Data:\n").append(paramJSONObject);
        }
      }
      else
      {
        QLog.d("WebCoreDump", 1, localStringBuilder.toString());
        if (paramWebResourceRequest == null) {
          break label732;
        }
        localStringBuilder.setLength(0);
        localStringBuilder.append("HAS_GESTURE:" + paramWebResourceRequest.hasGesture() + "\n");
        localStringBuilder.append("IS_FOR_MAINFRAME:" + paramWebResourceRequest.isForMainFrame() + "\n");
        localStringBuilder.append(paramWebResourceRequest.getMethod()).append(" ").append(paramWebResourceRequest.getUrl()).append("\n");
        paramJSONObject = paramWebResourceRequest.getRequestHeaders();
        if ((paramJSONObject == null) || (paramJSONObject.size() <= 0)) {
          break label702;
        }
        paramWebResourceRequest = paramJSONObject.keySet().iterator();
        for (;;)
        {
          if (!paramWebResourceRequest.hasNext()) {
            break label702;
          }
          String str = (String)paramWebResourceRequest.next();
          if (!str.equalsIgnoreCase("cookie")) {
            break;
          }
          localStringBuilder.append(str + ":" + Util.c((String)paramJSONObject.get(str), new String[0]) + "\n");
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l3;
        long l4;
        long l5;
        long l6;
        long l7;
        long l1;
        localException.printStackTrace();
        continue;
        if (0L != l3)
        {
          l1 = l3;
        }
        else if (0L != l4)
        {
          l1 = l4;
        }
        else if (0L != l5)
        {
          l1 = l5;
        }
        else if (0L != l6)
        {
          l1 = l6;
        }
        else
        {
          l1 = l7;
          continue;
          localStringBuilder.append(localException + ":" + (String)paramJSONObject.get(localException) + "\n");
        }
      }
      label702:
      QLog.d("WebCoreDump", 1, "-->HTTP REQUEST\n" + localStringBuilder.toString());
      label732:
      if (paramWebResourceResponse != null)
      {
        localStringBuilder.setLength(0);
        localStringBuilder.append("STATUS_CODE:" + paramWebResourceResponse.getStatusCode() + "\n").append("CONTENT_ENCODING:" + paramWebResourceResponse.getEncoding() + "\n").append("MIME_TYPE:" + paramWebResourceResponse.getMimeType() + "\n").append("REASON_PHRASE:" + paramWebResourceResponse.getReasonPhrase() + "\n");
        paramJSONObject = paramWebResourceResponse.getResponseHeaders();
        if ((paramJSONObject != null) && (paramJSONObject.size() > 0))
        {
          paramWebResourceRequest = paramJSONObject.keySet().iterator();
          while (paramWebResourceRequest.hasNext())
          {
            paramWebResourceResponse = (String)paramWebResourceRequest.next();
            localStringBuilder.append(paramWebResourceResponse + ":" + (String)paramJSONObject.get(paramWebResourceResponse) + "\n");
          }
        }
        QLog.d("WebCoreDump", 1, "<--HTTP RESPONSE\n" + localStringBuilder.toString());
      }
    }
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 0;
  }
  
  public static boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilSet.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ((!TextUtils.isEmpty(str)) && (paramString.contains(str)))
        {
          QLog.d("WebCoreDump", 1, "-->url:" + Util.b(paramString, new String[0]) + " is in white list");
          return true;
        }
      }
    }
    QLog.d("WebCoreDump", 1, "-->url:" + Util.b(paramString, new String[0]) + " is not in white list");
    return false;
  }
  
  public static void b()
  {
    if (jdField_g_of_type_Int == e) {}
  }
  
  public static boolean b()
  {
    QLog.d("WebCoreDump", 1, "-->uin in white list:" + jdField_b_of_type_Boolean);
    return jdField_b_of_type_Boolean;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\log\VipWebViewReportLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */