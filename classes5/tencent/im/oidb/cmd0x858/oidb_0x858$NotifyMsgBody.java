package tencent.im.oidb.cmd0x858;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x858$NotifyMsgBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 58 }, new String[] { "opt_enum_type", "opt_uint64_msg_time", "opt_uint64_msg_expires", "opt_uint64_conf_uin", "opt_msg_redtips", "opt_msg_recall_reminder", "opt_msg_obj_update" }, new Object[] { Integer.valueOf(5), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), null, null, null }, NotifyMsgBody.class);
  public final PBEnumField opt_enum_type = PBField.initEnum(5);
  public oidb_0x858.NotifyObjmsgUpdate opt_msg_obj_update = new oidb_0x858.NotifyObjmsgUpdate();
  public oidb_0x858.MessageRecallReminder opt_msg_recall_reminder = new oidb_0x858.MessageRecallReminder();
  public oidb_0x858.RedGrayTipsInfo opt_msg_redtips = new oidb_0x858.RedGrayTipsInfo();
  public final PBUInt64Field opt_uint64_conf_uin = PBField.initUInt64(0L);
  public final PBUInt64Field opt_uint64_msg_expires = PBField.initUInt64(0L);
  public final PBUInt64Field opt_uint64_msg_time = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\cmd0x858\oidb_0x858$NotifyMsgBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */