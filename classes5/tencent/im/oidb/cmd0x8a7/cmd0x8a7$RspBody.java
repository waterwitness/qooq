package tencent.im.oidb.cmd0x8a7;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x8a7$RspBody
  extends MessageMicro
{
  public static final int BOOL_CAN_AT_ALL_FIELD_NUMBER = 1;
  public static final int BYTES_PROMPT_MSG_1_FIELD_NUMBER = 4;
  public static final int BYTES_PROMPT_MSG_2_FIELD_NUMBER = 5;
  public static final int UINT32_REMAIN_AT_ALL_COUNT_FOR_GROUP_FIELD_NUMBER = 3;
  public static final int UINT32_REMAIN_AT_ALL_COUNT_FOR_UIN_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_can_at_all = PBField.initBool(false);
  public final PBBytesField bytes_prompt_msg_1 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_prompt_msg_2 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_remain_at_all_count_for_group = PBField.initUInt32(0);
  public final PBUInt32Field uint32_remain_at_all_count_for_uin = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42 }, new String[] { "bool_can_at_all", "uint32_remain_at_all_count_for_uin", "uint32_remain_at_all_count_for_group", "bytes_prompt_msg_1", "bytes_prompt_msg_2" }, new Object[] { Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2 }, RspBody.class);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x8a7\cmd0x8a7$RspBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */