package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_struct$HotTopicPack
  extends MessageMicro
{
  public static final int TOPIC_COLOR_FIELD_NUMBER = 4;
  public static final int TOPIC_COVER_FIELD_NUMBER = 3;
  public static final int TOPIC_ID_FIELD_NUMBER = 1;
  public static final int TOPIC_LOGO_FIELD_NUMBER = 5;
  public static final int TOPIC_NAME_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field topic_color = PBField.initUInt32(0);
  public final PBBytesField topic_cover = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field topic_id = PBField.initUInt64(0L);
  public final PBBytesField topic_logo = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField topic_name = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42 }, new String[] { "topic_id", "topic_name", "topic_cover", "topic_color", "topic_logo" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3 }, HotTopicPack.class);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\pb\qqstory_struct$HotTopicPack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */