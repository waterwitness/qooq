package com.tencent.open.business.base.appreport;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.Settings.Secure;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.open.business.base.OpenConfig;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import wui;
import wuj;

public class AppReport
{
  protected static final int a = 10;
  protected static final long a = 86400000L;
  protected static final String a = "AppReport";
  public static Lock a = new ReentrantLock();
  public static boolean a = false;
  public static final int b = 70;
  public static final String b = "appcenter_app_report_storage_file.txt";
  public static final int c = 1;
  public static final String c = "appcenter_app_report";
  public static final int d = 2;
  public static final String d = "app_last_fullReport_success_time";
  public static final int e = 4;
  public static final String e = "is_app_last_fullReport_success";
  public static final int f = 8;
  protected static final String f = "full_report_date";
  protected static final String g = "full_report_day_times";
  public static final String h = "is_incremental_report_overflow";
  protected static final String i = "platform";
  protected static final String j = "version";
  protected static final String k = "android_id";
  protected static final String l = "imsi";
  protected static final String m = "mac_addr";
  protected static final String n = "imei";
  protected static final String o = "keystr";
  protected static final String p = "sid";
  protected static final String q = "uin";
  protected static final String r = "resolution";
  protected static final String s = "model_info";
  protected static final String t = "package";
  protected static final String u = "type";
  protected static final String v = "ALL";
  protected static final String w = "INC";
  protected static final String x = "http://fusionbase.qq.com/cgi-bin/appstage/sdk_update";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static Bundle a(Context paramContext, Map paramMap, String paramString1, String paramString2)
  {
    paramContext = new Bundle();
    paramContext.putString("platform", CommonDataAdapter.a().g());
    paramContext.putString("version", CommonDataAdapter.a().c());
    paramContext.putString("uin", paramString2);
    paramContext.putString("imei", MobileInfoUtil.c());
    paramContext.putString("imsi", MobileInfoUtil.d());
    paramContext.putString("android_id", Settings.Secure.getString(CommonDataAdapter.a().a().getContentResolver(), "android_id"));
    paramContext.putString("mac_addr", MobileInfoUtil.a());
    paramContext.putString("model_info", Build.MODEL);
    paramContext.putString("resolution", MobileInfoUtil.e());
    paramContext.putString("keystr", CommonDataAdapter.a().a());
    paramContext.putString("sid", CommonDataAdapter.a().a());
    paramContext.putString("package", paramMap.values().toString());
    paramContext.putString("type", paramString1);
    return paramContext;
  }
  
  protected static String a(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    return a(paramString1, paramInt1, paramString2, paramInt2, "");
  }
  
  public static String a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[\"");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("\",");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(",\"");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("\",");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(",\"");
    localStringBuilder.append(paramString3);
    localStringBuilder.append("\"");
    localStringBuilder.append("]");
    LogUtility.b("AppReport", "message to cgi: " + localStringBuilder.toString());
    return localStringBuilder.toString();
  }
  
  /* Error */
  public static Map a(Context paramContext)
  {
    // Byte code:
    //   0: new 209	java/io/File
    //   3: dup
    //   4: new 171	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   11: aload_0
    //   12: invokevirtual 213	android/content/Context:getFilesDir	()Ljava/io/File;
    //   15: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   18: getstatic 219	java/io/File:separator	Ljava/lang/String;
    //   21: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: ldc 20
    //   26: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokespecial 222	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: invokevirtual 226	java/io/File:exists	()Z
    //   38: ifne +5 -> 43
    //   41: aconst_null
    //   42: areturn
    //   43: getstatic 104	com/tencent/open/business/base/appreport/AppReport:a	Ljava/util/concurrent/locks/Lock;
    //   46: invokeinterface 231 1 0
    //   51: aload_0
    //   52: ldc 20
    //   54: invokevirtual 235	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   57: astore_1
    //   58: new 237	java/io/ByteArrayOutputStream
    //   61: dup
    //   62: invokespecial 238	java/io/ByteArrayOutputStream:<init>	()V
    //   65: astore_2
    //   66: aload_2
    //   67: astore_3
    //   68: aload_1
    //   69: astore 4
    //   71: sipush 1024
    //   74: newarray <illegal type>
    //   76: astore 5
    //   78: aload_2
    //   79: astore_3
    //   80: aload_1
    //   81: astore 4
    //   83: aload_1
    //   84: aload 5
    //   86: invokevirtual 244	java/io/FileInputStream:read	([B)I
    //   89: istore 9
    //   91: iload 9
    //   93: iconst_m1
    //   94: if_icmpeq +54 -> 148
    //   97: aload_2
    //   98: astore_3
    //   99: aload_1
    //   100: astore 4
    //   102: aload_2
    //   103: aload 5
    //   105: iconst_0
    //   106: iload 9
    //   108: invokevirtual 248	java/io/ByteArrayOutputStream:write	([BII)V
    //   111: goto -33 -> 78
    //   114: astore_3
    //   115: aload_2
    //   116: astore_0
    //   117: aload_3
    //   118: astore_2
    //   119: aload_2
    //   120: invokevirtual 251	java/io/FileNotFoundException:printStackTrace	()V
    //   123: aload_1
    //   124: ifnull +7 -> 131
    //   127: aload_1
    //   128: invokevirtual 254	java/io/FileInputStream:close	()V
    //   131: aload_0
    //   132: ifnull -91 -> 41
    //   135: aload_0
    //   136: invokevirtual 255	java/io/ByteArrayOutputStream:close	()V
    //   139: aconst_null
    //   140: areturn
    //   141: astore_0
    //   142: aload_0
    //   143: invokevirtual 256	java/io/IOException:printStackTrace	()V
    //   146: aconst_null
    //   147: areturn
    //   148: aload_2
    //   149: astore_3
    //   150: aload_1
    //   151: astore 4
    //   153: getstatic 104	com/tencent/open/business/base/appreport/AppReport:a	Ljava/util/concurrent/locks/Lock;
    //   156: invokeinterface 259 1 0
    //   161: aload_2
    //   162: astore_3
    //   163: aload_1
    //   164: astore 4
    //   166: new 261	java/lang/String
    //   169: dup
    //   170: aload_2
    //   171: invokevirtual 265	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   174: invokespecial 268	java/lang/String:<init>	([B)V
    //   177: invokevirtual 271	java/lang/String:trim	()Ljava/lang/String;
    //   180: astore 5
    //   182: aload_2
    //   183: astore_3
    //   184: aload_1
    //   185: astore 4
    //   187: aload 5
    //   189: invokevirtual 275	java/lang/String:length	()I
    //   192: ifle +553 -> 745
    //   195: aload_2
    //   196: astore_3
    //   197: aload_1
    //   198: astore 4
    //   200: aload 5
    //   202: iconst_0
    //   203: aload 5
    //   205: invokevirtual 275	java/lang/String:length	()I
    //   208: iconst_1
    //   209: isub
    //   210: invokevirtual 279	java/lang/String:substring	(II)Ljava/lang/String;
    //   213: ldc_w 281
    //   216: invokevirtual 285	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   219: astore 5
    //   221: aload_2
    //   222: astore_3
    //   223: aload_1
    //   224: astore 4
    //   226: new 287	java/util/HashMap
    //   229: dup
    //   230: invokespecial 288	java/util/HashMap:<init>	()V
    //   233: astore 6
    //   235: aload 5
    //   237: ifnull +391 -> 628
    //   240: aload_2
    //   241: astore_3
    //   242: aload_1
    //   243: astore 4
    //   245: aload 5
    //   247: arraylength
    //   248: ifle +380 -> 628
    //   251: aload_2
    //   252: astore_3
    //   253: aload_1
    //   254: astore 4
    //   256: aload 5
    //   258: arraylength
    //   259: istore 10
    //   261: iconst_0
    //   262: istore 9
    //   264: iload 9
    //   266: iload 10
    //   268: if_icmpge +360 -> 628
    //   271: aload_2
    //   272: astore_3
    //   273: aload_1
    //   274: astore 4
    //   276: aload 5
    //   278: iload 9
    //   280: aaload
    //   281: ldc_w 290
    //   284: invokevirtual 285	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   287: astore 7
    //   289: aload_2
    //   290: astore_3
    //   291: aload_1
    //   292: astore 4
    //   294: aload 7
    //   296: iconst_1
    //   297: aaload
    //   298: invokestatic 296	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   301: istore 11
    //   303: iload 11
    //   305: bipush 8
    //   307: if_icmpne +36 -> 343
    //   310: aload_2
    //   311: astore_3
    //   312: aload_1
    //   313: astore 4
    //   315: aload 6
    //   317: aload 7
    //   319: iconst_0
    //   320: aaload
    //   321: aload 7
    //   323: iconst_0
    //   324: aaload
    //   325: iconst_0
    //   326: ldc_w 298
    //   329: iload 11
    //   331: invokestatic 300	com/tencent/open/business/base/appreport/AppReport:a	(Ljava/lang/String;ILjava/lang/String;I)Ljava/lang/String;
    //   334: invokeinterface 304 3 0
    //   339: pop
    //   340: goto +411 -> 751
    //   343: aload_2
    //   344: astore_3
    //   345: aload_1
    //   346: astore 4
    //   348: aload_0
    //   349: invokevirtual 308	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   352: aload 7
    //   354: iconst_0
    //   355: aaload
    //   356: iconst_0
    //   357: invokevirtual 314	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   360: astore 8
    //   362: aload_2
    //   363: astore_3
    //   364: aload_1
    //   365: astore 4
    //   367: aload 6
    //   369: aload 7
    //   371: iconst_0
    //   372: aaload
    //   373: aload 7
    //   375: iconst_0
    //   376: aaload
    //   377: aload 8
    //   379: getfield 319	android/content/pm/PackageInfo:versionCode	I
    //   382: aload 8
    //   384: getfield 322	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   387: iload 11
    //   389: aload_0
    //   390: aload 7
    //   392: iconst_0
    //   393: aaload
    //   394: invokestatic 327	com/tencent/open/business/base/AppUtil:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   397: invokestatic 169	com/tencent/open/business/base/appreport/AppReport:a	(Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;)Ljava/lang/String;
    //   400: invokeinterface 304 3 0
    //   405: pop
    //   406: goto +345 -> 751
    //   409: astore 8
    //   411: aload_2
    //   412: astore_3
    //   413: aload_1
    //   414: astore 4
    //   416: ldc 13
    //   418: new 171	java/lang/StringBuilder
    //   421: dup
    //   422: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   425: ldc_w 329
    //   428: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: aload 7
    //   433: iconst_0
    //   434: aaload
    //   435: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: ldc_w 331
    //   441: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: aload 8
    //   446: invokevirtual 332	android/content/pm/PackageManager$NameNotFoundException:toString	()Ljava/lang/String;
    //   449: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   455: invokestatic 334	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   458: goto +293 -> 751
    //   461: astore_3
    //   462: aload_2
    //   463: astore_0
    //   464: aload_3
    //   465: astore_2
    //   466: aload_0
    //   467: astore_3
    //   468: aload_1
    //   469: astore 4
    //   471: aload_2
    //   472: invokevirtual 256	java/io/IOException:printStackTrace	()V
    //   475: aload_1
    //   476: ifnull +7 -> 483
    //   479: aload_1
    //   480: invokevirtual 254	java/io/FileInputStream:close	()V
    //   483: aload_0
    //   484: ifnull -443 -> 41
    //   487: aload_0
    //   488: invokevirtual 255	java/io/ByteArrayOutputStream:close	()V
    //   491: aconst_null
    //   492: areturn
    //   493: astore_0
    //   494: aload_0
    //   495: invokevirtual 256	java/io/IOException:printStackTrace	()V
    //   498: aconst_null
    //   499: areturn
    //   500: astore 8
    //   502: aload_2
    //   503: astore_3
    //   504: aload_1
    //   505: astore 4
    //   507: ldc 13
    //   509: new 171	java/lang/StringBuilder
    //   512: dup
    //   513: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   516: ldc_w 336
    //   519: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: aload 7
    //   524: iconst_0
    //   525: aaload
    //   526: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: ldc_w 331
    //   532: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   535: aload 8
    //   537: invokevirtual 337	java/lang/NumberFormatException:toString	()Ljava/lang/String;
    //   540: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   546: invokestatic 334	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   549: goto +202 -> 751
    //   552: astore_0
    //   553: aload 4
    //   555: astore_1
    //   556: aload_3
    //   557: astore_2
    //   558: aload_1
    //   559: ifnull +7 -> 566
    //   562: aload_1
    //   563: invokevirtual 254	java/io/FileInputStream:close	()V
    //   566: aload_2
    //   567: ifnull +7 -> 574
    //   570: aload_2
    //   571: invokevirtual 255	java/io/ByteArrayOutputStream:close	()V
    //   574: aload_0
    //   575: athrow
    //   576: astore 8
    //   578: aload_2
    //   579: astore_3
    //   580: aload_1
    //   581: astore 4
    //   583: ldc 13
    //   585: new 171	java/lang/StringBuilder
    //   588: dup
    //   589: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   592: ldc_w 336
    //   595: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: aload 7
    //   600: iconst_0
    //   601: aaload
    //   602: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: ldc_w 331
    //   608: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: aload 8
    //   613: invokevirtual 338	java/lang/Exception:toString	()Ljava/lang/String;
    //   616: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   622: invokestatic 334	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   625: goto +126 -> 751
    //   628: aload_1
    //   629: ifnull +7 -> 636
    //   632: aload_1
    //   633: invokevirtual 254	java/io/FileInputStream:close	()V
    //   636: aload_2
    //   637: ifnull +7 -> 644
    //   640: aload_2
    //   641: invokevirtual 255	java/io/ByteArrayOutputStream:close	()V
    //   644: aload 6
    //   646: areturn
    //   647: astore_0
    //   648: aload_0
    //   649: invokevirtual 256	java/io/IOException:printStackTrace	()V
    //   652: goto -16 -> 636
    //   655: astore_0
    //   656: aload_0
    //   657: invokevirtual 256	java/io/IOException:printStackTrace	()V
    //   660: goto -16 -> 644
    //   663: astore_1
    //   664: aload_1
    //   665: invokevirtual 256	java/io/IOException:printStackTrace	()V
    //   668: goto -537 -> 131
    //   671: astore_1
    //   672: aload_1
    //   673: invokevirtual 256	java/io/IOException:printStackTrace	()V
    //   676: goto -193 -> 483
    //   679: astore_1
    //   680: aload_1
    //   681: invokevirtual 256	java/io/IOException:printStackTrace	()V
    //   684: goto -118 -> 566
    //   687: astore_1
    //   688: aload_1
    //   689: invokevirtual 256	java/io/IOException:printStackTrace	()V
    //   692: goto -118 -> 574
    //   695: astore_0
    //   696: aconst_null
    //   697: astore_2
    //   698: aconst_null
    //   699: astore_1
    //   700: goto -142 -> 558
    //   703: astore_0
    //   704: aconst_null
    //   705: astore_2
    //   706: goto -148 -> 558
    //   709: astore_3
    //   710: aload_0
    //   711: astore_2
    //   712: aload_3
    //   713: astore_0
    //   714: goto -156 -> 558
    //   717: astore_2
    //   718: aconst_null
    //   719: astore_0
    //   720: aconst_null
    //   721: astore_1
    //   722: goto -256 -> 466
    //   725: astore_2
    //   726: aconst_null
    //   727: astore_0
    //   728: goto -262 -> 466
    //   731: astore_2
    //   732: aconst_null
    //   733: astore_0
    //   734: aconst_null
    //   735: astore_1
    //   736: goto -617 -> 119
    //   739: astore_2
    //   740: aconst_null
    //   741: astore_0
    //   742: goto -623 -> 119
    //   745: aconst_null
    //   746: astore 5
    //   748: goto -527 -> 221
    //   751: iload 9
    //   753: iconst_1
    //   754: iadd
    //   755: istore 9
    //   757: goto -493 -> 264
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	760	0	paramContext	Context
    //   57	576	1	localObject1	Object
    //   663	2	1	localIOException1	IOException
    //   671	2	1	localIOException2	IOException
    //   679	2	1	localIOException3	IOException
    //   687	2	1	localIOException4	IOException
    //   699	37	1	localObject2	Object
    //   65	647	2	localObject3	Object
    //   717	1	2	localIOException5	IOException
    //   725	1	2	localIOException6	IOException
    //   731	1	2	localFileNotFoundException1	FileNotFoundException
    //   739	1	2	localFileNotFoundException2	FileNotFoundException
    //   67	32	3	localObject4	Object
    //   114	4	3	localFileNotFoundException3	FileNotFoundException
    //   149	264	3	localObject5	Object
    //   461	4	3	localIOException7	IOException
    //   467	113	3	localObject6	Object
    //   709	4	3	localObject7	Object
    //   69	513	4	localObject8	Object
    //   76	671	5	localObject9	Object
    //   233	412	6	localHashMap	java.util.HashMap
    //   287	312	7	arrayOfString	String[]
    //   360	23	8	localPackageInfo	android.content.pm.PackageInfo
    //   409	36	8	localNameNotFoundException	android.content.pm.PackageManager.NameNotFoundException
    //   500	36	8	localNumberFormatException	NumberFormatException
    //   576	36	8	localException	Exception
    //   89	667	9	i1	int
    //   259	10	10	i2	int
    //   301	87	11	i3	int
    // Exception table:
    //   from	to	target	type
    //   71	78	114	java/io/FileNotFoundException
    //   83	91	114	java/io/FileNotFoundException
    //   102	111	114	java/io/FileNotFoundException
    //   153	161	114	java/io/FileNotFoundException
    //   166	182	114	java/io/FileNotFoundException
    //   187	195	114	java/io/FileNotFoundException
    //   200	221	114	java/io/FileNotFoundException
    //   226	235	114	java/io/FileNotFoundException
    //   245	251	114	java/io/FileNotFoundException
    //   256	261	114	java/io/FileNotFoundException
    //   276	289	114	java/io/FileNotFoundException
    //   294	303	114	java/io/FileNotFoundException
    //   315	340	114	java/io/FileNotFoundException
    //   348	362	114	java/io/FileNotFoundException
    //   367	406	114	java/io/FileNotFoundException
    //   416	458	114	java/io/FileNotFoundException
    //   507	549	114	java/io/FileNotFoundException
    //   583	625	114	java/io/FileNotFoundException
    //   135	139	141	java/io/IOException
    //   294	303	409	android/content/pm/PackageManager$NameNotFoundException
    //   315	340	409	android/content/pm/PackageManager$NameNotFoundException
    //   348	362	409	android/content/pm/PackageManager$NameNotFoundException
    //   367	406	409	android/content/pm/PackageManager$NameNotFoundException
    //   71	78	461	java/io/IOException
    //   83	91	461	java/io/IOException
    //   102	111	461	java/io/IOException
    //   153	161	461	java/io/IOException
    //   166	182	461	java/io/IOException
    //   187	195	461	java/io/IOException
    //   200	221	461	java/io/IOException
    //   226	235	461	java/io/IOException
    //   245	251	461	java/io/IOException
    //   256	261	461	java/io/IOException
    //   276	289	461	java/io/IOException
    //   294	303	461	java/io/IOException
    //   315	340	461	java/io/IOException
    //   348	362	461	java/io/IOException
    //   367	406	461	java/io/IOException
    //   416	458	461	java/io/IOException
    //   507	549	461	java/io/IOException
    //   583	625	461	java/io/IOException
    //   487	491	493	java/io/IOException
    //   294	303	500	java/lang/NumberFormatException
    //   315	340	500	java/lang/NumberFormatException
    //   348	362	500	java/lang/NumberFormatException
    //   367	406	500	java/lang/NumberFormatException
    //   71	78	552	finally
    //   83	91	552	finally
    //   102	111	552	finally
    //   153	161	552	finally
    //   166	182	552	finally
    //   187	195	552	finally
    //   200	221	552	finally
    //   226	235	552	finally
    //   245	251	552	finally
    //   256	261	552	finally
    //   276	289	552	finally
    //   294	303	552	finally
    //   315	340	552	finally
    //   348	362	552	finally
    //   367	406	552	finally
    //   416	458	552	finally
    //   471	475	552	finally
    //   507	549	552	finally
    //   583	625	552	finally
    //   294	303	576	java/lang/Exception
    //   315	340	576	java/lang/Exception
    //   348	362	576	java/lang/Exception
    //   367	406	576	java/lang/Exception
    //   632	636	647	java/io/IOException
    //   640	644	655	java/io/IOException
    //   127	131	663	java/io/IOException
    //   479	483	671	java/io/IOException
    //   562	566	679	java/io/IOException
    //   570	574	687	java/io/IOException
    //   43	58	695	finally
    //   58	66	703	finally
    //   119	123	709	finally
    //   43	58	717	java/io/IOException
    //   58	66	725	java/io/IOException
    //   43	58	731	java/io/FileNotFoundException
    //   58	66	739	java/io/FileNotFoundException
  }
  
  public static void a(Context paramContext)
  {
    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("appcenter_app_report", 0).edit();
    localEditor.putLong("app_last_fullReport_success_time", SystemClock.currentThreadTimeMillis());
    localEditor.putBoolean("is_app_last_fullReport_success", true);
    localEditor.putBoolean("is_incremental_report_overflow", false);
    localEditor.commit();
    if (new File(paramContext.getFilesDir() + File.separator + "appcenter_app_report_storage_file.txt").exists())
    {
      a.lock();
      paramContext.deleteFile("appcenter_app_report_storage_file.txt");
      a.unlock();
    }
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    if (paramString == null) {
      return;
    }
    LogUtility.b("AppReport", "save package <" + paramString + " : " + paramInt + "> to local");
    Object localObject5 = null;
    Object localObject6 = null;
    Object localObject4 = null;
    Object localObject2 = localObject4;
    Object localObject3 = localObject5;
    localObject1 = localObject6;
    try
    {
      a.lock();
      localObject2 = localObject4;
      localObject3 = localObject5;
      localObject1 = localObject6;
      paramContext = paramContext.openFileOutput("appcenter_app_report_storage_file.txt", 32768);
      localObject2 = paramContext;
      localObject3 = paramContext;
      localObject1 = paramContext;
      paramContext.write((paramString + ":" + paramInt + ",").getBytes());
      if (paramContext != null) {}
      try
      {
        paramContext.close();
        a.unlock();
        return;
      }
      catch (IOException paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
        }
      }
      try
      {
        ((FileOutputStream)localObject1).close();
        a.unlock();
        throw paramContext;
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
    }
    catch (FileNotFoundException paramContext)
    {
      localObject1 = localObject2;
      paramContext.printStackTrace();
      if (localObject2 != null) {}
      try
      {
        ((FileOutputStream)localObject2).close();
        a.unlock();
        return;
      }
      catch (IOException paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
        }
      }
    }
    catch (IOException paramContext)
    {
      localObject1 = localObject3;
      paramContext.printStackTrace();
      if (localObject3 != null) {}
      try
      {
        ((FileOutputStream)localObject3).close();
        a.unlock();
        return;
      }
      catch (IOException paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
        }
      }
    }
    finally
    {
      if (localObject1 == null) {}
    }
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt, String paramString2, WebView paramWebView, String paramString3)
  {
    ThreadManager.d(new wui(paramString1, paramInt, paramContext, paramString2, paramWebView, paramString3));
  }
  
  public static void a(Context paramContext, String paramString1, WebView paramWebView, String paramString2, boolean paramBoolean)
  {
    ThreadManager.d(new wuj(paramContext, paramString1, paramWebView, paramString2, paramBoolean));
  }
  
  public static boolean a()
  {
    boolean bool = OpenConfig.a(CommonDataAdapter.a().a(), null).b("C_Full_Report");
    LogUtility.c("AppReport", "<AppReport>, app full report switch : " + bool);
    return bool;
  }
  
  public static boolean a(Context paramContext)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("appcenter_app_report", 0);
    long l1 = localSharedPreferences.getLong("full_report_date", 0L);
    int i1 = localSharedPreferences.getInt("full_report_day_times", 0);
    if (SystemClock.currentThreadTimeMillis() - l1 > 86400000L)
    {
      paramContext = paramContext.getSharedPreferences("appcenter_app_report", 0).edit();
      paramContext.putLong("full_report_date", SystemClock.currentThreadTimeMillis());
      paramContext.putInt("full_report_day_times", 0);
      paramContext.commit();
      return true;
    }
    if (i1 > 10) {
      return false;
    }
    paramContext = paramContext.getSharedPreferences("appcenter_app_report", 0).edit();
    paramContext.putInt("full_report_day_times", i1 + 1);
    paramContext.commit();
    return true;
  }
  
  public static void b(Context paramContext)
  {
    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("appcenter_app_report", 0).edit();
    localEditor.putBoolean("is_app_last_fullReport_success", false);
    localEditor.commit();
    if (new File(paramContext.getFilesDir() + File.separator + "appcenter_app_report_storage_file.txt").exists())
    {
      a.lock();
      paramContext.deleteFile("appcenter_app_report_storage_file.txt");
      a.unlock();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\business\base\appreport\AppReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */