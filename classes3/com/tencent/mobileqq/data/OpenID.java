package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class OpenID
  extends Entity
{
  @unique
  public String appID;
  public String openID;
  
  public OpenID()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String toString()
  {
    return "appid = " + this.appID + "; openid = " + this.openID;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\OpenID.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */