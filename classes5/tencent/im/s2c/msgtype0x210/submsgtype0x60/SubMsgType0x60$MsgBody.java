package tencent.im.s2c.msgtype0x210.submsgtype0x60;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SubMsgType0x60$MsgBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "uint32_pushcmd", "int64_ts", "str_ssid", "str_content" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), "", "" }, MsgBody.class);
  public final PBInt64Field int64_ts = PBField.initInt64(0L);
  public final PBStringField str_content = PBField.initString("");
  public final PBStringField str_ssid = PBField.initString("");
  public final PBUInt32Field uint32_pushcmd = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\s2c\msgtype0x210\submsgtype0x60\SubMsgType0x60$MsgBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */