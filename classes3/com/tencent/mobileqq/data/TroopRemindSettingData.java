package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class TroopRemindSettingData
  extends Entity
{
  public int isOpenState;
  @unique
  public String troopUin;
  
  public TroopRemindSettingData()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\TroopRemindSettingData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */