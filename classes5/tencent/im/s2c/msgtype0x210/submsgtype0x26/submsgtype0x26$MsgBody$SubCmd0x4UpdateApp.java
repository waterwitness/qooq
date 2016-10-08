package tencent.im.s2c.msgtype0x210.submsgtype0x26;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0x26$MsgBody$SubCmd0x4UpdateApp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "msg_app_id", "uint64_group_code", "sint32_unread_num" }, new Object[] { null, Long.valueOf(0L), Integer.valueOf(0) }, SubCmd0x4UpdateApp.class);
  public submsgtype0x26.AppID msg_app_id = new submsgtype0x26.AppID();
  public final PBSInt32Field sint32_unread_num = PBField.initSInt32(0);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\s2c\msgtype0x210\submsgtype0x26\submsgtype0x26$MsgBody$SubCmd0x4UpdateApp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */