package com.tencent.biz.qqstory.takevideo.publish;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class GenerateVideoResult
{
  public final String a;
  public final byte[] a;
  public final String b;
  
  public GenerateVideoResult(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.b = paramString2;
  }
  
  public String toString()
  {
    return "GenerateVideoResult{mVideoPath='" + this.jdField_a_of_type_JavaLangString + '\'' + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\publish\GenerateVideoResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */