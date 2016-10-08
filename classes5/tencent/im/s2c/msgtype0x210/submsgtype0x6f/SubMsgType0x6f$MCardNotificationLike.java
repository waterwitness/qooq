package tencent.im.s2c.msgtype0x210.submsgtype0x6f;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x6f$MCardNotificationLike
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint64_from_uin", "uint32_counter_total", "uint32_counter_new", "str_wording" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), "" }, MCardNotificationLike.class);
  public final PBStringField str_wording = PBField.initString("");
  public final PBUInt32Field uint32_counter_new = PBField.initUInt32(0);
  public final PBUInt32Field uint32_counter_total = PBField.initUInt32(0);
  public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\s2c\msgtype0x210\submsgtype0x6f\SubMsgType0x6f$MCardNotificationLike.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */