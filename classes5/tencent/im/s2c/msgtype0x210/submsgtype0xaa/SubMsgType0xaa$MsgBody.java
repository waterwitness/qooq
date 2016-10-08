package tencent.im.s2c.msgtype0x210.submsgtype0xaa;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SubMsgType0xaa$MsgBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "cmd", "msg_gameTeamMsg" }, new Object[] { Integer.valueOf(0), null }, MsgBody.class);
  public final PBUInt32Field cmd = PBField.initUInt32(0);
  public SubMsgType0xaa.GameTeam_MsgBody msg_gameTeamMsg = new SubMsgType0xaa.GameTeam_MsgBody();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\s2c\msgtype0x210\submsgtype0xaa\SubMsgType0xaa$MsgBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */