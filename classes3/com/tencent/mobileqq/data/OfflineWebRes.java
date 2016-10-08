package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class OfflineWebRes
  extends Entity
{
  public String bid;
  public String fileName;
  public String hashName;
  public int hitCount;
  @unique
  public String md5;
  
  public OfflineWebRes()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.hitCount = 1;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\OfflineWebRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */