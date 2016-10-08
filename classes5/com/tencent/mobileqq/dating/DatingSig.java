package com.tencent.mobileqq.dating;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class DatingSig
  extends Entity
{
  public String datingId;
  @unique
  public long openId;
  public byte[] sig;
  public long timestamp;
  
  public DatingSig()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\dating\DatingSig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */