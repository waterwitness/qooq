package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_service$ReqGetPreloadVideoList
  extends MessageMicro
{
  public static final int PULL_TYPE_FIELD_NUMBER = 1;
  public static final int UGC_TOPIC_ID_LIST_FIELD_NUMBER = 4;
  public static final int UNION_ID_LIST_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField pull_type = PBField.initEnum(1);
  public final PBRepeatField ugc_topic_id_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBRepeatField union_id_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 26, 32 }, new String[] { "pull_type", "union_id_list", "ugc_topic_id_list" }, new Object[] { Integer.valueOf(1), localByteStringMicro, Long.valueOf(0L) }, ReqGetPreloadVideoList.class);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\pb\qqstory_service$ReqGetPreloadVideoList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */