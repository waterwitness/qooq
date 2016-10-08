package tencent.im.s2c.msgtype0x210.submsgtype0x71;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Submsgtype0x71$MsgBody
  extends MessageMicro
{
  public static final int RPT_MSG_APP_INFO_FIELD_NUMBER = 1;
  public static final int UINT64_UIUIN_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "rpt_msg_app_info", "uint64_uiUin" }, new Object[] { null, Long.valueOf(0L) }, MsgBody.class);
  public final PBRepeatMessageField rpt_msg_app_info = PBField.initRepeatMessage(Submsgtype0x71.ReportAppInfo.class);
  public final PBUInt64Field uint64_uiUin = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\s2c\msgtype0x210\submsgtype0x71\Submsgtype0x71$MsgBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */