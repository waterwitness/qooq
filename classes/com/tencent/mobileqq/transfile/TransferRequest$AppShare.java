package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class TransferRequest$AppShare
{
  public long a;
  public String a;
  
  public TransferRequest$AppShare()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mAppShareID:" + this.jdField_a_of_type_Long);
    localStringBuilder.append(",mShareUrl:" + this.jdField_a_of_type_JavaLangString);
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\transfile\TransferRequest$AppShare.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */