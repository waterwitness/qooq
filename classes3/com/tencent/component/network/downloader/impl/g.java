package com.tencent.component.network.downloader.impl;

import android.text.TextUtils;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.DownloadResult.Content;
import org.apache.http.HttpResponse;

final class g
  implements com.tencent.component.network.downloader.handler.a
{
  public final boolean handleContentType(DownloadResult paramDownloadResult, HttpResponse paramHttpResponse)
  {
    paramDownloadResult = paramDownloadResult.getContent().type;
    if (TextUtils.isEmpty(paramDownloadResult)) {}
    while (!com.tencent.component.network.downloader.common.a.e(paramDownloadResult, "image")) {
      return false;
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\downloader\impl\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */