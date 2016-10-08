package com.tencent.mobileqq.pluginsdk;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

public abstract class PluginStatic
{
  public static final String PARAM_CLASS_STATISTICS_UPLOADER = "clsUploader";
  public static final String PARAM_CLEAR_TOP = "cleartop";
  public static final String PARAM_EXTRA_INFO = "pluginsdk_extraInfo";
  public static final String PARAM_LAUNCH_ACTIVITY = "pluginsdk_launchActivity";
  public static final String PARAM_LAUNCH_SERVICE = "pluginsdk_launchService";
  public static final String PARAM_PATH = "pluginsdk_pluginpath";
  public static final String PARAM_PLUGIN_GESTURELOCK = "param_plugin_gesturelock";
  public static final String PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY = "PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY";
  public static final String PARAM_PLUGIN_LOCATION = "pluginsdk_pluginLocation";
  public static final String PARAM_PLUGIN_NAME = "pluginsdk_pluginName";
  public static final String PARAM_PLUGIN_RECEIVER_CLASS_NAME = "pluginsdk_launchReceiver";
  public static final String PARAM_UIN = "pluginsdk_selfuin";
  public static final String PARAM_USE_QQ_RESOURCES = "userQqResources";
  public static final String PARAM_USE_SKIN_ENGINE = "useSkinEngine";
  public static final int USER_QQ_RESOURCES_BOTH = 2;
  public static final int USER_QQ_RESOURCES_NO = -1;
  public static final int USER_QQ_RESOURCES_YES = 1;
  static final String a = "com.tencent.mobileqq";
  static final String b = "pluginsdk_IsPluginActivity";
  static final ConcurrentHashMap c = new ConcurrentHashMap();
  static final ConcurrentHashMap d = new ConcurrentHashMap();
  private static final HashMap e = new HashMap();
  private static ArrayList f = new ArrayList();
  
  /* Error */
  static ClassLoader a(Context paramContext, String paramString1, String paramString2)
    throws Exception
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 83	com/tencent/mobileqq/pluginsdk/PluginStatic:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   6: aload_1
    //   7: invokevirtual 101	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 103	dalvik/system/DexClassLoader
    //   13: astore 4
    //   15: aload 4
    //   17: astore_3
    //   18: aload 4
    //   20: ifnonnull +118 -> 138
    //   23: aload_0
    //   24: invokestatic 109	com/tencent/mobileqq/pluginsdk/PluginUtils:getOptimizedDexPath	(Landroid/content/Context;)Ljava/io/File;
    //   27: invokevirtual 115	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   30: astore_3
    //   31: aload_0
    //   32: aload_1
    //   33: invokestatic 119	com/tencent/mobileqq/pluginsdk/PluginUtils:getPluginLibPath	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   36: invokevirtual 115	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   39: astore 4
    //   41: aload_2
    //   42: ldc 121
    //   44: invokevirtual 127	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   47: ifeq +96 -> 143
    //   50: new 129	com/tencent/commonsdk/soload/SoDexClassLoader
    //   53: dup
    //   54: aload_2
    //   55: aload_3
    //   56: aload 4
    //   58: aload_0
    //   59: invokevirtual 135	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   62: invokespecial 138	com/tencent/commonsdk/soload/SoDexClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   65: astore_3
    //   66: getstatic 85	com/tencent/mobileqq/pluginsdk/PluginStatic:d	Ljava/util/concurrent/ConcurrentHashMap;
    //   69: aload_2
    //   70: invokevirtual 101	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   73: checkcast 140	android/content/pm/PackageInfo
    //   76: astore 4
    //   78: aload 4
    //   80: astore 5
    //   82: aload 4
    //   84: ifnonnull +33 -> 117
    //   87: aload_0
    //   88: aload_2
    //   89: sipush 129
    //   92: invokestatic 146	com/tencent/mobileqq/pluginsdk/ApkFileParser:getPackageInfoWithException	(Landroid/content/Context;Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   95: astore_0
    //   96: aload_0
    //   97: ifnonnull +8 -> 105
    //   100: ldc -108
    //   102: invokestatic 154	com/tencent/mobileqq/pluginsdk/DebugHelper:log	(Ljava/lang/String;)V
    //   105: getstatic 85	com/tencent/mobileqq/pluginsdk/PluginStatic:d	Ljava/util/concurrent/ConcurrentHashMap;
    //   108: aload_2
    //   109: aload_0
    //   110: invokevirtual 158	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   113: pop
    //   114: aload_0
    //   115: astore 5
    //   117: aload 5
    //   119: ifnull +10 -> 129
    //   122: aload 5
    //   124: aload_1
    //   125: aload_3
    //   126: invokestatic 161	com/tencent/mobileqq/pluginsdk/PluginStatic:a	(Landroid/content/pm/PackageInfo;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   129: getstatic 83	com/tencent/mobileqq/pluginsdk/PluginStatic:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   132: aload_1
    //   133: aload_3
    //   134: invokevirtual 158	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   137: pop
    //   138: ldc 2
    //   140: monitorexit
    //   141: aload_3
    //   142: areturn
    //   143: new 103	dalvik/system/DexClassLoader
    //   146: dup
    //   147: aload_2
    //   148: aload_3
    //   149: aload 4
    //   151: aload_0
    //   152: invokevirtual 135	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   155: invokespecial 162	dalvik/system/DexClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   158: astore_3
    //   159: goto -93 -> 66
    //   162: astore_0
    //   163: ldc 2
    //   165: monitorexit
    //   166: aload_0
    //   167: athrow
    //   168: astore_0
    //   169: ldc -92
    //   171: ldc -108
    //   173: aload_0
    //   174: invokestatic 167	com/tencent/mobileqq/pluginsdk/DebugHelper:log	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   177: aload 4
    //   179: astore_0
    //   180: goto -84 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	paramContext	Context
    //   0	183	1	paramString1	String
    //   0	183	2	paramString2	String
    //   17	142	3	localObject1	Object
    //   13	165	4	localObject2	Object
    //   80	43	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   3	15	162	finally
    //   23	66	162	finally
    //   66	78	162	finally
    //   87	96	162	finally
    //   100	105	162	finally
    //   105	114	162	finally
    //   122	129	162	finally
    //   129	138	162	finally
    //   143	159	162	finally
    //   169	177	162	finally
    //   87	96	168	java/lang/Throwable
  }
  
  static List a()
  {
    return f;
  }
  
  static void a(PackageInfo paramPackageInfo, String paramString, ClassLoader paramClassLoader)
  {
    try
    {
      if ((IPluginLife)e.get(paramString) != null) {
        return;
      }
      if ((paramPackageInfo != null) && (paramPackageInfo.applicationInfo != null) && (paramPackageInfo.applicationInfo.metaData != null))
      {
        paramPackageInfo = paramPackageInfo.applicationInfo.metaData.getString("PLUGIN_LIFE_CLASS");
        if (paramPackageInfo != null)
        {
          paramPackageInfo = (IPluginLife)paramClassLoader.loadClass(paramPackageInfo).newInstance();
          e.put(paramString, paramPackageInfo);
          paramPackageInfo.onLoad();
          return;
        }
      }
    }
    catch (Throwable paramPackageInfo) {}
  }
  
  static void a(IPluginActivity paramIPluginActivity)
  {
    
    synchronized (f)
    {
      f.add(new WeakReference(paramIPluginActivity));
      return;
    }
  }
  
  static boolean a(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    for (;;)
    {
      return false;
      try
      {
        String str = paramBundle.getString("pluginsdk_pluginLocation");
        if ((!TextUtils.isEmpty(str)) && (!str.substring(0, str.lastIndexOf(".")).contains(".")) && (!TextUtils.isEmpty(paramBundle.getString("pluginsdk_pluginName"))))
        {
          paramBundle = paramBundle.getString("pluginsdk_pluginpath");
          if (!TextUtils.isEmpty(paramBundle))
          {
            if (TextUtils.isEmpty(paramBundle)) {
              return true;
            }
            boolean bool = a(paramBundle);
            return bool;
          }
        }
      }
      catch (Throwable paramBundle) {}
    }
    return false;
  }
  
  static boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (paramString.contains("..")) {
        return bool1;
      }
      if (paramString.endsWith(".so"))
      {
        String str = MobileQQ.getContext().getFilesDir().getParent();
        File localFile = new File(str + "/txlib/");
        if ((a(paramString, new File(str + "/lib/"))) || (!a(paramString, localFile))) {}
      }
      else
      {
        bool1 = bool2;
        if (!paramString.endsWith(".apk")) {
          return bool1;
        }
        bool1 = a(paramString, PluginUtils.getPluginInstallDir(MobileQQ.getContext()));
        return bool1;
      }
    }
    catch (Exception paramString)
    {
      return false;
    }
    bool1 = true;
    return bool1;
  }
  
  private static boolean a(String paramString, File paramFile)
    throws IOException
  {
    paramFile = paramFile.getCanonicalPath();
    String str = new File(paramString).getParentFile().getCanonicalPath();
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "path:" + paramString + "-> [" + str + ", " + paramFile + "]");
    }
    return str.equals(paramFile);
  }
  
  static ClassLoader b(String paramString)
  {
    try
    {
      paramString = (DexClassLoader)c.get(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  static void b()
  {
    ArrayList localArrayList = f;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < f.size())
        {
          if (((WeakReference)f.get(i)).get() == null)
          {
            f.remove(i);
            i -= 1;
          }
        }
        else {
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  static void b(IPluginActivity paramIPluginActivity)
  {
    b();
    c(paramIPluginActivity);
  }
  
  public static String byteArrayToHex(byte[] paramArrayOfByte)
  {
    int i = 0;
    char[] arrayOfChar1 = new char[16];
    char[] tmp8_7 = arrayOfChar1;
    tmp8_7[0] = 48;
    char[] tmp14_8 = tmp8_7;
    tmp14_8[1] = 49;
    char[] tmp20_14 = tmp14_8;
    tmp20_14[2] = 50;
    char[] tmp26_20 = tmp20_14;
    tmp26_20[3] = 51;
    char[] tmp32_26 = tmp26_20;
    tmp32_26[4] = 52;
    char[] tmp38_32 = tmp32_26;
    tmp38_32[5] = 53;
    char[] tmp44_38 = tmp38_32;
    tmp44_38[6] = 54;
    char[] tmp51_44 = tmp44_38;
    tmp51_44[7] = 55;
    char[] tmp58_51 = tmp51_44;
    tmp58_51[8] = 56;
    char[] tmp65_58 = tmp58_51;
    tmp65_58[9] = 57;
    char[] tmp72_65 = tmp65_58;
    tmp72_65[10] = 65;
    char[] tmp79_72 = tmp72_65;
    tmp79_72[11] = 66;
    char[] tmp86_79 = tmp79_72;
    tmp86_79[12] = 67;
    char[] tmp93_86 = tmp86_79;
    tmp93_86[13] = 68;
    char[] tmp100_93 = tmp93_86;
    tmp100_93[14] = 69;
    char[] tmp107_100 = tmp100_93;
    tmp107_100[15] = 70;
    tmp107_100;
    char[] arrayOfChar2 = new char[paramArrayOfByte.length * 2];
    int k = paramArrayOfByte.length;
    int j = 0;
    while (i < k)
    {
      int m = paramArrayOfByte[i];
      int n = j + 1;
      arrayOfChar2[j] = arrayOfChar1[(m >>> 4 & 0xF)];
      j = n + 1;
      arrayOfChar2[n] = arrayOfChar1[(m & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar2);
  }
  
  private static boolean c(IPluginActivity paramIPluginActivity)
  {
    ArrayList localArrayList = f;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < f.size())
        {
          if (((WeakReference)f.get(i)).get() == paramIPluginActivity)
          {
            f.remove(i);
            return true;
          }
        }
        else {
          return false;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  /* Error */
  public static String encodeFile(String paramString)
  {
    // Byte code:
    //   0: new 111	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 269	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 347	java/io/File:exists	()Z
    //   13: ifeq +10 -> 23
    //   16: aload_0
    //   17: invokevirtual 350	java/io/File:isFile	()Z
    //   20: ifne +24 -> 44
    //   23: invokestatic 290	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +12 -> 38
    //   29: ldc -92
    //   31: iconst_2
    //   32: ldc_w 352
    //   35: invokestatic 354	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   38: ldc_w 356
    //   41: astore_2
    //   42: aload_2
    //   43: areturn
    //   44: ldc_w 358
    //   47: invokestatic 364	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   50: astore_3
    //   51: new 366	java/io/FileInputStream
    //   54: dup
    //   55: aload_0
    //   56: invokespecial 369	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   59: astore_1
    //   60: aload_1
    //   61: astore_0
    //   62: sipush 16384
    //   65: newarray <illegal type>
    //   67: astore_2
    //   68: aload_1
    //   69: astore_0
    //   70: aload_1
    //   71: aload_2
    //   72: invokevirtual 373	java/io/FileInputStream:read	([B)I
    //   75: istore 4
    //   77: iload 4
    //   79: iconst_m1
    //   80: if_icmpeq +80 -> 160
    //   83: aload_1
    //   84: astore_0
    //   85: aload_3
    //   86: aload_2
    //   87: iconst_0
    //   88: iload 4
    //   90: invokevirtual 377	java/security/MessageDigest:update	([BII)V
    //   93: goto -25 -> 68
    //   96: astore_2
    //   97: aload_1
    //   98: astore_0
    //   99: invokestatic 290	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   102: ifeq +34 -> 136
    //   105: aload_1
    //   106: astore_0
    //   107: ldc -92
    //   109: iconst_2
    //   110: new 257	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   117: ldc_w 379
    //   120: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: aload_2
    //   124: invokestatic 383	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   127: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 354	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   136: aload_1
    //   137: ifnull +82 -> 219
    //   140: aload_1
    //   141: invokevirtual 386	java/io/FileInputStream:close	()V
    //   144: ldc_w 356
    //   147: areturn
    //   148: astore_0
    //   149: aload_1
    //   150: astore_0
    //   151: sipush 4096
    //   154: newarray <illegal type>
    //   156: astore_2
    //   157: goto -89 -> 68
    //   160: aload_1
    //   161: astore_0
    //   162: aload_3
    //   163: invokevirtual 390	java/security/MessageDigest:digest	()[B
    //   166: invokestatic 392	com/tencent/mobileqq/pluginsdk/PluginStatic:byteArrayToHex	([B)Ljava/lang/String;
    //   169: astore_2
    //   170: aload_2
    //   171: astore_0
    //   172: aload_0
    //   173: astore_2
    //   174: aload_1
    //   175: ifnull -133 -> 42
    //   178: aload_1
    //   179: invokevirtual 386	java/io/FileInputStream:close	()V
    //   182: aload_0
    //   183: areturn
    //   184: astore_1
    //   185: aload_0
    //   186: areturn
    //   187: astore_0
    //   188: ldc_w 356
    //   191: areturn
    //   192: astore_1
    //   193: aconst_null
    //   194: astore_0
    //   195: aload_0
    //   196: ifnull +7 -> 203
    //   199: aload_0
    //   200: invokevirtual 386	java/io/FileInputStream:close	()V
    //   203: aload_1
    //   204: athrow
    //   205: astore_0
    //   206: goto -3 -> 203
    //   209: astore_1
    //   210: goto -15 -> 195
    //   213: astore_2
    //   214: aconst_null
    //   215: astore_1
    //   216: goto -119 -> 97
    //   219: ldc_w 356
    //   222: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	223	0	paramString	String
    //   59	120	1	localFileInputStream	java.io.FileInputStream
    //   184	1	1	localIOException	IOException
    //   192	12	1	localObject1	Object
    //   209	1	1	localObject2	Object
    //   215	1	1	localObject3	Object
    //   41	46	2	localObject4	Object
    //   96	28	2	localException1	Exception
    //   156	18	2	localObject5	Object
    //   213	1	2	localException2	Exception
    //   50	113	3	localMessageDigest	java.security.MessageDigest
    //   75	14	4	i	int
    // Exception table:
    //   from	to	target	type
    //   62	68	96	java/lang/Exception
    //   70	77	96	java/lang/Exception
    //   85	93	96	java/lang/Exception
    //   151	157	96	java/lang/Exception
    //   162	170	96	java/lang/Exception
    //   62	68	148	java/lang/OutOfMemoryError
    //   178	182	184	java/io/IOException
    //   140	144	187	java/io/IOException
    //   44	60	192	finally
    //   199	203	205	java/io/IOException
    //   62	68	209	finally
    //   70	77	209	finally
    //   85	93	209	finally
    //   99	105	209	finally
    //   107	136	209	finally
    //   151	157	209	finally
    //   162	170	209	finally
    //   44	60	213	java/lang/Exception
  }
  
  public static ClassLoader getOrCreateClassLoader(Context paramContext, String paramString)
    throws Exception
  {
    try
    {
      ClassLoader localClassLoader2 = (ClassLoader)c.get(paramString);
      ClassLoader localClassLoader1 = localClassLoader2;
      if (localClassLoader2 == null) {
        localClassLoader1 = a(paramContext, paramString, PluginUtils.getInstalledPluginPath(paramContext, paramString).getCanonicalPath());
      }
      return localClassLoader1;
    }
    finally {}
  }
  
  public static List isProcessesExist(Context paramContext, List paramList)
  {
    ArrayList localArrayList = null;
    if (paramList != null)
    {
      localArrayList = new ArrayList();
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
      if (paramContext == null)
      {
        int i = 0;
        while (i < paramList.size())
        {
          localArrayList.add(Boolean.FALSE);
          i += 1;
        }
      }
    }
    else
    {
      return localArrayList;
    }
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      String str = (String)paramList.next();
      Iterator localIterator = paramContext.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!str.equalsIgnoreCase(((ActivityManager.RunningAppProcessInfo)localIterator.next()).processName));
      for (boolean bool = true;; bool = false)
      {
        localArrayList.add(Boolean.valueOf(bool));
        break;
      }
    }
    return localArrayList;
  }
  
  public static abstract interface IPluginLife
  {
    public abstract void onLoad();
    
    public abstract void onUnload();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\pluginsdk\PluginStatic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */