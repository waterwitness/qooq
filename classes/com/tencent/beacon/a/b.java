package com.tencent.beacon.a;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Process;
import com.tencent.beacon.d.a;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class b
{
  public static boolean a = false;
  private static String b = null;
  private static String c = null;
  private static Boolean d = null;
  private static int e = 0;
  private static String f = "";
  
  public static int a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("DENGTA_META", 0).getInt(paramString, 0);
  }
  
  public static String a()
  {
    if (!"".equals(f)) {
      return f;
    }
    try
    {
      if (e == 0) {
        e = Process.myPid();
      }
      f = f + e + "_";
      f += new Date().getTime();
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return f;
  }
  
  public static String a(Context paramContext)
  {
    if (paramContext == null) {
      paramContext = "";
    }
    for (;;)
    {
      return paramContext;
      try
      {
        paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).metaData.get("APPKEY_DENGTA");
        if (paramContext != null)
        {
          paramContext = paramContext.toString().trim();
          continue;
        }
      }
      catch (Throwable paramContext)
      {
        a.d("no appkey !! ", new Object[0]);
        paramContext = "";
      }
      finally {}
    }
  }
  
  public static void a(String paramString)
  {
    try
    {
      b = paramString;
      d locald = d.m();
      if (locald != null) {
        locald.a(paramString);
      }
      return;
    }
    finally {}
  }
  
  public static boolean a(Context paramContext, String paramString, int paramInt)
  {
    return paramContext.getSharedPreferences("DENGTA_META", 0).edit().putInt(paramString, paramInt).commit();
  }
  
  public static boolean a(Context paramContext, String paramString, long paramLong)
  {
    return paramContext.getSharedPreferences("DENGTA_META", 0).edit().putLong(paramString, paramLong).commit();
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    return paramContext.getSharedPreferences("DENGTA_META", 0).edit().putString(paramString1, paramString2).commit();
  }
  
  public static long b(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("DENGTA_META", 0).getLong(paramString, 0L);
  }
  
  /* Error */
  public static String b(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnonnull +11 -> 15
    //   7: ldc 26
    //   9: astore_0
    //   10: ldc 2
    //   12: monitorexit
    //   13: aload_0
    //   14: areturn
    //   15: aconst_null
    //   16: astore_2
    //   17: aconst_null
    //   18: astore_3
    //   19: aload_0
    //   20: invokevirtual 175	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   23: astore 5
    //   25: aload_0
    //   26: ldc 37
    //   28: iconst_0
    //   29: invokevirtual 43	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   32: ldc -79
    //   34: ldc 26
    //   36: invokeinterface 181 3 0
    //   41: astore 4
    //   43: aload 4
    //   45: astore_1
    //   46: aload 4
    //   48: ldc 26
    //   50: invokevirtual 58	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   53: ifeq +33 -> 86
    //   56: ldc -73
    //   58: astore_1
    //   59: aload_0
    //   60: ldc 37
    //   62: iconst_0
    //   63: invokevirtual 43	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   66: invokeinterface 144 1 0
    //   71: ldc -79
    //   73: ldc -73
    //   75: invokeinterface 164 3 0
    //   80: invokeinterface 154 1 0
    //   85: pop
    //   86: new 66	java/lang/StringBuilder
    //   89: dup
    //   90: ldc -71
    //   92: invokespecial 187	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   95: aload_1
    //   96: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: iconst_0
    //   103: anewarray 4	java/lang/Object
    //   106: invokestatic 189	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   109: aload_1
    //   110: ldc 26
    //   112: invokevirtual 58	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   115: ifne +293 -> 408
    //   118: aload 5
    //   120: aload_1
    //   121: invokevirtual 195	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   124: astore_1
    //   125: new 197	java/util/Properties
    //   128: dup
    //   129: invokespecial 198	java/util/Properties:<init>	()V
    //   132: astore_2
    //   133: aload_2
    //   134: aload_1
    //   135: invokevirtual 202	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   138: aload_2
    //   139: ldc -52
    //   141: ldc 26
    //   143: invokevirtual 207	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   146: astore_2
    //   147: new 66	java/lang/StringBuilder
    //   150: dup
    //   151: ldc -47
    //   153: invokespecial 187	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   156: aload_2
    //   157: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: iconst_0
    //   164: anewarray 4	java/lang/Object
    //   167: invokestatic 189	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   170: ldc 26
    //   172: aload_2
    //   173: invokevirtual 58	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   176: istore 6
    //   178: iload 6
    //   180: ifne +34 -> 214
    //   183: aload_2
    //   184: astore_0
    //   185: aload_1
    //   186: ifnull -176 -> 10
    //   189: aload_1
    //   190: invokevirtual 214	java/io/InputStream:close	()V
    //   193: aload_2
    //   194: astore_0
    //   195: goto -185 -> 10
    //   198: astore_0
    //   199: aload_0
    //   200: invokestatic 217	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   203: aload_2
    //   204: astore_0
    //   205: goto -195 -> 10
    //   208: astore_0
    //   209: ldc 2
    //   211: monitorexit
    //   212: aload_0
    //   213: athrow
    //   214: aload_1
    //   215: astore_3
    //   216: aload_2
    //   217: astore_1
    //   218: aload_3
    //   219: astore_2
    //   220: aload_1
    //   221: astore_3
    //   222: aload_2
    //   223: ifnull +180 -> 403
    //   226: aload_2
    //   227: invokevirtual 214	java/io/InputStream:close	()V
    //   230: aload_0
    //   231: invokevirtual 96	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   234: aload_0
    //   235: invokevirtual 99	android/content/Context:getPackageName	()Ljava/lang/String;
    //   238: sipush 128
    //   241: invokevirtual 105	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   244: getfield 111	android/content/pm/ApplicationInfo:metaData	Landroid/os/Bundle;
    //   247: ldc -37
    //   249: invokevirtual 119	android/os/Bundle:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   252: astore_2
    //   253: aload_1
    //   254: astore_0
    //   255: aload_2
    //   256: ifnull -246 -> 10
    //   259: aload_2
    //   260: invokevirtual 120	java/lang/Object:toString	()Ljava/lang/String;
    //   263: astore_0
    //   264: goto -254 -> 10
    //   267: astore_2
    //   268: aload_2
    //   269: invokestatic 217	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   272: goto -42 -> 230
    //   275: astore_1
    //   276: ldc 26
    //   278: astore_1
    //   279: aload_0
    //   280: ldc 37
    //   282: iconst_0
    //   283: invokevirtual 43	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   286: invokeinterface 144 1 0
    //   291: ldc -79
    //   293: ldc 26
    //   295: invokeinterface 164 3 0
    //   300: invokeinterface 154 1 0
    //   305: pop
    //   306: ldc -35
    //   308: iconst_0
    //   309: anewarray 4	java/lang/Object
    //   312: invokestatic 223	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   315: aload_1
    //   316: astore_3
    //   317: aload_2
    //   318: ifnull +85 -> 403
    //   321: aload_2
    //   322: invokevirtual 214	java/io/InputStream:close	()V
    //   325: goto -95 -> 230
    //   328: astore_2
    //   329: aload_2
    //   330: invokestatic 217	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   333: goto -103 -> 230
    //   336: astore_0
    //   337: aconst_null
    //   338: astore_1
    //   339: aload_1
    //   340: ifnull +7 -> 347
    //   343: aload_1
    //   344: invokevirtual 214	java/io/InputStream:close	()V
    //   347: aload_0
    //   348: athrow
    //   349: astore_1
    //   350: aload_1
    //   351: invokestatic 217	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   354: goto -7 -> 347
    //   357: astore_0
    //   358: ldc -31
    //   360: iconst_0
    //   361: anewarray 4	java/lang/Object
    //   364: invokestatic 189	com/tencent/beacon/d/a:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   367: aload_1
    //   368: astore_0
    //   369: goto -359 -> 10
    //   372: astore_0
    //   373: goto -34 -> 339
    //   376: astore_0
    //   377: aload_2
    //   378: astore_1
    //   379: goto -40 -> 339
    //   382: astore_2
    //   383: ldc 26
    //   385: astore_3
    //   386: aload_1
    //   387: astore_2
    //   388: aload_3
    //   389: astore_1
    //   390: goto -111 -> 279
    //   393: astore_3
    //   394: aload_2
    //   395: astore_3
    //   396: aload_1
    //   397: astore_2
    //   398: aload_3
    //   399: astore_1
    //   400: goto -121 -> 279
    //   403: aload_3
    //   404: astore_1
    //   405: goto -175 -> 230
    //   408: ldc 26
    //   410: astore_1
    //   411: aload_3
    //   412: astore_2
    //   413: goto -193 -> 220
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	416	0	paramContext	Context
    //   45	209	1	localObject1	Object
    //   275	1	1	localException1	Exception
    //   278	66	1	str1	String
    //   349	19	1	localIOException1	java.io.IOException
    //   378	33	1	localObject2	Object
    //   16	244	2	localObject3	Object
    //   267	55	2	localIOException2	java.io.IOException
    //   328	50	2	localIOException3	java.io.IOException
    //   382	1	2	localException2	Exception
    //   387	26	2	localObject4	Object
    //   18	371	3	localObject5	Object
    //   393	1	3	localException3	Exception
    //   395	17	3	localObject6	Object
    //   41	6	4	str2	String
    //   23	96	5	localAssetManager	android.content.res.AssetManager
    //   176	3	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   189	193	198	java/io/IOException
    //   19	25	208	finally
    //   189	193	208	finally
    //   199	203	208	finally
    //   226	230	208	finally
    //   230	253	208	finally
    //   259	264	208	finally
    //   268	272	208	finally
    //   321	325	208	finally
    //   329	333	208	finally
    //   343	347	208	finally
    //   347	349	208	finally
    //   350	354	208	finally
    //   358	367	208	finally
    //   226	230	267	java/io/IOException
    //   25	43	275	java/lang/Exception
    //   46	56	275	java/lang/Exception
    //   59	86	275	java/lang/Exception
    //   86	125	275	java/lang/Exception
    //   321	325	328	java/io/IOException
    //   25	43	336	finally
    //   46	56	336	finally
    //   59	86	336	finally
    //   86	125	336	finally
    //   343	347	349	java/io/IOException
    //   230	253	357	java/lang/Throwable
    //   259	264	357	java/lang/Throwable
    //   125	147	372	finally
    //   147	178	372	finally
    //   279	315	376	finally
    //   125	147	382	java/lang/Exception
    //   147	178	393	java/lang/Exception
  }
  
  public static String b(Context paramContext, String paramString1, String paramString2)
  {
    return paramContext.getSharedPreferences("DENGTA_META", 0).getString(paramString1, paramString2);
  }
  
  public static void c(Context paramContext, String paramString)
  {
    paramContext.getSharedPreferences("DENGTA_META", 0).edit().putString("key_channelpath", paramString).commit();
  }
  
  public static boolean c(Context paramContext)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    if (paramContext == null) {}
    for (;;)
    {
      try
      {
        a.d("context == null return null", new Object[0]);
        return bool2;
      }
      finally {}
      boolean bool1 = bool3;
      try
      {
        String str2 = paramContext.getSharedPreferences("DENGTA_META", 4).getString("APPKEY_DENGTA", null);
        bool1 = bool3;
        String str1 = a(paramContext);
        if (str2 != null)
        {
          bool1 = bool3;
          if (str2.equals(str1)) {}
        }
        else
        {
          bool3 = true;
          bool2 = true;
          bool1 = bool3;
          paramContext = paramContext.getSharedPreferences("DENGTA_META", 0).edit();
          bool1 = bool3;
          paramContext.putString("APPKEY_DENGTA", str1);
          bool1 = bool3;
          paramContext.commit();
        }
      }
      catch (Exception paramContext)
      {
        a.b("updateLocalAPPKEY fail!", new Object[0]);
        a.a(paramContext);
        bool2 = bool1;
      }
    }
  }
  
  public static void d(Context paramContext, String paramString)
  {
    paramContext.getSharedPreferences("DENGTA_META", 0).edit().putString("querytimes", paramString).commit();
  }
  
  public static boolean d(Context paramContext)
  {
    if (paramContext == null) {
      a.d("context == null return null", new Object[0]);
    }
    for (;;)
    {
      return false;
      try
      {
        String str2 = paramContext.getSharedPreferences("DENGTA_META", 0).getString("APPVER_DENGTA", null);
        String str1 = f(paramContext);
        if (str2 != null)
        {
          bool = str2.equals(str1);
          if (bool) {}
        }
        else
        {
          bool = true;
          a.b("updateLocalAPPKEY fail!", new Object[0]);
        }
      }
      catch (Exception paramContext)
      {
        try
        {
          paramContext = paramContext.getSharedPreferences("DENGTA_META", 0).edit();
          paramContext.putString("APPVER_DENGTA", str1);
          paramContext.commit();
          return true;
        }
        catch (Exception paramContext)
        {
          boolean bool;
          for (;;) {}
        }
        paramContext = paramContext;
        bool = false;
      }
    }
    a.a(paramContext);
    return bool;
  }
  
  public static String e(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    return paramContext.getPackageName();
  }
  
  public static void e(Context paramContext, String paramString)
  {
    paramContext.getSharedPreferences("DENGTA_META", 0).edit().putString("initsdkdate", paramString).commit();
  }
  
  public static String f(Context paramContext)
  {
    int i = 0;
    for (;;)
    {
      int k;
      try
      {
        if (b != null)
        {
          paramContext = b;
          return paramContext;
        }
        Object localObject;
        if (paramContext == null) {
          localObject = null;
        }
        try
        {
          paramContext = paramContext.getPackageManager().getPackageInfo((String)localObject, 0);
          localObject = paramContext.versionName;
          int m = paramContext.versionCode;
          if ((localObject == null) || (((String)localObject).trim().length() <= 0))
          {
            paramContext = String.valueOf(m);
            continue;
            localObject = paramContext.getPackageName();
            continue;
          }
          paramContext = ((String)localObject).trim().replace('\n', ' ').replace('\r', ' ').replace("|", "%7C");
          localObject = paramContext.toCharArray();
          j = 0;
          if (i < localObject.length)
          {
            k = j;
            if (localObject[i] != '.') {
              break label235;
            }
            k = j + 1;
            break label235;
          }
          if (j >= 3) {
            break label232;
          }
          a.a("add versionCode: %s", new Object[] { Integer.valueOf(m) });
          paramContext = paramContext + "." + m;
          a.a("version: %s", new Object[] { paramContext });
        }
        catch (Exception paramContext)
        {
          a.a(paramContext);
          a.d(paramContext.toString(), new Object[0]);
          paramContext = "";
        }
        continue;
        continue;
      }
      finally {}
      label232:
      label235:
      i += 1;
      int j = k;
    }
  }
  
  private static boolean f(Context paramContext, String paramString)
  {
    boolean bool3 = true;
    boolean bool1;
    boolean bool2;
    if ((paramContext != null) && (paramString != null)) {
      if (paramContext.checkPermission(paramString, Process.myPid(), Process.myUid()) == 0)
      {
        bool1 = true;
        bool2 = bool1;
        if (bool1) {}
      }
    }
    label160:
    for (;;)
    {
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 4096).requestedPermissions;
        if (paramContext == null) {
          break label160;
        }
        int j = paramContext.length;
        int i = 0;
        if (i >= j) {
          break label160;
        }
        bool2 = paramString.equals(paramContext[i]);
        if (bool2)
        {
          bool1 = bool3;
          a.b("AppInfo.isContainReadLogPermission() end", new Object[0]);
          bool2 = bool1;
          return bool2;
          bool1 = false;
          break;
        }
        i += 1;
        continue;
      }
      catch (Throwable paramContext)
      {
        a.a(paramContext);
        return bool1;
      }
      finally
      {
        a.b("AppInfo.isContainReadLogPermission() end", new Object[0]);
      }
      return false;
    }
  }
  
  public static boolean g(Context paramContext)
  {
    try
    {
      a.b("Read phone state permission check! start ", new Object[0]);
      if (d == null) {
        d = Boolean.valueOf(f(paramContext, "android.permission.READ_PHONE_STATE"));
      }
      boolean bool = d.booleanValue();
      return bool;
    }
    finally {}
  }
  
  private static boolean g(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null) || (paramString.trim().length() <= 0)) {
      return false;
    }
    try
    {
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
      if ((paramContext == null) || (paramContext.size() == 0))
      {
        a.b("no running proc", new Object[0]);
        return false;
      }
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        Object localObject = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (((ActivityManager.RunningAppProcessInfo)localObject).importance == 100)
        {
          localObject = ((ActivityManager.RunningAppProcessInfo)localObject).pkgList;
          int j = localObject.length;
          int i = 0;
          while (i < j)
          {
            boolean bool = paramString.equals(localObject[i]);
            if (bool) {
              return true;
            }
            i += 1;
          }
        }
      }
      return false;
    }
    catch (Throwable paramContext)
    {
      a.a(paramContext);
      a.d("Failed to judge }[%s]", new Object[] { paramContext.getLocalizedMessage() });
    }
  }
  
  public static boolean h(Context paramContext)
  {
    return g(paramContext, paramContext.getPackageName());
  }
  
  public static int i(Context paramContext)
  {
    try
    {
      if (e == 0) {
        e = Process.myPid();
      }
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (localRunningAppProcessInfo.pid == e)
        {
          int i = localRunningAppProcessInfo.importance;
          return i;
        }
      }
    }
    catch (Exception paramContext) {}
    return 0;
  }
  
  public static String j(Context paramContext)
  {
    if (c != null) {
      return c;
    }
    try
    {
      if (e == 0) {
        e = Process.myPid();
      }
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (localRunningAppProcessInfo.pid == e)
        {
          paramContext = localRunningAppProcessInfo.processName;
          c = paramContext;
          return paramContext;
        }
      }
    }
    catch (Throwable paramContext)
    {
      a.a(paramContext);
    }
    return "";
  }
  
  public static SharedPreferences.Editor k(Context paramContext)
  {
    return paramContext.getSharedPreferences("DENGTA_META", 0).edit();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\beacon\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */