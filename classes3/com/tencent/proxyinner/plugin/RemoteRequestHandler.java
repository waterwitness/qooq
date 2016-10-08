package com.tencent.proxyinner.plugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.sixgod.pluginsdk.SixGodHelper;
import com.tencent.proxyinner.log.XLog;
import com.tencent.proxyinner.plugin.loader.PluginLauncher;
import com.tencent.proxyinner.plugin.loader.PluginLauncher.Event;
import com.tencent.proxyinner.plugin.loader.PluginLauncher.LauncherParam;
import com.tencent.proxyinner.plugin.loader.UnZipSoListener;
import com.tencent.proxyinner.utility.UtilFile;
import com.tencent.txproxy.XEventListener;
import com.tencent.txproxy.XPlugin;
import dalvik.system.DexClassLoader;
import java.io.File;

public class RemoteRequestHandler
  implements PluginLauncher.Event
{
  private static final String TAG = "TXProxy|RemoteRequest";
  private BroadcastReceiver RemoteRequestReceiver = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent == null)
      {
        XLog.i("TXProxy|RemoteRequest", "收到插件进程的远程请求　intent = null");
        return;
      }
      RemoteRequestHandler.this.onRecvMessage(paramAnonymousIntent.getAction(), paramAnonymousIntent);
    }
  };
  Context mContext;
  Handler mHandler = new Handler(Looper.getMainLooper());
  String mHostType;
  XEventListener mListener;
  PluginLauncher mLoader = new PluginLauncher();
  String mPluginId;
  XEventListener mSink;
  
  public RemoteRequestHandler(Context paramContext, XEventListener paramXEventListener, String paramString1, String paramString2)
  {
    this.mContext = paramContext;
    this.mListener = paramXEventListener;
    this.mHostType = paramString1;
    this.mPluginId = paramString2;
  }
  
  private String getSendCmd(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = new StringBuffer(paramString1);
    paramString1.append("|");
    paramString1.append(paramString2);
    paramString1.append("|");
    paramString1.append(paramString3);
    return paramString1.toString().trim();
  }
  
  public void init(XEventListener paramXEventListener)
  {
    this.mLoader.init(this.mContext);
    this.mLoader.addListener(this);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.xplatform.launchdplugin" + this.mHostType);
    localIntentFilter.addAction("com.tencent.xplatform.unload.plugin" + this.mHostType);
    localIntentFilter.addAction("com.tencent.xplatform.preinstall_plugin" + this.mHostType);
    localIntentFilter.addAction(getSendCmd("com.tencent.xplatform.unload.plugin", this.mPluginId, this.mHostType));
    this.mContext.registerReceiver(this.RemoteRequestReceiver, localIntentFilter);
    this.mSink = paramXEventListener;
  }
  
  protected boolean launchPlugin(Intent paramIntent)
  {
    try
    {
      Object localObject = paramIntent.getExtras();
      String str1 = ((Bundle)localObject).getString("apkpath");
      String str2 = ((Bundle)localObject).getString("packagename");
      String str3 = ((Bundle)localObject).getString("processname");
      boolean bool1 = ((Bundle)localObject).getBoolean("preload");
      boolean bool2 = ((Bundle)localObject).getBoolean("movesofile");
      String str4 = ((Bundle)localObject).getString("activityname");
      String str5 = ((Bundle)localObject).getString("version");
      paramIntent = new PluginLauncher.LauncherParam();
      paramIntent.mApkPath = str1;
      paramIntent.mPakageName = str2;
      paramIntent.mProcessName = str3;
      paramIntent.params = ((Bundle)localObject);
      paramIntent.isLoad = bool1;
      paramIntent.mIsMoveSoFile = bool2;
      paramIntent.params = ((Bundle)localObject);
      paramIntent.activityName = str4;
      paramIntent.mVersionName = str5;
      localObject = ((Bundle)localObject).getString("vasschema");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramIntent.data = Uri.parse((String)localObject);
      }
      XLog.i("perflog", "开始加载业务插件 time = " + System.currentTimeMillis());
      this.mLoader.load(paramIntent);
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        paramIntent.printStackTrace();
        XLog.i("TXProxy|RemoteRequest", "RemoteRequestHandler launchPlugin Exception!");
      }
    }
    return true;
  }
  
  public void onLoadError(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    XLog.i("TXProxy|RemoteRequest", "插件加载失败，回调xplatform 包名为： " + paramString1 + "reason =  " + paramInt1 + "res  = " + paramInt2 + "msg = " + paramString2);
    paramString2 = new Bundle();
    paramString2.putInt("errcode", paramInt2);
    paramString2.putInt("rason", paramInt1);
    paramString2.putString("packagename", paramString1);
    sendMessage("com.tencent.xplatform.launchdplugin.result", paramString2);
  }
  
  public void onLoaded(PluginLauncher.LauncherParam paramLauncherParam)
  {
    XLog.i("TXProxy|RemoteRequest", "onLoaded isLoad = " + paramLauncherParam.isLoad);
    if (paramLauncherParam.isLoad == true)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("errcode", 0);
      localBundle.putString("packagename", paramLauncherParam.mPakageName);
      localBundle.putBoolean("preload", true);
      sendMessage("com.tencent.xplatform.launchdplugin.result", localBundle);
      return;
    }
    paramLauncherParam.isLoad = false;
    XLog.i("perflog", "加载业务插件成功 time = " + System.currentTimeMillis());
    this.mLoader.start(paramLauncherParam);
  }
  
  public Bundle onRecvMessage(String paramString, Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      return null;
      if (paramString.equals("com.tencent.xplatform.launchdplugin" + this.mHostType))
      {
        XLog.i("TXProxy|RemoteRequest", "收到插件进程的远程请求　开始加载插件");
        launchPlugin(paramIntent);
        return null;
      }
      if (paramString.equals(getSendCmd("com.tencent.xplatform.unload.plugin", this.mPluginId, this.mHostType)))
      {
        XLog.i("TXProxy|RemoteRequest", "收到插件进程的远程请求　开始UnLoad插件");
        unLoadPlugin(paramIntent);
        return null;
      }
    } while (!paramString.equals("com.tencent.xplatform.preinstall_plugin" + this.mHostType));
    XLog.i("TXProxy|RemoteRequest", "收到插件进程的远程请求　开始安装插件");
    preInstallPlugin(paramIntent);
    return null;
  }
  
  public void onStarted(String paramString)
  {
    XLog.i("TXProxy|RemoteRequest", "插件启动成功，回调xplatform 包名为： " + paramString);
    Bundle localBundle = new Bundle();
    localBundle.putInt("errcode", 0);
    localBundle.putString("packagename", paramString);
    sendMessage("com.tencent.xplatform.launchdplugin.result", localBundle);
  }
  
  public void onUnZipSo(String paramString, UnZipSoListener paramUnZipSoListener)
  {
    if (paramUnZipSoListener != null) {
      paramUnZipSoListener.onUnZipComplete(true);
    }
  }
  
  protected boolean preInstallPlugin(final Intent paramIntent)
  {
    final String str1 = paramIntent.getStringExtra("packagename");
    final String str2 = paramIntent.getStringExtra("apkpath");
    paramIntent = paramIntent.getStringExtra("version");
    new StringBuilder().append(UtilFile.getSixgodPluginRootDir(this.mContext)).append(str1).append(File.separator).append("lib").append("_").append(paramIntent).append(File.separator).toString();
    final String str3 = UtilFile.getSixgodPluginRootDir(this.mContext) + str1 + File.separator;
    new Thread(new Runnable()
    {
      public void run()
      {
        try
        {
          SixGodHelper.moveSoFile(RemoteRequestHandler.this.mContext, str2, str1, paramIntent);
          File localFile = new File(str3);
          if (!localFile.exists()) {
            localFile.mkdirs();
          }
          localFile = new File(this.val$odexDir);
          if (!localFile.exists()) {
            localFile.mkdirs();
          }
          new DexClassLoader(str2, this.val$odexDir, null, RemoteRequestHandler.this.mContext.getClassLoader().getParent());
          XPlugin.getPlugin(RemoteRequestHandler.this.mPluginId);
          RemoteRequestHandler.this.mHandler.post(new Runnable()
          {
            public void run()
            {
              Bundle localBundle = new Bundle();
              localBundle.putInt("errcode", 0);
              localBundle.putString("packagename", RemoteRequestHandler.2.this.val$packageName);
              localBundle.putString("version", RemoteRequestHandler.2.this.val$version);
              RemoteRequestHandler.this.sendMessage("com.tencent.xplatform.preinstall.result", localBundle);
            }
          });
          return;
        }
        catch (Exception localException)
        {
          Bundle localBundle = new Bundle();
          localBundle.putInt("errcode", 1001);
          localBundle.putString("packagename", str1);
          localBundle.putString("version", paramIntent);
          RemoteRequestHandler.this.sendMessage("com.tencent.xplatform.preinstall.result", localBundle);
          Log.i("TXProxy|RemoteRequest", "预安装出现异常　packagename = " + str1);
        }
      }
    }).start();
    return true;
  }
  
  public void sendMessage(String paramString, Bundle paramBundle)
  {
    paramString = new Intent(paramString);
    paramString.putExtras(paramBundle);
    this.mContext.sendBroadcast(paramString);
  }
  
  public void unInit()
  {
    this.mContext.unregisterReceiver(this.RemoteRequestReceiver);
  }
  
  protected boolean unLoadPlugin(Intent paramIntent)
  {
    boolean bool1 = paramIntent.getBooleanExtra("unloadall", false);
    boolean bool2 = paramIntent.getBooleanExtra("exitprocess", false);
    if (bool1) {
      SixGodHelper.unLoadAllPlugin(this.mContext, bool2);
    }
    for (;;)
    {
      return true;
      paramIntent = paramIntent.getStringExtra("packagename");
      SixGodHelper.unLoadPlugin(this.mContext, paramIntent, bool2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\proxyinner\plugin\RemoteRequestHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */