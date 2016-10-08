package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;

public class ApolloActionPackageData
  extends Entity
{
  public int acitonId;
  public int packageId;
  public String text;
  public int textType;
  
  public ApolloActionPackageData()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("actionId:").append(this.acitonId).append(" packageId:").append(this.packageId).append(" text:").append(this.text).append(" textType:").append(this.textType);
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\ApolloActionPackageData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */