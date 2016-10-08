package com.tencent.mobileqq.persistence;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class OGColumn
{
  public Class a;
  public String a;
  public String b;
  
  public OGColumn()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public OGColumn(Class paramClass, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangClass = paramClass;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  public String toString()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\persistence\OGColumn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */