package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetHotTopicVideoList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetHotTopicVideoList;
import com.tencent.biz.qqstory.network.response.GetTopicVideoListResponse;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class GetTopicVideoListRequest
  extends NetworkRequest
{
  public static final int a = 1;
  public static final String a = "Q.qqstory.player:GetTopicVideoListRequest";
  public static final int b = 2;
  public static final String b = "StorySvc.video_hot_story_video_list";
  public static final int c = 3;
  public long a;
  public String c;
  public int d;
  
  public GetTopicVideoListRequest()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.c = "";
  }
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetHotTopicVideoList localRspGetHotTopicVideoList = new qqstory_service.RspGetHotTopicVideoList();
    try
    {
      localRspGetHotTopicVideoList.mergeFrom(paramArrayOfByte);
      return new GetTopicVideoListResponse(localRspGetHotTopicVideoList);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  public String a()
  {
    return "StorySvc.video_hot_story_video_list";
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqGetHotTopicVideoList localReqGetHotTopicVideoList = new qqstory_service.ReqGetHotTopicVideoList();
    localReqGetHotTopicVideoList.topic_id.set(this.a);
    localReqGetHotTopicVideoList.start_cookie.set(ByteStringMicro.copyFromUtf8(this.c));
    localReqGetHotTopicVideoList.count.set(this.d);
    return localReqGetHotTopicVideoList.toByteArray();
  }
  
  public String toString()
  {
    return "GetTopicVideoListRequest{count=" + this.d + ", topicId=" + this.a + ", startCookie='" + this.c + '\'' + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\request\GetTopicVideoListRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */