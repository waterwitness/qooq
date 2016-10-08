package tencent.im.s2c.msgtype0x210.submsgtype0x90;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class SubMsgType0x90$PushBody
  extends MessageMicro
{
  public static final int MSG_DP_NOTIFY_BODY_FIELD_NUMBER = 1;
  public static final int MSG_OCCUPY_MICROPHONE_BODY_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_dp_notify_body", "msg_occupy_microphone_body" }, new Object[] { null, null }, PushBody.class);
  public SubMsgType0x90.DpNotifyMsgBdoy msg_dp_notify_body = new SubMsgType0x90.DpNotifyMsgBdoy();
  public SubMsgType0x90.OccupyMicrophoneNotifyMsgBody msg_occupy_microphone_body = new SubMsgType0x90.OccupyMicrophoneNotifyMsgBody();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\s2c\msgtype0x210\submsgtype0x90\SubMsgType0x90$PushBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */