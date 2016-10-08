package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class VideoSliceInfo
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public int d;
  
  public VideoSliceInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoSliceInfo\n");
    localStringBuilder.append("mIndex=").append(this.jdField_a_of_type_Int);
    localStringBuilder.append(",mVideoDuration=").append(this.jdField_b_of_type_Int);
    localStringBuilder.append(",mEncodeFinish=").append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(",mVideoPath(").append(this.c + "*" + this.d).append(")=").append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(",mVideoMd5=").append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(",mSendClicked=").append(this.jdField_b_of_type_Boolean);
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\VideoSliceInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */