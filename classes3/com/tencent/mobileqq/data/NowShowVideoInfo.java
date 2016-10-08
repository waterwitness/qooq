package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class NowShowVideoInfo
  extends ProfilePhotoWall
{
  public String mCoverUrl;
  public String mJumpUrl;
  
  public NowShowVideoInfo(String paramString1, String paramString2, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.type = 2;
    this.mCoverUrl = paramString1;
    this.mJumpUrl = paramString2;
    this.time = paramLong;
  }
  
  public String getOriginUrl()
  {
    return this.mCoverUrl;
  }
  
  public String getThumbUrl(int paramInt)
  {
    return this.mCoverUrl;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\NowShowVideoInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */