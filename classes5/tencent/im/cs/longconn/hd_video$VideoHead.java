package tencent.im.cs.longconn;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class hd_video$VideoHead
  extends MessageMicro
{
  public static final int CMD_S2C_PSTN_CALLBACK_NOTIFY_ACCEPT_REQ = 22;
  public static final int CMD_S2C_PSTN_CALLBACK_NOTIFY_LOGOUT_REQ = 23;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 58, 66, 106 }, new String[] { "uint64_room_id", "uint64_uin", "uint32_seq", "enum_body_type", "uint32_error_no", "str_from_nation", "str_from_mobile", "str_to_mobile", "str_to_nation" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(22), Integer.valueOf(0), "", "", "", "" }, VideoHead.class);
  public final PBEnumField enum_body_type = PBField.initEnum(22);
  public final PBStringField str_from_mobile = PBField.initString("");
  public final PBStringField str_from_nation = PBField.initString("");
  public final PBStringField str_to_mobile = PBField.initString("");
  public final PBStringField str_to_nation = PBField.initString("");
  public final PBUInt32Field uint32_error_no = PBField.initUInt32(0);
  public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
  public final PBUInt64Field uint64_room_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\cs\longconn\hd_video$VideoHead.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */