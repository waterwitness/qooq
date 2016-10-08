package com.tencent.biz.qqstory.pgc.model;

import com.tencent.biz.qqstory.network.pb.qqstory_pgc.StoryCoverInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.StoryInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.StoryNowTopicDes;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.StoryPostDes;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.StoryRoomDes;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.StoryVideoDes;
import com.tencent.biz.qqstory.network.pb.qqstory_pgc.UserInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Story
  implements Serializable
{
  public static final int CONTENT_TYPE_HLS = 5;
  public static final int CONTENT_TYPE_NOW = 3;
  public static final int CONTENT_TYPE_PAGE = 2;
  public static final int CONTENT_TYPE_TOPIC = 4;
  public static final int CONTENT_TYPE_VIDEO = 1;
  public static final long serialVersionUID = 1L;
  public String albumId;
  public String contentTips;
  public int contentType;
  public StoryCoverInfo coverInfo;
  public long createTime;
  public StoryNowTopicDes nowTopicContent;
  public StoryPostDes postDes;
  public StoryCoverInfo recommendCoverInfo;
  public List roomDesList;
  public String storyId;
  public String title;
  public UserInfo user;
  public int userType;
  public StoryVideoDes videoDes;
  
  public Story()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.albumId = "";
    this.userType = -1;
  }
  
  public static Story convertFrom(qqstory_pgc.StoryInfo paramStoryInfo)
  {
    Story localStory = new Story();
    localStory.storyId = paramStoryInfo.story_id.get().toStringUtf8();
    localStory.title = paramStoryInfo.title.get().toStringUtf8();
    localStory.user = UserInfo.convertFrom((qqstory_pgc.UserInfo)paramStoryInfo.user.get());
    localStory.createTime = paramStoryInfo.create_time.get();
    localStory.recommendCoverInfo = StoryCoverInfo.convertFrom((qqstory_pgc.StoryCoverInfo)paramStoryInfo.recommend_cover_info.get());
    localStory.coverInfo = StoryCoverInfo.convertFrom((qqstory_pgc.StoryCoverInfo)paramStoryInfo.cover_info.get());
    localStory.videoDes = StoryVideoDes.convertFrom((qqstory_pgc.StoryVideoDes)paramStoryInfo.video_content.get());
    if (paramStoryInfo.room_content_list.has())
    {
      List localList = paramStoryInfo.room_content_list.get();
      localStory.roomDesList = new ArrayList();
      int i = 0;
      while (i < localList.size())
      {
        StoryRoomDes localStoryRoomDes = StoryRoomDes.convertFrom((qqstory_pgc.StoryRoomDes)localList.get(i));
        if (localStoryRoomDes != null) {
          localStory.roomDesList.add(localStoryRoomDes);
        }
        i += 1;
      }
    }
    localStory.nowTopicContent = StoryNowTopicDes.convertFrom((qqstory_pgc.StoryNowTopicDes)paramStoryInfo.now_topic_content.get());
    localStory.postDes = StoryPostDes.convertFrom((qqstory_pgc.StoryPostDes)paramStoryInfo.post_content.get());
    localStory.contentType = paramStoryInfo.content_type.get();
    if (paramStoryInfo.content_tips.has()) {}
    for (paramStoryInfo = paramStoryInfo.content_tips.get().toStringUtf8();; paramStoryInfo = null)
    {
      localStory.contentTips = paramStoryInfo;
      return localStory;
    }
  }
  
  public boolean checkData()
  {
    if ((this.user != null) && (!this.user.checkData())) {}
    for (;;)
    {
      return false;
      if (((this.recommendCoverInfo == null) || (this.recommendCoverInfo.checkData())) && ((this.coverInfo == null) || (this.coverInfo.checkData())) && ((this.videoDes == null) || (this.videoDes.checkData())) && ((this.postDes == null) || (this.postDes.checkData())))
      {
        if (this.roomDesList != null)
        {
          i = 0;
          for (;;)
          {
            if (i >= this.roomDesList.size()) {
              break label135;
            }
            if (!((StoryRoomDes)this.roomDesList.get(i)).checkData()) {
              break;
            }
            i += 1;
          }
        }
        label135:
        for (int i = 0; ((i == 0) || (this.nowTopicContent == null) || (this.nowTopicContent.checkData())) && ((this.contentType != 2) || (this.postDes != null)) && ((this.contentType != 1) || (this.videoDes != null)) && ((this.contentType != 4) || (this.nowTopicContent != null) || (this.roomDesList != null)) && ((this.contentType != 5) || (this.postDes != null)); i = 1) {
          return true;
        }
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof Story))
    {
      paramObject = (Story)paramObject;
      if ((this.storyId != null) && (!this.storyId.equals(((Story)paramObject).storyId))) {}
      while ((this.storyId == null) && (((Story)paramObject).storyId != null)) {
        return false;
      }
    }
    return true;
  }
  
  public String getUnionId()
  {
    if (this.user != null) {
      return this.user.unionId;
    }
    return this.albumId;
  }
  
  public int getUserType()
  {
    if (this.user != null) {
      return this.user.type;
    }
    return this.userType;
  }
  
  public boolean isNowContent()
  {
    return ((this.roomDesList != null) && (this.roomDesList.size() > 0)) || (this.nowTopicContent != null);
  }
  
  public String toString()
  {
    return "Story{storyId='" + this.storyId + '\'' + ", title='" + this.title + '\'' + ", user=" + this.user + ", createTime=" + this.createTime + ", recommendCoverInfo=" + this.recommendCoverInfo + ", coverInfo=" + this.coverInfo + ", videoDes=" + this.videoDes + ", roomDesList=" + this.roomDesList + ", postDes=" + this.postDes + ", nowTopicContent=" + this.nowTopicContent + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\pgc\model\Story.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */