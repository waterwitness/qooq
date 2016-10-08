package tencent.mobileim.structmsg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class structmsg$SystemMsg
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field action_uin = PBField.initUInt64(0L);
  public final PBStringField action_uin_nick = PBField.initString("");
  public final PBBytesField action_uin_qq_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField action_uin_remark = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField actions = PBField.initRepeatMessage(structmsg.SystemMsgAction.class);
  public final PBUInt64Field actor_uin = PBField.initUInt64(0L);
  public final PBStringField actor_uin_nick = PBField.initString("");
  public final PBUInt32Field card_switch = PBField.initUInt32(0);
  public final PBUInt64Field clone_uin = PBField.initUInt64(0L);
  public final PBStringField clone_uin_nick = PBField.initString("");
  public final PBBytesField eim_group_id_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public structmsg.FriendInfo friend_info = new structmsg.FriendInfo();
  public final PBUInt64Field group_code = PBField.initUInt64(0L);
  public final PBUInt32Field group_ext_flag = PBField.initUInt32(0);
  public structmsg.GroupInfo group_info = new structmsg.GroupInfo();
  public final PBUInt32Field group_inviter_role = PBField.initUInt32(0);
  public final PBUInt32Field group_msg_type = PBField.initUInt32(0);
  public final PBStringField group_name = PBField.initString("");
  public final PBStringField msg_actor_describe = PBField.initString("");
  public final PBStringField msg_additional = PBField.initString("");
  public final PBStringField msg_additional_list = PBField.initString("");
  public final PBStringField msg_decided = PBField.initString("");
  public final PBStringField msg_describe = PBField.initString("");
  public final PBStringField msg_detail = PBField.initString("");
  public structmsg.MsgInviteExt msg_invite_extinfo = new structmsg.MsgInviteExt();
  public final PBStringField msg_qna = PBField.initString("");
  public final PBStringField msg_source = PBField.initString("");
  public final PBStringField msg_title = PBField.initString("");
  public final PBBytesField pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field relation = PBField.initUInt32(0);
  public final PBBytesField req_uin_business_card = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field req_uin_faceid = PBField.initInt32(0);
  public final PBStringField req_uin_nick = PBField.initString("");
  public final PBBytesField req_uin_pre_remark = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field reqsubtype = PBField.initUInt32(0);
  public final PBUInt32Field src_id = PBField.initUInt32(0);
  public final PBUInt32Field sub_src_id = PBField.initUInt32(0);
  public final PBUInt32Field sub_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_discuss_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_eim_group_id = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 56, 64, 74, 80, 88, 96, 104, 114, 122, 128, 138, 146, 152, 160, 168, 176, 184, 194, 400, 410, 418, 426, 434, 442, 456, 466, 474, 482, 490, 506, 514, 522, 530, 808 }, new String[] { "sub_type", "msg_title", "msg_describe", "msg_additional", "msg_source", "msg_decided", "src_id", "sub_src_id", "actions", "group_code", "action_uin", "group_msg_type", "group_inviter_role", "friend_info", "group_info", "actor_uin", "msg_actor_describe", "msg_additional_list", "relation", "reqsubtype", "clone_uin", "uint64_discuss_uin", "uint64_eim_group_id", "msg_invite_extinfo", "req_uin_faceid", "req_uin_nick", "group_name", "action_uin_nick", "msg_qna", "msg_detail", "group_ext_flag", "actor_uin_nick", "pic_url", "clone_uin_nick", "req_uin_business_card", "eim_group_id_name", "req_uin_pre_remark", "action_uin_qq_nick", "action_uin_remark", "card_switch" }, new Object[] { Integer.valueOf(0), "", "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), null, Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null, null, Long.valueOf(0L), "", "", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), null, Integer.valueOf(0), "", "", "", "", "", Integer.valueOf(0), "", localByteStringMicro1, "", localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, Integer.valueOf(0) }, SystemMsg.class);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\mobileim\structmsg\structmsg$SystemMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */