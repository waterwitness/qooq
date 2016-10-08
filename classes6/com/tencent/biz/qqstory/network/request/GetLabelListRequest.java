package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetLabelList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetLabelList;
import com.tencent.biz.qqstory.network.response.GetLabelListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class GetLabelListRequest
  extends NetworkRequest
{
  public static final String a = "Q.qqstory:GetLabelListRequest";
  public static final String b = "StorySvc.video_tag_search";
  public int a;
  public String c;
  public String d;
  
  public GetLabelListRequest()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.d = "";
  }
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetLabelList localRspGetLabelList = new qqstory_service.RspGetLabelList();
    try
    {
      localRspGetLabelList.mergeFrom(paramArrayOfByte);
      return new GetLabelListResponse(localRspGetLabelList);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      SLog.d("Q.qqstory:GetLabelListRequest", "" + paramArrayOfByte);
    }
    return null;
  }
  
  public String a()
  {
    return "StorySvc.video_tag_search";
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqGetLabelList localReqGetLabelList = new qqstory_service.ReqGetLabelList();
    localReqGetLabelList.keyword.set(ByteStringMicro.copyFromUtf8(this.c));
    localReqGetLabelList.count.set(this.a);
    localReqGetLabelList.start_cookie.set(ByteStringMicro.copyFromUtf8(this.d));
    return localReqGetLabelList.toByteArray();
  }
  
  public String toString()
  {
    return "GetLabelListRequest{count=" + this.a + ", keyword='" + this.c + '\'' + ", startCookie='" + this.d + '\'' + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\request\GetLabelListRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */