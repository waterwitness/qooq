package com.tencent.av.ui;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class JSInterfacePushData
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  String jdField_a_of_type_JavaLangString;
  String b;
  
  public JSInterfacePushData(int paramInt, String paramString1, String paramString2, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.b = "";
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Long = paramLong;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\ui\JSInterfacePushData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */