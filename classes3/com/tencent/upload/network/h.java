package com.tencent.upload.network;

import com.tencent.upload.common.UploadConfiguration;

final class h
  implements Runnable
{
  h(c paramc) {}
  
  public final void run()
  {
    if (!UploadConfiguration.isNetworkAvailable()) {
      return;
    }
    c.e(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\network\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */