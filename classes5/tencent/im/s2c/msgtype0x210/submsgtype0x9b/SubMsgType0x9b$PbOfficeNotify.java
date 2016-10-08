package tencent.im.s2c.msgtype0x210.submsgtype0x9b;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x9b$PbOfficeNotify
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "opt_uint32_myoffice_flag", "rpt_uint64_appid" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, PbOfficeNotify.class);
  public final PBUInt32Field opt_uint32_myoffice_flag = PBField.initUInt32(0);
  public final PBRepeatField rpt_uint64_appid = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\s2c\msgtype0x210\submsgtype0x9b\SubMsgType0x9b$PbOfficeNotify.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */