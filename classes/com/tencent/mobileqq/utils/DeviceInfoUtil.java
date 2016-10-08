package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Debug.MemoryInfo;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ProcessStats;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Method;

public class DeviceInfoUtil
{
  public static float a = 0.0F;
  public static final int a = 1024;
  private static long jdField_a_of_type_Long = 0L;
  public static final String a = "DeviceInfoUtil";
  private static String[] jdField_a_of_type_ArrayOfJavaLangString;
  public static int b = 0;
  private static long jdField_b_of_type_Long = 0L;
  private static final String jdField_b_of_type_JavaLangString = "top -n 1 -m 10";
  private static int jdField_c_of_type_Int = 0;
  private static long jdField_c_of_type_Long = 0L;
  private static final String jdField_c_of_type_JavaLangString = "top -n 1 -m 10 -t";
  private static long jdField_d_of_type_Long;
  private static String jdField_d_of_type_JavaLangString;
  private static String e;
  private static String f;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "HTC Sensation XL with Beats Audio X315e", "Dell V04B", "HTC Sensation Z710e", "HTC Sensation XL with Beats", "HTC Sensation(XE)" };
    jdField_d_of_type_JavaLangString = "";
    e = "";
    jdField_a_of_type_Float = 1.0F;
  }
  
  public static float a()
  {
    a();
    return jdField_a_of_type_Float;
  }
  
  public static int a()
  {
    return Integer.parseInt(Build.VERSION.SDK);
  }
  
  public static int a(Activity paramActivity)
  {
    int i = 0;
    if (paramActivity != null)
    {
      paramActivity = paramActivity.getWindowManager().getDefaultDisplay();
      if (paramActivity.getWidth() == paramActivity.getHeight()) {
        i = 3;
      }
    }
    else
    {
      return i;
    }
    if (paramActivity.getWidth() < paramActivity.getHeight()) {
      return 1;
    }
    return 2;
  }
  
  public static long a()
  {
    if (jdField_c_of_type_Long > 0L) {
      return jdField_c_of_type_Long;
    }
    int i = 0;
    int j = b();
    while ((jdField_c_of_type_Long <= 0L) && (i < j))
    {
      try
      {
        BufferedReader localBufferedReader = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpu" + i + "/cpufreq/cpuinfo_max_freq"), 1024);
        String str = localBufferedReader.readLine();
        if (str != null)
        {
          jdField_c_of_type_Long = Long.parseLong(str);
          jdField_c_of_type_Long /= 1024L;
        }
        localBufferedReader.close();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DeviceInfoUtil", 2, "getCpuFrequency = " + jdField_c_of_type_Long + "; CpuNum = " + (i - 1));
    }
    return jdField_c_of_type_Long;
  }
  
  public static long a(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      return Debug.getPss() * 1024L;
    }
    try
    {
      BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
      if (localBaseApplication != null)
      {
        paramInt = ((ActivityManager)localBaseApplication.getSystemService("activity")).getProcessMemoryInfo(new int[] { paramInt })[0].getTotalPss();
        return paramInt * 1024L;
      }
      return -1L;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return -1L;
  }
  
  public static DeviceInfoUtil.NetInfo a(Context paramContext)
  {
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    NetworkInfo localNetworkInfo = AppNetConnInfo.getRecentNetworkInfo();
    DeviceInfoUtil.NetInfo localNetInfo = new DeviceInfoUtil.NetInfo();
    localNetInfo.c = paramContext.getNetworkOperatorName();
    if ((localNetworkInfo != null) && (localNetworkInfo.isAvailable())) {}
    switch (localNetworkInfo.getType())
    {
    case 7: 
    case 8: 
    default: 
      localNetInfo.a = "unknown";
      localNetInfo.b = "unknown";
      return localNetInfo;
    case 9: 
      localNetInfo.a = "cable";
      return localNetInfo;
    case 1: 
    case 6: 
      localNetInfo.a = "WIFI";
      return localNetInfo;
    }
    switch (paramContext.getNetworkType())
    {
    default: 
      localNetInfo.a = "2G";
      localNetInfo.b = "unknown";
      return localNetInfo;
    case 13: 
      localNetInfo.a = "4G";
      localNetInfo.b = "LTE";
      return localNetInfo;
    case 3: 
      localNetInfo.a = "3G";
      localNetInfo.b = "UMTS";
      return localNetInfo;
    case 5: 
      localNetInfo.a = "3G";
      localNetInfo.b = "EVDO_0";
      return localNetInfo;
    case 6: 
      localNetInfo.a = "3G";
      localNetInfo.b = "EVDO_A";
      return localNetInfo;
    case 8: 
      localNetInfo.a = "3G";
      localNetInfo.b = "SDPA";
      return localNetInfo;
    case 9: 
      localNetInfo.a = "3G";
      localNetInfo.b = "HSUPA";
      return localNetInfo;
    case 10: 
      localNetInfo.a = "3G";
      localNetInfo.b = "HSPA";
      return localNetInfo;
    case 12: 
      localNetInfo.a = "3G";
      localNetInfo.b = "EVDO_B";
      return localNetInfo;
    case 14: 
      localNetInfo.a = "3G";
      localNetInfo.b = "EHRPD";
      return localNetInfo;
    case 15: 
      localNetInfo.a = "3G";
      localNetInfo.b = "HSPAP";
      return localNetInfo;
    case 1: 
      localNetInfo.a = "2G";
      localNetInfo.b = "GPRS";
      return localNetInfo;
    case 2: 
      localNetInfo.a = "2G";
      localNetInfo.b = "EDGE";
      return localNetInfo;
    case 4: 
      localNetInfo.a = "2G";
      localNetInfo.b = "CDMA";
      return localNetInfo;
    case 7: 
      localNetInfo.a = "2G";
      localNetInfo.b = "1xRTT";
      return localNetInfo;
    case 11: 
      localNetInfo.a = "2G";
      localNetInfo.b = "IDEN";
      return localNetInfo;
    }
    localNetInfo.a = "2G";
    localNetInfo.b = "unknown";
    return localNetInfo;
  }
  
  public static String a()
  {
    if ((jdField_d_of_type_JavaLangString != null) && (jdField_d_of_type_JavaLangString.length() > 0)) {
      return jdField_d_of_type_JavaLangString;
    }
    try
    {
      jdField_d_of_type_JavaLangString = ((TelephonyManager)BaseApplicationImpl.getContext().getSystemService("phone")).getDeviceId();
      return jdField_d_of_type_JavaLangString;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public static String a(Context paramContext)
  {
    if (!TextUtils.isEmpty(f)) {
      return f;
    }
    if (paramContext != null) {
      try
      {
        PackageManager localPackageManager = paramContext.getPackageManager();
        if (localPackageManager != null)
        {
          paramContext = localPackageManager.getPackageInfo(paramContext.getPackageName(), 0);
          if (paramContext != null)
          {
            f = paramContext.versionName + "." + paramContext.versionCode;
            paramContext = f;
            return paramContext;
          }
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    f = "6.5.5.0";
    return f;
  }
  
  private static String a(String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (paramArrayOfString == null)
    {
      localObject = "";
      return (String)localObject;
    }
    if ((paramInt1 < 0) || (paramArrayOfString.length < paramInt2)) {
      return "";
    }
    String str = "";
    paramInt1 = 2;
    for (;;)
    {
      localObject = str;
      if (paramInt1 >= paramArrayOfString.length) {
        break;
      }
      str = str + paramArrayOfString[paramInt1] + " ";
      paramInt1 += 1;
    }
  }
  
  private static void a()
  {
    if ((jdField_a_of_type_Long == 0L) || (jdField_b_of_type_Long == 0L))
    {
      Object localObject = BaseApplicationImpl.getContext();
      DisplayMetrics localDisplayMetrics = ((Context)localObject).getResources().getDisplayMetrics();
      jdField_a_of_type_Long = localDisplayMetrics.widthPixels;
      jdField_b_of_type_Long = localDisplayMetrics.heightPixels;
      jdField_a_of_type_Float = localDisplayMetrics.density;
      jdField_b_of_type_Int = localDisplayMetrics.densityDpi;
      localObject = ((Context)localObject).getResources().getConfiguration();
      if (localObject != null)
      {
        jdField_c_of_type_Int = ((Configuration)localObject).orientation;
        if (QLog.isColorLevel()) {
          QLog.i("DeviceInfoUtil", 2, "initDispalyParams, [" + jdField_c_of_type_Int + "," + jdField_a_of_type_Long + "," + jdField_b_of_type_Long + "]");
        }
      }
    }
  }
  
  public static boolean a()
  {
    boolean bool2 = false;
    String str = d();
    boolean bool1 = bool2;
    int i;
    if (str != null) {
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < jdField_a_of_type_ArrayOfJavaLangString.length)
      {
        if (jdField_a_of_type_ArrayOfJavaLangString[i].equals(str)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static long[] a()
  {
    try
    {
      long l1 = b() / 1048576L;
      StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
      long l2 = localStatFs.getBlockSize();
      l2 = localStatFs.getAvailableBlocks() * l2 / 1048576L;
      return new long[] { l1, l2 };
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return tmp66_60;
  }
  
  public static int b()
  {
    return ProcessStats.a();
  }
  
  public static long b()
  {
    StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
    long l = localStatFs.getBlockSize();
    return localStatFs.getBlockCount() * l;
  }
  
  /* Error */
  public static long b(int paramInt)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore 12
    //   3: aconst_null
    //   4: astore_2
    //   5: aconst_null
    //   6: astore_3
    //   7: iconst_0
    //   8: istore 8
    //   10: invokestatic 408	com/tencent/mobileqq/utils/DeviceInfoUtil:a	()I
    //   13: bipush 9
    //   15: if_icmpge +106 -> 121
    //   18: iload_0
    //   19: ifne +95 -> 114
    //   22: invokestatic 414	android/hardware/Camera:open	()Landroid/hardware/Camera;
    //   25: astore_1
    //   26: aload_1
    //   27: invokevirtual 418	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   30: invokevirtual 424	android/hardware/Camera$Parameters:getSupportedPictureSizes	()Ljava/util/List;
    //   33: iconst_0
    //   34: invokeinterface 430 2 0
    //   39: checkcast 432	android/hardware/Camera$Size
    //   42: astore_2
    //   43: aload_2
    //   44: getfield 435	android/hardware/Camera$Size:height	I
    //   47: istore_0
    //   48: aload_2
    //   49: getfield 438	android/hardware/Camera$Size:width	I
    //   52: istore 8
    //   54: iload 8
    //   56: iload_0
    //   57: imul
    //   58: i2l
    //   59: lstore 12
    //   61: lload 12
    //   63: lstore 10
    //   65: aload_1
    //   66: ifnull +11 -> 77
    //   69: aload_1
    //   70: invokevirtual 441	android/hardware/Camera:release	()V
    //   73: lload 12
    //   75: lstore 10
    //   77: lload 10
    //   79: lstore 12
    //   81: lload 12
    //   83: lreturn
    //   84: astore_1
    //   85: aconst_null
    //   86: astore_1
    //   87: aload_1
    //   88: ifnull +376 -> 464
    //   91: aload_1
    //   92: invokevirtual 441	android/hardware/Camera:release	()V
    //   95: lconst_0
    //   96: lstore 10
    //   98: goto -21 -> 77
    //   101: astore_2
    //   102: aconst_null
    //   103: astore_1
    //   104: aload_1
    //   105: ifnull +7 -> 112
    //   108: aload_1
    //   109: invokevirtual 441	android/hardware/Camera:release	()V
    //   112: aload_2
    //   113: athrow
    //   114: iload_0
    //   115: iconst_1
    //   116: if_icmpne -35 -> 81
    //   119: lconst_0
    //   120: lreturn
    //   121: invokestatic 443	com/tencent/mobileqq/utils/DeviceInfoUtil:c	()I
    //   124: istore 9
    //   126: aload_2
    //   127: astore_1
    //   128: ldc_w 445
    //   131: invokestatic 451	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   134: astore 7
    //   136: aload_2
    //   137: astore_1
    //   138: aload 7
    //   140: invokevirtual 455	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   143: astore 4
    //   145: aload_2
    //   146: astore_1
    //   147: aload 7
    //   149: ldc_w 457
    //   152: invokevirtual 461	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   155: astore 5
    //   157: aload_2
    //   158: astore_1
    //   159: aload 5
    //   161: iconst_1
    //   162: invokevirtual 467	java/lang/reflect/Field:setAccessible	(Z)V
    //   165: aload_2
    //   166: astore_1
    //   167: ldc_w 469
    //   170: invokestatic 451	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   173: astore 6
    //   175: aload_2
    //   176: astore_1
    //   177: aload 6
    //   179: ldc_w 471
    //   182: iconst_2
    //   183: anewarray 447	java/lang/Class
    //   186: dup
    //   187: iconst_0
    //   188: getstatic 475	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   191: aastore
    //   192: dup
    //   193: iconst_1
    //   194: aload 7
    //   196: aastore
    //   197: invokevirtual 479	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   200: astore 7
    //   202: aload_2
    //   203: astore_1
    //   204: aload 7
    //   206: iconst_1
    //   207: invokevirtual 482	java/lang/reflect/Method:setAccessible	(Z)V
    //   210: aload_2
    //   211: astore_1
    //   212: aload 6
    //   214: ldc_w 483
    //   217: iconst_1
    //   218: anewarray 447	java/lang/Class
    //   221: dup
    //   222: iconst_0
    //   223: getstatic 475	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   226: aastore
    //   227: invokevirtual 479	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   230: astore 6
    //   232: aload_2
    //   233: astore_1
    //   234: aload 6
    //   236: iconst_1
    //   237: invokevirtual 482	java/lang/reflect/Method:setAccessible	(Z)V
    //   240: iload 8
    //   242: iload 9
    //   244: if_icmpge +214 -> 458
    //   247: aload_2
    //   248: astore_1
    //   249: aload 7
    //   251: aconst_null
    //   252: iconst_2
    //   253: anewarray 4	java/lang/Object
    //   256: dup
    //   257: iconst_0
    //   258: iload 8
    //   260: invokestatic 487	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   263: aastore
    //   264: dup
    //   265: iconst_1
    //   266: aload 4
    //   268: aastore
    //   269: invokevirtual 491	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   272: pop
    //   273: aload_2
    //   274: astore_1
    //   275: aload 5
    //   277: aload 4
    //   279: invokevirtual 494	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   282: checkcast 71	java/lang/Integer
    //   285: invokevirtual 497	java/lang/Integer:intValue	()I
    //   288: iload_0
    //   289: if_icmpne +108 -> 397
    //   292: aload_2
    //   293: astore_1
    //   294: aload 6
    //   296: aconst_null
    //   297: iconst_1
    //   298: anewarray 4	java/lang/Object
    //   301: dup
    //   302: iconst_0
    //   303: iload 8
    //   305: invokestatic 487	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   308: aastore
    //   309: invokevirtual 491	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   312: checkcast 410	android/hardware/Camera
    //   315: astore_2
    //   316: lload 12
    //   318: lstore 10
    //   320: aload_2
    //   321: ifnull +61 -> 382
    //   324: aload_2
    //   325: invokevirtual 418	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   328: invokevirtual 424	android/hardware/Camera$Parameters:getSupportedPictureSizes	()Ljava/util/List;
    //   331: astore_1
    //   332: lload 12
    //   334: lstore 10
    //   336: aload_1
    //   337: ifnull +45 -> 382
    //   340: lload 12
    //   342: lstore 10
    //   344: aload_1
    //   345: invokeinterface 499 1 0
    //   350: ifne +32 -> 382
    //   353: aload_1
    //   354: iconst_0
    //   355: invokeinterface 430 2 0
    //   360: checkcast 432	android/hardware/Camera$Size
    //   363: astore_1
    //   364: aload_1
    //   365: getfield 435	android/hardware/Camera$Size:height	I
    //   368: istore_0
    //   369: aload_1
    //   370: getfield 438	android/hardware/Camera$Size:width	I
    //   373: istore 8
    //   375: iload 8
    //   377: iload_0
    //   378: imul
    //   379: i2l
    //   380: lstore 10
    //   382: lload 10
    //   384: lstore 12
    //   386: aload_2
    //   387: ifnull -306 -> 81
    //   390: aload_2
    //   391: invokevirtual 441	android/hardware/Camera:release	()V
    //   394: lload 10
    //   396: lreturn
    //   397: iload 8
    //   399: iconst_1
    //   400: iadd
    //   401: istore 8
    //   403: goto -163 -> 240
    //   406: astore_1
    //   407: aload_3
    //   408: astore_2
    //   409: aload_1
    //   410: astore_3
    //   411: aload_2
    //   412: astore_1
    //   413: aload_3
    //   414: invokevirtual 148	java/lang/Exception:printStackTrace	()V
    //   417: aload_2
    //   418: ifnull -337 -> 81
    //   421: aload_2
    //   422: invokevirtual 441	android/hardware/Camera:release	()V
    //   425: lconst_0
    //   426: lreturn
    //   427: astore_3
    //   428: aload_1
    //   429: astore_2
    //   430: aload_3
    //   431: astore_1
    //   432: aload_2
    //   433: ifnull +7 -> 440
    //   436: aload_2
    //   437: invokevirtual 441	android/hardware/Camera:release	()V
    //   440: aload_1
    //   441: athrow
    //   442: astore_1
    //   443: goto -11 -> 432
    //   446: astore_3
    //   447: goto -36 -> 411
    //   450: astore_2
    //   451: goto -347 -> 104
    //   454: astore_2
    //   455: goto -368 -> 87
    //   458: iconst_m1
    //   459: istore 8
    //   461: goto -169 -> 292
    //   464: lconst_0
    //   465: lstore 10
    //   467: goto -390 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	470	0	paramInt	int
    //   25	45	1	localCamera	android.hardware.Camera
    //   84	1	1	localException1	Exception
    //   86	284	1	localObject1	Object
    //   406	4	1	localException2	Exception
    //   412	29	1	localObject2	Object
    //   442	1	1	localObject3	Object
    //   4	45	2	localSize	android.hardware.Camera.Size
    //   101	192	2	localObject4	Object
    //   315	122	2	localObject5	Object
    //   450	1	2	localObject6	Object
    //   454	1	2	localException3	Exception
    //   6	408	3	localObject7	Object
    //   427	4	3	localObject8	Object
    //   446	1	3	localException4	Exception
    //   143	135	4	localObject9	Object
    //   155	121	5	localField	java.lang.reflect.Field
    //   173	122	6	localObject10	Object
    //   134	116	7	localObject11	Object
    //   8	452	8	i	int
    //   124	121	9	j	int
    //   63	403	10	l1	long
    //   1	384	12	l2	long
    // Exception table:
    //   from	to	target	type
    //   22	26	84	java/lang/Exception
    //   22	26	101	finally
    //   128	136	406	java/lang/Exception
    //   138	145	406	java/lang/Exception
    //   147	157	406	java/lang/Exception
    //   159	165	406	java/lang/Exception
    //   167	175	406	java/lang/Exception
    //   177	202	406	java/lang/Exception
    //   204	210	406	java/lang/Exception
    //   212	232	406	java/lang/Exception
    //   234	240	406	java/lang/Exception
    //   249	273	406	java/lang/Exception
    //   275	292	406	java/lang/Exception
    //   294	316	406	java/lang/Exception
    //   128	136	427	finally
    //   138	145	427	finally
    //   147	157	427	finally
    //   159	165	427	finally
    //   167	175	427	finally
    //   177	202	427	finally
    //   204	210	427	finally
    //   212	232	427	finally
    //   234	240	427	finally
    //   249	273	427	finally
    //   275	292	427	finally
    //   294	316	427	finally
    //   413	417	427	finally
    //   324	332	442	finally
    //   344	375	442	finally
    //   324	332	446	java/lang/Exception
    //   344	375	446	java/lang/Exception
    //   26	54	450	finally
    //   26	54	454	java/lang/Exception
  }
  
  public static String b()
  {
    if ((e != null) && (e.length() > 0)) {
      return e;
    }
    try
    {
      e = ((TelephonyManager)BaseApplicationImpl.getContext().getSystemService("phone")).getSubscriberId();
      return e;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public static String b(Context paramContext)
  {
    paramContext = (WifiManager)paramContext.getSystemService("wifi");
    if (paramContext == null) {
      paramContext = null;
    }
    for (;;)
    {
      return paramContext;
      try
      {
        paramContext = paramContext.getConnectionInfo();
        if (paramContext == null) {
          return null;
        }
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          paramContext = null;
        }
        String str = paramContext.getBSSID();
        if ((!"N/A".equals(str)) && (!"00:00:00:00:00:00".equals(str)))
        {
          paramContext = str;
          if (!"FF:FF:FF:FF:FF:FF".equalsIgnoreCase(str)) {
            continue;
          }
        }
      }
    }
    return null;
  }
  
  public static boolean b()
  {
    String str = i();
    return (!TextUtils.isEmpty(str)) && (str.equals("Lenovo A366t")) && (Build.VERSION.SDK_INT == 10);
  }
  
  public static long[] b()
  {
    try
    {
      long[] arrayOfLong = new long[2];
      if ("mounted".equals(Environment.getExternalStorageState()))
      {
        StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        long l1 = localStatFs.getBlockSize();
        long l2 = localStatFs.getBlockCount();
        long l3 = localStatFs.getAvailableBlocks();
        arrayOfLong[0] = (l2 * l1 / 1048576L);
        arrayOfLong[1] = (l3 * l1 / 1048576L);
      }
      return arrayOfLong;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return tmp88_82;
  }
  
  public static int c()
  {
    try
    {
      Method localMethod = Class.forName("android.hardware.Camera").getMethod("getNumberOfCameras", new Class[0]);
      if (localMethod != null)
      {
        int i = ((Integer)localMethod.invoke(null, (Object[])null)).intValue();
        return i;
      }
    }
    catch (Exception localException)
    {
      return 0;
    }
    return 0;
  }
  
  /* Error */
  public static long c()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_0
    //   4: getstatic 546	com/tencent/mobileqq/utils/DeviceInfoUtil:jdField_d_of_type_Long	J
    //   7: lconst_0
    //   8: lcmp
    //   9: ifne +140 -> 149
    //   12: new 107	java/io/FileReader
    //   15: dup
    //   16: ldc_w 548
    //   19: invokespecial 128	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   22: astore_1
    //   23: new 105	java/io/BufferedReader
    //   26: dup
    //   27: aload_1
    //   28: sipush 1024
    //   31: invokespecial 131	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   34: astore_0
    //   35: aload_0
    //   36: invokevirtual 134	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   39: astore_2
    //   40: aload_2
    //   41: ifnull +25 -> 66
    //   44: aload_2
    //   45: ldc_w 550
    //   48: invokevirtual 554	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   51: iconst_1
    //   52: aaload
    //   53: invokestatic 557	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   56: invokevirtual 560	java/lang/Long:longValue	()J
    //   59: ldc2_w 141
    //   62: lmul
    //   63: putstatic 546	com/tencent/mobileqq/utils/DeviceInfoUtil:jdField_d_of_type_Long	J
    //   66: aload_0
    //   67: ifnull +7 -> 74
    //   70: aload_0
    //   71: invokevirtual 145	java/io/BufferedReader:close	()V
    //   74: aload_1
    //   75: ifnull +7 -> 82
    //   78: aload_1
    //   79: invokevirtual 561	java/io/FileReader:close	()V
    //   82: getstatic 546	com/tencent/mobileqq/utils/DeviceInfoUtil:jdField_d_of_type_Long	J
    //   85: lconst_0
    //   86: lcmp
    //   87: ifne +62 -> 149
    //   90: ldc2_w 562
    //   93: lreturn
    //   94: astore_1
    //   95: aconst_null
    //   96: astore_2
    //   97: aload_0
    //   98: astore_1
    //   99: aload_2
    //   100: astore_0
    //   101: lconst_0
    //   102: putstatic 546	com/tencent/mobileqq/utils/DeviceInfoUtil:jdField_d_of_type_Long	J
    //   105: aload_0
    //   106: ifnull +7 -> 113
    //   109: aload_0
    //   110: invokevirtual 145	java/io/BufferedReader:close	()V
    //   113: aload_1
    //   114: ifnull -32 -> 82
    //   117: aload_1
    //   118: invokevirtual 561	java/io/FileReader:close	()V
    //   121: goto -39 -> 82
    //   124: astore_0
    //   125: goto -43 -> 82
    //   128: astore_0
    //   129: aconst_null
    //   130: astore_1
    //   131: aload_2
    //   132: ifnull +7 -> 139
    //   135: aload_2
    //   136: invokevirtual 145	java/io/BufferedReader:close	()V
    //   139: aload_1
    //   140: ifnull +7 -> 147
    //   143: aload_1
    //   144: invokevirtual 561	java/io/FileReader:close	()V
    //   147: aload_0
    //   148: athrow
    //   149: getstatic 546	com/tencent/mobileqq/utils/DeviceInfoUtil:jdField_d_of_type_Long	J
    //   152: lreturn
    //   153: astore_1
    //   154: goto -7 -> 147
    //   157: astore_0
    //   158: goto -27 -> 131
    //   161: astore_3
    //   162: aload_0
    //   163: astore_2
    //   164: aload_3
    //   165: astore_0
    //   166: goto -35 -> 131
    //   169: astore_3
    //   170: aload_0
    //   171: astore_2
    //   172: aload_3
    //   173: astore_0
    //   174: goto -43 -> 131
    //   177: astore_0
    //   178: aconst_null
    //   179: astore_0
    //   180: goto -79 -> 101
    //   183: astore_2
    //   184: goto -83 -> 101
    //   187: astore_0
    //   188: goto -106 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   3	107	0	localObject1	Object
    //   124	1	0	localException1	Exception
    //   128	20	0	localObject2	Object
    //   157	6	0	localObject3	Object
    //   165	9	0	localObject4	Object
    //   177	1	0	localException2	Exception
    //   179	1	0	localObject5	Object
    //   187	1	0	localException3	Exception
    //   22	57	1	localFileReader	FileReader
    //   94	1	1	localException4	Exception
    //   98	46	1	localObject6	Object
    //   153	1	1	localException5	Exception
    //   1	171	2	localObject7	Object
    //   183	1	2	localException6	Exception
    //   161	4	3	localObject8	Object
    //   169	4	3	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   12	23	94	java/lang/Exception
    //   109	113	124	java/lang/Exception
    //   117	121	124	java/lang/Exception
    //   12	23	128	finally
    //   135	139	153	java/lang/Exception
    //   143	147	153	java/lang/Exception
    //   23	35	157	finally
    //   35	40	161	finally
    //   44	66	161	finally
    //   101	105	169	finally
    //   23	35	177	java/lang/Exception
    //   35	40	183	java/lang/Exception
    //   44	66	183	java/lang/Exception
    //   70	74	187	java/lang/Exception
    //   78	82	187	java/lang/Exception
  }
  
  public static String c()
  {
    try
    {
      Object localObject = BaseApplicationImpl.getContext();
      localObject = ((Context)localObject).getPackageManager().getPackageInfo(((Context)localObject).getPackageName(), 0).versionName;
      return (String)localObject;
    }
    catch (Exception localException) {}
    return "getVersionException";
  }
  
  public static String c(Context paramContext)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramContext != null)
    {
      paramContext = (WifiManager)paramContext.getSystemService("wifi");
      localObject1 = localObject2;
      if (paramContext == null) {}
    }
    for (;;)
    {
      try
      {
        paramContext = paramContext.getConnectionInfo();
        if (paramContext != null)
        {
          paramContext = paramContext.getMacAddress();
          localObject1 = paramContext;
          return (String)localObject1;
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        return null;
      }
      paramContext = null;
    }
  }
  
  public static boolean c()
  {
    return BaseApplicationImpl.getContext().getPackageManager().hasSystemFeature("android.hardware.touchscreen.multitouch");
  }
  
  public static int d()
  {
    a();
    return jdField_b_of_type_Int;
  }
  
  public static long d()
  {
    Object localObject = BaseApplicationImpl.getContext();
    if (localObject != null)
    {
      localObject = (ActivityManager)((Context)localObject).getSystemService("activity");
      ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
      ((ActivityManager)localObject).getMemoryInfo(localMemoryInfo);
      return localMemoryInfo.availMem;
    }
    return -1L;
  }
  
  public static String d()
  {
    return Build.MODEL;
  }
  
  public static boolean d()
  {
    return Build.VERSION.SDK_INT >= 8;
  }
  
  public static final int e()
  {
    String str = ((TelephonyManager)BaseApplicationImpl.a().getSystemService("phone")).getSubscriberId();
    if (!TextUtils.isEmpty(str))
    {
      if ((str.startsWith("46000")) || (str.startsWith("46002"))) {
        return 1;
      }
      if (str.startsWith("46001")) {
        return 2;
      }
      if (str.startsWith("46003")) {
        return 3;
      }
    }
    return 0;
  }
  
  public static long e()
  {
    return Runtime.getRuntime().maxMemory();
  }
  
  public static String e()
  {
    return Build.VERSION.RELEASE;
  }
  
  public static long f()
  {
    a();
    return jdField_a_of_type_Long;
  }
  
  public static String f()
  {
    String str = Settings.System.getString(BaseApplicationImpl.getContext().getContentResolver(), "android_id");
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    return "";
  }
  
  public static long g()
  {
    a();
    return jdField_b_of_type_Long;
  }
  
  /* Error */
  public static String g()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 107	java/io/FileReader
    //   5: dup
    //   6: ldc_w 632
    //   9: invokespecial 128	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   12: astore_0
    //   13: new 105	java/io/BufferedReader
    //   16: dup
    //   17: aload_0
    //   18: sipush 8192
    //   21: invokespecial 131	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   24: astore_2
    //   25: ldc_w 319
    //   28: astore_1
    //   29: ldc_w 319
    //   32: astore 4
    //   34: ldc_w 319
    //   37: astore_3
    //   38: ldc_w 319
    //   41: astore 7
    //   43: ldc 50
    //   45: astore 5
    //   47: aload 5
    //   49: ifnull +14 -> 63
    //   52: aload_2
    //   53: invokevirtual 134	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   56: astore 10
    //   58: aload 10
    //   60: ifnonnull +86 -> 146
    //   63: new 109	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   70: aload 7
    //   72: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: ldc_w 634
    //   78: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: aload_3
    //   82: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: ldc_w 634
    //   88: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload 4
    //   93: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: ldc_w 634
    //   99: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_1
    //   103: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: astore_1
    //   110: aload_2
    //   111: invokevirtual 145	java/io/BufferedReader:close	()V
    //   114: aload_0
    //   115: invokevirtual 561	java/io/FileReader:close	()V
    //   118: iconst_0
    //   119: ifeq +11 -> 130
    //   122: new 636	java/lang/NullPointerException
    //   125: dup
    //   126: invokespecial 637	java/lang/NullPointerException:<init>	()V
    //   129: athrow
    //   130: aload_1
    //   131: astore_0
    //   132: iconst_0
    //   133: ifeq +11 -> 144
    //   136: new 636	java/lang/NullPointerException
    //   139: dup
    //   140: invokespecial 637	java/lang/NullPointerException:<init>	()V
    //   143: athrow
    //   144: aload_0
    //   145: areturn
    //   146: aload 10
    //   148: ldc_w 550
    //   151: invokevirtual 554	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   154: astore 11
    //   156: aload 10
    //   158: astore 5
    //   160: aload 11
    //   162: ifnull -115 -> 47
    //   165: aload 10
    //   167: astore 5
    //   169: aload 11
    //   171: arraylength
    //   172: iconst_3
    //   173: if_icmplt -126 -> 47
    //   176: aload 11
    //   178: iconst_0
    //   179: aaload
    //   180: invokevirtual 640	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   183: astore 5
    //   185: aload 7
    //   187: astore 6
    //   189: aload 5
    //   191: ldc_w 642
    //   194: invokevirtual 645	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   197: ifeq +41 -> 238
    //   200: new 109	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   207: aload 7
    //   209: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: aload 11
    //   214: iconst_2
    //   215: aload 11
    //   217: arraylength
    //   218: invokestatic 647	com/tencent/mobileqq/utils/DeviceInfoUtil:a	([Ljava/lang/String;II)Ljava/lang/String;
    //   221: ldc_w 649
    //   224: ldc_w 651
    //   227: invokevirtual 655	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   230: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: astore 6
    //   238: aload_3
    //   239: astore 8
    //   241: aload 5
    //   243: ldc_w 657
    //   246: invokevirtual 645	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   249: ifeq +23 -> 272
    //   252: aload 11
    //   254: iconst_2
    //   255: aload 11
    //   257: arraylength
    //   258: invokestatic 647	com/tencent/mobileqq/utils/DeviceInfoUtil:a	([Ljava/lang/String;II)Ljava/lang/String;
    //   261: ldc_w 649
    //   264: ldc_w 651
    //   267: invokevirtual 655	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   270: astore 8
    //   272: aload 4
    //   274: astore 9
    //   276: aload 5
    //   278: ldc_w 659
    //   281: invokevirtual 645	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   284: ifeq +23 -> 307
    //   287: aload 11
    //   289: iconst_2
    //   290: aload 11
    //   292: arraylength
    //   293: invokestatic 647	com/tencent/mobileqq/utils/DeviceInfoUtil:a	([Ljava/lang/String;II)Ljava/lang/String;
    //   296: ldc_w 649
    //   299: ldc_w 651
    //   302: invokevirtual 655	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   305: astore 9
    //   307: aload 9
    //   309: astore 4
    //   311: aload 8
    //   313: astore_3
    //   314: aload 6
    //   316: astore 7
    //   318: aload 10
    //   320: astore 5
    //   322: aload 11
    //   324: iconst_1
    //   325: aaload
    //   326: invokevirtual 640	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   329: ldc_w 661
    //   332: invokevirtual 645	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   335: ifeq -288 -> 47
    //   338: aload 11
    //   340: aload 11
    //   342: arraylength
    //   343: iconst_1
    //   344: isub
    //   345: aaload
    //   346: astore_1
    //   347: aload 9
    //   349: astore 4
    //   351: aload 8
    //   353: astore_3
    //   354: aload 6
    //   356: astore 7
    //   358: aload 10
    //   360: astore 5
    //   362: goto -315 -> 47
    //   365: astore_3
    //   366: aconst_null
    //   367: astore 4
    //   369: ldc 50
    //   371: astore_1
    //   372: aload_2
    //   373: astore_0
    //   374: aload 4
    //   376: astore_2
    //   377: aload_3
    //   378: invokevirtual 148	java/lang/Exception:printStackTrace	()V
    //   381: aload_0
    //   382: ifnull +7 -> 389
    //   385: aload_0
    //   386: invokevirtual 561	java/io/FileReader:close	()V
    //   389: aload_1
    //   390: astore_0
    //   391: aload_2
    //   392: ifnull -248 -> 144
    //   395: aload_2
    //   396: invokevirtual 145	java/io/BufferedReader:close	()V
    //   399: aload_1
    //   400: areturn
    //   401: astore_0
    //   402: aload_1
    //   403: areturn
    //   404: astore_1
    //   405: aconst_null
    //   406: astore_2
    //   407: aconst_null
    //   408: astore_0
    //   409: aload_0
    //   410: ifnull +7 -> 417
    //   413: aload_0
    //   414: invokevirtual 561	java/io/FileReader:close	()V
    //   417: aload_2
    //   418: ifnull +7 -> 425
    //   421: aload_2
    //   422: invokevirtual 145	java/io/BufferedReader:close	()V
    //   425: aload_1
    //   426: athrow
    //   427: astore_0
    //   428: goto -298 -> 130
    //   431: astore_0
    //   432: aload_1
    //   433: areturn
    //   434: astore_0
    //   435: goto -46 -> 389
    //   438: astore_0
    //   439: goto -22 -> 417
    //   442: astore_0
    //   443: goto -18 -> 425
    //   446: astore_1
    //   447: aconst_null
    //   448: astore_2
    //   449: goto -40 -> 409
    //   452: astore_1
    //   453: goto -44 -> 409
    //   456: astore_1
    //   457: goto -48 -> 409
    //   460: astore_3
    //   461: aconst_null
    //   462: astore_2
    //   463: ldc 50
    //   465: astore_1
    //   466: goto -89 -> 377
    //   469: astore_3
    //   470: ldc 50
    //   472: astore_1
    //   473: goto -96 -> 377
    //   476: astore_3
    //   477: goto -100 -> 377
    //   480: astore_3
    //   481: aconst_null
    //   482: astore_2
    //   483: goto -106 -> 377
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	379	0	localObject1	Object
    //   401	1	0	localException1	Exception
    //   408	6	0	localObject2	Object
    //   427	1	0	localException2	Exception
    //   431	1	0	localException3	Exception
    //   434	1	0	localException4	Exception
    //   438	1	0	localException5	Exception
    //   442	1	0	localException6	Exception
    //   28	375	1	str1	String
    //   404	29	1	str2	String
    //   446	1	1	localObject3	Object
    //   452	1	1	localObject4	Object
    //   456	1	1	localObject5	Object
    //   465	8	1	str3	String
    //   1	482	2	localObject6	Object
    //   37	317	3	localObject7	Object
    //   365	13	3	localException7	Exception
    //   460	1	3	localException8	Exception
    //   469	1	3	localException9	Exception
    //   476	1	3	localException10	Exception
    //   480	1	3	localException11	Exception
    //   32	343	4	localObject8	Object
    //   45	316	5	localObject9	Object
    //   187	168	6	localObject10	Object
    //   41	316	7	localObject11	Object
    //   239	113	8	localObject12	Object
    //   274	74	9	localObject13	Object
    //   56	303	10	str4	String
    //   154	187	11	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   2	13	365	java/lang/Exception
    //   395	399	401	java/lang/Exception
    //   2	13	404	finally
    //   122	130	427	java/lang/Exception
    //   136	144	431	java/lang/Exception
    //   385	389	434	java/lang/Exception
    //   413	417	438	java/lang/Exception
    //   421	425	442	java/lang/Exception
    //   13	25	446	finally
    //   114	118	446	finally
    //   52	58	452	finally
    //   63	110	452	finally
    //   110	114	452	finally
    //   146	156	452	finally
    //   169	185	452	finally
    //   189	238	452	finally
    //   241	272	452	finally
    //   276	307	452	finally
    //   322	347	452	finally
    //   377	381	456	finally
    //   13	25	460	java/lang/Exception
    //   52	58	469	java/lang/Exception
    //   63	110	469	java/lang/Exception
    //   146	156	469	java/lang/Exception
    //   169	185	469	java/lang/Exception
    //   189	238	469	java/lang/Exception
    //   241	272	469	java/lang/Exception
    //   276	307	469	java/lang/Exception
    //   322	347	469	java/lang/Exception
    //   110	114	476	java/lang/Exception
    //   114	118	480	java/lang/Exception
  }
  
  public static long h()
  {
    
    if (jdField_c_of_type_Int == 2) {
      return jdField_b_of_type_Long;
    }
    return jdField_a_of_type_Long;
  }
  
  public static String h()
  {
    return Build.MANUFACTURER;
  }
  
  public static long i()
  {
    
    if (jdField_c_of_type_Int == 2) {
      return jdField_a_of_type_Long;
    }
    return jdField_b_of_type_Long;
  }
  
  public static String i()
  {
    return Build.MODEL;
  }
  
  public static long j()
  {
    int i = 0;
    a();
    if (jdField_c_of_type_Int == 1) {
      i = (int)Math.min(jdField_a_of_type_Long, jdField_b_of_type_Long);
    }
    for (;;)
    {
      return i;
      if (jdField_c_of_type_Int == 2) {
        i = (int)Math.max(jdField_a_of_type_Long, jdField_b_of_type_Long);
      }
    }
  }
  
  public static String j()
  {
    return Build.DISPLAY;
  }
  
  public static long k()
  {
    int i = 0;
    a();
    if (jdField_c_of_type_Int == 1) {
      i = (int)Math.max(jdField_a_of_type_Long, jdField_b_of_type_Long);
    }
    for (;;)
    {
      return i;
      if (jdField_c_of_type_Int == 2) {
        i = (int)Math.min(jdField_a_of_type_Long, jdField_b_of_type_Long);
      }
    }
  }
  
  public static String k()
  {
    try
    {
      Object localObject = Build.class.getDeclaredMethod("getString", new Class[] { String.class });
      ((Method)localObject).setAccessible(true);
      localObject = (String)((Method)localObject).invoke(null, new Object[] { "ro.product.manufacturer" });
      return (String)localObject;
    }
    catch (Exception localException1)
    {
      try
      {
        String str = Build.MANUFACTURER;
        return str;
      }
      catch (Exception localException2) {}
    }
    return "";
  }
  
  public static String l()
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    int i = localBaseApplication.getResources().getDisplayMetrics().widthPixels;
    int j = localBaseApplication.getResources().getDisplayMetrics().heightPixels;
    int k;
    if (localBaseApplication.getResources().getConfiguration().orientation == 2)
    {
      k = j;
      j = i;
    }
    for (;;)
    {
      return k + "X" + j;
      k = i;
    }
  }
  
  /* Error */
  public static String m()
  {
    // Byte code:
    //   0: new 694	java/io/FileInputStream
    //   3: dup
    //   4: ldc_w 696
    //   7: invokespecial 697	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   10: astore_2
    //   11: new 105	java/io/BufferedReader
    //   14: dup
    //   15: new 699	java/io/InputStreamReader
    //   18: dup
    //   19: aload_2
    //   20: invokespecial 702	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   23: sipush 8192
    //   26: invokespecial 131	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   29: astore_3
    //   30: ldc 50
    //   32: astore_0
    //   33: aload_3
    //   34: invokevirtual 134	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   37: astore_1
    //   38: aload_1
    //   39: ifnull +35 -> 74
    //   42: new 109	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   49: aload_0
    //   50: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: aload_1
    //   54: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: astore_1
    //   61: aload_1
    //   62: astore_0
    //   63: goto -30 -> 33
    //   66: astore_0
    //   67: aload_0
    //   68: invokevirtual 703	java/io/FileNotFoundException:printStackTrace	()V
    //   71: ldc 50
    //   73: areturn
    //   74: aload_3
    //   75: invokevirtual 145	java/io/BufferedReader:close	()V
    //   78: aload_2
    //   79: invokevirtual 706	java/io/InputStream:close	()V
    //   82: aload_0
    //   83: ldc 50
    //   85: if_acmpeq -14 -> 71
    //   88: aload_0
    //   89: aload_0
    //   90: ldc_w 708
    //   93: invokevirtual 711	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   96: ldc_w 708
    //   99: invokevirtual 279	java/lang/String:length	()I
    //   102: iadd
    //   103: invokevirtual 715	java/lang/String:substring	(I)Ljava/lang/String;
    //   106: astore_0
    //   107: aload_0
    //   108: iconst_0
    //   109: aload_0
    //   110: ldc_w 319
    //   113: invokevirtual 711	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   116: invokevirtual 718	java/lang/String:substring	(II)Ljava/lang/String;
    //   119: astore_0
    //   120: aload_0
    //   121: areturn
    //   122: astore_1
    //   123: aload_1
    //   124: invokevirtual 719	java/io/IOException:printStackTrace	()V
    //   127: goto -45 -> 82
    //   130: astore_1
    //   131: aload_1
    //   132: invokevirtual 719	java/io/IOException:printStackTrace	()V
    //   135: aload_3
    //   136: invokevirtual 145	java/io/BufferedReader:close	()V
    //   139: aload_2
    //   140: invokevirtual 706	java/io/InputStream:close	()V
    //   143: goto -61 -> 82
    //   146: astore_1
    //   147: aload_1
    //   148: invokevirtual 719	java/io/IOException:printStackTrace	()V
    //   151: goto -69 -> 82
    //   154: astore_0
    //   155: aload_3
    //   156: invokevirtual 145	java/io/BufferedReader:close	()V
    //   159: aload_2
    //   160: invokevirtual 706	java/io/InputStream:close	()V
    //   163: aload_0
    //   164: athrow
    //   165: astore_1
    //   166: aload_1
    //   167: invokevirtual 719	java/io/IOException:printStackTrace	()V
    //   170: goto -7 -> 163
    //   173: astore_0
    //   174: aload_0
    //   175: invokevirtual 720	java/lang/IndexOutOfBoundsException:printStackTrace	()V
    //   178: ldc 50
    //   180: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   32	31	0	localObject1	Object
    //   66	24	0	localFileNotFoundException	java.io.FileNotFoundException
    //   106	15	0	str1	String
    //   154	10	0	localObject2	Object
    //   173	2	0	localIndexOutOfBoundsException	IndexOutOfBoundsException
    //   37	25	1	str2	String
    //   122	2	1	localIOException1	java.io.IOException
    //   130	2	1	localIOException2	java.io.IOException
    //   146	2	1	localIOException3	java.io.IOException
    //   165	2	1	localIOException4	java.io.IOException
    //   10	150	2	localFileInputStream	java.io.FileInputStream
    //   29	127	3	localBufferedReader	BufferedReader
    // Exception table:
    //   from	to	target	type
    //   0	11	66	java/io/FileNotFoundException
    //   74	82	122	java/io/IOException
    //   33	38	130	java/io/IOException
    //   42	61	130	java/io/IOException
    //   135	143	146	java/io/IOException
    //   33	38	154	finally
    //   42	61	154	finally
    //   131	135	154	finally
    //   155	163	165	java/io/IOException
    //   88	120	173	java/lang/IndexOutOfBoundsException
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\utils\DeviceInfoUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */