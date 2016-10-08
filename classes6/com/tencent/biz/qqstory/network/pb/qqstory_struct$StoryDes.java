package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_struct$StoryDes
  extends MessageMicro
{
  public static final int HAS_UNWATCHED_VIDEO_FIELD_NUMBER = 4;
  public static final int LIVE_VIDEO_FIELD_NUMBER = 6;
  public static final int NEW_STORY_TIME_FIELD_NUMBER = 3;
  public static final int STORYCOVER_FIELD_NUMBER = 2;
  public static final int USER_FIELD_NUMBER = 1;
  public static final int VIDEO_COUNT_FIELD_NUMBER = 5;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field has_unwatched_video = PBField.initUInt32(0);
  public qqstory_struct.LiveVideoDes live_video = new qqstory_struct.LiveVideoDes();
  public final PBUInt64Field new_story_time = PBField.initUInt64(0L);
  public final PBBytesField storyCover = PBField.initBytes(ByteStringMicro.EMPTY);
  public qqstory_struct.UserInfo user = new qqstory_struct.UserInfo();
  public final PBUInt32Field video_count = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 50 }, new String[] { "user", "storyCover", "new_story_time", "has_unwatched_video", "video_count", "live_video" }, new Object[] { null, localByteStringMicro, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null }, StoryDes.class);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\pb\qqstory_struct$StoryDes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */