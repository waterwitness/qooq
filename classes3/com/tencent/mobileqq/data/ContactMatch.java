package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class ContactMatch
  extends Entity
{
  public boolean isReaded;
  @unique
  public String mobileNo;
  public String name;
  public long timestamp;
  public String unifiedCode;
  
  public ContactMatch()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\ContactMatch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */