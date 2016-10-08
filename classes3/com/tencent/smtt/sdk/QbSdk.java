package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebIconDatabase;
import android.webkit.WebStorage;
import android.webkit.WebViewDatabase;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.smtt.sdk.ui.dialog.TBSActivityPicker;
import com.tencent.smtt.sdk.ui.dialog.TBSResources;
import com.tencent.smtt.utils.AppUtil;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.ReflectionUtils;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.TbsLogClient;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@SuppressLint({"NewApi"})
public class QbSdk
{
  private static final String AD_WEBVIEW_CLICK_STAT_ENTRYID_FOR_MINIQB = "ad_webview_click_stat_entryid_for_miniqb";
  private static final String AD_WEBVIEW_CLICK_STAT_KEY = "ad_webview_click_stat_key";
  private static final String AD_WEBVIEW_CLICK_STAT_POSID_FOR_QB = "ad_webview_click_stat_posid_for_qb";
  private static final String AD_WEBVIEW_DETAIL_URL = "ad_webview_detail_url";
  private static final int CAN_LOAD_X5_FALSE = -1;
  private static final String EXTENSION_DEX_FILE = "tbs_sdk_extension_dex.jar";
  private static final String EXTENSION_IMPL_CLASS = "com.tencent.tbs.sdk.extension.TbsSDKExtension";
  public static final String FILERADER_MENUDATA = "menuData";
  private static final int IS_X5ENABLE_FALSE = -2;
  private static final String KEY_RESULT_CODE = "result_code";
  private static final String KEY_TBS_CORE_VERSION = "tbs_core_version";
  private static final String KEY_TBS_JARFILES = "tbs_jarfiles";
  private static final String KEY_TBS_LIBRARYPATH = "tbs_librarypath";
  public static final String LOGIN_TYPE_KEY_PARTNER_CALL_POS = "PosID";
  public static final String LOGIN_TYPE_KEY_PARTNER_ID = "ChannelID";
  private static final String MIDPAGEEXTURL = "mttbrowser://miniqb/ch=icon?";
  private static final String MINIQB_HOME_PAGE = "miniqb://home";
  private static final String MINIQB_HOME_PAGE_JUMPQB_URL = "qb://navicard/addCard?cardId=168&cardName=168";
  private static final int MSG_CORE_INITED = 3;
  private static final int MSG_INIT_SYSCORE = 2;
  private static final int MSG_INIT_X5CORE = 1;
  public static final String PARAM_KEY_FEATUREID = "param_key_featureid";
  public static final String PARAM_KEY_FUNCTIONID = "param_key_functionid";
  public static final String PARAM_KEY_POSITIONID = "param_key_positionid";
  private static final int PRELOAD_X5_COUNTER_MAX = 3;
  public static final int SVNVERSION = 400538;
  private static final String TAG = "QbSdk";
  static final int TBS_OLD_CORE_VERSION = 25442;
  static final String TBS_PRELOAD_X5_COUNTER = "tbs_preload_x5_counter";
  static final String TBS_PRELOAD_X5_RECORDER = "tbs_preload_x5_recorder";
  static final String TBS_PRELOAD_X5_VERSION = "tbs_preload_x5_version";
  public static final String TID_QQNumber_Prefix = "QQ:";
  public static final int VERSION = 1;
  private static boolean isPreloadX5Checking;
  private static boolean mDownloadWithoutWifi;
  private static boolean mIsPreInitialized;
  static boolean mIsSysWebViewForced;
  static boolean mIsSysWebViewForcedByOuter;
  private static String mQQBuildNumber;
  static Map<String, Object> mSettings = null;
  private static String mSysWebViewForcedByOuterInfo;
  private static String mSysWebViewForcedInnerInfo;
  private static boolean mTBSInstalling;
  private static String mTID;
  private static TbsListener mTbsListener;
  private static TbsListener mTbsListenerForInit;
  static TbsListener mTbsListenerWrapper;
  static volatile boolean mTmpIsSysWebViewForced;
  static boolean sAllowThirdPartyAppDownload;
  static Object sApnLock;
  static long sApnRecordTime;
  private static Class<?> sExtensionClass;
  private static Object sExtensionObj;
  static boolean sIsApnWifi;
  public static boolean sIsVersionPrinted = false;
  private static String[] sJarFiles;
  static String sLibraryPath;
  private static int sTbsVersion = 0;
  private static String sTbsVersionString = "";
  static long sWifiConnectedTime;
  
  static
  {
    mIsSysWebViewForced = false;
    mIsSysWebViewForcedByOuter = false;
    sAllowThirdPartyAppDownload = false;
    mIsPreInitialized = false;
    mSysWebViewForcedByOuterInfo = "NULL";
    mSysWebViewForcedInnerInfo = "UNKNOWN";
    sIsApnWifi = false;
    sApnRecordTime = 0L;
    sWifiConnectedTime = 0L;
    sApnLock = new Object();
    mTID = null;
    mQQBuildNumber = null;
    mTmpIsSysWebViewForced = mIsSysWebViewForced;
    isPreloadX5Checking = true;
    mTbsListener = null;
    mTbsListenerForInit = null;
    mDownloadWithoutWifi = false;
    mTBSInstalling = false;
    mTbsListenerWrapper = new TbsListener()
    {
      public void onDownloadFinish(int paramAnonymousInt)
      {
        TbsDownloader.mIsDownloading = false;
        if (QbSdk.mTbsListener != null) {
          QbSdk.mTbsListener.onDownloadFinish(paramAnonymousInt);
        }
        if (QbSdk.mTbsListenerForInit != null) {
          QbSdk.mTbsListenerForInit.onDownloadFinish(paramAnonymousInt);
        }
      }
      
      public void onDownloadProgress(int paramAnonymousInt)
      {
        if (QbSdk.mTbsListenerForInit != null) {
          QbSdk.mTbsListenerForInit.onDownloadProgress(paramAnonymousInt);
        }
        if (QbSdk.mTbsListener != null) {
          QbSdk.mTbsListener.onDownloadProgress(paramAnonymousInt);
        }
      }
      
      public void onInstallFinish(int paramAnonymousInt)
      {
        QbSdk.setTBSInstallingStatus(false);
        TbsDownloader.mIsDownloading = false;
        if (QbSdk.mTbsListener != null) {
          QbSdk.mTbsListener.onInstallFinish(paramAnonymousInt);
        }
        if (QbSdk.mTbsListenerForInit != null) {
          QbSdk.mTbsListenerForInit.onInstallFinish(paramAnonymousInt);
        }
      }
    };
  }
  
  public static void allowThirdPartyAppDownload(boolean paramBoolean)
  {
    sAllowThirdPartyAppDownload = paramBoolean;
  }
  
  public static boolean canLoadVideo(Context paramContext)
  {
    Object localObject = ReflectionUtils.invokeInstance(sExtensionObj, "canLoadVideo", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(0) });
    if (localObject != null) {
      if (!((Boolean)localObject).booleanValue()) {
        TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 313);
      }
    }
    while (localObject == null)
    {
      return false;
      TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 314);
    }
    return ((Boolean)localObject).booleanValue();
  }
  
  static boolean canLoadX5(Context paramContext, boolean paramBoolean)
  {
    return canLoadX5(paramContext, paramBoolean, false);
  }
  
  static boolean canLoadX5(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 1;
    boolean bool2 = false;
    boolean bool1 = false;
    paramBoolean2 = false;
    if ((TbsShareManager.isThirdPartyApp(paramContext)) && (!TbsShareManager.isShareTbsCoreAvailableInner(paramContext)))
    {
      TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 302);
      paramBoolean1 = paramBoolean2;
      return paramBoolean1;
    }
    if (!init(paramContext, paramBoolean1))
    {
      TbsLog.e("QbSdk", "QbSdk.init failure!");
      return false;
    }
    Object localObject1 = ReflectionUtils.invokeInstance(sExtensionObj, "canLoadX5Core", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(36548) });
    label339:
    int i;
    if (localObject1 != null)
    {
      if (((localObject1 instanceof String)) && (((String)localObject1).equalsIgnoreCase("AuthenticationFail")))
      {
        TbsLog.e("loaderror", "317");
        return false;
      }
      if (!(localObject1 instanceof Bundle))
      {
        TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 330, new Throwable("" + localObject1));
        TbsLog.e("loaderror", "ret not instance of bundle");
        return false;
      }
      localObject1 = (Bundle)localObject1;
      int k = ((Bundle)localObject1).getInt("result_code", -1);
      if (k == 0)
      {
        paramBoolean1 = true;
        if (!TbsShareManager.isThirdPartyApp(paramContext)) {
          break label339;
        }
        SDKEngine.setTbsCoreVersion(TbsShareManager.getAvailableTbsCoreVersion(paramContext));
        sTbsVersionString = String.valueOf(TbsShareManager.getAvailableTbsCoreVersion(paramContext));
        if (sTbsVersionString.length() == 5) {
          sTbsVersionString = "0" + sTbsVersionString;
        }
        if (sTbsVersionString.length() != 6) {
          sTbsVersionString = "";
        }
      }
      for (;;)
      {
        try
        {
          sJarFiles = ((Bundle)localObject1).getStringArray("tbs_jarfiles");
          if ((sJarFiles instanceof String[])) {
            break label571;
          }
          TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 307, new Throwable("sJarFiles not instanceof String[]: " + sJarFiles));
          return false;
        }
        catch (Throwable localThrowable)
        {
          TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 329, localThrowable);
          return false;
        }
        paramBoolean1 = false;
        break;
        if (Build.VERSION.SDK_INT >= 12) {
          sTbsVersionString = ((Bundle)localObject1).getString("tbs_core_version", "0");
        }
        try
        {
          sTbsVersion = Integer.parseInt(sTbsVersionString);
          SDKEngine.setTbsCoreVersion(sTbsVersion);
          if (sTbsVersion == 0)
          {
            TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 307, new Throwable("sTbsVersion is 0"));
            return false;
            sTbsVersionString = ((Bundle)localObject1).getString("tbs_core_version");
            if (sTbsVersionString != null) {
              continue;
            }
            sTbsVersionString = "0";
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          sTbsVersion = 0;
          continue;
          if (sTbsVersion > 0)
          {
            i = j;
            if (sTbsVersion <= 25442) {}
          }
          else
          {
            if (sTbsVersion != 25472) {
              continue;
            }
            i = j;
          }
          if (i != 0)
          {
            TbsLog.e("TbsDownload", "is_obsolete --> delete old core:" + sTbsVersion);
            FileUtil.delete(TbsInstaller.getInstance().getTbsCoreShareDir(paramContext));
            TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 307, new Throwable("is_obsolete --> delete old core:" + sTbsVersion));
            return false;
            i = 0;
          }
        }
      }
      label571:
      sLibraryPath = localThrowable.getString("tbs_librarypath");
      switch (k)
      {
      default: 
        label604:
        paramBoolean2 = paramBoolean1;
      }
    }
    for (;;)
    {
      paramBoolean1 = paramBoolean2;
      if (paramBoolean2) {
        break;
      }
      TbsLog.e("loaderror", "319");
      return paramBoolean2;
      Object localObject2 = null;
      try
      {
        Object localObject3 = ReflectionUtils.invokeInstance(sExtensionObj, "getErrorCodeForLogReport", new Class[0], new Object[0]);
        localObject2 = localObject3;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
      TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 307, new Throwable("detail: " + localObject2));
      break label604;
      if (!TbsShareManager.isThirdPartyApp(paramContext)) {
        break label604;
      }
      TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 404);
      break label604;
      localObject2 = sExtensionObj;
      Class localClass = Integer.TYPE;
      i = DeviceInfo.getTotalRAM();
      localObject2 = ReflectionUtils.invokeInstance(localObject2, "canLoadX5", new Class[] { localClass }, new Object[] { Integer.valueOf(i) });
      if (localObject2 != null)
      {
        if (((localObject2 instanceof String)) && (((String)localObject2).equalsIgnoreCase("AuthenticationFail")))
        {
          TbsLog.e("loaderror", "317");
          return false;
        }
        paramBoolean2 = bool2;
        if (!(localObject2 instanceof Boolean)) {
          continue;
        }
        sTbsVersion = SDKEngine.getTbsCoreVersion();
        bool2 = isX5Disabled(paramContext, SDKEngine.getTbsCoreVersion());
        paramBoolean2 = bool1;
        if (((Boolean)localObject2).booleanValue())
        {
          paramBoolean2 = bool1;
          if (!bool2) {
            paramBoolean2 = true;
          }
        }
        paramBoolean1 = paramBoolean2;
        if (paramBoolean2) {
          break;
        }
        TbsLog.e("loaderror", "318");
        TbsLog.w("loaderror", "isX5Disable:" + bool2);
        TbsLog.w("loaderror", "(Boolean) ret:" + (Boolean)localObject2);
        return paramBoolean2;
      }
      TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 308);
      paramBoolean2 = bool2;
    }
  }
  
  public static void canOpenFile(Context paramContext, final String paramString, final ValueCallback<Boolean> paramValueCallback)
  {
    new Thread()
    {
      public void run()
      {
        X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
        localX5CoreEngine.init(this.val$context);
        final boolean bool = false;
        if (localX5CoreEngine.isX5Core()) {
          bool = localX5CoreEngine.wizard().canOpenFile(this.val$context, paramString);
        }
        new Handler(Looper.getMainLooper()).post(new Runnable()
        {
          public void run()
          {
            QbSdk.1.this.val$callback.onReceiveValue(Boolean.valueOf(bool));
          }
        });
      }
    }.start();
  }
  
  public static boolean canOpenMimeFileType(Context paramContext, String paramString)
  {
    if (!init(paramContext, false)) {}
    return false;
  }
  
  public static boolean canUseVideoFeatrue(Context paramContext, int paramInt)
  {
    paramContext = ReflectionUtils.invokeInstance(sExtensionObj, "canUseVideoFeatrue", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(paramInt) });
    if ((paramContext != null) && ((paramContext instanceof Boolean))) {
      return ((Boolean)paramContext).booleanValue();
    }
    return false;
  }
  
  public static void clear(Context paramContext) {}
  
  public static void clearAllWebViewCache(Context paramContext, boolean paramBoolean)
  {
    try
    {
      new android.webkit.WebView(paramContext).clearCache(true);
      if (paramBoolean)
      {
        CookieSyncManager.createInstance(paramContext);
        CookieManager.getInstance().removeAllCookie();
      }
      WebViewDatabase.getInstance(paramContext).clearUsernamePassword();
      WebViewDatabase.getInstance(paramContext).clearHttpAuthUsernamePassword();
      WebViewDatabase.getInstance(paramContext).clearFormData();
      WebStorage.getInstance().deleteAllData();
      WebIconDatabase.getInstance().removeAllIcons();
      X5CoreEngine localX5CoreEngine;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        try
        {
          if (new WebView(paramContext).getWebViewClientExtension() != null)
          {
            localX5CoreEngine = X5CoreEngine.getInstance();
            if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core())) {
              localX5CoreEngine.wizard().clearAllX5Cache(paramContext, paramBoolean);
            }
          }
          return;
        }
        catch (Throwable paramContext) {}
        localThrowable = localThrowable;
        TbsLog.e("QbSdk", "clearAllWebViewCache exception 1 -- " + Log.getStackTraceString(localThrowable));
      }
    }
  }
  
  public static void closeFileReader(Context paramContext)
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    localX5CoreEngine.init(paramContext);
    if (localX5CoreEngine.isX5Core()) {
      localX5CoreEngine.wizard().closeFileReader();
    }
  }
  
  public static boolean createMiniQBShortCut(Context paramContext, String paramString1, String paramString2, Drawable paramDrawable)
  {
    if (paramContext == null) {
      return false;
    }
    if (TbsDownloader.getOverSea(paramContext)) {
      return false;
    }
    if (isMiniQBShortCutExist(paramContext, paramString1, paramString2) == true) {
      return false;
    }
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core()))
    {
      Bitmap localBitmap = null;
      if ((paramDrawable instanceof BitmapDrawable)) {
        localBitmap = ((BitmapDrawable)paramDrawable).getBitmap();
      }
      paramDrawable = localX5CoreEngine.wizard().dexLoader();
      TbsLog.e("QbSdk", "qbsdk createMiniQBShortCut");
      paramContext = paramDrawable.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createMiniQBShortCut", new Class[] { Context.class, String.class, String.class, Bitmap.class }, new Object[] { paramContext, paramString1, paramString2, localBitmap });
      TbsLog.e("QbSdk", "qbsdk after createMiniQBShortCut ret: " + paramContext);
      return paramContext != null;
    }
    return false;
  }
  
  public static boolean deleteMiniQBShortCut(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null) {}
    X5CoreEngine localX5CoreEngine;
    do
    {
      do
      {
        do
        {
          return false;
        } while (TbsDownloader.getOverSea(paramContext));
        localX5CoreEngine = X5CoreEngine.getInstance();
      } while ((localX5CoreEngine == null) || (!localX5CoreEngine.isX5Core()));
    } while (localX5CoreEngine.wizard().dexLoader().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "deleteMiniQBShortCut", new Class[] { Context.class, String.class, String.class }, new Object[] { paramContext, paramString1, paramString2 }) == null);
    return true;
  }
  
  public static void forceSysWebView()
  {
    mIsSysWebViewForcedByOuter = true;
    mSysWebViewForcedByOuterInfo = "SysWebViewForcedByOuter: " + Log.getStackTraceString(new Throwable());
    TbsLog.e("QbSdk", "sys WebView: SysWebViewForcedByOuter");
  }
  
  /* Error */
  static void forceSysWebViewInner(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 170	com/tencent/smtt/sdk/QbSdk:mIsSysWebViewForced	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: iconst_1
    //   16: putstatic 170	com/tencent/smtt/sdk/QbSdk:mIsSysWebViewForced	Z
    //   19: new 309	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 310	java/lang/StringBuilder:<init>	()V
    //   26: ldc_w 592
    //   29: invokevirtual 314	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_1
    //   33: invokevirtual 314	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 321	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: putstatic 184	com/tencent/smtt/sdk/QbSdk:mSysWebViewForcedInnerInfo	Ljava/lang/String;
    //   42: ldc 107
    //   44: new 309	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 310	java/lang/StringBuilder:<init>	()V
    //   51: ldc_w 594
    //   54: invokevirtual 314	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: getstatic 184	com/tencent/smtt/sdk/QbSdk:mSysWebViewForcedInnerInfo	Ljava/lang/String;
    //   60: invokevirtual 314	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 321	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 290	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: invokestatic 256	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   72: aload_0
    //   73: sipush 401
    //   76: new 267	java/lang/Throwable
    //   79: dup
    //   80: getstatic 184	com/tencent/smtt/sdk/QbSdk:mSysWebViewForcedInnerInfo	Ljava/lang/String;
    //   83: invokespecial 324	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   86: invokevirtual 327	com/tencent/smtt/sdk/TbsCoreLoadStat:setLoadErrorCode	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   89: goto -78 -> 11
    //   92: astore_0
    //   93: ldc 2
    //   95: monitorexit
    //   96: aload_0
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	paramContext	Context
    //   0	98	1	paramString	String
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	7	92	finally
    //   15	89	92	finally
  }
  
  public static long getApkFileSize(Context paramContext)
  {
    long l = 0L;
    if (paramContext != null) {
      l = TbsDownloadConfig.getInstance(paramContext.getApplicationContext()).mPreferences.getLong("tbs_apkfilesize", 0L);
    }
    return l;
  }
  
  public static String[] getDexLoaderFileList(Context paramContext1, Context paramContext2, String paramString)
  {
    int i = 0;
    if ((sJarFiles instanceof String[]))
    {
      int j = sJarFiles.length;
      paramContext2 = new String[j];
      for (;;)
      {
        paramContext1 = paramContext2;
        if (i >= j) {
          break;
        }
        paramContext2[i] = (paramString + sJarFiles[i]);
        i += 1;
      }
    }
    paramContext1 = ReflectionUtils.invokeInstance(sExtensionObj, "getJarFiles", new Class[] { Context.class, Context.class, String.class }, new Object[] { paramContext1, paramContext2, paramString });
    if ((paramContext1 instanceof String[])) {}
    for (;;)
    {
      paramContext1 = (String[])paramContext1;
      return paramContext1;
      paramContext1 = "";
    }
  }
  
  public static boolean getDownloadWithoutWifi()
  {
    return mDownloadWithoutWifi;
  }
  
  public static String getMiniQBVersion()
  {
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core())) {
      return localX5CoreEngine.wizard().getMiniQBVersion();
    }
    return null;
  }
  
  public static String getQQBuildNumber()
  {
    return mQQBuildNumber;
  }
  
  public static boolean getTBSInstalling()
  {
    return mTBSInstalling;
  }
  
  public static String getTID()
  {
    return mTID;
  }
  
  static String getTbsCoreVersionString()
  {
    return sTbsVersionString;
  }
  
  public static int getTbsVersion(Context paramContext)
  {
    if (TbsShareManager.isThirdPartyApp(paramContext)) {
      return TbsShareManager.getAvailableTbsCoreVersion(paramContext);
    }
    return TbsInstaller.getInstance().getTbsCoreInstalledVerInNolock(paramContext);
  }
  
  public static String getX5CoreTimestamp()
  {
    Object localObject = ReflectionUtils.invokeStatic(sExtensionClass, "getX5CoreTimestamp", null, new Object[0]);
    if (localObject == null) {
      return "";
    }
    return (String)localObject;
  }
  
  static Bundle incrUpdate(Context paramContext, Bundle paramBundle)
    throws Exception
  {
    if (!initForPatch(paramContext))
    {
      TbsLogReport.getInstance(paramContext).setInstallErrorCode(216, "initForPatch return false!");
      return null;
    }
    paramBundle = ReflectionUtils.invokeInstance(sExtensionObj, "incrUpdate", new Class[] { Context.class, Bundle.class }, new Object[] { paramContext, paramBundle });
    if (paramBundle != null) {
      return (Bundle)paramBundle;
    }
    TbsLogReport.getInstance(paramContext).setInstallErrorCode(216, "incrUpdate return null!");
    return null;
  }
  
  @SuppressLint({"NewApi"})
  private static boolean init(Context paramContext, boolean paramBoolean)
  {
    TbsLog.initIfNeed(paramContext);
    if (!sIsVersionPrinted)
    {
      TbsLog.i("QbSdk", "svn revision: 400538; SDK_VERSION_CODE: 36548; SDK_VERSION_NAME: 2.2.0.1095");
      sIsVersionPrinted = true;
    }
    if ((mIsSysWebViewForced) && (!paramBoolean))
    {
      TbsLog.e("QbSdk", "QbSdk init: " + mSysWebViewForcedInnerInfo, false);
      return false;
    }
    if (mIsSysWebViewForcedByOuter)
    {
      TbsLog.e("QbSdk", "QbSdk init mIsSysWebViewForcedByOuter = true", true);
      TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 402, new Throwable(mSysWebViewForcedByOuterInfo));
      return false;
    }
    if (!isPreloadX5Checking) {
      preloadX5Check(paramContext);
    }
    Object localObject2;
    try
    {
      localObject2 = TbsInstaller.getInstance().getTbsCoreShareDir(paramContext);
      if (localObject2 == null)
      {
        TbsLog.e("QbSdk", "QbSdk init (false) optDir == null");
        TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 312, new Throwable("QbSdk.init (false) TbsCoreShareDir is null"));
        return false;
      }
    }
    catch (Throwable localThrowable)
    {
      TbsLog.e("QbSdk", "QbSdk init Throwable: " + Log.getStackTraceString(localThrowable));
      TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 306, localThrowable);
      return false;
    }
    int j;
    Object localObject1;
    if (TbsShareManager.isThirdPartyApp(paramContext))
    {
      if ((sTbsVersion != 0) && (sTbsVersion != TbsShareManager.getAvailableTbsCoreVersion(paramContext)))
      {
        sExtensionClass = null;
        sExtensionObj = null;
        TbsLog.e("QbSdk", "QbSdk init (false) ERROR_UNMATCH_TBSCORE_VER_THIRDPARTY!");
        TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 302, new Throwable("sTbsVersion: " + sTbsVersion + "; AvailableTbsCoreVersion: " + TbsShareManager.getAvailableTbsCoreVersion(paramContext)));
        return false;
      }
      sTbsVersion = TbsShareManager.getAvailableTbsCoreVersion(paramContext);
      if (sExtensionClass != null) {
        return true;
      }
    }
    else
    {
      if (sTbsVersion == 0) {
        break label892;
      }
      j = TbsInstaller.getInstance().getTbsCoreInstalledVerInNolock(paramContext);
      i = j;
      if (sTbsVersion != j)
      {
        if (j != 88888888)
        {
          sExtensionClass = null;
          sExtensionObj = null;
          TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp tbsCoreInstalledVer=" + j, true);
          TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp sTbsVersion=" + sTbsVersion, true);
          TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 303, new Throwable("sTbsVersion: " + sTbsVersion + "; tbsCoreInstalledVer: " + j));
          return false;
        }
        localObject1 = new File(paramContext.getDir("tbs", 0), "core_private");
        i = j;
        if (localObject1 != null)
        {
          i = j;
          if (((File)localObject1).isDirectory())
          {
            localObject1 = new File((File)localObject1, "tbs_extension.conf");
            i = j;
            if (((File)localObject1).exists())
            {
              ((File)localObject1).delete();
              TbsLog.i("QbSdk", "LOCAL_SDCARD_TBS_VERSION --> (" + ((File)localObject1).getName() + ") is deleted!", true);
            }
          }
        }
      }
    }
    label892:
    for (int i = j;; i = 0)
    {
      sTbsVersion = i;
      break;
      if (TbsShareManager.isThirdPartyApp(paramContext)) {
        if (!TbsShareManager.isShareTbsCoreAvailable(paramContext)) {}
      }
      for (localObject1 = new File(TbsShareManager.getAvailableTbsCorePath(paramContext), "tbs_sdk_extension_dex.jar"); !((File)localObject1).exists(); localObject1 = new File(TbsInstaller.getInstance().getTbsCoreShareDir(paramContext), "tbs_sdk_extension_dex.jar"))
      {
        TbsLog.e("QbSdk", "QbSdk init (false) tbs_sdk_extension_dex.jar is not exist!");
        TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 403, new Exception("QbSdk.init false, tbs_sdk_extension_dex not exist(NO tbs core)!"));
        return false;
        TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 304, new Throwable("isShareTbsCoreAvailable false!"));
        return false;
      }
      sExtensionClass = new DexClassLoader(((File)localObject1).getAbsolutePath(), ((File)localObject2).getAbsolutePath(), ((File)localObject1).getAbsolutePath(), QbSdk.class.getClassLoader()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
      localObject1 = sExtensionClass.getConstructor(new Class[] { Context.class, Context.class });
      if (TbsShareManager.isThirdPartyApp(paramContext)) {}
      for (sExtensionObj = ((Constructor)localObject1).newInstance(new Object[] { paramContext, TbsShareManager.getAvailableTbsCoreHostContext(paramContext) });; sExtensionObj = ((Constructor)localObject1).newInstance(new Object[] { paramContext, paramContext }))
      {
        localObject1 = sExtensionObj;
        localObject2 = AppUtil.mImei;
        String str1 = AppUtil.mImsi;
        String str2 = AppUtil.mCpu;
        String str3 = AppUtil.mMac;
        ReflectionUtils.invokeInstance(localObject1, "putInfo", new Class[] { String.class, String.class, String.class, String.class }, new Object[] { localObject2, str1, str2, str3 });
        ReflectionUtils.invokeInstance(sExtensionObj, "setClientVersion", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(1) });
        return true;
      }
    }
  }
  
  static boolean initForPatch(Context paramContext)
  {
    try
    {
      if (sExtensionClass != null) {
        return true;
      }
      File localFile1 = TbsInstaller.getInstance().getTbsCoreShareDir(paramContext);
      if (localFile1 == null)
      {
        TbsLog.e("QbSdk", "QbSdk initForPatch (false) optDir == null");
        return false;
      }
      File localFile2 = new File(localFile1, "tbs_sdk_extension_dex.jar");
      if (!localFile2.exists())
      {
        TbsLog.e("QbSdk", "QbSdk initForPatch (false) dexFile.exists()=false", true);
        return false;
      }
      sExtensionClass = new DexClassLoader(localFile2.getAbsolutePath(), localFile1.getAbsolutePath(), localFile2.getAbsolutePath(), QbSdk.class.getClassLoader()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
      sExtensionObj = sExtensionClass.getConstructor(new Class[] { Context.class, Context.class }).newInstance(new Object[] { paramContext, paramContext });
      return true;
    }
    catch (Throwable paramContext)
    {
      TbsLog.e("QbSdk", "initForPatch sys WebView: " + Log.getStackTraceString(paramContext));
    }
    return false;
  }
  
  private static boolean initForX5DisableConfig(Context paramContext)
  {
    Object localObject2;
    try
    {
      if (sExtensionClass != null) {
        return true;
      }
      localObject2 = TbsInstaller.getInstance().getTbsCoreShareDir(paramContext);
      if (localObject2 == null)
      {
        TbsLog.e("QbSdk", "QbSdk initForX5DisableConfig (false) optDir == null");
        return false;
      }
      if (TbsShareManager.isThirdPartyApp(paramContext)) {
        if (!TbsShareManager.isShareTbsCoreAvailable(paramContext)) {}
      }
      for (localObject1 = new File(TbsShareManager.getAvailableTbsCorePath(paramContext), "tbs_sdk_extension_dex.jar"); !((File)localObject1).exists(); localObject1 = new File(TbsInstaller.getInstance().getTbsCoreShareDir(paramContext), "tbs_sdk_extension_dex.jar"))
      {
        TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 403, new Exception("initForX5DisableConfig failure -- tbs_sdk_extension_dex.jar is not exist!"));
        return false;
        TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 1001);
        return false;
      }
      sExtensionClass = new DexClassLoader(((File)localObject1).getAbsolutePath(), ((File)localObject2).getAbsolutePath(), ((File)localObject1).getAbsolutePath(), QbSdk.class.getClassLoader()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
    }
    catch (Throwable paramContext)
    {
      TbsLog.e("QbSdk", "initForX5DisableConfig sys WebView: " + Log.getStackTraceString(paramContext));
      return false;
    }
    Object localObject1 = sExtensionClass.getConstructor(new Class[] { Context.class, Context.class });
    if (TbsShareManager.isThirdPartyApp(paramContext)) {}
    for (sExtensionObj = ((Constructor)localObject1).newInstance(new Object[] { paramContext, TbsShareManager.getAvailableTbsCoreHostContext(paramContext) });; sExtensionObj = ((Constructor)localObject1).newInstance(new Object[] { paramContext, paramContext }))
    {
      paramContext = sExtensionObj;
      localObject1 = AppUtil.mImei;
      localObject2 = AppUtil.mImsi;
      String str1 = AppUtil.mCpu;
      String str2 = AppUtil.mMac;
      ReflectionUtils.invokeInstance(paramContext, "putInfo", new Class[] { String.class, String.class, String.class, String.class }, new Object[] { localObject1, localObject2, str1, str2 });
      ReflectionUtils.invokeInstance(sExtensionObj, "setClientVersion", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(1) });
      return true;
    }
  }
  
  public static void initTbsSettings(Map<String, Object> paramMap)
  {
    mSettings = paramMap;
  }
  
  public static void initX5Environment(final Context paramContext, WebviewInitType paramWebviewInitType, final PreInitCallback paramPreInitCallback)
  {
    if ((paramWebviewInitType == WebviewInitType.FIRSTUSE_ONLY) || (paramWebviewInitType == WebviewInitType.FIRSTUSE_AND_PRELOAD))
    {
      if (paramWebviewInitType == WebviewInitType.FIRSTUSE_AND_PRELOAD) {
        mTbsListenerForInit = new TbsListener()
        {
          public void onDownloadFinish(int paramAnonymousInt) {}
          
          public void onDownloadProgress(int paramAnonymousInt) {}
          
          public void onInstallFinish(int paramAnonymousInt)
          {
            QbSdk.preInit(this.val$context, paramPreInitCallback, Boolean.valueOf(false));
          }
        };
      }
      TbsDownloader.needDownload(paramContext, false, new ICommonCallback()
      {
        public void onFinished()
        {
          if (this.val$type == QbSdk.WebviewInitType.FIRSTUSE_AND_PRELOAD) {
            QbSdk.preInit(paramContext, paramPreInitCallback, Boolean.valueOf(false));
          }
        }
      });
      return;
    }
    preInit(paramContext, paramPreInitCallback, Boolean.valueOf(false));
  }
  
  public static boolean installLocalQbApk(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(true);
    localSDKEngine.init(paramContext);
    if ((localSDKEngine != null) && (localSDKEngine.isTbsAvailable())) {
      return localSDKEngine.wizard().installLocalQbApk(paramContext, paramString1, paramString2, paramBundle);
    }
    return false;
  }
  
  public static boolean intentDispatch(WebView paramWebView, Intent paramIntent, String paramString1, String paramString2)
  {
    if (paramWebView == null) {
      return false;
    }
    Context localContext;
    int i;
    if (paramString1.startsWith("mttbrowser://miniqb/ch=icon?"))
    {
      localContext = paramWebView.getContext();
      i = paramString1.indexOf("url=");
      if (i <= 0) {
        break label180;
      }
    }
    label180:
    for (paramIntent = paramString1.substring(i + 4);; paramIntent = null)
    {
      HashMap localHashMap = new HashMap();
      paramString1 = "unknown";
      try
      {
        String str = localContext.getApplicationInfo().packageName;
        paramString1 = str;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
        paramWebView.loadUrl(paramIntent);
      }
      localHashMap.put("ChannelID", paramString1);
      localHashMap.put("PosID", "14004");
      if ("miniqb://home".equals(paramIntent)) {}
      for (paramString1 = "qb://navicard/addCard?cardId=168&cardName=168";; paramString1 = paramIntent)
      {
        if (MttLoader.loadUrl(localContext, paramString1, localHashMap, "QbSdk.startMiniQBToLoadUrl", null) != 0)
        {
          paramString1 = X5CoreEngine.getInstance();
          if ((paramString1 != null) && (paramString1.isX5Core()) && (paramString1.wizard().startMiniQB(localContext, paramIntent, null, paramString2, null) == 0)) {
            return true;
          }
        }
        for (;;)
        {
          return false;
          paramWebView.loadUrl(paramString1);
        }
      }
    }
  }
  
  public static boolean isMiniQBShortCutExist(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null) {
      return false;
    }
    if (TbsDownloader.getOverSea(paramContext)) {
      return false;
    }
    paramString2 = X5CoreEngine.getInstance();
    if ((paramString2 != null) && (paramString2.isX5Core()))
    {
      paramContext = paramString2.wizard().dexLoader().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "isMiniQBShortCutExist", new Class[] { Context.class, String.class }, new Object[] { paramContext, paramString1 });
      if (paramContext != null) {
        if (!(paramContext instanceof Boolean)) {
          break label100;
        }
      }
    }
    label100:
    for (paramContext = (Boolean)paramContext;; paramContext = Boolean.valueOf(false))
    {
      return paramContext.booleanValue();
      return false;
      return false;
    }
  }
  
  public static boolean isSdkVideoServiceFg(Context paramContext)
  {
    try
    {
      paramContext = ((ActivityManager)paramContext.getApplicationContext().getSystemService("activity")).getRunningAppProcesses();
      if ((paramContext == null) || (paramContext.size() == 0)) {
        break label123;
      }
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if ((localRunningAppProcessInfo.importance == 100) && (localRunningAppProcessInfo.processName != null))
        {
          boolean bool = localRunningAppProcessInfo.processName.contains("com.tencent.mtt:VideoService");
          if (bool) {
            return true;
          }
        }
      }
    }
    catch (Throwable paramContext)
    {
      TbsLog.e("QbSdk", "isSdkVideoServiceFg Exception: " + Log.getStackTraceString(paramContext));
    }
    return false;
    label123:
    return false;
  }
  
  public static boolean isTbsCoreInited()
  {
    boolean bool2 = false;
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    boolean bool1 = bool2;
    if (localSDKEngine != null)
    {
      bool1 = bool2;
      if (localSDKEngine.isInited()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  static boolean isX5Disabled(Context paramContext, int paramInt)
  {
    return isX5Disabled(paramContext, paramInt, 20000);
  }
  
  static boolean isX5Disabled(Context paramContext, int paramInt1, int paramInt2)
  {
    if (!initForX5DisableConfig(paramContext)) {
      return true;
    }
    paramContext = ReflectionUtils.invokeInstance(sExtensionObj, "isX5Disabled", new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(36548), Integer.valueOf(paramInt2) });
    if (paramContext != null) {
      return ((Boolean)paramContext).booleanValue();
    }
    paramContext = ReflectionUtils.invokeInstance(sExtensionObj, "isX5Disabled", new Class[] { Integer.TYPE, Integer.TYPE }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(36548) });
    if (paramContext != null) {
      return ((Boolean)paramContext).booleanValue();
    }
    return true;
  }
  
  public static boolean isX5DisabledSync(Context paramContext)
  {
    if (TbsCoreVerManager.getInstance(paramContext).getTbsCoreInstallStatus() == 2) {}
    for (int i = 1; i != 0; i = 0) {
      return false;
    }
    if (!initForX5DisableConfig(paramContext)) {
      return true;
    }
    i = TbsInstaller.getInstance().getTbsCoreInstalledVerInNolock(paramContext);
    paramContext = ReflectionUtils.invokeInstance(sExtensionObj, "isX5DisabledSync", new Class[] { Integer.TYPE, Integer.TYPE }, new Object[] { Integer.valueOf(i), Integer.valueOf(36548) });
    if (paramContext != null) {
      return ((Boolean)paramContext).booleanValue();
    }
    return true;
  }
  
  public static int openFileReader(Context paramContext, String paramString, HashMap<String, String> paramHashMap, ValueCallback<String> paramValueCallback)
  {
    if (paramString != null)
    {
      localObject = paramString.substring(paramString.lastIndexOf(".") + 1, paramString.length());
      if ((MttLoader.isBrowserInstalled(paramContext)) && (startQBForDoc(paramContext, paramString, 4, 0, (String)localObject, parseMenuData(paramContext, paramHashMap))))
      {
        if (paramValueCallback != null) {
          paramValueCallback.onReceiveValue("open QB");
        }
        return 1;
      }
    }
    else
    {
      if (paramValueCallback != null) {
        paramValueCallback.onReceiveValue("filepath error");
      }
      return -1;
    }
    Object localObject = paramHashMap;
    if (paramHashMap == null) {
      localObject = new HashMap();
    }
    ((HashMap)localObject).put("local", "true");
    if (startMiniQBToLoadUrl(paramContext, paramString, (HashMap)localObject, paramValueCallback) < 0)
    {
      if ((!paramContext.getApplicationInfo().packageName.equals("com.tencent.rtxlite")) && (!paramContext.getApplicationInfo().packageName.equals("com.tencent.tim"))) {
        openFileReaderListWithQBDownload(paramContext, paramString, paramValueCallback);
      }
      return 3;
    }
    return 2;
  }
  
  public static void openFileReaderListWithQBDownload(Context paramContext, String paramString, ValueCallback<String> paramValueCallback)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addCategory("android.intent.category.DEFAULT");
    localIntent.setDataAndType(Uri.fromFile(new File(paramString)), TBSResources.getMIMEType(paramString));
    paramString = new TBSActivityPicker(paramContext, "选择其它应用打开", localIntent, paramValueCallback);
    String str = paramString.getTBSPickedDefaultBrowser();
    if ((str != null) && (!TextUtils.isEmpty(str)))
    {
      localIntent.setPackage(str);
      paramContext.startActivity(localIntent);
      if (paramValueCallback != null) {
        paramValueCallback.onReceiveValue("default browser:" + str);
      }
      return;
    }
    paramString.show();
    paramString.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        if (this.val$callback != null) {
          this.val$callback.onReceiveValue("TbsReaderDialogClosed");
        }
      }
    });
  }
  
  /* Error */
  private static Bundle parseMenuData(Context paramContext, Map<String, String> paramMap)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 307	android/os/Bundle
    //   9: dup
    //   10: invokespecial 1085	android/os/Bundle:<init>	()V
    //   13: astore_3
    //   14: aload_1
    //   15: ldc_w 1087
    //   18: invokeinterface 1093 2 0
    //   23: ifnonnull +171 -> 194
    //   26: ldc_w 352
    //   29: astore_2
    //   30: aload_3
    //   31: ldc_w 1087
    //   34: aload_2
    //   35: invokevirtual 1096	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: aload_3
    //   39: ldc_w 1098
    //   42: aload_1
    //   43: ldc_w 1098
    //   46: invokeinterface 1093 2 0
    //   51: checkcast 295	java/lang/String
    //   54: invokestatic 1103	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   57: invokevirtual 1107	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   60: aload_1
    //   61: ifnull +168 -> 229
    //   64: aload_1
    //   65: ldc 57
    //   67: invokeinterface 1110 2 0
    //   72: ifeq +157 -> 229
    //   75: new 1112	org/json/JSONObject
    //   78: dup
    //   79: aload_1
    //   80: ldc 57
    //   82: invokeinterface 1093 2 0
    //   87: checkcast 295	java/lang/String
    //   90: invokespecial 1113	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   93: astore_1
    //   94: aload_1
    //   95: ldc_w 1115
    //   98: invokevirtual 1119	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   101: astore_2
    //   102: aload_2
    //   103: ifnull +116 -> 219
    //   106: new 1121	java/util/ArrayList
    //   109: dup
    //   110: invokespecial 1122	java/util/ArrayList:<init>	()V
    //   113: astore 4
    //   115: iconst_0
    //   116: istore 6
    //   118: aload_2
    //   119: invokevirtual 1125	org/json/JSONArray:length	()I
    //   122: istore 7
    //   124: iload 6
    //   126: iload 7
    //   128: if_icmpge +82 -> 210
    //   131: aload_2
    //   132: iload 6
    //   134: invokevirtual 1128	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   137: checkcast 1112	org/json/JSONObject
    //   140: astore 5
    //   142: aload 5
    //   144: ldc_w 1130
    //   147: invokevirtual 1132	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   150: istore 7
    //   152: aload 4
    //   154: iload 6
    //   156: aload_0
    //   157: invokevirtual 1136	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   160: iload 7
    //   162: invokevirtual 1142	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   165: checkcast 555	android/graphics/drawable/BitmapDrawable
    //   168: invokevirtual 559	android/graphics/drawable/BitmapDrawable:getBitmap	()Landroid/graphics/Bitmap;
    //   171: invokevirtual 1146	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   174: aload 5
    //   176: ldc_w 1130
    //   179: iload 6
    //   181: invokevirtual 1149	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   184: pop
    //   185: iload 6
    //   187: iconst_1
    //   188: iadd
    //   189: istore 6
    //   191: goto -73 -> 118
    //   194: aload_1
    //   195: ldc_w 1087
    //   198: invokeinterface 1093 2 0
    //   203: checkcast 295	java/lang/String
    //   206: astore_2
    //   207: goto -177 -> 30
    //   210: aload_3
    //   211: ldc_w 1151
    //   214: aload 4
    //   216: invokevirtual 1155	android/os/Bundle:putParcelableArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   219: aload_3
    //   220: ldc 57
    //   222: aload_1
    //   223: invokevirtual 1156	org/json/JSONObject:toString	()Ljava/lang/String;
    //   226: invokevirtual 1096	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   229: aload_3
    //   230: areturn
    //   231: astore_0
    //   232: aload_0
    //   233: invokevirtual 412	java/lang/Exception:printStackTrace	()V
    //   236: aconst_null
    //   237: areturn
    //   238: astore 5
    //   240: goto -55 -> 185
    //   243: astore_2
    //   244: goto -184 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	247	0	paramContext	Context
    //   0	247	1	paramMap	Map<String, String>
    //   29	178	2	localObject	Object
    //   243	1	2	localException1	Exception
    //   13	217	3	localBundle	Bundle
    //   113	102	4	localArrayList	java.util.ArrayList
    //   140	35	5	localJSONObject	org.json.JSONObject
    //   238	1	5	localException2	Exception
    //   116	74	6	i	int
    //   122	39	7	j	int
    // Exception table:
    //   from	to	target	type
    //   6	26	231	java/lang/Exception
    //   30	38	231	java/lang/Exception
    //   64	102	231	java/lang/Exception
    //   106	115	231	java/lang/Exception
    //   118	124	231	java/lang/Exception
    //   194	207	231	java/lang/Exception
    //   210	219	231	java/lang/Exception
    //   219	229	231	java/lang/Exception
    //   131	185	238	java/lang/Exception
    //   38	60	243	java/lang/Exception
  }
  
  public static void preInit(Context paramContext)
  {
    try
    {
      preInit(paramContext, null);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void preInit(Context paramContext, PreInitCallback paramPreInitCallback)
  {
    try
    {
      preInit(paramContext, paramPreInitCallback, Boolean.valueOf(true));
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void preInit(final Context paramContext, final PreInitCallback paramPreInitCallback, final Boolean paramBoolean)
  {
    try
    {
      TbsLog.initIfNeed(paramContext);
      mTmpIsSysWebViewForced = mIsSysWebViewForced;
      if (!mIsPreInitialized)
      {
        new Thread()
        {
          public void handleMessage(Message paramAnonymousMessage)
          {
            switch (paramAnonymousMessage.what)
            {
            }
            do
            {
              do
              {
                do
                {
                  return;
                  new android.webkit.WebView(paramContext);
                } while (paramPreInitCallback == null);
                paramPreInitCallback.onViewInitFinished(false);
                return;
                paramAnonymousMessage = X5CoreEngine.getInstance().wizard();
                if (paramAnonymousMessage != null) {
                  paramAnonymousMessage.createSDKWebview(paramContext);
                }
              } while (paramPreInitCallback == null);
              paramPreInitCallback.onViewInitFinished(true);
              return;
            } while (paramPreInitCallback == null);
            paramPreInitCallback.onCoreInitFinished();
          }
        }
        {
          public void run()
          {
            if (TbsInstaller.getInstance().getTbsCoreInstalledVerInNolock(this.val$context) == 0) {
              TbsInstaller.getInstance().installTbsCoreIfNeeded(this.val$context, true);
            }
            SDKEngine.getInstance(true).init(this.val$context, true);
            if ((TbsShareManager.isThirdPartyApp(this.val$context)) && (paramBoolean.booleanValue()))
            {
              if (!TbsShareManager.forceLoadX5FromTBSDemo(this.val$context.getApplicationContext())) {
                TbsDownloader.needDownload(this.val$context, false, null);
              }
              if ((!WebView.mSysWebviewCreated) && (!QbSdk.mTmpIsSysWebViewForced)) {
                QbSdk.mIsSysWebViewForced = false;
              }
            }
            X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
            localX5CoreEngine.init(this.val$context);
            boolean bool = localX5CoreEngine.isX5Core();
            this.val$handler.sendEmptyMessage(3);
            if (!bool)
            {
              this.val$handler.sendEmptyMessage(2);
              return;
            }
            this.val$handler.sendEmptyMessage(1);
          }
        }.start();
        mIsPreInitialized = true;
      }
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  private static void preloadX5Check(Context paramContext)
  {
    int i1 = -1;
    isPreloadX5Checking = true;
    try
    {
      if (Build.VERSION.SDK_INT >= 11) {
        localObject1 = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4);
      }
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        try
        {
          k = ((SharedPreferences)localObject1).getInt("tbs_preload_x5_recorder", -1);
          if (k < 0) {
            continue;
          }
          i = k + 1;
          if (i > 4)
          {
            return;
            localObject1 = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0);
            continue;
          }
          k = i;
        }
        catch (Throwable localThrowable2)
        {
          Object localObject1;
          int j;
          int n;
          Object localObject2;
          int m;
          Object localObject3;
          int k = -1;
          int i = -1;
          continue;
          i = -1;
          continue;
        }
        try
        {
          j = TbsInstaller.getInstance().getTbsCoreInstalledVerInNolock(paramContext);
          if (j <= 0) {
            continue;
          }
          if (k > 4) {}
        }
        catch (Throwable localThrowable3)
        {
          j = -1;
          k = i;
          i = j;
          continue;
        }
        try
        {
          ((SharedPreferences)localObject1).edit().putInt("tbs_preload_x5_recorder", k).commit();
          n = ((SharedPreferences)localObject1).getInt("tbs_preload_x5_counter", -1);
          k = i;
          localObject2 = localObject1;
          m = j;
          if (n < 0) {
            continue;
          }
          localObject2 = ((SharedPreferences)localObject1).edit();
          n += 1;
          ((SharedPreferences.Editor)localObject2).putInt("tbs_preload_x5_counter", n).commit();
          if (n <= 3) {
            continue;
          }
          try
          {
            i = ((SharedPreferences)localObject1).getInt("tbs_preload_x5_version", -1);
            localObject1 = ((SharedPreferences)localObject1).edit();
            if (i != j) {
              continue;
            }
            FileUtil.delete(TbsInstaller.getInstance().getTbsCoreShareDir(paramContext), false);
            paramContext = TbsCoreVerManager.getInstance(paramContext).getTbsCoreInstallFile();
            if (paramContext != null) {
              FileUtil.delete(paramContext, false);
            }
            TbsLog.e("QbSdk", "QbSdk - preload_x5_check: tbs core " + j + " is deleted!");
            ((SharedPreferences.Editor)localObject1).putInt("tbs_precheck_disable_version", i);
            ((SharedPreferences.Editor)localObject1).commit();
            return;
          }
          catch (Throwable paramContext)
          {
            TbsLog.e("QbSdk", "tbs_preload_x5_counter disable version exception:" + Log.getStackTraceString(paramContext));
            return;
          }
          localThrowable1 = localThrowable1;
          localObject1 = null;
          i = -1;
          k = -1;
        }
        catch (Throwable localThrowable4)
        {
          k = i;
          i = j;
          continue;
        }
        TbsLog.e("QbSdk", "tbs_preload_x5_counter Inc exception:" + Log.getStackTraceString(localThrowable1));
        m = i;
        localObject3 = localObject1;
        n = -1;
        i = k;
        localObject1 = localObject3;
        j = m;
        continue;
        TbsLog.e("QbSdk", "QbSdk - preload_x5_check -- reset exception core_ver:" + j + "; value:" + i);
      }
      j = i1;
      if (i > 0)
      {
        j = i1;
        if (i <= 3)
        {
          TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- before creation!");
          X5CoreEngine.getInstance().init(paramContext);
          TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- after creation!");
          j = 0;
        }
      }
      try
      {
        i = ((SharedPreferences)localObject1).getInt("tbs_preload_x5_counter", -1);
        if (i > 0) {
          ((SharedPreferences)localObject1).edit().putInt("tbs_preload_x5_counter", i - 1).commit();
        }
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          TbsLog.e("QbSdk", "tbs_preload_x5_counter Dec exception:" + Log.getStackTraceString(paramContext));
        }
      }
      TbsLog.i("QbSdk", "QbSdk -- preload_x5_check result:" + j);
      return;
    }
  }
  
  public static void reset(Context paramContext)
  {
    TbsLog.e("QbSdk", "QbSdk reset!", true);
    try
    {
      TbsDownloader.stopDownload();
      TbsDownloader.clearAllCache(paramContext);
      FileUtil.delete(paramContext.getDir("tbs", 0));
      TbsLog.i("QbSdk", "delete downloaded apk success", true);
      TbsInstaller.getInstance().mTbsCoreInstalledVer = 0;
      return;
    }
    catch (Throwable paramContext)
    {
      TbsLog.e("QbSdk", "QbSdk reset exception:" + Log.getStackTraceString(paramContext));
    }
  }
  
  public static void setCurrentID(String paramString)
  {
    if (paramString == null) {}
    while (!paramString.startsWith("QQ:")) {
      return;
    }
    paramString = paramString.substring("QQ:".length());
    mTID = "0000000000000000".substring(paramString.length()) + paramString;
  }
  
  public static void setDeviceInfo(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppUtil.mImei = paramString1;
    AppUtil.mImsi = paramString2;
    AppUtil.mCpu = paramString3;
    AppUtil.mMac = paramString4;
  }
  
  public static void setDownloadWithoutWifi(boolean paramBoolean)
  {
    mDownloadWithoutWifi = paramBoolean;
  }
  
  public static void setQQBuildNumber(String paramString)
  {
    mQQBuildNumber = paramString;
  }
  
  public static void setTBSInstallingStatus(boolean paramBoolean)
  {
    mTBSInstalling = paramBoolean;
  }
  
  public static void setTbsListener(TbsListener paramTbsListener)
  {
    mTbsListener = paramTbsListener;
  }
  
  public static void setTbsLogClient(TbsLogClient paramTbsLogClient)
  {
    TbsLog.setTbsLogClient(paramTbsLogClient);
  }
  
  public static int startMiniQBToLoadUrl(Context paramContext, String paramString, HashMap<String, String> paramHashMap, android.webkit.ValueCallback<String> paramValueCallback)
  {
    if (paramContext == null) {
      return -100;
    }
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    localX5CoreEngine.init(paramContext);
    if (localX5CoreEngine.isX5Core())
    {
      if ((paramContext == null) || (!paramContext.getApplicationInfo().packageName.equals("com.nd.android.pandahome2")) || (getTbsVersion(paramContext) >= 25487)) {
        return localX5CoreEngine.wizard().startMiniQB(paramContext, paramString, paramHashMap, null, paramValueCallback);
      }
      return -101;
    }
    return -102;
  }
  
  public static boolean startQBForDoc(Context paramContext, String paramString1, int paramInt1, int paramInt2, String paramString2, Bundle paramBundle)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ChannelID", paramContext.getApplicationContext().getApplicationInfo().processName);
    localHashMap.put("PosID", Integer.toString(paramInt1));
    return MttLoader.openDocWithQb(paramContext, paramString1, paramInt2, paramString2, localHashMap, paramBundle);
  }
  
  public static boolean startQBForVideo(Context paramContext, String paramString, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ChannelID", paramContext.getApplicationInfo().processName);
    localHashMap.put("PosID", Integer.toString(paramInt));
    return MttLoader.openVideoWithQb(paramContext, paramString, localHashMap);
  }
  
  public static boolean startQBToLoadurl(Context paramContext, String paramString, int paramInt, WebView paramWebView)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ChannelID", paramContext.getApplicationInfo().processName);
    localHashMap.put("PosID", Integer.toString(paramInt));
    WebView localWebView1 = paramWebView;
    if (paramWebView == null) {}
    try
    {
      Object localObject = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).packageName;
      if (localObject != "com.tencent.mm")
      {
        localWebView1 = paramWebView;
        if (localObject != "com.tencent.mobileqq") {}
      }
      else
      {
        localObject = X5CoreEngine.getInstance();
        localWebView1 = paramWebView;
        if (localObject != null)
        {
          localWebView1 = paramWebView;
          if (((X5CoreEngine)localObject).isX5Core())
          {
            localObject = ((X5CoreEngine)localObject).wizard().dexLoader().invokeStaticMethod("com.tencent.smtt.webkit.WebViewList", "getCurrentMainWebviewJustForQQandWechat", new Class[0], new Object[0]);
            localWebView1 = paramWebView;
            if (localObject != null)
            {
              localObject = (IX5WebViewBase)localObject;
              localWebView1 = paramWebView;
              if (localObject != null) {
                localWebView1 = (WebView)((IX5WebViewBase)localObject).getView().getParent();
              }
            }
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        WebView localWebView2 = paramWebView;
      }
    }
    return MttLoader.loadUrl(paramContext, paramString, localHashMap, "QbSdk.startQBToLoadurl", localWebView1) == 0;
  }
  
  public static boolean startQbOrMiniQBToLoadUrl(Context paramContext, String paramString, HashMap<String, String> paramHashMap, ValueCallback<String> paramValueCallback)
  {
    if (paramContext == null) {
      return false;
    }
    X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
    localX5CoreEngine.init(paramContext);
    String str1;
    if ((paramHashMap != null) && ("5".equals(paramHashMap.get("PosID"))) && (localX5CoreEngine.isX5Core()))
    {
      Object localObject = (Bundle)localX5CoreEngine.wizard().dexLoader().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getAdWebViewInfoFromX5Core", new Class[0], new Object[0]);
      if (localObject != null)
      {
        str1 = ((Bundle)localObject).getString("ad_webview_detail_url");
        String str2 = ((Bundle)localObject).getString("ad_webview_click_stat_posid_for_qb");
        localObject = ((Bundle)localObject).getString("ad_webview_click_stat_entryid_for_miniqb");
        if (!TextUtils.isEmpty(str1))
        {
          if (paramHashMap != null)
          {
            paramHashMap.put("PosID", str2);
            paramHashMap.put("entryId", localObject);
          }
          paramString = str1;
        }
      }
    }
    for (;;)
    {
      if (MttLoader.loadUrl(paramContext, paramString, paramHashMap, "QbSdk.startMiniQBToLoadUrl", null) != 0)
      {
        if (localX5CoreEngine.isX5Core()) {
          if ((paramContext == null) || (!paramContext.getApplicationInfo().packageName.equals("com.nd.android.pandahome2")) || (getTbsVersion(paramContext) >= 25487))
          {
            if (localX5CoreEngine.wizard().startMiniQB(paramContext, str1, paramHashMap, null, paramValueCallback) == 0) {
              return true;
            }
          }
          else {
            return false;
          }
        }
      }
      else {
        return true;
      }
      return false;
      str1 = paramString;
    }
  }
  
  public static void unForceSysWebView()
  {
    mIsSysWebViewForcedByOuter = false;
    TbsLog.e("QbSdk", "sys WebView: unForceSysWebView called");
  }
  
  public static boolean useSoftWare()
  {
    if (sExtensionObj == null) {
      return false;
    }
    Object localObject2 = ReflectionUtils.invokeInstance(sExtensionObj, "useSoftWare", new Class[0], new Object[0]);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = sExtensionObj;
      localObject2 = Integer.TYPE;
      int i = DeviceInfo.getTotalRAM();
      localObject1 = ReflectionUtils.invokeInstance(localObject1, "useSoftWare", new Class[] { localObject2 }, new Object[] { Integer.valueOf(i) });
    }
    if (localObject1 == null) {}
    for (boolean bool = false;; bool = ((Boolean)localObject1).booleanValue()) {
      return bool;
    }
  }
  
  static abstract interface ICommonCallback
  {
    public abstract void onFinished();
  }
  
  public static abstract interface PreInitCallback
  {
    public abstract void onCoreInitFinished();
    
    public abstract void onViewInitFinished(boolean paramBoolean);
  }
  
  public static enum WebviewInitType
  {
    FIRSTUSE_AND_PRELOAD,  FIRSTUSE_ONLY,  PRELOAD_ONLY;
    
    private WebviewInitType() {}
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\smtt\sdk\QbSdk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */