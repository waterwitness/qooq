package com.weiyun.sdk.job.af.pb;

import com.weiyun.sdk.IWyFileSystem.ThumbnailType;
import com.weiyun.sdk.job.af.AddressFetcher.DownloadAddress;
import com.weiyun.sdk.job.af.AddressFetcher.OfflineFileThumbnailDownloadAddress;
import com.weiyun.sdk.util.ThumbnailUtils;

public class PbOfflineFileThunbnailAddressFetcher
  extends PbOfflineFileAddressFetcher
{
  protected final IWyFileSystem.ThumbnailType mThumbnailType;
  
  public PbOfflineFileThunbnailAddressFetcher(long paramLong, String paramString, int paramInt, IWyFileSystem.ThumbnailType paramThumbnailType)
  {
    super(paramLong, paramString, paramInt);
    this.mThumbnailType = paramThumbnailType;
  }
  
  protected AddressFetcher.DownloadAddress createDownloadAddress(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    return new AddressFetcher.OfflineFileThumbnailDownloadAddress(paramString1, paramInt, paramString3, paramString2, ThumbnailUtils.getThumbnailSpec(this.mThumbnailType));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\weiyun\sdk\job\af\pb\PbOfflineFileThunbnailAddressFetcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */