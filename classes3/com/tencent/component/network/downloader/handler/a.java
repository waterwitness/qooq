package com.tencent.component.network.downloader.handler;

import com.tencent.component.network.downloader.DownloadResult;
import org.apache.http.HttpResponse;

public abstract interface a<T>
{
  public abstract boolean handleContentType(DownloadResult paramDownloadResult, HttpResponse paramHttpResponse);
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\downloader\handler\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */