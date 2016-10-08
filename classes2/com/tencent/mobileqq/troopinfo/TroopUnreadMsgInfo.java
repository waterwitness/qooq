package com.tencent.mobileqq.troopinfo;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class TroopUnreadMsgInfo
{
  public int a;
  public long a;
  public String a;
  public int b;
  
  public TroopUnreadMsgInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("[").append(this.jdField_a_of_type_JavaLangString).append(",").append(this.jdField_a_of_type_Long).append(",").append(this.jdField_a_of_type_Int).append(",").append(this.b).append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troopinfo\TroopUnreadMsgInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */