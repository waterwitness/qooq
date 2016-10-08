package com.tencent.qidian.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class BmqqAccountType
  extends Entity
{
  public static final int TYPE_ACCOUNT_BMQQ_EXT = 0;
  public static final int TYPE_ACCOUNT_CRM_EXT = 2;
  public static final int TYPE_ACCOUNT_CRM_MAIN = 3;
  public static final int TYPE_ACCOUNT_NOT_UIN = 5;
  public static final int TYPE_ACCOUNT_QIDIAN_EXT = 1;
  public static final int TYPE_ACCOUNT_UNKNOW = 4;
  public int mAccountType;
  @unique
  public String mUin;
  
  public BmqqAccountType()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.mUin = "";
  }
  
  public BmqqAccountType(String paramString, int paramInt)
  {
    this.mUin = "";
    this.mUin = paramString;
    this.mAccountType = paramInt;
  }
  
  public int getAccountType()
  {
    return this.mAccountType;
  }
  
  public String getUin()
  {
    return this.mUin;
  }
  
  public void setAccountType(int paramInt)
  {
    this.mAccountType = paramInt;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\qidian\data\BmqqAccountType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */