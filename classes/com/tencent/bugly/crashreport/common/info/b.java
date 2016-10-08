package com.tencent.bugly.crashreport.common.info;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.tencent.bugly.proguard.a;
import com.tencent.bugly.proguard.v;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public final class b
{
  private static String a = null;
  private static String b = null;
  
  public static String a()
  {
    try
    {
      String str = Build.MODEL;
      return str;
    }
    catch (Throwable localThrowable)
    {
      if (!v.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return "fail";
  }
  
  public static String a(Context paramContext)
  {
    Object localObject;
    if (!AppInfo.a(paramContext, "android.permission.READ_PHONE_STATE"))
    {
      v.d("no READ_PHONE_STATE permission to get IMEI", new Object[0]);
      localObject = "null";
    }
    for (;;)
    {
      return (String)localObject;
      if (paramContext == null) {
        return null;
      }
      try
      {
        paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
        localObject = paramContext;
        if (paramContext != null) {
          Log.i(v.b, "failed to get IMEI");
        }
      }
      catch (Throwable paramContext)
      {
        try
        {
          localObject = paramContext.toLowerCase();
          return (String)localObject;
        }
        catch (Throwable localThrowable)
        {
          for (;;) {}
        }
        paramContext = paramContext;
        paramContext = null;
      }
    }
    return paramContext;
  }
  
  public static String b()
  {
    try
    {
      String str = Build.VERSION.RELEASE;
      return str;
    }
    catch (Throwable localThrowable)
    {
      if (!v.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return "fail";
  }
  
  public static String b(Context paramContext)
  {
    Object localObject;
    if (!AppInfo.a(paramContext, "android.permission.READ_PHONE_STATE"))
    {
      v.d("no READ_PHONE_STATE permission to get IMSI", new Object[0]);
      localObject = "null";
    }
    for (;;)
    {
      return (String)localObject;
      if (paramContext == null) {
        return null;
      }
      try
      {
        paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
        localObject = paramContext;
        if (paramContext != null) {
          Log.i(v.b, "failed to get IMSI");
        }
      }
      catch (Throwable paramContext)
      {
        try
        {
          localObject = paramContext.toLowerCase();
          return (String)localObject;
        }
        catch (Throwable localThrowable)
        {
          for (;;) {}
        }
        paramContext = paramContext;
        paramContext = null;
      }
    }
    return paramContext;
  }
  
  public static int c()
  {
    try
    {
      int i = Build.VERSION.SDK_INT;
      return i;
    }
    catch (Throwable localThrowable)
    {
      if (!v.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return -1;
  }
  
  /* Error */
  public static String c(Context paramContext)
  {
    // Byte code:
    //   0: ldc 32
    //   2: astore_1
    //   3: aload_0
    //   4: ifnonnull +5 -> 9
    //   7: aload_1
    //   8: areturn
    //   9: aload_0
    //   10: invokevirtual 97	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   13: ldc 99
    //   15: invokestatic 105	android/provider/Settings$Secure:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   18: astore_0
    //   19: aload_0
    //   20: ifnonnull +6 -> 26
    //   23: ldc 48
    //   25: areturn
    //   26: aload_0
    //   27: invokevirtual 66	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   30: astore_1
    //   31: aload_1
    //   32: areturn
    //   33: astore_2
    //   34: aload_1
    //   35: astore_0
    //   36: aload_0
    //   37: astore_1
    //   38: aload_2
    //   39: invokestatic 27	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   42: ifne -35 -> 7
    //   45: getstatic 67	com/tencent/bugly/proguard/v:b	Ljava/lang/String;
    //   48: ldc 107
    //   50: invokestatic 75	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   53: pop
    //   54: aload_0
    //   55: areturn
    //   56: astore_2
    //   57: goto -21 -> 36
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	paramContext	Context
    //   2	36	1	localObject	Object
    //   33	6	2	localThrowable1	Throwable
    //   56	1	2	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   9	19	33	java/lang/Throwable
    //   26	31	56	java/lang/Throwable
  }
  
  public static String d()
  {
    try
    {
      String str2 = p();
      String str1 = str2;
      if (str2 == null) {
        str1 = System.getProperty("os.arch");
      }
      str1 = str1;
      return str1;
    }
    catch (Throwable localThrowable)
    {
      if (!v.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return "fail";
  }
  
  public static String d(Context paramContext)
  {
    Object localObject = "fail";
    if (paramContext == null) {
      paramContext = "fail";
    }
    do
    {
      return paramContext;
      try
      {
        paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getMacAddress();
        if (paramContext == null) {
          return "null";
        }
        localObject = paramContext;
        paramContext = paramContext.toLowerCase();
        return paramContext;
      }
      catch (Throwable localThrowable)
      {
        paramContext = (Context)localObject;
      }
    } while (v.a(localThrowable));
    localThrowable.printStackTrace();
    return (String)localObject;
  }
  
  public static long e()
  {
    long l1 = -1L;
    try
    {
      StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
      long l2 = localStatFs.getBlockSize();
      int i = localStatFs.getBlockCount();
      l1 = i * l2;
    }
    catch (Throwable localThrowable)
    {
      while (v.a(localThrowable)) {}
      localThrowable.printStackTrace();
    }
    return l1;
    return -1L;
  }
  
  public static String e(Context paramContext)
  {
    for (;;)
    {
      try
      {
        NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (localNetworkInfo == null) {
          return null;
        }
        if (localNetworkInfo.getType() == 1) {
          return "WIFI";
        }
        if (localNetworkInfo.getType() != 0) {
          continue;
        }
        paramContext = (TelephonyManager)paramContext.getSystemService("phone");
        if (paramContext == null) {
          continue;
        }
        int i = paramContext.getNetworkType();
        switch (i)
        {
        case 15: 
          paramContext = "MOBILE(" + i + ")";
        }
      }
      catch (Exception paramContext)
      {
        if (v.a(paramContext)) {
          continue;
        }
        paramContext.printStackTrace();
        return "unknown";
        paramContext = "unknown";
        break;
        return "unknown";
      }
      return "HSPA+";
    }
    return paramContext;
    return "GPRS";
    return "EDGE";
    return "UMTS";
    return "HSDPA";
    return "HSUPA";
    return "HSPA";
    return "CDMA";
    return "EVDO_0";
    return "EVDO_A";
    return "1xRTT";
    return "iDen";
    return "EVDO_B";
    return "LTE";
    return "eHRPD";
  }
  
  public static long f()
  {
    long l1 = -1L;
    try
    {
      StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
      long l2 = localStatFs.getBlockSize();
      int i = localStatFs.getAvailableBlocks();
      l1 = i * l2;
    }
    catch (Throwable localThrowable)
    {
      while (v.a(localThrowable)) {}
      localThrowable.printStackTrace();
    }
    return l1;
    return -1L;
  }
  
  public static String f(Context paramContext)
  {
    int j = 0;
    String str = a.a(paramContext, "ro.miui.ui.version.name");
    if ((str != null) && (str.trim().length() > 0)) {}
    for (int i = 0; (i == 0) && (!str.equals("fail")); i = 1) {
      return "XiaoMi/MIUI/" + str;
    }
    str = a.a(paramContext, "ro.build.version.emui");
    if ((str != null) && (str.trim().length() > 0)) {}
    for (i = 0; (i == 0) && (!str.equals("fail")); i = 1) {
      return "HuaWei/EMOTION/" + str;
    }
    str = a.a(paramContext, "ro.lenovo.series");
    if ((str != null) && (str.trim().length() > 0)) {}
    for (i = 0; (i == 0) && (!str.equals("fail")); i = 1)
    {
      paramContext = a.a(paramContext, "ro.build.version.incremental");
      return "Lenovo/VIBE/" + paramContext;
    }
    str = a.a(paramContext, "ro.build.nubia.rom.name");
    if ((str != null) && (str.trim().length() > 0)) {}
    for (i = 0; (i == 0) && (!str.equals("fail")); i = 1) {
      return "Zte/NUBIA/" + str + "_" + a.a(paramContext, "ro.build.nubia.rom.code");
    }
    str = a.a(paramContext, "ro.meizu.product.model");
    if ((str != null) && (str.trim().length() > 0)) {}
    for (i = 0; (i == 0) && (!str.equals("fail")); i = 1) {
      return "Meizu/FLYME/" + a.a(paramContext, "ro.build.display.id");
    }
    str = a.a(paramContext, "ro.build.version.opporom");
    if ((str != null) && (str.trim().length() > 0)) {}
    for (i = 0; (i == 0) && (!str.equals("fail")); i = 1) {
      return "Oppo/COLOROS/" + str;
    }
    str = a.a(paramContext, "ro.vivo.os.build.display.id");
    if ((str != null) && (str.trim().length() > 0)) {}
    for (i = 0; (i == 0) && (!str.equals("fail")); i = 1) {
      return "vivo/FUNTOUCH/" + str;
    }
    str = a.a(paramContext, "ro.aa.romver");
    if ((str != null) && (str.trim().length() > 0)) {}
    for (i = 0; (i == 0) && (!str.equals("fail")); i = 1) {
      return "htc/" + str + "/" + a.a(paramContext, "ro.build.description");
    }
    str = a.a(paramContext, "ro.lewa.version");
    if ((str != null) && (str.trim().length() > 0)) {}
    for (i = 0; (i == 0) && (!str.equals("fail")); i = 1) {
      return "tcl/" + str + "/" + a.a(paramContext, "ro.build.display.id");
    }
    str = a.a(paramContext, "ro.gn.gnromvernumber");
    if ((str != null) && (str.trim().length() > 0)) {}
    for (i = 0; (i == 0) && (!str.equals("fail")); i = 1) {
      return "amigo/" + str + "/" + a.a(paramContext, "ro.build.display.id");
    }
    str = a.a(paramContext, "ro.build.tyd.kbstyle_version");
    if ((str != null) && (str.trim().length() > 0)) {}
    for (i = j; (i == 0) && (!str.equals("fail")); i = 1) {
      return "dido/" + str;
    }
    return a.a(paramContext, "ro.build.fingerprint") + "/" + a.a(paramContext, "ro.build.rom.id");
  }
  
  /* Error */
  public static long g()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 314	java/io/FileReader
    //   5: dup
    //   6: ldc_w 316
    //   9: invokespecial 317	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   12: astore_2
    //   13: new 319	java/io/BufferedReader
    //   16: dup
    //   17: aload_2
    //   18: sipush 2048
    //   21: invokespecial 322	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   24: astore_1
    //   25: aload_1
    //   26: invokevirtual 325	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   29: ldc_w 327
    //   32: iconst_2
    //   33: invokevirtual 331	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   36: iconst_1
    //   37: aaload
    //   38: invokevirtual 66	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   41: ldc_w 333
    //   44: ldc_w 335
    //   47: invokevirtual 339	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   50: invokevirtual 244	java/lang/String:trim	()Ljava/lang/String;
    //   53: invokestatic 345	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   56: lstore 4
    //   58: lload 4
    //   60: bipush 10
    //   62: lshl
    //   63: lstore 4
    //   65: aload_1
    //   66: invokevirtual 348	java/io/BufferedReader:close	()V
    //   69: aload_2
    //   70: invokevirtual 349	java/io/FileReader:close	()V
    //   73: lload 4
    //   75: lreturn
    //   76: astore_0
    //   77: aload_0
    //   78: invokestatic 27	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   81: ifne -12 -> 69
    //   84: aload_0
    //   85: invokevirtual 350	java/io/IOException:printStackTrace	()V
    //   88: goto -19 -> 69
    //   91: astore_0
    //   92: aload_0
    //   93: invokestatic 27	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   96: ifne -23 -> 73
    //   99: aload_0
    //   100: invokevirtual 350	java/io/IOException:printStackTrace	()V
    //   103: lload 4
    //   105: lreturn
    //   106: astore_2
    //   107: aconst_null
    //   108: astore_0
    //   109: aload_3
    //   110: astore_1
    //   111: aload_2
    //   112: invokestatic 27	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   115: ifne +7 -> 122
    //   118: aload_2
    //   119: invokevirtual 30	java/lang/Throwable:printStackTrace	()V
    //   122: aload_1
    //   123: ifnull +7 -> 130
    //   126: aload_1
    //   127: invokevirtual 348	java/io/BufferedReader:close	()V
    //   130: aload_0
    //   131: ifnull +7 -> 138
    //   134: aload_0
    //   135: invokevirtual 349	java/io/FileReader:close	()V
    //   138: ldc2_w 351
    //   141: lreturn
    //   142: astore_1
    //   143: aload_1
    //   144: invokestatic 27	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   147: ifne -17 -> 130
    //   150: aload_1
    //   151: invokevirtual 350	java/io/IOException:printStackTrace	()V
    //   154: goto -24 -> 130
    //   157: astore_0
    //   158: aload_0
    //   159: invokestatic 27	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   162: ifne -24 -> 138
    //   165: aload_0
    //   166: invokevirtual 350	java/io/IOException:printStackTrace	()V
    //   169: goto -31 -> 138
    //   172: astore_0
    //   173: aconst_null
    //   174: astore_1
    //   175: aconst_null
    //   176: astore_2
    //   177: aload_1
    //   178: ifnull +7 -> 185
    //   181: aload_1
    //   182: invokevirtual 348	java/io/BufferedReader:close	()V
    //   185: aload_2
    //   186: ifnull +7 -> 193
    //   189: aload_2
    //   190: invokevirtual 349	java/io/FileReader:close	()V
    //   193: aload_0
    //   194: athrow
    //   195: astore_1
    //   196: aload_1
    //   197: invokestatic 27	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   200: ifne -15 -> 185
    //   203: aload_1
    //   204: invokevirtual 350	java/io/IOException:printStackTrace	()V
    //   207: goto -22 -> 185
    //   210: astore_1
    //   211: aload_1
    //   212: invokestatic 27	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   215: ifne -22 -> 193
    //   218: aload_1
    //   219: invokevirtual 350	java/io/IOException:printStackTrace	()V
    //   222: goto -29 -> 193
    //   225: astore_0
    //   226: aconst_null
    //   227: astore_1
    //   228: goto -51 -> 177
    //   231: astore_0
    //   232: goto -55 -> 177
    //   235: astore_3
    //   236: aload_0
    //   237: astore_2
    //   238: aload_3
    //   239: astore_0
    //   240: goto -63 -> 177
    //   243: astore_1
    //   244: aload_2
    //   245: astore_0
    //   246: aload_1
    //   247: astore_2
    //   248: aload_3
    //   249: astore_1
    //   250: goto -139 -> 111
    //   253: astore_3
    //   254: aload_2
    //   255: astore_0
    //   256: aload_3
    //   257: astore_2
    //   258: goto -147 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   76	9	0	localIOException1	java.io.IOException
    //   91	9	0	localIOException2	java.io.IOException
    //   108	27	0	localObject1	Object
    //   157	9	0	localIOException3	java.io.IOException
    //   172	22	0	localObject2	Object
    //   225	1	0	localObject3	Object
    //   231	6	0	localObject4	Object
    //   239	17	0	localObject5	Object
    //   24	103	1	localObject6	Object
    //   142	9	1	localIOException4	java.io.IOException
    //   174	8	1	localObject7	Object
    //   195	9	1	localIOException5	java.io.IOException
    //   210	9	1	localIOException6	java.io.IOException
    //   227	1	1	localObject8	Object
    //   243	4	1	localThrowable1	Throwable
    //   249	1	1	localObject9	Object
    //   12	58	2	localFileReader	java.io.FileReader
    //   106	13	2	localThrowable2	Throwable
    //   176	82	2	localObject10	Object
    //   1	109	3	localObject11	Object
    //   235	14	3	localObject12	Object
    //   253	4	3	localThrowable3	Throwable
    //   56	48	4	l	long
    // Exception table:
    //   from	to	target	type
    //   65	69	76	java/io/IOException
    //   69	73	91	java/io/IOException
    //   2	13	106	java/lang/Throwable
    //   126	130	142	java/io/IOException
    //   134	138	157	java/io/IOException
    //   2	13	172	finally
    //   181	185	195	java/io/IOException
    //   189	193	210	java/io/IOException
    //   13	25	225	finally
    //   25	58	231	finally
    //   111	122	235	finally
    //   13	25	243	java/lang/Throwable
    //   25	58	253	java/lang/Throwable
  }
  
  public static String g(Context paramContext)
  {
    return a.a(paramContext, "ro.board.platform");
  }
  
  /* Error */
  public static long h()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 314	java/io/FileReader
    //   5: dup
    //   6: ldc_w 316
    //   9: invokespecial 317	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   12: astore_2
    //   13: new 319	java/io/BufferedReader
    //   16: dup
    //   17: aload_2
    //   18: sipush 2048
    //   21: invokespecial 322	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   24: astore_1
    //   25: aload_1
    //   26: invokevirtual 325	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   29: pop
    //   30: aload_1
    //   31: invokevirtual 325	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   34: ldc_w 327
    //   37: iconst_2
    //   38: invokevirtual 331	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   41: iconst_1
    //   42: aaload
    //   43: invokevirtual 66	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   46: ldc_w 333
    //   49: ldc_w 335
    //   52: invokevirtual 339	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   55: invokevirtual 244	java/lang/String:trim	()Ljava/lang/String;
    //   58: invokestatic 345	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   61: lstore 4
    //   63: aload_1
    //   64: invokevirtual 325	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   67: ldc_w 327
    //   70: iconst_2
    //   71: invokevirtual 331	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   74: iconst_1
    //   75: aaload
    //   76: invokevirtual 66	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   79: ldc_w 333
    //   82: ldc_w 335
    //   85: invokevirtual 339	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   88: invokevirtual 244	java/lang/String:trim	()Ljava/lang/String;
    //   91: invokestatic 345	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   94: lstore 6
    //   96: aload_1
    //   97: invokevirtual 325	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   100: ldc_w 327
    //   103: iconst_2
    //   104: invokevirtual 331	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   107: iconst_1
    //   108: aaload
    //   109: invokevirtual 66	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   112: ldc_w 333
    //   115: ldc_w 335
    //   118: invokevirtual 339	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   121: invokevirtual 244	java/lang/String:trim	()Ljava/lang/String;
    //   124: invokestatic 345	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   127: lstore 8
    //   129: lload 4
    //   131: bipush 10
    //   133: lshl
    //   134: lload 6
    //   136: bipush 10
    //   138: lshl
    //   139: ladd
    //   140: lload 8
    //   142: bipush 10
    //   144: lshl
    //   145: ladd
    //   146: lstore 4
    //   148: aload_1
    //   149: invokevirtual 348	java/io/BufferedReader:close	()V
    //   152: aload_2
    //   153: invokevirtual 349	java/io/FileReader:close	()V
    //   156: lload 4
    //   158: lreturn
    //   159: astore_0
    //   160: aload_0
    //   161: invokestatic 27	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   164: ifne -12 -> 152
    //   167: aload_0
    //   168: invokevirtual 350	java/io/IOException:printStackTrace	()V
    //   171: goto -19 -> 152
    //   174: astore_0
    //   175: aload_0
    //   176: invokestatic 27	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   179: ifne -23 -> 156
    //   182: aload_0
    //   183: invokevirtual 350	java/io/IOException:printStackTrace	()V
    //   186: lload 4
    //   188: lreturn
    //   189: astore_2
    //   190: aconst_null
    //   191: astore_0
    //   192: aload_3
    //   193: astore_1
    //   194: aload_2
    //   195: invokestatic 27	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   198: ifne +7 -> 205
    //   201: aload_2
    //   202: invokevirtual 30	java/lang/Throwable:printStackTrace	()V
    //   205: aload_1
    //   206: ifnull +7 -> 213
    //   209: aload_1
    //   210: invokevirtual 348	java/io/BufferedReader:close	()V
    //   213: aload_0
    //   214: ifnull +7 -> 221
    //   217: aload_0
    //   218: invokevirtual 349	java/io/FileReader:close	()V
    //   221: ldc2_w 351
    //   224: lreturn
    //   225: astore_1
    //   226: aload_1
    //   227: invokestatic 27	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   230: ifne -17 -> 213
    //   233: aload_1
    //   234: invokevirtual 350	java/io/IOException:printStackTrace	()V
    //   237: goto -24 -> 213
    //   240: astore_0
    //   241: aload_0
    //   242: invokestatic 27	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   245: ifne -24 -> 221
    //   248: aload_0
    //   249: invokevirtual 350	java/io/IOException:printStackTrace	()V
    //   252: goto -31 -> 221
    //   255: astore_0
    //   256: aconst_null
    //   257: astore_1
    //   258: aconst_null
    //   259: astore_2
    //   260: aload_1
    //   261: ifnull +7 -> 268
    //   264: aload_1
    //   265: invokevirtual 348	java/io/BufferedReader:close	()V
    //   268: aload_2
    //   269: ifnull +7 -> 276
    //   272: aload_2
    //   273: invokevirtual 349	java/io/FileReader:close	()V
    //   276: aload_0
    //   277: athrow
    //   278: astore_1
    //   279: aload_1
    //   280: invokestatic 27	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   283: ifne -15 -> 268
    //   286: aload_1
    //   287: invokevirtual 350	java/io/IOException:printStackTrace	()V
    //   290: goto -22 -> 268
    //   293: astore_1
    //   294: aload_1
    //   295: invokestatic 27	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   298: ifne -22 -> 276
    //   301: aload_1
    //   302: invokevirtual 350	java/io/IOException:printStackTrace	()V
    //   305: goto -29 -> 276
    //   308: astore_0
    //   309: aconst_null
    //   310: astore_1
    //   311: goto -51 -> 260
    //   314: astore_0
    //   315: goto -55 -> 260
    //   318: astore_3
    //   319: aload_0
    //   320: astore_2
    //   321: aload_3
    //   322: astore_0
    //   323: goto -63 -> 260
    //   326: astore_1
    //   327: aload_2
    //   328: astore_0
    //   329: aload_1
    //   330: astore_2
    //   331: aload_3
    //   332: astore_1
    //   333: goto -139 -> 194
    //   336: astore_3
    //   337: aload_2
    //   338: astore_0
    //   339: aload_3
    //   340: astore_2
    //   341: goto -147 -> 194
    // Local variable table:
    //   start	length	slot	name	signature
    //   159	9	0	localIOException1	java.io.IOException
    //   174	9	0	localIOException2	java.io.IOException
    //   191	27	0	localObject1	Object
    //   240	9	0	localIOException3	java.io.IOException
    //   255	22	0	localObject2	Object
    //   308	1	0	localObject3	Object
    //   314	6	0	localObject4	Object
    //   322	17	0	localObject5	Object
    //   24	186	1	localObject6	Object
    //   225	9	1	localIOException4	java.io.IOException
    //   257	8	1	localObject7	Object
    //   278	9	1	localIOException5	java.io.IOException
    //   293	9	1	localIOException6	java.io.IOException
    //   310	1	1	localObject8	Object
    //   326	4	1	localThrowable1	Throwable
    //   332	1	1	localObject9	Object
    //   12	141	2	localFileReader	java.io.FileReader
    //   189	13	2	localThrowable2	Throwable
    //   259	82	2	localObject10	Object
    //   1	192	3	localObject11	Object
    //   318	14	3	localObject12	Object
    //   336	4	3	localThrowable3	Throwable
    //   61	126	4	l1	long
    //   94	41	6	l2	long
    //   127	14	8	l3	long
    // Exception table:
    //   from	to	target	type
    //   148	152	159	java/io/IOException
    //   152	156	174	java/io/IOException
    //   2	13	189	java/lang/Throwable
    //   209	213	225	java/io/IOException
    //   217	221	240	java/io/IOException
    //   2	13	255	finally
    //   264	268	278	java/io/IOException
    //   272	276	293	java/io/IOException
    //   13	25	308	finally
    //   25	129	314	finally
    //   194	205	318	finally
    //   13	25	326	java/lang/Throwable
    //   25	129	336	java/lang/Throwable
  }
  
  public static boolean h(Context paramContext)
  {
    boolean bool3 = false;
    int i;
    if ((Build.TAGS != null) && (Build.TAGS.contains("test-keys"))) {
      i = 1;
    }
    try
    {
      for (;;)
      {
        bool1 = new File("/system/app/Superuser.apk").exists();
        Object localObject3 = null;
        String str = null;
        paramContext = a.a(paramContext, new String[] { "/system/bin/sh", "-c", "type su" });
        Object localObject1 = localObject3;
        if (paramContext == null) {
          break label162;
        }
        localObject1 = localObject3;
        if (paramContext.size() <= 0) {
          break label162;
        }
        localObject1 = paramContext.iterator();
        for (paramContext = str; ((Iterator)localObject1).hasNext(); paramContext = Boolean.valueOf(false))
        {
          str = (String)((Iterator)localObject1).next();
          v.c(str, new Object[0]);
          if (!str.contains("not found")) {
            break label209;
          }
        }
        i = 0;
      }
    }
    catch (Throwable localThrowable)
    {
      label162:
      label209:
      for (;;)
      {
        boolean bool1 = false;
        continue;
        Object localObject2 = paramContext;
        if (paramContext == null) {
          localObject2 = Boolean.valueOf(true);
        }
        if (localObject2 == null) {}
        for (boolean bool2 = false;; bool2 = ((Boolean)localObject2).booleanValue())
        {
          if ((i == 0) && (!bool1))
          {
            bool1 = bool3;
            if (!Boolean.valueOf(bool2).booleanValue()) {}
          }
          else
          {
            bool1 = true;
          }
          return bool1;
        }
      }
    }
  }
  
  public static long i()
  {
    if (Environment.getExternalStorageState().equals("mounted")) {}
    for (int i = 1; i == 0; i = 0) {
      return 0L;
    }
    try
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      i = localStatFs.getBlockSize();
      int j = localStatFs.getBlockCount();
      long l = j;
      return i * l;
    }
    catch (Throwable localThrowable)
    {
      if (!v.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return -2L;
  }
  
  public static String i(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str = a.a(paramContext, "ro.genymotion.version");
    if (str != null)
    {
      localStringBuilder.append("ro.genymotion.version");
      localStringBuilder.append("|");
      localStringBuilder.append(str);
      localStringBuilder.append("\n");
    }
    str = a.a(paramContext, "androVM.vbox_dpi");
    if (str != null)
    {
      localStringBuilder.append("androVM.vbox_dpi");
      localStringBuilder.append("|");
      localStringBuilder.append(str);
      localStringBuilder.append("\n");
    }
    paramContext = a.a(paramContext, "qemu.sf.fake_camera");
    if (paramContext != null)
    {
      localStringBuilder.append("qemu.sf.fake_camera");
      localStringBuilder.append("|");
      localStringBuilder.append(paramContext);
    }
    return localStringBuilder.toString();
  }
  
  public static long j()
  {
    if (Environment.getExternalStorageState().equals("mounted")) {}
    for (int i = 1; i == 0; i = 0) {
      return 0L;
    }
    try
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      i = localStatFs.getBlockSize();
      int j = localStatFs.getAvailableBlocks();
      long l = j;
      return i * l;
    }
    catch (Throwable localThrowable)
    {
      if (!v.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return -2L;
  }
  
  /* Error */
  public static String j(Context paramContext)
  {
    // Byte code:
    //   0: new 120	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   7: astore_3
    //   8: getstatic 11	com/tencent/bugly/crashreport/common/info/b:a	Ljava/lang/String;
    //   11: ifnonnull +13 -> 24
    //   14: aload_0
    //   15: ldc_w 433
    //   18: invokestatic 241	com/tencent/bugly/proguard/a:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   21: putstatic 11	com/tencent/bugly/crashreport/common/info/b:a	Ljava/lang/String;
    //   24: getstatic 11	com/tencent/bugly/crashreport/common/info/b:a	Ljava/lang/String;
    //   27: ifnull +35 -> 62
    //   30: aload_3
    //   31: ldc_w 433
    //   34: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload_3
    //   39: ldc_w 424
    //   42: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload_3
    //   47: getstatic 11	com/tencent/bugly/crashreport/common/info/b:a	Ljava/lang/String;
    //   50: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload_3
    //   55: ldc_w 426
    //   58: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: getstatic 13	com/tencent/bugly/crashreport/common/info/b:b	Ljava/lang/String;
    //   65: ifnonnull +13 -> 78
    //   68: aload_0
    //   69: ldc_w 435
    //   72: invokestatic 241	com/tencent/bugly/proguard/a:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   75: putstatic 13	com/tencent/bugly/crashreport/common/info/b:b	Ljava/lang/String;
    //   78: getstatic 13	com/tencent/bugly/crashreport/common/info/b:b	Ljava/lang/String;
    //   81: ifnull +35 -> 116
    //   84: aload_3
    //   85: ldc_w 435
    //   88: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload_3
    //   93: ldc_w 424
    //   96: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload_3
    //   101: getstatic 13	com/tencent/bugly/crashreport/common/info/b:b	Ljava/lang/String;
    //   104: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload_3
    //   109: ldc_w 426
    //   112: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: new 319	java/io/BufferedReader
    //   119: dup
    //   120: new 314	java/io/FileReader
    //   123: dup
    //   124: ldc_w 437
    //   127: invokespecial 317	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   130: invokespecial 440	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   133: astore_1
    //   134: aload_1
    //   135: astore_0
    //   136: aload_1
    //   137: invokevirtual 325	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   140: astore_2
    //   141: aload_2
    //   142: ifnull +15 -> 157
    //   145: aload_1
    //   146: astore_0
    //   147: aload_2
    //   148: ldc_w 442
    //   151: invokevirtual 446	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   154: ifeq -20 -> 134
    //   157: aload_2
    //   158: ifnull +43 -> 201
    //   161: aload_1
    //   162: astore_0
    //   163: aload_2
    //   164: bipush 10
    //   166: invokevirtual 450	java/lang/String:substring	(I)Ljava/lang/String;
    //   169: invokevirtual 244	java/lang/String:trim	()Ljava/lang/String;
    //   172: astore_2
    //   173: aload_1
    //   174: astore_0
    //   175: aload_3
    //   176: ldc_w 452
    //   179: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload_1
    //   184: astore_0
    //   185: aload_3
    //   186: ldc_w 424
    //   189: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload_1
    //   194: astore_0
    //   195: aload_3
    //   196: aload_2
    //   197: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload_1
    //   202: astore_0
    //   203: aload_3
    //   204: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: astore_2
    //   208: aload_1
    //   209: invokevirtual 348	java/io/BufferedReader:close	()V
    //   212: aload_2
    //   213: areturn
    //   214: astore_0
    //   215: aload_0
    //   216: invokestatic 27	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   219: pop
    //   220: aload_2
    //   221: areturn
    //   222: astore_2
    //   223: aconst_null
    //   224: astore_1
    //   225: aload_1
    //   226: astore_0
    //   227: aload_2
    //   228: invokestatic 27	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   231: pop
    //   232: aload_1
    //   233: ifnull +7 -> 240
    //   236: aload_1
    //   237: invokevirtual 348	java/io/BufferedReader:close	()V
    //   240: aload_3
    //   241: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: areturn
    //   245: astore_0
    //   246: aload_0
    //   247: invokestatic 27	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   250: pop
    //   251: goto -11 -> 240
    //   254: astore_1
    //   255: aconst_null
    //   256: astore_0
    //   257: aload_0
    //   258: ifnull +7 -> 265
    //   261: aload_0
    //   262: invokevirtual 348	java/io/BufferedReader:close	()V
    //   265: aload_1
    //   266: athrow
    //   267: astore_0
    //   268: aload_0
    //   269: invokestatic 27	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   272: pop
    //   273: goto -8 -> 265
    //   276: astore_1
    //   277: goto -20 -> 257
    //   280: astore_2
    //   281: goto -56 -> 225
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	284	0	paramContext	Context
    //   133	104	1	localBufferedReader	java.io.BufferedReader
    //   254	12	1	localObject1	Object
    //   276	1	1	localObject2	Object
    //   140	81	2	str	String
    //   222	6	2	localThrowable1	Throwable
    //   280	1	2	localThrowable2	Throwable
    //   7	234	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   208	212	214	java/io/IOException
    //   116	134	222	java/lang/Throwable
    //   236	240	245	java/io/IOException
    //   116	134	254	finally
    //   261	265	267	java/io/IOException
    //   136	141	276	finally
    //   147	157	276	finally
    //   163	173	276	finally
    //   175	183	276	finally
    //   185	193	276	finally
    //   195	201	276	finally
    //   203	208	276	finally
    //   227	232	276	finally
    //   136	141	280	java/lang/Throwable
    //   147	157	280	java/lang/Throwable
    //   163	173	280	java/lang/Throwable
    //   175	183	280	java/lang/Throwable
    //   185	193	280	java/lang/Throwable
    //   195	201	280	java/lang/Throwable
    //   203	208	280	java/lang/Throwable
  }
  
  public static String k()
  {
    Object localObject = "fail";
    try
    {
      String str = Locale.getDefault().getCountry();
      localObject = str;
    }
    catch (Throwable localThrowable)
    {
      while (v.a(localThrowable)) {}
      localThrowable.printStackTrace();
    }
    return (String)localObject;
    return "fail";
  }
  
  public static String k(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str = a.a(paramContext, "gsm.sim.state");
    if (str != null)
    {
      localStringBuilder.append("gsm.sim.state");
      localStringBuilder.append("|");
      localStringBuilder.append(str);
    }
    localStringBuilder.append("\n");
    paramContext = a.a(paramContext, "gsm.sim.state2");
    if (paramContext != null)
    {
      localStringBuilder.append("gsm.sim.state2");
      localStringBuilder.append("|");
      localStringBuilder.append(paramContext);
    }
    return localStringBuilder.toString();
  }
  
  public static String l()
  {
    Object localObject = "fail";
    try
    {
      String str = Build.BRAND;
      localObject = str;
    }
    catch (Throwable localThrowable)
    {
      while (v.a(localThrowable)) {}
      localThrowable.printStackTrace();
    }
    return (String)localObject;
    return "fail";
  }
  
  /* Error */
  public static String m()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 120	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   10: astore 5
    //   12: new 157	java/io/File
    //   15: dup
    //   16: ldc_w 473
    //   19: invokespecial 368	java/io/File:<init>	(Ljava/lang/String;)V
    //   22: invokevirtual 372	java/io/File:exists	()Z
    //   25: ifeq +331 -> 356
    //   28: new 319	java/io/BufferedReader
    //   31: dup
    //   32: new 314	java/io/FileReader
    //   35: dup
    //   36: ldc_w 473
    //   39: invokespecial 317	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   42: invokespecial 440	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   45: astore_1
    //   46: aload_1
    //   47: astore_0
    //   48: aload_1
    //   49: invokevirtual 325	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   52: astore_2
    //   53: aload_2
    //   54: ifnull +12 -> 66
    //   57: aload_1
    //   58: astore_0
    //   59: aload 5
    //   61: aload_2
    //   62: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload_1
    //   67: astore_0
    //   68: aload_1
    //   69: invokevirtual 348	java/io/BufferedReader:close	()V
    //   72: aload_1
    //   73: astore_0
    //   74: aload_0
    //   75: astore_3
    //   76: aload 5
    //   78: ldc_w 475
    //   81: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload_0
    //   86: astore_1
    //   87: aload_0
    //   88: astore_3
    //   89: new 157	java/io/File
    //   92: dup
    //   93: ldc_w 477
    //   96: invokespecial 368	java/io/File:<init>	(Ljava/lang/String;)V
    //   99: invokevirtual 372	java/io/File:exists	()Z
    //   102: ifeq +49 -> 151
    //   105: aload_0
    //   106: astore_3
    //   107: new 319	java/io/BufferedReader
    //   110: dup
    //   111: new 314	java/io/FileReader
    //   114: dup
    //   115: ldc_w 477
    //   118: invokespecial 317	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   121: invokespecial 440	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   124: astore_1
    //   125: aload_1
    //   126: astore_0
    //   127: aload_1
    //   128: invokevirtual 325	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   131: astore_2
    //   132: aload_2
    //   133: ifnull +12 -> 145
    //   136: aload_1
    //   137: astore_0
    //   138: aload 5
    //   140: aload_2
    //   141: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload_1
    //   146: astore_0
    //   147: aload_1
    //   148: invokevirtual 348	java/io/BufferedReader:close	()V
    //   151: aload_1
    //   152: astore_3
    //   153: aload 5
    //   155: ldc_w 475
    //   158: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload_1
    //   163: astore_3
    //   164: new 157	java/io/File
    //   167: dup
    //   168: ldc_w 479
    //   171: invokespecial 368	java/io/File:<init>	(Ljava/lang/String;)V
    //   174: invokevirtual 372	java/io/File:exists	()Z
    //   177: ifeq +176 -> 353
    //   180: aload_1
    //   181: astore_3
    //   182: new 319	java/io/BufferedReader
    //   185: dup
    //   186: new 314	java/io/FileReader
    //   189: dup
    //   190: ldc_w 479
    //   193: invokespecial 317	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   196: invokespecial 440	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   199: astore_2
    //   200: aload_2
    //   201: astore_0
    //   202: aload_2
    //   203: invokevirtual 325	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   206: astore_3
    //   207: aload_2
    //   208: astore_1
    //   209: aload_3
    //   210: ifnull +14 -> 224
    //   213: aload_2
    //   214: astore_0
    //   215: aload 5
    //   217: aload_3
    //   218: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: pop
    //   222: aload_2
    //   223: astore_1
    //   224: aload_1
    //   225: astore_2
    //   226: aload_1
    //   227: astore_0
    //   228: aload 5
    //   230: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: astore_3
    //   234: aload_3
    //   235: astore_0
    //   236: aload_0
    //   237: astore_2
    //   238: aload_1
    //   239: ifnull +9 -> 248
    //   242: aload_1
    //   243: invokevirtual 348	java/io/BufferedReader:close	()V
    //   246: aload_0
    //   247: astore_2
    //   248: aload_2
    //   249: areturn
    //   250: astore_1
    //   251: aload_1
    //   252: invokestatic 27	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   255: pop
    //   256: aload_0
    //   257: areturn
    //   258: astore_1
    //   259: aconst_null
    //   260: astore_0
    //   261: aload_0
    //   262: astore_2
    //   263: aload_1
    //   264: invokestatic 27	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   267: pop
    //   268: aload 4
    //   270: astore_2
    //   271: aload_0
    //   272: ifnull -24 -> 248
    //   275: aload_0
    //   276: invokevirtual 348	java/io/BufferedReader:close	()V
    //   279: aconst_null
    //   280: areturn
    //   281: astore_0
    //   282: aload_0
    //   283: invokestatic 27	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   286: pop
    //   287: aconst_null
    //   288: areturn
    //   289: astore_0
    //   290: aconst_null
    //   291: astore_1
    //   292: aload_1
    //   293: ifnull +7 -> 300
    //   296: aload_1
    //   297: invokevirtual 348	java/io/BufferedReader:close	()V
    //   300: aload_0
    //   301: athrow
    //   302: astore_1
    //   303: aload_1
    //   304: invokestatic 27	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   307: pop
    //   308: goto -8 -> 300
    //   311: astore_0
    //   312: goto -20 -> 292
    //   315: astore_0
    //   316: aload_3
    //   317: astore_1
    //   318: goto -26 -> 292
    //   321: astore_0
    //   322: goto -30 -> 292
    //   325: astore_0
    //   326: aload_2
    //   327: astore_1
    //   328: goto -36 -> 292
    //   331: astore_0
    //   332: aload_2
    //   333: astore_1
    //   334: goto -42 -> 292
    //   337: astore_1
    //   338: goto -77 -> 261
    //   341: astore_1
    //   342: goto -81 -> 261
    //   345: astore_2
    //   346: aload_1
    //   347: astore_0
    //   348: aload_2
    //   349: astore_1
    //   350: goto -89 -> 261
    //   353: goto -129 -> 224
    //   356: aconst_null
    //   357: astore_0
    //   358: goto -284 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   47	229	0	localObject1	Object
    //   281	2	0	localIOException1	java.io.IOException
    //   289	12	0	localObject2	Object
    //   311	1	0	localObject3	Object
    //   315	1	0	localObject4	Object
    //   321	1	0	localObject5	Object
    //   325	1	0	localObject6	Object
    //   331	1	0	localObject7	Object
    //   347	11	0	localThrowable1	Throwable
    //   45	198	1	localObject8	Object
    //   250	2	1	localIOException2	java.io.IOException
    //   258	6	1	localThrowable2	Throwable
    //   291	6	1	localObject9	Object
    //   302	2	1	localIOException3	java.io.IOException
    //   317	17	1	localObject10	Object
    //   337	1	1	localThrowable3	Throwable
    //   341	6	1	localThrowable4	Throwable
    //   349	1	1	localObject11	Object
    //   52	281	2	localObject12	Object
    //   345	4	2	localThrowable5	Throwable
    //   75	242	3	localObject13	Object
    //   1	268	4	localObject14	Object
    //   10	219	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   242	246	250	java/io/IOException
    //   3	46	258	java/lang/Throwable
    //   275	279	281	java/io/IOException
    //   3	46	289	finally
    //   296	300	302	java/io/IOException
    //   48	53	311	finally
    //   59	66	311	finally
    //   68	72	311	finally
    //   76	85	315	finally
    //   89	105	315	finally
    //   107	125	315	finally
    //   153	162	315	finally
    //   164	180	315	finally
    //   182	200	315	finally
    //   127	132	321	finally
    //   138	145	321	finally
    //   147	151	321	finally
    //   202	207	325	finally
    //   215	222	325	finally
    //   228	234	331	finally
    //   263	268	331	finally
    //   48	53	337	java/lang/Throwable
    //   59	66	337	java/lang/Throwable
    //   68	72	337	java/lang/Throwable
    //   127	132	337	java/lang/Throwable
    //   138	145	337	java/lang/Throwable
    //   147	151	337	java/lang/Throwable
    //   202	207	337	java/lang/Throwable
    //   215	222	337	java/lang/Throwable
    //   228	234	337	java/lang/Throwable
    //   76	85	341	java/lang/Throwable
    //   89	105	341	java/lang/Throwable
    //   107	125	341	java/lang/Throwable
    //   153	162	345	java/lang/Throwable
    //   164	180	345	java/lang/Throwable
    //   182	200	345	java/lang/Throwable
  }
  
  /* Error */
  public static String n()
  {
    // Byte code:
    //   0: new 120	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   7: astore 4
    //   9: aconst_null
    //   10: astore_1
    //   11: aconst_null
    //   12: astore_0
    //   13: aload_1
    //   14: astore_2
    //   15: new 157	java/io/File
    //   18: dup
    //   19: ldc_w 482
    //   22: invokespecial 368	java/io/File:<init>	(Ljava/lang/String;)V
    //   25: invokevirtual 372	java/io/File:exists	()Z
    //   28: ifeq +73 -> 101
    //   31: aload_1
    //   32: astore_2
    //   33: new 319	java/io/BufferedReader
    //   36: dup
    //   37: new 314	java/io/FileReader
    //   40: dup
    //   41: ldc_w 482
    //   44: invokespecial 317	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   47: invokespecial 440	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   50: astore_1
    //   51: aload_1
    //   52: astore_0
    //   53: aload_1
    //   54: invokevirtual 325	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   57: astore_2
    //   58: aload_2
    //   59: ifnull +34 -> 93
    //   62: aload_1
    //   63: astore_0
    //   64: aload 4
    //   66: ldc_w 484
    //   69: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload_1
    //   74: astore_0
    //   75: aload 4
    //   77: ldc_w 424
    //   80: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload_1
    //   85: astore_0
    //   86: aload 4
    //   88: aload_2
    //   89: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload_1
    //   94: astore_0
    //   95: aload_1
    //   96: invokevirtual 348	java/io/BufferedReader:close	()V
    //   99: aload_1
    //   100: astore_0
    //   101: aload_0
    //   102: astore_2
    //   103: aload 4
    //   105: ldc_w 426
    //   108: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload_0
    //   113: astore_1
    //   114: aload_0
    //   115: astore_2
    //   116: new 157	java/io/File
    //   119: dup
    //   120: ldc_w 486
    //   123: invokespecial 368	java/io/File:<init>	(Ljava/lang/String;)V
    //   126: invokevirtual 372	java/io/File:exists	()Z
    //   129: ifeq +71 -> 200
    //   132: aload_0
    //   133: astore_2
    //   134: new 319	java/io/BufferedReader
    //   137: dup
    //   138: new 314	java/io/FileReader
    //   141: dup
    //   142: ldc_w 486
    //   145: invokespecial 317	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   148: invokespecial 440	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   151: astore_1
    //   152: aload_1
    //   153: astore_0
    //   154: aload_1
    //   155: invokevirtual 325	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   158: astore_2
    //   159: aload_2
    //   160: ifnull +34 -> 194
    //   163: aload_1
    //   164: astore_0
    //   165: aload 4
    //   167: ldc_w 488
    //   170: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: aload_1
    //   175: astore_0
    //   176: aload 4
    //   178: ldc_w 424
    //   181: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload_1
    //   186: astore_0
    //   187: aload 4
    //   189: aload_2
    //   190: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: aload_1
    //   195: astore_0
    //   196: aload_1
    //   197: invokevirtual 348	java/io/BufferedReader:close	()V
    //   200: aload_1
    //   201: astore_2
    //   202: aload 4
    //   204: ldc_w 426
    //   207: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload_1
    //   212: astore_2
    //   213: new 157	java/io/File
    //   216: dup
    //   217: ldc_w 490
    //   220: invokespecial 368	java/io/File:<init>	(Ljava/lang/String;)V
    //   223: invokevirtual 372	java/io/File:exists	()Z
    //   226: ifeq +182 -> 408
    //   229: aload_1
    //   230: astore_2
    //   231: new 319	java/io/BufferedReader
    //   234: dup
    //   235: new 314	java/io/FileReader
    //   238: dup
    //   239: ldc_w 490
    //   242: invokespecial 317	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   245: invokespecial 440	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   248: astore_3
    //   249: aload_3
    //   250: astore_0
    //   251: aload_3
    //   252: invokevirtual 325	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   255: astore_1
    //   256: aload_1
    //   257: ifnull +34 -> 291
    //   260: aload_3
    //   261: astore_0
    //   262: aload 4
    //   264: ldc_w 492
    //   267: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: aload_3
    //   272: astore_0
    //   273: aload 4
    //   275: ldc_w 424
    //   278: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: aload_3
    //   283: astore_0
    //   284: aload 4
    //   286: aload_1
    //   287: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: pop
    //   291: aload_3
    //   292: astore_0
    //   293: aload_3
    //   294: invokevirtual 348	java/io/BufferedReader:close	()V
    //   297: aload_3
    //   298: ifnull +7 -> 305
    //   301: aload_3
    //   302: invokevirtual 348	java/io/BufferedReader:close	()V
    //   305: aload 4
    //   307: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   310: areturn
    //   311: astore_0
    //   312: aload_0
    //   313: invokestatic 27	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   316: pop
    //   317: goto -12 -> 305
    //   320: astore_1
    //   321: aconst_null
    //   322: astore_0
    //   323: aload_1
    //   324: invokestatic 27	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   327: pop
    //   328: aload_0
    //   329: ifnull -24 -> 305
    //   332: aload_0
    //   333: invokevirtual 348	java/io/BufferedReader:close	()V
    //   336: goto -31 -> 305
    //   339: astore_0
    //   340: aload_0
    //   341: invokestatic 27	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   344: pop
    //   345: goto -40 -> 305
    //   348: astore_0
    //   349: aload_2
    //   350: astore_1
    //   351: aload_1
    //   352: ifnull +7 -> 359
    //   355: aload_1
    //   356: invokevirtual 348	java/io/BufferedReader:close	()V
    //   359: aload_0
    //   360: athrow
    //   361: astore_1
    //   362: aload_1
    //   363: invokestatic 27	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   366: pop
    //   367: goto -8 -> 359
    //   370: astore_0
    //   371: goto -20 -> 351
    //   374: astore_0
    //   375: goto -24 -> 351
    //   378: astore_0
    //   379: aload_3
    //   380: astore_1
    //   381: goto -30 -> 351
    //   384: astore_2
    //   385: aload_0
    //   386: astore_1
    //   387: aload_2
    //   388: astore_0
    //   389: goto -38 -> 351
    //   392: astore_1
    //   393: goto -70 -> 323
    //   396: astore_1
    //   397: goto -74 -> 323
    //   400: astore_2
    //   401: aload_1
    //   402: astore_0
    //   403: aload_2
    //   404: astore_1
    //   405: goto -82 -> 323
    //   408: aload_1
    //   409: astore_3
    //   410: goto -113 -> 297
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	281	0	localObject1	Object
    //   311	2	0	localIOException1	java.io.IOException
    //   322	11	0	localObject2	Object
    //   339	2	0	localIOException2	java.io.IOException
    //   348	12	0	localObject3	Object
    //   370	1	0	localObject4	Object
    //   374	1	0	localObject5	Object
    //   378	8	0	localObject6	Object
    //   388	15	0	localObject7	Object
    //   10	277	1	localObject8	Object
    //   320	4	1	localThrowable1	Throwable
    //   350	6	1	localObject9	Object
    //   361	2	1	localIOException3	java.io.IOException
    //   380	7	1	localObject10	Object
    //   392	1	1	localThrowable2	Throwable
    //   396	6	1	localThrowable3	Throwable
    //   404	5	1	localObject11	Object
    //   14	336	2	localObject12	Object
    //   384	4	2	localObject13	Object
    //   400	4	2	localThrowable4	Throwable
    //   248	162	3	localObject14	Object
    //   7	299	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   301	305	311	java/io/IOException
    //   15	31	320	java/lang/Throwable
    //   33	51	320	java/lang/Throwable
    //   332	336	339	java/io/IOException
    //   15	31	348	finally
    //   33	51	348	finally
    //   103	112	348	finally
    //   116	132	348	finally
    //   134	152	348	finally
    //   202	211	348	finally
    //   213	229	348	finally
    //   231	249	348	finally
    //   355	359	361	java/io/IOException
    //   53	58	370	finally
    //   64	73	370	finally
    //   75	84	370	finally
    //   86	93	370	finally
    //   95	99	370	finally
    //   154	159	374	finally
    //   165	174	374	finally
    //   176	185	374	finally
    //   187	194	374	finally
    //   196	200	374	finally
    //   251	256	378	finally
    //   262	271	378	finally
    //   273	282	378	finally
    //   284	291	378	finally
    //   293	297	378	finally
    //   323	328	384	finally
    //   53	58	392	java/lang/Throwable
    //   64	73	392	java/lang/Throwable
    //   75	84	392	java/lang/Throwable
    //   86	93	392	java/lang/Throwable
    //   95	99	392	java/lang/Throwable
    //   154	159	392	java/lang/Throwable
    //   165	174	392	java/lang/Throwable
    //   176	185	392	java/lang/Throwable
    //   187	194	392	java/lang/Throwable
    //   196	200	392	java/lang/Throwable
    //   251	256	392	java/lang/Throwable
    //   262	271	392	java/lang/Throwable
    //   273	282	392	java/lang/Throwable
    //   284	291	392	java/lang/Throwable
    //   293	297	392	java/lang/Throwable
    //   103	112	396	java/lang/Throwable
    //   116	132	396	java/lang/Throwable
    //   134	152	396	java/lang/Throwable
    //   202	211	400	java/lang/Throwable
    //   213	229	400	java/lang/Throwable
    //   231	249	400	java/lang/Throwable
  }
  
  /* Error */
  public static long o()
  {
    // Byte code:
    //   0: fconst_0
    //   1: fstore_1
    //   2: fconst_0
    //   3: fstore_0
    //   4: new 319	java/io/BufferedReader
    //   7: dup
    //   8: new 314	java/io/FileReader
    //   11: dup
    //   12: ldc_w 495
    //   15: invokespecial 317	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   18: invokespecial 440	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   21: astore 4
    //   23: aload 4
    //   25: astore_3
    //   26: aload 4
    //   28: invokevirtual 325	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   31: astore 5
    //   33: aload 5
    //   35: ifnull +43 -> 78
    //   38: aload 4
    //   40: astore_3
    //   41: aload 5
    //   43: ldc_w 497
    //   46: invokevirtual 500	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   49: iconst_0
    //   50: aaload
    //   51: astore 5
    //   53: aload 4
    //   55: astore_3
    //   56: invokestatic 503	java/lang/System:currentTimeMillis	()J
    //   59: ldc2_w 504
    //   62: ldiv
    //   63: l2f
    //   64: fstore_0
    //   65: aload 4
    //   67: astore_3
    //   68: aload 5
    //   70: invokestatic 511	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   73: fstore_2
    //   74: fload_0
    //   75: fload_2
    //   76: fsub
    //   77: fstore_0
    //   78: aload 4
    //   80: invokevirtual 348	java/io/BufferedReader:close	()V
    //   83: fload_0
    //   84: f2l
    //   85: lreturn
    //   86: astore_3
    //   87: aload_3
    //   88: invokestatic 27	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   91: pop
    //   92: goto -9 -> 83
    //   95: astore 5
    //   97: aconst_null
    //   98: astore 4
    //   100: aload 4
    //   102: astore_3
    //   103: aload 5
    //   105: invokestatic 27	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   108: pop
    //   109: fload_1
    //   110: fstore_0
    //   111: aload 4
    //   113: ifnull -30 -> 83
    //   116: aload 4
    //   118: invokevirtual 348	java/io/BufferedReader:close	()V
    //   121: fload_1
    //   122: fstore_0
    //   123: goto -40 -> 83
    //   126: astore_3
    //   127: aload_3
    //   128: invokestatic 27	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   131: pop
    //   132: fload_1
    //   133: fstore_0
    //   134: goto -51 -> 83
    //   137: astore 4
    //   139: aconst_null
    //   140: astore_3
    //   141: aload_3
    //   142: ifnull +7 -> 149
    //   145: aload_3
    //   146: invokevirtual 348	java/io/BufferedReader:close	()V
    //   149: aload 4
    //   151: athrow
    //   152: astore_3
    //   153: aload_3
    //   154: invokestatic 27	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   157: pop
    //   158: goto -9 -> 149
    //   161: astore 4
    //   163: goto -22 -> 141
    //   166: astore 5
    //   168: goto -68 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   3	131	0	f1	float
    //   1	132	1	f2	float
    //   73	3	2	f3	float
    //   25	43	3	localBufferedReader1	java.io.BufferedReader
    //   86	2	3	localIOException1	java.io.IOException
    //   102	1	3	localBufferedReader2	java.io.BufferedReader
    //   126	2	3	localIOException2	java.io.IOException
    //   140	6	3	localObject1	Object
    //   152	2	3	localIOException3	java.io.IOException
    //   21	96	4	localBufferedReader3	java.io.BufferedReader
    //   137	13	4	localObject2	Object
    //   161	1	4	localObject3	Object
    //   31	38	5	str	String
    //   95	9	5	localThrowable1	Throwable
    //   166	1	5	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   78	83	86	java/io/IOException
    //   4	23	95	java/lang/Throwable
    //   116	121	126	java/io/IOException
    //   4	23	137	finally
    //   145	149	152	java/io/IOException
    //   26	33	161	finally
    //   41	53	161	finally
    //   56	65	161	finally
    //   68	74	161	finally
    //   103	109	161	finally
    //   26	33	166	java/lang/Throwable
    //   41	53	166	java/lang/Throwable
    //   56	65	166	java/lang/Throwable
    //   68	74	166	java/lang/Throwable
  }
  
  /* Error */
  private static String p()
  {
    // Byte code:
    //   0: new 314	java/io/FileReader
    //   3: dup
    //   4: ldc_w 513
    //   7: invokespecial 317	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   10: astore_1
    //   11: new 319	java/io/BufferedReader
    //   14: dup
    //   15: aload_1
    //   16: sipush 2048
    //   19: invokespecial 322	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   22: astore 5
    //   24: aload 5
    //   26: astore_3
    //   27: aload_1
    //   28: astore_2
    //   29: aload 5
    //   31: invokevirtual 325	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   34: astore_0
    //   35: aload_0
    //   36: ifnull +291 -> 327
    //   39: aload 5
    //   41: astore_3
    //   42: aload_1
    //   43: astore_2
    //   44: aload_0
    //   45: ldc_w 515
    //   48: iconst_2
    //   49: invokevirtual 331	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   52: astore_0
    //   53: aload 5
    //   55: astore_3
    //   56: aload_1
    //   57: astore_2
    //   58: aload_0
    //   59: arraylength
    //   60: iconst_2
    //   61: if_icmpne -37 -> 24
    //   64: aload 5
    //   66: astore_3
    //   67: aload_1
    //   68: astore_2
    //   69: aload_0
    //   70: iconst_0
    //   71: aaload
    //   72: ldc_w 517
    //   75: invokevirtual 251	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   78: ifeq +41 -> 119
    //   81: aload_0
    //   82: iconst_1
    //   83: aaload
    //   84: astore_0
    //   85: aload_0
    //   86: astore_2
    //   87: aload_0
    //   88: ifnull +20 -> 108
    //   91: aload 5
    //   93: astore_3
    //   94: aload_1
    //   95: astore_2
    //   96: aload_0
    //   97: ldc_w 475
    //   100: invokevirtual 500	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   103: iconst_0
    //   104: aaload
    //   105: astore_0
    //   106: aload_0
    //   107: astore_2
    //   108: aload 5
    //   110: invokevirtual 348	java/io/BufferedReader:close	()V
    //   113: aload_1
    //   114: invokevirtual 349	java/io/FileReader:close	()V
    //   117: aload_2
    //   118: areturn
    //   119: aload 5
    //   121: astore_3
    //   122: aload_1
    //   123: astore_2
    //   124: aload_0
    //   125: iconst_0
    //   126: aaload
    //   127: ldc_w 519
    //   130: invokevirtual 251	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   133: ifeq -109 -> 24
    //   136: aload_0
    //   137: iconst_1
    //   138: aaload
    //   139: astore_0
    //   140: goto -55 -> 85
    //   143: astore_0
    //   144: aload_0
    //   145: invokestatic 27	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   148: ifne -35 -> 113
    //   151: aload_0
    //   152: invokevirtual 350	java/io/IOException:printStackTrace	()V
    //   155: goto -42 -> 113
    //   158: astore_0
    //   159: aload_0
    //   160: invokestatic 27	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   163: ifne -46 -> 117
    //   166: aload_0
    //   167: invokevirtual 350	java/io/IOException:printStackTrace	()V
    //   170: aload_2
    //   171: areturn
    //   172: astore 4
    //   174: aconst_null
    //   175: astore_0
    //   176: aconst_null
    //   177: astore_1
    //   178: aload_0
    //   179: astore_3
    //   180: aload_1
    //   181: astore_2
    //   182: aload 4
    //   184: invokestatic 27	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   187: ifne +12 -> 199
    //   190: aload_0
    //   191: astore_3
    //   192: aload_1
    //   193: astore_2
    //   194: aload 4
    //   196: invokevirtual 30	java/lang/Throwable:printStackTrace	()V
    //   199: aload_0
    //   200: ifnull +7 -> 207
    //   203: aload_0
    //   204: invokevirtual 348	java/io/BufferedReader:close	()V
    //   207: aload_1
    //   208: ifnull +7 -> 215
    //   211: aload_1
    //   212: invokevirtual 349	java/io/FileReader:close	()V
    //   215: aconst_null
    //   216: areturn
    //   217: astore_0
    //   218: aload_0
    //   219: invokestatic 27	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   222: ifne -15 -> 207
    //   225: aload_0
    //   226: invokevirtual 350	java/io/IOException:printStackTrace	()V
    //   229: goto -22 -> 207
    //   232: astore_0
    //   233: aload_0
    //   234: invokestatic 27	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   237: ifne -22 -> 215
    //   240: aload_0
    //   241: invokevirtual 350	java/io/IOException:printStackTrace	()V
    //   244: goto -29 -> 215
    //   247: astore_0
    //   248: aconst_null
    //   249: astore_3
    //   250: aconst_null
    //   251: astore_1
    //   252: aload_3
    //   253: ifnull +7 -> 260
    //   256: aload_3
    //   257: invokevirtual 348	java/io/BufferedReader:close	()V
    //   260: aload_1
    //   261: ifnull +7 -> 268
    //   264: aload_1
    //   265: invokevirtual 349	java/io/FileReader:close	()V
    //   268: aload_0
    //   269: athrow
    //   270: astore_2
    //   271: aload_2
    //   272: invokestatic 27	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   275: ifne -15 -> 260
    //   278: aload_2
    //   279: invokevirtual 350	java/io/IOException:printStackTrace	()V
    //   282: goto -22 -> 260
    //   285: astore_1
    //   286: aload_1
    //   287: invokestatic 27	com/tencent/bugly/proguard/v:a	(Ljava/lang/Throwable;)Z
    //   290: ifne -22 -> 268
    //   293: aload_1
    //   294: invokevirtual 350	java/io/IOException:printStackTrace	()V
    //   297: goto -29 -> 268
    //   300: astore_0
    //   301: aconst_null
    //   302: astore_3
    //   303: goto -51 -> 252
    //   306: astore_0
    //   307: aload_2
    //   308: astore_1
    //   309: goto -57 -> 252
    //   312: astore 4
    //   314: aconst_null
    //   315: astore_0
    //   316: goto -138 -> 178
    //   319: astore 4
    //   321: aload 5
    //   323: astore_0
    //   324: goto -146 -> 178
    //   327: aconst_null
    //   328: astore_0
    //   329: goto -244 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   34	106	0	localObject1	Object
    //   143	9	0	localIOException1	java.io.IOException
    //   158	9	0	localIOException2	java.io.IOException
    //   175	29	0	localObject2	Object
    //   217	9	0	localIOException3	java.io.IOException
    //   232	9	0	localIOException4	java.io.IOException
    //   247	22	0	localObject3	Object
    //   300	1	0	localObject4	Object
    //   306	1	0	localObject5	Object
    //   315	14	0	localBufferedReader1	java.io.BufferedReader
    //   10	255	1	localFileReader	java.io.FileReader
    //   285	9	1	localIOException5	java.io.IOException
    //   308	1	1	localObject6	Object
    //   28	166	2	localObject7	Object
    //   270	38	2	localIOException6	java.io.IOException
    //   26	277	3	localObject8	Object
    //   172	23	4	localThrowable1	Throwable
    //   312	1	4	localThrowable2	Throwable
    //   319	1	4	localThrowable3	Throwable
    //   22	300	5	localBufferedReader2	java.io.BufferedReader
    // Exception table:
    //   from	to	target	type
    //   108	113	143	java/io/IOException
    //   113	117	158	java/io/IOException
    //   0	11	172	java/lang/Throwable
    //   203	207	217	java/io/IOException
    //   211	215	232	java/io/IOException
    //   0	11	247	finally
    //   256	260	270	java/io/IOException
    //   264	268	285	java/io/IOException
    //   11	24	300	finally
    //   29	35	306	finally
    //   44	53	306	finally
    //   58	64	306	finally
    //   69	81	306	finally
    //   96	106	306	finally
    //   124	136	306	finally
    //   182	190	306	finally
    //   194	199	306	finally
    //   11	24	312	java/lang/Throwable
    //   29	35	319	java/lang/Throwable
    //   44	53	319	java/lang/Throwable
    //   58	64	319	java/lang/Throwable
    //   69	81	319	java/lang/Throwable
    //   96	106	319	java/lang/Throwable
    //   124	136	319	java/lang/Throwable
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\bugly\crashreport\common\info\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */