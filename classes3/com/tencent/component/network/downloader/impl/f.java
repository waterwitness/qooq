package com.tencent.component.network.downloader.impl;

import android.text.TextUtils;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.component.network.downloader.strategy.DownloadPreprocessStrategy;
import com.tencent.component.network.downloader.strategy.DownloadPreprocessStrategy.DownloadPool;
import com.tencent.component.network.downloader.strategy.KeepAliveStrategy;
import com.tencent.component.network.module.base.a;
import org.apache.http.HttpRequest;

final class f
  implements DownloadPreprocessStrategy
{
  f(Downloader paramDownloader) {}
  
  public final DownloadPreprocessStrategy.DownloadPool downloadPool(String paramString1, String paramString2)
  {
    if (c.a.c(paramString2)) {
      return DownloadPreprocessStrategy.DownloadPool.SPECIFIC1;
    }
    paramString1 = this.a.getKeepAliveStrategy();
    if ((paramString1 != null) && (paramString1.supportKeepAlive(paramString2))) {
      return DownloadPreprocessStrategy.DownloadPool.SPECIFIC;
    }
    return DownloadPreprocessStrategy.DownloadPool.COMMON;
  }
  
  public final void prepareRequest(String paramString1, String paramString2, HttpRequest paramHttpRequest)
  {
    if ((paramHttpRequest != null) && (paramString2 != null)) {
      if ((TextUtils.isEmpty(paramString2)) || ((!paramString2.endsWith("photo.store.qq.com")) && (!paramString2.endsWith("qpic.cn")))) {
        break label73;
      }
    }
    label73:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        paramHttpRequest.addHeader("Cookie", "uin=o" + a.f() + ";");
      }
      return;
    }
  }
  
  public final String prepareUrl(String paramString)
  {
    return paramString;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\downloader\impl\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */