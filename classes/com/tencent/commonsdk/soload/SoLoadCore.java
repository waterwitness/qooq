package com.tencent.commonsdk.soload;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Process;
import android.text.TextUtils;
import dalvik.system.BaseDexClassLoader;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.ZipFile;

public class SoLoadCore
{
  public static final int API_BELOW_14 = 128;
  public static final int API_EUQAL_AND_ABOVE_14 = 256;
  public static final String APP_ROOT = "/data/data/com.tencent.mobileqq/files";
  private static final String CONFIGPATH = "soconfig.cfg";
  public static final int CONFIG_SO_PATH_IN_LIB = 32768;
  public static final int CONFIG_SO_PATH_IN_TXLIB = 16384;
  public static final int IF_CONFIG_SO_CRCCHECK_SUCCESS = 8192;
  public static final int IF_GENERATE_CACHE_SUCCESS = 2097152;
  public static final int IF_GET_AVAILIABLE_CRCVALUE = 1048576;
  public static final int IF_READ_CONFIGFILE_SUCCESS = 65536;
  public static final int IF_RELEASE_BY_CLASSLOADER_SUCCESS = 64;
  public static final int IF_RELEASE_BY_ZIP_CHECK_SUCCESS = 8;
  public static final int IF_RELEASE_SOFILE_CHECK_SUCCESS = 32;
  public static final int IF_SOFILE_EXIST_IN_LIBPATH = 2048;
  public static final int IF_SOFILE_IN_LIB_CHECK_SUCCESS = 1024;
  public static final int IF_SO_CONFIG_EXIST = 131072;
  public static final int IF_TRY_LOADSO_INLIBPATH_SUCCESS = 512;
  public static final int IF_TRY_LOAD_CONFIG_SO_SUCCESS = 4096;
  public static final int IF_TRY_LOAD_LIBRARY_SUCCESS = 524288;
  public static final int IF_TRY_LOAD_RELEASESO_SUCCESS = 16;
  public static final int IF_TRY_LOAD_SO_BY_ZIP_SUCCESS = 4;
  public static final int LOAD_SO_SUCCESS_SAVE_AND_RETURN = 2;
  private static final String PACKAGE_NAME = "com.tencent.mobileqq";
  public static final String PATH_LIB = "/lib/";
  public static final String PATH_TX_LIB = "/txlib/";
  public static final int TRY_LOAD_LIBRARY_SUCCESS = 262144;
  private static HashMap<String, Long> assestCrcConfigs = null;
  
  public static boolean contentEquals(InputStream paramInputStream1, InputStream paramInputStream2)
    throws IOException
  {
    Object localObject = paramInputStream1;
    if (!(paramInputStream1 instanceof BufferedInputStream)) {
      localObject = new BufferedInputStream(paramInputStream1);
    }
    paramInputStream1 = paramInputStream2;
    if (!(paramInputStream2 instanceof BufferedInputStream)) {
      paramInputStream1 = new BufferedInputStream(paramInputStream2);
    }
    int i = ((InputStream)localObject).read();
    if (-1 != i) {
      if (i == paramInputStream1.read()) {}
    }
    while (paramInputStream1.read() != -1)
    {
      return false;
      i = ((InputStream)localObject).read();
      break;
    }
    return true;
  }
  
  /* Error */
  private static void copyZipEntry2File(java.util.zip.ZipEntry paramZipEntry, ZipFile paramZipFile, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore_3
    //   5: aconst_null
    //   6: astore 4
    //   8: aconst_null
    //   9: astore 9
    //   11: aconst_null
    //   12: astore 8
    //   14: aconst_null
    //   15: astore 11
    //   17: aconst_null
    //   18: astore 10
    //   20: aload_0
    //   21: ifnull +7 -> 28
    //   24: aload_1
    //   25: ifnonnull +44 -> 69
    //   28: iconst_0
    //   29: ifeq +11 -> 40
    //   32: new 94	java/lang/NullPointerException
    //   35: dup
    //   36: invokespecial 95	java/lang/NullPointerException:<init>	()V
    //   39: athrow
    //   40: iconst_0
    //   41: ifeq +11 -> 52
    //   44: new 94	java/lang/NullPointerException
    //   47: dup
    //   48: invokespecial 95	java/lang/NullPointerException:<init>	()V
    //   51: athrow
    //   52: iconst_0
    //   53: ifeq +11 -> 64
    //   56: new 94	java/lang/NullPointerException
    //   59: dup
    //   60: invokespecial 95	java/lang/NullPointerException:<init>	()V
    //   63: athrow
    //   64: aload_1
    //   65: invokevirtual 100	java/util/zip/ZipFile:close	()V
    //   68: return
    //   69: aload 11
    //   71: astore 5
    //   73: aload 4
    //   75: astore 6
    //   77: aload_1
    //   78: aload_0
    //   79: invokevirtual 104	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   82: astore_0
    //   83: aload 11
    //   85: astore 5
    //   87: aload 4
    //   89: astore 6
    //   91: aload_0
    //   92: astore_3
    //   93: aload_0
    //   94: astore 7
    //   96: new 80	java/io/BufferedInputStream
    //   99: dup
    //   100: aload_0
    //   101: invokespecial 83	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   104: astore 4
    //   106: sipush 8192
    //   109: newarray <illegal type>
    //   111: astore_3
    //   112: new 106	java/io/BufferedOutputStream
    //   115: dup
    //   116: new 108	java/io/FileOutputStream
    //   119: dup
    //   120: aload_2
    //   121: invokespecial 111	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   124: invokespecial 114	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   127: astore_2
    //   128: aload 4
    //   130: aload_3
    //   131: invokevirtual 117	java/io/BufferedInputStream:read	([B)I
    //   134: istore 12
    //   136: iload 12
    //   138: iconst_m1
    //   139: if_icmpeq +75 -> 214
    //   142: aload_2
    //   143: aload_3
    //   144: iconst_0
    //   145: iload 12
    //   147: invokevirtual 121	java/io/BufferedOutputStream:write	([BII)V
    //   150: goto -22 -> 128
    //   153: astore 5
    //   155: aload 4
    //   157: astore_3
    //   158: aload_2
    //   159: astore 8
    //   161: aload 5
    //   163: astore 4
    //   165: aload_3
    //   166: astore_2
    //   167: aload_2
    //   168: astore 5
    //   170: aload 8
    //   172: astore 6
    //   174: aload_0
    //   175: astore_3
    //   176: aload 4
    //   178: invokevirtual 124	java/io/IOException:printStackTrace	()V
    //   181: aload_2
    //   182: ifnull +7 -> 189
    //   185: aload_2
    //   186: invokevirtual 125	java/io/BufferedInputStream:close	()V
    //   189: aload_0
    //   190: ifnull +7 -> 197
    //   193: aload_0
    //   194: invokevirtual 126	java/io/InputStream:close	()V
    //   197: aload 8
    //   199: ifnull +8 -> 207
    //   202: aload 8
    //   204: invokevirtual 127	java/io/BufferedOutputStream:close	()V
    //   207: aload_1
    //   208: invokevirtual 100	java/util/zip/ZipFile:close	()V
    //   211: return
    //   212: astore_0
    //   213: return
    //   214: aload_2
    //   215: ifnull +7 -> 222
    //   218: aload_2
    //   219: invokevirtual 127	java/io/BufferedOutputStream:close	()V
    //   222: aload 4
    //   224: ifnull +8 -> 232
    //   227: aload 4
    //   229: invokevirtual 125	java/io/BufferedInputStream:close	()V
    //   232: aload_0
    //   233: ifnull +7 -> 240
    //   236: aload_0
    //   237: invokevirtual 126	java/io/InputStream:close	()V
    //   240: aload_2
    //   241: ifnull +7 -> 248
    //   244: aload_2
    //   245: invokevirtual 127	java/io/BufferedOutputStream:close	()V
    //   248: aload_1
    //   249: invokevirtual 100	java/util/zip/ZipFile:close	()V
    //   252: return
    //   253: astore_0
    //   254: return
    //   255: astore_0
    //   256: aload 5
    //   258: ifnull +8 -> 266
    //   261: aload 5
    //   263: invokevirtual 125	java/io/BufferedInputStream:close	()V
    //   266: aload_3
    //   267: ifnull +7 -> 274
    //   270: aload_3
    //   271: invokevirtual 126	java/io/InputStream:close	()V
    //   274: aload 6
    //   276: ifnull +8 -> 284
    //   279: aload 6
    //   281: invokevirtual 127	java/io/BufferedOutputStream:close	()V
    //   284: aload_1
    //   285: invokevirtual 100	java/util/zip/ZipFile:close	()V
    //   288: aload_0
    //   289: athrow
    //   290: astore_0
    //   291: return
    //   292: astore_1
    //   293: goto -5 -> 288
    //   296: astore_2
    //   297: goto -13 -> 284
    //   300: astore_2
    //   301: aload 4
    //   303: astore 5
    //   305: aload 9
    //   307: astore 6
    //   309: aload_0
    //   310: astore_3
    //   311: aload_2
    //   312: astore_0
    //   313: goto -57 -> 256
    //   316: astore 7
    //   318: aload 4
    //   320: astore 5
    //   322: aload_2
    //   323: astore 6
    //   325: aload_0
    //   326: astore_3
    //   327: aload 7
    //   329: astore_0
    //   330: goto -74 -> 256
    //   333: astore_0
    //   334: goto -127 -> 207
    //   337: astore 4
    //   339: aload 10
    //   341: astore_2
    //   342: aload 7
    //   344: astore_0
    //   345: goto -178 -> 167
    //   348: astore_3
    //   349: aload 4
    //   351: astore_2
    //   352: aload_3
    //   353: astore 4
    //   355: goto -188 -> 167
    //   358: astore_0
    //   359: goto -111 -> 248
    //   362: astore_0
    //   363: goto -299 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	366	0	paramZipEntry	java.util.zip.ZipEntry
    //   0	366	1	paramZipFile	ZipFile
    //   0	366	2	paramFile	File
    //   4	323	3	localObject1	Object
    //   348	5	3	localIOException1	IOException
    //   6	313	4	localObject2	Object
    //   337	13	4	localIOException2	IOException
    //   353	1	4	localIOException3	IOException
    //   71	15	5	localObject3	Object
    //   153	9	5	localIOException4	IOException
    //   168	153	5	localObject4	Object
    //   75	249	6	localObject5	Object
    //   1	94	7	localZipEntry	java.util.zip.ZipEntry
    //   316	27	7	localObject6	Object
    //   12	191	8	localFile	File
    //   9	297	9	localObject7	Object
    //   18	322	10	localObject8	Object
    //   15	69	11	localObject9	Object
    //   134	12	12	i	int
    // Exception table:
    //   from	to	target	type
    //   128	136	153	java/io/IOException
    //   142	150	153	java/io/IOException
    //   218	222	153	java/io/IOException
    //   207	211	212	java/io/IOException
    //   248	252	253	java/io/IOException
    //   77	83	255	finally
    //   96	106	255	finally
    //   176	181	255	finally
    //   64	68	290	java/io/IOException
    //   284	288	292	java/io/IOException
    //   261	266	296	java/io/IOException
    //   270	274	296	java/io/IOException
    //   279	284	296	java/io/IOException
    //   106	128	300	finally
    //   128	136	316	finally
    //   142	150	316	finally
    //   218	222	316	finally
    //   185	189	333	java/io/IOException
    //   193	197	333	java/io/IOException
    //   202	207	333	java/io/IOException
    //   77	83	337	java/io/IOException
    //   96	106	337	java/io/IOException
    //   106	128	348	java/io/IOException
    //   227	232	358	java/io/IOException
    //   236	240	358	java/io/IOException
    //   244	248	358	java/io/IOException
    //   32	40	362	java/io/IOException
    //   44	52	362	java/io/IOException
    //   56	64	362	java/io/IOException
  }
  
  public static String getApkPath(Context paramContext)
  {
    Object localObject1 = null;
    Object localObject2 = paramContext.getPackageManager();
    paramContext = paramContext.getPackageName();
    try
    {
      localObject2 = ((PackageManager)localObject2).getApplicationInfo(paramContext, 8192);
      paramContext = (Context)localObject1;
      if (localObject2 != null) {
        paramContext = ((ApplicationInfo)localObject2).sourceDir;
      }
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static File getAppWorkFile(Context paramContext)
  {
    try
    {
      File localFile = paramContext.getFilesDir().getParentFile();
      return localFile;
    }
    catch (Exception localException)
    {
      try
      {
        if ((paramContext instanceof ContextWrapper)) {}
        Object localObject;
        for (paramContext = ((ContextWrapper)paramContext).getBaseContext();; paramContext = ((Field)localObject).get(paramContext))
        {
          localObject = paramContext.getClass().getDeclaredMethod("getDataDirFile", new Class[0]);
          ((Method)localObject).setAccessible(true);
          return (File)((Method)localObject).invoke(paramContext, new Object[0]);
          localObject = ContextWrapper.class.getDeclaredField("mBase");
          ((Field)localObject).setAccessible(true);
        }
        return null;
      }
      catch (Throwable paramContext) {}
    }
  }
  
  public static String getAppWorkPath(Context paramContext)
  {
    try
    {
      String str = paramContext.getFilesDir().getParent();
      return str;
    }
    catch (Exception localException)
    {
      try
      {
        if ((paramContext instanceof ContextWrapper)) {}
        Object localObject;
        for (paramContext = ((ContextWrapper)paramContext).getBaseContext();; paramContext = ((Field)localObject).get(paramContext))
        {
          localObject = paramContext.getClass().getDeclaredMethod("getDataDirFile", new Class[0]);
          ((Method)localObject).setAccessible(true);
          return ((File)((Method)localObject).invoke(paramContext, new Object[0])).getAbsolutePath();
          localObject = ContextWrapper.class.getDeclaredField("mBase");
          ((Field)localObject).setAccessible(true);
        }
        return null;
      }
      catch (Throwable paramContext) {}
    }
  }
  
  /* Error */
  public static long getCRC32Value(File paramFile)
  {
    // Byte code:
    //   0: ldc2_w 219
    //   3: lstore 5
    //   5: lload 5
    //   7: lstore_3
    //   8: aload_0
    //   9: ifnull +13 -> 22
    //   12: aload_0
    //   13: invokevirtual 224	java/io/File:exists	()Z
    //   16: ifne +8 -> 24
    //   19: lload 5
    //   21: lstore_3
    //   22: lload_3
    //   23: lreturn
    //   24: aconst_null
    //   25: astore_1
    //   26: aconst_null
    //   27: astore_2
    //   28: new 226	java/io/FileInputStream
    //   31: dup
    //   32: aload_0
    //   33: invokespecial 227	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   36: astore_0
    //   37: aload_0
    //   38: invokestatic 230	com/tencent/commonsdk/soload/SoLoadCore:getCRC32Value	(Ljava/io/InputStream;)J
    //   41: lstore_3
    //   42: lload_3
    //   43: lstore 5
    //   45: lload 5
    //   47: lstore_3
    //   48: aload_0
    //   49: ifnull -27 -> 22
    //   52: aload_0
    //   53: invokevirtual 231	java/io/FileInputStream:close	()V
    //   56: lload 5
    //   58: lreturn
    //   59: astore_0
    //   60: aload_0
    //   61: invokevirtual 124	java/io/IOException:printStackTrace	()V
    //   64: lload 5
    //   66: lreturn
    //   67: astore_1
    //   68: aload_2
    //   69: astore_0
    //   70: aload_1
    //   71: astore_2
    //   72: aload_0
    //   73: astore_1
    //   74: aload_2
    //   75: invokevirtual 232	java/lang/Exception:printStackTrace	()V
    //   78: lload 5
    //   80: lstore_3
    //   81: aload_0
    //   82: ifnull -60 -> 22
    //   85: aload_0
    //   86: invokevirtual 231	java/io/FileInputStream:close	()V
    //   89: ldc2_w 219
    //   92: lreturn
    //   93: astore_0
    //   94: aload_0
    //   95: invokevirtual 124	java/io/IOException:printStackTrace	()V
    //   98: ldc2_w 219
    //   101: lreturn
    //   102: astore_0
    //   103: aload_1
    //   104: ifnull +7 -> 111
    //   107: aload_1
    //   108: invokevirtual 231	java/io/FileInputStream:close	()V
    //   111: aload_0
    //   112: athrow
    //   113: astore_1
    //   114: aload_1
    //   115: invokevirtual 124	java/io/IOException:printStackTrace	()V
    //   118: goto -7 -> 111
    //   121: astore_2
    //   122: aload_0
    //   123: astore_1
    //   124: aload_2
    //   125: astore_0
    //   126: goto -23 -> 103
    //   129: astore_2
    //   130: goto -58 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	paramFile	File
    //   25	1	1	localObject1	Object
    //   67	4	1	localException1	Exception
    //   73	35	1	localFile1	File
    //   113	2	1	localIOException	IOException
    //   123	1	1	localFile2	File
    //   27	48	2	localException2	Exception
    //   121	4	2	localObject2	Object
    //   129	1	2	localException3	Exception
    //   7	74	3	l1	long
    //   3	76	5	l2	long
    // Exception table:
    //   from	to	target	type
    //   52	56	59	java/io/IOException
    //   28	37	67	java/lang/Exception
    //   85	89	93	java/io/IOException
    //   28	37	102	finally
    //   74	78	102	finally
    //   107	111	113	java/io/IOException
    //   37	42	121	finally
    //   37	42	129	java/lang/Exception
  }
  
  public static long getCRC32Value(InputStream paramInputStream)
    throws Exception
  {
    byte[] arrayOfByte = new byte[' '];
    CRC32 localCRC32 = new CRC32();
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      localCRC32.update(arrayOfByte, 0, i);
    }
    return localCRC32.getValue();
  }
  
  private static String getCurProcessName(Context paramContext)
  {
    paramContext = ((ActivityManager)paramContext.getApplicationContext().getSystemService("activity")).getRunningAppProcesses();
    if (paramContext != null)
    {
      int i = Process.myPid();
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if ((localRunningAppProcessInfo.processName.startsWith("com.tencent.mobileqq")) && (localRunningAppProcessInfo.pid == i)) {
          return localRunningAppProcessInfo.processName + "_" + i;
        }
      }
    }
    return null;
  }
  
  private static String getDefaultPlatformString()
  {
    return "armeabi";
  }
  
  @SuppressLint({"SdCardPath"})
  public static File getExistFile(Context paramContext, String paramString)
  {
    File localFile = new File(paramContext.getFilesDir(), paramString);
    Object localObject = localFile;
    if (!localFile.exists())
    {
      paramContext = new File(paramContext.getFilesDir(), paramString);
      localObject = paramContext;
      if (!paramContext.exists())
      {
        paramContext = new File("/data/data/com.tencent.mobileqq/files", paramString);
        localObject = paramContext;
        if (!paramContext.exists()) {
          localObject = null;
        }
      }
    }
    return (File)localObject;
  }
  
  public static String getLibActualName(String paramString)
  {
    return "lib" + paramString + ".so";
  }
  
  public static String getOsClassLoader()
  {
    try
    {
      Class.forName("dalvik.system.LexClassLoader");
      return "lex";
    }
    catch (ClassNotFoundException localClassNotFoundException1)
    {
      int i = 1;
      try
      {
        Class.forName("dalvik.system.BaseDexClassLoader");
        if (i == 0) {
          return "below14";
        }
      }
      catch (ClassNotFoundException localClassNotFoundException2)
      {
        for (;;)
        {
          i = 0;
        }
      }
    }
    return "equalAndAbove14";
  }
  
  /* Error */
  private static String getPlatformString()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 352	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   6: astore_0
    //   7: aload_0
    //   8: ifnull +22 -> 30
    //   11: aload_0
    //   12: ldc_w 354
    //   15: invokevirtual 358	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   18: ifeq +12 -> 30
    //   21: ldc_w 354
    //   24: astore_0
    //   25: ldc 2
    //   27: monitorexit
    //   28: aload_0
    //   29: areturn
    //   30: aload_0
    //   31: ifnull +20 -> 51
    //   34: aload_0
    //   35: ldc_w 360
    //   38: invokevirtual 358	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   41: ifeq +10 -> 51
    //   44: ldc_w 362
    //   47: astore_0
    //   48: goto -23 -> 25
    //   51: ldc_w 311
    //   54: astore_0
    //   55: goto -30 -> 25
    //   58: astore_0
    //   59: ldc 2
    //   61: monitorexit
    //   62: aload_0
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	49	0	str	String
    //   58	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	58	finally
    //   11	21	58	finally
    //   34	44	58	finally
  }
  
  public static String getReleasedSoFilePath(Context paramContext, String paramString)
  {
    paramString = getLibActualName(paramString);
    initAssestCrcConfigs(paramContext);
    if ((assestCrcConfigs == null) || (assestCrcConfigs.isEmpty())) {}
    long l;
    do
    {
      do
      {
        do
        {
          Long localLong;
          do
          {
            return null;
            localLong = (Long)assestCrcConfigs.get(getDefaultPlatformString() + "/" + paramString);
          } while (localLong == null);
          l = localLong.longValue();
        } while (l <= 0L);
        paramContext = paramContext.getFilesDir() + "/" + "soconfigs";
        paramContext = new File(paramContext + "/" + paramString + ".cfg");
      } while ((!paramContext.exists()) || (!paramContext.isFile()));
      paramContext = readConfig(paramContext);
    } while ((paramContext == null) || (paramContext.mCrcvalue != l));
    return paramContext.mSopath;
  }
  
  private static File getSoOrDexByBaseDexClassLoader(Context paramContext, String paramString1, String paramString2)
  {
    File localFile = new File(paramString2);
    if (localFile.exists()) {
      localFile.delete();
    }
    paramString2 = paramContext.getClassLoader();
    paramContext = (BaseDexClassLoader)paramContext.getClassLoader();
    paramString2 = paramString2.getClass().getSuperclass();
    try
    {
      localFile.createNewFile();
      Object localObject = paramString2.getDeclaredField("pathList");
      ((Field)localObject).setAccessible(true);
      paramString2 = ((Field)localObject).get(paramContext);
      paramContext = ((Field)localObject).get(paramContext).getClass().getDeclaredField("dexElements");
      paramContext.setAccessible(true);
      localObject = paramContext.get(paramString2);
      int j;
      int i;
      if (localObject.getClass().isArray())
      {
        j = Array.getLength(localObject);
        if (j > 0)
        {
          paramString2 = null;
          paramContext = null;
          i = 0;
        }
      }
      for (;;)
      {
        if (i < j)
        {
          paramContext = Array.get(localObject, i);
          paramString2 = paramContext.getClass().getDeclaredField("zipFile");
          paramString2.setAccessible(true);
          paramContext = (ZipFile)paramString2.get(paramContext);
          paramString2 = paramContext.getEntry(paramString1);
          if (paramString2 == null) {}
        }
        else
        {
          if ((paramString2 == null) || (paramContext == null)) {
            break;
          }
          copyZipEntry2File(paramString2, paramContext, localFile);
          return localFile;
        }
        i += 1;
      }
      return null;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static File getSoOrDexByPathClassLoader(Context paramContext, String paramString1, String paramString2)
  {
    File localFile = new File(paramString2 + paramString1);
    paramContext = paramContext.getClassLoader();
    paramString2 = paramContext.getClass();
    try
    {
      paramString2 = paramString2.getDeclaredField("mZips");
      paramString2.setAccessible(true);
      Object localObject = paramString2.get(paramContext);
      int j;
      int i;
      if (localObject.getClass().isArray())
      {
        paramContext = null;
        paramString2 = null;
        j = Array.getLength(localObject);
        i = 0;
      }
      for (;;)
      {
        if (i < j)
        {
          paramString2 = (ZipFile)Array.get(localObject, i);
          paramContext = paramString2.getEntry(paramString1);
          if (paramContext == null) {}
        }
        else
        {
          if ((paramContext == null) || (paramString2 == null)) {
            break;
          }
          copyZipEntry2File(paramContext, paramString2, localFile);
          return localFile;
        }
        i += 1;
      }
      return null;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  private static boolean hasBaseDexClassloader()
  {
    try
    {
      Class.forName("dalvik.system.BaseDexClassLoader");
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException) {}
    return false;
  }
  
  /* Error */
  private static void initAssestCrcConfigs(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 70	com/tencent/commonsdk/soload/SoLoadCore:assestCrcConfigs	Ljava/util/HashMap;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: aconst_null
    //   16: astore 4
    //   18: aconst_null
    //   19: astore_3
    //   20: aload_3
    //   21: astore_2
    //   22: aload 4
    //   24: astore_1
    //   25: new 372	java/util/HashMap
    //   28: dup
    //   29: invokespecial 457	java/util/HashMap:<init>	()V
    //   32: putstatic 70	com/tencent/commonsdk/soload/SoLoadCore:assestCrcConfigs	Ljava/util/HashMap;
    //   35: aload_3
    //   36: astore_2
    //   37: aload 4
    //   39: astore_1
    //   40: aload_0
    //   41: invokevirtual 461	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   44: invokevirtual 467	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   47: ldc 16
    //   49: invokevirtual 473	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   52: astore_0
    //   53: aload_0
    //   54: astore_2
    //   55: aload_0
    //   56: astore_1
    //   57: new 475	java/io/BufferedReader
    //   60: dup
    //   61: new 477	java/io/InputStreamReader
    //   64: dup
    //   65: aload_0
    //   66: invokespecial 478	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   69: invokespecial 481	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   72: astore_3
    //   73: aload_0
    //   74: astore_2
    //   75: aload_0
    //   76: astore_1
    //   77: aload_3
    //   78: invokevirtual 484	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   81: astore 4
    //   83: aload 4
    //   85: ifnull +109 -> 194
    //   88: aload_0
    //   89: astore_2
    //   90: aload_0
    //   91: astore_1
    //   92: aload 4
    //   94: ldc_w 486
    //   97: invokevirtual 490	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   100: istore 6
    //   102: aload_0
    //   103: astore_2
    //   104: aload_0
    //   105: astore_1
    //   106: aload 4
    //   108: iconst_0
    //   109: iload 6
    //   111: invokevirtual 494	java/lang/String:substring	(II)Ljava/lang/String;
    //   114: astore 5
    //   116: aload_0
    //   117: astore_2
    //   118: aload_0
    //   119: astore_1
    //   120: aload 4
    //   122: iload 6
    //   124: iconst_1
    //   125: iadd
    //   126: invokevirtual 497	java/lang/String:substring	(I)Ljava/lang/String;
    //   129: invokestatic 501	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   132: lstore 7
    //   134: lload 7
    //   136: lconst_1
    //   137: lcmp
    //   138: iflt -65 -> 73
    //   141: aload_0
    //   142: astore_2
    //   143: aload_0
    //   144: astore_1
    //   145: getstatic 70	com/tencent/commonsdk/soload/SoLoadCore:assestCrcConfigs	Ljava/util/HashMap;
    //   148: aload 5
    //   150: lload 7
    //   152: invokestatic 505	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   155: invokevirtual 509	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   158: pop
    //   159: goto -86 -> 73
    //   162: astore_0
    //   163: aload_2
    //   164: astore_1
    //   165: aload_0
    //   166: invokevirtual 232	java/lang/Exception:printStackTrace	()V
    //   169: aload_2
    //   170: ifnull -159 -> 11
    //   173: aload_2
    //   174: invokevirtual 126	java/io/InputStream:close	()V
    //   177: goto -166 -> 11
    //   180: astore_0
    //   181: aload_0
    //   182: invokevirtual 124	java/io/IOException:printStackTrace	()V
    //   185: goto -174 -> 11
    //   188: astore_0
    //   189: ldc 2
    //   191: monitorexit
    //   192: aload_0
    //   193: athrow
    //   194: aload_0
    //   195: ifnull -184 -> 11
    //   198: aload_0
    //   199: invokevirtual 126	java/io/InputStream:close	()V
    //   202: goto -191 -> 11
    //   205: astore_0
    //   206: aload_0
    //   207: invokevirtual 124	java/io/IOException:printStackTrace	()V
    //   210: goto -199 -> 11
    //   213: astore_0
    //   214: aload_1
    //   215: ifnull +7 -> 222
    //   218: aload_1
    //   219: invokevirtual 126	java/io/InputStream:close	()V
    //   222: aload_0
    //   223: athrow
    //   224: astore_1
    //   225: aload_1
    //   226: invokevirtual 124	java/io/IOException:printStackTrace	()V
    //   229: goto -7 -> 222
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	232	0	paramContext	Context
    //   6	213	1	localObject1	Object
    //   224	2	1	localIOException	IOException
    //   21	153	2	localObject2	Object
    //   19	59	3	localBufferedReader	java.io.BufferedReader
    //   16	105	4	str1	String
    //   114	35	5	str2	String
    //   100	26	6	i	int
    //   132	19	7	l	long
    // Exception table:
    //   from	to	target	type
    //   25	35	162	java/lang/Exception
    //   40	53	162	java/lang/Exception
    //   57	73	162	java/lang/Exception
    //   77	83	162	java/lang/Exception
    //   92	102	162	java/lang/Exception
    //   106	116	162	java/lang/Exception
    //   120	134	162	java/lang/Exception
    //   145	159	162	java/lang/Exception
    //   173	177	180	java/io/IOException
    //   3	7	188	finally
    //   173	177	188	finally
    //   181	185	188	finally
    //   198	202	188	finally
    //   206	210	188	finally
    //   218	222	188	finally
    //   222	224	188	finally
    //   225	229	188	finally
    //   198	202	205	java/io/IOException
    //   25	35	213	finally
    //   40	53	213	finally
    //   57	73	213	finally
    //   77	83	213	finally
    //   92	102	213	finally
    //   106	116	213	finally
    //   120	134	213	finally
    //   145	159	213	finally
    //   165	169	213	finally
    //   218	222	224	java/io/IOException
  }
  
  /* Error */
  public static boolean isLibExtracted(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 9
    //   3: aload_0
    //   4: aload_1
    //   5: invokestatic 513	com/tencent/commonsdk/soload/SoLoadCore:getExistFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   8: ifnonnull +10 -> 18
    //   11: iload 9
    //   13: istore 8
    //   15: iload 8
    //   17: ireturn
    //   18: aconst_null
    //   19: astore_1
    //   20: aconst_null
    //   21: astore 4
    //   23: aconst_null
    //   24: astore 6
    //   26: aconst_null
    //   27: astore 5
    //   29: aload_0
    //   30: aload_2
    //   31: invokestatic 513	com/tencent/commonsdk/soload/SoLoadCore:getExistFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   34: astore 7
    //   36: iload 9
    //   38: istore 8
    //   40: aload 7
    //   42: ifnull -27 -> 15
    //   45: aload 6
    //   47: astore_3
    //   48: aload_0
    //   49: invokevirtual 514	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   52: aload_2
    //   53: invokevirtual 473	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   56: astore_0
    //   57: aload_0
    //   58: astore 4
    //   60: aload_0
    //   61: astore_1
    //   62: aload 6
    //   64: astore_3
    //   65: new 226	java/io/FileInputStream
    //   68: dup
    //   69: aload 7
    //   71: invokespecial 227	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   74: astore_2
    //   75: aload_0
    //   76: aload_2
    //   77: invokestatic 516	com/tencent/commonsdk/soload/SoLoadCore:contentEquals	(Ljava/io/InputStream;Ljava/io/InputStream;)Z
    //   80: istore 8
    //   82: iload 8
    //   84: istore 9
    //   86: aload_0
    //   87: ifnull +7 -> 94
    //   90: aload_0
    //   91: invokevirtual 126	java/io/InputStream:close	()V
    //   94: iload 9
    //   96: istore 8
    //   98: aload_2
    //   99: ifnull -84 -> 15
    //   102: aload_2
    //   103: invokevirtual 126	java/io/InputStream:close	()V
    //   106: iload 9
    //   108: ireturn
    //   109: astore_0
    //   110: iload 9
    //   112: ireturn
    //   113: astore_2
    //   114: aload 5
    //   116: astore_0
    //   117: aload 4
    //   119: astore_1
    //   120: aload_0
    //   121: astore_3
    //   122: aload_2
    //   123: invokevirtual 124	java/io/IOException:printStackTrace	()V
    //   126: aload 4
    //   128: ifnull +8 -> 136
    //   131: aload 4
    //   133: invokevirtual 126	java/io/InputStream:close	()V
    //   136: iload 9
    //   138: istore 8
    //   140: aload_0
    //   141: ifnull -126 -> 15
    //   144: aload_0
    //   145: invokevirtual 126	java/io/InputStream:close	()V
    //   148: iconst_0
    //   149: ireturn
    //   150: astore_0
    //   151: iconst_0
    //   152: ireturn
    //   153: astore_0
    //   154: aload_1
    //   155: ifnull +7 -> 162
    //   158: aload_1
    //   159: invokevirtual 126	java/io/InputStream:close	()V
    //   162: aload_3
    //   163: ifnull +7 -> 170
    //   166: aload_3
    //   167: invokevirtual 126	java/io/InputStream:close	()V
    //   170: aload_0
    //   171: athrow
    //   172: astore_0
    //   173: goto -79 -> 94
    //   176: astore_1
    //   177: goto -41 -> 136
    //   180: astore_1
    //   181: goto -19 -> 162
    //   184: astore_1
    //   185: goto -15 -> 170
    //   188: astore 4
    //   190: aload_0
    //   191: astore_1
    //   192: aload_2
    //   193: astore_3
    //   194: aload 4
    //   196: astore_0
    //   197: goto -43 -> 154
    //   200: astore_3
    //   201: aload_2
    //   202: astore_1
    //   203: aload_3
    //   204: astore_2
    //   205: aload_0
    //   206: astore 4
    //   208: aload_1
    //   209: astore_0
    //   210: goto -93 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	paramContext	Context
    //   0	213	1	paramString1	String
    //   0	213	2	paramString2	String
    //   47	147	3	localObject1	Object
    //   200	4	3	localIOException	IOException
    //   21	111	4	localContext1	Context
    //   188	7	4	localObject2	Object
    //   206	1	4	localContext2	Context
    //   27	88	5	localObject3	Object
    //   24	39	6	localObject4	Object
    //   34	36	7	localFile	File
    //   13	126	8	bool1	boolean
    //   1	136	9	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   102	106	109	java/io/IOException
    //   48	57	113	java/io/IOException
    //   65	75	113	java/io/IOException
    //   144	148	150	java/io/IOException
    //   48	57	153	finally
    //   65	75	153	finally
    //   122	126	153	finally
    //   90	94	172	java/io/IOException
    //   131	136	176	java/io/IOException
    //   158	162	180	java/io/IOException
    //   166	170	184	java/io/IOException
    //   75	82	188	finally
    //   75	82	200	java/io/IOException
  }
  
  private static boolean loadAndSave(File paramFile1, long paramLong, File paramFile2)
  {
    try
    {
      System.load(paramFile1.getAbsolutePath());
      bool = true;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        boolean bool = false;
      }
    }
    if (bool) {
      writeConfig(new ConfigStruct(paramLong, paramFile1.getAbsolutePath()), paramFile2);
    }
    return bool;
  }
  
  static int loadSo(Context paramContext, String paramString)
  {
    String str1 = getLibActualName(paramString);
    int j = 2097152;
    long l2 = -1L;
    initAssestCrcConfigs(paramContext);
    int i = j;
    long l1 = l2;
    if (assestCrcConfigs != null)
    {
      if (!assestCrcConfigs.isEmpty()) {
        break label77;
      }
      l1 = l2;
      i = j;
    }
    while (l1 < 0L)
    {
      i |= 0x80000;
      try
      {
        System.loadLibrary(paramString);
        i |= 0x40000;
      }
      catch (UnsatisfiedLinkError paramContext)
      {
        Object localObject1;
        Object localObject2;
        String str2;
        for (;;) {}
      }
      return i;
      label77:
      j = 0x200000 | 0x100000;
      localObject1 = (Long)assestCrcConfigs.get(getPlatformString() + "/" + str1);
      if ((localObject1 != null) && (((Long)localObject1).longValue() > 1L))
      {
        l1 = ((Long)localObject1).longValue();
        i = j;
      }
      else
      {
        localObject1 = (Long)assestCrcConfigs.get("armeabi/" + str1);
        i = j;
        l1 = l2;
        if (localObject1 != null)
        {
          i = j;
          l1 = l2;
          if (((Long)localObject1).longValue() > 1L)
          {
            l1 = ((Long)localObject1).longValue();
            i = j;
          }
        }
      }
    }
    localObject1 = paramContext.getFilesDir() + "/" + "soconfigs";
    new File((String)localObject1).mkdirs();
    paramString = (String)localObject1 + "/" + paramString + ".cfg";
    j = i | 0x20000;
    localObject1 = new File(paramString);
    i = j;
    if (((File)localObject1).exists())
    {
      paramString = readConfig((File)localObject1);
      j |= 0x10000;
      i = j;
      if (paramString != null)
      {
        if (paramString.mSopath.contains("/txlib/")) {}
        for (i = j | 0x4000;; i = j | 0x8000)
        {
          localObject2 = new File(paramString.mSopath);
          j = i | 0x2000;
          i = j;
          if (paramString.mCrcvalue != l1) {
            break;
          }
          i = j;
          if (!((File)localObject2).exists()) {
            break;
          }
          i = j | 0x1000;
          try
          {
            System.load(((File)localObject2).getAbsolutePath());
            return i | 0x2;
          }
          catch (UnsatisfiedLinkError paramString) {}
        }
      }
    }
    localObject2 = getAppWorkPath(paramContext) + "/txlib/";
    paramString = getAppWorkPath(paramContext) + "/lib/";
    paramString = new File(paramString + str1);
    j = i | 0x800;
    i = j;
    if (paramString.exists())
    {
      j |= 0x400;
      l2 = getCRC32Value(paramString);
      i = j;
      if (l2 == l1)
      {
        j |= 0x200;
        i = j;
        if (loadAndSave(paramString, l2, (File)localObject1)) {
          return j | 0x2;
        }
      }
    }
    str2 = getOsClassLoader();
    paramString = null;
    if (str2.equals("equalAndAbove14"))
    {
      j = i | 0x100;
      paramString = getSoOrDexByBaseDexClassLoader(paramContext, "lib/" + getPlatformString() + "/" + str1, (String)localObject2 + str1);
    }
    for (;;)
    {
      j |= 0x40;
      i = j;
      if (paramString == null) {
        break label780;
      }
      l2 = getCRC32Value(paramString);
      j |= 0x20;
      if (l2 != l1) {
        break;
      }
      j |= 0x10;
      i = j;
      if (!loadAndSave(paramString, l2, (File)localObject1)) {
        break label780;
      }
      return j | 0x2;
      j = i;
      if (str2.equals("below14"))
      {
        j = i | 0x80;
        paramString = getSoOrDexByPathClassLoader(paramContext, str1, (String)localObject2);
      }
    }
    i = j;
    if (paramString.exists())
    {
      paramString.delete();
      i = j;
    }
    label780:
    paramContext = releaseFromApk(getApkPath(paramContext), str1, (String)localObject2);
    l2 = getCRC32Value(paramContext);
    j = i | 0x8;
    i = j;
    if (l2 == l1)
    {
      j |= 0x4;
      i = j;
      if (loadAndSave(paramContext, l2, (File)localObject1)) {
        i = j | 0x2;
      }
    }
    return i;
  }
  
  /* Error */
  private static ConfigStruct readConfig(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 6
    //   5: aconst_null
    //   6: astore_3
    //   7: aconst_null
    //   8: astore 4
    //   10: ldc_w 572
    //   13: astore 5
    //   15: new 226	java/io/FileInputStream
    //   18: dup
    //   19: aload_0
    //   20: invokespecial 227	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   23: astore_0
    //   24: new 475	java/io/BufferedReader
    //   27: dup
    //   28: new 477	java/io/InputStreamReader
    //   31: dup
    //   32: aload_0
    //   33: invokespecial 478	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   36: invokespecial 481	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   39: astore_1
    //   40: aload_1
    //   41: invokevirtual 484	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   44: astore_0
    //   45: aload_0
    //   46: ifnull +113 -> 159
    //   49: aload_0
    //   50: ldc_w 574
    //   53: invokevirtual 358	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   56: ifeq +103 -> 159
    //   59: aload_0
    //   60: aload_0
    //   61: ldc_w 576
    //   64: invokevirtual 490	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   67: iconst_1
    //   68: iadd
    //   69: invokevirtual 497	java/lang/String:substring	(I)Ljava/lang/String;
    //   72: invokestatic 501	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   75: lstore 7
    //   77: aload_1
    //   78: invokevirtual 484	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   81: astore_0
    //   82: aload 5
    //   84: astore_2
    //   85: aload_0
    //   86: ifnull +30 -> 116
    //   89: aload 5
    //   91: astore_2
    //   92: aload_0
    //   93: ldc_w 578
    //   96: invokevirtual 358	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   99: ifeq +17 -> 116
    //   102: aload_0
    //   103: aload_0
    //   104: ldc_w 576
    //   107: invokevirtual 490	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   110: iconst_1
    //   111: iadd
    //   112: invokevirtual 497	java/lang/String:substring	(I)Ljava/lang/String;
    //   115: astore_2
    //   116: aload 4
    //   118: astore_0
    //   119: lload 7
    //   121: ldc2_w 535
    //   124: lcmp
    //   125: ifeq +24 -> 149
    //   128: aload 4
    //   130: astore_0
    //   131: aload_2
    //   132: ldc_w 572
    //   135: if_acmpeq +14 -> 149
    //   138: new 404	com/tencent/commonsdk/soload/ConfigStruct
    //   141: dup
    //   142: lload 7
    //   144: aload_2
    //   145: invokespecial 528	com/tencent/commonsdk/soload/ConfigStruct:<init>	(JLjava/lang/String;)V
    //   148: astore_0
    //   149: aload_1
    //   150: ifnull +106 -> 256
    //   153: aload_1
    //   154: invokevirtual 579	java/io/BufferedReader:close	()V
    //   157: aload_0
    //   158: areturn
    //   159: aload_1
    //   160: ifnull +7 -> 167
    //   163: aload_1
    //   164: invokevirtual 579	java/io/BufferedReader:close	()V
    //   167: aconst_null
    //   168: areturn
    //   169: astore_0
    //   170: aload_0
    //   171: invokevirtual 124	java/io/IOException:printStackTrace	()V
    //   174: goto -7 -> 167
    //   177: astore_1
    //   178: aload_1
    //   179: invokevirtual 124	java/io/IOException:printStackTrace	()V
    //   182: goto -25 -> 157
    //   185: astore_0
    //   186: aload 6
    //   188: astore_1
    //   189: aload_3
    //   190: astore_0
    //   191: aload_1
    //   192: ifnull -35 -> 157
    //   195: aload_1
    //   196: invokevirtual 579	java/io/BufferedReader:close	()V
    //   199: aload_3
    //   200: astore_0
    //   201: goto -44 -> 157
    //   204: astore_0
    //   205: aload_0
    //   206: invokevirtual 124	java/io/IOException:printStackTrace	()V
    //   209: aload_3
    //   210: astore_0
    //   211: goto -54 -> 157
    //   214: astore_0
    //   215: aload_2
    //   216: astore_1
    //   217: aload_1
    //   218: ifnull +7 -> 225
    //   221: aload_1
    //   222: invokevirtual 579	java/io/BufferedReader:close	()V
    //   225: aload_0
    //   226: athrow
    //   227: astore_1
    //   228: aload_1
    //   229: invokevirtual 124	java/io/IOException:printStackTrace	()V
    //   232: goto -7 -> 225
    //   235: astore_0
    //   236: aload_2
    //   237: astore_1
    //   238: goto -21 -> 217
    //   241: astore_0
    //   242: goto -25 -> 217
    //   245: astore_0
    //   246: aload 6
    //   248: astore_1
    //   249: goto -60 -> 189
    //   252: astore_0
    //   253: goto -64 -> 189
    //   256: goto -99 -> 157
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	259	0	paramFile	File
    //   39	125	1	localBufferedReader	java.io.BufferedReader
    //   177	2	1	localIOException1	IOException
    //   188	34	1	localObject1	Object
    //   227	2	1	localIOException2	IOException
    //   237	12	1	localObject2	Object
    //   1	236	2	localObject3	Object
    //   6	204	3	localObject4	Object
    //   8	121	4	localObject5	Object
    //   13	77	5	str	String
    //   3	244	6	localObject6	Object
    //   75	68	7	l	long
    // Exception table:
    //   from	to	target	type
    //   163	167	169	java/io/IOException
    //   153	157	177	java/io/IOException
    //   15	24	185	java/lang/Exception
    //   195	199	204	java/io/IOException
    //   15	24	214	finally
    //   221	225	227	java/io/IOException
    //   24	40	235	finally
    //   40	45	241	finally
    //   49	82	241	finally
    //   92	116	241	finally
    //   138	149	241	finally
    //   24	40	245	java/lang/Exception
    //   40	45	252	java/lang/Exception
    //   49	82	252	java/lang/Exception
    //   92	116	252	java/lang/Exception
    //   138	149	252	java/lang/Exception
  }
  
  public static boolean releaseDexFromApk(Context paramContext, String paramString)
  {
    Object localObject1 = paramContext.getFilesDir();
    Object localObject2;
    DexReleasor localDexReleasor;
    String str1;
    label116:
    String str2;
    boolean bool1;
    if (localObject1 != null)
    {
      localObject1 = ((File)localObject1).getAbsolutePath();
      localObject2 = localObject1;
      if (!((String)localObject1).endsWith(File.separator)) {
        localObject2 = (String)localObject1 + File.separator;
      }
      new File((String)localObject2).mkdirs();
      localDexReleasor = DexReleasor.getInstance(getApkPath(paramContext), (String)localObject2);
      if (!paramString.equals(DexReleasor.sExtraDexes[0])) {
        break label142;
      }
      localObject1 = DexReleasor.sExtraJarDexes[0];
      str1 = DexReleasor.sExtraDexes[0] + ".MD5";
      str2 = getCurProcessName(paramContext);
      if (!TextUtils.isEmpty(str2)) {
        break label268;
      }
      bool1 = false;
    }
    label142:
    label268:
    do
    {
      boolean bool2;
      do
      {
        return bool1;
        localObject1 = "/data/data/com.tencent.mobileqq/files";
        break;
        if (paramString.equals(DexReleasor.sExtraDexes[1]))
        {
          localObject1 = DexReleasor.sExtraJarDexes[1];
          str1 = DexReleasor.sExtraDexes[1] + ".MD5";
          break label116;
        }
        if (paramString.equals(DexReleasor.sExtraDexes[2]))
        {
          localObject1 = DexReleasor.sExtraJarDexes[2];
          str1 = DexReleasor.sExtraDexes[2] + ".MD5";
          break label116;
        }
        localObject1 = DexReleasor.sExtraJarDexes[3];
        str1 = DexReleasor.sExtraDexes[3] + ".MD5";
        break label116;
        bool2 = true;
        paramString = localDexReleasor.releaseDex(str2, paramString);
        if (!isLibExtracted(paramContext, (String)localObject1, str1)) {
          break label315;
        }
        bool1 = bool2;
      } while (paramString == null);
      bool1 = bool2;
    } while (!paramString.exists());
    paramString.delete();
    return true;
    label315:
    paramContext = new File((String)localObject2 + (String)localObject1);
    if (paramContext.exists()) {
      paramContext.delete();
    }
    if ((paramString != null) && (paramString.exists()))
    {
      paramString.renameTo(paramContext);
      return true;
    }
    return false;
  }
  
  public static File releaseFromApk(String paramString1, String paramString2, String paramString3)
  {
    Object localObject1 = paramString3;
    if (!paramString3.endsWith(File.separator)) {
      localObject1 = paramString3 + File.separator;
    }
    new File((String)localObject1).mkdirs();
    paramString3 = null;
    Object localObject2 = "lib/" + getPlatformString() + "/";
    paramString2 = "lib/" + getPlatformString() + "/" + paramString2;
    MyZipEntry localMyZipEntry;
    try
    {
      paramString1 = new MyZipFile(new File(paramString1), paramString2);
      if (paramString1 == null) {
        return null;
      }
    }
    catch (IOException paramString2)
    {
      for (;;)
      {
        paramString1 = null;
        paramString2.printStackTrace();
      }
      localMyZipEntry = paramString1.getDesEntry();
      paramString2 = paramString3;
      if (localMyZipEntry == null) {
        break label312;
      }
    }
    paramString2 = paramString3;
    int i;
    if (localMyZipEntry.getName().contains((CharSequence)localObject2))
    {
      paramString2 = paramString3;
      if (localMyZipEntry.getName().endsWith(".so"))
      {
        paramString3 = localMyZipEntry.getName();
        i = paramString3.lastIndexOf('/');
        paramString2 = paramString3;
        if (i != -1) {
          paramString2 = paramString3.substring(i + 1);
        }
        paramString3 = new File((String)localObject1 + paramString2);
        if (paramString3.exists()) {
          paramString3.delete();
        }
        localObject1 = new byte['က'];
      }
    }
    try
    {
      paramString1 = paramString1.getInputStream(localMyZipEntry);
      localObject2 = new FileOutputStream(paramString3);
      try
      {
        for (;;)
        {
          i = paramString1.read((byte[])localObject1);
          paramString2 = paramString3;
          if (i <= 0) {
            break;
          }
          ((FileOutputStream)localObject2).write((byte[])localObject1, 0, i);
        }
        paramString1.printStackTrace();
      }
      catch (IOException paramString1) {}
    }
    catch (IOException paramString1)
    {
      for (;;) {}
    }
    paramString2 = paramString3;
    label312:
    return paramString2;
  }
  
  public static String releaseSo(Context paramContext, String paramString)
  {
    Object localObject2 = null;
    String str1 = getLibActualName(paramString);
    long l2 = -1L;
    initAssestCrcConfigs(paramContext);
    long l1 = l2;
    if (assestCrcConfigs != null)
    {
      l1 = l2;
      if (!assestCrcConfigs.isEmpty()) {
        l1 = ((Long)assestCrcConfigs.get("armeabi/" + str1)).longValue();
      }
    }
    paramString = paramContext.getFilesDir() + "/" + "soconfigs";
    new File(paramString).mkdirs();
    File localFile = new File(paramString + "/" + str1 + ".cfg");
    if ((localFile.exists()) && (localFile.isFile()))
    {
      paramString = readConfig(localFile);
      if (paramString != null)
      {
        localObject1 = new File(paramString.mSopath);
        if ((paramString.mCrcvalue == l1) && (((File)localObject1).exists()))
        {
          paramContext = ((File)localObject1).getAbsolutePath();
          return paramContext;
        }
      }
      localFile.delete();
    }
    String str2 = getAppWorkPath(paramContext) + "/txlib/";
    paramString = getAppWorkPath(paramContext) + "/lib/";
    paramString = new File(paramString + str1);
    if ((paramString.exists()) && (paramString.isFile()) && (getCRC32Value(paramString) == l1))
    {
      paramContext = paramString.getAbsolutePath();
      writeConfig(new ConfigStruct(l1, paramString.getAbsolutePath()), localFile);
      return paramContext;
    }
    paramString = null;
    Object localObject1 = getOsClassLoader();
    if (((String)localObject1).equals("equalAndAbove14")) {
      paramString = getSoOrDexByBaseDexClassLoader(paramContext, "lib/" + getPlatformString() + "/" + str1, str2 + str1);
    }
    for (;;)
    {
      localObject1 = paramString;
      if (paramString == null) {
        localObject1 = releaseFromApk(getApkPath(paramContext), str1, str2);
      }
      paramContext = (Context)localObject2;
      if (localObject1 == null) {
        break;
      }
      paramContext = (Context)localObject2;
      if (!((File)localObject1).exists()) {
        break;
      }
      paramContext = ((File)localObject1).getAbsolutePath();
      writeConfig(new ConfigStruct(l1, ((File)localObject1).getAbsolutePath()), localFile);
      return paramContext;
      if (((String)localObject1).equals("below14")) {
        paramString = getSoOrDexByPathClassLoader(paramContext, str1, str2);
      }
    }
  }
  
  public static File releaseSoAnyway(Context paramContext, String paramString1, String paramString2)
  {
    Object localObject2;
    if (hasBaseDexClassloader())
    {
      localObject2 = "lib/" + getPlatformString() + "/" + paramString1;
      localObject1 = paramString2;
      if (!paramString2.endsWith(File.separator)) {
        localObject1 = paramString2 + File.separator;
      }
      localObject2 = getSoOrDexByBaseDexClassLoader(paramContext, (String)localObject2, (String)localObject1 + paramString1);
      paramString2 = (String)localObject1;
    }
    for (Object localObject1 = localObject2;; localObject1 = getSoOrDexByPathClassLoader(paramContext, paramString1, paramString2))
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = releaseFromApk(getApkPath(paramContext), paramString1, paramString2);
      }
      return (File)localObject2;
    }
  }
  
  /* Error */
  private static boolean writeConfig(ConfigStruct paramConfigStruct, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: iconst_0
    //   5: istore 4
    //   7: aload_1
    //   8: invokevirtual 224	java/io/File:exists	()Z
    //   11: ifeq +8 -> 19
    //   14: aload_1
    //   15: invokevirtual 416	java/io/File:delete	()Z
    //   18: pop
    //   19: aload_1
    //   20: invokevirtual 428	java/io/File:createNewFile	()Z
    //   23: pop
    //   24: new 644	java/io/BufferedWriter
    //   27: dup
    //   28: new 646	java/io/OutputStreamWriter
    //   31: dup
    //   32: new 108	java/io/FileOutputStream
    //   35: dup
    //   36: aload_1
    //   37: invokespecial 111	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   40: invokespecial 647	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   43: invokespecial 650	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   46: astore_1
    //   47: aload_1
    //   48: new 295	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 296	java/lang/StringBuilder:<init>	()V
    //   55: ldc_w 652
    //   58: invokevirtual 300	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: aload_0
    //   62: getfield 408	com/tencent/commonsdk/soload/ConfigStruct:mCrcvalue	J
    //   65: invokevirtual 655	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   68: invokevirtual 308	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokevirtual 657	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   74: aload_1
    //   75: invokevirtual 660	java/io/BufferedWriter:newLine	()V
    //   78: aload_1
    //   79: new 295	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 296	java/lang/StringBuilder:<init>	()V
    //   86: ldc_w 662
    //   89: invokevirtual 300	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: aload_0
    //   93: getfield 411	com/tencent/commonsdk/soload/ConfigStruct:mSopath	Ljava/lang/String;
    //   96: invokevirtual 300	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: invokevirtual 308	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokevirtual 657	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   105: iconst_1
    //   106: istore 4
    //   108: aload_1
    //   109: ifnull +68 -> 177
    //   112: aload_1
    //   113: invokevirtual 663	java/io/BufferedWriter:close	()V
    //   116: iload 4
    //   118: ireturn
    //   119: astore_0
    //   120: aload_0
    //   121: invokevirtual 124	java/io/IOException:printStackTrace	()V
    //   124: iconst_1
    //   125: ireturn
    //   126: astore_0
    //   127: aload_3
    //   128: astore_0
    //   129: aload_0
    //   130: ifnull -14 -> 116
    //   133: aload_0
    //   134: invokevirtual 663	java/io/BufferedWriter:close	()V
    //   137: iconst_0
    //   138: ireturn
    //   139: astore_0
    //   140: aload_0
    //   141: invokevirtual 124	java/io/IOException:printStackTrace	()V
    //   144: iconst_0
    //   145: ireturn
    //   146: astore_0
    //   147: aload_2
    //   148: astore_1
    //   149: aload_1
    //   150: ifnull +7 -> 157
    //   153: aload_1
    //   154: invokevirtual 663	java/io/BufferedWriter:close	()V
    //   157: aload_0
    //   158: athrow
    //   159: astore_1
    //   160: aload_1
    //   161: invokevirtual 124	java/io/IOException:printStackTrace	()V
    //   164: goto -7 -> 157
    //   167: astore_0
    //   168: goto -19 -> 149
    //   171: astore_0
    //   172: aload_1
    //   173: astore_0
    //   174: goto -45 -> 129
    //   177: iconst_1
    //   178: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	paramConfigStruct	ConfigStruct
    //   0	179	1	paramFile	File
    //   1	147	2	localObject1	Object
    //   3	125	3	localObject2	Object
    //   5	112	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   112	116	119	java/io/IOException
    //   7	19	126	java/lang/Exception
    //   19	47	126	java/lang/Exception
    //   133	137	139	java/io/IOException
    //   7	19	146	finally
    //   19	47	146	finally
    //   153	157	159	java/io/IOException
    //   47	105	167	finally
    //   47	105	171	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\commonsdk\soload\SoLoadCore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */