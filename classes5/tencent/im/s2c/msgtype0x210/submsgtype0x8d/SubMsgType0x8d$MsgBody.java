package tencent.im.s2c.msgtype0x210.submsgtype0x8d;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class SubMsgType0x8d$MsgBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "rpt_msg_notify_infos", "red_spot_notify_body" }, new Object[] { null, null }, MsgBody.class);
  public SubMsgType0x8d.RedSpotNotifyBody red_spot_notify_body = new SubMsgType0x8d.RedSpotNotifyBody();
  public final PBRepeatMessageField rpt_msg_notify_infos = PBField.initRepeatMessage(SubMsgType0x8d.NotifyBody.class);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\s2c\msgtype0x210\submsgtype0x8d\SubMsgType0x8d$MsgBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */