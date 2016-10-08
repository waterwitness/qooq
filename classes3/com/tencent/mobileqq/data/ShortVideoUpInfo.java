package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class ShortVideoUpInfo
  extends Entity
{
  @unique
  public String key;
  public long lastIp;
  public long timeStamp;
  public long transferedSize;
  public String uKey;
  
  public ShortVideoUpInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\ShortVideoUpInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */