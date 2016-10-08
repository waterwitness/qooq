package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;

public class CouponH5Data
  extends Entity
{
  public String mData;
  public String mHost;
  public String mKey;
  public String mPath;
  
  public CouponH5Data()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public CouponH5Data(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.mHost = paramString1;
    this.mPath = paramString2;
    this.mKey = paramString3;
    this.mData = paramString4;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\CouponH5Data.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */