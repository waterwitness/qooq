package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_struct$StoryVideoDes
  extends MessageMicro
{
  public static final int ADDRESS_FIELD_NUMBER = 10;
  public static final int CREATE_TIME_FIELD_NUMBER = 6;
  public static final int DOODLE_URL_FIELD_NUMBER = 5;
  public static final int HAS_RELATED_VIDEOS_FIELD_NUMBER = 11;
  public static final int LABEL_FIELD_NUMBER = 8;
  public static final int OWNER_FIELD_NUMBER = 17;
  public static final int STRANGER_VIEW_TOTAL_NUM_FIELD_NUMBER = 18;
  public static final int TITLE_FIELD_NUMBER = 4;
  public static final int VIDEO_ATTR_FIELD_NUMBER = 16;
  public static final int VIDEO_COVER_FIELD_NUMBER = 3;
  public static final int VIDEO_TOTAL_TIME_FIELD_NUMBER = 9;
  public static final int VIDEO_URL_FIELD_NUMBER = 2;
  public static final int VID_FIELD_NUMBER = 1;
  public static final int VIEW_TOTAL_NUM_FIELD_NUMBER = 7;
  static final MessageMicro.FieldMap __fieldMap__;
  public qqstory_struct.Address address = new qqstory_struct.Address();
  public final PBUInt64Field create_time = PBField.initUInt64(0L);
  public final PBBytesField doodle_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field has_related_videos = PBField.initUInt32(0);
  public final PBBytesField label = PBField.initBytes(ByteStringMicro.EMPTY);
  public qqstory_struct.UserInfo owner = new qqstory_struct.UserInfo();
  public final PBUInt32Field stranger_view_total_num = PBField.initUInt32(0);
  public final PBBytesField title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField video_attr = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField video_cover = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field video_total_time = PBField.initUInt64(0L);
  public final PBBytesField video_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field view_total_num = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 56, 66, 72, 82, 88, 130, 138, 144 }, new String[] { "vid", "video_url", "video_cover", "title", "doodle_url", "create_time", "view_total_num", "label", "video_total_time", "address", "has_related_videos", "video_attr", "owner", "stranger_view_total_num" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro6, Long.valueOf(0L), null, Integer.valueOf(0), localByteStringMicro7, null, Integer.valueOf(0) }, StoryVideoDes.class);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\pb\qqstory_struct$StoryVideoDes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */