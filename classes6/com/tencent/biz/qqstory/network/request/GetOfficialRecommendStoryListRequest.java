package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.ReqGetMediaStory;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.RspGetMediaStory;
import com.tencent.biz.qqstory.network.response.GetOfficialRecommendStoryListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class GetOfficialRecommendStoryListRequest
  extends NetworkRequest
{
  public static final String a = "Q.qqstory:GetOfficialRecommendStoryListRequest";
  public static final String b = "StorySvc.pgc_subscribe_media_list";
  public int a;
  
  public GetOfficialRecommendStoryListRequest()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    if (!QQStoryHandler.a(paramArrayOfByte))
    {
      SLog.d("Q.qqstory:GetOfficialRecommendStoryListRequest", "GetOfficialRecommendStoryListRequest data is no valid");
      return null;
    }
    qqstory_pgc.RspGetMediaStory localRspGetMediaStory = new qqstory_pgc.RspGetMediaStory();
    try
    {
      localRspGetMediaStory.mergeFrom(paramArrayOfByte);
      return new GetOfficialRecommendStoryListResponse(localRspGetMediaStory);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      SLog.d("Q.qqstory:GetOfficialRecommendStoryListRequest", "" + paramArrayOfByte);
    }
    return null;
  }
  
  public String a()
  {
    return "StorySvc.pgc_subscribe_media_list";
  }
  
  protected byte[] a()
  {
    qqstory_pgc.ReqGetMediaStory localReqGetMediaStory = new qqstory_pgc.ReqGetMediaStory();
    localReqGetMediaStory.seq.set(this.a, true);
    return localReqGetMediaStory.toByteArray();
  }
  
  public String toString()
  {
    return "GetOfficialRecommendStoryListRequest{seq=" + this.a + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\request\GetOfficialRecommendStoryListRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */