package tencent.im.oidb.cmd0x5cf;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Oidb_0x5cf$DelMsgInfo
  extends MessageMicro
{
  public static final int RPT_MSG_DECIDE_INFO_FIELD_NUMBER = 1;
  public static final int RPT_MSG_UNDECIDE_INFO_FIELD_NUMBER = 2;
  public static final int UINT32_PLATFORM_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "rpt_msg_decide_info", "rpt_msg_undecide_info", "uint32_platform" }, new Object[] { null, null, Integer.valueOf(0) }, DelMsgInfo.class);
  public final PBRepeatMessageField rpt_msg_decide_info = PBField.initRepeatMessage(Oidb_0x5cf.DelDecideInfo.class);
  public final PBRepeatMessageField rpt_msg_undecide_info = PBField.initRepeatMessage(Oidb_0x5cf.DelUnDecideInfo.class);
  public final PBUInt32Field uint32_platform = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x5cf\Oidb_0x5cf$DelMsgInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */