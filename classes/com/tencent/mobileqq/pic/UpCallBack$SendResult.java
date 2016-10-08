package com.tencent.mobileqq.pic;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class UpCallBack$SendResult
{
  public int a;
  public long a;
  public String a;
  public int b;
  public long b;
  public String b;
  public int c;
  public long c;
  public String c;
  public String d;
  
  public UpCallBack$SendResult()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nSendResult");
    localStringBuilder.append("\n |-").append("result:").append(this.jdField_a_of_type_Int);
    localStringBuilder.append("\n |-").append("errCode:").append(this.jdField_b_of_type_Int);
    localStringBuilder.append("\n |-").append("errStr:").append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("\n |-").append("path:").append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("\n |-").append("size:").append(this.jdField_a_of_type_Long);
    localStringBuilder.append("\n |-").append("uuid:").append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append("\n |-").append("md5:").append(this.d);
    localStringBuilder.append("\n |-").append("groupFileID:").append(this.jdField_b_of_type_Long);
    localStringBuilder.append("\n |-").append("thumbFileSize:").append(this.jdField_c_of_type_Long);
    localStringBuilder.append("\n |-").append("videoAttr:").append(this.jdField_c_of_type_Int);
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\pic\UpCallBack$SendResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */