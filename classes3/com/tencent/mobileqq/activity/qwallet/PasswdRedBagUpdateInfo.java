package com.tencent.mobileqq.activity.qwallet;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class PasswdRedBagUpdateInfo
{
  public int a;
  public long a;
  public long b;
  
  public PasswdRedBagUpdateInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof PasswdRedBagUpdateInfo))
    {
      paramObject = (PasswdRedBagUpdateInfo)paramObject;
      if ((((PasswdRedBagUpdateInfo)paramObject).jdField_a_of_type_Int == this.jdField_a_of_type_Int) && (((PasswdRedBagUpdateInfo)paramObject).jdField_a_of_type_Long == this.jdField_a_of_type_Long)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\qwallet\PasswdRedBagUpdateInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */