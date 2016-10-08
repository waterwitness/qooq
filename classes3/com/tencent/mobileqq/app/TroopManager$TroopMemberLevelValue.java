package com.tencent.mobileqq.app;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class TroopManager$TroopMemberLevelValue
{
  public int a;
  public String a;
  
  public TroopManager$TroopMemberLevelValue(TroopManager paramTroopManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof TroopMemberLevelValue))
    {
      paramObject = (TroopMemberLevelValue)paramObject;
      if ((((TroopMemberLevelValue)paramObject).jdField_a_of_type_Int == this.jdField_a_of_type_Int) && (((TroopMemberLevelValue)paramObject).jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString))) {
        return true;
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.jdField_a_of_type_Int + this.jdField_a_of_type_JavaLangString.hashCode();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\TroopManager$TroopMemberLevelValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */