package com.tencent.open.business.viareport;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.APNUtil;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.MobileInfoUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TimeZone;
import wum;
import wun;

public class ReportManager
{
  protected static ReportManager a;
  protected static final String a = "viareport";
  protected static final String c = "http://analy.qq.com/cgi-bin/mapp_apptrace";
  public static final String d = "opensdk_report_thread";
  protected static final String e = "mapp_apptrace";
  protected ArrayList a;
  public volatile boolean a;
  protected String b;
  protected ArrayList b;
  
  protected ReportManager()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static ReportManager a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentOpenBusinessViareportReportManager == null) {
        jdField_a_of_type_ComTencentOpenBusinessViareportReportManager = new ReportManager();
      }
      ReportManager localReportManager = jdField_a_of_type_ComTencentOpenBusinessViareportReportManager;
      return localReportManager;
    }
    finally {}
  }
  
  protected String a()
  {
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_b_of_type_JavaLangString = "http://analy.qq.com/cgi-bin/mapp_apptrace";
    }
    return this.jdField_b_of_type_JavaLangString;
  }
  
  protected String a(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramArrayList1 != null)
    {
      paramArrayList1 = paramArrayList1.iterator();
      while (paramArrayList1.hasNext())
      {
        BatchReportInfo localBatchReportInfo = (BatchReportInfo)paramArrayList1.next();
        localStringBuilder.append(localBatchReportInfo.jdField_a_of_type_JavaLangString + "_" + localBatchReportInfo.jdField_b_of_type_JavaLangString + "_" + localBatchReportInfo.c + "_" + localBatchReportInfo.a() + "_" + localBatchReportInfo.g);
        if (!TextUtils.isEmpty(localBatchReportInfo.h)) {
          localStringBuilder.append("_" + localBatchReportInfo.h);
        }
        if (!TextUtils.isEmpty(localBatchReportInfo.i)) {
          localStringBuilder.append("_" + localBatchReportInfo.i);
        }
        if (!TextUtils.isEmpty(localBatchReportInfo.j)) {
          localStringBuilder.append("_" + localBatchReportInfo.j);
        }
        if (!TextUtils.isEmpty(localBatchReportInfo.k)) {
          localStringBuilder.append("_" + localBatchReportInfo.k);
        }
        if (!TextUtils.isEmpty(localBatchReportInfo.l)) {
          localStringBuilder.append("_" + localBatchReportInfo.l);
        }
        localStringBuilder.append(",");
      }
    }
    if (paramArrayList2 != null)
    {
      paramArrayList1 = paramArrayList2.iterator();
      while (paramArrayList1.hasNext())
      {
        paramArrayList2 = (BatchReportInfo)paramArrayList1.next();
        localStringBuilder.append(paramArrayList2.jdField_a_of_type_JavaLangString + "_" + paramArrayList2.jdField_b_of_type_JavaLangString + "_" + paramArrayList2.c + "_" + paramArrayList2.a() + "_" + paramArrayList2.g);
        if (!TextUtils.isEmpty(paramArrayList2.h)) {
          localStringBuilder.append("_" + paramArrayList2.h);
        }
        if (!TextUtils.isEmpty(paramArrayList2.i)) {
          localStringBuilder.append("_" + paramArrayList2.i);
        }
        if (!TextUtils.isEmpty(paramArrayList2.j)) {
          localStringBuilder.append("_" + paramArrayList2.j);
        }
        if (!TextUtils.isEmpty(paramArrayList2.k)) {
          localStringBuilder.append("_" + paramArrayList2.k);
        }
        if (!TextUtils.isEmpty(paramArrayList2.l)) {
          localStringBuilder.append("_" + paramArrayList2.l);
        }
        localStringBuilder.append(",");
      }
    }
    paramArrayList2 = localStringBuilder.toString();
    paramArrayList1 = paramArrayList2;
    if (paramArrayList2.endsWith(",")) {
      paramArrayList1 = paramArrayList2.substring(0, paramArrayList2.length() - 1);
    }
    return paramArrayList1;
  }
  
  protected void a()
  {
    String str = String.valueOf(CommonDataAdapter.a().a());
    if (a(str)) {
      ThreadManager.d(new wun(this, str));
    }
  }
  
  public void a(BatchReportInfo paramBatchReportInfo, Bundle paramBundle, boolean paramBoolean)
  {
    a(String.valueOf(CommonDataAdapter.a().a()), paramBatchReportInfo, paramBundle, paramBoolean);
  }
  
  public void a(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    if (paramBoolean)
    {
      if (!a(paramString, localBundle))
      {
        LogUtility.b("viareport", "database empty");
        return;
      }
      this.jdField_a_of_type_Boolean = true;
    }
    localBundle.putString("uin", paramString);
    localBundle.putString("platform", CommonDataAdapter.a().g());
    localBundle.putString("action", "100");
    localBundle.putString("imei", MobileInfoUtil.c());
    localBundle.putString("resolution", MobileInfoUtil.e());
    localBundle.putString("network", APNUtil.a(CommonDataAdapter.a().a()));
    localBundle.putString("wifimac", MobileInfoUtil.a());
    localBundle.putString("mobile_pf", "1");
    localBundle.putString("os_ver", Build.VERSION.RELEASE);
    localBundle.putString("lang", MobileInfoUtil.b());
    localBundle.putString("device", Build.DEVICE);
    localBundle.putString("model_name", Build.MODEL);
    localBundle.putString("sdk_ver", "1.5");
    localBundle.putString("timezone", TimeZone.getDefault().getID());
    localBundle.putString("city", MobileInfoUtil.g());
    localBundle.putString("longitude", MobileInfoUtil.f());
    localBundle.putString("ret_code", "0");
    localBundle.putString("qua", CommonDataAdapter.a().e());
    localBundle.putString("qz_ver", CommonDataAdapter.a().b());
    localBundle.putString("ext", CommonDataAdapter.a().h());
    if (paramBundle != null) {
      localBundle.putAll(paramBundle);
    }
    if (paramBoolean) {}
    for (paramString = "POST";; paramString = "GET")
    {
      a(a(), paramString, localBundle, paramBoolean);
      return;
    }
  }
  
  public void a(String paramString, BatchReportInfo paramBatchReportInfo, Bundle paramBundle, boolean paramBoolean)
  {
    ThreadManager.d(new wum(this, paramBoolean, paramBatchReportInfo, paramBundle, paramString));
  }
  
  /* Error */
  protected void a(String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 302	com/tencent/open/business/viareport/ReportConfig:b	()I
    //   3: istore 10
    //   5: ldc 9
    //   7: new 56	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   14: ldc_w 304
    //   17: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: iload 10
    //   22: invokevirtual 307	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   25: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 165	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: iconst_0
    //   32: istore 8
    //   34: iconst_0
    //   35: istore 7
    //   37: invokestatic 312	android/os/SystemClock:elapsedRealtime	()J
    //   40: lstore 16
    //   42: lconst_0
    //   43: lstore 12
    //   45: lconst_0
    //   46: lstore 18
    //   48: iconst_0
    //   49: istore 11
    //   51: iload 8
    //   53: iconst_1
    //   54: iadd
    //   55: istore 9
    //   57: lload 12
    //   59: lstore 20
    //   61: aload_1
    //   62: aload_2
    //   63: aload_3
    //   64: invokestatic 317	com/tencent/open/base/http/HttpBaseUtil:a	(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Lcom/tencent/open/base/http/HttpBaseUtil$Statistic;
    //   67: astore 5
    //   69: lload 12
    //   71: lstore 20
    //   73: aload 5
    //   75: getfield 320	com/tencent/open/base/http/HttpBaseUtil$Statistic:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   78: invokestatic 323	com/tencent/open/base/http/HttpBaseUtil:a	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   81: astore 6
    //   83: lload 12
    //   85: lstore 20
    //   87: aload 6
    //   89: ldc_w 325
    //   92: invokevirtual 331	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   95: istore 8
    //   97: iload 8
    //   99: ifeq +22 -> 121
    //   102: lload 12
    //   104: lstore 20
    //   106: aload 5
    //   108: getfield 320	com/tencent/open/base/http/HttpBaseUtil$Statistic:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   111: invokestatic 53	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   114: istore 24
    //   116: iload 24
    //   118: ifne +951 -> 1069
    //   121: iconst_1
    //   122: istore 8
    //   124: iload 10
    //   126: istore 7
    //   128: lload 12
    //   130: lstore 20
    //   132: lload 12
    //   134: lstore 14
    //   136: aload 5
    //   138: getfield 334	com/tencent/open/base/http/HttpBaseUtil$Statistic:jdField_a_of_type_Long	J
    //   141: lstore 12
    //   143: lload 12
    //   145: lstore 20
    //   147: lload 12
    //   149: lstore 14
    //   151: aload 5
    //   153: getfield 336	com/tencent/open/base/http/HttpBaseUtil$Statistic:b	J
    //   156: lstore 22
    //   158: iload 11
    //   160: istore 9
    //   162: lload 22
    //   164: lstore 14
    //   166: iload 7
    //   168: iload 10
    //   170: if_icmplt +876 -> 1046
    //   173: ldc 9
    //   175: new 56	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   182: ldc_w 338
    //   185: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: lload 16
    //   190: invokevirtual 341	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   193: ldc_w 343
    //   196: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: lload 12
    //   201: invokevirtual 341	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   204: ldc_w 343
    //   207: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: lload 14
    //   212: invokevirtual 341	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   215: ldc_w 343
    //   218: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: iload 9
    //   223: invokevirtual 307	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   226: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: invokestatic 345	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   232: aload_0
    //   233: iload 9
    //   235: invokevirtual 348	com/tencent/open/business/viareport/ReportManager:a	(I)Z
    //   238: ifeq +29 -> 267
    //   241: invokestatic 353	com/tencent/open/business/cgireport/ReportManager:a	()Lcom/tencent/open/business/cgireport/ReportManager;
    //   244: ldc 18
    //   246: lload 16
    //   248: lload 12
    //   250: lload 14
    //   252: iload 9
    //   254: invokestatic 128	com/tencent/open/adapter/CommonDataAdapter:a	()Lcom/tencent/open/adapter/CommonDataAdapter;
    //   257: invokevirtual 131	com/tencent/open/adapter/CommonDataAdapter:a	()J
    //   260: ldc_w 355
    //   263: aconst_null
    //   264: invokevirtual 358	com/tencent/open/business/cgireport/ReportManager:a	(Ljava/lang/String;JJJIJLjava/lang/String;Ljava/lang/String;)V
    //   267: iload 8
    //   269: iconst_1
    //   270: if_icmpne +708 -> 978
    //   273: ldc_w 360
    //   276: ldc_w 362
    //   279: invokestatic 165	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   282: iload 4
    //   284: ifeq +25 -> 309
    //   287: ldc 9
    //   289: ldc_w 364
    //   292: invokestatic 165	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   295: aload_0
    //   296: iconst_0
    //   297: putfield 167	com/tencent/open/business/viareport/ReportManager:jdField_a_of_type_Boolean	Z
    //   300: iload 8
    //   302: ifeq +7 -> 309
    //   305: aload_0
    //   306: invokevirtual 366	com/tencent/open/business/viareport/ReportManager:a	()V
    //   309: return
    //   310: astore 6
    //   312: bipush -4
    //   314: istore 8
    //   316: goto -219 -> 97
    //   319: astore 5
    //   321: iload 7
    //   323: istore 8
    //   325: iload 9
    //   327: istore 7
    //   329: invokestatic 312	android/os/SystemClock:elapsedRealtime	()J
    //   332: lstore 16
    //   334: lconst_0
    //   335: lstore 12
    //   337: lconst_0
    //   338: lstore 14
    //   340: bipush -7
    //   342: istore 9
    //   344: ldc 9
    //   346: new 56	java/lang/StringBuilder
    //   349: dup
    //   350: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   353: ldc_w 368
    //   356: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: aload 5
    //   361: invokevirtual 369	org/apache/http/conn/ConnectTimeoutException:toString	()Ljava/lang/String;
    //   364: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   370: invokestatic 371	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   373: goto -207 -> 166
    //   376: astore 5
    //   378: iload 7
    //   380: istore 8
    //   382: iload 9
    //   384: istore 7
    //   386: invokestatic 312	android/os/SystemClock:elapsedRealtime	()J
    //   389: lstore 16
    //   391: lconst_0
    //   392: lstore 12
    //   394: lconst_0
    //   395: lstore 14
    //   397: bipush -8
    //   399: istore 9
    //   401: ldc 9
    //   403: new 56	java/lang/StringBuilder
    //   406: dup
    //   407: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   410: ldc_w 368
    //   413: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: aload 5
    //   418: invokevirtual 372	java/net/SocketTimeoutException:toString	()Ljava/lang/String;
    //   421: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   427: invokestatic 371	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   430: goto -264 -> 166
    //   433: astore 5
    //   435: iload 7
    //   437: istore 8
    //   439: iload 9
    //   441: istore 7
    //   443: lconst_0
    //   444: lstore 12
    //   446: lconst_0
    //   447: lstore 14
    //   449: bipush -4
    //   451: istore 9
    //   453: ldc 9
    //   455: new 56	java/lang/StringBuilder
    //   458: dup
    //   459: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   462: ldc_w 368
    //   465: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: aload 5
    //   470: invokevirtual 373	org/json/JSONException:toString	()Ljava/lang/String;
    //   473: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   479: invokestatic 371	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   482: goto -316 -> 166
    //   485: astore_1
    //   486: ldc 9
    //   488: new 56	java/lang/StringBuilder
    //   491: dup
    //   492: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   495: ldc_w 368
    //   498: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: aload_1
    //   502: invokevirtual 374	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException:toString	()Ljava/lang/String;
    //   505: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   511: invokestatic 371	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   514: aload_0
    //   515: iconst_0
    //   516: putfield 167	com/tencent/open/business/viareport/ReportManager:jdField_a_of_type_Boolean	Z
    //   519: return
    //   520: astore_1
    //   521: aload_1
    //   522: invokevirtual 377	com/tencent/open/base/http/HttpBaseUtil$HttpStatusException:getMessage	()Ljava/lang/String;
    //   525: ldc_w 379
    //   528: ldc 32
    //   530: invokevirtual 383	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   533: invokestatic 388	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   536: istore 7
    //   538: aload_0
    //   539: iload 7
    //   541: invokevirtual 348	com/tencent/open/business/viareport/ReportManager:a	(I)Z
    //   544: ifeq +29 -> 573
    //   547: invokestatic 353	com/tencent/open/business/cgireport/ReportManager:a	()Lcom/tencent/open/business/cgireport/ReportManager;
    //   550: ldc 18
    //   552: lload 16
    //   554: lload 20
    //   556: lload 18
    //   558: iload 7
    //   560: invokestatic 128	com/tencent/open/adapter/CommonDataAdapter:a	()Lcom/tencent/open/adapter/CommonDataAdapter;
    //   563: invokevirtual 131	com/tencent/open/adapter/CommonDataAdapter:a	()J
    //   566: ldc_w 355
    //   569: aconst_null
    //   570: invokevirtual 358	com/tencent/open/business/cgireport/ReportManager:a	(Ljava/lang/String;JJJIJLjava/lang/String;Ljava/lang/String;)V
    //   573: ldc 9
    //   575: new 56	java/lang/StringBuilder
    //   578: dup
    //   579: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   582: ldc_w 368
    //   585: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: aload_1
    //   589: invokevirtual 389	com/tencent/open/base/http/HttpBaseUtil$HttpStatusException:toString	()Ljava/lang/String;
    //   592: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   598: invokestatic 371	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   601: aload_0
    //   602: iconst_0
    //   603: putfield 167	com/tencent/open/business/viareport/ReportManager:jdField_a_of_type_Boolean	Z
    //   606: return
    //   607: astore_2
    //   608: ldc 9
    //   610: new 56	java/lang/StringBuilder
    //   613: dup
    //   614: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   617: ldc_w 368
    //   620: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: aload_1
    //   624: invokevirtual 389	com/tencent/open/base/http/HttpBaseUtil$HttpStatusException:toString	()Ljava/lang/String;
    //   627: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   630: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   633: invokestatic 371	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   636: goto -63 -> 573
    //   639: astore 5
    //   641: iload 7
    //   643: istore 8
    //   645: iload 9
    //   647: istore 7
    //   649: lconst_0
    //   650: lstore 12
    //   652: lconst_0
    //   653: lstore 14
    //   655: aload 5
    //   657: invokestatic 394	com/tencent/open/base/http/HttpCgiAsyncTask:a	(Ljava/io/IOException;)I
    //   660: istore 9
    //   662: ldc 9
    //   664: new 56	java/lang/StringBuilder
    //   667: dup
    //   668: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   671: ldc_w 368
    //   674: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   677: aload 5
    //   679: invokevirtual 395	java/io/IOException:toString	()Ljava/lang/String;
    //   682: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   685: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   688: invokestatic 371	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   691: goto -525 -> 166
    //   694: astore 5
    //   696: iload 7
    //   698: istore 8
    //   700: iload 9
    //   702: istore 7
    //   704: aload 5
    //   706: instanceof 292
    //   709: ifeq +38 -> 747
    //   712: ldc 9
    //   714: new 56	java/lang/StringBuilder
    //   717: dup
    //   718: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   721: ldc_w 368
    //   724: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   727: aload 5
    //   729: invokevirtual 396	java/lang/Exception:toString	()Ljava/lang/String;
    //   732: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   738: invokestatic 371	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   741: aload_0
    //   742: iconst_0
    //   743: putfield 167	com/tencent/open/business/viareport/ReportManager:jdField_a_of_type_Boolean	Z
    //   746: return
    //   747: aload 5
    //   749: instanceof 294
    //   752: ifeq +124 -> 876
    //   755: aload 5
    //   757: invokevirtual 397	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   760: ldc_w 379
    //   763: ldc 32
    //   765: invokevirtual 383	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   768: invokestatic 388	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   771: istore 7
    //   773: aload_0
    //   774: iload 7
    //   776: invokevirtual 348	com/tencent/open/business/viareport/ReportManager:a	(I)Z
    //   779: ifeq +29 -> 808
    //   782: invokestatic 353	com/tencent/open/business/cgireport/ReportManager:a	()Lcom/tencent/open/business/cgireport/ReportManager;
    //   785: ldc 18
    //   787: lload 16
    //   789: lload 12
    //   791: lload 18
    //   793: iload 7
    //   795: invokestatic 128	com/tencent/open/adapter/CommonDataAdapter:a	()Lcom/tencent/open/adapter/CommonDataAdapter;
    //   798: invokevirtual 131	com/tencent/open/adapter/CommonDataAdapter:a	()J
    //   801: ldc_w 355
    //   804: aconst_null
    //   805: invokevirtual 358	com/tencent/open/business/cgireport/ReportManager:a	(Ljava/lang/String;JJJIJLjava/lang/String;Ljava/lang/String;)V
    //   808: ldc 9
    //   810: new 56	java/lang/StringBuilder
    //   813: dup
    //   814: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   817: ldc_w 368
    //   820: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   823: aload 5
    //   825: invokevirtual 396	java/lang/Exception:toString	()Ljava/lang/String;
    //   828: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   831: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   834: invokestatic 371	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   837: aload_0
    //   838: iconst_0
    //   839: putfield 167	com/tencent/open/business/viareport/ReportManager:jdField_a_of_type_Boolean	Z
    //   842: return
    //   843: astore_1
    //   844: ldc 9
    //   846: new 56	java/lang/StringBuilder
    //   849: dup
    //   850: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   853: ldc_w 368
    //   856: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   859: aload 5
    //   861: invokevirtual 396	java/lang/Exception:toString	()Ljava/lang/String;
    //   864: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   867: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   870: invokestatic 371	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   873: goto -65 -> 808
    //   876: aload 5
    //   878: instanceof 296
    //   881: ifeq +51 -> 932
    //   884: lconst_0
    //   885: lstore 12
    //   887: lconst_0
    //   888: lstore 14
    //   890: aload 5
    //   892: checkcast 296	java/io/IOException
    //   895: invokestatic 394	com/tencent/open/base/http/HttpCgiAsyncTask:a	(Ljava/io/IOException;)I
    //   898: istore 9
    //   900: ldc 9
    //   902: new 56	java/lang/StringBuilder
    //   905: dup
    //   906: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   909: ldc_w 368
    //   912: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   915: aload 5
    //   917: invokevirtual 396	java/lang/Exception:toString	()Ljava/lang/String;
    //   920: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   923: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   926: invokestatic 371	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   929: goto -763 -> 166
    //   932: lconst_0
    //   933: lstore 12
    //   935: lconst_0
    //   936: lstore 14
    //   938: bipush -6
    //   940: istore 9
    //   942: ldc 9
    //   944: new 56	java/lang/StringBuilder
    //   947: dup
    //   948: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   951: ldc_w 368
    //   954: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   957: aload 5
    //   959: invokevirtual 396	java/lang/Exception:toString	()Ljava/lang/String;
    //   962: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   965: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   968: invokestatic 371	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   971: iload 10
    //   973: istore 7
    //   975: goto -809 -> 166
    //   978: ldc_w 360
    //   981: ldc_w 399
    //   984: invokestatic 165	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   987: iload 4
    //   989: ifeq -707 -> 282
    //   992: invokestatic 404	com/tencent/open/business/viareport/ReportDbHelper:a	()Lcom/tencent/open/business/viareport/ReportDbHelper;
    //   995: aload_0
    //   996: getfield 41	com/tencent/open/business/viareport/ReportManager:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   999: invokevirtual 407	com/tencent/open/business/viareport/ReportDbHelper:a	(Ljava/util/ArrayList;)I
    //   1002: pop
    //   1003: invokestatic 404	com/tencent/open/business/viareport/ReportDbHelper:a	()Lcom/tencent/open/business/viareport/ReportDbHelper;
    //   1006: aload_0
    //   1007: getfield 39	com/tencent/open/business/viareport/ReportManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1010: invokevirtual 407	com/tencent/open/business/viareport/ReportDbHelper:a	(Ljava/util/ArrayList;)I
    //   1013: pop
    //   1014: goto -732 -> 282
    //   1017: astore 5
    //   1019: lload 14
    //   1021: lstore 12
    //   1023: goto -319 -> 704
    //   1026: astore 5
    //   1028: goto -379 -> 649
    //   1031: astore 5
    //   1033: goto -590 -> 443
    //   1036: astore 5
    //   1038: goto -652 -> 386
    //   1041: astore 5
    //   1043: goto -714 -> 329
    //   1046: iload 7
    //   1048: istore 11
    //   1050: iload 8
    //   1052: istore 7
    //   1054: iload 11
    //   1056: istore 8
    //   1058: lload 14
    //   1060: lstore 18
    //   1062: iload 9
    //   1064: istore 11
    //   1066: goto -1015 -> 51
    //   1069: iload 7
    //   1071: istore 8
    //   1073: iload 9
    //   1075: istore 7
    //   1077: goto -949 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1080	0	this	ReportManager
    //   0	1080	1	paramString1	String
    //   0	1080	2	paramString2	String
    //   0	1080	3	paramBundle	Bundle
    //   0	1080	4	paramBoolean	boolean
    //   67	85	5	localStatistic	com.tencent.open.base.http.HttpBaseUtil.Statistic
    //   319	41	5	localConnectTimeoutException1	org.apache.http.conn.ConnectTimeoutException
    //   376	41	5	localSocketTimeoutException1	java.net.SocketTimeoutException
    //   433	36	5	localJSONException1	org.json.JSONException
    //   639	39	5	localIOException1	java.io.IOException
    //   694	264	5	localException1	Exception
    //   1017	1	5	localException2	Exception
    //   1026	1	5	localIOException2	java.io.IOException
    //   1031	1	5	localJSONException2	org.json.JSONException
    //   1036	1	5	localSocketTimeoutException2	java.net.SocketTimeoutException
    //   1041	1	5	localConnectTimeoutException2	org.apache.http.conn.ConnectTimeoutException
    //   81	7	6	localJSONObject	org.json.JSONObject
    //   310	1	6	localJSONException3	org.json.JSONException
    //   35	1041	7	i	int
    //   32	1040	8	j	int
    //   55	1019	9	k	int
    //   3	969	10	m	int
    //   49	1016	11	n	int
    //   43	979	12	l1	long
    //   134	925	14	l2	long
    //   40	748	16	l3	long
    //   46	1015	18	l4	long
    //   59	496	20	l5	long
    //   156	7	22	l6	long
    //   114	3	24	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   87	97	310	org/json/JSONException
    //   61	69	319	org/apache/http/conn/ConnectTimeoutException
    //   73	83	319	org/apache/http/conn/ConnectTimeoutException
    //   87	97	319	org/apache/http/conn/ConnectTimeoutException
    //   106	116	319	org/apache/http/conn/ConnectTimeoutException
    //   61	69	376	java/net/SocketTimeoutException
    //   73	83	376	java/net/SocketTimeoutException
    //   87	97	376	java/net/SocketTimeoutException
    //   106	116	376	java/net/SocketTimeoutException
    //   61	69	433	org/json/JSONException
    //   73	83	433	org/json/JSONException
    //   106	116	433	org/json/JSONException
    //   61	69	485	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   73	83	485	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   87	97	485	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   106	116	485	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   136	143	485	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   151	158	485	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   61	69	520	com/tencent/open/base/http/HttpBaseUtil$HttpStatusException
    //   73	83	520	com/tencent/open/base/http/HttpBaseUtil$HttpStatusException
    //   87	97	520	com/tencent/open/base/http/HttpBaseUtil$HttpStatusException
    //   106	116	520	com/tencent/open/base/http/HttpBaseUtil$HttpStatusException
    //   136	143	520	com/tencent/open/base/http/HttpBaseUtil$HttpStatusException
    //   151	158	520	com/tencent/open/base/http/HttpBaseUtil$HttpStatusException
    //   521	573	607	java/lang/Exception
    //   61	69	639	java/io/IOException
    //   73	83	639	java/io/IOException
    //   87	97	639	java/io/IOException
    //   106	116	639	java/io/IOException
    //   61	69	694	java/lang/Exception
    //   73	83	694	java/lang/Exception
    //   87	97	694	java/lang/Exception
    //   106	116	694	java/lang/Exception
    //   755	808	843	java/lang/Exception
    //   136	143	1017	java/lang/Exception
    //   151	158	1017	java/lang/Exception
    //   136	143	1026	java/io/IOException
    //   151	158	1026	java/io/IOException
    //   136	143	1031	org/json/JSONException
    //   151	158	1031	org/json/JSONException
    //   136	143	1036	java/net/SocketTimeoutException
    //   151	158	1036	java/net/SocketTimeoutException
    //   136	143	1041	org/apache/http/conn/ConnectTimeoutException
    //   151	158	1041	org/apache/http/conn/ConnectTimeoutException
  }
  
  /* Error */
  public boolean a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 408	com/tencent/open/business/viareport/ReportConfig:a	()J
    //   5: lstore_2
    //   6: invokestatic 413	java/lang/System:currentTimeMillis	()J
    //   9: lstore 4
    //   11: ldc 9
    //   13: new 56	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   20: ldc_w 415
    //   23: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: lload_2
    //   27: invokevirtual 341	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   30: ldc_w 417
    //   33: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: lload 4
    //   38: invokevirtual 341	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   41: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokestatic 165	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: invokestatic 419	com/tencent/open/business/viareport/ReportConfig:b	()J
    //   50: lstore 6
    //   52: ldc 9
    //   54: new 56	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   61: ldc_w 421
    //   64: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: lload 6
    //   69: invokevirtual 341	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   72: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 165	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   78: lload 4
    //   80: lload_2
    //   81: lsub
    //   82: lload 6
    //   84: ldc2_w 422
    //   87: lmul
    //   88: lcmp
    //   89: ifge +20 -> 109
    //   92: ldc_w 360
    //   95: ldc_w 425
    //   98: invokestatic 165	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: iconst_0
    //   102: istore 8
    //   104: aload_0
    //   105: monitorexit
    //   106: iload 8
    //   108: ireturn
    //   109: lload 4
    //   111: invokestatic 428	com/tencent/open/business/viareport/ReportConfig:a	(J)V
    //   114: ldc_w 360
    //   117: ldc_w 430
    //   120: invokestatic 165	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   123: iconst_1
    //   124: istore 8
    //   126: goto -22 -> 104
    //   129: astore_1
    //   130: aload_0
    //   131: monitorexit
    //   132: aload_1
    //   133: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	ReportManager
    //   129	4	1	localObject	Object
    //   5	76	2	l1	long
    //   9	101	4	l2	long
    //   50	33	6	l3	long
    //   102	23	8	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	78	129	finally
    //   92	101	129	finally
    //   109	123	129	finally
  }
  
  /* Error */
  protected boolean a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: invokestatic 433	com/tencent/open/business/viareport/ReportConfig:a	(I)I
    //   6: istore_1
    //   7: ldc 9
    //   9: new 56	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 435
    //   19: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: iload_1
    //   23: invokevirtual 307	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   26: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 165	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: new 437	java/util/Random
    //   35: dup
    //   36: invokespecial 438	java/util/Random:<init>	()V
    //   39: bipush 100
    //   41: invokevirtual 441	java/util/Random:nextInt	(I)I
    //   44: iload_1
    //   45: if_icmpge +18 -> 63
    //   48: ldc_w 443
    //   51: ldc_w 445
    //   54: invokestatic 165	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: iconst_1
    //   58: istore_3
    //   59: aload_0
    //   60: monitorexit
    //   61: iload_3
    //   62: ireturn
    //   63: ldc_w 443
    //   66: ldc_w 447
    //   69: invokestatic 165	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: iconst_0
    //   73: istore_3
    //   74: goto -15 -> 59
    //   77: astore_2
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_2
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	ReportManager
    //   0	82	1	paramInt	int
    //   77	4	2	localObject	Object
    //   58	16	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	57	77	finally
    //   63	72	77	finally
  }
  
  /* Error */
  public boolean a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 449	com/tencent/open/business/viareport/ReportConfig:a	()I
    //   5: istore_2
    //   6: ldc 9
    //   8: new 56	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   15: ldc_w 451
    //   18: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: iload_2
    //   22: invokevirtual 307	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   25: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 165	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: invokestatic 404	com/tencent/open/business/viareport/ReportDbHelper:a	()Lcom/tencent/open/business/viareport/ReportDbHelper;
    //   34: aload_1
    //   35: invokevirtual 453	com/tencent/open/business/viareport/ReportDbHelper:a	(Ljava/lang/String;)I
    //   38: iload_2
    //   39: if_icmplt +18 -> 57
    //   42: ldc_w 360
    //   45: ldc_w 455
    //   48: invokestatic 165	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: iconst_1
    //   52: istore_3
    //   53: aload_0
    //   54: monitorexit
    //   55: iload_3
    //   56: ireturn
    //   57: ldc_w 360
    //   60: ldc_w 457
    //   63: invokestatic 165	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: iconst_0
    //   67: istore_3
    //   68: goto -15 -> 53
    //   71: astore_1
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	ReportManager
    //   0	76	1	paramString	String
    //   5	35	2	i	int
    //   52	16	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	51	71	finally
    //   57	66	71	finally
  }
  
  /* Error */
  protected boolean a(String paramString, Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokestatic 404	com/tencent/open/business/viareport/ReportDbHelper:a	()Lcom/tencent/open/business/viareport/ReportDbHelper;
    //   6: aload_1
    //   7: invokevirtual 460	com/tencent/open/business/viareport/ReportDbHelper:a	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   10: putfield 39	com/tencent/open/business/viareport/ReportManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   13: invokestatic 404	com/tencent/open/business/viareport/ReportDbHelper:a	()Lcom/tencent/open/business/viareport/ReportDbHelper;
    //   16: ldc_w 462
    //   19: aload_1
    //   20: invokevirtual 465	com/tencent/open/business/viareport/ReportDbHelper:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   23: pop
    //   24: aload_0
    //   25: invokestatic 404	com/tencent/open/business/viareport/ReportDbHelper:a	()Lcom/tencent/open/business/viareport/ReportDbHelper;
    //   28: aload_1
    //   29: invokevirtual 467	com/tencent/open/business/viareport/ReportDbHelper:b	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   32: putfield 41	com/tencent/open/business/viareport/ReportManager:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   35: invokestatic 404	com/tencent/open/business/viareport/ReportDbHelper:a	()Lcom/tencent/open/business/viareport/ReportDbHelper;
    //   38: ldc_w 469
    //   41: aload_1
    //   42: invokevirtual 465	com/tencent/open/business/viareport/ReportDbHelper:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   45: pop
    //   46: aload_0
    //   47: aload_0
    //   48: getfield 39	com/tencent/open/business/viareport/ReportManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   51: aload_0
    //   52: getfield 41	com/tencent/open/business/viareport/ReportManager:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   55: invokevirtual 471	com/tencent/open/business/viareport/ReportManager:a	(Ljava/util/ArrayList;Ljava/util/ArrayList;)Ljava/lang/String;
    //   58: astore_1
    //   59: ldc 9
    //   61: new 56	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   68: ldc_w 473
    //   71: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload_1
    //   75: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokestatic 165	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   84: aload_2
    //   85: ldc_w 475
    //   88: aload_1
    //   89: invokevirtual 172	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: aload_1
    //   93: invokestatic 53	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   96: istore_3
    //   97: iload_3
    //   98: ifeq +9 -> 107
    //   101: iconst_0
    //   102: istore_3
    //   103: aload_0
    //   104: monitorexit
    //   105: iload_3
    //   106: ireturn
    //   107: iconst_1
    //   108: istore_3
    //   109: goto -6 -> 103
    //   112: astore_1
    //   113: aload_0
    //   114: monitorexit
    //   115: aload_1
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	ReportManager
    //   0	117	1	paramString	String
    //   0	117	2	paramBundle	Bundle
    //   96	13	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	97	112	finally
  }
  
  /* Error */
  public boolean b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 476	com/tencent/open/business/viareport/ReportConfig:a	(Ljava/lang/String;)I
    //   6: istore_2
    //   7: ldc 9
    //   9: new 56	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 478
    //   19: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: iload_2
    //   23: invokevirtual 307	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   26: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 165	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: new 437	java/util/Random
    //   35: dup
    //   36: invokespecial 438	java/util/Random:<init>	()V
    //   39: bipush 100
    //   41: invokevirtual 441	java/util/Random:nextInt	(I)I
    //   44: iload_2
    //   45: if_icmpge +18 -> 63
    //   48: ldc_w 443
    //   51: ldc_w 480
    //   54: invokestatic 165	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: iconst_1
    //   58: istore_3
    //   59: aload_0
    //   60: monitorexit
    //   61: iload_3
    //   62: ireturn
    //   63: ldc_w 443
    //   66: ldc_w 482
    //   69: invokestatic 165	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: iconst_0
    //   73: istore_3
    //   74: goto -15 -> 59
    //   77: astore_1
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_1
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	ReportManager
    //   0	82	1	paramString	String
    //   6	40	2	i	int
    //   58	16	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	57	77	finally
    //   63	72	77	finally
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\business\viareport\ReportManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */