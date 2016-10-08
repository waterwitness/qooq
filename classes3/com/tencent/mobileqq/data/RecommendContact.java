package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class RecommendContact
  extends Entity
{
  public String contactName;
  public boolean isRead;
  @unique
  public String key;
  public String mobileCode;
  public String mobileNo;
  public String nationCode;
  public String nickName;
  public long originBinder;
  public String source;
  public long timeStamp;
  public int type;
  public String uin;
  
  public RecommendContact()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean equals(Object paramObject)
  {
    return this.key.equals(((RecommendContact)paramObject).key);
  }
  
  public int hashCode()
  {
    return this.key.hashCode();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\RecommendContact.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */