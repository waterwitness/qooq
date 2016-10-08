package com.tencent.mobileqq.unifiedname;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.Utils;

public class MQQName
{
  public int a;
  public String a;
  
  public MQQName()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public MQQName(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(MQQName paramMQQName)
  {
    if (paramMQQName != null)
    {
      this.jdField_a_of_type_Int = paramMQQName.jdField_a_of_type_Int;
      this.jdField_a_of_type_JavaLangString = paramMQQName.jdField_a_of_type_JavaLangString;
    }
  }
  
  public Object clone()
  {
    return new MQQName(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof MQQName))
    {
      paramObject = (MQQName)paramObject;
      bool1 = bool2;
      if (((MQQName)paramObject).jdField_a_of_type_Int == this.jdField_a_of_type_Int)
      {
        bool1 = bool2;
        if (Utils.a(((MQQName)paramObject).jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\unifiedname\MQQName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */