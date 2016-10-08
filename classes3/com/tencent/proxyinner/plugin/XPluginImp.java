package com.tencent.proxyinner.plugin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.sixgod.pluginsdk.SixGodHelper;
import com.sixgod.pluginsdk.component.ContainerActivity;
import com.tencent.proxyinner.channel.PluginChannel;
import com.tencent.proxyinner.channel.PluginChannel.Event;
import com.tencent.proxyinner.channel.RemoteMessageSender;
import com.tencent.proxyinner.log.XLog;
import com.tencent.proxyinner.log.XLog.Event;
import com.tencent.proxyinner.plugin.Downloader.PluginChecker;
import com.tencent.proxyinner.plugin.Downloader.PluginChecker.Event;
import com.tencent.proxyinner.plugin.Downloader.PluginUpdater;
import com.tencent.proxyinner.plugin.Downloader.PluginUpdater.Event;
import com.tencent.proxyinner.plugin.Downloader.UpdateParam;
import com.tencent.proxyinner.plugin.Downloader.UpdateParam.ApkParam;
import com.tencent.proxyinner.plugin.data.XPluginInfoBuilder;
import com.tencent.proxyinner.plugin.loader.PluginLauncher;
import com.tencent.proxyinner.plugin.loader.PluginLauncher.Event;
import com.tencent.proxyinner.plugin.loader.PluginLauncher.LauncherParam;
import com.tencent.proxyinner.plugin.loader.UnZipSoListener;
import com.tencent.proxyinner.report.DataReport;
import com.tencent.proxyinner.report.DataReport.Event;
import com.tencent.proxyinner.utility.ApkUtility;
import com.tencent.proxyinner.utility.NetworkUtil;
import com.tencent.proxyinner.utility.NowPerfUtil;
import com.tencent.proxyinner.utility.UtilMisc;
import com.tencent.txproxy.HostEventListener;
import com.tencent.txproxy.InitParam;
import dalvik.system.DexClassLoader;
import java.io.File;

public class XPluginImp
  extends XStateMachine
  implements PluginLauncher.Event, PluginUpdater.Event, PluginChecker.Event, DataReport.Event, XLog.Event, PluginChannel.Event
{
  private static final int MSG_EXCUTE = 2;
  private static final int MSG_PREDOWNLOAD = 1;
  private static final int MSG_PREINSTALL_FINISH = 3;
  private static final String TAG = "TXProxy|XPluginImp";
  DataReport dataReport;
  boolean hasVersionFirst = false;
  boolean isPreDownload = false;
  boolean isPreload = false;
  PluginLauncher.LauncherParam launcherParam = new PluginLauncher.LauncherParam();
  LocalPlugin localPlugin = new LocalPlugin();
  XLog log;
  String mAppId;
  ContainerActivity mContainerActivity;
  Context mContext;
  int mDownloadType = 0;
  private Handler mHandler;
  InitParam mInitParam;
  boolean mInited;
  Intent mIntent = new Intent();
  boolean mJustCreateActivity = false;
  int mLastErrorCode = -1;
  boolean mNeedConfirm = false;
  String mNeedCreateActivityName;
  int mProgress = 0;
  UpdateParam mUpdateParam;
  public PluginChannel pluginChannel = new PluginChannel();
  public PluginChecker pluginChecker;
  public PluginLauncher pluginLoader;
  private XPluginNotifyer pluginNotifyer = new XPluginNotifyer();
  PluginUpdater pluginUpdater;
  
  private void checkVersion()
  {
    XLog.perfLog("开始版本检查");
    NowPerfUtil.step("begin to check version");
    if ((this.pluginChecker.getStatus() == 0) || (this.pluginChecker.isVersionInfoExpired())) {
      this.pluginChecker.run(this.mInitParam.mSourceId, this.mAppId, this);
    }
  }
  
  private void downloadSecretly()
  {
    if (getStatus() == 1) {
      return;
    }
    runDownloadTask();
  }
  
  private void excecute(Bundle paramBundle)
  {
    XLog.i("TXProxy|XPluginImp", "开始执行插件加载自动机，当前状态 = " + toString(this.mCurrentStatus));
    if ((this.pluginChecker.isVersionInfoExpired()) || (!isCheckedVersion()))
    {
      XLog.i("TXProxy|XPluginImp", "版本检查信息已过期，状态重置为IDEL，并重新版本检查");
      this.mCurrentStatus = 0;
      checkVersion();
    }
    int i;
    do
    {
      do
      {
        return;
        i = getStatus();
        if (i != 0) {
          break;
        }
        if (TextUtils.isEmpty(this.localPlugin.getPath()))
        {
          download(this.isPreDownload);
          return;
        }
      } while (!isCheckedVersion());
      gotoStatus(2, 0);
      installPlugin();
      return;
      if ((i == 1) && (getmCurrentFlag() == 1))
      {
        download(false);
        return;
      }
      if (i == 2)
      {
        installPlugin();
        return;
      }
      if ((i == 4) && (!this.isPreDownload))
      {
        load(this.isPreload, paramBundle);
        return;
      }
      if ((i == 6) && (!this.isPreload) && (!this.isPreDownload))
      {
        if (this.mJustCreateActivity)
        {
          paramBundle = SixGodHelper.createPluginActivity(this.mContainerActivity, this.pluginChecker.getPackName(), this.mNeedCreateActivityName, this.mIntent, null);
          this.pluginNotifyer.onGetPluginActivity(paramBundle);
          return;
        }
        start(paramBundle);
        return;
      }
    } while ((i != 8) || (this.isPreload) || (this.isPreDownload));
    start(paramBundle);
  }
  
  private int getNetworkSubType()
  {
    if (this.mContext == null) {}
    NetworkInfo localNetworkInfo;
    do
    {
      return 30;
      localNetworkInfo = ((ConnectivityManager)this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
    } while (localNetworkInfo == null);
    if (!localNetworkInfo.isAvailable()) {
      return 31;
    }
    return localNetworkInfo.getSubtype();
  }
  
  private int getNetworkType()
  {
    if (this.mContext == null) {}
    NetworkInfo localNetworkInfo;
    do
    {
      return 30;
      localNetworkInfo = ((ConnectivityManager)this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
    } while (localNetworkInfo == null);
    if (!localNetworkInfo.isAvailable()) {
      return 31;
    }
    return localNetworkInfo.getType();
  }
  
  private void installPluginInner(final boolean paramBoolean)
  {
    if (TextUtils.isEmpty(this.pluginChecker.getPackName()))
    {
      if (paramBoolean) {
        return;
      }
      postAsync(3, 1, 0, null, 0L);
    }
    final int i = this.localPlugin.getMaxSdkVersionWithoutConfirm();
    final String str1 = this.localPlugin.getPluginPathWihoutConfirm();
    final String str2 = this.localPlugin.getPluginOptDexDir() + this.pluginChecker.getPackName() + File.separator + "optDex" + "_" + this.localPlugin.getMaxSdkVersionWithoutConfirm() + File.separator;
    final String str3 = this.localPlugin.getPluginOptDexDir() + this.pluginChecker.getPackName() + File.separator + "lib" + "_" + this.localPlugin.getMaxSdkVersionWithoutConfirm() + File.separator;
    NowPerfUtil.step("xproxy start to installplugin");
    if ((!TextUtils.isEmpty(this.localPlugin.getPreInstalledPlugin(i))) && (new File(str3).length() > 0L))
    {
      XLog.i("TXProxy|XPluginImp", str1 + " 已经安装过，不再处理");
      gotoStatus(4, 0);
      postAsync(2, 0, 0, this.mIntent.getExtras(), 0L);
      return;
    }
    if ((!this.isPreDownload) && (!this.isPreload)) {
      onUpdateProgress(100);
    }
    new Thread(new Runnable()
    {
      public void run()
      {
        try
        {
          localObject1 = new File(str2);
          if (!((File)localObject1).exists()) {
            ((File)localObject1).mkdirs();
          }
          new DexClassLoader(str1, str2, null, XPluginImp.this.mContext.getClassLoader().getParent());
          NowPerfUtil.step("new dexclassloader  finish,begin to move so");
          if ((!XPluginImp.this.isPreDownload) && (!XPluginImp.this.isPreload)) {
            XPluginImp.this.onUpdateProgress(100);
          }
          if (!XPluginImp.this.mAppId.equals("Live")) {
            break label283;
          }
          XPluginImp.this.onUnZipSo(str1, null);
          NowPerfUtil.step("move so file finish");
          Log.i("TXProxy|XPluginImp", "预优化完成，优化文件目录=" + str2);
          if ((!XPluginImp.this.isPreDownload) && (!XPluginImp.this.isPreload)) {
            XPluginImp.this.onUpdateProgress(100);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Object localObject1;
            label283:
            new File(XPluginImp.this.localPlugin.getPluginPathWihoutConfirm()).delete();
            XPluginImp.this.postAsync(3, 1, 0, null, 0L);
          }
        }
        finally {}
        XPluginImp.this.localPlugin.setPreinstalledPlugin(i, str1);
        XPluginImp.this.localPlugin.setNeedConfirm(XPluginImp.this.mNeedConfirm, i);
        NowPerfUtil.step("install plugin finish");
        if (!paramBoolean)
        {
          XPluginImp.this.gotoStatus(4, 0);
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("odexPath", str2);
          ((Bundle)localObject1).putString("soPath", str3);
          XPluginImp.this.postAsync(3, 0, 0, (Bundle)localObject1, 0L);
        }
        for (;;)
        {
          return;
          SixGodHelper.moveSoFile(XPluginImp.this.mContext, str1, XPluginImp.this.pluginChecker.getPackName(), String.valueOf(XPluginImp.this.localPlugin.getMaxSdkVersion()));
          break;
          NowPerfUtil.step("本次安装只是预安装，不影响状态");
        }
      }
    }).start();
  }
  
  private void postAsync(int paramInt1, int paramInt2, int paramInt3, Bundle paramBundle, long paramLong)
  {
    Message localMessage = Message.obtain();
    localMessage.what = paramInt1;
    localMessage.arg1 = paramInt2;
    localMessage.arg2 = paramInt3;
    localMessage.setData(paramBundle);
    if (paramLong == 0L)
    {
      this.mHandler.sendMessage(localMessage);
      return;
    }
    this.mHandler.sendMessageDelayed(localMessage, paramLong);
  }
  
  private void reportDownloadComplete(int paramInt)
  {
    DataReport localDataReport = this.dataReport;
    int j = this.mDownloadType;
    if (this.isPreDownload) {}
    for (int i = 1;; i = 2)
    {
      localDataReport.reportDownloadComplete(paramInt, j, i, this.pluginUpdater.getLastResponseCode(), this.pluginUpdater.getLastHostErrCode(), this.pluginUpdater.getLastHeadInfo(), this.pluginUpdater.getLastError(), getNetworkType(), getNetworkSubType(), this.pluginChecker.getCheckUrl());
      resetDownloadReportData();
      return;
    }
  }
  
  private void resetDownloadReportData()
  {
    this.mDownloadType = 2;
  }
  
  private boolean startImpl(Bundle paramBundle)
  {
    gotoStatus(7, 0);
    this.launcherParam.mIsMoveSoFile = false;
    this.launcherParam.isLoad = false;
    this.launcherParam.params = paramBundle;
    this.launcherParam.activityName = paramBundle.getString("launchername");
    paramBundle = paramBundle.getString("vasschema");
    if (!TextUtils.isEmpty(paramBundle)) {
      this.launcherParam.data = Uri.parse(paramBundle);
    }
    this.pluginLoader.start(this.launcherParam);
    return true;
  }
  
  public void addListener(IXPluginEventListener paramIXPluginEventListener)
  {
    this.pluginNotifyer.addListener(paramIXPluginEventListener);
  }
  
  public void cancelRun(String paramString)
  {
    XLog.i("TXProxy|XPluginImp", "cancelRun reason = " + paramString);
    if (this.pluginUpdater != null) {
      this.dataReport.reportAction("cancelrun", getStatus(), getPluginDownloadType(), this.pluginUpdater.getLastResponseCode(), 0, 0, this.pluginUpdater.getLastError(), paramString, "", "", "");
    }
    for (;;)
    {
      this.isPreload = true;
      return;
      this.dataReport.reportAction("cancelrun", getStatus(), getPluginDownloadType(), 0, 0, 0, "", paramString, "", "", "");
    }
  }
  
  public void dataReport(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    DataReport localDataReport = this.dataReport;
    DataReport.getInstance().reportAction(paramString1, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramString2, paramString3, paramString4, paramString5, paramString6);
  }
  
  public boolean download(boolean paramBoolean)
  {
    XLog.i("TXProxy|XPluginImp", "插件开始下载，isPreDownload = " + paramBoolean);
    NowPerfUtil.step("begin download plugin");
    if (this.mCurrentStatus != 0) {
      return false;
    }
    this.isPreDownload = paramBoolean;
    gotoStatus(1, 0);
    if ((this.pluginChecker.getStatus() == 0) || (this.pluginChecker.getStatus() == 1)) {
      XLog.i("TXProxy|XPluginImp", "版本检查还没有完成，或者在进行中,直接返回");
    }
    runDownloadTask();
    return true;
  }
  
  public String getCheckConfigString()
  {
    return this.pluginChecker.getJsonString();
  }
  
  public UpdateParam getCheckVersionInfo()
  {
    return this.mUpdateParam;
  }
  
  public void getPluginActivity(ContainerActivity paramContainerActivity, String paramString, Bundle paramBundle)
  {
    XLog.i("TXProxy|XPluginImp", "getPluginActivity");
    setSourceInfo(paramBundle);
    this.mContainerActivity = paramContainerActivity;
    this.mJustCreateActivity = true;
    this.mNeedCreateActivityName = paramString;
    postAsync(2, 0, 0, this.mIntent.getExtras(), 0L);
  }
  
  public int getPluginDownloadType()
  {
    return this.mDownloadType;
  }
  
  public int getPluginSize()
  {
    return this.mUpdateParam.getFirstTagParam().size;
  }
  
  protected boolean gotoStatus(int paramInt1, int paramInt2)
  {
    int i = getStatus();
    boolean bool = super.gotoStatus(paramInt1, paramInt2);
    if (bool)
    {
      XLog.i("TXProxy|XPluginImp", String.format("切换自动机状态 从%s切换到%s", new Object[] { toString(i), toString(getStatus()) }));
      this.pluginNotifyer.onStatusChanged(i, getStatus(), 0, paramInt2);
    }
    return bool;
  }
  
  public boolean haslocalOdexedPlugin()
  {
    XLog.i("TXProxy|XPluginImp", "haslocalOdexedPlugin");
    if (!this.mInitParam.mNeedSilentUpdate)
    {
      if ((this.localPlugin.isPluginIsConfirmed(this.localPlugin.getMaxSdkVersionPathWithoutConfirm(), this.localPlugin.getMaxSdkVersionWithoutConfirm())) && (this.localPlugin.isExistInstallPlugin())) {}
      for (bool = true;; bool = false) {
        return bool;
      }
    }
    if (!TextUtils.isEmpty(this.localPlugin.getPreInstalledPlugin(this.localPlugin.getMaxSdkVersionWithoutConfirm()))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void initParam(String paramString, Context paramContext, InitParam paramInitParam)
  {
    XLog.i("TXProxy|XPluginImp", "runPlugin");
    this.mContext = paramContext;
    this.mAppId = paramString;
    this.mInitParam = paramInitParam;
    if ((paramContext == null) || (this.mInitParam == null))
    {
      this.pluginNotifyer.onError(1);
      return;
    }
    this.mIntent = XPluginInfoBuilder.setInitParam(paramString, this.mIntent, paramInitParam);
    this.mHandler = new Handler()
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        boolean bool = true;
        if (paramAnonymousMessage.what == 2) {
          XPluginImp.this.excecute(paramAnonymousMessage.getData());
        }
        label122:
        label192:
        do
        {
          do
          {
            return;
            if (paramAnonymousMessage.what != 1) {
              break label192;
            }
            if (paramAnonymousMessage.arg1 != 0) {}
            for (;;)
            {
              paramAnonymousMessage = ((ConnectivityManager)XPluginImp.this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
              if ((paramAnonymousMessage == null) || (paramAnonymousMessage.getType() != 1)) {
                break;
              }
              Log.e("TXProxy|XPluginImp", "predownload  start download od plugin!");
              if (XPluginImp.this.mCurrentStatus != 0) {
                break label122;
              }
              Log.i("TXProxy|XPluginImp", "预下载，本地没有包，直接启动下载");
              XPluginImp.this.isPreDownload = true;
              XPluginImp.this.download(XPluginImp.this.isPreDownload);
              return;
            }
            if (XPluginImp.this.mCurrentStatus != 1) {
              break;
            }
          } while (!UtilMisc.isTestEnv(XPluginImp.this.mAppId));
          Log.i("TXProxy|XPluginImp", "预下载，当前正在，忽略预下载");
          return;
          if (UtilMisc.isTestEnv(XPluginImp.this.mAppId)) {
            Log.i("TXProxy|XPluginImp", "预下载，后台偷偷更新，不影响当前状态");
          }
          XPluginImp.this.isPreDownload = true;
          XPluginImp.this.runDownloadTask();
          return;
        } while (paramAnonymousMessage.what != 3);
        int i = paramAnonymousMessage.arg1;
        String str = paramAnonymousMessage.getData().getString("soPath");
        paramAnonymousMessage = paramAnonymousMessage.getData().getString("odexPath");
        XPluginNotifyer localXPluginNotifyer = XPluginImp.this.pluginNotifyer;
        if (i == 0) {}
        for (;;)
        {
          localXPluginNotifyer.onPreInstallFinish(bool, str, paramAnonymousMessage);
          XPluginImp.this.postAsync(2, 0, 0, XPluginImp.this.mIntent.getExtras(), 0L);
          return;
          bool = false;
        }
      }
    };
    this.localPlugin.init(this.mContext, this.mAppId, this.mInitParam.mPluginName);
    this.localPlugin.clearAllExpiredSdkVersion();
    this.log = XLog.getInstance();
    this.dataReport = DataReport.getInstance();
    this.dataReport.setSourceInfo(this.mAppId, 0, this.mInitParam.mSourceVersion, this.mInitParam.mChannelId, this.mInitParam.mChannelType, this.mInitParam.isDataReportInHost);
    this.pluginChecker = new PluginChecker(this.localPlugin);
    this.pluginLoader = new PluginLauncher();
    this.pluginLoader.init(this.mContext);
    this.pluginLoader.addListener(this);
    this.pluginChannel.create(this.mContext, this.mAppId, String.valueOf(this.mInitParam.mChannelType));
    this.pluginChannel.addEventListener(this);
    this.dataReport.addListener(this);
    this.log.addListener(this);
    paramString = this.mContext.getSharedPreferences("Proxy", 0);
    if ((paramString.getInt("sdkSupport", -1) == -1) && ((this.localPlugin.isExistLocalPlugin()) || (this.localPlugin.isExistInstallPlugin())))
    {
      paramString = paramString.edit();
      paramString.putInt("sdkSupport", 1);
      paramString.commit();
    }
    isSdkSupport();
    this.hasVersionFirst = this.localPlugin.isExistInstallPlugin();
    if (this.hasVersionFirst) {}
    for (int i = 2;; i = 1)
    {
      this.mDownloadType = i;
      gotoStatus(0, 0);
      return;
    }
  }
  
  public void installPlugin()
  {
    if (getStatus() == 3)
    {
      XLog.i("TXProxy|XPluginImp", "installPlugin 插件正在安装中，直接返回");
      return;
    }
    gotoStatus(3, 0);
    installPluginInner(false);
  }
  
  public boolean isCheckedVersion()
  {
    return (this.pluginChecker.getStatus() == 2) && (!this.pluginChecker.isVersionInfoExpired());
  }
  
  public boolean isSdkSupport()
  {
    boolean bool2 = false;
    int i = this.mContext.getSharedPreferences("Proxy", 0).getInt("sdkSupport", -1);
    boolean bool1 = bool2;
    if (i != -1)
    {
      Log.i("TXProxy|XPluginImp", "isSdkSupport, sp load: " + i);
      bool1 = bool2;
      if (i != 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean load(boolean paramBoolean, Bundle paramBundle)
  {
    if (getStatus() != 4) {
      return false;
    }
    NowPerfUtil.step("begin load plugin");
    gotoStatus(5, 0);
    try
    {
      paramBundle.putLong("uin", Long.parseLong(this.mInitParam.mSourceId));
      this.launcherParam.mApkPath = this.localPlugin.getPath();
      this.launcherParam.params = paramBundle;
      this.launcherParam.mPakageName = this.pluginChecker.getPackName();
      this.launcherParam.mIsMoveSoFile = false;
      this.launcherParam.isLoad = true;
      this.launcherParam.mMapComponent = this.mInitParam.mComponentMap;
      this.launcherParam.mDefaultContainerActivity = this.mInitParam.mDefaultContainerActivity;
      this.launcherParam.mDefaultContainerService = this.mInitParam.mDefaultContainerService;
      this.launcherParam.mDefaultLoadApkActivity = this.mInitParam.mDefaultLoadApkActivity;
      this.launcherParam.mVersionName = String.valueOf(this.localPlugin.getMaxSdkVersion());
      if (this.mAppId.equals("Live")) {
        this.launcherParam.mProcessName = "com.tencent.mobileqq:tool";
      }
      i = paramBundle.getInt("vastype");
      if (i == 2)
      {
        this.launcherParam.mProcessName = ":web";
        this.pluginLoader.load(this.launcherParam);
        return true;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        int i;
        localNumberFormatException.printStackTrace();
        XLog.i("TXProxy|XPluginImp", "mOpenroomParam.mSourceId NumberFormatException");
        continue;
        if (i == 3) {
          this.launcherParam.mProcessName = ":homework";
        }
      }
    }
  }
  
  public void loadplugin()
  {
    XLog.i("TXProxy|XPluginImp", "loadlugin");
    this.isPreload = true;
    this.isPreDownload = false;
    if ((this.mAppId.equals("Live")) && (!ApkUtility.isProcessExist(this.mContext, "com.tencent.mobileqq:tool"))) {
      this.mCurrentStatus = 0;
    }
    postAsync(2, 0, 0, new Bundle(), 0L);
  }
  
  public void onCheckCompleted(boolean paramBoolean, final UpdateParam paramUpdateParam)
  {
    XLog.perfLog("版本检查完成，succ =  " + paramBoolean + "请求url = " + this.pluginChecker.getCheckUrl());
    NowPerfUtil.step("onCheckCompleted");
    if (this.mCurrentStatus == 1) {
      i = 1;
    }
    for (;;)
    {
      if (paramBoolean)
      {
        if (this.localPlugin.isExistInstallPlugin())
        {
          gotoStatus(2, 0);
          label77:
          if (this.hasVersionFirst) {
            break label176;
          }
          this.mDownloadType = 1;
        }
        try
        {
          for (;;)
          {
            l = Long.parseLong(this.mInitParam.mSourceId);
            this.pluginUpdater = PluginUpdater.create(this.mInitParam.mChannelType, this.localPlugin, l);
            postAsync(2, 0, 0, this.mIntent.getExtras(), 0L);
            this.mHandler.postDelayed(new Runnable()
            {
              public void run()
              {
                if ((paramUpdateParam.newVersionExit) && (XPluginImp.this.mInitParam.mNeedSilentUpdate))
                {
                  XLog.i("TXProxy|XPluginImp", "服务器上有新版本，开始静默更新");
                  XPluginImp.this.downloadSecretly();
                }
              }
            }, 60000L);
            return;
            i = 0;
            break;
            gotoStatus(this.mCurrentStatus, 1);
            break label77;
            label176:
            if (this.pluginChecker.isForceDownload()) {
              this.mDownloadType = 3;
            } else {
              this.mDownloadType = 2;
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            long l = 0L;
          }
        }
      }
    }
    this.mLastErrorCode = 1;
    int j;
    if (i != 0)
    {
      XLog.e("TXProxy|XPluginImp", "check faild! errInfo = " + this.pluginChecker.getLastError());
      paramUpdateParam = this.dataReport;
      j = this.mDownloadType;
      if (!this.isPreDownload) {
        break label369;
      }
      i = 1;
      paramUpdateParam.reportDownloadStart(j, i);
      paramUpdateParam = this.dataReport;
      j = this.mDownloadType;
      if (!this.isPreDownload) {
        break label375;
      }
    }
    label369:
    label375:
    for (int i = 1;; i = 2)
    {
      paramUpdateParam.reportDownloadComplete(1, j, i, this.pluginChecker.getLastHttpResponseCode(), 0, this.pluginChecker.getLastHeadInfo(), this.pluginChecker.getLastError(), NetworkUtil.getNetworkType(this.mContext), NetworkUtil.getNetworkSubType(this.mContext), this.pluginChecker.getCheckUrl());
      this.pluginNotifyer.onError(-1);
      gotoStatus(0, 2);
      return;
      i = 2;
      break;
    }
  }
  
  public void onDataReport(String paramString, Bundle paramBundle)
  {
    this.pluginNotifyer.onDataReport(paramString, paramBundle);
  }
  
  public void onHasPlugin(boolean paramBoolean)
  {
    Log.i("TXProxy|XPluginImp", "onHasPlugin, hasPlugin: " + paramBoolean);
    if (paramBoolean)
    {
      SharedPreferences.Editor localEditor = this.mContext.getSharedPreferences("Proxy", 0).edit();
      localEditor.putInt("sdkSupport", 1);
      Log.i("TXProxy|XPluginImp", "onHasPlugin, save sp: 1");
      localEditor.commit();
    }
  }
  
  public void onLoadError(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    XLog.e("TXProxy|XPluginImp", "插件加载/启动失败,code = " + paramInt1 + " res = " + paramInt2 + "descMsg = " + paramString2);
    this.dataReport.reportBootComplete(false, paramInt1, paramInt2, paramString2);
    this.pluginNotifyer.onError(-2);
    this.pluginChannel.stop();
    if (this.localPlugin.isExistLocalPlugin())
    {
      gotoStatus(2, 1000);
      return;
    }
    this.pluginUpdater.resetStatus();
    gotoStatus(0, 1);
  }
  
  public void onLoaded(PluginLauncher.LauncherParam paramLauncherParam)
  {
    NowPerfUtil.step("xproxy load plugin success pkg  = " + paramLauncherParam.mPakageName);
    gotoStatus(6, 0);
    postAsync(2, 0, 0, this.mIntent.getExtras(), 0L);
  }
  
  public void onLog(String paramString1, String paramString2, int paramInt)
  {
    this.pluginNotifyer.onLog(paramString1, paramString2, paramInt);
  }
  
  public void onNoNeedUpdate()
  {
    if (this.mCurrentStatus == 1)
    {
      XLog.i("TXProxy|XPluginImp", "下载结果：无更新");
      gotoStatus(2, 0);
      return;
    }
    XLog.i("TXProxy|XPluginImp", "后台偷偷更新, 结果：无更新");
  }
  
  public void onNoUpdate()
  {
    if (this.mCurrentStatus == 1)
    {
      if (UtilMisc.isTestEnv(this.mAppId)) {
        XLog.i("TXProxy|XPluginImp", "下载结果：无更新");
      }
      gotoStatus(2, 0);
    }
    for (;;)
    {
      this.mLastErrorCode = 5;
      reportDownloadComplete(5);
      return;
      XLog.i("TXProxy|XPluginImp", "后台偷偷更新, 结果：无更新");
    }
  }
  
  public void onRemoteRequest(String paramString, Bundle paramBundle)
  {
    XLog.i("TXProxy|XPluginImp", "收到远程广播，通知宿主 cmd = " + paramString);
    this.pluginNotifyer.onRecvMessage(paramString, paramBundle);
  }
  
  public void onStartDownloadFile(String paramString1, String paramString2, HostEventListener paramHostEventListener)
  {
    this.pluginNotifyer.onDownloadFile(paramString1, paramString2, paramHostEventListener);
  }
  
  public void onStartIncUpdate(Bundle paramBundle)
  {
    sendMessage("com.tencent.od.incupdate", paramBundle);
  }
  
  public void onStarted(String paramString)
  {
    NowPerfUtil.step("xproxy start plugin activity finish, pkg = " + paramString);
    new Handler().postDelayed(new Runnable()
    {
      public void run() {}
    }, 15000L);
    this.pluginNotifyer.onOpenRoom(paramString);
    gotoStatus(8, 0);
    this.dataReport.reportBootComplete(true, 0, 0, "");
  }
  
  public void onUnZipSo(String paramString, UnZipSoListener paramUnZipSoListener)
  {
    XLog.perfLog("开始7zip解压so");
    String str = this.localPlugin.getPluginOptDexDir() + this.pluginChecker.getPackName() + File.separator + "lib" + "_" + this.localPlugin.getMaxSdkVersionWithoutConfirm() + File.separator;
    this.pluginNotifyer.onUnZipSo(paramString, paramUnZipSoListener, str);
    XLog.perfLog("7zip解压so完成");
  }
  
  public void onUpdateError(int paramInt)
  {
    if (this.mCurrentStatus == 1)
    {
      XLog.i("TXProxy|XPluginImp", "下载出错，code" + paramInt + " errInfo = " + this.pluginUpdater.getLastError() + "headInfo = " + this.pluginUpdater.getLastHeadInfo());
      this.pluginNotifyer.onError(paramInt);
      gotoStatus(0, 0);
    }
    for (;;)
    {
      this.mLastErrorCode = paramInt;
      reportDownloadComplete(paramInt);
      return;
      if (PluginUpdater.isIncUpdateError(paramInt)) {
        runDownloadTask();
      } else {
        XLog.i("TXProxy|XPluginImp", "后台偷偷更新失败了，code = " + paramInt);
      }
    }
  }
  
  public void onUpdateProgress(int paramInt)
  {
    this.mProgress = paramInt;
    if (getStatus() == 1) {
      this.pluginNotifyer.onStatusChanged(this.mCurrentStatus, this.mCurrentStatus, paramInt, 0);
    }
  }
  
  public void onUpdated()
  {
    if (this.mCurrentStatus == 1)
    {
      XLog.perfLog("下载完成");
      NowPerfUtil.step("update plugin finish");
      gotoStatus(2, 0);
      postAsync(2, 0, 0, this.mIntent.getExtras(), 0L);
    }
    for (;;)
    {
      this.mLastErrorCode = 0;
      reportDownloadComplete(0);
      return;
      NowPerfUtil.step("update plugin finish,begin to install");
      preInstallPlugin();
    }
  }
  
  public void preInstallPlugin()
  {
    installPluginInner(true);
  }
  
  public void registerPluginMsg(String paramString)
  {
    this.pluginChannel.register(paramString);
  }
  
  public boolean reload()
  {
    XLog.i("TXProxy|XPluginImp", "插件重新加载");
    if (!unload(Boolean.valueOf(false))) {
      return false;
    }
    return load(this.isPreload, this.mIntent.getExtras());
  }
  
  public void removeListener(IXPluginEventListener paramIXPluginEventListener)
  {
    this.pluginNotifyer.removeListener(paramIXPluginEventListener);
  }
  
  void runDownloadTask()
  {
    int i = 1;
    if (this.mCurrentStatus == 1) {
      gotoStatus(1, this.mDownloadType);
    }
    boolean bool = this.mInitParam.isDownloadInHost;
    DataReport localDataReport;
    int j;
    if (this.pluginUpdater.run(this, Boolean.valueOf(bool).booleanValue(), this.pluginChecker.getJsonString()))
    {
      localDataReport = this.dataReport;
      j = this.mDownloadType;
      if (!this.isPreDownload) {
        break label79;
      }
    }
    for (;;)
    {
      localDataReport.reportDownloadStart(j, i);
      return;
      label79:
      i = 2;
    }
  }
  
  public void runPlugin(Bundle paramBundle)
  {
    this.isPreload = false;
    this.isPreDownload = false;
    setSourceInfo(paramBundle);
    if (("Live".equals(this.mAppId)) && (this.mCurrentStatus == 8) && (!ApkUtility.isProcessExist(this.mContext, "com.tencent.mobileqq:tool"))) {
      gotoStatus(4, 0);
    }
    postAsync(2, 0, 0, this.mIntent.getExtras(), 0L);
  }
  
  public void sendMessage(String paramString, Bundle paramBundle)
  {
    this.pluginChannel.sender.sendMessage(paramString, paramBundle);
  }
  
  public void setSourceInfo(Bundle paramBundle)
  {
    this.mIntent.putExtras(paramBundle);
    int i = paramBundle.getInt("vastype");
    boolean bool = paramBundle.getBoolean("reporthost");
    paramBundle = this.mInitParam.mSourceId;
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramBundle);
      l1 = l2;
    }
    catch (NumberFormatException paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
      }
    }
    this.dataReport.setSourceInfo(this.mAppId, i, this.mInitParam.mSourceVersion, this.mInitParam.mChannelId, l1, bool);
    this.log.setSourceInfo(this.mInitParam.isLogInHost);
  }
  
  public boolean start(Bundle paramBundle)
  {
    if (!this.localPlugin.isExistLocalPlugin()) {
      onLoadError("com.tencent.intervideo.xplatform", 2, 10004, "not_exit_install_plugin");
    }
    do
    {
      return false;
      XLog.perfLog("插件尝试启动 mCurrentStatus = " + this.mCurrentStatus);
    } while ((this.mCurrentStatus != 6) && (this.mCurrentStatus != 8));
    paramBundle.putString("versioncgitext", this.pluginChecker.getJsonString());
    paramBundle.putString("rootpath", this.localPlugin.getSdkPath());
    return startImpl(paramBundle);
  }
  
  public void unInit(boolean paramBoolean)
  {
    Log.i("TXProxy|XPluginImp", "unInit");
    unload(Boolean.valueOf(paramBoolean));
    Log.i("TXProxy|XPluginImp", "unInit suc ");
    this.pluginChannel.removeEventListener(this);
    this.pluginChannel.destroy();
    this.mCurrentStatus = 0;
    this.mInited = false;
  }
  
  public boolean unload(Boolean paramBoolean)
  {
    XLog.i("TXProxy|XPluginImp", "插件尝试卸载 mCurrentStatus = " + this.mCurrentStatus);
    if ((this.mCurrentStatus != 6) && (this.mCurrentStatus != 8)) {
      return false;
    }
    this.pluginChannel.stop();
    if ((getStatus() == 6) || (getStatus() == 8))
    {
      this.pluginLoader.unInit(paramBoolean.booleanValue());
      gotoStatus(2, 0);
    }
    this.isPreDownload = true;
    return true;
  }
  
  public void updatePluginAndPreInstall(boolean paramBoolean)
  {
    XLog.i("TXProxy|XPluginImp", "updatePluginAndPreInstall");
    this.mNeedConfirm = paramBoolean;
    this.isPreDownload = true;
    excecute(new Bundle());
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\proxyinner\plugin\XPluginImp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */