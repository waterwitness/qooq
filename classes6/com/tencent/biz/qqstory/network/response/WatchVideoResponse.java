package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspWatchVideo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class WatchVideoResponse
  extends BaseResponse
{
  public int b;
  
  public WatchVideoResponse(qqstory_service.RspWatchVideo paramRspWatchVideo)
  {
    super(paramRspWatchVideo.result);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = paramRspWatchVideo.unread_count.get();
  }
  
  public String toString()
  {
    return "WatchVideoResponse{unReadCount=" + this.b + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\response\WatchVideoResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */