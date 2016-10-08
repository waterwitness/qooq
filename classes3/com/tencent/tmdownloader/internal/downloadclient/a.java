package com.tencent.tmdownloader.internal.downloadclient;

import android.content.Context;
import com.tencent.tmassistantbase.a.m;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import com.tencent.tmdownloader.TMAssistantDownloadSettingClient;

class a
  implements Runnable
{
  a(MobileQQCloseServiceReceiver paramMobileQQCloseServiceReceiver, Context paramContext) {}
  
  public void run()
  {
    try
    {
      boolean bool = TMAssistantDownloadManager.getInstance(this.a).getDownloadSDKSettingClient().isAllDownloadFinished();
      m.c("MobileQQCloseServiceReceiver", "receive broadcast isAllDownloadFinished = " + bool);
      if (bool) {
        TMAssistantDownloadManager.closeAllService(this.a);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmdownloader\internal\downloadclient\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */