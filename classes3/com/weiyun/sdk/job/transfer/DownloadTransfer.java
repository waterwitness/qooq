package com.weiyun.sdk.job.transfer;

import com.weiyun.sdk.job.BaseDownloadJob;
import com.weiyun.sdk.job.DownloadJobContext;
import com.weiyun.sdk.job.af.AddressFetcher.DownloadAddress;
import java.net.HttpURLConnection;
import java.net.ProtocolException;

public class DownloadTransfer
  extends BaseDownloadTransfer
{
  public DownloadTransfer(AddressFetcher.DownloadAddress paramDownloadAddress, DownloadJobContext paramDownloadJobContext, BaseDownloadJob paramBaseDownloadJob)
  {
    super(paramDownloadAddress, paramDownloadJobContext, paramBaseDownloadJob);
  }
  
  protected boolean isSupportContinueInterruption()
  {
    return true;
  }
  
  protected boolean isSupportSplitDownload()
  {
    return true;
  }
  
  protected void setHttpHeader(HttpURLConnection paramHttpURLConnection)
    throws ProtocolException
  {
    super.setHttpHeader(paramHttpURLConnection);
    AddressFetcher.DownloadAddress localDownloadAddress = (AddressFetcher.DownloadAddress)this.mDownloadAddress;
    long l;
    if (usingSplitDownload())
    {
      l = this.mContext.getCurSize() + getSplitSize() - 1L;
      if ((this.mContext.getTotalSize() > 0L) && (l >= this.mContext.getTotalSize())) {
        paramHttpURLConnection.setRequestProperty("Range", "bytes=" + this.mContext.getCurSize() + "-");
      }
    }
    for (;;)
    {
      paramHttpURLConnection.setRequestProperty("Cookie", localDownloadAddress.getCookieName() + "=" + localDownloadAddress.getCookieValue());
      return;
      paramHttpURLConnection.setRequestProperty("Range", "bytes=" + this.mContext.getCurSize() + "-" + l);
      continue;
      paramHttpURLConnection.setRequestProperty("Range", "bytes=" + this.mContext.getCurSize() + "-");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\weiyun\sdk\job\transfer\DownloadTransfer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */