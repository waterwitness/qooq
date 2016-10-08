package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqDeleteVideo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspDeleteVideo;
import com.tencent.biz.qqstory.network.response.DeleteVideoRespond;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import java.util.ArrayList;
import java.util.List;

public class DeleteVideoRequest
  extends NetworkRequest
{
  public static final String a = "Q.qqstory:DeleteVideoRequest";
  private static final String c = "StorySvc.video_show_delete";
  public String b;
  
  public DeleteVideoRequest(String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = paramString;
  }
  
  public DeleteVideoRespond a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspDeleteVideo localRspDeleteVideo = new qqstory_service.RspDeleteVideo();
    try
    {
      localRspDeleteVideo.mergeFrom(paramArrayOfByte);
      return new DeleteVideoRespond(localRspDeleteVideo);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public String a()
  {
    return "StorySvc.video_show_delete";
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqDeleteVideo localReqDeleteVideo = new qqstory_service.ReqDeleteVideo();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ByteStringMicro.copyFromUtf8(this.b));
    localReqDeleteVideo.vid_list.addAll(localArrayList);
    return localReqDeleteVideo.toByteArray();
  }
  
  public String toString()
  {
    return "DeleteVideoRequest{vid='" + this.b + '\'' + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\request\DeleteVideoRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */