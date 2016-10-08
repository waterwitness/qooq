package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_service$RspGetStoryUinList
  extends MessageMicro
{
  public static final int IS_END_FIELD_NUMBER = 3;
  public static final int NEXT_COOKIE_FIELD_NUMBER = 4;
  public static final int RESULT_FIELD_NUMBER = 1;
  public static final int UIN_LIST_FIELD_NUMBER = 2;
  public static final int UNION_ID_LIST_FIELD_NUMBER = 5;
  public static final int USER_INFO_LIST_FIELD_NUMBER = 6;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field is_end = PBField.initUInt32(0);
  public final PBBytesField next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  public final PBRepeatField uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBRepeatField union_id_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBRepeatMessageField user_info_list = PBField.initRepeatMessage(qqstory_struct.UserInfo.class);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 50 }, new String[] { "result", "uin_list", "is_end", "next_cookie", "union_id_list", "user_info_list" }, new Object[] { null, Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, null }, RspGetStoryUinList.class);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\network\pb\qqstory_service$RspGetStoryUinList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */