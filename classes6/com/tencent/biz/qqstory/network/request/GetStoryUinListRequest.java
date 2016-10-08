package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetStoryUinList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetStoryUinList;
import com.tencent.biz.qqstory.network.response.GetStoryUinListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class GetStoryUinListRequest
  extends NetworkRequest
{
  private static final String b = "GetStoryUinListRequest";
  private static final String c = "StorySvc.video_show_story_uin_list";
  public final int a;
  public String a;
  public boolean a;
  public int b;
  
  public GetStoryUinListRequest(int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetStoryUinList localRspGetStoryUinList = new qqstory_service.RspGetStoryUinList();
    try
    {
      localRspGetStoryUinList.mergeFrom(paramArrayOfByte);
      return new GetStoryUinListResponse(localRspGetStoryUinList);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      SLog.d("GetStoryUinListRequest", "" + paramArrayOfByte);
    }
    return null;
  }
  
  public String a()
  {
    return "StorySvc.video_show_story_uin_list";
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqGetStoryUinList localReqGetStoryUinList = new qqstory_service.ReqGetStoryUinList();
    localReqGetStoryUinList.count.set(this.b);
    localReqGetStoryUinList.start_cookie.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_JavaLangString));
    PBUInt32Field localPBUInt32Field = localReqGetStoryUinList.ret_user_info;
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 0)
    {
      localPBUInt32Field.set(i);
      return localReqGetStoryUinList.toByteArray();
    }
  }
  
  public String toString()
  {
    return "GetStoryUinListRequest{count=" + this.b + ", startCookie='" + this.jdField_a_of_type_JavaLangString + '\'' + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\request\GetStoryUinListRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */