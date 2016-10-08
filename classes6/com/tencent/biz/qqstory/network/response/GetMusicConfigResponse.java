package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetMusicListConfig;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class GetMusicConfigResponse
  extends BaseResponse
{
  public qqstory_service.RspGetMusicListConfig a;
  
  public GetMusicConfigResponse(qqstory_service.RspGetMusicListConfig paramRspGetMusicListConfig)
  {
    super(paramRspGetMusicListConfig.result);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramRspGetMusicListConfig;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\response\GetMusicConfigResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */