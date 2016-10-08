package com.tencent.av.gaudio;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class AVUserInfo
{
  public int a;
  public long a;
  public int b;
  
  public AVUserInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String toString()
  {
    return "AVUserInfo-->Account = " + this.jdField_a_of_type_Long + " , AccountType = " + this.jdField_a_of_type_Int + " , pstnStatus = " + this.b + " .";
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\gaudio\AVUserInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */