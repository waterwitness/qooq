package com.tencent.mobileqq.troop.org.pb;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x496$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "rpt_msg_seq_info", "uint64_max_aio_msg", "uint64_max_position_msg", "msg_group_msg_config" }, new Object[] { null, Long.valueOf(0L), Long.valueOf(0L), null }, RspBody.class);
  public oidb_0x496.GroupMsgConfig msg_group_msg_config = new oidb_0x496.GroupMsgConfig();
  public final PBRepeatMessageField rpt_msg_seq_info = PBField.initRepeatMessage(oidb_0x496.MsgSeqInfo.class);
  public final PBUInt64Field uint64_max_aio_msg = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_max_position_msg = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\org\pb\oidb_0x496$RspBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */