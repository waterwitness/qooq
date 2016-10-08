package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetRelatedVideoList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetRelatedVideoList;
import com.tencent.biz.qqstory.network.response.GetRelatedVideoListRespond;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class GetRelatedVideoListRequest
  extends NetworkRequest
{
  public static final String a = "Q.qqstory:GetRelatedVideoListRequest";
  public static final String b = "StorySvc.video_tag_video_search";
  public static final String c = "StorySvc.video_hot_story_explore_list";
  public int a;
  public final String d;
  public String e;
  public String f;
  public String g;
  
  public GetRelatedVideoListRequest(String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.e = "";
    this.f = "";
    this.g = "";
    this.d = paramString;
  }
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetRelatedVideoList localRspGetRelatedVideoList = new qqstory_service.RspGetRelatedVideoList();
    try
    {
      localRspGetRelatedVideoList.mergeFrom(paramArrayOfByte);
      return new GetRelatedVideoListRespond(this.e, localRspGetRelatedVideoList);
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
    return this.d;
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqGetRelatedVideoList localReqGetRelatedVideoList = new qqstory_service.ReqGetRelatedVideoList();
    localReqGetRelatedVideoList.label.set(ByteStringMicro.copyFromUtf8(this.e));
    localReqGetRelatedVideoList.start_cookie.set(ByteStringMicro.copyFromUtf8(this.g));
    localReqGetRelatedVideoList.count.set(this.a);
    if (this.f != null) {
      localReqGetRelatedVideoList.current_view_vid.set(ByteStringMicro.copyFromUtf8(this.f));
    }
    return localReqGetRelatedVideoList.toByteArray();
  }
  
  public String toString()
  {
    return "GetRelatedVideoListRequest{CMD='" + this.d + '\'' + ", label='" + this.e + '\'' + ", currentViewVid='" + this.f + '\'' + ", startCookie='" + this.g + '\'' + ", count=" + this.a + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\request\GetRelatedVideoListRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */