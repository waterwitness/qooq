package com.tencent.biz.qqstory.base.videoupload.job;

import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.network.response.GetVideoUploadAddrResponse;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class GetVideoUploadAddrCmdHandler$ApplyUploadResultEvent
  extends BaseEvent
{
  GetVideoUploadAddrResponse a;
  
  public GetVideoUploadAddrCmdHandler$ApplyUploadResultEvent()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\videoupload\job\GetVideoUploadAddrCmdHandler$ApplyUploadResultEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */