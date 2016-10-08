package cooperation.qzone.cache;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.utils.AssertUtil;
import com.tencent.component.network.utils.FileUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QUA;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import ylt;
import ylu;

public class CacheManager
{
  public static final int a = 104857600;
  private static final long jdField_a_of_type_Long = 5242880L;
  private static FileStorageHandler jdField_a_of_type_CooperationQzoneCacheFileStorageHandler;
  private static Object jdField_a_of_type_JavaLangObject;
  public static final String a;
  private static final HashMap jdField_a_of_type_JavaUtilHashMap;
  private static volatile boolean jdField_a_of_type_Boolean = false;
  public static final int b = 41943040;
  private static long jdField_b_of_type_Long = 0L;
  public static final String b = "audio";
  private static HashMap jdField_b_of_type_JavaUtilHashMap;
  private static boolean jdField_b_of_type_Boolean = true;
  public static final int c = 52428800;
  public static final String c = "video";
  private static HashMap c;
  public static final int d = 20971520;
  public static final String d = "react";
  public static final int e = 104857600;
  public static final String e = "avatar";
  public static final int f = 20971520;
  public static final String f = "offline";
  public static final int g = 104857600;
  public static final String g = "personalise_font";
  public static final int h = 41943040;
  public static final String h = "video_cache";
  private static final int i = 1048576;
  public static final String i = "rapid_comment";
  public static final String j = "gift_fullscreen";
  private static final String k = "qua";
  private static String l;
  private static String m;
  private static final String n = "无SD Card";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = CacheManager.class.getSimpleName();
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
    c = new HashMap();
    l = "";
  }
  
  public static final long a()
  {
    if (!a()) {
      return -1L;
    }
    Object localObject = i();
    try
    {
      localObject = new StatFs((String)localObject);
      long l1 = ((StatFs)localObject).getBlockSize();
      int i1 = ((StatFs)localObject).getBlockCount();
      return i1 * l1;
    }
    catch (Exception localException)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "", localException);
    }
    return -1L;
  }
  
  public static FileCacheService a()
  {
    return a("audio", 104857600, 41943040);
  }
  
  public static FileCacheService a(String paramString, int paramInt1, int paramInt2)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (boolean bool = true;; bool = false)
    {
      AssertUtil.assertTrue(bool);
      synchronized (jdField_a_of_type_JavaUtilHashMap)
      {
        FileCacheService localFileCacheService2 = (FileCacheService)jdField_a_of_type_JavaUtilHashMap.get(paramString);
        FileCacheService localFileCacheService1 = localFileCacheService2;
        if (localFileCacheService2 == null)
        {
          localFileCacheService1 = new FileCacheService(paramString, paramInt1, paramInt2);
          localFileCacheService1.a(a());
          jdField_a_of_type_JavaUtilHashMap.put(paramString, localFileCacheService1);
        }
        return localFileCacheService1;
      }
    }
  }
  
  public static FileStorageHandler a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_CooperationQzoneCacheFileStorageHandler == null) {
        jdField_a_of_type_CooperationQzoneCacheFileStorageHandler = new FileStorageHandler(new ylt());
      }
      return jdField_a_of_type_CooperationQzoneCacheFileStorageHandler;
    }
  }
  
  public static final String a()
  {
    return a("personalise_font");
  }
  
  private static String a(int paramInt)
  {
    if (paramInt == 0) {
      return "byte";
    }
    if (paramInt == 1) {
      return "KB";
    }
    if (paramInt == 2) {
      return "MB";
    }
    if (paramInt == 3) {
      return "GB";
    }
    if (paramInt == 4) {
      return "TB";
    }
    if (paramInt == 5) {
      return "PB";
    }
    return "";
  }
  
  private static final String a(int paramInt, float paramFloat)
  {
    if (paramFloat < 0.0F) {
      return "";
    }
    if (paramFloat < 1024.0F) {
      return String.format("%.2f", new Object[] { Float.valueOf(paramFloat) }) + a(paramInt);
    }
    return a(paramInt + 1, paramFloat / 1024.0F);
  }
  
  private static final String a(long paramLong)
  {
    return a(0, (float)paramLong);
  }
  
  public static String a(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    String str = c(paramString);
    if (TextUtils.isEmpty(str)) {}
    for (;;)
    {
      int i1 = paramString.hashCode();
      if ("mounted".equals(Environment.getExternalStorageState()))
      {
        paramContext = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "Android" + File.separator + "data" + File.separator + "com.qzone" + File.separator + "cache" + File.separator + "imageV2";
        if (paramContext != null) {
          break label168;
        }
      }
      label168:
      for (paramContext = null;; paramContext = paramContext + File.separator + String.valueOf(i1))
      {
        return paramContext;
        paramContext = paramContext.getCacheDir().getAbsolutePath() + File.separator + "qzone" + File.separator + "image";
        break;
      }
      paramString = str;
    }
  }
  
  public static String a(Context paramContext, String paramString, long paramLong)
  {
    paramContext = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramContext = String.valueOf(System.currentTimeMillis());
    }
    paramContext = a().a(paramLong + "_" + paramContext, true);
    if (paramContext == null) {
      return null;
    }
    return paramContext.getAbsolutePath();
  }
  
  public static String a(String paramString)
  {
    String str = i();
    if (TextUtils.isEmpty(paramString)) {
      return str;
    }
    paramString = new File(str + File.separator + paramString);
    if (paramString.isFile()) {
      FileUtils.delete(paramString);
    }
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
    return paramString.getAbsolutePath();
  }
  
  public static void a()
  {
    c.clear();
    jdField_a_of_type_Boolean = false;
    d();
    a(false, false);
  }
  
  public static void a(long paramLong)
  {
    b(paramLong);
    ThreadManager.a(new ylu(), null, false);
  }
  
  public static void a(Context paramContext)
  {
    paramContext = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "Android" + File.separator + "data" + File.separator + "com.qzone" + File.separator + "cache" + File.separator + "imageV2";
    if (paramContext != null) {
      FileUtil.c(paramContext);
    }
    paramContext = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "Android" + File.separator + "data" + File.separator + "com.qzone" + File.separator + "cache" + File.separator + "video";
    if (paramContext != null) {
      FileUtil.c(paramContext);
    }
    paramContext = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "Android" + File.separator + "data" + File.separator + "com.qzone" + File.separator + "cache" + File.separator + "paster";
    if (paramContext != null) {
      FileUtil.c(paramContext);
    }
    FileUtil.c(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "Android" + File.separator + "data" + File.separator + "com.tencent.mobileqq" + File.separator + "cache" + File.separator + "video_cache");
    paramContext = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "Android" + File.separator + "data" + File.separator + "com.qzone" + File.separator + "cache" + File.separator + "file";
    if (paramContext != null) {
      FileUtil.c(paramContext);
    }
    paramContext = i();
    if (paramContext != null) {
      FileUtil.c(paramContext);
    }
    paramContext = g();
    if (paramContext != null) {
      FileUtil.c(paramContext);
    }
  }
  
  /* Error */
  private static void a(String paramString)
  {
    // Byte code:
    //   0: new 235	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 281	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 293	java/io/File:exists	()Z
    //   13: ifeq +166 -> 179
    //   16: new 336	java/io/BufferedReader
    //   19: dup
    //   20: new 338	java/io/FileReader
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 340	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   28: invokespecial 343	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   31: astore_1
    //   32: aload_1
    //   33: astore_0
    //   34: aload_1
    //   35: invokevirtual 346	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   38: astore_2
    //   39: aload_2
    //   40: ifnull +140 -> 180
    //   43: aload_1
    //   44: astore_0
    //   45: aload_2
    //   46: ldc_w 348
    //   49: invokevirtual 351	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   52: ifeq -20 -> 32
    //   55: aload_1
    //   56: astore_0
    //   57: aload_2
    //   58: ldc_w 353
    //   61: invokevirtual 357	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   64: astore_3
    //   65: aload_1
    //   66: astore_0
    //   67: aload_3
    //   68: arraylength
    //   69: iconst_3
    //   70: if_icmplt -38 -> 32
    //   73: aload_3
    //   74: iconst_2
    //   75: aaload
    //   76: astore_2
    //   77: aload_3
    //   78: iconst_1
    //   79: aaload
    //   80: astore_3
    //   81: aload_1
    //   82: astore_0
    //   83: new 235	java/io/File
    //   86: dup
    //   87: aload_2
    //   88: invokespecial 281	java/io/File:<init>	(Ljava/lang/String;)V
    //   91: invokevirtual 293	java/io/File:exists	()Z
    //   94: ifeq -62 -> 32
    //   97: aload_1
    //   98: astore_0
    //   99: getstatic 84	cooperation/qzone/cache/CacheManager:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   102: aload_3
    //   103: aload_2
    //   104: invokevirtual 155	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   107: pop
    //   108: aload_1
    //   109: astore_0
    //   110: invokestatic 360	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   113: ifeq -81 -> 32
    //   116: aload_1
    //   117: astore_0
    //   118: getstatic 72	cooperation/qzone/cache/CacheManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   121: iconst_4
    //   122: new 185	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 186	java/lang/StringBuilder:<init>	()V
    //   129: ldc_w 362
    //   132: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload_3
    //   136: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: ldc_w 364
    //   142: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload_2
    //   146: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokestatic 367	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   155: goto -123 -> 32
    //   158: astore_2
    //   159: aload_1
    //   160: astore_0
    //   161: getstatic 72	cooperation/qzone/cache/CacheManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   164: iconst_1
    //   165: ldc 88
    //   167: aload_2
    //   168: invokestatic 120	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   171: aload_1
    //   172: ifnull +7 -> 179
    //   175: aload_1
    //   176: invokevirtual 370	java/io/BufferedReader:close	()V
    //   179: return
    //   180: aload_1
    //   181: astore_0
    //   182: aload_1
    //   183: invokevirtual 370	java/io/BufferedReader:close	()V
    //   186: aload_1
    //   187: ifnull -8 -> 179
    //   190: aload_1
    //   191: invokevirtual 370	java/io/BufferedReader:close	()V
    //   194: return
    //   195: astore_0
    //   196: getstatic 72	cooperation/qzone/cache/CacheManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   199: iconst_1
    //   200: ldc 88
    //   202: aload_0
    //   203: invokestatic 120	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   206: return
    //   207: astore_0
    //   208: getstatic 72	cooperation/qzone/cache/CacheManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   211: iconst_1
    //   212: ldc 88
    //   214: aload_0
    //   215: invokestatic 120	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   218: return
    //   219: astore_1
    //   220: aconst_null
    //   221: astore_0
    //   222: aload_0
    //   223: ifnull +7 -> 230
    //   226: aload_0
    //   227: invokevirtual 370	java/io/BufferedReader:close	()V
    //   230: aload_1
    //   231: athrow
    //   232: astore_0
    //   233: getstatic 72	cooperation/qzone/cache/CacheManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   236: iconst_1
    //   237: ldc 88
    //   239: aload_0
    //   240: invokestatic 120	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   243: goto -13 -> 230
    //   246: astore_1
    //   247: goto -25 -> 222
    //   250: astore_2
    //   251: aconst_null
    //   252: astore_1
    //   253: goto -94 -> 159
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	256	0	paramString	String
    //   31	160	1	localBufferedReader	java.io.BufferedReader
    //   219	12	1	localObject1	Object
    //   246	1	1	localObject2	Object
    //   252	1	1	localObject3	Object
    //   38	108	2	str	String
    //   158	10	2	localException1	Exception
    //   250	1	2	localException2	Exception
    //   64	72	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   34	39	158	java/lang/Exception
    //   45	55	158	java/lang/Exception
    //   57	65	158	java/lang/Exception
    //   67	73	158	java/lang/Exception
    //   83	97	158	java/lang/Exception
    //   99	108	158	java/lang/Exception
    //   110	116	158	java/lang/Exception
    //   118	155	158	java/lang/Exception
    //   182	186	158	java/lang/Exception
    //   190	194	195	java/io/IOException
    //   175	179	207	java/io/IOException
    //   16	32	219	finally
    //   226	230	232	java/io/IOException
    //   34	39	246	finally
    //   45	55	246	finally
    //   57	65	246	finally
    //   67	73	246	finally
    //   83	97	246	finally
    //   99	108	246	finally
    //   110	116	246	finally
    //   118	155	246	finally
    //   161	171	246	finally
    //   182	186	246	finally
    //   16	32	250	java/lang/Exception
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      try
      {
        localObject = Environment.getExternalStorageState();
        jdField_b_of_type_Boolean = false;
        if ((!paramBoolean1) && ("mounted".equals(localObject)))
        {
          if ((paramBoolean2 != true) || (TextUtils.isEmpty(l))) {
            continue;
          }
          m = l + File.separator + "Android" + File.separator + "data" + File.separator + "com.tencent.mobileqq" + File.separator + "qzone";
          jdField_b_of_type_Boolean = true;
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        QLog.e(jdField_a_of_type_JavaLangString, 1, "", localException);
        continue;
      }
      if (!jdField_b_of_type_Boolean) {
        m = g();
      }
      localObject = new File(m);
      if (!((File)localObject).exists()) {
        if ((!((File)localObject).mkdirs()) && (QLog.isColorLevel())) {
          QLog.w(jdField_a_of_type_JavaLangString, 2, "Unable to create external cache directory");
        }
      }
      try
      {
        new File(m, ".nomedia").createNewFile();
        return;
      }
      catch (IOException localIOException)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "", localIOException);
      }
      if (Environment.getExternalStorageDirectory().canWrite())
      {
        m = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "Android" + File.separator + "data" + File.separator + "com.tencent.mobileqq" + File.separator + "qzone";
        jdField_b_of_type_Boolean = true;
      }
    }
  }
  
  public static boolean a()
  {
    return SDCardMountMonitorReceiver.a().a();
  }
  
  public static boolean a(String paramString)
  {
    String str = Environment.getDataDirectory().getAbsolutePath();
    return (paramString != null) && (paramString.startsWith(str));
  }
  
  public static final long b()
  {
    if (!a()) {
      return -1L;
    }
    Object localObject = i();
    try
    {
      localObject = new StatFs((String)localObject);
      long l1 = ((StatFs)localObject).getBlockSize();
      int i1 = ((StatFs)localObject).getAvailableBlocks();
      return i1 * l1;
    }
    catch (Exception localException)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "", localException);
    }
    return -1L;
  }
  
  public static FileCacheService b()
  {
    return a("offline", 104857600, 20971520);
  }
  
  public static String b()
  {
    return a("video");
  }
  
  public static String b(Context paramContext, String paramString)
  {
    paramContext = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramContext = String.valueOf(System.currentTimeMillis());
    }
    paramContext = a().a("audio_gift_" + paramContext, true);
    if (paramContext == null) {
      return null;
    }
    return paramContext.getAbsolutePath();
  }
  
  public static String b(String paramString)
  {
    String str = g();
    if (TextUtils.isEmpty(paramString)) {
      return str;
    }
    paramString = new File(str + File.separator + paramString);
    if (paramString.isFile()) {
      FileUtils.delete(paramString);
    }
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
    return paramString.getAbsolutePath();
  }
  
  public static void b()
  {
    a();
    d();
    b();
    c();
    a().a();
  }
  
  private static void b(long paramLong)
  {
    String str1 = LocalMultiProcConfig.a("qua", "");
    String str2 = QUA.a();
    if (!str1.equals(str2))
    {
      LocalMultiProcConfig.a("getMapLastGetTime", "", paramLong);
      LocalMultiProcConfig.a("qua", str2);
    }
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      if ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))) {
        return true;
      }
    } while (!URLUtil.isNetworkUrl(paramString));
    return true;
  }
  
  public static FileCacheService c()
  {
    return a("personalise_font", 104857600, 41943040);
  }
  
  public static String c()
  {
    int i1 = 1;
    int i2 = 0;
    for (;;)
    {
      try
      {
        if ("mounted".equals(Environment.getExternalStorageState()))
        {
          String str;
          if (!TextUtils.isEmpty(l))
          {
            str = l + File.separator + "Android" + File.separator + "data" + File.separator + "com.tencent.mobileqq" + File.separator + "qzone";
            if (str != null)
            {
              localObject = new File(str);
              if (((File)localObject).isFile()) {
                FileUtils.delete((File)localObject);
              }
              if (!((File)localObject).exists()) {
                ((File)localObject).mkdirs();
              }
            }
            if ((i1 != 0) && (!TextUtils.isEmpty(str)))
            {
              localObject = str;
              if (!d(str)) {}
            }
            else
            {
              localObject = g();
            }
            if (localObject == null) {
              return null;
            }
          }
          else
          {
            if (!Environment.getExternalStorageDirectory().canWrite()) {
              break label310;
            }
            str = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "Android" + File.separator + "data" + File.separator + "com.tencent.mobileqq" + File.separator + "qzone";
            continue;
          }
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        QLog.e(jdField_a_of_type_JavaLangString, 1, "", localException);
        localFile = null;
        i1 = i2;
        continue;
        localFile = new File((String)localObject + File.separator + "video_cache");
        if (localFile.isFile()) {
          FileUtils.delete(localFile);
        }
        if (!localFile.exists()) {
          localFile.mkdirs();
        }
        return localFile.getAbsolutePath();
      }
      label310:
      i1 = 0;
      File localFile = null;
    }
  }
  
  public static String c(String paramString)
  {
    String str = paramString;
    if (b(paramString))
    {
      int i3 = paramString.indexOf('/', 8);
      int i2 = paramString.indexOf("ek=1");
      int i1 = i2;
      if (i2 == -1)
      {
        i2 = paramString.indexOf('#');
        i1 = i2;
        if (i2 == -1) {
          i1 = paramString.length();
        }
      }
      str = paramString.substring(i3 + 1, i1);
    }
    return str;
  }
  
  public static boolean c(String paramString)
  {
    localObject = (Boolean)c.get(paramString);
    if (localObject != null) {
      return ((Boolean)localObject).booleanValue();
    }
    bool2 = false;
    bool1 = false;
    long l1 = Thread.currentThread().getId();
    localObject = new File(paramString + "/qz" + l1);
    for (;;)
    {
      try
      {
        if (!((File)localObject).exists()) {
          continue;
        }
        if (((File)localObject).delete()) {
          bool1 = ((File)localObject).createNewFile();
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "", localThrowable);
        ((File)localObject).delete();
        bool1 = bool2;
        continue;
      }
      finally
      {
        ((File)localObject).delete();
      }
      c.put(paramString, Boolean.valueOf(bool1));
      return bool1;
      bool1 = ((File)localObject).createNewFile();
    }
  }
  
  public static FileCacheService d()
  {
    return a("avatar", 52428800, 20971520);
  }
  
  public static String d()
  {
    return a("react");
  }
  
  private static void d()
  {
    if (jdField_a_of_type_Boolean) {
      return;
    }
    jdField_a_of_type_Boolean = true;
    synchronized (jdField_b_of_type_JavaUtilHashMap)
    {
      jdField_b_of_type_JavaUtilHashMap.clear();
      l = "";
      jdField_b_of_type_Long = 0L;
      a("/etc/vold.fstab");
      a("/etc/internal_sd.fstab");
      a("/etc/external_sd.fstab");
      Iterator localIterator = jdField_b_of_type_JavaUtilHashMap.values().iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          try
          {
            Object localObject2 = new File(str);
            if ((((File)localObject2).exists()) && (((File)localObject2).canWrite()) && (c(str)))
            {
              localObject2 = new StatFs(str);
              long l1 = ((StatFs)localObject2).getAvailableBlocks() * ((StatFs)localObject2).getBlockSize();
              if ((l1 > 0L) && (jdField_b_of_type_Long < l1))
              {
                jdField_b_of_type_Long = l1;
                l = str;
              }
            }
          }
          catch (Throwable localThrowable)
          {
            QLog.e(jdField_a_of_type_JavaLangString, 1, "", localThrowable);
          }
        }
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "max sdcard name:" + l + " size:" + jdField_b_of_type_Long / 1024L / 1024L / 1024L + "G");
    }
  }
  
  private static boolean d(String paramString)
  {
    try
    {
      StatFs localStatFs = new StatFs(paramString);
      long l1 = localStatFs.getAvailableBlocks() * localStatFs.getBlockSize();
      if (l1 < 5242880L) {}
      for (boolean bool = true;; bool = false)
      {
        if (bool) {
          QLog.w(jdField_a_of_type_JavaLangString, 1, "low storage: totalSize=" + localStatFs.getBlockCount() * localStatFs.getBlockSize() + ", availableSize=" + l1 + ", external=" + paramString);
        }
        return bool;
      }
      return true;
    }
    catch (Throwable paramString)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "", paramString);
    }
  }
  
  public static String e()
  {
    return a("rapid_comment");
  }
  
  public static String f()
  {
    return a("gift_fullscreen");
  }
  
  public static String g()
  {
    File localFile = BaseApplicationImpl.getContext().getCacheDir();
    if (localFile != null) {
      return localFile.getAbsolutePath() + File.separator + "qzone";
    }
    return null;
  }
  
  public static String h()
  {
    return AppConstants.bo + UUID.randomUUID().toString() + ".jpg";
  }
  
  public static String i()
  {
    if (m == null) {}
    try
    {
      if (m == null) {
        a(false, false);
      }
      return m;
    }
    finally {}
  }
  
  public static final String j()
  {
    long l1 = a();
    if (l1 >= 0L) {
      return a(l1);
    }
    return "无SD Card";
  }
  
  public static final String k()
  {
    long l1 = b();
    if (l1 >= 0L) {
      return a(l1);
    }
    return "无SD Card";
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\cache\CacheManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */