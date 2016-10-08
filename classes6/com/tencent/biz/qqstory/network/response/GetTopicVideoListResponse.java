package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetHotTopicVideoList;
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

public class GetTopicVideoListResponse
  extends BaseResponse
{
  public static final String b = "Q.qqstory.player.GetRelatedVideoListRespond";
  public long a;
  public List a;
  public boolean a;
  public int b;
  public String c;
  
  public GetTopicVideoListResponse(qqstory_service.RspGetHotTopicVideoList paramRspGetHotTopicVideoList)
  {
    super(paramRspGetHotTopicVideoList.result);
    boolean bool2 = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (paramRspGetHotTopicVideoList.is_end.get() == 1) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool1;
      this.c = paramRspGetHotTopicVideoList.next_cookie.get().toStringUtf8();
      this.b = paramRspGetHotTopicVideoList.video_count.get();
      this.jdField_a_of_type_Long = paramRspGetHotTopicVideoList.totle_time.get();
      paramRspGetHotTopicVideoList = paramRspGetHotTopicVideoList.video_list.get().iterator();
      while (paramRspGetHotTopicVideoList.hasNext())
      {
        qqstory_struct.StoryVideoDes localStoryVideoDes = (qqstory_struct.StoryVideoDes)paramRspGetHotTopicVideoList.next();
        StoryVideoItem localStoryVideoItem = new StoryVideoItem();
        localStoryVideoItem.convertFrom("Q.qqstory.player.GetRelatedVideoListRespond", localStoryVideoDes);
        this.jdField_a_of_type_JavaUtilList.add(localStoryVideoItem);
      }
      bool1 = false;
    }
  }
  
  public String toString()
  {
    return "GetTopicVideoListResponse{isEnd=" + this.jdField_a_of_type_Boolean + ", nextCookie='" + this.c + '\'' + ", storyVideoTotalTime=" + this.jdField_a_of_type_Long + ", videoCount=" + this.b + ", videoItems=" + StoryVideoItem.dump(this.jdField_a_of_type_JavaUtilList) + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\response\GetTopicVideoListResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */