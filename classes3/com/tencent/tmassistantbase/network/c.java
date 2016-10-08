package com.tencent.tmassistantbase.network;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class c
  extends Handler
{
  private WeakReference<NetworkMonitorReceiver> a;
  
  public c(NetworkMonitorReceiver paramNetworkMonitorReceiver)
  {
    this.a = new WeakReference(paramNetworkMonitorReceiver);
  }
  
  public void handleMessage(Message paramMessage)
  {
    NetworkMonitorReceiver localNetworkMonitorReceiver = (NetworkMonitorReceiver)this.a.get();
    if ((paramMessage.what == 67) && (localNetworkMonitorReceiver != null)) {
      localNetworkMonitorReceiver.d();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmassistantbase\network\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */