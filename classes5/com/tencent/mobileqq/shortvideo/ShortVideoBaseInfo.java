package com.tencent.mobileqq.shortvideo;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract class ShortVideoBaseInfo
  extends ShortVideoInfoInterface
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  
  public ShortVideoBaseInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Int == -1)
    {
      a("ShortVideoBaseInfo.check", "reqBusiType invalid, reqBusiType:" + this.jdField_a_of_type_Int);
      return false;
    }
    if (this.jdField_b_of_type_Int == -1)
    {
      a("ShortVideoBaseInfo.check", "uinType invalid,uinType:" + this.jdField_b_of_type_Int);
      return false;
    }
    if (this.c == null)
    {
      a("ShortVideoBaseInfo.check", "peerUin invalid,peerUin:" + this.c);
      return false;
    }
    return true;
  }
  
  public String toLogString()
  {
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nShortVideoBaseInfo");
    localStringBuilder.append("\n |-").append("localUUID:").append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("\n |-").append("uniseq:").append(this.jdField_a_of_type_Long);
    localStringBuilder.append("\n |-").append("reqBusiType:").append(this.jdField_a_of_type_Int);
    localStringBuilder.append("\n |-").append("selfUin:").append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("\n |-").append("peerUin:").append(this.c);
    localStringBuilder.append("\n |-").append("secondId:").append(this.d);
    localStringBuilder.append("\n |-").append("md5:").append(this.e);
    localStringBuilder.append("\n |-").append("thumbMD5:").append(this.g);
    localStringBuilder.append("\n |-").append("errInfo:").append(this.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo);
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\ShortVideoBaseInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */