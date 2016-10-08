package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetUserVideoList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetUserVideoList;
import com.tencent.biz.qqstory.network.response.GetUserVideoListResponse;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class GetUserVideoListRequest
  extends NetworkRequest
{
  public static final int a = 1;
  public static final String a = "Q.qqstory:GetUserVideoListRequest";
  public static final int b = 2;
  public static final String b = "StorySvc.video_show_video_list";
  public static final int c = 3;
  public long a;
  public String c;
  public int d;
  public int e;
  
  public GetUserVideoListRequest()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.c = "";
  }
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetUserVideoList localRspGetUserVideoList = new qqstory_service.RspGetUserVideoList();
    try
    {
      localRspGetUserVideoList.mergeFrom(paramArrayOfByte);
      return new GetUserVideoListResponse(this.a, localRspGetUserVideoList);
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
    return "StorySvc.video_show_video_list";
  }
  
  protected byte[] a()
  {
    Object localObject = (UserManager)SuperManager.a(2);
    if (this.a == QQStoryContext.a().a()) {}
    for (localObject = "0_1000";; localObject = ((UserManager)localObject).a(this.a))
    {
      qqstory_service.ReqGetUserVideoList localReqGetUserVideoList = new qqstory_service.ReqGetUserVideoList();
      localReqGetUserVideoList.uid.set(this.a);
      localReqGetUserVideoList.union_id.set(ByteStringMicro.copyFromUtf8((String)localObject));
      localReqGetUserVideoList.start_cookie.set(ByteStringMicro.copyFromUtf8(this.c));
      localReqGetUserVideoList.count.set(this.d);
      localReqGetUserVideoList.pull_type.set(this.e);
      return localReqGetUserVideoList.toByteArray();
    }
  }
  
  public String toString()
  {
    return "GetUserVideoListRequest{, uid=" + this.a + "count=" + this.d + ", startCookie='" + this.c + '\'' + ", pullType=" + this.e + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\request\GetUserVideoListRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */