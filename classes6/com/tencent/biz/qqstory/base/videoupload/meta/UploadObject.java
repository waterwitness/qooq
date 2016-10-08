package com.tencent.biz.qqstory.base.videoupload.meta;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

public abstract class UploadObject
  extends JobSegment
{
  public UploadObject.UploadFinishListener a;
  
  public UploadObject()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected abstract void a();
  
  public void a(UploadObject.UploadFinishListener paramUploadFinishListener)
  {
    this.a = paramUploadFinishListener;
  }
  
  protected void a(JobContext paramJobContext, ErrorMessage paramErrorMessage)
  {
    a();
  }
  
  public void b()
  {
    if (this.a != null) {
      this.a.a(this);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\videoupload\meta\UploadObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */