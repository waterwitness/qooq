package tencent.im.s2c.msgtype0x210.submsgtype0x4b;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class MsgBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 45, 48, 58, 66, 72, 80 }, new String[] { "string_albumid", "string_coverUrl", "string_albumName", "uint64_opuin", "uint32_time", "uint32_pic_cnt", "string_push_msg_helper", "string_push_msg_album", "uint32_usr_total", "rpt_uint64_user" }, new Object[] { "", "", "", Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), Long.valueOf(0L) }, MsgBody.class);
  public final PBRepeatField rpt_uint64_user = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBStringField string_albumName = PBField.initString("");
  public final PBStringField string_albumid = PBField.initString("");
  public final PBStringField string_coverUrl = PBField.initString("");
  public final PBStringField string_push_msg_album = PBField.initString("");
  public final PBStringField string_push_msg_helper = PBField.initString("");
  public final PBUInt32Field uint32_pic_cnt = PBField.initUInt32(0);
  public final PBFixed32Field uint32_time = PBField.initFixed32(0);
  public final PBUInt32Field uint32_usr_total = PBField.initUInt32(0);
  public final PBUInt64Field uint64_opuin = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\s2c\msgtype0x210\submsgtype0x4b\MsgBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */