package com.tencent.tmdownloader;

import android.os.Handler;
import com.tencent.tmassistantbase.a.m;

class e
  implements Runnable
{
  e(TMAssistantDownloadService paramTMAssistantDownloadService) {}
  
  public void run()
  {
    try
    {
      Thread.sleep(10000L);
      TMAssistantDownloadService.access$000(this.a).sendEmptyMessage(0);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      m.b("TMAssistantDownloadSDKService", "exception:", localInterruptedException);
      localInterruptedException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmdownloader\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */