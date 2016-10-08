package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspCheckText;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class CheckPublishTextResponse
  extends BaseResponse
{
  public CheckPublishTextResponse(qqstory_service.RspCheckText paramRspCheckText)
  {
    super(paramRspCheckText.result);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\response\CheckPublishTextResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */