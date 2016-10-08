package com.tencent.upload.uinterface.data;

import com.tencent.upload.uinterface.AbstractUploadResult;

public class MoodUploadResult
  extends AbstractUploadResult
{
  public final byte[] vBusiNessDataRsp;
  
  public MoodUploadResult(byte[] paramArrayOfByte)
  {
    this.vBusiNessDataRsp = paramArrayOfByte;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\uinterface\data\MoodUploadResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */