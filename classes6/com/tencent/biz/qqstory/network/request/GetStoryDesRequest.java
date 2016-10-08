package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetStoryDes;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetStoryDes;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryReqInfo;
import com.tencent.biz.qqstory.network.response.GetStoryDesResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetStoryDesRequest
  extends NetworkRequest
{
  private static final String a = "GetStoryDesRequest";
  private static final String b = "StorySvc.video_show_story_cover_list";
  public List a;
  
  public GetStoryDesRequest()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new ArrayList();
  }
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetStoryDes localRspGetStoryDes = new qqstory_service.RspGetStoryDes();
    try
    {
      localRspGetStoryDes.mergeFrom(paramArrayOfByte);
      return new GetStoryDesResponse(localRspGetStoryDes);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      SLog.d("GetStoryDesRequest", "" + paramArrayOfByte);
    }
    return null;
  }
  
  public String a()
  {
    return "StorySvc.video_show_story_cover_list";
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqGetStoryDes localReqGetStoryDes = new qqstory_service.ReqGetStoryDes();
    if (this.a != null)
    {
      ArrayList localArrayList = new ArrayList(this.a.size());
      UserManager localUserManager = (UserManager)SuperManager.a(2);
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Long)localIterator.next();
        qqstory_struct.StoryReqInfo localStoryReqInfo = new qqstory_struct.StoryReqInfo();
        localStoryReqInfo.uin.set(((Long)localObject).longValue());
        localObject = localUserManager.a(((Long)localObject).longValue());
        localStoryReqInfo.union_id.set(ByteStringMicro.copyFromUtf8((String)localObject));
        localArrayList.add(localStoryReqInfo);
      }
      localReqGetStoryDes.req_info_list.set(localArrayList);
    }
    return localReqGetStoryDes.toByteArray();
  }
  
  public String toString()
  {
    return "GetStoryDesRequest{uinList=" + this.a + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\request\GetStoryDesRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */