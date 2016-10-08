package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class ContactCard
  extends Entity
{
  public byte bAge;
  public byte bSex;
  public String mobileCode;
  @unique
  public String mobileNo;
  public String nationCode;
  public String nickName;
  public String strCity;
  public String strContactName;
  public String strCountry;
  public String strProvince;
  public String uin;
  
  public ContactCard()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.bSex = -1;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\ContactCard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */