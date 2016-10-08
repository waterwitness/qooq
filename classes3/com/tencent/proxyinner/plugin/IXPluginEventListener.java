package com.tencent.proxyinner.plugin;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.proxyinner.plugin.loader.UnZipSoListener;
import com.tencent.txproxy.HostEventListener;

public abstract interface IXPluginEventListener
{
  public abstract void onDataReport(String paramString, Bundle paramBundle);
  
  public abstract void onDownLoad(String paramString1, String paramString2, HostEventListener paramHostEventListener);
  
  public abstract void onError(int paramInt);
  
  public abstract void onGetPluginActivity(Activity paramActivity);
  
  public abstract void onLog(String paramString1, String paramString2, int paramInt);
  
  public abstract void onOpenRoom(String paramString);
  
  public abstract void onPreInstallFinish(boolean paramBoolean, String paramString1, String paramString2);
  
  public abstract void onReceiveMessage(String paramString, Bundle paramBundle);
  
  public abstract void onStatusChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void onUnZipSo(String paramString1, UnZipSoListener paramUnZipSoListener, String paramString2);
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\proxyinner\plugin\IXPluginEventListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */