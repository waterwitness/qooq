package com.tencent.upload.uinterface.data;

import com.tencent.upload.uinterface.AbstractUploadResult;

public class MobileLogUploadResult
  extends AbstractUploadResult
{
  public long iUin = 0L;
  
  public MobileLogUploadResult(long paramLong, int paramInt)
  {
    this.iUin = paramLong;
    this.flowId = paramInt;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\uinterface\data\MobileLogUploadResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */