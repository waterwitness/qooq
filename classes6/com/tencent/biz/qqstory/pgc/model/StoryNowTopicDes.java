package com.tencent.biz.qqstory.pgc.model;

import com.tencent.biz.qqstory.network.pb.qqstory_pgc.StoryNowTopicDes;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.StoryRoomDes;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StoryNowTopicDes
  implements Serializable
{
  public List roomContentList;
  public String topic;
  public String topicDesc;
  public long topicId;
  
  public StoryNowTopicDes()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static StoryNowTopicDes convertFrom(qqstory_pgc.StoryNowTopicDes paramStoryNowTopicDes)
  {
    Object localObject2 = null;
    if ((paramStoryNowTopicDes == null) || (!paramStoryNowTopicDes.has())) {
      return null;
    }
    StoryNowTopicDes localStoryNowTopicDes = new StoryNowTopicDes();
    long l;
    if (paramStoryNowTopicDes.topic_id.has())
    {
      l = paramStoryNowTopicDes.topic_id.get();
      localStoryNowTopicDes.topicId = l;
      if (!paramStoryNowTopicDes.topic.has()) {
        break label190;
      }
    }
    label190:
    for (Object localObject1 = paramStoryNowTopicDes.topic.get().toStringUtf8();; localObject1 = null)
    {
      localStoryNowTopicDes.topic = ((String)localObject1);
      localObject1 = localObject2;
      if (paramStoryNowTopicDes.topic_desc.has()) {
        localObject1 = paramStoryNowTopicDes.topic_desc.get().toStringUtf8();
      }
      localStoryNowTopicDes.topicDesc = ((String)localObject1);
      if (!paramStoryNowTopicDes.room_content_list.has()) {
        return localStoryNowTopicDes;
      }
      paramStoryNowTopicDes = paramStoryNowTopicDes.room_content_list.get();
      localStoryNowTopicDes.roomContentList = new ArrayList();
      int i = 0;
      while (i < paramStoryNowTopicDes.size())
      {
        localObject1 = StoryRoomDes.convertFrom((qqstory_pgc.StoryRoomDes)paramStoryNowTopicDes.get(i));
        if (localObject1 != null) {
          localStoryNowTopicDes.roomContentList.add(localObject1);
        }
        i += 1;
      }
      l = 0L;
      break;
    }
    return localStoryNowTopicDes;
  }
  
  public boolean checkData()
  {
    if (this.topicId <= 0L) {}
    for (boolean bool = false;; bool = true)
    {
      if ((!bool) && (this.roomContentList != null) && (this.roomContentList.size() > 0)) {
        return true;
      }
      return bool;
    }
  }
  
  public String toString()
  {
    return "StoryNowTopicDes{topicId=" + this.topicId + ", topic='" + this.topic + '\'' + ", topicDesc='" + this.topicDesc + '\'' + ", roomContentList=" + this.roomContentList + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\pgc\model\StoryNowTopicDes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */