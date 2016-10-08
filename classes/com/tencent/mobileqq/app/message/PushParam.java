package com.tencent.mobileqq.app.message;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class PushParam
{
  public long a;
  public String a;
  
  public PushParam(String paramString, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramLong;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\message\PushParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */