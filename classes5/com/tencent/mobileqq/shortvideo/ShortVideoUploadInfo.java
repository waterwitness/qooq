package com.tencent.mobileqq.shortvideo;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ShortVideoUploadInfo
  extends ShortVideoBaseInfo
{
  public ShortVideoUploadInfo.RetryInfo a;
  public Object a;
  public boolean b;
  public int c;
  public boolean c;
  public int d;
  public boolean d;
  public int e;
  public int f;
  public int g;
  public int h;
  public String h;
  public int i;
  public String i;
  public String j;
  public String k;
  public String l;
  
  public ShortVideoUploadInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = true;
  }
  
  public boolean a()
  {
    return super.a();
  }
  
  public String toLogString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nShortVideoUploadInfo");
    localStringBuilder.append("\n |-").append("localPath:").append(this.jdField_h_of_type_JavaLangString);
    localStringBuilder.append("\n |-").append("md5:").append(this.jdField_e_of_type_JavaLangString);
    localStringBuilder.append("\n |-").append("thumbPath:").append(this.j);
    localStringBuilder.append("\n |-").append("thumbWidth:").append(this.jdField_c_of_type_Int);
    localStringBuilder.append("\n |-").append("thumbHeight:").append(this.d);
    localStringBuilder.append("\n |-").append("sendSizeSpec:").append(this.jdField_e_of_type_Int);
    localStringBuilder.append("\n |-").append("fileTime:").append(this.f);
    localStringBuilder.append("\n |-").append("fileSource:").append(this.l);
    localStringBuilder.append("\n |-").append("supportProgressive:").append(this.jdField_c_of_type_Boolean);
    localStringBuilder.append("\n |-").append("fileWidth:").append(this.jdField_h_of_type_Int);
    localStringBuilder.append("\n |-").append("fileHeight:").append(this.i);
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


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\ShortVideoUploadInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */