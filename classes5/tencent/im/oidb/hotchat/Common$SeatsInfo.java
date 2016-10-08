package tencent.im.oidb.hotchat;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Common$SeatsInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint32_seat_flag", "uin64_guest_uin", "uint32_seat_id", "uint32_seat_seq" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, SeatsInfo.class);
  public final PBUInt64Field uin64_guest_uin = PBField.initUInt64(0L);
  public final PBUInt32Field uint32_seat_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_seat_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_seat_seq = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tencent\im\oidb\hotchat\Common$SeatsInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */