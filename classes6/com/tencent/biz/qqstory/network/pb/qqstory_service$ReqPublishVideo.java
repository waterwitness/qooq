package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_service$ReqPublishVideo
  extends MessageMicro
{
  public static final int ADDRESS_FIELD_NUMBER = 6;
  public static final int CREATE_TIME_FIELD_NUMBER = 8;
  public static final int DOODLE_TEXT_FIELD_NUMBER = 14;
  public static final int DOODLE_URL_FIELD_NUMBER = 4;
  public static final int LABEL_FIELD_NUMBER = 7;
  public static final int TITLE_FIELD_NUMBER = 1;
  public static final int TOTAL_TIME_FIELD_NUMBER = 5;
  public static final int VIDEO_ATTR_FIELD_NUMBER = 15;
  public static final int VIDEO_COVER_FIELD_NUMBER = 3;
  public static final int VIDEO_URL_FIELD_NUMBER = 10;
  public static final int VID_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public qqstory_struct.Address address = new qqstory_struct.Address();
  public final PBUInt64Field create_time = PBField.initUInt64(0L);
  public final PBBytesField doodle_text = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField doodle_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField label = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field total_time = PBField.initUInt64(0L);
  public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField video_attr = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField video_cover = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField video_url = PBField.initBytes(ByteStringMicro.EMPTY);
  
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
    ByteStringMicro localByteStringMicro8 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 50, 58, 64, 82, 114, 122 }, new String[] { "title", "vid", "video_cover", "doodle_url", "total_time", "address", "label", "create_time", "video_url", "doodle_text", "video_attr" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Long.valueOf(0L), null, localByteStringMicro5, Long.valueOf(0L), localByteStringMicro6, localByteStringMicro7, localByteStringMicro8 }, ReqPublishVideo.class);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\pb\qqstory_service$ReqPublishVideo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */