package com.tencent.mobileqq.shortvideo;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ShortVideoForwardInfo
  extends ShortVideoBaseInfo
{
  public static final int e = 0;
  public static final int f = 1;
  public static final int g = 2;
  public static final int h = 3;
  public ShortVideoForwardInfo.RetryInfo a;
  public Object a;
  public boolean b;
  public int c;
  public int d;
  public String h;
  public int i;
  public String i;
  public int j;
  public String j;
  public int k;
  public String k;
  public int l;
  public String l;
  public int m;
  public String m;
  public int n;
  public int o;
  public int p;
  public int q;
  public int r;
  public int s;
  
  public ShortVideoForwardInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String toLogString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nShortVideoForwardInfo");
    localStringBuilder.append("\n |-").append("fromChatType:").append(this.c);
    localStringBuilder.append("\n |-").append("toChatType:").append(this.d);
    localStringBuilder.append("\n |-").append("fromBusiType:").append(this.jdField_i_of_type_Int);
    localStringBuilder.append("\n |-").append("toBusiType:").append(this.jdField_j_of_type_Int);
    localStringBuilder.append("\n |-").append("localPath:").append(this.h);
    localStringBuilder.append("\n |-").append("md5:").append(this.e);
    localStringBuilder.append("\n |-").append("thumbPath:").append(this.jdField_i_of_type_JavaLangString);
    localStringBuilder.append("\n |-").append("thumbWidth:").append(this.k);
    localStringBuilder.append("\n |-").append("thumbHeight:").append(this.jdField_l_of_type_Int);
    localStringBuilder.append("\n |-").append("sendSizeSpec:").append(this.jdField_m_of_type_Int);
    localStringBuilder.append("\n |-").append("fileTime:").append(this.n);
    localStringBuilder.append("\n |-").append("fileSource:").append(this.jdField_j_of_type_JavaLangString);
    localStringBuilder.append("\n |-").append("uuid:").append(this.a);
    localStringBuilder.append("\n |-").append("fromUin:").append(this.jdField_l_of_type_JavaLangString);
    localStringBuilder.append("\n |-").append("fromSessionUin:").append(this.jdField_m_of_type_JavaLangString);
    localStringBuilder.append("\n |-").append("supportProgressive:").append(this.b);
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(toLogString());
    localStringBuilder.append(super.toString());
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\ShortVideoForwardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */