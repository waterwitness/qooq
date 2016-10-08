package com.tencent.open.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.appcommon.AppClient;
import com.tencent.open.appcommon.Common;
import com.tencent.open.base.APNUtil;
import com.tencent.open.base.LogUtility;
import com.tencent.open.component.cache.CacheManager;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.common.IntentFactory;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import mqq.manager.TicketManager;
import wpo;

public class OpenAppClient
{
  protected static int a = 0;
  public static final String a;
  protected static boolean a = false;
  protected static int b = 0;
  public static final String b = "schemaurl";
  protected static final int c = 0;
  public static final String c = "uin";
  protected static final int d = 1;
  public static final String d = "vkey";
  protected static final int e = 2;
  protected static String e;
  protected static final int f = 1;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = OpenAppClient.class.getName();
    jdField_a_of_type_Int = 7;
    jdField_b_of_type_Int = 11;
  }
  
  public static Intent a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    LogUtility.b(jdField_a_of_type_JavaLangString, "onPcPushMsgBackground " + paramString1);
    if (APNUtil.c(paramContext))
    {
      Object localObject = Common.a(paramString1);
      ((HashMap)localObject).put("schemaUrl", paramString1);
      ((HashMap)localObject).put("friendUin", paramString2);
      ((HashMap)localObject).put("istroop", paramInt + "");
      if (a(paramContext, (HashMap)localObject)) {
        return null;
      }
      paramContext = (String)((HashMap)localObject).get("appid");
      String str1 = (String)((HashMap)localObject).get("packname");
      String str2 = (String)((HashMap)localObject).get("downurl");
      localObject = (String)((HashMap)localObject).get("appname");
      String str3 = "_" + paramContext;
      if (DownloadApi.a(paramContext))
      {
        new Handler(Looper.getMainLooper()).post(new wpo(paramContext, (String)localObject, str1, str3, str2, paramString1, paramString2, paramInt));
        return null;
      }
      return IntentFactory.a(paramString1, paramString2, paramInt);
    }
    return IntentFactory.a(paramString1, paramString2, paramInt);
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle)
  {
    for (;;)
    {
      String str2;
      Object localObject;
      try
      {
        boolean bool = jdField_a_of_type_Boolean;
        if (bool) {
          return;
        }
        jdField_a_of_type_Boolean = true;
        str2 = paramBundle.getString("schemaurl");
        localObject = paramBundle.getString("uin");
        String str1 = paramBundle.getString("vkey");
        if (localObject != null)
        {
          paramBundle = (Bundle)localObject;
          if (!((String)localObject).equals("0")) {}
        }
        else
        {
          paramBundle = String.valueOf(CommonDataAdapter.a().a());
        }
        localObject = str1;
        if (TextUtils.isEmpty(str1)) {
          localObject = CommonDataAdapter.a().a();
        }
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          ThreadManager.b(new OpenAppClient.GetVkeyRunnable(paramActivity, 1, str2));
          continue;
        }
        jdField_a_of_type_Boolean = false;
      }
      finally {}
      AppClient.a(paramActivity, str2, paramBundle, (String)localObject);
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    LogUtility.b(jdField_a_of_type_JavaLangString, "onPcPushMsgForground " + paramString);
    if (APNUtil.c(paramContext)) {
      a(paramContext, Common.a(paramString));
    }
  }
  
  /* Error */
  public static void a(Context paramContext, HashMap paramHashMap)
  {
    // Byte code:
    //   0: getstatic 37	com/tencent/open/adapter/OpenAppClient:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3: new 48	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   10: ldc -57
    //   12: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_1
    //   16: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   19: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: invokestatic 63	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   25: iconst_m1
    //   26: istore 11
    //   28: iconst_m1
    //   29: istore 12
    //   31: aload_1
    //   32: ldc 95
    //   34: invokevirtual 99	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   37: checkcast 101	java/lang/String
    //   40: astore 6
    //   42: aload_1
    //   43: ldc 103
    //   45: invokevirtual 99	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   48: checkcast 101	java/lang/String
    //   51: astore 7
    //   53: aload_1
    //   54: ldc -52
    //   56: invokevirtual 99	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   59: checkcast 101	java/lang/String
    //   62: astore_3
    //   63: aload_1
    //   64: ldc 105
    //   66: invokevirtual 99	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   69: checkcast 101	java/lang/String
    //   72: astore 8
    //   74: aload_1
    //   75: ldc -50
    //   77: invokevirtual 99	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   80: checkcast 101	java/lang/String
    //   83: astore 4
    //   85: aload_1
    //   86: ldc 107
    //   88: invokevirtual 99	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   91: checkcast 101	java/lang/String
    //   94: astore_1
    //   95: aload_1
    //   96: astore_2
    //   97: aload_1
    //   98: invokestatic 172	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   101: ifeq +6 -> 107
    //   104: ldc 90
    //   106: astore_2
    //   107: new 48	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   114: ldc 109
    //   116: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload 6
    //   121: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: astore 9
    //   129: invokestatic 211	com/tencent/open/downloadnew/DownloadManager:a	()Lcom/tencent/open/downloadnew/DownloadManager;
    //   132: aload 6
    //   134: invokevirtual 213	com/tencent/open/downloadnew/DownloadManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   137: astore_1
    //   138: aload 7
    //   140: invokestatic 218	com/tencent/open/business/base/AppUtil:a	(Ljava/lang/String;)I
    //   143: ifle +10 -> 153
    //   146: aload 7
    //   148: invokestatic 218	com/tencent/open/business/base/AppUtil:a	(Ljava/lang/String;)I
    //   151: istore 11
    //   153: aload_1
    //   154: invokestatic 220	com/tencent/open/business/base/AppUtil:b	(Ljava/lang/String;)I
    //   157: ifle +9 -> 166
    //   160: aload_1
    //   161: invokestatic 220	com/tencent/open/business/base/AppUtil:b	(Ljava/lang/String;)I
    //   164: istore 12
    //   166: getstatic 37	com/tencent/open/adapter/OpenAppClient:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   169: new 48	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   176: ldc -34
    //   178: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: iload 11
    //   183: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   186: ldc -32
    //   188: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: iload 12
    //   193: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   196: ldc -30
    //   198: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: iload 12
    //   203: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   206: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: invokestatic 228	com/tencent/open/base/LogUtility:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   212: aload_3
    //   213: invokestatic 233	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   216: invokevirtual 237	java/lang/Integer:intValue	()I
    //   219: istore 13
    //   221: aconst_null
    //   222: astore_1
    //   223: aconst_null
    //   224: astore 5
    //   226: aload 4
    //   228: invokestatic 172	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   231: ifne +158 -> 389
    //   234: aload 4
    //   236: ldc -17
    //   238: invokevirtual 243	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   241: astore 10
    //   243: aload 10
    //   245: ifnull +291 -> 536
    //   248: aload 10
    //   250: arraylength
    //   251: iconst_2
    //   252: if_icmplt +284 -> 536
    //   255: new 48	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   262: astore_3
    //   263: iconst_0
    //   264: istore 14
    //   266: aload_3
    //   267: astore_1
    //   268: iload 14
    //   270: aload 10
    //   272: arraylength
    //   273: if_icmpge +265 -> 538
    //   276: iload 14
    //   278: iconst_1
    //   279: if_icmpeq +71 -> 350
    //   282: aload_3
    //   283: aload 10
    //   285: iload 14
    //   287: aaload
    //   288: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: iload 14
    //   294: aload 10
    //   296: arraylength
    //   297: iconst_1
    //   298: isub
    //   299: if_icmpeq +10 -> 309
    //   302: aload_3
    //   303: ldc -11
    //   305: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: pop
    //   309: iload 14
    //   311: iconst_1
    //   312: iadd
    //   313: istore 14
    //   315: goto -49 -> 266
    //   318: astore_1
    //   319: getstatic 37	com/tencent/open/adapter/OpenAppClient:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   322: new 48	java/lang/StringBuilder
    //   325: dup
    //   326: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   329: ldc -9
    //   331: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: aload_3
    //   335: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: invokestatic 249	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   344: iconst_0
    //   345: istore 13
    //   347: goto -126 -> 221
    //   350: aload_3
    //   351: aload 10
    //   353: iload 14
    //   355: aaload
    //   356: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: ldc -11
    //   361: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: ldc -5
    //   366: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: pop
    //   370: goto -78 -> 292
    //   373: astore 5
    //   375: aload_3
    //   376: astore_1
    //   377: aload 5
    //   379: astore_3
    //   380: getstatic 37	com/tencent/open/adapter/OpenAppClient:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   383: ldc -3
    //   385: aload_3
    //   386: invokestatic 256	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   389: aload 4
    //   391: astore_3
    //   392: aload_1
    //   393: ifnull +8 -> 401
    //   396: aload_1
    //   397: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: astore_3
    //   401: new 258	com/tencent/open/downloadnew/common/NoticeParam
    //   404: dup
    //   405: invokespecial 259	com/tencent/open/downloadnew/common/NoticeParam:<init>	()V
    //   408: astore_1
    //   409: aload_1
    //   410: aload 6
    //   412: putfield 260	com/tencent/open/downloadnew/common/NoticeParam:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   415: aload_1
    //   416: aload_2
    //   417: putfield 262	com/tencent/open/downloadnew/common/NoticeParam:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   420: aload_1
    //   421: aload 7
    //   423: putfield 264	com/tencent/open/downloadnew/common/NoticeParam:d	Ljava/lang/String;
    //   426: aload_1
    //   427: aload 9
    //   429: putfield 266	com/tencent/open/downloadnew/common/NoticeParam:f	Ljava/lang/String;
    //   432: new 144	android/os/Bundle
    //   435: dup
    //   436: invokespecial 267	android/os/Bundle:<init>	()V
    //   439: astore 4
    //   441: aload 4
    //   443: ldc_w 269
    //   446: aload 6
    //   448: invokevirtual 272	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   451: aload 4
    //   453: ldc -50
    //   455: aload_3
    //   456: invokevirtual 272	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   459: aload 4
    //   461: ldc_w 274
    //   464: aload 8
    //   466: invokevirtual 272	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   469: aload 4
    //   471: ldc_w 276
    //   474: aload 7
    //   476: invokevirtual 272	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   479: aload 4
    //   481: ldc_w 278
    //   484: ldc_w 280
    //   487: invokevirtual 272	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   490: iload 13
    //   492: iload 11
    //   494: if_icmpgt +47 -> 541
    //   497: ldc_w 282
    //   500: ldc_w 284
    //   503: aload 6
    //   505: invokestatic 289	com/tencent/open/business/base/StaticAnalyz:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   508: aload_1
    //   509: iconst_2
    //   510: putfield 290	com/tencent/open/downloadnew/common/NoticeParam:jdField_b_of_type_Int	I
    //   513: aload_1
    //   514: aload 8
    //   516: putfield 292	com/tencent/open/downloadnew/common/NoticeParam:e	Ljava/lang/String;
    //   519: aload_1
    //   520: aload 4
    //   522: invokestatic 295	com/tencent/open/downloadnew/common/IntentFactory:a	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   525: putfield 298	com/tencent/open/downloadnew/common/NoticeParam:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   528: invokestatic 303	com/tencent/open/downloadnew/common/AppNotificationManager:a	()Lcom/tencent/open/downloadnew/common/AppNotificationManager;
    //   531: aload_1
    //   532: invokevirtual 306	com/tencent/open/downloadnew/common/AppNotificationManager:a	(Lcom/tencent/open/downloadnew/common/NoticeParam;)V
    //   535: return
    //   536: aconst_null
    //   537: astore_1
    //   538: goto -149 -> 389
    //   541: iload 13
    //   543: iload 12
    //   545: if_icmpgt +75 -> 620
    //   548: ldc_w 282
    //   551: ldc_w 308
    //   554: aload 6
    //   556: invokestatic 289	com/tencent/open/business/base/StaticAnalyz:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   559: aload_1
    //   560: iconst_3
    //   561: putfield 290	com/tencent/open/downloadnew/common/NoticeParam:jdField_b_of_type_Int	I
    //   564: aload_1
    //   565: aload 8
    //   567: putfield 292	com/tencent/open/downloadnew/common/NoticeParam:e	Ljava/lang/String;
    //   570: aload_1
    //   571: aload 4
    //   573: invokestatic 295	com/tencent/open/downloadnew/common/IntentFactory:a	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   576: putfield 298	com/tencent/open/downloadnew/common/NoticeParam:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   579: invokestatic 303	com/tencent/open/downloadnew/common/AppNotificationManager:a	()Lcom/tencent/open/downloadnew/common/AppNotificationManager;
    //   582: aload_1
    //   583: invokevirtual 306	com/tencent/open/downloadnew/common/AppNotificationManager:a	(Lcom/tencent/open/downloadnew/common/NoticeParam;)V
    //   586: invokestatic 211	com/tencent/open/downloadnew/DownloadManager:a	()Lcom/tencent/open/downloadnew/DownloadManager;
    //   589: aload 6
    //   591: invokevirtual 213	com/tencent/open/downloadnew/DownloadManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   594: astore_1
    //   595: aload_1
    //   596: invokestatic 309	com/tencent/open/business/base/AppUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   599: ifnull +11 -> 610
    //   602: aload_0
    //   603: aload_1
    //   604: invokestatic 312	com/tencent/open/business/base/AppUtil:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   607: ifeq -72 -> 535
    //   610: getstatic 37	com/tencent/open/adapter/OpenAppClient:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   613: ldc_w 314
    //   616: invokestatic 249	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   619: return
    //   620: invokestatic 211	com/tencent/open/downloadnew/DownloadManager:a	()Lcom/tencent/open/downloadnew/DownloadManager;
    //   623: aload 6
    //   625: invokevirtual 317	com/tencent/open/downloadnew/DownloadManager:a	(Ljava/lang/String;)Lcom/tencent/open/downloadnew/DownloadInfo;
    //   628: ifnull +14 -> 642
    //   631: ldc_w 282
    //   634: ldc_w 319
    //   637: aload 6
    //   639: invokestatic 289	com/tencent/open/business/base/StaticAnalyz:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   642: aload 4
    //   644: invokestatic 295	com/tencent/open/downloadnew/common/IntentFactory:a	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   647: astore_0
    //   648: aload 7
    //   650: ifnull +50 -> 700
    //   653: aload 7
    //   655: invokevirtual 322	java/lang/String:trim	()Ljava/lang/String;
    //   658: ldc 90
    //   660: invokevirtual 154	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   663: ifne +37 -> 700
    //   666: iconst_1
    //   667: istore 15
    //   669: new 324	com/tencent/open/downloadnew/DownloadInfo
    //   672: dup
    //   673: aload 6
    //   675: aload 8
    //   677: invokevirtual 322	java/lang/String:trim	()Ljava/lang/String;
    //   680: aload 7
    //   682: aload_2
    //   683: aload_3
    //   684: aload_0
    //   685: iconst_0
    //   686: iload 15
    //   688: invokespecial 327	com/tencent/open/downloadnew/DownloadInfo:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;IZ)V
    //   691: astore_0
    //   692: invokestatic 211	com/tencent/open/downloadnew/DownloadManager:a	()Lcom/tencent/open/downloadnew/DownloadManager;
    //   695: aload_0
    //   696: invokevirtual 330	com/tencent/open/downloadnew/DownloadManager:a	(Lcom/tencent/open/downloadnew/DownloadInfo;)V
    //   699: return
    //   700: iconst_0
    //   701: istore 15
    //   703: goto -34 -> 669
    //   706: astore_3
    //   707: aload 5
    //   709: astore_1
    //   710: goto -330 -> 380
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	713	0	paramContext	Context
    //   0	713	1	paramHashMap	HashMap
    //   96	587	2	localObject1	Object
    //   62	622	3	localObject2	Object
    //   706	1	3	localException1	Exception
    //   83	560	4	localObject3	Object
    //   224	1	5	localObject4	Object
    //   373	335	5	localException2	Exception
    //   40	634	6	str1	String
    //   51	630	7	str2	String
    //   72	604	8	str3	String
    //   127	301	9	str4	String
    //   241	111	10	arrayOfString	String[]
    //   26	469	11	i	int
    //   29	517	12	j	int
    //   219	327	13	k	int
    //   264	90	14	m	int
    //   667	35	15	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   212	221	318	java/lang/NumberFormatException
    //   268	276	373	java/lang/Exception
    //   282	292	373	java/lang/Exception
    //   292	309	373	java/lang/Exception
    //   350	370	373	java/lang/Exception
    //   234	243	706	java/lang/Exception
    //   248	263	706	java/lang/Exception
  }
  
  public static void a(AppInterface paramAppInterface)
  {
    CacheManager.a(CommonDataAdapter.a().a());
    String str = "";
    if (paramAppInterface != null)
    {
      if (!(paramAppInterface instanceof QQAppInterface)) {
        break label70;
      }
      ((TicketManager)paramAppInterface.getManager(2)).getSkey(paramAppInterface.getAccount());
      str = ((QQAppInterface)paramAppInterface).getAccount();
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str)) {}
      label70:
      try
      {
        CommonDataAdapter.a().a(Long.valueOf(str).longValue());
        return;
      }
      catch (Exception paramAppInterface) {}
      if ((paramAppInterface instanceof BrowserAppInterface))
      {
        str = ((BrowserAppInterface)paramAppInterface).getAccount();
        ThreadManager.d(new OpenAppClient.GetVkeyRunnable(paramAppInterface, 0, ""));
      }
    }
  }
  
  /* Error */
  protected static boolean a(Context paramContext, HashMap paramHashMap)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: invokevirtual 378	java/util/HashMap:size	()I
    //   8: ifne +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: aload_1
    //   14: ldc_w 380
    //   17: invokevirtual 99	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   20: checkcast 101	java/lang/String
    //   23: invokestatic 383	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   26: istore_3
    //   27: iload_3
    //   28: iconst_1
    //   29: if_icmpne +84 -> 113
    //   32: aload_1
    //   33: ldc 95
    //   35: invokevirtual 99	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   38: checkcast 101	java/lang/String
    //   41: invokestatic 114	com/tencent/open/downloadnew/DownloadApi:a	(Ljava/lang/String;)Z
    //   44: istore 4
    //   46: iload 4
    //   48: ifeq +21 -> 69
    //   51: iconst_0
    //   52: ireturn
    //   53: astore_2
    //   54: getstatic 37	com/tencent/open/adapter/OpenAppClient:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   57: ldc_w 385
    //   60: aload_2
    //   61: invokestatic 387	com/tencent/open/base/LogUtility:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   64: iconst_m1
    //   65: istore_3
    //   66: goto -39 -> 27
    //   69: new 389	wpp
    //   72: dup
    //   73: aload_0
    //   74: aload_1
    //   75: invokespecial 391	wpp:<init>	(Landroid/content/Context;Ljava/util/HashMap;)V
    //   78: invokestatic 184	com/tencent/mobileqq/app/ThreadManager:b	(Ljava/lang/Runnable;)V
    //   81: iconst_1
    //   82: ireturn
    //   83: astore_0
    //   84: new 48	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   91: ldc_w 393
    //   94: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload_1
    //   98: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: astore_1
    //   105: getstatic 37	com/tencent/open/adapter/OpenAppClient:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   108: aload_1
    //   109: aload_0
    //   110: invokestatic 256	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   113: iconst_0
    //   114: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	paramContext	Context
    //   0	115	1	paramHashMap	HashMap
    //   53	8	2	localNumberFormatException	NumberFormatException
    //   26	40	3	i	int
    //   44	3	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   13	27	53	java/lang/NumberFormatException
    //   32	46	83	java/lang/Exception
    //   69	81	83	java/lang/Exception
  }
  
  public static void b(Activity paramActivity, Bundle paramBundle)
  {
    for (;;)
    {
      try
      {
        boolean bool = jdField_a_of_type_Boolean;
        if (bool) {
          return;
        }
        jdField_a_of_type_Boolean = true;
        String str = paramBundle.getString("schemaurl");
        paramBundle.getString("uin");
        if (TextUtils.isEmpty(str)) {
          jdField_a_of_type_Boolean = false;
        } else {
          try
          {
            ThreadManager.d(new OpenAppClient.GetVkeyRunnable(paramActivity, 2, new URL(str).getQuery()));
          }
          catch (MalformedURLException paramActivity)
          {
            paramActivity.printStackTrace();
            jdField_a_of_type_Boolean = false;
          }
        }
      }
      finally {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\adapter\OpenAppClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */