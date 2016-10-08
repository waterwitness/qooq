package com.tencent.mobileqq.vas;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class IndividuationConfigInfo$ShapedImgConfig
{
  public long a;
  public String a;
  public long b;
  public String b;
  public String c;
  
  public IndividuationConfigInfo$ShapedImgConfig()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ShapedImgConfig: ").append("bizName=").append(this.jdField_a_of_type_JavaLangString).append(";").append("imgUrl=").append(this.jdField_b_of_type_JavaLangString).append(";").append("id=").append(this.c).append("begin=").append(this.jdField_a_of_type_Long).append("end=").append(this.jdField_b_of_type_Long);
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vas\IndividuationConfigInfo$ShapedImgConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */