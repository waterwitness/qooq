package com.tencent.biz.qqstory.base.videoupload.job;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

public class CacheImageJobSegment
  extends JobSegment
{
  public static final String a = "local_path";
  
  public CacheImageJobSegment()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(JobContext paramJobContext, FileUploadRspData paramFileUploadRspData)
  {
    if (paramFileUploadRspData.a != 0)
    {
      super.notifyError(new ErrorMessage(paramFileUploadRspData.a, "upload failed!"));
      return;
    }
    super.notifyResult(paramFileUploadRspData);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\videoupload\job\CacheImageJobSegment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */