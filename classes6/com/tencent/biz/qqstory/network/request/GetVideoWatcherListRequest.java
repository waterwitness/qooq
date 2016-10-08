package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetWatcher;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetWatcher;
import com.tencent.biz.qqstory.network.response.GetVideoWatcherListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class GetVideoWatcherListRequest
  extends NetworkRequest
{
  public static final String a = "Q.qqstory:GetVideoWatcherListRequest";
  public static final String b = "StorySvc.video_visitor_list";
  public int a;
  public String c;
  public String d;
  
  public GetVideoWatcherListRequest()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.c = "";
  }
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetWatcher localRspGetWatcher = new qqstory_service.RspGetWatcher();
    try
    {
      localRspGetWatcher.mergeFrom(paramArrayOfByte);
      return new GetVideoWatcherListResponse(this.d, localRspGetWatcher);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      SLog.d("Q.qqstory:GetVideoWatcherListRequest", "" + paramArrayOfByte);
    }
    return null;
  }
  
  public String a()
  {
    return "StorySvc.video_visitor_list";
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqGetWatcher localReqGetWatcher = new qqstory_service.ReqGetWatcher();
    localReqGetWatcher.count.set(this.a);
    localReqGetWatcher.start_cookie.set(ByteStringMicro.copyFromUtf8(this.c));
    localReqGetWatcher.vid.set(ByteStringMicro.copyFromUtf8(this.d));
    return localReqGetWatcher.toByteArray();
  }
  
  public String toString()
  {
    return "GetVideoWatcherListRequest{count=" + this.a + ", startCookie='" + this.c + '\'' + ", vid='" + this.d + '\'' + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\request\GetVideoWatcherListRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */