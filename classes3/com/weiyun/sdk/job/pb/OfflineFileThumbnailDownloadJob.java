package com.weiyun.sdk.job.pb;

import com.weiyun.sdk.IWyFileSystem.ThumbnailType;
import com.weiyun.sdk.job.DownloadJobContext;
import com.weiyun.sdk.job.af.AddressFetcher;
import com.weiyun.sdk.job.af.AddressFetcher.TransferAddress;
import com.weiyun.sdk.job.af.pb.PbOfflineFileThunbnailAddressFetcher;
import com.weiyun.sdk.job.transfer.HttpDownloadTransfer;
import com.weiyun.sdk.job.transfer.Transfer;

public class OfflineFileThumbnailDownloadJob
  extends OfflineFileDownloadJob
{
  protected final IWyFileSystem.ThumbnailType mThumbnailType;
  
  public OfflineFileThumbnailDownloadJob(long paramLong, DownloadJobContext paramDownloadJobContext, int paramInt, IWyFileSystem.ThumbnailType paramThumbnailType)
  {
    super(paramLong, paramDownloadJobContext, paramInt);
    this.mThumbnailType = paramThumbnailType;
  }
  
  protected AddressFetcher createDownloadAddressFetcher()
  {
    return new PbOfflineFileThunbnailAddressFetcher(this.mJobContext.getUin(), this.mJobContext.getFileId(), this.mOfflineFileType, this.mThumbnailType);
  }
  
  protected Transfer createTransfer(AddressFetcher.TransferAddress paramTransferAddress)
  {
    return new HttpDownloadTransfer(paramTransferAddress, this.mJobContext, this);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\weiyun\sdk\job\pb\OfflineFileThumbnailDownloadJob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */