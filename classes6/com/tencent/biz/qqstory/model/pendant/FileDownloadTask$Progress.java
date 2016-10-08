package com.tencent.biz.qqstory.model.pendant;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class FileDownloadTask$Progress
{
  public final long a;
  public final FileDownloadTask.Input a;
  public final long b;
  
  public FileDownloadTask$Progress(FileDownloadTask.Input paramInput, long paramLong1, long paramLong2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentBizQqstoryModelPendantFileDownloadTask$Input = paramInput;
    this.jdField_a_of_type_Long = paramLong1;
    this.b = paramLong2;
  }
  
  public String toString()
  {
    return "Progress{intput=" + this.jdField_a_of_type_ComTencentBizQqstoryModelPendantFileDownloadTask$Input + ", downloadBytes=" + this.jdField_a_of_type_Long + ", totalBytes=" + this.b + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\model\pendant\FileDownloadTask$Progress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */