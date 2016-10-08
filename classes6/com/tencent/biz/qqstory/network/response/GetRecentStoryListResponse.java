package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetUnWatchStoryList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryVideoDes;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.UnWatchStoryDes;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetRecentStoryListResponse
  extends BaseResponse
{
  public List a;
  public boolean a;
  public String b;
  
  public GetRecentStoryListResponse(qqstory_service.RspGetUnWatchStoryList paramRspGetUnWatchStoryList)
  {
    super(paramRspGetUnWatchStoryList.result);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.b = paramRspGetUnWatchStoryList.next_cookie.get().toStringUtf8();
    Object localObject1;
    if (paramRspGetUnWatchStoryList.is_end.get() == 1)
    {
      bool = true;
      this.jdField_a_of_type_Boolean = bool;
      localObject1 = paramRspGetUnWatchStoryList.story_list.get();
      paramRspGetUnWatchStoryList = (UserManager)SuperManager.a(2);
      localObject1 = ((List)localObject1).iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        return;
      }
      Object localObject2 = (qqstory_struct.UnWatchStoryDes)((Iterator)localObject1).next();
      StoryItem localStoryItem = new StoryItem();
      localStoryItem.convertFrom(1, ((qqstory_struct.UnWatchStoryDes)localObject2).des);
      localStoryItem.type = 1;
      localStoryItem.key = StoryItem.makeRecentKey(localStoryItem.user.uid);
      paramRspGetUnWatchStoryList.a(localStoryItem.user);
      localObject2 = ((qqstory_struct.UnWatchStoryDes)localObject2).latest_video_list.get().iterator();
      int i = 0;
      label165:
      if (((Iterator)localObject2).hasNext())
      {
        qqstory_struct.StoryVideoDes localStoryVideoDes = (qqstory_struct.StoryVideoDes)((Iterator)localObject2).next();
        if (i == 0) {
          localStoryItem.unReadVid1 = localStoryVideoDes.vid.get().toStringUtf8();
        }
        for (;;)
        {
          i += 1;
          break label165;
          bool = false;
          break;
          if (i == 1) {
            localStoryItem.unReadVid2 = localStoryVideoDes.vid.get().toStringUtf8();
          } else if (i == 2) {
            localStoryItem.unReadVid3 = localStoryVideoDes.vid.get().toStringUtf8();
          }
        }
      }
      this.jdField_a_of_type_JavaUtilList.add(localStoryItem);
    }
  }
  
  public String toString()
  {
    return "GetRecentStoryListResponse{isEnd=" + this.jdField_a_of_type_Boolean + ", nextCookie='" + this.b + '\'' + ", unWatchStoryList=" + this.jdField_a_of_type_JavaUtilList.size() + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\response\GetRecentStoryListResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */