package tencent.im.oidb.cmd0x920;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0x920$RspBody
  extends MessageMicro
{
  public static final int MSG_CANCLE_MEETING_FIELD_NUMBER = 3;
  public static final int MSG_CREATE_MEETING_FIELD_NUMBER = 2;
  public static final int RPT_MSG_MEETING_INFO_FIELD_NUMBER = 4;
  public static final int UINT32_SUBCMD_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint32_subcmd", "msg_create_meeting", "msg_cancle_meeting", "rpt_msg_meeting_info" }, new Object[] { Integer.valueOf(0), null, null, null }, RspBody.class);
  public oidb_cmd0x920.CancleMeeting msg_cancle_meeting = new oidb_cmd0x920.CancleMeeting();
  public oidb_cmd0x920.CreateMeeting msg_create_meeting = new oidb_cmd0x920.CreateMeeting();
  public final PBRepeatMessageField rpt_msg_meeting_info = PBField.initRepeatMessage(oidb_cmd0x920.MeetingInfo.class);
  public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x920\oidb_cmd0x920$RspBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */