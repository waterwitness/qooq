package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetMusicListConfig;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetMusicListConfig;
import com.tencent.biz.qqstory.network.response.GetMusicConfigResponse;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;

public class GetMusicConfigRequest
  extends NetworkRequest
{
  public static final String a = "Q.qqstory:GetMusicConfigRequest";
  private static final String b = "StorySvc.video_music_get";
  
  public GetMusicConfigRequest()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public GetMusicConfigResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetMusicListConfig localRspGetMusicListConfig = new qqstory_service.RspGetMusicListConfig();
    try
    {
      localRspGetMusicListConfig.mergeFrom(paramArrayOfByte);
      return new GetMusicConfigResponse(localRspGetMusicListConfig);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public String a()
  {
    return "StorySvc.video_music_get";
  }
  
  protected byte[] a()
  {
    return new qqstory_service.ReqGetMusicListConfig().toByteArray();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\request\GetMusicConfigRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */