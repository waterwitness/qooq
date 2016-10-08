package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.database.LiveVideoEntry;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetUserVideoList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.LiveVideoDes;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryVideoDes;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetUserVideoListResponse
  extends BaseResponse
{
  public static final String b = "Q.qqstory.player.GetRelatedVideoListRespond";
  public long a;
  public LiveVideoEntry a;
  public List a;
  public boolean a;
  public int b;
  public String c;
  
  public GetUserVideoListResponse(long paramLong, qqstory_service.RspGetUserVideoList paramRspGetUserVideoList)
  {
    super(paramRspGetUserVideoList.result);
    boolean bool2 = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (paramRspGetUserVideoList.is_end.get() == 1) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool1;
      this.c = paramRspGetUserVideoList.next_cookie.get().toStringUtf8();
      this.jdField_a_of_type_Long = paramRspGetUserVideoList.story_video_list_total_time.get();
      this.b = paramRspGetUserVideoList.video_list_total_count.get();
      Iterator localIterator = paramRspGetUserVideoList.video_list.get().iterator();
      while (localIterator.hasNext())
      {
        qqstory_struct.StoryVideoDes localStoryVideoDes = (qqstory_struct.StoryVideoDes)localIterator.next();
        StoryVideoItem localStoryVideoItem = new StoryVideoItem();
        localStoryVideoItem.convertFrom("Q.qqstory.player.GetRelatedVideoListRespond", localStoryVideoDes);
        this.jdField_a_of_type_JavaUtilList.add(localStoryVideoItem);
      }
      bool1 = false;
    }
    if ((this.jdField_a_of_type_Boolean) && (paramRspGetUserVideoList.live_video_des.has())) {
      this.jdField_a_of_type_ComTencentBizQqstoryDatabaseLiveVideoEntry = LiveVideoEntry.convertFrom(paramLong, paramRspGetUserVideoList.live_video_des);
    }
  }
  
  public String toString()
  {
    return "GetUserVideoListResponse{isEnd=" + this.jdField_a_of_type_Boolean + ", nextCookie='" + this.c + '\'' + ", storyVideoTotalTime=" + this.jdField_a_of_type_Long + ", videoCount=" + this.b + ", videoItems=" + StoryVideoItem.dump(this.jdField_a_of_type_JavaUtilList) + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\response\GetUserVideoListResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */