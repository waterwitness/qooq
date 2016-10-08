package com.tencent.upload.network;

import com.tencent.upload.a.b;
import com.tencent.upload.common.UploadConfiguration.NetworkStateObserver;

final class d
  extends UploadConfiguration.NetworkStateObserver
{
  d(c paramc) {}
  
  public final void onStateChanged(boolean paramBoolean)
  {
    b.d("SessionManager", c.a(this.a) + " " + b.a(c.b(this.a)) + " NetworkStateObserver isConnected:" + paramBoolean);
    if (!paramBoolean)
    {
      c.d(this.a).post(new e(this));
      return;
    }
    c.d(this.a).post(new f(this));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\network\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */