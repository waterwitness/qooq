package com.weiyun.sdk.job.pb;

import com.weiyun.sdk.job.BaseDownloadJob;
import com.weiyun.sdk.job.DownloadJobContext;
import com.weiyun.sdk.job.af.AddressFetcher;
import com.weiyun.sdk.job.af.AddressFetcher.TransferAddress;
import com.weiyun.sdk.job.af.pb.PbOfflineFileAddressFetcher;
import com.weiyun.sdk.job.transfer.OfflineFileDownloadTransfer;
import com.weiyun.sdk.job.transfer.Transfer;

public class OfflineFileDownloadJob
  extends BaseDownloadJob
{
  protected final int mOfflineFileType;
  
  public OfflineFileDownloadJob(long paramLong, DownloadJobContext paramDownloadJobContext, int paramInt)
  {
    super(paramLong, paramDownloadJobContext);
    this.mOfflineFileType = paramInt;
  }
  
  protected boolean checkContent()
  {
    if ((this.mJobContext == null) || (this.mJobContext.getFileId() == null) || (this.mJobContext.getFileName() == null) || (this.mJobContext.getDestDirectoryPath() == null) || (this.mJobContext.getDestFileName() == null) || (this.mJobContext.getDestFilePath() == null) || (this.mJobContext.getDataFilePath() == null))
    {
      setLastErrorNo(55535);
      return false;
    }
    return true;
  }
  
  protected AddressFetcher createDownloadAddressFetcher()
  {
    return new PbOfflineFileAddressFetcher(this.mJobContext.getUin(), this.mJobContext.getFileId(), this.mOfflineFileType);
  }
  
  protected Transfer createTransfer(AddressFetcher.TransferAddress paramTransferAddress)
  {
    return new OfflineFileDownloadTransfer(paramTransferAddress, this.mJobContext, this);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\weiyun\sdk\job\pb\OfflineFileDownloadJob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */