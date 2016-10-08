package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.model.ReportWatchVideoManager.InnerVideoItem;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqWatchVideoBatch;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspWatchVideoBatch;
import com.tencent.biz.qqstory.network.pb.qqstory_service.VideoItem;
import com.tencent.biz.qqstory.network.response.WatchVideoBatchResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;

public class WatchVideoBatchRequest
  extends NetworkRequest
{
  public static final String a = "Q.qqstory:WatchVideoBatchRequest";
  public static final String b = "StorySvc.video_watch_batch";
  public int a;
  public ArrayList a;
  
  public WatchVideoBatchRequest()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspWatchVideoBatch localRspWatchVideoBatch = new qqstory_service.RspWatchVideoBatch();
    try
    {
      localRspWatchVideoBatch.mergeFrom(paramArrayOfByte);
      return new WatchVideoBatchResponse(localRspWatchVideoBatch);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        SLog.d("Q.qqstory:WatchVideoBatchRequest", paramArrayOfByte.toString());
      }
    }
  }
  
  public String a()
  {
    return "StorySvc.video_watch_batch";
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqWatchVideoBatch localReqWatchVideoBatch = new qqstory_service.ReqWatchVideoBatch();
    UserManager localUserManager = (UserManager)SuperManager.a(2);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    if (localIterator.hasNext())
    {
      ReportWatchVideoManager.InnerVideoItem localInnerVideoItem = (ReportWatchVideoManager.InnerVideoItem)localIterator.next();
      qqstory_service.VideoItem localVideoItem = new qqstory_service.VideoItem();
      localVideoItem.vid.set(ByteStringMicro.copyFromUtf8(localInnerVideoItem.jdField_a_of_type_JavaLangString));
      Object localObject = localUserManager.a(localInnerVideoItem.jdField_a_of_type_Long);
      localVideoItem.to_union_id.set(ByteStringMicro.copyFromUtf8((String)localObject));
      localObject = localVideoItem.is_live_video;
      if (localInnerVideoItem.jdField_a_of_type_Boolean) {}
      for (int i = 1;; i = 0)
      {
        ((PBUInt32Field)localObject).set(i);
        localVideoItem.create_time.set(localInnerVideoItem.b / 1000L);
        localReqWatchVideoBatch.video_list.add(localVideoItem);
        break;
      }
    }
    return localReqWatchVideoBatch.toByteArray();
  }
  
  public String toString()
  {
    return "WatchVideoBatchRequest{seq=" + this.jdField_a_of_type_Int + "mVideoList=" + this.jdField_a_of_type_JavaUtilArrayList + "}";
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\request\WatchVideoBatchRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */