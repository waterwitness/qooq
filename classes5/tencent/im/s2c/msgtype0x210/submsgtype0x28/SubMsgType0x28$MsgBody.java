package tencent.im.s2c.msgtype0x210.submsgtype0x28;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SubMsgType0x28$MsgBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_sub_cmd", "msg_rsp_followlist", "msg_rsp_typelist" }, new Object[] { Integer.valueOf(0), null, null }, MsgBody.class);
  public SubMsgType0x28.RspFollowList msg_rsp_followlist = new SubMsgType0x28.RspFollowList();
  public SubMsgType0x28.RspTypeList msg_rsp_typelist = new SubMsgType0x28.RspTypeList();
  public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\s2c\msgtype0x210\submsgtype0x28\SubMsgType0x28$MsgBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */