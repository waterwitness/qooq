package com.tencent.pb.secmsg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SecMsgComu$SecMsg_Rsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122, 130, 138, 146, 154, 162, 170, 178, 186 }, new String[] { "ret", "errmsg", "cmd", "packet_seq", "comm", "rspcmd_0x01", "rspcmd_0x02", "rspcmd_0x03", "rspcmd_0x04", "rspcmd_0x05", "rspcmd_0x06", "rspcmd_0x07", "rspcmd_0x08", "rspcmd_0x51", "rspcmd_0x52", "rspcmd_0x53", "rspcmd_0x54", "rspcmd_0x55", "rspcmd_0x56", "rspcmd_0x57", "rspcmd_0x58", "rspcmd_0x59", "rspcmd_0x60" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(0), Long.valueOf(0L), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null }, SecMsg_Rsp.class);
  public final PBUInt32Field cmd = PBField.initUInt32(0);
  public SecMsgComu.SecMsg_Rsp_Comm comm = new SecMsgComu.SecMsg_Rsp_Comm();
  public final PBStringField errmsg = PBField.initString("");
  public final PBUInt64Field packet_seq = PBField.initUInt64(0L);
  public final PBInt64Field ret = PBField.initInt64(0L);
  public SecMsgComu.SecMsg_CreateSS_Rsp rspcmd_0x01 = new SecMsgComu.SecMsg_CreateSS_Rsp();
  public SecMsgComu.SecMsg_SendMsg_Rsp rspcmd_0x02 = new SecMsgComu.SecMsg_SendMsg_Rsp();
  public SecMsgComu.SecMsg_SendACK_Rsp rspcmd_0x03 = new SecMsgComu.SecMsg_SendACK_Rsp();
  public SecMsgComu.SecMsg_GetInbox_Rsp rspcmd_0x04 = new SecMsgComu.SecMsg_GetInbox_Rsp();
  public SecMsgComu.SecMsg_GetSSInfo_Rsp rspcmd_0x05 = new SecMsgComu.SecMsg_GetSSInfo_Rsp();
  public SecMsgComu.SecMsg_GetBaseInfo_Rsp rspcmd_0x06 = new SecMsgComu.SecMsg_GetBaseInfo_Rsp();
  public SecMsgComu.SecMsg_EnableSS_Rsp rspcmd_0x07 = new SecMsgComu.SecMsg_EnableSS_Rsp();
  public SecMsgComu.SecMsg_EnableSecMsg_Rsp rspcmd_0x08 = new SecMsgComu.SecMsg_EnableSecMsg_Rsp();
  public SecMsgComu.SecGroupMsg_OPSS_Rsp rspcmd_0x51 = new SecMsgComu.SecGroupMsg_OPSS_Rsp();
  public SecMsgComu.SecGroupMsg_SendMsg_Rsp rspcmd_0x52 = new SecMsgComu.SecGroupMsg_SendMsg_Rsp();
  public SecMsgComu.SecGroupMsg_GetMsg_Rsp rspcmd_0x53 = new SecMsgComu.SecGroupMsg_GetMsg_Rsp();
  public SecMsgComu.SecGroupMsg_Invite_Rsp rspcmd_0x54 = new SecMsgComu.SecGroupMsg_Invite_Rsp();
  public SecMsgComu.SecGroupMsg_Get_Invitation_Rsp rspcmd_0x55 = new SecMsgComu.SecGroupMsg_Get_Invitation_Rsp();
  public SecMsgComu.SecGroupMsg_Get_MySS_Rsp rspcmd_0x56 = new SecMsgComu.SecGroupMsg_Get_MySS_Rsp();
  public SecMsgComu.SecGroupMsg_Get_SS_Rsp rspcmd_0x57 = new SecMsgComu.SecGroupMsg_Get_SS_Rsp();
  public SecMsgComu.SecGroupMsg_Send_Invitation_Ack_Rsp rspcmd_0x58 = new SecMsgComu.SecGroupMsg_Send_Invitation_Ack_Rsp();
  public SecMsgComu.SecGroupMsg_Set_Invitation_Flag_Rsp rspcmd_0x59 = new SecMsgComu.SecGroupMsg_Set_Invitation_Flag_Rsp();
  public SecMsgComu.SecGroupMsg_EnableSecGroupMsg_Rsp rspcmd_0x60 = new SecMsgComu.SecGroupMsg_EnableSecGroupMsg_Rsp();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\secmsg\SecMsgComu$SecMsg_Rsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */