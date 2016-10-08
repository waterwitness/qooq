package com.tencent.proxyinner.entry;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.proxyinner.log.XLog;
import com.tencent.proxyinner.plugin.Downloader.PluginUpdater;
import com.tencent.proxyinner.plugin.loader.UnZipSoListener;
import com.tencent.proxyinner.report.DataReport;
import com.tencent.proxyinner.utility.ApkUtility;
import com.tencent.txproxy.HostEventListener;
import com.tencent.txproxy.XEventListener;
import com.tencent.txproxy.XPlugin;

public class DefaultLoadingActivity
  extends Activity
  implements DefaultLoadingUI.Event, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, XEventListener
{
  private static final int MSG_CHECK_NETWORK = 1000;
  private static final String TAG = "XProxy|DefaultLoadingActivity";
  private AlertDialog dlg = null;
  private boolean mActivate = false;
  private Bundle mBundle = null;
  private Handler mHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      }
      DefaultLoadingActivity.this.checkNetwork();
    }
  };
  private BroadcastReceiver mHomePressReceiver = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if ((paramAnonymousIntent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS")) && (TextUtils.equals(paramAnonymousIntent.getStringExtra("reason"), "homekey")))
      {
        XLog.i("XProxy|DefaultLoadingActivity", "on touch homekey");
        if (!ApkUtility.isBackground(DefaultLoadingActivity.this)) {
          XLog.i("XProxy|DefaultLoadingActivity", "report homekey");
        }
      }
    }
  };
  DefaultLoadingUI mLoadingUI = new DefaultLoadingUI();
  private String mPluginId;
  private boolean needStart = true;
  private XPlugin plugin;
  private boolean select_ok = false;
  
  private String getPackageSizeString(int paramInt)
  {
    if (paramInt < 1024) {
      return paramInt + "B";
    }
    if ((paramInt >= 1024) && (paramInt < 1048576)) {
      return paramInt / 1024 + "KB";
    }
    return paramInt / 1048576 + "M";
  }
  
  private void run()
  {
    this.plugin.runPlugin(getIntent());
  }
  
  public void checkNetwork()
  {
    XLog.i("XProxy|DefaultLoadingActivity", "start checkNetwork");
    if (this.plugin.getCheckVersionInfo() != null) {}
    for (;;)
    {
      try
      {
        int i = this.plugin.getStatus();
        int j = this.plugin.getPluginSize();
        if (i != 0) {
          break label266;
        }
        Object localObject = ((ConnectivityManager)getSystemService("connectivity")).getActiveNetworkInfo();
        if (localObject == null)
        {
          onError(this.mPluginId, -1, "");
          return;
        }
        if ((((NetworkInfo)localObject).getType() == 1) || (j < 1024000)) {
          break label261;
        }
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
        localBuilder.setTitle("提示");
        localObject = getPackageSizeString(j);
        if ((j > 0) && (1 == 1))
        {
          localObject = "当前处于移动网络环境下。首次进入交友房间，初始化需" + (String)localObject + "流量，是否继续？";
          localBuilder.setMessage((CharSequence)localObject);
          this.select_ok = false;
          localBuilder.setPositiveButton("取消", this);
          localBuilder.setNegativeButton("继续", this);
          this.dlg = localBuilder.create();
          this.dlg.setCanceledOnTouchOutside(false);
          this.dlg.setOnDismissListener(this);
          boolean bool = isFinishing();
          if (bool) {
            break label275;
          }
          try
          {
            this.dlg.show();
            return;
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            localIllegalArgumentException.printStackTrace();
            return;
          }
        }
        if (j <= 0) {
          break label276;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      String str;
      if (1 == 3)
      {
        str = "当前处于移动网络环境下。交友房间有重要更新，需" + localException + "流量，是否继续？";
        continue;
        label261:
        run();
        return;
        label266:
        run();
        return;
        run();
      }
      else
      {
        label275:
        label276:
        str = "当前处于移动网络环境下,是否继续？";
      }
    }
  }
  
  public void onBackPressed()
  {
    finish();
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
        this.select_ok = false;
      } while (isFinishing());
      try
      {
        this.dlg.dismiss();
        return;
      }
      catch (IllegalArgumentException paramDialogInterface)
      {
        paramDialogInterface.printStackTrace();
        return;
      }
      this.select_ok = true;
    } while (isFinishing());
    try
    {
      this.dlg.dismiss();
      return;
    }
    catch (IllegalArgumentException paramDialogInterface)
    {
      paramDialogInterface.printStackTrace();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    XLog.i("XProxy|DefaultLoadingActivityperflog", "TXProxy loading onCreate time = " + System.currentTimeMillis());
    super.onCreate(paramBundle);
    DataReport.getInstance().reportAction("createLoadingStart", 0, 0, "", "");
    this.mBundle = getIntent().getExtras();
    if (this.mBundle == null) {
      throw new IllegalArgumentException("Create LoadingActivity IllegalAugumentException");
    }
    getIntent().putExtra("packagename", "com.tencent.intervideo.xplatform");
    this.needStart = true;
    this.mLoadingUI.initUI(this, "");
    this.mLoadingUI.addListener(this);
    this.mLoadingUI.updateTips("正在初始化数据，请稍候...…", true);
    this.mPluginId = getIntent().getStringExtra("pluginappid");
    this.plugin = XPlugin.getPlugin(this.mPluginId);
    this.plugin.addEventListener(this);
    registerReceiver(this.mHomePressReceiver, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
    DataReport.getInstance().reportAction("createLoadingEnd", 0, 0, "", "");
    this.mHandler.sendEmptyMessageDelayed(1000, 5L);
  }
  
  public void onDataReport(String paramString, Bundle paramBundle) {}
  
  protected void onDestroy()
  {
    this.needStart = false;
    XLog.i("XProxy|DefaultLoadingActivity", "onDestroy, needStart = " + this.needStart);
    this.plugin.removeListener(this);
    unregisterReceiver(this.mHomePressReceiver);
    this.mLoadingUI.unInitUI();
    DataReport.getInstance().reportAction("destroyLoading", 0, 0, "", "");
    super.onDestroy();
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.select_ok)
    {
      run();
      return;
    }
    super.finish();
  }
  
  public void onDownload(String paramString1, String paramString2, HostEventListener paramHostEventListener) {}
  
  public void onError(String paramString1, int paramInt, String paramString2)
  {
    this.needStart = false;
    XLog.e("XProxy|DefaultLoadingActivity", "onODError, needStart = " + this.needStart + "errCode = " + paramInt);
    if (PluginUpdater.isIncUpdateError(paramInt)) {
      paramString1 = "继续下载更新，需" + getPackageSizeString(this.plugin.getPluginSize()) + "流量，是否继续";
    }
    for (;;)
    {
      this.mLoadingUI.showErrorUI(paramString1);
      return;
      if (PluginUpdater.isNoSpaceError(paramInt)) {
        paramString1 = "SD卡剩余空间不足，请先清理空间";
      } else {
        paramString1 = "下载失败，请重试";
      }
    }
  }
  
  public void onGetPluginActivity(Activity paramActivity) {}
  
  public void onLog(String paramString1, String paramString2, int paramInt) {}
  
  public void onOpenRoom(String paramString) {}
  
  public void onPluginLoaded(String paramString) {}
  
  public void onPluginRun(String paramString) {}
  
  public void onPreInstallFinish(String paramString1, boolean paramBoolean, String paramString2, String paramString3) {}
  
  public void onProgress(String paramString, int paramInt) {}
  
  public void onReceivePluginMsg(String paramString1, String paramString2, Bundle paramBundle) {}
  
  protected void onRestart()
  {
    XLog.i("XProxy|DefaultLoadingActivity", "onRestart");
    this.mActivate = true;
    super.onRestart();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.mActivate = true;
    XLog.i("XProxy|DefaultLoadingActivity", " LoadingActivity onResume time = " + System.currentTimeMillis());
  }
  
  public void onRetry()
  {
    this.needStart = true;
    this.mLoadingUI.showLoadingUI();
    this.mLoadingUI.updateProgress(0);
    DataReport.getInstance().reportAction("destroyLoading", 0, 0, "", "");
    run();
  }
  
  protected void onStop()
  {
    try
    {
      int i = this.plugin.getStatus();
      if ((i == 8) || (i == 7)) {
        finish();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        XLog.i("XProxy|DefaultLoadingActivity", "onStop Exception: " + localException.toString());
        localException.printStackTrace();
      }
    }
    this.mActivate = false;
    DataReport.getInstance().reportAction("stopLoading", 0, 0, "", "");
    super.onStop();
  }
  
  public void onUnZipSo(String paramString1, UnZipSoListener paramUnZipSoListener, String paramString2) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\proxyinner\entry\DefaultLoadingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */