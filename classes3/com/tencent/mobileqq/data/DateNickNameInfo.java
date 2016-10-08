package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class DateNickNameInfo
{
  public long lastUpdateTime;
  public String nickName;
  
  public DateNickNameInfo(String paramString, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.nickName = paramString;
    this.lastUpdateTime = paramLong;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\DateNickNameInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */