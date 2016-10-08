package com.tencent.biz.pubaccount.AccountDetail.bean;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class DynamicInfoEntity
  extends Entity
{
  public byte[] dynamicInfoData;
  @unique
  public String puin;
  
  public DynamicInfoEntity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\AccountDetail\bean\DynamicInfoEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */