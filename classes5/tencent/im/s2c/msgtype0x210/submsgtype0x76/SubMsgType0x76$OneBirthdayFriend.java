package tencent.im.s2c.msgtype0x210.submsgtype0x76;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x76$OneBirthdayFriend
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48 }, new String[] { "uint64_uin", "bool_lunar_birth", "uint32_birth_month", "uint32_birth_date", "uint64_msg_send_time", "uint32_birth_year" }, new Object[] { Long.valueOf(0L), Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, OneBirthdayFriend.class);
  public final PBBoolField bool_lunar_birth = PBField.initBool(false);
  public final PBUInt32Field uint32_birth_date = PBField.initUInt32(0);
  public final PBUInt32Field uint32_birth_month = PBField.initUInt32(0);
  public final PBUInt32Field uint32_birth_year = PBField.initUInt32(0);
  public final PBUInt64Field uint64_msg_send_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\s2c\msgtype0x210\submsgtype0x76\SubMsgType0x76$OneBirthdayFriend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */