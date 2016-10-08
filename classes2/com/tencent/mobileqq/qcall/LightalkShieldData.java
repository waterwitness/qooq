package com.tencent.mobileqq.qcall;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class LightalkShieldData
  extends Entity
{
  @unique
  public String phone;
  public long qcallId;
  
  public LightalkShieldData()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\qcall\LightalkShieldData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */