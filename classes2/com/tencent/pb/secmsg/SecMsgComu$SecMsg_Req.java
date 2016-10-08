package com.tencent.pb.secmsg;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SecMsgComu$SecMsg_Req
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122, 130, 138, 146, 154, 162, 170 }, new String[] { "cmd", "packet_seq", "comm", "reqcmd_0x01", "reqcmd_0x02", "reqcmd_0x03", "reqcmd_0x04", "reqcmd_0x05", "reqcmd_0x06", "reqcmd_0x07", "reqcmd_0x08", "reqcmd_0x51", "reqcmd_0x52", "reqcmd_0x53", "reqcmd_0x54", "reqcmd_0x55", "reqcmd_0x56", "reqcmd_0x57", "reqcmd_0x58", "reqcmd_0x59", "reqcmd_0x60" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null }, SecMsg_Req.class);
  public final PBUInt32Field cmd = PBField.initUInt32(0);
  public SecMsgComu.SecMsg_Req_Comm comm = new SecMsgComu.SecMsg_Req_Comm();
  public final PBUInt64Field packet_seq = PBField.initUInt64(0L);
  public SecMsgComu.SecMsg_CreateSS_Req reqcmd_0x01 = new SecMsgComu.SecMsg_CreateSS_Req();
  public SecMsgComu.SecMsg_SendMsg_Req reqcmd_0x02 = new SecMsgComu.SecMsg_SendMsg_Req();
  public SecMsgComu.SecMsg_SendACK_Req reqcmd_0x03 = new SecMsgComu.SecMsg_SendACK_Req();
  public SecMsgComu.SecMsg_GetInbox_Req reqcmd_0x04 = new SecMsgComu.SecMsg_GetInbox_Req();
  public SecMsgComu.SecMsg_GetSSInfo_Req reqcmd_0x05 = new SecMsgComu.SecMsg_GetSSInfo_Req();
  public SecMsgComu.SecMsg_GetBaseInfo_Req reqcmd_0x06 = new SecMsgComu.SecMsg_GetBaseInfo_Req();
  public SecMsgComu.SecMsg_EnableSS_Req reqcmd_0x07 = new SecMsgComu.SecMsg_EnableSS_Req();
  public SecMsgComu.SecMsg_EnableSecMsg_Req reqcmd_0x08 = new SecMsgComu.SecMsg_EnableSecMsg_Req();
  public SecMsgComu.SecGroupMsg_OPSS_Req reqcmd_0x51 = new SecMsgComu.SecGroupMsg_OPSS_Req();
  public SecMsgComu.SecGroupMsg_SendMsg_Req reqcmd_0x52 = new SecMsgComu.SecGroupMsg_SendMsg_Req();
  public SecMsgComu.SecGroupMsg_GetMsg_Req reqcmd_0x53 = new SecMsgComu.SecGroupMsg_GetMsg_Req();
  public SecMsgComu.SecGroupMsg_Invite_Req reqcmd_0x54 = new SecMsgComu.SecGroupMsg_Invite_Req();
  public SecMsgComu.SecGroupMsg_Get_Invitation_Req reqcmd_0x55 = new SecMsgComu.SecGroupMsg_Get_Invitation_Req();
  public SecMsgComu.SecGroupMsg_Get_MySS_Req reqcmd_0x56 = new SecMsgComu.SecGroupMsg_Get_MySS_Req();
  public SecMsgComu.SecGroupMsg_Get_SS_Req reqcmd_0x57 = new SecMsgComu.SecGroupMsg_Get_SS_Req();
  public SecMsgComu.SecGroupMsg_Send_Invitation_Ack_Req reqcmd_0x58 = new SecMsgComu.SecGroupMsg_Send_Invitation_Ack_Req();
  public SecMsgComu.SecGroupMsg_Set_Invitation_Flag_Req reqcmd_0x59 = new SecMsgComu.SecGroupMsg_Set_Invitation_Flag_Req();
  public SecMsgComu.SecGroupMsg_EnableSecGroupMsg_Req reqcmd_0x60 = new SecMsgComu.SecGroupMsg_EnableSecGroupMsg_Req();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\pb\secmsg\SecMsgComu$SecMsg_Req.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */