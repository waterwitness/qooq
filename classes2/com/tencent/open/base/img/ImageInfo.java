package com.tencent.open.base.img;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ImageInfo
{
  public int a;
  public long a;
  public String a;
  public long b;
  public String b;
  public long c;
  public String c;
  
  public ImageInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Long = 259200L;
  }
  
  public boolean equals(Object paramObject)
  {
    paramObject = (ImageInfo)paramObject;
    if (paramObject != null) {
      return ((ImageInfo)paramObject).jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString);
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.jdField_a_of_type_JavaLangString.hashCode();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\base\img\ImageInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */