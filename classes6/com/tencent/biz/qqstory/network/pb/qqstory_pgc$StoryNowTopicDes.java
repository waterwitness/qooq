package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_pgc$StoryNowTopicDes
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField room_content_list = PBField.initRepeatMessage(qqstory_pgc.StoryRoomDes.class);
  public final PBBytesField topic = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField topic_desc = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field topic_id = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "topic_id", "topic", "topic_desc", "room_content_list" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, null }, StoryNowTopicDes.class);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\pb\qqstory_pgc$StoryNowTopicDes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */