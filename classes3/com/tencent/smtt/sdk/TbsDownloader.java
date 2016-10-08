package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.smtt.utils.AppUtil;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.HttpUtil;
import com.tencent.smtt.utils.HttpUtil.HttpResponseListener;
import com.tencent.smtt.utils.TbsCommonConfig;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class TbsDownloader
{
  public static final boolean DEBUG_DISABLE_DOWNLOAD = false;
  private static final String DEVICE_CUPABI_BLACKLIST = "i686|mips|x86_64";
  public static boolean DOWNLOAD_OVERSEA_TBS = false;
  private static final int FUNCTION_DOWNLOAD = 0;
  private static final int FUNCTION_QUERY = 2;
  private static final int FUNCTION_UPDATE = 1;
  public static final String LOGTAG = "TbsDownload";
  private static final int MAX_INTERVAL = 604800;
  static final int MAX_SDK_RESPONSECODE = 10000;
  private static final int MSG_CONTINUEINSTALL_TBSCORE = 103;
  private static final int MSG_PREPARE_DOWNLOAD = 102;
  private static final int MSG_SEND_CHECKCONFIG_REQUEST = 100;
  private static final int MSG_START_DOWNLOAD_TBSAPK = 101;
  private static final int MSG_UPLOAD_TBSLOG = 104;
  private static final int PROTOCOL_VERSION = 1;
  static final int RESPONSECODE_APK = 1;
  static final int RESPONSECODE_UPDATE_APK = 2;
  static final int RESPONSECODE_UPDATE_PATCH = 3;
  private static final String TBS_EXTENSION_CFG_FILE = "tbs_extension_config";
  static final String TBS_METADATA = "com.tencent.mm.BuildInfo.CLIENT_VERSION";
  static final String TBS_PRECHECK_DISABLE_VERSION = "tbs_precheck_disable_version";
  static final String TBS_PRELOADX5_CHECK_CFG_FILE = "tbs_preloadx5_check_cfg_file";
  private static final String TBS_SDBACKUP_APK_FILENAME = "x5.tbs.org";
  private static final String TBS_SDBACKUP_APK_FILENAME_OVERSEA = "x5.oversea.tbs.org";
  static boolean mIsDownloading;
  private static boolean mStopDownloadByException = false;
  private static Context sAppContext;
  private static String sCpuabi;
  private static String sDefalutUserAgent;
  private static boolean sOverSea = false;
  private static boolean sOverSeaInited = false;
  private static TbsApkDownloader sTbsApkDownloader;
  private static Handler sTbsDownloaderHandler;
  private static HandlerThread sTbsHandlerThread;
  
  @TargetApi(11)
  static void clearAllCache(Context paramContext)
  {
    TbsDownloadConfig.getInstance(paramContext).clear();
    TbsLogReport.getInstance(paramContext).clear();
    TbsApkDownloader.clearAllApkFile(paramContext);
    SharedPreferences localSharedPreferences;
    if (Build.VERSION.SDK_INT >= 11)
    {
      localSharedPreferences = paramContext.getSharedPreferences("tbs_extension_config", 4);
      localSharedPreferences.edit().clear().commit();
      if (Build.VERSION.SDK_INT < 11) {
        break label96;
      }
    }
    label96:
    for (paramContext = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4);; paramContext = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0))
    {
      paramContext.edit().clear().commit();
      return;
      localSharedPreferences = paramContext.getSharedPreferences("tbs_extension_config", 0);
      break;
    }
  }
  
  static String getDefaultUserAgent(Context paramContext)
  {
    if (!TextUtils.isEmpty(sDefalutUserAgent)) {
      return sDefalutUserAgent;
    }
    Locale localLocale = Locale.getDefault();
    localStringBuffer = new StringBuffer();
    paramContext = Build.VERSION.RELEASE;
    try
    {
      str = new String(paramContext.getBytes("UTF-8"), "ISO8859-1");
      paramContext = str;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        String str;
        continue;
        localStringBuffer.append("1.0");
        continue;
        localStringBuffer.append("en");
      }
    }
    if (paramContext.length() > 0)
    {
      localStringBuffer.append(paramContext);
      localStringBuffer.append("; ");
      paramContext = localLocale.getLanguage();
      if (paramContext == null) {
        break label228;
      }
      localStringBuffer.append(paramContext.toLowerCase());
      paramContext = localLocale.getCountry();
      if (paramContext != null)
      {
        localStringBuffer.append("-");
        localStringBuffer.append(paramContext.toLowerCase());
      }
      if ("REL".equals(Build.VERSION.CODENAME)) {
        paramContext = Build.MODEL;
      }
    }
    try
    {
      str = new String(paramContext.getBytes("UTF-8"), "ISO8859-1");
      paramContext = str;
    }
    catch (Exception localException2)
    {
      for (;;) {}
    }
    if (paramContext.length() > 0)
    {
      localStringBuffer.append("; ");
      localStringBuffer.append(paramContext);
    }
    paramContext = Build.ID.replaceAll("[一-龥]", "");
    if (paramContext.length() > 0)
    {
      localStringBuffer.append(" Build/");
      localStringBuffer.append(paramContext);
    }
    paramContext = String.format("Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko)Version/4.0 Mobile Safari/533.1", new Object[] { localStringBuffer });
    sDefalutUserAgent = paramContext;
    return paramContext;
  }
  
  public static boolean getOverSea(Context paramContext)
  {
    try
    {
      if (!sOverSeaInited)
      {
        sOverSeaInited = true;
        paramContext = TbsDownloadConfig.getInstance(paramContext);
        if (paramContext.mPreferences.contains("is_oversea"))
        {
          sOverSea = paramContext.mPreferences.getBoolean("is_oversea", false);
          TbsLog.i("TbsDownload", "[TbsDownloader.getOverSea]  first called. sOverSea = " + sOverSea);
        }
        TbsLog.i("TbsDownload", "[TbsDownloader.getOverSea]  sOverSea = " + sOverSea);
      }
      boolean bool = sOverSea;
      return bool;
    }
    finally {}
  }
  
  public static HandlerThread getsTbsHandlerThread()
  {
    return sTbsHandlerThread;
  }
  
  private static boolean hostHasX5()
  {
    boolean bool2 = false;
    try
    {
      String[] arrayOfString = TbsShareManager.getCoreProviderAppList();
      int j = arrayOfString.length;
      int i = 0;
      for (;;)
      {
        boolean bool1 = bool2;
        if (i < j)
        {
          String str = arrayOfString[i];
          int k = TbsShareManager.getSharedTbsCoreVersion(sAppContext, str);
          if (k > 0) {
            bool1 = true;
          }
        }
        else
        {
          return bool1;
        }
        i += 1;
      }
      return false;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private static void initTbsDownloaderThreadIfNeeded()
  {
    try
    {
      if (sTbsHandlerThread == null) {
        sTbsHandlerThread = TbsHandlerThread.getInstance();
      }
      try
      {
        sTbsApkDownloader = new TbsApkDownloader(sAppContext);
        sTbsDownloaderHandler = new Handler(sTbsHandlerThread.getLooper())
        {
          public void handleMessage(Message paramAnonymousMessage)
          {
            switch (paramAnonymousMessage.what)
            {
            default: 
            case 100: 
              boolean bool;
              do
              {
                return;
                bool = TbsDownloader.sendRequest(true);
                if ((!bool) && (paramAnonymousMessage.obj != null) && ((paramAnonymousMessage.obj instanceof QbSdk.ICommonCallback))) {
                  ((QbSdk.ICommonCallback)paramAnonymousMessage.obj).onFinished();
                }
              } while ((!TbsShareManager.isThirdPartyApp(TbsDownloader.sAppContext)) || (!bool));
              TbsDownloader.startDownload(TbsDownloader.sAppContext);
              return;
            case 101: 
              paramAnonymousMessage = null;
              Object localObject = "tbs_download_lock_file" + TbsDownloadConfig.getInstance(TbsDownloader.sAppContext).mPreferences.getInt("tbs_download_version", 0) + ".txt";
              FileOutputStream localFileOutputStream = FileUtil.getLockFos(TbsDownloader.sAppContext, false, (String)localObject);
              if (localFileOutputStream != null)
              {
                localObject = FileUtil.tryFileLock(TbsDownloader.sAppContext, localFileOutputStream);
                paramAnonymousMessage = (Message)localObject;
                if (localObject == null)
                {
                  TbsLog.i("TbsDownload", "file lock locked,wx or qq is downloading");
                  TbsDownloadConfig.getInstance(TbsDownloader.sAppContext).setDownloadInterruptCode(65333);
                }
              }
              else if (FileUtil.isSdcardDirWritable(TbsDownloader.sAppContext))
              {
                TbsDownloadConfig.getInstance(TbsDownloader.sAppContext).setDownloadInterruptCode(65332);
                return;
              }
              localObject = TbsDownloadConfig.getInstance(TbsDownloader.sAppContext);
              if ((TbsDownloader.sendRequest(false)) && (((TbsDownloadConfig)localObject).mPreferences.getBoolean("tbs_needdownload", false)))
              {
                TbsDownloadConfig.getInstance(TbsDownloader.sAppContext).setDownloadInterruptCode(65321);
                TbsDownloader.sTbsApkDownloader.startDownload();
              }
              for (;;)
              {
                TbsLog.i("TbsDownload", "------freeFileLock called :");
                FileUtil.freeFileLock(paramAnonymousMessage, localFileOutputStream);
                return;
                QbSdk.mTbsListenerWrapper.onDownloadFinish(110);
              }
            case 102: 
              TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] MSG_REPORT_DOWNLOAD_STAT");
              if (TbsShareManager.isThirdPartyApp(TbsDownloader.sAppContext)) {}
              for (int i = TbsShareManager.getAvailableTbsCoreVersion(TbsDownloader.sAppContext, false);; i = TbsInstaller.getInstance().getTbsCoreInstalledVer(TbsDownloader.sAppContext))
              {
                TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] localTbsVersion=" + i);
                TbsDownloader.sTbsApkDownloader.removeTbsApkIfNeeded(i);
                TbsLogReport.getInstance(TbsDownloader.sAppContext).reportDownloadStat();
                return;
              }
            case 104: 
              TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] MSG_UPLOAD_TBSLOG");
              TbsLogReport.getInstance(TbsDownloader.sAppContext).reportTbsLog();
              return;
            }
            TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] MSG_CONTINUEINSTALL_TBSCORE");
            TbsInstaller.getInstance().continueInstallTbsCore((Context)paramAnonymousMessage.obj);
          }
        };
      }
      catch (Exception localException)
      {
        for (;;)
        {
          mStopDownloadByException = true;
          TbsLog.e("TbsDownload", "TbsApkDownloader init has Exception");
        }
      }
      return;
    }
    finally {}
  }
  
  static boolean installLocalTbs(Context paramContext)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (Build.VERSION.SDK_INT >= 8)
    {
      sAppContext = paramContext.getApplicationContext();
      initTbsDownloaderThreadIfNeeded();
      if (!mStopDownloadByException) {}
    }
    do
    {
      return bool2;
      bool1 = tryToInstallLocalTbsFromSdcard(paramContext);
      bool2 = bool1;
    } while (!bool1);
    return bool1;
  }
  
  public static boolean isDownloading()
  {
    try
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.isDownloading]");
      boolean bool = mIsDownloading;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static boolean needDownload(Context paramContext, boolean paramBoolean)
  {
    return needDownload(paramContext, paramBoolean, null);
  }
  
  static boolean needDownload(Context paramContext, boolean paramBoolean, QbSdk.ICommonCallback paramICommonCallback)
  {
    boolean bool = false;
    TbsLog.initIfNeed(paramContext);
    if (TbsInstaller.isStaticTbsInstalling)
    {
      if (paramICommonCallback != null) {
        paramICommonCallback.onFinished();
      }
      return false;
    }
    TbsLog.app_extra("TbsDownload", paramContext);
    int i = 0;
    int j = 0;
    sAppContext = paramContext.getApplicationContext();
    TbsDownloadConfig localTbsDownloadConfig = TbsDownloadConfig.getInstance(sAppContext);
    localTbsDownloadConfig.setDownloadInterruptCode(-100);
    if (Build.VERSION.SDK_INT >= 8)
    {
      if (!localTbsDownloadConfig.mPreferences.contains("is_oversea"))
      {
        bool = paramBoolean;
        if (paramBoolean)
        {
          bool = paramBoolean;
          if (!"com.tencent.mm".equals(paramContext.getApplicationInfo().packageName))
          {
            bool = false;
            TbsLog.i("TbsDownload", "needDownload-oversea is true, but not WX");
          }
        }
        localTbsDownloadConfig.mSyncMap.put("is_oversea", Boolean.valueOf(bool));
        localTbsDownloadConfig.commit();
        sOverSea = bool;
        TbsLog.i("TbsDownload", "needDownload-first-called--isoversea = " + bool);
      }
      if ((getOverSea(paramContext)) && (Build.VERSION.SDK_INT != 16) && (Build.VERSION.SDK_INT != 17) && (Build.VERSION.SDK_INT != 18))
      {
        TbsLog.i("TbsDownload", "needDownload- return false,  because of  version is " + Build.VERSION.SDK_INT + ", and overea");
        if (paramICommonCallback != null) {
          paramICommonCallback.onFinished();
        }
        localTbsDownloadConfig.setDownloadInterruptCode(-103);
        return false;
      }
      sCpuabi = localTbsDownloadConfig.mPreferences.getString("device_cpuabi", null);
      if (!TextUtils.isEmpty(sCpuabi)) {
        localObject1 = null;
      }
    }
    try
    {
      localObject2 = Pattern.compile("i686|mips|x86_64").matcher(sCpuabi);
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      Object localObject2;
      int k;
      String str1;
      int m;
      String str2;
      long l1;
      long l2;
      long l3;
      for (;;) {}
    }
    if ((localObject1 != null) && (((Matcher)localObject1).find()))
    {
      if (paramICommonCallback != null) {
        paramICommonCallback.onFinished();
      }
      localTbsDownloadConfig.setDownloadInterruptCode(-104);
      return false;
    }
    initTbsDownloaderThreadIfNeeded();
    if (mStopDownloadByException)
    {
      if (paramICommonCallback != null) {
        paramICommonCallback.onFinished();
      }
      localTbsDownloadConfig.setDownloadInterruptCode(-105);
      return false;
    }
    Object localObject1 = localTbsDownloadConfig.mPreferences.getString("app_versionname", null);
    k = localTbsDownloadConfig.mPreferences.getInt("app_versioncode", 0);
    localObject2 = localTbsDownloadConfig.mPreferences.getString("app_metadata", null);
    str1 = AppUtil.getAppVersionName(sAppContext);
    m = AppUtil.getAppVersionCode(sAppContext);
    str2 = AppUtil.getAppMetadata(sAppContext, "com.tencent.mm.BuildInfo.CLIENT_VERSION");
    l1 = System.currentTimeMillis();
    l2 = localTbsDownloadConfig.mPreferences.getLong("last_check", 0L);
    l3 = localTbsDownloadConfig.getRetryInterval();
    TbsLog.i("TbsDownload", "retryInterval = " + l3 + " s");
    if (l1 - l2 > 1000L * l3)
    {
      i = 1;
      if (i != 0) {
        queryRequest(paramICommonCallback);
      }
      sTbsDownloaderHandler.removeMessages(102);
      Message.obtain(sTbsDownloaderHandler, 102).sendToTarget();
      paramBoolean = localTbsDownloadConfig.mPreferences.contains("tbs_needdownload");
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload] hasNeedDownloadKey=" + paramBoolean);
      if ((paramBoolean) || (TbsShareManager.isThirdPartyApp(paramContext))) {
        break label722;
      }
      paramBoolean = true;
      label591:
      if (!paramBoolean) {
        break label740;
      }
      bool = paramBoolean;
      j = i;
      if (!needStartDownload())
      {
        bool = false;
        j = i;
      }
    }
    for (;;)
    {
      if ((j == 0) && (paramICommonCallback != null)) {
        paramICommonCallback.onFinished();
      }
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload] needDownload=" + bool);
      return bool;
      i = j;
      if (str1 == null) {
        break;
      }
      i = j;
      if (m == 0) {
        break;
      }
      i = j;
      if (str2 == null) {
        break;
      }
      if ((str1.equals(localObject1)) && (m == k))
      {
        i = j;
        if (str2.equals(localObject2)) {
          break;
        }
      }
      i = 1;
      break;
      label722:
      paramBoolean = localTbsDownloadConfig.mPreferences.getBoolean("tbs_needdownload", false);
      break label591;
      label740:
      bool = paramBoolean;
      j = i;
      if (i != 0)
      {
        sTbsDownloaderHandler.removeMessages(103);
        Message.obtain(sTbsDownloaderHandler, 103, sAppContext).sendToTarget();
        bool = paramBoolean;
        j = i;
        continue;
        localTbsDownloadConfig.setDownloadInterruptCode(-102);
        j = i;
      }
    }
  }
  
  private static boolean needStartDownload()
  {
    TbsDownloadConfig localTbsDownloadConfig = TbsDownloadConfig.getInstance(sAppContext);
    if (localTbsDownloadConfig.mPreferences.getInt("tbs_download_success_retrytimes", 0) >= localTbsDownloadConfig.getDownloadSuccessMaxRetrytimes())
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] out of success retrytimes", true);
      return false;
    }
    if (localTbsDownloadConfig.mPreferences.getInt("tbs_download_failed_retrytimes", 0) >= localTbsDownloadConfig.getDownloadFailedMaxRetrytimes())
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] out of failed retrytimes", true);
      return false;
    }
    if (!sTbsApkDownloader.hasEnoughFreeSpace())
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] local rom freespace limit", true);
      return false;
    }
    if (System.currentTimeMillis() - localTbsDownloadConfig.mPreferences.getLong("tbs_downloadstarttime", 0L) <= 86400000L)
    {
      long l = localTbsDownloadConfig.mPreferences.getLong("tbs_downloadflow", 0L);
      TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] downloadFlow=" + l);
      if (l >= localTbsDownloadConfig.getDownloadMaxflow())
      {
        TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] failed because you exceeded max flow!", true);
        return false;
      }
    }
    return true;
  }
  
  private static String notNullString(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private static JSONObject postJsonData(boolean paramBoolean)
  {
    TbsDownloadConfig localTbsDownloadConfig = TbsDownloadConfig.getInstance(sAppContext);
    String str1 = getDefaultUserAgent(sAppContext);
    String str2 = AppUtil.getImsi(sAppContext);
    String str3 = AppUtil.getImei(sAppContext);
    String str4 = AppUtil.getAndroidID(sAppContext);
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray;
    int j;
    for (;;)
    {
      label164:
      label171:
      int k;
      try
      {
        localJSONObject.put("PROTOCOLVERSION", 1);
        if (TbsShareManager.isThirdPartyApp(sAppContext))
        {
          i = TbsShareManager.getAvailableTbsCoreVersion(sAppContext, false);
          if (!paramBoolean) {
            break label642;
          }
          localJSONObject.put("FUNCTION", 2);
          if (!TbsShareManager.isThirdPartyApp(sAppContext)) {
            break label370;
          }
          localJSONArray = new JSONArray();
          Object localObject = TbsShareManager.getCoreProviderAppList();
          String str5 = sAppContext.getApplicationContext().getPackageName();
          if (!str5.equals(TbsShareManager.readPackageNameFromConfig(sAppContext))) {
            break label627;
          }
          j = localObject.length;
          String[] arrayOfString = new String[j + 1];
          System.arraycopy(localObject, 0, arrayOfString, 0, j);
          arrayOfString[j] = str5;
          localObject = arrayOfString;
          int i1 = localObject.length;
          j = 0;
          if (j >= i1) {
            break;
          }
          arrayOfString = localObject[j];
          int i2 = TbsShareManager.getSharedTbsCoreVersion(sAppContext, arrayOfString);
          if (i2 <= 0) {
            break label633;
          }
          int n = 0;
          k = 0;
          int m = n;
          if (k < localJSONArray.length())
          {
            if (localJSONArray.optInt(k) != i2) {
              break label336;
            }
            m = 1;
          }
          if (m != 0) {
            break label633;
          }
          localJSONArray.put(i2);
          break label633;
        }
        i = TbsInstaller.getInstance().getTbsCoreInstalledVer(sAppContext);
        if ((paramBoolean) || (i != 0) || (!TbsInstaller.getInstance().tbsFileConfExists(sAppContext))) {
          break label630;
        }
        i = -1;
        continue;
        label286:
        localJSONObject.put("FUNCTION", j);
        continue;
        TbsLog.i("TbsDownload", "[TbsDownloader.postJsonData] jsonData=" + localJSONObject.toString());
      }
      catch (Exception localException) {}
      label300:
      return localJSONObject;
      label330:
      j = 1;
      continue;
      label336:
      k += 1;
    }
    localJSONObject.put("TBSVLARR", localJSONArray);
    if (QbSdk.sAllowThirdPartyAppDownload) {
      localJSONObject.put("THIRDREQ", 1);
    }
    label370:
    localJSONObject.put("APPN", sAppContext.getPackageName());
    localJSONObject.put("APPVN", notNullString(localTbsDownloadConfig.mPreferences.getString("app_versionname", null)));
    localJSONObject.put("APPVC", localTbsDownloadConfig.mPreferences.getInt("app_versioncode", 0));
    localJSONObject.put("APPMETA", notNullString(localTbsDownloadConfig.mPreferences.getString("app_metadata", null)));
    localJSONObject.put("TBSSDKV", 36548);
    localJSONObject.put("TBSV", i);
    if (i != 0) {
      localJSONObject.put("TBSBACKUPV", sTbsApkDownloader.backupApkVersion());
    }
    localJSONObject.put("CPU", sCpuabi);
    localJSONObject.put("UA", str1);
    localJSONObject.put("IMSI", notNullString(str2));
    localJSONObject.put("IMEI", notNullString(str3));
    localJSONObject.put("ANDROID_ID", notNullString(str4));
    if (!TbsShareManager.isThirdPartyApp(sAppContext))
    {
      if (i <= 0) {
        break label615;
      }
      if (!QbSdk.isX5Disabled(sAppContext, i)) {
        break label653;
      }
    }
    label615:
    label625:
    label627:
    label630:
    label633:
    label642:
    label653:
    for (int i = 0;; i = 1)
    {
      localJSONObject.put("STATUS", i);
      for (;;)
      {
        if (!getOverSea(sAppContext)) {
          break label625;
        }
        localJSONObject.put("OVERSEA", 1);
        break;
        localJSONObject.put("STATUS", 0);
      }
      break label300;
      break label164;
      break;
      j += 1;
      break label171;
      if (i != 0) {
        break label330;
      }
      j = 0;
      break label286;
    }
  }
  
  private static void queryRequest(QbSdk.ICommonCallback paramICommonCallback)
  {
    TbsLog.i("TbsDownload", "[TbsDownloader.queryConfig]");
    sTbsDownloaderHandler.removeMessages(100);
    Message localMessage = Message.obtain(sTbsDownloaderHandler, 100);
    if (paramICommonCallback != null) {
      localMessage.obj = paramICommonCallback;
    }
    localMessage.sendToTarget();
  }
  
  @TargetApi(11)
  private static boolean readResponse(String paramString, int paramInt, boolean paramBoolean)
    throws Exception
  {
    TbsLog.i("TbsDownload", "[TbsDownloader.readResponse] response=" + paramString);
    TbsDownloadConfig localTbsDownloadConfig = TbsDownloadConfig.getInstance(sAppContext);
    if (TextUtils.isEmpty(paramString))
    {
      if (paramBoolean) {
        localTbsDownloadConfig.setDownloadInterruptCode(-108);
      }
      for (;;)
      {
        return false;
        localTbsDownloadConfig.setDownloadInterruptCode(65328);
      }
    }
    JSONObject localJSONObject = new JSONObject(paramString);
    if (localJSONObject.getInt("RET") != 0)
    {
      if (paramBoolean) {
        localTbsDownloadConfig.setDownloadInterruptCode(-109);
      }
      for (;;)
      {
        return false;
        localTbsDownloadConfig.setDownloadInterruptCode(65327);
      }
    }
    int m = localJSONObject.getInt("RESPONSECODE");
    String str2 = localJSONObject.getString("DOWNLOADURL");
    int n = localJSONObject.getInt("TBSAPKSERVERVERSION");
    int i1 = localJSONObject.getInt("DOWNLOADMAXFLOW");
    int i2 = localJSONObject.getInt("DOWNLOAD_MIN_FREE_SPACE");
    int i3 = localJSONObject.getInt("DOWNLOAD_SUCCESS_MAX_RETRYTIMES");
    int i4 = localJSONObject.getInt("DOWNLOAD_FAILED_MAX_RETRYTIMES");
    long l2 = localJSONObject.getLong("DOWNLOAD_SINGLE_TIMEOUT");
    long l3 = localJSONObject.getLong("TBSAPKFILESIZE");
    long l1 = localJSONObject.optLong("RETRY_INTERVAL", 0L);
    paramString = null;
    int j = 0;
    int i = j;
    try
    {
      String str1 = localJSONObject.getString("PKGMD5");
      i = j;
      paramString = str1;
      j = localJSONObject.getInt("RESETX5");
      i = j;
      paramString = str1;
      int k = localJSONObject.getInt("UPLOADLOG");
      paramString = str1;
      i = k;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        j = i;
        i = 0;
        continue;
        localTbsDownloadConfig.setDownloadInterruptCode(65326);
      }
      if (i != 1) {
        break label338;
      }
      sTbsDownloaderHandler.removeMessages(104);
      Message.obtain(sTbsDownloaderHandler, 104).sendToTarget();
      if ((!TextUtils.isEmpty(str2)) || (!TbsShareManager.isThirdPartyApp(sAppContext))) {
        break label397;
      }
      localTbsDownloadConfig.mSyncMap.put("tbs_needdownload", Boolean.valueOf(false));
      localTbsDownloadConfig.commit();
      TbsLog.e("TbsDownload", "downloadUrl is empty --> disable current tbs!");
      TbsShareManager.writeCoreInfoForThirdPartyApp(sAppContext, n, false);
      return false;
      if (m != 0) {
        break label449;
      }
      localTbsDownloadConfig.mSyncMap.put("tbs_needdownload", Boolean.valueOf(false));
      localTbsDownloadConfig.commit();
      if (!paramBoolean) {
        break label438;
      }
      localTbsDownloadConfig.setDownloadInterruptCode(-111);
      for (;;)
      {
        return false;
        localTbsDownloadConfig.setDownloadInterruptCode(65325);
      }
      i = TbsDownloadConfig.getInstance(sAppContext).mPreferences.getInt("tbs_download_version", 0);
      if (Build.VERSION.SDK_INT < 11) {
        break label643;
      }
    }
    if (j == 1) {
      if (paramBoolean)
      {
        localTbsDownloadConfig.setDownloadInterruptCode(-110);
        QbSdk.reset(sAppContext);
        return false;
      }
    }
    label338:
    label397:
    label438:
    label449:
    SharedPreferences localSharedPreferences = sAppContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4);
    j = localSharedPreferences.getInt("tbs_precheck_disable_version", -1);
    if (l1 > 0L)
    {
      if (l1 <= 604800L) {
        break label1000;
      }
      l1 = 604800L;
    }
    label643:
    label1000:
    for (;;)
    {
      localTbsDownloadConfig.mSyncMap.put("retry_interval", Long.valueOf(l1));
      if ((j == n) || (paramInt >= n) || (i > n) || (TextUtils.isEmpty(str2)))
      {
        if (j == n) {
          TbsLog.e("TbsDownload", "Download is disabled by preload_x5_check; tbs_version:" + n);
        }
        localTbsDownloadConfig.mSyncMap.put("tbs_needdownload", Boolean.valueOf(false));
        localTbsDownloadConfig.commit();
        if (paramBoolean) {
          localTbsDownloadConfig.setDownloadInterruptCode(-112);
        }
        for (;;)
        {
          TbsLog.i("TbsDownload", "version error or downloadUrl empty ,return ahead");
          return false;
          localSharedPreferences = sAppContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0);
          break;
          localTbsDownloadConfig.setDownloadInterruptCode(65324);
        }
      }
      if (!str2.equals(localTbsDownloadConfig.mPreferences.getString("tbs_downloadurl", null)))
      {
        sTbsApkDownloader.clearCache();
        localTbsDownloadConfig.mSyncMap.put("tbs_download_failed_retrytimes", Integer.valueOf(0));
        localTbsDownloadConfig.mSyncMap.put("tbs_download_success_retrytimes", Integer.valueOf(0));
      }
      localTbsDownloadConfig.mSyncMap.put("tbs_download_version", Integer.valueOf(n));
      localTbsDownloadConfig.mSyncMap.put("tbs_downloadurl", str2);
      localTbsDownloadConfig.mSyncMap.put("tbs_responsecode", Integer.valueOf(m));
      localTbsDownloadConfig.mSyncMap.put("tbs_download_maxflow", Integer.valueOf(i1));
      localTbsDownloadConfig.mSyncMap.put("tbs_download_min_free_space", Integer.valueOf(i2));
      localTbsDownloadConfig.mSyncMap.put("tbs_download_success_max_retrytimes", Integer.valueOf(i3));
      localTbsDownloadConfig.mSyncMap.put("tbs_download_failed_max_retrytimes", Integer.valueOf(i4));
      localTbsDownloadConfig.mSyncMap.put("tbs_single_timeout", Long.valueOf(l2));
      localTbsDownloadConfig.mSyncMap.put("tbs_apkfilesize", Long.valueOf(l3));
      if (paramString != null) {
        localTbsDownloadConfig.mSyncMap.put("tbs_apk_md5", paramString);
      }
      if (TbsInstaller.getInstance().installLocalTbsCore(sAppContext, n)) {
        if (paramBoolean)
        {
          localTbsDownloadConfig.setDownloadInterruptCode(-113);
          localTbsDownloadConfig.mSyncMap.put("tbs_needdownload", Boolean.valueOf(false));
        }
      }
      for (;;)
      {
        localTbsDownloadConfig.commit();
        return true;
        localTbsDownloadConfig.setDownloadInterruptCode(65323);
        break;
        localTbsDownloadConfig.mSyncMap.put("tbs_needdownload", Boolean.valueOf(true));
      }
    }
  }
  
  private static boolean sendRequest(boolean paramBoolean)
  {
    TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest]isQuery: " + paramBoolean);
    if (TbsInstaller.getInstance().isTbsLocalInstalled(sAppContext))
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest] -- isTbsLocalInstalled!");
      return false;
    }
    final TbsDownloadConfig localTbsDownloadConfig = TbsDownloadConfig.getInstance(sAppContext);
    Object localObject2 = FileUtil.getTBSSdcardFilePath(sAppContext, 1);
    Object localObject3;
    if (getOverSea(sAppContext))
    {
      localObject1 = "x5.oversea.tbs.org";
      localObject2 = new File((String)localObject2, (String)localObject1);
      localObject3 = FileUtil.getTBSSdcardFilePath(sAppContext, 2);
      if (!getOverSea(sAppContext)) {
        break label379;
      }
      localObject1 = "x5.oversea.tbs.org";
      label105:
      localObject3 = new File((String)localObject3, (String)localObject1);
      Object localObject4 = FileUtil.getTBSSdcardFilePath(sAppContext, 3);
      if (!getOverSea(sAppContext)) {
        break label385;
      }
      localObject1 = "x5.oversea.tbs.org";
      label138:
      localObject4 = new File((String)localObject4, (String)localObject1);
      String str = FileUtil.getTBSSdcardFilePath(sAppContext, 4);
      if (!getOverSea(sAppContext)) {
        break label391;
      }
      localObject1 = "x5.oversea.tbs.org";
      label171:
      localObject1 = new File(str, (String)localObject1);
      if (!((File)localObject1).exists())
      {
        if (!((File)localObject4).exists()) {
          break label397;
        }
        ((File)localObject4).renameTo((File)localObject1);
      }
    }
    for (;;)
    {
      long l = System.currentTimeMillis();
      localTbsDownloadConfig.mSyncMap.put("last_check", Long.valueOf(l));
      localTbsDownloadConfig.mSyncMap.put("app_versionname", AppUtil.getAppVersionName(sAppContext));
      localTbsDownloadConfig.mSyncMap.put("app_versioncode", Integer.valueOf(AppUtil.getAppVersionCode(sAppContext)));
      localTbsDownloadConfig.mSyncMap.put("app_metadata", AppUtil.getAppMetadata(sAppContext, "com.tencent.mm.BuildInfo.CLIENT_VERSION"));
      localTbsDownloadConfig.commit();
      if (sCpuabi == null)
      {
        sCpuabi = AppUtil.getDeviceCpuabi();
        localTbsDownloadConfig.mSyncMap.put("device_cpuabi", sCpuabi);
        localTbsDownloadConfig.commit();
      }
      if (TextUtils.isEmpty(sCpuabi)) {
        break label440;
      }
      localObject1 = null;
      try
      {
        localObject2 = Pattern.compile("i686|mips|x86_64").matcher(sCpuabi);
        localObject1 = localObject2;
      }
      catch (Exception localException2)
      {
        int i;
        boolean bool;
        for (;;) {}
      }
      if ((localObject1 == null) || (!((Matcher)localObject1).find())) {
        break label440;
      }
      if (!paramBoolean) {
        break label431;
      }
      localTbsDownloadConfig.setDownloadInterruptCode(-104);
      return false;
      localObject1 = "x5.tbs.org";
      break;
      label379:
      localObject1 = "x5.tbs.org";
      break label105;
      label385:
      localObject1 = "x5.tbs.org";
      break label138;
      label391:
      localObject1 = "x5.tbs.org";
      break label171;
      label397:
      if (((File)localObject3).exists()) {
        ((File)localObject3).renameTo((File)localObject1);
      } else if (((File)localObject2).exists()) {
        ((File)localObject2).renameTo((File)localObject1);
      }
    }
    label431:
    localTbsDownloadConfig.setDownloadInterruptCode(65331);
    return false;
    label440:
    Object localObject1 = postJsonData(paramBoolean);
    try
    {
      i = ((JSONObject)localObject1).getInt("TBSV");
      if (i != -1)
      {
        try
        {
          localObject2 = TbsCommonConfig.getInstance(sAppContext).getTbsDownloaderPostUrl();
          TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest] postUrl=" + (String)localObject2);
          bool = readResponse(HttpUtil.postData((String)localObject2, ((JSONObject)localObject1).toString().getBytes("utf-8"), new HttpUtil.HttpResponseListener()
          {
            public void onHttpResponseCode(int paramAnonymousInt)
            {
              TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest] httpResponseCode=" + paramAnonymousInt);
              if (paramAnonymousInt >= 300)
              {
                if (this.val$isQuery) {
                  localTbsDownloadConfig.setDownloadInterruptCode(-107);
                }
              }
              else {
                return;
              }
              localTbsDownloadConfig.setDownloadInterruptCode(65329);
            }
          }, false), i, paramBoolean);
          paramBoolean = bool;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            localThrowable.printStackTrace();
            if (!paramBoolean) {
              break;
            }
            localTbsDownloadConfig.setDownloadInterruptCode(-106);
            paramBoolean = false;
          }
          localTbsDownloadConfig.setDownloadInterruptCode(65330);
        }
        return paramBoolean;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        i = -1;
        continue;
        paramBoolean = false;
      }
    }
  }
  
  public static void startDownload(Context paramContext)
  {
    for (;;)
    {
      try
      {
        TbsLog.i("TbsDownload", "[TbsDownloader.startDownload] sAppContext=" + sAppContext);
        boolean bool = TbsInstaller.isStaticTbsInstalling;
        if (bool) {
          return;
        }
        mIsDownloading = true;
        sAppContext = paramContext.getApplicationContext();
        TbsDownloadConfig.getInstance(sAppContext).setDownloadInterruptCode(65336);
        if (Build.VERSION.SDK_INT < 8)
        {
          QbSdk.mTbsListenerWrapper.onDownloadFinish(110);
          TbsDownloadConfig.getInstance(sAppContext).setDownloadInterruptCode(65335);
          continue;
        }
        initTbsDownloaderThreadIfNeeded();
      }
      finally {}
      if (mStopDownloadByException)
      {
        TbsDownloadConfig.getInstance(sAppContext).setDownloadInterruptCode(65334);
      }
      else
      {
        sTbsDownloaderHandler.removeMessages(101);
        sTbsDownloaderHandler.removeMessages(100);
        Message.obtain(sTbsDownloaderHandler, 101, QbSdk.mTbsListenerWrapper).sendToTarget();
      }
    }
  }
  
  public static void stopDownload()
  {
    if (mStopDownloadByException) {}
    do
    {
      return;
      TbsLog.i("TbsDownload", "[TbsDownloader.stopDownload]");
      if (sTbsApkDownloader != null) {
        sTbsApkDownloader.stopDownload();
      }
    } while (sTbsDownloaderHandler == null);
    sTbsDownloaderHandler.removeMessages(100);
    sTbsDownloaderHandler.removeMessages(101);
  }
  
  private static boolean tryToInstallLocalTbsFromSdcard(Context paramContext)
  {
    boolean bool = false;
    try
    {
      paramContext = TbsApkDownloader.getLocalTbsFromSdcard(paramContext);
      if (paramContext != null)
      {
        TbsLog.i("grass", "[TbsDownloader.needDownload] getLocalTbsFromSdcard is not NULL -- force install local tbs!");
        bool = sTbsApkDownloader.InstallLocalTbsFromSdcard(paramContext);
      }
      return bool;
    }
    catch (Throwable paramContext)
    {
      StringWriter localStringWriter = new StringWriter();
      paramContext.printStackTrace(new PrintWriter(localStringWriter));
      TbsLog.e("grass", "tryToInstallLocalTbsFromSdcard exceptions:" + localStringWriter.toString());
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\smtt\sdk\TbsDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */