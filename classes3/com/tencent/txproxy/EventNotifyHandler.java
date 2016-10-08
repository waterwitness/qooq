package com.tencent.txproxy;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.proxyinner.plugin.loader.UnZipSoListener;
import java.util.ArrayList;
import java.util.List;

public class EventNotifyHandler
{
  List<XEventListener> mListeners = new ArrayList();
  
  public void addListener(XEventListener paramXEventListener)
  {
    if (!this.mListeners.contains(paramXEventListener)) {
      this.mListeners.add(paramXEventListener);
    }
  }
  
  public void clear()
  {
    this.mListeners.clear();
  }
  
  public void onDataReport(String paramString, Bundle paramBundle)
  {
    int i = 0;
    while (i < this.mListeners.size())
    {
      ((XEventListener)this.mListeners.get(i)).onDataReport(paramString, paramBundle);
      i += 1;
    }
  }
  
  public void onDownload(String paramString1, String paramString2, HostEventListener paramHostEventListener)
  {
    int i = 0;
    while (i < this.mListeners.size())
    {
      ((XEventListener)this.mListeners.get(i)).onDownload(paramString1, paramString2, paramHostEventListener);
      i += 1;
    }
  }
  
  public void onError(String paramString1, int paramInt, String paramString2)
  {
    int i = 0;
    while (i < this.mListeners.size())
    {
      ((XEventListener)this.mListeners.get(i)).onError(paramString1, paramInt, paramString2);
      i += 1;
    }
  }
  
  public void onGetPluginActivity(Activity paramActivity)
  {
    int i = 0;
    while (i < this.mListeners.size())
    {
      ((XEventListener)this.mListeners.get(i)).onGetPluginActivity(paramActivity);
      i += 1;
    }
  }
  
  public void onLog(String paramString1, String paramString2, int paramInt)
  {
    int i = 0;
    while (i < this.mListeners.size())
    {
      ((XEventListener)this.mListeners.get(i)).onLog(paramString1, paramString2, paramInt);
      i += 1;
    }
  }
  
  public void onOpenRoom(String paramString)
  {
    int i = 0;
    while (i < this.mListeners.size())
    {
      ((XEventListener)this.mListeners.get(i)).onOpenRoom(paramString);
      i += 1;
    }
  }
  
  public void onPluginLoaded(String paramString)
  {
    int i = 0;
    while (i < this.mListeners.size())
    {
      ((XEventListener)this.mListeners.get(i)).onPluginLoaded(paramString);
      i += 1;
    }
  }
  
  public void onPluginMsg(String paramString1, String paramString2, Bundle paramBundle)
  {
    int i = 0;
    while (i < this.mListeners.size())
    {
      ((XEventListener)this.mListeners.get(i)).onReceivePluginMsg(paramString1, paramString2, paramBundle);
      i += 1;
    }
  }
  
  public void onPluginRun(String paramString)
  {
    int i = 0;
    while (i < this.mListeners.size())
    {
      ((XEventListener)this.mListeners.get(i)).onPluginRun(paramString);
      i += 1;
    }
  }
  
  public void onPreInstallFish(String paramString1, boolean paramBoolean, String paramString2, String paramString3)
  {
    int i = 0;
    while (i < this.mListeners.size())
    {
      ((XEventListener)this.mListeners.get(i)).onPreInstallFinish(paramString1, paramBoolean, paramString2, paramString3);
      i += 1;
    }
  }
  
  public void onProgress(String paramString, int paramInt)
  {
    int i = 0;
    while (i < this.mListeners.size())
    {
      ((XEventListener)this.mListeners.get(i)).onProgress(paramString, paramInt);
      i += 1;
    }
  }
  
  public void onReceiveMsg(String paramString1, String paramString2, Bundle paramBundle)
  {
    int i = 0;
    while (i < this.mListeners.size())
    {
      ((XEventListener)this.mListeners.get(i)).onReceivePluginMsg(paramString1, paramString2, paramBundle);
      i += 1;
    }
  }
  
  public void onUnzipSo(String paramString1, UnZipSoListener paramUnZipSoListener, String paramString2)
  {
    int i = 0;
    while (i < this.mListeners.size())
    {
      ((XEventListener)this.mListeners.get(i)).onUnZipSo(paramString1, paramUnZipSoListener, paramString2);
      i += 1;
    }
  }
  
  public void removeListener(XEventListener paramXEventListener)
  {
    this.mListeners.remove(paramXEventListener);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\txproxy\EventNotifyHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */