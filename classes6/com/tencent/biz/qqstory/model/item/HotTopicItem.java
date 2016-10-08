package com.tencent.biz.qqstory.model.item;

import com.tencent.biz.qqstory.base.Copyable;
import com.tencent.biz.qqstory.database.HotTopicEntry;
import com.tencent.biz.qqstory.model.BaseUIItem;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.HotTopicPack;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class HotTopicItem
  extends BaseUIItem
  implements Copyable
{
  public int topicColor;
  public String topicCover;
  public long topicId;
  public String topicLogo;
  public String topicName;
  
  public HotTopicItem()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public HotTopicItem(HotTopicEntry paramHotTopicEntry)
  {
    this.topicId = paramHotTopicEntry.topicId;
    this.topicName = paramHotTopicEntry.topicName;
    this.topicCover = paramHotTopicEntry.topicCover;
    this.topicLogo = paramHotTopicEntry.topicLogo;
    this.topicColor = paramHotTopicEntry.topicColor;
  }
  
  public HotTopicItem(qqstory_struct.HotTopicPack paramHotTopicPack)
  {
    this.topicId = paramHotTopicPack.topic_id.get();
    this.topicName = paramHotTopicPack.topic_name.get().toStringUtf8();
    this.topicCover = paramHotTopicPack.topic_cover.get().toStringUtf8();
    this.topicLogo = paramHotTopicPack.topic_logo.get().toStringUtf8();
    this.topicColor = paramHotTopicPack.topic_color.get();
  }
  
  public void copy(Object paramObject) {}
  
  public HotTopicEntry cover2StoryEntry()
  {
    HotTopicEntry localHotTopicEntry = new HotTopicEntry();
    localHotTopicEntry.topicId = this.topicId;
    localHotTopicEntry.topicName = this.topicName;
    localHotTopicEntry.topicCover = this.topicCover;
    localHotTopicEntry.topicLogo = this.topicLogo;
    localHotTopicEntry.topicColor = this.topicColor;
    return localHotTopicEntry;
  }
  
  public String toString()
  {
    return "HotTopicItem{topicId=" + this.topicId + ", topicName='" + this.topicName + '\'' + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\model\item\HotTopicItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */