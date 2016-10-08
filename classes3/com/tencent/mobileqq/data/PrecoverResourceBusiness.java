package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class PrecoverResourceBusiness
  extends PrecoverResource
{
  public PrecoverResourceBusiness() {}
  
  public PrecoverResourceBusiness(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    super(paramString1, paramString2, paramString3, paramString4);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PrecoverResourceBusiness:pk=").append(this.pk);
    localStringBuilder.append(",businessId=").append(this.businessId);
    localStringBuilder.append(",resId=").append(this.resId);
    localStringBuilder.append(",url=").append(this.url);
    localStringBuilder.append(",md5=").append(this.md5);
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\PrecoverResourceBusiness.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */