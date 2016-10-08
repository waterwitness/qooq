package tencent.mobileim.structmsg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class structmsg$RspSystemMsgNew
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 56, 74, 82, 90, 98, 106, 114, 160 }, new String[] { "head", "unread_friend_count", "unread_group_count", "latest_friend_seq", "latest_group_seq", "following_friend_seq", "following_group_seq", "friendmsgs", "groupmsgs", "msg_ribbon_friend", "msg_ribbon_group", "msg_display", "grp_msg_display", "checktype" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), null, null, null, null, "", "", Integer.valueOf(1) }, RspSystemMsgNew.class);
  public final PBEnumField checktype = PBField.initEnum(1);
  public final PBUInt64Field following_friend_seq = PBField.initUInt64(0L);
  public final PBUInt64Field following_group_seq = PBField.initUInt64(0L);
  public final PBRepeatMessageField friendmsgs = PBField.initRepeatMessage(structmsg.StructMsg.class);
  public final PBRepeatMessageField groupmsgs = PBField.initRepeatMessage(structmsg.StructMsg.class);
  public final PBStringField grp_msg_display = PBField.initString("");
  public structmsg.RspHead head = new structmsg.RspHead();
  public final PBUInt64Field latest_friend_seq = PBField.initUInt64(0L);
  public final PBUInt64Field latest_group_seq = PBField.initUInt64(0L);
  public final PBStringField msg_display = PBField.initString("");
  public structmsg.StructMsg msg_ribbon_friend = new structmsg.StructMsg();
  public structmsg.StructMsg msg_ribbon_group = new structmsg.StructMsg();
  public final PBUInt32Field unread_friend_count = PBField.initUInt32(0);
  public final PBUInt32Field unread_group_count = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\mobileim\structmsg\structmsg$RspSystemMsgNew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */