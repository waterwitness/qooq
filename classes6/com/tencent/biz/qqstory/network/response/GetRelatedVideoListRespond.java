package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetRelatedVideoList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryVideoDes;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetRelatedVideoListRespond
  extends BaseResponse
{
  private static final String c = "Q.qqstory.player.GetRelatedVideoListRespond";
  public long a;
  public List a;
  public boolean a;
  public int b;
  public String b;
  
  public GetRelatedVideoListRespond(String paramString, qqstory_service.RspGetRelatedVideoList paramRspGetRelatedVideoList)
  {
    super(paramRspGetRelatedVideoList.result);
    boolean bool2 = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (paramRspGetRelatedVideoList.is_end.get() == 1) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool1;
      this.jdField_b_of_type_JavaLangString = paramRspGetRelatedVideoList.next_cookie.get().toStringUtf8();
      paramString = paramRspGetRelatedVideoList.video_list.get().iterator();
      while (paramString.hasNext())
      {
        paramRspGetRelatedVideoList = (qqstory_struct.StoryVideoDes)paramString.next();
        StoryVideoItem localStoryVideoItem = new StoryVideoItem();
        localStoryVideoItem.convertFrom("Q.qqstory.player.GetRelatedVideoListRespond", paramRspGetRelatedVideoList);
        this.jdField_a_of_type_JavaUtilList.add(localStoryVideoItem);
      }
      bool1 = false;
    }
  }
  
  public String toString()
  {
    return "GetRelatedVideoListRespond{isEnd=" + this.jdField_a_of_type_Boolean + ", nextCookie='" + this.jdField_b_of_type_JavaLangString + '\'' + ", storyVideoTotalTime=" + this.jdField_a_of_type_Long + ", videoCount=" + this.jdField_b_of_type_Int + ", videoItems=" + StoryVideoItem.dump(this.jdField_a_of_type_JavaUtilList) + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\response\GetRelatedVideoListRespond.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */