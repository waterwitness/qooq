package com.tencent.txproxy;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.proxyinner.plugin.loader.UnZipSoListener;

public abstract interface XEventListener
{
  public abstract void onDataReport(String paramString, Bundle paramBundle);
  
  public abstract void onDownload(String paramString1, String paramString2, HostEventListener paramHostEventListener);
  
  public abstract void onError(String paramString1, int paramInt, String paramString2);
  
  public abstract void onGetPluginActivity(Activity paramActivity);
  
  public abstract void onLog(String paramString1, String paramString2, int paramInt);
  
  public abstract void onOpenRoom(String paramString);
  
  public abstract void onPluginLoaded(String paramString);
  
  public abstract void onPluginRun(String paramString);
  
  public abstract void onPreInstallFinish(String paramString1, boolean paramBoolean, String paramString2, String paramString3);
  
  public abstract void onProgress(String paramString, int paramInt);
  
  public abstract void onReceivePluginMsg(String paramString1, String paramString2, Bundle paramBundle);
  
  public abstract void onUnZipSo(String paramString1, UnZipSoListener paramUnZipSoListener, String paramString2);
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\txproxy\XEventListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */