package com.tencent.mobileqq.enterpriseqq;

import com.tencent.crmqq.structmsg.StructMsg.GetCRMMenuResponse;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class EnterpriseQQMenuEntity
  extends Entity
{
  public byte[] data;
  public long savedDateTime;
  public int seqno;
  @unique
  public String uin;
  
  public EnterpriseQQMenuEntity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public EnterpriseQQMenuEntity(String paramString, StructMsg.GetCRMMenuResponse paramGetCRMMenuResponse, int paramInt, long paramLong)
  {
    this.uin = paramString;
    this.data = paramGetCRMMenuResponse.toByteArray();
    this.seqno = paramInt;
    this.savedDateTime = paramLong;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\enterpriseqq\EnterpriseQQMenuEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */