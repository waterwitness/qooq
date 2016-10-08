package tencent.im.s2c.msgtype0x210.submsgtype0x6f;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SubMsgType0x6f$ForwardBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 16002, 16010, 16018, 16026 }, new String[] { "uint32_notify_type", "uint32_op_type", "msg_fanpanzi_notify", "msg_mcard_notification_like", "vip_info_notify", "msg_push_lost_dev_found" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null, null, null }, ForwardBody.class);
  public SubMsgType0x6f.FanpaiziNotify msg_fanpanzi_notify = new SubMsgType0x6f.FanpaiziNotify();
  public SubMsgType0x6f.MCardNotificationLike msg_mcard_notification_like = new SubMsgType0x6f.MCardNotificationLike();
  public SubMsgType0x6f.PushLostDevFound msg_push_lost_dev_found = new SubMsgType0x6f.PushLostDevFound();
  public final PBUInt32Field uint32_notify_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_op_type = PBField.initUInt32(0);
  public SubMsgType0x6f.VipInfoNotify vip_info_notify = new SubMsgType0x6f.VipInfoNotify();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\s2c\msgtype0x210\submsgtype0x6f\SubMsgType0x6f$ForwardBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */