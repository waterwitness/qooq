package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_service$ReqForbidStory
  extends MessageMicro
{
  public static final int FORBIDDEN_FIELD_NUMBER = 2;
  public static final int FORBID_MY_STORY_FIELD_NUMBER = 3;
  public static final int UID_LIST_FIELD_NUMBER = 1;
  public static final int UNION_ID_LIST_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field forbid_my_story = PBField.initUInt32(0);
  public final PBUInt32Field forbidden = PBField.initUInt32(0);
  public final PBRepeatField uid_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBRepeatField union_id_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uid_list", "forbidden", "forbid_my_story", "union_id_list" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, ReqForbidStory.class);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\pb\qqstory_service$ReqForbidStory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */