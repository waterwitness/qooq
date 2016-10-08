package com.tencent.tmdownloader;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.tencent.tmassistant.aidl.a;
import com.tencent.tmassistantbase.a.m;
import java.util.List;

class h
  implements com.tencent.tmassistantbase.a.g
{
  h(g paramg) {}
  
  public void a(List<String> paramList)
  {
    try
    {
      m.c("TMAssistantDownloadSDKService", "onLogPrint : ");
      int j = this.a.a.mCallbacks.beginBroadcast();
      int i = 0;
      for (;;)
      {
        if (i < j) {
          try
          {
            ((a)this.a.a.mCallbacks.getBroadcastItem(i)).a(paramList);
            i += 1;
          }
          catch (RemoteException localRemoteException)
          {
            for (;;)
            {
              m.c("TMAssistantDownloadSDKService", "exception: ", localRemoteException);
            }
          }
        }
      }
      this.a.a.mCallbacks.finishBroadcast();
    }
    catch (Throwable paramList)
    {
      m.c("TMAssistantDownloadSDKService", "exception: ", paramList);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmdownloader\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */