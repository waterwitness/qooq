package com.tencent.biz.qqstory.takevideo.publish;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class GenerateThumbResult
{
  public final int a;
  public final String a;
  public final byte[] a;
  public final int b;
  
  public GenerateThumbResult(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public String toString()
  {
    return "GenerateThumbResult{mPath='" + this.jdField_a_of_type_JavaLangString + '\'' + ", mWidth=" + this.jdField_a_of_type_Int + ", mHeight=" + this.b + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\publish\GenerateThumbResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */