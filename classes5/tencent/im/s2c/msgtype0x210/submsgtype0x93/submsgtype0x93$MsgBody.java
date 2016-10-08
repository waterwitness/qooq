package tencent.im.s2c.msgtype0x210.submsgtype0x93;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class submsgtype0x93$MsgBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_msg_type", "msg_umc_changed", "msg_state_changed" }, new Object[] { Integer.valueOf(0), null, null }, MsgBody.class);
  public submsgtype0x93.StateChangeNotify msg_state_changed = new submsgtype0x93.StateChangeNotify();
  public submsgtype0x93.UnreadMailCountChanged msg_umc_changed = new submsgtype0x93.UnreadMailCountChanged();
  public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\s2c\msgtype0x210\submsgtype0x93\submsgtype0x93$MsgBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */