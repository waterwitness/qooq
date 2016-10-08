package tencent.im.s2c.msgtype0x210.submsgtype0x67;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0x67$GroupInfo
  extends MessageMicro
{
  public static final int STR_GROUP_MEMO_FIELD_NUMBER = 3;
  public static final int STR_GROUP_NAME_FIELD_NUMBER = 2;
  public static final int UINT32_GROUP_TYPE_FIELD_NUMBER = 5;
  public static final int UINT32_MEMBER_NUM_FIELD_NUMBER = 4;
  public static final int UINT64_GROUP_CODE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40 }, new String[] { "uint64_group_code", "str_group_name", "str_group_memo", "uint32_member_num", "uint32_group_type" }, new Object[] { Long.valueOf(0L), "", "", Integer.valueOf(0), Integer.valueOf(0) }, GroupInfo.class);
  public final PBStringField str_group_memo = PBField.initString("");
  public final PBStringField str_group_name = PBField.initString("");
  public final PBUInt32Field uint32_group_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_member_num = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\s2c\msgtype0x210\submsgtype0x67\submsgtype0x67$GroupInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */