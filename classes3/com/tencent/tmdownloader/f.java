package com.tencent.tmdownloader;

import android.os.Handler;
import android.os.Message;
import com.tencent.tmassistantbase.a.m;
import com.tencent.tmdownloader.internal.downloadclient.b;

class f
  extends Handler
{
  f(TMAssistantDownloadService paramTMAssistantDownloadService) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 0: 
      do
      {
        return;
        m.c("TMAssistantDownloadSDKService", "MSG_INIT_YYBMG......");
      } while ((com.tencent.tmassistantbase.a.f.a().k() < 5) && (com.tencent.tmassistantbase.a.f.a().l() < 1));
      if (TMAssistantDownloadService.access$200(this.a) == null) {
        TMAssistantDownloadService.access$202(this.a, new b());
      }
      TMAssistantDownloadService.access$200(this.a).a(this.a.getApplicationContext(), "TMAssistantYYBManager");
      TMAssistantDownloadService.access$200(this.a).b(this.a.getApplicationContext(), "open_sdkcom.tencent.mobileqq:web");
      sendEmptyMessage(1);
      return;
    }
    m.c("TMAssistantDownloadSDKService", "MSG_HANDSHAKE_YYB......");
    TMAssistantDownloadService.access$200(this.a).a();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmdownloader\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */