package com.tencent.proxyinner.plugin.loader;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.sixgod.pluginsdk.PluginCallback;
import com.sixgod.pluginsdk.PluginLoadParams;
import com.sixgod.pluginsdk.SixGodHelper;
import com.tencent.proxyinner.log.XLog;
import com.tencent.proxyinner.report.DataReport;
import com.tencent.proxyinner.utility.ApkUtility;
import com.tencent.proxyinner.utility.NowPerfUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PluginLauncher
  implements PluginLoaderMonitor.IMonitorListener, PluginCallback
{
  private static final int MSG_CRASHED = 6;
  private static final int MSG_LOAD_FAIL = 2;
  private static final int MSG_LOAD_SUCC = 1;
  private static final int MSG_MOVE_SO_FILE = 9;
  private static final int MSG_MOVE_SO_FILE_FAIL = 8;
  private static final int MSG_MOVE_SO_FILE_SUCC = 7;
  private static final int MSG_START_FAIL = 5;
  private static final int MSG_START_SUCC = 4;
  private static final int RES_LOAD_CRASHED = 10003;
  private static final int RES_LOAD_FAIL = 1;
  private static final int RES_LOAD_SUCC = 0;
  private static final int RES_LOAD_TIMEOUT = 10001;
  private static final int RES_START_APK_NOT_EXIST = 10005;
  private static final int RES_START_CRASHED = 10004;
  private static final int RES_START_FAIL = 2;
  private static final int RES_START_PARAM_INVALID = 10006;
  private static final int RES_START_TIMEOUT = 10002;
  private static final String TAG = "TXProxy|PluginLoader";
  private static int mTimeoutDelay = 60000;
  private Context mContext;
  private List<Event> mEventList = new ArrayList();
  private Handler mHandler = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      PluginLauncher.this.monitor.stopTimeoutMonitor();
      Object localObject = paramAnonymousMessage.getData();
      int i = 0;
      String str1 = "";
      String str2 = "";
      if (localObject != null)
      {
        i = ((Bundle)localObject).getInt("res");
        str1 = ((Bundle)localObject).getString("descmsg");
        str2 = ((Bundle)localObject).getString("packagename");
      }
      localObject = PluginLauncher.this.mEventList.iterator();
      for (;;)
      {
        PluginLauncher.Event localEvent;
        if (((Iterator)localObject).hasNext())
        {
          localEvent = (PluginLauncher.Event)((Iterator)localObject).next();
          if (paramAnonymousMessage.what == 1)
          {
            XLog.i("TXProxy|PluginLoader", "加载插件成功");
            localEvent.onLoaded(PluginLauncher.this.mParams);
            continue;
          }
          if (paramAnonymousMessage.what == 4)
          {
            XLog.i("TXProxy|PluginLoader", "启动插件成功");
            localEvent.onStarted(str2);
            continue;
          }
          if (paramAnonymousMessage.what == 2)
          {
            XLog.e("TXProxy|PluginLoader", "加载插件失败");
            localEvent.onLoadError(str2, 1, i, str1);
            continue;
          }
          if (paramAnonymousMessage.what == 5)
          {
            XLog.e("TXProxy|PluginLoader", "启动插件失败");
            PluginLauncher.this.unload(false);
            localEvent.onLoadError(str2, 2, i, str1);
            continue;
          }
          if (paramAnonymousMessage.what != 7) {
            break label319;
          }
          XLog.i("TXProxy|PluginLoader", "拷贝ｓｏ文件成功");
          if (PluginLauncher.this.mThread != null)
          {
            PluginLauncher.this.mThread.interrupt();
            PluginLauncher.this.mThread = null;
          }
          if (!SixGodHelper.isPluginLoaded(PluginLauncher.this.mParams.mPakageName)) {}
        }
        else
        {
          return;
        }
        PluginLauncher.this.mParams.mIsMoveSoFile = false;
        PluginLauncher.this.launchPlugin(PluginLauncher.this.mContext, PluginLauncher.this.mParams);
        continue;
        label319:
        if (paramAnonymousMessage.what == 8)
        {
          XLog.i("TXProxy|PluginLoader", "拷贝ｓｏ文件失败");
          localEvent.onLoadError(str2, 1, i, str1);
        }
      }
    }
  };
  private boolean mIsPreload = false;
  LauncherParam mParams;
  HandlerThread mThread;
  private UnZipSoListener mUnZipSoListener = new UnZipSoListener()
  {
    public void onUnZipComplete(boolean paramAnonymousBoolean)
    {
      if (paramAnonymousBoolean)
      {
        PluginLauncher.this.postCallback(7, PluginLauncher.this.mParams.mPakageName, 0, "");
        return;
      }
      PluginLauncher.this.postCallback(8, PluginLauncher.this.mParams.mPakageName, 10003, "move so file fail!");
    }
  };
  private PluginLoaderMonitor monitor = new PluginLoaderMonitor();
  
  private PluginLoadParams buildSixgodLoadPluginParams(LauncherParam paramLauncherParam)
  {
    PluginLoadParams localPluginLoadParams = new PluginLoadParams(paramLauncherParam.mApkPath, paramLauncherParam.mPakageName, ApkUtility.getApkName(paramLauncherParam.mApkPath));
    if (paramLauncherParam.mPakageName.equals("com.tencent.huayang"))
    {
      localPluginLoadParams.defaultUseActionBar = true;
      localPluginLoadParams.defaultActivityContainer = "com.tencent.proxyinner.plugin.loader.HYContainnerActivity";
      localPluginLoadParams.componentMap.put("com.tencent.tmdownloader.TMAssistantDownloadService", "com.tencent.pluginloader.proxy.DownloadProxyService");
      localPluginLoadParams.componentMap.put("com.tencent.hy.module.web.WebActivity", "com.tencent.proxyinner.plugin.loader.HYWebProxyActivity");
      localPluginLoadParams.componentMap.put("com.tencent.hy.module.startup.LauncherActivity", "com.tencent.proxyinner.plugin.loader.HYSingleTopProxyActivity");
      localPluginLoadParams.componentMap.put("com.tencent.hy.module.room.QtService", "com.tencent.proxyinner.plugin.loader.QTProxyService");
      localPluginLoadParams.componentMap.put("com.tencent.wns.export.EmptyService", "com.tencent.proxyinner.plugin.loader.WNSProxyService");
      localPluginLoadParams.componentMap.put("com.tencent.wns.service.WnsMain", "com.tencent.proxyinner.plugin.loader.WNSProxyService");
      localPluginLoadParams.componentMap.put("com.tencent.hy.module.mainpage.MainFragmentActivity", "com.tencent.proxyinner.plugin.loader.HYMainFragmentActivity");
    }
    for (;;)
    {
      localPluginLoadParams.pluginLoadCallBack = this;
      if (!TextUtils.isEmpty(paramLauncherParam.mDefaultContainerActivity)) {
        localPluginLoadParams.defaultActivityContainer = paramLauncherParam.mDefaultContainerActivity;
      }
      if (!TextUtils.isEmpty(paramLauncherParam.mDefaultLoadApkActivity)) {
        localPluginLoadParams.defaultLoadApkActivity = paramLauncherParam.mDefaultLoadApkActivity;
      }
      localPluginLoadParams.useBootClassLoader = true;
      if (paramLauncherParam.mMapComponent.size() > 0) {
        localPluginLoadParams.componentMap.putAll(paramLauncherParam.mMapComponent);
      }
      localPluginLoadParams.versionName = paramLauncherParam.mVersionName;
      return localPluginLoadParams;
      if (paramLauncherParam.mPakageName.equals("com.tencent.mobileqq"))
      {
        localPluginLoadParams.defaultActivityContainer = "com.tencent.proxyinner.plugin.loader.ODContainnerActivity";
        localPluginLoadParams.defaultLoadApkActivity = "com.tencent.pluginloader.proxy.ODLoadActivity";
        localPluginLoadParams.componentMap.put("com.tencent.od.app.newloginprocess.EnteringRoomActivity", "com.tencent.pluginloader.proxy.ODLoadActivity");
        localPluginLoadParams.componentMap.put("com.tencent.od.app.newloginprocess.LoginActivity", "com.tencent.pluginloader.proxy.ODLoadActivity");
        localPluginLoadParams.componentMap.put("com.tencent.od.app.ODRoomActivity", "com.tencent.proxyinner.plugin.loader.ODSingleTopProxyActivity");
      }
      else if (paramLauncherParam.mPakageName.equals("com.tencent.intervideo.xplatform"))
      {
        localPluginLoadParams.defaultUseActionBar = true;
        XLog.i("perflog", "开始加载xplatform time = " + System.currentTimeMillis());
        localPluginLoadParams.defaultActivityContainer = "com.tencent.proxyinner.plugin.loader.HYContainnerActivity";
        localPluginLoadParams.componentMap.put("com.tencent.hycopy.module.login.HuayangLoginInput", "com.tencent.proxyinner.plugin.loader.HYNoHistoryActivity");
        localPluginLoadParams.componentMap.put("com.tencent.intervideo.xplatform.SplashActivity", "com.tencent.proxyinner.plugin.loader.HYNoHistoryActivity");
        localPluginLoadParams.componentMap.put("com.tencent.intervideo.xplatform.SwitchAppActivity", "com.tencent.proxyinner.plugin.loader.HYNoHistoryTransparentActivity");
        localPluginLoadParams.defaultServiceContainer = "com.tencent.proxyinner.plugin.loader.QTProxyService";
        localPluginLoadParams.defaultUseActionBar = false;
        paramLauncherParam.mIsMoveSoFile = false;
      }
      else if (paramLauncherParam.mPakageName.equals("com.tencent.now"))
      {
        localPluginLoadParams.defaultUseActionBar = true;
        if (paramLauncherParam.mMapComponent.size() == 0)
        {
          localPluginLoadParams.componentMap.put("com.tencent.litelive.module.LiveMainActivity", "com.tencent.pluginloader.proxy.NowLiveMainProxy");
          localPluginLoadParams.componentMap.put("com.tencent.wns.export.EmptyService", "com.tencent.proxyinner.plugin.loader.WnsEmptyProxyService");
          localPluginLoadParams.componentMap.put("com.tencent.hy.module.room.QtService", "com.tencent.proxyinner.plugin.loader.NowQTServiceProxy");
          localPluginLoadParams.componentMap.put("com.tencent.wns.service.WnsMain", "com.tencent.proxyinner.plugin.loader.WNSProxyService");
          localPluginLoadParams.componentMap.put("com.tencent.hy.module.startup.LauncherActivity", "com.tencent.mobileqq.intervideo.now.NowGestureProxyActivity");
          localPluginLoadParams.componentMap.put("com.tencent.tmdownloader.TMAssistantDownloadService", "com.tencent.pluginloader.proxy.DownloadProxyService");
          localPluginLoadParams.componentMap.put("com.tencent.litelive.module.videoroom.widget.LiteVideoWindowService", "com.tencent.pluginloader.proxy.NowVideoServiceProxy");
          localPluginLoadParams.componentMap.put("com.wns.daemon.foreservice.FakeForeGroundService", "com.tencent.proxyinner.plugin.loader.FakaForgroundProxyService");
          localPluginLoadParams.componentMap.put("com.tencent.hy.module.web.WebActivity", "com.tencent.proxyinner.plugin.loader.WebProxyActivity");
          localPluginLoadParams.componentMap.put("com.tencent.litelive.module.web.TransparentTitleWebActivity", "com.tencent.proxyinner.plugin.loader.WebSingleTopProxyActivity");
          localPluginLoadParams.componentMap.put("com.tencent.litelive.module.share.RecordShareActivity", "com.tencent.proxyinner.plugin.loader.RecordShareProxyActivity");
          localPluginLoadParams.componentMap.put("com.tencent.tauth.AuthActivity", "com.tencent.proxyinner.plugin.loader.NowAuthProxyActivity");
          localPluginLoadParams.componentMap.put("com.tencent.now.wxapi.WXEntryActivity", "com.tencent.proxyinner.plugin.loader.NowWXEntryProxyActivity");
          localPluginLoadParams.componentMap.put("com.tencent.litelive.module.videoroom.RoomActivity", "com.tencent.mobileqq.intervideo.now.NowGestureProxyActivity");
          localPluginLoadParams.defaultUseActionBar = true;
          localPluginLoadParams.defaultActivityContainer = "com.tencent.pluginloader.proxy.NowDefaultProxy";
          localPluginLoadParams.defaultServiceContainer = "com.tencent.proxyinner.plugin.loader.NowQTServiceProxy";
          localPluginLoadParams.processName = "com.tencent.mobileqq:tool";
        }
      }
    }
  }
  
  private boolean launchPlugin(Context paramContext, LauncherParam paramLauncherParam)
  {
    boolean bool = true;
    if ((paramContext == null) || (paramLauncherParam == null)) {
      postCallback(5, paramLauncherParam.mPakageName, 10006, "pluginPath is empty");
    }
    this.mContext = paramContext;
    this.mParams = paramLauncherParam;
    if (TextUtils.isEmpty(paramLauncherParam.mApkPath))
    {
      postCallback(5, paramLauncherParam.mPakageName, 10005, "pluginPath is empty");
      bool = false;
    }
    do
    {
      return bool;
      if (!SixGodHelper.isPluginLoaded(paramLauncherParam.mPakageName))
      {
        if (paramLauncherParam.mIsMoveSoFile)
        {
          moveSoFile(paramContext, paramLauncherParam.mApkPath, paramLauncherParam.mPakageName);
          return true;
        }
        XLog.i("TXProxy|PluginLoader", "loadPlugin");
        loadPlugin(buildSixgodLoadPluginParams(paramLauncherParam));
        return true;
      }
      paramLauncherParam.params.putBoolean("pluginflag", true);
      if ((!this.mParams.isLoad) && (SixGodHelper.isPluginLoaded(paramLauncherParam.mPakageName)))
      {
        if (TextUtils.isEmpty(this.mParams.activityName))
        {
          SixGodHelper.startPluginLauncherActivity(paramLauncherParam.mPakageName, paramLauncherParam.params, paramLauncherParam.data);
          return true;
        }
        XLog.i("TXProxy|PluginLoader", "startPluginActivity data = " + paramLauncherParam.data);
        SixGodHelper.startPluginActivity(this.mContext, paramLauncherParam.activityName, buildSixgodLoadPluginParams(paramLauncherParam), paramLauncherParam.params, paramLauncherParam.data);
        return true;
      }
    } while (!this.mParams.isLoad);
    loadPluginSucc(this.mParams.mPakageName, "");
    return true;
  }
  
  private void loadPlugin(final PluginLoadParams paramPluginLoadParams)
  {
    HandlerThread localHandlerThread = new HandlerThread("load_plugin", 1);
    localHandlerThread.start();
    new Handler(localHandlerThread.getLooper()).post(new Runnable()
    {
      public void run()
      {
        try
        {
          SixGodHelper.loadPlugin(PluginLauncher.this.mContext, paramPluginLoadParams);
          return;
        }
        catch (Exception localException)
        {
          PluginLauncher.this.postCallback(2, paramPluginLoadParams.pkgName, 10003, "loadPlugin crashed!");
          DataReport.getInstance().reportAction("sixgodloadfail", 10003, 0, paramPluginLoadParams.pkgName, localException.getMessage());
          localException.printStackTrace();
        }
      }
    });
  }
  
  private void postCallback(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    Message localMessage = Message.obtain();
    localMessage.what = paramInt1;
    Bundle localBundle = new Bundle();
    localBundle.putInt("res", paramInt2);
    localBundle.putString("descmsg", paramString2);
    localBundle.putString("packagename", paramString1);
    localMessage.setData(localBundle);
    this.mHandler.sendMessage(localMessage);
  }
  
  public void addListener(Event paramEvent)
  {
    if (paramEvent != null) {
      this.mEventList.add(paramEvent);
    }
  }
  
  public void crashHappened(String paramString1, String paramString2, String paramString3, Throwable paramThrowable)
  {
    XLog.e("TXProxy|PluginLoader", "crashHappened packageName = " + paramString2 + " processName" + paramString1);
    paramThrowable.printStackTrace();
    if (this.mIsPreload)
    {
      postCallback(2, paramString2, 10003, paramThrowable.toString());
      return;
    }
    postCallback(2, paramString2, 10004, paramThrowable.toString());
  }
  
  public void init(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public void load(LauncherParam paramLauncherParam)
  {
    XLog.i("TXProxy|PluginLoader", "开始加载插件,启动超时逻辑, path = " + paramLauncherParam.mApkPath);
    if (paramLauncherParam == null) {
      throw new IllegalArgumentException("load,LauncherParam = null!");
    }
    this.monitor.startTimeoutMonitor(1, this, mTimeoutDelay);
    DataReport.getInstance().reportAction("sixgodloadstart", 0, 0, paramLauncherParam.mPakageName, "");
    launchPlugin(this.mContext, paramLauncherParam);
  }
  
  public void loadPluginFailed(String paramString1, String paramString2, int paramInt)
  {
    XLog.e("TXProxy|PluginLoader", "loadPluginFailed packageName = " + paramString1);
    postCallback(2, paramString1, paramInt, "loadPluginFailed!");
    DataReport.getInstance().reportAction("sixgodloadfail", 1, paramInt, paramString1, "");
  }
  
  public void loadPluginSucc(String paramString1, String paramString2)
  {
    XLog.i("TXProxy|PluginLoader", "loadPluginSucc packageName = " + paramString1);
    postCallback(1, paramString1, 0, "");
    DataReport.getInstance().reportAction("sixgodloadsucc", 0, 0, paramString1, "");
  }
  
  protected void moveSoFile(final Context paramContext, final String paramString1, final String paramString2)
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        try
        {
          XLog.i("TXProxy|PluginLoader", "开始moveSoFile time = " + System.currentTimeMillis());
          SixGodHelper.moveSoFile(paramContext, paramString1, paramString2, PluginLauncher.this.mParams.mVersionName);
          XLog.i("TXProxy|PluginLoader", "moveSoFile完成，time =" + System.currentTimeMillis());
          Iterator localIterator = PluginLauncher.this.mEventList.iterator();
          while (localIterator.hasNext()) {
            ((PluginLauncher.Event)localIterator.next()).onUnZipSo(paramString1, PluginLauncher.this.mUnZipSoListener);
          }
          NowPerfUtil.step("xproxy move so success");
        }
        catch (Exception localException)
        {
          PluginLauncher.this.postCallback(8, paramString2, 10003, "move so file crashed!");
          localException.printStackTrace();
          return;
        }
      }
    }).start();
  }
  
  public void onLoadTimeout()
  {
    XLog.e("TXProxy|PluginLoader", "加载插件超时！");
    postCallback(2, this.mParams.mPakageName, 10001, "load_time_out");
    DataReport.getInstance().reportAction("sixgodloadfail", 10001, 0, this.mParams.mPakageName, "load_time_out");
  }
  
  public void onStartTimeout()
  {
    XLog.e("TXProxy|PluginLoader", "启动插件超时！");
    postCallback(5, this.mParams.mPakageName, 10002, "start_time_out");
  }
  
  public void setTimeoutDelay(int paramInt)
  {
    mTimeoutDelay = paramInt;
  }
  
  public void start(LauncherParam paramLauncherParam)
  {
    XLog.i("TXProxy|PluginLoader", "开始启动插件,启动超时逻辑");
    this.monitor.startTimeoutMonitor(2, this, mTimeoutDelay);
    launchPlugin(this.mContext, paramLauncherParam);
  }
  
  public void startActivitySucc(String paramString1, String paramString2, String paramString3)
  {
    XLog.i("TXProxy|PluginLoader", "startActivitySucc packageName = " + paramString1);
    postCallback(4, paramString1, 0, "startActivitySucc!");
  }
  
  public void startMainActivityFailed(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    XLog.e("TXProxy|PluginLoader", "startMainActivityFailed packageName = " + paramString1);
    postCallback(5, paramString1, 2, "startMainActivityFailed!");
  }
  
  public void startMainActivitySucc(String paramString1, String paramString2, String paramString3)
  {
    XLog.i("TXProxy|PluginLoader", "startMainActivitySucc packageName = " + paramString1);
    postCallback(4, paramString1, 0, "startMainActivitySucc!");
  }
  
  public void unInit(boolean paramBoolean)
  {
    unload(paramBoolean);
    this.mEventList.clear();
  }
  
  public void unload(boolean paramBoolean)
  {
    XLog.i("TXProxy|PluginLoader", "卸载插件");
    SixGodHelper.unLoadPlugin(this.mContext, this.mParams.mPakageName, paramBoolean);
  }
  
  public static abstract interface Event
  {
    public abstract void onLoadError(String paramString1, int paramInt1, int paramInt2, String paramString2);
    
    public abstract void onLoaded(PluginLauncher.LauncherParam paramLauncherParam);
    
    public abstract void onStarted(String paramString);
    
    public abstract void onUnZipSo(String paramString, UnZipSoListener paramUnZipSoListener);
  }
  
  public static class LauncherParam
  {
    public String activityName;
    public Uri data;
    public boolean isLoad;
    public String mApkPath;
    public String mDefaultContainerActivity;
    public String mDefaultContainerService;
    public String mDefaultLoadApkActivity;
    public boolean mIsMoveSoFile;
    public Map<String, String> mMapComponent = new HashMap();
    public String mPakageName;
    public String mProcessName = ":plugin";
    public String mSoPath;
    public String mVersionName = "version";
    public Bundle params;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\proxyinner\plugin\loader\PluginLauncher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */