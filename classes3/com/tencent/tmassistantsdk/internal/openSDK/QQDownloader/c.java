package com.tencent.tmassistantsdk.internal.openSDK.QQDownloader;

import android.content.Context;

class c
  extends Thread
{
  c(QQDownloaderInstalled paramQQDownloaderInstalled, Context paramContext) {}
  
  public void run()
  {
    if (this.b.d != null) {
      this.b.d.onQQDownloaderInstalled(this.a);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmassistantsdk\internal\openSDK\QQDownloader\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */