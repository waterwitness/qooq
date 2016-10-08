package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetHotTopicPack;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetHotTopicPack;
import com.tencent.biz.qqstory.network.response.GetHotTopicListRespond;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;

public class GetHotTopicListRequest
  extends NetworkRequest
{
  public static final String a = "Q.qqstory.home.hot:GetHotTopicListRequest";
  public String b;
  
  public GetHotTopicListRequest()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = "";
  }
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetHotTopicPack localRspGetHotTopicPack = new qqstory_service.RspGetHotTopicPack();
    try
    {
      localRspGetHotTopicPack.mergeFrom(paramArrayOfByte);
      return new GetHotTopicListRespond(localRspGetHotTopicPack);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      SLog.b("Q.qqstory.home.hot:GetHotTopicListRequest", a(), paramArrayOfByte);
    }
    return null;
  }
  
  public String a()
  {
    return "StorySvc.video_hot_story_topic_list";
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqGetHotTopicPack localReqGetHotTopicPack = new qqstory_service.ReqGetHotTopicPack();
    localReqGetHotTopicPack.start_cookie.set(ByteStringMicro.copyFromUtf8(this.b));
    return localReqGetHotTopicPack.toByteArray();
  }
  
  public String toString()
  {
    return "GetHotTopicListRequest{startCookie='" + this.b + '\'' + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\request\GetHotTopicListRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */