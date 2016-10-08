package com.tencent.biz.qqstory.model.item;

import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.Copyable;
import com.tencent.biz.qqstory.database.LiveVideoEntry;
import com.tencent.biz.qqstory.database.StoryEntry;
import com.tencent.biz.qqstory.model.BaseUIItem;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryDes;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.StoryListUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class StoryItem
  extends BaseUIItem
  implements Copyable
{
  public static final int TYPE_NORMAL = 0;
  public static final int TYPE_RECENT = 1;
  public String cover;
  public String key;
  public LiveVideoEntry liveVideo;
  public int preLoadStatus;
  public long totalTime;
  public int type;
  public int unReadCount;
  public String unReadVid1;
  public String unReadVid2;
  public String unReadVid3;
  public long updateTime;
  public QQUserUIItem user;
  public int videoCount;
  
  public StoryItem()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.preLoadStatus = 0;
  }
  
  public StoryItem(StoryEntry paramStoryEntry)
  {
    this.preLoadStatus = 0;
    this.key = paramStoryEntry.key;
    this.type = paramStoryEntry.type;
    long l = paramStoryEntry.uid;
    Object localObject = (UserManager)SuperManager.a(2);
    this.user = ((UserManager)localObject).c(l);
    localObject = StoryListUtils.a(QQStoryContext.a().a(), l, ((UserManager)localObject).a().contains(String.valueOf(l)));
    if ((this.user != null) && (localObject != null))
    {
      this.user.nickName = ((QQUserUIItem)localObject).nickName;
      this.user.remark = ((QQUserUIItem)localObject).remark;
      this.user.specialCare = ((QQUserUIItem)localObject).specialCare;
    }
    if (this.user == null)
    {
      this.user = new QQUserUIItem();
      this.user.uid = l;
      this.user.nickName = "user";
    }
    this.updateTime = paramStoryEntry.updateTime;
    this.cover = paramStoryEntry.coverUrl;
    this.unReadCount = paramStoryEntry.hasUnWatchVideo;
    this.videoCount = paramStoryEntry.videoCount;
  }
  
  public static String dump(List paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localStringBuilder.append(((StoryItem)paramList.next()).key).append(",");
    }
    return localStringBuilder.toString();
  }
  
  public static String makeFriendKey(long paramLong)
  {
    return "fri." + paramLong;
  }
  
  public static String makeRecentKey(long paramLong)
  {
    return "recent." + paramLong;
  }
  
  public void convertFrom(int paramInt, qqstory_struct.StoryDes paramStoryDes)
  {
    this.updateTime = (paramStoryDes.new_story_time.get() * 1000L);
    if (this.updateTime == 0L) {
      this.updateTime = System.currentTimeMillis();
    }
    this.cover = paramStoryDes.storyCover.get().toStringUtf8();
    this.unReadCount = paramStoryDes.has_unwatched_video.get();
    UserManager localUserManager = (UserManager)SuperManager.a(2);
    QQUserUIItem localQQUserUIItem = new QQUserUIItem();
    localQQUserUIItem.convertFrom(paramStoryDes.user);
    this.user = localUserManager.a(localQQUserUIItem);
    this.videoCount = paramStoryDes.video_count.get();
    this.liveVideo = LiveVideoEntry.convertFrom(this.user.uid, paramStoryDes.live_video);
    paramStoryDes = ((StoryManager)SuperManager.a(5)).a(this.user.uid, paramInt);
    if (paramStoryDes != null) {
      this.totalTime = paramStoryDes.totalTime;
    }
  }
  
  public void copy(Object paramObject)
  {
    if ((paramObject instanceof StoryItem))
    {
      this.key = ((StoryItem)paramObject).key;
      this.type = ((StoryItem)paramObject).type;
      this.user = ((StoryItem)paramObject).user;
      this.updateTime = ((StoryItem)paramObject).updateTime;
      this.cover = ((StoryItem)paramObject).cover;
      this.totalTime = ((StoryItem)paramObject).totalTime;
      this.unReadCount = ((StoryItem)paramObject).unReadCount;
      this.videoCount = ((StoryItem)paramObject).videoCount;
      this.liveVideo = ((StoryItem)paramObject).liveVideo;
      this.unReadVid1 = ((StoryItem)paramObject).unReadVid1;
      this.unReadVid2 = ((StoryItem)paramObject).unReadVid2;
      this.unReadVid3 = ((StoryItem)paramObject).unReadVid3;
      this.preLoadStatus = ((StoryItem)paramObject).preLoadStatus;
    }
  }
  
  public StoryEntry cover2StoryEntry()
  {
    StoryEntry localStoryEntry = new StoryEntry();
    localStoryEntry.key = this.key;
    localStoryEntry.type = this.type;
    localStoryEntry.coverUrl = this.cover;
    localStoryEntry.updateTime = this.updateTime;
    localStoryEntry.uid = this.user.uid;
    localStoryEntry.totalTime = this.totalTime;
    localStoryEntry.hasUnWatchVideo = this.unReadCount;
    localStoryEntry.videoCount = this.videoCount;
    localStoryEntry.extra1 = this.unReadVid1;
    localStoryEntry.extra2 = this.unReadVid2;
    localStoryEntry.extra3 = this.unReadVid3;
    return localStoryEntry;
  }
  
  public float getCountDown()
  {
    return StoryListUtils.a(this.updateTime);
  }
  
  public String getCoverUrl()
  {
    return this.cover;
  }
  
  public String getTime()
  {
    return StoryListUtils.a(this.updateTime);
  }
  
  public String getTitle()
  {
    if (this.user == null) {
      return "";
    }
    if (!TextUtils.isEmpty(this.user.remark)) {
      return this.user.remark;
    }
    if (!TextUtils.isEmpty(this.user.nickName)) {
      return this.user.nickName;
    }
    return String.valueOf(this.user.uid);
  }
  
  public void makeRead(String paramString)
  {
    if (paramString.equals(this.unReadVid1)) {
      this.unReadVid1 = null;
    }
    if (paramString.equals(this.unReadVid2)) {
      this.unReadVid2 = null;
    }
    if (paramString.equals(this.unReadVid3)) {
      this.unReadVid3 = null;
    }
  }
  
  public String toString()
  {
    return "StoryItem{cover='" + this.cover + '\'' + ", owner=" + this.user + ", updateTime=" + this.updateTime + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\model\item\StoryItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */