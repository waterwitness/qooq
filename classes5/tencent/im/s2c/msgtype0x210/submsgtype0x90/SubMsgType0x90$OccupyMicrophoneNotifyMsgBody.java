package tencent.im.s2c.msgtype0x210.submsgtype0x90;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x90$OccupyMicrophoneNotifyMsgBody
  extends MessageMicro
{
  public static final int UINT32_UIN_FIELD_NUMBER = 1;
  public static final int UINT64_DIN_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_uin", "uint64_din" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, OccupyMicrophoneNotifyMsgBody.class);
  public final PBUInt32Field uint32_uin = PBField.initUInt32(0);
  public final PBUInt64Field uint64_din = PBField.initUInt64(0L);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\s2c\msgtype0x210\submsgtype0x90\SubMsgType0x90$OccupyMicrophoneNotifyMsgBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */