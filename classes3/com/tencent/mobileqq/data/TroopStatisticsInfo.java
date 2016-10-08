package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class TroopStatisticsInfo
  extends Entity
{
  public long count;
  @unique
  public String troopUin;
  
  public TroopStatisticsInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\TroopStatisticsInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */