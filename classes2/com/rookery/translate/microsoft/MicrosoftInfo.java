package com.rookery.translate.microsoft;

import com.rookery.translate.ServiceInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class MicrosoftInfo
  extends ServiceInfo
{
  private String jdField_a_of_type_JavaLangString;
  private byte[] jdField_a_of_type_ArrayOfByte;
  
  public MicrosoftInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ArrayOfByte = new byte[] { -124, -103, -119, 53, -84, -31, 44, -41, 18, 66, -17, 11, -91, -20, 57, -47, 11, -75, -75, 104, 32, 86, -43, -40, -17, 110, -103, -69, -10, -60, 125, 94, 113, -10, -57, -17, 56, 34, 69, -69, -13, -5, -102, -37, 9, -125, 124, -87, -89, -122, 103, 57, 119, -111, 83, -38 };
    this.jdField_a_of_type_JavaLangString = "qqi_android";
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String b()
  {
    return a(this.jdField_a_of_type_ArrayOfByte, a());
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\rookery\translate\microsoft\MicrosoftInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */