package com.tencent.mobileqq.startup.step;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public class UpdateAvSo
  extends Step
{
  private static final String a = "AVModuleExtract";
  private static final String c = "so_sp";
  private static final String d = "key_so_version_";
  private static final String e = "first_qq_lauch_";
  private static final String f = "first_av_lauch_";
  
  public static long a()
  {
    long l = SystemClock.uptimeMillis();
    SharedPreferences localSharedPreferences = BaseApplicationImpl.a.getSharedPreferences("so_sp", 0);
    if (localSharedPreferences.getLong("first_av_lauch_229354", 0L) != 0L) {
      return 0L;
    }
    localSharedPreferences.edit().putLong("first_av_lauch_229354", l).commit();
    return l - b();
  }
  
  public static String a()
  {
    File localFile = BaseApplicationImpl.a.getFilesDir();
    if (localFile == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AVModuleExtract", 2, "getFilesDir is null");
      }
      return "";
    }
    return localFile.getParent() + "/txlib/";
  }
  
  private static String a(String paramString)
  {
    return "lib" + paramString + ".so";
  }
  
  public static void a()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.a;
    b(localBaseApplicationImpl, "VideoCtrl", true);
    b(localBaseApplicationImpl, "traeimp-armeabi-v7a", true);
    b(localBaseApplicationImpl, "qav_graphics", true);
    b(localBaseApplicationImpl, "qav_gaudio_engine", true);
    b(localBaseApplicationImpl, "qav_utils", true);
    b(localBaseApplicationImpl, "qav_media_engine", true);
  }
  
  public static boolean a(Context paramContext)
  {
    if (VcSystemInfo.f() <= 2) {
      if ((!a(paramContext, "traeimp-armeabi")) || (!a(paramContext, "TcVpxDec-armeabi")) || (!a(paramContext, "TcVpxEnc-armeabi"))) {}
    }
    while ((a(paramContext, "TcHevcDec")) && (a(paramContext, "TcHevcEnc")) && (a(paramContext, "traeopus-armeabi-v7a")))
    {
      return true;
      return false;
    }
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 9) {}
    for (paramContext = paramContext.getApplicationInfo().nativeLibraryDir + "/";; paramContext = paramContext.getApplicationInfo().dataDir + "/lib/")
    {
      paramContext = new File(paramContext + a(paramString));
      File localFile = new File(a() + a(paramString));
      if ((!paramContext.exists()) && (!localFile.exists())) {
        break;
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.e("AVModuleExtract", 2, "fail to find so:" + paramString);
    }
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AVModuleExtract", 2, "start LoadExtractedSo: " + paramString);
    }
    try
    {
      System.load(paramContext.getFilesDir().getParent() + "/txlib/" + a(paramString));
      paramBoolean = true;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
    {
      for (;;)
      {
        localFile = new File(paramContext.getFilesDir().getParent() + "/txlib/" + a(paramString));
        if (localFile.exists()) {
          localFile.delete();
        }
        b(paramContext, paramString, paramBoolean);
        try
        {
          System.load(paramContext.getFilesDir().getParent() + "/txlib/" + a(paramString));
          paramBoolean = true;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
        {
          paramBoolean = false;
        }
      }
    }
    if (!paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AVModuleExtract", 2, "finally try to use system way to load so: " + paramString);
      }
      try
      {
        System.loadLibrary(paramString);
        paramBoolean = true;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError3)
      {
        HashMap localHashMap;
        File localFile;
        for (;;) {}
      }
      if (!paramBoolean)
      {
        QLog.e("AVModuleExtract", 1, "LoadExtractedSo failed: " + paramString);
        localHashMap = new HashMap();
        localHashMap.put("soname", paramString);
        StatisticCollector.a(paramContext).a("", "AV_LOAD_SO_FAILED", false, 0L, 0L, localHashMap, "");
      }
      return paramBoolean;
    }
  }
  
  private static long b()
  {
    long l2 = BaseApplicationImpl.a.getSharedPreferences("so_sp", 0).getLong("first_qq_lauch_229354", 0L);
    long l1 = l2;
    if (l2 == 0L) {
      l1 = BaseApplicationImpl.c;
    }
    return l1;
  }
  
  private static String b()
  {
    return "lib/armeabi/";
  }
  
  private static void b()
  {
    Object localObject = BaseApplicationImpl.a.getSharedPreferences("so_sp", 0);
    if (QLog.isColorLevel()) {
      QLog.d("AVModuleExtract", 2, "setQQFirstLauchTime:" + BaseApplicationImpl.c);
    }
    localObject = ((SharedPreferences)localObject).edit();
    if (BaseApplicationImpl.c > 0L) {}
    for (long l = BaseApplicationImpl.c;; l = SystemClock.uptimeMillis())
    {
      ((SharedPreferences.Editor)localObject).putLong("first_qq_lauch_229354", l).commit();
      return;
    }
  }
  
  public static boolean b(Context paramContext)
  {
    return (a(paramContext, "TcVpxDec")) && (a(paramContext, "TcVpxEnc"));
  }
  
  /* Error */
  public static boolean b(Context paramContext, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: iconst_0
    //   4: istore 28
    //   6: iconst_0
    //   7: istore 29
    //   9: aload_0
    //   10: ldc 11
    //   12: iconst_0
    //   13: invokevirtual 42	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   16: astore 14
    //   18: ldc -13
    //   20: invokestatic 249	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   23: invokevirtual 252	java/lang/Integer:intValue	()I
    //   26: istore 19
    //   28: new 87	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   35: ldc 14
    //   37: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload_1
    //   41: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: astore 15
    //   49: aload 14
    //   51: aload 15
    //   53: iconst_m1
    //   54: invokeinterface 256 3 0
    //   59: istore 20
    //   61: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   64: ifeq +51 -> 115
    //   67: ldc 8
    //   69: iconst_2
    //   70: new 87	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   77: ldc_w 258
    //   80: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: aload_1
    //   84: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: ldc_w 260
    //   90: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: iload 20
    //   95: invokevirtual 263	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   98: ldc_w 265
    //   101: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: iload 19
    //   106: invokevirtual 263	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   109: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 83	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   115: invokestatic 167	com/tencent/mobileqq/startup/step/UpdateAvSo:a	()Ljava/lang/String;
    //   118: astore 17
    //   120: aload 17
    //   122: invokestatic 271	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   125: istore 27
    //   127: iload 27
    //   129: ifeq +17 -> 146
    //   132: iconst_0
    //   133: istore_2
    //   134: ldc 2
    //   136: monitorexit
    //   137: iload_2
    //   138: ireturn
    //   139: astore_3
    //   140: iconst_0
    //   141: istore 19
    //   143: goto -115 -> 28
    //   146: new 90	java/io/File
    //   149: dup
    //   150: new 87	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   157: aload 17
    //   159: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_1
    //   163: invokestatic 162	com/tencent/mobileqq/startup/step/UpdateAvSo:a	(Ljava/lang/String;)Ljava/lang/String;
    //   166: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: invokespecial 165	java/io/File:<init>	(Ljava/lang/String;)V
    //   175: astore 16
    //   177: iload 20
    //   179: iload 19
    //   181: if_icmpne +16 -> 197
    //   184: aload 16
    //   186: invokevirtual 170	java/io/File:exists	()Z
    //   189: ifeq +8 -> 197
    //   192: iconst_1
    //   193: istore_2
    //   194: goto -60 -> 134
    //   197: invokestatic 31	android/os/SystemClock:uptimeMillis	()J
    //   200: lstore 25
    //   202: aload 16
    //   204: invokevirtual 219	java/io/File:delete	()Z
    //   207: pop
    //   208: iload 29
    //   210: istore 27
    //   212: aload 16
    //   214: invokevirtual 170	java/io/File:exists	()Z
    //   217: ifne +88 -> 305
    //   220: iload_2
    //   221: ifeq +204 -> 425
    //   224: aload_0
    //   225: aload 17
    //   227: ldc_w 273
    //   230: aload_1
    //   231: invokestatic 162	com/tencent/mobileqq/startup/step/UpdateAvSo:a	(Ljava/lang/String;)Ljava/lang/String;
    //   234: invokestatic 278	com/tencent/mobileqq/utils/SoLoadUtil:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   237: istore 20
    //   239: iload 29
    //   241: istore 27
    //   243: aload 16
    //   245: invokevirtual 170	java/io/File:exists	()Z
    //   248: ifeq +57 -> 305
    //   251: iload 20
    //   253: ifeq +118 -> 371
    //   256: aload 16
    //   258: invokevirtual 219	java/io/File:delete	()Z
    //   261: pop
    //   262: new 87	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   269: ldc 85
    //   271: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: ldc_w 280
    //   277: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: astore_0
    //   284: iconst_0
    //   285: istore_2
    //   286: iload_2
    //   287: istore 27
    //   289: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   292: ifeq +13 -> 305
    //   295: ldc 8
    //   297: iconst_2
    //   298: aload_0
    //   299: invokestatic 192	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   302: iload_2
    //   303: istore 27
    //   305: invokestatic 31	android/os/SystemClock:uptimeMillis	()J
    //   308: lstore 21
    //   310: iload 27
    //   312: istore_2
    //   313: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   316: ifeq -182 -> 134
    //   319: ldc 8
    //   321: iconst_2
    //   322: new 87	java/lang/StringBuilder
    //   325: dup
    //   326: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   329: ldc_w 282
    //   332: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: aload_1
    //   336: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: ldc_w 284
    //   342: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: lload 21
    //   347: lload 25
    //   349: lsub
    //   350: invokevirtual 231	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   353: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   356: invokestatic 192	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   359: iload 27
    //   361: istore_2
    //   362: goto -228 -> 134
    //   365: astore_0
    //   366: ldc 2
    //   368: monitorexit
    //   369: aload_0
    //   370: athrow
    //   371: iload 19
    //   373: ifne +27 -> 400
    //   376: aload 14
    //   378: invokeinterface 54 1 0
    //   383: aload 15
    //   385: iconst_m1
    //   386: invokeinterface 288 3 0
    //   391: invokeinterface 64 1 0
    //   396: pop
    //   397: goto +1003 -> 1400
    //   400: aload 14
    //   402: invokeinterface 54 1 0
    //   407: aload 15
    //   409: iload 19
    //   411: invokeinterface 288 3 0
    //   416: invokeinterface 64 1 0
    //   421: pop
    //   422: goto +978 -> 1400
    //   425: aconst_null
    //   426: astore 10
    //   428: aconst_null
    //   429: astore 11
    //   431: aconst_null
    //   432: astore 12
    //   434: aconst_null
    //   435: astore 4
    //   437: aconst_null
    //   438: astore 9
    //   440: aconst_null
    //   441: astore 6
    //   443: aconst_null
    //   444: astore 13
    //   446: aconst_null
    //   447: astore_3
    //   448: aload 13
    //   450: astore 7
    //   452: aload 4
    //   454: astore 5
    //   456: aload 11
    //   458: astore 8
    //   460: new 90	java/io/File
    //   463: dup
    //   464: aload 17
    //   466: invokespecial 165	java/io/File:<init>	(Ljava/lang/String;)V
    //   469: astore 18
    //   471: aload 13
    //   473: astore 7
    //   475: aload 4
    //   477: astore 5
    //   479: aload 11
    //   481: astore 8
    //   483: aload 18
    //   485: invokevirtual 170	java/io/File:exists	()Z
    //   488: ifne +30 -> 518
    //   491: aload 13
    //   493: astore 7
    //   495: aload 4
    //   497: astore 5
    //   499: aload 11
    //   501: astore 8
    //   503: aload 18
    //   505: invokevirtual 291	java/io/File:mkdir	()Z
    //   508: istore 27
    //   510: iload 28
    //   512: istore_2
    //   513: iload 27
    //   515: ifeq +514 -> 1029
    //   518: aload 13
    //   520: astore 7
    //   522: aload 4
    //   524: astore 5
    //   526: aload 11
    //   528: astore 8
    //   530: aload_0
    //   531: invokevirtual 295	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   534: new 87	java/lang/StringBuilder
    //   537: dup
    //   538: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   541: invokestatic 297	com/tencent/mobileqq/startup/step/UpdateAvSo:b	()Ljava/lang/String;
    //   544: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: aload_1
    //   548: invokestatic 162	com/tencent/mobileqq/startup/step/UpdateAvSo:a	(Ljava/lang/String;)Ljava/lang/String;
    //   551: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   557: invokevirtual 303	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   560: astore 4
    //   562: aload 12
    //   564: astore_0
    //   565: aload 4
    //   567: ifnull +45 -> 612
    //   570: aload_3
    //   571: astore 7
    //   573: aload 4
    //   575: astore 5
    //   577: aload 11
    //   579: astore 8
    //   581: new 305	java/io/FileOutputStream
    //   584: dup
    //   585: new 87	java/lang/StringBuilder
    //   588: dup
    //   589: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   592: aload 17
    //   594: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: aload_1
    //   598: invokestatic 162	com/tencent/mobileqq/startup/step/UpdateAvSo:a	(Ljava/lang/String;)Ljava/lang/String;
    //   601: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   607: iconst_1
    //   608: invokespecial 308	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   611: astore_0
    //   612: lconst_0
    //   613: lstore 21
    //   615: aload_3
    //   616: astore 7
    //   618: aload 4
    //   620: astore 5
    //   622: aload_0
    //   623: astore 8
    //   625: sipush 8192
    //   628: newarray <illegal type>
    //   630: astore 6
    //   632: lload 21
    //   634: lstore 23
    //   636: aload 4
    //   638: ifnull +182 -> 820
    //   641: aload_3
    //   642: astore 7
    //   644: aload 4
    //   646: astore 5
    //   648: aload_0
    //   649: astore 8
    //   651: aload 4
    //   653: aload 6
    //   655: iconst_0
    //   656: aload 6
    //   658: arraylength
    //   659: invokevirtual 314	java/io/InputStream:read	([BII)I
    //   662: istore 20
    //   664: lload 21
    //   666: lstore 23
    //   668: iload 20
    //   670: iconst_m1
    //   671: if_icmpeq +149 -> 820
    //   674: aload_3
    //   675: astore 7
    //   677: aload 4
    //   679: astore 5
    //   681: aload_0
    //   682: astore 8
    //   684: aload_0
    //   685: aload 6
    //   687: iconst_0
    //   688: iload 20
    //   690: invokevirtual 320	java/io/OutputStream:write	([BII)V
    //   693: lload 21
    //   695: iload 20
    //   697: i2l
    //   698: ladd
    //   699: lstore 21
    //   701: goto -69 -> 632
    //   704: astore 4
    //   706: aconst_null
    //   707: astore 5
    //   709: aload 13
    //   711: astore 7
    //   713: aload 11
    //   715: astore 8
    //   717: aload_0
    //   718: invokevirtual 295	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   721: new 87	java/lang/StringBuilder
    //   724: dup
    //   725: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   728: invokestatic 297	com/tencent/mobileqq/startup/step/UpdateAvSo:b	()Ljava/lang/String;
    //   731: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   734: aload_1
    //   735: invokestatic 162	com/tencent/mobileqq/startup/step/UpdateAvSo:a	(Ljava/lang/String;)Ljava/lang/String;
    //   738: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   741: ldc_w 322
    //   744: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   747: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   750: invokevirtual 303	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   753: astore 6
    //   755: aload 6
    //   757: astore 4
    //   759: aload 6
    //   761: ifnull -199 -> 562
    //   764: aload 13
    //   766: astore 7
    //   768: aload 6
    //   770: astore 5
    //   772: aload 11
    //   774: astore 8
    //   776: aload_0
    //   777: invokevirtual 295	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   780: new 87	java/lang/StringBuilder
    //   783: dup
    //   784: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   787: invokestatic 297	com/tencent/mobileqq/startup/step/UpdateAvSo:b	()Ljava/lang/String;
    //   790: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   793: aload_1
    //   794: invokestatic 162	com/tencent/mobileqq/startup/step/UpdateAvSo:a	(Ljava/lang/String;)Ljava/lang/String;
    //   797: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   800: ldc_w 324
    //   803: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   806: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   809: invokevirtual 303	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   812: astore_3
    //   813: aload 6
    //   815: astore 4
    //   817: goto -255 -> 562
    //   820: aload_3
    //   821: ifnull +61 -> 882
    //   824: aload_3
    //   825: astore 7
    //   827: aload 4
    //   829: astore 5
    //   831: aload_0
    //   832: astore 8
    //   834: aload_3
    //   835: aload 6
    //   837: iconst_0
    //   838: aload 6
    //   840: arraylength
    //   841: invokevirtual 314	java/io/InputStream:read	([BII)I
    //   844: istore 20
    //   846: iload 20
    //   848: iconst_m1
    //   849: if_icmpeq +33 -> 882
    //   852: aload_3
    //   853: astore 7
    //   855: aload 4
    //   857: astore 5
    //   859: aload_0
    //   860: astore 8
    //   862: aload_0
    //   863: aload 6
    //   865: iconst_0
    //   866: iload 20
    //   868: invokevirtual 320	java/io/OutputStream:write	([BII)V
    //   871: lload 23
    //   873: iload 20
    //   875: i2l
    //   876: ladd
    //   877: lstore 23
    //   879: goto -59 -> 820
    //   882: iload 28
    //   884: istore_2
    //   885: aload_3
    //   886: astore 6
    //   888: aload 4
    //   890: astore 9
    //   892: aload_0
    //   893: astore 10
    //   895: aload_3
    //   896: astore 7
    //   898: aload 4
    //   900: astore 5
    //   902: aload_0
    //   903: astore 8
    //   905: aload 16
    //   907: invokevirtual 170	java/io/File:exists	()Z
    //   910: ifeq +119 -> 1029
    //   913: aload_3
    //   914: astore 7
    //   916: aload 4
    //   918: astore 5
    //   920: aload_0
    //   921: astore 8
    //   923: lload 23
    //   925: aload 16
    //   927: invokevirtual 327	java/io/File:length	()J
    //   930: lcmp
    //   931: ifeq +144 -> 1075
    //   934: aload_3
    //   935: astore 7
    //   937: aload 4
    //   939: astore 5
    //   941: aload_0
    //   942: astore 8
    //   944: aload 16
    //   946: invokevirtual 219	java/io/File:delete	()Z
    //   949: pop
    //   950: aload_3
    //   951: astore 7
    //   953: aload 4
    //   955: astore 5
    //   957: aload_0
    //   958: astore 8
    //   960: new 87	java/lang/StringBuilder
    //   963: dup
    //   964: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   967: ldc 85
    //   969: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   972: ldc_w 280
    //   975: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   978: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   981: astore 9
    //   983: aload_3
    //   984: astore 7
    //   986: aload 4
    //   988: astore 5
    //   990: aload_0
    //   991: astore 8
    //   993: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   996: ifeq +389 -> 1385
    //   999: aload_3
    //   1000: astore 7
    //   1002: aload 4
    //   1004: astore 5
    //   1006: aload_0
    //   1007: astore 8
    //   1009: ldc 8
    //   1011: iconst_2
    //   1012: aload 9
    //   1014: invokestatic 192	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1017: iconst_0
    //   1018: istore_2
    //   1019: aload_0
    //   1020: astore 10
    //   1022: aload 4
    //   1024: astore 9
    //   1026: aload_3
    //   1027: astore 6
    //   1029: aload 10
    //   1031: ifnull +8 -> 1039
    //   1034: aload 10
    //   1036: invokevirtual 330	java/io/OutputStream:close	()V
    //   1039: aload 9
    //   1041: ifnull +8 -> 1049
    //   1044: aload 9
    //   1046: invokevirtual 331	java/io/InputStream:close	()V
    //   1049: iload_2
    //   1050: istore 27
    //   1052: aload 6
    //   1054: ifnull -749 -> 305
    //   1057: aload 6
    //   1059: invokevirtual 331	java/io/InputStream:close	()V
    //   1062: iload_2
    //   1063: istore 27
    //   1065: goto -760 -> 305
    //   1068: astore_0
    //   1069: iload_2
    //   1070: istore 27
    //   1072: goto -767 -> 305
    //   1075: iload 19
    //   1077: ifne +37 -> 1114
    //   1080: aload_3
    //   1081: astore 7
    //   1083: aload 4
    //   1085: astore 5
    //   1087: aload_0
    //   1088: astore 8
    //   1090: aload 14
    //   1092: invokeinterface 54 1 0
    //   1097: aload 15
    //   1099: iconst_m1
    //   1100: invokeinterface 288 3 0
    //   1105: invokeinterface 64 1 0
    //   1110: pop
    //   1111: goto +295 -> 1406
    //   1114: aload_3
    //   1115: astore 7
    //   1117: aload 4
    //   1119: astore 5
    //   1121: aload_0
    //   1122: astore 8
    //   1124: aload 14
    //   1126: invokeinterface 54 1 0
    //   1131: aload 15
    //   1133: iload 19
    //   1135: invokeinterface 288 3 0
    //   1140: invokeinterface 64 1 0
    //   1145: pop
    //   1146: goto +260 -> 1406
    //   1149: astore 7
    //   1151: aload_3
    //   1152: astore 5
    //   1154: aload 4
    //   1156: astore_3
    //   1157: ldc 85
    //   1159: astore 6
    //   1161: aload_0
    //   1162: astore 4
    //   1164: aload 5
    //   1166: astore_0
    //   1167: aload 7
    //   1169: astore 5
    //   1171: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1174: ifeq +13 -> 1187
    //   1177: ldc 8
    //   1179: iconst_2
    //   1180: aload 6
    //   1182: aload 5
    //   1184: invokestatic 334	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1187: aload 4
    //   1189: ifnull +8 -> 1197
    //   1192: aload 4
    //   1194: invokevirtual 330	java/io/OutputStream:close	()V
    //   1197: aload_3
    //   1198: ifnull +7 -> 1205
    //   1201: aload_3
    //   1202: invokevirtual 331	java/io/InputStream:close	()V
    //   1205: aload_0
    //   1206: ifnull +173 -> 1379
    //   1209: aload_0
    //   1210: invokevirtual 331	java/io/InputStream:close	()V
    //   1213: iconst_0
    //   1214: istore 27
    //   1216: goto -911 -> 305
    //   1219: astore_0
    //   1220: iconst_0
    //   1221: istore 27
    //   1223: goto -918 -> 305
    //   1226: astore_0
    //   1227: aload 8
    //   1229: astore 4
    //   1231: aload 4
    //   1233: ifnull +8 -> 1241
    //   1236: aload 4
    //   1238: invokevirtual 330	java/io/OutputStream:close	()V
    //   1241: aload 5
    //   1243: ifnull +8 -> 1251
    //   1246: aload 5
    //   1248: invokevirtual 331	java/io/InputStream:close	()V
    //   1251: aload 7
    //   1253: ifnull +8 -> 1261
    //   1256: aload 7
    //   1258: invokevirtual 331	java/io/InputStream:close	()V
    //   1261: aload_0
    //   1262: athrow
    //   1263: astore_0
    //   1264: goto -225 -> 1039
    //   1267: astore_0
    //   1268: goto -219 -> 1049
    //   1271: astore 4
    //   1273: goto -76 -> 1197
    //   1276: astore_3
    //   1277: goto -72 -> 1205
    //   1280: astore_1
    //   1281: goto -40 -> 1241
    //   1284: astore_1
    //   1285: goto -34 -> 1251
    //   1288: astore_1
    //   1289: goto -28 -> 1261
    //   1292: astore_1
    //   1293: aload_0
    //   1294: astore 7
    //   1296: aload_1
    //   1297: astore_0
    //   1298: aload_3
    //   1299: astore 5
    //   1301: goto -70 -> 1231
    //   1304: astore 5
    //   1306: aconst_null
    //   1307: astore_0
    //   1308: aconst_null
    //   1309: astore_3
    //   1310: aconst_null
    //   1311: astore 4
    //   1313: ldc 85
    //   1315: astore 6
    //   1317: goto -146 -> 1171
    //   1320: astore 5
    //   1322: aconst_null
    //   1323: astore_0
    //   1324: aload 6
    //   1326: astore_3
    //   1327: aconst_null
    //   1328: astore 4
    //   1330: ldc 85
    //   1332: astore 6
    //   1334: goto -163 -> 1171
    //   1337: astore 5
    //   1339: aload_3
    //   1340: astore_0
    //   1341: aload 4
    //   1343: astore_3
    //   1344: aconst_null
    //   1345: astore 4
    //   1347: ldc 85
    //   1349: astore 6
    //   1351: goto -180 -> 1171
    //   1354: astore 5
    //   1356: aload_0
    //   1357: astore 6
    //   1359: aload 9
    //   1361: astore 7
    //   1363: aload_3
    //   1364: astore_0
    //   1365: aload 4
    //   1367: astore_3
    //   1368: aload 6
    //   1370: astore 4
    //   1372: aload 7
    //   1374: astore 6
    //   1376: goto -205 -> 1171
    //   1379: iconst_0
    //   1380: istore 27
    //   1382: goto -1077 -> 305
    //   1385: iconst_0
    //   1386: istore_2
    //   1387: aload_3
    //   1388: astore 6
    //   1390: aload 4
    //   1392: astore 9
    //   1394: aload_0
    //   1395: astore 10
    //   1397: goto -368 -> 1029
    //   1400: iconst_1
    //   1401: istore 27
    //   1403: goto -1098 -> 305
    //   1406: iconst_1
    //   1407: istore_2
    //   1408: aload_3
    //   1409: astore 6
    //   1411: aload 4
    //   1413: astore 9
    //   1415: aload_0
    //   1416: astore 10
    //   1418: goto -389 -> 1029
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1421	0	paramContext	Context
    //   0	1421	1	paramString	String
    //   0	1421	2	paramBoolean	boolean
    //   139	1	3	localNumberFormatException	NumberFormatException
    //   447	755	3	localObject1	Object
    //   1276	23	3	localIOException1	java.io.IOException
    //   1309	100	3	localObject2	Object
    //   435	243	4	localInputStream	java.io.InputStream
    //   704	1	4	localFileNotFoundException	java.io.FileNotFoundException
    //   757	480	4	localObject3	Object
    //   1271	1	4	localIOException2	java.io.IOException
    //   1311	101	4	localObject4	Object
    //   454	846	5	localObject5	Object
    //   1304	1	5	localIOException3	java.io.IOException
    //   1320	1	5	localIOException4	java.io.IOException
    //   1337	1	5	localIOException5	java.io.IOException
    //   1354	1	5	localIOException6	java.io.IOException
    //   441	969	6	localObject6	Object
    //   450	666	7	localObject7	Object
    //   1149	108	7	localIOException7	java.io.IOException
    //   1294	79	7	localObject8	Object
    //   458	770	8	localObject9	Object
    //   438	976	9	localObject10	Object
    //   426	991	10	localContext	Context
    //   429	344	11	localObject11	Object
    //   432	131	12	localObject12	Object
    //   444	321	13	localObject13	Object
    //   16	1109	14	localSharedPreferences	SharedPreferences
    //   47	1085	15	str1	String
    //   175	770	16	localFile1	File
    //   118	475	17	str2	String
    //   469	35	18	localFile2	File
    //   26	1108	19	i	int
    //   59	815	20	j	int
    //   308	392	21	l1	long
    //   634	290	23	l2	long
    //   200	148	25	l3	long
    //   125	1277	27	bool1	boolean
    //   4	879	28	bool2	boolean
    //   7	233	29	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   18	28	139	java/lang/NumberFormatException
    //   9	18	365	finally
    //   18	28	365	finally
    //   28	115	365	finally
    //   115	127	365	finally
    //   146	177	365	finally
    //   184	192	365	finally
    //   197	208	365	finally
    //   212	220	365	finally
    //   224	239	365	finally
    //   243	251	365	finally
    //   256	284	365	finally
    //   289	302	365	finally
    //   305	310	365	finally
    //   313	359	365	finally
    //   376	397	365	finally
    //   400	422	365	finally
    //   1034	1039	365	finally
    //   1044	1049	365	finally
    //   1057	1062	365	finally
    //   1192	1197	365	finally
    //   1201	1205	365	finally
    //   1209	1213	365	finally
    //   1236	1241	365	finally
    //   1246	1251	365	finally
    //   1256	1261	365	finally
    //   1261	1263	365	finally
    //   530	562	704	java/io/FileNotFoundException
    //   1057	1062	1068	java/io/IOException
    //   625	632	1149	java/io/IOException
    //   651	664	1149	java/io/IOException
    //   684	693	1149	java/io/IOException
    //   834	846	1149	java/io/IOException
    //   862	871	1149	java/io/IOException
    //   905	913	1149	java/io/IOException
    //   923	934	1149	java/io/IOException
    //   944	950	1149	java/io/IOException
    //   960	983	1149	java/io/IOException
    //   1090	1111	1149	java/io/IOException
    //   1124	1146	1149	java/io/IOException
    //   1209	1213	1219	java/io/IOException
    //   460	471	1226	finally
    //   483	491	1226	finally
    //   503	510	1226	finally
    //   530	562	1226	finally
    //   581	612	1226	finally
    //   625	632	1226	finally
    //   651	664	1226	finally
    //   684	693	1226	finally
    //   717	755	1226	finally
    //   776	813	1226	finally
    //   834	846	1226	finally
    //   862	871	1226	finally
    //   905	913	1226	finally
    //   923	934	1226	finally
    //   944	950	1226	finally
    //   960	983	1226	finally
    //   993	999	1226	finally
    //   1009	1017	1226	finally
    //   1090	1111	1226	finally
    //   1124	1146	1226	finally
    //   1034	1039	1263	java/io/IOException
    //   1044	1049	1267	java/io/IOException
    //   1192	1197	1271	java/io/IOException
    //   1201	1205	1276	java/io/IOException
    //   1236	1241	1280	java/io/IOException
    //   1246	1251	1284	java/io/IOException
    //   1256	1261	1288	java/io/IOException
    //   1171	1187	1292	finally
    //   460	471	1304	java/io/IOException
    //   483	491	1304	java/io/IOException
    //   503	510	1304	java/io/IOException
    //   530	562	1304	java/io/IOException
    //   717	755	1304	java/io/IOException
    //   776	813	1320	java/io/IOException
    //   581	612	1337	java/io/IOException
    //   993	999	1354	java/io/IOException
    //   1009	1017	1354	java/io/IOException
  }
  
  protected boolean a()
  {
    a();
    b();
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\startup\step\UpdateAvSo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */