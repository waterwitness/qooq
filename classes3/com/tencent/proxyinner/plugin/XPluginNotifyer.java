package com.tencent.proxyinner.plugin;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.proxyinner.plugin.loader.UnZipSoListener;
import com.tencent.txproxy.HostEventListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XPluginNotifyer
{
  private static final String TAG = "ODSDK|ODNotifyer";
  private List<IXPluginEventListener> mList = new ArrayList();
  
  public void addListener(IXPluginEventListener paramIXPluginEventListener)
  {
    if ((paramIXPluginEventListener != null) && (!this.mList.contains(paramIXPluginEventListener))) {
      this.mList.add(paramIXPluginEventListener);
    }
  }
  
  void onDataReport(String paramString, Bundle paramBundle)
  {
    Object localObject = new ArrayList();
    ((List)localObject).addAll(this.mList);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      IXPluginEventListener localIXPluginEventListener = (IXPluginEventListener)((Iterator)localObject).next();
      try
      {
        localIXPluginEventListener.onDataReport(paramString, paramBundle);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  void onDownloadFile(String paramString1, String paramString2, HostEventListener paramHostEventListener)
  {
    Object localObject = new ArrayList();
    ((List)localObject).addAll(this.mList);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      IXPluginEventListener localIXPluginEventListener = (IXPluginEventListener)((Iterator)localObject).next();
      try
      {
        localIXPluginEventListener.onDownLoad(paramString1, paramString2, paramHostEventListener);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  void onError(int paramInt)
  {
    Object localObject = new ArrayList();
    ((List)localObject).addAll(this.mList);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      IXPluginEventListener localIXPluginEventListener = (IXPluginEventListener)((Iterator)localObject).next();
      try
      {
        localIXPluginEventListener.onError(paramInt);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  void onGetPluginActivity(Activity paramActivity)
  {
    Object localObject = new ArrayList();
    ((List)localObject).addAll(this.mList);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      IXPluginEventListener localIXPluginEventListener = (IXPluginEventListener)((Iterator)localObject).next();
      try
      {
        localIXPluginEventListener.onGetPluginActivity(paramActivity);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  void onLog(String paramString1, String paramString2, int paramInt)
  {
    Object localObject = new ArrayList();
    ((List)localObject).addAll(this.mList);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      IXPluginEventListener localIXPluginEventListener = (IXPluginEventListener)((Iterator)localObject).next();
      try
      {
        localIXPluginEventListener.onLog(paramString1, paramString2, paramInt);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  void onOpenRoom(String paramString)
  {
    Object localObject = new ArrayList();
    ((List)localObject).addAll(this.mList);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      IXPluginEventListener localIXPluginEventListener = (IXPluginEventListener)((Iterator)localObject).next();
      try
      {
        localIXPluginEventListener.onOpenRoom(paramString);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  void onPreInstallFinish(boolean paramBoolean, String paramString1, String paramString2)
  {
    Object localObject = new ArrayList();
    ((List)localObject).addAll(this.mList);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      IXPluginEventListener localIXPluginEventListener = (IXPluginEventListener)((Iterator)localObject).next();
      try
      {
        localIXPluginEventListener.onPreInstallFinish(paramBoolean, paramString1, paramString2);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  void onRecvMessage(String paramString, Bundle paramBundle)
  {
    Object localObject = new ArrayList();
    ((List)localObject).addAll(this.mList);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      IXPluginEventListener localIXPluginEventListener = (IXPluginEventListener)((Iterator)localObject).next();
      try
      {
        localIXPluginEventListener.onReceiveMessage(paramString, paramBundle);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  void onStatusChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject = new ArrayList();
    ((List)localObject).addAll(this.mList);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      IXPluginEventListener localIXPluginEventListener = (IXPluginEventListener)((Iterator)localObject).next();
      try
      {
        localIXPluginEventListener.onStatusChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  void onUnZipSo(String paramString1, UnZipSoListener paramUnZipSoListener, String paramString2)
  {
    Object localObject = new ArrayList();
    ((List)localObject).addAll(this.mList);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      IXPluginEventListener localIXPluginEventListener = (IXPluginEventListener)((Iterator)localObject).next();
      try
      {
        localIXPluginEventListener.onUnZipSo(paramString1, paramUnZipSoListener, paramString2);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void removeListener(IXPluginEventListener paramIXPluginEventListener)
  {
    if ((paramIXPluginEventListener != null) && (this.mList.contains(paramIXPluginEventListener))) {
      this.mList.remove(paramIXPluginEventListener);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\proxyinner\plugin\XPluginNotifyer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */