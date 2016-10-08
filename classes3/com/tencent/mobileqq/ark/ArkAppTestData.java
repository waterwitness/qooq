package com.tencent.mobileqq.ark;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class ArkAppTestData
  extends Entity
{
  public long date;
  @unique
  public String name;
  public String value;
  
  public ArkAppTestData()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\ark\ArkAppTestData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */