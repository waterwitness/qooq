package tencent.im.oidb;

import appoint.define.appoint_define.AppointInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x7dc$RspBody
  extends MessageMicro
{
  public static final int RPT_MSG_APPOINT_INFO_FIELD_NUMBER = 3;
  public static final int STR_WORDING_FIELD_NUMBER = 2;
  public static final int UINT32_SEQ_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_seq", "str_wording", "rpt_msg_appoint_info" }, new Object[] { Integer.valueOf(0), "", null }, RspBody.class);
  public final PBRepeatMessageField rpt_msg_appoint_info = PBField.initRepeatMessage(appoint_define.AppointInfo.class);
  public final PBStringField str_wording = PBField.initString("");
  public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x7dc$RspBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */