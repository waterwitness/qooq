package tencent.im.s2c.msgtype0x210.submsgtype0x7c;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0x7c$MsgBody
  extends MessageMicro
{
  public static final int INT32_CMD_FIELD_NUMBER = 2;
  public static final int RPT_STRING_CMD_EXT_FIELD_NUMBER = 3;
  public static final int RPT_STRING_SEQ_EXT_FIELD_NUMBER = 5;
  public static final int UINT64_SEQ_FIELD_NUMBER = 4;
  public static final int UINT64_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42 }, new String[] { "uint64_uin", "int32_cmd", "rpt_string_cmd_ext", "uint64_seq", "rpt_string_seq_ext" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "", Long.valueOf(0L), "" }, MsgBody.class);
  public final PBInt32Field int32_cmd = PBField.initInt32(0);
  public final PBRepeatField rpt_string_cmd_ext = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBRepeatField rpt_string_seq_ext = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBUInt64Field uint64_seq = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\s2c\msgtype0x210\submsgtype0x7c\submsgtype0x7c$MsgBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */