package com.tencent.mobileqq.maproam.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class LocationDetail
  implements Cloneable
{
  public double a;
  public String a;
  public double b;
  public String b;
  public String c;
  public String d;
  
  public LocationDetail()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.c = "";
    this.d = "";
    this.jdField_a_of_type_Double = 0.0D;
    this.jdField_b_of_type_Double = 0.0D;
  }
  
  public Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return this;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\maproam\data\LocationDetail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */