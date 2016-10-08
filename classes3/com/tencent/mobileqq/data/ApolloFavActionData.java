package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class ApolloFavActionData
  extends Entity
{
  public int acitonId;
  @unique
  public long favId;
  public String text;
  public int textType;
  
  public ApolloFavActionData()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        return false;
        paramObject = (ApolloFavActionData)paramObject;
        if (!TextUtils.isEmpty(this.text)) {
          break;
        }
      } while ((((ApolloFavActionData)paramObject).acitonId != this.acitonId) || (!TextUtils.isEmpty(((ApolloFavActionData)paramObject).text)));
      return true;
    } while ((((ApolloFavActionData)paramObject).acitonId != this.acitonId) || (!this.text.equals(((ApolloFavActionData)paramObject).text)) || (((ApolloFavActionData)paramObject).textType != this.textType));
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("actionId:").append(this.acitonId).append(" text:").append(this.text).append(" textType:").append(this.textType);
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\ApolloFavActionData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */