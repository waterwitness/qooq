package tencent.im.oidb.cmd0x920;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_cmd0x920$GetSpecifiedMeeting
  extends MessageMicro
{
  public static final int RPT_MSG_MEETING_INFO3_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_meeting_info3" }, new Object[] { null }, GetSpecifiedMeeting.class);
  public final PBRepeatMessageField rpt_msg_meeting_info3 = PBField.initRepeatMessage(oidb_cmd0x920.MeetingInfo.class);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x920\oidb_cmd0x920$GetSpecifiedMeeting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */