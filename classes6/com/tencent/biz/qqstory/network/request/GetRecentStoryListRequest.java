package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetUnWatchStoryList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetUnWatchStoryList;
import com.tencent.biz.qqstory.network.response.GetRecentStoryListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class GetRecentStoryListRequest
  extends NetworkRequest
{
  public static final String a = "Q.qqstory:GetRecentStoryListRequest";
  public static final String b = "StorySvc.video_show_newest_story_list";
  public int a;
  public String c;
  
  public GetRecentStoryListRequest()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.c = "";
  }
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetUnWatchStoryList localRspGetUnWatchStoryList = new qqstory_service.RspGetUnWatchStoryList();
    try
    {
      localRspGetUnWatchStoryList.mergeFrom(paramArrayOfByte);
      return new GetRecentStoryListResponse(localRspGetUnWatchStoryList);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      SLog.d("Q.qqstory:GetRecentStoryListRequest", "" + paramArrayOfByte);
    }
    return null;
  }
  
  public String a()
  {
    return "StorySvc.video_show_newest_story_list";
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqGetUnWatchStoryList localReqGetUnWatchStoryList = new qqstory_service.ReqGetUnWatchStoryList();
    localReqGetUnWatchStoryList.count.set(this.a);
    localReqGetUnWatchStoryList.start_cookie.set(ByteStringMicro.copyFromUtf8(this.c));
    return localReqGetUnWatchStoryList.toByteArray();
  }
  
  public String toString()
  {
    return "GetRecentStoryListRequest{count=" + this.a + ", startCookie='" + this.c + '\'' + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\request\GetRecentStoryListRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */