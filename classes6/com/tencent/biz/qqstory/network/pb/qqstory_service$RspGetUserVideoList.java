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

public final class qqstory_service$RspGetUserVideoList
  extends MessageMicro
{
  public static final int IS_END_FIELD_NUMBER = 3;
  public static final int LIVE_VIDEO_DES_FIELD_NUMBER = 7;
  public static final int NEXT_COOKIE_FIELD_NUMBER = 4;
  public static final int RESULT_FIELD_NUMBER = 1;
  public static final int STORY_VIDEO_LIST_TOTAL_TIME_FIELD_NUMBER = 5;
  public static final int VIDEO_LIST_FIELD_NUMBER = 2;
  public static final int VIDEO_LIST_TOTAL_COUNT_FIELD_NUMBER = 6;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field is_end = PBField.initUInt32(0);
  public qqstory_struct.LiveVideoDes live_video_des = new qqstory_struct.LiveVideoDes();
  public final PBBytesField next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  public final PBUInt64Field story_video_list_total_time = PBField.initUInt64(0L);
  public final PBRepeatMessageField video_list = PBField.initRepeatMessage(qqstory_struct.StoryVideoDes.class);
  public final PBUInt32Field video_list_total_count = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40, 48, 58 }, new String[] { "result", "video_list", "is_end", "next_cookie", "story_video_list_total_time", "video_list_total_count", "live_video_des" }, new Object[] { null, null, Integer.valueOf(0), localByteStringMicro, Long.valueOf(0L), Integer.valueOf(0), null }, RspGetUserVideoList.class);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\pb\qqstory_service$RspGetUserVideoList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */