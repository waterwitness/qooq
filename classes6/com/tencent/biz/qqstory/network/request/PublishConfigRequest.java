package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetPublishConfig;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetPublishConfig;
import com.tencent.biz.qqstory.network.response.PublishConfigResponse;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;

public class PublishConfigRequest
  extends NetworkRequest
{
  public static final String a = "PublishConfigRequest";
  public static final String b = "StorySvc.video_publish_config_get";
  
  public PublishConfigRequest()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public PublishConfigResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetPublishConfig localRspGetPublishConfig = new qqstory_service.RspGetPublishConfig();
    try
    {
      localRspGetPublishConfig.mergeFrom(paramArrayOfByte);
      return new PublishConfigResponse(localRspGetPublishConfig);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public String a()
  {
    return "StorySvc.video_publish_config_get";
  }
  
  protected byte[] a()
  {
    return new qqstory_service.ReqGetPublishConfig().toByteArray();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\request\PublishConfigRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */