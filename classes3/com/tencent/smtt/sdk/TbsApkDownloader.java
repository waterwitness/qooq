package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings.System;
import android.util.Log;
import com.tencent.smtt.utils.ApkUtil;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.AppUtil;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.TbsUtils;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TbsApkDownloader
{
  public static final String BACKUPNAME = "backup";
  private static final int BUFFER_SIZE = 8192;
  public static final long DOWNLOAD_PERIOD = 86400000L;
  public static final int LOCAL_SDCARD_TBS_VERSION = 88888888;
  private static final int MAX_RETRY_TIMES = 5;
  private static final long MIN_RETRY_INTERVAL = 20000L;
  private static final int MSG_NETWORK_DETECTOR = 150;
  private static final long NETWORK_DETECT_RETRY_TIME = 120000L;
  private static final long NETWORK_WIFI_CHECK_STEP_SIZE = 1048576L;
  private static final String TBS_APK_FILENAME = "x5.tbs";
  private static final String TBS_APK_TEMP_FILENAME = "x5.tbs.temp";
  static final String TBS_BACKUP_APK_FILENAME = "x5.tbs.org";
  static final String TBS_BACKUP_APK_FILENAME_OVERSEA = "x5.oversea.tbs.org";
  private static final String TBS_BACKUP_APK_PATH = "tbs";
  private static final String[] TBS_DOWNLOADING_APP_KEYS = { "tbs_downloading_com.tencent.mtt", "tbs_downloading_com.tencent.mm", "tbs_downloading_com.tencent.mobileqq", "tbs_downloading_com.tencent.x5sdk.demo", "tbs_downloading_com.qzone" };
  private static final String TBS_DOWNLOADING_KEY_HEAD = "tbs_downloading_";
  private static final int WALLED_GARDEN_SOCKET_TIMEOUT_MS = 10000;
  private static final String WALLED_GARDEN_URL = "http://pms.mb.qq.com/rsp204";
  private String mApnInfo;
  private int mApnType;
  private boolean mCanceled;
  private int mConnectTimeout = 20000;
  private long mContentLength;
  private Context mContext;
  private TbsLogReport mDownloadStat;
  private String mDownloadUrl;
  private File mFilePath;
  private boolean mFinished;
  private boolean mHasTmpTryNoRange;
  private HttpURLConnection mHttpRequest;
  private String mLastDownloadUrl;
  private String mLocalDownloadingKey;
  private String mLocation;
  private boolean mNeedDownloadStat;
  private Handler mNetworkDetectorHandler;
  private int mReadTimeout = 30000;
  private int mRetryTimes;
  private int mRetryTimes302;
  private Set<String> mWifiUnavailableList;
  
  public TbsApkDownloader(Context paramContext)
    throws NullPointerException
  {
    this.mContext = paramContext.getApplicationContext();
    this.mDownloadStat = TbsLogReport.getInstance(this.mContext);
    this.mWifiUnavailableList = new HashSet();
    this.mLocalDownloadingKey = ("tbs_downloading_" + this.mContext.getPackageName());
    TbsInstaller.getInstance();
    this.mFilePath = TbsInstaller.getTbsCorePrivateDir(this.mContext);
    if (this.mFilePath == null) {
      throw new NullPointerException("TbsCorePrivateDir is null!");
    }
    resetArgs();
    this.mApnInfo = null;
    this.mApnType = -1;
  }
  
  @TargetApi(8)
  static File backupApkPath(Context paramContext)
  {
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT >= 8)
        {
          paramContext = new File(FileUtil.getTBSSdcardFilePath(paramContext, 4));
          if ((paramContext != null) && (!paramContext.exists()) && (!paramContext.isDirectory())) {
            paramContext.mkdirs();
          }
          return paramContext;
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        TbsLog.e("TbsDownload", "[TbsApkDownloader.backupApkPath] Exception is " + paramContext.getMessage());
        return null;
      }
      paramContext = null;
    }
  }
  
  public static void backupTbsApk(File paramFile, Context paramContext)
  {
    if ((paramFile == null) || (!paramFile.exists())) {}
    for (;;)
    {
      return;
      try
      {
        File localFile = backupApkPath(paramContext);
        if (localFile == null) {
          continue;
        }
        if (TbsDownloader.getOverSea(paramContext)) {}
        for (paramContext = "x5.oversea.tbs.org";; paramContext = "x5.tbs.org")
        {
          paramContext = new File(localFile, paramContext);
          paramContext.delete();
          FileUtil.copyFiles(paramFile, paramContext);
          return;
        }
        return;
      }
      catch (Exception paramFile) {}
    }
  }
  
  public static void clearAllApkFile(Context paramContext)
  {
    try
    {
      TbsInstaller.getInstance();
      File localFile = TbsInstaller.getTbsCorePrivateDir(paramContext);
      new File(localFile, "x5.tbs").delete();
      new File(localFile, "x5.tbs.temp").delete();
      paramContext = backupApkPath(paramContext);
      if (paramContext != null)
      {
        new File(paramContext, "x5.tbs.org").delete();
        new File(paramContext, "x5.oversea.tbs.org").delete();
      }
      return;
    }
    catch (Exception paramContext) {}
  }
  
  private void closeHttpRequest()
  {
    TbsLog.i("TbsDownload", "[TbsApkDownloader.closeHttpRequest]");
    if (this.mHttpRequest != null) {
      if (!this.mCanceled) {
        this.mDownloadStat.setResolveIp(getDomainIp(this.mHttpRequest.getURL()));
      }
    }
    try
    {
      this.mHttpRequest.disconnect();
      this.mHttpRequest = null;
      int i = this.mDownloadStat.mErrorCode;
      if ((!this.mCanceled) && (this.mNeedDownloadStat))
      {
        this.mDownloadStat.setEventTime(System.currentTimeMillis());
        String str = Apn.getApnInfo(this.mContext);
        int j = Apn.getApnType(this.mContext);
        this.mDownloadStat.setApn(str);
        this.mDownloadStat.setNetworkType(j);
        if ((j != this.mApnType) || (!str.equals(this.mApnInfo))) {
          this.mDownloadStat.setNetworkChange(0);
        }
        if (((this.mDownloadStat.mErrorCode == 0) || (this.mDownloadStat.mErrorCode == 107)) && (this.mDownloadStat.getDownFinalFlag() == 0))
        {
          if (Apn.isNetworkAvailable(this.mContext)) {
            break label218;
          }
          setDownloadStat(101, null, true);
        }
        for (;;)
        {
          this.mDownloadStat.saveUploadData(TbsLogReport.EventType.TYPE_DOWNLOAD);
          if (i != 100) {
            QbSdk.mTbsListenerWrapper.onDownloadFinish(i);
          }
          return;
          label218:
          if (!ping()) {
            setDownloadStat(101, null, true);
          }
        }
      }
      TbsDownloader.mIsDownloading = false;
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  private void closeStream(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
  
  private boolean copyTbsApkFromBackupToInstall()
  {
    try
    {
      File localFile1 = new File(this.mFilePath, "x5.tbs");
      File localFile2 = backupApkPath(this.mContext);
      if (localFile2 != null)
      {
        if (TbsDownloader.getOverSea(this.mContext)) {}
        for (Object localObject = "x5.oversea.tbs.org";; localObject = "x5.tbs.org")
        {
          localObject = new File(localFile2, (String)localObject);
          localFile1.delete();
          FileUtil.copyFiles((File)localObject, localFile1);
          break;
        }
      }
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      TbsLog.e("TbsDownload", "[TbsApkDownloader.copyTbsApkFromBackupToInstall] Exception is " + localException.getMessage());
      return false;
    }
  }
  
  private boolean deleteFile(boolean paramBoolean)
  {
    TbsLog.i("TbsDownload", "[TbsApkDownloader.deleteFile] isApk=" + paramBoolean);
    if (paramBoolean) {}
    for (File localFile = new File(this.mFilePath, "x5.tbs");; localFile = new File(this.mFilePath, "x5.tbs.temp"))
    {
      boolean bool = true;
      paramBoolean = bool;
      if (localFile != null)
      {
        paramBoolean = bool;
        if (localFile.exists()) {
          paramBoolean = localFile.delete();
        }
      }
      return paramBoolean;
    }
  }
  
  private void deleteFileBackuped()
  {
    try
    {
      String str = FileUtil.getTBSSdcardFilePath(this.mContext, 4);
      if (TbsDownloader.getOverSea(this.mContext)) {}
      for (Object localObject = "x5.oversea.tbs.org";; localObject = "x5.tbs.org")
      {
        localObject = new File(str, (String)localObject);
        if ((localObject == null) || (!((File)localObject).exists())) {
          break;
        }
        ((File)localObject).delete();
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  /* Error */
  private boolean detectWifiNetworkAvailable()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_1
    //   4: iconst_1
    //   5: istore 7
    //   7: iconst_0
    //   8: istore 8
    //   10: aload_0
    //   11: getfield 124	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   14: invokestatic 301	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   17: iconst_3
    //   18: if_icmpne +267 -> 285
    //   21: iconst_1
    //   22: istore 6
    //   24: ldc -39
    //   26: new 139	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   33: ldc_w 379
    //   36: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: iload 6
    //   41: invokevirtual 372	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   44: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 256	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: iload 8
    //   52: istore 5
    //   54: iload 6
    //   56: ifeq +133 -> 189
    //   59: aload_0
    //   60: getfield 124	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   63: invokestatic 382	com/tencent/smtt/utils/Apn:getWifiSSID	(Landroid/content/Context;)Ljava/lang/String;
    //   66: astore_1
    //   67: ldc -39
    //   69: new 139	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   76: ldc_w 384
    //   79: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload_1
    //   83: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokestatic 256	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: new 386	java/net/URL
    //   95: dup
    //   96: ldc 60
    //   98: invokespecial 387	java/net/URL:<init>	(Ljava/lang/String;)V
    //   101: invokevirtual 391	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   104: checkcast 262	java/net/HttpURLConnection
    //   107: astore_2
    //   108: aload_2
    //   109: iconst_0
    //   110: invokevirtual 395	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   113: aload_2
    //   114: sipush 10000
    //   117: invokevirtual 398	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   120: aload_2
    //   121: sipush 10000
    //   124: invokevirtual 401	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   127: aload_2
    //   128: iconst_0
    //   129: invokevirtual 404	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   132: aload_2
    //   133: invokevirtual 408	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   136: pop
    //   137: aload_2
    //   138: invokevirtual 411	java/net/HttpURLConnection:getResponseCode	()I
    //   141: istore 4
    //   143: ldc -39
    //   145: new 139	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   152: ldc_w 413
    //   155: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: iload 4
    //   160: invokevirtual 416	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   163: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokestatic 256	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   169: iload 4
    //   171: sipush 204
    //   174: if_icmpne +117 -> 291
    //   177: iload 7
    //   179: istore 5
    //   181: aload_2
    //   182: ifnull +185 -> 367
    //   185: aload_2
    //   186: invokevirtual 276	java/net/HttpURLConnection:disconnect	()V
    //   189: iload 5
    //   191: ifne +62 -> 253
    //   194: aload_1
    //   195: invokestatic 422	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   198: ifne +55 -> 253
    //   201: aload_0
    //   202: getfield 137	com/tencent/smtt/sdk/TbsApkDownloader:mWifiUnavailableList	Ljava/util/Set;
    //   205: aload_1
    //   206: invokeinterface 427 2 0
    //   211: ifne +42 -> 253
    //   214: aload_0
    //   215: getfield 137	com/tencent/smtt/sdk/TbsApkDownloader:mWifiUnavailableList	Ljava/util/Set;
    //   218: aload_1
    //   219: invokeinterface 430 2 0
    //   224: pop
    //   225: aload_0
    //   226: invokespecial 433	com/tencent/smtt/sdk/TbsApkDownloader:initNetworkDetectorHandlerIfNeeded	()V
    //   229: aload_0
    //   230: getfield 435	com/tencent/smtt/sdk/TbsApkDownloader:mNetworkDetectorHandler	Landroid/os/Handler;
    //   233: sipush 150
    //   236: aload_1
    //   237: invokevirtual 441	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   240: astore_2
    //   241: aload_0
    //   242: getfield 435	com/tencent/smtt/sdk/TbsApkDownloader:mNetworkDetectorHandler	Landroid/os/Handler;
    //   245: aload_2
    //   246: ldc2_w 31
    //   249: invokevirtual 445	android/os/Handler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   252: pop
    //   253: iload 5
    //   255: ifeq +27 -> 282
    //   258: aload_0
    //   259: getfield 137	com/tencent/smtt/sdk/TbsApkDownloader:mWifiUnavailableList	Ljava/util/Set;
    //   262: aload_1
    //   263: invokeinterface 427 2 0
    //   268: ifeq +14 -> 282
    //   271: aload_0
    //   272: getfield 137	com/tencent/smtt/sdk/TbsApkDownloader:mWifiUnavailableList	Ljava/util/Set;
    //   275: aload_1
    //   276: invokeinterface 448 2 0
    //   281: pop
    //   282: iload 5
    //   284: ireturn
    //   285: iconst_0
    //   286: istore 6
    //   288: goto -264 -> 24
    //   291: iconst_0
    //   292: istore 5
    //   294: goto -113 -> 181
    //   297: astore_2
    //   298: goto -109 -> 189
    //   301: astore_3
    //   302: aconst_null
    //   303: astore_2
    //   304: aload_3
    //   305: invokevirtual 449	java/lang/Throwable:printStackTrace	()V
    //   308: aload_2
    //   309: ifnull +51 -> 360
    //   312: aload_2
    //   313: invokevirtual 276	java/net/HttpURLConnection:disconnect	()V
    //   316: iload 8
    //   318: istore 5
    //   320: goto -131 -> 189
    //   323: astore_2
    //   324: iload 8
    //   326: istore 5
    //   328: goto -139 -> 189
    //   331: astore_1
    //   332: aload_3
    //   333: astore_2
    //   334: aload_2
    //   335: ifnull +7 -> 342
    //   338: aload_2
    //   339: invokevirtual 276	java/net/HttpURLConnection:disconnect	()V
    //   342: aload_1
    //   343: athrow
    //   344: astore_2
    //   345: goto -3 -> 342
    //   348: astore_1
    //   349: goto -15 -> 334
    //   352: astore_1
    //   353: goto -19 -> 334
    //   356: astore_3
    //   357: goto -53 -> 304
    //   360: iload 8
    //   362: istore 5
    //   364: goto -175 -> 189
    //   367: goto -178 -> 189
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	370	0	this	TbsApkDownloader
    //   3	273	1	str	String
    //   331	12	1	localObject1	Object
    //   348	1	1	localObject2	Object
    //   352	1	1	localObject3	Object
    //   107	139	2	localObject4	Object
    //   297	1	2	localException1	Exception
    //   303	10	2	localObject5	Object
    //   323	1	2	localException2	Exception
    //   333	6	2	localThrowable1	Throwable
    //   344	1	2	localException3	Exception
    //   1	1	3	localObject6	Object
    //   301	32	3	localThrowable2	Throwable
    //   356	1	3	localThrowable3	Throwable
    //   141	34	4	i	int
    //   52	311	5	bool1	boolean
    //   22	265	6	bool2	boolean
    //   5	173	7	bool3	boolean
    //   8	353	8	bool4	boolean
    // Exception table:
    //   from	to	target	type
    //   185	189	297	java/lang/Exception
    //   92	108	301	java/lang/Throwable
    //   312	316	323	java/lang/Exception
    //   92	108	331	finally
    //   338	342	344	java/lang/Exception
    //   108	169	348	finally
    //   304	308	352	finally
    //   108	169	356	java/lang/Throwable
  }
  
  private boolean downloadFileExists()
  {
    boolean bool2 = false;
    File localFile = new File(this.mFilePath, "x5.tbs.temp");
    boolean bool1 = bool2;
    if (localFile != null)
    {
      bool1 = bool2;
      if (localFile.exists()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private long downloadFileSize()
  {
    long l2 = 0L;
    File localFile = new File(this.mFilePath, "x5.tbs.temp");
    long l1 = l2;
    if (localFile != null)
    {
      l1 = l2;
      if (localFile.exists()) {
        l1 = localFile.length();
      }
    }
    return l1;
  }
  
  private void downloadSuccess(boolean paramBoolean)
  {
    TbsUtils.createDirectoryTBS(this.mContext);
    Object localObject1 = QbSdk.mTbsListenerWrapper;
    Object localObject2;
    File localFile;
    label113:
    int j;
    if (paramBoolean)
    {
      i = 100;
      ((TbsListener)localObject1).onDownloadFinish(i);
      localObject2 = TbsDownloadConfig.getInstance(this.mContext);
      ((TbsDownloadConfig)localObject2).mSyncMap.put("tbs_needdownload", Boolean.valueOf(false));
      ((TbsDownloadConfig)localObject2).commit();
      i = ((TbsDownloadConfig)localObject2).mPreferences.getInt("tbs_responsecode", 0);
      if ((i != 3) && (i <= 10000)) {
        break label296;
      }
      localFile = backupApkPath(this.mContext);
      if (localFile == null) {
        break label270;
      }
      if (!TbsDownloader.getOverSea(this.mContext)) {
        break label259;
      }
      localObject1 = "x5.oversea.tbs.org";
      localFile = new File(localFile, (String)localObject1);
      j = ApkUtil.getApkVersion(this.mContext, localFile);
      localObject1 = new File(this.mFilePath, "x5.tbs");
      if (!((File)localObject1).exists()) {
        break label265;
      }
    }
    label259:
    label265:
    for (localObject1 = ((File)localObject1).getAbsolutePath();; localObject1 = null)
    {
      int k = ((TbsDownloadConfig)localObject2).mPreferences.getInt("tbs_download_version", 0);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putInt("operation", i);
      ((Bundle)localObject2).putInt("old_core_ver", j);
      ((Bundle)localObject2).putInt("new_core_ver", k);
      ((Bundle)localObject2).putString("old_apk_location", localFile.getAbsolutePath());
      ((Bundle)localObject2).putString("new_apk_location", (String)localObject1);
      ((Bundle)localObject2).putString("diff_file_location", (String)localObject1);
      TbsInstaller.getInstance().installLocalTbsCoreExInThread(this.mContext, (Bundle)localObject2);
      return;
      i = 120;
      break;
      localObject1 = "x5.tbs.org";
      break label113;
    }
    label270:
    clearCache();
    ((TbsDownloadConfig)localObject2).mSyncMap.put("tbs_needdownload", Boolean.valueOf(true));
    ((TbsDownloadConfig)localObject2).commit();
    return;
    label296:
    int i = ((TbsDownloadConfig)localObject2).mPreferences.getInt("tbs_download_version", 0);
    TbsInstaller.getInstance().installTbsCore(this.mContext, new File(this.mFilePath, "x5.tbs").getAbsolutePath(), i);
    backupTbsApk(new File(this.mFilePath, "x5.tbs"), this.mContext);
  }
  
  private String errorToString(Throwable paramThrowable)
  {
    String str = Log.getStackTraceString(paramThrowable);
    paramThrowable = str;
    if (str.length() > 1024) {
      paramThrowable = str.substring(0, 1024);
    }
    return paramThrowable;
  }
  
  private static File getApkFilePath(Context paramContext, int paramInt)
  {
    File localFile = new File(FileUtil.getTBSSdcardFilePath(paramContext, paramInt));
    if ((localFile == null) || (!localFile.exists()) || (!localFile.isDirectory())) {
      return null;
    }
    if (TbsDownloader.getOverSea(paramContext)) {}
    for (paramContext = "x5.oversea.tbs.org";; paramContext = "x5.tbs.org")
    {
      paramContext = new File(localFile, paramContext);
      if ((paramContext == null) || (!paramContext.exists())) {
        break;
      }
      return localFile;
    }
    return null;
  }
  
  private String getDomainIp(URL paramURL)
  {
    try
    {
      paramURL = InetAddress.getByName(paramURL.getHost()).getHostAddress();
      return paramURL;
    }
    catch (Exception paramURL)
    {
      paramURL.printStackTrace();
      return "";
    }
    catch (Error paramURL)
    {
      paramURL.printStackTrace();
    }
    return "";
  }
  
  @TargetApi(8)
  static File getHostBackupApkPath(Context paramContext)
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 8)
      {
        Object localObject2 = getApkFilePath(paramContext, 4);
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = getApkFilePath(paramContext, 3);
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = getApkFilePath(paramContext, 2);
        }
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = getApkFilePath(paramContext, 1);
        }
        return (File)localObject1;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      TbsLog.e("TbsDownload", "[TbsApkDownloader.backupApkPath] Exception is " + paramContext.getMessage());
      return null;
    }
    return null;
  }
  
  public static File getLocalTbsFromSdcard(Context paramContext)
  {
    paramContext = new File(FileUtil.getTBSSdcardFilePath(paramContext, 5));
    if ((paramContext == null) || (!paramContext.isDirectory()))
    {
      TbsLog.w("TbsDownload", "[TbsApkDownloader.getLocalTbsFromSdcard] " + paramContext.getAbsolutePath() + "not found!");
      return null;
    }
    paramContext = paramContext.listFiles();
    Pattern localPattern = Pattern.compile("tbs(.*).apk");
    int j = paramContext.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramContext[i];
      if ((localPattern.matcher(((File)localObject).getName()).find()) && (((File)localObject).isFile()) && (((File)localObject).exists()) && (((File)localObject).canRead()))
      {
        TbsLog.w("TbsDownload", "[TbsApkDownloader.getLocalTbsFromSdcard] got tbs apk:" + localObject);
        return (File)localObject;
      }
      i += 1;
    }
    TbsLog.w("TbsDownload", "[TbsApkDownloader.getLocalTbsFromSdcard] No tbs apk found!");
    return null;
  }
  
  private void initHttpRequest(String paramString)
    throws Exception
  {
    this.mHttpRequest = ((HttpURLConnection)new URL(paramString).openConnection());
    this.mHttpRequest.setRequestProperty("User-Agent", TbsDownloader.getDefaultUserAgent(this.mContext));
    this.mHttpRequest.setRequestProperty("Accept-Encoding", "identity");
    this.mHttpRequest.setRequestMethod("GET");
    this.mHttpRequest.setInstanceFollowRedirects(false);
    this.mHttpRequest.setConnectTimeout(this.mConnectTimeout);
    this.mHttpRequest.setReadTimeout(this.mReadTimeout);
  }
  
  private void initNetworkDetectorHandlerIfNeeded()
  {
    if (this.mNetworkDetectorHandler == null) {
      this.mNetworkDetectorHandler = new Handler(TbsHandlerThread.getInstance().getLooper())
      {
        public void handleMessage(Message paramAnonymousMessage)
        {
          if (paramAnonymousMessage.what == 150) {
            TbsApkDownloader.this.detectWifiNetworkAvailable();
          }
        }
      };
    }
  }
  
  /* Error */
  private boolean ping()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 10
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore 5
    //   9: invokestatic 660	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   12: astore_1
    //   13: aload_1
    //   14: new 139	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   21: ldc_w 662
    //   24: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: ldc_w 664
    //   30: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokevirtual 668	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   39: invokevirtual 671	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   42: astore_1
    //   43: new 673	java/io/InputStreamReader
    //   46: dup
    //   47: aload_1
    //   48: invokespecial 676	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   51: astore_3
    //   52: new 678	java/io/BufferedReader
    //   55: dup
    //   56: aload_3
    //   57: invokespecial 681	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   60: astore_2
    //   61: iconst_0
    //   62: istore 7
    //   64: aload_2
    //   65: invokevirtual 684	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   68: astore 4
    //   70: iload 10
    //   72: istore 9
    //   74: aload 4
    //   76: ifnull +32 -> 108
    //   79: aload 4
    //   81: ldc_w 686
    //   84: invokevirtual 688	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   87: ifne +18 -> 105
    //   90: aload 4
    //   92: ldc_w 690
    //   95: invokevirtual 688	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   98: istore 9
    //   100: iload 9
    //   102: ifeq +24 -> 126
    //   105: iconst_1
    //   106: istore 9
    //   108: aload_0
    //   109: aload_1
    //   110: invokespecial 692	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   113: aload_0
    //   114: aload_3
    //   115: invokespecial 692	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   118: aload_0
    //   119: aload_2
    //   120: invokespecial 692	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   123: iload 9
    //   125: ireturn
    //   126: iload 7
    //   128: iconst_1
    //   129: iadd
    //   130: istore 8
    //   132: iload 8
    //   134: istore 7
    //   136: iload 8
    //   138: iconst_5
    //   139: if_icmplt -75 -> 64
    //   142: iload 10
    //   144: istore 9
    //   146: goto -38 -> 108
    //   149: astore_3
    //   150: aconst_null
    //   151: astore_1
    //   152: aconst_null
    //   153: astore_2
    //   154: aload 5
    //   156: astore 4
    //   158: aload_3
    //   159: invokevirtual 449	java/lang/Throwable:printStackTrace	()V
    //   162: aload_0
    //   163: aload_2
    //   164: invokespecial 692	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   167: aload_0
    //   168: aload 4
    //   170: invokespecial 692	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   173: aload_0
    //   174: aload_1
    //   175: invokespecial 692	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   178: iconst_0
    //   179: ireturn
    //   180: astore_2
    //   181: aconst_null
    //   182: astore_3
    //   183: aconst_null
    //   184: astore_1
    //   185: aload_0
    //   186: aload_1
    //   187: invokespecial 692	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   190: aload_0
    //   191: aload_3
    //   192: invokespecial 692	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   195: aload_0
    //   196: aload 4
    //   198: invokespecial 692	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   201: aload_2
    //   202: athrow
    //   203: astore_2
    //   204: aconst_null
    //   205: astore_3
    //   206: goto -21 -> 185
    //   209: astore_2
    //   210: goto -25 -> 185
    //   213: astore 5
    //   215: aload_2
    //   216: astore 4
    //   218: aload 5
    //   220: astore_2
    //   221: goto -36 -> 185
    //   224: astore 6
    //   226: aload_2
    //   227: astore 5
    //   229: aload 4
    //   231: astore_3
    //   232: aload 6
    //   234: astore_2
    //   235: aload_1
    //   236: astore 4
    //   238: aload 5
    //   240: astore_1
    //   241: goto -56 -> 185
    //   244: astore_3
    //   245: aconst_null
    //   246: astore 4
    //   248: aload_1
    //   249: astore_2
    //   250: aload 4
    //   252: astore_1
    //   253: aload 5
    //   255: astore 4
    //   257: goto -99 -> 158
    //   260: astore 6
    //   262: aconst_null
    //   263: astore 5
    //   265: aload_3
    //   266: astore 4
    //   268: aload_1
    //   269: astore_2
    //   270: aload 6
    //   272: astore_3
    //   273: aload 5
    //   275: astore_1
    //   276: goto -118 -> 158
    //   279: astore 6
    //   281: aload_3
    //   282: astore 4
    //   284: aload_1
    //   285: astore 5
    //   287: aload 6
    //   289: astore_3
    //   290: aload_2
    //   291: astore_1
    //   292: aload 5
    //   294: astore_2
    //   295: goto -137 -> 158
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	298	0	this	TbsApkDownloader
    //   12	280	1	localObject1	Object
    //   60	104	2	localBufferedReader	java.io.BufferedReader
    //   180	22	2	localObject2	Object
    //   203	1	2	localObject3	Object
    //   209	7	2	localObject4	Object
    //   220	75	2	localObject5	Object
    //   51	64	3	localInputStreamReader	java.io.InputStreamReader
    //   149	10	3	localThrowable1	Throwable
    //   182	50	3	localObject6	Object
    //   244	22	3	localThrowable2	Throwable
    //   272	18	3	localObject7	Object
    //   4	279	4	localObject8	Object
    //   7	148	5	localObject9	Object
    //   213	6	5	localObject10	Object
    //   227	66	5	localObject11	Object
    //   224	9	6	localObject12	Object
    //   260	11	6	localThrowable3	Throwable
    //   279	9	6	localThrowable4	Throwable
    //   62	73	7	i	int
    //   130	10	8	j	int
    //   72	73	9	bool1	boolean
    //   1	142	10	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   13	43	149	java/lang/Throwable
    //   13	43	180	finally
    //   43	52	203	finally
    //   52	61	209	finally
    //   64	70	213	finally
    //   79	100	213	finally
    //   158	162	224	finally
    //   43	52	244	java/lang/Throwable
    //   52	61	260	java/lang/Throwable
    //   64	70	279	java/lang/Throwable
    //   79	100	279	java/lang/Throwable
  }
  
  private void resetArgs()
  {
    this.mRetryTimes = 0;
    this.mRetryTimes302 = 0;
    this.mContentLength = -1L;
    this.mLocation = null;
    this.mHasTmpTryNoRange = false;
    this.mCanceled = false;
    this.mFinished = false;
    this.mNeedDownloadStat = false;
  }
  
  private void retry(long paramLong)
  {
    long l = paramLong;
    if (paramLong <= 0L) {}
    try
    {
      l = retryInterval();
      Thread.sleep(l);
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    this.mRetryTimes += 1;
  }
  
  private long retryInterval()
  {
    long l = 20000L;
    switch (this.mRetryTimes)
    {
    }
    for (;;)
    {
      return l * 10L;
      return 20000L * this.mRetryTimes;
      l = 20000L * 5L;
    }
  }
  
  private long saveDownloadDataStat(long paramLong1, long paramLong2)
  {
    long l = System.currentTimeMillis();
    this.mDownloadStat.setDownConsumeTime(l - paramLong1);
    this.mDownloadStat.setDownloadSize(paramLong2);
    return l;
  }
  
  private void setDownloadStat(int paramInt, String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) || (this.mRetryTimes > 5))
    {
      this.mDownloadStat.setErrorCode(paramInt);
      this.mDownloadStat.setFailDetail(paramString);
    }
  }
  
  private boolean verifyLocalTbsApk(File paramFile)
  {
    TbsLog.i("grass", "[TbsApkDownloader.verifyLocalTbsApk] apk=" + paramFile);
    if (!"3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(AppUtil.getSignatureFromApk(this.mContext, paramFile)))
    {
      TbsLog.i("grass", "[TbsApkDownloader.verifyLocalTbsApk] apk:" + paramFile + " signature failed");
      return false;
    }
    return true;
  }
  
  private boolean verifyTBSApkBackuped()
  {
    String str = FileUtil.getTBSSdcardFilePath(this.mContext, 4);
    if (TbsDownloader.getOverSea(this.mContext)) {}
    for (Object localObject = "x5.oversea.tbs.org";; localObject = "x5.tbs.org")
    {
      localObject = new File(str, (String)localObject);
      int i = TbsDownloadConfig.getInstance(this.mContext).mPreferences.getInt("tbs_download_version", 0);
      return ApkUtil.verifyTbsApk(this.mContext, (File)localObject, 0L, i);
    }
  }
  
  private boolean verifyTbsApk(boolean paramBoolean1, boolean paramBoolean2)
  {
    long l2 = 0L;
    TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + paramBoolean1);
    Object localObject2 = this.mFilePath;
    Object localObject1;
    if (!paramBoolean1)
    {
      localObject1 = "x5.tbs";
      localObject1 = new File((File)localObject2, (String)localObject1);
      if (((File)localObject1).exists()) {
        break label67;
      }
    }
    label67:
    Object localObject3;
    do
    {
      return false;
      localObject1 = "x5.tbs.temp";
      break;
      localObject2 = TbsDownloadConfig.getInstance(this.mContext).mPreferences.getString("tbs_apk_md5", null);
      localObject3 = ApkUtil.getMd5((File)localObject1);
      if ((localObject2 != null) && (((String)localObject2).equals(localObject3))) {
        break label156;
      }
      TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + paramBoolean1 + " md5 failed");
    } while (!paramBoolean1);
    this.mDownloadStat.setCheckErrorDetail("fileMd5 not match");
    return false;
    label156:
    TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] md5(" + (String)localObject3 + ") successful!");
    long l1 = l2;
    long l3;
    if (paramBoolean1)
    {
      l3 = TbsDownloadConfig.getInstance(this.mContext).mPreferences.getLong("tbs_apkfilesize", 0L);
      if ((localObject1 == null) || (!((File)localObject1).exists())) {
        break label725;
      }
      l1 = l2;
      if (l3 > 0L)
      {
        l1 = ((File)localObject1).length();
        if (l3 == l1) {}
      }
    }
    for (;;)
    {
      TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + paramBoolean1 + " filelength failed");
      this.mDownloadStat.setCheckErrorDetail("fileLength:" + l1 + ",contentLength:" + l3);
      return false;
      TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] length(" + l1 + ") successful!");
      int i = -1;
      if (paramBoolean2)
      {
        int j = ApkUtil.getApkVersion(this.mContext, (File)localObject1);
        int k = TbsDownloadConfig.getInstance(this.mContext).mPreferences.getInt("tbs_download_version", 0);
        i = j;
        if (k != j)
        {
          TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + paramBoolean1 + " versionCode failed");
          if (!paramBoolean1) {
            break;
          }
          this.mDownloadStat.setCheckErrorDetail("fileVersion:" + j + ",configVersion:" + k);
          return false;
        }
      }
      TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] tbsApkVersionCode(" + i + ") successful!");
      if (paramBoolean2)
      {
        String str = AppUtil.getSignatureFromApk(this.mContext, (File)localObject1);
        if (!"3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(str))
        {
          TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + paramBoolean1 + " signature failed");
          if (!paramBoolean1) {
            break;
          }
          localObject2 = this.mDownloadStat;
          localObject3 = new StringBuilder().append("signature:");
          if (str == null) {}
          for (localObject1 = "null";; localObject1 = Integer.valueOf(str.length()))
          {
            ((TbsLogReport)localObject2).setCheckErrorDetail(localObject1);
            return false;
          }
        }
      }
      TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] signature successful!");
      if (paramBoolean1)
      {
        try
        {
          paramBoolean1 = ((File)localObject1).renameTo(new File(this.mFilePath, "x5.tbs"));
          localObject1 = null;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            paramBoolean1 = false;
          }
        }
        paramBoolean2 = paramBoolean1;
        if (paramBoolean1) {
          break label692;
        }
        setDownloadStat(109, errorToString((Throwable)localObject1), true);
        return false;
      }
      paramBoolean2 = false;
      label692:
      TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] rename(" + paramBoolean2 + ") successful!");
      return true;
      label725:
      l1 = 0L;
    }
  }
  
  public boolean InstallLocalTbsFromSdcard(File paramFile)
  {
    boolean bool = false;
    if (paramFile != null)
    {
      TbsLog.w("grass", "[TbsApkDownloader.startDownload] getLocalTbsFromSdcard=" + paramFile);
      if (verifyLocalTbsApk(paramFile))
      {
        TbsLog.w("grass", "[TbsApkDownloader.startDownload] getLocalTbsFromSdcard － verify localTbs successful!");
        TbsInstaller.getInstance().installTbsCore(this.mContext, paramFile.getAbsolutePath(), 88888888);
        bool = true;
      }
    }
    else
    {
      return bool;
    }
    TbsLog.w("grass", "[TbsApkDownloader.startDownload] getLocalTbsFromSdcard － verify localTbs failed!");
    paramFile.delete();
    return false;
  }
  
  public int backupApkVersion()
  {
    File localFile = backupApkPath(this.mContext);
    if (localFile == null) {
      return 0;
    }
    Context localContext = this.mContext;
    if (TbsDownloader.getOverSea(this.mContext)) {}
    for (String str = "x5.oversea.tbs.org";; str = "x5.tbs.org") {
      return ApkUtil.getApkVersion(localContext, new File(localFile, str));
    }
  }
  
  public void clearCache()
  {
    stopDownload();
    deleteFile(false);
    deleteFile(true);
  }
  
  public boolean hasEnoughFreeSpace()
  {
    long l = FileUtil.getFreeSpace(this.mFilePath.getAbsolutePath());
    if (l >= TbsDownloadConfig.getInstance(this.mContext).getDownloadMinFreeSpace()) {}
    for (boolean bool = true;; bool = false)
    {
      if (!bool) {
        TbsLog.e("TbsDownload", "[TbsApkDwonloader.hasEnoughFreeSpace] freeSpace too small,  freeSpace = " + l);
      }
      return bool;
    }
  }
  
  public boolean hasSameTbsDownloading()
  {
    bool1 = true;
    for (;;)
    {
      try
      {
        l1 = System.currentTimeMillis();
        j = TbsDownloadConfig.getInstance(this.mContext).mPreferences.getInt("tbs_download_version", 0);
        String[] arrayOfString = TBS_DOWNLOADING_APP_KEYS;
        int k = arrayOfString.length;
        i = 0;
        if (i >= k) {
          continue;
        }
        localObject1 = arrayOfString[i];
        boolean bool2 = ((String)localObject1).equals(this.mLocalDownloadingKey);
        if (bool2) {
          continue;
        }
      }
      catch (Exception localException)
      {
        long l1;
        int j;
        int i;
        Object localObject1;
        Object localObject2;
        localException.printStackTrace();
        bool1 = false;
        continue;
      }
      try
      {
        localObject1 = Settings.System.getString(this.mContext.getContentResolver(), (String)localObject1);
        if (localObject1 != null)
        {
          localObject1 = ((String)localObject1).split("\\|");
          Object localObject3 = localObject1[0];
          long l2 = Long.parseLong(localObject1[1]);
          if ((localObject3 != null) && (((String)localObject3).equals(String.valueOf(j))) && (l2 > 0L))
          {
            long l3 = TbsDownloadConfig.getInstance(this.mContext).getDownloadSingleTimeout();
            if (l1 - l2 < l3)
            {
              TbsLog.i("TbsDownload", "[TbsApkDownloader.hasSameTbsDownloading] result=" + bool1);
              return bool1;
            }
          }
        }
      }
      catch (SecurityException localSecurityException)
      {
        localSecurityException.printStackTrace();
        localObject2 = null;
        continue;
      }
      i += 1;
    }
  }
  
  public void removeTbsApkIfNeeded(int paramInt)
  {
    try
    {
      File localFile = new File(this.mFilePath, "x5.tbs");
      int i = ApkUtil.getApkVersion(this.mContext, localFile);
      if ((-1 == i) || ((paramInt > 0) && (paramInt == i))) {
        localFile.delete();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  /* Error */
  public void startDownload()
  {
    // Byte code:
    //   0: invokestatic 158	com/tencent/smtt/sdk/TbsInstaller:getInstance	()Lcom/tencent/smtt/sdk/TbsInstaller;
    //   3: aload_0
    //   4: getfield 124	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   7: invokevirtual 885	com/tencent/smtt/sdk/TbsInstaller:isTbsLocalInstalled	(Landroid/content/Context;)Z
    //   10: ifeq +4 -> 14
    //   13: return
    //   14: aload_0
    //   15: getfield 124	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   18: invokestatic 465	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   21: getfield 490	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   24: ldc_w 492
    //   27: iconst_0
    //   28: invokeinterface 498 3 0
    //   33: istore 7
    //   35: iload 7
    //   37: iconst_1
    //   38: if_icmpeq +9 -> 47
    //   41: iload 7
    //   43: iconst_2
    //   44: if_icmpne +44 -> 88
    //   47: iconst_1
    //   48: istore 22
    //   50: iload 22
    //   52: ifeq +46 -> 98
    //   55: aload_0
    //   56: invokespecial 887	com/tencent/smtt/sdk/TbsApkDownloader:verifyTBSApkBackuped	()Z
    //   59: ifeq +35 -> 94
    //   62: aload_0
    //   63: invokespecial 889	com/tencent/smtt/sdk/TbsApkDownloader:copyTbsApkFromBackupToInstall	()Z
    //   66: ifeq +32 -> 98
    //   69: aload_0
    //   70: getfield 124	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   73: invokestatic 465	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   76: sipush 65322
    //   79: invokevirtual 892	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   82: aload_0
    //   83: iconst_0
    //   84: invokespecial 894	com/tencent/smtt/sdk/TbsApkDownloader:downloadSuccess	(Z)V
    //   87: return
    //   88: iconst_0
    //   89: istore 22
    //   91: goto -41 -> 50
    //   94: aload_0
    //   95: invokespecial 896	com/tencent/smtt/sdk/TbsApkDownloader:deleteFileBackuped	()V
    //   98: aload_0
    //   99: iconst_0
    //   100: iload 22
    //   102: invokespecial 898	com/tencent/smtt/sdk/TbsApkDownloader:verifyTbsApk	(ZZ)Z
    //   105: ifeq +22 -> 127
    //   108: aload_0
    //   109: getfield 124	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   112: invokestatic 465	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   115: sipush 65322
    //   118: invokevirtual 892	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   121: aload_0
    //   122: iconst_0
    //   123: invokespecial 894	com/tencent/smtt/sdk/TbsApkDownloader:downloadSuccess	(Z)V
    //   126: return
    //   127: aload_0
    //   128: iconst_1
    //   129: invokespecial 838	com/tencent/smtt/sdk/TbsApkDownloader:deleteFile	(Z)Z
    //   132: ifne +20 -> 152
    //   135: aload_0
    //   136: iconst_1
    //   137: invokespecial 838	com/tencent/smtt/sdk/TbsApkDownloader:deleteFile	(Z)Z
    //   140: ifne +12 -> 152
    //   143: ldc -39
    //   145: ldc_w 900
    //   148: invokestatic 228	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: return
    //   152: aload_0
    //   153: aload_0
    //   154: getfield 124	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   157: invokestatic 465	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   160: getfield 490	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   163: ldc_w 902
    //   166: aconst_null
    //   167: invokeinterface 765 3 0
    //   172: putfield 904	com/tencent/smtt/sdk/TbsApkDownloader:mDownloadUrl	Ljava/lang/String;
    //   175: ldc -39
    //   177: new 139	java/lang/StringBuilder
    //   180: dup
    //   181: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   184: ldc_w 906
    //   187: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: aload_0
    //   191: getfield 904	com/tencent/smtt/sdk/TbsApkDownloader:mDownloadUrl	Ljava/lang/String;
    //   194: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: ldc_w 908
    //   200: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: aload_0
    //   204: getfield 702	com/tencent/smtt/sdk/TbsApkDownloader:mLocation	Ljava/lang/String;
    //   207: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: ldc_w 910
    //   213: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: aload_0
    //   217: getfield 260	com/tencent/smtt/sdk/TbsApkDownloader:mCanceled	Z
    //   220: invokevirtual 372	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   223: ldc_w 912
    //   226: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: aload_0
    //   230: getfield 258	com/tencent/smtt/sdk/TbsApkDownloader:mHttpRequest	Ljava/net/HttpURLConnection;
    //   233: invokevirtual 622	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   236: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: invokestatic 256	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   242: aload_0
    //   243: getfield 904	com/tencent/smtt/sdk/TbsApkDownloader:mDownloadUrl	Ljava/lang/String;
    //   246: ifnonnull +21 -> 267
    //   249: aload_0
    //   250: getfield 702	com/tencent/smtt/sdk/TbsApkDownloader:mLocation	Ljava/lang/String;
    //   253: ifnonnull +14 -> 267
    //   256: getstatic 342	com/tencent/smtt/sdk/QbSdk:mTbsListenerWrapper	Lcom/tencent/smtt/sdk/TbsListener;
    //   259: bipush 110
    //   261: invokeinterface 347 2 0
    //   266: return
    //   267: aload_0
    //   268: getfield 258	com/tencent/smtt/sdk/TbsApkDownloader:mHttpRequest	Ljava/net/HttpURLConnection;
    //   271: ifnull +21 -> 292
    //   274: aload_0
    //   275: getfield 260	com/tencent/smtt/sdk/TbsApkDownloader:mCanceled	Z
    //   278: ifne +14 -> 292
    //   281: getstatic 342	com/tencent/smtt/sdk/QbSdk:mTbsListenerWrapper	Lcom/tencent/smtt/sdk/TbsListener;
    //   284: bipush 110
    //   286: invokeinterface 347 2 0
    //   291: return
    //   292: aload_0
    //   293: getfield 137	com/tencent/smtt/sdk/TbsApkDownloader:mWifiUnavailableList	Ljava/util/Set;
    //   296: aload_0
    //   297: getfield 124	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   300: invokestatic 382	com/tencent/smtt/utils/Apn:getWifiSSID	(Landroid/content/Context;)Ljava/lang/String;
    //   303: invokeinterface 427 2 0
    //   308: ifeq +22 -> 330
    //   311: ldc -39
    //   313: ldc_w 914
    //   316: invokestatic 256	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   319: getstatic 342	com/tencent/smtt/sdk/QbSdk:mTbsListenerWrapper	Lcom/tencent/smtt/sdk/TbsListener;
    //   322: bipush 110
    //   324: invokeinterface 347 2 0
    //   329: return
    //   330: aload_0
    //   331: invokespecial 172	com/tencent/smtt/sdk/TbsApkDownloader:resetArgs	()V
    //   334: ldc -39
    //   336: ldc_w 916
    //   339: iconst_1
    //   340: invokestatic 919	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   343: aload_0
    //   344: getfield 124	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   347: invokestatic 465	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   350: invokevirtual 922	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMaxflow	()J
    //   353: lstore 18
    //   355: aload_0
    //   356: getfield 694	com/tencent/smtt/sdk/TbsApkDownloader:mRetryTimes	I
    //   359: iconst_5
    //   360: if_icmple +181 -> 541
    //   363: iconst_0
    //   364: istore 20
    //   366: aload_0
    //   367: getfield 260	com/tencent/smtt/sdk/TbsApkDownloader:mCanceled	Z
    //   370: ifne +166 -> 536
    //   373: iload 20
    //   375: istore 21
    //   377: aload_0
    //   378: getfield 706	com/tencent/smtt/sdk/TbsApkDownloader:mFinished	Z
    //   381: ifeq +84 -> 465
    //   384: iload 20
    //   386: istore 21
    //   388: iload 20
    //   390: ifne +12 -> 402
    //   393: aload_0
    //   394: iconst_1
    //   395: iload 22
    //   397: invokespecial 898	com/tencent/smtt/sdk/TbsApkDownloader:verifyTbsApk	(ZZ)Z
    //   400: istore 21
    //   402: aload_0
    //   403: getfield 132	com/tencent/smtt/sdk/TbsApkDownloader:mDownloadStat	Lcom/tencent/smtt/sdk/TbsLogReport;
    //   406: astore_1
    //   407: iload 21
    //   409: ifeq +2189 -> 2598
    //   412: iconst_1
    //   413: istore 7
    //   415: aload_1
    //   416: iload 7
    //   418: invokevirtual 925	com/tencent/smtt/sdk/TbsLogReport:setUnpkgFlag	(I)V
    //   421: iload 22
    //   423: ifne +2187 -> 2610
    //   426: aload_0
    //   427: getfield 132	com/tencent/smtt/sdk/TbsApkDownloader:mDownloadStat	Lcom/tencent/smtt/sdk/TbsLogReport;
    //   430: astore_1
    //   431: iload 21
    //   433: ifeq +2171 -> 2604
    //   436: iconst_1
    //   437: istore 7
    //   439: aload_1
    //   440: iload 7
    //   442: invokevirtual 928	com/tencent/smtt/sdk/TbsLogReport:setPatchUpdateFlag	(I)V
    //   445: iload 21
    //   447: ifeq +2174 -> 2621
    //   450: aload_0
    //   451: iconst_1
    //   452: invokespecial 894	com/tencent/smtt/sdk/TbsApkDownloader:downloadSuccess	(Z)V
    //   455: aload_0
    //   456: bipush 100
    //   458: ldc_w 930
    //   461: iconst_1
    //   462: invokespecial 326	com/tencent/smtt/sdk/TbsApkDownloader:setDownloadStat	(ILjava/lang/String;Z)V
    //   465: aload_0
    //   466: getfield 124	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   469: invokestatic 465	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   472: astore_1
    //   473: iload 21
    //   475: ifeq +2155 -> 2630
    //   478: aload_1
    //   479: getfield 490	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   482: ldc_w 932
    //   485: iconst_0
    //   486: invokeinterface 498 3 0
    //   491: istore 7
    //   493: aload_1
    //   494: getfield 469	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   497: ldc_w 932
    //   500: iload 7
    //   502: iconst_1
    //   503: iadd
    //   504: invokestatic 814	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   507: invokeinterface 483 3 0
    //   512: pop
    //   513: aload_1
    //   514: invokevirtual 486	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   517: aload_0
    //   518: getfield 132	com/tencent/smtt/sdk/TbsApkDownloader:mDownloadStat	Lcom/tencent/smtt/sdk/TbsLogReport;
    //   521: astore_1
    //   522: iload 21
    //   524: ifeq +2167 -> 2691
    //   527: iconst_1
    //   528: istore 7
    //   530: aload_1
    //   531: iload 7
    //   533: invokevirtual 935	com/tencent/smtt/sdk/TbsLogReport:setDownFinalFlag	(I)V
    //   536: aload_0
    //   537: invokespecial 937	com/tencent/smtt/sdk/TbsApkDownloader:closeHttpRequest	()V
    //   540: return
    //   541: aload_0
    //   542: getfield 696	com/tencent/smtt/sdk/TbsApkDownloader:mRetryTimes302	I
    //   545: bipush 8
    //   547: if_icmple +9 -> 556
    //   550: iconst_0
    //   551: istore 20
    //   553: goto -187 -> 366
    //   556: invokestatic 287	java/lang/System:currentTimeMillis	()J
    //   559: lstore 14
    //   561: lload 14
    //   563: aload_0
    //   564: getfield 124	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   567: invokestatic 465	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   570: getfield 490	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   573: ldc_w 939
    //   576: lconst_0
    //   577: invokeinterface 786 4 0
    //   582: lsub
    //   583: ldc2_w 19
    //   586: lcmp
    //   587: ifle +90 -> 677
    //   590: ldc -39
    //   592: ldc_w 941
    //   595: invokestatic 256	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   598: aload_0
    //   599: getfield 124	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   602: invokestatic 465	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   605: getfield 469	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   608: ldc_w 939
    //   611: lload 14
    //   613: invokestatic 944	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   616: invokeinterface 483 3 0
    //   621: pop
    //   622: aload_0
    //   623: getfield 124	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   626: invokestatic 465	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   629: getfield 469	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   632: ldc_w 946
    //   635: lconst_0
    //   636: invokestatic 944	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   639: invokeinterface 483 3 0
    //   644: pop
    //   645: aload_0
    //   646: getfield 124	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   649: invokestatic 465	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   652: invokevirtual 486	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   655: aload_0
    //   656: invokevirtual 948	com/tencent/smtt/sdk/TbsApkDownloader:hasEnoughFreeSpace	()Z
    //   659: ifne +88 -> 747
    //   662: ldc -39
    //   664: ldc_w 950
    //   667: iconst_1
    //   668: invokestatic 919	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   671: iconst_0
    //   672: istore 20
    //   674: goto -308 -> 366
    //   677: aload_0
    //   678: getfield 124	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   681: invokestatic 465	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   684: getfield 490	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   687: ldc_w 946
    //   690: lconst_0
    //   691: invokeinterface 786 4 0
    //   696: lstore 8
    //   698: ldc -39
    //   700: new 139	java/lang/StringBuilder
    //   703: dup
    //   704: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   707: ldc_w 952
    //   710: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   713: lload 8
    //   715: invokevirtual 793	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   718: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   721: invokestatic 256	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   724: lload 8
    //   726: lload 18
    //   728: lcmp
    //   729: iflt -74 -> 655
    //   732: ldc -39
    //   734: ldc_w 954
    //   737: iconst_1
    //   738: invokestatic 919	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   741: iconst_0
    //   742: istore 20
    //   744: goto -378 -> 366
    //   747: aload_0
    //   748: iconst_1
    //   749: putfield 281	com/tencent/smtt/sdk/TbsApkDownloader:mNeedDownloadStat	Z
    //   752: aload_0
    //   753: getfield 702	com/tencent/smtt/sdk/TbsApkDownloader:mLocation	Ljava/lang/String;
    //   756: ifnull +361 -> 1117
    //   759: aload_0
    //   760: getfield 702	com/tencent/smtt/sdk/TbsApkDownloader:mLocation	Ljava/lang/String;
    //   763: astore_1
    //   764: aload_1
    //   765: aload_0
    //   766: getfield 956	com/tencent/smtt/sdk/TbsApkDownloader:mLastDownloadUrl	Ljava/lang/String;
    //   769: invokevirtual 312	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   772: ifne +11 -> 783
    //   775: aload_0
    //   776: getfield 132	com/tencent/smtt/sdk/TbsApkDownloader:mDownloadStat	Lcom/tencent/smtt/sdk/TbsLogReport;
    //   779: aload_1
    //   780: invokevirtual 959	com/tencent/smtt/sdk/TbsLogReport:setDownloadUrl	(Ljava/lang/String;)V
    //   783: aload_0
    //   784: aload_1
    //   785: putfield 956	com/tencent/smtt/sdk/TbsApkDownloader:mLastDownloadUrl	Ljava/lang/String;
    //   788: aload_0
    //   789: aload_1
    //   790: invokespecial 961	com/tencent/smtt/sdk/TbsApkDownloader:initHttpRequest	(Ljava/lang/String;)V
    //   793: lconst_0
    //   794: lstore 8
    //   796: aload_0
    //   797: getfield 704	com/tencent/smtt/sdk/TbsApkDownloader:mHasTmpTryNoRange	Z
    //   800: ifne +108 -> 908
    //   803: aload_0
    //   804: invokespecial 963	com/tencent/smtt/sdk/TbsApkDownloader:downloadFileSize	()J
    //   807: lstore 8
    //   809: ldc -39
    //   811: new 139	java/lang/StringBuilder
    //   814: dup
    //   815: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   818: ldc_w 965
    //   821: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   824: lload 8
    //   826: invokevirtual 793	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   829: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   832: invokestatic 256	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   835: aload_0
    //   836: getfield 700	com/tencent/smtt/sdk/TbsApkDownloader:mContentLength	J
    //   839: lconst_0
    //   840: lcmp
    //   841: ifgt +284 -> 1125
    //   844: ldc -39
    //   846: new 139	java/lang/StringBuilder
    //   849: dup
    //   850: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   853: ldc_w 967
    //   856: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   859: lload 8
    //   861: invokevirtual 793	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   864: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   867: iconst_1
    //   868: invokestatic 919	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   871: aload_0
    //   872: getfield 258	com/tencent/smtt/sdk/TbsApkDownloader:mHttpRequest	Ljava/net/HttpURLConnection;
    //   875: ldc_w 969
    //   878: new 139	java/lang/StringBuilder
    //   881: dup
    //   882: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   885: ldc_w 971
    //   888: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   891: lload 8
    //   893: invokevirtual 793	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   896: ldc_w 973
    //   899: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   902: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   905: invokevirtual 633	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   908: aload_0
    //   909: getfield 132	com/tencent/smtt/sdk/TbsApkDownloader:mDownloadStat	Lcom/tencent/smtt/sdk/TbsLogReport;
    //   912: astore_1
    //   913: lload 8
    //   915: lconst_0
    //   916: lcmp
    //   917: ifne +330 -> 1247
    //   920: iconst_0
    //   921: istore 7
    //   923: aload_1
    //   924: iload 7
    //   926: invokevirtual 976	com/tencent/smtt/sdk/TbsLogReport:setDownloadCancel	(I)V
    //   929: aload_0
    //   930: getfield 124	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   933: invokestatic 301	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   936: istore 7
    //   938: aload_0
    //   939: getfield 124	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   942: invokestatic 297	com/tencent/smtt/utils/Apn:getApnInfo	(Landroid/content/Context;)Ljava/lang/String;
    //   945: astore_1
    //   946: aload_0
    //   947: getfield 174	com/tencent/smtt/sdk/TbsApkDownloader:mApnInfo	Ljava/lang/String;
    //   950: ifnonnull +303 -> 1253
    //   953: aload_0
    //   954: getfield 176	com/tencent/smtt/sdk/TbsApkDownloader:mApnType	I
    //   957: iconst_m1
    //   958: if_icmpne +295 -> 1253
    //   961: aload_0
    //   962: aload_1
    //   963: putfield 174	com/tencent/smtt/sdk/TbsApkDownloader:mApnInfo	Ljava/lang/String;
    //   966: aload_0
    //   967: iload 7
    //   969: putfield 176	com/tencent/smtt/sdk/TbsApkDownloader:mApnType	I
    //   972: aload_0
    //   973: getfield 694	com/tencent/smtt/sdk/TbsApkDownloader:mRetryTimes	I
    //   976: iconst_1
    //   977: if_icmplt +17 -> 994
    //   980: aload_0
    //   981: getfield 258	com/tencent/smtt/sdk/TbsApkDownloader:mHttpRequest	Ljava/net/HttpURLConnection;
    //   984: ldc_w 978
    //   987: aload_0
    //   988: getfield 904	com/tencent/smtt/sdk/TbsApkDownloader:mDownloadUrl	Ljava/lang/String;
    //   991: invokevirtual 981	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   994: aload_0
    //   995: getfield 258	com/tencent/smtt/sdk/TbsApkDownloader:mHttpRequest	Ljava/net/HttpURLConnection;
    //   998: invokevirtual 411	java/net/HttpURLConnection:getResponseCode	()I
    //   1001: istore 7
    //   1003: ldc -39
    //   1005: new 139	java/lang/StringBuilder
    //   1008: dup
    //   1009: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   1012: ldc_w 983
    //   1015: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1018: iload 7
    //   1020: invokevirtual 416	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1023: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1026: invokestatic 256	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1029: aload_0
    //   1030: getfield 132	com/tencent/smtt/sdk/TbsApkDownloader:mDownloadStat	Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1033: iload 7
    //   1035: invokevirtual 986	com/tencent/smtt/sdk/TbsLogReport:setHttpCode	(I)V
    //   1038: aload_0
    //   1039: getfield 124	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   1042: invokestatic 239	com/tencent/smtt/sdk/TbsDownloader:getOverSea	(Landroid/content/Context;)Z
    //   1045: ifne +59 -> 1104
    //   1048: aload_0
    //   1049: getfield 124	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   1052: invokestatic 301	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   1055: iconst_3
    //   1056: if_icmpeq +9 -> 1065
    //   1059: invokestatic 989	com/tencent/smtt/sdk/QbSdk:getDownloadWithoutWifi	()Z
    //   1062: ifeq +13 -> 1075
    //   1065: aload_0
    //   1066: getfield 124	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   1069: invokestatic 301	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   1072: ifne +32 -> 1104
    //   1075: aload_0
    //   1076: invokevirtual 836	com/tencent/smtt/sdk/TbsApkDownloader:stopDownload	()V
    //   1079: getstatic 342	com/tencent/smtt/sdk/QbSdk:mTbsListenerWrapper	Lcom/tencent/smtt/sdk/TbsListener;
    //   1082: ifnull +13 -> 1095
    //   1085: getstatic 342	com/tencent/smtt/sdk/QbSdk:mTbsListenerWrapper	Lcom/tencent/smtt/sdk/TbsListener;
    //   1088: bipush 111
    //   1090: invokeinterface 347 2 0
    //   1095: ldc -39
    //   1097: ldc_w 991
    //   1100: iconst_0
    //   1101: invokestatic 919	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1104: aload_0
    //   1105: getfield 260	com/tencent/smtt/sdk/TbsApkDownloader:mCanceled	Z
    //   1108: ifeq +1653 -> 2761
    //   1111: iconst_0
    //   1112: istore 20
    //   1114: goto -748 -> 366
    //   1117: aload_0
    //   1118: getfield 904	com/tencent/smtt/sdk/TbsApkDownloader:mDownloadUrl	Ljava/lang/String;
    //   1121: astore_1
    //   1122: goto -358 -> 764
    //   1125: ldc -39
    //   1127: new 139	java/lang/StringBuilder
    //   1130: dup
    //   1131: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   1134: ldc_w 993
    //   1137: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1140: lload 8
    //   1142: invokevirtual 793	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1145: ldc_w 995
    //   1148: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1151: aload_0
    //   1152: getfield 700	com/tencent/smtt/sdk/TbsApkDownloader:mContentLength	J
    //   1155: invokevirtual 793	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1158: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1161: iconst_1
    //   1162: invokestatic 919	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1165: aload_0
    //   1166: getfield 258	com/tencent/smtt/sdk/TbsApkDownloader:mHttpRequest	Ljava/net/HttpURLConnection;
    //   1169: ldc_w 969
    //   1172: new 139	java/lang/StringBuilder
    //   1175: dup
    //   1176: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   1179: ldc_w 971
    //   1182: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1185: lload 8
    //   1187: invokevirtual 793	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1190: ldc_w 973
    //   1193: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1196: aload_0
    //   1197: getfield 700	com/tencent/smtt/sdk/TbsApkDownloader:mContentLength	J
    //   1200: invokevirtual 793	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1203: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1206: invokevirtual 633	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1209: goto -301 -> 908
    //   1212: astore_1
    //   1213: aload_1
    //   1214: invokevirtual 449	java/lang/Throwable:printStackTrace	()V
    //   1217: aload_0
    //   1218: lconst_0
    //   1219: invokespecial 997	com/tencent/smtt/sdk/TbsApkDownloader:retry	(J)V
    //   1222: aload_0
    //   1223: bipush 107
    //   1225: aload_0
    //   1226: aload_1
    //   1227: invokespecial 821	com/tencent/smtt/sdk/TbsApkDownloader:errorToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1230: iconst_0
    //   1231: invokespecial 326	com/tencent/smtt/sdk/TbsApkDownloader:setDownloadStat	(ILjava/lang/String;Z)V
    //   1234: aload_0
    //   1235: getfield 260	com/tencent/smtt/sdk/TbsApkDownloader:mCanceled	Z
    //   1238: ifeq -883 -> 355
    //   1241: iconst_0
    //   1242: istore 20
    //   1244: goto -878 -> 366
    //   1247: iconst_1
    //   1248: istore 7
    //   1250: goto -327 -> 923
    //   1253: iload 7
    //   1255: aload_0
    //   1256: getfield 176	com/tencent/smtt/sdk/TbsApkDownloader:mApnType	I
    //   1259: if_icmpne +14 -> 1273
    //   1262: aload_1
    //   1263: aload_0
    //   1264: getfield 174	com/tencent/smtt/sdk/TbsApkDownloader:mApnInfo	Ljava/lang/String;
    //   1267: invokevirtual 312	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1270: ifne -298 -> 972
    //   1273: aload_0
    //   1274: getfield 132	com/tencent/smtt/sdk/TbsApkDownloader:mDownloadStat	Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1277: iconst_0
    //   1278: invokevirtual 315	com/tencent/smtt/sdk/TbsLogReport:setNetworkChange	(I)V
    //   1281: aload_0
    //   1282: aload_1
    //   1283: putfield 174	com/tencent/smtt/sdk/TbsApkDownloader:mApnInfo	Ljava/lang/String;
    //   1286: aload_0
    //   1287: iload 7
    //   1289: putfield 176	com/tencent/smtt/sdk/TbsApkDownloader:mApnType	I
    //   1292: goto -320 -> 972
    //   1295: aload_0
    //   1296: aload_0
    //   1297: getfield 258	com/tencent/smtt/sdk/TbsApkDownloader:mHttpRequest	Ljava/net/HttpURLConnection;
    //   1300: invokevirtual 1000	java/net/HttpURLConnection:getContentLength	()I
    //   1303: i2l
    //   1304: lload 8
    //   1306: ladd
    //   1307: putfield 700	com/tencent/smtt/sdk/TbsApkDownloader:mContentLength	J
    //   1310: ldc -39
    //   1312: new 139	java/lang/StringBuilder
    //   1315: dup
    //   1316: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   1319: ldc_w 1002
    //   1322: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1325: aload_0
    //   1326: getfield 700	com/tencent/smtt/sdk/TbsApkDownloader:mContentLength	J
    //   1329: invokevirtual 793	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1332: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1335: invokestatic 256	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1338: aload_0
    //   1339: getfield 132	com/tencent/smtt/sdk/TbsApkDownloader:mDownloadStat	Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1342: aload_0
    //   1343: getfield 700	com/tencent/smtt/sdk/TbsApkDownloader:mContentLength	J
    //   1346: invokevirtual 1005	com/tencent/smtt/sdk/TbsLogReport:setPkgSize	(J)V
    //   1349: aload_0
    //   1350: getfield 124	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   1353: invokestatic 465	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1356: getfield 490	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   1359: ldc_w 782
    //   1362: lconst_0
    //   1363: invokeinterface 786 4 0
    //   1368: lstore 10
    //   1370: lload 10
    //   1372: lconst_0
    //   1373: lcmp
    //   1374: ifeq +133 -> 1507
    //   1377: aload_0
    //   1378: getfield 700	com/tencent/smtt/sdk/TbsApkDownloader:mContentLength	J
    //   1381: lload 10
    //   1383: lcmp
    //   1384: ifeq +123 -> 1507
    //   1387: ldc -39
    //   1389: new 139	java/lang/StringBuilder
    //   1392: dup
    //   1393: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   1396: ldc_w 1007
    //   1399: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1402: lload 10
    //   1404: invokevirtual 793	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1407: ldc_w 1009
    //   1410: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1413: aload_0
    //   1414: getfield 700	com/tencent/smtt/sdk/TbsApkDownloader:mContentLength	J
    //   1417: invokevirtual 793	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1420: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1423: iconst_1
    //   1424: invokestatic 919	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1427: aload_0
    //   1428: invokespecial 183	com/tencent/smtt/sdk/TbsApkDownloader:detectWifiNetworkAvailable	()Z
    //   1431: ifne +19 -> 1450
    //   1434: invokestatic 989	com/tencent/smtt/sdk/QbSdk:getDownloadWithoutWifi	()Z
    //   1437: ifeq +57 -> 1494
    //   1440: aload_0
    //   1441: getfield 124	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   1444: invokestatic 322	com/tencent/smtt/utils/Apn:isNetworkAvailable	(Landroid/content/Context;)Z
    //   1447: ifeq +47 -> 1494
    //   1450: aload_0
    //   1451: bipush 113
    //   1453: new 139	java/lang/StringBuilder
    //   1456: dup
    //   1457: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   1460: ldc_w 1011
    //   1463: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1466: lload 10
    //   1468: invokevirtual 793	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1471: ldc_w 1009
    //   1474: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1477: aload_0
    //   1478: getfield 700	com/tencent/smtt/sdk/TbsApkDownloader:mContentLength	J
    //   1481: invokevirtual 793	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1484: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1487: iconst_1
    //   1488: invokespecial 326	com/tencent/smtt/sdk/TbsApkDownloader:setDownloadStat	(ILjava/lang/String;Z)V
    //   1491: goto +1289 -> 2780
    //   1494: aload_0
    //   1495: bipush 101
    //   1497: ldc_w 1013
    //   1500: iconst_1
    //   1501: invokespecial 326	com/tencent/smtt/sdk/TbsApkDownloader:setDownloadStat	(ILjava/lang/String;Z)V
    //   1504: goto +1276 -> 2780
    //   1507: aconst_null
    //   1508: astore 5
    //   1510: aconst_null
    //   1511: astore_1
    //   1512: aconst_null
    //   1513: astore_3
    //   1514: aload_0
    //   1515: getfield 258	com/tencent/smtt/sdk/TbsApkDownloader:mHttpRequest	Ljava/net/HttpURLConnection;
    //   1518: invokevirtual 408	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1521: astore_2
    //   1522: aload_2
    //   1523: ifnull +1230 -> 2753
    //   1526: aload_0
    //   1527: getfield 258	com/tencent/smtt/sdk/TbsApkDownloader:mHttpRequest	Ljava/net/HttpURLConnection;
    //   1530: invokevirtual 1016	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   1533: astore_1
    //   1534: aload_1
    //   1535: ifnull +98 -> 1633
    //   1538: aload_1
    //   1539: ldc_w 1018
    //   1542: invokevirtual 688	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1545: ifeq +88 -> 1633
    //   1548: new 1020	java/util/zip/GZIPInputStream
    //   1551: dup
    //   1552: aload_2
    //   1553: invokespecial 1021	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   1556: astore_1
    //   1557: sipush 8192
    //   1560: newarray <illegal type>
    //   1562: astore_3
    //   1563: new 1023	java/io/FileOutputStream
    //   1566: dup
    //   1567: new 196	java/io/File
    //   1570: dup
    //   1571: aload_0
    //   1572: getfield 164	com/tencent/smtt/sdk/TbsApkDownloader:mFilePath	Ljava/io/File;
    //   1575: ldc 41
    //   1577: invokespecial 242	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   1580: iconst_1
    //   1581: invokespecial 1026	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   1584: astore 4
    //   1586: invokestatic 287	java/lang/System:currentTimeMillis	()J
    //   1589: lstore 10
    //   1591: lload 8
    //   1593: lstore 12
    //   1595: aload_0
    //   1596: getfield 260	com/tencent/smtt/sdk/TbsApkDownloader:mCanceled	Z
    //   1599: ifeq +150 -> 1749
    //   1602: ldc -39
    //   1604: ldc_w 1028
    //   1607: iconst_1
    //   1608: invokestatic 919	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1611: aload_0
    //   1612: aload 4
    //   1614: invokespecial 692	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   1617: aload_0
    //   1618: aload_1
    //   1619: invokespecial 692	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   1622: aload_0
    //   1623: aload_2
    //   1624: invokespecial 692	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   1627: iconst_0
    //   1628: istore 20
    //   1630: goto -1264 -> 366
    //   1633: aload_1
    //   1634: ifnull +110 -> 1744
    //   1637: aload_1
    //   1638: ldc_w 1030
    //   1641: invokevirtual 688	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1644: ifeq +100 -> 1744
    //   1647: new 1032	java/util/zip/InflaterInputStream
    //   1650: dup
    //   1651: aload_2
    //   1652: new 1034	java/util/zip/Inflater
    //   1655: dup
    //   1656: iconst_1
    //   1657: invokespecial 1036	java/util/zip/Inflater:<init>	(Z)V
    //   1660: invokespecial 1039	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Inflater;)V
    //   1663: astore_1
    //   1664: goto -107 -> 1557
    //   1667: astore 6
    //   1669: aload_2
    //   1670: astore_1
    //   1671: aload 5
    //   1673: astore 4
    //   1675: aload 6
    //   1677: astore_2
    //   1678: aload_2
    //   1679: invokevirtual 1040	java/io/IOException:printStackTrace	()V
    //   1682: aload_2
    //   1683: instanceof 1042
    //   1686: ifne +10 -> 1696
    //   1689: aload_2
    //   1690: instanceof 1044
    //   1693: ifeq +482 -> 2175
    //   1696: aload_0
    //   1697: ldc_w 1045
    //   1700: putfield 114	com/tencent/smtt/sdk/TbsApkDownloader:mReadTimeout	I
    //   1703: aload_0
    //   1704: aload_0
    //   1705: getfield 694	com/tencent/smtt/sdk/TbsApkDownloader:mRetryTimes	I
    //   1708: iconst_1
    //   1709: iadd
    //   1710: putfield 694	com/tencent/smtt/sdk/TbsApkDownloader:mRetryTimes	I
    //   1713: aload_0
    //   1714: bipush 103
    //   1716: aload_0
    //   1717: aload_2
    //   1718: invokespecial 821	com/tencent/smtt/sdk/TbsApkDownloader:errorToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1721: iconst_0
    //   1722: invokespecial 326	com/tencent/smtt/sdk/TbsApkDownloader:setDownloadStat	(ILjava/lang/String;Z)V
    //   1725: aload_0
    //   1726: aload 4
    //   1728: invokespecial 692	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   1731: aload_0
    //   1732: aload_3
    //   1733: invokespecial 692	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   1736: aload_0
    //   1737: aload_1
    //   1738: invokespecial 692	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   1741: goto -1386 -> 355
    //   1744: aload_2
    //   1745: astore_1
    //   1746: goto -189 -> 1557
    //   1749: aload_1
    //   1750: aload_3
    //   1751: iconst_0
    //   1752: sipush 8192
    //   1755: invokevirtual 1051	java/io/InputStream:read	([BII)I
    //   1758: istore 7
    //   1760: iload 7
    //   1762: ifgt +11 -> 1773
    //   1765: aload_0
    //   1766: iconst_1
    //   1767: putfield 706	com/tencent/smtt/sdk/TbsApkDownloader:mFinished	Z
    //   1770: goto -159 -> 1611
    //   1773: aload 4
    //   1775: aload_3
    //   1776: iconst_0
    //   1777: iload 7
    //   1779: invokevirtual 1055	java/io/FileOutputStream:write	([BII)V
    //   1782: aload 4
    //   1784: invokevirtual 1058	java/io/FileOutputStream:flush	()V
    //   1787: aload_0
    //   1788: getfield 124	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   1791: invokestatic 465	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1794: getfield 490	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   1797: ldc_w 946
    //   1800: lconst_0
    //   1801: invokeinterface 786 4 0
    //   1806: iload 7
    //   1808: i2l
    //   1809: ladd
    //   1810: lstore 16
    //   1812: aload_0
    //   1813: getfield 124	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   1816: invokestatic 465	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1819: getfield 469	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1822: ldc_w 946
    //   1825: lload 16
    //   1827: invokestatic 944	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1830: invokeinterface 483 3 0
    //   1835: pop
    //   1836: aload_0
    //   1837: getfield 124	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   1840: invokestatic 465	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1843: invokevirtual 486	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1846: lload 16
    //   1848: lload 18
    //   1850: lcmp
    //   1851: iflt +42 -> 1893
    //   1854: ldc -39
    //   1856: ldc_w 954
    //   1859: iconst_1
    //   1860: invokestatic 919	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1863: aload_0
    //   1864: bipush 112
    //   1866: aconst_null
    //   1867: iconst_1
    //   1868: invokespecial 326	com/tencent/smtt/sdk/TbsApkDownloader:setDownloadStat	(ILjava/lang/String;Z)V
    //   1871: goto -260 -> 1611
    //   1874: astore_3
    //   1875: aload_0
    //   1876: aload 4
    //   1878: invokespecial 692	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   1881: aload_0
    //   1882: aload_1
    //   1883: invokespecial 692	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   1886: aload_0
    //   1887: aload_2
    //   1888: invokespecial 692	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   1891: aload_3
    //   1892: athrow
    //   1893: aload_0
    //   1894: invokevirtual 948	com/tencent/smtt/sdk/TbsApkDownloader:hasEnoughFreeSpace	()Z
    //   1897: ifne +70 -> 1967
    //   1900: ldc -39
    //   1902: ldc_w 1060
    //   1905: iconst_1
    //   1906: invokestatic 919	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1909: aload_0
    //   1910: bipush 105
    //   1912: new 139	java/lang/StringBuilder
    //   1915: dup
    //   1916: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   1919: ldc_w 1062
    //   1922: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1925: aload_0
    //   1926: getfield 164	com/tencent/smtt/sdk/TbsApkDownloader:mFilePath	Ljava/io/File;
    //   1929: invokevirtual 507	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1932: invokestatic 843	com/tencent/smtt/utils/FileUtil:getFreeSpace	(Ljava/lang/String;)J
    //   1935: invokevirtual 793	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1938: ldc_w 1064
    //   1941: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1944: aload_0
    //   1945: getfield 124	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   1948: invokestatic 465	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1951: invokevirtual 846	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   1954: invokevirtual 793	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1957: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1960: iconst_1
    //   1961: invokespecial 326	com/tencent/smtt/sdk/TbsApkDownloader:setDownloadStat	(ILjava/lang/String;Z)V
    //   1964: goto -353 -> 1611
    //   1967: aload_0
    //   1968: lload 14
    //   1970: iload 7
    //   1972: i2l
    //   1973: invokespecial 1066	com/tencent/smtt/sdk/TbsApkDownloader:saveDownloadDataStat	(JJ)J
    //   1976: lstore 14
    //   1978: invokestatic 287	java/lang/System:currentTimeMillis	()J
    //   1981: lstore 16
    //   1983: lload 12
    //   1985: iload 7
    //   1987: i2l
    //   1988: ladd
    //   1989: lstore 12
    //   1991: lload 16
    //   1993: lload 10
    //   1995: lsub
    //   1996: ldc2_w 1067
    //   1999: lcmp
    //   2000: ifle +750 -> 2750
    //   2003: ldc -39
    //   2005: new 139	java/lang/StringBuilder
    //   2008: dup
    //   2009: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   2012: ldc_w 1070
    //   2015: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2018: lload 12
    //   2020: invokevirtual 793	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2023: ldc_w 995
    //   2026: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2029: aload_0
    //   2030: getfield 700	com/tencent/smtt/sdk/TbsApkDownloader:mContentLength	J
    //   2033: invokevirtual 793	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2036: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2039: iconst_1
    //   2040: invokestatic 919	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   2043: getstatic 342	com/tencent/smtt/sdk/QbSdk:mTbsListenerWrapper	Lcom/tencent/smtt/sdk/TbsListener;
    //   2046: ifnull +29 -> 2075
    //   2049: lload 12
    //   2051: l2d
    //   2052: aload_0
    //   2053: getfield 700	com/tencent/smtt/sdk/TbsApkDownloader:mContentLength	J
    //   2056: l2d
    //   2057: ddiv
    //   2058: ldc2_w 1071
    //   2061: dmul
    //   2062: d2i
    //   2063: istore 7
    //   2065: getstatic 342	com/tencent/smtt/sdk/QbSdk:mTbsListenerWrapper	Lcom/tencent/smtt/sdk/TbsListener;
    //   2068: iload 7
    //   2070: invokeinterface 1075 2 0
    //   2075: lload 8
    //   2077: lstore 10
    //   2079: lload 12
    //   2081: lload 8
    //   2083: lsub
    //   2084: ldc2_w 34
    //   2087: lcmp
    //   2088: ifle +76 -> 2164
    //   2091: aload_0
    //   2092: getfield 124	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   2095: invokestatic 239	com/tencent/smtt/sdk/TbsDownloader:getOverSea	(Landroid/content/Context;)Z
    //   2098: ifne +62 -> 2160
    //   2101: aload_0
    //   2102: getfield 124	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   2105: invokestatic 301	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   2108: iconst_3
    //   2109: if_icmpeq +9 -> 2118
    //   2112: invokestatic 989	com/tencent/smtt/sdk/QbSdk:getDownloadWithoutWifi	()Z
    //   2115: ifeq +13 -> 2128
    //   2118: aload_0
    //   2119: getfield 124	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   2122: invokestatic 301	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   2125: ifne +35 -> 2160
    //   2128: aload_0
    //   2129: invokevirtual 836	com/tencent/smtt/sdk/TbsApkDownloader:stopDownload	()V
    //   2132: getstatic 342	com/tencent/smtt/sdk/QbSdk:mTbsListenerWrapper	Lcom/tencent/smtt/sdk/TbsListener;
    //   2135: ifnull +13 -> 2148
    //   2138: getstatic 342	com/tencent/smtt/sdk/QbSdk:mTbsListenerWrapper	Lcom/tencent/smtt/sdk/TbsListener;
    //   2141: bipush 111
    //   2143: invokeinterface 347 2 0
    //   2148: ldc -39
    //   2150: ldc_w 1077
    //   2153: iconst_0
    //   2154: invokestatic 919	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   2157: goto -546 -> 1611
    //   2160: lload 12
    //   2162: lstore 10
    //   2164: lload 10
    //   2166: lstore 8
    //   2168: lload 16
    //   2170: lstore 10
    //   2172: goto -577 -> 1595
    //   2175: aload_0
    //   2176: invokevirtual 948	com/tencent/smtt/sdk/TbsApkDownloader:hasEnoughFreeSpace	()Z
    //   2179: ifne +80 -> 2259
    //   2182: aload_0
    //   2183: bipush 105
    //   2185: new 139	java/lang/StringBuilder
    //   2188: dup
    //   2189: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   2192: ldc_w 1062
    //   2195: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2198: aload_0
    //   2199: getfield 164	com/tencent/smtt/sdk/TbsApkDownloader:mFilePath	Ljava/io/File;
    //   2202: invokevirtual 507	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   2205: invokestatic 843	com/tencent/smtt/utils/FileUtil:getFreeSpace	(Ljava/lang/String;)J
    //   2208: invokevirtual 793	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2211: ldc_w 1064
    //   2214: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2217: aload_0
    //   2218: getfield 124	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   2221: invokestatic 465	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2224: invokevirtual 846	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   2227: invokevirtual 793	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2230: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2233: iconst_1
    //   2234: invokespecial 326	com/tencent/smtt/sdk/TbsApkDownloader:setDownloadStat	(ILjava/lang/String;Z)V
    //   2237: aload_0
    //   2238: aload 4
    //   2240: invokespecial 692	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   2243: aload_0
    //   2244: aload_3
    //   2245: invokespecial 692	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   2248: aload_0
    //   2249: aload_1
    //   2250: invokespecial 692	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   2253: iconst_0
    //   2254: istore 20
    //   2256: goto -1890 -> 366
    //   2259: aload_0
    //   2260: lconst_0
    //   2261: invokespecial 997	com/tencent/smtt/sdk/TbsApkDownloader:retry	(J)V
    //   2264: aload_0
    //   2265: invokespecial 1079	com/tencent/smtt/sdk/TbsApkDownloader:downloadFileExists	()Z
    //   2268: ifne +34 -> 2302
    //   2271: aload_0
    //   2272: bipush 106
    //   2274: aload_0
    //   2275: aload_2
    //   2276: invokespecial 821	com/tencent/smtt/sdk/TbsApkDownloader:errorToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2279: iconst_0
    //   2280: invokespecial 326	com/tencent/smtt/sdk/TbsApkDownloader:setDownloadStat	(ILjava/lang/String;Z)V
    //   2283: aload_0
    //   2284: aload 4
    //   2286: invokespecial 692	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   2289: aload_0
    //   2290: aload_3
    //   2291: invokespecial 692	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   2294: aload_0
    //   2295: aload_1
    //   2296: invokespecial 692	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   2299: goto -1944 -> 355
    //   2302: aload_0
    //   2303: bipush 104
    //   2305: aload_0
    //   2306: aload_2
    //   2307: invokespecial 821	com/tencent/smtt/sdk/TbsApkDownloader:errorToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2310: iconst_0
    //   2311: invokespecial 326	com/tencent/smtt/sdk/TbsApkDownloader:setDownloadStat	(ILjava/lang/String;Z)V
    //   2314: goto -31 -> 2283
    //   2317: astore 6
    //   2319: aload_3
    //   2320: astore_2
    //   2321: aload_1
    //   2322: astore 5
    //   2324: aload 6
    //   2326: astore_3
    //   2327: aload_2
    //   2328: astore_1
    //   2329: aload 5
    //   2331: astore_2
    //   2332: goto -457 -> 1875
    //   2335: iload 7
    //   2337: sipush 300
    //   2340: if_icmplt +47 -> 2387
    //   2343: iload 7
    //   2345: sipush 307
    //   2348: if_icmpgt +39 -> 2387
    //   2351: aload_0
    //   2352: getfield 258	com/tencent/smtt/sdk/TbsApkDownloader:mHttpRequest	Ljava/net/HttpURLConnection;
    //   2355: ldc_w 1081
    //   2358: invokevirtual 1085	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   2361: astore_1
    //   2362: aload_1
    //   2363: invokestatic 422	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2366: ifne +434 -> 2800
    //   2369: aload_0
    //   2370: aload_1
    //   2371: putfield 702	com/tencent/smtt/sdk/TbsApkDownloader:mLocation	Ljava/lang/String;
    //   2374: aload_0
    //   2375: aload_0
    //   2376: getfield 696	com/tencent/smtt/sdk/TbsApkDownloader:mRetryTimes302	I
    //   2379: iconst_1
    //   2380: iadd
    //   2381: putfield 696	com/tencent/smtt/sdk/TbsApkDownloader:mRetryTimes302	I
    //   2384: goto -2029 -> 355
    //   2387: aload_0
    //   2388: bipush 102
    //   2390: aconst_null
    //   2391: iconst_0
    //   2392: invokespecial 326	com/tencent/smtt/sdk/TbsApkDownloader:setDownloadStat	(ILjava/lang/String;Z)V
    //   2395: iload 7
    //   2397: sipush 416
    //   2400: if_icmpne +406 -> 2806
    //   2403: aload_0
    //   2404: iconst_1
    //   2405: iload 22
    //   2407: invokespecial 898	com/tencent/smtt/sdk/TbsApkDownloader:verifyTbsApk	(ZZ)Z
    //   2410: ifeq +9 -> 2419
    //   2413: iconst_1
    //   2414: istore 20
    //   2416: goto -2050 -> 366
    //   2419: aload_0
    //   2420: iconst_0
    //   2421: invokespecial 838	com/tencent/smtt/sdk/TbsApkDownloader:deleteFile	(Z)Z
    //   2424: pop
    //   2425: iconst_0
    //   2426: istore 20
    //   2428: goto -2062 -> 366
    //   2431: aload_0
    //   2432: getfield 700	com/tencent/smtt/sdk/TbsApkDownloader:mContentLength	J
    //   2435: ldc2_w 697
    //   2438: lcmp
    //   2439: ifne +9 -> 2448
    //   2442: iconst_0
    //   2443: istore 20
    //   2445: goto -2079 -> 366
    //   2448: iload 7
    //   2450: sipush 202
    //   2453: if_icmpeq -2098 -> 355
    //   2456: aload_0
    //   2457: getfield 694	com/tencent/smtt/sdk/TbsApkDownloader:mRetryTimes	I
    //   2460: iconst_5
    //   2461: if_icmpge +41 -> 2502
    //   2464: iload 7
    //   2466: sipush 503
    //   2469: if_icmpne +33 -> 2502
    //   2472: aload_0
    //   2473: aload_0
    //   2474: getfield 258	com/tencent/smtt/sdk/TbsApkDownloader:mHttpRequest	Ljava/net/HttpURLConnection;
    //   2477: ldc_w 1087
    //   2480: invokevirtual 1085	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   2483: invokestatic 871	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2486: invokespecial 997	com/tencent/smtt/sdk/TbsApkDownloader:retry	(J)V
    //   2489: aload_0
    //   2490: getfield 260	com/tencent/smtt/sdk/TbsApkDownloader:mCanceled	Z
    //   2493: ifeq -2138 -> 355
    //   2496: iconst_0
    //   2497: istore 20
    //   2499: goto -2133 -> 366
    //   2502: aload_0
    //   2503: getfield 694	com/tencent/smtt/sdk/TbsApkDownloader:mRetryTimes	I
    //   2506: iconst_5
    //   2507: if_icmpge +53 -> 2560
    //   2510: iload 7
    //   2512: sipush 408
    //   2515: if_icmpeq +27 -> 2542
    //   2518: iload 7
    //   2520: sipush 504
    //   2523: if_icmpeq +19 -> 2542
    //   2526: iload 7
    //   2528: sipush 502
    //   2531: if_icmpeq +11 -> 2542
    //   2534: iload 7
    //   2536: sipush 408
    //   2539: if_icmpne +21 -> 2560
    //   2542: aload_0
    //   2543: lconst_0
    //   2544: invokespecial 997	com/tencent/smtt/sdk/TbsApkDownloader:retry	(J)V
    //   2547: aload_0
    //   2548: getfield 260	com/tencent/smtt/sdk/TbsApkDownloader:mCanceled	Z
    //   2551: ifeq -2196 -> 355
    //   2554: iconst_0
    //   2555: istore 20
    //   2557: goto -2191 -> 366
    //   2560: aload_0
    //   2561: invokespecial 963	com/tencent/smtt/sdk/TbsApkDownloader:downloadFileSize	()J
    //   2564: lconst_0
    //   2565: lcmp
    //   2566: ifgt +26 -> 2592
    //   2569: aload_0
    //   2570: getfield 704	com/tencent/smtt/sdk/TbsApkDownloader:mHasTmpTryNoRange	Z
    //   2573: ifne +19 -> 2592
    //   2576: iload 7
    //   2578: sipush 410
    //   2581: if_icmpeq +11 -> 2592
    //   2584: aload_0
    //   2585: iconst_1
    //   2586: putfield 704	com/tencent/smtt/sdk/TbsApkDownloader:mHasTmpTryNoRange	Z
    //   2589: goto -2234 -> 355
    //   2592: iconst_0
    //   2593: istore 20
    //   2595: goto -2229 -> 366
    //   2598: iconst_0
    //   2599: istore 7
    //   2601: goto -2186 -> 415
    //   2604: iconst_2
    //   2605: istore 7
    //   2607: goto -2168 -> 439
    //   2610: aload_0
    //   2611: getfield 132	com/tencent/smtt/sdk/TbsApkDownloader:mDownloadStat	Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2614: iconst_0
    //   2615: invokevirtual 928	com/tencent/smtt/sdk/TbsLogReport:setPatchUpdateFlag	(I)V
    //   2618: goto -2173 -> 445
    //   2621: aload_0
    //   2622: iconst_0
    //   2623: invokespecial 838	com/tencent/smtt/sdk/TbsApkDownloader:deleteFile	(Z)Z
    //   2626: pop
    //   2627: goto -2162 -> 465
    //   2630: aload_1
    //   2631: getfield 490	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   2634: ldc_w 1089
    //   2637: iconst_0
    //   2638: invokeinterface 498 3 0
    //   2643: istore 7
    //   2645: aload_1
    //   2646: getfield 469	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2649: astore_2
    //   2650: iload 7
    //   2652: iconst_1
    //   2653: iadd
    //   2654: istore 7
    //   2656: aload_2
    //   2657: ldc_w 1089
    //   2660: iload 7
    //   2662: invokestatic 814	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2665: invokeinterface 483 3 0
    //   2670: pop
    //   2671: iload 7
    //   2673: aload_1
    //   2674: invokevirtual 1092	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadFailedMaxRetrytimes	()I
    //   2677: if_icmpne -2164 -> 513
    //   2680: aload_0
    //   2681: getfield 132	com/tencent/smtt/sdk/TbsApkDownloader:mDownloadStat	Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2684: iconst_2
    //   2685: invokevirtual 976	com/tencent/smtt/sdk/TbsLogReport:setDownloadCancel	(I)V
    //   2688: goto -2175 -> 513
    //   2691: iconst_0
    //   2692: istore 7
    //   2694: goto -2164 -> 530
    //   2697: astore_3
    //   2698: aconst_null
    //   2699: astore_1
    //   2700: aconst_null
    //   2701: astore_2
    //   2702: aconst_null
    //   2703: astore 4
    //   2705: goto -830 -> 1875
    //   2708: astore_3
    //   2709: aconst_null
    //   2710: astore_1
    //   2711: aconst_null
    //   2712: astore 4
    //   2714: goto -839 -> 1875
    //   2717: astore_3
    //   2718: aconst_null
    //   2719: astore 4
    //   2721: goto -846 -> 1875
    //   2724: astore_2
    //   2725: aload 5
    //   2727: astore 4
    //   2729: goto -1051 -> 1678
    //   2732: astore_3
    //   2733: aload_2
    //   2734: astore 4
    //   2736: aload_3
    //   2737: astore_2
    //   2738: aload_1
    //   2739: astore_3
    //   2740: aload 4
    //   2742: astore_1
    //   2743: aload 5
    //   2745: astore 4
    //   2747: goto -1069 -> 1678
    //   2750: goto -578 -> 2172
    //   2753: aconst_null
    //   2754: astore_1
    //   2755: aconst_null
    //   2756: astore 4
    //   2758: goto -1147 -> 1611
    //   2761: iload 7
    //   2763: sipush 200
    //   2766: if_icmpeq -1471 -> 1295
    //   2769: iload 7
    //   2771: sipush 206
    //   2774: if_icmpne -439 -> 2335
    //   2777: goto -1482 -> 1295
    //   2780: iconst_0
    //   2781: istore 20
    //   2783: goto -2417 -> 366
    //   2786: astore_3
    //   2787: aload_2
    //   2788: astore 5
    //   2790: aload_3
    //   2791: astore_2
    //   2792: aload_1
    //   2793: astore_3
    //   2794: aload 5
    //   2796: astore_1
    //   2797: goto -1119 -> 1678
    //   2800: iconst_0
    //   2801: istore 20
    //   2803: goto -2437 -> 366
    //   2806: iload 7
    //   2808: sipush 403
    //   2811: if_icmpeq -380 -> 2431
    //   2814: iload 7
    //   2816: sipush 406
    //   2819: if_icmpne -371 -> 2448
    //   2822: goto -391 -> 2431
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2825	0	this	TbsApkDownloader
    //   406	716	1	localObject1	Object
    //   1212	71	1	localThrowable	Throwable
    //   1511	1286	1	localObject2	Object
    //   1521	1181	2	localObject3	Object
    //   2724	10	2	localIOException1	IOException
    //   2737	55	2	localIOException2	IOException
    //   1513	263	3	arrayOfByte	byte[]
    //   1874	446	3	localCloseable	Closeable
    //   2326	1	3	localObject4	Object
    //   2697	1	3	localObject5	Object
    //   2708	1	3	localObject6	Object
    //   2717	1	3	localObject7	Object
    //   2732	5	3	localIOException3	IOException
    //   2739	1	3	localObject8	Object
    //   2786	5	3	localIOException4	IOException
    //   2793	1	3	localObject9	Object
    //   1584	1173	4	localObject10	Object
    //   1508	1287	5	localObject11	Object
    //   1667	9	6	localIOException5	IOException
    //   2317	8	6	localObject12	Object
    //   33	2787	7	i	int
    //   696	1471	8	l1	long
    //   1368	803	10	l2	long
    //   1593	568	12	l3	long
    //   559	1418	14	l4	long
    //   1810	359	16	l5	long
    //   353	1496	18	l6	long
    //   364	2438	20	bool1	boolean
    //   375	148	21	bool2	boolean
    //   48	2358	22	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   561	655	1212	java/lang/Throwable
    //   655	671	1212	java/lang/Throwable
    //   677	724	1212	java/lang/Throwable
    //   732	741	1212	java/lang/Throwable
    //   747	764	1212	java/lang/Throwable
    //   764	783	1212	java/lang/Throwable
    //   783	793	1212	java/lang/Throwable
    //   796	908	1212	java/lang/Throwable
    //   908	913	1212	java/lang/Throwable
    //   923	972	1212	java/lang/Throwable
    //   972	994	1212	java/lang/Throwable
    //   994	1065	1212	java/lang/Throwable
    //   1065	1075	1212	java/lang/Throwable
    //   1075	1095	1212	java/lang/Throwable
    //   1095	1104	1212	java/lang/Throwable
    //   1104	1111	1212	java/lang/Throwable
    //   1117	1122	1212	java/lang/Throwable
    //   1125	1209	1212	java/lang/Throwable
    //   1253	1273	1212	java/lang/Throwable
    //   1273	1292	1212	java/lang/Throwable
    //   1295	1370	1212	java/lang/Throwable
    //   1377	1450	1212	java/lang/Throwable
    //   1450	1491	1212	java/lang/Throwable
    //   1494	1504	1212	java/lang/Throwable
    //   1611	1627	1212	java/lang/Throwable
    //   1725	1741	1212	java/lang/Throwable
    //   1875	1893	1212	java/lang/Throwable
    //   2237	2253	1212	java/lang/Throwable
    //   2283	2299	1212	java/lang/Throwable
    //   2351	2384	1212	java/lang/Throwable
    //   2387	2395	1212	java/lang/Throwable
    //   2403	2413	1212	java/lang/Throwable
    //   2419	2425	1212	java/lang/Throwable
    //   2431	2442	1212	java/lang/Throwable
    //   2456	2464	1212	java/lang/Throwable
    //   2472	2496	1212	java/lang/Throwable
    //   2502	2510	1212	java/lang/Throwable
    //   2542	2554	1212	java/lang/Throwable
    //   2560	2576	1212	java/lang/Throwable
    //   2584	2589	1212	java/lang/Throwable
    //   1526	1534	1667	java/io/IOException
    //   1538	1557	1667	java/io/IOException
    //   1637	1664	1667	java/io/IOException
    //   1586	1591	1874	finally
    //   1595	1611	1874	finally
    //   1749	1760	1874	finally
    //   1765	1770	1874	finally
    //   1773	1846	1874	finally
    //   1854	1871	1874	finally
    //   1893	1964	1874	finally
    //   1967	1983	1874	finally
    //   2003	2075	1874	finally
    //   2091	2118	1874	finally
    //   2118	2128	1874	finally
    //   2128	2148	1874	finally
    //   2148	2157	1874	finally
    //   1678	1696	2317	finally
    //   1696	1725	2317	finally
    //   2175	2237	2317	finally
    //   2259	2283	2317	finally
    //   2302	2314	2317	finally
    //   1514	1522	2697	finally
    //   1526	1534	2708	finally
    //   1538	1557	2708	finally
    //   1637	1664	2708	finally
    //   1557	1586	2717	finally
    //   1514	1522	2724	java/io/IOException
    //   1557	1586	2732	java/io/IOException
    //   1586	1591	2786	java/io/IOException
    //   1595	1611	2786	java/io/IOException
    //   1749	1760	2786	java/io/IOException
    //   1765	1770	2786	java/io/IOException
    //   1773	1846	2786	java/io/IOException
    //   1854	1871	2786	java/io/IOException
    //   1893	1964	2786	java/io/IOException
    //   1967	1983	2786	java/io/IOException
    //   2003	2075	2786	java/io/IOException
    //   2091	2118	2786	java/io/IOException
    //   2118	2128	2786	java/io/IOException
    //   2128	2148	2786	java/io/IOException
    //   2148	2157	2786	java/io/IOException
  }
  
  public void stopDownload()
  {
    this.mCanceled = true;
  }
  
  private static abstract interface Header
  {
    public static final String ACCEPT_ENCODING = "Accept-Encoding";
    public static final String RANGE = "Range";
    public static final String REFERER = "Referer";
    public static final String USER_AGENT = "User-Agent";
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\smtt\sdk\TbsApkDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */