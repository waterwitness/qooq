package com.tencent.biz.qqstory.base.videoupload;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class VideoUploadHelper$UploadResult
{
  public int a;
  public long a;
  public ErrorMessage a;
  public String a;
  public long b;
  public String b;
  public String c;
  public String d;
  
  public VideoUploadHelper$UploadResult()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage();
  }
  
  public String toString()
  {
    return "UploadResult{errorMessage=" + this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage + ", fileKey='" + this.jdField_a_of_type_JavaLangString + '\'' + ", fileId='" + this.b + '\'' + ", uploadServerIp='" + this.d + '\'' + ", mLastUploadOffset='" + this.jdField_a_of_type_Int + '\'' + ", cdnUrl='" + this.c + '\'' + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\videoupload\VideoUploadHelper$UploadResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */