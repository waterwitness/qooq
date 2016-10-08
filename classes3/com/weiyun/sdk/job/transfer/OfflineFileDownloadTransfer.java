package com.weiyun.sdk.job.transfer;

import com.weiyun.sdk.job.BaseDownloadJob;
import com.weiyun.sdk.job.DownloadJobContext;
import com.weiyun.sdk.job.af.AddressFetcher.TransferAddress;
import java.net.HttpURLConnection;
import java.net.ProtocolException;

public class OfflineFileDownloadTransfer
  extends BaseDownloadTransfer
{
  public OfflineFileDownloadTransfer(AddressFetcher.TransferAddress paramTransferAddress, DownloadJobContext paramDownloadJobContext, BaseDownloadJob paramBaseDownloadJob)
  {
    super(paramTransferAddress, paramDownloadJobContext, paramBaseDownloadJob);
  }
  
  protected void setHttpHeader(HttpURLConnection paramHttpURLConnection)
    throws ProtocolException
  {
    super.setHttpHeader(paramHttpURLConnection);
    paramHttpURLConnection.setRequestProperty("Range", this.mContext.getCurSize() + "-");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\weiyun\sdk\job\transfer\OfflineFileDownloadTransfer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */