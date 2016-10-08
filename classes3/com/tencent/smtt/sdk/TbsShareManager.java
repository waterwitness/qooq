package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.smtt.utils.AppUtil;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;
import java.io.IOException;

public class TbsShareManager
{
  static final String APP_VERSION = "app_version";
  static final String CORE_DISABLED = "core_disabled";
  static final String CORE_PACKAGENAME = "core_packagename";
  static final String CORE_PATH = "core_path";
  static final String CORE_VERSION = "core_version";
  private static final String TAG = "TbsShareManager";
  static final String TBS_FOLDER_NAME = "tbs";
  static final String TBS_PRIVATE_FOLDER_NAME = "core_private";
  private static boolean core_info_already_read = false;
  private static boolean core_info_shared;
  private static String mAppVersion;
  private static String mAvailableCorePath = null;
  private static int mAvailableCoreVersion = 0;
  private static boolean mCoreDiabled;
  private static String mSrcPackageName = null;
  private static Context sAppContext;
  private static boolean sIsThirdPartyApp;
  
  static
  {
    mCoreDiabled = false;
    core_info_shared = false;
    mAppVersion = null;
  }
  
  private static boolean checkCoreInOthers(Context paramContext)
  {
    boolean bool2 = false;
    Object localObject = getCoreProviderAppList();
    int j = localObject.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        String str = localObject[i];
        if ((mAvailableCoreVersion > 0) && (mAvailableCoreVersion == getSharedTbsCoreVersion(paramContext, str)))
        {
          localObject = getPackageContext(paramContext, str);
          mAvailableCorePath = TbsInstaller.getInstance().getTbsCoreShareDir(paramContext, (Context)localObject).getAbsolutePath();
          mSrcPackageName = str;
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  private static boolean checkCoreInfo(Context paramContext)
  {
    if (mSrcPackageName == null) {}
    while (mAvailableCoreVersion != getSharedTbsCoreVersion(paramContext, mSrcPackageName)) {
      return false;
    }
    return true;
  }
  
  private static boolean closeX5(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    writeProperties(paramContext, Integer.toString(0), "", "", Integer.toString(0));
    return true;
  }
  
  private static int findCoreForThirdPartyApp(Context paramContext)
  {
    loadProperties(paramContext);
    TbsLog.i("TbsShareManager", "core_info mAvailableCoreVersion is " + mAvailableCoreVersion + " mAvailableCorePath is " + mAvailableCorePath + " mSrcPackageName is " + mSrcPackageName);
    if ((!checkCoreInfo(paramContext)) && (!checkCoreInOthers(paramContext)))
    {
      mAvailableCoreVersion = 0;
      mAvailableCorePath = null;
      mSrcPackageName = null;
      TbsLog.i("TbsShareManager", "core_info error checkCoreInfo is false and checkCoreInOthers is false ");
    }
    if ((mAvailableCoreVersion > 0) && ((QbSdk.isX5Disabled(paramContext, mAvailableCoreVersion)) || (mCoreDiabled)))
    {
      mAvailableCoreVersion = 0;
      mAvailableCorePath = null;
      mSrcPackageName = null;
      TbsLog.i("TbsShareManager", "core_info error QbSdk.isX5Disabled ");
    }
    return mAvailableCoreVersion;
  }
  
  public static boolean forceLoadX5FromTBSDemo(Context paramContext)
  {
    if ((paramContext == null) || (TbsInstaller.getInstance().hasStaticTbsInstalled(paramContext, null))) {}
    int i;
    do
    {
      return false;
      i = getSharedTbsCoreVersion(paramContext, "com.tencent.x5sdk.demo");
    } while (i <= 0);
    Object localObject = getPackageContext(paramContext, "com.tencent.x5sdk.demo");
    localObject = TbsInstaller.getInstance().getTbsCoreShareDir((Context)localObject).getAbsolutePath();
    writeProperties(paramContext, Integer.toString(i), "com.tencent.x5sdk.demo", (String)localObject, "1");
    return true;
  }
  
  static Context getAvailableTbsCoreHostContext(Context paramContext)
  {
    isShareTbsCoreAvailable(paramContext);
    if (mSrcPackageName == null) {
      return null;
    }
    return getPackageContext(paramContext, mSrcPackageName);
  }
  
  static String getAvailableTbsCorePath(Context paramContext)
  {
    isShareTbsCoreAvailable(paramContext);
    return mAvailableCorePath;
  }
  
  static int getAvailableTbsCoreVersion(Context paramContext)
  {
    return getAvailableTbsCoreVersion(paramContext, true);
  }
  
  static int getAvailableTbsCoreVersion(Context paramContext, boolean paramBoolean)
  {
    isShareTbsCoreAvailable(paramContext, paramBoolean);
    return mAvailableCoreVersion;
  }
  
  public static String[] getCoreProviderAppList()
  {
    return new String[] { "com.tencent.mm", "com.tencent.mobileqq", "com.tencent.mtt", "com.qzone", "com.tencent.qqpimsecure", "com.tencent.x5sdk.demo", "com.tencent.mtt.sdk.test" };
  }
  
  private static Context getPackageContext(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.createPackageContext(paramString, 2);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      return null;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return null;
  }
  
  public static int getSharedTbsCoreVersion(Context paramContext, String paramString)
  {
    paramContext = getPackageContext(paramContext, paramString);
    if (paramContext == null) {
      return 0;
    }
    return TbsInstaller.getInstance().getTbsCoreInstalledVerInNolock(paramContext);
  }
  
  private static File getTbsCorePrivateDir(Context paramContext)
  {
    paramContext = new File(paramContext.getDir("tbs", 0), "core_private");
    if ((paramContext == null) || ((!paramContext.isDirectory()) && (!paramContext.mkdir()))) {
      return null;
    }
    return paramContext;
  }
  
  private static File getTbsCorePrivateFile(Context paramContext, String paramString)
  {
    paramContext = getTbsCorePrivateDir(paramContext);
    if (paramContext == null) {
      return null;
    }
    paramContext = new File(paramContext, paramString);
    if ((paramContext != null) && (paramContext.exists())) {
      return paramContext;
    }
    try
    {
      paramContext.createNewFile();
      return paramContext;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  private static File getTbsShareFile(Context paramContext, String paramString)
  {
    paramContext = TbsInstaller.getInstance().getTbsShareDir(paramContext);
    if (paramContext == null) {
      return null;
    }
    paramContext = new File(paramContext, paramString);
    if ((paramContext != null) && (paramContext.exists())) {
      return paramContext;
    }
    try
    {
      paramContext.createNewFile();
      return paramContext;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  static boolean isShareTbsCoreAvailable(Context paramContext)
  {
    return isShareTbsCoreAvailable(paramContext, true);
  }
  
  static boolean isShareTbsCoreAvailable(Context paramContext, boolean paramBoolean)
  {
    if (isShareTbsCoreAvailableInner(paramContext)) {
      return true;
    }
    if (paramBoolean) {
      QbSdk.forceSysWebViewInner(paramContext, "TbsShareManager::isShareTbsCoreAvailable forceSysWebViewInner!");
    }
    return false;
  }
  
  static boolean isShareTbsCoreAvailableInner(Context paramContext)
  {
    try
    {
      if (mAvailableCoreVersion == 0) {
        findCoreForThirdPartyApp(paramContext);
      }
      if (mAvailableCoreVersion == 0) {
        return false;
      }
      if ((mAvailableCoreVersion != 0) && (getSharedTbsCoreVersion(paramContext, mSrcPackageName) == mAvailableCoreVersion)) {
        return true;
      }
      mAvailableCorePath = null;
      mAvailableCoreVersion = 0;
      QbSdk.forceSysWebViewInner(paramContext, "TbsShareManager::isShareTbsCoreAvailableInner forceSysWebViewInner!");
      return false;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public static boolean isThirdPartyApp(Context paramContext)
  {
    for (;;)
    {
      int i;
      try
      {
        if ((sAppContext != null) && (sAppContext.equals(paramContext.getApplicationContext()))) {
          return sIsThirdPartyApp;
        }
        sAppContext = paramContext.getApplicationContext();
        paramContext = sAppContext.getPackageName();
        String[] arrayOfString = getCoreProviderAppList();
        int j = arrayOfString.length;
        i = 0;
        if (i < j)
        {
          if (!paramContext.equals(arrayOfString[i])) {
            break label78;
          }
          sIsThirdPartyApp = false;
          return false;
        }
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
        sIsThirdPartyApp = true;
        return true;
      }
      label78:
      i += 1;
    }
  }
  
  /* Error */
  private static void loadProperties(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 57	com/tencent/smtt/sdk/TbsShareManager:core_info_already_read	Z
    //   6: istore 4
    //   8: iload 4
    //   10: ifeq +7 -> 17
    //   13: ldc 2
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: ldc_w 272
    //   21: invokestatic 274	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   24: astore_0
    //   25: aload_0
    //   26: ifnonnull +29 -> 55
    //   29: iconst_0
    //   30: ifeq -17 -> 13
    //   33: new 276	java/lang/NullPointerException
    //   36: dup
    //   37: invokespecial 277	java/lang/NullPointerException:<init>	()V
    //   40: athrow
    //   41: astore_0
    //   42: aload_0
    //   43: invokevirtual 202	java/lang/Exception:printStackTrace	()V
    //   46: goto -33 -> 13
    //   49: astore_0
    //   50: ldc 2
    //   52: monitorexit
    //   53: aload_0
    //   54: athrow
    //   55: new 279	java/io/FileInputStream
    //   58: dup
    //   59: aload_0
    //   60: invokespecial 282	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   63: astore_1
    //   64: aload_1
    //   65: astore_0
    //   66: new 284	java/util/Properties
    //   69: dup
    //   70: invokespecial 285	java/util/Properties:<init>	()V
    //   73: astore_2
    //   74: aload_1
    //   75: astore_0
    //   76: aload_2
    //   77: aload_1
    //   78: invokevirtual 289	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   81: aload_1
    //   82: astore_0
    //   83: aload_2
    //   84: ldc 20
    //   86: ldc 101
    //   88: invokevirtual 293	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   91: astore_3
    //   92: aload_1
    //   93: astore_0
    //   94: ldc 101
    //   96: aload_3
    //   97: invokevirtual 270	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   100: ifne +16 -> 116
    //   103: aload_1
    //   104: astore_0
    //   105: aload_3
    //   106: invokestatic 297	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   109: iconst_0
    //   110: invokestatic 303	java/lang/Math:max	(II)I
    //   113: putstatic 47	com/tencent/smtt/sdk/TbsShareManager:mAvailableCoreVersion	I
    //   116: aload_1
    //   117: astore_0
    //   118: aload_2
    //   119: ldc 14
    //   121: ldc 101
    //   123: invokevirtual 293	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   126: astore_3
    //   127: aload_1
    //   128: astore_0
    //   129: ldc 101
    //   131: aload_3
    //   132: invokevirtual 270	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   135: ifne +9 -> 144
    //   138: aload_1
    //   139: astore_0
    //   140: aload_3
    //   141: putstatic 49	com/tencent/smtt/sdk/TbsShareManager:mSrcPackageName	Ljava/lang/String;
    //   144: aload_1
    //   145: astore_0
    //   146: aload_2
    //   147: ldc 17
    //   149: ldc 101
    //   151: invokevirtual 293	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   154: astore_3
    //   155: aload_1
    //   156: astore_0
    //   157: ldc 101
    //   159: aload_3
    //   160: invokevirtual 270	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   163: ifne +9 -> 172
    //   166: aload_1
    //   167: astore_0
    //   168: aload_3
    //   169: putstatic 45	com/tencent/smtt/sdk/TbsShareManager:mAvailableCorePath	Ljava/lang/String;
    //   172: aload_1
    //   173: astore_0
    //   174: aload_2
    //   175: ldc 8
    //   177: ldc 101
    //   179: invokevirtual 293	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   182: astore_3
    //   183: aload_1
    //   184: astore_0
    //   185: ldc 101
    //   187: aload_3
    //   188: invokevirtual 270	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   191: ifne +9 -> 200
    //   194: aload_1
    //   195: astore_0
    //   196: aload_3
    //   197: putstatic 55	com/tencent/smtt/sdk/TbsShareManager:mAppVersion	Ljava/lang/String;
    //   200: aload_1
    //   201: astore_0
    //   202: aload_2
    //   203: ldc 11
    //   205: ldc_w 305
    //   208: invokevirtual 293	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   211: invokestatic 311	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   214: putstatic 51	com/tencent/smtt/sdk/TbsShareManager:mCoreDiabled	Z
    //   217: aload_1
    //   218: astore_0
    //   219: iconst_1
    //   220: putstatic 57	com/tencent/smtt/sdk/TbsShareManager:core_info_already_read	Z
    //   223: aload_1
    //   224: ifnull -211 -> 13
    //   227: aload_1
    //   228: invokevirtual 314	java/io/FileInputStream:close	()V
    //   231: goto -218 -> 13
    //   234: astore_0
    //   235: aload_0
    //   236: invokevirtual 202	java/lang/Exception:printStackTrace	()V
    //   239: goto -226 -> 13
    //   242: astore_2
    //   243: aconst_null
    //   244: astore_1
    //   245: aload_1
    //   246: astore_0
    //   247: aload_2
    //   248: invokevirtual 253	java/lang/Throwable:printStackTrace	()V
    //   251: aload_1
    //   252: ifnull -239 -> 13
    //   255: aload_1
    //   256: invokevirtual 314	java/io/FileInputStream:close	()V
    //   259: goto -246 -> 13
    //   262: astore_0
    //   263: aload_0
    //   264: invokevirtual 202	java/lang/Exception:printStackTrace	()V
    //   267: goto -254 -> 13
    //   270: astore_1
    //   271: aconst_null
    //   272: astore_0
    //   273: aload_0
    //   274: ifnull +7 -> 281
    //   277: aload_0
    //   278: invokevirtual 314	java/io/FileInputStream:close	()V
    //   281: aload_1
    //   282: athrow
    //   283: astore_0
    //   284: aload_0
    //   285: invokevirtual 202	java/lang/Exception:printStackTrace	()V
    //   288: goto -7 -> 281
    //   291: astore_1
    //   292: goto -19 -> 273
    //   295: astore_2
    //   296: goto -51 -> 245
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	299	0	paramContext	Context
    //   63	193	1	localFileInputStream	java.io.FileInputStream
    //   270	12	1	localObject1	Object
    //   291	1	1	localObject2	Object
    //   73	130	2	localProperties	java.util.Properties
    //   242	6	2	localThrowable1	Throwable
    //   295	1	2	localThrowable2	Throwable
    //   91	106	3	str	String
    //   6	3	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   33	41	41	java/lang/Exception
    //   3	8	49	finally
    //   33	41	49	finally
    //   42	46	49	finally
    //   227	231	49	finally
    //   235	239	49	finally
    //   255	259	49	finally
    //   263	267	49	finally
    //   277	281	49	finally
    //   281	283	49	finally
    //   284	288	49	finally
    //   227	231	234	java/lang/Exception
    //   17	25	242	java/lang/Throwable
    //   55	64	242	java/lang/Throwable
    //   255	259	262	java/lang/Exception
    //   17	25	270	finally
    //   55	64	270	finally
    //   277	281	283	java/lang/Exception
    //   66	74	291	finally
    //   76	81	291	finally
    //   83	92	291	finally
    //   94	103	291	finally
    //   105	116	291	finally
    //   118	127	291	finally
    //   129	138	291	finally
    //   140	144	291	finally
    //   146	155	291	finally
    //   157	166	291	finally
    //   168	172	291	finally
    //   174	183	291	finally
    //   185	194	291	finally
    //   196	200	291	finally
    //   202	217	291	finally
    //   219	223	291	finally
    //   247	251	291	finally
    //   66	74	295	java/lang/Throwable
    //   76	81	295	java/lang/Throwable
    //   83	92	295	java/lang/Throwable
    //   94	103	295	java/lang/Throwable
    //   105	116	295	java/lang/Throwable
    //   118	127	295	java/lang/Throwable
    //   129	138	295	java/lang/Throwable
    //   140	144	295	java/lang/Throwable
    //   146	155	295	java/lang/Throwable
    //   157	166	295	java/lang/Throwable
    //   168	172	295	java/lang/Throwable
    //   174	183	295	java/lang/Throwable
    //   185	194	295	java/lang/Throwable
    //   196	200	295	java/lang/Throwable
    //   202	217	295	java/lang/Throwable
    //   219	223	295	java/lang/Throwable
  }
  
  /* Error */
  private static void openX5(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 272
    //   4: invokestatic 274	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   7: astore 6
    //   9: aload 6
    //   11: ifnonnull +11 -> 22
    //   14: new 276	java/lang/NullPointerException
    //   17: dup
    //   18: invokespecial 277	java/lang/NullPointerException:<init>	()V
    //   21: athrow
    //   22: new 279	java/io/FileInputStream
    //   25: dup
    //   26: aload 6
    //   28: invokespecial 282	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   31: astore_3
    //   32: aload_3
    //   33: astore_2
    //   34: new 284	java/util/Properties
    //   37: dup
    //   38: invokespecial 285	java/util/Properties:<init>	()V
    //   41: astore 4
    //   43: aload_3
    //   44: astore_2
    //   45: aload 4
    //   47: aload_3
    //   48: invokevirtual 289	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   51: aload_3
    //   52: astore_2
    //   53: aload 4
    //   55: ldc 11
    //   57: iconst_0
    //   58: invokestatic 320	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   61: invokevirtual 324	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   64: pop
    //   65: iload_1
    //   66: ifeq +75 -> 141
    //   69: aload_3
    //   70: astore_2
    //   71: invokestatic 81	com/tencent/smtt/sdk/TbsInstaller:getInstance	()Lcom/tencent/smtt/sdk/TbsInstaller;
    //   74: aload_0
    //   75: invokevirtual 159	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreShareDir	(Landroid/content/Context;)Ljava/io/File;
    //   78: invokevirtual 91	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   81: astore 7
    //   83: aload_3
    //   84: astore_2
    //   85: aload_0
    //   86: invokevirtual 260	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   89: invokevirtual 269	android/content/Context:getPackageName	()Ljava/lang/String;
    //   92: astore 5
    //   94: aload_3
    //   95: astore_2
    //   96: aload_0
    //   97: invokestatic 329	com/tencent/smtt/utils/AppUtil:getAppVersionCode	(Landroid/content/Context;)I
    //   100: istore 8
    //   102: aload_3
    //   103: astore_2
    //   104: aload 4
    //   106: ldc 14
    //   108: aload 5
    //   110: invokevirtual 324	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   113: pop
    //   114: aload_3
    //   115: astore_2
    //   116: aload 4
    //   118: ldc 17
    //   120: aload 7
    //   122: invokevirtual 324	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   125: pop
    //   126: aload_3
    //   127: astore_2
    //   128: aload 4
    //   130: ldc 8
    //   132: iload 8
    //   134: invokestatic 331	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   137: invokevirtual 324	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   140: pop
    //   141: aload_3
    //   142: astore_2
    //   143: aload 4
    //   145: new 333	java/io/FileOutputStream
    //   148: dup
    //   149: aload 6
    //   151: invokespecial 334	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   154: aconst_null
    //   155: invokevirtual 338	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   158: aload_3
    //   159: invokevirtual 314	java/io/FileInputStream:close	()V
    //   162: return
    //   163: astore_0
    //   164: return
    //   165: astore 4
    //   167: aconst_null
    //   168: astore_0
    //   169: aload_0
    //   170: astore_2
    //   171: aload 4
    //   173: invokevirtual 253	java/lang/Throwable:printStackTrace	()V
    //   176: aload_0
    //   177: invokevirtual 314	java/io/FileInputStream:close	()V
    //   180: return
    //   181: astore_0
    //   182: aconst_null
    //   183: astore_2
    //   184: aload_2
    //   185: invokevirtual 314	java/io/FileInputStream:close	()V
    //   188: aload_0
    //   189: athrow
    //   190: astore_2
    //   191: goto -3 -> 188
    //   194: astore_0
    //   195: goto -11 -> 184
    //   198: astore 4
    //   200: aload_3
    //   201: astore_0
    //   202: goto -33 -> 169
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	205	0	paramContext	Context
    //   0	205	1	paramBoolean	boolean
    //   33	152	2	localObject	Object
    //   190	1	2	localException	Exception
    //   31	170	3	localFileInputStream	java.io.FileInputStream
    //   41	103	4	localProperties	java.util.Properties
    //   165	7	4	localThrowable1	Throwable
    //   198	1	4	localThrowable2	Throwable
    //   92	17	5	str1	String
    //   7	143	6	localFile	File
    //   81	40	7	str2	String
    //   100	33	8	i	int
    // Exception table:
    //   from	to	target	type
    //   14	22	163	java/lang/Exception
    //   158	162	163	java/lang/Exception
    //   176	180	163	java/lang/Exception
    //   0	9	165	java/lang/Throwable
    //   22	32	165	java/lang/Throwable
    //   0	9	181	finally
    //   22	32	181	finally
    //   184	188	190	java/lang/Exception
    //   34	43	194	finally
    //   45	51	194	finally
    //   53	65	194	finally
    //   71	83	194	finally
    //   85	94	194	finally
    //   96	102	194	finally
    //   104	114	194	finally
    //   116	126	194	finally
    //   128	141	194	finally
    //   143	158	194	finally
    //   171	176	194	finally
    //   34	43	198	java/lang/Throwable
    //   45	51	198	java/lang/Throwable
    //   53	65	198	java/lang/Throwable
    //   71	83	198	java/lang/Throwable
    //   85	94	198	java/lang/Throwable
    //   96	102	198	java/lang/Throwable
    //   104	114	198	java/lang/Throwable
    //   116	126	198	java/lang/Throwable
    //   128	141	198	java/lang/Throwable
    //   143	158	198	java/lang/Throwable
  }
  
  /* Error */
  static int readCoreVersionFromConfig(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: ldc 2
    //   5: monitorenter
    //   6: aload_0
    //   7: ldc_w 272
    //   10: invokestatic 274	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   13: astore_0
    //   14: aload_0
    //   15: ifnonnull +23 -> 38
    //   18: iload 4
    //   20: istore_3
    //   21: iconst_0
    //   22: ifeq +11 -> 33
    //   25: new 276	java/lang/NullPointerException
    //   28: dup
    //   29: invokespecial 277	java/lang/NullPointerException:<init>	()V
    //   32: athrow
    //   33: ldc 2
    //   35: monitorexit
    //   36: iload_3
    //   37: ireturn
    //   38: new 279	java/io/FileInputStream
    //   41: dup
    //   42: aload_0
    //   43: invokespecial 282	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   46: astore_1
    //   47: aload_1
    //   48: astore_0
    //   49: new 284	java/util/Properties
    //   52: dup
    //   53: invokespecial 285	java/util/Properties:<init>	()V
    //   56: astore_2
    //   57: aload_1
    //   58: astore_0
    //   59: aload_2
    //   60: aload_1
    //   61: invokevirtual 289	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   64: aload_1
    //   65: astore_0
    //   66: aload_2
    //   67: ldc 20
    //   69: ldc 101
    //   71: invokevirtual 293	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   74: astore_2
    //   75: aload_1
    //   76: astore_0
    //   77: ldc 101
    //   79: aload_2
    //   80: invokevirtual 270	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   83: ifne +112 -> 195
    //   86: aload_1
    //   87: astore_0
    //   88: aload_2
    //   89: invokestatic 297	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   92: iconst_0
    //   93: invokestatic 303	java/lang/Math:max	(II)I
    //   96: istore 4
    //   98: iload 4
    //   100: istore_3
    //   101: aload_1
    //   102: ifnull -69 -> 33
    //   105: aload_1
    //   106: invokevirtual 314	java/io/FileInputStream:close	()V
    //   109: iload 4
    //   111: istore_3
    //   112: goto -79 -> 33
    //   115: astore_0
    //   116: aload_0
    //   117: invokevirtual 202	java/lang/Exception:printStackTrace	()V
    //   120: iload 4
    //   122: istore_3
    //   123: goto -90 -> 33
    //   126: astore_0
    //   127: ldc 2
    //   129: monitorexit
    //   130: aload_0
    //   131: athrow
    //   132: astore_2
    //   133: aconst_null
    //   134: astore_1
    //   135: aload_1
    //   136: astore_0
    //   137: aload_2
    //   138: invokevirtual 253	java/lang/Throwable:printStackTrace	()V
    //   141: aload_1
    //   142: ifnull +7 -> 149
    //   145: aload_1
    //   146: invokevirtual 314	java/io/FileInputStream:close	()V
    //   149: bipush -2
    //   151: istore_3
    //   152: goto -119 -> 33
    //   155: astore_1
    //   156: aconst_null
    //   157: astore_0
    //   158: aload_0
    //   159: ifnull +7 -> 166
    //   162: aload_0
    //   163: invokevirtual 314	java/io/FileInputStream:close	()V
    //   166: aload_1
    //   167: athrow
    //   168: astore_0
    //   169: aload_0
    //   170: invokevirtual 202	java/lang/Exception:printStackTrace	()V
    //   173: goto -7 -> 166
    //   176: astore_0
    //   177: aload_0
    //   178: invokevirtual 202	java/lang/Exception:printStackTrace	()V
    //   181: goto -32 -> 149
    //   184: astore_0
    //   185: aload_0
    //   186: invokevirtual 202	java/lang/Exception:printStackTrace	()V
    //   189: iload 4
    //   191: istore_3
    //   192: goto -159 -> 33
    //   195: iload 4
    //   197: istore_3
    //   198: aload_1
    //   199: ifnull -166 -> 33
    //   202: aload_1
    //   203: invokevirtual 314	java/io/FileInputStream:close	()V
    //   206: iload 4
    //   208: istore_3
    //   209: goto -176 -> 33
    //   212: astore_0
    //   213: aload_0
    //   214: invokevirtual 202	java/lang/Exception:printStackTrace	()V
    //   217: iload 4
    //   219: istore_3
    //   220: goto -187 -> 33
    //   223: astore_1
    //   224: goto -66 -> 158
    //   227: astore_2
    //   228: goto -93 -> 135
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	231	0	paramContext	Context
    //   46	100	1	localFileInputStream	java.io.FileInputStream
    //   155	48	1	localObject1	Object
    //   223	1	1	localObject2	Object
    //   56	33	2	localObject3	Object
    //   132	6	2	localThrowable1	Throwable
    //   227	1	2	localThrowable2	Throwable
    //   20	200	3	i	int
    //   1	217	4	j	int
    // Exception table:
    //   from	to	target	type
    //   105	109	115	java/lang/Exception
    //   25	33	126	finally
    //   105	109	126	finally
    //   116	120	126	finally
    //   145	149	126	finally
    //   162	166	126	finally
    //   166	168	126	finally
    //   169	173	126	finally
    //   177	181	126	finally
    //   185	189	126	finally
    //   202	206	126	finally
    //   213	217	126	finally
    //   6	14	132	java/lang/Throwable
    //   38	47	132	java/lang/Throwable
    //   6	14	155	finally
    //   38	47	155	finally
    //   162	166	168	java/lang/Exception
    //   145	149	176	java/lang/Exception
    //   25	33	184	java/lang/Exception
    //   202	206	212	java/lang/Exception
    //   49	57	223	finally
    //   59	64	223	finally
    //   66	75	223	finally
    //   77	86	223	finally
    //   88	98	223	finally
    //   137	141	223	finally
    //   49	57	227	java/lang/Throwable
    //   59	64	227	java/lang/Throwable
    //   66	75	227	java/lang/Throwable
    //   77	86	227	java/lang/Throwable
    //   88	98	227	java/lang/Throwable
  }
  
  /* Error */
  static String readPackageNameFromConfig(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc 2
    //   4: monitorenter
    //   5: aload_0
    //   6: ldc_w 272
    //   9: invokestatic 274	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   12: astore_0
    //   13: aload_0
    //   14: ifnonnull +22 -> 36
    //   17: aload_3
    //   18: astore_0
    //   19: iconst_0
    //   20: ifeq +11 -> 31
    //   23: new 276	java/lang/NullPointerException
    //   26: dup
    //   27: invokespecial 277	java/lang/NullPointerException:<init>	()V
    //   30: athrow
    //   31: ldc 2
    //   33: monitorexit
    //   34: aload_0
    //   35: areturn
    //   36: new 279	java/io/FileInputStream
    //   39: dup
    //   40: aload_0
    //   41: invokespecial 282	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   44: astore_1
    //   45: aload_1
    //   46: astore_0
    //   47: new 284	java/util/Properties
    //   50: dup
    //   51: invokespecial 285	java/util/Properties:<init>	()V
    //   54: astore_2
    //   55: aload_1
    //   56: astore_0
    //   57: aload_2
    //   58: aload_1
    //   59: invokevirtual 289	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   62: aload_1
    //   63: astore_0
    //   64: aload_2
    //   65: ldc 14
    //   67: ldc 101
    //   69: invokevirtual 293	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   72: astore_2
    //   73: aload_1
    //   74: astore_0
    //   75: ldc 101
    //   77: aload_2
    //   78: invokevirtual 270	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   81: istore 4
    //   83: iload 4
    //   85: ifne +73 -> 158
    //   88: aload_1
    //   89: ifnull +7 -> 96
    //   92: aload_1
    //   93: invokevirtual 314	java/io/FileInputStream:close	()V
    //   96: aload_2
    //   97: astore_0
    //   98: goto -67 -> 31
    //   101: astore_2
    //   102: aconst_null
    //   103: astore_1
    //   104: aload_1
    //   105: astore_0
    //   106: aload_2
    //   107: invokevirtual 253	java/lang/Throwable:printStackTrace	()V
    //   110: aload_3
    //   111: astore_0
    //   112: aload_1
    //   113: ifnull -82 -> 31
    //   116: aload_1
    //   117: invokevirtual 314	java/io/FileInputStream:close	()V
    //   120: aload_3
    //   121: astore_0
    //   122: goto -91 -> 31
    //   125: astore_0
    //   126: aload_3
    //   127: astore_0
    //   128: goto -97 -> 31
    //   131: astore_1
    //   132: aconst_null
    //   133: astore_0
    //   134: aload_0
    //   135: ifnull +7 -> 142
    //   138: aload_0
    //   139: invokevirtual 314	java/io/FileInputStream:close	()V
    //   142: aload_1
    //   143: athrow
    //   144: astore_0
    //   145: ldc 2
    //   147: monitorexit
    //   148: aload_0
    //   149: athrow
    //   150: astore_0
    //   151: goto -9 -> 142
    //   154: astore_0
    //   155: goto -59 -> 96
    //   158: aload_3
    //   159: astore_0
    //   160: aload_1
    //   161: ifnull -130 -> 31
    //   164: aload_1
    //   165: invokevirtual 314	java/io/FileInputStream:close	()V
    //   168: aload_3
    //   169: astore_0
    //   170: goto -139 -> 31
    //   173: astore_1
    //   174: goto -40 -> 134
    //   177: astore_2
    //   178: goto -74 -> 104
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	paramContext	Context
    //   44	73	1	localFileInputStream	java.io.FileInputStream
    //   131	34	1	localObject1	Object
    //   173	1	1	localObject2	Object
    //   54	43	2	localObject3	Object
    //   101	6	2	localThrowable1	Throwable
    //   177	1	2	localThrowable2	Throwable
    //   1	168	3	localObject4	Object
    //   81	3	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   5	13	101	java/lang/Throwable
    //   36	45	101	java/lang/Throwable
    //   23	31	125	java/lang/Exception
    //   116	120	125	java/lang/Exception
    //   164	168	125	java/lang/Exception
    //   5	13	131	finally
    //   36	45	131	finally
    //   23	31	144	finally
    //   92	96	144	finally
    //   116	120	144	finally
    //   138	142	144	finally
    //   142	144	144	finally
    //   164	168	144	finally
    //   138	142	150	java/lang/Exception
    //   92	96	154	java/lang/Exception
    //   47	55	173	finally
    //   57	62	173	finally
    //   64	73	173	finally
    //   75	83	173	finally
    //   106	110	173	finally
    //   47	55	177	java/lang/Throwable
    //   57	62	177	java/lang/Throwable
    //   64	73	177	java/lang/Throwable
    //   75	83	177	java/lang/Throwable
  }
  
  private static void shareAllDirsAndFiles(Context paramContext, TbsLinuxToolsJni paramTbsLinuxToolsJni, File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists()) || (!paramFile.isDirectory())) {
      return;
    }
    paramTbsLinuxToolsJni.Chmod(paramFile.getAbsolutePath(), "755");
    paramFile = paramFile.listFiles();
    int j = paramFile.length;
    int i = 0;
    label43:
    File localFile;
    if (i < j)
    {
      localFile = paramFile[i];
      if (!localFile.isFile()) {
        break label111;
      }
      if (localFile.getAbsolutePath().indexOf(".so") <= 0) {
        break label96;
      }
      paramTbsLinuxToolsJni.Chmod(localFile.getAbsolutePath(), "755");
    }
    for (;;)
    {
      i += 1;
      break label43;
      break;
      label96:
      paramTbsLinuxToolsJni.Chmod(localFile.getAbsolutePath(), "644");
      continue;
      label111:
      if (localFile.isDirectory()) {
        shareAllDirsAndFiles(paramContext, paramTbsLinuxToolsJni, localFile);
      } else {
        TbsLog.e("TbsShareManager", "unknown file type.", true);
      }
    }
  }
  
  static void shareTbsCore(Context paramContext)
  {
    try
    {
      TbsLinuxToolsJni localTbsLinuxToolsJni = new TbsLinuxToolsJni(paramContext);
      shareAllDirsAndFiles(paramContext, localTbsLinuxToolsJni, TbsInstaller.getInstance().getTbsCoreShareDir(paramContext));
      localTbsLinuxToolsJni.Chmod(TbsInstaller.getInstance().getTbsShareDir(paramContext).getAbsolutePath(), "755");
      return;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void writeCoreInfoForThirdPartyApp(Context paramContext, int paramInt, boolean paramBoolean)
  {
    int i = 0;
    if (paramInt == 0) {
      closeX5(paramContext);
    }
    label290:
    for (;;)
    {
      return;
      int j = readCoreVersionFromConfig(paramContext);
      if (j >= 0)
      {
        if (paramInt == j)
        {
          openX5(paramContext, paramBoolean);
          return;
        }
        if (paramInt < j)
        {
          closeX5(paramContext);
          return;
        }
        Object localObject1 = getCoreProviderAppList();
        if (paramBoolean)
        {
          localObject1 = new String[1];
          localObject1[0] = paramContext.getApplicationContext().getPackageName();
        }
        j = localObject1.length;
        for (;;)
        {
          if (i >= j) {
            break label290;
          }
          Object localObject2 = localObject1[i];
          if (paramInt == getSharedTbsCoreVersion(paramContext, (String)localObject2))
          {
            localObject1 = getPackageContext(paramContext, (String)localObject2);
            localObject1 = TbsInstaller.getInstance().getTbsCoreShareDir((Context)localObject1).getAbsolutePath();
            i = AppUtil.getAppVersionCode(paramContext);
            File localFile;
            if (!((String)localObject2).equals(paramContext.getApplicationContext().getPackageName()))
            {
              TbsLog.i("TbsShareManager", "thirdAPP pre--> delete old core_share Directory:" + paramInt);
              localFile = TbsInstaller.getInstance().getTbsCoreShareDir(paramContext);
            }
            try
            {
              FileUtil.delete(localFile);
              TbsLog.i("TbsShareManager", "thirdAPP success--> delete old core_share Directory");
              writeProperties(paramContext, Integer.toString(paramInt), (String)localObject2, (String)localObject1, Integer.toString(i));
              try
              {
                localObject1 = getTbsShareFile(paramContext, "core_info");
                if ((core_info_shared) || (localObject1 == null)) {
                  break;
                }
                localObject2 = new TbsLinuxToolsJni(sAppContext);
                ((TbsLinuxToolsJni)localObject2).Chmod(((File)localObject1).getAbsolutePath(), "644");
                ((TbsLinuxToolsJni)localObject2).Chmod(TbsInstaller.getInstance().getTbsShareDir(paramContext).getAbsolutePath(), "755");
                core_info_shared = true;
                return;
              }
              catch (Throwable paramContext)
              {
                paramContext.printStackTrace();
                return;
              }
            }
            catch (Throwable localThrowable)
            {
              for (;;)
              {
                localThrowable.printStackTrace();
              }
            }
          }
          i += 1;
        }
      }
    }
  }
  
  /* Error */
  public static void writeProperties(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 9
    //   3: aload_0
    //   4: ldc_w 272
    //   7: invokestatic 274	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   10: astore 7
    //   12: aload 7
    //   14: ifnonnull +11 -> 25
    //   17: new 276	java/lang/NullPointerException
    //   20: dup
    //   21: invokespecial 277	java/lang/NullPointerException:<init>	()V
    //   24: athrow
    //   25: new 279	java/io/FileInputStream
    //   28: dup
    //   29: aload 7
    //   31: invokespecial 282	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   34: astore 5
    //   36: aload 5
    //   38: astore_0
    //   39: new 284	java/util/Properties
    //   42: dup
    //   43: invokespecial 285	java/util/Properties:<init>	()V
    //   46: astore 6
    //   48: aload 5
    //   50: astore_0
    //   51: aload 6
    //   53: aload 5
    //   55: invokevirtual 289	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   58: aload 5
    //   60: astore_0
    //   61: aload_1
    //   62: invokestatic 297	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   65: istore 8
    //   67: iload 8
    //   69: ifeq +104 -> 173
    //   72: aload 5
    //   74: astore_0
    //   75: aload 6
    //   77: ldc 20
    //   79: aload_1
    //   80: invokevirtual 324	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   83: pop
    //   84: aload 5
    //   86: astore_0
    //   87: aload 6
    //   89: ldc 11
    //   91: iconst_0
    //   92: invokestatic 320	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   95: invokevirtual 324	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   98: pop
    //   99: aload 5
    //   101: astore_0
    //   102: aload 6
    //   104: ldc 14
    //   106: aload_2
    //   107: invokevirtual 324	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   110: pop
    //   111: aload 5
    //   113: astore_0
    //   114: aload 6
    //   116: ldc 17
    //   118: aload_3
    //   119: invokevirtual 324	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   122: pop
    //   123: aload 5
    //   125: astore_0
    //   126: aload 6
    //   128: ldc 8
    //   130: aload 4
    //   132: invokevirtual 324	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   135: pop
    //   136: aload 5
    //   138: astore_0
    //   139: aload 6
    //   141: new 333	java/io/FileOutputStream
    //   144: dup
    //   145: aload 7
    //   147: invokespecial 334	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   150: aconst_null
    //   151: invokevirtual 338	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   154: aload 5
    //   156: astore_0
    //   157: iconst_0
    //   158: putstatic 57	com/tencent/smtt/sdk/TbsShareManager:core_info_already_read	Z
    //   161: aload 5
    //   163: invokevirtual 314	java/io/FileInputStream:close	()V
    //   166: return
    //   167: astore_0
    //   168: aload_0
    //   169: invokevirtual 202	java/lang/Exception:printStackTrace	()V
    //   172: return
    //   173: aload 5
    //   175: astore_0
    //   176: aload 6
    //   178: ldc 11
    //   180: iconst_1
    //   181: invokestatic 320	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   184: invokevirtual 324	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   187: pop
    //   188: goto -52 -> 136
    //   191: astore_2
    //   192: aload 5
    //   194: astore_1
    //   195: aload_1
    //   196: astore_0
    //   197: aload_2
    //   198: invokevirtual 253	java/lang/Throwable:printStackTrace	()V
    //   201: aload_1
    //   202: invokevirtual 314	java/io/FileInputStream:close	()V
    //   205: return
    //   206: astore_0
    //   207: goto -39 -> 168
    //   210: astore_1
    //   211: aconst_null
    //   212: astore_0
    //   213: aload_0
    //   214: invokevirtual 314	java/io/FileInputStream:close	()V
    //   217: aload_1
    //   218: athrow
    //   219: astore_0
    //   220: iload 9
    //   222: istore 8
    //   224: goto -157 -> 67
    //   227: astore_0
    //   228: aload_0
    //   229: invokevirtual 202	java/lang/Exception:printStackTrace	()V
    //   232: goto -15 -> 217
    //   235: astore_0
    //   236: goto -68 -> 168
    //   239: astore_1
    //   240: goto -27 -> 213
    //   243: astore_2
    //   244: aconst_null
    //   245: astore_1
    //   246: goto -51 -> 195
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	249	0	paramContext	Context
    //   0	249	1	paramString1	String
    //   0	249	2	paramString2	String
    //   0	249	3	paramString3	String
    //   0	249	4	paramString4	String
    //   34	159	5	localFileInputStream	java.io.FileInputStream
    //   46	131	6	localProperties	java.util.Properties
    //   10	136	7	localFile	File
    //   65	158	8	i	int
    //   1	220	9	j	int
    // Exception table:
    //   from	to	target	type
    //   161	166	167	java/lang/Exception
    //   39	48	191	java/lang/Throwable
    //   51	58	191	java/lang/Throwable
    //   61	67	191	java/lang/Throwable
    //   75	84	191	java/lang/Throwable
    //   87	99	191	java/lang/Throwable
    //   102	111	191	java/lang/Throwable
    //   114	123	191	java/lang/Throwable
    //   126	136	191	java/lang/Throwable
    //   139	154	191	java/lang/Throwable
    //   157	161	191	java/lang/Throwable
    //   176	188	191	java/lang/Throwable
    //   201	205	206	java/lang/Exception
    //   3	12	210	finally
    //   25	36	210	finally
    //   61	67	219	java/lang/Exception
    //   213	217	227	java/lang/Exception
    //   17	25	235	java/lang/Exception
    //   39	48	239	finally
    //   51	58	239	finally
    //   61	67	239	finally
    //   75	84	239	finally
    //   87	99	239	finally
    //   102	111	239	finally
    //   114	123	239	finally
    //   126	136	239	finally
    //   139	154	239	finally
    //   157	161	239	finally
    //   176	188	239	finally
    //   197	201	239	finally
    //   3	12	243	java/lang/Throwable
    //   25	36	243	java/lang/Throwable
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\smtt\sdk\TbsShareManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */