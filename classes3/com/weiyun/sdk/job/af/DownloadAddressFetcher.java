package com.weiyun.sdk.job.af;

public abstract class DownloadAddressFetcher
  extends AddressFetcher
{
  protected final String mFileId;
  protected final String mFileName;
  protected final String mMacAddress;
  protected final String mParentDirKey;
  protected final long mUin;
  
  public DownloadAddressFetcher(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.mUin = paramLong;
    this.mFileId = paramString1;
    this.mParentDirKey = paramString2;
    this.mFileName = paramString3;
    this.mMacAddress = paramString4;
  }
  
  public AddressFetcher.DownloadAddress createDownloadAddress(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    return new AddressFetcher.DownloadAddress(paramString1, paramInt, paramString2, paramString3, paramString4, paramString5);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\weiyun\sdk\job\af\DownloadAddressFetcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */