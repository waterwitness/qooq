package com.tencent.mobileqq.nearby;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;

public class NearbyEntityManagerFactory$VerifyEntity
  extends Entity
{
  public String flags;
  public String name;
  
  public NearbyEntityManagerFactory$VerifyEntity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.flags = "nearby_verify_entity";
    this.name = "";
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\NearbyEntityManagerFactory$VerifyEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */