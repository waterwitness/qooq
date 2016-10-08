package tencent.im.s2c.msgtype0x210.submsgtype0xaa;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SubMsgType0xaa$GameTeam_MsgBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint32_GameTeamCmd", "msg_turnOverMessage", "msg_startGameMessage", "msg_updateTeamMessage" }, new Object[] { Integer.valueOf(0), null, null, null }, GameTeam_MsgBody.class);
  public SubMsgType0xaa.GameTeam_StartGameMessage msg_startGameMessage = new SubMsgType0xaa.GameTeam_StartGameMessage();
  public SubMsgType0xaa.GameTeam_TurnOverMessage msg_turnOverMessage = new SubMsgType0xaa.GameTeam_TurnOverMessage();
  public SubMsgType0xaa.GameTeam_UpdateTeamMessage msg_updateTeamMessage = new SubMsgType0xaa.GameTeam_UpdateTeamMessage();
  public final PBUInt32Field uint32_GameTeamCmd = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\s2c\msgtype0x210\submsgtype0xaa\SubMsgType0xaa$GameTeam_MsgBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */