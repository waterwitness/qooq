package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetConfigFile;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetConfigFile;
import com.tencent.biz.qqstory.network.response.GetConfigFileResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class GetConfigFileRequest
  extends NetworkRequest
{
  public static final int a = 1;
  private static final String a = "GetConfigFileRequest";
  private int b;
  
  public GetConfigFileRequest(int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("");
    }
    this.b = paramInt;
  }
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetConfigFile localRspGetConfigFile = new qqstory_service.RspGetConfigFile();
    try
    {
      localRspGetConfigFile.mergeFrom(paramArrayOfByte);
      return new GetConfigFileResponse(localRspGetConfigFile);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      SLog.e("GetConfigFileRequest", "GetEmojiPackInfoListRequest error : " + paramArrayOfByte);
    }
    return null;
  }
  
  public String a()
  {
    return "StorySvc.video_pendant_config_get";
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqGetConfigFile localReqGetConfigFile = new qqstory_service.ReqGetConfigFile();
    localReqGetConfigFile.config_file_type.set(this.b);
    localReqGetConfigFile.mobile_type.set(1);
    return localReqGetConfigFile.toByteArray();
  }
  
  public String toString()
  {
    return "GetConfigFileRequest{mType=" + this.b + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\request\GetConfigFileRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */