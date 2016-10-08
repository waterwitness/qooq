package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class RecommendFriend
  extends Entity
{
  public String name;
  public String source;
  @unique
  public String uin;
  
  public RecommendFriend()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\RecommendFriend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */