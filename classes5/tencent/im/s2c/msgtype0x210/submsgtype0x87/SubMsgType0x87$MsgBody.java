package tencent.im.s2c.msgtype0x210.submsgtype0x87;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x87$MsgBody
  extends MessageMicro
{
  public static final int MSG_MSG_NOTIFY_UNREAD_FIELD_NUMBER = 3;
  public static final int RPT_MSG_MSG_NOTIFY_FIELD_NUMBER = 2;
  public static final int UINT64_FRIEND_MSG_TYPE_FLAG_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint64_friend_msg_type_flag", "rpt_msg_msg_notify", "msg_msg_notify_unread" }, new Object[] { Long.valueOf(0L), null, null }, MsgBody.class);
  public SubMsgType0x87.MsgNotifyUnread msg_msg_notify_unread = new SubMsgType0x87.MsgNotifyUnread();
  public final PBRepeatMessageField rpt_msg_msg_notify = PBField.initRepeatMessage(SubMsgType0x87.MsgNotify.class);
  public final PBUInt64Field uint64_friend_msg_type_flag = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\s2c\msgtype0x210\submsgtype0x87\SubMsgType0x87$MsgBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */