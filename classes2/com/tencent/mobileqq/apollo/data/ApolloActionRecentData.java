package com.tencent.mobileqq.apollo.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;

public class ApolloActionRecentData
  extends Entity
{
  public int actionId;
  public int orderId;
  public String sessionType;
  public String uin;
  
  public ApolloActionRecentData()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\data\ApolloActionRecentData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */