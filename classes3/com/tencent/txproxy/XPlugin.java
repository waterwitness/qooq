package com.tencent.txproxy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.sixgod.pluginsdk.SixGodHelper;
import com.sixgod.pluginsdk.component.ContainerActivity;
import com.tencent.proxyinner.entry.DefaultLoadingActivity;
import com.tencent.proxyinner.log.XLog;
import com.tencent.proxyinner.plugin.Downloader.UpdateParam;
import com.tencent.proxyinner.plugin.IXPluginEventListener;
import com.tencent.proxyinner.plugin.RemoteRequestHandler;
import com.tencent.proxyinner.plugin.XPluginImp;
import com.tencent.proxyinner.plugin.data.XPluginInfoBuilder;
import com.tencent.proxyinner.plugin.loader.UnZipSoListener;
import com.tencent.proxyinner.report.DataReport;
import com.tencent.proxyinner.utility.NowPerfUtil;
import java.util.HashMap;
import java.util.Map;

public class XPlugin
  implements IXPluginEventListener
{
  public static final String TAG = "XProxy|XPlugin";
  static Map<String, XPlugin> mLoaderMap = new HashMap();
  Context mContext;
  boolean mInit = false;
  InitParam mInitParam;
  EventNotifyHandler mNotifyHandler;
  String mPluginId;
  XPluginImp mPluginImp;
  RemoteRequestHandler remoteRequestHandler;
  
  private XPlugin(String paramString)
  {
    this.mPluginId = paramString;
    this.mPluginImp = new XPluginImp();
  }
  
  public static XPlugin getPlugin(String paramString)
  {
    if (mLoaderMap.containsKey(paramString)) {
      return (XPlugin)mLoaderMap.get(paramString);
    }
    XPlugin localXPlugin = new XPlugin(paramString);
    mLoaderMap.put(paramString, localXPlugin);
    return localXPlugin;
  }
  
  public static void unloadAllPlugin(Context paramContext)
  {
    SixGodHelper.unLoadAllPlugin(paramContext, true);
  }
  
  public void addEventListener(XEventListener paramXEventListener)
  {
    this.mNotifyHandler.addListener(paramXEventListener);
  }
  
  public void cancelRunPlugin(String paramString)
  {
    this.mPluginImp.cancelRun(paramString);
  }
  
  public void dataReport(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.mPluginImp.dataReport(paramString1, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramString2, paramString3, paramString4, paramString5, paramString6);
  }
  
  public UpdateParam getCheckVersionInfo()
  {
    if (!this.mPluginImp.isCheckedVersion()) {
      return null;
    }
    return this.mPluginImp.getCheckVersionInfo();
  }
  
  public void getPluginActivity(ContainerActivity paramContainerActivity, String paramString, Intent paramIntent)
  {
    this.mPluginImp.getPluginActivity(paramContainerActivity, paramString, paramIntent.getExtras());
  }
  
  public int getPluginSize()
  {
    return this.mPluginImp.getPluginSize();
  }
  
  public int getPluginStatus()
  {
    return this.mPluginImp.getStatus();
  }
  
  public int getStatus()
  {
    return this.mPluginImp.getStatus();
  }
  
  public boolean hasLocalPlugin()
  {
    return this.mPluginImp.haslocalOdexedPlugin();
  }
  
  public boolean isPluginLoaded()
  {
    return this.mPluginImp.getStatus() == 6;
  }
  
  public boolean loadPlugin()
  {
    this.mPluginImp.loadplugin();
    return true;
  }
  
  public void onDataReport(String paramString, Bundle paramBundle)
  {
    this.mNotifyHandler.onDataReport(paramString, paramBundle);
  }
  
  public void onDownLoad(String paramString1, String paramString2, HostEventListener paramHostEventListener)
  {
    this.mNotifyHandler.onDownload(paramString1, paramString2, paramHostEventListener);
  }
  
  public void onError(int paramInt)
  {
    this.mNotifyHandler.onError(this.mPluginId, paramInt, "加载插件失败，请稍后重试");
  }
  
  public void onGetPluginActivity(Activity paramActivity)
  {
    this.mNotifyHandler.onGetPluginActivity(paramActivity);
  }
  
  public void onLog(String paramString1, String paramString2, int paramInt)
  {
    this.mNotifyHandler.onLog(paramString1, paramString2, paramInt);
  }
  
  public void onOpenRoom(String paramString)
  {
    this.mNotifyHandler.onOpenRoom(this.mPluginId);
  }
  
  public void onPreInstallFinish(boolean paramBoolean, String paramString1, String paramString2)
  {
    this.mNotifyHandler.onPreInstallFish(this.mPluginId, paramBoolean, paramString1, paramString2);
  }
  
  public void onReceiveMessage(String paramString, Bundle paramBundle)
  {
    this.mNotifyHandler.onPluginMsg(this.mPluginId, paramString, paramBundle);
  }
  
  public void onStatusChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 == 5) && (paramInt2 == 6)) {
      this.mNotifyHandler.onPluginLoaded(this.mPluginId);
    }
    for (;;)
    {
      if (paramInt3 > 0) {
        this.mNotifyHandler.onProgress(this.mPluginId, paramInt3);
      }
      return;
      if ((paramInt1 == 7) && (paramInt2 == 8)) {
        this.mNotifyHandler.onPluginRun(this.mPluginId);
      }
    }
  }
  
  public void onUnZipSo(String paramString1, UnZipSoListener paramUnZipSoListener, String paramString2)
  {
    this.mNotifyHandler.onUnzipSo(paramString1, paramUnZipSoListener, paramString2);
  }
  
  public void registerPluginMsgCmd(String paramString)
  {
    this.mPluginImp.registerPluginMsg(paramString);
  }
  
  public void removeListener(XEventListener paramXEventListener)
  {
    if (this.mNotifyHandler != null) {
      this.mNotifyHandler.removeListener(paramXEventListener);
    }
  }
  
  public boolean runPlugin(Intent paramIntent)
  {
    this.mPluginImp.runPlugin(paramIntent.getExtras());
    return true;
  }
  
  public boolean runPlugin(RunPluginParams paramRunPluginParams)
  {
    XLog.i("XProxy|XPlugin", "runPlugin pluginid = " + this.mPluginId);
    DataReport.getInstance().setSourceFromId(paramRunPluginParams.mFromId);
    DataReport.getInstance().reportAction("runplugin", 0, 0, this.mPluginId, paramRunPluginParams.mFromId);
    NowPerfUtil.start("begin into txproxy and runplugin");
    Intent localIntent = XPluginInfoBuilder.setLauncherParam(new Intent(this.mContext, DefaultLoadingActivity.class), paramRunPluginParams);
    if (paramRunPluginParams.useDefaultLoading)
    {
      localIntent.putExtra("pluginappid", this.mPluginId);
      if (!(this.mContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      this.mContext.startActivity(localIntent);
      if ((this.mContext instanceof Activity)) {
        ((Activity)this.mContext).overridePendingTransition(17432576, 17432577);
      }
    }
    for (;;)
    {
      return true;
      this.mPluginImp.runPlugin(localIntent.getExtras());
    }
  }
  
  public void sendMessage(String paramString, Bundle paramBundle)
  {
    this.mPluginImp.sendMessage(paramString, paramBundle);
  }
  
  public void setInitData(Context paramContext, InitParam paramInitParam)
  {
    if (!this.mInit)
    {
      this.mPluginImp.initParam(this.mPluginId, paramContext, paramInitParam);
      this.mInitParam = paramInitParam;
      this.mNotifyHandler = new EventNotifyHandler();
      if (this.mInitParam.mSink != null) {
        this.mNotifyHandler.addListener(this.mInitParam.mSink);
      }
      if (this.remoteRequestHandler == null) {
        this.remoteRequestHandler = new RemoteRequestHandler(paramContext, paramInitParam.mSink, String.valueOf(paramInitParam.mChannelType), this.mPluginId);
      }
      this.remoteRequestHandler.init(paramInitParam.mSink);
      this.mContext = paramContext;
      this.mPluginImp.addListener(this);
      this.mInit = true;
    }
  }
  
  public boolean unload(Boolean paramBoolean)
  {
    this.mPluginImp.unload(paramBoolean);
    this.mPluginImp.removeListener(this);
    this.mNotifyHandler.clear();
    this.remoteRequestHandler.unInit();
    this.mInit = false;
    return true;
  }
  
  public boolean updatePluginAndPreInstall()
  {
    this.mPluginImp.updatePluginAndPreInstall(false);
    return true;
  }
  
  public boolean updatePluginAndPreInstallNeedWaitConfirm()
  {
    this.mPluginImp.updatePluginAndPreInstall(true);
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\txproxy\XPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */