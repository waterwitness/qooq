package com.tencent.biz.qqstory.model.pendant;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class FileDownloadTask$Output
{
  public final int a;
  public final FileDownloadTask.Input a;
  public final String a;
  
  public FileDownloadTask$Output(FileDownloadTask.Input paramInput, int paramInt, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentBizQqstoryModelPendantFileDownloadTask$Input = paramInput;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public String toString()
  {
    return "Output{intput=" + this.jdField_a_of_type_ComTencentBizQqstoryModelPendantFileDownloadTask$Input + ", errorCode=" + this.jdField_a_of_type_Int + ", errorMessage='" + this.jdField_a_of_type_JavaLangString + '\'' + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\model\pendant\FileDownloadTask$Output.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */