package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspPublishVideo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class PublishStoryVideoRespond
  extends BaseResponse
{
  public long a;
  
  public PublishStoryVideoRespond(qqstory_service.RspPublishVideo paramRspPublishVideo)
  {
    super(paramRspPublishVideo.result);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramRspPublishVideo.create_time.get();
  }
  
  public String toString()
  {
    return "PublishStoryVideoRespond{createTime=" + this.a + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\response\PublishStoryVideoRespond.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */