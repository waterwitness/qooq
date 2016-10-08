package tencent.im.s2c.msgtype0x210.submsgtype0x26;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0x26$MsgBody$SubCmd0x3UpdateDiscussAppInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "msg_app_id", "uint64_conf_uin", "msg_app_tip_notify" }, new Object[] { null, Long.valueOf(0L), null }, SubCmd0x3UpdateDiscussAppInfo.class);
  public submsgtype0x26.AppID msg_app_id = new submsgtype0x26.AppID();
  public submsgtype0x26.AppTipNotify msg_app_tip_notify = new submsgtype0x26.AppTipNotify();
  public final PBUInt64Field uint64_conf_uin = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\s2c\msgtype0x210\submsgtype0x26\submsgtype0x26$MsgBody$SubCmd0x3UpdateDiscussAppInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */