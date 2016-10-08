package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspDeleteVideo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class DeleteVideoRespond
  extends BaseResponse
{
  public DeleteVideoRespond(qqstory_service.RspDeleteVideo paramRspDeleteVideo)
  {
    super(paramRspDeleteVideo.result);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\response\DeleteVideoRespond.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */