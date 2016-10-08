package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqWatchVideo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspWatchVideo;
import com.tencent.biz.qqstory.network.response.WatchVideoResponse;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class WatchVideoRequest
  extends NetworkRequest
{
  public static final String a = "Q.qqstory:WatchVideoRequest";
  public static final String b = "StorySvc.video_watch";
  public long a;
  public boolean a;
  public String c;
  
  public WatchVideoRequest()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public WatchVideoResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspWatchVideo localRspWatchVideo = new qqstory_service.RspWatchVideo();
    try
    {
      localRspWatchVideo.mergeFrom(paramArrayOfByte);
      return new WatchVideoResponse(localRspWatchVideo);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public String a()
  {
    return "StorySvc.video_watch";
  }
  
  protected byte[] a()
  {
    Object localObject = ((UserManager)SuperManager.a(2)).a(this.jdField_a_of_type_Long);
    qqstory_service.ReqWatchVideo localReqWatchVideo = new qqstory_service.ReqWatchVideo();
    localReqWatchVideo.vid.set(ByteStringMicro.copyFromUtf8(this.c));
    localReqWatchVideo.to_union_id.set(ByteStringMicro.copyFromUtf8((String)localObject));
    localObject = localReqWatchVideo.is_live_video;
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 0)
    {
      ((PBUInt32Field)localObject).set(i);
      return localReqWatchVideo.toByteArray();
    }
  }
  
  public String toString()
  {
    return "WatchVideoRequest{vid='" + this.c + '\'' + ", videoUid=" + this.jdField_a_of_type_Long + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\request\WatchVideoRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */