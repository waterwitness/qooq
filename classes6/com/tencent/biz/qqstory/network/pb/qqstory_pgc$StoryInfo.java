package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_pgc$StoryInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField content_tips = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field content_type = PBField.initUInt32(0);
  public qqstory_pgc.StoryCoverInfo cover_info = new qqstory_pgc.StoryCoverInfo();
  public final PBUInt64Field create_time = PBField.initUInt64(0L);
  public qqstory_pgc.StoryNowTopicDes now_topic_content = new qqstory_pgc.StoryNowTopicDes();
  public qqstory_pgc.StoryPostDes post_content = new qqstory_pgc.StoryPostDes();
  public qqstory_pgc.StoryCoverInfo recommend_cover_info = new qqstory_pgc.StoryCoverInfo();
  public final PBRepeatMessageField room_content_list = PBField.initRepeatMessage(qqstory_pgc.StoryRoomDes.class);
  public final PBBytesField story_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField title = PBField.initBytes(ByteStringMicro.EMPTY);
  public qqstory_pgc.UserInfo user = new qqstory_pgc.UserInfo();
  public qqstory_pgc.StoryVideoDes video_content = new qqstory_pgc.StoryVideoDes();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42, 50, 58, 74, 82, 90, 96, 106 }, new String[] { "story_id", "title", "user", "create_time", "recommend_cover_info", "cover_info", "video_content", "post_content", "room_content_list", "now_topic_content", "content_type", "content_tips" }, new Object[] { localByteStringMicro1, localByteStringMicro2, null, Long.valueOf(0L), null, null, null, null, null, null, Integer.valueOf(0), localByteStringMicro3 }, StoryInfo.class);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\pb\qqstory_pgc$StoryInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */